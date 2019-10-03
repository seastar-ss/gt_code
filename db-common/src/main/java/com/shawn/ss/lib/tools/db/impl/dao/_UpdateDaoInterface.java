package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.Set;

public interface _UpdateDaoInterface<Ty extends AbstractBaseModel> {

    Integer update(Ty instance, Set<String> conditionField, DaoAssembler assembler);

    Integer update(Ty instance, Set<String> conditionField);

    Integer updateById(Ty instance, DaoAssembler assembler);

    Integer updateById(Ty instance);

    Integer updateByIds(Ty instance, Set<Integer> ids, DaoAssembler assembler);

    Integer updateByIds(Ty instance, Set<Integer> ids);
}
