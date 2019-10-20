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
 * base DTO,represent for table :mlink_match_result
 * 	mlink 上报天网名片匹配结果表
 */
public class ModelMlinkMatchResult
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "mlink_match_result";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.mlink_match_result.id 字段
     * 自增主键
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.mlink_match_result.user_id 字段
     * 用户id
     */
    Integer userId;
    public final static String FI_USER_ID = "user_id";
    /**
     * 对应数据库.mlink_match_result.mlink_id 字段
     * mlink id
     */
    Integer mlinkId;
    public final static String FI_MLINK_ID = "mlink_id";
    /**
     * 对应数据库.mlink_match_result.mobile 字段
     * 手机号
     */
    String mobile;
    public final static String FI_MOBILE = "mobile";
    /**
     * 对应数据库.mlink_match_result.is_related 字段
     * 是否关联，0否，1是
     */
    Integer isRelated;
    public final static String FI_IS_RELATED = "is_related";
    /**
     * 对应数据库.mlink_match_result.stu_id 字段
     * 学员id，天网反馈
     */
    Integer stuId;
    public final static String FI_STU_ID = "stu_id";
    /**
     * 对应数据库.mlink_match_result.system 字段
     * 系统，天网反馈
     */
    String system;
    public final static String FI_SYSTEM = "system";
    /**
     * 对应数据库.mlink_match_result.bind_state 字段
     * 绑定失败原因，撞单，补充失败:other_repeated、重复，补充失败:self_repeated、超限，补充失败:over、补充成功:success，异常：exception
     */
    String bindState;
    public final static String FI_BIND_STATE = "bind_state";
    /**
     * 对应数据库.mlink_match_result.call_result 字段
     * 接口调用是否成功，0失败，1成功
     */
    Integer callResult;
    public final static String FI_CALL_RESULT = "call_result";
    /**
     * 对应数据库.mlink_match_result.return_message 字段
     * 接口返回结果
     */
    String returnMessage;
    public final static String FI_RETURN_MESSAGE = "return_message";
    /**
     * 对应数据库.mlink_match_result.is_bind 字段
     * 手机号是否绑定，1补充成功，0补充失败
     */
    Integer isBind;
    public final static String FI_IS_BIND = "is_bind";
    /**
     * 对应数据库.mlink_match_result.create_time 字段
     * 创建时间
     */
    Date createTime;
    public final static String FI_CREATE_TIME = "create_time";
    /**
     * 对应数据库.mlink_match_result.delete_flag 字段
     * 删除标识,0未删除，1已删除
     */
    Integer deleteFlag;
    public final static String FI_DELETE_FLAG = "delete_flag";
    /**
     * 对应数据库.mlink_match_result.update_time 字段
     * 
     */
    Date updateTime;
    public final static String FI_UPDATE_TIME = "update_time";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelMlinkMatchResult.FI_ID, Integer.class).put(ModelMlinkMatchResult.FI_USER_ID, Integer.class).put(ModelMlinkMatchResult.FI_MLINK_ID, Integer.class).put(ModelMlinkMatchResult.FI_MOBILE, String.class).put(ModelMlinkMatchResult.FI_IS_RELATED, Integer.class).put(ModelMlinkMatchResult.FI_STU_ID, Integer.class).put(ModelMlinkMatchResult.FI_SYSTEM, String.class).put(ModelMlinkMatchResult.FI_BIND_STATE, String.class).put(ModelMlinkMatchResult.FI_CALL_RESULT, Integer.class).put(ModelMlinkMatchResult.FI_RETURN_MESSAGE, String.class).put(ModelMlinkMatchResult.FI_IS_BIND, Integer.class).put(ModelMlinkMatchResult.FI_CREATE_TIME, Date.class).put(ModelMlinkMatchResult.FI_DELETE_FLAG, Integer.class).put(ModelMlinkMatchResult.FI_UPDATE_TIME, Date.class).getMap();
    public final static Integer FIELD_COUNT = 14;
    public final static ResultSetMapperModelMlinkMatchResult<ModelMlinkMatchResult> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelMlinkMatchResult<com.shangde.ent_portal.logical.dto.basepo.ModelMlinkMatchResult>();
    public final static ByteMapMapperModelMlinkMatchResult MAP_OBJ_MAPPER = new ByteMapMapperModelMlinkMatchResult();

    public ModelMlinkMatchResult() {
    }

    public Integer getId() {
        return id;
    }

    public ModelMlinkMatchResult setId(Integer lId) {
        id = lId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public ModelMlinkMatchResult setUserId(Integer lUserId) {
        userId = lUserId;
        return this;
    }

    public Integer getMlinkId() {
        return mlinkId;
    }

    public ModelMlinkMatchResult setMlinkId(Integer lMlinkId) {
        mlinkId = lMlinkId;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ModelMlinkMatchResult setMobile(String lMobile) {
        mobile = lMobile;
        return this;
    }

    public Integer getIsRelated() {
        return isRelated;
    }

    public ModelMlinkMatchResult setIsRelated(Integer lIsRelated) {
        isRelated = lIsRelated;
        return this;
    }

    public Integer getStuId() {
        return stuId;
    }

    public ModelMlinkMatchResult setStuId(Integer lStuId) {
        stuId = lStuId;
        return this;
    }

    public String getSystem() {
        return system;
    }

    public ModelMlinkMatchResult setSystem(String lSystem) {
        system = lSystem;
        return this;
    }

    public String getBindState() {
        return bindState;
    }

    public ModelMlinkMatchResult setBindState(String lBindState) {
        bindState = lBindState;
        return this;
    }

    public Integer getCallResult() {
        return callResult;
    }

    public ModelMlinkMatchResult setCallResult(Integer lCallResult) {
        callResult = lCallResult;
        return this;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public ModelMlinkMatchResult setReturnMessage(String lReturnMessage) {
        returnMessage = lReturnMessage;
        return this;
    }

    public Integer getIsBind() {
        return isBind;
    }

    public ModelMlinkMatchResult setIsBind(Integer lIsBind) {
        isBind = lIsBind;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ModelMlinkMatchResult setCreateTime(Date lCreateTime) {
        createTime = lCreateTime;
        return this;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public ModelMlinkMatchResult setDeleteFlag(Integer lDeleteFlag) {
        deleteFlag = lDeleteFlag;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ModelMlinkMatchResult setUpdateTime(Date lUpdateTime) {
        updateTime = lUpdateTime;
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
        if (getUserId()!= null) {
            return false;
        }
        if (getMlinkId()!= null) {
            return false;
        }
        if (getMobile()!= null) {
            return false;
        }
        if (getIsRelated()!= null) {
            return false;
        }
        if (getStuId()!= null) {
            return false;
        }
        if (getSystem()!= null) {
            return false;
        }
        if (getBindState()!= null) {
            return false;
        }
        if (getCallResult()!= null) {
            return false;
        }
        if (getReturnMessage()!= null) {
            return false;
        }
        if (getIsBind()!= null) {
            return false;
        }
        if (getCreateTime()!= null) {
            return false;
        }
        if (getDeleteFlag()!= null) {
            return false;
        }
        if (getUpdateTime()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelMlinkMatchResult.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelMlinkMatchResult.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("userId").append(":").append(userId).append("}\n");
        ret.append("{").append("mlinkId").append(":").append(mlinkId).append("}\n");
        ret.append("{").append("mobile").append(":").append(mobile).append("}\n");
        ret.append("{").append("isRelated").append(":").append(isRelated).append("}\n");
        ret.append("{").append("stuId").append(":").append(stuId).append("}\n");
        ret.append("{").append("system").append(":").append(system).append("}\n");
        ret.append("{").append("bindState").append(":").append(bindState).append("}\n");
        ret.append("{").append("callResult").append(":").append(callResult).append("}\n");
        ret.append("{").append("returnMessage").append(":").append(returnMessage).append("}\n");
        ret.append("{").append("isBind").append(":").append(isBind).append("}\n");
        ret.append("{").append("createTime").append(":").append(createTime).append("}\n");
        ret.append("{").append("deleteFlag").append(":").append(deleteFlag).append("}\n");
        ret.append("{").append("updateTime").append(":").append(updateTime).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelMlinkMatchResult
        implements RedisMapMapper<ModelMlinkMatchResult>
    {

        @Override
        public ModelMlinkMatchResult fromMap(Map<byte[], byte[]> map) {
            ModelMlinkMatchResult instance = new ModelMlinkMatchResult();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelMlinkMatchResult.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelMlinkMatchResult.FI_USER_ID)) {
                        instance.setUserId(mapToFieldUserId(entry.getValue()));
                    } else {
                        if (field.equals(ModelMlinkMatchResult.FI_MLINK_ID)) {
                            instance.setMlinkId(mapToFieldMlinkId(entry.getValue()));
                        } else {
                            if (field.equals(ModelMlinkMatchResult.FI_MOBILE)) {
                                instance.setMobile(mapToFieldMobile(entry.getValue()));
                            } else {
                                if (field.equals(ModelMlinkMatchResult.FI_IS_RELATED)) {
                                    instance.setIsRelated(mapToFieldIsRelated(entry.getValue()));
                                } else {
                                    if (field.equals(ModelMlinkMatchResult.FI_STU_ID)) {
                                        instance.setStuId(mapToFieldStuId(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelMlinkMatchResult.FI_SYSTEM)) {
                                            instance.setSystem(mapToFieldSystem(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelMlinkMatchResult.FI_BIND_STATE)) {
                                                instance.setBindState(mapToFieldBindState(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelMlinkMatchResult.FI_CALL_RESULT)) {
                                                    instance.setCallResult(mapToFieldCallResult(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
                                                        instance.setReturnMessage(mapToFieldReturnMessage(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelMlinkMatchResult.FI_IS_BIND)) {
                                                            instance.setIsBind(mapToFieldIsBind(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelMlinkMatchResult.FI_CREATE_TIME)) {
                                                                instance.setCreateTime(mapToFieldCreateTime(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
                                                                    instance.setDeleteFlag(mapToFieldDeleteFlag(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
                                                                        instance.setUpdateTime(mapToFieldUpdateTime(entry.getValue()));
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

        protected Integer mapToFieldUserId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMlinkId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldMobile(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldIsRelated(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldStuId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldSystem(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldBindState(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldCallResult(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldReturnMessage(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldIsBind(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Integer mapToFieldDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldUpdateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelMlinkMatchResult instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelMlinkMatchResult.FI_ID.getBytes(), valueId);
            byte[] valueUser_id = mapFromFieldUserId(instance.getUserId());
            ret.put(ModelMlinkMatchResult.FI_USER_ID.getBytes(), valueUser_id);
            byte[] valueMlink_id = mapFromFieldMlinkId(instance.getMlinkId());
            ret.put(ModelMlinkMatchResult.FI_MLINK_ID.getBytes(), valueMlink_id);
            byte[] valueMobile = mapFromFieldMobile(instance.getMobile());
            ret.put(ModelMlinkMatchResult.FI_MOBILE.getBytes(), valueMobile);
            byte[] valueIs_related = mapFromFieldIsRelated(instance.getIsRelated());
            ret.put(ModelMlinkMatchResult.FI_IS_RELATED.getBytes(), valueIs_related);
            byte[] valueStu_id = mapFromFieldStuId(instance.getStuId());
            ret.put(ModelMlinkMatchResult.FI_STU_ID.getBytes(), valueStu_id);
            byte[] valueSystem = mapFromFieldSystem(instance.getSystem());
            ret.put(ModelMlinkMatchResult.FI_SYSTEM.getBytes(), valueSystem);
            byte[] valueBind_state = mapFromFieldBindState(instance.getBindState());
            ret.put(ModelMlinkMatchResult.FI_BIND_STATE.getBytes(), valueBind_state);
            byte[] valueCall_result = mapFromFieldCallResult(instance.getCallResult());
            ret.put(ModelMlinkMatchResult.FI_CALL_RESULT.getBytes(), valueCall_result);
            byte[] valueReturn_message = mapFromFieldReturnMessage(instance.getReturnMessage());
            ret.put(ModelMlinkMatchResult.FI_RETURN_MESSAGE.getBytes(), valueReturn_message);
            byte[] valueIs_bind = mapFromFieldIsBind(instance.getIsBind());
            ret.put(ModelMlinkMatchResult.FI_IS_BIND.getBytes(), valueIs_bind);
            byte[] valueCreate_time = mapFromFieldCreateTime(instance.getCreateTime());
            ret.put(ModelMlinkMatchResult.FI_CREATE_TIME.getBytes(), valueCreate_time);
            byte[] valueDelete_flag = mapFromFieldDeleteFlag(instance.getDeleteFlag());
            ret.put(ModelMlinkMatchResult.FI_DELETE_FLAG.getBytes(), valueDelete_flag);
            byte[] valueUpdate_time = mapFromFieldUpdateTime(instance.getUpdateTime());
            ret.put(ModelMlinkMatchResult.FI_UPDATE_TIME.getBytes(), valueUpdate_time);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMlinkId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMobile(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIsRelated(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldStuId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSystem(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldBindState(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCallResult(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReturnMessage(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIsBind(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeleteFlag(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUpdateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelMlinkMatchResult instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelMlinkMatchResult.FI_ID, dId);
            }
            Integer dUser_id = instance.getUserId();
            if (dUser_id!= null) {
                ret.put(ModelMlinkMatchResult.FI_USER_ID, dUser_id);
            }
            Integer dMlink_id = instance.getMlinkId();
            if (dMlink_id!= null) {
                ret.put(ModelMlinkMatchResult.FI_MLINK_ID, dMlink_id);
            }
            String dMobile = instance.getMobile();
            if (dMobile!= null) {
                ret.put(ModelMlinkMatchResult.FI_MOBILE, dMobile);
            }
            Integer dIs_related = instance.getIsRelated();
            if (dIs_related!= null) {
                ret.put(ModelMlinkMatchResult.FI_IS_RELATED, dIs_related);
            }
            Integer dStu_id = instance.getStuId();
            if (dStu_id!= null) {
                ret.put(ModelMlinkMatchResult.FI_STU_ID, dStu_id);
            }
            String dSystem = instance.getSystem();
            if (dSystem!= null) {
                ret.put(ModelMlinkMatchResult.FI_SYSTEM, dSystem);
            }
            String dBind_state = instance.getBindState();
            if (dBind_state!= null) {
                ret.put(ModelMlinkMatchResult.FI_BIND_STATE, dBind_state);
            }
            Integer dCall_result = instance.getCallResult();
            if (dCall_result!= null) {
                ret.put(ModelMlinkMatchResult.FI_CALL_RESULT, dCall_result);
            }
            String dReturn_message = instance.getReturnMessage();
            if (dReturn_message!= null) {
                ret.put(ModelMlinkMatchResult.FI_RETURN_MESSAGE, dReturn_message);
            }
            Integer dIs_bind = instance.getIsBind();
            if (dIs_bind!= null) {
                ret.put(ModelMlinkMatchResult.FI_IS_BIND, dIs_bind);
            }
            Date dCreate_time = instance.getCreateTime();
            if (dCreate_time!= null) {
                ret.put(ModelMlinkMatchResult.FI_CREATE_TIME, dCreate_time);
            }
            Integer dDelete_flag = instance.getDeleteFlag();
            if (dDelete_flag!= null) {
                ret.put(ModelMlinkMatchResult.FI_DELETE_FLAG, dDelete_flag);
            }
            Date dUpdate_time = instance.getUpdateTime();
            if (dUpdate_time!= null) {
                ret.put(ModelMlinkMatchResult.FI_UPDATE_TIME, dUpdate_time);
            }
            return ret;
        }

        @Override
        public ModelMlinkMatchResult fromCommonMap(Map<String, Object> param) {
            ModelMlinkMatchResult ret = new ModelMlinkMatchResult();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelMlinkMatchResult.FI_ID);
            if (dId!= null) {
                this.setField(ModelMlinkMatchResult.FI_ID, ret, dId);
            }
            Object dUser_id = param.get(ModelMlinkMatchResult.FI_USER_ID);
            if (dUser_id!= null) {
                this.setField(ModelMlinkMatchResult.FI_USER_ID, ret, dUser_id);
            }
            Object dMlink_id = param.get(ModelMlinkMatchResult.FI_MLINK_ID);
            if (dMlink_id!= null) {
                this.setField(ModelMlinkMatchResult.FI_MLINK_ID, ret, dMlink_id);
            }
            Object dMobile = param.get(ModelMlinkMatchResult.FI_MOBILE);
            if (dMobile!= null) {
                this.setField(ModelMlinkMatchResult.FI_MOBILE, ret, dMobile);
            }
            Object dIs_related = param.get(ModelMlinkMatchResult.FI_IS_RELATED);
            if (dIs_related!= null) {
                this.setField(ModelMlinkMatchResult.FI_IS_RELATED, ret, dIs_related);
            }
            Object dStu_id = param.get(ModelMlinkMatchResult.FI_STU_ID);
            if (dStu_id!= null) {
                this.setField(ModelMlinkMatchResult.FI_STU_ID, ret, dStu_id);
            }
            Object dSystem = param.get(ModelMlinkMatchResult.FI_SYSTEM);
            if (dSystem!= null) {
                this.setField(ModelMlinkMatchResult.FI_SYSTEM, ret, dSystem);
            }
            Object dBind_state = param.get(ModelMlinkMatchResult.FI_BIND_STATE);
            if (dBind_state!= null) {
                this.setField(ModelMlinkMatchResult.FI_BIND_STATE, ret, dBind_state);
            }
            Object dCall_result = param.get(ModelMlinkMatchResult.FI_CALL_RESULT);
            if (dCall_result!= null) {
                this.setField(ModelMlinkMatchResult.FI_CALL_RESULT, ret, dCall_result);
            }
            Object dReturn_message = param.get(ModelMlinkMatchResult.FI_RETURN_MESSAGE);
            if (dReturn_message!= null) {
                this.setField(ModelMlinkMatchResult.FI_RETURN_MESSAGE, ret, dReturn_message);
            }
            Object dIs_bind = param.get(ModelMlinkMatchResult.FI_IS_BIND);
            if (dIs_bind!= null) {
                this.setField(ModelMlinkMatchResult.FI_IS_BIND, ret, dIs_bind);
            }
            Object dCreate_time = param.get(ModelMlinkMatchResult.FI_CREATE_TIME);
            if (dCreate_time!= null) {
                this.setField(ModelMlinkMatchResult.FI_CREATE_TIME, ret, dCreate_time);
            }
            Object dDelete_flag = param.get(ModelMlinkMatchResult.FI_DELETE_FLAG);
            if (dDelete_flag!= null) {
                this.setField(ModelMlinkMatchResult.FI_DELETE_FLAG, ret, dDelete_flag);
            }
            Object dUpdate_time = param.get(ModelMlinkMatchResult.FI_UPDATE_TIME);
            if (dUpdate_time!= null) {
                this.setField(ModelMlinkMatchResult.FI_UPDATE_TIME, ret, dUpdate_time);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldUserId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMlinkId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMobile(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldIsRelated(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldStuId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldSystem(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldBindState(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldCallResult(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldReturnMessage(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldIsBind(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected Integer mapToFieldDeleteFlag(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldUpdateTime(Object obj) {
            return ((Date) obj);
        }

        public<TT> TT getField(String field, ModelMlinkMatchResult instance) {
            try {
                if (field.equals(ModelMlinkMatchResult.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelMlinkMatchResult.FI_USER_ID)) {
                        return ((TT) instance.getUserId());
                    } else {
                        if (field.equals(ModelMlinkMatchResult.FI_MLINK_ID)) {
                            return ((TT) instance.getMlinkId());
                        } else {
                            if (field.equals(ModelMlinkMatchResult.FI_MOBILE)) {
                                return ((TT) instance.getMobile());
                            } else {
                                if (field.equals(ModelMlinkMatchResult.FI_IS_RELATED)) {
                                    return ((TT) instance.getIsRelated());
                                } else {
                                    if (field.equals(ModelMlinkMatchResult.FI_STU_ID)) {
                                        return ((TT) instance.getStuId());
                                    } else {
                                        if (field.equals(ModelMlinkMatchResult.FI_SYSTEM)) {
                                            return ((TT) instance.getSystem());
                                        } else {
                                            if (field.equals(ModelMlinkMatchResult.FI_BIND_STATE)) {
                                                return ((TT) instance.getBindState());
                                            } else {
                                                if (field.equals(ModelMlinkMatchResult.FI_CALL_RESULT)) {
                                                    return ((TT) instance.getCallResult());
                                                } else {
                                                    if (field.equals(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
                                                        return ((TT) instance.getReturnMessage());
                                                    } else {
                                                        if (field.equals(ModelMlinkMatchResult.FI_IS_BIND)) {
                                                            return ((TT) instance.getIsBind());
                                                        } else {
                                                            if (field.equals(ModelMlinkMatchResult.FI_CREATE_TIME)) {
                                                                return ((TT) instance.getCreateTime());
                                                            } else {
                                                                if (field.equals(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
                                                                    return ((TT) instance.getDeleteFlag());
                                                                } else {
                                                                    if (field.equals(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
                                                                        return ((TT) instance.getUpdateTime());
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

        public<TT> void setField(String field, ModelMlinkMatchResult instance, TT value) {
            if (field.equals(ModelMlinkMatchResult.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelMlinkMatchResult.FI_USER_ID)) {
                    try {
                        instance.setUserId(mapToFieldUserId(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelMlinkMatchResult.FI_MLINK_ID)) {
                        try {
                            instance.setMlinkId(mapToFieldMlinkId(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelMlinkMatchResult.FI_MOBILE)) {
                            try {
                                instance.setMobile(mapToFieldMobile(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelMlinkMatchResult.FI_IS_RELATED)) {
                                try {
                                    instance.setIsRelated(mapToFieldIsRelated(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelMlinkMatchResult.FI_STU_ID)) {
                                    try {
                                        instance.setStuId(mapToFieldStuId(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelMlinkMatchResult.FI_SYSTEM)) {
                                        try {
                                            instance.setSystem(mapToFieldSystem(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelMlinkMatchResult.FI_BIND_STATE)) {
                                            try {
                                                instance.setBindState(mapToFieldBindState(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelMlinkMatchResult.FI_CALL_RESULT)) {
                                                try {
                                                    instance.setCallResult(mapToFieldCallResult(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
                                                    try {
                                                        instance.setReturnMessage(mapToFieldReturnMessage(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelMlinkMatchResult.FI_IS_BIND)) {
                                                        try {
                                                            instance.setIsBind(mapToFieldIsBind(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelMlinkMatchResult.FI_CREATE_TIME)) {
                                                            try {
                                                                instance.setCreateTime(mapToFieldCreateTime(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
                                                                try {
                                                                    instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
                                                                    try {
                                                                        instance.setUpdateTime(mapToFieldUpdateTime(value));
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

        public void setField(String field, ModelMlinkMatchResult instance, byte[] value) {
            if (field.equals(ModelMlinkMatchResult.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelMlinkMatchResult.FI_USER_ID)) {
                    instance.setUserId(mapToFieldUserId(value));
                } else {
                    if (field.equals(ModelMlinkMatchResult.FI_MLINK_ID)) {
                        instance.setMlinkId(mapToFieldMlinkId(value));
                    } else {
                        if (field.equals(ModelMlinkMatchResult.FI_MOBILE)) {
                            instance.setMobile(mapToFieldMobile(value));
                        } else {
                            if (field.equals(ModelMlinkMatchResult.FI_IS_RELATED)) {
                                instance.setIsRelated(mapToFieldIsRelated(value));
                            } else {
                                if (field.equals(ModelMlinkMatchResult.FI_STU_ID)) {
                                    instance.setStuId(mapToFieldStuId(value));
                                } else {
                                    if (field.equals(ModelMlinkMatchResult.FI_SYSTEM)) {
                                        instance.setSystem(mapToFieldSystem(value));
                                    } else {
                                        if (field.equals(ModelMlinkMatchResult.FI_BIND_STATE)) {
                                            instance.setBindState(mapToFieldBindState(value));
                                        } else {
                                            if (field.equals(ModelMlinkMatchResult.FI_CALL_RESULT)) {
                                                instance.setCallResult(mapToFieldCallResult(value));
                                            } else {
                                                if (field.equals(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
                                                    instance.setReturnMessage(mapToFieldReturnMessage(value));
                                                } else {
                                                    if (field.equals(ModelMlinkMatchResult.FI_IS_BIND)) {
                                                        instance.setIsBind(mapToFieldIsBind(value));
                                                    } else {
                                                        if (field.equals(ModelMlinkMatchResult.FI_CREATE_TIME)) {
                                                            instance.setCreateTime(mapToFieldCreateTime(value));
                                                        } else {
                                                            if (field.equals(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
                                                                instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                                                            } else {
                                                                if (field.equals(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
                                                                    instance.setUpdateTime(mapToFieldUpdateTime(value));
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

    public static class ResultSetMapperModelMlinkMatchResult<T extends ModelMlinkMatchResult>
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
            return ((T) new ModelMlinkMatchResult());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldUser_id(rs, columnNames, instance);
            mapFieldMlink_id(rs, columnNames, instance);
            mapFieldMobile(rs, columnNames, instance);
            mapFieldIs_related(rs, columnNames, instance);
            mapFieldStu_id(rs, columnNames, instance);
            mapFieldSystem(rs, columnNames, instance);
            mapFieldBind_state(rs, columnNames, instance);
            mapFieldCall_result(rs, columnNames, instance);
            mapFieldReturn_message(rs, columnNames, instance);
            mapFieldIs_bind(rs, columnNames, instance);
            mapFieldCreate_time(rs, columnNames, instance);
            mapFieldDelete_flag(rs, columnNames, instance);
            mapFieldUpdate_time(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_ID)) {
                instance.setId(rs.getInt(ModelMlinkMatchResult.FI_ID));
            }
        }

        protected void mapFieldUser_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_USER_ID)) {
                instance.setUserId(rs.getInt(ModelMlinkMatchResult.FI_USER_ID));
            }
        }

        protected void mapFieldMlink_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_MLINK_ID)) {
                instance.setMlinkId(rs.getInt(ModelMlinkMatchResult.FI_MLINK_ID));
            }
        }

        protected void mapFieldMobile(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_MOBILE)) {
                instance.setMobile(rs.getString(ModelMlinkMatchResult.FI_MOBILE));
            }
        }

        protected void mapFieldIs_related(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_IS_RELATED)) {
                instance.setIsRelated(rs.getInt(ModelMlinkMatchResult.FI_IS_RELATED));
            }
        }

        protected void mapFieldStu_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_STU_ID)) {
                instance.setStuId(rs.getInt(ModelMlinkMatchResult.FI_STU_ID));
            }
        }

        protected void mapFieldSystem(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_SYSTEM)) {
                instance.setSystem(rs.getString(ModelMlinkMatchResult.FI_SYSTEM));
            }
        }

        protected void mapFieldBind_state(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_BIND_STATE)) {
                instance.setBindState(rs.getString(ModelMlinkMatchResult.FI_BIND_STATE));
            }
        }

        protected void mapFieldCall_result(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_CALL_RESULT)) {
                instance.setCallResult(rs.getInt(ModelMlinkMatchResult.FI_CALL_RESULT));
            }
        }

        protected void mapFieldReturn_message(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_RETURN_MESSAGE)) {
                instance.setReturnMessage(rs.getString(ModelMlinkMatchResult.FI_RETURN_MESSAGE));
            }
        }

        protected void mapFieldIs_bind(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_IS_BIND)) {
                instance.setIsBind(rs.getInt(ModelMlinkMatchResult.FI_IS_BIND));
            }
        }

        protected void mapFieldCreate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_CREATE_TIME)) {
                instance.setCreateTime(rs.getTimestamp(ModelMlinkMatchResult.FI_CREATE_TIME));
            }
        }

        protected void mapFieldDelete_flag(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_DELETE_FLAG)) {
                instance.setDeleteFlag(rs.getInt(ModelMlinkMatchResult.FI_DELETE_FLAG));
            }
        }

        protected void mapFieldUpdate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelMlinkMatchResult.FI_UPDATE_TIME)) {
                instance.setUpdateTime(rs.getTimestamp(ModelMlinkMatchResult.FI_UPDATE_TIME));
            }
        }
    }
}
