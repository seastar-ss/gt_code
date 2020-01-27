package com.shawn.ss.lib.code_gen.model.def_model;

import com.helger.jcodemodel.AbstractJType;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.TableInfo;

import java.util.List;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseDaoConf<T extends _BaseDaoConf> extends _BaseModelConf<T>,_BaseDaoClassNameConf<T>,_BaseDataSourceConf {
    List<SelectMethodEnum> getMainModelSelectMethod();
    T setMainModelSelectMethod(List<SelectMethodEnum> mainModelSelectMethod);
    String getTable();
    String getDb();
//    FieldInfoInterface getPriField();
    TableInfoInterface getTableDef();
    List<_BaseSubDaoConf<_BaseSubDaoConf>> getRelatedDef();
    String getBaseTable();

    /////data acess api
    AbstractJType getDeclaredDao();

    T setDeclaredDao(AbstractJType tclazz);

    AbstractJType getDeclaredAssembler();

    T setDeclaredAssembler(AbstractJType tclazz);

    AbstractJType getDeclaredMapper();

    T setDeclaredMapper(AbstractJType tclazz);
}
