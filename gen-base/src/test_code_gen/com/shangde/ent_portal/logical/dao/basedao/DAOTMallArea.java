package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
import com.shangde.ent_portal.logical.dto.enums.EnumAreaType;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea;

@Repository("DAOTMallArea")
@SuppressWarnings("unchecked")
public class DAOTMallArea
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTMallArea.class);

    public DAOTMallArea() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea.class, Constants.T_MALL_AREA_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTMallArea.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTMallArea.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelTMallArea instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, dId);
        }
        EnumAreaType dArea_type = instance.getAreaType();
        if (dArea_type!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_TYPE, ColumnDataType.byteData);
            param.put(ModelTMallArea.FI_AREA_TYPE, dArea_type.val);
        }
        String dArea_name = instance.getAreaName();
        if (dArea_name!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_NAME, ColumnDataType.stringData);
            param.put(ModelTMallArea.FI_AREA_NAME, dArea_name);
        }
        Integer dArea_arix_max_x = instance.getAreaArixMaxX();
        if (dArea_arix_max_x!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_MAX_X, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_ARIX_MAX_X, dArea_arix_max_x);
        }
        Integer dArea_arix_max_y = instance.getAreaArixMaxY();
        if (dArea_arix_max_y!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_MAX_Y, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_ARIX_MAX_Y, dArea_arix_max_y);
        }
        Integer dArea_arix_max_z = instance.getAreaArixMaxZ();
        if (dArea_arix_max_z!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_MAX_Z, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_ARIX_MAX_Z, dArea_arix_max_z);
        }
        Byte dArea_reachable = instance.getAreaReachable();
        if (dArea_reachable!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_REACHABLE, ColumnDataType.byteData);
            param.put(ModelTMallArea.FI_AREA_REACHABLE, dArea_reachable);
        }
        Integer dArea_capacity = instance.getAreaCapacity();
        if (dArea_capacity!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_CAPACITY, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_CAPACITY, dArea_capacity);
        }
        Integer dArea_arix_x_base = instance.getAreaArixXBase();
        if (dArea_arix_x_base!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_X_BASE, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_ARIX_X_BASE, dArea_arix_x_base);
        }
        Integer dArea_arix_y_base = instance.getAreaArixYBase();
        if (dArea_arix_y_base!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_Y_BASE, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_ARIX_Y_BASE, dArea_arix_y_base);
        }
        Integer dArea_arix_z_base = instance.getAreaArixZBase();
        if (dArea_arix_z_base!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_Z_BASE, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_ARIX_Z_BASE, dArea_arix_z_base);
        }
        Integer dArea_index = instance.getAreaIndex();
        if (dArea_index!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_INDEX, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_INDEX, dArea_index);
        }
        Integer dArea_path = instance.getAreaPath();
        if (dArea_path!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_PATH, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_AREA_PATH, dArea_path);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTMallArea.FI_ID)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_ID);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_TYPE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_TYPE);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_NAME)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_NAME);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_X);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_REACHABLE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_REACHABLE);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_CAPACITY)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_CAPACITY);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_X_BASE);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_INDEX)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_INDEX);
        }
        if (selectFields.contains(ModelTMallArea.FI_AREA_PATH)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_PATH);
        }
    }

    public List<ModelTMallArea> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTMallArea> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTMallArea> get() {
        return get(null, null);
    }

    public List<ModelTMallArea> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMallArea.FI_ID, ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTMallArea> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTMallArea> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTMallArea> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTMallArea> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTMallArea> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTMallArea> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTMallArea> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTMallArea instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTMallArea> getByCond(Integer start, Integer count, ModelTMallArea instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTMallArea> getByCond(ModelTMallArea instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTMallArea> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTMallArea> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTMallArea> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTMallArea instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTMallArea> getByCondAndIndex(Integer start, Integer count, ModelTMallArea instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTMallArea> getByCondAndIndex(ModelTMallArea instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTMallArea> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMallArea.FI_ID, ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTMallArea> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMallArea.FI_ID, ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTMallArea> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTMallArea instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIdAndCondAndWhere(Integer start, Integer count, ModelTMallArea instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIdAndCondAndWhere(ModelTMallArea instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMallArea> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndWhere(Integer start, Integer count, ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndWhere(ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public List<ModelTMallArea> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTMallArea instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTMallArea instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTMallArea> getByCondAndIndexAndWhere(ModelTMallArea instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTMallArea getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTMallArea getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTMallArea getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTMallArea getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTMallArea instance) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public ModelTMallArea getOneByCond(Set<String> selectFields, ModelTMallArea instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTMallArea getOneByCond(ModelTMallArea instance) {
        return getOneByCond(null, instance);
    }

    public ModelTMallArea getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public ModelTMallArea getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTMallArea getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTMallArea getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public ModelTMallArea getOneByCondAndWhere(Set<String> selectFields, ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTMallArea getOneByCondAndWhere(ModelTMallArea instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTMallArea getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTMallArea instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTMallArea getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTMallArea instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTMallArea getOneByIdAndCondAndWhere(ModelTMallArea instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTMallArea instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelTMallArea instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTMallArea instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelTMallArea instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTMallArea instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelTMallArea instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTMallArea instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelTMallArea instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTMallArea instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTMallArea instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMallArea.FI_ID, ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
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
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTMallArea instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTMallArea instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTMallArea instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTMallArea instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTMallArea.FI_ID, ModelTMallArea.FI_ID, ColumnDataType.intData);
            param.put(ModelTMallArea.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTMallArea instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTMallArea instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTMallArea insert(ModelTMallArea instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_ID);
        }
        EnumAreaType dArea_type = instance.getAreaType();
        if (dArea_type!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_TYPE);
        }
        String dArea_name = instance.getAreaName();
        if (dArea_name!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_NAME);
        }
        Integer dArea_arix_max_x = instance.getAreaArixMaxX();
        if (dArea_arix_max_x!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_X);
        }
        Integer dArea_arix_max_y = instance.getAreaArixMaxY();
        if (dArea_arix_max_y!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
        }
        Integer dArea_arix_max_z = instance.getAreaArixMaxZ();
        if (dArea_arix_max_z!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
        }
        Byte dArea_reachable = instance.getAreaReachable();
        if (dArea_reachable!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_REACHABLE);
        }
        Integer dArea_capacity = instance.getAreaCapacity();
        if (dArea_capacity!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_CAPACITY);
        }
        Integer dArea_arix_x_base = instance.getAreaArixXBase();
        if (dArea_arix_x_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_X_BASE);
        }
        Integer dArea_arix_y_base = instance.getAreaArixYBase();
        if (dArea_arix_y_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
        }
        Integer dArea_arix_z_base = instance.getAreaArixZBase();
        if (dArea_arix_z_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
        }
        Integer dArea_index = instance.getAreaIndex();
        if (dArea_index!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_INDEX);
        }
        Integer dArea_path = instance.getAreaPath();
        if (dArea_path!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_PATH);
        }
        Map<String, Object> param = Constants.T_MALL_AREA_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelTMallArea insert(ModelTMallArea instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTMallArea> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTMallArea.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        if (fields.contains(ModelTMallArea.FI_ID)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_ID);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_TYPE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_TYPE);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_NAME)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_NAME);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_X);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_REACHABLE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_REACHABLE);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_CAPACITY)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_CAPACITY);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_X_BASE);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_INDEX)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_INDEX);
        }
        if (fields.contains(ModelTMallArea.FI_AREA_PATH)) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_PATH);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTMallArea instance: instances) {
            Map<String, Object> paramMap = Constants.T_MALL_AREA_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTMallArea> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTMallArea> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTMallArea instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTMallArea.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_ID);
            }
        }
        EnumAreaType dArea_type = instance.getAreaType();
        if (conditionField.contains(ModelTMallArea.FI_AREA_TYPE)) {
            throwExceptionIf((dArea_type!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_TYPE, ColumnDataType.byteData);
        } else {
            if (dArea_type!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_TYPE);
            }
        }
        String dArea_name = instance.getAreaName();
        if (conditionField.contains(ModelTMallArea.FI_AREA_NAME)) {
            throwExceptionIf((dArea_name!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_NAME, ColumnDataType.stringData);
        } else {
            if (dArea_name!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_NAME);
            }
        }
        Integer dArea_arix_max_x = instance.getAreaArixMaxX();
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
            throwExceptionIf((dArea_arix_max_x!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_MAX_X, ColumnDataType.intData);
        } else {
            if (dArea_arix_max_x!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_X);
            }
        }
        Integer dArea_arix_max_y = instance.getAreaArixMaxY();
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
            throwExceptionIf((dArea_arix_max_y!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_MAX_Y, ColumnDataType.intData);
        } else {
            if (dArea_arix_max_y!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
            }
        }
        Integer dArea_arix_max_z = instance.getAreaArixMaxZ();
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
            throwExceptionIf((dArea_arix_max_z!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_MAX_Z, ColumnDataType.intData);
        } else {
            if (dArea_arix_max_z!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
            }
        }
        Byte dArea_reachable = instance.getAreaReachable();
        if (conditionField.contains(ModelTMallArea.FI_AREA_REACHABLE)) {
            throwExceptionIf((dArea_reachable!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_REACHABLE, ColumnDataType.byteData);
        } else {
            if (dArea_reachable!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_REACHABLE);
            }
        }
        Integer dArea_capacity = instance.getAreaCapacity();
        if (conditionField.contains(ModelTMallArea.FI_AREA_CAPACITY)) {
            throwExceptionIf((dArea_capacity!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_CAPACITY, ColumnDataType.intData);
        } else {
            if (dArea_capacity!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_CAPACITY);
            }
        }
        Integer dArea_arix_x_base = instance.getAreaArixXBase();
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
            throwExceptionIf((dArea_arix_x_base!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_X_BASE, ColumnDataType.intData);
        } else {
            if (dArea_arix_x_base!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_X_BASE);
            }
        }
        Integer dArea_arix_y_base = instance.getAreaArixYBase();
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
            throwExceptionIf((dArea_arix_y_base!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_Y_BASE, ColumnDataType.intData);
        } else {
            if (dArea_arix_y_base!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
            }
        }
        Integer dArea_arix_z_base = instance.getAreaArixZBase();
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
            throwExceptionIf((dArea_arix_z_base!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_ARIX_Z_BASE, ColumnDataType.intData);
        } else {
            if (dArea_arix_z_base!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
            }
        }
        Integer dArea_index = instance.getAreaIndex();
        if (conditionField.contains(ModelTMallArea.FI_AREA_INDEX)) {
            throwExceptionIf((dArea_index!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_INDEX, ColumnDataType.intData);
        } else {
            if (dArea_index!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_INDEX);
            }
        }
        Integer dArea_path = instance.getAreaPath();
        if (conditionField.contains(ModelTMallArea.FI_AREA_PATH)) {
            throwExceptionIf((dArea_path!= null));
            sqlBuilder.itemWhere(ModelTMallArea.FI_AREA_PATH, ColumnDataType.intData);
        } else {
            if (dArea_path!= null) {
                sqlBuilder.itemCol(ModelTMallArea.FI_AREA_PATH);
            }
        }
        Map<String, Object> param = Constants.T_MALL_AREA_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelTMallArea instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTMallArea instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_ID);
        }
        EnumAreaType dArea_type = instance.getAreaType();
        if (dArea_type!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_TYPE);
        }
        String dArea_name = instance.getAreaName();
        if (dArea_name!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_NAME);
        }
        Integer dArea_arix_max_x = instance.getAreaArixMaxX();
        if (dArea_arix_max_x!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_X);
        }
        Integer dArea_arix_max_y = instance.getAreaArixMaxY();
        if (dArea_arix_max_y!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
        }
        Integer dArea_arix_max_z = instance.getAreaArixMaxZ();
        if (dArea_arix_max_z!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
        }
        Byte dArea_reachable = instance.getAreaReachable();
        if (dArea_reachable!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_REACHABLE);
        }
        Integer dArea_capacity = instance.getAreaCapacity();
        if (dArea_capacity!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_CAPACITY);
        }
        Integer dArea_arix_x_base = instance.getAreaArixXBase();
        if (dArea_arix_x_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_X_BASE);
        }
        Integer dArea_arix_y_base = instance.getAreaArixYBase();
        if (dArea_arix_y_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
        }
        Integer dArea_arix_z_base = instance.getAreaArixZBase();
        if (dArea_arix_z_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
        }
        Integer dArea_index = instance.getAreaIndex();
        if (dArea_index!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_INDEX);
        }
        Integer dArea_path = instance.getAreaPath();
        if (dArea_path!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_PATH);
        }
        Map<String, Object> param;
        param = Constants.T_MALL_AREA_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTMallArea instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTMallArea instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        EnumAreaType dArea_type = instance.getAreaType();
        if (dArea_type!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_TYPE);
        }
        String dArea_name = instance.getAreaName();
        if (dArea_name!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_NAME);
        }
        Integer dArea_arix_max_x = instance.getAreaArixMaxX();
        if (dArea_arix_max_x!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_X);
        }
        Integer dArea_arix_max_y = instance.getAreaArixMaxY();
        if (dArea_arix_max_y!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
        }
        Integer dArea_arix_max_z = instance.getAreaArixMaxZ();
        if (dArea_arix_max_z!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
        }
        Byte dArea_reachable = instance.getAreaReachable();
        if (dArea_reachable!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_REACHABLE);
        }
        Integer dArea_capacity = instance.getAreaCapacity();
        if (dArea_capacity!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_CAPACITY);
        }
        Integer dArea_arix_x_base = instance.getAreaArixXBase();
        if (dArea_arix_x_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_X_BASE);
        }
        Integer dArea_arix_y_base = instance.getAreaArixYBase();
        if (dArea_arix_y_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
        }
        Integer dArea_arix_z_base = instance.getAreaArixZBase();
        if (dArea_arix_z_base!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
        }
        Integer dArea_index = instance.getAreaIndex();
        if (dArea_index!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_INDEX);
        }
        Integer dArea_path = instance.getAreaPath();
        if (dArea_path!= null) {
            sqlBuilder.itemCol(ModelTMallArea.FI_AREA_PATH);
        }
        Map<String, Object> param;
        param = Constants.T_MALL_AREA_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTMallArea instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelTMallArea.DTO_TABLE_NAME);
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
    public ModelTMallArea updateOrInsert(ModelTMallArea instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTMallArea checkInstance = new ModelTMallArea();
        if (conditionField.contains(ModelTMallArea.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_TYPE)) {
            checkInstance.setAreaType(instance.getAreaType());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_NAME)) {
            checkInstance.setAreaName(instance.getAreaName());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
            checkInstance.setAreaArixMaxX(instance.getAreaArixMaxX());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
            checkInstance.setAreaArixMaxY(instance.getAreaArixMaxY());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
            checkInstance.setAreaArixMaxZ(instance.getAreaArixMaxZ());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_REACHABLE)) {
            checkInstance.setAreaReachable(instance.getAreaReachable());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_CAPACITY)) {
            checkInstance.setAreaCapacity(instance.getAreaCapacity());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
            checkInstance.setAreaArixXBase(instance.getAreaArixXBase());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
            checkInstance.setAreaArixYBase(instance.getAreaArixYBase());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
            checkInstance.setAreaArixZBase(instance.getAreaArixZBase());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_INDEX)) {
            checkInstance.setAreaIndex(instance.getAreaIndex());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_PATH)) {
            checkInstance.setAreaPath(instance.getAreaPath());
        }
        ModelTMallArea selected = getOneByCond(Collections.singleton(ModelTMallArea.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTMallArea.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTMallArea updateOrInsert(ModelTMallArea instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTMallArea insertIfNoExist(ModelTMallArea instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTMallArea checkInstance = new ModelTMallArea();
        if (conditionField.contains(ModelTMallArea.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_TYPE)) {
            checkInstance.setAreaType(instance.getAreaType());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_NAME)) {
            checkInstance.setAreaName(instance.getAreaName());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
            checkInstance.setAreaArixMaxX(instance.getAreaArixMaxX());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
            checkInstance.setAreaArixMaxY(instance.getAreaArixMaxY());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
            checkInstance.setAreaArixMaxZ(instance.getAreaArixMaxZ());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_REACHABLE)) {
            checkInstance.setAreaReachable(instance.getAreaReachable());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_CAPACITY)) {
            checkInstance.setAreaCapacity(instance.getAreaCapacity());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
            checkInstance.setAreaArixXBase(instance.getAreaArixXBase());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
            checkInstance.setAreaArixYBase(instance.getAreaArixYBase());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
            checkInstance.setAreaArixZBase(instance.getAreaArixZBase());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_INDEX)) {
            checkInstance.setAreaIndex(instance.getAreaIndex());
        }
        if (conditionField.contains(ModelTMallArea.FI_AREA_PATH)) {
            checkInstance.setAreaPath(instance.getAreaPath());
        }
        ModelTMallArea selected = getOneByCond(Collections.singleton(ModelTMallArea.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTMallArea insertIfNoExist(ModelTMallArea instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTMallArea> buildMap(List<ModelTMallArea> list, String field) {
        Map<TT, ModelTMallArea> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTMallArea item: list) {
            ret.put(Constants.T_MALL_AREA_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTMallArea>> buildListMap(List<ModelTMallArea> list, String field) {
        Map<TT, List<ModelTMallArea>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTMallArea item: list) {
            List<ModelTMallArea> itemList = ret.get(Constants.T_MALL_AREA_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.T_MALL_AREA_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTMallArea> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTMallArea.FIELD_CLASS.containsKey(field)) {
            for (ModelTMallArea item: list) {
                ret.add(Constants.T_MALL_AREA_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
