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
 * base DTO,represent for  :b_role
 */
public class ModelBRole
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 编码
     */
    String roleCode;
    public final static String FI_ROLE_CODE = "role_code";
    /**
     * 角色名称
     */
    String roleName;
    public final static String FI_ROLE_NAME = "role_name";
    /**
     * 角色类型
     */
    Byte roleType;
    public final static String FI_ROLE_TYPE = "role_type";
    /**
     * 排序
     */
    Integer roleSort;
    public final static String FI_ROLE_SORT = "role_sort";
    /**
     * 是否启用
     */
    Integer roleEnabled;
    public final static String FI_ROLE_ENABLED = "role_enabled";
    /**
     * 备注
     */
    String roleRemark;
    public final static String FI_ROLE_REMARK = "role_remark";
    /**
     * 创建人
     */
    Integer roleCreator;
    public final static String FI_ROLE_CREATOR = "role_creator";
    /**
     * 创建时间
     */
    Date roleCreatedata;
    public final static String FI_ROLE_CREATEDATA = "role_createdata";
    /**
     * 修改人
     */
    Integer roleUpdator;
    public final static String FI_ROLE_UPDATOR = "role_updator";
    /**
     * 修改时间
     */
    Date roleUpdatedata;
    public final static String FI_ROLE_UPDATEDATA = "role_updatedata";
    /**
     * 删除标记
     */
    Byte roleDeleteFlag;
    public final static String FI_ROLE_DELETE_FLAG = "role_delete_flag";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelBRole.FI_ID, Integer.class).put(ModelBRole.FI_ROLE_CODE, String.class).put(ModelBRole.FI_ROLE_NAME, String.class).put(ModelBRole.FI_ROLE_TYPE, Byte.class).put(ModelBRole.FI_ROLE_SORT, Integer.class).put(ModelBRole.FI_ROLE_ENABLED, Integer.class).put(ModelBRole.FI_ROLE_REMARK, String.class).put(ModelBRole.FI_ROLE_CREATOR, Integer.class).put(ModelBRole.FI_ROLE_CREATEDATA, Date.class).put(ModelBRole.FI_ROLE_UPDATOR, Integer.class).put(ModelBRole.FI_ROLE_UPDATEDATA, Date.class).put(ModelBRole.FI_ROLE_DELETE_FLAG, Byte.class).getMap();
    public final static Integer FIELD_COUNT = 12;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "b_role";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelBRole() {
    }

    public Integer getId() {
        return id;
    }

    public ModelBRole setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public ModelBRole setRoleCode(String lRoleCode) {
        roleCode = lRoleCode;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public ModelBRole setRoleName(String lRoleName) {
        roleName = lRoleName;
        return this;
    }

    public Byte getRoleType() {
        return roleType;
    }

    public ModelBRole setRoleType(Byte lRoleType) {
        roleType = lRoleType;
        return this;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public ModelBRole setRoleSort(Integer lRoleSort) {
        roleSort = lRoleSort;
        return this;
    }

    public Integer getRoleEnabled() {
        return roleEnabled;
    }

    public ModelBRole setRoleEnabled(Integer lRoleEnabled) {
        roleEnabled = lRoleEnabled;
        return this;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public ModelBRole setRoleRemark(String lRoleRemark) {
        roleRemark = lRoleRemark;
        return this;
    }

    public Integer getRoleCreator() {
        return roleCreator;
    }

    public ModelBRole setRoleCreator(Integer lRoleCreator) {
        roleCreator = lRoleCreator;
        return this;
    }

    public Date getRoleCreatedata() {
        return roleCreatedata;
    }

    public ModelBRole setRoleCreatedata(Date lRoleCreatedata) {
        roleCreatedata = lRoleCreatedata;
        return this;
    }

    public Integer getRoleUpdator() {
        return roleUpdator;
    }

    public ModelBRole setRoleUpdator(Integer lRoleUpdator) {
        roleUpdator = lRoleUpdator;
        return this;
    }

    public Date getRoleUpdatedata() {
        return roleUpdatedata;
    }

    public ModelBRole setRoleUpdatedata(Date lRoleUpdatedata) {
        roleUpdatedata = lRoleUpdatedata;
        return this;
    }

    public Byte getRoleDeleteFlag() {
        return roleDeleteFlag;
    }

    public ModelBRole setRoleDeleteFlag(Byte lRoleDeleteFlag) {
        roleDeleteFlag = lRoleDeleteFlag;
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
        if (getRoleCode()!= null) {
            return false;
        }
        if (getRoleName()!= null) {
            return false;
        }
        if (getRoleType()!= null) {
            return false;
        }
        if (getRoleSort()!= null) {
            return false;
        }
        if (getRoleEnabled()!= null) {
            return false;
        }
        if (getRoleRemark()!= null) {
            return false;
        }
        if (getRoleCreator()!= null) {
            return false;
        }
        if (getRoleCreatedata()!= null) {
            return false;
        }
        if (getRoleUpdator()!= null) {
            return false;
        }
        if (getRoleUpdatedata()!= null) {
            return false;
        }
        if (getRoleDeleteFlag()!= null) {
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
        ret.append("{").append("roleCode").append(":").append(roleCode).append("}\n");
        ret.append("{").append("roleName").append(":").append(roleName).append("}\n");
        ret.append("{").append("roleType").append(":").append(roleType).append("}\n");
        ret.append("{").append("roleSort").append(":").append(roleSort).append("}\n");
        ret.append("{").append("roleEnabled").append(":").append(roleEnabled).append("}\n");
        ret.append("{").append("roleRemark").append(":").append(roleRemark).append("}\n");
        ret.append("{").append("roleCreator").append(":").append(roleCreator).append("}\n");
        ret.append("{").append("roleCreatedata").append(":").append(roleCreatedata).append("}\n");
        ret.append("{").append("roleUpdator").append(":").append(roleUpdator).append("}\n");
        ret.append("{").append("roleUpdatedata").append(":").append(roleUpdatedata).append("}\n");
        ret.append("{").append("roleDeleteFlag").append(":").append(roleDeleteFlag).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelBRole
        implements RedisMapMapper<ModelBRole>
    {

        @Override
        public ModelBRole fromMap(Map<byte[], byte[]> map) {
            ModelBRole instance = new ModelBRole();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelBRole.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelBRole.FI_ROLE_CODE)) {
                        instance.setRoleCode(mapToFieldRoleCode(entry.getValue()));
                    } else {
                        if (field.equals(ModelBRole.FI_ROLE_NAME)) {
                            instance.setRoleName(mapToFieldRoleName(entry.getValue()));
                        } else {
                            if (field.equals(ModelBRole.FI_ROLE_TYPE)) {
                                instance.setRoleType(mapToFieldRoleType(entry.getValue()));
                            } else {
                                if (field.equals(ModelBRole.FI_ROLE_SORT)) {
                                    instance.setRoleSort(mapToFieldRoleSort(entry.getValue()));
                                } else {
                                    if (field.equals(ModelBRole.FI_ROLE_ENABLED)) {
                                        instance.setRoleEnabled(mapToFieldRoleEnabled(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelBRole.FI_ROLE_REMARK)) {
                                            instance.setRoleRemark(mapToFieldRoleRemark(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelBRole.FI_ROLE_CREATOR)) {
                                                instance.setRoleCreator(mapToFieldRoleCreator(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelBRole.FI_ROLE_CREATEDATA)) {
                                                    instance.setRoleCreatedata(mapToFieldRoleCreatedata(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelBRole.FI_ROLE_UPDATOR)) {
                                                        instance.setRoleUpdator(mapToFieldRoleUpdator(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelBRole.FI_ROLE_UPDATEDATA)) {
                                                            instance.setRoleUpdatedata(mapToFieldRoleUpdatedata(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelBRole.FI_ROLE_DELETE_FLAG)) {
                                                                instance.setRoleDeleteFlag(mapToFieldRoleDeleteFlag(entry.getValue()));
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

        protected String mapToFieldRoleCode(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldRoleName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldRoleType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldRoleSort(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldRoleEnabled(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldRoleRemark(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldRoleCreator(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldRoleCreatedata(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Integer mapToFieldRoleUpdator(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldRoleUpdatedata(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Byte mapToFieldRoleDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelBRole instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelBRole.FI_ID.getBytes(), valueId);
            byte[] valueRole_code = mapFromFieldRoleCode(instance.getRoleCode());
            ret.put(ModelBRole.FI_ROLE_CODE.getBytes(), valueRole_code);
            byte[] valueRole_name = mapFromFieldRoleName(instance.getRoleName());
            ret.put(ModelBRole.FI_ROLE_NAME.getBytes(), valueRole_name);
            byte[] valueRole_type = mapFromFieldRoleType(instance.getRoleType());
            ret.put(ModelBRole.FI_ROLE_TYPE.getBytes(), valueRole_type);
            byte[] valueRole_sort = mapFromFieldRoleSort(instance.getRoleSort());
            ret.put(ModelBRole.FI_ROLE_SORT.getBytes(), valueRole_sort);
            byte[] valueRole_enabled = mapFromFieldRoleEnabled(instance.getRoleEnabled());
            ret.put(ModelBRole.FI_ROLE_ENABLED.getBytes(), valueRole_enabled);
            byte[] valueRole_remark = mapFromFieldRoleRemark(instance.getRoleRemark());
            ret.put(ModelBRole.FI_ROLE_REMARK.getBytes(), valueRole_remark);
            byte[] valueRole_creator = mapFromFieldRoleCreator(instance.getRoleCreator());
            ret.put(ModelBRole.FI_ROLE_CREATOR.getBytes(), valueRole_creator);
            byte[] valueRole_createdata = mapFromFieldRoleCreatedata(instance.getRoleCreatedata());
            ret.put(ModelBRole.FI_ROLE_CREATEDATA.getBytes(), valueRole_createdata);
            byte[] valueRole_updator = mapFromFieldRoleUpdator(instance.getRoleUpdator());
            ret.put(ModelBRole.FI_ROLE_UPDATOR.getBytes(), valueRole_updator);
            byte[] valueRole_updatedata = mapFromFieldRoleUpdatedata(instance.getRoleUpdatedata());
            ret.put(ModelBRole.FI_ROLE_UPDATEDATA.getBytes(), valueRole_updatedata);
            byte[] valueRole_delete_flag = mapFromFieldRoleDeleteFlag(instance.getRoleDeleteFlag());
            ret.put(ModelBRole.FI_ROLE_DELETE_FLAG.getBytes(), valueRole_delete_flag);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleCode(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleType(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleSort(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleEnabled(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleRemark(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleCreator(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleCreatedata(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleUpdator(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleUpdatedata(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRoleDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelBRole instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelBRole.FI_ID, dId);
            }
            String dRole_code = instance.getRoleCode();
            if (dRole_code!= null) {
                ret.put(ModelBRole.FI_ROLE_CODE, dRole_code);
            }
            String dRole_name = instance.getRoleName();
            if (dRole_name!= null) {
                ret.put(ModelBRole.FI_ROLE_NAME, dRole_name);
            }
            Byte dRole_type = instance.getRoleType();
            if (dRole_type!= null) {
                ret.put(ModelBRole.FI_ROLE_TYPE, dRole_type);
            }
            Integer dRole_sort = instance.getRoleSort();
            if (dRole_sort!= null) {
                ret.put(ModelBRole.FI_ROLE_SORT, dRole_sort);
            }
            Integer dRole_enabled = instance.getRoleEnabled();
            if (dRole_enabled!= null) {
                ret.put(ModelBRole.FI_ROLE_ENABLED, dRole_enabled);
            }
            String dRole_remark = instance.getRoleRemark();
            if (dRole_remark!= null) {
                ret.put(ModelBRole.FI_ROLE_REMARK, dRole_remark);
            }
            Integer dRole_creator = instance.getRoleCreator();
            if (dRole_creator!= null) {
                ret.put(ModelBRole.FI_ROLE_CREATOR, dRole_creator);
            }
            Date dRole_createdata = instance.getRoleCreatedata();
            if (dRole_createdata!= null) {
                ret.put(ModelBRole.FI_ROLE_CREATEDATA, dRole_createdata);
            }
            Integer dRole_updator = instance.getRoleUpdator();
            if (dRole_updator!= null) {
                ret.put(ModelBRole.FI_ROLE_UPDATOR, dRole_updator);
            }
            Date dRole_updatedata = instance.getRoleUpdatedata();
            if (dRole_updatedata!= null) {
                ret.put(ModelBRole.FI_ROLE_UPDATEDATA, dRole_updatedata);
            }
            Byte dRole_delete_flag = instance.getRoleDeleteFlag();
            if (dRole_delete_flag!= null) {
                ret.put(ModelBRole.FI_ROLE_DELETE_FLAG, dRole_delete_flag);
            }
            return ret;
        }

        @Override
        public ModelBRole fromCommonMap(Map<String, Object> param) {
            ModelBRole ret = new ModelBRole();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelBRole.FI_ID);
            if (dId!= null) {
                this.setField(ModelBRole.FI_ID, ret, dId);
            }
            Object dRole_code = param.get(ModelBRole.FI_ROLE_CODE);
            if (dRole_code!= null) {
                this.setField(ModelBRole.FI_ROLE_CODE, ret, dRole_code);
            }
            Object dRole_name = param.get(ModelBRole.FI_ROLE_NAME);
            if (dRole_name!= null) {
                this.setField(ModelBRole.FI_ROLE_NAME, ret, dRole_name);
            }
            Object dRole_type = param.get(ModelBRole.FI_ROLE_TYPE);
            if (dRole_type!= null) {
                this.setField(ModelBRole.FI_ROLE_TYPE, ret, dRole_type);
            }
            Object dRole_sort = param.get(ModelBRole.FI_ROLE_SORT);
            if (dRole_sort!= null) {
                this.setField(ModelBRole.FI_ROLE_SORT, ret, dRole_sort);
            }
            Object dRole_enabled = param.get(ModelBRole.FI_ROLE_ENABLED);
            if (dRole_enabled!= null) {
                this.setField(ModelBRole.FI_ROLE_ENABLED, ret, dRole_enabled);
            }
            Object dRole_remark = param.get(ModelBRole.FI_ROLE_REMARK);
            if (dRole_remark!= null) {
                this.setField(ModelBRole.FI_ROLE_REMARK, ret, dRole_remark);
            }
            Object dRole_creator = param.get(ModelBRole.FI_ROLE_CREATOR);
            if (dRole_creator!= null) {
                this.setField(ModelBRole.FI_ROLE_CREATOR, ret, dRole_creator);
            }
            Object dRole_createdata = param.get(ModelBRole.FI_ROLE_CREATEDATA);
            if (dRole_createdata!= null) {
                this.setField(ModelBRole.FI_ROLE_CREATEDATA, ret, dRole_createdata);
            }
            Object dRole_updator = param.get(ModelBRole.FI_ROLE_UPDATOR);
            if (dRole_updator!= null) {
                this.setField(ModelBRole.FI_ROLE_UPDATOR, ret, dRole_updator);
            }
            Object dRole_updatedata = param.get(ModelBRole.FI_ROLE_UPDATEDATA);
            if (dRole_updatedata!= null) {
                this.setField(ModelBRole.FI_ROLE_UPDATEDATA, ret, dRole_updatedata);
            }
            Object dRole_delete_flag = param.get(ModelBRole.FI_ROLE_DELETE_FLAG);
            if (dRole_delete_flag!= null) {
                this.setField(ModelBRole.FI_ROLE_DELETE_FLAG, ret, dRole_delete_flag);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldRoleCode(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldRoleName(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldRoleType(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldRoleSort(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldRoleEnabled(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldRoleRemark(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldRoleCreator(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldRoleCreatedata(Object obj) {
            return ((Date) obj);
        }

        protected Integer mapToFieldRoleUpdator(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldRoleUpdatedata(Object obj) {
            return ((Date) obj);
        }

        protected Byte mapToFieldRoleDeleteFlag(Object obj) {
            return ((Byte) obj);
        }

        public<TT> TT getField(String field, ModelBRole instance) {
            try {
                if (field.equals(ModelBRole.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelBRole.FI_ROLE_CODE)) {
                        return ((TT) instance.getRoleCode());
                    } else {
                        if (field.equals(ModelBRole.FI_ROLE_NAME)) {
                            return ((TT) instance.getRoleName());
                        } else {
                            if (field.equals(ModelBRole.FI_ROLE_TYPE)) {
                                return ((TT) instance.getRoleType());
                            } else {
                                if (field.equals(ModelBRole.FI_ROLE_SORT)) {
                                    return ((TT) instance.getRoleSort());
                                } else {
                                    if (field.equals(ModelBRole.FI_ROLE_ENABLED)) {
                                        return ((TT) instance.getRoleEnabled());
                                    } else {
                                        if (field.equals(ModelBRole.FI_ROLE_REMARK)) {
                                            return ((TT) instance.getRoleRemark());
                                        } else {
                                            if (field.equals(ModelBRole.FI_ROLE_CREATOR)) {
                                                return ((TT) instance.getRoleCreator());
                                            } else {
                                                if (field.equals(ModelBRole.FI_ROLE_CREATEDATA)) {
                                                    return ((TT) instance.getRoleCreatedata());
                                                } else {
                                                    if (field.equals(ModelBRole.FI_ROLE_UPDATOR)) {
                                                        return ((TT) instance.getRoleUpdator());
                                                    } else {
                                                        if (field.equals(ModelBRole.FI_ROLE_UPDATEDATA)) {
                                                            return ((TT) instance.getRoleUpdatedata());
                                                        } else {
                                                            if (field.equals(ModelBRole.FI_ROLE_DELETE_FLAG)) {
                                                                return ((TT) instance.getRoleDeleteFlag());
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

        public<TT> void setField(String field, ModelBRole instance, TT value) {
            if (field.equals(ModelBRole.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelBRole.FI_ROLE_CODE)) {
                    try {
                        instance.setRoleCode(mapToFieldRoleCode(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelBRole.FI_ROLE_NAME)) {
                        try {
                            instance.setRoleName(mapToFieldRoleName(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelBRole.FI_ROLE_TYPE)) {
                            try {
                                instance.setRoleType(mapToFieldRoleType(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelBRole.FI_ROLE_SORT)) {
                                try {
                                    instance.setRoleSort(mapToFieldRoleSort(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelBRole.FI_ROLE_ENABLED)) {
                                    try {
                                        instance.setRoleEnabled(mapToFieldRoleEnabled(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelBRole.FI_ROLE_REMARK)) {
                                        try {
                                            instance.setRoleRemark(mapToFieldRoleRemark(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelBRole.FI_ROLE_CREATOR)) {
                                            try {
                                                instance.setRoleCreator(mapToFieldRoleCreator(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelBRole.FI_ROLE_CREATEDATA)) {
                                                try {
                                                    instance.setRoleCreatedata(mapToFieldRoleCreatedata(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelBRole.FI_ROLE_UPDATOR)) {
                                                    try {
                                                        instance.setRoleUpdator(mapToFieldRoleUpdator(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelBRole.FI_ROLE_UPDATEDATA)) {
                                                        try {
                                                            instance.setRoleUpdatedata(mapToFieldRoleUpdatedata(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelBRole.FI_ROLE_DELETE_FLAG)) {
                                                            try {
                                                                instance.setRoleDeleteFlag(mapToFieldRoleDeleteFlag(value));
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

        public void setField(String field, ModelBRole instance, byte[] value) {
            if (field.equals(ModelBRole.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelBRole.FI_ROLE_CODE)) {
                    instance.setRoleCode(mapToFieldRoleCode(value));
                } else {
                    if (field.equals(ModelBRole.FI_ROLE_NAME)) {
                        instance.setRoleName(mapToFieldRoleName(value));
                    } else {
                        if (field.equals(ModelBRole.FI_ROLE_TYPE)) {
                            instance.setRoleType(mapToFieldRoleType(value));
                        } else {
                            if (field.equals(ModelBRole.FI_ROLE_SORT)) {
                                instance.setRoleSort(mapToFieldRoleSort(value));
                            } else {
                                if (field.equals(ModelBRole.FI_ROLE_ENABLED)) {
                                    instance.setRoleEnabled(mapToFieldRoleEnabled(value));
                                } else {
                                    if (field.equals(ModelBRole.FI_ROLE_REMARK)) {
                                        instance.setRoleRemark(mapToFieldRoleRemark(value));
                                    } else {
                                        if (field.equals(ModelBRole.FI_ROLE_CREATOR)) {
                                            instance.setRoleCreator(mapToFieldRoleCreator(value));
                                        } else {
                                            if (field.equals(ModelBRole.FI_ROLE_CREATEDATA)) {
                                                instance.setRoleCreatedata(mapToFieldRoleCreatedata(value));
                                            } else {
                                                if (field.equals(ModelBRole.FI_ROLE_UPDATOR)) {
                                                    instance.setRoleUpdator(mapToFieldRoleUpdator(value));
                                                } else {
                                                    if (field.equals(ModelBRole.FI_ROLE_UPDATEDATA)) {
                                                        instance.setRoleUpdatedata(mapToFieldRoleUpdatedata(value));
                                                    } else {
                                                        if (field.equals(ModelBRole.FI_ROLE_DELETE_FLAG)) {
                                                            instance.setRoleDeleteFlag(mapToFieldRoleDeleteFlag(value));
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
