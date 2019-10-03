package com.shawn.ss.gen.code_build_handlers.multi_dao_conf.multi_dao_conf;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.SqlMultipleResp;
import com.shawn.ss.gen.code_build_handlers.AbstractClassHandler;
import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.tools.structure.LoopStatus;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlMultiDaoHandler extends AbstractClassHandler<SqlMultiDaoConf> {
    public SqlMultiDaoHandler(Class<SqlMultipleResp> sqlRespClass) {
        super(sqlRespClass);
    }

    @Override
    protected AbstractCodeGenerator buildGenerator(String basePack, Helpers helpers) {
        return new SqlMultiDaoGen(getContexts());
    }

    @Override
    public void handleClass(RoundEnvironment env, Helpers helpers, Element element,LoopStatus loopStatus) {
        final ElementKind kind = element.getKind();
        if (kind == ElementKind.PACKAGE) {

            SqlMultiDaoConf conf = new SqlMultiDaoConf(element, helpers);
//            String database = annotation.database();
//            conf.setContext();

            addContext(conf);
        }
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
    public void afterHandleAllElement(RoundEnvironment env, Helpers helpers, LoopStatus loopStatus) {

    }
}
