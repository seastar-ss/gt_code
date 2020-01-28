package com.shawn.ss.lib.code_gen.model.def_model.interfaces;

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


}
