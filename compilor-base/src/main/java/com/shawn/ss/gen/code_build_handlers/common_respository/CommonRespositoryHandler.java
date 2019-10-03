package com.shawn.ss.gen.code_build_handlers.common_respository;

import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.gen.Constants;
import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultResp;
import com.shawn.ss.gen.code_build_handlers.AbstractClassHandler;
import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.tools.structure.LoopStatus;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;

public class CommonRespositoryHandler extends AbstractClassHandler<ModelGenConf> {


//    ModelGenConf conf;
//    ModelBuilderContext context;

//    String dataSourceId;


    public CommonRespositoryHandler(Class<DefaultResp> defaultRespClass) {
        super(defaultRespClass);

    }

    @Override
    public void beforeHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {

        super.beforeHandle(env, helpers, status);
//        if(status.isFirst() && !AbstractGenConf.isContextInited()){
//            final DBConnectionHelper conn = helpers.getConn();
////            final Properties gen = helpers.getProperties("gen");

//        }
    }

    @Override
    protected AbstractCodeGenerator buildGenerator(String basePack, Helpers helpers) {

        return new CommonRespGen(getContexts());
    }

    @Override
    public void handleClass(RoundEnvironment env, Helpers helpers, Element element, LoopStatus loopStatus) {
        final ElementKind kind = element.getKind();
        if (kind == ElementKind.PACKAGE) {
            if (loopStatus.isFirst()) {

            }
            ModelGenConf conf = new ModelGenConf((PackageElement) element, helpers);
            addContext(conf);
//            AbstractGenConf.setContext(context,basePackPos);


//            if(includingTables==null || includingTables.size()==0) {
//            if(AbstractGenConf.isContextInited()){
//            context.addDb(database,conn,includingTables,excludeTables);
//            }else {
//            }
//            conf.getContext().addDb(database,excludeTables,includingTables);
//            TypeMirror typeMirror = element.asType();
//            }else {
//                context = ModelBuilderContext.builderPartialHelper(conn,cm)
//            }
//            if(StringHelper.isEmpty(dataSourceId)){
//                context.buildBaseModelAndDao();
//            }else{
//                context.buildBaseModelAndDao(dataSourceId);
//            }
        }
    }

    @Override
    public void afterHandleAllElement(RoundEnvironment env, Helpers helpers, LoopStatus loopStatus) {
//        super.afterHandleAllElement(env,helpers);
    }
}
