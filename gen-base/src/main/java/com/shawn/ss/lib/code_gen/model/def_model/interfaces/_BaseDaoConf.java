package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.gen.api.conf.SelectMethod;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.Collection;
import java.util.List;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseDaoConf extends _BaseModelConf, _BaseDaoClassNameConf, _BaseDataSourceConf {

    public enum EnumFieldDataSrcType {
        commonDao, specialDao, mulDao, customerDao
    }

    public static enum DataAttrType {
        SINGLE, OBJ, LIST, LIST_OBJ
    }

    Collection<SelectMethod> getMainModelSelectMethod();

    String getTable();

    String getDb();

    //    FieldInfoInterface getPriField();
    TableInfoInterface getTableDef();

    String getBaseTable();

    boolean buildAbstractDao();

    List<_BaseDaoConf> getRelation();

    _BaseDaoConf getRelation(int index);

    _BaseRelationDef getRelatedDef(String configName);

    EnumFieldDataSrcType getDaoType();

    //    String getSql();

    List<FieldInfoInterface> getParams();

    _BaseDaoSqlConf.DataAttrType getSqlType();

    /////data acess api
    JDefinedClass getDeclaredDao();

    void setDeclaredDao(JDefinedClass tclazz);

    JDefinedClass getDeclaredAssembler();

    void setDeclaredAssembler(JDefinedClass tclazz);

    JDefinedClass getDeclaredRsMapper();

    void setDeclaredRsMapper(JDefinedClass tclazz);

    String getDBInstancePrefix();
}
