package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface _WhereSelectDaoInterface<Ty extends AbstractBaseModel> {
    List<Ty> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition);

    <TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

}
