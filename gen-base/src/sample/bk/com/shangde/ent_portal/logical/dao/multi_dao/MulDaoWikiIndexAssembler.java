package com.shangde.ent_portal.logical.dao.multi_dao;

import java.util.List;
import java.util.Map;
import com.shangde.ent_portal.logical.dto.composedpo.ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;

public abstract class MulDaoWikiIndexAssembler
    extends AbstractMultipleDaoAssembler
{
    protected ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem ret;
    protected List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> rets = CollectionHelper.newList();
    public final static int RND_OF_WIKI_INDEX = 0;
    public final static int RND_OF_PAGE = 1;
    public final static int RND_OF_ITEM = 2;
    public final static int RND_OF_INFO = 3;

    public ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem getRet() {
        return ret;
    }

    public MulDaoWikiIndexAssembler setRet(ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem lRet) {
        ret = lRet;
        return this;
    }

    public List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> getRets() {
        return rets;
    }

    public MulDaoWikiIndexAssembler setRets(List<ModelWikiIndexWikiIndexInfossWikiPagesWikiStructureInfoKeyItem> lRets) {
        rets = lRets;
        return this;
    }

    public void clearData() {
        ret = null;
        rets.clear();
    }

    public int assembleSql(SQL sql, Map<String, Object> param, Class<? extends AbstractBaseModel> tClass) {
        if (getIndex() == RND_OF_WIKI_INDEX) {
            return assembleSqlWikiIndex(sql, param, tClass);
        }
        if (getIndex() == RND_OF_PAGE) {
            return assembleSqlPage(sql, param, tClass);
        }
        if (getIndex() == RND_OF_ITEM) {
            return assembleSqlItem(sql, param, tClass);
        }
        if (getIndex() == RND_OF_INFO) {
            return assembleSqlInfo(sql, param, tClass);
        }
        return  1;
    }

    protected int assembleSqlWikiIndex(SQL sql, Map<String, Object> param, Class<? extends AbstractBaseModel> tClass) {
        return  0;
    }

    protected int assembleSqlPage(SQL sql, Map<String, Object> param, Class<? extends AbstractBaseModel> tClass) {
        return  0;
    }

    protected int assembleSqlItem(SQL sql, Map<String, Object> param, Class<? extends AbstractBaseModel> tClass) {
        return  0;
    }

    protected int assembleSqlInfo(SQL sql, Map<String, Object> param, Class<? extends AbstractBaseModel> tClass) {
        return  0;
    }
}
