package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoSqlConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseRelationDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonFieldTypeInfo;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldInfo;

import java.util.List;

/**
 * Created by ss on 2018/3/3.
 */
public class CommonModelDaoDef<T extends CommonModelDaoDef> extends _BaseDaoConfImpl<T> implements _BaseDaoConf {

    protected final transient TableInfoInterface def;

    protected String assemblerExtendClzName, assemblerClzName;
    protected String daoExtendClzName, daoClzName;
    protected String mapperClzName;

    protected String baseTable;
    protected boolean buildMapper;

    protected final List<FieldInfoInterface> params;

    protected _BaseDaoSqlConf.DataAttrType dataAttrType;
    protected EnumFieldDataSrcType dataSrcType;

    protected final List<_BaseDaoConf> relationDao;

    protected _BaseRelationDef relationDef;

    protected String sql;

    protected boolean buildAbstractDao;
    protected String dataSourceName;
    protected List<String> dataSourceNames;

    protected JDefinedClass declaredDao, declaredAssembler, declaredMapper, declaredDsConfig;

    public CommonModelDaoDef(TableInfoInterface def, ModelBuilderContext builderContext) {
        super(def, builderContext);
        this.def = def;
        params = CollectionHelper.newList();
        relationDao = CollectionHelper.newList();
        initDef();
        //        enumClzz= CollectionHelper.newMap();
        this.dataSourceName = CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
    }

    public CommonModelDaoDef(String name, TableInfoInterface def, ModelBuilderContext builderContext) {
        super(name, builderContext);
        this.def = def;
        params = CollectionHelper.newList();
        relationDao = CollectionHelper.newList();
        initDef();
        //        enumClzz= CollectionHelper.newMap();
        this.dataSourceName = CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
    }

    public void initDef() {
        final TableInfoInterface tbInfo = def;
        //CommonPOJOConf conf=new CommonPOJOConf();
        List<ColumnInfoInterface> columns = tbInfo.getColumns();
        for (ColumnInfoInterface col : columns) {
            String fname = CodeConstants.getFieldNameFromTbColumn(col.getFieldName());
            FieldDataTypeInterface type = col.getType();
            addField(
                    col
            );
        }

        setPojoClzName(CodeConstants.getReallyModelClassName(builderContext.getBasePackage(), def.getTable(), baseTable));
        dataAttrType = _BaseDaoSqlConf.DataAttrType.LIST_OBJ;
        //        setPojoClzName(builderContext.getModelVoClassName(def.getTable()));
    }

    public String getBaseTable() {
        return baseTable;
    }

    public T setBaseTable(String baseTable) {
        this.baseTable = baseTable;
        setPojoClzName(CodeConstants.getReallyModelClassName(builderContext.getBasePackage(), def.getTable(), baseTable));
        return (T) this;
    }

    @Override
    public boolean buildAbstractDao() {
        return buildAbstractDao;
    }

    public CommonModelDaoDef setBuildAbstractDao(boolean buildAbstractDao) {
        this.buildAbstractDao = buildAbstractDao;
        return this;
    }

    @Override
    public List<_BaseDaoConf> getRelation() {
        return relationDao;
    }

    public int sizeOfRelation() {
        return getRelation().size();
    }

    public boolean addRelation(_BaseDaoConf conf) {
        return getRelation().add(conf);
    }

    @Override
    public _BaseRelationDef getRelatedDef() {
        return relationDef;
    }

    public CommonModelDaoDef setRelationDef(_BaseRelationDef relationDef) {
        this.relationDef = relationDef;
        return this;
    }

    @Override
    public EnumFieldDataSrcType getDaoType() {
        return dataSrcType;
    }

    public CommonModelDaoDef setDataSrcType(EnumFieldDataSrcType dataSrcType) {
        this.dataSrcType = dataSrcType;
        return this;
    }

    @Override
    public String getSql() {
        return sql;
    }

    public CommonModelDaoDef setSql(String sql) {
        this.sql = sql;
        return this;
    }

    public int sizeOfParams() {
        return params.size();
    }

    public boolean addParam(FieldInfoInterface fieldInfoInterface) {
        return params.add(fieldInfoInterface);
    }

    @Override
    public List<FieldInfoInterface> getParams() {
        return params;
    }

    @Override
    public _BaseDaoSqlConf.DataAttrType getSqlType() {
        return dataAttrType;
    }

    public CommonModelDaoDef setDataAttrType(_BaseDaoSqlConf.DataAttrType dataAttrType) {
        this.dataAttrType = dataAttrType;
        return this;
    }

    @Override
    public JDefinedClass getDeclaredDao() {
        return declaredDao;
    }

    @Override
    public void setDeclaredDao(JDefinedClass tclazz) {
        declaredDao = tclazz;
    }

    @Override
    public JDefinedClass getDeclaredAssembler() {
        return declaredAssembler;
    }

    @Override
    public void setDeclaredAssembler(JDefinedClass tclazz) {
        declaredAssembler = tclazz;
    }

    @Override
    public JDefinedClass getDeclaredRsMapper() {
        return declaredMapper;
    }

    @Override
    public void setDeclaredRsMapper(JDefinedClass tclazz) {
        declaredMapper = tclazz;
    }

    @Override
    public SourceAttrType getDataSourceType() {
        return SourceAttrType.DB;
    }

    @Override
    public JDefinedClass getDataSourceConfigClass() {
        return declaredDsConfig;
    }

    @Override
    public void setDataSourceConfigClass(JDefinedClass clz) {
        declaredDsConfig = clz;
    }

    public boolean isBuildMapper() {
        return buildMapper;
    }

    public T setBuildMapper(boolean buildMapper) {
        this.buildMapper = buildMapper;
        return (T) this;
    }

    @Override
    public TableInfoInterface getTableDef() {
        return def;
    }

    @Override
    public String getDaoClzName() {
        return daoClzName;
    }

    public CommonModelDaoDef setDaoClzName(String daoClzName) {
        this.daoClzName = daoClzName;
        return this;
    }

    @Override
    public String getDaoExtendsClzName() {
        return daoExtendClzName;
    }

    public CommonModelDaoDef setDaoExtendClzName(String daoExtendClzName) {
        this.daoExtendClzName = daoExtendClzName;
        return this;
    }

    @Override
    public String getAssemblerClzName() {
        return assemblerClzName;
    }

    public CommonModelDaoDef setAssemblerClzName(String assemblerClzName) {
        this.assemblerClzName = assemblerClzName;
        return this;
    }

    @Override
    public String getAssemblerExtendClzName() {
        return assemblerExtendClzName;
    }

    public CommonModelDaoDef setAssemblerExtendClzName(String assemblerExtendClzName) {
        this.assemblerExtendClzName = assemblerExtendClzName;
        return this;
    }

    @Override
    public String getMapperClzName() {
        return mapperClzName;
    }

    public CommonModelDaoDef setMapperClzName(String mapperClzName) {
        this.mapperClzName = mapperClzName;
        return this;
    }

    @Override
    public String getShadingClzName() {
        return null;
    }

    //    @Override
    //    public List<FieldInfoInterface> getFields() {
    //        return null;
    //    }
    //
    //    @Override
    //    public int sizeOfField() {
    //        return 0;
    //    }
    //
    //    @Override
    //    public boolean addField(FieldInfoInterface fieldDef) {
    //        return false;
    //    }
    //
    //    @Override
    //    public FieldInfoInterface getField(int index) {
    //        return null;
    //    }

    //    @Override
    //    public String getPojoClzName() {
    //        return null;
    //    }
    //
    //    @Override
    //    public T setPojoClzName(String pojoClzName) {
    //        return (T)this;
    //    }
    //
    //    @Override
    //    public String getPojoExtendsClzName() {
    //        return null;
    //    }
    //
    //    @Override
    //    public T setPojoExtendsClzName(String pojoExtendsClzName) {
    //        return (T)this;
    //    }


    //    public String getBaseModelTable() {
    //        return baseModelTable;
    //    }
    //
    //    public SpecialModelConf setBaseModelTable(String baseModelTable) {
    //        this.baseModelTable = baseModelTable;
    //        return (T)this;
    //    }

    //        public Set<String> getIgnoreField() {
    //        return ignoreField;
    //    }
    //
    //    public T setIgnoreField(Set<String> ignoreField) {
    //        this.ignoreField = ignoreField;
    //        return (T) this;
    //    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public T setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
        return (T) this;
    }

    //    public Map<String, JDefinedClass> getEnumClzz() {
    //        return enumClzz;
    //    }
    //
    //    public CommonModelDaoDef setEnumClzz(Map<String, JDefinedClass> enumClzz) {
    //        this.enumClzz = enumClzz;
    //        return this;
    //    }

    //    public int sizeOfEnumClz() {
    //        return getEnumClzz().size();
    //    }
    //
    //    public JDefinedClass getEnumClz(Object key) {
    //        return getEnumClzz().get(key);
    //    }
    //
    //    public JDefinedClass putEnumClz(String key, JDefinedClass value) {
    //        return getEnumClzz().put(key, value);
    //    }

    public List<String> getDataSourceNames() {
        return dataSourceNames;
    }

    public CommonModelDaoDef setDataSourceNames(List<String> dataSourceNames) {
        for (String name : dataSourceNames) {
            final String key = CodeConstants.KEY_WORD_FOR_DATA_SOURCE + name;
            constantConf.putField(
                    key,
                    new FieldInfo()
                            .setFieldName(key)
                            .setType(new CommonFieldTypeInfo().settClass(String.class))
                            .setDefaultValue(name)
            );
        }
        //        this.dataSourceNames = dataSourceNames;
        return this;
    }

    @Override
    public FieldInfoInterface getPriField() {
        return def.getPriKeyInfo();
    }

    //    public String getTable() {
    //        return def.getTable();
    //    }
    //
    //    public String getDb() {
    //        return def.getDb() == null ? DbDataTable.getCurrentDb() : def.getDb();
    //    }
}
