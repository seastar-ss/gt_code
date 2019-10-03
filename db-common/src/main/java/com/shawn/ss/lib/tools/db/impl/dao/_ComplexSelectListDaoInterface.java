package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface _ComplexSelectListDaoInterface<Ty extends AbstractBaseModel> {
    List<Ty> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes);

    List<Ty> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes);

    List<Ty> getByCondAndIndex(Set<String> selectFields, Ty instance, String inField, List indexes);

    List<Ty> getByIdAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndIndexAndWhere(Set<String> selectFields, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(Set<String> selectFields, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Set<String> selectFields, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

}
