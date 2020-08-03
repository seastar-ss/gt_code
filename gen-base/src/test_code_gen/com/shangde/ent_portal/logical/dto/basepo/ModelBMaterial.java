/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumMaterialProductType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;


/**
 * base DTO,represent for  :b_material
 */
public class ModelBMaterial
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    String materialName;
    public final static String FI_MATERIAL_NAME = "material_name";
    String materialCode;
    public final static String FI_MATERIAL_CODE = "material_code";
    EnumMaterialProductType meterialProductType;
    public final static String FI_METERIAL_PRODUCT_TYPE = "meterial_product_type";
    /**
     * 物料贵重程度,1-100，数值越高越贵重
     */
    Byte meterialCost;
    public final static String FI_METERIAL_COST = "meterial_cost";
    /**
     * 物料名称
     */
    String meterialName;
    public final static String FI_METERIAL_NAME = "meterial_name";
    /**
     * 物料品牌
     */
    String meterialBrand;
    public final static String FI_METERIAL_BRAND = "meterial_brand";
    /**
     * 物料等级,关联b_define_dictionary.define_aspect=1时的b_define_dictionary.define_value
     */
    Integer meterialLevel;
    public final static String FI_METERIAL_LEVEL = "meterial_level";
    /**
     * 物料规格
     */
    String meterialSpecification;
    public final static String FI_METERIAL_SPECIFICATION = "meterial_specification";
    /**
     * 物料型号
     */
    String meterialStyle;
    public final static String FI_METERIAL_STYLE = "meterial_style";
    /**
     * 物料描述
     */
    String meterialDescription;
    public final static String FI_METERIAL_DESCRIPTION = "meterial_description";
    /**
     * 材质
     */
    String meterialFeature;
    public final static String FI_METERIAL_FEATURE = "meterial_feature";
    /**
     * 物料价格参数
     */
    Integer materialPricePara;
    public final static String FI_MATERIAL_PRICE_PARA = "material_price_para";
    Integer meterialCreator;
    public final static String FI_METERIAL_CREATOR = "meterial_creator";
    Date meterialCreateTime;
    public final static String FI_METERIAL_CREATE_TIME = "meterial_create_time";
    /**
     * 更新时间
     */
    Date meterialUpdateTime;
    public final static String FI_METERIAL_UPDATE_TIME = "meterial_update_time";
    /**
     * 更新人
     */
    Integer meterialModifyBy;
    public final static String FI_METERIAL_MODIFY_BY = "meterial_modify_by";
    /**
     * 物料类型,引用b_material_type.id
     */
    Integer materialType;
    public final static String FI_MATERIAL_TYPE = "material_type";
    /**
     * 主要计量单位
     */
    Integer mainMeasureUnit;
    public final static String FI_MAIN_MEASURE_UNIT = "main_measure_unit";
    /**
     * 删除标记
     */
    Byte materialDeleteFlag;
    public final static String FI_MATERIAL_DELETE_FLAG = "material_delete_flag";
    /**
     * 状态 1：在用，0：禁用
     */
    Byte materialStatus;
    public final static String FI_MATERIAL_STATUS = "material_status";
    /**
     * 主单位名称
     */
    String mainMeasureUnitName;
    public final static String FI_MAIN_MEASURE_UNIT_NAME = "main_measure_unit_name";
    /**
     * 重量,保留6为小数
     */
    Long materialWeight;
    public final static String FI_MATERIAL_WEIGHT = "material_weight";
    /**
     * 图号
     */
    String materialDrawingNo;
    public final static String FI_MATERIAL_DRAWING_NO = "material_drawing_no";
    /**
     * 颜色
     */
    String materialColor;
    public final static String FI_MATERIAL_COLOR = "material_color";
    /**
     * 面积,保留6位小数
     */
    Long materialArea;
    public final static String FI_MATERIAL_AREA = "material_area";
    /**
     * 价格，保留6位小数
     */
    Long materialPrice;
    public final static String FI_MATERIAL_PRICE = "material_price";
    /**
     * 物料宽度
     */
    Long materialWidth;
    public final static String FI_MATERIAL_WIDTH = "material_width";
    /**
     * 物料高度
     */
    Long materialHeight;
    public final static String FI_MATERIAL_HEIGHT = "material_height";
    /**
     * 物料长度
     */
    Long materialLength;
    public final static String FI_MATERIAL_LENGTH = "material_length";
    /**
     * 物料体积
     */
    Long materialVolumn;
    public final static String FI_MATERIAL_VOLUMN = "material_volumn";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelBMaterial.FI_ID, Integer.class).put(ModelBMaterial.FI_MATERIAL_NAME, String.class).put(ModelBMaterial.FI_MATERIAL_CODE, String.class).put(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE, EnumMaterialProductType.class).put(ModelBMaterial.FI_METERIAL_COST, Byte.class).put(ModelBMaterial.FI_METERIAL_NAME, String.class).put(ModelBMaterial.FI_METERIAL_BRAND, String.class).put(ModelBMaterial.FI_METERIAL_LEVEL, Integer.class).put(ModelBMaterial.FI_METERIAL_SPECIFICATION, String.class).put(ModelBMaterial.FI_METERIAL_STYLE, String.class).put(ModelBMaterial.FI_METERIAL_DESCRIPTION, String.class).put(ModelBMaterial.FI_METERIAL_FEATURE, String.class).put(ModelBMaterial.FI_MATERIAL_PRICE_PARA, Integer.class).put(ModelBMaterial.FI_METERIAL_CREATOR, Integer.class).put(ModelBMaterial.FI_METERIAL_CREATE_TIME, Date.class).put(ModelBMaterial.FI_METERIAL_UPDATE_TIME, Date.class).put(ModelBMaterial.FI_METERIAL_MODIFY_BY, Integer.class).put(ModelBMaterial.FI_MATERIAL_TYPE, Integer.class).put(ModelBMaterial.FI_MAIN_MEASURE_UNIT, Integer.class).put(ModelBMaterial.FI_MATERIAL_DELETE_FLAG, Byte.class).put(ModelBMaterial.FI_MATERIAL_STATUS, Byte.class).put(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME, String.class).put(ModelBMaterial.FI_MATERIAL_WEIGHT, Long.class).put(ModelBMaterial.FI_MATERIAL_DRAWING_NO, String.class).put(ModelBMaterial.FI_MATERIAL_COLOR, String.class).put(ModelBMaterial.FI_MATERIAL_AREA, Long.class).put(ModelBMaterial.FI_MATERIAL_PRICE, Long.class).put(ModelBMaterial.FI_MATERIAL_WIDTH, Long.class).put(ModelBMaterial.FI_MATERIAL_HEIGHT, Long.class).put(ModelBMaterial.FI_MATERIAL_LENGTH, Long.class).put(ModelBMaterial.FI_MATERIAL_VOLUMN, Long.class).getMap();
    public final static Integer FIELD_COUNT = 31;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "b_material";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelBMaterial() {
    }

    public Integer getId() {
        return id;
    }

    public ModelBMaterial setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getMaterialName() {
        return materialName;
    }

    public ModelBMaterial setMaterialName(String lMaterialName) {
        materialName = lMaterialName;
        return this;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public ModelBMaterial setMaterialCode(String lMaterialCode) {
        materialCode = lMaterialCode;
        return this;
    }

    public EnumMaterialProductType getMeterialProductType() {
        return meterialProductType;
    }

    public ModelBMaterial setMeterialProductType(EnumMaterialProductType lMeterialProductType) {
        meterialProductType = lMeterialProductType;
        return this;
    }

    public Byte getMeterialCost() {
        return meterialCost;
    }

    public ModelBMaterial setMeterialCost(Byte lMeterialCost) {
        meterialCost = lMeterialCost;
        return this;
    }

    public String getMeterialName() {
        return meterialName;
    }

    public ModelBMaterial setMeterialName(String lMeterialName) {
        meterialName = lMeterialName;
        return this;
    }

    public String getMeterialBrand() {
        return meterialBrand;
    }

    public ModelBMaterial setMeterialBrand(String lMeterialBrand) {
        meterialBrand = lMeterialBrand;
        return this;
    }

    public Integer getMeterialLevel() {
        return meterialLevel;
    }

    public ModelBMaterial setMeterialLevel(Integer lMeterialLevel) {
        meterialLevel = lMeterialLevel;
        return this;
    }

    public String getMeterialSpecification() {
        return meterialSpecification;
    }

    public ModelBMaterial setMeterialSpecification(String lMeterialSpecification) {
        meterialSpecification = lMeterialSpecification;
        return this;
    }

    public String getMeterialStyle() {
        return meterialStyle;
    }

    public ModelBMaterial setMeterialStyle(String lMeterialStyle) {
        meterialStyle = lMeterialStyle;
        return this;
    }

    public String getMeterialDescription() {
        return meterialDescription;
    }

    public ModelBMaterial setMeterialDescription(String lMeterialDescription) {
        meterialDescription = lMeterialDescription;
        return this;
    }

    public String getMeterialFeature() {
        return meterialFeature;
    }

    public ModelBMaterial setMeterialFeature(String lMeterialFeature) {
        meterialFeature = lMeterialFeature;
        return this;
    }

    public Integer getMaterialPricePara() {
        return materialPricePara;
    }

    public ModelBMaterial setMaterialPricePara(Integer lMaterialPricePara) {
        materialPricePara = lMaterialPricePara;
        return this;
    }

    public Integer getMeterialCreator() {
        return meterialCreator;
    }

    public ModelBMaterial setMeterialCreator(Integer lMeterialCreator) {
        meterialCreator = lMeterialCreator;
        return this;
    }

    public Date getMeterialCreateTime() {
        return meterialCreateTime;
    }

    public ModelBMaterial setMeterialCreateTime(Date lMeterialCreateTime) {
        meterialCreateTime = lMeterialCreateTime;
        return this;
    }

    public Date getMeterialUpdateTime() {
        return meterialUpdateTime;
    }

    public ModelBMaterial setMeterialUpdateTime(Date lMeterialUpdateTime) {
        meterialUpdateTime = lMeterialUpdateTime;
        return this;
    }

    public Integer getMeterialModifyBy() {
        return meterialModifyBy;
    }

    public ModelBMaterial setMeterialModifyBy(Integer lMeterialModifyBy) {
        meterialModifyBy = lMeterialModifyBy;
        return this;
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public ModelBMaterial setMaterialType(Integer lMaterialType) {
        materialType = lMaterialType;
        return this;
    }

    public Integer getMainMeasureUnit() {
        return mainMeasureUnit;
    }

    public ModelBMaterial setMainMeasureUnit(Integer lMainMeasureUnit) {
        mainMeasureUnit = lMainMeasureUnit;
        return this;
    }

    public Byte getMaterialDeleteFlag() {
        return materialDeleteFlag;
    }

    public ModelBMaterial setMaterialDeleteFlag(Byte lMaterialDeleteFlag) {
        materialDeleteFlag = lMaterialDeleteFlag;
        return this;
    }

    public Byte getMaterialStatus() {
        return materialStatus;
    }

    public ModelBMaterial setMaterialStatus(Byte lMaterialStatus) {
        materialStatus = lMaterialStatus;
        return this;
    }

    public String getMainMeasureUnitName() {
        return mainMeasureUnitName;
    }

    public ModelBMaterial setMainMeasureUnitName(String lMainMeasureUnitName) {
        mainMeasureUnitName = lMainMeasureUnitName;
        return this;
    }

    public Long getMaterialWeight() {
        return materialWeight;
    }

    public ModelBMaterial setMaterialWeight(Long lMaterialWeight) {
        materialWeight = lMaterialWeight;
        return this;
    }

    public String getMaterialDrawingNo() {
        return materialDrawingNo;
    }

    public ModelBMaterial setMaterialDrawingNo(String lMaterialDrawingNo) {
        materialDrawingNo = lMaterialDrawingNo;
        return this;
    }

    public String getMaterialColor() {
        return materialColor;
    }

    public ModelBMaterial setMaterialColor(String lMaterialColor) {
        materialColor = lMaterialColor;
        return this;
    }

    public Long getMaterialArea() {
        return materialArea;
    }

    public ModelBMaterial setMaterialArea(Long lMaterialArea) {
        materialArea = lMaterialArea;
        return this;
    }

    public Long getMaterialPrice() {
        return materialPrice;
    }

    public ModelBMaterial setMaterialPrice(Long lMaterialPrice) {
        materialPrice = lMaterialPrice;
        return this;
    }

    public Long getMaterialWidth() {
        return materialWidth;
    }

    public ModelBMaterial setMaterialWidth(Long lMaterialWidth) {
        materialWidth = lMaterialWidth;
        return this;
    }

    public Long getMaterialHeight() {
        return materialHeight;
    }

    public ModelBMaterial setMaterialHeight(Long lMaterialHeight) {
        materialHeight = lMaterialHeight;
        return this;
    }

    public Long getMaterialLength() {
        return materialLength;
    }

    public ModelBMaterial setMaterialLength(Long lMaterialLength) {
        materialLength = lMaterialLength;
        return this;
    }

    public Long getMaterialVolumn() {
        return materialVolumn;
    }

    public ModelBMaterial setMaterialVolumn(Long lMaterialVolumn) {
        materialVolumn = lMaterialVolumn;
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
        if (getMaterialName()!= null) {
            return false;
        }
        if (getMaterialCode()!= null) {
            return false;
        }
        if (getMeterialProductType()!= null) {
            return false;
        }
        if (getMeterialCost()!= null) {
            return false;
        }
        if (getMeterialName()!= null) {
            return false;
        }
        if (getMeterialBrand()!= null) {
            return false;
        }
        if (getMeterialLevel()!= null) {
            return false;
        }
        if (getMeterialSpecification()!= null) {
            return false;
        }
        if (getMeterialStyle()!= null) {
            return false;
        }
        if (getMeterialDescription()!= null) {
            return false;
        }
        if (getMeterialFeature()!= null) {
            return false;
        }
        if (getMaterialPricePara()!= null) {
            return false;
        }
        if (getMeterialCreator()!= null) {
            return false;
        }
        if (getMeterialCreateTime()!= null) {
            return false;
        }
        if (getMeterialUpdateTime()!= null) {
            return false;
        }
        if (getMeterialModifyBy()!= null) {
            return false;
        }
        if (getMaterialType()!= null) {
            return false;
        }
        if (getMainMeasureUnit()!= null) {
            return false;
        }
        if (getMaterialDeleteFlag()!= null) {
            return false;
        }
        if (getMaterialStatus()!= null) {
            return false;
        }
        if (getMainMeasureUnitName()!= null) {
            return false;
        }
        if (getMaterialWeight()!= null) {
            return false;
        }
        if (getMaterialDrawingNo()!= null) {
            return false;
        }
        if (getMaterialColor()!= null) {
            return false;
        }
        if (getMaterialArea()!= null) {
            return false;
        }
        if (getMaterialPrice()!= null) {
            return false;
        }
        if (getMaterialWidth()!= null) {
            return false;
        }
        if (getMaterialHeight()!= null) {
            return false;
        }
        if (getMaterialLength()!= null) {
            return false;
        }
        if (getMaterialVolumn()!= null) {
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
        ret.append("{").append("materialName").append(":").append(materialName).append("}\n");
        ret.append("{").append("materialCode").append(":").append(materialCode).append("}\n");
        ret.append("{").append("meterialProductType").append(":").append(meterialProductType).append("}\n");
        ret.append("{").append("meterialCost").append(":").append(meterialCost).append("}\n");
        ret.append("{").append("meterialName").append(":").append(meterialName).append("}\n");
        ret.append("{").append("meterialBrand").append(":").append(meterialBrand).append("}\n");
        ret.append("{").append("meterialLevel").append(":").append(meterialLevel).append("}\n");
        ret.append("{").append("meterialSpecification").append(":").append(meterialSpecification).append("}\n");
        ret.append("{").append("meterialStyle").append(":").append(meterialStyle).append("}\n");
        ret.append("{").append("meterialDescription").append(":").append(meterialDescription).append("}\n");
        ret.append("{").append("meterialFeature").append(":").append(meterialFeature).append("}\n");
        ret.append("{").append("materialPricePara").append(":").append(materialPricePara).append("}\n");
        ret.append("{").append("meterialCreator").append(":").append(meterialCreator).append("}\n");
        ret.append("{").append("meterialCreateTime").append(":").append(meterialCreateTime).append("}\n");
        ret.append("{").append("meterialUpdateTime").append(":").append(meterialUpdateTime).append("}\n");
        ret.append("{").append("meterialModifyBy").append(":").append(meterialModifyBy).append("}\n");
        ret.append("{").append("materialType").append(":").append(materialType).append("}\n");
        ret.append("{").append("mainMeasureUnit").append(":").append(mainMeasureUnit).append("}\n");
        ret.append("{").append("materialDeleteFlag").append(":").append(materialDeleteFlag).append("}\n");
        ret.append("{").append("materialStatus").append(":").append(materialStatus).append("}\n");
        ret.append("{").append("mainMeasureUnitName").append(":").append(mainMeasureUnitName).append("}\n");
        ret.append("{").append("materialWeight").append(":").append(materialWeight).append("}\n");
        ret.append("{").append("materialDrawingNo").append(":").append(materialDrawingNo).append("}\n");
        ret.append("{").append("materialColor").append(":").append(materialColor).append("}\n");
        ret.append("{").append("materialArea").append(":").append(materialArea).append("}\n");
        ret.append("{").append("materialPrice").append(":").append(materialPrice).append("}\n");
        ret.append("{").append("materialWidth").append(":").append(materialWidth).append("}\n");
        ret.append("{").append("materialHeight").append(":").append(materialHeight).append("}\n");
        ret.append("{").append("materialLength").append(":").append(materialLength).append("}\n");
        ret.append("{").append("materialVolumn").append(":").append(materialVolumn).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelBMaterial
        implements RedisMapMapper<ModelBMaterial>
    {

        @Override
        public ModelBMaterial fromMap(Map<byte[], byte[]> map) {
            ModelBMaterial instance = new ModelBMaterial();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelBMaterial.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelBMaterial.FI_MATERIAL_NAME)) {
                        instance.setMaterialName(mapToFieldMaterialName(entry.getValue()));
                    } else {
                        if (field.equals(ModelBMaterial.FI_MATERIAL_CODE)) {
                            instance.setMaterialCode(mapToFieldMaterialCode(entry.getValue()));
                        } else {
                            if (field.equals(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
                                instance.setMeterialProductType(mapToFieldMeterialProductType(entry.getValue()));
                            } else {
                                if (field.equals(ModelBMaterial.FI_METERIAL_COST)) {
                                    instance.setMeterialCost(mapToFieldMeterialCost(entry.getValue()));
                                } else {
                                    if (field.equals(ModelBMaterial.FI_METERIAL_NAME)) {
                                        instance.setMeterialName(mapToFieldMeterialName(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelBMaterial.FI_METERIAL_BRAND)) {
                                            instance.setMeterialBrand(mapToFieldMeterialBrand(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelBMaterial.FI_METERIAL_LEVEL)) {
                                                instance.setMeterialLevel(mapToFieldMeterialLevel(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
                                                    instance.setMeterialSpecification(mapToFieldMeterialSpecification(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelBMaterial.FI_METERIAL_STYLE)) {
                                                        instance.setMeterialStyle(mapToFieldMeterialStyle(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
                                                            instance.setMeterialDescription(mapToFieldMeterialDescription(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelBMaterial.FI_METERIAL_FEATURE)) {
                                                                instance.setMeterialFeature(mapToFieldMeterialFeature(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
                                                                    instance.setMaterialPricePara(mapToFieldMaterialPricePara(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelBMaterial.FI_METERIAL_CREATOR)) {
                                                                        instance.setMeterialCreator(mapToFieldMeterialCreator(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
                                                                            instance.setMeterialCreateTime(mapToFieldMeterialCreateTime(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
                                                                                instance.setMeterialUpdateTime(mapToFieldMeterialUpdateTime(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
                                                                                    instance.setMeterialModifyBy(mapToFieldMeterialModifyBy(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_TYPE)) {
                                                                                        instance.setMaterialType(mapToFieldMaterialType(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
                                                                                            instance.setMainMeasureUnit(mapToFieldMainMeasureUnit(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
                                                                                                instance.setMaterialDeleteFlag(mapToFieldMaterialDeleteFlag(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_STATUS)) {
                                                                                                    instance.setMaterialStatus(mapToFieldMaterialStatus(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
                                                                                                        instance.setMainMeasureUnitName(mapToFieldMainMeasureUnitName(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
                                                                                                            instance.setMaterialWeight(mapToFieldMaterialWeight(entry.getValue()));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
                                                                                                                instance.setMaterialDrawingNo(mapToFieldMaterialDrawingNo(entry.getValue()));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_COLOR)) {
                                                                                                                    instance.setMaterialColor(mapToFieldMaterialColor(entry.getValue()));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_AREA)) {
                                                                                                                        instance.setMaterialArea(mapToFieldMaterialArea(entry.getValue()));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE)) {
                                                                                                                            instance.setMaterialPrice(mapToFieldMaterialPrice(entry.getValue()));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_WIDTH)) {
                                                                                                                                instance.setMaterialWidth(mapToFieldMaterialWidth(entry.getValue()));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
                                                                                                                                    instance.setMaterialHeight(mapToFieldMaterialHeight(entry.getValue()));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_LENGTH)) {
                                                                                                                                        instance.setMaterialLength(mapToFieldMaterialLength(entry.getValue()));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
                                                                                                                                            instance.setMaterialVolumn(mapToFieldMaterialVolumn(entry.getValue()));
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

        protected String mapToFieldMaterialName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMaterialCode(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected EnumMaterialProductType mapToFieldMeterialProductType(byte[] bytes) {
            return EnumMaterialProductType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected Byte mapToFieldMeterialCost(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected String mapToFieldMeterialName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMeterialBrand(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldMeterialLevel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldMeterialSpecification(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMeterialStyle(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMeterialDescription(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMeterialFeature(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldMaterialPricePara(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMeterialCreator(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldMeterialCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Date mapToFieldMeterialUpdateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Integer mapToFieldMeterialModifyBy(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMaterialType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMainMeasureUnit(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldMaterialDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Byte mapToFieldMaterialStatus(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected String mapToFieldMainMeasureUnitName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Long mapToFieldMaterialWeight(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected String mapToFieldMaterialDrawingNo(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMaterialColor(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Long mapToFieldMaterialArea(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldMaterialPrice(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldMaterialWidth(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldMaterialHeight(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldMaterialLength(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Long mapToFieldMaterialVolumn(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelBMaterial instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelBMaterial.FI_ID.getBytes(), valueId);
            byte[] valueMaterial_name = mapFromFieldMaterialName(instance.getMaterialName());
            ret.put(ModelBMaterial.FI_MATERIAL_NAME.getBytes(), valueMaterial_name);
            byte[] valueMaterial_code = mapFromFieldMaterialCode(instance.getMaterialCode());
            ret.put(ModelBMaterial.FI_MATERIAL_CODE.getBytes(), valueMaterial_code);
            byte[] valueMeterial_product_type = mapFromFieldMeterialProductType(instance.getMeterialProductType());
            ret.put(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE.getBytes(), valueMeterial_product_type);
            byte[] valueMeterial_cost = mapFromFieldMeterialCost(instance.getMeterialCost());
            ret.put(ModelBMaterial.FI_METERIAL_COST.getBytes(), valueMeterial_cost);
            byte[] valueMeterial_name = mapFromFieldMeterialName(instance.getMeterialName());
            ret.put(ModelBMaterial.FI_METERIAL_NAME.getBytes(), valueMeterial_name);
            byte[] valueMeterial_brand = mapFromFieldMeterialBrand(instance.getMeterialBrand());
            ret.put(ModelBMaterial.FI_METERIAL_BRAND.getBytes(), valueMeterial_brand);
            byte[] valueMeterial_level = mapFromFieldMeterialLevel(instance.getMeterialLevel());
            ret.put(ModelBMaterial.FI_METERIAL_LEVEL.getBytes(), valueMeterial_level);
            byte[] valueMeterial_specification = mapFromFieldMeterialSpecification(instance.getMeterialSpecification());
            ret.put(ModelBMaterial.FI_METERIAL_SPECIFICATION.getBytes(), valueMeterial_specification);
            byte[] valueMeterial_style = mapFromFieldMeterialStyle(instance.getMeterialStyle());
            ret.put(ModelBMaterial.FI_METERIAL_STYLE.getBytes(), valueMeterial_style);
            byte[] valueMeterial_description = mapFromFieldMeterialDescription(instance.getMeterialDescription());
            ret.put(ModelBMaterial.FI_METERIAL_DESCRIPTION.getBytes(), valueMeterial_description);
            byte[] valueMeterial_feature = mapFromFieldMeterialFeature(instance.getMeterialFeature());
            ret.put(ModelBMaterial.FI_METERIAL_FEATURE.getBytes(), valueMeterial_feature);
            byte[] valueMaterial_price_para = mapFromFieldMaterialPricePara(instance.getMaterialPricePara());
            ret.put(ModelBMaterial.FI_MATERIAL_PRICE_PARA.getBytes(), valueMaterial_price_para);
            byte[] valueMeterial_creator = mapFromFieldMeterialCreator(instance.getMeterialCreator());
            ret.put(ModelBMaterial.FI_METERIAL_CREATOR.getBytes(), valueMeterial_creator);
            byte[] valueMeterial_create_time = mapFromFieldMeterialCreateTime(instance.getMeterialCreateTime());
            ret.put(ModelBMaterial.FI_METERIAL_CREATE_TIME.getBytes(), valueMeterial_create_time);
            byte[] valueMeterial_update_time = mapFromFieldMeterialUpdateTime(instance.getMeterialUpdateTime());
            ret.put(ModelBMaterial.FI_METERIAL_UPDATE_TIME.getBytes(), valueMeterial_update_time);
            byte[] valueMeterial_modify_by = mapFromFieldMeterialModifyBy(instance.getMeterialModifyBy());
            ret.put(ModelBMaterial.FI_METERIAL_MODIFY_BY.getBytes(), valueMeterial_modify_by);
            byte[] valueMaterial_type = mapFromFieldMaterialType(instance.getMaterialType());
            ret.put(ModelBMaterial.FI_MATERIAL_TYPE.getBytes(), valueMaterial_type);
            byte[] valueMain_measure_unit = mapFromFieldMainMeasureUnit(instance.getMainMeasureUnit());
            ret.put(ModelBMaterial.FI_MAIN_MEASURE_UNIT.getBytes(), valueMain_measure_unit);
            byte[] valueMaterial_delete_flag = mapFromFieldMaterialDeleteFlag(instance.getMaterialDeleteFlag());
            ret.put(ModelBMaterial.FI_MATERIAL_DELETE_FLAG.getBytes(), valueMaterial_delete_flag);
            byte[] valueMaterial_status = mapFromFieldMaterialStatus(instance.getMaterialStatus());
            ret.put(ModelBMaterial.FI_MATERIAL_STATUS.getBytes(), valueMaterial_status);
            byte[] valueMain_measure_unit_name = mapFromFieldMainMeasureUnitName(instance.getMainMeasureUnitName());
            ret.put(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME.getBytes(), valueMain_measure_unit_name);
            byte[] valueMaterial_weight = mapFromFieldMaterialWeight(instance.getMaterialWeight());
            ret.put(ModelBMaterial.FI_MATERIAL_WEIGHT.getBytes(), valueMaterial_weight);
            byte[] valueMaterial_drawing_no = mapFromFieldMaterialDrawingNo(instance.getMaterialDrawingNo());
            ret.put(ModelBMaterial.FI_MATERIAL_DRAWING_NO.getBytes(), valueMaterial_drawing_no);
            byte[] valueMaterial_color = mapFromFieldMaterialColor(instance.getMaterialColor());
            ret.put(ModelBMaterial.FI_MATERIAL_COLOR.getBytes(), valueMaterial_color);
            byte[] valueMaterial_area = mapFromFieldMaterialArea(instance.getMaterialArea());
            ret.put(ModelBMaterial.FI_MATERIAL_AREA.getBytes(), valueMaterial_area);
            byte[] valueMaterial_price = mapFromFieldMaterialPrice(instance.getMaterialPrice());
            ret.put(ModelBMaterial.FI_MATERIAL_PRICE.getBytes(), valueMaterial_price);
            byte[] valueMaterial_width = mapFromFieldMaterialWidth(instance.getMaterialWidth());
            ret.put(ModelBMaterial.FI_MATERIAL_WIDTH.getBytes(), valueMaterial_width);
            byte[] valueMaterial_height = mapFromFieldMaterialHeight(instance.getMaterialHeight());
            ret.put(ModelBMaterial.FI_MATERIAL_HEIGHT.getBytes(), valueMaterial_height);
            byte[] valueMaterial_length = mapFromFieldMaterialLength(instance.getMaterialLength());
            ret.put(ModelBMaterial.FI_MATERIAL_LENGTH.getBytes(), valueMaterial_length);
            byte[] valueMaterial_volumn = mapFromFieldMaterialVolumn(instance.getMaterialVolumn());
            ret.put(ModelBMaterial.FI_MATERIAL_VOLUMN.getBytes(), valueMaterial_volumn);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialCode(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialProductType(EnumMaterialProductType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldMeterialCost(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialBrand(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialLevel(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialSpecification(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialStyle(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialDescription(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialFeature(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialPricePara(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialCreator(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialUpdateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMeterialModifyBy(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialType(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMainMeasureUnit(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialStatus(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMainMeasureUnitName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialWeight(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialDrawingNo(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialColor(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialArea(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialPrice(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialWidth(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialHeight(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialLength(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialVolumn(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelBMaterial instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelBMaterial.FI_ID, dId);
            }
            String dMaterial_name = instance.getMaterialName();
            if (dMaterial_name!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_NAME, dMaterial_name);
            }
            String dMaterial_code = instance.getMaterialCode();
            if (dMaterial_code!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_CODE, dMaterial_code);
            }
            EnumMaterialProductType dMeterial_product_type = instance.getMeterialProductType();
            if (dMeterial_product_type!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE, dMeterial_product_type.val);
            }
            Byte dMeterial_cost = instance.getMeterialCost();
            if (dMeterial_cost!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_COST, dMeterial_cost);
            }
            String dMeterial_name = instance.getMeterialName();
            if (dMeterial_name!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_NAME, dMeterial_name);
            }
            String dMeterial_brand = instance.getMeterialBrand();
            if (dMeterial_brand!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_BRAND, dMeterial_brand);
            }
            Integer dMeterial_level = instance.getMeterialLevel();
            if (dMeterial_level!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_LEVEL, dMeterial_level);
            }
            String dMeterial_specification = instance.getMeterialSpecification();
            if (dMeterial_specification!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_SPECIFICATION, dMeterial_specification);
            }
            String dMeterial_style = instance.getMeterialStyle();
            if (dMeterial_style!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_STYLE, dMeterial_style);
            }
            String dMeterial_description = instance.getMeterialDescription();
            if (dMeterial_description!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_DESCRIPTION, dMeterial_description);
            }
            String dMeterial_feature = instance.getMeterialFeature();
            if (dMeterial_feature!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_FEATURE, dMeterial_feature);
            }
            Integer dMaterial_price_para = instance.getMaterialPricePara();
            if (dMaterial_price_para!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_PRICE_PARA, dMaterial_price_para);
            }
            Integer dMeterial_creator = instance.getMeterialCreator();
            if (dMeterial_creator!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_CREATOR, dMeterial_creator);
            }
            Date dMeterial_create_time = instance.getMeterialCreateTime();
            if (dMeterial_create_time!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_CREATE_TIME, dMeterial_create_time);
            }
            Date dMeterial_update_time = instance.getMeterialUpdateTime();
            if (dMeterial_update_time!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_UPDATE_TIME, dMeterial_update_time);
            }
            Integer dMeterial_modify_by = instance.getMeterialModifyBy();
            if (dMeterial_modify_by!= null) {
                ret.put(ModelBMaterial.FI_METERIAL_MODIFY_BY, dMeterial_modify_by);
            }
            Integer dMaterial_type = instance.getMaterialType();
            if (dMaterial_type!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_TYPE, dMaterial_type);
            }
            Integer dMain_measure_unit = instance.getMainMeasureUnit();
            if (dMain_measure_unit!= null) {
                ret.put(ModelBMaterial.FI_MAIN_MEASURE_UNIT, dMain_measure_unit);
            }
            Byte dMaterial_delete_flag = instance.getMaterialDeleteFlag();
            if (dMaterial_delete_flag!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_DELETE_FLAG, dMaterial_delete_flag);
            }
            Byte dMaterial_status = instance.getMaterialStatus();
            if (dMaterial_status!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_STATUS, dMaterial_status);
            }
            String dMain_measure_unit_name = instance.getMainMeasureUnitName();
            if (dMain_measure_unit_name!= null) {
                ret.put(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME, dMain_measure_unit_name);
            }
            Long dMaterial_weight = instance.getMaterialWeight();
            if (dMaterial_weight!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_WEIGHT, dMaterial_weight);
            }
            String dMaterial_drawing_no = instance.getMaterialDrawingNo();
            if (dMaterial_drawing_no!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_DRAWING_NO, dMaterial_drawing_no);
            }
            String dMaterial_color = instance.getMaterialColor();
            if (dMaterial_color!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_COLOR, dMaterial_color);
            }
            Long dMaterial_area = instance.getMaterialArea();
            if (dMaterial_area!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_AREA, dMaterial_area);
            }
            Long dMaterial_price = instance.getMaterialPrice();
            if (dMaterial_price!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_PRICE, dMaterial_price);
            }
            Long dMaterial_width = instance.getMaterialWidth();
            if (dMaterial_width!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_WIDTH, dMaterial_width);
            }
            Long dMaterial_height = instance.getMaterialHeight();
            if (dMaterial_height!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_HEIGHT, dMaterial_height);
            }
            Long dMaterial_length = instance.getMaterialLength();
            if (dMaterial_length!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_LENGTH, dMaterial_length);
            }
            Long dMaterial_volumn = instance.getMaterialVolumn();
            if (dMaterial_volumn!= null) {
                ret.put(ModelBMaterial.FI_MATERIAL_VOLUMN, dMaterial_volumn);
            }
            return ret;
        }

        @Override
        public ModelBMaterial fromCommonMap(Map<String, Object> param) {
            ModelBMaterial ret = new ModelBMaterial();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelBMaterial.FI_ID);
            if (dId!= null) {
                this.setField(ModelBMaterial.FI_ID, ret, dId);
            }
            Object dMaterial_name = param.get(ModelBMaterial.FI_MATERIAL_NAME);
            if (dMaterial_name!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_NAME, ret, dMaterial_name);
            }
            Object dMaterial_code = param.get(ModelBMaterial.FI_MATERIAL_CODE);
            if (dMaterial_code!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_CODE, ret, dMaterial_code);
            }
            Object dMeterial_product_type = param.get(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
            if (dMeterial_product_type!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE, ret, dMeterial_product_type);
            }
            Object dMeterial_cost = param.get(ModelBMaterial.FI_METERIAL_COST);
            if (dMeterial_cost!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_COST, ret, dMeterial_cost);
            }
            Object dMeterial_name = param.get(ModelBMaterial.FI_METERIAL_NAME);
            if (dMeterial_name!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_NAME, ret, dMeterial_name);
            }
            Object dMeterial_brand = param.get(ModelBMaterial.FI_METERIAL_BRAND);
            if (dMeterial_brand!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_BRAND, ret, dMeterial_brand);
            }
            Object dMeterial_level = param.get(ModelBMaterial.FI_METERIAL_LEVEL);
            if (dMeterial_level!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_LEVEL, ret, dMeterial_level);
            }
            Object dMeterial_specification = param.get(ModelBMaterial.FI_METERIAL_SPECIFICATION);
            if (dMeterial_specification!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_SPECIFICATION, ret, dMeterial_specification);
            }
            Object dMeterial_style = param.get(ModelBMaterial.FI_METERIAL_STYLE);
            if (dMeterial_style!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_STYLE, ret, dMeterial_style);
            }
            Object dMeterial_description = param.get(ModelBMaterial.FI_METERIAL_DESCRIPTION);
            if (dMeterial_description!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_DESCRIPTION, ret, dMeterial_description);
            }
            Object dMeterial_feature = param.get(ModelBMaterial.FI_METERIAL_FEATURE);
            if (dMeterial_feature!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_FEATURE, ret, dMeterial_feature);
            }
            Object dMaterial_price_para = param.get(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
            if (dMaterial_price_para!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_PRICE_PARA, ret, dMaterial_price_para);
            }
            Object dMeterial_creator = param.get(ModelBMaterial.FI_METERIAL_CREATOR);
            if (dMeterial_creator!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_CREATOR, ret, dMeterial_creator);
            }
            Object dMeterial_create_time = param.get(ModelBMaterial.FI_METERIAL_CREATE_TIME);
            if (dMeterial_create_time!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_CREATE_TIME, ret, dMeterial_create_time);
            }
            Object dMeterial_update_time = param.get(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
            if (dMeterial_update_time!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_UPDATE_TIME, ret, dMeterial_update_time);
            }
            Object dMeterial_modify_by = param.get(ModelBMaterial.FI_METERIAL_MODIFY_BY);
            if (dMeterial_modify_by!= null) {
                this.setField(ModelBMaterial.FI_METERIAL_MODIFY_BY, ret, dMeterial_modify_by);
            }
            Object dMaterial_type = param.get(ModelBMaterial.FI_MATERIAL_TYPE);
            if (dMaterial_type!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_TYPE, ret, dMaterial_type);
            }
            Object dMain_measure_unit = param.get(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
            if (dMain_measure_unit!= null) {
                this.setField(ModelBMaterial.FI_MAIN_MEASURE_UNIT, ret, dMain_measure_unit);
            }
            Object dMaterial_delete_flag = param.get(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
            if (dMaterial_delete_flag!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_DELETE_FLAG, ret, dMaterial_delete_flag);
            }
            Object dMaterial_status = param.get(ModelBMaterial.FI_MATERIAL_STATUS);
            if (dMaterial_status!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_STATUS, ret, dMaterial_status);
            }
            Object dMain_measure_unit_name = param.get(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
            if (dMain_measure_unit_name!= null) {
                this.setField(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME, ret, dMain_measure_unit_name);
            }
            Object dMaterial_weight = param.get(ModelBMaterial.FI_MATERIAL_WEIGHT);
            if (dMaterial_weight!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_WEIGHT, ret, dMaterial_weight);
            }
            Object dMaterial_drawing_no = param.get(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
            if (dMaterial_drawing_no!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_DRAWING_NO, ret, dMaterial_drawing_no);
            }
            Object dMaterial_color = param.get(ModelBMaterial.FI_MATERIAL_COLOR);
            if (dMaterial_color!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_COLOR, ret, dMaterial_color);
            }
            Object dMaterial_area = param.get(ModelBMaterial.FI_MATERIAL_AREA);
            if (dMaterial_area!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_AREA, ret, dMaterial_area);
            }
            Object dMaterial_price = param.get(ModelBMaterial.FI_MATERIAL_PRICE);
            if (dMaterial_price!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_PRICE, ret, dMaterial_price);
            }
            Object dMaterial_width = param.get(ModelBMaterial.FI_MATERIAL_WIDTH);
            if (dMaterial_width!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_WIDTH, ret, dMaterial_width);
            }
            Object dMaterial_height = param.get(ModelBMaterial.FI_MATERIAL_HEIGHT);
            if (dMaterial_height!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_HEIGHT, ret, dMaterial_height);
            }
            Object dMaterial_length = param.get(ModelBMaterial.FI_MATERIAL_LENGTH);
            if (dMaterial_length!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_LENGTH, ret, dMaterial_length);
            }
            Object dMaterial_volumn = param.get(ModelBMaterial.FI_MATERIAL_VOLUMN);
            if (dMaterial_volumn!= null) {
                this.setField(ModelBMaterial.FI_MATERIAL_VOLUMN, ret, dMaterial_volumn);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMaterialName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMaterialCode(Object obj) {
            return ((String) obj);
        }

        protected EnumMaterialProductType mapToFieldMeterialProductType(Object obj) {
            return EnumMaterialProductType.fromValue(((Byte) obj));
        }

        protected Byte mapToFieldMeterialCost(Object obj) {
            return ((Byte) obj);
        }

        protected String mapToFieldMeterialName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMeterialBrand(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldMeterialLevel(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMeterialSpecification(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMeterialStyle(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMeterialDescription(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMeterialFeature(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldMaterialPricePara(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMeterialCreator(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldMeterialCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected Date mapToFieldMeterialUpdateTime(Object obj) {
            return ((Date) obj);
        }

        protected Integer mapToFieldMeterialModifyBy(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMaterialType(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMainMeasureUnit(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldMaterialDeleteFlag(Object obj) {
            return ((Byte) obj);
        }

        protected Byte mapToFieldMaterialStatus(Object obj) {
            return ((Byte) obj);
        }

        protected String mapToFieldMainMeasureUnitName(Object obj) {
            return ((String) obj);
        }

        protected Long mapToFieldMaterialWeight(Object obj) {
            return ((Long) obj);
        }

        protected String mapToFieldMaterialDrawingNo(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMaterialColor(Object obj) {
            return ((String) obj);
        }

        protected Long mapToFieldMaterialArea(Object obj) {
            return ((Long) obj);
        }

        protected Long mapToFieldMaterialPrice(Object obj) {
            return ((Long) obj);
        }

        protected Long mapToFieldMaterialWidth(Object obj) {
            return ((Long) obj);
        }

        protected Long mapToFieldMaterialHeight(Object obj) {
            return ((Long) obj);
        }

        protected Long mapToFieldMaterialLength(Object obj) {
            return ((Long) obj);
        }

        protected Long mapToFieldMaterialVolumn(Object obj) {
            return ((Long) obj);
        }

        public<TT> TT getField(String field, ModelBMaterial instance) {
            try {
                if (field.equals(ModelBMaterial.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelBMaterial.FI_MATERIAL_NAME)) {
                        return ((TT) instance.getMaterialName());
                    } else {
                        if (field.equals(ModelBMaterial.FI_MATERIAL_CODE)) {
                            return ((TT) instance.getMaterialCode());
                        } else {
                            if (field.equals(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
                                return ((TT) instance.getMeterialProductType());
                            } else {
                                if (field.equals(ModelBMaterial.FI_METERIAL_COST)) {
                                    return ((TT) instance.getMeterialCost());
                                } else {
                                    if (field.equals(ModelBMaterial.FI_METERIAL_NAME)) {
                                        return ((TT) instance.getMeterialName());
                                    } else {
                                        if (field.equals(ModelBMaterial.FI_METERIAL_BRAND)) {
                                            return ((TT) instance.getMeterialBrand());
                                        } else {
                                            if (field.equals(ModelBMaterial.FI_METERIAL_LEVEL)) {
                                                return ((TT) instance.getMeterialLevel());
                                            } else {
                                                if (field.equals(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
                                                    return ((TT) instance.getMeterialSpecification());
                                                } else {
                                                    if (field.equals(ModelBMaterial.FI_METERIAL_STYLE)) {
                                                        return ((TT) instance.getMeterialStyle());
                                                    } else {
                                                        if (field.equals(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
                                                            return ((TT) instance.getMeterialDescription());
                                                        } else {
                                                            if (field.equals(ModelBMaterial.FI_METERIAL_FEATURE)) {
                                                                return ((TT) instance.getMeterialFeature());
                                                            } else {
                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
                                                                    return ((TT) instance.getMaterialPricePara());
                                                                } else {
                                                                    if (field.equals(ModelBMaterial.FI_METERIAL_CREATOR)) {
                                                                        return ((TT) instance.getMeterialCreator());
                                                                    } else {
                                                                        if (field.equals(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
                                                                            return ((TT) instance.getMeterialCreateTime());
                                                                        } else {
                                                                            if (field.equals(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
                                                                                return ((TT) instance.getMeterialUpdateTime());
                                                                            } else {
                                                                                if (field.equals(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
                                                                                    return ((TT) instance.getMeterialModifyBy());
                                                                                } else {
                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_TYPE)) {
                                                                                        return ((TT) instance.getMaterialType());
                                                                                    } else {
                                                                                        if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
                                                                                            return ((TT) instance.getMainMeasureUnit());
                                                                                        } else {
                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
                                                                                                return ((TT) instance.getMaterialDeleteFlag());
                                                                                            } else {
                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_STATUS)) {
                                                                                                    return ((TT) instance.getMaterialStatus());
                                                                                                } else {
                                                                                                    if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
                                                                                                        return ((TT) instance.getMainMeasureUnitName());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
                                                                                                            return ((TT) instance.getMaterialWeight());
                                                                                                        } else {
                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
                                                                                                                return ((TT) instance.getMaterialDrawingNo());
                                                                                                            } else {
                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_COLOR)) {
                                                                                                                    return ((TT) instance.getMaterialColor());
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_AREA)) {
                                                                                                                        return ((TT) instance.getMaterialArea());
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE)) {
                                                                                                                            return ((TT) instance.getMaterialPrice());
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_WIDTH)) {
                                                                                                                                return ((TT) instance.getMaterialWidth());
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
                                                                                                                                    return ((TT) instance.getMaterialHeight());
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_LENGTH)) {
                                                                                                                                        return ((TT) instance.getMaterialLength());
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
                                                                                                                                            return ((TT) instance.getMaterialVolumn());
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

        public<TT> void setField(String field, ModelBMaterial instance, TT value) {
            if (field.equals(ModelBMaterial.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelBMaterial.FI_MATERIAL_NAME)) {
                    try {
                        instance.setMaterialName(mapToFieldMaterialName(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelBMaterial.FI_MATERIAL_CODE)) {
                        try {
                            instance.setMaterialCode(mapToFieldMaterialCode(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
                            try {
                                instance.setMeterialProductType(mapToFieldMeterialProductType(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelBMaterial.FI_METERIAL_COST)) {
                                try {
                                    instance.setMeterialCost(mapToFieldMeterialCost(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelBMaterial.FI_METERIAL_NAME)) {
                                    try {
                                        instance.setMeterialName(mapToFieldMeterialName(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelBMaterial.FI_METERIAL_BRAND)) {
                                        try {
                                            instance.setMeterialBrand(mapToFieldMeterialBrand(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelBMaterial.FI_METERIAL_LEVEL)) {
                                            try {
                                                instance.setMeterialLevel(mapToFieldMeterialLevel(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
                                                try {
                                                    instance.setMeterialSpecification(mapToFieldMeterialSpecification(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelBMaterial.FI_METERIAL_STYLE)) {
                                                    try {
                                                        instance.setMeterialStyle(mapToFieldMeterialStyle(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
                                                        try {
                                                            instance.setMeterialDescription(mapToFieldMeterialDescription(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelBMaterial.FI_METERIAL_FEATURE)) {
                                                            try {
                                                                instance.setMeterialFeature(mapToFieldMeterialFeature(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
                                                                try {
                                                                    instance.setMaterialPricePara(mapToFieldMaterialPricePara(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelBMaterial.FI_METERIAL_CREATOR)) {
                                                                    try {
                                                                        instance.setMeterialCreator(mapToFieldMeterialCreator(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
                                                                        try {
                                                                            instance.setMeterialCreateTime(mapToFieldMeterialCreateTime(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
                                                                            try {
                                                                                instance.setMeterialUpdateTime(mapToFieldMeterialUpdateTime(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
                                                                                try {
                                                                                    instance.setMeterialModifyBy(mapToFieldMeterialModifyBy(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_TYPE)) {
                                                                                    try {
                                                                                        instance.setMaterialType(mapToFieldMaterialType(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
                                                                                        try {
                                                                                            instance.setMainMeasureUnit(mapToFieldMainMeasureUnit(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
                                                                                            try {
                                                                                                instance.setMaterialDeleteFlag(mapToFieldMaterialDeleteFlag(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_STATUS)) {
                                                                                                try {
                                                                                                    instance.setMaterialStatus(mapToFieldMaterialStatus(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
                                                                                                    try {
                                                                                                        instance.setMainMeasureUnitName(mapToFieldMainMeasureUnitName(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
                                                                                                        try {
                                                                                                            instance.setMaterialWeight(mapToFieldMaterialWeight(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
                                                                                                            try {
                                                                                                                instance.setMaterialDrawingNo(mapToFieldMaterialDrawingNo(value));
                                                                                                            } catch (final Exception ex) {
                                                                                                                ex.printStackTrace();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_COLOR)) {
                                                                                                                try {
                                                                                                                    instance.setMaterialColor(mapToFieldMaterialColor(value));
                                                                                                                } catch (final Exception ex) {
                                                                                                                    ex.printStackTrace();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_AREA)) {
                                                                                                                    try {
                                                                                                                        instance.setMaterialArea(mapToFieldMaterialArea(value));
                                                                                                                    } catch (final Exception ex) {
                                                                                                                        ex.printStackTrace();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE)) {
                                                                                                                        try {
                                                                                                                            instance.setMaterialPrice(mapToFieldMaterialPrice(value));
                                                                                                                        } catch (final Exception ex) {
                                                                                                                            ex.printStackTrace();
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_WIDTH)) {
                                                                                                                            try {
                                                                                                                                instance.setMaterialWidth(mapToFieldMaterialWidth(value));
                                                                                                                            } catch (final Exception ex) {
                                                                                                                                ex.printStackTrace();
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
                                                                                                                                try {
                                                                                                                                    instance.setMaterialHeight(mapToFieldMaterialHeight(value));
                                                                                                                                } catch (final Exception ex) {
                                                                                                                                    ex.printStackTrace();
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_LENGTH)) {
                                                                                                                                    try {
                                                                                                                                        instance.setMaterialLength(mapToFieldMaterialLength(value));
                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                        ex.printStackTrace();
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
                                                                                                                                        try {
                                                                                                                                            instance.setMaterialVolumn(mapToFieldMaterialVolumn(value));
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

        public void setField(String field, ModelBMaterial instance, byte[] value) {
            if (field.equals(ModelBMaterial.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelBMaterial.FI_MATERIAL_NAME)) {
                    instance.setMaterialName(mapToFieldMaterialName(value));
                } else {
                    if (field.equals(ModelBMaterial.FI_MATERIAL_CODE)) {
                        instance.setMaterialCode(mapToFieldMaterialCode(value));
                    } else {
                        if (field.equals(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
                            instance.setMeterialProductType(mapToFieldMeterialProductType(value));
                        } else {
                            if (field.equals(ModelBMaterial.FI_METERIAL_COST)) {
                                instance.setMeterialCost(mapToFieldMeterialCost(value));
                            } else {
                                if (field.equals(ModelBMaterial.FI_METERIAL_NAME)) {
                                    instance.setMeterialName(mapToFieldMeterialName(value));
                                } else {
                                    if (field.equals(ModelBMaterial.FI_METERIAL_BRAND)) {
                                        instance.setMeterialBrand(mapToFieldMeterialBrand(value));
                                    } else {
                                        if (field.equals(ModelBMaterial.FI_METERIAL_LEVEL)) {
                                            instance.setMeterialLevel(mapToFieldMeterialLevel(value));
                                        } else {
                                            if (field.equals(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
                                                instance.setMeterialSpecification(mapToFieldMeterialSpecification(value));
                                            } else {
                                                if (field.equals(ModelBMaterial.FI_METERIAL_STYLE)) {
                                                    instance.setMeterialStyle(mapToFieldMeterialStyle(value));
                                                } else {
                                                    if (field.equals(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
                                                        instance.setMeterialDescription(mapToFieldMeterialDescription(value));
                                                    } else {
                                                        if (field.equals(ModelBMaterial.FI_METERIAL_FEATURE)) {
                                                            instance.setMeterialFeature(mapToFieldMeterialFeature(value));
                                                        } else {
                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
                                                                instance.setMaterialPricePara(mapToFieldMaterialPricePara(value));
                                                            } else {
                                                                if (field.equals(ModelBMaterial.FI_METERIAL_CREATOR)) {
                                                                    instance.setMeterialCreator(mapToFieldMeterialCreator(value));
                                                                } else {
                                                                    if (field.equals(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
                                                                        instance.setMeterialCreateTime(mapToFieldMeterialCreateTime(value));
                                                                    } else {
                                                                        if (field.equals(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
                                                                            instance.setMeterialUpdateTime(mapToFieldMeterialUpdateTime(value));
                                                                        } else {
                                                                            if (field.equals(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
                                                                                instance.setMeterialModifyBy(mapToFieldMeterialModifyBy(value));
                                                                            } else {
                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_TYPE)) {
                                                                                    instance.setMaterialType(mapToFieldMaterialType(value));
                                                                                } else {
                                                                                    if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
                                                                                        instance.setMainMeasureUnit(mapToFieldMainMeasureUnit(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
                                                                                            instance.setMaterialDeleteFlag(mapToFieldMaterialDeleteFlag(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_STATUS)) {
                                                                                                instance.setMaterialStatus(mapToFieldMaterialStatus(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
                                                                                                    instance.setMainMeasureUnitName(mapToFieldMainMeasureUnitName(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
                                                                                                        instance.setMaterialWeight(mapToFieldMaterialWeight(value));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
                                                                                                            instance.setMaterialDrawingNo(mapToFieldMaterialDrawingNo(value));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_COLOR)) {
                                                                                                                instance.setMaterialColor(mapToFieldMaterialColor(value));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_AREA)) {
                                                                                                                    instance.setMaterialArea(mapToFieldMaterialArea(value));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_PRICE)) {
                                                                                                                        instance.setMaterialPrice(mapToFieldMaterialPrice(value));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelBMaterial.FI_MATERIAL_WIDTH)) {
                                                                                                                            instance.setMaterialWidth(mapToFieldMaterialWidth(value));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
                                                                                                                                instance.setMaterialHeight(mapToFieldMaterialHeight(value));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelBMaterial.FI_MATERIAL_LENGTH)) {
                                                                                                                                    instance.setMaterialLength(mapToFieldMaterialLength(value));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
                                                                                                                                        instance.setMaterialVolumn(mapToFieldMaterialVolumn(value));
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
