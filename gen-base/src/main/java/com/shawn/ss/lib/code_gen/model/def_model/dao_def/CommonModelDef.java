package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.model.def_model._BaseConf;
import com.shawn.ss.lib.code_gen.model.def_model._BaseConfImpl;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/3/3.
 */
public class CommonModelDef<T extends CommonModelDef> extends _BaseConfImpl implements _BaseConf {

    protected transient TableInfoInterface def;
    protected String baseAssemblerClass;
    protected String baseDaoClass;
    protected String baseTable;
    protected boolean buildMapper;
    protected Set<String> ignoreField;
    protected String dataSourceName;
    protected List<String> dataSourceNames;
    protected Map<String,JDefinedClass> enumClzz;//=CollectionHelper.newMap();
    //    private boolean composed;
//        protected String baseModelTable;

    public CommonModelDef() {
        enumClzz= CollectionHelper.newMap();
        this.dataSourceName= CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
    }

    public TableInfoInterface getDef() {
        return def;
    }

    public T setDef(TableInfoInterface def) {
        this.def = def;
        return (T)this;
    }

    public String getBaseTable() {
        return baseTable;
    }

    public T setBaseTable(String baseTable) {
        this.baseTable = baseTable;
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

    public Map<String, JDefinedClass> getEnumClzz() {
        return enumClzz;
    }

    public CommonModelDef setEnumClzz(Map<String, JDefinedClass> enumClzz) {
        this.enumClzz = enumClzz;
        return this;
    }

    public int sizeOfEnumClz() {
        return getEnumClzz().size();
    }

    public JDefinedClass getEnumClz(Object key) {
        return getEnumClzz().get(key);
    }

    public JDefinedClass putEnumClz(String key, JDefinedClass value) {
        return getEnumClzz().put(key, value);
    }

    public List<String> getDataSourceNames() {
        return dataSourceNames;
    }

    public CommonModelDef setDataSourceNames(List<String> dataSourceNames) {
        this.dataSourceNames = dataSourceNames;
        return this;
    }

    public String getBaseAssemblerClass() {
        return baseAssemblerClass;
    }

    public CommonModelDef setBaseAssemblerClass(String baseAssemblerClass) {
        this.baseAssemblerClass = baseAssemblerClass;
        return this;
    }

    public String getBaseDaoClass() {
        return baseDaoClass;
    }

    public CommonModelDef setBaseDaoClass(String baseDaoClass) {
        this.baseDaoClass = baseDaoClass;
        return this;
    }

    //    public String getBaseModelTable() {
//        return baseModelTable;
//    }
//
//    public SpecialModelDef setBaseModelTable(String baseModelTable) {
//        this.baseModelTable = baseModelTable;
//        return (T)this;
//    }
}
