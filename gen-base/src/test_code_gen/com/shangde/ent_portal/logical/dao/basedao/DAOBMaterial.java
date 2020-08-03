package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
import com.shangde.ent_portal.logical.dto.enums.EnumMaterialProductType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.BaseMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLBuilder;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial;

@Repository("DAOBMaterial")
@SuppressWarnings("unchecked")
public class DAOBMaterial
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOBMaterial.class);

    public DAOBMaterial() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial.class, Constants.B_MATERIAL_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelBMaterial.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelBMaterial.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelBMaterial instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, dId);
        }
        String dMaterial_name = instance.getMaterialName();
        if (dMaterial_name!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_NAME, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_MATERIAL_NAME, dMaterial_name);
        }
        String dMaterial_code = instance.getMaterialCode();
        if (dMaterial_code!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_CODE, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_MATERIAL_CODE, dMaterial_code);
        }
        EnumMaterialProductType dMeterial_product_type = instance.getMeterialProductType();
        if (dMeterial_product_type!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE, ColumnDataType.byteData);
            param.put(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE, dMeterial_product_type.val);
        }
        Byte dMeterial_cost = instance.getMeterialCost();
        if (dMeterial_cost!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_COST, ColumnDataType.byteData);
            param.put(ModelBMaterial.FI_METERIAL_COST, dMeterial_cost);
        }
        String dMeterial_name = instance.getMeterialName();
        if (dMeterial_name!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_NAME, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_METERIAL_NAME, dMeterial_name);
        }
        String dMeterial_brand = instance.getMeterialBrand();
        if (dMeterial_brand!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_BRAND, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_METERIAL_BRAND, dMeterial_brand);
        }
        Integer dMeterial_level = instance.getMeterialLevel();
        if (dMeterial_level!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_LEVEL, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_METERIAL_LEVEL, dMeterial_level);
        }
        String dMeterial_specification = instance.getMeterialSpecification();
        if (dMeterial_specification!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_SPECIFICATION, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_METERIAL_SPECIFICATION, dMeterial_specification);
        }
        String dMeterial_style = instance.getMeterialStyle();
        if (dMeterial_style!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_STYLE, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_METERIAL_STYLE, dMeterial_style);
        }
        String dMeterial_description = instance.getMeterialDescription();
        if (dMeterial_description!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_DESCRIPTION, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_METERIAL_DESCRIPTION, dMeterial_description);
        }
        String dMeterial_feature = instance.getMeterialFeature();
        if (dMeterial_feature!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_FEATURE, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_METERIAL_FEATURE, dMeterial_feature);
        }
        Integer dMaterial_price_para = instance.getMaterialPricePara();
        if (dMaterial_price_para!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_PRICE_PARA, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_MATERIAL_PRICE_PARA, dMaterial_price_para);
        }
        Integer dMeterial_creator = instance.getMeterialCreator();
        if (dMeterial_creator!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_CREATOR, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_METERIAL_CREATOR, dMeterial_creator);
        }
        Date dMeterial_create_time = instance.getMeterialCreateTime();
        if (dMeterial_create_time!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelBMaterial.FI_METERIAL_CREATE_TIME, dMeterial_create_time);
        }
        Date dMeterial_update_time = instance.getMeterialUpdateTime();
        if (dMeterial_update_time!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelBMaterial.FI_METERIAL_UPDATE_TIME, dMeterial_update_time);
        }
        Integer dMeterial_modify_by = instance.getMeterialModifyBy();
        if (dMeterial_modify_by!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_MODIFY_BY, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_METERIAL_MODIFY_BY, dMeterial_modify_by);
        }
        Integer dMaterial_type = instance.getMaterialType();
        if (dMaterial_type!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_TYPE, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_MATERIAL_TYPE, dMaterial_type);
        }
        Integer dMain_measure_unit = instance.getMainMeasureUnit();
        if (dMain_measure_unit!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MAIN_MEASURE_UNIT, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_MAIN_MEASURE_UNIT, dMain_measure_unit);
        }
        Byte dMaterial_delete_flag = instance.getMaterialDeleteFlag();
        if (dMaterial_delete_flag!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelBMaterial.FI_MATERIAL_DELETE_FLAG, dMaterial_delete_flag);
        }
        Byte dMaterial_status = instance.getMaterialStatus();
        if (dMaterial_status!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_STATUS, ColumnDataType.byteData);
            param.put(ModelBMaterial.FI_MATERIAL_STATUS, dMaterial_status);
        }
        String dMain_measure_unit_name = instance.getMainMeasureUnitName();
        if (dMain_measure_unit_name!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME, dMain_measure_unit_name);
        }
        Long dMaterial_weight = instance.getMaterialWeight();
        if (dMaterial_weight!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_WEIGHT, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_WEIGHT, dMaterial_weight);
        }
        String dMaterial_drawing_no = instance.getMaterialDrawingNo();
        if (dMaterial_drawing_no!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_DRAWING_NO, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_MATERIAL_DRAWING_NO, dMaterial_drawing_no);
        }
        String dMaterial_color = instance.getMaterialColor();
        if (dMaterial_color!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_COLOR, ColumnDataType.stringData);
            param.put(ModelBMaterial.FI_MATERIAL_COLOR, dMaterial_color);
        }
        Long dMaterial_area = instance.getMaterialArea();
        if (dMaterial_area!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_AREA, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_AREA, dMaterial_area);
        }
        Long dMaterial_price = instance.getMaterialPrice();
        if (dMaterial_price!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_PRICE, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_PRICE, dMaterial_price);
        }
        Long dMaterial_width = instance.getMaterialWidth();
        if (dMaterial_width!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_WIDTH, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_WIDTH, dMaterial_width);
        }
        Long dMaterial_height = instance.getMaterialHeight();
        if (dMaterial_height!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_HEIGHT, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_HEIGHT, dMaterial_height);
        }
        Long dMaterial_length = instance.getMaterialLength();
        if (dMaterial_length!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_LENGTH, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_LENGTH, dMaterial_length);
        }
        Long dMaterial_volumn = instance.getMaterialVolumn();
        if (dMaterial_volumn!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_VOLUMN, ColumnDataType.longData);
            param.put(ModelBMaterial.FI_MATERIAL_VOLUMN, dMaterial_volumn);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelBMaterial.FI_ID)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_ID);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_NAME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_NAME);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_CODE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_CODE);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_COST)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_COST);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_NAME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_NAME);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_BRAND)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_BRAND);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_LEVEL)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_LEVEL);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_SPECIFICATION);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_STYLE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_STYLE);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_DESCRIPTION);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_FEATURE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_FEATURE);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_CREATOR)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATOR);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATE_TIME);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
        }
        if (selectFields.contains(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_MODIFY_BY);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_TYPE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_TYPE);
        }
        if (selectFields.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_STATUS)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_STATUS);
        }
        if (selectFields.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WEIGHT);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_COLOR)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_COLOR);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_AREA)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_AREA);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_PRICE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_WIDTH)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WIDTH);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_HEIGHT);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_LENGTH)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_LENGTH);
        }
        if (selectFields.contains(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_VOLUMN);
        }
    }

    public List<ModelBMaterial> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelBMaterial> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelBMaterial> get() {
        return get(null, null);
    }

    public List<ModelBMaterial> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMaterial.FI_ID, ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelBMaterial> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelBMaterial> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelBMaterial> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelBMaterial> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelBMaterial> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelBMaterial> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByCond(Set<String> selectFields, Integer start, Integer count, ModelBMaterial instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelBMaterial> getByCond(Integer start, Integer count, ModelBMaterial instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelBMaterial> getByCond(ModelBMaterial instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelBMaterial> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelBMaterial> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelBMaterial> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelBMaterial instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelBMaterial> getByCondAndIndex(Integer start, Integer count, ModelBMaterial instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelBMaterial> getByCondAndIndex(ModelBMaterial instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelBMaterial> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMaterial.FI_ID, ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMaterial.FI_ID, ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBMaterial instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIdAndCondAndWhere(Integer start, Integer count, ModelBMaterial instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIdAndCondAndWhere(ModelBMaterial instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMaterial> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndWhere(Integer start, Integer count, ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndWhere(ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMaterial> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBMaterial instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndIndexAndWhere(Integer start, Integer count, ModelBMaterial instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMaterial> getByCondAndIndexAndWhere(ModelBMaterial instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelBMaterial getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMaterial getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelBMaterial getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelBMaterial getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelBMaterial instance) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMaterial getOneByCond(Set<String> selectFields, ModelBMaterial instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelBMaterial getOneByCond(ModelBMaterial instance) {
        return getOneByCond(null, instance);
    }

    public ModelBMaterial getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMaterial getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelBMaterial getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelBMaterial getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMaterial getOneByCondAndWhere(Set<String> selectFields, ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelBMaterial getOneByCondAndWhere(ModelBMaterial instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelBMaterial getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBMaterial instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMaterial getOneByIdAndCondAndWhere(Set<String> selectFields, ModelBMaterial instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelBMaterial getOneByIdAndCondAndWhere(ModelBMaterial instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelBMaterial instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCond(ModelBMaterial instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelBMaterial instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelBMaterial instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelBMaterial instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        sqlBuilder.rawSelectItem("count(*)", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndexAndWhere(ModelBMaterial instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelBMaterial instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelBMaterial instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelBMaterial instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelBMaterial instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMaterial.FI_ID, ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, id, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, id, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelBMaterial instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelBMaterial instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelBMaterial instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBMaterial instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        throwExceptionIf((tClass!= null));
        throwExceptionIf(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (id!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMaterial.FI_ID, ModelBMaterial.FI_ID, ColumnDataType.intData);
            param.put(ModelBMaterial.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelBMaterial instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelBMaterial instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelBMaterial insert(ModelBMaterial instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_ID);
        }
        String dMaterial_name = instance.getMaterialName();
        if (dMaterial_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_NAME);
        }
        String dMaterial_code = instance.getMaterialCode();
        if (dMaterial_code!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_CODE);
        }
        EnumMaterialProductType dMeterial_product_type = instance.getMeterialProductType();
        if (dMeterial_product_type!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
        }
        Byte dMeterial_cost = instance.getMeterialCost();
        if (dMeterial_cost!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_COST);
        }
        String dMeterial_name = instance.getMeterialName();
        if (dMeterial_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_NAME);
        }
        String dMeterial_brand = instance.getMeterialBrand();
        if (dMeterial_brand!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_BRAND);
        }
        Integer dMeterial_level = instance.getMeterialLevel();
        if (dMeterial_level!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_LEVEL);
        }
        String dMeterial_specification = instance.getMeterialSpecification();
        if (dMeterial_specification!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_SPECIFICATION);
        }
        String dMeterial_style = instance.getMeterialStyle();
        if (dMeterial_style!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_STYLE);
        }
        String dMeterial_description = instance.getMeterialDescription();
        if (dMeterial_description!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_DESCRIPTION);
        }
        String dMeterial_feature = instance.getMeterialFeature();
        if (dMeterial_feature!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_FEATURE);
        }
        Integer dMaterial_price_para = instance.getMaterialPricePara();
        if (dMaterial_price_para!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
        }
        Integer dMeterial_creator = instance.getMeterialCreator();
        if (dMeterial_creator!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATOR);
        }
        Date dMeterial_create_time = instance.getMeterialCreateTime();
        if (dMeterial_create_time!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATE_TIME);
        }
        Date dMeterial_update_time = instance.getMeterialUpdateTime();
        if (dMeterial_update_time!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
        }
        Integer dMeterial_modify_by = instance.getMeterialModifyBy();
        if (dMeterial_modify_by!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_MODIFY_BY);
        }
        Integer dMaterial_type = instance.getMaterialType();
        if (dMaterial_type!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_TYPE);
        }
        Integer dMain_measure_unit = instance.getMainMeasureUnit();
        if (dMain_measure_unit!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
        }
        Byte dMaterial_delete_flag = instance.getMaterialDeleteFlag();
        if (dMaterial_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
        }
        Byte dMaterial_status = instance.getMaterialStatus();
        if (dMaterial_status!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_STATUS);
        }
        String dMain_measure_unit_name = instance.getMainMeasureUnitName();
        if (dMain_measure_unit_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
        }
        Long dMaterial_weight = instance.getMaterialWeight();
        if (dMaterial_weight!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WEIGHT);
        }
        String dMaterial_drawing_no = instance.getMaterialDrawingNo();
        if (dMaterial_drawing_no!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
        }
        String dMaterial_color = instance.getMaterialColor();
        if (dMaterial_color!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_COLOR);
        }
        Long dMaterial_area = instance.getMaterialArea();
        if (dMaterial_area!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_AREA);
        }
        Long dMaterial_price = instance.getMaterialPrice();
        if (dMaterial_price!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE);
        }
        Long dMaterial_width = instance.getMaterialWidth();
        if (dMaterial_width!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WIDTH);
        }
        Long dMaterial_height = instance.getMaterialHeight();
        if (dMaterial_height!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_HEIGHT);
        }
        Long dMaterial_length = instance.getMaterialLength();
        if (dMaterial_length!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_LENGTH);
        }
        Long dMaterial_volumn = instance.getMaterialVolumn();
        if (dMaterial_volumn!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_VOLUMN);
        }
        Map<String, Object> param = Constants.B_MATERIAL_MAP_OBJ_MAPPER.toCommonMap(instance);
        Long ret = super.insert(assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelBMaterial insert(ModelBMaterial instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelBMaterial> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelBMaterial.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        if (fields.contains(ModelBMaterial.FI_ID)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_ID);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_NAME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_NAME);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_CODE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_CODE);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_COST)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_COST);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_NAME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_NAME);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_BRAND)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_BRAND);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_LEVEL)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_LEVEL);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_SPECIFICATION);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_STYLE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_STYLE);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_DESCRIPTION);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_FEATURE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_FEATURE);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_CREATOR)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATOR);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATE_TIME);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
        }
        if (fields.contains(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_MODIFY_BY);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_TYPE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_TYPE);
        }
        if (fields.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_STATUS)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_STATUS);
        }
        if (fields.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WEIGHT);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_COLOR)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_COLOR);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_AREA)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_AREA);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_PRICE)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_WIDTH)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WIDTH);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_HEIGHT);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_LENGTH)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_LENGTH);
        }
        if (fields.contains(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_VOLUMN);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelBMaterial instance: instances) {
            Map<String, Object> paramMap = Constants.B_MATERIAL_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelBMaterial> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelBMaterial> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelBMaterial instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelBMaterial.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_ID);
            }
        }
        String dMaterial_name = instance.getMaterialName();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_NAME)) {
            throwExceptionIf((dMaterial_name!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_NAME, ColumnDataType.stringData);
        } else {
            if (dMaterial_name!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_NAME);
            }
        }
        String dMaterial_code = instance.getMaterialCode();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_CODE)) {
            throwExceptionIf((dMaterial_code!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_CODE, ColumnDataType.stringData);
        } else {
            if (dMaterial_code!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_CODE);
            }
        }
        EnumMaterialProductType dMeterial_product_type = instance.getMeterialProductType();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
            throwExceptionIf((dMeterial_product_type!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE, ColumnDataType.byteData);
        } else {
            if (dMeterial_product_type!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
            }
        }
        Byte dMeterial_cost = instance.getMeterialCost();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_COST)) {
            throwExceptionIf((dMeterial_cost!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_COST, ColumnDataType.byteData);
        } else {
            if (dMeterial_cost!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_COST);
            }
        }
        String dMeterial_name = instance.getMeterialName();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_NAME)) {
            throwExceptionIf((dMeterial_name!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_NAME, ColumnDataType.stringData);
        } else {
            if (dMeterial_name!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_NAME);
            }
        }
        String dMeterial_brand = instance.getMeterialBrand();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_BRAND)) {
            throwExceptionIf((dMeterial_brand!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_BRAND, ColumnDataType.stringData);
        } else {
            if (dMeterial_brand!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_BRAND);
            }
        }
        Integer dMeterial_level = instance.getMeterialLevel();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_LEVEL)) {
            throwExceptionIf((dMeterial_level!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_LEVEL, ColumnDataType.intData);
        } else {
            if (dMeterial_level!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_LEVEL);
            }
        }
        String dMeterial_specification = instance.getMeterialSpecification();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
            throwExceptionIf((dMeterial_specification!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_SPECIFICATION, ColumnDataType.stringData);
        } else {
            if (dMeterial_specification!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_SPECIFICATION);
            }
        }
        String dMeterial_style = instance.getMeterialStyle();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_STYLE)) {
            throwExceptionIf((dMeterial_style!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_STYLE, ColumnDataType.stringData);
        } else {
            if (dMeterial_style!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_STYLE);
            }
        }
        String dMeterial_description = instance.getMeterialDescription();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
            throwExceptionIf((dMeterial_description!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_DESCRIPTION, ColumnDataType.stringData);
        } else {
            if (dMeterial_description!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_DESCRIPTION);
            }
        }
        String dMeterial_feature = instance.getMeterialFeature();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_FEATURE)) {
            throwExceptionIf((dMeterial_feature!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_FEATURE, ColumnDataType.stringData);
        } else {
            if (dMeterial_feature!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_FEATURE);
            }
        }
        Integer dMaterial_price_para = instance.getMaterialPricePara();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
            throwExceptionIf((dMaterial_price_para!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_PRICE_PARA, ColumnDataType.intData);
        } else {
            if (dMaterial_price_para!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
            }
        }
        Integer dMeterial_creator = instance.getMeterialCreator();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_CREATOR)) {
            throwExceptionIf((dMeterial_creator!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_CREATOR, ColumnDataType.intData);
        } else {
            if (dMeterial_creator!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATOR);
            }
        }
        Date dMeterial_create_time = instance.getMeterialCreateTime();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
            throwExceptionIf((dMeterial_create_time!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dMeterial_create_time!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATE_TIME);
            }
        }
        Date dMeterial_update_time = instance.getMeterialUpdateTime();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
            throwExceptionIf((dMeterial_update_time!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dMeterial_update_time!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
            }
        }
        Integer dMeterial_modify_by = instance.getMeterialModifyBy();
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
            throwExceptionIf((dMeterial_modify_by!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_METERIAL_MODIFY_BY, ColumnDataType.intData);
        } else {
            if (dMeterial_modify_by!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_MODIFY_BY);
            }
        }
        Integer dMaterial_type = instance.getMaterialType();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_TYPE)) {
            throwExceptionIf((dMaterial_type!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_TYPE, ColumnDataType.intData);
        } else {
            if (dMaterial_type!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_TYPE);
            }
        }
        Integer dMain_measure_unit = instance.getMainMeasureUnit();
        if (conditionField.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
            throwExceptionIf((dMain_measure_unit!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MAIN_MEASURE_UNIT, ColumnDataType.intData);
        } else {
            if (dMain_measure_unit!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
            }
        }
        Byte dMaterial_delete_flag = instance.getMaterialDeleteFlag();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
            throwExceptionIf((dMaterial_delete_flag!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dMaterial_delete_flag!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
            }
        }
        Byte dMaterial_status = instance.getMaterialStatus();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_STATUS)) {
            throwExceptionIf((dMaterial_status!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_STATUS, ColumnDataType.byteData);
        } else {
            if (dMaterial_status!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_STATUS);
            }
        }
        String dMain_measure_unit_name = instance.getMainMeasureUnitName();
        if (conditionField.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
            throwExceptionIf((dMain_measure_unit_name!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME, ColumnDataType.stringData);
        } else {
            if (dMain_measure_unit_name!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
            }
        }
        Long dMaterial_weight = instance.getMaterialWeight();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
            throwExceptionIf((dMaterial_weight!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_WEIGHT, ColumnDataType.longData);
        } else {
            if (dMaterial_weight!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WEIGHT);
            }
        }
        String dMaterial_drawing_no = instance.getMaterialDrawingNo();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
            throwExceptionIf((dMaterial_drawing_no!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_DRAWING_NO, ColumnDataType.stringData);
        } else {
            if (dMaterial_drawing_no!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
            }
        }
        String dMaterial_color = instance.getMaterialColor();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_COLOR)) {
            throwExceptionIf((dMaterial_color!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_COLOR, ColumnDataType.stringData);
        } else {
            if (dMaterial_color!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_COLOR);
            }
        }
        Long dMaterial_area = instance.getMaterialArea();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_AREA)) {
            throwExceptionIf((dMaterial_area!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_AREA, ColumnDataType.longData);
        } else {
            if (dMaterial_area!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_AREA);
            }
        }
        Long dMaterial_price = instance.getMaterialPrice();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_PRICE)) {
            throwExceptionIf((dMaterial_price!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_PRICE, ColumnDataType.longData);
        } else {
            if (dMaterial_price!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE);
            }
        }
        Long dMaterial_width = instance.getMaterialWidth();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_WIDTH)) {
            throwExceptionIf((dMaterial_width!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_WIDTH, ColumnDataType.longData);
        } else {
            if (dMaterial_width!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WIDTH);
            }
        }
        Long dMaterial_height = instance.getMaterialHeight();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
            throwExceptionIf((dMaterial_height!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_HEIGHT, ColumnDataType.longData);
        } else {
            if (dMaterial_height!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_HEIGHT);
            }
        }
        Long dMaterial_length = instance.getMaterialLength();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_LENGTH)) {
            throwExceptionIf((dMaterial_length!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_LENGTH, ColumnDataType.longData);
        } else {
            if (dMaterial_length!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_LENGTH);
            }
        }
        Long dMaterial_volumn = instance.getMaterialVolumn();
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
            throwExceptionIf((dMaterial_volumn!= null));
            sqlBuilder.itemWhere(ModelBMaterial.FI_MATERIAL_VOLUMN, ColumnDataType.longData);
        } else {
            if (dMaterial_volumn!= null) {
                sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_VOLUMN);
            }
        }
        Map<String, Object> param = Constants.B_MATERIAL_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelBMaterial instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelBMaterial instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_ID);
        }
        String dMaterial_name = instance.getMaterialName();
        if (dMaterial_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_NAME);
        }
        String dMaterial_code = instance.getMaterialCode();
        if (dMaterial_code!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_CODE);
        }
        EnumMaterialProductType dMeterial_product_type = instance.getMeterialProductType();
        if (dMeterial_product_type!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
        }
        Byte dMeterial_cost = instance.getMeterialCost();
        if (dMeterial_cost!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_COST);
        }
        String dMeterial_name = instance.getMeterialName();
        if (dMeterial_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_NAME);
        }
        String dMeterial_brand = instance.getMeterialBrand();
        if (dMeterial_brand!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_BRAND);
        }
        Integer dMeterial_level = instance.getMeterialLevel();
        if (dMeterial_level!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_LEVEL);
        }
        String dMeterial_specification = instance.getMeterialSpecification();
        if (dMeterial_specification!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_SPECIFICATION);
        }
        String dMeterial_style = instance.getMeterialStyle();
        if (dMeterial_style!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_STYLE);
        }
        String dMeterial_description = instance.getMeterialDescription();
        if (dMeterial_description!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_DESCRIPTION);
        }
        String dMeterial_feature = instance.getMeterialFeature();
        if (dMeterial_feature!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_FEATURE);
        }
        Integer dMaterial_price_para = instance.getMaterialPricePara();
        if (dMaterial_price_para!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
        }
        Integer dMeterial_creator = instance.getMeterialCreator();
        if (dMeterial_creator!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATOR);
        }
        Date dMeterial_create_time = instance.getMeterialCreateTime();
        if (dMeterial_create_time!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATE_TIME);
        }
        Date dMeterial_update_time = instance.getMeterialUpdateTime();
        if (dMeterial_update_time!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
        }
        Integer dMeterial_modify_by = instance.getMeterialModifyBy();
        if (dMeterial_modify_by!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_MODIFY_BY);
        }
        Integer dMaterial_type = instance.getMaterialType();
        if (dMaterial_type!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_TYPE);
        }
        Integer dMain_measure_unit = instance.getMainMeasureUnit();
        if (dMain_measure_unit!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
        }
        Byte dMaterial_delete_flag = instance.getMaterialDeleteFlag();
        if (dMaterial_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
        }
        Byte dMaterial_status = instance.getMaterialStatus();
        if (dMaterial_status!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_STATUS);
        }
        String dMain_measure_unit_name = instance.getMainMeasureUnitName();
        if (dMain_measure_unit_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
        }
        Long dMaterial_weight = instance.getMaterialWeight();
        if (dMaterial_weight!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WEIGHT);
        }
        String dMaterial_drawing_no = instance.getMaterialDrawingNo();
        if (dMaterial_drawing_no!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
        }
        String dMaterial_color = instance.getMaterialColor();
        if (dMaterial_color!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_COLOR);
        }
        Long dMaterial_area = instance.getMaterialArea();
        if (dMaterial_area!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_AREA);
        }
        Long dMaterial_price = instance.getMaterialPrice();
        if (dMaterial_price!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE);
        }
        Long dMaterial_width = instance.getMaterialWidth();
        if (dMaterial_width!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WIDTH);
        }
        Long dMaterial_height = instance.getMaterialHeight();
        if (dMaterial_height!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_HEIGHT);
        }
        Long dMaterial_length = instance.getMaterialLength();
        if (dMaterial_length!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_LENGTH);
        }
        Long dMaterial_volumn = instance.getMaterialVolumn();
        if (dMaterial_volumn!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_VOLUMN);
        }
        Map<String, Object> param;
        param = Constants.B_MATERIAL_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelBMaterial instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelBMaterial instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        String dMaterial_name = instance.getMaterialName();
        if (dMaterial_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_NAME);
        }
        String dMaterial_code = instance.getMaterialCode();
        if (dMaterial_code!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_CODE);
        }
        EnumMaterialProductType dMeterial_product_type = instance.getMeterialProductType();
        if (dMeterial_product_type!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE);
        }
        Byte dMeterial_cost = instance.getMeterialCost();
        if (dMeterial_cost!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_COST);
        }
        String dMeterial_name = instance.getMeterialName();
        if (dMeterial_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_NAME);
        }
        String dMeterial_brand = instance.getMeterialBrand();
        if (dMeterial_brand!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_BRAND);
        }
        Integer dMeterial_level = instance.getMeterialLevel();
        if (dMeterial_level!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_LEVEL);
        }
        String dMeterial_specification = instance.getMeterialSpecification();
        if (dMeterial_specification!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_SPECIFICATION);
        }
        String dMeterial_style = instance.getMeterialStyle();
        if (dMeterial_style!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_STYLE);
        }
        String dMeterial_description = instance.getMeterialDescription();
        if (dMeterial_description!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_DESCRIPTION);
        }
        String dMeterial_feature = instance.getMeterialFeature();
        if (dMeterial_feature!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_FEATURE);
        }
        Integer dMaterial_price_para = instance.getMaterialPricePara();
        if (dMaterial_price_para!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE_PARA);
        }
        Integer dMeterial_creator = instance.getMeterialCreator();
        if (dMeterial_creator!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATOR);
        }
        Date dMeterial_create_time = instance.getMeterialCreateTime();
        if (dMeterial_create_time!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_CREATE_TIME);
        }
        Date dMeterial_update_time = instance.getMeterialUpdateTime();
        if (dMeterial_update_time!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_UPDATE_TIME);
        }
        Integer dMeterial_modify_by = instance.getMeterialModifyBy();
        if (dMeterial_modify_by!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_METERIAL_MODIFY_BY);
        }
        Integer dMaterial_type = instance.getMaterialType();
        if (dMaterial_type!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_TYPE);
        }
        Integer dMain_measure_unit = instance.getMainMeasureUnit();
        if (dMain_measure_unit!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT);
        }
        Byte dMaterial_delete_flag = instance.getMaterialDeleteFlag();
        if (dMaterial_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DELETE_FLAG);
        }
        Byte dMaterial_status = instance.getMaterialStatus();
        if (dMaterial_status!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_STATUS);
        }
        String dMain_measure_unit_name = instance.getMainMeasureUnitName();
        if (dMain_measure_unit_name!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME);
        }
        Long dMaterial_weight = instance.getMaterialWeight();
        if (dMaterial_weight!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WEIGHT);
        }
        String dMaterial_drawing_no = instance.getMaterialDrawingNo();
        if (dMaterial_drawing_no!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_DRAWING_NO);
        }
        String dMaterial_color = instance.getMaterialColor();
        if (dMaterial_color!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_COLOR);
        }
        Long dMaterial_area = instance.getMaterialArea();
        if (dMaterial_area!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_AREA);
        }
        Long dMaterial_price = instance.getMaterialPrice();
        if (dMaterial_price!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_PRICE);
        }
        Long dMaterial_width = instance.getMaterialWidth();
        if (dMaterial_width!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_WIDTH);
        }
        Long dMaterial_height = instance.getMaterialHeight();
        if (dMaterial_height!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_HEIGHT);
        }
        Long dMaterial_length = instance.getMaterialLength();
        if (dMaterial_length!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_LENGTH);
        }
        Long dMaterial_volumn = instance.getMaterialVolumn();
        if (dMaterial_volumn!= null) {
            sqlBuilder.itemCol(ModelBMaterial.FI_MATERIAL_VOLUMN);
        }
        Map<String, Object> param;
        param = Constants.B_MATERIAL_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelBMaterial instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        throwExceptionIf((id!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Map<String, Object> param;
        param = Collections.singletonMap("__id", id);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelBMaterial.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Map<String, Object> param;
        param = Collections.singletonMap("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelBMaterial updateOrInsert(ModelBMaterial instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBMaterial checkInstance = new ModelBMaterial();
        if (conditionField.contains(ModelBMaterial.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_NAME)) {
            checkInstance.setMaterialName(instance.getMaterialName());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_CODE)) {
            checkInstance.setMaterialCode(instance.getMaterialCode());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
            checkInstance.setMeterialProductType(instance.getMeterialProductType());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_COST)) {
            checkInstance.setMeterialCost(instance.getMeterialCost());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_NAME)) {
            checkInstance.setMeterialName(instance.getMeterialName());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_BRAND)) {
            checkInstance.setMeterialBrand(instance.getMeterialBrand());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_LEVEL)) {
            checkInstance.setMeterialLevel(instance.getMeterialLevel());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
            checkInstance.setMeterialSpecification(instance.getMeterialSpecification());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_STYLE)) {
            checkInstance.setMeterialStyle(instance.getMeterialStyle());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
            checkInstance.setMeterialDescription(instance.getMeterialDescription());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_FEATURE)) {
            checkInstance.setMeterialFeature(instance.getMeterialFeature());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
            checkInstance.setMaterialPricePara(instance.getMaterialPricePara());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_CREATOR)) {
            checkInstance.setMeterialCreator(instance.getMeterialCreator());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
            checkInstance.setMeterialCreateTime(instance.getMeterialCreateTime());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
            checkInstance.setMeterialUpdateTime(instance.getMeterialUpdateTime());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
            checkInstance.setMeterialModifyBy(instance.getMeterialModifyBy());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_TYPE)) {
            checkInstance.setMaterialType(instance.getMaterialType());
        }
        if (conditionField.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
            checkInstance.setMainMeasureUnit(instance.getMainMeasureUnit());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
            checkInstance.setMaterialDeleteFlag(instance.getMaterialDeleteFlag());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_STATUS)) {
            checkInstance.setMaterialStatus(instance.getMaterialStatus());
        }
        if (conditionField.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
            checkInstance.setMainMeasureUnitName(instance.getMainMeasureUnitName());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
            checkInstance.setMaterialWeight(instance.getMaterialWeight());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
            checkInstance.setMaterialDrawingNo(instance.getMaterialDrawingNo());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_COLOR)) {
            checkInstance.setMaterialColor(instance.getMaterialColor());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_AREA)) {
            checkInstance.setMaterialArea(instance.getMaterialArea());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_PRICE)) {
            checkInstance.setMaterialPrice(instance.getMaterialPrice());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_WIDTH)) {
            checkInstance.setMaterialWidth(instance.getMaterialWidth());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
            checkInstance.setMaterialHeight(instance.getMaterialHeight());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_LENGTH)) {
            checkInstance.setMaterialLength(instance.getMaterialLength());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
            checkInstance.setMaterialVolumn(instance.getMaterialVolumn());
        }
        ModelBMaterial selected = getOneByCond(Collections.singleton(ModelBMaterial.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelBMaterial.FI_ID), assembler);
            return instance;
        }
    }

    public ModelBMaterial updateOrInsert(ModelBMaterial instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelBMaterial insertIfNoExist(ModelBMaterial instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBMaterial checkInstance = new ModelBMaterial();
        if (conditionField.contains(ModelBMaterial.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_NAME)) {
            checkInstance.setMaterialName(instance.getMaterialName());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_CODE)) {
            checkInstance.setMaterialCode(instance.getMaterialCode());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_PRODUCT_TYPE)) {
            checkInstance.setMeterialProductType(instance.getMeterialProductType());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_COST)) {
            checkInstance.setMeterialCost(instance.getMeterialCost());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_NAME)) {
            checkInstance.setMeterialName(instance.getMeterialName());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_BRAND)) {
            checkInstance.setMeterialBrand(instance.getMeterialBrand());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_LEVEL)) {
            checkInstance.setMeterialLevel(instance.getMeterialLevel());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_SPECIFICATION)) {
            checkInstance.setMeterialSpecification(instance.getMeterialSpecification());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_STYLE)) {
            checkInstance.setMeterialStyle(instance.getMeterialStyle());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_DESCRIPTION)) {
            checkInstance.setMeterialDescription(instance.getMeterialDescription());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_FEATURE)) {
            checkInstance.setMeterialFeature(instance.getMeterialFeature());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_PRICE_PARA)) {
            checkInstance.setMaterialPricePara(instance.getMaterialPricePara());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_CREATOR)) {
            checkInstance.setMeterialCreator(instance.getMeterialCreator());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_CREATE_TIME)) {
            checkInstance.setMeterialCreateTime(instance.getMeterialCreateTime());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_UPDATE_TIME)) {
            checkInstance.setMeterialUpdateTime(instance.getMeterialUpdateTime());
        }
        if (conditionField.contains(ModelBMaterial.FI_METERIAL_MODIFY_BY)) {
            checkInstance.setMeterialModifyBy(instance.getMeterialModifyBy());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_TYPE)) {
            checkInstance.setMaterialType(instance.getMaterialType());
        }
        if (conditionField.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT)) {
            checkInstance.setMainMeasureUnit(instance.getMainMeasureUnit());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_DELETE_FLAG)) {
            checkInstance.setMaterialDeleteFlag(instance.getMaterialDeleteFlag());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_STATUS)) {
            checkInstance.setMaterialStatus(instance.getMaterialStatus());
        }
        if (conditionField.contains(ModelBMaterial.FI_MAIN_MEASURE_UNIT_NAME)) {
            checkInstance.setMainMeasureUnitName(instance.getMainMeasureUnitName());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_WEIGHT)) {
            checkInstance.setMaterialWeight(instance.getMaterialWeight());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_DRAWING_NO)) {
            checkInstance.setMaterialDrawingNo(instance.getMaterialDrawingNo());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_COLOR)) {
            checkInstance.setMaterialColor(instance.getMaterialColor());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_AREA)) {
            checkInstance.setMaterialArea(instance.getMaterialArea());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_PRICE)) {
            checkInstance.setMaterialPrice(instance.getMaterialPrice());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_WIDTH)) {
            checkInstance.setMaterialWidth(instance.getMaterialWidth());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_HEIGHT)) {
            checkInstance.setMaterialHeight(instance.getMaterialHeight());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_LENGTH)) {
            checkInstance.setMaterialLength(instance.getMaterialLength());
        }
        if (conditionField.contains(ModelBMaterial.FI_MATERIAL_VOLUMN)) {
            checkInstance.setMaterialVolumn(instance.getMaterialVolumn());
        }
        ModelBMaterial selected = getOneByCond(Collections.singleton(ModelBMaterial.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelBMaterial insertIfNoExist(ModelBMaterial instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelBMaterial> buildMap(List<ModelBMaterial> list, String field) {
        Map<TT, ModelBMaterial> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBMaterial item: list) {
            ret.put(Constants.B_MATERIAL_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelBMaterial>> buildListMap(List<ModelBMaterial> list, String field) {
        Map<TT, List<ModelBMaterial>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBMaterial item: list) {
            List<ModelBMaterial> itemList = ret.get(Constants.B_MATERIAL_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.B_MATERIAL_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelBMaterial> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelBMaterial.FIELD_CLASS.containsKey(field)) {
            for (ModelBMaterial item: list) {
                ret.add(Constants.B_MATERIAL_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
