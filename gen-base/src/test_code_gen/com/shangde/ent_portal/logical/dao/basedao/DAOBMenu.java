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
import com.shangde.ent_portal.logical.dto.basepo.ModelBMenu;

@Repository("DAOBMenu")
@SuppressWarnings("unchecked")
public class DAOBMenu
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelBMenu, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelBMenu, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOBMenu.class);

    public DAOBMenu() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelBMenu.class, Constants.B_MENU_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelBMenu.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelBMenu.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelBMenu.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelBMenu instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, dId);
        }
        String dMenu_code = instance.getMenuCode();
        if (dMenu_code!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_CODE, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_CODE, dMenu_code);
        }
        String dMenu_name = instance.getMenuName();
        if (dMenu_name!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_NAME, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_NAME, dMenu_name);
        }
        Integer dMenu_type = instance.getMenuType();
        if (dMenu_type!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_TYPE, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_TYPE, dMenu_type);
        }
        Integer dMenu_parent_id = instance.getMenuParentId();
        if (dMenu_parent_id!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_PARENT_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_PARENT_ID, dMenu_parent_id);
        }
        String dMenu_parent_url = instance.getMenuParentUrl();
        if (dMenu_parent_url!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_PARENT_URL, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_PARENT_URL, dMenu_parent_url);
        }
        String dMenu_url = instance.getMenuUrl();
        if (dMenu_url!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_URL, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_URL, dMenu_url);
        }
        String dMenu_icon_class = instance.getMenuIconClass();
        if (dMenu_icon_class!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_ICON_CLASS, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_ICON_CLASS, dMenu_icon_class);
        }
        Integer dMenu_sort = instance.getMenuSort();
        if (dMenu_sort!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_SORT, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_SORT, dMenu_sort);
        }
        Integer dMenu_enabled = instance.getMenuEnabled();
        if (dMenu_enabled!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_ENABLED, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_ENABLED, dMenu_enabled);
        }
        String dMenu_remark = instance.getMenuRemark();
        if (dMenu_remark!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_REMARK, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_REMARK, dMenu_remark);
        }
        Integer dMenu_creator = instance.getMenuCreator();
        if (dMenu_creator!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_CREATOR, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_CREATOR, dMenu_creator);
        }
        Date dMenu_create_time = instance.getMenuCreateTime();
        if (dMenu_create_time!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelBMenu.FI_MENU_CREATE_TIME, dMenu_create_time);
        }
        Integer dMenu_updator = instance.getMenuUpdator();
        if (dMenu_updator!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_UPDATOR, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_UPDATOR, dMenu_updator);
        }
        Date dMenu_update_time = instance.getMenuUpdateTime();
        if (dMenu_update_time!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelBMenu.FI_MENU_UPDATE_TIME, dMenu_update_time);
        }
        Byte dMenu_delete_flag = instance.getMenuDeleteFlag();
        if (dMenu_delete_flag!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelBMenu.FI_MENU_DELETE_FLAG, dMenu_delete_flag);
        }
        Byte dMenu_level = instance.getMenuLevel();
        if (dMenu_level!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_LEVEL, ColumnDataType.byteData);
            param.put(ModelBMenu.FI_MENU_LEVEL, dMenu_level);
        }
        Integer dMenu_auth = instance.getMenuAuth();
        if (dMenu_auth!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_AUTH, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_AUTH, dMenu_auth);
        }
        String dMenu_request_param_main = instance.getMenuRequestParamMain();
        if (dMenu_request_param_main!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN, dMenu_request_param_main);
        }
        String dMenu_request_param_sub = instance.getMenuRequestParamSub();
        if (dMenu_request_param_sub!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB, ColumnDataType.stringData);
            param.put(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB, dMenu_request_param_sub);
        }
        Integer dMenu_function_id = instance.getMenuFunctionId();
        if (dMenu_function_id!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_FUNCTION_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_MENU_FUNCTION_ID, dMenu_function_id);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelBMenu.FI_ID)) {
            sqlBuilder.itemCol(ModelBMenu.FI_ID);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_CODE)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CODE);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_NAME)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_NAME);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_TYPE)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_TYPE);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_PARENT_ID)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_ID);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_PARENT_URL)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_URL);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_URL)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_URL);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_ICON_CLASS)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ICON_CLASS);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_SORT)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_SORT);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_ENABLED)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ENABLED);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_REMARK)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REMARK);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_CREATOR)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATOR);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATE_TIME);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_UPDATOR)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATOR);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATE_TIME);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_DELETE_FLAG);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_LEVEL)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_LEVEL);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_AUTH)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_AUTH);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
        }
        if (selectFields.contains(ModelBMenu.FI_MENU_FUNCTION_ID)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_FUNCTION_ID);
        }
    }

    public List<ModelBMenu> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelBMenu> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelBMenu> get() {
        return get(null, null);
    }

    public List<ModelBMenu> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMenu.FI_ID, ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMenu> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelBMenu> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelBMenu> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelBMenu> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelBMenu> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelBMenu> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelBMenu> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByCond(Set<String> selectFields, Integer start, Integer count, ModelBMenu instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelBMenu> getByCond(Integer start, Integer count, ModelBMenu instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelBMenu> getByCond(ModelBMenu instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelBMenu> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelBMenu> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelBMenu> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelBMenu instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelBMenu> getByCondAndIndex(Integer start, Integer count, ModelBMenu instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelBMenu> getByCondAndIndex(ModelBMenu instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelBMenu> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMenu.FI_ID, ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMenu> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelBMenu> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelBMenu> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelBMenu> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMenu.FI_ID, ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBMenu> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBMenu instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBMenu> getByIdAndCondAndWhere(Integer start, Integer count, ModelBMenu instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBMenu> getByIdAndCondAndWhere(ModelBMenu instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelBMenu> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMenu> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMenu> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndWhere(Integer start, Integer count, ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndWhere(ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public List<ModelBMenu> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBMenu instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndIndexAndWhere(Integer start, Integer count, ModelBMenu instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBMenu> getByCondAndIndexAndWhere(ModelBMenu instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelBMenu getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMenu getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelBMenu getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelBMenu getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelBMenu instance) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public ModelBMenu getOneByCond(Set<String> selectFields, ModelBMenu instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelBMenu getOneByCond(ModelBMenu instance) {
        return getOneByCond(null, instance);
    }

    public ModelBMenu getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public ModelBMenu getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelBMenu getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelBMenu getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public ModelBMenu getOneByCondAndWhere(Set<String> selectFields, ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelBMenu getOneByCondAndWhere(ModelBMenu instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelBMenu getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBMenu instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBMenu getOneByIdAndCondAndWhere(Set<String> selectFields, ModelBMenu instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelBMenu getOneByIdAndCondAndWhere(ModelBMenu instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelBMenu instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelBMenu instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelBMenu instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelBMenu instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelBMenu instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelBMenu instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelBMenu instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelBMenu instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelBMenu instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelBMenu instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMenu.FI_ID, ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
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
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelBMenu instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelBMenu instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelBMenu instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBMenu instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBMenu.FI_ID, ModelBMenu.FI_ID, ColumnDataType.intData);
            param.put(ModelBMenu.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelBMenu instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelBMenu instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelBMenu insert(ModelBMenu instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_ID);
        }
        String dMenu_code = instance.getMenuCode();
        if (dMenu_code!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CODE);
        }
        String dMenu_name = instance.getMenuName();
        if (dMenu_name!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_NAME);
        }
        Integer dMenu_type = instance.getMenuType();
        if (dMenu_type!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_TYPE);
        }
        Integer dMenu_parent_id = instance.getMenuParentId();
        if (dMenu_parent_id!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_ID);
        }
        String dMenu_parent_url = instance.getMenuParentUrl();
        if (dMenu_parent_url!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_URL);
        }
        String dMenu_url = instance.getMenuUrl();
        if (dMenu_url!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_URL);
        }
        String dMenu_icon_class = instance.getMenuIconClass();
        if (dMenu_icon_class!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ICON_CLASS);
        }
        Integer dMenu_sort = instance.getMenuSort();
        if (dMenu_sort!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_SORT);
        }
        Integer dMenu_enabled = instance.getMenuEnabled();
        if (dMenu_enabled!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ENABLED);
        }
        String dMenu_remark = instance.getMenuRemark();
        if (dMenu_remark!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REMARK);
        }
        Integer dMenu_creator = instance.getMenuCreator();
        if (dMenu_creator!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATOR);
        }
        Date dMenu_create_time = instance.getMenuCreateTime();
        if (dMenu_create_time!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATE_TIME);
        }
        Integer dMenu_updator = instance.getMenuUpdator();
        if (dMenu_updator!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATOR);
        }
        Date dMenu_update_time = instance.getMenuUpdateTime();
        if (dMenu_update_time!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATE_TIME);
        }
        Byte dMenu_delete_flag = instance.getMenuDeleteFlag();
        if (dMenu_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_DELETE_FLAG);
        }
        Byte dMenu_level = instance.getMenuLevel();
        if (dMenu_level!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_LEVEL);
        }
        Integer dMenu_auth = instance.getMenuAuth();
        if (dMenu_auth!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_AUTH);
        }
        String dMenu_request_param_main = instance.getMenuRequestParamMain();
        if (dMenu_request_param_main!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
        }
        String dMenu_request_param_sub = instance.getMenuRequestParamSub();
        if (dMenu_request_param_sub!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
        }
        Integer dMenu_function_id = instance.getMenuFunctionId();
        if (dMenu_function_id!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_FUNCTION_ID);
        }
        Map<String, Object> param = Constants.B_MENU_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelBMenu insert(ModelBMenu instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelBMenu> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelBMenu.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        if (fields.contains(ModelBMenu.FI_ID)) {
            sqlBuilder.itemCol(ModelBMenu.FI_ID);
        }
        if (fields.contains(ModelBMenu.FI_MENU_CODE)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CODE);
        }
        if (fields.contains(ModelBMenu.FI_MENU_NAME)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_NAME);
        }
        if (fields.contains(ModelBMenu.FI_MENU_TYPE)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_TYPE);
        }
        if (fields.contains(ModelBMenu.FI_MENU_PARENT_ID)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_ID);
        }
        if (fields.contains(ModelBMenu.FI_MENU_PARENT_URL)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_URL);
        }
        if (fields.contains(ModelBMenu.FI_MENU_URL)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_URL);
        }
        if (fields.contains(ModelBMenu.FI_MENU_ICON_CLASS)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ICON_CLASS);
        }
        if (fields.contains(ModelBMenu.FI_MENU_SORT)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_SORT);
        }
        if (fields.contains(ModelBMenu.FI_MENU_ENABLED)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ENABLED);
        }
        if (fields.contains(ModelBMenu.FI_MENU_REMARK)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REMARK);
        }
        if (fields.contains(ModelBMenu.FI_MENU_CREATOR)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATOR);
        }
        if (fields.contains(ModelBMenu.FI_MENU_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATE_TIME);
        }
        if (fields.contains(ModelBMenu.FI_MENU_UPDATOR)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATOR);
        }
        if (fields.contains(ModelBMenu.FI_MENU_UPDATE_TIME)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATE_TIME);
        }
        if (fields.contains(ModelBMenu.FI_MENU_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_DELETE_FLAG);
        }
        if (fields.contains(ModelBMenu.FI_MENU_LEVEL)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_LEVEL);
        }
        if (fields.contains(ModelBMenu.FI_MENU_AUTH)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_AUTH);
        }
        if (fields.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
        }
        if (fields.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
        }
        if (fields.contains(ModelBMenu.FI_MENU_FUNCTION_ID)) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_FUNCTION_ID);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelBMenu instance: instances) {
            Map<String, Object> paramMap = Constants.B_MENU_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelBMenu> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelBMenu> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelBMenu instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelBMenu.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_ID);
            }
        }
        String dMenu_code = instance.getMenuCode();
        if (conditionField.contains(ModelBMenu.FI_MENU_CODE)) {
            throwExceptionIf((dMenu_code!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_CODE, ColumnDataType.stringData);
        } else {
            if (dMenu_code!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_CODE);
            }
        }
        String dMenu_name = instance.getMenuName();
        if (conditionField.contains(ModelBMenu.FI_MENU_NAME)) {
            throwExceptionIf((dMenu_name!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_NAME, ColumnDataType.stringData);
        } else {
            if (dMenu_name!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_NAME);
            }
        }
        Integer dMenu_type = instance.getMenuType();
        if (conditionField.contains(ModelBMenu.FI_MENU_TYPE)) {
            throwExceptionIf((dMenu_type!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_TYPE, ColumnDataType.intData);
        } else {
            if (dMenu_type!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_TYPE);
            }
        }
        Integer dMenu_parent_id = instance.getMenuParentId();
        if (conditionField.contains(ModelBMenu.FI_MENU_PARENT_ID)) {
            throwExceptionIf((dMenu_parent_id!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_PARENT_ID, ColumnDataType.intData);
        } else {
            if (dMenu_parent_id!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_ID);
            }
        }
        String dMenu_parent_url = instance.getMenuParentUrl();
        if (conditionField.contains(ModelBMenu.FI_MENU_PARENT_URL)) {
            throwExceptionIf((dMenu_parent_url!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_PARENT_URL, ColumnDataType.stringData);
        } else {
            if (dMenu_parent_url!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_URL);
            }
        }
        String dMenu_url = instance.getMenuUrl();
        if (conditionField.contains(ModelBMenu.FI_MENU_URL)) {
            throwExceptionIf((dMenu_url!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_URL, ColumnDataType.stringData);
        } else {
            if (dMenu_url!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_URL);
            }
        }
        String dMenu_icon_class = instance.getMenuIconClass();
        if (conditionField.contains(ModelBMenu.FI_MENU_ICON_CLASS)) {
            throwExceptionIf((dMenu_icon_class!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_ICON_CLASS, ColumnDataType.stringData);
        } else {
            if (dMenu_icon_class!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_ICON_CLASS);
            }
        }
        Integer dMenu_sort = instance.getMenuSort();
        if (conditionField.contains(ModelBMenu.FI_MENU_SORT)) {
            throwExceptionIf((dMenu_sort!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_SORT, ColumnDataType.intData);
        } else {
            if (dMenu_sort!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_SORT);
            }
        }
        Integer dMenu_enabled = instance.getMenuEnabled();
        if (conditionField.contains(ModelBMenu.FI_MENU_ENABLED)) {
            throwExceptionIf((dMenu_enabled!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_ENABLED, ColumnDataType.intData);
        } else {
            if (dMenu_enabled!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_ENABLED);
            }
        }
        String dMenu_remark = instance.getMenuRemark();
        if (conditionField.contains(ModelBMenu.FI_MENU_REMARK)) {
            throwExceptionIf((dMenu_remark!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_REMARK, ColumnDataType.stringData);
        } else {
            if (dMenu_remark!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_REMARK);
            }
        }
        Integer dMenu_creator = instance.getMenuCreator();
        if (conditionField.contains(ModelBMenu.FI_MENU_CREATOR)) {
            throwExceptionIf((dMenu_creator!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_CREATOR, ColumnDataType.intData);
        } else {
            if (dMenu_creator!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATOR);
            }
        }
        Date dMenu_create_time = instance.getMenuCreateTime();
        if (conditionField.contains(ModelBMenu.FI_MENU_CREATE_TIME)) {
            throwExceptionIf((dMenu_create_time!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dMenu_create_time!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATE_TIME);
            }
        }
        Integer dMenu_updator = instance.getMenuUpdator();
        if (conditionField.contains(ModelBMenu.FI_MENU_UPDATOR)) {
            throwExceptionIf((dMenu_updator!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_UPDATOR, ColumnDataType.intData);
        } else {
            if (dMenu_updator!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATOR);
            }
        }
        Date dMenu_update_time = instance.getMenuUpdateTime();
        if (conditionField.contains(ModelBMenu.FI_MENU_UPDATE_TIME)) {
            throwExceptionIf((dMenu_update_time!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dMenu_update_time!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATE_TIME);
            }
        }
        Byte dMenu_delete_flag = instance.getMenuDeleteFlag();
        if (conditionField.contains(ModelBMenu.FI_MENU_DELETE_FLAG)) {
            throwExceptionIf((dMenu_delete_flag!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dMenu_delete_flag!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_DELETE_FLAG);
            }
        }
        Byte dMenu_level = instance.getMenuLevel();
        if (conditionField.contains(ModelBMenu.FI_MENU_LEVEL)) {
            throwExceptionIf((dMenu_level!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_LEVEL, ColumnDataType.byteData);
        } else {
            if (dMenu_level!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_LEVEL);
            }
        }
        Integer dMenu_auth = instance.getMenuAuth();
        if (conditionField.contains(ModelBMenu.FI_MENU_AUTH)) {
            throwExceptionIf((dMenu_auth!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_AUTH, ColumnDataType.intData);
        } else {
            if (dMenu_auth!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_AUTH);
            }
        }
        String dMenu_request_param_main = instance.getMenuRequestParamMain();
        if (conditionField.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
            throwExceptionIf((dMenu_request_param_main!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN, ColumnDataType.stringData);
        } else {
            if (dMenu_request_param_main!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
            }
        }
        String dMenu_request_param_sub = instance.getMenuRequestParamSub();
        if (conditionField.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
            throwExceptionIf((dMenu_request_param_sub!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB, ColumnDataType.stringData);
        } else {
            if (dMenu_request_param_sub!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
            }
        }
        Integer dMenu_function_id = instance.getMenuFunctionId();
        if (conditionField.contains(ModelBMenu.FI_MENU_FUNCTION_ID)) {
            throwExceptionIf((dMenu_function_id!= null));
            sqlBuilder.itemWhere(ModelBMenu.FI_MENU_FUNCTION_ID, ColumnDataType.intData);
        } else {
            if (dMenu_function_id!= null) {
                sqlBuilder.itemCol(ModelBMenu.FI_MENU_FUNCTION_ID);
            }
        }
        Map<String, Object> param = Constants.B_MENU_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelBMenu instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelBMenu instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_ID);
        }
        String dMenu_code = instance.getMenuCode();
        if (dMenu_code!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CODE);
        }
        String dMenu_name = instance.getMenuName();
        if (dMenu_name!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_NAME);
        }
        Integer dMenu_type = instance.getMenuType();
        if (dMenu_type!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_TYPE);
        }
        Integer dMenu_parent_id = instance.getMenuParentId();
        if (dMenu_parent_id!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_ID);
        }
        String dMenu_parent_url = instance.getMenuParentUrl();
        if (dMenu_parent_url!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_URL);
        }
        String dMenu_url = instance.getMenuUrl();
        if (dMenu_url!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_URL);
        }
        String dMenu_icon_class = instance.getMenuIconClass();
        if (dMenu_icon_class!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ICON_CLASS);
        }
        Integer dMenu_sort = instance.getMenuSort();
        if (dMenu_sort!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_SORT);
        }
        Integer dMenu_enabled = instance.getMenuEnabled();
        if (dMenu_enabled!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ENABLED);
        }
        String dMenu_remark = instance.getMenuRemark();
        if (dMenu_remark!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REMARK);
        }
        Integer dMenu_creator = instance.getMenuCreator();
        if (dMenu_creator!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATOR);
        }
        Date dMenu_create_time = instance.getMenuCreateTime();
        if (dMenu_create_time!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATE_TIME);
        }
        Integer dMenu_updator = instance.getMenuUpdator();
        if (dMenu_updator!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATOR);
        }
        Date dMenu_update_time = instance.getMenuUpdateTime();
        if (dMenu_update_time!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATE_TIME);
        }
        Byte dMenu_delete_flag = instance.getMenuDeleteFlag();
        if (dMenu_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_DELETE_FLAG);
        }
        Byte dMenu_level = instance.getMenuLevel();
        if (dMenu_level!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_LEVEL);
        }
        Integer dMenu_auth = instance.getMenuAuth();
        if (dMenu_auth!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_AUTH);
        }
        String dMenu_request_param_main = instance.getMenuRequestParamMain();
        if (dMenu_request_param_main!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
        }
        String dMenu_request_param_sub = instance.getMenuRequestParamSub();
        if (dMenu_request_param_sub!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
        }
        Integer dMenu_function_id = instance.getMenuFunctionId();
        if (dMenu_function_id!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_FUNCTION_ID);
        }
        Map<String, Object> param;
        param = Constants.B_MENU_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelBMenu instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelBMenu instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        String dMenu_code = instance.getMenuCode();
        if (dMenu_code!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CODE);
        }
        String dMenu_name = instance.getMenuName();
        if (dMenu_name!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_NAME);
        }
        Integer dMenu_type = instance.getMenuType();
        if (dMenu_type!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_TYPE);
        }
        Integer dMenu_parent_id = instance.getMenuParentId();
        if (dMenu_parent_id!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_ID);
        }
        String dMenu_parent_url = instance.getMenuParentUrl();
        if (dMenu_parent_url!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_PARENT_URL);
        }
        String dMenu_url = instance.getMenuUrl();
        if (dMenu_url!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_URL);
        }
        String dMenu_icon_class = instance.getMenuIconClass();
        if (dMenu_icon_class!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ICON_CLASS);
        }
        Integer dMenu_sort = instance.getMenuSort();
        if (dMenu_sort!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_SORT);
        }
        Integer dMenu_enabled = instance.getMenuEnabled();
        if (dMenu_enabled!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_ENABLED);
        }
        String dMenu_remark = instance.getMenuRemark();
        if (dMenu_remark!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REMARK);
        }
        Integer dMenu_creator = instance.getMenuCreator();
        if (dMenu_creator!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATOR);
        }
        Date dMenu_create_time = instance.getMenuCreateTime();
        if (dMenu_create_time!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_CREATE_TIME);
        }
        Integer dMenu_updator = instance.getMenuUpdator();
        if (dMenu_updator!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATOR);
        }
        Date dMenu_update_time = instance.getMenuUpdateTime();
        if (dMenu_update_time!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_UPDATE_TIME);
        }
        Byte dMenu_delete_flag = instance.getMenuDeleteFlag();
        if (dMenu_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_DELETE_FLAG);
        }
        Byte dMenu_level = instance.getMenuLevel();
        if (dMenu_level!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_LEVEL);
        }
        Integer dMenu_auth = instance.getMenuAuth();
        if (dMenu_auth!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_AUTH);
        }
        String dMenu_request_param_main = instance.getMenuRequestParamMain();
        if (dMenu_request_param_main!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
        }
        String dMenu_request_param_sub = instance.getMenuRequestParamSub();
        if (dMenu_request_param_sub!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
        }
        Integer dMenu_function_id = instance.getMenuFunctionId();
        if (dMenu_function_id!= null) {
            sqlBuilder.itemCol(ModelBMenu.FI_MENU_FUNCTION_ID);
        }
        Map<String, Object> param;
        param = Constants.B_MENU_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelBMenu instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBMenu.DTO_TABLE_NAME);
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
    public ModelBMenu updateOrInsert(ModelBMenu instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBMenu checkInstance = new ModelBMenu();
        if (conditionField.contains(ModelBMenu.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_CODE)) {
            checkInstance.setMenuCode(instance.getMenuCode());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_NAME)) {
            checkInstance.setMenuName(instance.getMenuName());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_TYPE)) {
            checkInstance.setMenuType(instance.getMenuType());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_PARENT_ID)) {
            checkInstance.setMenuParentId(instance.getMenuParentId());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_PARENT_URL)) {
            checkInstance.setMenuParentUrl(instance.getMenuParentUrl());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_URL)) {
            checkInstance.setMenuUrl(instance.getMenuUrl());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_ICON_CLASS)) {
            checkInstance.setMenuIconClass(instance.getMenuIconClass());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_SORT)) {
            checkInstance.setMenuSort(instance.getMenuSort());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_ENABLED)) {
            checkInstance.setMenuEnabled(instance.getMenuEnabled());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_REMARK)) {
            checkInstance.setMenuRemark(instance.getMenuRemark());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_CREATOR)) {
            checkInstance.setMenuCreator(instance.getMenuCreator());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_CREATE_TIME)) {
            checkInstance.setMenuCreateTime(instance.getMenuCreateTime());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_UPDATOR)) {
            checkInstance.setMenuUpdator(instance.getMenuUpdator());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_UPDATE_TIME)) {
            checkInstance.setMenuUpdateTime(instance.getMenuUpdateTime());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_DELETE_FLAG)) {
            checkInstance.setMenuDeleteFlag(instance.getMenuDeleteFlag());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_LEVEL)) {
            checkInstance.setMenuLevel(instance.getMenuLevel());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_AUTH)) {
            checkInstance.setMenuAuth(instance.getMenuAuth());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
            checkInstance.setMenuRequestParamMain(instance.getMenuRequestParamMain());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
            checkInstance.setMenuRequestParamSub(instance.getMenuRequestParamSub());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_FUNCTION_ID)) {
            checkInstance.setMenuFunctionId(instance.getMenuFunctionId());
        }
        ModelBMenu selected = getOneByCond(Collections.singleton(ModelBMenu.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelBMenu.FI_ID), assembler);
            return instance;
        }
    }

    public ModelBMenu updateOrInsert(ModelBMenu instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelBMenu insertIfNoExist(ModelBMenu instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBMenu checkInstance = new ModelBMenu();
        if (conditionField.contains(ModelBMenu.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_CODE)) {
            checkInstance.setMenuCode(instance.getMenuCode());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_NAME)) {
            checkInstance.setMenuName(instance.getMenuName());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_TYPE)) {
            checkInstance.setMenuType(instance.getMenuType());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_PARENT_ID)) {
            checkInstance.setMenuParentId(instance.getMenuParentId());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_PARENT_URL)) {
            checkInstance.setMenuParentUrl(instance.getMenuParentUrl());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_URL)) {
            checkInstance.setMenuUrl(instance.getMenuUrl());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_ICON_CLASS)) {
            checkInstance.setMenuIconClass(instance.getMenuIconClass());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_SORT)) {
            checkInstance.setMenuSort(instance.getMenuSort());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_ENABLED)) {
            checkInstance.setMenuEnabled(instance.getMenuEnabled());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_REMARK)) {
            checkInstance.setMenuRemark(instance.getMenuRemark());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_CREATOR)) {
            checkInstance.setMenuCreator(instance.getMenuCreator());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_CREATE_TIME)) {
            checkInstance.setMenuCreateTime(instance.getMenuCreateTime());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_UPDATOR)) {
            checkInstance.setMenuUpdator(instance.getMenuUpdator());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_UPDATE_TIME)) {
            checkInstance.setMenuUpdateTime(instance.getMenuUpdateTime());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_DELETE_FLAG)) {
            checkInstance.setMenuDeleteFlag(instance.getMenuDeleteFlag());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_LEVEL)) {
            checkInstance.setMenuLevel(instance.getMenuLevel());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_AUTH)) {
            checkInstance.setMenuAuth(instance.getMenuAuth());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
            checkInstance.setMenuRequestParamMain(instance.getMenuRequestParamMain());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
            checkInstance.setMenuRequestParamSub(instance.getMenuRequestParamSub());
        }
        if (conditionField.contains(ModelBMenu.FI_MENU_FUNCTION_ID)) {
            checkInstance.setMenuFunctionId(instance.getMenuFunctionId());
        }
        ModelBMenu selected = getOneByCond(Collections.singleton(ModelBMenu.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelBMenu insertIfNoExist(ModelBMenu instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelBMenu> buildMap(List<ModelBMenu> list, String field) {
        Map<TT, ModelBMenu> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBMenu item: list) {
            ret.put(Constants.B_MENU_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelBMenu>> buildListMap(List<ModelBMenu> list, String field) {
        Map<TT, List<ModelBMenu>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBMenu item: list) {
            List<ModelBMenu> itemList = ret.get(Constants.B_MENU_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.B_MENU_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelBMenu> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelBMenu.FIELD_CLASS.containsKey(field)) {
            for (ModelBMenu item: list) {
                ret.add(Constants.B_MENU_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
