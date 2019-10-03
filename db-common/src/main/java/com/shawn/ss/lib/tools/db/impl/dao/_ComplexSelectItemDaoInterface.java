package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface _ComplexSelectItemDaoInterface<Ty extends AbstractBaseModel> {
    Long getCountByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes);

    Long getCountByCondAndIndex(Ty instance, String inField, List indexes);

    Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    Long getCountByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    <TT> TT getItemByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> TT getItemByCondAndIndex(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> TT getItemByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);


}
