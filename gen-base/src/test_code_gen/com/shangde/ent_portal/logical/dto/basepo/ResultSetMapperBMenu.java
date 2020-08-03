package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperBMenu<T extends ModelBMenu>
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
        return ((T) new ModelBMenu());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldMenu_code(rs, columnNames, instance);
        mapFieldMenu_name(rs, columnNames, instance);
        mapFieldMenu_type(rs, columnNames, instance);
        mapFieldMenu_parent_id(rs, columnNames, instance);
        mapFieldMenu_parent_url(rs, columnNames, instance);
        mapFieldMenu_url(rs, columnNames, instance);
        mapFieldMenu_icon_class(rs, columnNames, instance);
        mapFieldMenu_sort(rs, columnNames, instance);
        mapFieldMenu_enabled(rs, columnNames, instance);
        mapFieldMenu_remark(rs, columnNames, instance);
        mapFieldMenu_creator(rs, columnNames, instance);
        mapFieldMenu_create_time(rs, columnNames, instance);
        mapFieldMenu_updator(rs, columnNames, instance);
        mapFieldMenu_update_time(rs, columnNames, instance);
        mapFieldMenu_delete_flag(rs, columnNames, instance);
        mapFieldMenu_level(rs, columnNames, instance);
        mapFieldMenu_auth(rs, columnNames, instance);
        mapFieldMenu_request_param_main(rs, columnNames, instance);
        mapFieldMenu_request_param_sub(rs, columnNames, instance);
        mapFieldMenu_function_id(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_ID)) {
            instance.setId(rs.getInt(ModelBMenu.FI_ID));
        }
    }

    protected void mapFieldMenu_code(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_CODE)) {
            instance.setMenuCode(rs.getString(ModelBMenu.FI_MENU_CODE));
        }
    }

    protected void mapFieldMenu_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_NAME)) {
            instance.setMenuName(rs.getString(ModelBMenu.FI_MENU_NAME));
        }
    }

    protected void mapFieldMenu_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_TYPE)) {
            instance.setMenuType(rs.getInt(ModelBMenu.FI_MENU_TYPE));
        }
    }

    protected void mapFieldMenu_parent_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_PARENT_ID)) {
            instance.setMenuParentId(rs.getInt(ModelBMenu.FI_MENU_PARENT_ID));
        }
    }

    protected void mapFieldMenu_parent_url(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_PARENT_URL)) {
            instance.setMenuParentUrl(rs.getString(ModelBMenu.FI_MENU_PARENT_URL));
        }
    }

    protected void mapFieldMenu_url(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_URL)) {
            instance.setMenuUrl(rs.getString(ModelBMenu.FI_MENU_URL));
        }
    }

    protected void mapFieldMenu_icon_class(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_ICON_CLASS)) {
            instance.setMenuIconClass(rs.getString(ModelBMenu.FI_MENU_ICON_CLASS));
        }
    }

    protected void mapFieldMenu_sort(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_SORT)) {
            instance.setMenuSort(rs.getInt(ModelBMenu.FI_MENU_SORT));
        }
    }

    protected void mapFieldMenu_enabled(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_ENABLED)) {
            instance.setMenuEnabled(rs.getInt(ModelBMenu.FI_MENU_ENABLED));
        }
    }

    protected void mapFieldMenu_remark(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_REMARK)) {
            instance.setMenuRemark(rs.getString(ModelBMenu.FI_MENU_REMARK));
        }
    }

    protected void mapFieldMenu_creator(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_CREATOR)) {
            instance.setMenuCreator(rs.getInt(ModelBMenu.FI_MENU_CREATOR));
        }
    }

    protected void mapFieldMenu_create_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_CREATE_TIME)) {
            instance.setMenuCreateTime(rs.getTimestamp(ModelBMenu.FI_MENU_CREATE_TIME));
        }
    }

    protected void mapFieldMenu_updator(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_UPDATOR)) {
            instance.setMenuUpdator(rs.getInt(ModelBMenu.FI_MENU_UPDATOR));
        }
    }

    protected void mapFieldMenu_update_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_UPDATE_TIME)) {
            instance.setMenuUpdateTime(rs.getTimestamp(ModelBMenu.FI_MENU_UPDATE_TIME));
        }
    }

    protected void mapFieldMenu_delete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_DELETE_FLAG)) {
            instance.setMenuDeleteFlag(rs.getByte(ModelBMenu.FI_MENU_DELETE_FLAG));
        }
    }

    protected void mapFieldMenu_level(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_LEVEL)) {
            instance.setMenuLevel(rs.getByte(ModelBMenu.FI_MENU_LEVEL));
        }
    }

    protected void mapFieldMenu_auth(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_AUTH)) {
            instance.setMenuAuth(rs.getInt(ModelBMenu.FI_MENU_AUTH));
        }
    }

    protected void mapFieldMenu_request_param_main(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
            instance.setMenuRequestParamMain(rs.getString(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN));
        }
    }

    protected void mapFieldMenu_request_param_sub(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
            instance.setMenuRequestParamSub(rs.getString(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB));
        }
    }

    protected void mapFieldMenu_function_id(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMenu.FI_MENU_FUNCTION_ID)) {
            instance.setMenuFunctionId(rs.getInt(ModelBMenu.FI_MENU_FUNCTION_ID));
        }
    }
}
