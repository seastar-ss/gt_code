package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.model.def_model._BaseConf;
import com.shawn.ss.lib.code_gen.model.def_model._BaseDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.List;
import java.util.Map;

/**
 * Created by ss on 2018/2/13.
 */
public class SpecialModelConf extends CommonModelDef<SpecialModelConf> implements _BaseConf, _BaseDef {
//    String name;
    protected String sql;
    protected Map<String, Object> defualtParam;
    protected String methodName;
//    protected String name;
    protected String clzName;
    protected String interfaceClzName;
    protected String comment;
    protected boolean listResult;
    protected List<FieldInfoInterface> params;
    protected String queryModelClzName;

//    private transient TableInfoInterface modelDef;
    protected volatile DataAttrType dataType;
    protected SourceAttrType sourceType;

    public static enum DataAttrType {
        SINGLE, OBJ, LIST, LIST_OBJ
    }

    public static enum SourceAttrType{
        DB,REDIS,FIXED
    }

    public SpecialModelConf(String name, TableInfoInterface def) {
        super(name,def);
        defualtParam= CollectionHelper.newMap();
        params= CollectionHelper.newList();
//        dataType=DataAttrType.LIST_OBJ;
        listResult=true;
        sourceType= SourceAttrType.DB;
    }

    public String getSql() {
        return sql;
    }

    public SpecialModelConf setSql(String sql) {
        this.sql = sql;

        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public SpecialModelConf setMethodName(String name) {
        this.methodName = name;
        return this;
    }

    public Map<String, Object> getDefualtParam() {
        return defualtParam;
    }

    public SpecialModelConf setDefualtParam(Map<String, Object> defualtParam) {
        this.defualtParam = defualtParam;
        return this;
    }

    public int sizeOfDefaultParam() {
        return defualtParam.size();
    }

    public boolean isDefaultParamEmpty() {
        return defualtParam.isEmpty();
    }

    public Object getDefaultParam(Object key) {
        return defualtParam.get(key);
    }

    public SpecialModelConf putDefaultParam(String key, Object value) {
        defualtParam.put(key, value);
        return this;
    }

    public DataAttrType getDataType() {
        if(dataType ==null ) {
            if (def != null) {
                int size = def.getColumnCount();
                if (size == 1) {
                    dataType =listResult ? DataAttrType.LIST : DataAttrType.SINGLE;
//                    assert(getBaseTable() ==null);
                } else if (size > 1) {
                    dataType =listResult ? DataAttrType.LIST_OBJ : DataAttrType.OBJ;
                }
            }else {
                throw new IllegalArgumentException("need set dataType");
            }
        }
        return dataType;
    }

    public SpecialModelConf setDataType(DataAttrType dataType) {
        this.dataType = dataType;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SpecialModelConf setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isListResult() {
        return listResult;
    }

    public SpecialModelConf setListResult(boolean listResult) {
        this.listResult = listResult;
        return this;
    }

    public SourceAttrType getSourceType() {
        return sourceType;
    }

    public SpecialModelConf setSourceType(SourceAttrType sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public String getClzName() {
        return clzName;
    }

    public SpecialModelConf setClzName(String clzName) {
        this.clzName = clzName;
        return this;
    }

    public String getInterfaceClzName() {
        return interfaceClzName;
    }

    public SpecialModelConf setInterfaceClzName(String interfaceClzName) {
        this.interfaceClzName = interfaceClzName;
        return this;
    }

    public List<FieldInfoInterface> getParams() {
        return params;
    }

    public int sizeOfParam() {
        return params.size();
    }

    public boolean addParam(FieldInfoInterface sqldaoMethodParamDef) {
        return params.add(sqldaoMethodParamDef);
    }

    public FieldInfoInterface getParam(int index) {
        return params.get(index);
    }

    public SpecialModelConf setParams(List<FieldInfoInterface> params) {
        this.params = params;
        return this;
    }

    public String getQueryModelClzName() {
        return queryModelClzName;
    }

    public SpecialModelConf setQueryModelClzName(String queryModelClzName) {
        this.queryModelClzName = queryModelClzName;
        return this;
    }

//    public String getName() {
//        return name;
//    }

//    public SpecialModelConf setName(String name) {
//        this.name = name;
//        return this;
//    }
}
