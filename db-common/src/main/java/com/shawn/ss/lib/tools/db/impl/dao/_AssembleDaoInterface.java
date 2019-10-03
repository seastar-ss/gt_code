package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.List;
import java.util.Map;

public interface _AssembleDaoInterface<Ty extends AbstractBaseModel> {
    <TT> Map<TT, Ty> buildMap(List<Ty> list, String field);

    <TT> Map<TT, List<Ty>> buildListMap(List<Ty> list, String field);

    <TT> List<TT> extractItemAsList(List<Ty> list, String field);
}
