package com.shawn.ss.lib.code_gen.base.helper.conf_factory;

import com.shawn.ss.gen.api.conf.SelectMethod;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ConfDataTable;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDaoDef;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.MulDaoRelationDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseContextConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnInfo;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonFieldTypeInfo;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.TableInfo;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiModelConfFactory {

    static final Pattern conditionPattern = Pattern.compile("([0-9A-Za-z_$\\.]+)=([0-9A-Za-z_$\\.]+)(;|$)");
    static final Pattern itemPattern = Pattern.compile("([0-9A-Za-z_$]+)");

    static final ConcurrentHashMap<String, MultiModelConfFactory> confMaps = new ConcurrentHashMap<>();
    static final ConcurrentHashMap<String, MultiModelConfFactory> tableConfs = new ConcurrentHashMap<>();

    private final String name;
    private final String comment;
    private final Collection<SelectMethod> mainModelSelectMethod;
    private final Map<String, MulDaoRelationDef> relationConfs;
    private final Map<String, _BaseDaoConf> confs;
    private final List<String> fields;

    private volatile String mainTable, mainDb, mainField;

    private volatile String baseAssemblerClass, baseDaoClass;

    private volatile boolean buildAbstractDao;

    private volatile _BaseDaoConf mainConf;

    private static class DbTableCol {
        String db, table, col;
        boolean isMain;

        public DbTableCol(String db, String table, String col, boolean isMain) {
            this.db = db;
            this.table = table;
            this.col = col;
            this.isMain = isMain;
        }
    }

    public static MultiModelConfFactory newInstance(String name, String comment) {
        if (confMaps.containsKey(name)) {
            throw new IllegalStateException(name + " mulDao already exists");
        }
        MultiModelConfFactory value = new MultiModelConfFactory(name, comment);
        confMaps.put(name, value);
        return value;
    }

    public static MultiModelConfFactory newInstance(String name, String comment, Collection<SelectMethod> mainModelSelectMethod) {
        if (confMaps.containsKey(name)) {
            throw new IllegalStateException(name + " mulDao already exists");
        }
        MultiModelConfFactory value = new MultiModelConfFactory(name, comment, mainModelSelectMethod);
        confMaps.put(name, value);
        return value;
    }

    public static Map<String, _BaseDaoConf> buildConfs(ModelBuilderContext context) {
        Map<String, _BaseDaoConf> ret = CollectionHelper.newMap();
        confMaps.forEach((k, v) -> ret.put(k, v.buildConf(context)));
        return ret;
    }

    public static MultiModelConfFactory getFactory(Object key) {
        return confMaps.get(key);
    }

    public static MultiModelConfFactory getFactoryByMainTable(Object key) {
        return tableConfs.get(key);
    }

    public static boolean containsFactory(Object value) {
        return confMaps.containsValue(value);
    }

    private MultiModelConfFactory(String name, String comment, Collection<SelectMethod> mainModelSelectMethod) {
        this.name = name;
        this.comment = comment;
        this.mainModelSelectMethod = mainModelSelectMethod;
        this.relationConfs = new ConcurrentHashMap<>(16);
        confs = new ConcurrentHashMap<>(16);
        fields = CollectionHelper.newList(16);
    }

    private MultiModelConfFactory(String name, String comment) {
        this(name, comment, SelectMethodEnum.getAllSelectMethod().values());
    }

    public MultiModelConfFactory addConf(MulDaoRelationDef relationDef, _BaseDaoConf conf) {
        if (relationDef == null || conf == null) {
            return this;
        }
        if (!relationDef.isMain() && fields.isEmpty()) {
            throw new IllegalStateException("add main configuration first for muldao" + name);
        } else if (relationDef.isMain() && !fields.isEmpty()) {
            throw new IllegalStateException("add main configuration first for muldao" + name);
        }
        String fieldName = relationDef.getFieldName();
        if (fieldName == null) {
            throw new IllegalStateException("relation information should contain field");
        }
        if (relationDef.isMain()) {
            this.mainField = fieldName;
            this.mainDb = conf.getDb();
            this.mainTable = conf.getTable();
        } else {

        }
        this.fields.add(fieldName);
        this.relationConfs.put(fieldName, relationDef);
        this.confs.put(fieldName, conf);
        return this;
    }

    public _BaseDaoConf buildConf(ModelBuilderContext context) {
        return buildConf(context, false);
    }

    public _BaseDaoConf buildConf(ModelBuilderContext context, boolean flush) {
        if (!flush && mainConf != null) return mainConf;
        if (fields.size() <= 1) {
            throw new IllegalStateException("need at least two fields to construct a multidao , wrong state for configuration:" + name);
        }
        TableInfo tableInfo = buildTableInfo(context);
        CommonModelDaoDef ret = new CommonModelDaoDef(name, tableInfo, context);

        ret.setAssemblerExtendClzName(baseAssemblerClass);
        ret.setDaoExtendClzName(baseDaoClass);

        ret.setPojoClzName(CodeConstants.getModelClassName(context.getBasePackage(), name, false));
        ret.setAssemblerClzName(CodeConstants.getMulDaoAssemblerClassName(context.getBasePackage(), name));
        ret.setDaoClzName(CodeConstants.getMulSelectDaoClassName(context.getBasePackage(), name));
        ret.setMapperClzName(CodeConstants.getMapMapperClassName(context.getBasePackage(), name));

        ret.setDataSrcType(_BaseDaoConf.EnumFieldDataSrcType.mulDao);
        ret.setBuildAbstractDao(buildAbstractDao);
        ret.setMainModelSelectMethod(mainModelSelectMethod);


        ret.setModelType(CodeConstants.TYPE_MODEL_COMBINE_TYPE);

        for (String field : fields) {
            _BaseDaoConf baseDaoConf = confs.get(field);
            CommonModelDaoDef relatedConf = null;
            if (baseDaoConf instanceof CommonModelDaoDef) {
                relatedConf = (CommonModelDaoDef) baseDaoConf;
            } else {

            }
            MulDaoRelationDef relation = relationConfs.get(field);
            if (relation == null || baseDaoConf == null) {
                throw new IllegalStateException("config or relation is null , data may not ready for field " + field);
            }
            relatedConf.putDef(name, relation);
            ret.addRelation(baseDaoConf);
        }
        //        ret.setComment(comment);
        this.mainConf = ret;
        return ret;
    }

    private TableInfo buildTableInfo(ModelBuilderContext context) {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setDbName(mainDb);
        tableInfo.setTableName(mainTable);
        tableInfo.setTableType(CodeConstants.TYPE_TABLE_MUL_TYPE);
        tableInfo.setTableComment(comment);
        for (String field : fields) {
            _BaseDaoConf baseDaoConf = confs.get(field);
            MulDaoRelationDef relation = relationConfs.get(field);
            if (relation == null || baseDaoConf == null) {
                throw new IllegalStateException("config or relation is null , data may not ready for field " + field);
            }
            boolean isCollection = !relation.isMain() && !relation.isSingle();
            tableInfo.addCol(
                    new ColumnInfo()
                            .setInfo(tableInfo)
                            .setComment(baseDaoConf.getComment())
                            .setType(
                                    new CommonFieldTypeInfo()
                                            .setCollection(isCollection)
                                            .settClassName(baseDaoConf.getPojoClzName())
                            )
                            .setAliasFieldName(field)
                            .setFieldName(field)
            );
        }
        return tableInfo;
    }

    private void addMainRelation(String mainField) {
        relationConfs.put(
                mainField,
                new MulDaoRelationDef()
                        .setMain(true)
                        .setFieldName(mainField)
        );
        tableConfs.put(CodeConstants.buildConfNameFromDbAndTable(mainDb, mainTable), this);
    }

    private void addSubRelation(String field, boolean isSingle, int batchSize, Map<String, String> additionalCondition, String additionalWhere, DbTableCol[] results, _BaseDaoConf conf) {
        relationConfs.put(
                field,
                new MulDaoRelationDef()
                        .setMain(false)
                        .setAdditionalWhere(additionalWhere)
                        .setSingle(isSingle)
                        .setBatchSize(batchSize)
                        .setFieldName(field)
                        .setFieldInRelatedTable(results[0].col)
                        .setFieldInThisTable(results[1].col)
                        .setRelatedField(
                                conf.getField(results[1].col)
                        )
                        .putAllAdditionalCondition(additionalCondition)
        );
    }

    public MultiModelConfFactory addMainTable(String mainField, String mainDb, String mainTable) {
        if (!fields.isEmpty()) {
            throw new IllegalStateException("add main configuration first for muldao" + name);
        }

        this.mainTable = mainTable;
        this.mainField = mainField;
        this.mainDb = mainDb;

        String key = CodeConstants.buildConfNameFromDbAndTable(mainDb, mainTable);
        _BaseContextConf conf = ConfDataTable.get(key);
        if (!(conf instanceof _BaseDaoConf)) {
            throw new IllegalStateException(key + " may not exist or not been inited, can't add mainTable for " + name);
        }
        _BaseDaoConf conf1 = (_BaseDaoConf) conf;
        confs.put(mainField, conf1);
        addMainRelation(mainField);
        fields.add(mainField);
        return this;
    }

    public MultiModelConfFactory addMainMultiDao(String name, String mainField) {
        if (!fields.isEmpty()) {
            throw new IllegalStateException("add main configuration first for muldao" + name);
        }
        MultiModelConfFactory multiModelConfFactory = confMaps.get(name);
        if (multiModelConfFactory == null) {
            throw new IllegalStateException("configuration not exist, wrong configuration name :" + name);
        }
        _BaseDaoConf baseDaoConf = multiModelConfFactory.mainConf;
        if (baseDaoConf == null) {
            throw new IllegalStateException("before use muldao, call buildConf() it first");
        }
        confs.put(mainField, baseDaoConf);
        this.mainDb = multiModelConfFactory.mainDb;
        this.mainTable = multiModelConfFactory.mainTable;
        this.mainField = mainField;
        addMainRelation(mainField);
        fields.add(mainField);
        return this;
    }

    public MultiModelConfFactory addRelatedMultiDao(String field, String condition, String muldaoName, boolean isSingle, int batchSize) {
        return addRelatedMultiDao(field, condition, muldaoName, isSingle, batchSize, null, null);
    }

    public MultiModelConfFactory addRelatedMultiDao(
            String field,
            String condition,
            String muldaoName,
            boolean isSingle,
            int batchSize,
            Map<String, String> additionalCondition,
            String additionalWhere
    ) {
        if (fields.isEmpty()) {
            throw new IllegalStateException("add main configuration first for muldao" + name);
        }
        DbTableCol[] results = calRelation(condition, mainDb, mainTable);
        String key = CodeConstants.buildConfNameFromDbAndTable(results[1].db, results[1].table);
        MultiModelConfFactory relatedConfFactory = confMaps.get(muldaoName);
        if (relatedConfFactory == null) {
            throw new IllegalStateException("no multidao contains " + muldaoName + ", build the a multidao with " + results[1].db + "." + results[1].table + " as main table first");
        }
        _BaseDaoConf conf = relatedConfFactory.mainConf;

        if (conf == null) {
            throw new IllegalStateException("before use muldao, call buildConf() it first");
        }
        if (!results[1].table.equals(conf.getTable()) || !results[1].db.equals(conf.getDb())) {
            throw new IllegalStateException("condition not match multidao main table: expectedd " + conf.getDb() + "." + conf.getTable() + " got " + key);
        }
        confs.put(field, conf);
        addSubRelation(field, isSingle, batchSize, additionalCondition, additionalWhere, results, conf);
        fields.add(field);
        
        return this;
    }


    public MultiModelConfFactory addRelatedTable(String field, String condition, boolean isSingle, int batchSize) {
        return addRelatedTable(field, condition, isSingle, batchSize, null, null);
    }

    public MultiModelConfFactory addRelatedTable(
            String field,
            String condition,
            boolean isSingle,
            int batchSize,
            Map<String, String> additionalCondition,
            String additionalWhere
    ) {
        if (fields.isEmpty()) {
            throw new IllegalStateException("add main configuration first for muldao" + name);
        }
        DbTableCol[] results = calRelation(condition, mainDb, mainTable);
        String key = CodeConstants.buildConfNameFromDbAndTable(results[1].db, results[1].table);
        _BaseContextConf conf = ConfDataTable.get(key);
        if (!(conf instanceof _BaseDaoConf)) {
            throw new IllegalStateException(key + " may not exist or not been inited, can't add mainTable for " + name);
        }
        _BaseDaoConf relatedConf = (_BaseDaoConf) conf;

        confs.put(field, relatedConf);
        addSubRelation(field, isSingle, batchSize, additionalCondition, additionalWhere, results, relatedConf);
        fields.add(field);

        return this;
    }

    private DbTableCol[] calRelation(String relationship, String mainDb, String mainTable) {
        Matcher matcher = conditionPattern.matcher(relationship);
        if (matcher.matches()) {
            //            String[] re = new String[2];
            DbTableCol[] item = new DbTableCol[2];
            String p1 = matcher.group(1);
            String p2 = matcher.group(2);
            String[] item1 = p1.split("\\.");
            String[] item2 = p2.split("\\.");
            DbTableCol it = getItem(item1, mainDb, mainTable);
            item[it.isMain ? 0 : 1] = it;
            it = getItem(item2, mainDb, mainTable);
            item[it.isMain ? 0 : 1] = it;
            if (item[0] != null && item[1] != null) {
                return item;
            } else {
                throw new IllegalArgumentException("condition illegal, not match maintable and table ");
            }
        }
        throw new IllegalArgumentException("condition illegal, need to be as 'db1.table1.field1=db2.table2.field2' or 'table1.field1=table2.fields' ");
    }

    private DbTableCol getItem(String[] parts, String mainDb, String mainTable) {
        boolean main = false;
        String db = null, table = null, col = null;
        if (parts.length == 2) {
            if (parts[0].equalsIgnoreCase(mainTable)) {
                main = true;
            }
            table = parts[0];
            col = parts[1];
        } else if (parts.length == 3) {
            if (parts[0].equalsIgnoreCase(mainDb) && parts[1].equalsIgnoreCase(mainTable)) {
                main = true;
            }
            db = parts[0];
            table = parts[1];
            col = parts[2];
        }
        return new DbTableCol(db, table, col, main);
    }

    public String getBaseAssemblerClass() {
        return baseAssemblerClass;
    }

    public void setBaseAssemblerClass(String baseAssemblerClass) {
        this.baseAssemblerClass = baseAssemblerClass;
    }

    public String getBaseDaoClass() {
        return baseDaoClass;
    }

    public void setBaseDaoClass(String baseDaoClass) {
        this.baseDaoClass = baseDaoClass;
    }

    public List<String> getFields() {
        return fields;
    }

    public String getMainTable() {
        return mainTable;
    }

    public String getMainDb() {
        return mainDb;
    }

    public String getMainField() {
        return mainField;
    }

    public boolean isBuildAbstractDao() {
        return buildAbstractDao;
    }

    public void setBuildAbstractDao(boolean buildAbstractDao) {
        this.buildAbstractDao = buildAbstractDao;
    }
}
