package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperBUser<T extends ModelBUser>
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
        return ((T) new ModelBUser());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldUser_name(rs, columnNames, instance);
        mapFieldUser_show_name(rs, columnNames, instance);
        mapFieldUser_pwd(rs, columnNames, instance);
        mapFieldUser_mobile(rs, columnNames, instance);
        mapFieldUser_create_time(rs, columnNames, instance);
        mapFieldUser_salt(rs, columnNames, instance);
        mapFieldUser_wx(rs, columnNames, instance);
        mapFieldUser_email(rs, columnNames, instance);
        mapFieldUser_modify_time(rs, columnNames, instance);
        mapFieldUser_image(rs, columnNames, instance);
        mapFieldUser_avatar(rs, columnNames, instance);
        mapFieldUser_status(rs, columnNames, instance);
        mapFieldUser_wx_open_id(rs, columnNames, instance);
        mapFieldUser_push_token(rs, columnNames, instance);
        mapFieldUser_delete_flag(rs, columnNames, instance);
        mapFieldUser_type(rs, columnNames, instance);
        mapFieldUser_provider(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_ID)) {
            instance.setId(rs.getInt(ModelBUser.FI_ID));
        }
    }

    protected void mapFieldUser_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_NAME)) {
            instance.setUserName(rs.getString(ModelBUser.FI_USER_NAME));
        }
    }

    protected void mapFieldUser_show_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_SHOW_NAME)) {
            instance.setUserShowName(rs.getString(ModelBUser.FI_USER_SHOW_NAME));
        }
    }

    protected void mapFieldUser_pwd(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_PWD)) {
            instance.setUserPwd(rs.getString(ModelBUser.FI_USER_PWD));
        }
    }

    protected void mapFieldUser_mobile(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_MOBILE)) {
            instance.setUserMobile(rs.getString(ModelBUser.FI_USER_MOBILE));
        }
    }

    protected void mapFieldUser_create_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_CREATE_TIME)) {
            instance.setUserCreateTime(rs.getTimestamp(ModelBUser.FI_USER_CREATE_TIME));
        }
    }

    protected void mapFieldUser_salt(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_SALT)) {
            instance.setUserSalt(rs.getString(ModelBUser.FI_USER_SALT));
        }
    }

    protected void mapFieldUser_wx(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_WX)) {
            instance.setUserWx(rs.getString(ModelBUser.FI_USER_WX));
        }
    }

    protected void mapFieldUser_email(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_EMAIL)) {
            instance.setUserEmail(rs.getString(ModelBUser.FI_USER_EMAIL));
        }
    }

    protected void mapFieldUser_modify_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_MODIFY_TIME)) {
            instance.setUserModifyTime(rs.getTimestamp(ModelBUser.FI_USER_MODIFY_TIME));
        }
    }

    protected void mapFieldUser_image(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_IMAGE)) {
            instance.setUserImage(rs.getString(ModelBUser.FI_USER_IMAGE));
        }
    }

    protected void mapFieldUser_avatar(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_AVATAR)) {
            instance.setUserAvatar(rs.getString(ModelBUser.FI_USER_AVATAR));
        }
    }

    protected void mapFieldUser_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_STATUS)) {
            instance.setUserStatus(rs.getByte(ModelBUser.FI_USER_STATUS));
        }
    }

    protected void mapFieldUser_wx_open_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_WX_OPEN_ID)) {
            instance.setUserWxOpenId(rs.getString(ModelBUser.FI_USER_WX_OPEN_ID));
        }
    }

    protected void mapFieldUser_push_token(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_PUSH_TOKEN)) {
            instance.setUserPushToken(rs.getString(ModelBUser.FI_USER_PUSH_TOKEN));
        }
    }

    protected void mapFieldUser_delete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_DELETE_FLAG)) {
            instance.setUserDeleteFlag(rs.getByte(ModelBUser.FI_USER_DELETE_FLAG));
        }
    }

    protected void mapFieldUser_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_TYPE)) {
            instance.setUserType(rs.getInt(ModelBUser.FI_USER_TYPE));
        }
    }

    protected void mapFieldUser_provider(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBUser.FI_USER_PROVIDER)) {
            instance.setUserProvider(rs.getString(ModelBUser.FI_USER_PROVIDER));
        }
    }
}
