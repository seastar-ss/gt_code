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
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._ObjMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :t_wechat_info
 * 	微信账号
 */
public class ModelTWechatInfo
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_wechat_info";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.t_wechat_info.id 字段
     * 微信基本信息维护表
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.t_wechat_info.wechat_name 字段
     * 微信账号，北京分校、测试账号等
     */
    String wechatName;
    public final static String FI_WECHAT_NAME = "wechat_name";
    /**
     * 对应数据库.t_wechat_info.app_id 字段
     * 
     */
    String appId;
    public final static String FI_APP_ID = "app_id";
    /**
     * 对应数据库.t_wechat_info.app_secret 字段
     * 
     */
    String appSecret;
    public final static String FI_APP_SECRET = "app_secret";
    /**
     * 对应数据库.t_wechat_info.creat_name 字段
     * 创建人
     */
    String creatName;
    public final static String FI_CREAT_NAME = "creat_name";
    /**
     * 对应数据库.t_wechat_info.creat_time 字段
     * 创建日期
     */
    Date creatTime;
    public final static String FI_CREAT_TIME = "creat_time";
    /**
     * 对应数据库.t_wechat_info.update_time 字段
     * 
     */
    Date updateTime;
    public final static String FI_UPDATE_TIME = "update_time";
    /**
     * 对应数据库.t_wechat_info.school_name 字段
     * 分校名称
     */
    String schoolName;
    public final static String FI_SCHOOL_NAME = "school_name";
    /**
     * 对应数据库.t_wechat_info.source_id 字段
     * 
     */
    String sourceId;
    public final static String FI_SOURCE_ID = "source_id";
    /**
     * 对应数据库.t_wechat_info.attention_reply 字段
     * 
     */
    String attentionReply;
    public final static String FI_ATTENTION_REPLY = "attention_reply";
    /**
     * 对应数据库.t_wechat_info.auto_reply 字段
     * 
     */
    String autoReply;
    public final static String FI_AUTO_REPLY = "auto_reply";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTWechatInfo.FI_ID, Integer.class).put(ModelTWechatInfo.FI_WECHAT_NAME, String.class).put(ModelTWechatInfo.FI_APP_ID, String.class).put(ModelTWechatInfo.FI_APP_SECRET, String.class).put(ModelTWechatInfo.FI_CREAT_NAME, String.class).put(ModelTWechatInfo.FI_CREAT_TIME, Date.class).put(ModelTWechatInfo.FI_UPDATE_TIME, Date.class).put(ModelTWechatInfo.FI_SCHOOL_NAME, String.class).put(ModelTWechatInfo.FI_SOURCE_ID, String.class).put(ModelTWechatInfo.FI_ATTENTION_REPLY, String.class).put(ModelTWechatInfo.FI_AUTO_REPLY, String.class).getMap();
    public final static Integer FIELD_COUNT = 11;
    public final static ResultSetMapperModelTWechatInfo<ModelTWechatInfo> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelTWechatInfo<com.shangde.ent_portal.logical.dto.basepo.ModelTWechatInfo>();
    public final static ByteMapMapperModelTWechatInfo MAP_OBJ_MAPPER = new ByteMapMapperModelTWechatInfo();

    public ModelTWechatInfo() {
    }

    public Integer getId() {
        return id;
    }

    public ModelTWechatInfo setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getWechatName() {
        return wechatName;
    }

    public ModelTWechatInfo setWechatName(String lWechatName) {
        wechatName = lWechatName;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public ModelTWechatInfo setAppId(String lAppId) {
        appId = lAppId;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public ModelTWechatInfo setAppSecret(String lAppSecret) {
        appSecret = lAppSecret;
        return this;
    }

    public String getCreatName() {
        return creatName;
    }

    public ModelTWechatInfo setCreatName(String lCreatName) {
        creatName = lCreatName;
        return this;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public ModelTWechatInfo setCreatTime(Date lCreatTime) {
        creatTime = lCreatTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ModelTWechatInfo setUpdateTime(Date lUpdateTime) {
        updateTime = lUpdateTime;
        return this;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public ModelTWechatInfo setSchoolName(String lSchoolName) {
        schoolName = lSchoolName;
        return this;
    }

    public String getSourceId() {
        return sourceId;
    }

    public ModelTWechatInfo setSourceId(String lSourceId) {
        sourceId = lSourceId;
        return this;
    }

    public String getAttentionReply() {
        return attentionReply;
    }

    public ModelTWechatInfo setAttentionReply(String lAttentionReply) {
        attentionReply = lAttentionReply;
        return this;
    }

    public String getAutoReply() {
        return autoReply;
    }

    public ModelTWechatInfo setAutoReply(String lAutoReply) {
        autoReply = lAutoReply;
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
        if (getWechatName()!= null) {
            return false;
        }
        if (getAppId()!= null) {
            return false;
        }
        if (getAppSecret()!= null) {
            return false;
        }
        if (getCreatName()!= null) {
            return false;
        }
        if (getCreatTime()!= null) {
            return false;
        }
        if (getUpdateTime()!= null) {
            return false;
        }
        if (getSchoolName()!= null) {
            return false;
        }
        if (getSourceId()!= null) {
            return false;
        }
        if (getAttentionReply()!= null) {
            return false;
        }
        if (getAutoReply()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTWechatInfo.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTWechatInfo.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("wechatName").append(":").append(wechatName).append("}\n");
        ret.append("{").append("appId").append(":").append(appId).append("}\n");
        ret.append("{").append("appSecret").append(":").append(appSecret).append("}\n");
        ret.append("{").append("creatName").append(":").append(creatName).append("}\n");
        ret.append("{").append("creatTime").append(":").append(creatTime).append("}\n");
        ret.append("{").append("updateTime").append(":").append(updateTime).append("}\n");
        ret.append("{").append("schoolName").append(":").append(schoolName).append("}\n");
        ret.append("{").append("sourceId").append(":").append(sourceId).append("}\n");
        ret.append("{").append("attentionReply").append(":").append(attentionReply).append("}\n");
        ret.append("{").append("autoReply").append(":").append(autoReply).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelTWechatInfo
        implements RedisMapMapper<ModelTWechatInfo>
    {

        @Override
        public ModelTWechatInfo fromMap(Map<byte[], byte[]> map) {
            ModelTWechatInfo instance = new ModelTWechatInfo();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTWechatInfo.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTWechatInfo.FI_WECHAT_NAME)) {
                        instance.setWechatName(mapToFieldWechatName(entry.getValue()));
                    } else {
                        if (field.equals(ModelTWechatInfo.FI_APP_ID)) {
                            instance.setAppId(mapToFieldAppId(entry.getValue()));
                        } else {
                            if (field.equals(ModelTWechatInfo.FI_APP_SECRET)) {
                                instance.setAppSecret(mapToFieldAppSecret(entry.getValue()));
                            } else {
                                if (field.equals(ModelTWechatInfo.FI_CREAT_NAME)) {
                                    instance.setCreatName(mapToFieldCreatName(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTWechatInfo.FI_CREAT_TIME)) {
                                        instance.setCreatTime(mapToFieldCreatTime(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTWechatInfo.FI_UPDATE_TIME)) {
                                            instance.setUpdateTime(mapToFieldUpdateTime(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTWechatInfo.FI_SCHOOL_NAME)) {
                                                instance.setSchoolName(mapToFieldSchoolName(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTWechatInfo.FI_SOURCE_ID)) {
                                                    instance.setSourceId(mapToFieldSourceId(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
                                                        instance.setAttentionReply(mapToFieldAttentionReply(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTWechatInfo.FI_AUTO_REPLY)) {
                                                            instance.setAutoReply(mapToFieldAutoReply(entry.getValue()));
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

        protected String mapToFieldWechatName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldAppId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldAppSecret(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCreatName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldCreatTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Date mapToFieldUpdateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldSchoolName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldSourceId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldAttentionReply(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldAutoReply(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTWechatInfo instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTWechatInfo.FI_ID.getBytes(), valueId);
            byte[] valueWechat_name = mapFromFieldWechatName(instance.getWechatName());
            ret.put(ModelTWechatInfo.FI_WECHAT_NAME.getBytes(), valueWechat_name);
            byte[] valueApp_id = mapFromFieldAppId(instance.getAppId());
            ret.put(ModelTWechatInfo.FI_APP_ID.getBytes(), valueApp_id);
            byte[] valueApp_secret = mapFromFieldAppSecret(instance.getAppSecret());
            ret.put(ModelTWechatInfo.FI_APP_SECRET.getBytes(), valueApp_secret);
            byte[] valueCreat_name = mapFromFieldCreatName(instance.getCreatName());
            ret.put(ModelTWechatInfo.FI_CREAT_NAME.getBytes(), valueCreat_name);
            byte[] valueCreat_time = mapFromFieldCreatTime(instance.getCreatTime());
            ret.put(ModelTWechatInfo.FI_CREAT_TIME.getBytes(), valueCreat_time);
            byte[] valueUpdate_time = mapFromFieldUpdateTime(instance.getUpdateTime());
            ret.put(ModelTWechatInfo.FI_UPDATE_TIME.getBytes(), valueUpdate_time);
            byte[] valueSchool_name = mapFromFieldSchoolName(instance.getSchoolName());
            ret.put(ModelTWechatInfo.FI_SCHOOL_NAME.getBytes(), valueSchool_name);
            byte[] valueSource_id = mapFromFieldSourceId(instance.getSourceId());
            ret.put(ModelTWechatInfo.FI_SOURCE_ID.getBytes(), valueSource_id);
            byte[] valueAttention_reply = mapFromFieldAttentionReply(instance.getAttentionReply());
            ret.put(ModelTWechatInfo.FI_ATTENTION_REPLY.getBytes(), valueAttention_reply);
            byte[] valueAuto_reply = mapFromFieldAutoReply(instance.getAutoReply());
            ret.put(ModelTWechatInfo.FI_AUTO_REPLY.getBytes(), valueAuto_reply);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldWechatName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAppId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAppSecret(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCreatName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCreatTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUpdateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSchoolName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSourceId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAttentionReply(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAutoReply(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTWechatInfo instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTWechatInfo.FI_ID, dId);
            }
            String dWechat_name = instance.getWechatName();
            if (dWechat_name!= null) {
                ret.put(ModelTWechatInfo.FI_WECHAT_NAME, dWechat_name);
            }
            String dApp_id = instance.getAppId();
            if (dApp_id!= null) {
                ret.put(ModelTWechatInfo.FI_APP_ID, dApp_id);
            }
            String dApp_secret = instance.getAppSecret();
            if (dApp_secret!= null) {
                ret.put(ModelTWechatInfo.FI_APP_SECRET, dApp_secret);
            }
            String dCreat_name = instance.getCreatName();
            if (dCreat_name!= null) {
                ret.put(ModelTWechatInfo.FI_CREAT_NAME, dCreat_name);
            }
            Date dCreat_time = instance.getCreatTime();
            if (dCreat_time!= null) {
                ret.put(ModelTWechatInfo.FI_CREAT_TIME, dCreat_time);
            }
            Date dUpdate_time = instance.getUpdateTime();
            if (dUpdate_time!= null) {
                ret.put(ModelTWechatInfo.FI_UPDATE_TIME, dUpdate_time);
            }
            String dSchool_name = instance.getSchoolName();
            if (dSchool_name!= null) {
                ret.put(ModelTWechatInfo.FI_SCHOOL_NAME, dSchool_name);
            }
            String dSource_id = instance.getSourceId();
            if (dSource_id!= null) {
                ret.put(ModelTWechatInfo.FI_SOURCE_ID, dSource_id);
            }
            String dAttention_reply = instance.getAttentionReply();
            if (dAttention_reply!= null) {
                ret.put(ModelTWechatInfo.FI_ATTENTION_REPLY, dAttention_reply);
            }
            String dAuto_reply = instance.getAutoReply();
            if (dAuto_reply!= null) {
                ret.put(ModelTWechatInfo.FI_AUTO_REPLY, dAuto_reply);
            }
            return ret;
        }

        @Override
        public ModelTWechatInfo fromCommonMap(Map<String, Object> param) {
            ModelTWechatInfo ret = new ModelTWechatInfo();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelTWechatInfo.FI_ID);
            if (dId!= null) {
                this.setField(ModelTWechatInfo.FI_ID, ret, dId);
            }
            Object dWechat_name = param.get(ModelTWechatInfo.FI_WECHAT_NAME);
            if (dWechat_name!= null) {
                this.setField(ModelTWechatInfo.FI_WECHAT_NAME, ret, dWechat_name);
            }
            Object dApp_id = param.get(ModelTWechatInfo.FI_APP_ID);
            if (dApp_id!= null) {
                this.setField(ModelTWechatInfo.FI_APP_ID, ret, dApp_id);
            }
            Object dApp_secret = param.get(ModelTWechatInfo.FI_APP_SECRET);
            if (dApp_secret!= null) {
                this.setField(ModelTWechatInfo.FI_APP_SECRET, ret, dApp_secret);
            }
            Object dCreat_name = param.get(ModelTWechatInfo.FI_CREAT_NAME);
            if (dCreat_name!= null) {
                this.setField(ModelTWechatInfo.FI_CREAT_NAME, ret, dCreat_name);
            }
            Object dCreat_time = param.get(ModelTWechatInfo.FI_CREAT_TIME);
            if (dCreat_time!= null) {
                this.setField(ModelTWechatInfo.FI_CREAT_TIME, ret, dCreat_time);
            }
            Object dUpdate_time = param.get(ModelTWechatInfo.FI_UPDATE_TIME);
            if (dUpdate_time!= null) {
                this.setField(ModelTWechatInfo.FI_UPDATE_TIME, ret, dUpdate_time);
            }
            Object dSchool_name = param.get(ModelTWechatInfo.FI_SCHOOL_NAME);
            if (dSchool_name!= null) {
                this.setField(ModelTWechatInfo.FI_SCHOOL_NAME, ret, dSchool_name);
            }
            Object dSource_id = param.get(ModelTWechatInfo.FI_SOURCE_ID);
            if (dSource_id!= null) {
                this.setField(ModelTWechatInfo.FI_SOURCE_ID, ret, dSource_id);
            }
            Object dAttention_reply = param.get(ModelTWechatInfo.FI_ATTENTION_REPLY);
            if (dAttention_reply!= null) {
                this.setField(ModelTWechatInfo.FI_ATTENTION_REPLY, ret, dAttention_reply);
            }
            Object dAuto_reply = param.get(ModelTWechatInfo.FI_AUTO_REPLY);
            if (dAuto_reply!= null) {
                this.setField(ModelTWechatInfo.FI_AUTO_REPLY, ret, dAuto_reply);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldWechatName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldAppId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldAppSecret(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCreatName(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldCreatTime(Object obj) {
            return ((Date) obj);
        }

        protected Date mapToFieldUpdateTime(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldSchoolName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldSourceId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldAttentionReply(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldAutoReply(Object obj) {
            return ((String) obj);
        }

        public<TT> TT getField(String field, ModelTWechatInfo instance) {
            try {
                if (field.equals(ModelTWechatInfo.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTWechatInfo.FI_WECHAT_NAME)) {
                        return ((TT) instance.getWechatName());
                    } else {
                        if (field.equals(ModelTWechatInfo.FI_APP_ID)) {
                            return ((TT) instance.getAppId());
                        } else {
                            if (field.equals(ModelTWechatInfo.FI_APP_SECRET)) {
                                return ((TT) instance.getAppSecret());
                            } else {
                                if (field.equals(ModelTWechatInfo.FI_CREAT_NAME)) {
                                    return ((TT) instance.getCreatName());
                                } else {
                                    if (field.equals(ModelTWechatInfo.FI_CREAT_TIME)) {
                                        return ((TT) instance.getCreatTime());
                                    } else {
                                        if (field.equals(ModelTWechatInfo.FI_UPDATE_TIME)) {
                                            return ((TT) instance.getUpdateTime());
                                        } else {
                                            if (field.equals(ModelTWechatInfo.FI_SCHOOL_NAME)) {
                                                return ((TT) instance.getSchoolName());
                                            } else {
                                                if (field.equals(ModelTWechatInfo.FI_SOURCE_ID)) {
                                                    return ((TT) instance.getSourceId());
                                                } else {
                                                    if (field.equals(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
                                                        return ((TT) instance.getAttentionReply());
                                                    } else {
                                                        if (field.equals(ModelTWechatInfo.FI_AUTO_REPLY)) {
                                                            return ((TT) instance.getAutoReply());
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

        public<TT> void setField(String field, ModelTWechatInfo instance, TT value) {
            if (field.equals(ModelTWechatInfo.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTWechatInfo.FI_WECHAT_NAME)) {
                    try {
                        instance.setWechatName(mapToFieldWechatName(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTWechatInfo.FI_APP_ID)) {
                        try {
                            instance.setAppId(mapToFieldAppId(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTWechatInfo.FI_APP_SECRET)) {
                            try {
                                instance.setAppSecret(mapToFieldAppSecret(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTWechatInfo.FI_CREAT_NAME)) {
                                try {
                                    instance.setCreatName(mapToFieldCreatName(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTWechatInfo.FI_CREAT_TIME)) {
                                    try {
                                        instance.setCreatTime(mapToFieldCreatTime(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTWechatInfo.FI_UPDATE_TIME)) {
                                        try {
                                            instance.setUpdateTime(mapToFieldUpdateTime(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTWechatInfo.FI_SCHOOL_NAME)) {
                                            try {
                                                instance.setSchoolName(mapToFieldSchoolName(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTWechatInfo.FI_SOURCE_ID)) {
                                                try {
                                                    instance.setSourceId(mapToFieldSourceId(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
                                                    try {
                                                        instance.setAttentionReply(mapToFieldAttentionReply(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTWechatInfo.FI_AUTO_REPLY)) {
                                                        try {
                                                            instance.setAutoReply(mapToFieldAutoReply(value));
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

        public void setField(String field, ModelTWechatInfo instance, byte[] value) {
            if (field.equals(ModelTWechatInfo.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTWechatInfo.FI_WECHAT_NAME)) {
                    instance.setWechatName(mapToFieldWechatName(value));
                } else {
                    if (field.equals(ModelTWechatInfo.FI_APP_ID)) {
                        instance.setAppId(mapToFieldAppId(value));
                    } else {
                        if (field.equals(ModelTWechatInfo.FI_APP_SECRET)) {
                            instance.setAppSecret(mapToFieldAppSecret(value));
                        } else {
                            if (field.equals(ModelTWechatInfo.FI_CREAT_NAME)) {
                                instance.setCreatName(mapToFieldCreatName(value));
                            } else {
                                if (field.equals(ModelTWechatInfo.FI_CREAT_TIME)) {
                                    instance.setCreatTime(mapToFieldCreatTime(value));
                                } else {
                                    if (field.equals(ModelTWechatInfo.FI_UPDATE_TIME)) {
                                        instance.setUpdateTime(mapToFieldUpdateTime(value));
                                    } else {
                                        if (field.equals(ModelTWechatInfo.FI_SCHOOL_NAME)) {
                                            instance.setSchoolName(mapToFieldSchoolName(value));
                                        } else {
                                            if (field.equals(ModelTWechatInfo.FI_SOURCE_ID)) {
                                                instance.setSourceId(mapToFieldSourceId(value));
                                            } else {
                                                if (field.equals(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
                                                    instance.setAttentionReply(mapToFieldAttentionReply(value));
                                                } else {
                                                    if (field.equals(ModelTWechatInfo.FI_AUTO_REPLY)) {
                                                        instance.setAutoReply(mapToFieldAutoReply(value));
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

    public static class ResultSetMapperModelTWechatInfo<T extends ModelTWechatInfo>
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
            return ((T) new ModelTWechatInfo());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldWechat_name(rs, columnNames, instance);
            mapFieldApp_id(rs, columnNames, instance);
            mapFieldApp_secret(rs, columnNames, instance);
            mapFieldCreat_name(rs, columnNames, instance);
            mapFieldCreat_time(rs, columnNames, instance);
            mapFieldUpdate_time(rs, columnNames, instance);
            mapFieldSchool_name(rs, columnNames, instance);
            mapFieldSource_id(rs, columnNames, instance);
            mapFieldAttention_reply(rs, columnNames, instance);
            mapFieldAuto_reply(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_ID)) {
                instance.setId(rs.getInt(ModelTWechatInfo.FI_ID));
            }
        }

        protected void mapFieldWechat_name(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_WECHAT_NAME)) {
                instance.setWechatName(rs.getString(ModelTWechatInfo.FI_WECHAT_NAME));
            }
        }

        protected void mapFieldApp_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_APP_ID)) {
                instance.setAppId(rs.getString(ModelTWechatInfo.FI_APP_ID));
            }
        }

        protected void mapFieldApp_secret(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_APP_SECRET)) {
                instance.setAppSecret(rs.getString(ModelTWechatInfo.FI_APP_SECRET));
            }
        }

        protected void mapFieldCreat_name(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_CREAT_NAME)) {
                instance.setCreatName(rs.getString(ModelTWechatInfo.FI_CREAT_NAME));
            }
        }

        protected void mapFieldCreat_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_CREAT_TIME)) {
                instance.setCreatTime(rs.getTimestamp(ModelTWechatInfo.FI_CREAT_TIME));
            }
        }

        protected void mapFieldUpdate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_UPDATE_TIME)) {
                instance.setUpdateTime(rs.getTimestamp(ModelTWechatInfo.FI_UPDATE_TIME));
            }
        }

        protected void mapFieldSchool_name(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_SCHOOL_NAME)) {
                instance.setSchoolName(rs.getString(ModelTWechatInfo.FI_SCHOOL_NAME));
            }
        }

        protected void mapFieldSource_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_SOURCE_ID)) {
                instance.setSourceId(rs.getString(ModelTWechatInfo.FI_SOURCE_ID));
            }
        }

        protected void mapFieldAttention_reply(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_ATTENTION_REPLY)) {
                instance.setAttentionReply(rs.getString(ModelTWechatInfo.FI_ATTENTION_REPLY));
            }
        }

        protected void mapFieldAuto_reply(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTWechatInfo.FI_AUTO_REPLY)) {
                instance.setAutoReply(rs.getString(ModelTWechatInfo.FI_AUTO_REPLY));
            }
        }
    }
}
