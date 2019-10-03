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
 * base DTO,represent for table :t_user_login_auth_info
 * 	灰度名单表
 */
public class ModelTUserLoginAuthInfo
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_user_login_auth_info";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.t_user_login_auth_info.id 字段
     * 自增id
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.t_user_login_auth_info.user_id 字段
     * 用户id
     */
    Integer userId;
    public final static String FI_USER_ID = "user_id";
    /**
     * 对应数据库.t_user_login_auth_info.type 字段
     *  0:灰度名单  1:白名单 2 付费首页用户
     */
    Byte type;
    public final static String FI_TYPE = "type";
    /**
     * 对应数据库.t_user_login_auth_info.create_time 字段
     * 创建时间
     */
    Date createTime;
    public final static String FI_CREATE_TIME = "create_time";
    /**
     * 对应数据库.t_user_login_auth_info.delete_flag 字段
     *  0:正常 1:被删除
     */
    Byte deleteFlag;
    public final static String FI_DELETE_FLAG = "delete_flag";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTUserLoginAuthInfo.FI_ID, Integer.class).put(ModelTUserLoginAuthInfo.FI_USER_ID, Integer.class).put(ModelTUserLoginAuthInfo.FI_TYPE, Byte.class).put(ModelTUserLoginAuthInfo.FI_CREATE_TIME, Date.class).put(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, Byte.class).getMap();
    public final static Integer FIELD_COUNT = 5;
    public final static ResultSetMapperModelTUserLoginAuthInfo<ModelTUserLoginAuthInfo> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelTUserLoginAuthInfo<com.shangde.master.dmo.user.dto.basedto.ModelTUserLoginAuthInfo>();
    public final static ByteMapMapperModelTUserLoginAuthInfo MAP_OBJ_MAPPER = new ByteMapMapperModelTUserLoginAuthInfo();

    public ModelTUserLoginAuthInfo() {
    }

    public final Integer getId() {
        return id;
    }

    public final ModelTUserLoginAuthInfo setId(Integer lId) {
        id = lId;
        return this;
    }

    public final Integer getUserId() {
        return userId;
    }

    public final ModelTUserLoginAuthInfo setUserId(Integer lUserId) {
        userId = lUserId;
        return this;
    }

    public final Byte getType() {
        return type;
    }

    public final ModelTUserLoginAuthInfo setType(Byte lType) {
        type = lType;
        return this;
    }

    public final Date getCreateTime() {
        return createTime;
    }

    public final ModelTUserLoginAuthInfo setCreateTime(Date lCreateTime) {
        createTime = lCreateTime;
        return this;
    }

    public final Byte getDeleteFlag() {
        return deleteFlag;
    }

    public final ModelTUserLoginAuthInfo setDeleteFlag(Byte lDeleteFlag) {
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
        if (getUserId()!= null) {
            return false;
        }
        if (getType()!= null) {
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
            return ((FT) ModelTUserLoginAuthInfo.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUserLoginAuthInfo.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("userId").append(":").append(userId).append("}\n");
        ret.append("{").append("type").append(":").append(type).append("}\n");
        ret.append("{").append("createTime").append(":").append(createTime).append("}\n");
        ret.append("{").append("deleteFlag").append(":").append(deleteFlag).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelTUserLoginAuthInfo
        implements RedisMapMapper<ModelTUserLoginAuthInfo>
    {

        @Override
        public ModelTUserLoginAuthInfo fromMap(Map<byte[], byte[]> map) {
            ModelTUserLoginAuthInfo instance = new ModelTUserLoginAuthInfo();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTUserLoginAuthInfo.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTUserLoginAuthInfo.FI_USER_ID)) {
                        instance.setUserId(mapToFieldUserId(entry.getValue()));
                    } else {
                        if (field.equals(ModelTUserLoginAuthInfo.FI_TYPE)) {
                            instance.setType(mapToFieldType(entry.getValue()));
                        } else {
                            if (field.equals(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
                                instance.setCreateTime(mapToFieldCreateTime(entry.getValue()));
                            } else {
                                if (field.equals(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
                                    instance.setDeleteFlag(mapToFieldDeleteFlag(entry.getValue()));
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

        protected Byte mapToFieldType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Date mapToFieldCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Byte mapToFieldDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTUserLoginAuthInfo instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTUserLoginAuthInfo.FI_ID.getBytes(), valueId);
            byte[] valueUser_id = mapFromFieldUserId(instance.getUserId());
            ret.put(ModelTUserLoginAuthInfo.FI_USER_ID.getBytes(), valueUser_id);
            byte[] valueType = mapFromFieldType(instance.getType());
            ret.put(ModelTUserLoginAuthInfo.FI_TYPE.getBytes(), valueType);
            byte[] valueCreate_time = mapFromFieldCreateTime(instance.getCreateTime());
            ret.put(ModelTUserLoginAuthInfo.FI_CREATE_TIME.getBytes(), valueCreate_time);
            byte[] valueDelete_flag = mapFromFieldDeleteFlag(instance.getDeleteFlag());
            ret.put(ModelTUserLoginAuthInfo.FI_DELETE_FLAG.getBytes(), valueDelete_flag);
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

        protected byte[] mapFromFieldType(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTUserLoginAuthInfo instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTUserLoginAuthInfo.FI_ID, dId);
            }
            Integer dUser_id = instance.getUserId();
            if (dUser_id!= null) {
                ret.put(ModelTUserLoginAuthInfo.FI_USER_ID, dUser_id);
            }
            Byte dType = instance.getType();
            if (dType!= null) {
                ret.put(ModelTUserLoginAuthInfo.FI_TYPE, dType);
            }
            Date dCreate_time = instance.getCreateTime();
            if (dCreate_time!= null) {
                ret.put(ModelTUserLoginAuthInfo.FI_CREATE_TIME, dCreate_time);
            }
            Byte dDelete_flag = instance.getDeleteFlag();
            if (dDelete_flag!= null) {
                ret.put(ModelTUserLoginAuthInfo.FI_DELETE_FLAG, dDelete_flag);
            }
            return ret;
        }

        public<TT> TT getField(String field, ModelTUserLoginAuthInfo instance) {
            try {
                if (field.equals(ModelTUserLoginAuthInfo.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTUserLoginAuthInfo.FI_USER_ID)) {
                        return ((TT) instance.getUserId());
                    } else {
                        if (field.equals(ModelTUserLoginAuthInfo.FI_TYPE)) {
                            return ((TT) instance.getType());
                        } else {
                            if (field.equals(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
                                return ((TT) instance.getCreateTime());
                            } else {
                                if (field.equals(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
                                    return ((TT) instance.getDeleteFlag());
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

        public<TT> void setField(String field, ModelTUserLoginAuthInfo instance, TT value) {
            if (field.equals(ModelTUserLoginAuthInfo.FI_ID)) {
                try {
                    instance.setId(((Integer) value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTUserLoginAuthInfo.FI_USER_ID)) {
                    try {
                        instance.setUserId(((Integer) value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTUserLoginAuthInfo.FI_TYPE)) {
                        try {
                            instance.setType(((Byte) value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
                            try {
                                instance.setCreateTime(((Date) value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
                                try {
                                    instance.setDeleteFlag(((Byte) value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        public void setField(String field, ModelTUserLoginAuthInfo instance, byte[] value) {
            if (field.equals(ModelTUserLoginAuthInfo.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTUserLoginAuthInfo.FI_USER_ID)) {
                    instance.setUserId(mapToFieldUserId(value));
                } else {
                    if (field.equals(ModelTUserLoginAuthInfo.FI_TYPE)) {
                        instance.setType(mapToFieldType(value));
                    } else {
                        if (field.equals(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
                            instance.setCreateTime(mapToFieldCreateTime(value));
                        } else {
                            if (field.equals(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
                                instance.setDeleteFlag(mapToFieldDeleteFlag(value));
                            }
                        }
                    }
                }
            }
        }
    }

    public static class ResultSetMapperModelTUserLoginAuthInfo<T extends ModelTUserLoginAuthInfo>
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
            return ((T) new ModelTUserLoginAuthInfo());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldUser_id(rs, columnNames, instance);
            mapFieldType(rs, columnNames, instance);
            mapFieldCreate_time(rs, columnNames, instance);
            mapFieldDelete_flag(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthInfo.FI_ID)) {
                instance.setId(rs.getInt(ModelTUserLoginAuthInfo.FI_ID));
            }
        }

        protected void mapFieldUser_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthInfo.FI_USER_ID)) {
                instance.setUserId(rs.getInt(ModelTUserLoginAuthInfo.FI_USER_ID));
            }
        }

        protected void mapFieldType(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthInfo.FI_TYPE)) {
                instance.setType(rs.getByte(ModelTUserLoginAuthInfo.FI_TYPE));
            }
        }

        protected void mapFieldCreate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthInfo.FI_CREATE_TIME)) {
                instance.setCreateTime(rs.getTimestamp(ModelTUserLoginAuthInfo.FI_CREATE_TIME));
            }
        }

        protected void mapFieldDelete_flag(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserLoginAuthInfo.FI_DELETE_FLAG)) {
                instance.setDeleteFlag(rs.getByte(ModelTUserLoginAuthInfo.FI_DELETE_FLAG));
            }
        }
    }
}
