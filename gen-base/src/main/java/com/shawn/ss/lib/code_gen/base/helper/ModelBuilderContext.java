package com.shawn.ss.lib.code_gen.base.helper;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_dao_builder.CommonDaoBuilder;
import com.shawn.ss.lib.code_gen.base.dao.special_dao.special_dao_builder.SpecialDaoBuilder;
import com.shawn.ss.lib.code_gen.base.helper.db_analyzer.DbAnalyzer;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.model.MethodTypeEnum;
import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.MapperOfMapBuilder;
import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.MapperOfResultSetBuilder;
import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.ModelBuilder;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDef;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.SpecialModelConf;
import com.shawn.ss.lib.code_gen.base.multi_dao.multi_dao_builder.MultiDaoSelectServiceBuilder;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.DbInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ModelBuilderContext {
    final Logger L = LoggerFactory.getLogger(ModelBuilderContext.class.getSimpleName());


    //    volatile DBConnectionHelper dataSource;
//    volatile DbAnalyzer analyzer;
    volatile String basePackage;
    JCodeModel cm;
    private String filePath;
    private Map<Long,DbInfoHandler> relatedDbs;
//    private Map<String,List<Long>> dbNameToIndex;

//    private String dbName;
//    private Map<String, TableInfoInterface> tbMap;
//    private DbInfoInterface dbInfo;

//    public static final class ParamDef {
//        Class clz;
//        Class narrow[];
//        String name;
//
//        public ParamDef(Class clz, String name) {
//            this.clz = clz;
//            this.name = name;
//        }
//
//        public ParamDef(Class clz, String name, Class[] narrow) {
//            this.clz = clz;
//            this.narrow = narrow;
//            this.name = name;
//        }
//
//        public Class[] getNarrow() {
//            return narrow;
//        }
//
//        public void setNarrow(Class[] narrow) {
//            this.narrow = narrow;
//        }
//
//        public Class getClz() {
//            return clz;
//        }
//
//        public void setClz(Class clz) {
//            this.clz = clz;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }

//    static final Map<String, List<ParamDef>> DAO_METHOD_PARAM;
//
//    static {
//        DAO_METHOD_PARAM = CollectionHelper.newMap();
//        DAO_METHOD_PARAM.put(CodeConstants.METHOD_DAO_GET_ALL,
//                CollectionHelper.<ParamDef>listBuilder()
//                        .add(new ParamDef(Set.class, "selectField", new Class[]{String.class}))
//                        .add(new ParamDef(DaoAssembler.class, "assembler"))
//                        .add(new ParamDef(Integer.class, "start"))
//                        .add(new ParamDef(Integer.class, "count"))
//
//                        .getList()
//        );
//        DAO_METHOD_PARAM.put(CodeConstants.METHOD_DAO_GET_BY_IDS,
//                CollectionHelper.<ParamDef>listBuilder()
//                        .add(new ParamDef(Set.class, "selectField", new Class[]{String.class}))
//                        .add(new ParamDef(DaoAssembler.class, "assembler"))
//                        .add(new ParamDef(Integer.class, "start"))
//                        .add(new ParamDef(Integer.class, "count"))
//
//                        .add(new ParamDef(List.class, "id", new Class[]{Integer.class}))
//                        .add()
//                        .getList()
//        );
//        DAO_METHOD_PARAM.put(CodeConstants.METHOD_DAO_GET_BY_CONDITION,
//                CollectionHelper.<ParamDef>listBuilder()
//                        .add(new ParamDef(Set.class, "selectField", new Class[]{String.class}))
//                        .add(new ParamDef(DaoAssembler.class, "assembler"))
//                        .add(new ParamDef(Integer.class, "start"))
//                        .add(new ParamDef(Integer.class, "count"))
//                        .add(new ParamDef(null, "instance"))
//                        .getList()
//        );
//        DAO_METHOD_PARAM.put(CodeConstants.METHOD_DAO_GET_BY_INDEXES,
//                CollectionHelper.<ParamDef>listBuilder()
//                        .add(new ParamDef(Set.class, "selectField", new Class[]{String.class}))
//                        .add(new ParamDef(DaoAssembler.class, "assembler"))
//                        .add(new ParamDef(Integer.class, "start"))
//                        .add(new ParamDef(Integer.class, "count"))
//                        .add(new ParamDef(String.class, "inField"))
//                        .add(new ParamDef(List.class, "indexes"))
//                        .add()
//                        .getList()
//        );
//    }

//    public static boolean containsMethodKey(Object key) {
//        return DAO_METHOD_PARAM.containsKey(key);
//    }
//
//    public static List<ParamDef> getMethodDef(Object key) {
//        return DAO_METHOD_PARAM.get(key);
//    }


    private ModelBuilderContext() {
        relatedDbs=CollectionHelper.newMap(32);
//        dbNameToIndex=CollectionHelper.newMap(32);
    }

    public static ModelBuilderContext builderHelper(JCodeModel cm, String basePackage, String filePath) {
        ModelBuilderContext mbh = new ModelBuilderContext();
        mbh.init(cm, basePackage, filePath);
        return mbh;
    }

//    public static ModelBuilderContext builderPartialHelper(DBConnectionHelper data_store, JCodeModel cm, String basePackage, String filePath, String dbName, Set<String> includingTable) {
//        ModelBuilderContext mbh = new ModelBuilderContext();
//        mbh.init(data_store, cm, basePackage, filePath, dbName, includingTable,null);
//        return mbh;
//    }

//    public static ModelBuilderContext builderHelper(DBConnectionHelper data_store, JCodeModel cm, String basePackage, String filePath, String dbName, Set<String> ignoreTbPattern) {
//        ModelBuilderContext mbh = new ModelBuilderContext();
//        mbh.init(data_store, cm, basePackage, filePath, dbName, ignoreTbPattern);
//        return mbh;
//    }

//    public static ModelBuilderContext builderHelper(String pos, String basePackage, String filePath, String dbName,String dataSourceId) {
//        Properties p = new Properties();
//        try {
//            InputStream in = new FileInputStream(new File(pos));
//            p.load(in);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        final ModelBuilderContext context = builderHelper(basePackage, filePath);
//        context.addConnctionAndDb(dbName, dataSourceId, p);
//        return context;
//    }
//
//    public static ModelBuilderContext builderHelper(String pos, String basePackage, String filePath, String dbName) {
//        return builderHelper(pos,basePackage,filePath,dbName,CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID);
//    }

//    public static ModelBuilderContext builderHelper( String basePackage, String filePath) {
//
//        return builderHelper(basePackage,filePath);
//    }

    public static ModelBuilderContext builderHelper(String basePackage, String filePath) {
        ModelBuilderContext mbh = new ModelBuilderContext();
        mbh.init(basePackage, filePath);
        return mbh;
    }

//    protected void init(DBConnectionHelper data_store, JCodeModel cm, String basePackage, String filePath, String dbName, Set<String> tables) {
//        init(data_store,cm,basePackage,filePath,dbName,tables,false);
//    }

//    public DBConnectionHelper buildConnection(String dataSourceId, Properties dbConfig){
//        return new DBConnectionHelper(dataSourceId,dbConfig);
//    }

    public DBConnectionHelper buildConnection(String dataSourceId, String dbUrl,String dbUserName,String dbPassword,String dbDriver){
        return new DBConnectionHelper(dataSourceId,dbUrl,dbUserName,dbPassword,dbDriver);
    }

//    public long addConnctionAndDb(String db, String dataSourceId, Properties p,boolean isSlave, Set<String> including, Set<String> excluding) {
//        DBConnectionHelper connection = buildConnection(dataSourceId, p);
//        final DbInfoHandler infoHolder = new DbInfoHandler(connection,isSlave);
//        final long uuid = addDbInternal(db, infoHolder, including, excluding);
//        return uuid;
//    }

//    public long addConnctionAndDb(String db, String dataSourceId, Properties p,boolean isSlave) {
//
//        return addConnctionAndDb(db,dataSourceId,p,isSlave,null,null);
//    }
//
//    public long addConnctionAndDb(String db, String dataSourceId, Properties p) {
//        return addConnctionAndDb(db,dataSourceId,p,false,null,null);
//    }

//    public long addDb(String db, DBConnectionHelper conn) {
//
//        return addDb(db,conn,false,null,null);
//    }

//    public long addDb(String db, DBConnectionHelper conn,boolean isSlave) {
//
//        return addDb(db,conn,isSlave,null,null);
//    }

    public long addDb(DBConnectionHelper conn, DbModelConf conf) {
        final DbInfoHandler infoHolder = new DbInfoHandler(conn,conf);
                final long uuid = DbDataTable.putDbInfo(infoHolder);
        relatedDbs.put(uuid,infoHolder);
//        List<Long> list = dbNameToIndex.get(data_store);
//        if(list==null){
//            list=CollectionHelper.newList();
//        }
//        list.add(uuid);
//        dbNameToIndex.put(data_store,list);
//        final long uuid = addDbInternal(db, infoHolder, including, excluding);
        return uuid;
    }

//    private long addDbInternal(String db, DbInfoHandler infoHolder, Set<String> including, Set<String> excluding) {
//        infoHolder.setDb(db, including, excluding);
//        final long uuid = DbDataTable.putDbInfo(infoHolder);
//        relatedDbs.put(uuid,infoHolder);
////        List<Long> list = dbNameToIndex.get(data_store);
////        if(list==null){
////            list=CollectionHelper.newList();
////        }
////        list.add(uuid);
////        dbNameToIndex.put(data_store,list);
//        return uuid;
//    }

    protected void init(JCodeModel cm, String basePackage, String filePath) {
        this.filePath = filePath;
        this.basePackage = basePackage;
        this.cm = cm;
        assert (cm != null);
//        this.dbName = dbName;
//        dataSource = data_store;
//        assert (dataSource != null);

//        this.dbInfo = analyzeDb(excluding,including);

//        this.tbMap = buildTableMap(dbInfo);
    }

    protected void init(String basePackage, String filePath) {
        this.filePath = filePath;
        this.basePackage = basePackage;
        cm = new JCodeModel();
//        this.dbName = dbName;
//        if (dataSource == null) {
//            synchronized (ModelBuilder.class) {
//                Properties p = new Properties();
//                L.info("dbInfo properties:{}", p);
//
//                try {
//                    InputStream in = new FileInputStream(new File(pos));
//                    p.load(in);
//                    dataSource = new DBConnectionHelper(p);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        assert (dataSource != null);
//        if (analyzer == null) {
//            synchronized (ModelBuilder.class) {
//                analyzer = new DbAnalyzer();
//            }
//        }
//        assert (analyzer != null);

//        this.dbInfo = analyzeDb(ignoreTbPattern,including);
//        this.tbMap = buildTableMap(dbInfo);
    }


//    private DbInfoInterface analyzePatialDb(Set<String> tables) {
//        DbInfo data_store = new DbInfo(dbName);
//        analyzer.buildModel(dataSource.getConnection(), data_store, null, tables);
//        return data_store;
//    }


    public String getDaoClassName(String table, String baseTable, int type) {
        String tb = (baseTable == null ? table : baseTable);
        String modelSimpleName = CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(tb));
        if (type == 2 && baseTable == null) {
            return basePackage + ".dao.spdao." + CodeHelper.CLASS_NAME_DAO_PREFIX + modelSimpleName;
        } else {
            return basePackage + ".dao.basedao." + CodeHelper.CLASS_NAME_DAO_PREFIX + modelSimpleName;
        }
    }

    public String getDaoClassName(String table) {
//        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
        return getDaoClassName(table, null, 0);
//                basePackage + ".dao." + CodeConstants.CLASS_NAME_DAO_PREFIX + CodeStyleTransformHelper.upperFirstCase(modelSimpleName);
    }

    public String getServiceClassName(String table) {
        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
        return basePackage + ".dao.multi_dao." + CodeHelper.CLASS_NAME_MULTI_DAO_PREFIX + CodeStyleTransformHelper.upperFirstCase(modelSimpleName);
    }

    public String getServiceAssemblerClassName(String serviceClassName) {
        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(serviceClassName);
        return basePackage + ".dao.multi_dao." + CodeHelper.CLASS_NAME_MULTI_DAO_PREFIX + CodeStyleTransformHelper.upperFirstCase(modelSimpleName)+ CodeHelper.CLASS_NAME_MULTI_DAO_ASSEMBLER_APPENDIX;
    }

    public String getModelClassPrefix(boolean base) {
        return basePackage + ".dto." + (base ? "basepo." : "composedpo.") + CodeHelper.CLASS_NAME_MODEL_PREFIX;
    }

    public String getEnumClzName(String clazzName) {
        return basePackage + ".dto.enums." + CodeHelper.CLASS_NAME_ENUM_PREFIX + CodeStyleTransformHelper.upperFirstCase(clazzName);
    }

    private String getClassNameOfSpecialQueryDto(String clzName) {
        return basePackage + ".dto.input." + CodeHelper.CLASS_NAME_MODEL_PREFIX + CodeStyleTransformHelper.upperFirstCase(clzName);
    }

    private String getModelClassName(String table) {
        return getModelClassName(table, true);
    }

    private String getModelClassName(String table, boolean isBase) {
        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
        return getModelClassPrefix(isBase) + CodeStyleTransformHelper.upperFirstCase(modelSimpleName);
    }

    public String getRSMapperClassName(String table) {
        String modelClass = getModelClassName(table);
        return modelClass + "." + CodeHelper.CLASS_NAME_RESULT_SET_MAPPER_PREFIX + CodeHelper.getClassNameFromFullName(modelClass);
    }

    public String getMapMapperClassName(String table) {
        String modelClass = getModelClassName(table);
        return modelClass + "." + CodeHelper.CLASS_NAME_REDIS_BYTE_MAPPER_PREFIX + CodeHelper.getClassNameFromFullName(modelClass);
    }

    public void buildBaseModelAndDao() {
//        CollectionHelper.travelMap(, new CollectionHelper.Traveler<String, DbInfoHandler>() {
//            @Override
//            public boolean travel(String s, DbInfoHandler dbInfoHolder, int i) {
        final Collection<DbInfoHandler> dbInfoHandlers = relatedDbs.values();
        for (DbInfoHandler dbInfoHandler : dbInfoHandlers) {
            buildBaseModelAndDao(dbInfoHandler);
        }
//                return true;
//            }
//        });
    }

    public void buildBaseModelAndDao(long uuid) {
        if(!relatedDbs.containsKey(uuid)){
            throw new IllegalStateException("错误的uuid，此context不包含此uuid："+uuid+" context:"+relatedDbs.toString());
        }
        final DbInfoHandler dbInfoHandler = DbDataTable.getHolder(uuid);
        buildBaseModelAndDao(dbInfoHandler);
    }



    public void buildBaseModelAndDao(DbInfoHandler db) {
//        String dbName = data_store.getDb();
//        List<String> dataSources=getDataSource(dbName);
//        Collection<TableInfoInterface> tables = data_store.getTbMaps().values();
        List<CommonModelDef> defs = db.getDefs();
        for (CommonModelDef def : defs) {
//            String table = tableInfo.getTable();
//            String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
//            final CommonModelDef commonModelDef = new CommonModelDef()
//                    .setDef(tableInfo)
//                    .setBaseTable(null)
//                    .setBuildMapper(true)
//                    .setIgnoreField(null)
//                    .setDataSourceName(data_store.getDataSourceId());
//            if(dataSources!=null){
//                commonModelDef.setDataSourceNames(dataSources);
//            }
            ModelBuilder builder = buildBaseModel(def);
            try {
                CommonDaoBuilder daoBuilder = new CommonDaoBuilder(def, this);
                daoBuilder.buildModel();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

//    public void buildBaseModelAndDao(DbInfoHandler data_store) {
//        String dbName = data_store.getDb();
//        List<String> dataSources=getDataSource(dbName);
//        Collection<TableInfoInterface> tables = data_store.getTbMaps().values();
//        for (TableInfoInterface tableInfo : tables) {
////            String table = tableInfo.getTable();
////            String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
//            final CommonModelDef commonModelDef = new CommonModelDef()
//                    .setDef(tableInfo)
//                    .setBaseTable(null)
//                    .setBuildMapper(true)
//                    .setIgnoreField(null)
//                    .setDataSourceName(data_store.getDataSourceId());
//            if(dataSources!=null){
//                commonModelDef.setDataSourceNames(dataSources);
//            }
//            ModelBuilder builder = buildBaseModel(commonModelDef);
//            try {
//                CommonDaoBuilder daoBuilder = new CommonDaoBuilder(commonModelDef, this);
//                daoBuilder.buildModel();
//            }catch (Exception ex){
//                ex.printStackTrace();
//            }
//        }
//    }

//    private List<String> getDataSource(String dbName) {
//        List<Long> list = dbNameToIndex.get(dbName);
//        if(list!=null && list.size()>1){
//            List<String> ret=CollectionHelper.newList(list.size());
//            for(long i:list){
//                DbInfoHandler dbInfoHandler = relatedDbs.get(i);
//                if(dbInfoHandler !=null && dbInfoHandler.isSlave()){
//                    ret.add(dbInfoHandler.getDataSourceId());
//                }
//            }
//            return ret;
//        }
//        return null;
//    }

    private ModelBuilder buildBaseModel(CommonModelDef def)
//            (TableInfoInterface tableInfo, String baseTable, boolean buildMapper, Set<String> ignoreField)
    {
        try {
            if (def.getBuilderContext() == null) {
                def.setBuilderContext(this);
            }
            ModelBuilder builder = new ModelBuilder(def);
            builder.buildModel();
            if (def.isBuildMapper()) {
                MapperOfResultSetBuilder rsMapperBuilder = new MapperOfResultSetBuilder(builder);
                rsMapperBuilder.buildModel();
                MapperOfMapBuilder redisMapperBuilder = new MapperOfMapBuilder(builder);
                redisMapperBuilder.buildModel();
            }
            return builder;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public void buildSpecialModalAndDao(SpecialModelConf def) {
//        NamedParameterJdbcTemplate jdbcTemplate = dataSource.getJdbcTemplate();
        try {
            SpecialModelConf.DataAttrType type = def.getDataType();
            if (type.equals(SpecialModelConf.DataAttrType.LIST_OBJ) || type.equals(SpecialModelConf.DataAttrType.OBJ)) {
                ModelBuilder modelBuilder = buildBaseModel(def);
//        if(type.equals(SpecialModelDef.DataAttrType.SQL)) {
//            modelBuilder.buildSQLField(modelDef.getSql());

            } else if (type.equals(SpecialModelConf.DataAttrType.LIST) || type.equals(SpecialModelConf.DataAttrType.SINGLE)) {

//            SpecialDaoBuilder daoBuilder = new SpecialDaoBuilder(def, this);
//            daoBuilder.buildModel();
            }
            SpecialDaoBuilder daoBuilder = new SpecialDaoBuilder(def, this);
            daoBuilder.buildModel();
        }catch (Exception ex){
            ex.printStackTrace();

        }
//        }

    }



    public void buildMultiSelectDao(ModelMulDaoConf conf) {
//        serviceName = getServiceClassName(serviceName);
        if(conf==null){
            return ;
        }
        try {
            if (conf.getBuilderContext() == null) {
                conf.setBuilderContext(this);
            }
//            conf.setBuilderContext(this);
            MultiDaoSelectServiceBuilder builder = new MultiDaoSelectServiceBuilder(conf);
//            builder.
            builder.buildModel();
        }catch (Exception ex){
            ex.printStackTrace();
        }
//        if (CommonDaoBuilder.hasMethod(selectMethod) ) {
//            MultiDaoSelectServiceBuilder serviceBuilder = new MultiDaoSelectServiceBuilder(
////                    cm,
//                    basePackage + ".service."+CodeConstants.CLASS_NAME_MULTI_DAO_PREFIX + serviceName,
//                    selectMethod,
//                    mainTable,
//                    relatedTable,
//                    buildController,
//                    this
//            );
//            serviceBuilder.buildModel();
//        }
    }

    public void writeModel() {
        try {
            File file = new File(filePath);
            if (file.exists() || file.mkdirs()) {
                L.info("code will in folder:{}", file.getAbsolutePath());
                cm.build(file);
            } else {
                L.info("can't buildBaseModelAndDao folder:{}", file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerMethod(JMethod method) {
        String name = method.name();
        JDefinedClass jDefinedClass = method.owningClass();
        String clzName = jDefinedClass.name();
        MethodTypeEnum mType = null;
        if (clzName.startsWith(CodeHelper.CLASS_NAME_DAO_PREFIX)) {
            mType = MethodTypeEnum.DAO_METHOD;
        } else if (clzName.startsWith(CodeHelper.CLASS_NAME_MODEL_PREFIX)) {
            mType = MethodTypeEnum.MODEL_METHOD;
        } else if (clzName.startsWith(CodeHelper.CLASS_NAME_RESULT_SET_MAPPER_PREFIX)) {
            mType = MethodTypeEnum.MODEL_MAPPER_METHOD;
        } else if (clzName.startsWith(CodeHelper.CLASS_NAME_MULTI_DAO_PREFIX)) {
            mType = MethodTypeEnum.MUL_DAO_METHOD;
        } else {
            mType = MethodTypeEnum.SQL_DEFINED_METHOD;
        }
        boolean constructor = method.isConstructor();

        if (!constructor) {
//            AbstractJType varParamType = method.listVarParamType();
            ClassDataTable.putMethod(mType, clzName, name, method);
        }
    }


//    public DbInfoInterface getDbInfo() {
//        return dbInfo;
//    }
//
//    public ModelBuilderContext setDbInfo(DbInfoInterface dbInfo) {
//        this.dbInfo = dbInfo;
//        return this;
//    }

    public FieldDataTypeInterface getFieldType(String db, String table, String colName) {
        final DbInfoInterface holder = DbDataTable.getDb(db);
        TableInfoInterface tableInfoInterface = holder.getTable(table);
        if (tableInfoInterface == null) {
            return null;
        } else {
            return tableInfoInterface.getColumnDataType(colName);
        }
    }

    public FieldDataTypeInterface getIdFieldType(String db, String table) {
        final DbInfoInterface holder = DbDataTable.getDb(db);
        TableInfoInterface tableInfoInterface = holder.getTable(table);
        if (tableInfoInterface == null) {
            return null;
        } else {
            return tableInfoInterface.getPriKeyType();
        }
    }

    public String getIdFieldName(String db, String table) {
        final DbInfoInterface holder = DbDataTable.getDb(db);
        TableInfoInterface tableInfoInterface = holder.getTable(table);
        if (tableInfoInterface == null) {
            return null;
        } else {
            return tableInfoInterface.getPriKey();
        }
    }



//    public Map<String, TableInfoInterface> getTbMap() {
//        return tbMap;
//    }

//    public ModelBuilderContext setTbMap(Map<String, TableInfoInterface> tbMap) {
//        this.tbMap = tbMap;
//        return this;
//    }

    public JCodeModel getCm() {
        return cm;
    }

//    public String getDbName() {
//        return dbName;
//    }

    public String getReallyModelClassName(String table, String baseTable) {
        return getReallyModelClassName(table, baseTable, true);
    }

    public String getReallyModelClassName(String table, String baseTable, boolean isBase) {
        return getModelClassName(table, isBase) + (baseTable == null ? "" : "Ext");
    }


    public String getClzName(String clzName) {
        return basePackage + clzName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public ModelBuilderContext setBasePackage(String basePackage) {
        this.basePackage = basePackage;
        return this;
    }

    @Override
    public String toString() {
        return "ModelBuilderContext{" +
                "basePackage='" + basePackage + '\'' +
                ", relatedDbs=" + relatedDbs +
                '}';
    }



}