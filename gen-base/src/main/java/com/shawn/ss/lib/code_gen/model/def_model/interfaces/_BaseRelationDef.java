package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Map;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseRelationDef extends _BaseDef {

    String getFieldInThisTable();
    String getFieldInMainTable();
    boolean isSingle();
    String getFieldName();
    String getAdditionalWhere();
    Map<String,String> getAdditionalCondition();
    FieldInfoInterface getRelatedField();
//    _BaseDaoConf getRelatedDaoConf();

}
