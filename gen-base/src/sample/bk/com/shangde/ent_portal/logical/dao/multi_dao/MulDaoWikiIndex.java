package com.shangde.ent_portal.logical.dao.multi_dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dao.basedao.DAOWikiIndex;
import com.shangde.ent_portal.logical.dao.basedao.DAOWikiIndexInfos;
import com.shangde.ent_portal.logical.dao.basedao.DAOWikiPage;
import com.shangde.ent_portal.logical.dao.basedao.DAOWikiStructureInfoKeyItem;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem;
import com.shangde.ent_portal.logical.dto.composedpo.ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem;

@SuppressWarnings("unchecked")
public abstract class MulDaoWikiIndex
    extends AbstractDao<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem, Integer>
    implements DaoInterface<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(MulDaoWikiIndex.class);
    @Autowired
    protected DAOWikiIndex daoWikiIndex;
    @Autowired
    protected DAOWikiPage daoWikiPage;
    @Autowired
    protected DAOWikiStructureInfoKeyItem daoWikiStructureInfoKeyItem;
    @Autowired
    protected DAOWikiIndexInfos daoWikiIndexInfos;

    public MulDaoWikiIndex() {
        super(ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem.class);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
    }

    protected void assembleMainDataList(List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel, List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret) {
        if ((mainModel == null)||(mainModel.size() == 0)) {
            return;
        }
        for (com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex model: mainModel) {
            ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem wrapper = new ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem();
            wrapper.setWikiIndex(model);
            ret.add(wrapper);
        }
    }

    protected void assembleMainData(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainModel, ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret) {
        if (mainModel == null) {
            return;
        }
        ret.setWikiIndex(mainModel);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> get(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer start, Integer count) {
        List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newList();
        assembler.clearData();
        assembler.setRets(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel = getMainDataViaGet(selectFields, assembler, start, count);
        assembleMainDataList(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetByIndexAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> getMainDataViaGet(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> allMainList = daoWikiIndex.get(selectFields, assembler, start, count);
        return allMainList;
    }

    protected void getSubDataPagesViaGetByIndex(List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainData, List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret, Set<String> selectFields, MulDaoWikiIndexAssembler assembler) {
        if ((mainData == null)||(mainData.size() == 0)) {
            return;
        }
        List<Integer> list = daoWikiIndex.<Integer> extractItemAsList(mainData, com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FI_INDEXPAGEID);
        List<ModelWikiPage> subModels = daoWikiPage.getByIndex(selectFields, assembler, null, null, ModelWikiPage.FI_PAGEID, list);
        Map<Integer, List<ModelWikiPage>> subModelMap = daoWikiPage.buildListMap(subModels, ModelWikiPage.FI_PAGEID);
        for (ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem wrapper: ret) {
            Integer mainId = wrapper.getWikiIndex().getIndexPageId();
            wrapper.setPage(subModelMap.get(mainId));
        }
    }

    protected void getSubDataItemViaGetByIndexAndWhere(List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainData, List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret, Set<String> selectFields, MulDaoWikiIndexAssembler assembler) {
        if ((mainData == null)||(mainData.size() == 0)) {
            return;
        }
        List<Integer> list = daoWikiIndex.<Integer> extractItemAsList(mainData, com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FI_INDEXPAGEID);
        List<ModelWikiStructureInfoKeyItem> subModels = daoWikiStructureInfoKeyItem.getByIndexAndWhere(selectFields, assembler, null, null, ModelWikiStructureInfoKeyItem.FI_ITEMID, list, null, Collections.singleton("pageType in (2,5,6)"));
        Map<Integer, ModelWikiStructureInfoKeyItem> subModelMap = daoWikiStructureInfoKeyItem.buildMap(subModels, ModelWikiStructureInfoKeyItem.FI_ITEMID);
        for (ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem wrapper: ret) {
            Integer mainId = wrapper.getWikiIndex().getIndexPageId();
            wrapper.setItem(subModelMap.get(mainId));
        }
    }

    protected void getSubDataInfosViaGetByCondAndIndex(List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainData, List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret, Set<String> selectFields, MulDaoWikiIndexAssembler assembler) {
        if ((mainData == null)||(mainData.size() == 0)) {
            return;
        }
        ModelWikiIndexInfos instance = new ModelWikiIndexInfos();
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainDataFirst = mainData.get(0);
        String mainIdIndexTitle = mainDataFirst.getIndexTitle();
        instance.setCmsInfoName(mainIdIndexTitle);
        List<Integer> list = daoWikiIndex.<Integer> extractItemAsList(mainData, com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FI_INDEXID);
        List<ModelWikiIndexInfos> subModels = daoWikiIndexInfos.getByCondAndIndex(selectFields, assembler, null, null, instance, ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, list);
        Map<Integer, List<ModelWikiIndexInfos>> subModelMap = daoWikiIndexInfos.buildListMap(subModels, ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
        for (ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem wrapper: ret) {
            Integer mainId = wrapper.getWikiIndex().getIndexId();
            wrapper.setInfo(subModelMap.get(mainId));
        }
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> get(MulDaoWikiIndexAssembler assembler, Integer start, Integer count) {
        return get(null, assembler, start, count);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> get(MulDaoWikiIndexAssembler assembler) {
        return get(assembler, null, null);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByCond(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer start, Integer count, ModelWikiIndex instance) {
        List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newList();
        assembler.clearData();
        assembler.setRets(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel = getMainDataViaGetByCond(selectFields, assembler, start, count, instance);
        assembleMainDataList(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetByIndexAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> getMainDataViaGetByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance) {
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> allMainList = daoWikiIndex.getByCond(selectFields, assembler, start, count, instance);
        return allMainList;
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByCond(MulDaoWikiIndexAssembler assembler, Integer start, Integer count, ModelWikiIndex instance) {
        return getByCond(null, assembler, start, count, instance);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByCond(MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance) {
        return getByCond(assembler, null, null, instance);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newList();
        assembler.clearData();
        assembler.setRets(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel = getMainDataViaGetByCondAndIndexAndWhere(selectFields, assembler, start, count, instance, inField, indexes, extParam, extCondition);
        assembleMainDataList(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetByIndexAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> getMainDataViaGetByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> allMainList = daoWikiIndex.getByCondAndIndexAndWhere(selectFields, assembler, start, count, instance, inField, indexes, extParam, extCondition);
        return allMainList;
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(MulDaoWikiIndexAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, assembler, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByCondAndIndexAndWhere(MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(assembler, null, null, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getById(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer start, Integer count, List<Integer> indexId) {
        List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newList();
        assembler.clearData();
        assembler.setRets(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel = getMainDataViaGetById(selectFields, assembler, start, count, indexId);
        assembleMainDataList(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetByIndexAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> getMainDataViaGetById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> indexId) {
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> allMainList = daoWikiIndex.getById(selectFields, assembler, start, count, indexId);
        return allMainList;
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getById(MulDaoWikiIndexAssembler assembler, Integer start, Integer count, List<Integer> indexId) {
        return getById(null, assembler, start, count, indexId);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getById(MulDaoWikiIndexAssembler assembler, List<Integer> indexId) {
        return getById(assembler, null, null, indexId);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByIdAndCondAndWhere(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newList();
        assembler.clearData();
        assembler.setRets(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel = getMainDataViaGetByIdAndCondAndWhere(selectFields, assembler, start, count, instance, indexId, extParam, extCondition);
        assembleMainDataList(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetByIndexAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> getMainDataViaGetByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> allMainList = daoWikiIndex.getByIdAndCondAndWhere(selectFields, assembler, start, count, instance, indexId, extParam, extCondition);
        return allMainList;
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByIdAndCondAndWhere(MulDaoWikiIndexAssembler assembler, Integer start, Integer count, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, assembler, start, count, instance, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByIdAndCondAndWhere(MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance, List<Integer> indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(assembler, null, null, instance, indexId, extParam, extCondition);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByIndex(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newList();
        assembler.clearData();
        assembler.setRets(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> mainModel = getMainDataViaGetByIndex(selectFields, assembler, start, count, inField, indexes);
        assembleMainDataList(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetByIndexAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> getMainDataViaGetByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        List<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex> allMainList = daoWikiIndex.getByIndex(selectFields, assembler, start, count, inField, indexes);
        return allMainList;
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByIndex(MulDaoWikiIndexAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, assembler, start, count, inField, indexes);
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getByIndex(MulDaoWikiIndexAssembler assembler, String inField, List indexes) {
        return getByIndex(assembler, null, null, inField, indexes);
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getOneByCond(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance) {
        ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret = new ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem();
        assembler.clearData();
        assembler.setRet(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainModel = getMainDataViaGetOneByCond(selectFields, assembler, instance);
        assembleMainData(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetOneByCondAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex getMainDataViaGetOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndex instance) {
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex allMainList = daoWikiIndex.getOneByCond(selectFields, assembler, instance);
        return allMainList;
    }

    protected void getSubDataPagesViaGetByIndex(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainData, ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret, Set<String> selectFields, MulDaoWikiIndexAssembler assembler) {
        if (mainData == null) {
            return;
        }
        List<Integer> list = daoWikiIndex.<Integer> extractItemAsList(Collections.singletonList(mainData), com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FI_INDEXPAGEID);
        List<ModelWikiPage> subModel = daoWikiPage.getByIndex(selectFields, assembler, null, null, ModelWikiPage.FI_PAGEID, list);
        ret.setPage(subModel);
    }

    protected void getSubDataItemViaGetOneByCondAndWhere(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainData, ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret, Set<String> selectFields, MulDaoWikiIndexAssembler assembler) {
        if (mainData == null) {
            return;
        }
        ModelWikiStructureInfoKeyItem instance = new ModelWikiStructureInfoKeyItem();
        Integer mainId = mainData.getIndexPageId();
        instance.setItemId(mainId);
        ModelWikiStructureInfoKeyItem subModel = daoWikiStructureInfoKeyItem.getOneByCondAndWhere(selectFields, assembler, instance, null, Collections.singleton("pageType in (2,5,6)"));
        ret.setItem(subModel);
    }

    protected void getSubDataInfosViaGetByCondAndIndex(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainData, ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret, Set<String> selectFields, MulDaoWikiIndexAssembler assembler) {
        if (mainData == null) {
            return;
        }
        ModelWikiIndexInfos instance = new ModelWikiIndexInfos();
        String mainIdIndexTitle = mainData.getIndexTitle();
        instance.setCmsInfoName(mainIdIndexTitle);
        List<Integer> list = daoWikiIndex.<Integer> extractItemAsList(Collections.singletonList(mainData), com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FI_INDEXID);
        List<ModelWikiIndexInfos> subModel = daoWikiIndexInfos.getByCondAndIndex(selectFields, assembler, null, null, instance, ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, list);
        ret.setInfo(subModel);
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getOneByCond(MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance) {
        return getOneByCond(null, assembler, instance);
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getOneById(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, Integer indexId) {
        ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret = new ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem();
        assembler.clearData();
        assembler.setRet(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainModel = getMainDataViaGetOneById(selectFields, assembler, indexId);
        assembleMainData(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetOneByCondAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex getMainDataViaGetOneById(Set<String> selectFields, DaoAssembler assembler, Integer indexId) {
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex allMainList = daoWikiIndex.getOneById(selectFields, assembler, indexId);
        return allMainList;
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getOneById(MulDaoWikiIndexAssembler assembler, Integer indexId) {
        return getOneById(null, assembler, indexId);
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getOneByIdAndCondAndWhere(Set<String> selectFields, MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret = new ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem();
        assembler.clearData();
        assembler.setRet(ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_WIKI_INDEX);
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainModel = getMainDataViaGetOneByIdAndCondAndWhere(selectFields, assembler, instance, indexId, extParam, extCondition);
        assembleMainData(mainModel, ret);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_PAGE);
        getSubDataPagesViaGetByIndex(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_ITEM);
        getSubDataItemViaGetOneByCondAndWhere(mainModel, ret, selectFields, assembler);
        assembler.setIndex(MulDaoWikiIndexAssembler.RND_OF_INFO);
        getSubDataInfosViaGetByCondAndIndex(mainModel, ret, selectFields, assembler);
        return ret;
    }

    protected com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex getMainDataViaGetOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelWikiIndex instance, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex allMainList = daoWikiIndex.getOneByIdAndCondAndWhere(selectFields, assembler, instance, indexId, extParam, extCondition);
        return allMainList;
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getOneByIdAndCondAndWhere(MulDaoWikiIndexAssembler assembler, ModelWikiIndex instance, Integer indexId, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, assembler, instance, indexId, extParam, extCondition);
    }

    public<TT> List<TT> extractItemAsList(List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem item: list) {
                com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainVar = item.getWikiIndex();
                ret.add(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, mainVar));
            }
        }
        return ret;
    }

    public<TT> Map<TT, ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> buildMap(List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> list, String field) {
        Map<TT, ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        if (com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem item: list) {
                com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainVar = item.getWikiIndex();
                ret.put(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, mainVar), item);
            }
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem>> buildListMap(List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> list, String field) {
        Map<TT, List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        if (com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.FIELD_CLASS.containsKey(field)) {
            for (ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem item: list) {
                com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex mainVar = item.getWikiIndex();
                List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> itemList = ret.get(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, mainVar));
                if (itemList == null) {
                    itemList = CollectionHelper.newList();
                }
                itemList.add(item);
                ret.put(com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex.MAP_OBJ_MAPPER.<TT> getField(field, mainVar), itemList);
            }
        }
        return ret;
    }
}
