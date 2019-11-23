package com.shawn.ss.build_test.common.sql;


import com.shawn.ss.gen.api.interfaces.SqlResp;
import com.shawn.ss.gen.api.interfaces.SqlRespParam;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.List;

/**
 * Created by ss on 2018/6/16.
 */

public interface DaoCodeGen {

    @SqlResp(
            sql="SELECT count(*) as insCount,gpInsId FROM ent_knownleag_base.wiki_user " +
                    "where wUserState=:state and gpBaseAuth>:auth  group by gpInsId",
            dataSourceId = "ent_knownleag_base"
    )
    <T extends AbstractBaseModel> List<T> queryAllCount(
            @SqlRespParam(defaultValue = "0") Integer state,
            @SqlRespParam(defaultValue = "255") Integer auth);
//
//    @SqlResp(dataSourceId = "ent_knownleag_base",
//            sql="select *,(select count(*) from wiki_page p where p.pageIndex=i.indexId) as pageCount " +
//                    "from wiki_index i where indexId in (:ids)")
//    <T extends AbstractBaseModel> T queryWikiIndex(@SqlRespParam(defaultValues = {"1"}) Integer[] ids);
//
//    @SqlResp(dataSourceId = "ent_knownleag_base",
//            sql="select *,(select count(*) from wiki_page p where p.pageIndex=i.indexId) as pageCount " +
//                    "from wiki_index i where indexId in (:ids)")
//    <T extends AbstractBaseModel> T queryWikiIndexList(@SqlRespParam(defaultValues = {"1"}) List<Integer> ids);

//    @SqlResp(dataSourceId = "ent_portal",
//            sql="select *,substring(mobile,0,3) as mobilePrefix from t_user_info where mobile=:info.mobile and status=:info.status")
//    <T extends ModelTUserInfo> T queryByObject(@SqlRespParam ModelTUserInfo info);

}
