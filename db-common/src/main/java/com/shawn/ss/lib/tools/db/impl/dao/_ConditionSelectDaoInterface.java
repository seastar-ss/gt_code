package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;

import java.util.List;
import java.util.Set;

public interface _ConditionSelectDaoInterface<Ty extends AbstractBaseModel> {

    Ty getOneByCond(Set<String> selectFields, DaoAssembler assembler, Ty instance);

    Ty getOneByCond(Set<String> selectFields, Ty instance);

    List<Ty> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance);

    List<Ty> getByCond(Set<String> selectFields, Integer start, Integer count, Ty instance);

    List<Ty> getByCond(Set<String> selectFields, Ty instance);
    List<Ty> getByCond( Ty instance);

    Long getCountByCond(DaoAssembler assembler, Ty instance);

    Long getCountByCond(Ty instance);

    <TT> TT getItemByCond(DaoAssembler assembler, Ty instance, Class<TT> tClass, String rawItem);

    <TT extends Object> TT getItemByCond(Ty instance, Class<TT> tClass, String rawItem);
}
