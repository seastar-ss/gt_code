package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperBRole<T extends ModelBRole>
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
        return ((T) new ModelBRole());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldRole_code(rs, columnNames, instance);
        mapFieldRole_name(rs, columnNames, instance);
        mapFieldRole_type(rs, columnNames, instance);
        mapFieldRole_sort(rs, columnNames, instance);
        mapFieldRole_enabled(rs, columnNames, instance);
        mapFieldRole_remark(rs, columnNames, instance);
        mapFieldRole_creator(rs, columnNames, instance);
        mapFieldRole_createdata(rs, columnNames, instance);
        mapFieldRole_updator(rs, columnNames, instance);
        mapFieldRole_updatedata(rs, columnNames, instance);
        mapFieldRole_delete_flag(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ID)) {
            instance.setId(rs.getInt(ModelBRole.FI_ID));
        }
    }

    protected void mapFieldRole_code(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_CODE)) {
            instance.setRoleCode(rs.getString(ModelBRole.FI_ROLE_CODE));
        }
    }

    protected void mapFieldRole_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_NAME)) {
            instance.setRoleName(rs.getString(ModelBRole.FI_ROLE_NAME));
        }
    }

    protected void mapFieldRole_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_TYPE)) {
            instance.setRoleType(rs.getByte(ModelBRole.FI_ROLE_TYPE));
        }
    }

    protected void mapFieldRole_sort(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_SORT)) {
            instance.setRoleSort(rs.getInt(ModelBRole.FI_ROLE_SORT));
        }
    }

    protected void mapFieldRole_enabled(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_ENABLED)) {
            instance.setRoleEnabled(rs.getInt(ModelBRole.FI_ROLE_ENABLED));
        }
    }

    protected void mapFieldRole_remark(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_REMARK)) {
            instance.setRoleRemark(rs.getString(ModelBRole.FI_ROLE_REMARK));
        }
    }

    protected void mapFieldRole_creator(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_CREATOR)) {
            instance.setRoleCreator(rs.getInt(ModelBRole.FI_ROLE_CREATOR));
        }
    }

    protected void mapFieldRole_createdata(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_CREATEDATA)) {
            instance.setRoleCreatedata(rs.getTimestamp(ModelBRole.FI_ROLE_CREATEDATA));
        }
    }

    protected void mapFieldRole_updator(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_UPDATOR)) {
            instance.setRoleUpdator(rs.getInt(ModelBRole.FI_ROLE_UPDATOR));
        }
    }

    protected void mapFieldRole_updatedata(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_UPDATEDATA)) {
            instance.setRoleUpdatedata(rs.getTimestamp(ModelBRole.FI_ROLE_UPDATEDATA));
        }
    }

    protected void mapFieldRole_delete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBRole.FI_ROLE_DELETE_FLAG)) {
            instance.setRoleDeleteFlag(rs.getByte(ModelBRole.FI_ROLE_DELETE_FLAG));
        }
    }
}
