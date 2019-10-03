package com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

public interface ModelToModelMapper<T1 extends AbstractBaseModel,T2 extends AbstractBaseModel> {
    T2 toMap(T1 model);
}
