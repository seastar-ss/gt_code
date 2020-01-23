package com.shawn.ss.gen.code_build_handlers.multi_dao_conf.multi_dao_conf;

import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoDaoConf;

import java.io.IOException;
import java.util.List;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlMultiDaoGen extends AbstractCodeGenerator {
    private List<SqlMultiDaoConf> contexts;

    public SqlMultiDaoGen(List<SqlMultiDaoConf> contexts) {
        super();
        this.contexts = contexts;
    }



    @Override
    public void genCode() {
        for(SqlMultiDaoConf ct:contexts) {
            ModelBuilderContext context = ct.getContext();
            final List<ModelMulDaoDaoConf> confModels = ct.getConfModel();
            if(confModels!=null && confModels.size()>0) {
                for(ModelMulDaoDaoConf conf:confModels) {
                    context.buildMultiSelectDao(conf);
                }
            }
        }
    }

    @Override
    public void beforeWriteCode() throws IOException {
//        for(SqlMultiDaoConf ct:contexts) {
//            ModelBuilderContext context = ct.getContext();
//            context.writeModel();
//        }
    }
}
