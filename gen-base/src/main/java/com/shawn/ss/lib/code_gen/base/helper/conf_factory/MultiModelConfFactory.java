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

    private final String name;
    private final String comment;
    private final Collection<SelectMethod> mainModelSelectMethod;
    private final Map<String, MulDaoRelationDef> relationConfs;
    private final Map<String, _BaseDaoConf> confs;
    private final List<String> fields;

    private String mainTable, mainDb, mainField;

    private String baseAssemblerClass, baseDaoClass;

    private boolean buildAbstractDao;

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
            tableInfo.addCol(
                    new ColumnInfo()
                            .setInfo(tableInfo)
                            .setComment(baseDaoConf.getComment())
                            .setType(
                                    new CommonFieldTypeInfo()
                                            .setCollection(relation.isSingle())
                                            .settClassName(baseDaoConf.getPojoClzName())
                            )
                            .setAliasFieldName(field)
                            .setFieldName(field)
            );
        }
        return tableInfo;
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
        confs.put(mainField, (_BaseDaoConf) conf);
        relationConfs.put(mainField, new MulDaoRelationDef().setMain(true));
        fields.add(mainField);
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
        DbTableCol tableCol = results[1];
        String key = CodeConstants.buildConfNameFromDbAndTable(tableCol.db, tableCol.table);
        _BaseContextConf conf = ConfDataTable.get(key);
        if (!(conf instanceof _BaseDaoConf)) {
            throw new IllegalStateException(key + " may not exist or not been inited, can't add mainTable for " + name);
        }
        _BaseDaoConf relatedConf = (_BaseDaoConf) conf;

        confs.put(field, relatedConf);
        relationConfs.put(
                field,
                new MulDaoRelationDef()
                        .setMain(false)
                        .setAdditionalWhere(additionalWhere)
                        .setSingle(isSingle)
                        .setBatchSize(batchSize)
                        .setFieldName(field)
                        .setFieldInRelatedTable(results[0].col)
                        .setFieldInThisTable(tableCol.col)
                        .setRelatedField(
                                relatedConf.getField(tableCol.col)
                        )
        );
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
