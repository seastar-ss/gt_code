package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelBRole;

@Repository("DAOBRole")
@SuppressWarnings("unchecked")
public class DAOBRole
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelBRole, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelBRole, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOBRole.class);

    public DAOBRole() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelBRole.class, Constants.B_ROLE_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelBRole.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelBRole.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelBRole.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelBRole instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, dId);
        }
        String dRole_code = instance.getRoleCode();
        if (dRole_code!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_CODE, ColumnDataType.stringData);
            param.put(ModelBRole.FI_ROLE_CODE, dRole_code);
        }
        String dRole_name = instance.getRoleName();
        if (dRole_name!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_NAME, ColumnDataType.stringData);
            param.put(ModelBRole.FI_ROLE_NAME, dRole_name);
        }
        Byte dRole_type = instance.getRoleType();
        if (dRole_type!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_TYPE, ColumnDataType.byteData);
            param.put(ModelBRole.FI_ROLE_TYPE, dRole_type);
        }
        Integer dRole_sort = instance.getRoleSort();
        if (dRole_sort!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_SORT, ColumnDataType.intData);
            param.put(ModelBRole.FI_ROLE_SORT, dRole_sort);
        }
        Integer dRole_enabled = instance.getRoleEnabled();
        if (dRole_enabled!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_ENABLED, ColumnDataType.intData);
            param.put(ModelBRole.FI_ROLE_ENABLED, dRole_enabled);
        }
        String dRole_remark = instance.getRoleRemark();
        if (dRole_remark!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_REMARK, ColumnDataType.stringData);
            param.put(ModelBRole.FI_ROLE_REMARK, dRole_remark);
        }
        Integer dRole_creator = instance.getRoleCreator();
        if (dRole_creator!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_CREATOR, ColumnDataType.intData);
            param.put(ModelBRole.FI_ROLE_CREATOR, dRole_creator);
        }
        Date dRole_createdata = instance.getRoleCreatedata();
        if (dRole_createdata!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_CREATEDATA, ColumnDataType.timeStampData);
            param.put(ModelBRole.FI_ROLE_CREATEDATA, dRole_createdata);
        }
        Integer dRole_updator = instance.getRoleUpdator();
        if (dRole_updator!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_UPDATOR, ColumnDataType.intData);
            param.put(ModelBRole.FI_ROLE_UPDATOR, dRole_updator);
        }
        Date dRole_updatedata = instance.getRoleUpdatedata();
        if (dRole_updatedata!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_UPDATEDATA, ColumnDataType.timeStampData);
            param.put(ModelBRole.FI_ROLE_UPDATEDATA, dRole_updatedata);
        }
        Byte dRole_delete_flag = instance.getRoleDeleteFlag();
        if (dRole_delete_flag!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelBRole.FI_ROLE_DELETE_FLAG, dRole_delete_flag);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelBRole.FI_ID)) {
            sqlBuilder.itemCol(ModelBRole.FI_ID);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_CODE)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CODE);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_NAME)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_NAME);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_TYPE)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_TYPE);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_SORT)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_SORT);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_ENABLED)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_ENABLED);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_REMARK)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_REMARK);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_CREATOR)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATOR);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_CREATEDATA)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATEDATA);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_UPDATOR)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATOR);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_UPDATEDATA)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATEDATA);
        }
        if (selectFields.contains(ModelBRole.FI_ROLE_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_DELETE_FLAG);
        }
    }

    public List<ModelBRole> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelBRole> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelBRole> get() {
        return get(null, null);
    }

    public List<ModelBRole> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBRole.FI_ID, ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBRole> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelBRole> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelBRole> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelBRole> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelBRole> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelBRole> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelBRole> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBRole instance) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByCond(Set<String> selectFields, Integer start, Integer count, ModelBRole instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelBRole> getByCond(Integer start, Integer count, ModelBRole instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelBRole> getByCond(ModelBRole instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelBRole> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelBRole> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelBRole> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelBRole instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelBRole> getByCondAndIndex(Integer start, Integer count, ModelBRole instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelBRole> getByCondAndIndex(ModelBRole instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelBRole> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBRole.FI_ID, ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBRole> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelBRole> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelBRole> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelBRole> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBRole.FI_ID, ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBRole> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBRole instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBRole> getByIdAndCondAndWhere(Integer start, Integer count, ModelBRole instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBRole> getByIdAndCondAndWhere(ModelBRole instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelBRole> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBRole> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBRole> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndWhere(Integer start, Integer count, ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndWhere(ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public List<ModelBRole> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBRole instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndIndexAndWhere(Integer start, Integer count, ModelBRole instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBRole> getByCondAndIndexAndWhere(ModelBRole instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelBRole getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBRole getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelBRole getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelBRole getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelBRole instance) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public ModelBRole getOneByCond(Set<String> selectFields, ModelBRole instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelBRole getOneByCond(ModelBRole instance) {
        return getOneByCond(null, instance);
    }

    public ModelBRole getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public ModelBRole getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelBRole getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelBRole getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public ModelBRole getOneByCondAndWhere(Set<String> selectFields, ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelBRole getOneByCondAndWhere(ModelBRole instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelBRole getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBRole instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBRole getOneByIdAndCondAndWhere(Set<String> selectFields, ModelBRole instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelBRole getOneByIdAndCondAndWhere(ModelBRole instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelBRole instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelBRole instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelBRole instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelBRole instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelBRole instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelBRole instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelBRole instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelBRole instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelBRole instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelBRole instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBRole.FI_ID, ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
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
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelBRole instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelBRole instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelBRole instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBRole instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBRole.FI_ID, ModelBRole.FI_ID, ColumnDataType.intData);
            param.put(ModelBRole.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelBRole instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelBRole instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelBRole insert(ModelBRole instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ID);
        }
        String dRole_code = instance.getRoleCode();
        if (dRole_code!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CODE);
        }
        String dRole_name = instance.getRoleName();
        if (dRole_name!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_NAME);
        }
        Byte dRole_type = instance.getRoleType();
        if (dRole_type!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_TYPE);
        }
        Integer dRole_sort = instance.getRoleSort();
        if (dRole_sort!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_SORT);
        }
        Integer dRole_enabled = instance.getRoleEnabled();
        if (dRole_enabled!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_ENABLED);
        }
        String dRole_remark = instance.getRoleRemark();
        if (dRole_remark!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_REMARK);
        }
        Integer dRole_creator = instance.getRoleCreator();
        if (dRole_creator!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATOR);
        }
        Date dRole_createdata = instance.getRoleCreatedata();
        if (dRole_createdata!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATEDATA);
        }
        Integer dRole_updator = instance.getRoleUpdator();
        if (dRole_updator!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATOR);
        }
        Date dRole_updatedata = instance.getRoleUpdatedata();
        if (dRole_updatedata!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATEDATA);
        }
        Byte dRole_delete_flag = instance.getRoleDeleteFlag();
        if (dRole_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_DELETE_FLAG);
        }
        Map<String, Object> param = Constants.B_ROLE_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelBRole insert(ModelBRole instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelBRole> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelBRole.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        if (fields.contains(ModelBRole.FI_ID)) {
            sqlBuilder.itemCol(ModelBRole.FI_ID);
        }
        if (fields.contains(ModelBRole.FI_ROLE_CODE)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CODE);
        }
        if (fields.contains(ModelBRole.FI_ROLE_NAME)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_NAME);
        }
        if (fields.contains(ModelBRole.FI_ROLE_TYPE)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_TYPE);
        }
        if (fields.contains(ModelBRole.FI_ROLE_SORT)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_SORT);
        }
        if (fields.contains(ModelBRole.FI_ROLE_ENABLED)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_ENABLED);
        }
        if (fields.contains(ModelBRole.FI_ROLE_REMARK)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_REMARK);
        }
        if (fields.contains(ModelBRole.FI_ROLE_CREATOR)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATOR);
        }
        if (fields.contains(ModelBRole.FI_ROLE_CREATEDATA)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATEDATA);
        }
        if (fields.contains(ModelBRole.FI_ROLE_UPDATOR)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATOR);
        }
        if (fields.contains(ModelBRole.FI_ROLE_UPDATEDATA)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATEDATA);
        }
        if (fields.contains(ModelBRole.FI_ROLE_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_DELETE_FLAG);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelBRole instance: instances) {
            Map<String, Object> paramMap = Constants.B_ROLE_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelBRole> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelBRole> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelBRole instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelBRole.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ID);
            }
        }
        String dRole_code = instance.getRoleCode();
        if (conditionField.contains(ModelBRole.FI_ROLE_CODE)) {
            throwExceptionIf((dRole_code!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_CODE, ColumnDataType.stringData);
        } else {
            if (dRole_code!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_CODE);
            }
        }
        String dRole_name = instance.getRoleName();
        if (conditionField.contains(ModelBRole.FI_ROLE_NAME)) {
            throwExceptionIf((dRole_name!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_NAME, ColumnDataType.stringData);
        } else {
            if (dRole_name!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_NAME);
            }
        }
        Byte dRole_type = instance.getRoleType();
        if (conditionField.contains(ModelBRole.FI_ROLE_TYPE)) {
            throwExceptionIf((dRole_type!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_TYPE, ColumnDataType.byteData);
        } else {
            if (dRole_type!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_TYPE);
            }
        }
        Integer dRole_sort = instance.getRoleSort();
        if (conditionField.contains(ModelBRole.FI_ROLE_SORT)) {
            throwExceptionIf((dRole_sort!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_SORT, ColumnDataType.intData);
        } else {
            if (dRole_sort!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_SORT);
            }
        }
        Integer dRole_enabled = instance.getRoleEnabled();
        if (conditionField.contains(ModelBRole.FI_ROLE_ENABLED)) {
            throwExceptionIf((dRole_enabled!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_ENABLED, ColumnDataType.intData);
        } else {
            if (dRole_enabled!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_ENABLED);
            }
        }
        String dRole_remark = instance.getRoleRemark();
        if (conditionField.contains(ModelBRole.FI_ROLE_REMARK)) {
            throwExceptionIf((dRole_remark!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_REMARK, ColumnDataType.stringData);
        } else {
            if (dRole_remark!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_REMARK);
            }
        }
        Integer dRole_creator = instance.getRoleCreator();
        if (conditionField.contains(ModelBRole.FI_ROLE_CREATOR)) {
            throwExceptionIf((dRole_creator!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_CREATOR, ColumnDataType.intData);
        } else {
            if (dRole_creator!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATOR);
            }
        }
        Date dRole_createdata = instance.getRoleCreatedata();
        if (conditionField.contains(ModelBRole.FI_ROLE_CREATEDATA)) {
            throwExceptionIf((dRole_createdata!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_CREATEDATA, ColumnDataType.timeStampData);
        } else {
            if (dRole_createdata!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATEDATA);
            }
        }
        Integer dRole_updator = instance.getRoleUpdator();
        if (conditionField.contains(ModelBRole.FI_ROLE_UPDATOR)) {
            throwExceptionIf((dRole_updator!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_UPDATOR, ColumnDataType.intData);
        } else {
            if (dRole_updator!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATOR);
            }
        }
        Date dRole_updatedata = instance.getRoleUpdatedata();
        if (conditionField.contains(ModelBRole.FI_ROLE_UPDATEDATA)) {
            throwExceptionIf((dRole_updatedata!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_UPDATEDATA, ColumnDataType.timeStampData);
        } else {
            if (dRole_updatedata!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATEDATA);
            }
        }
        Byte dRole_delete_flag = instance.getRoleDeleteFlag();
        if (conditionField.contains(ModelBRole.FI_ROLE_DELETE_FLAG)) {
            throwExceptionIf((dRole_delete_flag!= null));
            sqlBuilder.itemWhere(ModelBRole.FI_ROLE_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dRole_delete_flag!= null) {
                sqlBuilder.itemCol(ModelBRole.FI_ROLE_DELETE_FLAG);
            }
        }
        Map<String, Object> param = Constants.B_ROLE_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelBRole instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelBRole instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ID);
        }
        String dRole_code = instance.getRoleCode();
        if (dRole_code!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CODE);
        }
        String dRole_name = instance.getRoleName();
        if (dRole_name!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_NAME);
        }
        Byte dRole_type = instance.getRoleType();
        if (dRole_type!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_TYPE);
        }
        Integer dRole_sort = instance.getRoleSort();
        if (dRole_sort!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_SORT);
        }
        Integer dRole_enabled = instance.getRoleEnabled();
        if (dRole_enabled!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_ENABLED);
        }
        String dRole_remark = instance.getRoleRemark();
        if (dRole_remark!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_REMARK);
        }
        Integer dRole_creator = instance.getRoleCreator();
        if (dRole_creator!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATOR);
        }
        Date dRole_createdata = instance.getRoleCreatedata();
        if (dRole_createdata!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATEDATA);
        }
        Integer dRole_updator = instance.getRoleUpdator();
        if (dRole_updator!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATOR);
        }
        Date dRole_updatedata = instance.getRoleUpdatedata();
        if (dRole_updatedata!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATEDATA);
        }
        Byte dRole_delete_flag = instance.getRoleDeleteFlag();
        if (dRole_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_DELETE_FLAG);
        }
        Map<String, Object> param;
        param = Constants.B_ROLE_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelBRole instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelBRole instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        String dRole_code = instance.getRoleCode();
        if (dRole_code!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CODE);
        }
        String dRole_name = instance.getRoleName();
        if (dRole_name!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_NAME);
        }
        Byte dRole_type = instance.getRoleType();
        if (dRole_type!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_TYPE);
        }
        Integer dRole_sort = instance.getRoleSort();
        if (dRole_sort!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_SORT);
        }
        Integer dRole_enabled = instance.getRoleEnabled();
        if (dRole_enabled!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_ENABLED);
        }
        String dRole_remark = instance.getRoleRemark();
        if (dRole_remark!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_REMARK);
        }
        Integer dRole_creator = instance.getRoleCreator();
        if (dRole_creator!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATOR);
        }
        Date dRole_createdata = instance.getRoleCreatedata();
        if (dRole_createdata!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_CREATEDATA);
        }
        Integer dRole_updator = instance.getRoleUpdator();
        if (dRole_updator!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATOR);
        }
        Date dRole_updatedata = instance.getRoleUpdatedata();
        if (dRole_updatedata!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_UPDATEDATA);
        }
        Byte dRole_delete_flag = instance.getRoleDeleteFlag();
        if (dRole_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBRole.FI_ROLE_DELETE_FLAG);
        }
        Map<String, Object> param;
        param = Constants.B_ROLE_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelBRole instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBRole.DTO_TABLE_NAME);
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
    public ModelBRole updateOrInsert(ModelBRole instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBRole checkInstance = new ModelBRole();
        if (conditionField.contains(ModelBRole.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_CODE)) {
            checkInstance.setRoleCode(instance.getRoleCode());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_NAME)) {
            checkInstance.setRoleName(instance.getRoleName());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_TYPE)) {
            checkInstance.setRoleType(instance.getRoleType());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_SORT)) {
            checkInstance.setRoleSort(instance.getRoleSort());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_ENABLED)) {
            checkInstance.setRoleEnabled(instance.getRoleEnabled());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_REMARK)) {
            checkInstance.setRoleRemark(instance.getRoleRemark());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_CREATOR)) {
            checkInstance.setRoleCreator(instance.getRoleCreator());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_CREATEDATA)) {
            checkInstance.setRoleCreatedata(instance.getRoleCreatedata());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_UPDATOR)) {
            checkInstance.setRoleUpdator(instance.getRoleUpdator());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_UPDATEDATA)) {
            checkInstance.setRoleUpdatedata(instance.getRoleUpdatedata());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_DELETE_FLAG)) {
            checkInstance.setRoleDeleteFlag(instance.getRoleDeleteFlag());
        }
        ModelBRole selected = getOneByCond(Collections.singleton(ModelBRole.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelBRole.FI_ID), assembler);
            return instance;
        }
    }

    public ModelBRole updateOrInsert(ModelBRole instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelBRole insertIfNoExist(ModelBRole instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBRole checkInstance = new ModelBRole();
        if (conditionField.contains(ModelBRole.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_CODE)) {
            checkInstance.setRoleCode(instance.getRoleCode());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_NAME)) {
            checkInstance.setRoleName(instance.getRoleName());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_TYPE)) {
            checkInstance.setRoleType(instance.getRoleType());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_SORT)) {
            checkInstance.setRoleSort(instance.getRoleSort());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_ENABLED)) {
            checkInstance.setRoleEnabled(instance.getRoleEnabled());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_REMARK)) {
            checkInstance.setRoleRemark(instance.getRoleRemark());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_CREATOR)) {
            checkInstance.setRoleCreator(instance.getRoleCreator());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_CREATEDATA)) {
            checkInstance.setRoleCreatedata(instance.getRoleCreatedata());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_UPDATOR)) {
            checkInstance.setRoleUpdator(instance.getRoleUpdator());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_UPDATEDATA)) {
            checkInstance.setRoleUpdatedata(instance.getRoleUpdatedata());
        }
        if (conditionField.contains(ModelBRole.FI_ROLE_DELETE_FLAG)) {
            checkInstance.setRoleDeleteFlag(instance.getRoleDeleteFlag());
        }
        ModelBRole selected = getOneByCond(Collections.singleton(ModelBRole.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelBRole insertIfNoExist(ModelBRole instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelBRole> buildMap(List<ModelBRole> list, String field) {
        Map<TT, ModelBRole> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBRole item: list) {
            ret.put(Constants.B_ROLE_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelBRole>> buildListMap(List<ModelBRole> list, String field) {
        Map<TT, List<ModelBRole>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBRole item: list) {
            List<ModelBRole> itemList = ret.get(Constants.B_ROLE_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.B_ROLE_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelBRole> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelBRole.FIELD_CLASS.containsKey(field)) {
            for (ModelBRole item: list) {
                ret.add(Constants.B_ROLE_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
