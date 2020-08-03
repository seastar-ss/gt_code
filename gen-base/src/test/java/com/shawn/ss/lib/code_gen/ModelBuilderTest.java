package com.shawn.ss.lib.code_gen;

//import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.ModelBuilder;

//import com.shawn.ss.lib.code_gen.base.dao.conf.SelectMethodEnum;

import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
//import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoDaoConf;
//import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelRelatedTableDef;
import com.shawn.ss.lib.code_gen.model.gen_param_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelBuilderTest {
    static final Logger L = LoggerFactory.getLogger(ModelBuilderTest.class.getSimpleName());

    public static final String TEST_POS = "C:\\projects\\WorkSpace\\ent-portal-trunk-source\\cms-parent\\cms_jar\\src\\main\\java";
    //    public static final String TEST_WIKI_POS="C:\\projects\\WorkSpace\\ent-portal-trunk-source\\wiki-parent\\wiki_jar\\src\\main\\java";
    public static final String TEST_WIKI_POS = "C:\\projects\\newWorkSpace\\wiki-war\\wiki_jar\\src\\main\\java";


    public static final String TEST_LOG_POS = "C:\\projects\\newWorkSpace\\log-sdk-server\\log_service_jar\\src\\main\\java";

    public static final String TEST_LOG_POS_16BIT = "C:\\projects\\newWorkSpace\\log-sdk-server\\log_service_jar\\src\\main\\java";


    //    public static final String TEST_POS="D:\\project\\newProject\\cms-parent\\src\\main\\java";
    public static final String TEST_POS_DEV = "src/test_code_gen";
    public static final String TEST_POS_DEV_SAMPLE = "C:\\projects\\newWorkSpace\\user-sdk-parent\\user_service_jar\\src\\main\\java";
    public static final String TEST_POS_COMMON_ACTIVITY = "C:\\projects\\newWorkSpace\\common-activity\\activity-jar\\src\\main\\gen_code\\java";
//    public static final String TEST_POS_DEV="D:\\project\\newProject\\cms-parent\\src\\main\\java";

    //    @Test
    public void testGen16BitDbModel() {

//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper("data_store-16bit.properties",
//                "com.sundland.thor.new_dao",
//                "C:\\projects\\newWorkSpace\\sunland-thor\\src\\main\\java", "sunland");
//        modelBuilderContext.buildBaseModelAndDao();
//        modelBuilderContext.writeModel();
    }

    static List<SelectMethodEnum> list = CollectionHelper.<SelectMethodEnum>listBuilder()
            .add(SelectMethodEnum.getAll)
            .getList();
/**
    @Test
    public void testGenCommonActivity() {
//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper(
//                "data_store-ny.properties",
//                "com.sunland.activity",
//                TEST_WIKI_POS,
////                TEST_POS_COMMON_ACTIVITY,
//                "ent_activities", "ent_activities");
//
//        modelBuilderContext.buildBaseModelAndDao();
//
//        ModelMulDaoConf conf2 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("task")
//                .setMainTable("ac_tasks")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("TaskInfo")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "ac_user_link",
//                                        "linkTaskId",
//                                        "taskId",
//                                        false, true, "link"))
//                        .getList())//wiki_user
//                .setServiceClassName("TaskList");
//        conf2.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf2);
//
//        ModelMulDaoConf conf3 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("order")
//                .setMainTable("ac_user_order")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("OrderInfo")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "gd_goods",
//                                        "goodsId",
//                                        "orderGoodsId",
//                                        true, true, "goods"))
////                        .add(new ModelRelatedTableDef
////                                (
////                                        "wiki_page",
////                                        "pageId",
////                                        "IndexPageId",
////                                        true,true,"page"))
////                        .add(new ModelRelatedTableDef
////                                (
////                                        "wiki_page_statistic",
////                                        "cmsStatisticPId",
////                                        "indexId",
////                                        false,false,"statistic"))
////                        .add(new ModelRelatedTableDef
////                                (
////                                        "wiki_user",
////                                        "id",
////                                        "indexSubmitBy",
////                                        true,true,"user"))
//                        .getList())//wiki_user
//                .setServiceClassName("OrderList");
//        conf3.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf3);
//
//        ModelMulDaoConf conf4 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("task")
//                .setMainTable("ac_task_achevement")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("AchieveInfo")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "ac_user",
//                                        "id",
//                                        "achievedByUserId",
//                                        true, true, "user"))
//                        .getList())//wiki_user
//                .setServiceClassName("AcheivementList");
//        conf4.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf4);
//
//        ModelMulDaoConf conf5 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("user")
//                .setMainTable("ac_user")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("UserAllInfo")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "ac_user_account_info",
//                                        "uinfoUserId",
//                                        "id",
//                                        false, true, "userInfo"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "ac_user_addr",
//                                        "addrUserId",
//                                        "id",
//                                        false, false, "userAddr"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "ac_user_scores",
//                                        "rtUserId",
//                                        "id",
//                                        false, false, "userScore"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_activities",
//                                        "ac_user_statistic",
//                                        "acUserStatisticUId",
//                                        "id",
//                                        false, false, "statistic"))
//                        .getList())//wiki_user
//                .setServiceClassName("UserInfo");
//        conf5.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf5);

//        ModelMulDaoConf conf1 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("user")
//                .setMainTable("wiki_user")
//                .setMainModelSelectMethod("getById")
//                .setDtoClazzName("UserAndRole")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_account_info","uinfoUserId","id",false,false,"attrs"))
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_role","wikiUserId","id",false,true,"role"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_page_statistic","cmsStatisticPId","indexId",false,false,"statistic"))
//                        .getList())
//                .setServiceClassName("UserRoleQuery")
//                ;
//        conf1.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf1);
//
//        ModelMulDaoConf conf3 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("action")
//                .setMainTable("wiki_page_action_record")
//                .setMainModelSelectMethod("getByCondition")
//                .setDtoClazzName("ActionAndUser")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user","id","uarActionUserId",true,true,"user"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_page_statistic","cmsStatisticPId","indexId",false,false,"statistic"))
//                        .getList())
//                .setServiceClassName("UserActionQuery")
//                ;
//        conf3.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf3);
//
//        ModelMulDaoConf conf4 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("user")
//                .setMainTable("wiki_user")
//                .setMultiFieldFromSameTable(true)
//                .setMainModelSelectMethod("getOneByCondition")
//                .setDtoClazzName("UserAndRoleAndGp")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_account_info","uinfoUserId","id",false,false,"attrs"))
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_role","wikiUserId","id",false,true,"role"))
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_gp","id","gpInsId",false,true,"userIns"))
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_gp","id","gpFamilyId",false,true,"userFm"))
//                        .add(new ModelRelatedTableDef
//                                ("wiki_user_gp","id","gpGpId",false,true,"userGp"))
//                        .getList())
//                .setServiceClassName("UserGpQuery")
//                ;
//        conf4.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf4);
//        modelBuilderContext.writeModel();

//        ModelBuilderContext modelBuilderContext2 = ModelBuilderContext.builderHelper("data_store.properties",
//                "com.shangde.wiki_management", TEST_WIKI_POS, "ent_portal_users");
//
//        modelBuilderContext2.buildBaseModelAndDao();
//
//        ModelMulDaoConf conf5 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("rel")
//                .setMainTable("ent_cp_person_rel")
//                .setMainModelSelectMethod("getOneByCondition")
//                .setDtoClazzName("EntPortalUser")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_p_cp","id","person_id",true,true,"user"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_cp_group","id","group_id",true,true,"group"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_family","id","family_id",true,true,"family"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_college","id","college_id",true,true,"college"))
//                        .getList())//wiki_user
//                .setServiceClassName("UserQueryForPortalGroup")
//                ;
//        conf5.setBuilderContext(modelBuilderContext2);
//        modelBuilderContext2.buildMultiSelectDao(conf5);
//        modelBuilderContext2.writeModel();
    }

    @Test
    public void testGenActivityDbModel() {

//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper("db.properties",
//                "com.sunland.activity", TEST_POS_DEV, "common_activity");
//
//        modelBuilderContext.buildBaseModelAndDao();

//        ModelMulDaoConf conf2 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
////                .setBuilderContext(modelBuilderContext)
//                .setMainTable("ac_user_action_record")
//                .setMainModelSelectMethod("getByCondition")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef("ac_user","userId","uarActionUserId",true,""))
////                        .add(new ModelRelatedTableDef("t_content","id","contentId",true))
////                        .add(new ModelRelatedTableDef("t_dispatch_info","contentId","contentId",true))
//                        .getList())
//                .setServiceClassName("UserActivityQuery");
//        conf2.setBuilderContext(modelBuilderContext);
//        ModelMulDaoConf conf1 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setBuilderContext(modelBuilderContext)
//                .setMainTable("t_content")
//                .setMainModelSelectMethod("getByCondition")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef("t_content_attr","contentId","id",false))
////                        .add(new ModelRelatedTableDef("t_content","id","contentId",true))
//                        .add(new ModelRelatedTableDef("t_dispatch_info","contentId","id",true))
//                        .getList())
//                .setServiceClassName("SysContentQuery");
//        modelBuilderContext.buildMultiSelectDao(conf1);
//        modelBuilderContext.buildMultiSelectDao(conf2);

//        modelBuilderContext.buildSpecialModalAndDao(new SpecialModelConf().setMethodName("selectUndispatchedCount").putDefaultParam("",new Date().getTime())
//                .setSql("select sum(targetRdState) as sum from t_read_state as rd inner join " +
//                        "t_content as c on c.id=rd.contentId where c.content like concat('%',:c,'%') group by c.id").setListResult(false));

//        modelBuilderContext.writeModel();
    }

    //    @Test
    public void testGenLogCode() {
//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper("db.properties",
//                "com.shangde.log_service", TEST_LOG_POS, "ent_log");
//        modelBuilderContext.buildBaseModelAndDao();
//        modelBuilderContext.writeModel();
        //
    }

    //    @Test
    public void testGenUser() {
//        ModelBuilderContext modelBuilderContext2 = ModelBuilderContext.builderHelper("data_store-ny.properties",
//                "com.shangde.user_api", TEST_POS_DEV_SAMPLE, "ent_portal_tbs");
//        modelBuilderContext2.buildBaseModelAndDao();
//        modelBuilderContext2.writeModel();
    }

    @Test
    public void testGenWIKIDbModel() {

//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper(
//                "data_store-ny.properties",
//                "com.shangde.wiki_management",
////                TEST_WIKI_POS,
////                TEST_WIKI_POS,
//                TEST_POS_DEV,
//                "ent_knownleag_base");
//
//
//        modelBuilderContext.buildBaseModelAndDao();
//
//        ModelMulDaoConf conf7 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("page")
//                .setMainTable("wiki_page")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("PageInfoDetail")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
////                        .add(new ModelRelatedTableDef
////                                ("wiki_index_infos","cmsInfoOfIndexId","indexId",false,false,"attrs"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_page","pageId","IndexPageId",true,true,"page"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_page_statistic","cmsStatisticPId","indexId",false,false,"statistic"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user", "id", "pageSubmitBy", true, true, "user"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user_gp", "id", "pageSubmitByIns", false, true, "userIns"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user_gp", "id", "pageSubmitByFamily", false, true, "userFm"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user_gp", "id", "pageSubmitByGp", false, true, "userGp"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user_gp", "id", "pageSubmitByTopIns", false, true, "userTopIns"))
//
//                        .getList())//wiki_user
//                .setServiceClassName("PageInfoDetailQuery");
//        conf7.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf7);
//
//        ModelMulDaoConf conf2 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("indexs")
//                .setMainTable("wiki_index")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("WikiIndexWikiIndexInfossWikiPageWikiPageStatistics")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_index_infos", "cmsInfoOfIndexId", "indexId", false, false, "attrs"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_page", "pageId", "IndexPageId", true, true, "page"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_page_statistic", "cmsStatisticPId", "indexId", false, false, "statistic"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user", "id", "indexSubmitBy", true, true, "user"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_permission_grant", "grantWikiIndexId", "indexId", false, false, "permission"))
//                        .getList())//wiki_user
//                .setServiceClassName("UserContentQuery");
//        conf2.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf2);
//
//        ModelMulDaoConf conf1 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("user")
//                .setMainTable("wiki_user")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("UserAndRole")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user_account_info", "uinfoUserId", "id", false, false, "attrs"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user_role", "wikiUserId", "id", false, true, "role"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_page_statistic","cmsStatisticPId","indexId",false,false,"statistic"))
//                        .getList())
//                .setServiceClassName("UserRoleQuery");
//        conf1.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf1);
//
//        ModelMulDaoConf conf3 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("action")
//                .setMainTable("wiki_page_action_record")
//                .setMainModelSelectMethod(list)
//                .setDtoClazzName("ActionAndUser")
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_knownleag_base", "wiki_user", "id", "uarActionUserId", true, true, "user"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_page_statistic","cmsStatisticPId","indexId",false,false,"statistic"))
//                        .getList())
//                .setServiceClassName("UserActionQuery");
//        conf3.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf3);
//
////        ModelMulDaoConf conf4 = new ModelMulDaoConf()
////                .setBuildNotAbstract(true)
////                .setMainField("user")
////                .setMainTable("wiki_user")
////                .setMultiFieldFromSameTable(true)
////                .setMainModelSelectMethod("getOneByCondition")
////                .setDtoClazzName("UserAndRoleAndGp")
////                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
////                        .add(new ModelRelatedTableDef
////                                ("wiki_user_account_info","uinfoUserId","id",false,false,"attrs"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_user_role","wikiUserId","id",false,true,"role"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_user_gp","id","gpInsId",false,true,"userIns"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_user_gp","id","gpFamilyId",false,true,"userFm"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_user_gp","id","gpGpId",false,true,"userGp"))
////                        .add(new ModelRelatedTableDef
////                                ("wiki_user_gp","id","gpTopIns",false,true,"userTopIns"))
////
////                        .getList())
////                .setServiceClassName("UserGpQuery")
////                ;
////        conf4.setBuilderContext(modelBuilderContext);
////        modelBuilderContext.buildMultiSelectDao(conf4);
//        modelBuilderContext.writeModel();
//
////        ModelBuilderContext modelBuilderContext2 = ModelBuilderContext.builderHelper("data_store.properties",
////                "com.shangde.wiki_management", TEST_POS_DEV, "ent_portal_users");
////
////        modelBuilderContext2.buildBaseModelAndDao();
////
////        ModelMulDaoConf conf5 = new ModelMulDaoConf()
////                .setBuildNotAbstract(true)
////                .setMainField("rel")
////                .setMainTable("ent_cp_person_rel")
////                .setMainModelSelectMethod("getOneByCondition")
////                .setDtoClazzName("EntPortalUser")
////                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
////                        .add(new ModelRelatedTableDef
////                                ("ent_p_cp","id","person_id",true,true,"user"))
////                        .add(new ModelRelatedTableDef
////                                ("ent_cp_group","id","group_id",true,true,"group"))
////                        .add(new ModelRelatedTableDef
////                                ("ent_family","id","family_id",true,true,"family"))
////                        .add(new ModelRelatedTableDef
////                                ("ent_college","id","college_id",true,true,"college"))
////                        .getList())//wiki_user
////                .setServiceClassName("UserQueryForPortalGroup")
////                ;
////        conf5.setBuilderContext(modelBuilderContext2);
////        modelBuilderContext2.buildMultiSelectDao(conf5);
////        modelBuilderContext2.writeModel();
    }

    //    @Test
    public void testGenCMSDbModel() {

//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper(
//                "db.properties", "com.shangde.cms_management.logical", TEST_POS, "ent_cms");
//
//        modelBuilderContext.buildBaseModelAndDao();
//
//        ModelMulDaoConf conf2 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
//                .setMainField("read")
//                .setMainTable("t_read_state")
//                .setMainModelSelectMethod(list)
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef
//                                ("ent_cms", "t_content_attr", "contentId", "contentId", false, false, "attrs"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_cms", "t_content", "id", "contentId", false, true, "content"))
//                        .add(new ModelRelatedTableDef
//                                ("ent_cms", "t_dispatch_info", "contentId", "contentId", false, true, "dispatch"))
//                        .getList())
//                .setServiceClassName("UserContentQuery");
//
//        ModelMulDaoConf conf1 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
////                .setBuilderContext(modelBuilderContext)
//                .setMainTable("t_content")
//                .setMainModelSelectMethod(list)
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef("t_content_attr", "contentId", "id", false))
////                        .add(new ModelRelatedTableDef("t_content","id","contentId",true))
//                        .add(new ModelRelatedTableDef("t_dispatch_info", "contentId", "id", true))
//                        .getList())
//                .setServiceClassName("SysContentQuery");
//        conf1.setBuilderContext(modelBuilderContext);
//        conf2.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf1);
//        modelBuilderContext.buildMultiSelectDao(conf2);
//
////        modelBuilderContext.buildSpecialModalAndDao(new SpecialModelConf().setMethodName("selectUndispatchedCount").putDefaultParam("",new Date().getTime())
////                .setSql("select sum(targetRdState) as sum from t_read_state as rd inner join " +
////                        "t_content as c on c.id=rd.contentId where c.content like concat('%',:c,'%') group by c.id").setListResult(false));
//
//        modelBuilderContext.writeModel();
    }

    //    @Test
    public void testGenWWchatDbModel() throws IOException {
        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper("com.shangde.ent_portal.logical", TEST_POS_DEV);
        Properties p = new Properties();
        p.load(new FileReader("data_store-ny.properties"));
        DBConnectionHelper connection = modelBuilderContext.buildConnection("ent_activities",
//               "jdbc:mysql://127.0.0.1:4000/ent_portal?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true",
//               "root", "asdf12345", "com.mysql.jdbc.Driver"
                p.getProperty("ent_activities.jdbc.url"),
                p.getProperty("ent_activities.jdbc.username"),
                p.getProperty("ent_activities.jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb( connection,new DbModelConf().setDb("ent_knownleag_base"));
        modelBuilderContext.buildBaseModelAndDao();
        modelBuilderContext.writeModel();
    }
**/

    @Test
    public void testGenSqlDbModel() throws IOException {
        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper("com.shangde.ent_portal.logical", TEST_POS_DEV);
        Properties p = new Properties();
        p.load(new FileReader("db-ny.properties"));
//        p.load(new FileReader("data_store-ny.properties"));
        DBConnectionHelper connectionMaster = modelBuilderContext.buildConnection("ent_portal_slave",
//               "jdbc:mysql://127.0.0.1:4000/ent_portal?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true",
//               "root", "asdf12345", "com.mysql.jdbc.Driver"
                p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
//        modelBuilderContext.addConnctionAndDb("ent_portal", CodeHelper.KEY_WORD_DEFAULT_DATA_SOURCE_ID, p, false,
//                CollectionHelper.<String>setBuilder()
//                        .add("mlink_match_result")
//                        .add("t_mlink_url_info")
//                        .add("t_wechat_info")
//                        .add("t_user_info")
//                        .getSet(),
//                CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet());
        final Set<String> set = CollectionHelper.<String>setBuilder()
                .add("b_menu")
                .add("b_user")
                .add("b_role")
                .add("b_material")
                .add("b_orgnization_user")
                .getSet();
        modelBuilderContext.addDb(connectionMaster, new DbModelConf().setSlave(false)
                .setIncludingPattern(
                        set
                )
//                .setDefaultBaseDaoClass("com.nonexist.claswws.DAO")
//                .setBaseDaoClass(Collections.singletonMap("t_user_info","com.nonexist.class.DAOs"))
//                .setDefaultAssemblerClass("com.nonexist.clasews.Assemble")
//                .setBaseAssembleClass(Collections.singletonMap("t_user_info","com.nonexist.class.Assembles"))
                .setDb("new_main_schema")
                .setIgnoreTbPattern(CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()));
        DBConnectionHelper connection = modelBuilderContext.buildConnection("ent_portal_slave",
//               "jdbc:mysql://127.0.0.1:4000/ent_portal?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true",
//               "root", "asdf12345", "com.mysql.jdbc.Driver"
                p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb(connection, new DbModelConf().setSlave(true)
                .setIncludingPattern(
                        set
                )
                .setDb("new_main_schema")
                .setIgnoreTbPattern(CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()));
        DBConnectionHelper wikiconnection = modelBuilderContext.buildConnection("wiki_master",
//               "jdbc:mysql://127.0.0.1:4000/ent_knownleag_base?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true",
//               "root", "asdf12345", "com.mysql.jdbc.Driver"
                p.getProperty("ent_activities.jdbc.url"), p.getProperty("ent_activities.jdbc.username"),
                p.getProperty("ent_activities.jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb(wikiconnection, new DbModelConf().setSlave(false)
                        .setIncludingPattern(
                                CollectionHelper.<String>setBuilder()
                                        .add("t_device")
                                        .add("t_event")
                                        .add("t_task")
                                        .add("t_mall_area")
//                       .add("t_wechat_info")
//                       .add("t_user_info")
                                        .getSet()
                        ).setDb("robot_control_system")
                        .setIgnoreTbPattern(
                                CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()
                        )
        );
        modelBuilderContext.initBaseClazz();
        modelBuilderContext.buildBaseModelAndDao();
//        ModelMulDaoDaoConf wikiConf = new ModelMulDaoDaoConf("wikiConf").setMainTableDef(
//                new ModelRelatedTableDef().setFieldName("wikiIndex").setName("ent_knownleag_base.wiki_index")
//        )
////                        .setMainDb("ent_knownleag_base")
////                        .setMainTable("wiki_index")
////                        .setMainField("wikiIndex")
//                ;
//        wikiConf.setMainModelSelectMethod(
////                                CollectionHelper.<SelectMethodEnum>listBuilder()
////                                        .add(SelectMethodEnum.getOneById)
////                                        .add(SelectMethodEnum.getByCondition)
////                                        .add(SelectMethodEnum.getByIndexAndCondition)
////                                        .getList()
//                SelectMethodEnum.getNacessarySelectMethod().values().stream().<SelectMethodEnum>map((s) -> {
//                    return (SelectMethodEnum) s;
//                }).collect(Collectors.toList())
//        );
//        modelBuilderContext.buildMultiSelectDao(
//
//                wikiConf.setRelatedTables(
//                        CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                                .add(
//                                        new ModelRelatedTableDef()
//                                                .setFieldName("page")
//                                                .setName("ent_knownleag_base.wiki_page")
////                                                        .setDb("ent_knownleag_base")
////                                                        .setTable("wiki_page")
//                                                .setFieldInThisTable("pageId")
//                                                .setFieldInMainTable("IndexPageId")
//                                                .setSingle(false)
//
//                                )
//                                .add(
//                                        new ModelRelatedTableDef()
//                                                .setFieldName("item")
//                                                .setName("ent_knownleag_base.wiki_structure_info_key_item")
////                                                        .setDb("ent_knownleag_base")
////                                                        .setTable("wiki_structure_info_key_item")
//                                                .setFieldInThisTable("itemId")
//                                                .setFieldInMainTable("IndexPageId")
//                                                .setSingle(true)
//                                                .setAdditionalWhere("pageType in (2,5,6)")
//                                )
//                                .add(
//                                        new ModelRelatedTableDef()
//                                                .setFieldName("info")
//                                                .setName("ent_knownleag_base.wiki_index_infos")
////                                                        .setDb("ent_knownleag_base")
////                                                        .setTable("wiki_index_infos")
//                                                .setFieldInThisTable("cmsInfoOfIndexId")
//                                                .setFieldInMainTable("indexId")
//                                                .setSingle(false)
//                                                .setAdditionalCondition(Collections.singletonMap("indexTitle", "cmsInfoName"))
//                                )
//                                .getList()
//                )
//        );
//        modelBuilderContext.buildSpecialModalAndDao(new SpecialModelConf().setMethodName("sample").setClzName("com.test.sample.SampleSqlDAO")
//                .setSql("SELECT\n" +
//                        "\tDATE_FORMAT(mar.create_time, '%y-%m-%d') AS date,\n" +
//                        "\tmar.user_id AS userId,\n" +
//                        "\tmar.mobile AS mobile,\n" +
//                        "\treg_time AS regTime,\n" +
//                        "\tmui.config_user AS configUser\n" +
//                        "FROM\n" +
//                        "\tt_mlink_app_report mar\n" +
//                        "INNER JOIN t_mlink_url_info mui ON mar.mlink_id = mui.id\n" +
//                        "LEFT JOIN mlink_match_result mmr ON mmr.mobile = mar.mobile\n" +
//                        "AND mmr.is_related = 1\n" +
//                        "WHERE\n" +
//                        "\tmui.config_user IN ('chenlishan','lilin06','zhuoxiaohui','fanxuanfang','chentao06','liuxinrong','yuronghui','yuli','tanxianglian','linguohui','wujialin31','caiyongqin','zhoujiahua','panliting','hanchunkui','lailinyan')\n" +
//                        "AND mmr.mobile IS NULL\n" +
//                        "AND TO_DAYS(NOW()) - TO_DAYS(mar.create_time) = 1\n" +
//                        "GROUP BY\n" +
//                        "\tmar.user_id"));
        modelBuilderContext.writeModel();
    }

    //    @Test
    public void testGenDbModelDev() {
//        DBConnection c = new DBConnection("data_store.properties");
//        Map<String, TableDef> defss=CollectionBuilder.newHashMap();
//        DbAnalyzer anl = new DbAnalyzer();
//        DbInfo dbInfo = new DbInfo("ent_cms");
//        ModelBuilderContext.init("data_store.properties","com.shangde.student.course",TEST_POS_DEV);
//        ModelBuilderContext.analyzeDb(dbInfo);
////        anl.buildModel(c.conn,  dbInfo);
//        ModelBuilderContext.buildBaseModelAndDao(dbInfo);
//        ModelBuilderContext.buildMultiSelectDao(dbInfo,"TeacherList","teacher","getByIds",
//                CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef("course","teacherId","id"))
//                        .getList(),
//                true
//                );

//        ModelBuilderContext modelBuilderContext = ModelBuilderContext.builderHelper(
//                "db.properties", "com.shangde.web_activity.logical", TEST_POS_DEV, "ent_cms");
//
//        modelBuilderContext.buildBaseModelAndDao();
//        ModelMulDaoConf conf = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
////                .setBuilderContext(modelBuilderContext)
//                .setMainTable("t_content")
//                .setMainModelSelectMethod(list)
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef("ent_cms", "t_content_attr", "contentId", "id", false, false, "attrs"))
//                        .add(new ModelRelatedTableDef("ent_cms", "t_read_state", "contentId", "id", false, true, "read"))
//                        .add(new ModelRelatedTableDef("ent_cms", "t_dispatch_info", "contentId", "id", false, true, "dispatch"))
//                        .getList())
//                .setServiceClassName("Read");
//        conf.setBuilderContext(modelBuilderContext);
//
//        modelBuilderContext.buildMultiSelectDao(conf);
//        ModelMulDaoConf conf2 = new ModelMulDaoConf()
//                .setBuildNotAbstract(true)
////                .setBuilderContext(modelBuilderContext)
//                .setMainTable("t_read_state")
//                .setMainModelSelectMethod(list)
//                .setRelatedTables(CollectionHelper.<ModelRelatedTableDef>listBuilder()
//                        .add(new ModelRelatedTableDef("ent_cms", "t_content_attr", "contentId", "contentId", false, false, "attr"))
//                        .add(new ModelRelatedTableDef("ent_cms", "t_content", "id", "contentId", true, true, "content"))
//                        .add(new ModelRelatedTableDef("ent_cms", "t_dispatch_info", "contentId", "contentId", false, true, "dispatch"))
//                        .getList())
//                .setServiceClassName("Content");
//        conf2.setBuilderContext(modelBuilderContext);
//        modelBuilderContext.buildMultiSelectDao(conf2);
//        SpecialModelConf specialModelDef = new SpecialModelConf().setMethodName("test").putDefaultParam("id", 1)
//                .setSql("select contentId,c.content,c.createTime,count(*) as count,sum(targetRdState) as sum from t_read_state as rd inner join " +
//                        "t_content as c on c.id=rd.contentId where c.id=:id group by c.id").setListResult(true).setBaseTable("t_content").setDataSourceName("spcialResource");
////        specialModelDef.setBaseTable("t_content");
////        specialModelDef.setDataSourceName("spcialResource");
//        modelBuilderContext.buildSpecialModalAndDao(specialModelDef);
//        SpecialModelConf specialModelDef1 = new SpecialModelConf().setMethodName("testSingle").putDefaultParam("c", "abc")
//                .setSql("select sum(targetRdState) as sum from t_read_state as rd inner join " +
//                        "t_content as c on c.id=rd.contentId where c.content like concat('%',:c,'%') group by c.id").setListResult(true);
//        specialModelDef1.setDataSourceName("spcialResource");
//        modelBuilderContext.buildSpecialModalAndDao(specialModelDef1);
//        modelBuilderContext.writeModel();
    }

    //    @Test
    public void testAnalyze() {
//        DbInfo dbInfo = new DbInfo("hackathon");
//        ModelBuilderContext.init("data_store.properties","com.shangde.student.course",TEST_POS_DEV);
//        ModelBuilderContext.analyzeDb(dbInfo);
//        L.info("data_store analyzed,table count:{}",dbInfo.size());
    }

    //    @Test
    public void testGenModel() {
//        JCodeModel cm=new JCodeModel();
//        ModelBuilder builder=new ModelBuilder(new MockTableInfo(),cm,);
//        builder.buildModel();
//        MapperOfResultSetBuilder rsMapperBuilder=new MapperOfResultSetBuilder(builder);
//        rsMapperBuilder.buildModel();
//        MapperOfMapBuilder redisMapperBuilder=new MapperOfMapBuilder(builder);
//        redisMapperBuilder.buildModel();
//
//        try {
//            File file = new File(TEST_POS_DEV);
//            if(file.exists() || file.mkdirs()) {
//                L.info("code will in folder:{}", file.getAbsolutePath());
//                cm.build(file);
//            }else{
//                L.info("can't buildBaseModelAndDao folder:{}", file.getAbsolutePath());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    class MockTableInfo implements TableInfoInterface {
//
//        @Override
//        public String getTable() {
//            return "sample";
//        }
//
//        @Override
//        public String getDb() {
//            return "test_db";
//        }
//
//        @Override
//        public String[] getTableColumnNames() {
//            return new String[0];
//        }
//
//        @Override
//        public String getPriKey() {
//            return "id";
//        }
//
//        @Override
//        public FieldDataTypeInterface getPriKeyType() {
//            return ColumnDataType.longData;
//        }
//
//        @Override
//        public List<ColumnInfoInterface> getColumns() {
//            return CollectionHelper.<ColumnInfoInterface>listBuilder()
//                    .add(new MockColumnInfo("userId", ColumnDataType.intData, "用户id"))
//                    .add(new MockColumnInfo("channel", ColumnDataType.stringData, "登录渠道"))
//
//                    .getList();
//        }
//
//        @Override
//        public TableInfo getTableInfo() {
//            return null;
//        }
//
//        @Override
//        public List<IndexInfo> getIndexes() {
//            return null;
//        }
//
//        @Override
//        public List<TableReferInfo> getReferFromTable() {
//            return null;
//        }
//
//        @Override
//        public List<TableReferInfo> getReferToTable() {
//            return null;
//        }
//
//        @Override
//        public FieldDataTypeInterface getColumnDataType(String s) {
//            return null;
//        }
//
//        @Override
//        public ColumnInfoInterface getColumnData(String s) {
//            return null;
//        }
//
//        @Override
//        public int getTableType() {
//            return 0;
//        }
//
//        @Override
//        public String getTableComment() {
//            return "测试数据库";
//        }
//
//        @Override
//        public String getCharset() {
//            return null;
//        }
//
//        @Override
//        public int getColumnCount() {
//            return 0;
//        }
//
//        private class MockColumnInfo implements ColumnInfoInterface {
//
//            String colName;
//            FieldDataTypeInterface dataType;
//            String comment;
//
//            public MockColumnInfo(String colName, FieldDataTypeInterface dataType, String comment) {
//                this.colName = colName;
//                this.dataType = dataType;
//                this.comment = comment;
//            }
//
//            @Override
//            public String getFieldName() {
//                return colName;
//            }
//
//            @Override
//            public FieldDataTypeInterface getType() {
//                return dataType;
//            }
//
//            @Override
//            public String getComment() {
//                return comment;
//            }
//
//            @Override
//            public String getDefaultValue() {
//                return null;
//            }
//
//            @Override
//            public String getExtra() {
//                return null;
//            }
//
//            @Override
//            public boolean isNullable() {
//                return false;
//            }
//
//            @Override
//            public boolean isPrime() {
//                return false;
//            }
//
//            @Override
//            public boolean isUnique() {
//                return false;
//            }
//
//            @Override
//            public boolean isReferer() {
//                return false;
//            }
//
//            @Override
//            public boolean isIndexed() {
//                return false;
//            }
//
//            @Override
//            public boolean isAutoIncreament() {
//                return false;
//            }
//
//            @Override
//            public String getCharSet() {
//                return null;
//            }
//
//            @Override
//            public long getCharLength() {
//                return 0;
//            }
//
//            @Override
//            public int getPrecision() {
//                return 0;
//            }
//
//            @Override
//            public Properties getExtraInfo() {
//                return null;
//            }
//
//            @Override
//            public TableInfo getInfo() {
//                return null;
//            }
//
//            @Override
//            public EnumTypeDef getEnumTypeDef() {
//                return null;
//            }
//        }
//    }


}
