package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Set;

public interface _InsertDaoInterface<Ty extends AbstractBaseModel> {
    Ty insert(Ty instance, DaoAssembler assembler);

    Ty insert(Ty instance);

    Integer insert(List<Ty> instances, Set<String> fields, DaoAssembler assembler);

    Integer insert(List<Ty> instances, Set<String> fields);

    Integer insert(List<Ty> instances);
}
