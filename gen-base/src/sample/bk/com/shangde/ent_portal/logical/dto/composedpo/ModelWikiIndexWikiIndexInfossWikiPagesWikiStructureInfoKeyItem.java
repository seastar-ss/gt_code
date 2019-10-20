package com.shangde.ent_portal.logical.dto.composedpo;

import java.util.List;
import java.util.Map;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage;
import com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

public class ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem
    extends AbstractBaseModel
{
    protected ModelWikiIndex wikiIndex;
    protected List<ModelWikiPage> page;
    protected ModelWikiStructureInfoKeyItem item;
    protected List<ModelWikiIndexInfos> info;
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put("wikiIndex", ModelWikiIndex.class).put("wiki_page", ModelWikiPage.class).put("wiki_structure_info_key_item", ModelWikiStructureInfoKeyItem.class).put("wiki_index_infos", ModelWikiIndexInfos.class).getMap();

    public ModelWikiIndex getWikiIndex() {
        return wikiIndex;
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem setWikiIndex(ModelWikiIndex lWikiIndex) {
        wikiIndex = lWikiIndex;
        return this;
    }

    public List<ModelWikiPage> getPage() {
        return page;
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem setPage(List<ModelWikiPage> lPage) {
        page = lPage;
        return this;
    }

    public ModelWikiStructureInfoKeyItem getItem() {
        return item;
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem setItem(ModelWikiStructureInfoKeyItem lItem) {
        item = lItem;
        return this;
    }

    public List<ModelWikiIndexInfos> getInfo() {
        return info;
    }

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem setInfo(List<ModelWikiIndexInfos> lInfo) {
        info = lInfo;
        return this;
    }

    public boolean isEmpty() {
        if (wikiIndex!= null) {
            return false;
        }
        if (page!= null) {
            return false;
        }
        if (item!= null) {
            return false;
        }
        if (info!= null) {
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Object> getFieldConfig() {
        return FIELD_CLASS;
    }
}
