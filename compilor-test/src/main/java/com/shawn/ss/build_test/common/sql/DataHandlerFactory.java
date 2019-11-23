package com.shawn.ss.build_test.common.sql;

import com.shawn.ss.gen.api.interfaces.SqlResp;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultResp;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultRespConf;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;

@DefaultResp
public interface DataHandlerFactory {
    @DefaultRespConf(dataSourceId = "ent_portal",db = "ent_portal",includeTables = {"t_user_info"})
    <Ty extends AbstractBaseModel,Tp>AbstractDao<Ty,Tp> getEntBaseDao(Class<Ty> modelClazz);
    @DefaultRespConf(dataSourceId = "ent_portal",db = "ent_portal",includeTables = {"t_user_info"})
    <Ty extends AbstractBaseModel,Tp>AbstractDao<Ty,Tp> getStsBaseDao(Class<Ty> modelClazz);


}
