package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.contants.Constants;
import com.shangde.ent_portal.logical.dto.enums.EnumOrgUserRole;
import com.shangde.ent_portal.logical.dto.enums.EnumYesOrNo;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser;

@Repository("DAOBOrgnizationUser")
@SuppressWarnings("unchecked")
public class DAOBOrgnizationUser
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOBOrgnizationUser.class);

    public DAOBOrgnizationUser() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser.class, Constants.B_ORGNIZATION_USER_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelBOrgnizationUser.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelBOrgnizationUser.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelBOrgnizationUser instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, dId);
        }
        Integer dOrg_id = instance.getOrgId();
        if (dOrg_id!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ORG_ID, dOrg_id);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_USER_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_USER_ID, dUser_id);
        }
        EnumOrgUserRole dOrg_role = instance.getOrgRole();
        if (dOrg_role!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_ROLE, ColumnDataType.byteData);
            param.put(ModelBOrgnizationUser.FI_ORG_ROLE, dOrg_role.val);
        }
        Date dOrg_user_create_time = instance.getOrgUserCreateTime();
        if (dOrg_user_create_time!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME, dOrg_user_create_time);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelBOrgnizationUser.FI_DELETE_FLAG, dDelete_flag);
        }
        EnumYesOrNo dIs_user_default_org = instance.getIsUserDefaultOrg();
        if (dIs_user_default_org!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG, ColumnDataType.byteData);
            param.put(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG, dIs_user_default_org.val);
        }
        Byte dOrg_user_delete_flag = instance.getOrgUserDeleteFlag();
        if (dOrg_user_delete_flag!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG, dOrg_user_delete_flag);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelBOrgnizationUser.FI_ID)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ID);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_ORG_ID)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ID);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_USER_ID)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_USER_ID);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_ORG_ROLE)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ROLE);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_DELETE_FLAG);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
        }
        if (selectFields.contains(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
        }
    }

    public List<ModelBOrgnizationUser> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelBOrgnizationUser> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelBOrgnizationUser> get() {
        return get(null, null);
    }

    public List<ModelBOrgnizationUser> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBOrgnizationUser.FI_ID, ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBOrgnizationUser> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelBOrgnizationUser> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelBOrgnizationUser> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelBOrgnizationUser> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelBOrgnizationUser> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelBOrgnizationUser> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelBOrgnizationUser> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByCond(Set<String> selectFields, Integer start, Integer count, ModelBOrgnizationUser instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelBOrgnizationUser> getByCond(Integer start, Integer count, ModelBOrgnizationUser instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelBOrgnizationUser> getByCond(ModelBOrgnizationUser instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelBOrgnizationUser> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelBOrgnizationUser> getByCondAndIndex(Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelBOrgnizationUser> getByCondAndIndex(ModelBOrgnizationUser instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelBOrgnizationUser> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBOrgnizationUser.FI_ID, ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBOrgnizationUser> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBOrgnizationUser.FI_ID, ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBOrgnizationUser> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBOrgnizationUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIdAndCondAndWhere(Integer start, Integer count, ModelBOrgnizationUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIdAndCondAndWhere(ModelBOrgnizationUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndWhere(Integer start, Integer count, ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndWhere(ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public List<ModelBOrgnizationUser> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndIndexAndWhere(Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBOrgnizationUser> getByCondAndIndexAndWhere(ModelBOrgnizationUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelBOrgnizationUser getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBOrgnizationUser getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelBOrgnizationUser getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelBOrgnizationUser getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelBOrgnizationUser instance) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public ModelBOrgnizationUser getOneByCond(Set<String> selectFields, ModelBOrgnizationUser instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelBOrgnizationUser getOneByCond(ModelBOrgnizationUser instance) {
        return getOneByCond(null, instance);
    }

    public ModelBOrgnizationUser getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public ModelBOrgnizationUser getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelBOrgnizationUser getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelBOrgnizationUser getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public ModelBOrgnizationUser getOneByCondAndWhere(Set<String> selectFields, ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelBOrgnizationUser getOneByCondAndWhere(ModelBOrgnizationUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelBOrgnizationUser getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBOrgnizationUser instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBOrgnizationUser getOneByIdAndCondAndWhere(Set<String> selectFields, ModelBOrgnizationUser instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelBOrgnizationUser getOneByIdAndCondAndWhere(ModelBOrgnizationUser instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelBOrgnizationUser instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelBOrgnizationUser instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelBOrgnizationUser instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelBOrgnizationUser instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelBOrgnizationUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelBOrgnizationUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBOrgnizationUser.FI_ID, ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
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
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelBOrgnizationUser instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelBOrgnizationUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBOrgnizationUser instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBOrgnizationUser.FI_ID, ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBOrgnizationUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelBOrgnizationUser instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelBOrgnizationUser instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelBOrgnizationUser insert(ModelBOrgnizationUser instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ID);
        }
        Integer dOrg_id = instance.getOrgId();
        if (dOrg_id!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_USER_ID);
        }
        EnumOrgUserRole dOrg_role = instance.getOrgRole();
        if (dOrg_role!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ROLE);
        }
        Date dOrg_user_create_time = instance.getOrgUserCreateTime();
        if (dOrg_user_create_time!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_DELETE_FLAG);
        }
        EnumYesOrNo dIs_user_default_org = instance.getIsUserDefaultOrg();
        if (dIs_user_default_org!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
        }
        Byte dOrg_user_delete_flag = instance.getOrgUserDeleteFlag();
        if (dOrg_user_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
        }
        Map<String, Object> param = Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelBOrgnizationUser insert(ModelBOrgnizationUser instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelBOrgnizationUser> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelBOrgnizationUser.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        if (fields.contains(ModelBOrgnizationUser.FI_ID)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ID);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_ORG_ID)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ID);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_USER_ID)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_USER_ID);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_ORG_ROLE)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ROLE);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_DELETE_FLAG);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
        }
        if (fields.contains(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelBOrgnizationUser instance: instances) {
            Map<String, Object> paramMap = Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelBOrgnizationUser> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelBOrgnizationUser> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelBOrgnizationUser instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ID);
            }
        }
        Integer dOrg_id = instance.getOrgId();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_ID)) {
            throwExceptionIf((dOrg_id!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_ID, ColumnDataType.intData);
        } else {
            if (dOrg_id!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ID);
            }
        }
        Integer dUser_id = instance.getUserId();
        if (conditionField.contains(ModelBOrgnizationUser.FI_USER_ID)) {
            throwExceptionIf((dUser_id!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_USER_ID, ColumnDataType.intData);
        } else {
            if (dUser_id!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_USER_ID);
            }
        }
        EnumOrgUserRole dOrg_role = instance.getOrgRole();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_ROLE)) {
            throwExceptionIf((dOrg_role!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_ROLE, ColumnDataType.byteData);
        } else {
            if (dOrg_role!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ROLE);
            }
        }
        Date dOrg_user_create_time = instance.getOrgUserCreateTime();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
            throwExceptionIf((dOrg_user_create_time!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dOrg_user_create_time!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
            }
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (conditionField.contains(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
            throwExceptionIf((dDelete_flag!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dDelete_flag!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_DELETE_FLAG);
            }
        }
        EnumYesOrNo dIs_user_default_org = instance.getIsUserDefaultOrg();
        if (conditionField.contains(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
            throwExceptionIf((dIs_user_default_org!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG, ColumnDataType.byteData);
        } else {
            if (dIs_user_default_org!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
            }
        }
        Byte dOrg_user_delete_flag = instance.getOrgUserDeleteFlag();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
            throwExceptionIf((dOrg_user_delete_flag!= null));
            sqlBuilder.itemWhere(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dOrg_user_delete_flag!= null) {
                sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
            }
        }
        Map<String, Object> param = Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelBOrgnizationUser instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelBOrgnizationUser instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ID);
        }
        Integer dOrg_id = instance.getOrgId();
        if (dOrg_id!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_USER_ID);
        }
        EnumOrgUserRole dOrg_role = instance.getOrgRole();
        if (dOrg_role!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ROLE);
        }
        Date dOrg_user_create_time = instance.getOrgUserCreateTime();
        if (dOrg_user_create_time!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_DELETE_FLAG);
        }
        EnumYesOrNo dIs_user_default_org = instance.getIsUserDefaultOrg();
        if (dIs_user_default_org!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
        }
        Byte dOrg_user_delete_flag = instance.getOrgUserDeleteFlag();
        if (dOrg_user_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
        }
        Map<String, Object> param;
        param = Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelBOrgnizationUser instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelBOrgnizationUser instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        Integer dOrg_id = instance.getOrgId();
        if (dOrg_id!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ID);
        }
        Integer dUser_id = instance.getUserId();
        if (dUser_id!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_USER_ID);
        }
        EnumOrgUserRole dOrg_role = instance.getOrgRole();
        if (dOrg_role!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_ROLE);
        }
        Date dOrg_user_create_time = instance.getOrgUserCreateTime();
        if (dOrg_user_create_time!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME);
        }
        Byte dDelete_flag = instance.getDeleteFlag();
        if (dDelete_flag!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_DELETE_FLAG);
        }
        EnumYesOrNo dIs_user_default_org = instance.getIsUserDefaultOrg();
        if (dIs_user_default_org!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG);
        }
        Byte dOrg_user_delete_flag = instance.getOrgUserDeleteFlag();
        if (dOrg_user_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG);
        }
        Map<String, Object> param;
        param = Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelBOrgnizationUser instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBOrgnizationUser.DTO_TABLE_NAME);
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
    public ModelBOrgnizationUser updateOrInsert(ModelBOrgnizationUser instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBOrgnizationUser checkInstance = new ModelBOrgnizationUser();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_ID)) {
            checkInstance.setOrgId(instance.getOrgId());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_USER_ID)) {
            checkInstance.setUserId(instance.getUserId());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_ROLE)) {
            checkInstance.setOrgRole(instance.getOrgRole());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
            checkInstance.setOrgUserCreateTime(instance.getOrgUserCreateTime());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
            checkInstance.setIsUserDefaultOrg(instance.getIsUserDefaultOrg());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
            checkInstance.setOrgUserDeleteFlag(instance.getOrgUserDeleteFlag());
        }
        ModelBOrgnizationUser selected = getOneByCond(Collections.singleton(ModelBOrgnizationUser.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelBOrgnizationUser.FI_ID), assembler);
            return instance;
        }
    }

    public ModelBOrgnizationUser updateOrInsert(ModelBOrgnizationUser instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelBOrgnizationUser insertIfNoExist(ModelBOrgnizationUser instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBOrgnizationUser checkInstance = new ModelBOrgnizationUser();
        if (conditionField.contains(ModelBOrgnizationUser.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_ID)) {
            checkInstance.setOrgId(instance.getOrgId());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_USER_ID)) {
            checkInstance.setUserId(instance.getUserId());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_ROLE)) {
            checkInstance.setOrgRole(instance.getOrgRole());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_USER_CREATE_TIME)) {
            checkInstance.setOrgUserCreateTime(instance.getOrgUserCreateTime());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_DELETE_FLAG)) {
            checkInstance.setDeleteFlag(instance.getDeleteFlag());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_IS_USER_DEFAULT_ORG)) {
            checkInstance.setIsUserDefaultOrg(instance.getIsUserDefaultOrg());
        }
        if (conditionField.contains(ModelBOrgnizationUser.FI_ORG_USER_DELETE_FLAG)) {
            checkInstance.setOrgUserDeleteFlag(instance.getOrgUserDeleteFlag());
        }
        ModelBOrgnizationUser selected = getOneByCond(Collections.singleton(ModelBOrgnizationUser.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelBOrgnizationUser insertIfNoExist(ModelBOrgnizationUser instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelBOrgnizationUser> buildMap(List<ModelBOrgnizationUser> list, String field) {
        Map<TT, ModelBOrgnizationUser> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBOrgnizationUser item: list) {
            ret.put(Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelBOrgnizationUser>> buildListMap(List<ModelBOrgnizationUser> list, String field) {
        Map<TT, List<ModelBOrgnizationUser>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBOrgnizationUser item: list) {
            List<ModelBOrgnizationUser> itemList = ret.get(Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelBOrgnizationUser> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelBOrgnizationUser.FIELD_CLASS.containsKey(field)) {
            for (ModelBOrgnizationUser item: list) {
                ret.add(Constants.B_ORGNIZATION_USER_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
