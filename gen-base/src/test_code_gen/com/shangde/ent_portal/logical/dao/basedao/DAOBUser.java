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
import com.shangde.ent_portal.logical.dto.basepo.ModelBUser;

@Repository("DAOBUser")
@SuppressWarnings("unchecked")
public class DAOBUser
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelBUser, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelBUser, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOBUser.class);

    public DAOBUser() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelBUser.class, Constants.B_USER_RESULT_SET_OBJ_MAPPER);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelBUser.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelBUser.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelBUser.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelBUser instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, dId);
        }
        String dUser_name = instance.getUserName();
        if (dUser_name!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_NAME, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_NAME, dUser_name);
        }
        String dUser_show_name = instance.getUserShowName();
        if (dUser_show_name!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_SHOW_NAME, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_SHOW_NAME, dUser_show_name);
        }
        String dUser_pwd = instance.getUserPwd();
        if (dUser_pwd!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_PWD, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_PWD, dUser_pwd);
        }
        String dUser_mobile = instance.getUserMobile();
        if (dUser_mobile!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_MOBILE, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_MOBILE, dUser_mobile);
        }
        Date dUser_create_time = instance.getUserCreateTime();
        if (dUser_create_time!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_CREATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelBUser.FI_USER_CREATE_TIME, dUser_create_time);
        }
        String dUser_salt = instance.getUserSalt();
        if (dUser_salt!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_SALT, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_SALT, dUser_salt);
        }
        String dUser_wx = instance.getUserWx();
        if (dUser_wx!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_WX, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_WX, dUser_wx);
        }
        String dUser_email = instance.getUserEmail();
        if (dUser_email!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_EMAIL, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_EMAIL, dUser_email);
        }
        Date dUser_modify_time = instance.getUserModifyTime();
        if (dUser_modify_time!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_MODIFY_TIME, ColumnDataType.timeStampData);
            param.put(ModelBUser.FI_USER_MODIFY_TIME, dUser_modify_time);
        }
        String dUser_image = instance.getUserImage();
        if (dUser_image!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_IMAGE, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_IMAGE, dUser_image);
        }
        String dUser_avatar = instance.getUserAvatar();
        if (dUser_avatar!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_AVATAR, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_AVATAR, dUser_avatar);
        }
        Byte dUser_status = instance.getUserStatus();
        if (dUser_status!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_STATUS, ColumnDataType.byteData);
            param.put(ModelBUser.FI_USER_STATUS, dUser_status);
        }
        String dUser_wx_open_id = instance.getUserWxOpenId();
        if (dUser_wx_open_id!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_WX_OPEN_ID, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_WX_OPEN_ID, dUser_wx_open_id);
        }
        String dUser_push_token = instance.getUserPushToken();
        if (dUser_push_token!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_PUSH_TOKEN, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_PUSH_TOKEN, dUser_push_token);
        }
        Byte dUser_delete_flag = instance.getUserDeleteFlag();
        if (dUser_delete_flag!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_DELETE_FLAG, ColumnDataType.byteData);
            param.put(ModelBUser.FI_USER_DELETE_FLAG, dUser_delete_flag);
        }
        Integer dUser_type = instance.getUserType();
        if (dUser_type!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_TYPE, ColumnDataType.intData);
            param.put(ModelBUser.FI_USER_TYPE, dUser_type);
        }
        String dUser_provider = instance.getUserProvider();
        if (dUser_provider!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_USER_PROVIDER, ColumnDataType.stringData);
            param.put(ModelBUser.FI_USER_PROVIDER, dUser_provider);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelBUser.FI_ID)) {
            sqlBuilder.itemCol(ModelBUser.FI_ID);
        }
        if (selectFields.contains(ModelBUser.FI_USER_NAME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_NAME);
        }
        if (selectFields.contains(ModelBUser.FI_USER_SHOW_NAME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SHOW_NAME);
        }
        if (selectFields.contains(ModelBUser.FI_USER_PWD)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PWD);
        }
        if (selectFields.contains(ModelBUser.FI_USER_MOBILE)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MOBILE);
        }
        if (selectFields.contains(ModelBUser.FI_USER_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_CREATE_TIME);
        }
        if (selectFields.contains(ModelBUser.FI_USER_SALT)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SALT);
        }
        if (selectFields.contains(ModelBUser.FI_USER_WX)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX);
        }
        if (selectFields.contains(ModelBUser.FI_USER_EMAIL)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_EMAIL);
        }
        if (selectFields.contains(ModelBUser.FI_USER_MODIFY_TIME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MODIFY_TIME);
        }
        if (selectFields.contains(ModelBUser.FI_USER_IMAGE)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_IMAGE);
        }
        if (selectFields.contains(ModelBUser.FI_USER_AVATAR)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_AVATAR);
        }
        if (selectFields.contains(ModelBUser.FI_USER_STATUS)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_STATUS);
        }
        if (selectFields.contains(ModelBUser.FI_USER_WX_OPEN_ID)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX_OPEN_ID);
        }
        if (selectFields.contains(ModelBUser.FI_USER_PUSH_TOKEN)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PUSH_TOKEN);
        }
        if (selectFields.contains(ModelBUser.FI_USER_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_DELETE_FLAG);
        }
        if (selectFields.contains(ModelBUser.FI_USER_TYPE)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_TYPE);
        }
        if (selectFields.contains(ModelBUser.FI_USER_PROVIDER)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PROVIDER);
        }
    }

    public List<ModelBUser> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelBUser> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelBUser> get() {
        return get(null, null);
    }

    public List<ModelBUser> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBUser.FI_ID, ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBUser> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelBUser> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelBUser> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelBUser> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelBUser> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelBUser> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelBUser> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBUser instance) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByCond(Set<String> selectFields, Integer start, Integer count, ModelBUser instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelBUser> getByCond(Integer start, Integer count, ModelBUser instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelBUser> getByCond(ModelBUser instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelBUser> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelBUser> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelBUser> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelBUser instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelBUser> getByCondAndIndex(Integer start, Integer count, ModelBUser instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelBUser> getByCondAndIndex(ModelBUser instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelBUser> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBUser.FI_ID, ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBUser> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelBUser> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelBUser> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelBUser> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBUser.FI_ID, ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelBUser> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBUser> getByIdAndCondAndWhere(Integer start, Integer count, ModelBUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelBUser> getByIdAndCondAndWhere(ModelBUser instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelBUser> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBUser> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelBUser> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndWhere(Integer start, Integer count, ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndWhere(ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public List<ModelBUser> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelBUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndIndexAndWhere(Integer start, Integer count, ModelBUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelBUser> getByCondAndIndexAndWhere(ModelBUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelBUser getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBUser getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelBUser getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelBUser getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelBUser instance) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public ModelBUser getOneByCond(Set<String> selectFields, ModelBUser instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelBUser getOneByCond(ModelBUser instance) {
        return getOneByCond(null, instance);
    }

    public ModelBUser getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public ModelBUser getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelBUser getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelBUser getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public ModelBUser getOneByCondAndWhere(Set<String> selectFields, ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelBUser getOneByCondAndWhere(ModelBUser instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelBUser getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelBUser instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.itemWhere(ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelBUser getOneByIdAndCondAndWhere(Set<String> selectFields, ModelBUser instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelBUser getOneByIdAndCondAndWhere(ModelBUser instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelBUser instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelBUser instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelBUser instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelBUser instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelBUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelBUser instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelBUser instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelBUser instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelBUser instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelBUser instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBUser.FI_ID, ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
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
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelBUser instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelBUser instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelBUser instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelBUser instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelBUser.FI_ID, ModelBUser.FI_ID, ColumnDataType.intData);
            param.put(ModelBUser.FI_ID, id);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelBUser instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelBUser instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelBUser insert(ModelBUser instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_ID);
        }
        String dUser_name = instance.getUserName();
        if (dUser_name!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_NAME);
        }
        String dUser_show_name = instance.getUserShowName();
        if (dUser_show_name!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SHOW_NAME);
        }
        String dUser_pwd = instance.getUserPwd();
        if (dUser_pwd!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PWD);
        }
        String dUser_mobile = instance.getUserMobile();
        if (dUser_mobile!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MOBILE);
        }
        Date dUser_create_time = instance.getUserCreateTime();
        if (dUser_create_time!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_CREATE_TIME);
        }
        String dUser_salt = instance.getUserSalt();
        if (dUser_salt!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SALT);
        }
        String dUser_wx = instance.getUserWx();
        if (dUser_wx!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX);
        }
        String dUser_email = instance.getUserEmail();
        if (dUser_email!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_EMAIL);
        }
        Date dUser_modify_time = instance.getUserModifyTime();
        if (dUser_modify_time!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MODIFY_TIME);
        }
        String dUser_image = instance.getUserImage();
        if (dUser_image!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_IMAGE);
        }
        String dUser_avatar = instance.getUserAvatar();
        if (dUser_avatar!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_AVATAR);
        }
        Byte dUser_status = instance.getUserStatus();
        if (dUser_status!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_STATUS);
        }
        String dUser_wx_open_id = instance.getUserWxOpenId();
        if (dUser_wx_open_id!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX_OPEN_ID);
        }
        String dUser_push_token = instance.getUserPushToken();
        if (dUser_push_token!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PUSH_TOKEN);
        }
        Byte dUser_delete_flag = instance.getUserDeleteFlag();
        if (dUser_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_DELETE_FLAG);
        }
        Integer dUser_type = instance.getUserType();
        if (dUser_type!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_TYPE);
        }
        String dUser_provider = instance.getUserProvider();
        if (dUser_provider!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PROVIDER);
        }
        Map<String, Object> param = Constants.B_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
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

    public ModelBUser insert(ModelBUser instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelBUser> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelBUser.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        if (fields.contains(ModelBUser.FI_ID)) {
            sqlBuilder.itemCol(ModelBUser.FI_ID);
        }
        if (fields.contains(ModelBUser.FI_USER_NAME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_NAME);
        }
        if (fields.contains(ModelBUser.FI_USER_SHOW_NAME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SHOW_NAME);
        }
        if (fields.contains(ModelBUser.FI_USER_PWD)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PWD);
        }
        if (fields.contains(ModelBUser.FI_USER_MOBILE)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MOBILE);
        }
        if (fields.contains(ModelBUser.FI_USER_CREATE_TIME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_CREATE_TIME);
        }
        if (fields.contains(ModelBUser.FI_USER_SALT)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SALT);
        }
        if (fields.contains(ModelBUser.FI_USER_WX)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX);
        }
        if (fields.contains(ModelBUser.FI_USER_EMAIL)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_EMAIL);
        }
        if (fields.contains(ModelBUser.FI_USER_MODIFY_TIME)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MODIFY_TIME);
        }
        if (fields.contains(ModelBUser.FI_USER_IMAGE)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_IMAGE);
        }
        if (fields.contains(ModelBUser.FI_USER_AVATAR)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_AVATAR);
        }
        if (fields.contains(ModelBUser.FI_USER_STATUS)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_STATUS);
        }
        if (fields.contains(ModelBUser.FI_USER_WX_OPEN_ID)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX_OPEN_ID);
        }
        if (fields.contains(ModelBUser.FI_USER_PUSH_TOKEN)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PUSH_TOKEN);
        }
        if (fields.contains(ModelBUser.FI_USER_DELETE_FLAG)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_DELETE_FLAG);
        }
        if (fields.contains(ModelBUser.FI_USER_TYPE)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_TYPE);
        }
        if (fields.contains(ModelBUser.FI_USER_PROVIDER)) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PROVIDER);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelBUser instance: instances) {
            Map<String, Object> paramMap = Constants.B_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        return super.batchInsert(assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelBUser> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelBUser> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelBUser instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelBUser.FI_ID)) {
            throwExceptionIf((dId!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_ID);
            }
        }
        String dUser_name = instance.getUserName();
        if (conditionField.contains(ModelBUser.FI_USER_NAME)) {
            throwExceptionIf((dUser_name!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_NAME, ColumnDataType.stringData);
        } else {
            if (dUser_name!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_NAME);
            }
        }
        String dUser_show_name = instance.getUserShowName();
        if (conditionField.contains(ModelBUser.FI_USER_SHOW_NAME)) {
            throwExceptionIf((dUser_show_name!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_SHOW_NAME, ColumnDataType.stringData);
        } else {
            if (dUser_show_name!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_SHOW_NAME);
            }
        }
        String dUser_pwd = instance.getUserPwd();
        if (conditionField.contains(ModelBUser.FI_USER_PWD)) {
            throwExceptionIf((dUser_pwd!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_PWD, ColumnDataType.stringData);
        } else {
            if (dUser_pwd!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_PWD);
            }
        }
        String dUser_mobile = instance.getUserMobile();
        if (conditionField.contains(ModelBUser.FI_USER_MOBILE)) {
            throwExceptionIf((dUser_mobile!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_MOBILE, ColumnDataType.stringData);
        } else {
            if (dUser_mobile!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_MOBILE);
            }
        }
        Date dUser_create_time = instance.getUserCreateTime();
        if (conditionField.contains(ModelBUser.FI_USER_CREATE_TIME)) {
            throwExceptionIf((dUser_create_time!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_CREATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dUser_create_time!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_CREATE_TIME);
            }
        }
        String dUser_salt = instance.getUserSalt();
        if (conditionField.contains(ModelBUser.FI_USER_SALT)) {
            throwExceptionIf((dUser_salt!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_SALT, ColumnDataType.stringData);
        } else {
            if (dUser_salt!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_SALT);
            }
        }
        String dUser_wx = instance.getUserWx();
        if (conditionField.contains(ModelBUser.FI_USER_WX)) {
            throwExceptionIf((dUser_wx!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_WX, ColumnDataType.stringData);
        } else {
            if (dUser_wx!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_WX);
            }
        }
        String dUser_email = instance.getUserEmail();
        if (conditionField.contains(ModelBUser.FI_USER_EMAIL)) {
            throwExceptionIf((dUser_email!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_EMAIL, ColumnDataType.stringData);
        } else {
            if (dUser_email!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_EMAIL);
            }
        }
        Date dUser_modify_time = instance.getUserModifyTime();
        if (conditionField.contains(ModelBUser.FI_USER_MODIFY_TIME)) {
            throwExceptionIf((dUser_modify_time!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_MODIFY_TIME, ColumnDataType.timeStampData);
        } else {
            if (dUser_modify_time!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_MODIFY_TIME);
            }
        }
        String dUser_image = instance.getUserImage();
        if (conditionField.contains(ModelBUser.FI_USER_IMAGE)) {
            throwExceptionIf((dUser_image!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_IMAGE, ColumnDataType.stringData);
        } else {
            if (dUser_image!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_IMAGE);
            }
        }
        String dUser_avatar = instance.getUserAvatar();
        if (conditionField.contains(ModelBUser.FI_USER_AVATAR)) {
            throwExceptionIf((dUser_avatar!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_AVATAR, ColumnDataType.stringData);
        } else {
            if (dUser_avatar!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_AVATAR);
            }
        }
        Byte dUser_status = instance.getUserStatus();
        if (conditionField.contains(ModelBUser.FI_USER_STATUS)) {
            throwExceptionIf((dUser_status!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_STATUS, ColumnDataType.byteData);
        } else {
            if (dUser_status!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_STATUS);
            }
        }
        String dUser_wx_open_id = instance.getUserWxOpenId();
        if (conditionField.contains(ModelBUser.FI_USER_WX_OPEN_ID)) {
            throwExceptionIf((dUser_wx_open_id!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_WX_OPEN_ID, ColumnDataType.stringData);
        } else {
            if (dUser_wx_open_id!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_WX_OPEN_ID);
            }
        }
        String dUser_push_token = instance.getUserPushToken();
        if (conditionField.contains(ModelBUser.FI_USER_PUSH_TOKEN)) {
            throwExceptionIf((dUser_push_token!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_PUSH_TOKEN, ColumnDataType.stringData);
        } else {
            if (dUser_push_token!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_PUSH_TOKEN);
            }
        }
        Byte dUser_delete_flag = instance.getUserDeleteFlag();
        if (conditionField.contains(ModelBUser.FI_USER_DELETE_FLAG)) {
            throwExceptionIf((dUser_delete_flag!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_DELETE_FLAG, ColumnDataType.byteData);
        } else {
            if (dUser_delete_flag!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_DELETE_FLAG);
            }
        }
        Integer dUser_type = instance.getUserType();
        if (conditionField.contains(ModelBUser.FI_USER_TYPE)) {
            throwExceptionIf((dUser_type!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_TYPE, ColumnDataType.intData);
        } else {
            if (dUser_type!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_TYPE);
            }
        }
        String dUser_provider = instance.getUserProvider();
        if (conditionField.contains(ModelBUser.FI_USER_PROVIDER)) {
            throwExceptionIf((dUser_provider!= null));
            sqlBuilder.itemWhere(ModelBUser.FI_USER_PROVIDER, ColumnDataType.stringData);
        } else {
            if (dUser_provider!= null) {
                sqlBuilder.itemCol(ModelBUser.FI_USER_PROVIDER);
            }
        }
        Map<String, Object> param = Constants.B_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer update(ModelBUser instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelBUser instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        throwExceptionIf((instance.getId()!= null));
        sqlBuilder.itemWhere("__id", ColumnDataType.intData);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_ID);
        }
        String dUser_name = instance.getUserName();
        if (dUser_name!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_NAME);
        }
        String dUser_show_name = instance.getUserShowName();
        if (dUser_show_name!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SHOW_NAME);
        }
        String dUser_pwd = instance.getUserPwd();
        if (dUser_pwd!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PWD);
        }
        String dUser_mobile = instance.getUserMobile();
        if (dUser_mobile!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MOBILE);
        }
        Date dUser_create_time = instance.getUserCreateTime();
        if (dUser_create_time!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_CREATE_TIME);
        }
        String dUser_salt = instance.getUserSalt();
        if (dUser_salt!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SALT);
        }
        String dUser_wx = instance.getUserWx();
        if (dUser_wx!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX);
        }
        String dUser_email = instance.getUserEmail();
        if (dUser_email!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_EMAIL);
        }
        Date dUser_modify_time = instance.getUserModifyTime();
        if (dUser_modify_time!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MODIFY_TIME);
        }
        String dUser_image = instance.getUserImage();
        if (dUser_image!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_IMAGE);
        }
        String dUser_avatar = instance.getUserAvatar();
        if (dUser_avatar!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_AVATAR);
        }
        Byte dUser_status = instance.getUserStatus();
        if (dUser_status!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_STATUS);
        }
        String dUser_wx_open_id = instance.getUserWxOpenId();
        if (dUser_wx_open_id!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX_OPEN_ID);
        }
        String dUser_push_token = instance.getUserPushToken();
        if (dUser_push_token!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PUSH_TOKEN);
        }
        Byte dUser_delete_flag = instance.getUserDeleteFlag();
        if (dUser_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_DELETE_FLAG);
        }
        Integer dUser_type = instance.getUserType();
        if (dUser_type!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_TYPE);
        }
        String dUser_provider = instance.getUserProvider();
        if (dUser_provider!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PROVIDER);
        }
        Map<String, Object> param;
        param = Constants.B_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__id", instance.getId());
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelBUser instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelBUser instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
        throwExceptionIf(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, "__ids", "__ids", ColumnDataType.intData);
        Integer dId = instance.getId();
        instance.setId(null);
        String dUser_name = instance.getUserName();
        if (dUser_name!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_NAME);
        }
        String dUser_show_name = instance.getUserShowName();
        if (dUser_show_name!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SHOW_NAME);
        }
        String dUser_pwd = instance.getUserPwd();
        if (dUser_pwd!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PWD);
        }
        String dUser_mobile = instance.getUserMobile();
        if (dUser_mobile!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MOBILE);
        }
        Date dUser_create_time = instance.getUserCreateTime();
        if (dUser_create_time!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_CREATE_TIME);
        }
        String dUser_salt = instance.getUserSalt();
        if (dUser_salt!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_SALT);
        }
        String dUser_wx = instance.getUserWx();
        if (dUser_wx!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX);
        }
        String dUser_email = instance.getUserEmail();
        if (dUser_email!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_EMAIL);
        }
        Date dUser_modify_time = instance.getUserModifyTime();
        if (dUser_modify_time!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_MODIFY_TIME);
        }
        String dUser_image = instance.getUserImage();
        if (dUser_image!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_IMAGE);
        }
        String dUser_avatar = instance.getUserAvatar();
        if (dUser_avatar!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_AVATAR);
        }
        Byte dUser_status = instance.getUserStatus();
        if (dUser_status!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_STATUS);
        }
        String dUser_wx_open_id = instance.getUserWxOpenId();
        if (dUser_wx_open_id!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_WX_OPEN_ID);
        }
        String dUser_push_token = instance.getUserPushToken();
        if (dUser_push_token!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PUSH_TOKEN);
        }
        Byte dUser_delete_flag = instance.getUserDeleteFlag();
        if (dUser_delete_flag!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_DELETE_FLAG);
        }
        Integer dUser_type = instance.getUserType();
        if (dUser_type!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_TYPE);
        }
        String dUser_provider = instance.getUserProvider();
        if (dUser_provider!= null) {
            sqlBuilder.itemCol(ModelBUser.FI_USER_PROVIDER);
        }
        Map<String, Object> param;
        param = Constants.B_USER_MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("__ids", ids);
        return super.update(assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelBUser instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelBUser.DTO_TABLE_NAME);
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
    public ModelBUser updateOrInsert(ModelBUser instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBUser checkInstance = new ModelBUser();
        if (conditionField.contains(ModelBUser.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBUser.FI_USER_NAME)) {
            checkInstance.setUserName(instance.getUserName());
        }
        if (conditionField.contains(ModelBUser.FI_USER_SHOW_NAME)) {
            checkInstance.setUserShowName(instance.getUserShowName());
        }
        if (conditionField.contains(ModelBUser.FI_USER_PWD)) {
            checkInstance.setUserPwd(instance.getUserPwd());
        }
        if (conditionField.contains(ModelBUser.FI_USER_MOBILE)) {
            checkInstance.setUserMobile(instance.getUserMobile());
        }
        if (conditionField.contains(ModelBUser.FI_USER_CREATE_TIME)) {
            checkInstance.setUserCreateTime(instance.getUserCreateTime());
        }
        if (conditionField.contains(ModelBUser.FI_USER_SALT)) {
            checkInstance.setUserSalt(instance.getUserSalt());
        }
        if (conditionField.contains(ModelBUser.FI_USER_WX)) {
            checkInstance.setUserWx(instance.getUserWx());
        }
        if (conditionField.contains(ModelBUser.FI_USER_EMAIL)) {
            checkInstance.setUserEmail(instance.getUserEmail());
        }
        if (conditionField.contains(ModelBUser.FI_USER_MODIFY_TIME)) {
            checkInstance.setUserModifyTime(instance.getUserModifyTime());
        }
        if (conditionField.contains(ModelBUser.FI_USER_IMAGE)) {
            checkInstance.setUserImage(instance.getUserImage());
        }
        if (conditionField.contains(ModelBUser.FI_USER_AVATAR)) {
            checkInstance.setUserAvatar(instance.getUserAvatar());
        }
        if (conditionField.contains(ModelBUser.FI_USER_STATUS)) {
            checkInstance.setUserStatus(instance.getUserStatus());
        }
        if (conditionField.contains(ModelBUser.FI_USER_WX_OPEN_ID)) {
            checkInstance.setUserWxOpenId(instance.getUserWxOpenId());
        }
        if (conditionField.contains(ModelBUser.FI_USER_PUSH_TOKEN)) {
            checkInstance.setUserPushToken(instance.getUserPushToken());
        }
        if (conditionField.contains(ModelBUser.FI_USER_DELETE_FLAG)) {
            checkInstance.setUserDeleteFlag(instance.getUserDeleteFlag());
        }
        if (conditionField.contains(ModelBUser.FI_USER_TYPE)) {
            checkInstance.setUserType(instance.getUserType());
        }
        if (conditionField.contains(ModelBUser.FI_USER_PROVIDER)) {
            checkInstance.setUserProvider(instance.getUserProvider());
        }
        ModelBUser selected = getOneByCond(Collections.singleton(ModelBUser.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelBUser.FI_ID), assembler);
            return instance;
        }
    }

    public ModelBUser updateOrInsert(ModelBUser instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelBUser insertIfNoExist(ModelBUser instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelBUser checkInstance = new ModelBUser();
        if (conditionField.contains(ModelBUser.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelBUser.FI_USER_NAME)) {
            checkInstance.setUserName(instance.getUserName());
        }
        if (conditionField.contains(ModelBUser.FI_USER_SHOW_NAME)) {
            checkInstance.setUserShowName(instance.getUserShowName());
        }
        if (conditionField.contains(ModelBUser.FI_USER_PWD)) {
            checkInstance.setUserPwd(instance.getUserPwd());
        }
        if (conditionField.contains(ModelBUser.FI_USER_MOBILE)) {
            checkInstance.setUserMobile(instance.getUserMobile());
        }
        if (conditionField.contains(ModelBUser.FI_USER_CREATE_TIME)) {
            checkInstance.setUserCreateTime(instance.getUserCreateTime());
        }
        if (conditionField.contains(ModelBUser.FI_USER_SALT)) {
            checkInstance.setUserSalt(instance.getUserSalt());
        }
        if (conditionField.contains(ModelBUser.FI_USER_WX)) {
            checkInstance.setUserWx(instance.getUserWx());
        }
        if (conditionField.contains(ModelBUser.FI_USER_EMAIL)) {
            checkInstance.setUserEmail(instance.getUserEmail());
        }
        if (conditionField.contains(ModelBUser.FI_USER_MODIFY_TIME)) {
            checkInstance.setUserModifyTime(instance.getUserModifyTime());
        }
        if (conditionField.contains(ModelBUser.FI_USER_IMAGE)) {
            checkInstance.setUserImage(instance.getUserImage());
        }
        if (conditionField.contains(ModelBUser.FI_USER_AVATAR)) {
            checkInstance.setUserAvatar(instance.getUserAvatar());
        }
        if (conditionField.contains(ModelBUser.FI_USER_STATUS)) {
            checkInstance.setUserStatus(instance.getUserStatus());
        }
        if (conditionField.contains(ModelBUser.FI_USER_WX_OPEN_ID)) {
            checkInstance.setUserWxOpenId(instance.getUserWxOpenId());
        }
        if (conditionField.contains(ModelBUser.FI_USER_PUSH_TOKEN)) {
            checkInstance.setUserPushToken(instance.getUserPushToken());
        }
        if (conditionField.contains(ModelBUser.FI_USER_DELETE_FLAG)) {
            checkInstance.setUserDeleteFlag(instance.getUserDeleteFlag());
        }
        if (conditionField.contains(ModelBUser.FI_USER_TYPE)) {
            checkInstance.setUserType(instance.getUserType());
        }
        if (conditionField.contains(ModelBUser.FI_USER_PROVIDER)) {
            checkInstance.setUserProvider(instance.getUserProvider());
        }
        ModelBUser selected = getOneByCond(Collections.singleton(ModelBUser.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelBUser insertIfNoExist(ModelBUser instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelBUser> buildMap(List<ModelBUser> list, String field) {
        Map<TT, ModelBUser> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBUser item: list) {
            ret.put(Constants.B_USER_MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelBUser>> buildListMap(List<ModelBUser> list, String field) {
        Map<TT, List<ModelBUser>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelBUser item: list) {
            List<ModelBUser> itemList = ret.get(Constants.B_USER_MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(Constants.B_USER_MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelBUser> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelBUser.FIELD_CLASS.containsKey(field)) {
            for (ModelBUser item: list) {
                ret.add(Constants.B_USER_MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
