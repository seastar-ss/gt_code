package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumAreaType;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperTMallArea<T extends ModelTMallArea>
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
        return ((T) new ModelTMallArea());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldArea_type(rs, columnNames, instance);
        mapFieldArea_name(rs, columnNames, instance);
        mapFieldArea_arix_max_x(rs, columnNames, instance);
        mapFieldArea_arix_max_y(rs, columnNames, instance);
        mapFieldArea_arix_max_z(rs, columnNames, instance);
        mapFieldArea_reachable(rs, columnNames, instance);
        mapFieldArea_capacity(rs, columnNames, instance);
        mapFieldArea_arix_x_base(rs, columnNames, instance);
        mapFieldArea_arix_y_base(rs, columnNames, instance);
        mapFieldArea_arix_z_base(rs, columnNames, instance);
        mapFieldArea_index(rs, columnNames, instance);
        mapFieldArea_path(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_ID)) {
            instance.setId(rs.getInt(ModelTMallArea.FI_ID));
        }
    }

    protected void mapFieldArea_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_TYPE)) {
            instance.setAreaType(EnumAreaType.fromValue(rs.getByte(ModelTMallArea.FI_AREA_TYPE)));
        }
    }

    protected void mapFieldArea_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_NAME)) {
            instance.setAreaName(rs.getString(ModelTMallArea.FI_AREA_NAME));
        }
    }

    protected void mapFieldArea_arix_max_x(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
            instance.setAreaArixMaxX(rs.getInt(ModelTMallArea.FI_AREA_ARIX_MAX_X));
        }
    }

    protected void mapFieldArea_arix_max_y(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
            instance.setAreaArixMaxY(rs.getInt(ModelTMallArea.FI_AREA_ARIX_MAX_Y));
        }
    }

    protected void mapFieldArea_arix_max_z(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
            instance.setAreaArixMaxZ(rs.getInt(ModelTMallArea.FI_AREA_ARIX_MAX_Z));
        }
    }

    protected void mapFieldArea_reachable(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_REACHABLE)) {
            instance.setAreaReachable(rs.getByte(ModelTMallArea.FI_AREA_REACHABLE));
        }
    }

    protected void mapFieldArea_capacity(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_CAPACITY)) {
            instance.setAreaCapacity(rs.getInt(ModelTMallArea.FI_AREA_CAPACITY));
        }
    }

    protected void mapFieldArea_arix_x_base(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
            instance.setAreaArixXBase(rs.getInt(ModelTMallArea.FI_AREA_ARIX_X_BASE));
        }
    }

    protected void mapFieldArea_arix_y_base(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
            instance.setAreaArixYBase(rs.getInt(ModelTMallArea.FI_AREA_ARIX_Y_BASE));
        }
    }

    protected void mapFieldArea_arix_z_base(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
            instance.setAreaArixZBase(rs.getInt(ModelTMallArea.FI_AREA_ARIX_Z_BASE));
        }
    }

    protected void mapFieldArea_index(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_INDEX)) {
            instance.setAreaIndex(rs.getInt(ModelTMallArea.FI_AREA_INDEX));
        }
    }

    protected void mapFieldArea_path(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelTMallArea.FI_AREA_PATH)) {
            instance.setAreaPath(rs.getInt(ModelTMallArea.FI_AREA_PATH));
        }
    }
}
