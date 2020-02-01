package com.shawn.ss.lib.code_gen.base.dao.dao_constants;

import com.helger.jcodemodel.*;
import com.shawn.ss.gen.api.model.data_source_conf.ModelDbConfig;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDataSourceConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDataSourceDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.impl.utils.HelperFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.Map;

//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantConf;

public class DaoConstantsBuilder implements CodeBuilderInterface {

    private final _BaseDataSourceConf conf;
    private final ModelBuilderContext builderContext;
    private final JCodeModel cm;
    private final JDefinedClass constantClz;
    private final JPackage constantPackage;

    public DaoConstantsBuilder(_BaseDataSourceConf conf) {
        this.conf = conf;
        builderContext = conf.getBuilderContext();
        cm = builderContext.getCm();
        _BaseConstantDef constant = conf.getConstant();
        constantClz = constant.getConstantClz();
        constantPackage = constantClz.getPackage();
    }

    @Override
    public void buildModel() {
        List<_BaseDataSourceDef> defs = conf.getDsDef();

        for(_BaseDataSourceDef def:defs){
            buildConfigClz(def);
        }
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void buildConfigClz(_BaseDataSourceDef def) {
        String name = def.getDataSourceBaseName();
        AbstractJClass modelRefer = cm.ref(ModelDbConfig.class);
        AbstractJClass contextRefer = cm.ref(GenericApplicationContext.class);
        AbstractJClass helperRefer = cm.ref(HelperFactory.class);
        try {
            JDefinedClass definedClass = constantPackage._class(JMod.PUBLIC, CodeConstants.getDsConfigClzName(name));

            JDefinedClass modelDbConfigImpl = definedClass._class(JMod.STATIC, "ModelDbConfigImpl");
            modelDbConfigImpl.annotate(ConfigurationProperties.class).param("prefix",def.getConfigPrefix());
            modelDbConfigImpl.annotate(PropertySource.class).param("value","classpath:"+def.getConfigFilePath());

            modelDbConfigImpl._extends(modelRefer);

            definedClass.annotate(Configuration.class);
            definedClass.annotate(EnableConfigurationProperties.class).param("value",JExpr.dotclass(modelDbConfigImpl));
            JFieldVar configField = definedClass.field(JMod.PRIVATE + JMod.FINAL, modelRefer, "config");
            CodeConstants.buildGetter(definedClass,"config",modelRefer,configField);
            JFieldVar contextField = definedClass.field(JMod.PRIVATE + JMod.FINAL, contextRefer, "context");
            JFieldVar beanFactoryField = definedClass.field(
                    JMod.PRIVATE + JMod.FINAL,
                    cm.ref(ConfigurableListableBeanFactory.class),
                    "beanFactory"
            );
            JFieldVar dataSourceNameField = definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, String.class, "dataSourceName", JExpr.lit(name));

            JMethod init = definedClass.method(JMod.PRIVATE, Void.class, "init");
            JBlock initBody = init.body();
            JVar dbsVar = initBody.decl(
                    CodeConstants.buildNarrowedClass(cm, Map.class, String.class, SimpleDbInterface.class),
                    "dbHandlers",
                    helperRefer.staticInvoke("getDbHandler").arg(dataSourceNameField).arg(configField)
            );
            initBody.add(helperRefer.staticInvoke("registeBean").arg(dataSourceNameField).arg(dbsVar).arg(beanFactoryField));


            JMethod constructor = definedClass.constructor(JMod.PUBLIC);
            JVar configVar = constructor.param(modelRefer, "config");
            JVar contextVar = constructor.param(contextRefer, "context");

            JBlock body = constructor.body();
            body.assign(configField,configVar);
            body.assign(contextField,contextVar);
            body.invoke(init);


        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }
}
