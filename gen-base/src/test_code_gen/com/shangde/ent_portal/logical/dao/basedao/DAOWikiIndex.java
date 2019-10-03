package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.ResultSetMapperModelWikiIndex;
import com.shangde.ent_portal.logical.dto.enums.EnumIndexStatus;
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
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
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
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex;

@Repository("DAOWikiIndex")
@SuppressWarnings("unchecked")
public class DAOWikiIndex
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOWikiIndex.class);
    @Autowired(required = true)
    @Qualifier("wiki_master")
    protected SimpleDbInterface data_store;

    public DAOWikiIndex() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.class);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected<TT> TT getSingleResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        return super.getSingleResult(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected<TT> List<TT> getSingleResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        return super.getSingleResults(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected List<ModelWikiIndex> getResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiIndex.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiIndex<ModelWikiIndex> rsMapper = ModelWikiIndex.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiIndex<ModelWikiIndex> rsMapperTmp = ((ResultSetMapperModelWikiIndex<ModelWikiIndex> ) assembler.<ModelWikiIndex> assembleResultSetMapper(param, ModelWikiIndex.class));
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

    protected ModelWikiIndex getResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelWikiIndex.class);
        }
        SimpleDbInterface dbInstance = data_store;
        if (status == 0) {
            ResultSetMapperModelWikiIndex<ModelWikiIndex> rsMapper = ModelWikiIndex.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelWikiIndex<ModelWikiIndex> rsMapperTmp = ((ResultSetMapperModelWikiIndex<ModelWikiIndex> ) assembler.<ModelWikiIndex> assembleResultSetMapper(param, ModelWikiIndex.class));
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
        if (ModelWikiIndex.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelWikiIndex.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect<SQLSelect> sqlBuilder, ModelWikiIndex instance, Map<String, Object> param) {
        Integer dIndexId = instance.getIndexId();
        if (dIndexId!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXID, dIndexId);
        }
        Byte dIndexLevel = instance.getIndexLevel();
        if (dIndexLevel!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXLEVEL, ColumnDataType.byteData);
            param.put(ModelWikiIndex.FI_INDEXLEVEL, dIndexLevel);
        }
        Integer dIndexParent = instance.getIndexParent();
        if (dIndexParent!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPARENT, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXPARENT, dIndexParent);
        }
        Integer dIndexNext = instance.getIndexNext();
        if (dIndexNext!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXNEXT, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXNEXT, dIndexNext);
        }
        Integer dIndexPrev = instance.getIndexPrev();
        if (dIndexPrev!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPREV, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXPREV, dIndexPrev);
        }
        Short dIndexIndex = instance.getIndexIndex();
        if (dIndexIndex!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXINDEX, ColumnDataType.shortData);
            param.put(ModelWikiIndex.FI_INDEXINDEX, dIndexIndex);
        }
        Integer dIndexRoot = instance.getIndexRoot();
        if (dIndexRoot!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXROOT, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXROOT, dIndexRoot);
        }
        Integer dIndexLeftValue = instance.getIndexLeftValue();
        if (dIndexLeftValue!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXLEFTVALUE, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXLEFTVALUE, dIndexLeftValue);
        }
        Integer dIndexRightValue = instance.getIndexRightValue();
        if (dIndexRightValue!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRIGHTVALUE, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXRIGHTVALUE, dIndexRightValue);
        }
        String dIndexTitle = instance.getIndexTitle();
        if (dIndexTitle!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXTITLE, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXTITLE, dIndexTitle);
        }
        String dIndexContent = instance.getIndexContent();
        if (dIndexContent!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCONTENT, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXCONTENT, dIndexContent);
        }
        String dIndexIcon = instance.getIndexIcon();
        if (dIndexIcon!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXICON, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXICON, dIndexIcon);
        }
        String dIndexBackground = instance.getIndexBackground();
        if (dIndexBackground!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXBACKGROUND, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXBACKGROUND, dIndexBackground);
        }
        Short dIndexRank = instance.getIndexRank();
        if (dIndexRank!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRANK, ColumnDataType.shortData);
            param.put(ModelWikiIndex.FI_INDEXRANK, dIndexRank);
        }
        Integer dIndexPageId = instance.getIndexPageId();
        if (dIndexPageId!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPAGEID, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXPAGEID, dIndexPageId);
        }
        Short dIndexChildrenCount = instance.getIndexChildrenCount();
        if (dIndexChildrenCount!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, ColumnDataType.shortData);
            param.put(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, dIndexChildrenCount);
        }
        String dIndexSequence = instance.getIndexSequence();
        if (dIndexSequence!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSEQUENCE, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXSEQUENCE, dIndexSequence);
        }
        Date dIndexCreateTime = instance.getIndexCreateTime();
        if (dIndexCreateTime!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCREATETIME, ColumnDataType.timeStampData);
            param.put(ModelWikiIndex.FI_INDEXCREATETIME, dIndexCreateTime);
        }
        Date dIndexPublishTime = instance.getIndexPublishTime();
        if (dIndexPublishTime!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPUBLISHTIME, ColumnDataType.timeStampData);
            param.put(ModelWikiIndex.FI_INDEXPUBLISHTIME, dIndexPublishTime);
        }
        EnumIndexStatus dIndexStatus = instance.getIndexStatus();
        if (dIndexStatus!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSTATUS, ColumnDataType.byteData);
            param.put(ModelWikiIndex.FI_INDEXSTATUS, dIndexStatus.val);
        }
        String dIndexResourceUrl = instance.getIndexResourceUrl();
        if (dIndexResourceUrl!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRESOURCEURL, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXRESOURCEURL, dIndexResourceUrl);
        }
        String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
        if (dIndexDefaultTemplate!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, ColumnDataType.stringData);
            param.put(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, dIndexDefaultTemplate);
        }
        Integer dIndexSubmitBy = instance.getIndexSubmitBy();
        if (dIndexSubmitBy!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBY, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXSUBMITBY, dIndexSubmitBy);
        }
        Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
        if (dIndexSubmitByGp!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYGP, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXSUBMITBYGP, dIndexSubmitByGp);
        }
        Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
        if (dIndexSubmitByIns!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYINS, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXSUBMITBYINS, dIndexSubmitByIns);
        }
        Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
        if (dIndexSubmitByFamily!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, dIndexSubmitByFamily);
        }
        Short dIndexAuthLevel = instance.getIndexAuthLevel();
        if (dIndexAuthLevel!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXAUTHLEVEL, ColumnDataType.shortData);
            param.put(ModelWikiIndex.FI_INDEXAUTHLEVEL, dIndexAuthLevel);
        }
        Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
        if (dIndexWrAuthLevel!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, ColumnDataType.shortData);
            param.put(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, dIndexWrAuthLevel);
        }
        Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
        if (dIndexExAuthLevel!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, ColumnDataType.shortData);
            param.put(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, dIndexExAuthLevel);
        }
        Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
        if (dIndexSubmitByTopIns!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, dIndexSubmitByTopIns);
        }
        Byte dIndexAspect = instance.getIndexAspect();
        if (dIndexAspect!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXASPECT, ColumnDataType.byteData);
            param.put(ModelWikiIndex.FI_INDEXASPECT, dIndexAspect);
        }
        Integer dIndexRelatedObj = instance.getIndexRelatedObj();
        if (dIndexRelatedObj!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRELATEDOBJ, ColumnDataType.intData);
            param.put(ModelWikiIndex.FI_INDEXRELATEDOBJ, dIndexRelatedObj);
        }
        Byte dIndexType = instance.getIndexType();
        if (dIndexType!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXTYPE, ColumnDataType.byteData);
            param.put(ModelWikiIndex.FI_INDEXTYPE, dIndexType);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect<SQLSelect> sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelWikiIndex.FI_INDEXID)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXID);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEVEL);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXPARENT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPARENT);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXNEXT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXNEXT);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXPREV)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPREV);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXINDEX)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXINDEX);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXROOT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXROOT);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEFTVALUE);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRIGHTVALUE);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXTITLE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTITLE);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCONTENT);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXICON)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXICON);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXBACKGROUND);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXRANK)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRANK);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPAGEID);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSEQUENCE);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCREATETIME);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPUBLISHTIME);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSTATUS);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRESOURCEURL);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBY);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYGP);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYINS);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXAUTHLEVEL);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXASPECT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXASPECT);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRELATEDOBJ);
        }
        if (selectFields.contains(ModelWikiIndex.FI_INDEXTYPE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTYPE);
        }
    }

    public List<ModelWikiIndex> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelWikiIndex> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelWikiIndex> get() {
        return get(null, null);
    }

    public List<ModelWikiIndex> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> indexId) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        if (indexId!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndex.FI_INDEXID, ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> indexId) {
        return getById(selectFields, null, start, count, indexId);
    }

    public List<ModelWikiIndex> getById(Integer start, Integer count, List<Integer> indexId) {
        return getById(null, start, count, indexId);
    }

    public List<ModelWikiIndex> getById(List<Integer> indexId) {
        return getById(null, null, indexId);
    }

    public List<ModelWikiIndex> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelWikiIndex> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelWikiIndex> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelWikiIndex> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByCond(Set<String> selectFields, Integer start, Integer count, ModelWikiIndex instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelWikiIndex> getByCond(Integer start, Integer count, ModelWikiIndex instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelWikiIndex> getByCond(ModelWikiIndex instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelWikiIndex> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiIndex> getByCondAndIndex(Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelWikiIndex> getByCondAndIndex(ModelWikiIndex instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelWikiIndex> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        if (indexId!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndex.FI_INDEXID, ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIdAndWhere(Integer start, Integer count, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIdAndWhere(Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        if (indexId!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndex.FI_INDEXID, ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIdAndCondAndWhere(Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIdAndCondAndWhere(ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndWhere(Integer start, Integer count, ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndWhere(ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelWikiIndex> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndIndexAndWhere(Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndex> getByCondAndIndexAndWhere(ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelWikiIndex getOneById(Set<String> selectFields, DaoAssembler assembler, Integer indexId) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (indexId!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndex getOneById(Set<String> selectFields, Integer indexId) {
        return getOneById(selectFields, null, indexId);
    }

    public ModelWikiIndex getOneById(Integer indexId) {
        return getOneById(null, indexId);
    }

    public ModelWikiIndex getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndex instance) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndex getOneByCond(Set<String> selectFields, ModelWikiIndex instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelWikiIndex getOneByCond(ModelWikiIndex instance) {
        return getOneByCond(null, instance);
    }

    public ModelWikiIndex getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndex getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelWikiIndex getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelWikiIndex getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndex getOneByCondAndWhere(Set<String> selectFields, ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelWikiIndex getOneByCondAndWhere(ModelWikiIndex instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelWikiIndex getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndex instance, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (indexId!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelWikiIndex getOneByIdAndCondAndWhere(Set<String> selectFields, ModelWikiIndex instance, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, indexId, extParam, extCondition);
    }

    public ModelWikiIndex getOneByIdAndCondAndWhere(ModelWikiIndex instance, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, indexId, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelWikiIndex instance) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCond(ModelWikiIndex instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelWikiIndex instance, String inField, List indexes) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelWikiIndex instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndexAndWhere(ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelWikiIndex instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelWikiIndex instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelWikiIndex instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelWikiIndex instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer indexId, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        if (indexId!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndex.FI_INDEXID, ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer indexId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, indexId, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer indexId, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, indexId, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelWikiIndex instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelWikiIndex instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelWikiIndex instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelWikiIndex.DTO_TABLE_NAME);
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
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (indexId!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelWikiIndex.FI_INDEXID, ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, indexId, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelWikiIndex instance, List<Integer> indexId, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, indexId, tClass, rawItem, extParam, extCondition);
    }

    public ModelWikiIndex insert(ModelWikiIndex instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer dIndexId = instance.getIndexId();
        if (dIndexId!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXID);
        }
        Byte dIndexLevel = instance.getIndexLevel();
        if (dIndexLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEVEL);
        }
        Integer dIndexParent = instance.getIndexParent();
        if (dIndexParent!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPARENT);
        }
        Integer dIndexNext = instance.getIndexNext();
        if (dIndexNext!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXNEXT);
        }
        Integer dIndexPrev = instance.getIndexPrev();
        if (dIndexPrev!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPREV);
        }
        Short dIndexIndex = instance.getIndexIndex();
        if (dIndexIndex!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXINDEX);
        }
        Integer dIndexRoot = instance.getIndexRoot();
        if (dIndexRoot!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXROOT);
        }
        Integer dIndexLeftValue = instance.getIndexLeftValue();
        if (dIndexLeftValue!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEFTVALUE);
        }
        Integer dIndexRightValue = instance.getIndexRightValue();
        if (dIndexRightValue!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRIGHTVALUE);
        }
        String dIndexTitle = instance.getIndexTitle();
        if (dIndexTitle!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTITLE);
        }
        String dIndexContent = instance.getIndexContent();
        if (dIndexContent!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCONTENT);
        }
        String dIndexIcon = instance.getIndexIcon();
        if (dIndexIcon!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXICON);
        }
        String dIndexBackground = instance.getIndexBackground();
        if (dIndexBackground!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXBACKGROUND);
        }
        Short dIndexRank = instance.getIndexRank();
        if (dIndexRank!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRANK);
        }
        Integer dIndexPageId = instance.getIndexPageId();
        if (dIndexPageId!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPAGEID);
        }
        Short dIndexChildrenCount = instance.getIndexChildrenCount();
        if (dIndexChildrenCount!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
        }
        String dIndexSequence = instance.getIndexSequence();
        if (dIndexSequence!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSEQUENCE);
        }
        Date dIndexCreateTime = instance.getIndexCreateTime();
        if (dIndexCreateTime!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCREATETIME);
        }
        Date dIndexPublishTime = instance.getIndexPublishTime();
        if (dIndexPublishTime!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPUBLISHTIME);
        }
        EnumIndexStatus dIndexStatus = instance.getIndexStatus();
        if (dIndexStatus!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSTATUS);
        }
        String dIndexResourceUrl = instance.getIndexResourceUrl();
        if (dIndexResourceUrl!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRESOURCEURL);
        }
        String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
        if (dIndexDefaultTemplate!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
        }
        Integer dIndexSubmitBy = instance.getIndexSubmitBy();
        if (dIndexSubmitBy!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBY);
        }
        Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
        if (dIndexSubmitByGp!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYGP);
        }
        Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
        if (dIndexSubmitByIns!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYINS);
        }
        Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
        if (dIndexSubmitByFamily!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
        }
        Short dIndexAuthLevel = instance.getIndexAuthLevel();
        if (dIndexAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXAUTHLEVEL);
        }
        Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
        if (dIndexWrAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
        }
        Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
        if (dIndexExAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
        }
        Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
        if (dIndexSubmitByTopIns!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
        }
        Byte dIndexAspect = instance.getIndexAspect();
        if (dIndexAspect!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXASPECT);
        }
        Integer dIndexRelatedObj = instance.getIndexRelatedObj();
        if (dIndexRelatedObj!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRELATEDOBJ);
        }
        Byte dIndexType = instance.getIndexType();
        if (dIndexType!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTYPE);
        }
        Map<String, Object> param = ModelWikiIndex.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setIndexId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelWikiIndex insert(ModelWikiIndex instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelWikiIndex> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelWikiIndex.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelWikiIndex.DTO_TABLE_NAME);
        if (fields.contains(ModelWikiIndex.FI_INDEXID)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXID);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEVEL);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXPARENT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPARENT);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXNEXT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXNEXT);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXPREV)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPREV);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXINDEX)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXINDEX);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXROOT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXROOT);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEFTVALUE);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRIGHTVALUE);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXTITLE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTITLE);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCONTENT);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXICON)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXICON);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXBACKGROUND);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXRANK)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRANK);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPAGEID);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSEQUENCE);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCREATETIME);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPUBLISHTIME);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSTATUS);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRESOURCEURL);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBY);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYGP);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYINS);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXAUTHLEVEL);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXASPECT)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXASPECT);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRELATEDOBJ);
        }
        if (fields.contains(ModelWikiIndex.FI_INDEXTYPE)) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTYPE);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelWikiIndex instance: instances) {
            Map<String, Object> paramMap = ModelWikiIndex.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelWikiIndex> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelWikiIndex> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelWikiIndex instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer dIndexId = instance.getIndexId();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXID)) {
            assert((dIndexId!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        } else {
            if (dIndexId!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXID);
            }
        }
        Byte dIndexLevel = instance.getIndexLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
            assert((dIndexLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXLEVEL, ColumnDataType.byteData);
        } else {
            if (dIndexLevel!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXLEVEL);
            }
        }
        Integer dIndexParent = instance.getIndexParent();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPARENT)) {
            assert((dIndexParent!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPARENT, ColumnDataType.intData);
        } else {
            if (dIndexParent!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXPARENT);
            }
        }
        Integer dIndexNext = instance.getIndexNext();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXNEXT)) {
            assert((dIndexNext!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXNEXT, ColumnDataType.intData);
        } else {
            if (dIndexNext!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXNEXT);
            }
        }
        Integer dIndexPrev = instance.getIndexPrev();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPREV)) {
            assert((dIndexPrev!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPREV, ColumnDataType.intData);
        } else {
            if (dIndexPrev!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXPREV);
            }
        }
        Short dIndexIndex = instance.getIndexIndex();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXINDEX)) {
            assert((dIndexIndex!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXINDEX, ColumnDataType.shortData);
        } else {
            if (dIndexIndex!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXINDEX);
            }
        }
        Integer dIndexRoot = instance.getIndexRoot();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXROOT)) {
            assert((dIndexRoot!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXROOT, ColumnDataType.intData);
        } else {
            if (dIndexRoot!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXROOT);
            }
        }
        Integer dIndexLeftValue = instance.getIndexLeftValue();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
            assert((dIndexLeftValue!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXLEFTVALUE, ColumnDataType.intData);
        } else {
            if (dIndexLeftValue!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXLEFTVALUE);
            }
        }
        Integer dIndexRightValue = instance.getIndexRightValue();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
            assert((dIndexRightValue!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRIGHTVALUE, ColumnDataType.intData);
        } else {
            if (dIndexRightValue!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXRIGHTVALUE);
            }
        }
        String dIndexTitle = instance.getIndexTitle();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTITLE)) {
            assert((dIndexTitle!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXTITLE, ColumnDataType.stringData);
        } else {
            if (dIndexTitle!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXTITLE);
            }
        }
        String dIndexContent = instance.getIndexContent();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
            assert((dIndexContent!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCONTENT, ColumnDataType.stringData);
        } else {
            if (dIndexContent!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXCONTENT);
            }
        }
        String dIndexIcon = instance.getIndexIcon();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXICON)) {
            assert((dIndexIcon!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXICON, ColumnDataType.stringData);
        } else {
            if (dIndexIcon!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXICON);
            }
        }
        String dIndexBackground = instance.getIndexBackground();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
            assert((dIndexBackground!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXBACKGROUND, ColumnDataType.stringData);
        } else {
            if (dIndexBackground!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXBACKGROUND);
            }
        }
        Short dIndexRank = instance.getIndexRank();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRANK)) {
            assert((dIndexRank!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRANK, ColumnDataType.shortData);
        } else {
            if (dIndexRank!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXRANK);
            }
        }
        Integer dIndexPageId = instance.getIndexPageId();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
            assert((dIndexPageId!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPAGEID, ColumnDataType.intData);
        } else {
            if (dIndexPageId!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXPAGEID);
            }
        }
        Short dIndexChildrenCount = instance.getIndexChildrenCount();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
            assert((dIndexChildrenCount!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, ColumnDataType.shortData);
        } else {
            if (dIndexChildrenCount!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
            }
        }
        String dIndexSequence = instance.getIndexSequence();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
            assert((dIndexSequence!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSEQUENCE, ColumnDataType.stringData);
        } else {
            if (dIndexSequence!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSEQUENCE);
            }
        }
        Date dIndexCreateTime = instance.getIndexCreateTime();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
            assert((dIndexCreateTime!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCREATETIME, ColumnDataType.timeStampData);
        } else {
            if (dIndexCreateTime!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXCREATETIME);
            }
        }
        Date dIndexPublishTime = instance.getIndexPublishTime();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
            assert((dIndexPublishTime!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPUBLISHTIME, ColumnDataType.timeStampData);
        } else {
            if (dIndexPublishTime!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXPUBLISHTIME);
            }
        }
        EnumIndexStatus dIndexStatus = instance.getIndexStatus();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
            assert((dIndexStatus!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSTATUS, ColumnDataType.byteData);
        } else {
            if (dIndexStatus!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSTATUS);
            }
        }
        String dIndexResourceUrl = instance.getIndexResourceUrl();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
            assert((dIndexResourceUrl!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRESOURCEURL, ColumnDataType.stringData);
        } else {
            if (dIndexResourceUrl!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXRESOURCEURL);
            }
        }
        String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
            assert((dIndexDefaultTemplate!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, ColumnDataType.stringData);
        } else {
            if (dIndexDefaultTemplate!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
            }
        }
        Integer dIndexSubmitBy = instance.getIndexSubmitBy();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
            assert((dIndexSubmitBy!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBY, ColumnDataType.intData);
        } else {
            if (dIndexSubmitBy!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBY);
            }
        }
        Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
            assert((dIndexSubmitByGp!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYGP, ColumnDataType.intData);
        } else {
            if (dIndexSubmitByGp!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYGP);
            }
        }
        Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
            assert((dIndexSubmitByIns!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYINS, ColumnDataType.intData);
        } else {
            if (dIndexSubmitByIns!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYINS);
            }
        }
        Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
            assert((dIndexSubmitByFamily!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, ColumnDataType.intData);
        } else {
            if (dIndexSubmitByFamily!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
            }
        }
        Short dIndexAuthLevel = instance.getIndexAuthLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
            assert((dIndexAuthLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXAUTHLEVEL, ColumnDataType.shortData);
        } else {
            if (dIndexAuthLevel!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXAUTHLEVEL);
            }
        }
        Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
            assert((dIndexWrAuthLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, ColumnDataType.shortData);
        } else {
            if (dIndexWrAuthLevel!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
            }
        }
        Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
            assert((dIndexExAuthLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, ColumnDataType.shortData);
        } else {
            if (dIndexExAuthLevel!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
            }
        }
        Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
            assert((dIndexSubmitByTopIns!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, ColumnDataType.intData);
        } else {
            if (dIndexSubmitByTopIns!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
            }
        }
        Byte dIndexAspect = instance.getIndexAspect();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXASPECT)) {
            assert((dIndexAspect!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXASPECT, ColumnDataType.byteData);
        } else {
            if (dIndexAspect!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXASPECT);
            }
        }
        Integer dIndexRelatedObj = instance.getIndexRelatedObj();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
            assert((dIndexRelatedObj!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRELATEDOBJ, ColumnDataType.intData);
        } else {
            if (dIndexRelatedObj!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXRELATEDOBJ);
            }
        }
        Byte dIndexType = instance.getIndexType();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTYPE)) {
            assert((dIndexType!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXTYPE, ColumnDataType.byteData);
        } else {
            if (dIndexType!= null) {
                sqlBuilder.items(ModelWikiIndex.FI_INDEXTYPE);
            }
        }
        Map<String, Object> param = ModelWikiIndex.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelWikiIndex instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelWikiIndex instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelWikiIndex.DTO_TABLE_NAME);
        assert((instance.getIndexId()!= null));
        Integer dIndexId = instance.getIndexId();
        if (dIndexId!= null) {
            sqlBuilder.where(ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        Byte dIndexLevel = instance.getIndexLevel();
        if (dIndexLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEVEL);
        }
        Integer dIndexParent = instance.getIndexParent();
        if (dIndexParent!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPARENT);
        }
        Integer dIndexNext = instance.getIndexNext();
        if (dIndexNext!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXNEXT);
        }
        Integer dIndexPrev = instance.getIndexPrev();
        if (dIndexPrev!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPREV);
        }
        Short dIndexIndex = instance.getIndexIndex();
        if (dIndexIndex!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXINDEX);
        }
        Integer dIndexRoot = instance.getIndexRoot();
        if (dIndexRoot!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXROOT);
        }
        Integer dIndexLeftValue = instance.getIndexLeftValue();
        if (dIndexLeftValue!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEFTVALUE);
        }
        Integer dIndexRightValue = instance.getIndexRightValue();
        if (dIndexRightValue!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRIGHTVALUE);
        }
        String dIndexTitle = instance.getIndexTitle();
        if (dIndexTitle!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTITLE);
        }
        String dIndexContent = instance.getIndexContent();
        if (dIndexContent!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCONTENT);
        }
        String dIndexIcon = instance.getIndexIcon();
        if (dIndexIcon!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXICON);
        }
        String dIndexBackground = instance.getIndexBackground();
        if (dIndexBackground!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXBACKGROUND);
        }
        Short dIndexRank = instance.getIndexRank();
        if (dIndexRank!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRANK);
        }
        Integer dIndexPageId = instance.getIndexPageId();
        if (dIndexPageId!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPAGEID);
        }
        Short dIndexChildrenCount = instance.getIndexChildrenCount();
        if (dIndexChildrenCount!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
        }
        String dIndexSequence = instance.getIndexSequence();
        if (dIndexSequence!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSEQUENCE);
        }
        Date dIndexCreateTime = instance.getIndexCreateTime();
        if (dIndexCreateTime!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCREATETIME);
        }
        Date dIndexPublishTime = instance.getIndexPublishTime();
        if (dIndexPublishTime!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPUBLISHTIME);
        }
        EnumIndexStatus dIndexStatus = instance.getIndexStatus();
        if (dIndexStatus!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSTATUS);
        }
        String dIndexResourceUrl = instance.getIndexResourceUrl();
        if (dIndexResourceUrl!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRESOURCEURL);
        }
        String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
        if (dIndexDefaultTemplate!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
        }
        Integer dIndexSubmitBy = instance.getIndexSubmitBy();
        if (dIndexSubmitBy!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBY);
        }
        Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
        if (dIndexSubmitByGp!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYGP);
        }
        Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
        if (dIndexSubmitByIns!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYINS);
        }
        Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
        if (dIndexSubmitByFamily!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
        }
        Short dIndexAuthLevel = instance.getIndexAuthLevel();
        if (dIndexAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXAUTHLEVEL);
        }
        Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
        if (dIndexWrAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
        }
        Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
        if (dIndexExAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
        }
        Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
        if (dIndexSubmitByTopIns!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
        }
        Byte dIndexAspect = instance.getIndexAspect();
        if (dIndexAspect!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXASPECT);
        }
        Integer dIndexRelatedObj = instance.getIndexRelatedObj();
        if (dIndexRelatedObj!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRELATEDOBJ);
        }
        Byte dIndexType = instance.getIndexType();
        if (dIndexType!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTYPE);
        }
        Map<String, Object> param = ModelWikiIndex.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelWikiIndex instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelWikiIndex instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelWikiIndex.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.where(LogicalOpType.in, ModelWikiIndex.FI_INDEXID, "ids", ColumnDataType.intData);
        instance.setIndexId(null);
        Byte dIndexLevel = instance.getIndexLevel();
        if (dIndexLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEVEL);
        }
        Integer dIndexParent = instance.getIndexParent();
        if (dIndexParent!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPARENT);
        }
        Integer dIndexNext = instance.getIndexNext();
        if (dIndexNext!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXNEXT);
        }
        Integer dIndexPrev = instance.getIndexPrev();
        if (dIndexPrev!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPREV);
        }
        Short dIndexIndex = instance.getIndexIndex();
        if (dIndexIndex!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXINDEX);
        }
        Integer dIndexRoot = instance.getIndexRoot();
        if (dIndexRoot!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXROOT);
        }
        Integer dIndexLeftValue = instance.getIndexLeftValue();
        if (dIndexLeftValue!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXLEFTVALUE);
        }
        Integer dIndexRightValue = instance.getIndexRightValue();
        if (dIndexRightValue!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRIGHTVALUE);
        }
        String dIndexTitle = instance.getIndexTitle();
        if (dIndexTitle!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTITLE);
        }
        String dIndexContent = instance.getIndexContent();
        if (dIndexContent!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCONTENT);
        }
        String dIndexIcon = instance.getIndexIcon();
        if (dIndexIcon!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXICON);
        }
        String dIndexBackground = instance.getIndexBackground();
        if (dIndexBackground!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXBACKGROUND);
        }
        Short dIndexRank = instance.getIndexRank();
        if (dIndexRank!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRANK);
        }
        Integer dIndexPageId = instance.getIndexPageId();
        if (dIndexPageId!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPAGEID);
        }
        Short dIndexChildrenCount = instance.getIndexChildrenCount();
        if (dIndexChildrenCount!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
        }
        String dIndexSequence = instance.getIndexSequence();
        if (dIndexSequence!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSEQUENCE);
        }
        Date dIndexCreateTime = instance.getIndexCreateTime();
        if (dIndexCreateTime!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXCREATETIME);
        }
        Date dIndexPublishTime = instance.getIndexPublishTime();
        if (dIndexPublishTime!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXPUBLISHTIME);
        }
        EnumIndexStatus dIndexStatus = instance.getIndexStatus();
        if (dIndexStatus!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSTATUS);
        }
        String dIndexResourceUrl = instance.getIndexResourceUrl();
        if (dIndexResourceUrl!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRESOURCEURL);
        }
        String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
        if (dIndexDefaultTemplate!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
        }
        Integer dIndexSubmitBy = instance.getIndexSubmitBy();
        if (dIndexSubmitBy!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBY);
        }
        Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
        if (dIndexSubmitByGp!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYGP);
        }
        Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
        if (dIndexSubmitByIns!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYINS);
        }
        Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
        if (dIndexSubmitByFamily!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
        }
        Short dIndexAuthLevel = instance.getIndexAuthLevel();
        if (dIndexAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXAUTHLEVEL);
        }
        Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
        if (dIndexWrAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
        }
        Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
        if (dIndexExAuthLevel!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
        }
        Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
        if (dIndexSubmitByTopIns!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
        }
        Byte dIndexAspect = instance.getIndexAspect();
        if (dIndexAspect!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXASPECT);
        }
        Integer dIndexRelatedObj = instance.getIndexRelatedObj();
        if (dIndexRelatedObj!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXRELATEDOBJ);
        }
        Byte dIndexType = instance.getIndexType();
        if (dIndexType!= null) {
            sqlBuilder.items(ModelWikiIndex.FI_INDEXTYPE);
        }
        Map<String, Object> param = ModelWikiIndex.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelWikiIndex instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelWikiIndex instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelWikiIndex.DTO_TABLE_NAME);
        Integer dIndexId = instance.getIndexId();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXID)) {
            assert((dIndexId!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXID, ColumnDataType.intData);
        }
        Byte dIndexLevel = instance.getIndexLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
            assert((dIndexLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXLEVEL, ColumnDataType.byteData);
        }
        Integer dIndexParent = instance.getIndexParent();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPARENT)) {
            assert((dIndexParent!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPARENT, ColumnDataType.intData);
        }
        Integer dIndexNext = instance.getIndexNext();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXNEXT)) {
            assert((dIndexNext!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXNEXT, ColumnDataType.intData);
        }
        Integer dIndexPrev = instance.getIndexPrev();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPREV)) {
            assert((dIndexPrev!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPREV, ColumnDataType.intData);
        }
        Short dIndexIndex = instance.getIndexIndex();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXINDEX)) {
            assert((dIndexIndex!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXINDEX, ColumnDataType.shortData);
        }
        Integer dIndexRoot = instance.getIndexRoot();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXROOT)) {
            assert((dIndexRoot!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXROOT, ColumnDataType.intData);
        }
        Integer dIndexLeftValue = instance.getIndexLeftValue();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
            assert((dIndexLeftValue!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXLEFTVALUE, ColumnDataType.intData);
        }
        Integer dIndexRightValue = instance.getIndexRightValue();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
            assert((dIndexRightValue!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRIGHTVALUE, ColumnDataType.intData);
        }
        String dIndexTitle = instance.getIndexTitle();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTITLE)) {
            assert((dIndexTitle!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXTITLE, ColumnDataType.stringData);
        }
        String dIndexContent = instance.getIndexContent();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
            assert((dIndexContent!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCONTENT, ColumnDataType.stringData);
        }
        String dIndexIcon = instance.getIndexIcon();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXICON)) {
            assert((dIndexIcon!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXICON, ColumnDataType.stringData);
        }
        String dIndexBackground = instance.getIndexBackground();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
            assert((dIndexBackground!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXBACKGROUND, ColumnDataType.stringData);
        }
        Short dIndexRank = instance.getIndexRank();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRANK)) {
            assert((dIndexRank!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRANK, ColumnDataType.shortData);
        }
        Integer dIndexPageId = instance.getIndexPageId();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
            assert((dIndexPageId!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPAGEID, ColumnDataType.intData);
        }
        Short dIndexChildrenCount = instance.getIndexChildrenCount();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
            assert((dIndexChildrenCount!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, ColumnDataType.shortData);
        }
        String dIndexSequence = instance.getIndexSequence();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
            assert((dIndexSequence!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSEQUENCE, ColumnDataType.stringData);
        }
        Date dIndexCreateTime = instance.getIndexCreateTime();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
            assert((dIndexCreateTime!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXCREATETIME, ColumnDataType.timeStampData);
        }
        Date dIndexPublishTime = instance.getIndexPublishTime();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
            assert((dIndexPublishTime!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXPUBLISHTIME, ColumnDataType.timeStampData);
        }
        EnumIndexStatus dIndexStatus = instance.getIndexStatus();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
            assert((dIndexStatus!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSTATUS, ColumnDataType.byteData);
        }
        String dIndexResourceUrl = instance.getIndexResourceUrl();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
            assert((dIndexResourceUrl!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRESOURCEURL, ColumnDataType.stringData);
        }
        String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
            assert((dIndexDefaultTemplate!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, ColumnDataType.stringData);
        }
        Integer dIndexSubmitBy = instance.getIndexSubmitBy();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
            assert((dIndexSubmitBy!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBY, ColumnDataType.intData);
        }
        Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
            assert((dIndexSubmitByGp!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYGP, ColumnDataType.intData);
        }
        Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
            assert((dIndexSubmitByIns!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYINS, ColumnDataType.intData);
        }
        Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
            assert((dIndexSubmitByFamily!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, ColumnDataType.intData);
        }
        Short dIndexAuthLevel = instance.getIndexAuthLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
            assert((dIndexAuthLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXAUTHLEVEL, ColumnDataType.shortData);
        }
        Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
            assert((dIndexWrAuthLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, ColumnDataType.shortData);
        }
        Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
            assert((dIndexExAuthLevel!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, ColumnDataType.shortData);
        }
        Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
            assert((dIndexSubmitByTopIns!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, ColumnDataType.intData);
        }
        Byte dIndexAspect = instance.getIndexAspect();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXASPECT)) {
            assert((dIndexAspect!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXASPECT, ColumnDataType.byteData);
        }
        Integer dIndexRelatedObj = instance.getIndexRelatedObj();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
            assert((dIndexRelatedObj!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXRELATEDOBJ, ColumnDataType.intData);
        }
        Byte dIndexType = instance.getIndexType();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTYPE)) {
            assert((dIndexType!= null));
            sqlBuilder.where(ModelWikiIndex.FI_INDEXTYPE, ColumnDataType.byteData);
        }
        Map<String, Object> param = ModelWikiIndex.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelWikiIndex instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelWikiIndex.DTO_TABLE_NAME);
        assert((id!= null));
        Map<String, Object> param = Collections.singletonMap("id", id);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelWikiIndex.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelWikiIndex updateOrInsert(ModelWikiIndex instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiIndex checkInstance = new ModelWikiIndex();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXID)) {
            checkInstance.setIndexId(instance.getIndexId());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
            checkInstance.setIndexLevel(instance.getIndexLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPARENT)) {
            checkInstance.setIndexParent(instance.getIndexParent());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXNEXT)) {
            checkInstance.setIndexNext(instance.getIndexNext());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPREV)) {
            checkInstance.setIndexPrev(instance.getIndexPrev());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXINDEX)) {
            checkInstance.setIndexIndex(instance.getIndexIndex());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXROOT)) {
            checkInstance.setIndexRoot(instance.getIndexRoot());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
            checkInstance.setIndexLeftValue(instance.getIndexLeftValue());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
            checkInstance.setIndexRightValue(instance.getIndexRightValue());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTITLE)) {
            checkInstance.setIndexTitle(instance.getIndexTitle());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
            checkInstance.setIndexContent(instance.getIndexContent());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXICON)) {
            checkInstance.setIndexIcon(instance.getIndexIcon());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
            checkInstance.setIndexBackground(instance.getIndexBackground());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRANK)) {
            checkInstance.setIndexRank(instance.getIndexRank());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
            checkInstance.setIndexPageId(instance.getIndexPageId());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
            checkInstance.setIndexChildrenCount(instance.getIndexChildrenCount());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
            checkInstance.setIndexSequence(instance.getIndexSequence());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
            checkInstance.setIndexCreateTime(instance.getIndexCreateTime());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
            checkInstance.setIndexPublishTime(instance.getIndexPublishTime());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
            checkInstance.setIndexStatus(instance.getIndexStatus());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
            checkInstance.setIndexResourceUrl(instance.getIndexResourceUrl());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
            checkInstance.setIndexDefaultTemplate(instance.getIndexDefaultTemplate());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
            checkInstance.setIndexSubmitBy(instance.getIndexSubmitBy());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
            checkInstance.setIndexSubmitByGp(instance.getIndexSubmitByGp());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
            checkInstance.setIndexSubmitByIns(instance.getIndexSubmitByIns());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
            checkInstance.setIndexSubmitByFamily(instance.getIndexSubmitByFamily());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
            checkInstance.setIndexAuthLevel(instance.getIndexAuthLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
            checkInstance.setIndexWrAuthLevel(instance.getIndexWrAuthLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
            checkInstance.setIndexExAuthLevel(instance.getIndexExAuthLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
            checkInstance.setIndexSubmitByTopIns(instance.getIndexSubmitByTopIns());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXASPECT)) {
            checkInstance.setIndexAspect(instance.getIndexAspect());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
            checkInstance.setIndexRelatedObj(instance.getIndexRelatedObj());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTYPE)) {
            checkInstance.setIndexType(instance.getIndexType());
        }
        ModelWikiIndex selected = getOneByCond(Collections.singleton(ModelWikiIndex.FI_INDEXID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setIndexId(selected.getIndexId());
            update(instance, Collections.singleton(ModelWikiIndex.FI_INDEXID), assembler);
            return instance;
        }
    }

    public ModelWikiIndex updateOrInsert(ModelWikiIndex instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelWikiIndex insertIfNoExist(ModelWikiIndex instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelWikiIndex checkInstance = new ModelWikiIndex();
        if (conditionField.contains(ModelWikiIndex.FI_INDEXID)) {
            checkInstance.setIndexId(instance.getIndexId());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
            checkInstance.setIndexLevel(instance.getIndexLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPARENT)) {
            checkInstance.setIndexParent(instance.getIndexParent());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXNEXT)) {
            checkInstance.setIndexNext(instance.getIndexNext());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPREV)) {
            checkInstance.setIndexPrev(instance.getIndexPrev());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXINDEX)) {
            checkInstance.setIndexIndex(instance.getIndexIndex());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXROOT)) {
            checkInstance.setIndexRoot(instance.getIndexRoot());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
            checkInstance.setIndexLeftValue(instance.getIndexLeftValue());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
            checkInstance.setIndexRightValue(instance.getIndexRightValue());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTITLE)) {
            checkInstance.setIndexTitle(instance.getIndexTitle());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
            checkInstance.setIndexContent(instance.getIndexContent());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXICON)) {
            checkInstance.setIndexIcon(instance.getIndexIcon());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
            checkInstance.setIndexBackground(instance.getIndexBackground());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRANK)) {
            checkInstance.setIndexRank(instance.getIndexRank());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
            checkInstance.setIndexPageId(instance.getIndexPageId());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
            checkInstance.setIndexChildrenCount(instance.getIndexChildrenCount());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
            checkInstance.setIndexSequence(instance.getIndexSequence());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
            checkInstance.setIndexCreateTime(instance.getIndexCreateTime());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
            checkInstance.setIndexPublishTime(instance.getIndexPublishTime());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
            checkInstance.setIndexStatus(instance.getIndexStatus());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
            checkInstance.setIndexResourceUrl(instance.getIndexResourceUrl());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
            checkInstance.setIndexDefaultTemplate(instance.getIndexDefaultTemplate());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
            checkInstance.setIndexSubmitBy(instance.getIndexSubmitBy());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
            checkInstance.setIndexSubmitByGp(instance.getIndexSubmitByGp());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
            checkInstance.setIndexSubmitByIns(instance.getIndexSubmitByIns());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
            checkInstance.setIndexSubmitByFamily(instance.getIndexSubmitByFamily());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
            checkInstance.setIndexAuthLevel(instance.getIndexAuthLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
            checkInstance.setIndexWrAuthLevel(instance.getIndexWrAuthLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
            checkInstance.setIndexExAuthLevel(instance.getIndexExAuthLevel());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
            checkInstance.setIndexSubmitByTopIns(instance.getIndexSubmitByTopIns());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXASPECT)) {
            checkInstance.setIndexAspect(instance.getIndexAspect());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
            checkInstance.setIndexRelatedObj(instance.getIndexRelatedObj());
        }
        if (conditionField.contains(ModelWikiIndex.FI_INDEXTYPE)) {
            checkInstance.setIndexType(instance.getIndexType());
        }
        ModelWikiIndex selected = getOneByCond(Collections.singleton(ModelWikiIndex.FI_INDEXID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setIndexId(selected.getIndexId());
            return instance;
        }
    }

    public ModelWikiIndex insertIfNoExist(ModelWikiIndex instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelWikiIndex> buildMap(List<ModelWikiIndex> list, String field) {
        Map<TT, ModelWikiIndex> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiIndex item: list) {
            ret.put(ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelWikiIndex>> buildListMap(List<ModelWikiIndex> list, String field) {
        Map<TT, List<ModelWikiIndex>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelWikiIndex item: list) {
            List<ModelWikiIndex> itemList = ret.get(ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelWikiIndex> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelWikiIndex.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiIndex item: list) {
                ret.add(ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
