package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem.ResultSetMapperModelWikiStructureInfoKeyItem;
import com.shangde.ent_portal.logical.dto.enums.EnumItemType;
import com.shangde.ent_portal.logical.dto.enums.EnumItemValueType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem;

@Repository("DAOWikiStructureInfoKeyItem")
@SuppressWarnings("unchecked")
public class DAOWikiStructureInfoKeyItem
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOWikiStructureInfoKeyItem.class);
    @Autowired(required = true)
    @Qualifier("wiki_master")
    protected SimpleDbInterface data_store;

    public DAOWikiStructureInfoKeyItem() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem.class);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected<TT> TT getSingleResult(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        return super.getSingleResult(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected<TT> List<TT> getSingleResults(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        return super.getSingleResults(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected List<ModelWikiStructureInfoKeyItem> getResults(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiStructureInfoKeyItem.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> rsMapper = ModelWikiStructureInfoKeyItem.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> rsMapperTmp = ((ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> ) assembler.<ModelWikiStructureInfoKeyItem> assembleResultSetMapper(param, ModelWikiStructureInfoKeyItem.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResults(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected ModelWikiStructureInfoKeyItem getResult(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiStructureInfoKeyItem.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> rsMapper = ModelWikiStructureInfoKeyItem.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> rsMapperTmp = ((ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> ) assembler.<ModelWikiStructureInfoKeyItem> assembleResultSetMapper(param, ModelWikiStructureInfoKeyItem.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResult(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelWikiStructureInfoKeyItem.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelWikiStructureInfoKeyItem.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelWikiStructureInfoKeyItem instance, Map<String, Object> param) {
        Integer dItemId = instance.getItemId();
        if (dItemId!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMID, dItemId);
        }
        String dItemName = instance.getItemName();
        if (dItemName!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, ColumnDataType.stringData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, dItemName);
        }
        EnumItemType dItemType = instance.getItemType();
        if (dItemType!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, ColumnDataType.byteData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, dItemType.val);
        }
        EnumItemValueType dItemValueType = instance.getItemValueType();
        if (dItemValueType!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, ColumnDataType.byteData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, dItemValueType.val);
        }
        String dItemLabel = instance.getItemLabel();
        if (dItemLabel!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, ColumnDataType.stringData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, dItemLabel);
        }
        Byte dItemReadOnly = instance.getItemReadOnly();
        if (dItemReadOnly!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, ColumnDataType.byteData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, dItemReadOnly);
        }
        String dItemObtainMethod = instance.getItemObtainMethod();
        if (dItemObtainMethod!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, ColumnDataType.stringData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, dItemObtainMethod);
        }
        String dItemDeleteFlag = instance.getItemDeleteFlag();
        if (dItemDeleteFlag!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, ColumnDataType.stringData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, dItemDeleteFlag);
        }
        Integer dItemBelongCollection = instance.getItemBelongCollection();
        if (dItemBelongCollection!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, ColumnDataType.intData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, dItemBelongCollection);
        }
        String dItemDesp = instance.getItemDesp();
        if (dItemDesp!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, ColumnDataType.stringData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, dItemDesp);
        }
        Byte dItemSequence = instance.getItemSequence();
        if (dItemSequence!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, ColumnDataType.byteData);
            param.put(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, dItemSequence);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMID);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
        }
        if (selectFields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
        }
    }

    public List<ModelWikiStructureInfoKeyItem> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelWikiStructureInfoKeyItem> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelWikiStructureInfoKeyItem> get() {
        return get(null, null);
    }

    public List<ModelWikiStructureInfoKeyItem> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> itemId) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        if (itemId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiStructureInfoKeyItem.FI_ITEMID, ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiStructureInfoKeyItem> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> itemId) {
        return getById(selectFields, null, start, count, itemId);
    }

    public List<ModelWikiStructureInfoKeyItem> getById(Integer start, Integer count, List<Integer> itemId) {
        return getById(null, start, count, itemId);
    }

    public List<ModelWikiStructureInfoKeyItem> getById(List<Integer> itemId) {
        return getById(null, null, itemId);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByCond(Set<String> selectFields, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCond(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCond(ModelWikiStructureInfoKeyItem instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelWikiStructureInfoKeyItem> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndex(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndex(ModelWikiStructureInfoKeyItem instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        if (itemId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiStructureInfoKeyItem.FI_ITEMID, ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, itemId, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndWhere(Integer start, Integer count, Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, itemId, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndWhere(Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, itemId, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        if (itemId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiStructureInfoKeyItem.FI_ITEMID, ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, itemId, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndCondAndWhere(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, itemId, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIdAndCondAndWhere(ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, itemId, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndWhere(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndWhere(ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem getOneById(Set<String> selectFields, DaoAssembler assembler, Integer itemId) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (itemId!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiStructureInfoKeyItem getOneById(Set<String> selectFields, Integer itemId) {
        return getOneById(selectFields, null, itemId);
    }

    public ModelWikiStructureInfoKeyItem getOneById(Integer itemId) {
        return getOneById(null, itemId);
    }

    public ModelWikiStructureInfoKeyItem getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public ModelWikiStructureInfoKeyItem getOneByCond(Set<String> selectFields, ModelWikiStructureInfoKeyItem instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelWikiStructureInfoKeyItem getOneByCond(ModelWikiStructureInfoKeyItem instance) {
        return getOneByCond(null, instance);
    }

    public ModelWikiStructureInfoKeyItem getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public ModelWikiStructureInfoKeyItem getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public ModelWikiStructureInfoKeyItem getOneByCondAndWhere(Set<String> selectFields, ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem getOneByCondAndWhere(ModelWikiStructureInfoKeyItem instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (itemId!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiStructureInfoKeyItem getOneByIdAndCondAndWhere(Set<String> selectFields, ModelWikiStructureInfoKeyItem instance, Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, itemId, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem getOneByIdAndCondAndWhere(ModelWikiStructureInfoKeyItem instance, Integer itemId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, itemId, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelWikiStructureInfoKeyItem instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelWikiStructureInfoKeyItem instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
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
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer itemId, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        if (itemId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiStructureInfoKeyItem.FI_ITEMID, ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer itemId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, itemId, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer itemId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, itemId, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
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
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelWikiStructureInfoKeyItem instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelWikiStructureInfoKeyItem instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
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
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawSelectItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (itemId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiStructureInfoKeyItem.FI_ITEMID, ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, itemId, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelWikiStructureInfoKeyItem instance, List<Integer> itemId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, itemId, tClass, rawItem, extParam, extCondition);
    }

    public ModelWikiStructureInfoKeyItem insert(ModelWikiStructureInfoKeyItem instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer dItemId = instance.getItemId();
        if (dItemId!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMID);
        }
        String dItemName = instance.getItemName();
        if (dItemName!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
        }
        EnumItemType dItemType = instance.getItemType();
        if (dItemType!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
        }
        EnumItemValueType dItemValueType = instance.getItemValueType();
        if (dItemValueType!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
        }
        String dItemLabel = instance.getItemLabel();
        if (dItemLabel!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
        }
        Byte dItemReadOnly = instance.getItemReadOnly();
        if (dItemReadOnly!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
        }
        String dItemObtainMethod = instance.getItemObtainMethod();
        if (dItemObtainMethod!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
        }
        String dItemDeleteFlag = instance.getItemDeleteFlag();
        if (dItemDeleteFlag!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
        }
        Integer dItemBelongCollection = instance.getItemBelongCollection();
        if (dItemBelongCollection!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
        }
        String dItemDesp = instance.getItemDesp();
        if (dItemDesp!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
        }
        Byte dItemSequence = instance.getItemSequence();
        if (dItemSequence!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
        }
        Map<String, Object> param = ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setItemId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelWikiStructureInfoKeyItem insert(ModelWikiStructureInfoKeyItem instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelWikiStructureInfoKeyItem> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelWikiStructureInfoKeyItem.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMID);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
        }
        if (fields.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelWikiStructureInfoKeyItem instance: instances) {
            Map<String, Object> paramMap = ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelWikiStructureInfoKeyItem> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelWikiStructureInfoKeyItem> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer dItemId = instance.getItemId();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
            assert((dItemId!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        } else {
            if (dItemId!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMID);
            }
        }
        String dItemName = instance.getItemName();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
            assert((dItemName!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, ColumnDataType.stringData);
        } else {
            if (dItemName!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
            }
        }
        EnumItemType dItemType = instance.getItemType();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
            assert((dItemType!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, ColumnDataType.byteData);
        } else {
            if (dItemType!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
            }
        }
        EnumItemValueType dItemValueType = instance.getItemValueType();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
            assert((dItemValueType!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, ColumnDataType.byteData);
        } else {
            if (dItemValueType!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
            }
        }
        String dItemLabel = instance.getItemLabel();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
            assert((dItemLabel!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, ColumnDataType.stringData);
        } else {
            if (dItemLabel!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
            }
        }
        Byte dItemReadOnly = instance.getItemReadOnly();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
            assert((dItemReadOnly!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, ColumnDataType.byteData);
        } else {
            if (dItemReadOnly!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
            }
        }
        String dItemObtainMethod = instance.getItemObtainMethod();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
            assert((dItemObtainMethod!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, ColumnDataType.stringData);
        } else {
            if (dItemObtainMethod!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
            }
        }
        String dItemDeleteFlag = instance.getItemDeleteFlag();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
            assert((dItemDeleteFlag!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, ColumnDataType.stringData);
        } else {
            if (dItemDeleteFlag!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
            }
        }
        Integer dItemBelongCollection = instance.getItemBelongCollection();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
            assert((dItemBelongCollection!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, ColumnDataType.intData);
        } else {
            if (dItemBelongCollection!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
            }
        }
        String dItemDesp = instance.getItemDesp();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
            assert((dItemDesp!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, ColumnDataType.stringData);
        } else {
            if (dItemDesp!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
            }
        }
        Byte dItemSequence = instance.getItemSequence();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
            assert((dItemSequence!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, ColumnDataType.byteData);
        } else {
            if (dItemSequence!= null) {
                sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
            }
        }
        Map<String, Object> param = ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelWikiStructureInfoKeyItem instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        assert((instance.getItemId()!= null));
        Integer dItemId = instance.getItemId();
        if (dItemId!= null) {
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        String dItemName = instance.getItemName();
        if (dItemName!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
        }
        EnumItemType dItemType = instance.getItemType();
        if (dItemType!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
        }
        EnumItemValueType dItemValueType = instance.getItemValueType();
        if (dItemValueType!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
        }
        String dItemLabel = instance.getItemLabel();
        if (dItemLabel!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
        }
        Byte dItemReadOnly = instance.getItemReadOnly();
        if (dItemReadOnly!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
        }
        String dItemObtainMethod = instance.getItemObtainMethod();
        if (dItemObtainMethod!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
        }
        String dItemDeleteFlag = instance.getItemDeleteFlag();
        if (dItemDeleteFlag!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
        }
        Integer dItemBelongCollection = instance.getItemBelongCollection();
        if (dItemBelongCollection!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
        }
        String dItemDesp = instance.getItemDesp();
        if (dItemDesp!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
        }
        Byte dItemSequence = instance.getItemSequence();
        if (dItemSequence!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
        }
        Map<String, Object> param = ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelWikiStructureInfoKeyItem instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelWikiStructureInfoKeyItem instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, ModelWikiStructureInfoKeyItem.FI_ITEMID, "ids", ColumnDataType.intData);
        instance.setItemId(null);
        String dItemName = instance.getItemName();
        if (dItemName!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
        }
        EnumItemType dItemType = instance.getItemType();
        if (dItemType!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
        }
        EnumItemValueType dItemValueType = instance.getItemValueType();
        if (dItemValueType!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
        }
        String dItemLabel = instance.getItemLabel();
        if (dItemLabel!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
        }
        Byte dItemReadOnly = instance.getItemReadOnly();
        if (dItemReadOnly!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
        }
        String dItemObtainMethod = instance.getItemObtainMethod();
        if (dItemObtainMethod!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
        }
        String dItemDeleteFlag = instance.getItemDeleteFlag();
        if (dItemDeleteFlag!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
        }
        Integer dItemBelongCollection = instance.getItemBelongCollection();
        if (dItemBelongCollection!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
        }
        String dItemDesp = instance.getItemDesp();
        if (dItemDesp!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
        }
        Byte dItemSequence = instance.getItemSequence();
        if (dItemSequence!= null) {
            sqlBuilder.itemCol(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
        }
        Map<String, Object> param = ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelWikiStructureInfoKeyItem instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        Integer dItemId = instance.getItemId();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
            assert((dItemId!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMID, ColumnDataType.intData);
        }
        String dItemName = instance.getItemName();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
            assert((dItemName!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, ColumnDataType.stringData);
        }
        EnumItemType dItemType = instance.getItemType();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
            assert((dItemType!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, ColumnDataType.byteData);
        }
        EnumItemValueType dItemValueType = instance.getItemValueType();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
            assert((dItemValueType!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, ColumnDataType.byteData);
        }
        String dItemLabel = instance.getItemLabel();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
            assert((dItemLabel!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, ColumnDataType.stringData);
        }
        Byte dItemReadOnly = instance.getItemReadOnly();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
            assert((dItemReadOnly!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, ColumnDataType.byteData);
        }
        String dItemObtainMethod = instance.getItemObtainMethod();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
            assert((dItemObtainMethod!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, ColumnDataType.stringData);
        }
        String dItemDeleteFlag = instance.getItemDeleteFlag();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
            assert((dItemDeleteFlag!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, ColumnDataType.stringData);
        }
        Integer dItemBelongCollection = instance.getItemBelongCollection();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
            assert((dItemBelongCollection!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, ColumnDataType.intData);
        }
        String dItemDesp = instance.getItemDesp();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
            assert((dItemDesp!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, ColumnDataType.stringData);
        }
        Byte dItemSequence = instance.getItemSequence();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
            assert((dItemSequence!= null));
            sqlBuilder.itemWhere(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, ColumnDataType.byteData);
        }
        Map<String, Object> param = ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        assert((id!= null));
        Map<String, Object> param = Collections.singletonMap("id", id);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiStructureInfoKeyItem.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelWikiStructureInfoKeyItem updateOrInsert(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiStructureInfoKeyItem checkInstance = new ModelWikiStructureInfoKeyItem();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
            checkInstance.setItemId(instance.getItemId());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
            checkInstance.setItemName(instance.getItemName());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
            checkInstance.setItemType(instance.getItemType());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
            checkInstance.setItemValueType(instance.getItemValueType());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
            checkInstance.setItemLabel(instance.getItemLabel());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
            checkInstance.setItemReadOnly(instance.getItemReadOnly());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
            checkInstance.setItemObtainMethod(instance.getItemObtainMethod());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
            checkInstance.setItemDeleteFlag(instance.getItemDeleteFlag());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
            checkInstance.setItemBelongCollection(instance.getItemBelongCollection());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
            checkInstance.setItemDesp(instance.getItemDesp());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
            checkInstance.setItemSequence(instance.getItemSequence());
        }
        ModelWikiStructureInfoKeyItem selected = getOneByCond(Collections.singleton(ModelWikiStructureInfoKeyItem.FI_ITEMID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setItemId(selected.getItemId());
            update(instance, Collections.singleton(ModelWikiStructureInfoKeyItem.FI_ITEMID), assembler);
            return instance;
        }
    }

    public ModelWikiStructureInfoKeyItem updateOrInsert(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelWikiStructureInfoKeyItem insertIfNoExist(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiStructureInfoKeyItem checkInstance = new ModelWikiStructureInfoKeyItem();
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
            checkInstance.setItemId(instance.getItemId());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
            checkInstance.setItemName(instance.getItemName());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
            checkInstance.setItemType(instance.getItemType());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
            checkInstance.setItemValueType(instance.getItemValueType());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
            checkInstance.setItemLabel(instance.getItemLabel());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
            checkInstance.setItemReadOnly(instance.getItemReadOnly());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
            checkInstance.setItemObtainMethod(instance.getItemObtainMethod());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
            checkInstance.setItemDeleteFlag(instance.getItemDeleteFlag());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
            checkInstance.setItemBelongCollection(instance.getItemBelongCollection());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
            checkInstance.setItemDesp(instance.getItemDesp());
        }
        if (conditionField.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
            checkInstance.setItemSequence(instance.getItemSequence());
        }
        ModelWikiStructureInfoKeyItem selected = getOneByCond(Collections.singleton(ModelWikiStructureInfoKeyItem.FI_ITEMID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setItemId(selected.getItemId());
            return instance;
        }
    }

    public ModelWikiStructureInfoKeyItem insertIfNoExist(ModelWikiStructureInfoKeyItem instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelWikiStructureInfoKeyItem> buildMap(List<ModelWikiStructureInfoKeyItem> list, String field) {
        Map<TT, ModelWikiStructureInfoKeyItem> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiStructureInfoKeyItem item: list) {
            ret.put(ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelWikiStructureInfoKeyItem>> buildListMap(List<ModelWikiStructureInfoKeyItem> list, String field) {
        Map<TT, List<ModelWikiStructureInfoKeyItem>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiStructureInfoKeyItem item: list) {
            List<ModelWikiStructureInfoKeyItem> itemList = ret.get(ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelWikiStructureInfoKeyItem> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelWikiStructureInfoKeyItem.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiStructureInfoKeyItem item: list) {
                ret.add(ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
