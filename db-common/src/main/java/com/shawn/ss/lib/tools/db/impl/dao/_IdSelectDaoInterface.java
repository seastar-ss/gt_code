package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Set;

public interface _IdSelectDaoInterface<Ty extends AbstractBaseModel, Tt> {
    Ty getOneById(Set<String> selectFields, DaoAssembler assembler, Tt id);

    Ty getOneById(Set<String> selectFields, Tt id);

    Ty getOneById(Tt id);

    List<Ty> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Tt> id);

    List<Ty> getById(Set<String> selectFields, Integer start, Integer count, List<Tt> id);

    List<Ty> getById(Set<String> selectFields, List<Tt> id);

    List<Ty> getById(List<Tt> id);
}
