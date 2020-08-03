/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumOrgUserRole;
import com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;


/**
 * base DTO,represent for  :b_orgnization_user
 */
public class ModelBOrgnizationUser
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    Integer orgId;
    public final static String FI_ORG_ID = "org_id";
    Integer userId;
    public final static String FI_USER_ID = "user_id";
    EnumOrgUserRole orgRole;
    public final static String FI_ORG_ROLE = "org_role";
    /**
     * 人员加入时间
     */
    Date orgUserCreateTime;
    public final static String FI_ORG_USER_CREATE_TIME = "org_user_create_time";
    /**
     * 删除标识
     */
    Byte deleteFlag;
    public final static String FI_DELETE_FLAG = "delete_flag";
    EnumYesOrNo isUserDefaultOrg;
    public final static String FI_IS_USER_DEFAULT_ORG = "is_user_default_org";
    /**
     * 删除标记
     */
    Byte orgUserDeleteFlag;
    public final static String FI_ORG_USER_DELETE_FLAG = "org_user_delete_flag";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelBOrgnizationUser.FI_ID, Integer.class).put(ModelBOrgnizationUser.FI_ORG_ID, Integer.class).put(ModelBOrgnizationUser.FI_USER_ID, Integer.class).put(ModelBOrgnizationUser.FI_ORG_ROLE, EnumOrgUserRole.class).put(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME, Date.class).put(ModelBOrgnizationUser.FI_DELETE_FLAG, Byte.class).put(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG, EnumYesOrNo.class).put(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG, Byte.class).getMap();
    public final static Integer FIELD_COUNT = 8;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "b_orgnization_user";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelBOrgnizationUser() {
    }

    public Integer getId() {
        return id;
    }

    public ModelBOrgnizationUser setId(Integer lId) {
        id = lId;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public ModelBOrgnizationUser setOrgId(Integer lOrgId) {
        orgId = lOrgId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public ModelBOrgnizationUser setUserId(Integer lUserId) {
        userId = lUserId;
        return this;
    }

    public EnumOrgUserRole getOrgRole() {
        return orgRole;
    }

    public ModelBOrgnizationUser setOrgRole(EnumOrgUserRole lOrgRole) {
        orgRole = lOrgRole;
        return this;
    }

    public Date getOrgUserCreateTime() {
        return orgUserCreateTime;
    }

    public ModelBOrgnizationUser setOrgUserCreateTime(Date lOrgUserCreateTime) {
        orgUserCreateTime = lOrgUserCreateTime;
        return this;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public ModelBOrgnizationUser setDeleteFlag(Byte lDeleteFlag) {
        deleteFlag = lDeleteFlag;
        return this;
    }

    public EnumYesOrNo getIsUserDefaultOrg() {
        return isUserDefaultOrg;
    }

    public ModelBOrgnizationUser setIsUserDefaultOrg(EnumYesOrNo lIsUserDefaultOrg) {
        isUserDefaultOrg = lIsUserDefaultOrg;
        return this;
    }

    public Byte getOrgUserDeleteFlag() {
        return orgUserDeleteFlag;
    }

    public ModelBOrgnizationUser setOrgUserDeleteFlag(Byte lOrgUserDeleteFlag) {
        orgUserDeleteFlag = lOrgUserDeleteFlag;
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
        if (getOrgId()!= null) {
            return false;
        }
        if (getUserId()!= null) {
            return false;
        }
        if (getOrgRole()!= null) {
            return false;
        }
        if (getOrgUserCreateTime()!= null) {
            return false;
        }
        if (getDeleteFlag()!= null) {
            return false;
        }
        if (getIsUserDefaultOrg()!= null) {
            return false;
        }
        if (getOrgUserDeleteFlag()!= null) {
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
        ret.append("{").append("orgId").append(":").append(orgId).append("}\n");
        ret.append("{").append("userId").append(":").append(userId).append("}\n");
        ret.append("{").append("orgRole").append(":").append(orgRole).append("}\n");
        ret.append("{").append("orgUserCreateTime").append(":").append(orgUserCreateTime).append("}\n");
        ret.append("{").append("deleteFlag").append(":").append(deleteFlag).append("}\n");
        ret.append("{").append("isUserDefaultOrg").append(":").append(isUserDefaultOrg).append("}\n");
        ret.append("{").append("orgUserDeleteFlag").append(":").append(orgUserDeleteFlag).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelBOrgnizationUser
        implements RedisMapMapper<ModelBOrgnizationUser>
    {

        @Override
        public ModelBOrgnizationUser fromMap(Map<byte[], byte[]> map) {
            ModelBOrgnizationUser instance = new ModelBOrgnizationUser();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelBOrgnizationUser.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelBOrgnizationUser.FI_ORG_ID)) {
                        instance.setOrgId(mapToFieldOrgId(entry.getValue()));
                    } else {
                        if (field.equals(ModelBOrgnizationUser.FI_USER_ID)) {
                            instance.setUserId(mapToFieldUserId(entry.getValue()));
                        } else {
                            if (field.equals(ModelBOrgnizationUser.FI_ORG_ROLE)) {
                                instance.setOrgRole(mapToFieldOrgRole(entry.getValue()));
                            } else {
                                if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
                                    instance.setOrgUserCreateTime(mapToFieldOrgUserCreateTime(entry.getValue()));
                                } else {
                                    if (field.equals(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
                                        instance.setDeleteFlag(mapToFieldDeleteFlag(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
                                            instance.setIsUserDefaultOrg(mapToFieldIsUserDefaultOrg(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
                                                instance.setOrgUserDeleteFlag(mapToFieldOrgUserDeleteFlag(entry.getValue()));
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

        protected Integer mapToFieldOrgId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldUserId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected EnumOrgUserRole mapToFieldOrgRole(byte[] bytes) {
            return EnumOrgUserRole.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected Date mapToFieldOrgUserCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Byte mapToFieldDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected EnumYesOrNo mapToFieldIsUserDefaultOrg(byte[] bytes) {
            return EnumYesOrNo.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected Byte mapToFieldOrgUserDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelBOrgnizationUser instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelBOrgnizationUser.FI_ID.getBytes(), valueId);
            byte[] valueOrg_id = mapFromFieldOrgId(instance.getOrgId());
            ret.put(ModelBOrgnizationUser.FI_ORG_ID.getBytes(), valueOrg_id);
            byte[] valueUser_id = mapFromFieldUserId(instance.getUserId());
            ret.put(ModelBOrgnizationUser.FI_USER_ID.getBytes(), valueUser_id);
            byte[] valueOrg_role = mapFromFieldOrgRole(instance.getOrgRole());
            ret.put(ModelBOrgnizationUser.FI_ORG_ROLE.getBytes(), valueOrg_role);
            byte[] valueOrg_user_create_time = mapFromFieldOrgUserCreateTime(instance.getOrgUserCreateTime());
            ret.put(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME.getBytes(), valueOrg_user_create_time);
            byte[] valueDelete_flag = mapFromFieldDeleteFlag(instance.getDeleteFlag());
            ret.put(ModelBOrgnizationUser.FI_DELETE_FLAG.getBytes(), valueDelete_flag);
            byte[] valueIs_user_default_org = mapFromFieldIsUserDefaultOrg(instance.getIsUserDefaultOrg());
            ret.put(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG.getBytes(), valueIs_user_default_org);
            byte[] valueOrg_user_delete_flag = mapFromFieldOrgUserDeleteFlag(instance.getOrgUserDeleteFlag());
            ret.put(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG.getBytes(), valueOrg_user_delete_flag);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldOrgId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUserId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldOrgRole(EnumOrgUserRole field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldOrgUserCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIsUserDefaultOrg(EnumYesOrNo field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldOrgUserDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelBOrgnizationUser instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelBOrgnizationUser.FI_ID, dId);
            }
            Integer dOrg_id = instance.getOrgId();
            if (dOrg_id!= null) {
                ret.put(ModelBOrgnizationUser.FI_ORG_ID, dOrg_id);
            }
            Integer dUser_id = instance.getUserId();
            if (dUser_id!= null) {
                ret.put(ModelBOrgnizationUser.FI_USER_ID, dUser_id);
            }
            EnumOrgUserRole dOrg_role = instance.getOrgRole();
            if (dOrg_role!= null) {
                ret.put(ModelBOrgnizationUser.FI_ORG_ROLE, dOrg_role.val);
            }
            Date dOrg_user_create_time = instance.getOrgUserCreateTime();
            if (dOrg_user_create_time!= null) {
                ret.put(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME, dOrg_user_create_time);
            }
            Byte dDelete_flag = instance.getDeleteFlag();
            if (dDelete_flag!= null) {
                ret.put(ModelBOrgnizationUser.FI_DELETE_FLAG, dDelete_flag);
            }
            EnumYesOrNo dIs_user_default_org = instance.getIsUserDefaultOrg();
            if (dIs_user_default_org!= null) {
                ret.put(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG, dIs_user_default_org.val);
            }
            Byte dOrg_user_delete_flag = instance.getOrgUserDeleteFlag();
            if (dOrg_user_delete_flag!= null) {
                ret.put(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG, dOrg_user_delete_flag);
            }
            return ret;
        }

        @Override
        public ModelBOrgnizationUser fromCommonMap(Map<String, Object> param) {
            ModelBOrgnizationUser ret = new ModelBOrgnizationUser();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelBOrgnizationUser.FI_ID);
            if (dId!= null) {
                this.setField(ModelBOrgnizationUser.FI_ID, ret, dId);
            }
            Object dOrg_id = param.get(ModelBOrgnizationUser.FI_ORG_ID);
            if (dOrg_id!= null) {
                this.setField(ModelBOrgnizationUser.FI_ORG_ID, ret, dOrg_id);
            }
            Object dUser_id = param.get(ModelBOrgnizationUser.FI_USER_ID);
            if (dUser_id!= null) {
                this.setField(ModelBOrgnizationUser.FI_USER_ID, ret, dUser_id);
            }
            Object dOrg_role = param.get(ModelBOrgnizationUser.FI_ORG_ROLE);
            if (dOrg_role!= null) {
                this.setField(ModelBOrgnizationUser.FI_ORG_ROLE, ret, dOrg_role);
            }
            Object dOrg_user_create_time = param.get(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
            if (dOrg_user_create_time!= null) {
                this.setField(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME, ret, dOrg_user_create_time);
            }
            Object dDelete_flag = param.get(ModelBOrgnizationUser.FI_DELETE_FLAG);
            if (dDelete_flag!= null) {
                this.setField(ModelBOrgnizationUser.FI_DELETE_FLAG, ret, dDelete_flag);
            }
            Object dIs_user_default_org = param.get(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
            if (dIs_user_default_org!= null) {
                this.setField(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG, ret, dIs_user_default_org);
            }
            Object dOrg_user_delete_flag = param.get(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
            if (dOrg_user_delete_flag!= null) {
                this.setField(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG, ret, dOrg_user_delete_flag);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldOrgId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldUserId(Object obj) {
            return ((Integer) obj);
        }

        protected EnumOrgUserRole mapToFieldOrgRole(Object obj) {
            return EnumOrgUserRole.fromValue(((Byte) obj));
        }

        protected Date mapToFieldOrgUserCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected Byte mapToFieldDeleteFlag(Object obj) {
            return ((Byte) obj);
        }

        protected EnumYesOrNo mapToFieldIsUserDefaultOrg(Object obj) {
            return EnumYesOrNo.fromValue(((Byte) obj));
        }

        protected Byte mapToFieldOrgUserDeleteFlag(Object obj) {
            return ((Byte) obj);
        }

        public<TT> TT getField(String field, ModelBOrgnizationUser instance) {
            try {
                if (field.equals(ModelBOrgnizationUser.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelBOrgnizationUser.FI_ORG_ID)) {
                        return ((TT) instance.getOrgId());
                    } else {
                        if (field.equals(ModelBOrgnizationUser.FI_USER_ID)) {
                            return ((TT) instance.getUserId());
                        } else {
                            if (field.equals(ModelBOrgnizationUser.FI_ORG_ROLE)) {
                                return ((TT) instance.getOrgRole());
                            } else {
                                if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
                                    return ((TT) instance.getOrgUserCreateTime());
                                } else {
                                    if (field.equals(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
                                        return ((TT) instance.getDeleteFlag());
                                    } else {
                                        if (field.equals(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
                                            return ((TT) instance.getIsUserDefaultOrg());
                                        } else {
                                            if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
                                                return ((TT) instance.getOrgUserDeleteFlag());
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

        public<TT> void setField(String field, ModelBOrgnizationUser instance, TT value) {
            if (field.equals(ModelBOrgnizationUser.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelBOrgnizationUser.FI_ORG_ID)) {
                    try {
                        instance.setOrgId(mapToFieldOrgId(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelBOrgnizationUser.FI_USER_ID)) {
                        try {
                            instance.setUserId(mapToFieldUserId(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelBOrgnizationUser.FI_ORG_ROLE)) {
                            try {
                                instance.setOrgRole(mapToFieldOrgRole(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
                                try {
                                    instance.setOrgUserCreateTime(mapToFieldOrgUserCreateTime(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
                                    try {
                                        instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
                                        try {
                                            instance.setIsUserDefaultOrg(mapToFieldIsUserDefaultOrg(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
                                            try {
                                                instance.setOrgUserDeleteFlag(mapToFieldOrgUserDeleteFlag(value));
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

        public void setField(String field, ModelBOrgnizationUser instance, byte[] value) {
            if (field.equals(ModelBOrgnizationUser.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelBOrgnizationUser.FI_ORG_ID)) {
                    instance.setOrgId(mapToFieldOrgId(value));
                } else {
                    if (field.equals(ModelBOrgnizationUser.FI_USER_ID)) {
                        instance.setUserId(mapToFieldUserId(value));
                    } else {
                        if (field.equals(ModelBOrgnizationUser.FI_ORG_ROLE)) {
                            instance.setOrgRole(mapToFieldOrgRole(value));
                        } else {
                            if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
                                instance.setOrgUserCreateTime(mapToFieldOrgUserCreateTime(value));
                            } else {
                                if (field.equals(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
                                    instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                                } else {
                                    if (field.equals(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
                                        instance.setIsUserDefaultOrg(mapToFieldIsUserDefaultOrg(value));
                                    } else {
                                        if (field.equals(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
                                            instance.setOrgUserDeleteFlag(mapToFieldOrgUserDeleteFlag(value));
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
