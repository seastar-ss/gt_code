/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers._ObjMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :t_mlink_url_info
 * 	mlink二期 -  url 参数记录表
 */
public class ModelTMlinkUrlInfo
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_mlink_url_info";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.t_mlink_url_info.id 字段
     * 自增主键
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.t_mlink_url_info.site_id 字段
     * 站点id
     */
    String siteId;
    public final static String FI_SITE_ID = "site_id";
    /**
     * 对应数据库.t_mlink_url_info.config_user 字段
     * 配置人
     */
    String configUser;
    public final static String FI_CONFIG_USER = "config_user";
    /**
     * 对应数据库.t_mlink_url_info.scene 字段
     * 场景
     */
    String scene;
    public final static String FI_SCENE = "scene";
    /**
     * 对应数据库.t_mlink_url_info.division 字段
     * 事业部
     */
    String division;
    public final static String FI_DIVISION = "division";
    /**
     * 对应数据库.t_mlink_url_info.legion 字段
     * 军团
     */
    String legion;
    public final static String FI_LEGION = "legion";
    /**
     * 对应数据库.t_mlink_url_info.channel 字段
     * 渠道
     */
    String channel;
    public final static String FI_CHANNEL = "channel";
    /**
     * 对应数据库.t_mlink_url_info.activity_name 字段
     * 活动名称
     */
    String activityName;
    public final static String FI_ACTIVITY_NAME = "activity_name";
    /**
     * 对应数据库.t_mlink_url_info.plan_id 字段
     * 计划id
     */
    String planId;
    public final static String FI_PLAN_ID = "plan_id";
    /**
     * 对应数据库.t_mlink_url_info.reserve_param1 字段
     * 预留参数
     */
    String reserveParam1;
    public final static String FI_RESERVE_PARAM1 = "reserve_param1";
    /**
     * 对应数据库.t_mlink_url_info.reserve_param2 字段
     * 预留参数
     */
    String reserveParam2;
    public final static String FI_RESERVE_PARAM2 = "reserve_param2";
    /**
     * 对应数据库.t_mlink_url_info.reserve_param3 字段
     * 预留参数
     */
    String reserveParam3;
    public final static String FI_RESERVE_PARAM3 = "reserve_param3";
    /**
     * 对应数据库.t_mlink_url_info.reserve_param4 字段
     * 预留参数
     */
    String reserveParam4;
    public final static String FI_RESERVE_PARAM4 = "reserve_param4";
    /**
     * 对应数据库.t_mlink_url_info.reserve_param5 字段
     * 预留参数
     */
    String reserveParam5;
    public final static String FI_RESERVE_PARAM5 = "reserve_param5";
    /**
     * 对应数据库.t_mlink_url_info.reserve_param6 字段
     * 预留参数
     */
    String reserveParam6;
    public final static String FI_RESERVE_PARAM6 = "reserve_param6";
    /**
     * 对应数据库.t_mlink_url_info.page_detail 字段
     * 落地页
     */
    String pageDetail;
    public final static String FI_PAGE_DETAIL = "page_detail";
    /**
     * 对应数据库.t_mlink_url_info.video_type 字段
     * 视频类型
     */
    String videoType;
    public final static String FI_VIDEO_TYPE = "video_type";
    /**
     * 对应数据库.t_mlink_url_info.param 字段
     * 页面需要参数
     */
    String param;
    public final static String FI_PARAM = "param";
    /**
     * 对应数据库.t_mlink_url_info.video_url 字段
     * 视频链接
     */
    String videoUrl;
    public final static String FI_VIDEO_URL = "video_url";
    /**
     * 对应数据库.t_mlink_url_info.update_time 字段
     * 更新事件
     */
    Date updateTime;
    public final static String FI_UPDATE_TIME = "update_time";
    /**
     * 对应数据库.t_mlink_url_info.create_time 字段
     * 创建时间
     */
    Date createTime;
    public final static String FI_CREATE_TIME = "create_time";
    /**
     * 对应数据库.t_mlink_url_info.site_flag 字段
     * 控制站点是否分配，0分配1不分配
     */
    Integer siteFlag;
    public final static String FI_SITE_FLAG = "site_flag";
    /**
     * 对应数据库.t_mlink_url_info.system 字段
     * 系统
     */
    String system;
    public final static String FI_SYSTEM = "system";
    /**
     * 对应数据库.t_mlink_url_info.delete_flag 字段
     * 删除表示，0未删除，1已删除
     */
    Integer deleteFlag;
    public final static String FI_DELETE_FLAG = "delete_flag";
    /**
     * 对应数据库.t_mlink_url_info.encrypted_params 字段
     * 加密字符串，分隔
     */
    String encryptedParams;
    public final static String FI_ENCRYPTED_PARAMS = "encrypted_params";
    /**
     * 对应数据库.t_mlink_url_info.unique_identifier 字段
     * 唯一标识
     */
    String uniqueIdentifier;
    public final static String FI_UNIQUE_IDENTIFIER = "unique_identifier";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTMlinkUrlInfo.FI_ID, Integer.class).put(ModelTMlinkUrlInfo.FI_SITE_ID, String.class).put(ModelTMlinkUrlInfo.FI_CONFIG_USER, String.class).put(ModelTMlinkUrlInfo.FI_SCENE, String.class).put(ModelTMlinkUrlInfo.FI_DIVISION, String.class).put(ModelTMlinkUrlInfo.FI_LEGION, String.class).put(ModelTMlinkUrlInfo.FI_CHANNEL, String.class).put(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, String.class).put(ModelTMlinkUrlInfo.FI_PLAN_ID, String.class).put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, String.class).put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, String.class).put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, String.class).put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, String.class).put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, String.class).put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, String.class).put(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, String.class).put(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, String.class).put(ModelTMlinkUrlInfo.FI_PARAM, String.class).put(ModelTMlinkUrlInfo.FI_VIDEO_URL, String.class).put(ModelTMlinkUrlInfo.FI_UPDATE_TIME, Date.class).put(ModelTMlinkUrlInfo.FI_CREATE_TIME, Date.class).put(ModelTMlinkUrlInfo.FI_SITE_FLAG, Integer.class).put(ModelTMlinkUrlInfo.FI_SYSTEM, String.class).put(ModelTMlinkUrlInfo.FI_DELETE_FLAG, Integer.class).put(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, String.class).put(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, String.class).getMap();
    public final static Integer FIELD_COUNT = 26;
    public final static ResultSetMapperModelTMlinkUrlInfo<ModelTMlinkUrlInfo> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelTMlinkUrlInfo<com.shangde.ent_portal.logical.dto.basepo.ModelTMlinkUrlInfo>();
    public final static ByteMapMapperModelTMlinkUrlInfo MAP_OBJ_MAPPER = new ByteMapMapperModelTMlinkUrlInfo();

    public ModelTMlinkUrlInfo() {
    }

    public Integer getId() {
        return id;
    }

    public ModelTMlinkUrlInfo setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getSiteId() {
        return siteId;
    }

    public ModelTMlinkUrlInfo setSiteId(String lSiteId) {
        siteId = lSiteId;
        return this;
    }

    public String getConfigUser() {
        return configUser;
    }

    public ModelTMlinkUrlInfo setConfigUser(String lConfigUser) {
        configUser = lConfigUser;
        return this;
    }

    public String getScene() {
        return scene;
    }

    public ModelTMlinkUrlInfo setScene(String lScene) {
        scene = lScene;
        return this;
    }

    public String getDivision() {
        return division;
    }

    public ModelTMlinkUrlInfo setDivision(String lDivision) {
        division = lDivision;
        return this;
    }

    public String getLegion() {
        return legion;
    }

    public ModelTMlinkUrlInfo setLegion(String lLegion) {
        legion = lLegion;
        return this;
    }

    public String getChannel() {
        return channel;
    }

    public ModelTMlinkUrlInfo setChannel(String lChannel) {
        channel = lChannel;
        return this;
    }

    public String getActivityName() {
        return activityName;
    }

    public ModelTMlinkUrlInfo setActivityName(String lActivityName) {
        activityName = lActivityName;
        return this;
    }

    public String getPlanId() {
        return planId;
    }

    public ModelTMlinkUrlInfo setPlanId(String lPlanId) {
        planId = lPlanId;
        return this;
    }

    public String getReserveParam1() {
        return reserveParam1;
    }

    public ModelTMlinkUrlInfo setReserveParam1(String lReserveParam1) {
        reserveParam1 = lReserveParam1;
        return this;
    }

    public String getReserveParam2() {
        return reserveParam2;
    }

    public ModelTMlinkUrlInfo setReserveParam2(String lReserveParam2) {
        reserveParam2 = lReserveParam2;
        return this;
    }

    public String getReserveParam3() {
        return reserveParam3;
    }

    public ModelTMlinkUrlInfo setReserveParam3(String lReserveParam3) {
        reserveParam3 = lReserveParam3;
        return this;
    }

    public String getReserveParam4() {
        return reserveParam4;
    }

    public ModelTMlinkUrlInfo setReserveParam4(String lReserveParam4) {
        reserveParam4 = lReserveParam4;
        return this;
    }

    public String getReserveParam5() {
        return reserveParam5;
    }

    public ModelTMlinkUrlInfo setReserveParam5(String lReserveParam5) {
        reserveParam5 = lReserveParam5;
        return this;
    }

    public String getReserveParam6() {
        return reserveParam6;
    }

    public ModelTMlinkUrlInfo setReserveParam6(String lReserveParam6) {
        reserveParam6 = lReserveParam6;
        return this;
    }

    public String getPageDetail() {
        return pageDetail;
    }

    public ModelTMlinkUrlInfo setPageDetail(String lPageDetail) {
        pageDetail = lPageDetail;
        return this;
    }

    public String getVideoType() {
        return videoType;
    }

    public ModelTMlinkUrlInfo setVideoType(String lVideoType) {
        videoType = lVideoType;
        return this;
    }

    public String getParam() {
        return param;
    }

    public ModelTMlinkUrlInfo setParam(String lParam) {
        param = lParam;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ModelTMlinkUrlInfo setVideoUrl(String lVideoUrl) {
        videoUrl = lVideoUrl;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ModelTMlinkUrlInfo setUpdateTime(Date lUpdateTime) {
        updateTime = lUpdateTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ModelTMlinkUrlInfo setCreateTime(Date lCreateTime) {
        createTime = lCreateTime;
        return this;
    }

    public Integer getSiteFlag() {
        return siteFlag;
    }

    public ModelTMlinkUrlInfo setSiteFlag(Integer lSiteFlag) {
        siteFlag = lSiteFlag;
        return this;
    }

    public String getSystem() {
        return system;
    }

    public ModelTMlinkUrlInfo setSystem(String lSystem) {
        system = lSystem;
        return this;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public ModelTMlinkUrlInfo setDeleteFlag(Integer lDeleteFlag) {
        deleteFlag = lDeleteFlag;
        return this;
    }

    public String getEncryptedParams() {
        return encryptedParams;
    }

    public ModelTMlinkUrlInfo setEncryptedParams(String lEncryptedParams) {
        encryptedParams = lEncryptedParams;
        return this;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public ModelTMlinkUrlInfo setUniqueIdentifier(String lUniqueIdentifier) {
        uniqueIdentifier = lUniqueIdentifier;
        return this;
    }

    @Override
    public Map<String, Object> getFieldConfig() {
        return FIELD_CLASS;
    }

    public boolean isEmpty() {
        if (!super.isEmpty()) {
            return false;
        }
        if (getId()!= null) {
            return false;
        }
        if (getSiteId()!= null) {
            return false;
        }
        if (getConfigUser()!= null) {
            return false;
        }
        if (getScene()!= null) {
            return false;
        }
        if (getDivision()!= null) {
            return false;
        }
        if (getLegion()!= null) {
            return false;
        }
        if (getChannel()!= null) {
            return false;
        }
        if (getActivityName()!= null) {
            return false;
        }
        if (getPlanId()!= null) {
            return false;
        }
        if (getReserveParam1()!= null) {
            return false;
        }
        if (getReserveParam2()!= null) {
            return false;
        }
        if (getReserveParam3()!= null) {
            return false;
        }
        if (getReserveParam4()!= null) {
            return false;
        }
        if (getReserveParam5()!= null) {
            return false;
        }
        if (getReserveParam6()!= null) {
            return false;
        }
        if (getPageDetail()!= null) {
            return false;
        }
        if (getVideoType()!= null) {
            return false;
        }
        if (getParam()!= null) {
            return false;
        }
        if (getVideoUrl()!= null) {
            return false;
        }
        if (getUpdateTime()!= null) {
            return false;
        }
        if (getCreateTime()!= null) {
            return false;
        }
        if (getSiteFlag()!= null) {
            return false;
        }
        if (getSystem()!= null) {
            return false;
        }
        if (getDeleteFlag()!= null) {
            return false;
        }
        if (getEncryptedParams()!= null) {
            return false;
        }
        if (getUniqueIdentifier()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTMlinkUrlInfo.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTMlinkUrlInfo.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("siteId").append(":").append(siteId).append("}\n");
        ret.append("{").append("configUser").append(":").append(configUser).append("}\n");
        ret.append("{").append("scene").append(":").append(scene).append("}\n");
        ret.append("{").append("division").append(":").append(division).append("}\n");
        ret.append("{").append("legion").append(":").append(legion).append("}\n");
        ret.append("{").append("channel").append(":").append(channel).append("}\n");
        ret.append("{").append("activityName").append(":").append(activityName).append("}\n");
        ret.append("{").append("planId").append(":").append(planId).append("}\n");
        ret.append("{").append("reserveParam1").append(":").append(reserveParam1).append("}\n");
        ret.append("{").append("reserveParam2").append(":").append(reserveParam2).append("}\n");
        ret.append("{").append("reserveParam3").append(":").append(reserveParam3).append("}\n");
        ret.append("{").append("reserveParam4").append(":").append(reserveParam4).append("}\n");
        ret.append("{").append("reserveParam5").append(":").append(reserveParam5).append("}\n");
        ret.append("{").append("reserveParam6").append(":").append(reserveParam6).append("}\n");
        ret.append("{").append("pageDetail").append(":").append(pageDetail).append("}\n");
        ret.append("{").append("videoType").append(":").append(videoType).append("}\n");
        ret.append("{").append("param").append(":").append(param).append("}\n");
        ret.append("{").append("videoUrl").append(":").append(videoUrl).append("}\n");
        ret.append("{").append("updateTime").append(":").append(updateTime).append("}\n");
        ret.append("{").append("createTime").append(":").append(createTime).append("}\n");
        ret.append("{").append("siteFlag").append(":").append(siteFlag).append("}\n");
        ret.append("{").append("system").append(":").append(system).append("}\n");
        ret.append("{").append("deleteFlag").append(":").append(deleteFlag).append("}\n");
        ret.append("{").append("encryptedParams").append(":").append(encryptedParams).append("}\n");
        ret.append("{").append("uniqueIdentifier").append(":").append(uniqueIdentifier).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelTMlinkUrlInfo
        implements RedisMapMapper<ModelTMlinkUrlInfo>
    {

        @Override
        public ModelTMlinkUrlInfo fromMap(Map<byte[], byte[]> map) {
            ModelTMlinkUrlInfo instance = new ModelTMlinkUrlInfo();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTMlinkUrlInfo.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTMlinkUrlInfo.FI_SITE_ID)) {
                        instance.setSiteId(mapToFieldSiteId(entry.getValue()));
                    } else {
                        if (field.equals(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
                            instance.setConfigUser(mapToFieldConfigUser(entry.getValue()));
                        } else {
                            if (field.equals(ModelTMlinkUrlInfo.FI_SCENE)) {
                                instance.setScene(mapToFieldScene(entry.getValue()));
                            } else {
                                if (field.equals(ModelTMlinkUrlInfo.FI_DIVISION)) {
                                    instance.setDivision(mapToFieldDivision(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTMlinkUrlInfo.FI_LEGION)) {
                                        instance.setLegion(mapToFieldLegion(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTMlinkUrlInfo.FI_CHANNEL)) {
                                            instance.setChannel(mapToFieldChannel(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
                                                instance.setActivityName(mapToFieldActivityName(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
                                                    instance.setPlanId(mapToFieldPlanId(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
                                                        instance.setReserveParam1(mapToFieldReserveParam1(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
                                                            instance.setReserveParam2(mapToFieldReserveParam2(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
                                                                instance.setReserveParam3(mapToFieldReserveParam3(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
                                                                    instance.setReserveParam4(mapToFieldReserveParam4(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
                                                                        instance.setReserveParam5(mapToFieldReserveParam5(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
                                                                            instance.setReserveParam6(mapToFieldReserveParam6(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
                                                                                instance.setPageDetail(mapToFieldPageDetail(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
                                                                                    instance.setVideoType(mapToFieldVideoType(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_PARAM)) {
                                                                                        instance.setParam(mapToFieldParam(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
                                                                                            instance.setVideoUrl(mapToFieldVideoUrl(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
                                                                                                instance.setUpdateTime(mapToFieldUpdateTime(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
                                                                                                    instance.setCreateTime(mapToFieldCreateTime(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
                                                                                                        instance.setSiteFlag(mapToFieldSiteFlag(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_SYSTEM)) {
                                                                                                            instance.setSystem(mapToFieldSystem(entry.getValue()));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
                                                                                                                instance.setDeleteFlag(mapToFieldDeleteFlag(entry.getValue()));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
                                                                                                                    instance.setEncryptedParams(mapToFieldEncryptedParams(entry.getValue()));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
                                                                                                                        instance.setUniqueIdentifier(mapToFieldUniqueIdentifier(entry.getValue()));
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return instance;
        }

        protected Integer mapToFieldId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldSiteId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldConfigUser(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldScene(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldDivision(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldLegion(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldChannel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldActivityName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPlanId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldReserveParam1(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldReserveParam2(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldReserveParam3(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldReserveParam4(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldReserveParam5(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldReserveParam6(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPageDetail(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldVideoType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldParam(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldVideoUrl(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldUpdateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Date mapToFieldCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Integer mapToFieldSiteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldSystem(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldEncryptedParams(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUniqueIdentifier(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTMlinkUrlInfo instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTMlinkUrlInfo.FI_ID.getBytes(), valueId);
            byte[] valueSite_id = mapFromFieldSiteId(instance.getSiteId());
            ret.put(ModelTMlinkUrlInfo.FI_SITE_ID.getBytes(), valueSite_id);
            byte[] valueConfig_user = mapFromFieldConfigUser(instance.getConfigUser());
            ret.put(ModelTMlinkUrlInfo.FI_CONFIG_USER.getBytes(), valueConfig_user);
            byte[] valueScene = mapFromFieldScene(instance.getScene());
            ret.put(ModelTMlinkUrlInfo.FI_SCENE.getBytes(), valueScene);
            byte[] valueDivision = mapFromFieldDivision(instance.getDivision());
            ret.put(ModelTMlinkUrlInfo.FI_DIVISION.getBytes(), valueDivision);
            byte[] valueLegion = mapFromFieldLegion(instance.getLegion());
            ret.put(ModelTMlinkUrlInfo.FI_LEGION.getBytes(), valueLegion);
            byte[] valueChannel = mapFromFieldChannel(instance.getChannel());
            ret.put(ModelTMlinkUrlInfo.FI_CHANNEL.getBytes(), valueChannel);
            byte[] valueActivity_name = mapFromFieldActivityName(instance.getActivityName());
            ret.put(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME.getBytes(), valueActivity_name);
            byte[] valuePlan_id = mapFromFieldPlanId(instance.getPlanId());
            ret.put(ModelTMlinkUrlInfo.FI_PLAN_ID.getBytes(), valuePlan_id);
            byte[] valueReserve_param1 = mapFromFieldReserveParam1(instance.getReserveParam1());
            ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1 .getBytes(), valueReserve_param1);
            byte[] valueReserve_param2 = mapFromFieldReserveParam2(instance.getReserveParam2());
            ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2 .getBytes(), valueReserve_param2);
            byte[] valueReserve_param3 = mapFromFieldReserveParam3(instance.getReserveParam3());
            ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3 .getBytes(), valueReserve_param3);
            byte[] valueReserve_param4 = mapFromFieldReserveParam4(instance.getReserveParam4());
            ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4 .getBytes(), valueReserve_param4);
            byte[] valueReserve_param5 = mapFromFieldReserveParam5(instance.getReserveParam5());
            ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5 .getBytes(), valueReserve_param5);
            byte[] valueReserve_param6 = mapFromFieldReserveParam6(instance.getReserveParam6());
            ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6 .getBytes(), valueReserve_param6);
            byte[] valuePage_detail = mapFromFieldPageDetail(instance.getPageDetail());
            ret.put(ModelTMlinkUrlInfo.FI_PAGE_DETAIL.getBytes(), valuePage_detail);
            byte[] valueVideo_type = mapFromFieldVideoType(instance.getVideoType());
            ret.put(ModelTMlinkUrlInfo.FI_VIDEO_TYPE.getBytes(), valueVideo_type);
            byte[] valueParam = mapFromFieldParam(instance.getParam());
            ret.put(ModelTMlinkUrlInfo.FI_PARAM.getBytes(), valueParam);
            byte[] valueVideo_url = mapFromFieldVideoUrl(instance.getVideoUrl());
            ret.put(ModelTMlinkUrlInfo.FI_VIDEO_URL.getBytes(), valueVideo_url);
            byte[] valueUpdate_time = mapFromFieldUpdateTime(instance.getUpdateTime());
            ret.put(ModelTMlinkUrlInfo.FI_UPDATE_TIME.getBytes(), valueUpdate_time);
            byte[] valueCreate_time = mapFromFieldCreateTime(instance.getCreateTime());
            ret.put(ModelTMlinkUrlInfo.FI_CREATE_TIME.getBytes(), valueCreate_time);
            byte[] valueSite_flag = mapFromFieldSiteFlag(instance.getSiteFlag());
            ret.put(ModelTMlinkUrlInfo.FI_SITE_FLAG.getBytes(), valueSite_flag);
            byte[] valueSystem = mapFromFieldSystem(instance.getSystem());
            ret.put(ModelTMlinkUrlInfo.FI_SYSTEM.getBytes(), valueSystem);
            byte[] valueDelete_flag = mapFromFieldDeleteFlag(instance.getDeleteFlag());
            ret.put(ModelTMlinkUrlInfo.FI_DELETE_FLAG.getBytes(), valueDelete_flag);
            byte[] valueEncrypted_params = mapFromFieldEncryptedParams(instance.getEncryptedParams());
            ret.put(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS.getBytes(), valueEncrypted_params);
            byte[] valueUnique_identifier = mapFromFieldUniqueIdentifier(instance.getUniqueIdentifier());
            ret.put(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER.getBytes(), valueUnique_identifier);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSiteId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldConfigUser(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldScene(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDivision(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldLegion(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldChannel(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldActivityName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPlanId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReserveParam1(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReserveParam2(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReserveParam3(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReserveParam4(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReserveParam5(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReserveParam6(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageDetail(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldVideoType(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldParam(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldVideoUrl(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUpdateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSiteFlag(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSystem(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeleteFlag(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEncryptedParams(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUniqueIdentifier(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTMlinkUrlInfo instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_ID, dId);
            }
            String dSite_id = instance.getSiteId();
            if (dSite_id!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_SITE_ID, dSite_id);
            }
            String dConfig_user = instance.getConfigUser();
            if (dConfig_user!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_CONFIG_USER, dConfig_user);
            }
            String dScene = instance.getScene();
            if (dScene!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_SCENE, dScene);
            }
            String dDivision = instance.getDivision();
            if (dDivision!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_DIVISION, dDivision);
            }
            String dLegion = instance.getLegion();
            if (dLegion!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_LEGION, dLegion);
            }
            String dChannel = instance.getChannel();
            if (dChannel!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_CHANNEL, dChannel);
            }
            String dActivity_name = instance.getActivityName();
            if (dActivity_name!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, dActivity_name);
            }
            String dPlan_id = instance.getPlanId();
            if (dPlan_id!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_PLAN_ID, dPlan_id);
            }
            String dReserve_param1 = instance.getReserveParam1();
            if (dReserve_param1 != null) {
                ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, dReserve_param1);
            }
            String dReserve_param2 = instance.getReserveParam2();
            if (dReserve_param2 != null) {
                ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, dReserve_param2);
            }
            String dReserve_param3 = instance.getReserveParam3();
            if (dReserve_param3 != null) {
                ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, dReserve_param3);
            }
            String dReserve_param4 = instance.getReserveParam4();
            if (dReserve_param4 != null) {
                ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, dReserve_param4);
            }
            String dReserve_param5 = instance.getReserveParam5();
            if (dReserve_param5 != null) {
                ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, dReserve_param5);
            }
            String dReserve_param6 = instance.getReserveParam6();
            if (dReserve_param6 != null) {
                ret.put(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, dReserve_param6);
            }
            String dPage_detail = instance.getPageDetail();
            if (dPage_detail!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, dPage_detail);
            }
            String dVideo_type = instance.getVideoType();
            if (dVideo_type!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, dVideo_type);
            }
            String dParam = instance.getParam();
            if (dParam!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_PARAM, dParam);
            }
            String dVideo_url = instance.getVideoUrl();
            if (dVideo_url!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_VIDEO_URL, dVideo_url);
            }
            Date dUpdate_time = instance.getUpdateTime();
            if (dUpdate_time!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_UPDATE_TIME, dUpdate_time);
            }
            Date dCreate_time = instance.getCreateTime();
            if (dCreate_time!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_CREATE_TIME, dCreate_time);
            }
            Integer dSite_flag = instance.getSiteFlag();
            if (dSite_flag!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_SITE_FLAG, dSite_flag);
            }
            String dSystem = instance.getSystem();
            if (dSystem!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_SYSTEM, dSystem);
            }
            Integer dDelete_flag = instance.getDeleteFlag();
            if (dDelete_flag!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_DELETE_FLAG, dDelete_flag);
            }
            String dEncrypted_params = instance.getEncryptedParams();
            if (dEncrypted_params!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, dEncrypted_params);
            }
            String dUnique_identifier = instance.getUniqueIdentifier();
            if (dUnique_identifier!= null) {
                ret.put(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, dUnique_identifier);
            }
            return ret;
        }

        @Override
        public ModelTMlinkUrlInfo fromCommonMap(Map<String, Object> param) {
            ModelTMlinkUrlInfo ret = new ModelTMlinkUrlInfo();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelTMlinkUrlInfo.FI_ID);
            if (dId!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_ID, ret, dId);
            }
            Object dSite_id = param.get(ModelTMlinkUrlInfo.FI_SITE_ID);
            if (dSite_id!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_SITE_ID, ret, dSite_id);
            }
            Object dConfig_user = param.get(ModelTMlinkUrlInfo.FI_CONFIG_USER);
            if (dConfig_user!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_CONFIG_USER, ret, dConfig_user);
            }
            Object dScene = param.get(ModelTMlinkUrlInfo.FI_SCENE);
            if (dScene!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_SCENE, ret, dScene);
            }
            Object dDivision = param.get(ModelTMlinkUrlInfo.FI_DIVISION);
            if (dDivision!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_DIVISION, ret, dDivision);
            }
            Object dLegion = param.get(ModelTMlinkUrlInfo.FI_LEGION);
            if (dLegion!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_LEGION, ret, dLegion);
            }
            Object dChannel = param.get(ModelTMlinkUrlInfo.FI_CHANNEL);
            if (dChannel!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_CHANNEL, ret, dChannel);
            }
            Object dActivity_name = param.get(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME);
            if (dActivity_name!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME, ret, dActivity_name);
            }
            Object dPlan_id = param.get(ModelTMlinkUrlInfo.FI_PLAN_ID);
            if (dPlan_id!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_PLAN_ID, ret, dPlan_id);
            }
            Object dReserve_param1 = param.get(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1);
            if (dReserve_param1 != null) {
                this.setField(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1, ret, dReserve_param1);
            }
            Object dReserve_param2 = param.get(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2);
            if (dReserve_param2 != null) {
                this.setField(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2, ret, dReserve_param2);
            }
            Object dReserve_param3 = param.get(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3);
            if (dReserve_param3 != null) {
                this.setField(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3, ret, dReserve_param3);
            }
            Object dReserve_param4 = param.get(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4);
            if (dReserve_param4 != null) {
                this.setField(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4, ret, dReserve_param4);
            }
            Object dReserve_param5 = param.get(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5);
            if (dReserve_param5 != null) {
                this.setField(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5, ret, dReserve_param5);
            }
            Object dReserve_param6 = param.get(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6);
            if (dReserve_param6 != null) {
                this.setField(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6, ret, dReserve_param6);
            }
            Object dPage_detail = param.get(ModelTMlinkUrlInfo.FI_PAGE_DETAIL);
            if (dPage_detail!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_PAGE_DETAIL, ret, dPage_detail);
            }
            Object dVideo_type = param.get(ModelTMlinkUrlInfo.FI_VIDEO_TYPE);
            if (dVideo_type!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_VIDEO_TYPE, ret, dVideo_type);
            }
            Object dParam = param.get(ModelTMlinkUrlInfo.FI_PARAM);
            if (dParam!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_PARAM, ret, dParam);
            }
            Object dVideo_url = param.get(ModelTMlinkUrlInfo.FI_VIDEO_URL);
            if (dVideo_url!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_VIDEO_URL, ret, dVideo_url);
            }
            Object dUpdate_time = param.get(ModelTMlinkUrlInfo.FI_UPDATE_TIME);
            if (dUpdate_time!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_UPDATE_TIME, ret, dUpdate_time);
            }
            Object dCreate_time = param.get(ModelTMlinkUrlInfo.FI_CREATE_TIME);
            if (dCreate_time!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_CREATE_TIME, ret, dCreate_time);
            }
            Object dSite_flag = param.get(ModelTMlinkUrlInfo.FI_SITE_FLAG);
            if (dSite_flag!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_SITE_FLAG, ret, dSite_flag);
            }
            Object dSystem = param.get(ModelTMlinkUrlInfo.FI_SYSTEM);
            if (dSystem!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_SYSTEM, ret, dSystem);
            }
            Object dDelete_flag = param.get(ModelTMlinkUrlInfo.FI_DELETE_FLAG);
            if (dDelete_flag!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_DELETE_FLAG, ret, dDelete_flag);
            }
            Object dEncrypted_params = param.get(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS);
            if (dEncrypted_params!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS, ret, dEncrypted_params);
            }
            Object dUnique_identifier = param.get(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER);
            if (dUnique_identifier!= null) {
                this.setField(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER, ret, dUnique_identifier);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldSiteId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldConfigUser(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldScene(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldDivision(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldLegion(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldChannel(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldActivityName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPlanId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldReserveParam1(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldReserveParam2(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldReserveParam3(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldReserveParam4(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldReserveParam5(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldReserveParam6(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPageDetail(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldVideoType(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldParam(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldVideoUrl(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldUpdateTime(Object obj) {
            return ((Date) obj);
        }

        protected Date mapToFieldCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected Integer mapToFieldSiteFlag(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldSystem(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldDeleteFlag(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldEncryptedParams(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUniqueIdentifier(Object obj) {
            return ((String) obj);
        }

        public<TT> TT getField(String field, ModelTMlinkUrlInfo instance) {
            try {
                if (field.equals(ModelTMlinkUrlInfo.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTMlinkUrlInfo.FI_SITE_ID)) {
                        return ((TT) instance.getSiteId());
                    } else {
                        if (field.equals(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
                            return ((TT) instance.getConfigUser());
                        } else {
                            if (field.equals(ModelTMlinkUrlInfo.FI_SCENE)) {
                                return ((TT) instance.getScene());
                            } else {
                                if (field.equals(ModelTMlinkUrlInfo.FI_DIVISION)) {
                                    return ((TT) instance.getDivision());
                                } else {
                                    if (field.equals(ModelTMlinkUrlInfo.FI_LEGION)) {
                                        return ((TT) instance.getLegion());
                                    } else {
                                        if (field.equals(ModelTMlinkUrlInfo.FI_CHANNEL)) {
                                            return ((TT) instance.getChannel());
                                        } else {
                                            if (field.equals(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
                                                return ((TT) instance.getActivityName());
                                            } else {
                                                if (field.equals(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
                                                    return ((TT) instance.getPlanId());
                                                } else {
                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
                                                        return ((TT) instance.getReserveParam1());
                                                    } else {
                                                        if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
                                                            return ((TT) instance.getReserveParam2());
                                                        } else {
                                                            if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
                                                                return ((TT) instance.getReserveParam3());
                                                            } else {
                                                                if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
                                                                    return ((TT) instance.getReserveParam4());
                                                                } else {
                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
                                                                        return ((TT) instance.getReserveParam5());
                                                                    } else {
                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
                                                                            return ((TT) instance.getReserveParam6());
                                                                        } else {
                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
                                                                                return ((TT) instance.getPageDetail());
                                                                            } else {
                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
                                                                                    return ((TT) instance.getVideoType());
                                                                                } else {
                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_PARAM)) {
                                                                                        return ((TT) instance.getParam());
                                                                                    } else {
                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
                                                                                            return ((TT) instance.getVideoUrl());
                                                                                        } else {
                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
                                                                                                return ((TT) instance.getUpdateTime());
                                                                                            } else {
                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
                                                                                                    return ((TT) instance.getCreateTime());
                                                                                                } else {
                                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
                                                                                                        return ((TT) instance.getSiteFlag());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_SYSTEM)) {
                                                                                                            return ((TT) instance.getSystem());
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
                                                                                                                return ((TT) instance.getDeleteFlag());
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
                                                                                                                    return ((TT) instance.getEncryptedParams());
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
                                                                                                                        return ((TT) instance.getUniqueIdentifier());
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public<TT> void setField(String field, ModelTMlinkUrlInfo instance, TT value) {
            if (field.equals(ModelTMlinkUrlInfo.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTMlinkUrlInfo.FI_SITE_ID)) {
                    try {
                        instance.setSiteId(mapToFieldSiteId(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
                        try {
                            instance.setConfigUser(mapToFieldConfigUser(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTMlinkUrlInfo.FI_SCENE)) {
                            try {
                                instance.setScene(mapToFieldScene(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTMlinkUrlInfo.FI_DIVISION)) {
                                try {
                                    instance.setDivision(mapToFieldDivision(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTMlinkUrlInfo.FI_LEGION)) {
                                    try {
                                        instance.setLegion(mapToFieldLegion(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTMlinkUrlInfo.FI_CHANNEL)) {
                                        try {
                                            instance.setChannel(mapToFieldChannel(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
                                            try {
                                                instance.setActivityName(mapToFieldActivityName(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
                                                try {
                                                    instance.setPlanId(mapToFieldPlanId(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
                                                    try {
                                                        instance.setReserveParam1(mapToFieldReserveParam1(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
                                                        try {
                                                            instance.setReserveParam2(mapToFieldReserveParam2(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
                                                            try {
                                                                instance.setReserveParam3(mapToFieldReserveParam3(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
                                                                try {
                                                                    instance.setReserveParam4(mapToFieldReserveParam4(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
                                                                    try {
                                                                        instance.setReserveParam5(mapToFieldReserveParam5(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
                                                                        try {
                                                                            instance.setReserveParam6(mapToFieldReserveParam6(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
                                                                            try {
                                                                                instance.setPageDetail(mapToFieldPageDetail(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
                                                                                try {
                                                                                    instance.setVideoType(mapToFieldVideoType(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_PARAM)) {
                                                                                    try {
                                                                                        instance.setParam(mapToFieldParam(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
                                                                                        try {
                                                                                            instance.setVideoUrl(mapToFieldVideoUrl(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
                                                                                            try {
                                                                                                instance.setUpdateTime(mapToFieldUpdateTime(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
                                                                                                try {
                                                                                                    instance.setCreateTime(mapToFieldCreateTime(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
                                                                                                    try {
                                                                                                        instance.setSiteFlag(mapToFieldSiteFlag(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_SYSTEM)) {
                                                                                                        try {
                                                                                                            instance.setSystem(mapToFieldSystem(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
                                                                                                            try {
                                                                                                                instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                                                                                                            } catch (final Exception ex) {
                                                                                                                ex.printStackTrace();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
                                                                                                                try {
                                                                                                                    instance.setEncryptedParams(mapToFieldEncryptedParams(value));
                                                                                                                } catch (final Exception ex) {
                                                                                                                    ex.printStackTrace();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
                                                                                                                    try {
                                                                                                                        instance.setUniqueIdentifier(mapToFieldUniqueIdentifier(value));
                                                                                                                    } catch (final Exception ex) {
                                                                                                                        ex.printStackTrace();
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void setField(String field, ModelTMlinkUrlInfo instance, byte[] value) {
            if (field.equals(ModelTMlinkUrlInfo.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTMlinkUrlInfo.FI_SITE_ID)) {
                    instance.setSiteId(mapToFieldSiteId(value));
                } else {
                    if (field.equals(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
                        instance.setConfigUser(mapToFieldConfigUser(value));
                    } else {
                        if (field.equals(ModelTMlinkUrlInfo.FI_SCENE)) {
                            instance.setScene(mapToFieldScene(value));
                        } else {
                            if (field.equals(ModelTMlinkUrlInfo.FI_DIVISION)) {
                                instance.setDivision(mapToFieldDivision(value));
                            } else {
                                if (field.equals(ModelTMlinkUrlInfo.FI_LEGION)) {
                                    instance.setLegion(mapToFieldLegion(value));
                                } else {
                                    if (field.equals(ModelTMlinkUrlInfo.FI_CHANNEL)) {
                                        instance.setChannel(mapToFieldChannel(value));
                                    } else {
                                        if (field.equals(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
                                            instance.setActivityName(mapToFieldActivityName(value));
                                        } else {
                                            if (field.equals(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
                                                instance.setPlanId(mapToFieldPlanId(value));
                                            } else {
                                                if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
                                                    instance.setReserveParam1(mapToFieldReserveParam1(value));
                                                } else {
                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
                                                        instance.setReserveParam2(mapToFieldReserveParam2(value));
                                                    } else {
                                                        if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
                                                            instance.setReserveParam3(mapToFieldReserveParam3(value));
                                                        } else {
                                                            if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
                                                                instance.setReserveParam4(mapToFieldReserveParam4(value));
                                                            } else {
                                                                if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
                                                                    instance.setReserveParam5(mapToFieldReserveParam5(value));
                                                                } else {
                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
                                                                        instance.setReserveParam6(mapToFieldReserveParam6(value));
                                                                    } else {
                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
                                                                            instance.setPageDetail(mapToFieldPageDetail(value));
                                                                        } else {
                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
                                                                                instance.setVideoType(mapToFieldVideoType(value));
                                                                            } else {
                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_PARAM)) {
                                                                                    instance.setParam(mapToFieldParam(value));
                                                                                } else {
                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
                                                                                        instance.setVideoUrl(mapToFieldVideoUrl(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
                                                                                            instance.setUpdateTime(mapToFieldUpdateTime(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
                                                                                                instance.setCreateTime(mapToFieldCreateTime(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
                                                                                                    instance.setSiteFlag(mapToFieldSiteFlag(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTMlinkUrlInfo.FI_SYSTEM)) {
                                                                                                        instance.setSystem(mapToFieldSystem(value));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
                                                                                                            instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
                                                                                                                instance.setEncryptedParams(mapToFieldEncryptedParams(value));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
                                                                                                                    instance.setUniqueIdentifier(mapToFieldUniqueIdentifier(value));
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static class ResultSetMapperModelTMlinkUrlInfo<T extends ModelTMlinkUrlInfo>
        extends BaseDbMapper<T>
        implements DbResultSetMapper<T>
    {

        @Override
        public T mapRow(ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            T instance = buildInstance();
            return mapRow(instance, rs, rowNum, columnNames);
        }

        protected T buildInstance() {
            return ((T) new ModelTMlinkUrlInfo());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldSite_id(rs, columnNames, instance);
            mapFieldConfig_user(rs, columnNames, instance);
            mapFieldScene(rs, columnNames, instance);
            mapFieldDivision(rs, columnNames, instance);
            mapFieldLegion(rs, columnNames, instance);
            mapFieldChannel(rs, columnNames, instance);
            mapFieldActivity_name(rs, columnNames, instance);
            mapFieldPlan_id(rs, columnNames, instance);
            mapFieldReserve_param1(rs, columnNames, instance);
            mapFieldReserve_param2(rs, columnNames, instance);
            mapFieldReserve_param3(rs, columnNames, instance);
            mapFieldReserve_param4(rs, columnNames, instance);
            mapFieldReserve_param5(rs, columnNames, instance);
            mapFieldReserve_param6(rs, columnNames, instance);
            mapFieldPage_detail(rs, columnNames, instance);
            mapFieldVideo_type(rs, columnNames, instance);
            mapFieldParam(rs, columnNames, instance);
            mapFieldVideo_url(rs, columnNames, instance);
            mapFieldUpdate_time(rs, columnNames, instance);
            mapFieldCreate_time(rs, columnNames, instance);
            mapFieldSite_flag(rs, columnNames, instance);
            mapFieldSystem(rs, columnNames, instance);
            mapFieldDelete_flag(rs, columnNames, instance);
            mapFieldEncrypted_params(rs, columnNames, instance);
            mapFieldUnique_identifier(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_ID)) {
                instance.setId(rs.getInt(ModelTMlinkUrlInfo.FI_ID));
            }
        }

        protected void mapFieldSite_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_SITE_ID)) {
                instance.setSiteId(rs.getString(ModelTMlinkUrlInfo.FI_SITE_ID));
            }
        }

        protected void mapFieldConfig_user(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_CONFIG_USER)) {
                instance.setConfigUser(rs.getString(ModelTMlinkUrlInfo.FI_CONFIG_USER));
            }
        }

        protected void mapFieldScene(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_SCENE)) {
                instance.setScene(rs.getString(ModelTMlinkUrlInfo.FI_SCENE));
            }
        }

        protected void mapFieldDivision(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_DIVISION)) {
                instance.setDivision(rs.getString(ModelTMlinkUrlInfo.FI_DIVISION));
            }
        }

        protected void mapFieldLegion(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_LEGION)) {
                instance.setLegion(rs.getString(ModelTMlinkUrlInfo.FI_LEGION));
            }
        }

        protected void mapFieldChannel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_CHANNEL)) {
                instance.setChannel(rs.getString(ModelTMlinkUrlInfo.FI_CHANNEL));
            }
        }

        protected void mapFieldActivity_name(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME)) {
                instance.setActivityName(rs.getString(ModelTMlinkUrlInfo.FI_ACTIVITY_NAME));
            }
        }

        protected void mapFieldPlan_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_PLAN_ID)) {
                instance.setPlanId(rs.getString(ModelTMlinkUrlInfo.FI_PLAN_ID));
            }
        }

        protected void mapFieldReserve_param1(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1)) {
                instance.setReserveParam1(rs.getString(ModelTMlinkUrlInfo.FI_RESERVE_PARAM1));
            }
        }

        protected void mapFieldReserve_param2(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2)) {
                instance.setReserveParam2(rs.getString(ModelTMlinkUrlInfo.FI_RESERVE_PARAM2));
            }
        }

        protected void mapFieldReserve_param3(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3)) {
                instance.setReserveParam3(rs.getString(ModelTMlinkUrlInfo.FI_RESERVE_PARAM3));
            }
        }

        protected void mapFieldReserve_param4(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4)) {
                instance.setReserveParam4(rs.getString(ModelTMlinkUrlInfo.FI_RESERVE_PARAM4));
            }
        }

        protected void mapFieldReserve_param5(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5)) {
                instance.setReserveParam5(rs.getString(ModelTMlinkUrlInfo.FI_RESERVE_PARAM5));
            }
        }

        protected void mapFieldReserve_param6(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6)) {
                instance.setReserveParam6(rs.getString(ModelTMlinkUrlInfo.FI_RESERVE_PARAM6));
            }
        }

        protected void mapFieldPage_detail(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_PAGE_DETAIL)) {
                instance.setPageDetail(rs.getString(ModelTMlinkUrlInfo.FI_PAGE_DETAIL));
            }
        }

        protected void mapFieldVideo_type(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_VIDEO_TYPE)) {
                instance.setVideoType(rs.getString(ModelTMlinkUrlInfo.FI_VIDEO_TYPE));
            }
        }

        protected void mapFieldParam(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_PARAM)) {
                instance.setParam(rs.getString(ModelTMlinkUrlInfo.FI_PARAM));
            }
        }

        protected void mapFieldVideo_url(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_VIDEO_URL)) {
                instance.setVideoUrl(rs.getString(ModelTMlinkUrlInfo.FI_VIDEO_URL));
            }
        }

        protected void mapFieldUpdate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_UPDATE_TIME)) {
                instance.setUpdateTime(rs.getTimestamp(ModelTMlinkUrlInfo.FI_UPDATE_TIME));
            }
        }

        protected void mapFieldCreate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_CREATE_TIME)) {
                instance.setCreateTime(rs.getTimestamp(ModelTMlinkUrlInfo.FI_CREATE_TIME));
            }
        }

        protected void mapFieldSite_flag(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_SITE_FLAG)) {
                instance.setSiteFlag(rs.getInt(ModelTMlinkUrlInfo.FI_SITE_FLAG));
            }
        }

        protected void mapFieldSystem(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_SYSTEM)) {
                instance.setSystem(rs.getString(ModelTMlinkUrlInfo.FI_SYSTEM));
            }
        }

        protected void mapFieldDelete_flag(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_DELETE_FLAG)) {
                instance.setDeleteFlag(rs.getInt(ModelTMlinkUrlInfo.FI_DELETE_FLAG));
            }
        }

        protected void mapFieldEncrypted_params(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS)) {
                instance.setEncryptedParams(rs.getString(ModelTMlinkUrlInfo.FI_ENCRYPTED_PARAMS));
            }
        }

        protected void mapFieldUnique_identifier(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER)) {
                instance.setUniqueIdentifier(rs.getString(ModelTMlinkUrlInfo.FI_UNIQUE_IDENTIFIER));
            }
        }
    }
}
