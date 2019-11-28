package com.shawn.ss.gen.code_build_handlers.sql_dao;

import com.shawn.ss.gen.Constants;
import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.SqlResp;
import com.shawn.ss.gen.api.interfaces.SqlRespClass;
import com.shawn.ss.gen.api.interfaces.SqlRespParam;
import com.shawn.ss.gen.clz_analyze_handlers.TypeAnalyzer;
import com.shawn.ss.gen.tools.clzAnalyzer.ClassAnalyze;
import com.shawn.ss.gen.code_build_handlers.AbstractGenConf;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
//import com.shawn.ss.gen.tools.clzAnalyzer.ClassAnalyze;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.CommonFieldTypeInfo;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.element.*;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlDaoConf extends AbstractGenConf {

    public static final Logger L = LoggerFactory.getLogger(SqlDaoConf.class);

    protected String sql;
    protected String className;
    protected String interfaceClassName;
    protected String methodName;
    protected String comment;
    protected String dataSourceId;

    protected String baseClz;
    protected String baseTable;

//    protected Map<String, Object> defualtParam;
    protected final ModelBuilderContext context;
    protected List<FieldInfoInterface> params;
    private final ClassAnalyze analyzer;

    public SqlDaoConf(Element element, Helpers helpers) throws IllegalArgumentException {
        super(element);
        analyzer = new ClassAnalyze(helpers);
//        defualtParam= CollectionHelper.newMap();
        params=CollectionHelper.newList();
        SqlResp annotation = element.getAnnotation(SqlResp.class);
        String sql = annotation.sql();
        assert (!StringHelper.isEmpty(sql));
        this.setSql(sql);

//            if(StringHelper.isEmpty(clazzName) || StringHelper)
        ExecutableElement el = (ExecutableElement) element;
        String methodName = annotation.methodName();
        Name simpleName = el.getSimpleName();
        if (StringHelper.isEmpty(methodName)) {
            this.setMethodName(simpleName.toString());
        } else {
            this.setMethodName(methodName);
        }

        List<? extends VariableElement> parameters = el.getParameters();
        helpers.println("get method param:"+parameters.size());
        handleParamInfo(this, parameters, helpers,analyzer);

        Element enclosingElement = el.getEnclosingElement();
        if (enclosingElement != null && enclosingElement.getKind() == ElementKind.INTERFACE) {
            final TypeElement typeElement = (TypeElement) enclosingElement;
            handleClassInfo(this, typeElement, helpers);
            context=findContextByPos(typeElement,helpers);
            if(context==null){
                throw new IllegalArgumentException("@SqlResp标注的类，应该在@DefaultResp标注的包之下");
            }
        }else{
            throw new IllegalArgumentException("不能再此处上增加@SqlResp，找不到外围的interface元素");
        }


        handleMethodRetType(this, el,helpers,analyzer);

        String docComment = helpers.elementUtils.getDocComment(el);
        this.setComment(docComment);
        dataSourceId=annotation.dataSourceId();
    }



    public String getSql() {
        return sql;
    }

    public SqlDaoConf setSql(String sql) {
        this.sql = sql;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public SqlDaoConf setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public SqlDaoConf setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public SqlDaoConf setComment(String comment) {
        this.comment = comment;
        return this;
    }

//    public Map<String, Object> getDefualtParam() {
//        return defualtParam;
//    }
//
//    public SqlDaoConf setDefualtParam(Map<String, Object> defualtParam) {
//        this.defualtParam = defualtParam;
//        return this;
//    }

//    public int sizeOfDefaultParam() {
//        return defualtParam.size();
//    }
//
//    public boolean isDefaultParamEmpty() {
//        return defualtParam.isEmpty();
//    }
//
//    public Object getDefaultParam(Object key) {
//        return defualtParam.get(key);
//    }
//
//    public SqlDaoConf putDefaultParam(String key, Object value) {
//        defualtParam.put(key, value);
//        return this;
//    }

    public static void handleMethodRetType(SqlDaoConf sqlDaoConf, ExecutableElement el, Helpers helpers, ClassAnalyze analyzer) {
        TypeMirror returnType = el.getReturnType();
        //TODO: handle base model
        if(returnType.getKind()== TypeKind.WILDCARD){
            WildcardType type=(WildcardType)returnType;
            TypeMirror extendsBound = type.getExtendsBound();
            String toString = extendsBound.toString();
            if(ClassDataTable.keySetOfModelClz().contains(toString)){
                sqlDaoConf.baseTable=toString;
            }
        }
    }

    public static void handleClassInfo(SqlDaoConf conf, TypeElement el, Helpers helpers) {
        Name qualifiedName = el.getQualifiedName();
        String clName=null;
        SqlRespClass annotation = el.getAnnotation(SqlRespClass.class);
        if(annotation!=null){
            clName=annotation.clazzName();
        }
        if(StringHelper.isEmpty(clName)){
            clName=el.getSimpleName().toString()+ Constants.CLASS_IMPL_APPENDIX;
        }
        conf.setInterfaceClassName(qualifiedName.toString());
        helpers.println("get sql class name:"+clName);
        conf.setClassName(clName);
    }

    public static void handleParamInfo(SqlDaoConf conf, List<? extends VariableElement> parameters, Helpers helpers, ClassAnalyze analyzer) {
        for(VariableElement el:parameters){

            boolean add = conf.params.add(buildParam(el,helpers,analyzer));
        }
    }

    private static FieldInfoInterface buildParam(VariableElement el, Helpers helpers, ClassAnalyze analyzer) {
        ModelParamEntry entry=new ModelParamEntry();
        analyzer.assembleParamStructure(entry,el);
        Integer arrayDemension = entry.getArrayDemension();
        Name simpleName = el.getSimpleName();
        Object value=null;
        helpers.println("handle sql params:" + simpleName);
        SqlRespParam annotation = el.getAnnotation(SqlRespParam.class);
        String defaultValue = null;
        String name = null;
        if (annotation != null) {
            defaultValue = annotation.defaultValue();
            name = annotation.name();
        }
        if (StringHelper.isEmpty(name)) {
            name = simpleName.toString();
        }
        if(entry.isSimple() && (arrayDemension ==0 )) {
            TypeMirror typeMirror = el.asType();

            value = helpers.asObject(defaultValue, typeMirror);
            helpers.println("handle sql params:" + name + "->" + value);
            assert (value != null);
//                conf.putDefaultParam(name, value);
        }

        FieldInfo def=new FieldInfo();
        def.setDefaultValue(value);
        def.setFieldName(entry.getParamName());
        if(entry.isSimple()){
            def.setFieldName(entry.getClzName());

            CommonFieldTypeInfo type=new CommonFieldTypeInfo();
            if(arrayDemension==0){
                type.setArray(false).setCollection(false).setMap(false);
            }else if(arrayDemension==1){
                ModelParamEntry.ArrayType arrayType = entry.getArrayType().get(0);
                switch (arrayType){
                    case array:
                        type.setArray(true).setCollection(false).setMap(false);
                        break;
                    case list:
                        type.setArray(false).setCollection(true).setMap(false);
                        break;
                    default:
                        break;
                }
            }else{
                //TODO:
            }
            def.setType(type);
        }else {
            //TODO:
        }

        L.info("build param conf:"+def);
        return def;
    }

//    private static FieldInfoInterface buildParam(ModelParamEntry entry) {
//
//    }


    public ModelBuilderContext getContext() {
        return context;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public String getInterfaceClassName() {
        return interfaceClassName;
    }

    public SqlDaoConf setInterfaceClassName(String interfaceClassName) {
        this.interfaceClassName = interfaceClassName;
        return this;
    }

    public SqlDaoConf setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
        return this;
    }

    public List<FieldInfoInterface> getParams() {
        return params;
    }

    public SqlDaoConf setParams(List<FieldInfoInterface> params) {
        this.params = params;
        return this;
    }

    public String getBaseClz() {
        return baseClz;
    }

    public SqlDaoConf setBaseClz(String baseClz) {
        this.baseClz = baseClz;
        return this;
    }

    public String getBaseTable() {
        return baseTable;
    }

    public SqlDaoConf setBaseTable(String baseTable) {
        this.baseTable = baseTable;
        return this;
    }
}
