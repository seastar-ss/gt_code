/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;


/**
 * base DTO,represent for  :b_user
 */
public class ModelBUser
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 登录用用户名，全局唯一
     */
    String userName;
    public final static String FI_USER_NAME = "user_name";
    /**
     * 用户展示名称
     */
    String userShowName;
    public final static String FI_USER_SHOW_NAME = "user_show_name";
    /**
     * 用户密码，hash(hash(origin_password+user_name)+user_salt)
     */
    String userPwd;
    public final static String FI_USER_PWD = "user_pwd";
    /**
     * 用户手机号，可用于登录
     */
    String userMobile;
    public final static String FI_USER_MOBILE = "user_mobile";
    /**
     * 用户创建时间
     */
    Date userCreateTime;
    public final static String FI_USER_CREATE_TIME = "user_create_time";
    /**
     * 用户随机字符串，用于提高安全性
     */
    String userSalt;
    public final static String FI_USER_SALT = "user_salt";
    /**
     * 用户微信号，需用户自己填写，作为附加联系方式
     */
    String userWx;
    public final static String FI_USER_WX = "user_wx";
    /**
     * 用户邮箱
     */
    String userEmail;
    public final static String FI_USER_EMAIL = "user_email";
    /**
     * 用户信息更新时间
     */
    Date userModifyTime;
    public final static String FI_USER_MODIFY_TIME = "user_modify_time";
    /**
     * 用户图片，大图
     */
    String userImage;
    public final static String FI_USER_IMAGE = "user_image";
    /**
     * 用户头像，小图
     */
    String userAvatar;
    public final static String FI_USER_AVATAR = "user_avatar";
    Byte userStatus;
    public final static String FI_USER_STATUS = "user_status";
    /**
     * 用户微信openId，用于触达
     */
    String userWxOpenId;
    public final static String FI_USER_WX_OPEN_ID = "user_wx_open_id";
    /**
     * 用户推送用token
     */
    String userPushToken;
    public final static String FI_USER_PUSH_TOKEN = "user_push_token";
    /**
     * 删除标记
     */
    Byte userDeleteFlag;
    public final static String FI_USER_DELETE_FLAG = "user_delete_flag";
    /**
     * 用户类型
     */
    Integer userType;
    public final static String FI_USER_TYPE = "user_type";
    /**
     * 注册来源
     */
    String userProvider;
    public final static String FI_USER_PROVIDER = "user_provider";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelBUser.FI_ID, Integer.class).put(ModelBUser.FI_USER_NAME, String.class).put(ModelBUser.FI_USER_SHOW_NAME, String.class).put(ModelBUser.FI_USER_PWD, String.class).put(ModelBUser.FI_USER_MOBILE, String.class).put(ModelBUser.FI_USER_CREATE_TIME, Date.class).put(ModelBUser.FI_USER_SALT, String.class).put(ModelBUser.FI_USER_WX, String.class).put(ModelBUser.FI_USER_EMAIL, String.class).put(ModelBUser.FI_USER_MODIFY_TIME, Date.class).put(ModelBUser.FI_USER_IMAGE, String.class).put(ModelBUser.FI_USER_AVATAR, String.class).put(ModelBUser.FI_USER_STATUS, Byte.class).put(ModelBUser.FI_USER_WX_OPEN_ID, String.class).put(ModelBUser.FI_USER_PUSH_TOKEN, String.class).put(ModelBUser.FI_USER_DELETE_FLAG, Byte.class).put(ModelBUser.FI_USER_TYPE, Integer.class).put(ModelBUser.FI_USER_PROVIDER, String.class).getMap();
    public final static Integer FIELD_COUNT = 18;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "b_user";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelBUser() {
    }

    public Integer getId() {
        return id;
    }

    public ModelBUser setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ModelBUser setUserName(String lUserName) {
        userName = lUserName;
        return this;
    }

    public String getUserShowName() {
        return userShowName;
    }

    public ModelBUser setUserShowName(String lUserShowName) {
        userShowName = lUserShowName;
        return this;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public ModelBUser setUserPwd(String lUserPwd) {
        userPwd = lUserPwd;
        return this;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public ModelBUser setUserMobile(String lUserMobile) {
        userMobile = lUserMobile;
        return this;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public ModelBUser setUserCreateTime(Date lUserCreateTime) {
        userCreateTime = lUserCreateTime;
        return this;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public ModelBUser setUserSalt(String lUserSalt) {
        userSalt = lUserSalt;
        return this;
    }

    public String getUserWx() {
        return userWx;
    }

    public ModelBUser setUserWx(String lUserWx) {
        userWx = lUserWx;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public ModelBUser setUserEmail(String lUserEmail) {
        userEmail = lUserEmail;
        return this;
    }

    public Date getUserModifyTime() {
        return userModifyTime;
    }

    public ModelBUser setUserModifyTime(Date lUserModifyTime) {
        userModifyTime = lUserModifyTime;
        return this;
    }

    public String getUserImage() {
        return userImage;
    }

    public ModelBUser setUserImage(String lUserImage) {
        userImage = lUserImage;
        return this;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public ModelBUser setUserAvatar(String lUserAvatar) {
        userAvatar = lUserAvatar;
        return this;
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public ModelBUser setUserStatus(Byte lUserStatus) {
        userStatus = lUserStatus;
        return this;
    }

    public String getUserWxOpenId() {
        return userWxOpenId;
    }

    public ModelBUser setUserWxOpenId(String lUserWxOpenId) {
        userWxOpenId = lUserWxOpenId;
        return this;
    }

    public String getUserPushToken() {
        return userPushToken;
    }

    public ModelBUser setUserPushToken(String lUserPushToken) {
        userPushToken = lUserPushToken;
        return this;
    }

    public Byte getUserDeleteFlag() {
        return userDeleteFlag;
    }

    public ModelBUser setUserDeleteFlag(Byte lUserDeleteFlag) {
        userDeleteFlag = lUserDeleteFlag;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public ModelBUser setUserType(Integer lUserType) {
        userType = lUserType;
        return this;
    }

    public String getUserProvider() {
        return userProvider;
    }

    public ModelBUser setUserProvider(String lUserProvider) {
        userProvider = lUserProvider;
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
        if (getUserName()!= null) {
            return false;
        }
        if (getUserShowName()!= null) {
            return false;
        }
        if (getUserPwd()!= null) {
            return false;
        }
        if (getUserMobile()!= null) {
            return false;
        }
        if (getUserCreateTime()!= null) {
            return false;
        }
        if (getUserSalt()!= null) {
            return false;
        }
        if (getUserWx()!= null) {
            return false;
        }
        if (getUserEmail()!= null) {
            return false;
        }
        if (getUserModifyTime()!= null) {
            return false;
        }
        if (getUserImage()!= null) {
            return false;
        }
        if (getUserAvatar()!= null) {
            return false;
        }
        if (getUserStatus()!= null) {
            return false;
        }
        if (getUserWxOpenId()!= null) {
            return false;
        }
        if (getUserPushToken()!= null) {
            return false;
        }
        if (getUserDeleteFlag()!= null) {
            return false;
        }
        if (getUserType()!= null) {
            return false;
        }
        if (getUserProvider()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _APIObj> FT getFeature(Class<FT> clazz) {
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("userName").append(":").append(userName).append("}\n");
        ret.append("{").append("userShowName").append(":").append(userShowName).append("}\n");
        ret.append("{").append("userPwd").append(":").append(userPwd).append("}\n");
        ret.append("{").append("userMobile").append(":").append(userMobile).append("}\n");
        ret.append("{").append("userCreateTime").append(":").append(userCreateTime).append("}\n");
        ret.append("{").append("userSalt").append(":").append(userSalt).append("}\n");
        ret.append("{").append("userWx").append(":").append(userWx).append("}\n");
        ret.append("{").append("userEmail").append(":").append(userEmail).append("}\n");
        ret.append("{").append("userModifyTime").append(":").append(userModifyTime).append("}\n");
        ret.append("{").append("userImage").append(":").append(userImage).append("}\n");
        ret.append("{").append("userAvatar").append(":").append(userAvatar).append("}\n");
        ret.append("{").append("userStatus").append(":").append(userStatus).append("}\n");
        ret.append("{").append("userWxOpenId").append(":").append(userWxOpenId).append("}\n");
        ret.append("{").append("userPushToken").append(":").append(userPushToken).append("}\n");
        ret.append("{").append("userDeleteFlag").append(":").append(userDeleteFlag).append("}\n");
        ret.append("{").append("userType").append(":").append(userType).append("}\n");
        ret.append("{").append("userProvider").append(":").append(userProvider).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelBUser
        implements RedisMapMapper<ModelBUser>
    {

        @Override
        public ModelBUser fromMap(Map<byte[], byte[]> map) {
            ModelBUser instance = new ModelBUser();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelBUser.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelBUser.FI_USER_NAME)) {
                        instance.setUserName(mapToFieldUserName(entry.getValue()));
                    } else {
                        if (field.equals(ModelBUser.FI_USER_SHOW_NAME)) {
                            instance.setUserShowName(mapToFieldUserShowName(entry.getValue()));
                        } else {
                            if (field.equals(ModelBUser.FI_USER_PWD)) {
                                instance.setUserPwd(mapToFieldUserPwd(entry.getValue()));
                            } else {
                                if (field.equals(ModelBUser.FI_USER_MOBILE)) {
                                    instance.setUserMobile(mapToFieldUserMobile(entry.getValue()));
                                } else {
                                    if (field.equals(ModelBUser.FI_USER_CREATE_TIME)) {
                                        instance.setUserCreateTime(mapToFieldUserCreateTime(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelBUser.FI_USER_SALT)) {
                                            instance.setUserSalt(mapToFieldUserSalt(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelBUser.FI_USER_WX)) {
                                                instance.setUserWx(mapToFieldUserWx(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelBUser.FI_USER_EMAIL)) {
                                                    instance.setUserEmail(mapToFieldUserEmail(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelBUser.FI_USER_MODIFY_TIME)) {
                                                        instance.setUserModifyTime(mapToFieldUserModifyTime(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelBUser.FI_USER_IMAGE)) {
                                                            instance.setUserImage(mapToFieldUserImage(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelBUser.FI_USER_AVATAR)) {
                                                                instance.setUserAvatar(mapToFieldUserAvatar(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelBUser.FI_USER_STATUS)) {
                                                                    instance.setUserStatus(mapToFieldUserStatus(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelBUser.FI_USER_WX_OPEN_ID)) {
                                                                        instance.setUserWxOpenId(mapToFieldUserWxOpenId(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelBUser.FI_USER_PUSH_TOKEN)) {
                                                                            instance.setUserPushToken(mapToFieldUserPushToken(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelBUser.FI_USER_DELETE_FLAG)) {
                                                                                instance.setUserDeleteFlag(mapToFieldUserDeleteFlag(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelBUser.FI_USER_TYPE)) {
                                                                                    instance.setUserType(mapToFieldUserType(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelBUser.FI_USER_PROVIDER)) {
                                                                                        instance.setUserProvider(mapToFieldUserProvider(entry.getValue()));
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

        protected String mapToFieldUserName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserShowName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserPwd(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserMobile(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldUserCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldUserSalt(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserWx(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserEmail(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldUserModifyTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldUserImage(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserAvatar(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldUserStatus(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected String mapToFieldUserWxOpenId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUserPushToken(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldUserDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldUserType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldUserProvider(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelBUser instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelBUser.FI_ID.getBytes(), valueId);
            byte[] valueUser_name = mapFromFieldUserName(instance.getUserName());
            ret.put(ModelBUser.FI_USER_NAME.getBytes(), valueUser_name);
            byte[] valueUser_show_name = mapFromFieldUserShowName(instance.getUserShowName());
            ret.put(ModelBUser.FI_USER_SHOW_NAME.getBytes(), valueUser_show_name);
            byte[] valueUser_pwd = mapFromFieldUserPwd(instance.getUserPwd());
            ret.put(ModelBUser.FI_USER_PWD.getBytes(), valueUser_pwd);
            byte[] valueUser_mobile = mapFromFieldUserMobile(instance.getUserMobile());
            ret.put(ModelBUser.FI_USER_MOBILE.getBytes(), valueUser_mobile);
            byte[] valueUser_create_time = mapFromFieldUserCreateTime(instance.getUserCreateTime());
            ret.put(ModelBUser.FI_USER_CREATE_TIME.getBytes(), valueUser_create_time);
            byte[] valueUser_salt = mapFromFieldUserSalt(instance.getUserSalt());
            ret.put(ModelBUser.FI_USER_SALT.getBytes(), valueUser_salt);
            byte[] valueUser_wx = mapFromFieldUserWx(instance.getUserWx());
            ret.put(ModelBUser.FI_USER_WX.getBytes(), valueUser_wx);
            byte[] valueUser_email = mapFromFieldUserEmail(instance.getUserEmail());
            ret.put(ModelBUser.FI_USER_EMAIL.getBytes(), valueUser_email);
            byte[] valueUser_modify_time = mapFromFieldUserModifyTime(instance.getUserModifyTime());
            ret.put(ModelBUser.FI_USER_MODIFY_TIME.getBytes(), valueUser_modify_time);
            byte[] valueUser_image = mapFromFieldUserImage(instance.getUserImage());
            ret.put(ModelBUser.FI_USER_IMAGE.getBytes(), valueUser_image);
            byte[] valueUser_avatar = mapFromFieldUserAvatar(instance.getUserAvatar());
            ret.put(ModelBUser.FI_USER_AVATAR.getBytes(), valueUser_avatar);
            byte[] valueUser_status = mapFromFieldUserStatus(instance.getUserStatus());
            ret.put(ModelBUser.FI_USER_STATUS.getBytes(), valueUser_status);
            byte[] valueUser_wx_open_id = mapFromFieldUserWxOpenId(instance.getUserWxOpenId());
            ret.put(ModelBUser.FI_USER_WX_OPEN_ID.getBytes(), valueUser_wx_open_id);
            byte[] valueUser_push_token = mapFromFieldUserPushToken(instance.getUserPushToken());
            ret.put(ModelBUser.FI_USER_PUSH_TOKEN.getBytes(), valueUser_push_token);
            byte[] valueUser_delete_flag = mapFromFieldUserDeleteFlag(instance.getUserDeleteFlag());
            ret.put(ModelBUser.FI_USER_DELETE_FLAG.getBytes(), valueUser_delete_flag);
            byte[] valueUser_type = mapFromFieldUserType(instance.getUserType());
            ret.put(ModelBUser.FI_USER_TYPE.getBytes(), valueUser_type);
            byte[] valueUser_provider = mapFromFieldUserProvider(instance.getUserProvider());
            ret.put(ModelBUser.FI_USER_PROVIDER.getBytes(), valueUser_provider);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserShowName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserPwd(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserMobile(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserSalt(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserWx(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserEmail(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserModifyTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserImage(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserAvatar(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserStatus(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserWxOpenId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserPushToken(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserType(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserProvider(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelBUser instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelBUser.FI_ID, dId);
            }
            String dUser_name = instance.getUserName();
            if (dUser_name!= null) {
                ret.put(ModelBUser.FI_USER_NAME, dUser_name);
            }
            String dUser_show_name = instance.getUserShowName();
            if (dUser_show_name!= null) {
                ret.put(ModelBUser.FI_USER_SHOW_NAME, dUser_show_name);
            }
            String dUser_pwd = instance.getUserPwd();
            if (dUser_pwd!= null) {
                ret.put(ModelBUser.FI_USER_PWD, dUser_pwd);
            }
            String dUser_mobile = instance.getUserMobile();
            if (dUser_mobile!= null) {
                ret.put(ModelBUser.FI_USER_MOBILE, dUser_mobile);
            }
            Date dUser_create_time = instance.getUserCreateTime();
            if (dUser_create_time!= null) {
                ret.put(ModelBUser.FI_USER_CREATE_TIME, dUser_create_time);
            }
            String dUser_salt = instance.getUserSalt();
            if (dUser_salt!= null) {
                ret.put(ModelBUser.FI_USER_SALT, dUser_salt);
            }
            String dUser_wx = instance.getUserWx();
            if (dUser_wx!= null) {
                ret.put(ModelBUser.FI_USER_WX, dUser_wx);
            }
            String dUser_email = instance.getUserEmail();
            if (dUser_email!= null) {
                ret.put(ModelBUser.FI_USER_EMAIL, dUser_email);
            }
            Date dUser_modify_time = instance.getUserModifyTime();
            if (dUser_modify_time!= null) {
                ret.put(ModelBUser.FI_USER_MODIFY_TIME, dUser_modify_time);
            }
            String dUser_image = instance.getUserImage();
            if (dUser_image!= null) {
                ret.put(ModelBUser.FI_USER_IMAGE, dUser_image);
            }
            String dUser_avatar = instance.getUserAvatar();
            if (dUser_avatar!= null) {
                ret.put(ModelBUser.FI_USER_AVATAR, dUser_avatar);
            }
            Byte dUser_status = instance.getUserStatus();
            if (dUser_status!= null) {
                ret.put(ModelBUser.FI_USER_STATUS, dUser_status);
            }
            String dUser_wx_open_id = instance.getUserWxOpenId();
            if (dUser_wx_open_id!= null) {
                ret.put(ModelBUser.FI_USER_WX_OPEN_ID, dUser_wx_open_id);
            }
            String dUser_push_token = instance.getUserPushToken();
            if (dUser_push_token!= null) {
                ret.put(ModelBUser.FI_USER_PUSH_TOKEN, dUser_push_token);
            }
            Byte dUser_delete_flag = instance.getUserDeleteFlag();
            if (dUser_delete_flag!= null) {
                ret.put(ModelBUser.FI_USER_DELETE_FLAG, dUser_delete_flag);
            }
            Integer dUser_type = instance.getUserType();
            if (dUser_type!= null) {
                ret.put(ModelBUser.FI_USER_TYPE, dUser_type);
            }
            String dUser_provider = instance.getUserProvider();
            if (dUser_provider!= null) {
                ret.put(ModelBUser.FI_USER_PROVIDER, dUser_provider);
            }
            return ret;
        }

        @Override
        public ModelBUser fromCommonMap(Map<String, Object> param) {
            ModelBUser ret = new ModelBUser();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelBUser.FI_ID);
            if (dId!= null) {
                this.setField(ModelBUser.FI_ID, ret, dId);
            }
            Object dUser_name = param.get(ModelBUser.FI_USER_NAME);
            if (dUser_name!= null) {
                this.setField(ModelBUser.FI_USER_NAME, ret, dUser_name);
            }
            Object dUser_show_name = param.get(ModelBUser.FI_USER_SHOW_NAME);
            if (dUser_show_name!= null) {
                this.setField(ModelBUser.FI_USER_SHOW_NAME, ret, dUser_show_name);
            }
            Object dUser_pwd = param.get(ModelBUser.FI_USER_PWD);
            if (dUser_pwd!= null) {
                this.setField(ModelBUser.FI_USER_PWD, ret, dUser_pwd);
            }
            Object dUser_mobile = param.get(ModelBUser.FI_USER_MOBILE);
            if (dUser_mobile!= null) {
                this.setField(ModelBUser.FI_USER_MOBILE, ret, dUser_mobile);
            }
            Object dUser_create_time = param.get(ModelBUser.FI_USER_CREATE_TIME);
            if (dUser_create_time!= null) {
                this.setField(ModelBUser.FI_USER_CREATE_TIME, ret, dUser_create_time);
            }
            Object dUser_salt = param.get(ModelBUser.FI_USER_SALT);
            if (dUser_salt!= null) {
                this.setField(ModelBUser.FI_USER_SALT, ret, dUser_salt);
            }
            Object dUser_wx = param.get(ModelBUser.FI_USER_WX);
            if (dUser_wx!= null) {
                this.setField(ModelBUser.FI_USER_WX, ret, dUser_wx);
            }
            Object dUser_email = param.get(ModelBUser.FI_USER_EMAIL);
            if (dUser_email!= null) {
                this.setField(ModelBUser.FI_USER_EMAIL, ret, dUser_email);
            }
            Object dUser_modify_time = param.get(ModelBUser.FI_USER_MODIFY_TIME);
            if (dUser_modify_time!= null) {
                this.setField(ModelBUser.FI_USER_MODIFY_TIME, ret, dUser_modify_time);
            }
            Object dUser_image = param.get(ModelBUser.FI_USER_IMAGE);
            if (dUser_image!= null) {
                this.setField(ModelBUser.FI_USER_IMAGE, ret, dUser_image);
            }
            Object dUser_avatar = param.get(ModelBUser.FI_USER_AVATAR);
            if (dUser_avatar!= null) {
                this.setField(ModelBUser.FI_USER_AVATAR, ret, dUser_avatar);
            }
            Object dUser_status = param.get(ModelBUser.FI_USER_STATUS);
            if (dUser_status!= null) {
                this.setField(ModelBUser.FI_USER_STATUS, ret, dUser_status);
            }
            Object dUser_wx_open_id = param.get(ModelBUser.FI_USER_WX_OPEN_ID);
            if (dUser_wx_open_id!= null) {
                this.setField(ModelBUser.FI_USER_WX_OPEN_ID, ret, dUser_wx_open_id);
            }
            Object dUser_push_token = param.get(ModelBUser.FI_USER_PUSH_TOKEN);
            if (dUser_push_token!= null) {
                this.setField(ModelBUser.FI_USER_PUSH_TOKEN, ret, dUser_push_token);
            }
            Object dUser_delete_flag = param.get(ModelBUser.FI_USER_DELETE_FLAG);
            if (dUser_delete_flag!= null) {
                this.setField(ModelBUser.FI_USER_DELETE_FLAG, ret, dUser_delete_flag);
            }
            Object dUser_type = param.get(ModelBUser.FI_USER_TYPE);
            if (dUser_type!= null) {
                this.setField(ModelBUser.FI_USER_TYPE, ret, dUser_type);
            }
            Object dUser_provider = param.get(ModelBUser.FI_USER_PROVIDER);
            if (dUser_provider!= null) {
                this.setField(ModelBUser.FI_USER_PROVIDER, ret, dUser_provider);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldUserName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserShowName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserPwd(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserMobile(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldUserCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldUserSalt(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserWx(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserEmail(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldUserModifyTime(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldUserImage(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserAvatar(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldUserStatus(Object obj) {
            return ((Byte) obj);
        }

        protected String mapToFieldUserWxOpenId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUserPushToken(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldUserDeleteFlag(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldUserType(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldUserProvider(Object obj) {
            return ((String) obj);
        }

        public<TT> TT getField(String field, ModelBUser instance) {
            try {
                if (field.equals(ModelBUser.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelBUser.FI_USER_NAME)) {
                        return ((TT) instance.getUserName());
                    } else {
                        if (field.equals(ModelBUser.FI_USER_SHOW_NAME)) {
                            return ((TT) instance.getUserShowName());
                        } else {
                            if (field.equals(ModelBUser.FI_USER_PWD)) {
                                return ((TT) instance.getUserPwd());
                            } else {
                                if (field.equals(ModelBUser.FI_USER_MOBILE)) {
                                    return ((TT) instance.getUserMobile());
                                } else {
                                    if (field.equals(ModelBUser.FI_USER_CREATE_TIME)) {
                                        return ((TT) instance.getUserCreateTime());
                                    } else {
                                        if (field.equals(ModelBUser.FI_USER_SALT)) {
                                            return ((TT) instance.getUserSalt());
                                        } else {
                                            if (field.equals(ModelBUser.FI_USER_WX)) {
                                                return ((TT) instance.getUserWx());
                                            } else {
                                                if (field.equals(ModelBUser.FI_USER_EMAIL)) {
                                                    return ((TT) instance.getUserEmail());
                                                } else {
                                                    if (field.equals(ModelBUser.FI_USER_MODIFY_TIME)) {
                                                        return ((TT) instance.getUserModifyTime());
                                                    } else {
                                                        if (field.equals(ModelBUser.FI_USER_IMAGE)) {
                                                            return ((TT) instance.getUserImage());
                                                        } else {
                                                            if (field.equals(ModelBUser.FI_USER_AVATAR)) {
                                                                return ((TT) instance.getUserAvatar());
                                                            } else {
                                                                if (field.equals(ModelBUser.FI_USER_STATUS)) {
                                                                    return ((TT) instance.getUserStatus());
                                                                } else {
                                                                    if (field.equals(ModelBUser.FI_USER_WX_OPEN_ID)) {
                                                                        return ((TT) instance.getUserWxOpenId());
                                                                    } else {
                                                                        if (field.equals(ModelBUser.FI_USER_PUSH_TOKEN)) {
                                                                            return ((TT) instance.getUserPushToken());
                                                                        } else {
                                                                            if (field.equals(ModelBUser.FI_USER_DELETE_FLAG)) {
                                                                                return ((TT) instance.getUserDeleteFlag());
                                                                            } else {
                                                                                if (field.equals(ModelBUser.FI_USER_TYPE)) {
                                                                                    return ((TT) instance.getUserType());
                                                                                } else {
                                                                                    if (field.equals(ModelBUser.FI_USER_PROVIDER)) {
                                                                                        return ((TT) instance.getUserProvider());
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

        public<TT> void setField(String field, ModelBUser instance, TT value) {
            if (field.equals(ModelBUser.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelBUser.FI_USER_NAME)) {
                    try {
                        instance.setUserName(mapToFieldUserName(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelBUser.FI_USER_SHOW_NAME)) {
                        try {
                            instance.setUserShowName(mapToFieldUserShowName(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelBUser.FI_USER_PWD)) {
                            try {
                                instance.setUserPwd(mapToFieldUserPwd(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelBUser.FI_USER_MOBILE)) {
                                try {
                                    instance.setUserMobile(mapToFieldUserMobile(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelBUser.FI_USER_CREATE_TIME)) {
                                    try {
                                        instance.setUserCreateTime(mapToFieldUserCreateTime(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelBUser.FI_USER_SALT)) {
                                        try {
                                            instance.setUserSalt(mapToFieldUserSalt(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelBUser.FI_USER_WX)) {
                                            try {
                                                instance.setUserWx(mapToFieldUserWx(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelBUser.FI_USER_EMAIL)) {
                                                try {
                                                    instance.setUserEmail(mapToFieldUserEmail(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelBUser.FI_USER_MODIFY_TIME)) {
                                                    try {
                                                        instance.setUserModifyTime(mapToFieldUserModifyTime(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelBUser.FI_USER_IMAGE)) {
                                                        try {
                                                            instance.setUserImage(mapToFieldUserImage(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelBUser.FI_USER_AVATAR)) {
                                                            try {
                                                                instance.setUserAvatar(mapToFieldUserAvatar(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelBUser.FI_USER_STATUS)) {
                                                                try {
                                                                    instance.setUserStatus(mapToFieldUserStatus(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelBUser.FI_USER_WX_OPEN_ID)) {
                                                                    try {
                                                                        instance.setUserWxOpenId(mapToFieldUserWxOpenId(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelBUser.FI_USER_PUSH_TOKEN)) {
                                                                        try {
                                                                            instance.setUserPushToken(mapToFieldUserPushToken(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelBUser.FI_USER_DELETE_FLAG)) {
                                                                            try {
                                                                                instance.setUserDeleteFlag(mapToFieldUserDeleteFlag(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelBUser.FI_USER_TYPE)) {
                                                                                try {
                                                                                    instance.setUserType(mapToFieldUserType(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelBUser.FI_USER_PROVIDER)) {
                                                                                    try {
                                                                                        instance.setUserProvider(mapToFieldUserProvider(value));
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

        public void setField(String field, ModelBUser instance, byte[] value) {
            if (field.equals(ModelBUser.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelBUser.FI_USER_NAME)) {
                    instance.setUserName(mapToFieldUserName(value));
                } else {
                    if (field.equals(ModelBUser.FI_USER_SHOW_NAME)) {
                        instance.setUserShowName(mapToFieldUserShowName(value));
                    } else {
                        if (field.equals(ModelBUser.FI_USER_PWD)) {
                            instance.setUserPwd(mapToFieldUserPwd(value));
                        } else {
                            if (field.equals(ModelBUser.FI_USER_MOBILE)) {
                                instance.setUserMobile(mapToFieldUserMobile(value));
                            } else {
                                if (field.equals(ModelBUser.FI_USER_CREATE_TIME)) {
                                    instance.setUserCreateTime(mapToFieldUserCreateTime(value));
                                } else {
                                    if (field.equals(ModelBUser.FI_USER_SALT)) {
                                        instance.setUserSalt(mapToFieldUserSalt(value));
                                    } else {
                                        if (field.equals(ModelBUser.FI_USER_WX)) {
                                            instance.setUserWx(mapToFieldUserWx(value));
                                        } else {
                                            if (field.equals(ModelBUser.FI_USER_EMAIL)) {
                                                instance.setUserEmail(mapToFieldUserEmail(value));
                                            } else {
                                                if (field.equals(ModelBUser.FI_USER_MODIFY_TIME)) {
                                                    instance.setUserModifyTime(mapToFieldUserModifyTime(value));
                                                } else {
                                                    if (field.equals(ModelBUser.FI_USER_IMAGE)) {
                                                        instance.setUserImage(mapToFieldUserImage(value));
                                                    } else {
                                                        if (field.equals(ModelBUser.FI_USER_AVATAR)) {
                                                            instance.setUserAvatar(mapToFieldUserAvatar(value));
                                                        } else {
                                                            if (field.equals(ModelBUser.FI_USER_STATUS)) {
                                                                instance.setUserStatus(mapToFieldUserStatus(value));
                                                            } else {
                                                                if (field.equals(ModelBUser.FI_USER_WX_OPEN_ID)) {
                                                                    instance.setUserWxOpenId(mapToFieldUserWxOpenId(value));
                                                                } else {
                                                                    if (field.equals(ModelBUser.FI_USER_PUSH_TOKEN)) {
                                                                        instance.setUserPushToken(mapToFieldUserPushToken(value));
                                                                    } else {
                                                                        if (field.equals(ModelBUser.FI_USER_DELETE_FLAG)) {
                                                                            instance.setUserDeleteFlag(mapToFieldUserDeleteFlag(value));
                                                                        } else {
                                                                            if (field.equals(ModelBUser.FI_USER_TYPE)) {
                                                                                instance.setUserType(mapToFieldUserType(value));
                                                                            } else {
                                                                                if (field.equals(ModelBUser.FI_USER_PROVIDER)) {
                                                                                    instance.setUserProvider(mapToFieldUserProvider(value));
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
