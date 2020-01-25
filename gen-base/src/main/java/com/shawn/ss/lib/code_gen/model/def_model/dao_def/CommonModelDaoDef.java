package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2018/3/3.
 */
public class CommonModelDaoDef<T extends CommonModelDaoDef> extends _BaseDaoConfImpl<T>  {

    protected final transient TableInfoInterface def;
//    String table,db;
    protected String baseAssemblerClass;
    protected String baseDaoClass;
    protected String baseTable;
    protected boolean buildMapper;
    protected Set<String> ignoreField;
    protected String dataSourceName;
    protected List<String> dataSourceNames;
//    protected Map<String,JDefinedClass> enumClzz;//=CollectionHelper.newMap();
    //    private boolean composed;
//        protected String baseModelTable;

    public CommonModelDaoDef(TableInfoInterface def,ModelBuilderContext builderContext) {
        super(def, builderContext);
        this.def=def;
        initDef();
//        enumClzz= CollectionHelper.newMap();
        this.dataSourceName= CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
    }

    public CommonModelDaoDef(String name, TableInfoInterface def,ModelBuilderContext builderContext) {
        super(name, builderContext);
        this.def=def;
        initDef();
//        enumClzz= CollectionHelper.newMap();
        this.dataSourceName= CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
    }

    public TableInfoInterface getDef() {
        return def;
    }

    public void initDef() {
        final TableInfoInterface tbInfo = def;
        //CommonPOJOConf conf=new CommonPOJOConf();
        List<ColumnInfoInterface> columns = tbInfo.getColumns();
        for (ColumnInfoInterface col : columns) {
            String fname = CodeConstants.getFieldNameFromTbColumn(col.getFieldName());
            FieldDataTypeInterface type = col.getType();
            addField(new FieldInfo().setFieldName(fname).setType(type));
        }

        setPojoClzName(builderContext.getReallyModelClassName(def.getTable(),baseTable));
//        setPojoClzName(builderContext.getModelVoClassName(def.getTable()));
    }

    public String getBaseTable() {
        return baseTable;
    }

    public T setBaseTable(String baseTable) {
        this.baseTable = baseTable;
        setPojoClzName(builderContext.getReallyModelClassName(def.getTable(),baseTable));
        return (T)this;
    }

    public boolean isBuildMapper() {
        return buildMapper;
    }

    public T setBuildMapper(boolean buildMapper) {
        this.buildMapper = buildMapper;
        return (T)this;
    }

    public Set<String> getIgnoreField() {
        return ignoreField;
    }

    public T setIgnoreField(Set<String> ignoreField) {
        this.ignoreField = ignoreField;
        return (T)this;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public T setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
        return (T)this;
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
        this.dataSourceNames = dataSourceNames;
        return this;
    }

    public String getBaseAssemblerClass() {
        return baseAssemblerClass;
    }

    public CommonModelDaoDef setBaseAssemblerClass(String baseAssemblerClass) {
        this.baseAssemblerClass = baseAssemblerClass;
        return this;
    }

    public String getBaseDaoClass() {
        return baseDaoClass;
    }

    public CommonModelDaoDef setBaseDaoClass(String baseDaoClass) {
        this.baseDaoClass = baseDaoClass;
        return this;
    }

    public String getTable() {
        return def.getTable();
    }

    public String getDb() {
        return def.getDb()==null? DbDataTable.getCurrentDb():def.getDb();
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
}
