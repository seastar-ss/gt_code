package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage.ResultSetMapperModelWikiPage;
import com.shangde.ent_portal.logical.dto.enums.EnumPageType;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage;

@Repository("DAOWikiPage")
@SuppressWarnings("unchecked")
public class DAOWikiPage
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOWikiPage.class);
    @Autowired(required = true)
    @Qualifier("wiki_master")
    protected SimpleDbInterface data_store;

    public DAOWikiPage() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage.class);
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

    protected List<ModelWikiPage> getResults(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiPage.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiPage<ModelWikiPage> rsMapper = ModelWikiPage.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiPage<ModelWikiPage> rsMapperTmp = ((ResultSetMapperModelWikiPage<ModelWikiPage> ) assembler.<ModelWikiPage> assembleResultSetMapper(param, ModelWikiPage.class));
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

    protected ModelWikiPage getResult(DaoAssembler assembler, SQLSelect sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiPage.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiPage<ModelWikiPage> rsMapper = ModelWikiPage.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiPage<ModelWikiPage> rsMapperTmp = ((ResultSetMapperModelWikiPage<ModelWikiPage> ) assembler.<ModelWikiPage> assembleResultSetMapper(param, ModelWikiPage.class));
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
        if (ModelWikiPage.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelWikiPage.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect sqlBuilder, ModelWikiPage instance, Map<String, Object> param) {
        Integer dPageId = instance.getPageId();
        if (dPageId!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, dPageId);
        }
        String dPageVisitName = instance.getPageVisitName();
        if (dPageVisitName!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEVISITNAME, ColumnDataType.stringData);
            param.put(ModelWikiPage.FI_PAGEVISITNAME, dPageVisitName);
        }
        String dPageContent = instance.getPageContent();
        if (dPageContent!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGECONTENT, ColumnDataType.stringData);
            param.put(ModelWikiPage.FI_PAGECONTENT, dPageContent);
        }
        String dPageTitle = instance.getPageTitle();
        if (dPageTitle!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGETITLE, ColumnDataType.stringData);
            param.put(ModelWikiPage.FI_PAGETITLE, dPageTitle);
        }
        Integer dPageIndex = instance.getPageIndex();
        if (dPageIndex!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEINDEX, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEINDEX, dPageIndex);
        }
        Byte dPageVersion = instance.getPageVersion();
        if (dPageVersion!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEVERSION, ColumnDataType.byteData);
            param.put(ModelWikiPage.FI_PAGEVERSION, dPageVersion);
        }
        Integer dPageSubmitBy = instance.getPageSubmitBy();
        if (dPageSubmitBy!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBY, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGESUBMITBY, dPageSubmitBy);
        }
        Integer dPageSubmitByGp = instance.getPageSubmitByGp();
        if (dPageSubmitByGp!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYGP, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGESUBMITBYGP, dPageSubmitByGp);
        }
        Integer dPageSubmitByIns = instance.getPageSubmitByIns();
        if (dPageSubmitByIns!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYINS, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGESUBMITBYINS, dPageSubmitByIns);
        }
        Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
        if (dPageSubmitByFamily!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYFAMILY, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGESUBMITBYFAMILY, dPageSubmitByFamily);
        }
        Date dPageCreatedOn = instance.getPageCreatedOn();
        if (dPageCreatedOn!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGECREATEDON, ColumnDataType.timeStampData);
            param.put(ModelWikiPage.FI_PAGECREATEDON, dPageCreatedOn);
        }
        String dPageAddition = instance.getPageAddition();
        if (dPageAddition!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEADDITION, ColumnDataType.stringData);
            param.put(ModelWikiPage.FI_PAGEADDITION, dPageAddition);
        }
        Byte dPageState = instance.getPageState();
        if (dPageState!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESTATE, ColumnDataType.byteData);
            param.put(ModelWikiPage.FI_PAGESTATE, dPageState);
        }
        String dPageDisplayMethod = instance.getPageDisplayMethod();
        if (dPageDisplayMethod!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEDISPLAYMETHOD, ColumnDataType.stringData);
            param.put(ModelWikiPage.FI_PAGEDISPLAYMETHOD, dPageDisplayMethod);
        }
        Byte dPageAspect = instance.getPageAspect();
        if (dPageAspect!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEASPECT, ColumnDataType.byteData);
            param.put(ModelWikiPage.FI_PAGEASPECT, dPageAspect);
        }
        EnumPageType dPageType = instance.getPageType();
        if (dPageType!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGETYPE, ColumnDataType.byteData);
            param.put(ModelWikiPage.FI_PAGETYPE, dPageType.val);
        }
        String dPageResourceUrl = instance.getPageResourceUrl();
        if (dPageResourceUrl!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGERESOURCEURL, ColumnDataType.stringData);
            param.put(ModelWikiPage.FI_PAGERESOURCEURL, dPageResourceUrl);
        }
        Long dPageFileSize = instance.getPageFileSize();
        if (dPageFileSize!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEFILESIZE, ColumnDataType.longData);
            param.put(ModelWikiPage.FI_PAGEFILESIZE, dPageFileSize);
        }
        Integer dPageRelatedObject = instance.getPageRelatedObject();
        if (dPageRelatedObject!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGERELATEDOBJECT, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGERELATEDOBJECT, dPageRelatedObject);
        }
        Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
        if (dPageSubmitByTopIns!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYTOPINS, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGESUBMITBYTOPINS, dPageSubmitByTopIns);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelWikiPage.FI_PAGEID)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEID);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVISITNAME);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGECONTENT)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECONTENT);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGETITLE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETITLE);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEINDEX)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEINDEX);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEVERSION)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVERSION);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBY);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYGP);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYINS);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGECREATEDON)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECREATEDON);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEADDITION)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEADDITION);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGESTATE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESTATE);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEASPECT)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEASPECT);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGETYPE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETYPE);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERESOURCEURL);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEFILESIZE);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERELATEDOBJECT);
        }
        if (selectFields.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
        }
    }

    public List<ModelWikiPage> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelWikiPage> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelWikiPage> get() {
        return get(null, null);
    }

    public List<ModelWikiPage> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> pageId) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        if (pageId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiPage.FI_PAGEID, ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiPage> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> pageId) {
        return getById(selectFields, null, start, count, pageId);
    }

    public List<ModelWikiPage> getById(Integer start, Integer count, List<Integer> pageId) {
        return getById(null, start, count, pageId);
    }

    public List<ModelWikiPage> getById(List<Integer> pageId) {
        return getById(null, null, pageId);
    }

    public List<ModelWikiPage> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelWikiPage> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelWikiPage> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelWikiPage> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByCond(Set<String> selectFields, Integer start, Integer count, ModelWikiPage instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelWikiPage> getByCond(Integer start, Integer count, ModelWikiPage instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelWikiPage> getByCond(ModelWikiPage instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelWikiPage> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelWikiPage> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelWikiPage> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelWikiPage instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiPage> getByCondAndIndex(Integer start, Integer count, ModelWikiPage instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiPage> getByCondAndIndex(ModelWikiPage instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelWikiPage> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        if (pageId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiPage.FI_PAGEID, ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiPage> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, pageId, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIdAndWhere(Integer start, Integer count, Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, pageId, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIdAndWhere(Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, pageId, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, List<Integer> pageId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        if (pageId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiPage.FI_PAGEID, ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiPage> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiPage instance, List<Integer> pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, pageId, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIdAndCondAndWhere(Integer start, Integer count, ModelWikiPage instance, List<Integer> pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, pageId, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIdAndCondAndWhere(ModelWikiPage instance, List<Integer> pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, pageId, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiPage> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndWhere(Integer start, Integer count, ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndWhere(ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public List<ModelWikiPage> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiPage instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndIndexAndWhere(Integer start, Integer count, ModelWikiPage instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiPage> getByCondAndIndexAndWhere(ModelWikiPage instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelWikiPage getOneById(Set<String> selectFields, DaoAssembler assembler, Integer pageId) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (pageId!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiPage getOneById(Set<String> selectFields, Integer pageId) {
        return getOneById(selectFields, null, pageId);
    }

    public ModelWikiPage getOneById(Integer pageId) {
        return getOneById(null, pageId);
    }

    public ModelWikiPage getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelWikiPage instance) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public ModelWikiPage getOneByCond(Set<String> selectFields, ModelWikiPage instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelWikiPage getOneByCond(ModelWikiPage instance) {
        return getOneByCond(null, instance);
    }

    public ModelWikiPage getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public ModelWikiPage getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelWikiPage getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelWikiPage getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public ModelWikiPage getOneByCondAndWhere(Set<String> selectFields, ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelWikiPage getOneByCondAndWhere(ModelWikiPage instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelWikiPage getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiPage instance, Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (pageId!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiPage getOneByIdAndCondAndWhere(Set<String> selectFields, ModelWikiPage instance, Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, pageId, extParam, extCondition);
    }

    public ModelWikiPage getOneByIdAndCondAndWhere(ModelWikiPage instance, Integer pageId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, pageId, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelWikiPage instance) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public Long getCountByCond(ModelWikiPage instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelWikiPage instance, String inField, List indexes) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndex(ModelWikiPage instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiPage instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public Long getCountByCondAndIndexAndWhere(ModelWikiPage instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelWikiPage instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCond(ModelWikiPage instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndex(ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelWikiPage instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelWikiPage instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer pageId, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        if (pageId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiPage.FI_PAGEID, ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer pageId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, pageId, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer pageId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, pageId, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelWikiPage instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelWikiPage instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelWikiPage instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiPage instance, List<Integer> pageId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect sqlBuilder = SQLBuilder.buildSelectSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        if (pageId!= null) {
            sqlBuilder.itemWhere(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiPage.FI_PAGEID, ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
            param.put(ModelWikiPage.FI_PAGEID, pageId);
        }
        sqlBuilder.limit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelWikiPage instance, List<Integer> pageId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, pageId, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelWikiPage instance, List<Integer> pageId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, pageId, tClass, rawItem, extParam, extCondition);
    }

    public ModelWikiPage insert(ModelWikiPage instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        Integer dPageId = instance.getPageId();
        if (dPageId!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEID);
        }
        String dPageVisitName = instance.getPageVisitName();
        if (dPageVisitName!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVISITNAME);
        }
        String dPageContent = instance.getPageContent();
        if (dPageContent!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECONTENT);
        }
        String dPageTitle = instance.getPageTitle();
        if (dPageTitle!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETITLE);
        }
        Integer dPageIndex = instance.getPageIndex();
        if (dPageIndex!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEINDEX);
        }
        Byte dPageVersion = instance.getPageVersion();
        if (dPageVersion!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVERSION);
        }
        Integer dPageSubmitBy = instance.getPageSubmitBy();
        if (dPageSubmitBy!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBY);
        }
        Integer dPageSubmitByGp = instance.getPageSubmitByGp();
        if (dPageSubmitByGp!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYGP);
        }
        Integer dPageSubmitByIns = instance.getPageSubmitByIns();
        if (dPageSubmitByIns!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYINS);
        }
        Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
        if (dPageSubmitByFamily!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
        }
        Date dPageCreatedOn = instance.getPageCreatedOn();
        if (dPageCreatedOn!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECREATEDON);
        }
        String dPageAddition = instance.getPageAddition();
        if (dPageAddition!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEADDITION);
        }
        Byte dPageState = instance.getPageState();
        if (dPageState!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESTATE);
        }
        String dPageDisplayMethod = instance.getPageDisplayMethod();
        if (dPageDisplayMethod!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
        }
        Byte dPageAspect = instance.getPageAspect();
        if (dPageAspect!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEASPECT);
        }
        EnumPageType dPageType = instance.getPageType();
        if (dPageType!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETYPE);
        }
        String dPageResourceUrl = instance.getPageResourceUrl();
        if (dPageResourceUrl!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERESOURCEURL);
        }
        Long dPageFileSize = instance.getPageFileSize();
        if (dPageFileSize!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEFILESIZE);
        }
        Integer dPageRelatedObject = instance.getPageRelatedObject();
        if (dPageRelatedObject!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERELATEDOBJECT);
        }
        Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
        if (dPageSubmitByTopIns!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
        }
        Map<String, Object> param = ModelWikiPage.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setPageId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelWikiPage insert(ModelWikiPage instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelWikiPage> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelWikiPage.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQLBuilder.buildInsertSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        if (fields.contains(ModelWikiPage.FI_PAGEID)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEID);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVISITNAME);
        }
        if (fields.contains(ModelWikiPage.FI_PAGECONTENT)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECONTENT);
        }
        if (fields.contains(ModelWikiPage.FI_PAGETITLE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETITLE);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEINDEX)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEINDEX);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEVERSION)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVERSION);
        }
        if (fields.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBY);
        }
        if (fields.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYGP);
        }
        if (fields.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYINS);
        }
        if (fields.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
        }
        if (fields.contains(ModelWikiPage.FI_PAGECREATEDON)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECREATEDON);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEADDITION)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEADDITION);
        }
        if (fields.contains(ModelWikiPage.FI_PAGESTATE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESTATE);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEASPECT)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEASPECT);
        }
        if (fields.contains(ModelWikiPage.FI_PAGETYPE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETYPE);
        }
        if (fields.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERESOURCEURL);
        }
        if (fields.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEFILESIZE);
        }
        if (fields.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERELATEDOBJECT);
        }
        if (fields.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelWikiPage instance: instances) {
            Map<String, Object> paramMap = ModelWikiPage.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelWikiPage> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelWikiPage> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelWikiPage instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        Integer dPageId = instance.getPageId();
        if (conditionField.contains(ModelWikiPage.FI_PAGEID)) {
            assert((dPageId!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
        } else {
            if (dPageId!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEID);
            }
        }
        String dPageVisitName = instance.getPageVisitName();
        if (conditionField.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
            assert((dPageVisitName!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEVISITNAME, ColumnDataType.stringData);
        } else {
            if (dPageVisitName!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVISITNAME);
            }
        }
        String dPageContent = instance.getPageContent();
        if (conditionField.contains(ModelWikiPage.FI_PAGECONTENT)) {
            assert((dPageContent!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGECONTENT, ColumnDataType.stringData);
        } else {
            if (dPageContent!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGECONTENT);
            }
        }
        String dPageTitle = instance.getPageTitle();
        if (conditionField.contains(ModelWikiPage.FI_PAGETITLE)) {
            assert((dPageTitle!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGETITLE, ColumnDataType.stringData);
        } else {
            if (dPageTitle!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGETITLE);
            }
        }
        Integer dPageIndex = instance.getPageIndex();
        if (conditionField.contains(ModelWikiPage.FI_PAGEINDEX)) {
            assert((dPageIndex!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEINDEX, ColumnDataType.intData);
        } else {
            if (dPageIndex!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEINDEX);
            }
        }
        Byte dPageVersion = instance.getPageVersion();
        if (conditionField.contains(ModelWikiPage.FI_PAGEVERSION)) {
            assert((dPageVersion!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEVERSION, ColumnDataType.byteData);
        } else {
            if (dPageVersion!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVERSION);
            }
        }
        Integer dPageSubmitBy = instance.getPageSubmitBy();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
            assert((dPageSubmitBy!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBY, ColumnDataType.intData);
        } else {
            if (dPageSubmitBy!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBY);
            }
        }
        Integer dPageSubmitByGp = instance.getPageSubmitByGp();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
            assert((dPageSubmitByGp!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYGP, ColumnDataType.intData);
        } else {
            if (dPageSubmitByGp!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYGP);
            }
        }
        Integer dPageSubmitByIns = instance.getPageSubmitByIns();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
            assert((dPageSubmitByIns!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYINS, ColumnDataType.intData);
        } else {
            if (dPageSubmitByIns!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYINS);
            }
        }
        Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
            assert((dPageSubmitByFamily!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYFAMILY, ColumnDataType.intData);
        } else {
            if (dPageSubmitByFamily!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
            }
        }
        Date dPageCreatedOn = instance.getPageCreatedOn();
        if (conditionField.contains(ModelWikiPage.FI_PAGECREATEDON)) {
            assert((dPageCreatedOn!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGECREATEDON, ColumnDataType.timeStampData);
        } else {
            if (dPageCreatedOn!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGECREATEDON);
            }
        }
        String dPageAddition = instance.getPageAddition();
        if (conditionField.contains(ModelWikiPage.FI_PAGEADDITION)) {
            assert((dPageAddition!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEADDITION, ColumnDataType.stringData);
        } else {
            if (dPageAddition!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEADDITION);
            }
        }
        Byte dPageState = instance.getPageState();
        if (conditionField.contains(ModelWikiPage.FI_PAGESTATE)) {
            assert((dPageState!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESTATE, ColumnDataType.byteData);
        } else {
            if (dPageState!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGESTATE);
            }
        }
        String dPageDisplayMethod = instance.getPageDisplayMethod();
        if (conditionField.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
            assert((dPageDisplayMethod!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEDISPLAYMETHOD, ColumnDataType.stringData);
        } else {
            if (dPageDisplayMethod!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
            }
        }
        Byte dPageAspect = instance.getPageAspect();
        if (conditionField.contains(ModelWikiPage.FI_PAGEASPECT)) {
            assert((dPageAspect!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEASPECT, ColumnDataType.byteData);
        } else {
            if (dPageAspect!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEASPECT);
            }
        }
        EnumPageType dPageType = instance.getPageType();
        if (conditionField.contains(ModelWikiPage.FI_PAGETYPE)) {
            assert((dPageType!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGETYPE, ColumnDataType.byteData);
        } else {
            if (dPageType!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGETYPE);
            }
        }
        String dPageResourceUrl = instance.getPageResourceUrl();
        if (conditionField.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
            assert((dPageResourceUrl!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGERESOURCEURL, ColumnDataType.stringData);
        } else {
            if (dPageResourceUrl!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGERESOURCEURL);
            }
        }
        Long dPageFileSize = instance.getPageFileSize();
        if (conditionField.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
            assert((dPageFileSize!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEFILESIZE, ColumnDataType.longData);
        } else {
            if (dPageFileSize!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGEFILESIZE);
            }
        }
        Integer dPageRelatedObject = instance.getPageRelatedObject();
        if (conditionField.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
            assert((dPageRelatedObject!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGERELATEDOBJECT, ColumnDataType.intData);
        } else {
            if (dPageRelatedObject!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGERELATEDOBJECT);
            }
        }
        Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
            assert((dPageSubmitByTopIns!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYTOPINS, ColumnDataType.intData);
        } else {
            if (dPageSubmitByTopIns!= null) {
                sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
            }
        }
        Map<String, Object> param = ModelWikiPage.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelWikiPage instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelWikiPage instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        assert((instance.getPageId()!= null));
        Integer dPageId = instance.getPageId();
        if (dPageId!= null) {
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
        }
        String dPageVisitName = instance.getPageVisitName();
        if (dPageVisitName!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVISITNAME);
        }
        String dPageContent = instance.getPageContent();
        if (dPageContent!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECONTENT);
        }
        String dPageTitle = instance.getPageTitle();
        if (dPageTitle!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETITLE);
        }
        Integer dPageIndex = instance.getPageIndex();
        if (dPageIndex!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEINDEX);
        }
        Byte dPageVersion = instance.getPageVersion();
        if (dPageVersion!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVERSION);
        }
        Integer dPageSubmitBy = instance.getPageSubmitBy();
        if (dPageSubmitBy!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBY);
        }
        Integer dPageSubmitByGp = instance.getPageSubmitByGp();
        if (dPageSubmitByGp!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYGP);
        }
        Integer dPageSubmitByIns = instance.getPageSubmitByIns();
        if (dPageSubmitByIns!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYINS);
        }
        Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
        if (dPageSubmitByFamily!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
        }
        Date dPageCreatedOn = instance.getPageCreatedOn();
        if (dPageCreatedOn!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECREATEDON);
        }
        String dPageAddition = instance.getPageAddition();
        if (dPageAddition!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEADDITION);
        }
        Byte dPageState = instance.getPageState();
        if (dPageState!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESTATE);
        }
        String dPageDisplayMethod = instance.getPageDisplayMethod();
        if (dPageDisplayMethod!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
        }
        Byte dPageAspect = instance.getPageAspect();
        if (dPageAspect!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEASPECT);
        }
        EnumPageType dPageType = instance.getPageType();
        if (dPageType!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETYPE);
        }
        String dPageResourceUrl = instance.getPageResourceUrl();
        if (dPageResourceUrl!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERESOURCEURL);
        }
        Long dPageFileSize = instance.getPageFileSize();
        if (dPageFileSize!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEFILESIZE);
        }
        Integer dPageRelatedObject = instance.getPageRelatedObject();
        if (dPageRelatedObject!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERELATEDOBJECT);
        }
        Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
        if (dPageSubmitByTopIns!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
        }
        Map<String, Object> param = ModelWikiPage.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelWikiPage instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelWikiPage instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQLBuilder.buildUpdateSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.itemWhere(LogicalOpType.in, ModelWikiPage.FI_PAGEID, "ids", ColumnDataType.intData);
        instance.setPageId(null);
        String dPageVisitName = instance.getPageVisitName();
        if (dPageVisitName!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVISITNAME);
        }
        String dPageContent = instance.getPageContent();
        if (dPageContent!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECONTENT);
        }
        String dPageTitle = instance.getPageTitle();
        if (dPageTitle!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETITLE);
        }
        Integer dPageIndex = instance.getPageIndex();
        if (dPageIndex!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEINDEX);
        }
        Byte dPageVersion = instance.getPageVersion();
        if (dPageVersion!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEVERSION);
        }
        Integer dPageSubmitBy = instance.getPageSubmitBy();
        if (dPageSubmitBy!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBY);
        }
        Integer dPageSubmitByGp = instance.getPageSubmitByGp();
        if (dPageSubmitByGp!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYGP);
        }
        Integer dPageSubmitByIns = instance.getPageSubmitByIns();
        if (dPageSubmitByIns!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYINS);
        }
        Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
        if (dPageSubmitByFamily!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
        }
        Date dPageCreatedOn = instance.getPageCreatedOn();
        if (dPageCreatedOn!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGECREATEDON);
        }
        String dPageAddition = instance.getPageAddition();
        if (dPageAddition!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEADDITION);
        }
        Byte dPageState = instance.getPageState();
        if (dPageState!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESTATE);
        }
        String dPageDisplayMethod = instance.getPageDisplayMethod();
        if (dPageDisplayMethod!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
        }
        Byte dPageAspect = instance.getPageAspect();
        if (dPageAspect!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEASPECT);
        }
        EnumPageType dPageType = instance.getPageType();
        if (dPageType!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGETYPE);
        }
        String dPageResourceUrl = instance.getPageResourceUrl();
        if (dPageResourceUrl!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERESOURCEURL);
        }
        Long dPageFileSize = instance.getPageFileSize();
        if (dPageFileSize!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGEFILESIZE);
        }
        Integer dPageRelatedObject = instance.getPageRelatedObject();
        if (dPageRelatedObject!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGERELATEDOBJECT);
        }
        Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
        if (dPageSubmitByTopIns!= null) {
            sqlBuilder.itemCol(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
        }
        Map<String, Object> param = ModelWikiPage.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelWikiPage instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelWikiPage instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        Integer dPageId = instance.getPageId();
        if (conditionField.contains(ModelWikiPage.FI_PAGEID)) {
            assert((dPageId!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEID, ColumnDataType.intData);
        }
        String dPageVisitName = instance.getPageVisitName();
        if (conditionField.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
            assert((dPageVisitName!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEVISITNAME, ColumnDataType.stringData);
        }
        String dPageContent = instance.getPageContent();
        if (conditionField.contains(ModelWikiPage.FI_PAGECONTENT)) {
            assert((dPageContent!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGECONTENT, ColumnDataType.stringData);
        }
        String dPageTitle = instance.getPageTitle();
        if (conditionField.contains(ModelWikiPage.FI_PAGETITLE)) {
            assert((dPageTitle!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGETITLE, ColumnDataType.stringData);
        }
        Integer dPageIndex = instance.getPageIndex();
        if (conditionField.contains(ModelWikiPage.FI_PAGEINDEX)) {
            assert((dPageIndex!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEINDEX, ColumnDataType.intData);
        }
        Byte dPageVersion = instance.getPageVersion();
        if (conditionField.contains(ModelWikiPage.FI_PAGEVERSION)) {
            assert((dPageVersion!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEVERSION, ColumnDataType.byteData);
        }
        Integer dPageSubmitBy = instance.getPageSubmitBy();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
            assert((dPageSubmitBy!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBY, ColumnDataType.intData);
        }
        Integer dPageSubmitByGp = instance.getPageSubmitByGp();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
            assert((dPageSubmitByGp!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYGP, ColumnDataType.intData);
        }
        Integer dPageSubmitByIns = instance.getPageSubmitByIns();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
            assert((dPageSubmitByIns!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYINS, ColumnDataType.intData);
        }
        Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
            assert((dPageSubmitByFamily!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYFAMILY, ColumnDataType.intData);
        }
        Date dPageCreatedOn = instance.getPageCreatedOn();
        if (conditionField.contains(ModelWikiPage.FI_PAGECREATEDON)) {
            assert((dPageCreatedOn!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGECREATEDON, ColumnDataType.timeStampData);
        }
        String dPageAddition = instance.getPageAddition();
        if (conditionField.contains(ModelWikiPage.FI_PAGEADDITION)) {
            assert((dPageAddition!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEADDITION, ColumnDataType.stringData);
        }
        Byte dPageState = instance.getPageState();
        if (conditionField.contains(ModelWikiPage.FI_PAGESTATE)) {
            assert((dPageState!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESTATE, ColumnDataType.byteData);
        }
        String dPageDisplayMethod = instance.getPageDisplayMethod();
        if (conditionField.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
            assert((dPageDisplayMethod!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEDISPLAYMETHOD, ColumnDataType.stringData);
        }
        Byte dPageAspect = instance.getPageAspect();
        if (conditionField.contains(ModelWikiPage.FI_PAGEASPECT)) {
            assert((dPageAspect!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEASPECT, ColumnDataType.byteData);
        }
        EnumPageType dPageType = instance.getPageType();
        if (conditionField.contains(ModelWikiPage.FI_PAGETYPE)) {
            assert((dPageType!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGETYPE, ColumnDataType.byteData);
        }
        String dPageResourceUrl = instance.getPageResourceUrl();
        if (conditionField.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
            assert((dPageResourceUrl!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGERESOURCEURL, ColumnDataType.stringData);
        }
        Long dPageFileSize = instance.getPageFileSize();
        if (conditionField.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
            assert((dPageFileSize!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGEFILESIZE, ColumnDataType.longData);
        }
        Integer dPageRelatedObject = instance.getPageRelatedObject();
        if (conditionField.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
            assert((dPageRelatedObject!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGERELATEDOBJECT, ColumnDataType.intData);
        }
        Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
            assert((dPageSubmitByTopIns!= null));
            sqlBuilder.itemWhere(ModelWikiPage.FI_PAGESUBMITBYTOPINS, ColumnDataType.intData);
        }
        Map<String, Object> param = ModelWikiPage.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelWikiPage instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQLBuilder.buildDeleteSql();
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
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
        sqlBuilder.table(ModelWikiPage.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelWikiPage updateOrInsert(ModelWikiPage instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiPage checkInstance = new ModelWikiPage();
        if (conditionField.contains(ModelWikiPage.FI_PAGEID)) {
            checkInstance.setPageId(instance.getPageId());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
            checkInstance.setPageVisitName(instance.getPageVisitName());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGECONTENT)) {
            checkInstance.setPageContent(instance.getPageContent());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGETITLE)) {
            checkInstance.setPageTitle(instance.getPageTitle());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEINDEX)) {
            checkInstance.setPageIndex(instance.getPageIndex());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEVERSION)) {
            checkInstance.setPageVersion(instance.getPageVersion());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
            checkInstance.setPageSubmitBy(instance.getPageSubmitBy());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
            checkInstance.setPageSubmitByGp(instance.getPageSubmitByGp());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
            checkInstance.setPageSubmitByIns(instance.getPageSubmitByIns());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
            checkInstance.setPageSubmitByFamily(instance.getPageSubmitByFamily());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGECREATEDON)) {
            checkInstance.setPageCreatedOn(instance.getPageCreatedOn());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEADDITION)) {
            checkInstance.setPageAddition(instance.getPageAddition());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESTATE)) {
            checkInstance.setPageState(instance.getPageState());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
            checkInstance.setPageDisplayMethod(instance.getPageDisplayMethod());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEASPECT)) {
            checkInstance.setPageAspect(instance.getPageAspect());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGETYPE)) {
            checkInstance.setPageType(instance.getPageType());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
            checkInstance.setPageResourceUrl(instance.getPageResourceUrl());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
            checkInstance.setPageFileSize(instance.getPageFileSize());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
            checkInstance.setPageRelatedObject(instance.getPageRelatedObject());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
            checkInstance.setPageSubmitByTopIns(instance.getPageSubmitByTopIns());
        }
        ModelWikiPage selected = getOneByCond(Collections.singleton(ModelWikiPage.FI_PAGEID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setPageId(selected.getPageId());
            update(instance, Collections.singleton(ModelWikiPage.FI_PAGEID), assembler);
            return instance;
        }
    }

    public ModelWikiPage updateOrInsert(ModelWikiPage instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelWikiPage insertIfNoExist(ModelWikiPage instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiPage checkInstance = new ModelWikiPage();
        if (conditionField.contains(ModelWikiPage.FI_PAGEID)) {
            checkInstance.setPageId(instance.getPageId());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
            checkInstance.setPageVisitName(instance.getPageVisitName());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGECONTENT)) {
            checkInstance.setPageContent(instance.getPageContent());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGETITLE)) {
            checkInstance.setPageTitle(instance.getPageTitle());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEINDEX)) {
            checkInstance.setPageIndex(instance.getPageIndex());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEVERSION)) {
            checkInstance.setPageVersion(instance.getPageVersion());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
            checkInstance.setPageSubmitBy(instance.getPageSubmitBy());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
            checkInstance.setPageSubmitByGp(instance.getPageSubmitByGp());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
            checkInstance.setPageSubmitByIns(instance.getPageSubmitByIns());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
            checkInstance.setPageSubmitByFamily(instance.getPageSubmitByFamily());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGECREATEDON)) {
            checkInstance.setPageCreatedOn(instance.getPageCreatedOn());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEADDITION)) {
            checkInstance.setPageAddition(instance.getPageAddition());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESTATE)) {
            checkInstance.setPageState(instance.getPageState());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
            checkInstance.setPageDisplayMethod(instance.getPageDisplayMethod());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEASPECT)) {
            checkInstance.setPageAspect(instance.getPageAspect());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGETYPE)) {
            checkInstance.setPageType(instance.getPageType());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
            checkInstance.setPageResourceUrl(instance.getPageResourceUrl());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
            checkInstance.setPageFileSize(instance.getPageFileSize());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
            checkInstance.setPageRelatedObject(instance.getPageRelatedObject());
        }
        if (conditionField.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
            checkInstance.setPageSubmitByTopIns(instance.getPageSubmitByTopIns());
        }
        ModelWikiPage selected = getOneByCond(Collections.singleton(ModelWikiPage.FI_PAGEID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setPageId(selected.getPageId());
            return instance;
        }
    }

    public ModelWikiPage insertIfNoExist(ModelWikiPage instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelWikiPage> buildMap(List<ModelWikiPage> list, String field) {
        Map<TT, ModelWikiPage> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiPage item: list) {
            ret.put(ModelWikiPage.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelWikiPage>> buildListMap(List<ModelWikiPage> list, String field) {
        Map<TT, List<ModelWikiPage>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiPage item: list) {
            List<ModelWikiPage> itemList = ret.get(ModelWikiPage.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelWikiPage.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelWikiPage> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelWikiPage.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiPage item: list) {
                ret.add(ModelWikiPage.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
