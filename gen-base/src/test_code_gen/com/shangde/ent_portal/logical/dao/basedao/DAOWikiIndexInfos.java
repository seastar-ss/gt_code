package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos.ResultSetMapperModelWikiIndexInfos;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos;

@Repository("DAOWikiIndexInfos")
@SuppressWarnings("unchecked")
public class DAOWikiIndexInfos
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOWikiIndexInfos.class);
    @Autowired(required = true)
    @Qualifier("wiki_master")
    protected SimpleDbInterface data_store;

    public DAOWikiIndexInfos() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos.class);
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

    protected List<ModelWikiIndexInfos> getResults(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiIndexInfos.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> rsMapper = ModelWikiIndexInfos.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> rsMapperTmp = ((ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> ) assembler.<ModelWikiIndexInfos> assembleResultSetMapper(param, ModelWikiIndexInfos.class));
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

    protected ModelWikiIndexInfos getResult(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiIndexInfos.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> rsMapper = ModelWikiIndexInfos.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> rsMapperTmp = ((ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> ) assembler.<ModelWikiIndexInfos> assembleResultSetMapper(param, ModelWikiIndexInfos.class));
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
        if (ModelWikiIndexInfos.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelWikiIndexInfos.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelWikiIndexInfos instance, Map<String, Object> param) {
        Integer dCmsIndexInfoId = instance.getCmsIndexInfoId();
        if (dCmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, dCmsIndexInfoId);
        }
        Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
        if (dCmsIndexInfoState!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, ColumnDataType.byteData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, dCmsIndexInfoState);
        }
        Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
        if (dCmsInfoCreateTime!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, ColumnDataType.timeStampData);
            param.put(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, dCmsInfoCreateTime);
        }
        String dCmsInfoKey = instance.getCmsInfoKey();
        if (dCmsInfoKey!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOKEY, ColumnDataType.stringData);
            param.put(ModelWikiIndexInfos.FI_CMSINFOKEY, dCmsInfoKey);
        }
        String dCmsInfoValue = instance.getCmsInfoValue();
        if (dCmsInfoValue!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOVALUE, ColumnDataType.stringData);
            param.put(ModelWikiIndexInfos.FI_CMSINFOVALUE, dCmsInfoValue);
        }
        String dCmsInfoName = instance.getCmsInfoName();
        if (dCmsInfoName!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFONAME, ColumnDataType.stringData);
            param.put(ModelWikiIndexInfos.FI_CMSINFONAME, dCmsInfoName);
        }
        String dCmdInfoAspect = instance.getCmdInfoAspect();
        if (dCmdInfoAspect!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMDINFOASPECT, ColumnDataType.stringData);
            param.put(ModelWikiIndexInfos.FI_CMDINFOASPECT, dCmdInfoAspect);
        }
        String dCmsInfoDesc = instance.getCmsInfoDesc();
        if (dCmsInfoDesc!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFODESC, ColumnDataType.stringData);
            param.put(ModelWikiIndexInfos.FI_CMSINFODESC, dCmsInfoDesc);
        }
        Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
        if (dCmsInfoOfIndexId!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, dCmsInfoOfIndexId);
        }
        Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
        if (dCmsInfoOfIndexParent!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, dCmsInfoOfIndexParent);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOID);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOKEY);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOVALUE);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFONAME);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMDINFOASPECT);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFODESC);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
        }
        if (selectFields.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
        }
    }

    public List<ModelWikiIndexInfos> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelWikiIndexInfos> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelWikiIndexInfos> get() {
        return get(null, null);
    }

    public List<ModelWikiIndexInfos> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> cmsIndexInfoId) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndexInfos> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> cmsIndexInfoId) {
        return getById(selectFields, null, start, count, cmsIndexInfoId);
    }

    public List<ModelWikiIndexInfos> getById(Integer start, Integer count, List<Integer> cmsIndexInfoId) {
        return getById(null, start, count, cmsIndexInfoId);
    }

    public List<ModelWikiIndexInfos> getById(List<Integer> cmsIndexInfoId) {
        return getById(null, null, cmsIndexInfoId);
    }

    public List<ModelWikiIndexInfos> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelWikiIndexInfos> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelWikiIndexInfos> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelWikiIndexInfos> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByCond(Set<String> selectFields, Integer start, Integer count, ModelWikiIndexInfos instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelWikiIndexInfos> getByCond(Integer start, Integer count, ModelWikiIndexInfos instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelWikiIndexInfos> getByCond(ModelWikiIndexInfos instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelWikiIndexInfos> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiIndexInfos> getByCondAndIndex(Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiIndexInfos> getByCondAndIndex(ModelWikiIndexInfos instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelWikiIndexInfos> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndexInfos> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, cmsIndexInfoId, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIdAndWhere(Integer start, Integer count, Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, cmsIndexInfoId, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIdAndWhere(Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, cmsIndexInfoId, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndexInfos> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, cmsIndexInfoId, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIdAndCondAndWhere(Integer start, Integer count, ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, cmsIndexInfoId, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIdAndCondAndWhere(ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, cmsIndexInfoId, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndWhere(Integer start, Integer count, ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndWhere(ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public List<ModelWikiIndexInfos> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndIndexAndWhere(Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexInfos> getByCondAndIndexAndWhere(ModelWikiIndexInfos instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelWikiIndexInfos getOneById(Set<String> selectFields, DaoAssembler assembler, Integer cmsIndexInfoId) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndexInfos getOneById(Set<String> selectFields, Integer cmsIndexInfoId) {
        return getOneById(selectFields, null, cmsIndexInfoId);
    }

    public ModelWikiIndexInfos getOneById(Integer cmsIndexInfoId) {
        return getOneById(null, cmsIndexInfoId);
    }

    public ModelWikiIndexInfos getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndexInfos instance) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public ModelWikiIndexInfos getOneByCond(Set<String> selectFields, ModelWikiIndexInfos instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelWikiIndexInfos getOneByCond(ModelWikiIndexInfos instance) {
        return getOneByCond(null, instance);
    }

    public ModelWikiIndexInfos getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public ModelWikiIndexInfos getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelWikiIndexInfos getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelWikiIndexInfos getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public ModelWikiIndexInfos getOneByCondAndWhere(Set<String> selectFields, ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelWikiIndexInfos getOneByCondAndWhere(ModelWikiIndexInfos instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelWikiIndexInfos getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndexInfos instance, Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndexInfos getOneByIdAndCondAndWhere(Set<String> selectFields, ModelWikiIndexInfos instance, Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, cmsIndexInfoId, extParam, extCondition);
    }

    public ModelWikiIndexInfos getOneByIdAndCondAndWhere(ModelWikiIndexInfos instance, Integer cmsIndexInfoId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, cmsIndexInfoId, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelWikiIndexInfos instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelWikiIndexInfos instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelWikiIndexInfos instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelWikiIndexInfos instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiIndexInfos instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelWikiIndexInfos instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer cmsIndexInfoId, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer cmsIndexInfoId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, cmsIndexInfoId, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer cmsIndexInfoId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, cmsIndexInfoId, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelWikiIndexInfos instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelWikiIndexInfos instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        if (cmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
            param.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, cmsIndexInfoId);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, cmsIndexInfoId, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelWikiIndexInfos instance, List<Integer> cmsIndexInfoId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, cmsIndexInfoId, tClass, rawItem, extParam, extCondition);
    }

    public ModelWikiIndexInfos insert(ModelWikiIndexInfos instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        Integer dCmsIndexInfoId = instance.getCmsIndexInfoId();
        if (dCmsIndexInfoId!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOID);
        }
        Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
        if (dCmsIndexInfoState!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
        }
        Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
        if (dCmsInfoCreateTime!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
        }
        String dCmsInfoKey = instance.getCmsInfoKey();
        if (dCmsInfoKey!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOKEY);
        }
        String dCmsInfoValue = instance.getCmsInfoValue();
        if (dCmsInfoValue!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOVALUE);
        }
        String dCmsInfoName = instance.getCmsInfoName();
        if (dCmsInfoName!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFONAME);
        }
        String dCmdInfoAspect = instance.getCmdInfoAspect();
        if (dCmdInfoAspect!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMDINFOASPECT);
        }
        String dCmsInfoDesc = instance.getCmsInfoDesc();
        if (dCmsInfoDesc!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFODESC);
        }
        Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
        if (dCmsInfoOfIndexId!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
        }
        Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
        if (dCmsInfoOfIndexParent!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
        }
        Map<String, Object> param = ModelWikiIndexInfos.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setCmsIndexInfoId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelWikiIndexInfos insert(ModelWikiIndexInfos instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelWikiIndexInfos> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelWikiIndexInfos.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOID);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOKEY);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOVALUE);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFONAME);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMDINFOASPECT);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFODESC);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
        }
        if (fields.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelWikiIndexInfos instance: instances) {
            Map<String, Object> paramMap = ModelWikiIndexInfos.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelWikiIndexInfos> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelWikiIndexInfos> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelWikiIndexInfos instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        Integer dCmsIndexInfoId = instance.getCmsIndexInfoId();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
            assert((dCmsIndexInfoId!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
        } else {
            if (dCmsIndexInfoId!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOID);
            }
        }
        Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
            assert((dCmsIndexInfoState!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, ColumnDataType.byteData);
        } else {
            if (dCmsIndexInfoState!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
            }
        }
        Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
            assert((dCmsInfoCreateTime!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, ColumnDataType.timeStampData);
        } else {
            if (dCmsInfoCreateTime!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
            }
        }
        String dCmsInfoKey = instance.getCmsInfoKey();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
            assert((dCmsInfoKey!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOKEY, ColumnDataType.stringData);
        } else {
            if (dCmsInfoKey!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOKEY);
            }
        }
        String dCmsInfoValue = instance.getCmsInfoValue();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
            assert((dCmsInfoValue!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOVALUE, ColumnDataType.stringData);
        } else {
            if (dCmsInfoValue!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOVALUE);
            }
        }
        String dCmsInfoName = instance.getCmsInfoName();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
            assert((dCmsInfoName!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFONAME, ColumnDataType.stringData);
        } else {
            if (dCmsInfoName!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFONAME);
            }
        }
        String dCmdInfoAspect = instance.getCmdInfoAspect();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
            assert((dCmdInfoAspect!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMDINFOASPECT, ColumnDataType.stringData);
        } else {
            if (dCmdInfoAspect!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMDINFOASPECT);
            }
        }
        String dCmsInfoDesc = instance.getCmsInfoDesc();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
            assert((dCmsInfoDesc!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFODESC, ColumnDataType.stringData);
        } else {
            if (dCmsInfoDesc!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFODESC);
            }
        }
        Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
            assert((dCmsInfoOfIndexId!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, ColumnDataType.intData);
        } else {
            if (dCmsInfoOfIndexId!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
            }
        }
        Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
            assert((dCmsInfoOfIndexParent!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, ColumnDataType.intData);
        } else {
            if (dCmsInfoOfIndexParent!= null) {
                sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
            }
        }
        Map<String, Object> param = ModelWikiIndexInfos.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelWikiIndexInfos instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelWikiIndexInfos instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        assert((instance.getCmsIndexInfoId()!= null));
        Integer dCmsIndexInfoId = instance.getCmsIndexInfoId();
        if (dCmsIndexInfoId!= null) {
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
        }
        Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
        if (dCmsIndexInfoState!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
        }
        Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
        if (dCmsInfoCreateTime!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
        }
        String dCmsInfoKey = instance.getCmsInfoKey();
        if (dCmsInfoKey!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOKEY);
        }
        String dCmsInfoValue = instance.getCmsInfoValue();
        if (dCmsInfoValue!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOVALUE);
        }
        String dCmsInfoName = instance.getCmsInfoName();
        if (dCmsInfoName!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFONAME);
        }
        String dCmdInfoAspect = instance.getCmdInfoAspect();
        if (dCmdInfoAspect!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMDINFOASPECT);
        }
        String dCmsInfoDesc = instance.getCmsInfoDesc();
        if (dCmsInfoDesc!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFODESC);
        }
        Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
        if (dCmsInfoOfIndexId!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
        }
        Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
        if (dCmsInfoOfIndexParent!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
        }
        Map<String, Object> param = ModelWikiIndexInfos.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelWikiIndexInfos instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelWikiIndexInfos instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, ModelWikiIndexInfos.FI_CMSINDEXINFOID, "ids", ColumnDataType.intData);
        instance.setCmsIndexInfoId(null);
        Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
        if (dCmsIndexInfoState!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
        }
        Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
        if (dCmsInfoCreateTime!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
        }
        String dCmsInfoKey = instance.getCmsInfoKey();
        if (dCmsInfoKey!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOKEY);
        }
        String dCmsInfoValue = instance.getCmsInfoValue();
        if (dCmsInfoValue!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOVALUE);
        }
        String dCmsInfoName = instance.getCmsInfoName();
        if (dCmsInfoName!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFONAME);
        }
        String dCmdInfoAspect = instance.getCmdInfoAspect();
        if (dCmdInfoAspect!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMDINFOASPECT);
        }
        String dCmsInfoDesc = instance.getCmsInfoDesc();
        if (dCmsInfoDesc!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFODESC);
        }
        Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
        if (dCmsInfoOfIndexId!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
        }
        Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
        if (dCmsInfoOfIndexParent!= null) {
            sqlBuilder.itemCol(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
        }
        Map<String, Object> param = ModelWikiIndexInfos.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelWikiIndexInfos instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelWikiIndexInfos instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        Integer dCmsIndexInfoId = instance.getCmsIndexInfoId();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
            assert((dCmsIndexInfoId!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ColumnDataType.intData);
        }
        Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
            assert((dCmsIndexInfoState!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, ColumnDataType.byteData);
        }
        Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
            assert((dCmsInfoCreateTime!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, ColumnDataType.timeStampData);
        }
        String dCmsInfoKey = instance.getCmsInfoKey();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
            assert((dCmsInfoKey!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOKEY, ColumnDataType.stringData);
        }
        String dCmsInfoValue = instance.getCmsInfoValue();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
            assert((dCmsInfoValue!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOVALUE, ColumnDataType.stringData);
        }
        String dCmsInfoName = instance.getCmsInfoName();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
            assert((dCmsInfoName!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFONAME, ColumnDataType.stringData);
        }
        String dCmdInfoAspect = instance.getCmdInfoAspect();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
            assert((dCmdInfoAspect!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMDINFOASPECT, ColumnDataType.stringData);
        }
        String dCmsInfoDesc = instance.getCmsInfoDesc();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
            assert((dCmsInfoDesc!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFODESC, ColumnDataType.stringData);
        }
        Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
            assert((dCmsInfoOfIndexId!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, ColumnDataType.intData);
        }
        Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
            assert((dCmsInfoOfIndexParent!= null));
            sqlBuilder.itemWhere(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, ColumnDataType.intData);
        }
        Map<String, Object> param = ModelWikiIndexInfos.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelWikiIndexInfos instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelWikiIndexInfos.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelWikiIndexInfos updateOrInsert(ModelWikiIndexInfos instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiIndexInfos checkInstance = new ModelWikiIndexInfos();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
            checkInstance.setCmsIndexInfoId(instance.getCmsIndexInfoId());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
            checkInstance.setCmsIndexInfoState(instance.getCmsIndexInfoState());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
            checkInstance.setCmsInfoCreateTime(instance.getCmsInfoCreateTime());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
            checkInstance.setCmsInfoKey(instance.getCmsInfoKey());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
            checkInstance.setCmsInfoValue(instance.getCmsInfoValue());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
            checkInstance.setCmsInfoName(instance.getCmsInfoName());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
            checkInstance.setCmdInfoAspect(instance.getCmdInfoAspect());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
            checkInstance.setCmsInfoDesc(instance.getCmsInfoDesc());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
            checkInstance.setCmsInfoOfIndexId(instance.getCmsInfoOfIndexId());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
            checkInstance.setCmsInfoOfIndexParent(instance.getCmsInfoOfIndexParent());
        }
        ModelWikiIndexInfos selected = getOneByCond(Collections.singleton(ModelWikiIndexInfos.FI_CMSINDEXINFOID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setCmsIndexInfoId(selected.getCmsIndexInfoId());
            update(instance, Collections.singleton(ModelWikiIndexInfos.FI_CMSINDEXINFOID), assembler);
            return instance;
        }
    }

    public ModelWikiIndexInfos updateOrInsert(ModelWikiIndexInfos instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelWikiIndexInfos insertIfNoExist(ModelWikiIndexInfos instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiIndexInfos checkInstance = new ModelWikiIndexInfos();
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
            checkInstance.setCmsIndexInfoId(instance.getCmsIndexInfoId());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
            checkInstance.setCmsIndexInfoState(instance.getCmsIndexInfoState());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
            checkInstance.setCmsInfoCreateTime(instance.getCmsInfoCreateTime());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
            checkInstance.setCmsInfoKey(instance.getCmsInfoKey());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
            checkInstance.setCmsInfoValue(instance.getCmsInfoValue());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
            checkInstance.setCmsInfoName(instance.getCmsInfoName());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
            checkInstance.setCmdInfoAspect(instance.getCmdInfoAspect());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
            checkInstance.setCmsInfoDesc(instance.getCmsInfoDesc());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
            checkInstance.setCmsInfoOfIndexId(instance.getCmsInfoOfIndexId());
        }
        if (conditionField.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
            checkInstance.setCmsInfoOfIndexParent(instance.getCmsInfoOfIndexParent());
        }
        ModelWikiIndexInfos selected = getOneByCond(Collections.singleton(ModelWikiIndexInfos.FI_CMSINDEXINFOID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setCmsIndexInfoId(selected.getCmsIndexInfoId());
            return instance;
        }
    }

    public ModelWikiIndexInfos insertIfNoExist(ModelWikiIndexInfos instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelWikiIndexInfos> buildMap(List<ModelWikiIndexInfos> list, String field) {
        Map<TT, ModelWikiIndexInfos> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiIndexInfos item: list) {
            ret.put(ModelWikiIndexInfos.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelWikiIndexInfos>> buildListMap(List<ModelWikiIndexInfos> list, String field) {
        Map<TT, List<ModelWikiIndexInfos>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiIndexInfos item: list) {
            List<ModelWikiIndexInfos> itemList = ret.get(ModelWikiIndexInfos.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelWikiIndexInfos.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelWikiIndexInfos> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelWikiIndexInfos.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiIndexInfos item: list) {
                ret.add(ModelWikiIndexInfos.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
