package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Set;

public interface _InSelectDaoInterface<Ty extends AbstractBaseModel> {
    List<Ty> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes);

    List<Ty> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes);

    List<Ty> getByIndex(Set<String> selectFields, String inField, List indexes);
    List<Ty> getByIndex( String inField, List indexes);

    <TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem);
}

