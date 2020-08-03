package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumMaterialProductType;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;

public class ResultSetMapperBMaterial<T extends ModelBMaterial>
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
        return ((T) new ModelBMaterial());
    }

    @Override
    public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
        throws SQLException
    {
        mapFieldId(rs, columnNames, instance);
        mapFieldMaterial_name(rs, columnNames, instance);
        mapFieldMaterial_code(rs, columnNames, instance);
        mapFieldMeterial_product_type(rs, columnNames, instance);
        mapFieldMeterial_cost(rs, columnNames, instance);
        mapFieldMeterial_name(rs, columnNames, instance);
        mapFieldMeterial_brand(rs, columnNames, instance);
        mapFieldMeterial_level(rs, columnNames, instance);
        mapFieldMeterial_specification(rs, columnNames, instance);
        mapFieldMeterial_style(rs, columnNames, instance);
        mapFieldMeterial_description(rs, columnNames, instance);
        mapFieldMeterial_feature(rs, columnNames, instance);
        mapFieldMaterial_price_para(rs, columnNames, instance);
        mapFieldMeterial_creator(rs, columnNames, instance);
        mapFieldMeterial_create_time(rs, columnNames, instance);
        mapFieldMeterial_update_time(rs, columnNames, instance);
        mapFieldMeterial_modify_by(rs, columnNames, instance);
        mapFieldMaterial_type(rs, columnNames, instance);
        mapFieldMain_measure_unit(rs, columnNames, instance);
        mapFieldMaterial_delete_flag(rs, columnNames, instance);
        mapFieldMaterial_status(rs, columnNames, instance);
        mapFieldMain_measure_unit_name(rs, columnNames, instance);
        mapFieldMaterial_weight(rs, columnNames, instance);
        mapFieldMaterial_drawing_no(rs, columnNames, instance);
        mapFieldMaterial_color(rs, columnNames, instance);
        mapFieldMaterial_area(rs, columnNames, instance);
        mapFieldMaterial_price(rs, columnNames, instance);
        mapFieldMaterial_width(rs, columnNames, instance);
        mapFieldMaterial_height(rs, columnNames, instance);
        mapFieldMaterial_length(rs, columnNames, instance);
        mapFieldMaterial_volumn(rs, columnNames, instance);
        instance.setIndex(rowNum);
        return instance;
    }

    protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_ID)) {
            instance.setId(rs.getInt(ModelBMaterial.FI_ID));
        }
    }

    protected void mapFieldMaterial_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_NAME)) {
            instance.setMaterialName(rs.getString(ModelBMaterial.FI_MATERIAL_NAME));
        }
    }

    protected void mapFieldMaterial_code(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_CODE)) {
            instance.setMaterialCode(rs.getString(ModelBMaterial.FI_MATERIAL_CODE));
        }
    }

    protected void mapFieldMeterial_product_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
            instance.setMeterialProductType(EnumMaterialProductType.fromValue(rs.getByte(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)));
        }
    }

    protected void mapFieldMeterial_cost(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_COST)) {
            instance.setMeterialCost(rs.getByte(ModelBMaterial.FI_METERIAL_COST));
        }
    }

    protected void mapFieldMeterial_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_NAME)) {
            instance.setMeterialName(rs.getString(ModelBMaterial.FI_METERIAL_NAME));
        }
    }

    protected void mapFieldMeterial_brand(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_BRAND)) {
            instance.setMeterialBrand(rs.getString(ModelBMaterial.FI_METERIAL_BRAND));
        }
    }

    protected void mapFieldMeterial_level(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_LEVEL)) {
            instance.setMeterialLevel(rs.getInt(ModelBMaterial.FI_METERIAL_LEVEL));
        }
    }

    protected void mapFieldMeterial_specification(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
            instance.setMeterialSpecification(rs.getString(ModelBMaterial.FI_METERIAL_SPECIFICATION));
        }
    }

    protected void mapFieldMeterial_style(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_STYLE)) {
            instance.setMeterialStyle(rs.getString(ModelBMaterial.FI_METERIAL_STYLE));
        }
    }

    protected void mapFieldMeterial_description(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
            instance.setMeterialDescription(rs.getString(ModelBMaterial.FI_METERIAL_DESCRIPTION));
        }
    }

    protected void mapFieldMeterial_feature(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_FEATURE)) {
            instance.setMeterialFeature(rs.getString(ModelBMaterial.FI_METERIAL_FEATURE));
        }
    }

    protected void mapFieldMaterial_price_para(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
            instance.setMaterialPricePara(rs.getInt(ModelBMaterial.FI_MATERIAL_PRICE_PARA));
        }
    }

    protected void mapFieldMeterial_creator(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_CREATOR)) {
            instance.setMeterialCreator(rs.getInt(ModelBMaterial.FI_METERIAL_CREATOR));
        }
    }

    protected void mapFieldMeterial_create_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
            instance.setMeterialCreateTime(rs.getTimestamp(ModelBMaterial.FI_METERIAL_CREATE_TIME));
        }
    }

    protected void mapFieldMeterial_update_time(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
            instance.setMeterialUpdateTime(rs.getTimestamp(ModelBMaterial.FI_METERIAL_UPDATE_TIME));
        }
    }

    protected void mapFieldMeterial_modify_by(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
            instance.setMeterialModifyBy(rs.getInt(ModelBMaterial.FI_METERIAL_MODIFY_BY));
        }
    }

    protected void mapFieldMaterial_type(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_TYPE)) {
            instance.setMaterialType(rs.getInt(ModelBMaterial.FI_MATERIAL_TYPE));
        }
    }

    protected void mapFieldMain_measure_unit(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
            instance.setMainMeasureUnit(rs.getInt(ModelBMaterial.FI_MAIN_MEASURE_UNIT));
        }
    }

    protected void mapFieldMaterial_delete_flag(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
            instance.setMaterialDeleteFlag(rs.getByte(ModelBMaterial.FI_MATERIAL_DELETE_FLAG));
        }
    }

    protected void mapFieldMaterial_status(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_STATUS)) {
            instance.setMaterialStatus(rs.getByte(ModelBMaterial.FI_MATERIAL_STATUS));
        }
    }

    protected void mapFieldMain_measure_unit_name(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
            instance.setMainMeasureUnitName(rs.getString(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME));
        }
    }

    protected void mapFieldMaterial_weight(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
            instance.setMaterialWeight(rs.getLong(ModelBMaterial.FI_MATERIAL_WEIGHT));
        }
    }

    protected void mapFieldMaterial_drawing_no(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
            instance.setMaterialDrawingNo(rs.getString(ModelBMaterial.FI_MATERIAL_DRAWING_NO));
        }
    }

    protected void mapFieldMaterial_color(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_COLOR)) {
            instance.setMaterialColor(rs.getString(ModelBMaterial.FI_MATERIAL_COLOR));
        }
    }

    protected void mapFieldMaterial_area(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_AREA)) {
            instance.setMaterialArea(rs.getLong(ModelBMaterial.FI_MATERIAL_AREA));
        }
    }

    protected void mapFieldMaterial_price(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_PRICE)) {
            instance.setMaterialPrice(rs.getLong(ModelBMaterial.FI_MATERIAL_PRICE));
        }
    }

    protected void mapFieldMaterial_width(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_WIDTH)) {
            instance.setMaterialWidth(rs.getLong(ModelBMaterial.FI_MATERIAL_WIDTH));
        }
    }

    protected void mapFieldMaterial_height(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
            instance.setMaterialHeight(rs.getLong(ModelBMaterial.FI_MATERIAL_HEIGHT));
        }
    }

    protected void mapFieldMaterial_length(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_LENGTH)) {
            instance.setMaterialLength(rs.getLong(ModelBMaterial.FI_MATERIAL_LENGTH));
        }
    }

    protected void mapFieldMaterial_volumn(ResultSet rs, Set<String> columnNames, T instance)
        throws SQLException
    {
        if (columnNames.contains(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
            instance.setMaterialVolumn(rs.getLong(ModelBMaterial.FI_MATERIAL_VOLUMN));
        }
    }
}
