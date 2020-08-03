package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumOrgUserRole;
import com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperBOrgnizationUser<T extends ModelBOrgnizationUser>
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
        return ((T) new ModelBOrgnizationUser());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldOrg_id(rs, columnNames, instance);
        mapFieldUser_id(rs, columnNames, instance);
        mapFieldOrg_role(rs, columnNames, instance);
        mapFieldOrg_user_create_time(rs, columnNames, instance);
        mapFieldDelete_flag(rs, columnNames, instance);
        mapFieldIs_user_default_org(rs, columnNames, instance);
        mapFieldOrg_user_delete_flag(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_ID)) {
            instance.setId(rs.getInt(ModelBOrgnizationUser.FI_ID));
        }
    }

    protected void mapFieldOrg_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_ORG_ID)) {
            instance.setOrgId(rs.getInt(ModelBOrgnizationUser.FI_ORG_ID));
        }
    }

    protected void mapFieldUser_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_USER_ID)) {
            instance.setUserId(rs.getInt(ModelBOrgnizationUser.FI_USER_ID));
        }
    }

    protected void mapFieldOrg_role(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_ORG_ROLE)) {
            instance.setOrgRole(EnumOrgUserRole.fromValue(rs.getByte(ModelBOrgnizationUser.FI_ORG_ROLE)));
        }
    }

    protected void mapFieldOrg_user_create_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
            instance.setOrgUserCreateTime(rs.getTimestamp(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME));
        }
    }

    protected void mapFieldDelete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
            instance.setDeleteFlag(rs.getByte(ModelBOrgnizationUser.FI_DELETE_FLAG));
        }
    }

    protected void mapFieldIs_user_default_org(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
            instance.setIsUserDefaultOrg(EnumYesOrNo.fromValue(rs.getByte(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)));
        }
    }

    protected void mapFieldOrg_user_delete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
            instance.setOrgUserDeleteFlag(rs.getByte(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG));
        }
    }
}
