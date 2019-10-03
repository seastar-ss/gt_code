package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Set;

public interface _BaseSelectDaoInterface<Ty extends AbstractBaseModel> {
    List<Ty> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count);

    List<Ty> get(Set<String> selectFields, Integer start, Integer count);

    List<Ty> get(Set<String> selectFields);

    List<Ty> get();
}
