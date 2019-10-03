package com.shawn.ss.gen.code_build_handlers.sql_dao;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.SqlResp;
import com.shawn.ss.gen.code_build_handlers.AbstractClassHandler;
import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.tools.structure.LoopStatus;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.*;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlDaoHandler extends AbstractClassHandler<SqlDaoConf> {
    public SqlDaoHandler(Class<SqlResp> sqlRespClass) {
        super(sqlRespClass);
    }

    @Override
    protected AbstractCodeGenerator buildGenerator(String basePack, Helpers helpers) {
        return new SqlDaoGen(getContexts());
    }

    @Override
    public void handleClass(RoundEnvironment env, Helpers helpers, Element element,LoopStatus loopStatus) {
        final ElementKind kind = element.getKind();
        if (kind == ElementKind.METHOD) {

            SqlDaoConf conf = new SqlDaoConf(element, helpers);
//            String database = annotation.database();
//            conf.setContext();

            addContext(conf);
        }
    }



    @Override
    public void afterHandleAllElement(RoundEnvironment env, Helpers helpers, LoopStatus loopStatus) {

    }
}
