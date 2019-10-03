/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.master.dmo.user.dto.basedto;

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
 * base DTO,represent for table :t_user_login_auth_sys_info
 * 	
 */
public class ModelTUserLoginAuthSysInfo
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_user_login_auth_sys_info";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.t_user_login_auth_sys_info.id 字段
     * 主键id
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.t_user_login_auth_sys_info.channel 字段
     * 单设备登录渠道
     */
    String channel;
    public final static String FI_CHANNEL = "channel";
    /**
     * 对应数据库.t_user_login_auth_sys_info.check_login 字段
     * 是否校验单设备登录（true：校验）
     */
    String checkLogin;
    public final static String FI_CHECK_LOGIN = "check_login";
    /**
     * 对应数据库.t_user_login_auth_sys_info.check_login_gray_list 字段
     * 是否验证灰度名单（true:验证）
     */
    String checkLoginGrayList;
    public final static String FI_CHECK_LOGIN_GRAY_LIST = "check_login_gray_list";
    /**
     * 对应数据库.t_user_login_auth_sys_info.check_login_white_list 字段
     * 是否验证白名单（true:验证）
     */
    String checkLoginWhiteList;
    public final static String FI_CHECK_LOGIN_WHITE_LIST = "check_login_white_list";
    /**
     * 对应数据库.t_user_login_auth_sys_info.check_pay 字段
     * 
     */
    String checkPay;
    public final static String FI_CHECK_PAY = "check_pay";
    /**
     * 对应数据库.t_user_login_auth_sys_info.login_expire_time 字段
     * userAuth存活时间
     */
    Long loginExpireTime;
    public final static String FI_LOGIN_EXPIRE_TIME = "login_expire_time";
    /**
     * 对应数据库.t_user_login_auth_sys_info.extend_expire_time 字段
     * 续期更换userAuth间隔时间
     */
    Long extendExpireTime;
    public final static String FI_EXTEND_EXPIRE_TIME = "extend_expire_time";
    /**
     * 对应数据库.t_user_login_auth_sys_info.last_login_remain_time 字段
     * 登陆后原userAuth有效时间
     */
    Long lastLoginRemainTime;
    public final static String FI_LAST_LOGIN_REMAIN_TIME = "last_login_remain_time";
    /**
     * 对应数据库.t_user_login_auth_sys_info.last_extend_remain_time 字段
     * 续期后原userAuth有效时间
     */
    Long lastExtendRemainTime;
    public final static String FI_LAST_EXTEND_REMAIN_TIME = "last_extend_remain_time";
    /**
     * 对应数据库.t_user_login_auth_sys_info.create_time 字段
     * 创建时间
     */
    Date createTime;
    public final static String FI_CREATE_TIME = "create_time";
    /**
     * 对应数据库.t_user_login_auth_sys_info.delete_flag 字段
     *  0：有效 1：删除
     */
    Integer deleteFlag;
    public final static String FI_DELETE_FLAG = "delete_flag";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTUserLoginAuthSysInfo.FI_ID, Integer.class).put(ModelTUserLoginAuthSysInfo.FI_CHANNEL, String.class).put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, String.class).put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, String.class).put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, String.class).put(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, String.class).put(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, Long.class).put(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, Long.class).put(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, Long.class).put(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, Long.class).put(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, Date.class).put(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, Integer.class).getMap();
    public final static Integer FIELD_COUNT = 12;
    public final static ResultSetMapperModelTUserLoginAuthSysInfo<ModelTUserLoginAuthSysInfo> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelTUserLoginAuthSysInfo<com.shangde.master.dmo.user.dto.basedto.ModelTUserLoginAuthSysInfo>();
    public final static ByteMapMapperModelTUserLoginAuthSysInfo MAP_OBJ_MAPPER = new ByteMapMapperModelTUserLoginAuthSysInfo();

    public ModelTUserLoginAuthSysInfo() {
    }

    public final Integer getId() {
        return id;
    }

    public final ModelTUserLoginAuthSysInfo setId(Integer lId) {
        id = lId;
        return this;
    }

    public final String getChannel() {
        return channel;
    }

    public final ModelTUserLoginAuthSysInfo setChannel(String lChannel) {
        channel = lChannel;
        return this;
    }

    public final String getCheckLogin() {
        return checkLogin;
    }

    public final ModelTUserLoginAuthSysInfo setCheckLogin(String lCheckLogin) {
        checkLogin = lCheckLogin;
        return this;
    }

    public final String getCheckLoginGrayList() {
        return checkLoginGrayList;
    }

    public final ModelTUserLoginAuthSysInfo setCheckLoginGrayList(String lCheckLoginGrayList) {
        checkLoginGrayList = lCheckLoginGrayList;
        return this;
    }

    public final String getCheckLoginWhiteList() {
        return checkLoginWhiteList;
    }

    public final ModelTUserLoginAuthSysInfo setCheckLoginWhiteList(String lCheckLoginWhiteList) {
        checkLoginWhiteList = lCheckLoginWhiteList;
        return this;
    }

    public final String getCheckPay() {
        return checkPay;
    }

    public final ModelTUserLoginAuthSysInfo setCheckPay(String lCheckPay) {
        checkPay = lCheckPay;
        return this;
    }

    public final Long getLoginExpireTime() {
        return loginExpireTime;
    }

    public final ModelTUserLoginAuthSysInfo setLoginExpireTime(Long lLoginExpireTime) {
        loginExpireTime = lLoginExpireTime;
        return this;
    }

    public final Long getExtendExpireTime() {
        return extendExpireTime;
    }

    public final ModelTUserLoginAuthSysInfo setExtendExpireTime(Long lExtendExpireTime) {
        extendExpireTime = lExtendExpireTime;
        return this;
    }

    public final Long getLastLoginRemainTime() {
        return lastLoginRemainTime;
    }

    public final ModelTUserLoginAuthSysInfo setLastLoginRemainTime(Long lLastLoginRemainTime) {
        lastLoginRemainTime = lLastLoginRemainTime;
        return this;
    }

    public final Long getLastExtendRemainTime() {
        return lastExtendRemainTime;
    }

    public final ModelTUserLoginAuthSysInfo setLastExtendRemainTime(Long lLastExtendRemainTime) {
        lastExtendRemainTime = lLastExtendRemainTime;
        return this;
    }

    public final Date getCreateTime() {
        return createTime;
    }

    public final ModelTUserLoginAuthSysInfo setCreateTime(Date lCreateTime) {
        createTime = lCreateTime;
        return this;
    }

    public final Integer getDeleteFlag() {
        return deleteFlag;
    }

    public final ModelTUserLoginAuthSysInfo setDeleteFlag(Integer lDeleteFlag) {
        deleteFlag = lDeleteFlag;
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
        if (getChannel()!= null) {
            return false;
        }
        if (getCheckLogin()!= null) {
            return false;
        }
        if (getCheckLoginGrayList()!= null) {
            return false;
        }
        if (getCheckLoginWhiteList()!= null) {
            return false;
        }
        if (getCheckPay()!= null) {
            return false;
        }
        if (getLoginExpireTime()!= null) {
            return false;
        }
        if (getExtendExpireTime()!= null) {
            return false;
        }
        if (getLastLoginRemainTime()!= null) {
            return false;
        }
        if (getLastExtendRemainTime()!= null) {
            return false;
        }
        if (getCreateTime()!= null) {
            return false;
        }
        if (getDeleteFlag()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUserLoginAuthSysInfo.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUserLoginAuthSysInfo.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("channel").append(":").append(channel).append("}\n");
        ret.append("{").append("checkLogin").append(":").append(checkLogin).append("}\n");
        ret.append("{").append("checkLoginGrayList").append(":").append(checkLoginGrayList).append("}\n");
        ret.append("{").append("checkLoginWhiteList").append(":").append(checkLoginWhiteList).append("}\n");
        ret.append("{").append("checkPay").append(":").append(checkPay).append("}\n");
        ret.append("{").append("loginExpireTime").append(":").append(loginExpireTime).append("}\n");
        ret.append("{").append("extendExpireTime").append(":").append(extendExpireTime).append("}\n");
        ret.append("{").append("lastLoginRemainTime").append(":").append(lastLoginRemainTime).append("}\n");
        ret.append("{").append("lastExtendRemainTime").append(":").append(lastExtendRemainTime).append("}\n");
        ret.append("{").append("createTime").append(":").append(createTime).append("}\n");
        ret.append("{").append("deleteFlag").append(":").append(deleteFlag).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelTUserLoginAuthSysInfo
        implements RedisMapMapper<ModelTUserLoginAuthSysInfo>
    {

        @Override
        public ModelTUserLoginAuthSysInfo fromMap(Map<byte[], byte[]> map) {
            ModelTUserLoginAuthSysInfo instance = new ModelTUserLoginAuthSysInfo();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTUserLoginAuthSysInfo.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
                        instance.setChannel(mapToFieldChannel(entry.getValue()));
                    } else {
                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
                            instance.setCheckLogin(mapToFieldCheckLogin(entry.getValue()));
                        } else {
                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
                                instance.setCheckLoginGrayList(mapToFieldCheckLoginGrayList(entry.getValue()));
                            } else {
                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
                                    instance.setCheckLoginWhiteList(mapToFieldCheckLoginWhiteList(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
                                        instance.setCheckPay(mapToFieldCheckPay(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
                                            instance.setLoginExpireTime(mapToFieldLoginExpireTime(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
                                                instance.setExtendExpireTime(mapToFieldExtendExpireTime(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
                                                    instance.setLastLoginRemainTime(mapToFieldLastLoginRemainTime(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
                                                        instance.setLastExtendRemainTime(mapToFieldLastExtendRemainTime(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
                                                            instance.setCreateTime(mapToFieldCreateTime(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
                                                                instance.setDeleteFlag(mapToFieldDeleteFlag(entry.getValue()));
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

        protected String mapToFieldChannel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCheckLogin(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCheckLoginGrayList(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCheckLoginWhiteList(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCheckPay(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Long mapToFieldLoginExpireTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldExtendExpireTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldLastLoginRemainTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldLastExtendRemainTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Date mapToFieldCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Integer mapToFieldDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTUserLoginAuthSysInfo instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTUserLoginAuthSysInfo.FI_ID.getBytes(), valueId);
            byte[] valueChannel = mapFromFieldChannel(instance.getChannel());
            ret.put(ModelTUserLoginAuthSysInfo.FI_CHANNEL.getBytes(), valueChannel);
            byte[] valueCheck_login = mapFromFieldCheckLogin(instance.getCheckLogin());
            ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN.getBytes(), valueCheck_login);
            byte[] valueCheck_login_gray_list = mapFromFieldCheckLoginGrayList(instance.getCheckLoginGrayList());
            ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST.getBytes(), valueCheck_login_gray_list);
            byte[] valueCheck_login_white_list = mapFromFieldCheckLoginWhiteList(instance.getCheckLoginWhiteList());
            ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST.getBytes(), valueCheck_login_white_list);
            byte[] valueCheck_pay = mapFromFieldCheckPay(instance.getCheckPay());
            ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY.getBytes(), valueCheck_pay);
            byte[] valueLogin_expire_time = mapFromFieldLoginExpireTime(instance.getLoginExpireTime());
            ret.put(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME.getBytes(), valueLogin_expire_time);
            byte[] valueExtend_expire_time = mapFromFieldExtendExpireTime(instance.getExtendExpireTime());
            ret.put(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME.getBytes(), valueExtend_expire_time);
            byte[] valueLast_login_remain_time = mapFromFieldLastLoginRemainTime(instance.getLastLoginRemainTime());
            ret.put(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME.getBytes(), valueLast_login_remain_time);
            byte[] valueLast_extend_remain_time = mapFromFieldLastExtendRemainTime(instance.getLastExtendRemainTime());
            ret.put(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME.getBytes(), valueLast_extend_remain_time);
            byte[] valueCreate_time = mapFromFieldCreateTime(instance.getCreateTime());
            ret.put(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME.getBytes(), valueCreate_time);
            byte[] valueDelete_flag = mapFromFieldDeleteFlag(instance.getDeleteFlag());
            ret.put(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG.getBytes(), valueDelete_flag);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldChannel(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCheckLogin(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCheckLoginGrayList(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCheckLoginWhiteList(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCheckPay(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldLoginExpireTime(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldExtendExpireTime(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldLastLoginRemainTime(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldLastExtendRemainTime(Long field) {
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

        @Override
        public Map<String, Object> toCommonMap(ModelTUserLoginAuthSysInfo instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_ID, dId);
            }
            String dChannel = instance.getChannel();
            if (dChannel!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_CHANNEL, dChannel);
            }
            String dCheck_login = instance.getCheckLogin();
            if (dCheck_login!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN, dCheck_login);
            }
            String dCheck_login_gray_list = instance.getCheckLoginGrayList();
            if (dCheck_login_gray_list!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST, dCheck_login_gray_list);
            }
            String dCheck_login_white_list = instance.getCheckLoginWhiteList();
            if (dCheck_login_white_list!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST, dCheck_login_white_list);
            }
            String dCheck_pay = instance.getCheckPay();
            if (dCheck_pay!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY, dCheck_pay);
            }
            Long dLogin_expire_time = instance.getLoginExpireTime();
            if (dLogin_expire_time!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME, dLogin_expire_time);
            }
            Long dExtend_expire_time = instance.getExtendExpireTime();
            if (dExtend_expire_time!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME, dExtend_expire_time);
            }
            Long dLast_login_remain_time = instance.getLastLoginRemainTime();
            if (dLast_login_remain_time!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME, dLast_login_remain_time);
            }
            Long dLast_extend_remain_time = instance.getLastExtendRemainTime();
            if (dLast_extend_remain_time!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME, dLast_extend_remain_time);
            }
            Date dCreate_time = instance.getCreateTime();
            if (dCreate_time!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME, dCreate_time);
            }
            Integer dDelete_flag = instance.getDeleteFlag();
            if (dDelete_flag!= null) {
                ret.put(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG, dDelete_flag);
            }
            return ret;
        }

        public<TT> TT getField(String field, ModelTUserLoginAuthSysInfo instance) {
            try {
                if (field.equals(ModelTUserLoginAuthSysInfo.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
                        return ((TT) instance.getChannel());
                    } else {
                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
                            return ((TT) instance.getCheckLogin());
                        } else {
                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
                                return ((TT) instance.getCheckLoginGrayList());
                            } else {
                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
                                    return ((TT) instance.getCheckLoginWhiteList());
                                } else {
                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
                                        return ((TT) instance.getCheckPay());
                                    } else {
                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
                                            return ((TT) instance.getLoginExpireTime());
                                        } else {
                                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
                                                return ((TT) instance.getExtendExpireTime());
                                            } else {
                                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
                                                    return ((TT) instance.getLastLoginRemainTime());
                                                } else {
                                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
                                                        return ((TT) instance.getLastExtendRemainTime());
                                                    } else {
                                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
                                                            return ((TT) instance.getCreateTime());
                                                        } else {
                                                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
                                                                return ((TT) instance.getDeleteFlag());
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

        public<TT> void setField(String field, ModelTUserLoginAuthSysInfo instance, TT value) {
            if (field.equals(ModelTUserLoginAuthSysInfo.FI_ID)) {
                try {
                    instance.setId(((Integer) value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
                    try {
                        instance.setChannel(((String) value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
                        try {
                            instance.setCheckLogin(((String) value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
                            try {
                                instance.setCheckLoginGrayList(((String) value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
                                try {
                                    instance.setCheckLoginWhiteList(((String) value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
                                    try {
                                        instance.setCheckPay(((String) value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
                                        try {
                                            instance.setLoginExpireTime(((Long) value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
                                            try {
                                                instance.setExtendExpireTime(((Long) value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
                                                try {
                                                    instance.setLastLoginRemainTime(((Long) value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
                                                    try {
                                                        instance.setLastExtendRemainTime(((Long) value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
                                                        try {
                                                            instance.setCreateTime(((Date) value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
                                                            try {
                                                                instance.setDeleteFlag(((Integer) value));
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

        public void setField(String field, ModelTUserLoginAuthSysInfo instance, byte[] value) {
            if (field.equals(ModelTUserLoginAuthSysInfo.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
                    instance.setChannel(mapToFieldChannel(value));
                } else {
                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
                        instance.setCheckLogin(mapToFieldCheckLogin(value));
                    } else {
                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
                            instance.setCheckLoginGrayList(mapToFieldCheckLoginGrayList(value));
                        } else {
                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
                                instance.setCheckLoginWhiteList(mapToFieldCheckLoginWhiteList(value));
                            } else {
                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
                                    instance.setCheckPay(mapToFieldCheckPay(value));
                                } else {
                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
                                        instance.setLoginExpireTime(mapToFieldLoginExpireTime(value));
                                    } else {
                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
                                            instance.setExtendExpireTime(mapToFieldExtendExpireTime(value));
                                        } else {
                                            if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
                                                instance.setLastLoginRemainTime(mapToFieldLastLoginRemainTime(value));
                                            } else {
                                                if (field.equals(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
                                                    instance.setLastExtendRemainTime(mapToFieldLastExtendRemainTime(value));
                                                } else {
                                                    if (field.equals(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
                                                        instance.setCreateTime(mapToFieldCreateTime(value));
                                                    } else {
                                                        if (field.equals(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
                                                            instance.setDeleteFlag(mapToFieldDeleteFlag(value));
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

    public static class ResultSetMapperModelTUserLoginAuthSysInfo<T extends ModelTUserLoginAuthSysInfo>
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
            return ((T) new ModelTUserLoginAuthSysInfo());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldChannel(rs, columnNames, instance);
            mapFieldCheck_login(rs, columnNames, instance);
            mapFieldCheck_login_gray_list(rs, columnNames, instance);
            mapFieldCheck_login_white_list(rs, columnNames, instance);
            mapFieldCheck_pay(rs, columnNames, instance);
            mapFieldLogin_expire_time(rs, columnNames, instance);
            mapFieldExtend_expire_time(rs, columnNames, instance);
            mapFieldLast_login_remain_time(rs, columnNames, instance);
            mapFieldLast_extend_remain_time(rs, columnNames, instance);
            mapFieldCreate_time(rs, columnNames, instance);
            mapFieldDelete_flag(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_ID)) {
                instance.setId(rs.getInt(ModelTUserLoginAuthSysInfo.FI_ID));
            }
        }

        protected void mapFieldChannel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_CHANNEL)) {
                instance.setChannel(rs.getString(ModelTUserLoginAuthSysInfo.FI_CHANNEL));
            }
        }

        protected void mapFieldCheck_login(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN)) {
                instance.setCheckLogin(rs.getString(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN));
            }
        }

        protected void mapFieldCheck_login_gray_list(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST)) {
                instance.setCheckLoginGrayList(rs.getString(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_GRAY_LIST));
            }
        }

        protected void mapFieldCheck_login_white_list(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST)) {
                instance.setCheckLoginWhiteList(rs.getString(ModelTUserLoginAuthSysInfo.FI_CHECK_LOGIN_WHITE_LIST));
            }
        }

        protected void mapFieldCheck_pay(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY)) {
                instance.setCheckPay(rs.getString(ModelTUserLoginAuthSysInfo.FI_CHECK_PAY));
            }
        }

        protected void mapFieldLogin_expire_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME)) {
                instance.setLoginExpireTime(rs.getLong(ModelTUserLoginAuthSysInfo.FI_LOGIN_EXPIRE_TIME));
            }
        }

        protected void mapFieldExtend_expire_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME)) {
                instance.setExtendExpireTime(rs.getLong(ModelTUserLoginAuthSysInfo.FI_EXTEND_EXPIRE_TIME));
            }
        }

        protected void mapFieldLast_login_remain_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME)) {
                instance.setLastLoginRemainTime(rs.getLong(ModelTUserLoginAuthSysInfo.FI_LAST_LOGIN_REMAIN_TIME));
            }
        }

        protected void mapFieldLast_extend_remain_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME)) {
                instance.setLastExtendRemainTime(rs.getLong(ModelTUserLoginAuthSysInfo.FI_LAST_EXTEND_REMAIN_TIME));
            }
        }

        protected void mapFieldCreate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME)) {
                instance.setCreateTime(rs.getTimestamp(ModelTUserLoginAuthSysInfo.FI_CREATE_TIME));
            }
        }

        protected void mapFieldDelete_flag(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG)) {
                instance.setDeleteFlag(rs.getInt(ModelTUserLoginAuthSysInfo.FI_DELETE_FLAG));
            }
        }
    }
}
