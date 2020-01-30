package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.helger.jcodemodel.AbstractJType;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.List;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseDaoConf extends _BaseModelConf,_BaseDaoClassNameConf,_BaseDataSourceConf {
    List<SelectMethodEnum> getMainModelSelectMethod();

    String getTable();
    String getDb();
//    FieldInfoInterface getPriField();
    TableInfoInterface getTableDef();
    String getBaseTable();
    boolean buildAbstractDao();

    /////data acess api
    AbstractJType getDeclaredDao();

    void setDeclaredDao(AbstractJType tclazz);

    AbstractJType getDeclaredAssembler();

    void setDeclaredAssembler(AbstractJType tclazz);

    AbstractJType getDeclaredMapper();

    void setDeclaredMapper(AbstractJType tclazz);
}
