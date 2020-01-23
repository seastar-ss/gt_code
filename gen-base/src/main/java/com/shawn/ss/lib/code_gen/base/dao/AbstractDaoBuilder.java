package com.shawn.ss.lib.code_gen.base.dao;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDaoDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class AbstractDaoBuilder implements CodeBuilderInterface {
    public static final String LOGGER_TEMPLATE="execute sql:\n{}\nwith param:{}";

    protected final ModelBuilderContext builderContext;

//    protected final ModelBuilder parentBuilder;
    protected final JCodeModel cm;
    protected  String daoClassName;
    protected JDefinedClass definedClass;
    protected AbstractJClass modelClass;
    protected JFieldVar dbField;
    protected Map<String,JFieldVar> dbFields;
    protected TableInfoInterface info;
    protected final String table;
    protected final CommonModelDaoDef modelDef;
    protected JFieldVar loggerField;
    protected JMethod afterPropertiesSet;
    protected JFieldVar dbMapField;

    public AbstractDaoBuilder(CommonModelDaoDef def, ModelBuilderContext builderContext) {
        cm = builderContext.getCm();
        final List<String> dataSourceNames = def.getDataSourceNames();
        if(dataSourceNames!=null && dataSourceNames.size()>0) {
            dbFields = CollectionHelper.newMap();
        }else{
            dbFields= Collections.emptyMap();
        }
        /**
         * this.modelDef = def;
         this.info = def.getDef();
         this.builderContext = def.getBuilderContext();
         this.baseTable = def.getBaseTable();
         Set<String> ignore = def.getIgnoreField();
         this.ignoreField = (ignore ==null? Collections.emptySet(): ignore);
         data_store = info.getDb();
         table = info.getTable();
         columns = info.getColumns();

         if (builderContext == null)
         throw new IllegalArgumentException("code build context is null");
         //        else
         this.cm = builderContext.getCm();

         this.modelClassName =builderContext.getReallyModelClassName(table,baseTable);
         this.allModelFields = CollectionHelper.newMap();
         this.allGetFields = CollectionHelper.newMap();
         this.allSetFields = CollectionHelper.newMap();
         if(baseTable==null) {
         extendedClazz = cm.ref(AbstractBaseModel.class);
         }else{
         //            this.selectModel = true;
         extendedClazz =cm.ref(builderContext.getReallyModelClassName(baseTable, null));
         }
         this.selectModel = (info.getTableType()==2);
         enumClzz=CollectionHelper.newMap();
         */
//        if(parentBuilder!=null) {
//        this.parentBuilder = parentBuilder;
        this.info = def.getDef();
        String baseTable = def.getBaseTable();

        this.table = info.getTable();
        modelClass = cm.ref(builderContext.getReallyModelClassName(table,baseTable));

        int tableType = this.info.getTableType();
//        String modelClassName = parentBuilder.getModelClassName();

//        String baseTable = parentBuilder.getBaseTable();
        this.builderContext = builderContext;
        this.daoClassName = builderContext.getDaoClassName(table, baseTable, tableType);
        modelDef =def;
//        }else{
//
//        }
    }

    @Override
    public void buildModel() {
        try {
            FieldDataTypeInterface priKeyType = info.getPriKeyType();
            definedClass = cm._class(daoClassName);

            loggerField = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.ref(Logger.class), CodeConstants.FIELD_DAO_LOGGER,
                    cm.ref(LoggerFactory.class).staticInvoke("getLogger").arg(JExpr.dotclass(definedClass)));
            JAnnotationUse annotate = definedClass.annotate(Repository.class);
            annotate.param("value", CodeConstants.getClassNameFromFullName(daoClassName));
            definedClass._implements(InitializingBean.class);
            AbstractJType idType=(priKeyType==null?cm.ref(Object.class):cm.ref(priKeyType.gettClass()));
            definedClass._implements(CodeConstants.buildNarrowedClass(cm,DaoInterface.class,modelClass,idType));
            final String baseDaoClass = modelDef.getBaseDaoClass();
            AbstractJClass ref = cm.ref(AbstractDao.class);
            if(!StringHelper.isEmpty(baseDaoClass)){
                ref=cm.ref(baseDaoClass);
            }
            definedClass._extends(CodeConstants.buildNarrowedClass(cm,ref,modelClass,idType));
            definedClass.annotate(cm.ref(SuppressWarnings.class)).param("value","unchecked");//.annotationParam(cm.ref(String.class),JExpr.lit("unchecked"))
            afterPropertiesSet=definedClass.method(JMod.PUBLIC,cm.VOID, CodeConstants.METHOD_SPRING_BEAN_AFTER_PROPERTIES_SET);
            afterPropertiesSet.annotate(Override.class);
            afterPropertiesSet._throws(Exception.class);
            definedClass.constructor(JMod.PUBLIC).body().invoke("super").arg(JExpr.dotclass(modelClass));
            buildCommonDbFieldInjection();
//            info = parentBuilder.getInfo();
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }

    }

    protected void buildCommonDbFieldInjection() {
        String dataSourceName = modelDef.getDataSourceName();
        final List<String> dataSourceNames = modelDef.getDataSourceNames();
        boolean multiDs=dataSourceNames!=null && dataSourceNames.size()>0;
        if(dataSourceName==null){
            if(multiDs){
                dataSourceName=dataSourceNames.get(0);
            }
        }
        dbField=addInjectedDbField("", dataSourceName);

        if(multiDs){
            dbMapField = definedClass.field(
                    JMod.PROTECTED + JMod.STATIC + JMod.FINAL,
                    CodeConstants.buildNarrowedClass(cm, Map.class, String.class, SimpleDbInterface.class),
                    CodeConstants.FIELD_DAO_DB_FIELD_MAP,
                    cm.ref(CollectionHelper.class).staticInvoke("newMap")
            );
            JBlock body = afterPropertiesSet.body();
            for(String dsName:dataSourceNames) {
                JFieldVar field = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, CodeConstants.getFieldNameOfDBSourceName(dsName), JExpr.lit(dsName));
                final JFieldVar dbField = addInjectedDbField(dsName,dsName);
                body._if(dbField.ne(JExpr._null()))._then().invoke(dbMapField,"put").arg(field).arg(dbField);
            }
        }
    }

    protected JFieldVar addInjectedDbField(String dsFieldName,String dataSourceName){
        JFieldVar ret = definedClass.field(JMod.PROTECTED, cm.ref(SimpleDbInterface.class), CodeConstants.getFieldNameOfDBFieldBySourceName(dsFieldName));
        ret.annotate(Autowired.class).param("required", true);
//        String dataSourceName = modelDef.getDataSourceName();
        if(dataSourceName!=null){
            ret.annotate(Qualifier.class).param("value",JExpr.lit(dataSourceName));
        }
        return ret;
    }

    public void addLogs(JBlock body, IJExpression sql, IJExpression param) {
        body.invoke(loggerField,"info").arg(JExpr.lit(LOGGER_TEMPLATE)).arg(sql).arg(param);
    }

    public JDefinedClass getDefinedClass() {
        return definedClass;
    }
}
