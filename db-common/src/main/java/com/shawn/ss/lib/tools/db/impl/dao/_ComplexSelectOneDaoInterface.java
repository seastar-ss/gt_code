package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.Map;
import java.util.Set;

public interface _ComplexSelectOneDaoInterface<Ty extends AbstractBaseModel> {
    Ty getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByCondAndWhere(Set<String> selectFields, Ty instance, Map<String, Object> extParam, Set<String> extCondition);
}
