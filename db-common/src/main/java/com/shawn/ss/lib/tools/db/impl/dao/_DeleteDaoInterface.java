package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.Set;

public interface _DeleteDaoInterface<Ty extends AbstractBaseModel> {
    Integer delete(Ty instance, Set<String> conditionField, DaoAssembler assembler);

    Integer delete(Ty instance, Set<String> conditionField);

    Integer deleteById(Integer id, DaoAssembler assembler);

    Integer deleteById(Integer id);

    Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler);

    Integer deleteByIds(Set<Integer> ids);
}
