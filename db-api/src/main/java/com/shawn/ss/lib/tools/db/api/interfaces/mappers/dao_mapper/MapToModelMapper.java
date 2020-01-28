package com.shawn.ss.lib.tools.db.api.interfaces.mappers.dao_mapper;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.Map;

public interface MapToModelMapper<T extends AbstractBaseModel>  {
    T fromMap(Map<String, Object> src);
}
