package com.shawn.ss.gen.code_build_handlers.common_respository;

import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.tools.StringHelper;

import java.io.IOException;
import java.util.List;

public class CommonRespGen extends AbstractCodeGenerator {


//    private String dataSourceId;
    private List<ModelGenConf> contexts;

    public CommonRespGen(List<ModelGenConf> contexts) {
        super();
//        this.dataSourceId = dataSourceId;
        this.contexts = contexts;
    }

    @Override
    public void genCode() {
        for(ModelGenConf ct:contexts) {
            final ModelBuilderContext context = ct.getContext();
            context.buildBaseModelAndDao();
        }
    }

    @Override
    public void beforeWriteCode() throws IOException {
//        for(ModelGenConf ct:contexts) {
//            ModelBuilderContext context = ct.getContext();
//            context.writeModel();
//        }
    }
}
