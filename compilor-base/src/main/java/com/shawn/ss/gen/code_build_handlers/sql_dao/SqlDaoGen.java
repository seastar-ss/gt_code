package com.shawn.ss.gen.code_build_handlers.sql_dao;

import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.SpecialModelDef;

import java.io.IOException;
import java.util.List;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlDaoGen extends AbstractCodeGenerator {
    private List<SqlDaoConf> contexts;

    public SqlDaoGen(List<SqlDaoConf> contexts) {
        super();
        this.contexts = contexts;
    }

    @Override
    public void genCode() {
        for(SqlDaoConf ct:contexts) {
            ModelBuilderContext context = ct.getContext();
            context.buildSpecialModalAndDao(new SpecialModelDef()
                    .setClzName(ct.getClassName())
                    .setMethodName(ct.getMethodName())
                    .setDefualtParam(ct.getDefualtParam())
                    .setSql(ct.getSql())
                    .setComment(ct.getComment())
                    .setDataSourceName(ct.getDataSourceId())
                    .setInterfaceClzName(ct.getInterfaceClassName())
                    .setParams(ct.getParams())
//                    .setDataSourceName(context.get)
            );

        }
    }

    @Override
    public void beforeWriteCode() throws IOException {
//        for(SqlDaoConf ct:contexts) {
//            ModelBuilderContext context = ct.getContext();
//            context.writeModel();
//        }
    }
}
