/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumIndexStatus;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers._ObjMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :wiki_index
 * 	知识索引表
 * 用于索引知识，每个索引信息只能对应一个知识
 */
public class ModelWikiIndex
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "indexId";
    public final static String DTO_TABLE_NAME = "wiki_index";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.wiki_index.indexId 字段
     * 
     */
    Integer indexId;
    public final static String FI_INDEXID = "indexId";
    /**
     * 对应数据库.wiki_index.indexLevel 字段
     * 索引所在层级
     */
    Byte indexLevel;
    public final static String FI_INDEXLEVEL = "indexLevel";
    /**
     * 对应数据库.wiki_index.indexParent 字段
     * 上一级索引
     */
    Integer indexParent;
    public final static String FI_INDEXPARENT = "indexParent";
    /**
     * 对应数据库.wiki_index.indexNext 字段
     * 下一个索引，可以手动设置
     */
    Integer indexNext;
    public final static String FI_INDEXNEXT = "indexNext";
    /**
     * 对应数据库.wiki_index.indexPrev 字段
     * 上一个索引，可以手动设置
     */
    Integer indexPrev;
    public final static String FI_INDEXPREV = "indexPrev";
    /**
     * 对应数据库.wiki_index.indexIndex 字段
     * 索引从叶节点起算的高度
     */
    Short indexIndex;
    public final static String FI_INDEXINDEX = "indexIndex";
    /**
     * 对应数据库.wiki_index.indexRoot 字段
     * 索引的根节点,控制多层的父级节点展示如果此值不为0则表示，在返回多层级的结构时，仅当下层子节点的数目多于此值，才会返回此节点例如设置为1之后，如果此节点下无子节点，则此节点也不会出现在结果中
     */
    Integer indexRoot;
    public final static String FI_INDEXROOT = "indexRoot";
    /**
     * 对应数据库.wiki_index.indexLeftValue 字段
     * 区间索引左值
     */
    Integer indexLeftValue;
    public final static String FI_INDEXLEFTVALUE = "indexLeftValue";
    /**
     * 对应数据库.wiki_index.indexRightValue 字段
     * 区间索引右值
     */
    Integer indexRightValue;
    public final static String FI_INDEXRIGHTVALUE = "indexRightValue";
    /**
     * 对应数据库.wiki_index.indexTitle 字段
     * 索引的标题
     */
    String indexTitle;
    public final static String FI_INDEXTITLE = "indexTitle";
    /**
     * 对应数据库.wiki_index.indexContent 字段
     * 索引的内容（类似副标题）
     */
    String indexContent;
    public final static String FI_INDEXCONTENT = "indexContent";
    /**
     * 对应数据库.wiki_index.indexIcon 字段
     * 索引的图标
     */
    String indexIcon;
    public final static String FI_INDEXICON = "indexIcon";
    /**
     * 对应数据库.wiki_index.indexBackground 字段
     * 
     */
    String indexBackground;
    public final static String FI_INDEXBACKGROUND = "indexBackground";
    /**
     * 对应数据库.wiki_index.indexRank 字段
     * 索引排序，越小越靠前
     */
    Short indexRank;
    public final static String FI_INDEXRANK = "indexRank";
    /**
     * 对应数据库.wiki_index.IndexPageId 字段
     * 知识关联id，为0表示文件夹
     */
    Integer indexPageId;
    public final static String FI_INDEXPAGEID = "IndexPageId";
    /**
     * 对应数据库.wiki_index.indexChildrenCount 字段
     * 下级文件夹中的数目
     */
    Short indexChildrenCount;
    public final static String FI_INDEXCHILDRENCOUNT = "indexChildrenCount";
    /**
     * 对应数据库.wiki_index.indexSequence 字段
     * 层级结构，可维护类似文件夹路径的结构
     */
    String indexSequence;
    public final static String FI_INDEXSEQUENCE = "indexSequence";
    /**
     * 对应数据库.wiki_index.indexCreateTime 字段
     * 知识的创建时间
     */
    Date indexCreateTime;
    public final static String FI_INDEXCREATETIME = "indexCreateTime";
    /**
     * 对应数据库.wiki_index.indexPublishTime 字段
     * 
     */
    Date indexPublishTime;
    public final static String FI_INDEXPUBLISHTIME = "indexPublishTime";
    /**
     * 对应数据库.wiki_index.indexStatus 字段
     * 
     */
    EnumIndexStatus indexStatus;
    public final static String FI_INDEXSTATUS = "indexStatus";
    /**
     * 对应数据库.wiki_index.indexResourceUrl 字段
     * 索引内容的资源地址（视频和音频等信息可以直接记录此字段）
     */
    String indexResourceUrl;
    public final static String FI_INDEXRESOURCEURL = "indexResourceUrl";
    /**
     * 对应数据库.wiki_index.indexDefaultTemplate 字段
     * 此索引下默认页面模板，子级索引会继承父级的此属性
     */
    String indexDefaultTemplate;
    public final static String FI_INDEXDEFAULTTEMPLATE = "indexDefaultTemplate";
    /**
     * 对应数据库.wiki_index.indexSubmitBy 字段
     * 创建人
     */
    Integer indexSubmitBy;
    public final static String FI_INDEXSUBMITBY = "indexSubmitBy";
    /**
     * 对应数据库.wiki_index.indexSubmitByGp 字段
     * 创建组
     */
    Integer indexSubmitByGp;
    public final static String FI_INDEXSUBMITBYGP = "indexSubmitByGp";
    /**
     * 对应数据库.wiki_index.indexSubmitByIns 字段
     * 创建学院
     */
    Integer indexSubmitByIns;
    public final static String FI_INDEXSUBMITBYINS = "indexSubmitByIns";
    /**
     * 对应数据库.wiki_index.indexSubmitByFamily 字段
     * 创建家族
     */
    Integer indexSubmitByFamily;
    public final static String FI_INDEXSUBMITBYFAMILY = "indexSubmitByFamily";
    /**
     * 对应数据库.wiki_index.indexAuthLevel 字段
     * 读权限限制值
     */
    Short indexAuthLevel;
    public final static String FI_INDEXAUTHLEVEL = "indexAuthLevel";
    /**
     * 对应数据库.wiki_index.indexWrAuthLevel 字段
     * 写权限限制值
     */
    Short indexWrAuthLevel;
    public final static String FI_INDEXWRAUTHLEVEL = "indexWrAuthLevel";
    /**
     * 对应数据库.wiki_index.indexExAuthLevel 字段
     * 文件夹管理权限限制值
     */
    Short indexExAuthLevel;
    public final static String FI_INDEXEXAUTHLEVEL = "indexExAuthLevel";
    /**
     * 对应数据库.wiki_index.indexSubmitByTopIns 字段
     * 创建者顶级组织
     */
    Integer indexSubmitByTopIns;
    public final static String FI_INDEXSUBMITBYTOPINS = "indexSubmitByTopIns";
    /**
     * 对应数据库.wiki_index.indexAspect 字段
     * 索引类型0 普通文件夹索引1 字段分类索引
     */
    Byte indexAspect;
    public final static String FI_INDEXASPECT = "indexAspect";
    /**
     * 对应数据库.wiki_index.indexRelatedObj 字段
     * 索引关联数据项
     */
    Integer indexRelatedObj;
    public final static String FI_INDEXRELATEDOBJ = "indexRelatedObj";
    /**
     * 对应数据库.wiki_index.indexType 字段
     * 索引类型：aspect=0 无意义apsect=1 同wiki_structure_info_key_item.itemType区分节点是否内容基础平台
     */
    Byte indexType;
    public final static String FI_INDEXTYPE = "indexType";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelWikiIndex.FI_INDEXID, Integer.class).put(ModelWikiIndex.FI_INDEXLEVEL, Byte.class).put(ModelWikiIndex.FI_INDEXPARENT, Integer.class).put(ModelWikiIndex.FI_INDEXNEXT, Integer.class).put(ModelWikiIndex.FI_INDEXPREV, Integer.class).put(ModelWikiIndex.FI_INDEXINDEX, Short.class).put(ModelWikiIndex.FI_INDEXROOT, Integer.class).put(ModelWikiIndex.FI_INDEXLEFTVALUE, Integer.class).put(ModelWikiIndex.FI_INDEXRIGHTVALUE, Integer.class).put(ModelWikiIndex.FI_INDEXTITLE, String.class).put(ModelWikiIndex.FI_INDEXCONTENT, String.class).put(ModelWikiIndex.FI_INDEXICON, String.class).put(ModelWikiIndex.FI_INDEXBACKGROUND, String.class).put(ModelWikiIndex.FI_INDEXRANK, Short.class).put(ModelWikiIndex.FI_INDEXPAGEID, Integer.class).put(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, Short.class).put(ModelWikiIndex.FI_INDEXSEQUENCE, String.class).put(ModelWikiIndex.FI_INDEXCREATETIME, Date.class).put(ModelWikiIndex.FI_INDEXPUBLISHTIME, Date.class).put(ModelWikiIndex.FI_INDEXSTATUS, EnumIndexStatus.class).put(ModelWikiIndex.FI_INDEXRESOURCEURL, String.class).put(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, String.class).put(ModelWikiIndex.FI_INDEXSUBMITBY, Integer.class).put(ModelWikiIndex.FI_INDEXSUBMITBYGP, Integer.class).put(ModelWikiIndex.FI_INDEXSUBMITBYINS, Integer.class).put(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, Integer.class).put(ModelWikiIndex.FI_INDEXAUTHLEVEL, Short.class).put(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, Short.class).put(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, Short.class).put(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, Integer.class).put(ModelWikiIndex.FI_INDEXASPECT, Byte.class).put(ModelWikiIndex.FI_INDEXRELATEDOBJ, Integer.class).put(ModelWikiIndex.FI_INDEXTYPE, Byte.class).getMap();
    public final static Integer FIELD_COUNT = 33;
    public final static ResultSetMapperModelWikiIndex<ModelWikiIndex> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelWikiIndex<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndex>();
    public final static ByteMapMapperModelWikiIndex MAP_OBJ_MAPPER = new ByteMapMapperModelWikiIndex();

    public ModelWikiIndex() {
    }

    public Integer getIndexId() {
        return indexId;
    }

    public ModelWikiIndex setIndexId(Integer lIndexId) {
        indexId = lIndexId;
        return this;
    }

    public Byte getIndexLevel() {
        return indexLevel;
    }

    public ModelWikiIndex setIndexLevel(Byte lIndexLevel) {
        indexLevel = lIndexLevel;
        return this;
    }

    public Integer getIndexParent() {
        return indexParent;
    }

    public ModelWikiIndex setIndexParent(Integer lIndexParent) {
        indexParent = lIndexParent;
        return this;
    }

    public Integer getIndexNext() {
        return indexNext;
    }

    public ModelWikiIndex setIndexNext(Integer lIndexNext) {
        indexNext = lIndexNext;
        return this;
    }

    public Integer getIndexPrev() {
        return indexPrev;
    }

    public ModelWikiIndex setIndexPrev(Integer lIndexPrev) {
        indexPrev = lIndexPrev;
        return this;
    }

    public Short getIndexIndex() {
        return indexIndex;
    }

    public ModelWikiIndex setIndexIndex(Short lIndexIndex) {
        indexIndex = lIndexIndex;
        return this;
    }

    public Integer getIndexRoot() {
        return indexRoot;
    }

    public ModelWikiIndex setIndexRoot(Integer lIndexRoot) {
        indexRoot = lIndexRoot;
        return this;
    }

    public Integer getIndexLeftValue() {
        return indexLeftValue;
    }

    public ModelWikiIndex setIndexLeftValue(Integer lIndexLeftValue) {
        indexLeftValue = lIndexLeftValue;
        return this;
    }

    public Integer getIndexRightValue() {
        return indexRightValue;
    }

    public ModelWikiIndex setIndexRightValue(Integer lIndexRightValue) {
        indexRightValue = lIndexRightValue;
        return this;
    }

    public String getIndexTitle() {
        return indexTitle;
    }

    public ModelWikiIndex setIndexTitle(String lIndexTitle) {
        indexTitle = lIndexTitle;
        return this;
    }

    public String getIndexContent() {
        return indexContent;
    }

    public ModelWikiIndex setIndexContent(String lIndexContent) {
        indexContent = lIndexContent;
        return this;
    }

    public String getIndexIcon() {
        return indexIcon;
    }

    public ModelWikiIndex setIndexIcon(String lIndexIcon) {
        indexIcon = lIndexIcon;
        return this;
    }

    public String getIndexBackground() {
        return indexBackground;
    }

    public ModelWikiIndex setIndexBackground(String lIndexBackground) {
        indexBackground = lIndexBackground;
        return this;
    }

    public Short getIndexRank() {
        return indexRank;
    }

    public ModelWikiIndex setIndexRank(Short lIndexRank) {
        indexRank = lIndexRank;
        return this;
    }

    public Integer getIndexPageId() {
        return indexPageId;
    }

    public ModelWikiIndex setIndexPageId(Integer lIndexPageId) {
        indexPageId = lIndexPageId;
        return this;
    }

    public Short getIndexChildrenCount() {
        return indexChildrenCount;
    }

    public ModelWikiIndex setIndexChildrenCount(Short lIndexChildrenCount) {
        indexChildrenCount = lIndexChildrenCount;
        return this;
    }

    public String getIndexSequence() {
        return indexSequence;
    }

    public ModelWikiIndex setIndexSequence(String lIndexSequence) {
        indexSequence = lIndexSequence;
        return this;
    }

    public Date getIndexCreateTime() {
        return indexCreateTime;
    }

    public ModelWikiIndex setIndexCreateTime(Date lIndexCreateTime) {
        indexCreateTime = lIndexCreateTime;
        return this;
    }

    public Date getIndexPublishTime() {
        return indexPublishTime;
    }

    public ModelWikiIndex setIndexPublishTime(Date lIndexPublishTime) {
        indexPublishTime = lIndexPublishTime;
        return this;
    }

    public EnumIndexStatus getIndexStatus() {
        return indexStatus;
    }

    public ModelWikiIndex setIndexStatus(EnumIndexStatus lIndexStatus) {
        indexStatus = lIndexStatus;
        return this;
    }

    public String getIndexResourceUrl() {
        return indexResourceUrl;
    }

    public ModelWikiIndex setIndexResourceUrl(String lIndexResourceUrl) {
        indexResourceUrl = lIndexResourceUrl;
        return this;
    }

    public String getIndexDefaultTemplate() {
        return indexDefaultTemplate;
    }

    public ModelWikiIndex setIndexDefaultTemplate(String lIndexDefaultTemplate) {
        indexDefaultTemplate = lIndexDefaultTemplate;
        return this;
    }

    public Integer getIndexSubmitBy() {
        return indexSubmitBy;
    }

    public ModelWikiIndex setIndexSubmitBy(Integer lIndexSubmitBy) {
        indexSubmitBy = lIndexSubmitBy;
        return this;
    }

    public Integer getIndexSubmitByGp() {
        return indexSubmitByGp;
    }

    public ModelWikiIndex setIndexSubmitByGp(Integer lIndexSubmitByGp) {
        indexSubmitByGp = lIndexSubmitByGp;
        return this;
    }

    public Integer getIndexSubmitByIns() {
        return indexSubmitByIns;
    }

    public ModelWikiIndex setIndexSubmitByIns(Integer lIndexSubmitByIns) {
        indexSubmitByIns = lIndexSubmitByIns;
        return this;
    }

    public Integer getIndexSubmitByFamily() {
        return indexSubmitByFamily;
    }

    public ModelWikiIndex setIndexSubmitByFamily(Integer lIndexSubmitByFamily) {
        indexSubmitByFamily = lIndexSubmitByFamily;
        return this;
    }

    public Short getIndexAuthLevel() {
        return indexAuthLevel;
    }

    public ModelWikiIndex setIndexAuthLevel(Short lIndexAuthLevel) {
        indexAuthLevel = lIndexAuthLevel;
        return this;
    }

    public Short getIndexWrAuthLevel() {
        return indexWrAuthLevel;
    }

    public ModelWikiIndex setIndexWrAuthLevel(Short lIndexWrAuthLevel) {
        indexWrAuthLevel = lIndexWrAuthLevel;
        return this;
    }

    public Short getIndexExAuthLevel() {
        return indexExAuthLevel;
    }

    public ModelWikiIndex setIndexExAuthLevel(Short lIndexExAuthLevel) {
        indexExAuthLevel = lIndexExAuthLevel;
        return this;
    }

    public Integer getIndexSubmitByTopIns() {
        return indexSubmitByTopIns;
    }

    public ModelWikiIndex setIndexSubmitByTopIns(Integer lIndexSubmitByTopIns) {
        indexSubmitByTopIns = lIndexSubmitByTopIns;
        return this;
    }

    public Byte getIndexAspect() {
        return indexAspect;
    }

    public ModelWikiIndex setIndexAspect(Byte lIndexAspect) {
        indexAspect = lIndexAspect;
        return this;
    }

    public Integer getIndexRelatedObj() {
        return indexRelatedObj;
    }

    public ModelWikiIndex setIndexRelatedObj(Integer lIndexRelatedObj) {
        indexRelatedObj = lIndexRelatedObj;
        return this;
    }

    public Byte getIndexType() {
        return indexType;
    }

    public ModelWikiIndex setIndexType(Byte lIndexType) {
        indexType = lIndexType;
        return this;
    }

    @Override
    public Map<String, Object> getFieldConfig() {
        return FIELD_CLASS;
    }

    public boolean isEmpty() {
        if (!super.isEmpty()) {
            return false;
        }
        if (getIndexId()!= null) {
            return false;
        }
        if (getIndexLevel()!= null) {
            return false;
        }
        if (getIndexParent()!= null) {
            return false;
        }
        if (getIndexNext()!= null) {
            return false;
        }
        if (getIndexPrev()!= null) {
            return false;
        }
        if (getIndexIndex()!= null) {
            return false;
        }
        if (getIndexRoot()!= null) {
            return false;
        }
        if (getIndexLeftValue()!= null) {
            return false;
        }
        if (getIndexRightValue()!= null) {
            return false;
        }
        if (getIndexTitle()!= null) {
            return false;
        }
        if (getIndexContent()!= null) {
            return false;
        }
        if (getIndexIcon()!= null) {
            return false;
        }
        if (getIndexBackground()!= null) {
            return false;
        }
        if (getIndexRank()!= null) {
            return false;
        }
        if (getIndexPageId()!= null) {
            return false;
        }
        if (getIndexChildrenCount()!= null) {
            return false;
        }
        if (getIndexSequence()!= null) {
            return false;
        }
        if (getIndexCreateTime()!= null) {
            return false;
        }
        if (getIndexPublishTime()!= null) {
            return false;
        }
        if (getIndexStatus()!= null) {
            return false;
        }
        if (getIndexResourceUrl()!= null) {
            return false;
        }
        if (getIndexDefaultTemplate()!= null) {
            return false;
        }
        if (getIndexSubmitBy()!= null) {
            return false;
        }
        if (getIndexSubmitByGp()!= null) {
            return false;
        }
        if (getIndexSubmitByIns()!= null) {
            return false;
        }
        if (getIndexSubmitByFamily()!= null) {
            return false;
        }
        if (getIndexAuthLevel()!= null) {
            return false;
        }
        if (getIndexWrAuthLevel()!= null) {
            return false;
        }
        if (getIndexExAuthLevel()!= null) {
            return false;
        }
        if (getIndexSubmitByTopIns()!= null) {
            return false;
        }
        if (getIndexAspect()!= null) {
            return false;
        }
        if (getIndexRelatedObj()!= null) {
            return false;
        }
        if (getIndexType()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiIndex.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiIndex.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("indexId").append(":").append(indexId).append("}\n");
        ret.append("{").append("indexLevel").append(":").append(indexLevel).append("}\n");
        ret.append("{").append("indexParent").append(":").append(indexParent).append("}\n");
        ret.append("{").append("indexNext").append(":").append(indexNext).append("}\n");
        ret.append("{").append("indexPrev").append(":").append(indexPrev).append("}\n");
        ret.append("{").append("indexIndex").append(":").append(indexIndex).append("}\n");
        ret.append("{").append("indexRoot").append(":").append(indexRoot).append("}\n");
        ret.append("{").append("indexLeftValue").append(":").append(indexLeftValue).append("}\n");
        ret.append("{").append("indexRightValue").append(":").append(indexRightValue).append("}\n");
        ret.append("{").append("indexTitle").append(":").append(indexTitle).append("}\n");
        ret.append("{").append("indexContent").append(":").append(indexContent).append("}\n");
        ret.append("{").append("indexIcon").append(":").append(indexIcon).append("}\n");
        ret.append("{").append("indexBackground").append(":").append(indexBackground).append("}\n");
        ret.append("{").append("indexRank").append(":").append(indexRank).append("}\n");
        ret.append("{").append("indexPageId").append(":").append(indexPageId).append("}\n");
        ret.append("{").append("indexChildrenCount").append(":").append(indexChildrenCount).append("}\n");
        ret.append("{").append("indexSequence").append(":").append(indexSequence).append("}\n");
        ret.append("{").append("indexCreateTime").append(":").append(indexCreateTime).append("}\n");
        ret.append("{").append("indexPublishTime").append(":").append(indexPublishTime).append("}\n");
        ret.append("{").append("indexStatus").append(":").append(indexStatus).append("}\n");
        ret.append("{").append("indexResourceUrl").append(":").append(indexResourceUrl).append("}\n");
        ret.append("{").append("indexDefaultTemplate").append(":").append(indexDefaultTemplate).append("}\n");
        ret.append("{").append("indexSubmitBy").append(":").append(indexSubmitBy).append("}\n");
        ret.append("{").append("indexSubmitByGp").append(":").append(indexSubmitByGp).append("}\n");
        ret.append("{").append("indexSubmitByIns").append(":").append(indexSubmitByIns).append("}\n");
        ret.append("{").append("indexSubmitByFamily").append(":").append(indexSubmitByFamily).append("}\n");
        ret.append("{").append("indexAuthLevel").append(":").append(indexAuthLevel).append("}\n");
        ret.append("{").append("indexWrAuthLevel").append(":").append(indexWrAuthLevel).append("}\n");
        ret.append("{").append("indexExAuthLevel").append(":").append(indexExAuthLevel).append("}\n");
        ret.append("{").append("indexSubmitByTopIns").append(":").append(indexSubmitByTopIns).append("}\n");
        ret.append("{").append("indexAspect").append(":").append(indexAspect).append("}\n");
        ret.append("{").append("indexRelatedObj").append(":").append(indexRelatedObj).append("}\n");
        ret.append("{").append("indexType").append(":").append(indexType).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelWikiIndex
        implements RedisMapMapper<ModelWikiIndex>
    {

        @Override
        public ModelWikiIndex fromMap(Map<byte[], byte[]> map) {
            ModelWikiIndex instance = new ModelWikiIndex();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelWikiIndex.FI_INDEXID)) {
                    instance.setIndexId(mapToFieldIndexId(entry.getValue()));
                } else {
                    if (field.equals(ModelWikiIndex.FI_INDEXLEVEL)) {
                        instance.setIndexLevel(mapToFieldIndexLevel(entry.getValue()));
                    } else {
                        if (field.equals(ModelWikiIndex.FI_INDEXPARENT)) {
                            instance.setIndexParent(mapToFieldIndexParent(entry.getValue()));
                        } else {
                            if (field.equals(ModelWikiIndex.FI_INDEXNEXT)) {
                                instance.setIndexNext(mapToFieldIndexNext(entry.getValue()));
                            } else {
                                if (field.equals(ModelWikiIndex.FI_INDEXPREV)) {
                                    instance.setIndexPrev(mapToFieldIndexPrev(entry.getValue()));
                                } else {
                                    if (field.equals(ModelWikiIndex.FI_INDEXINDEX)) {
                                        instance.setIndexIndex(mapToFieldIndexIndex(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelWikiIndex.FI_INDEXROOT)) {
                                            instance.setIndexRoot(mapToFieldIndexRoot(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
                                                instance.setIndexLeftValue(mapToFieldIndexLeftValue(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
                                                    instance.setIndexRightValue(mapToFieldIndexRightValue(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelWikiIndex.FI_INDEXTITLE)) {
                                                        instance.setIndexTitle(mapToFieldIndexTitle(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelWikiIndex.FI_INDEXCONTENT)) {
                                                            instance.setIndexContent(mapToFieldIndexContent(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelWikiIndex.FI_INDEXICON)) {
                                                                instance.setIndexIcon(mapToFieldIndexIcon(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelWikiIndex.FI_INDEXBACKGROUND)) {
                                                                    instance.setIndexBackground(mapToFieldIndexBackground(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelWikiIndex.FI_INDEXRANK)) {
                                                                        instance.setIndexRank(mapToFieldIndexRank(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelWikiIndex.FI_INDEXPAGEID)) {
                                                                            instance.setIndexPageId(mapToFieldIndexPageId(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
                                                                                instance.setIndexChildrenCount(mapToFieldIndexChildrenCount(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSEQUENCE)) {
                                                                                    instance.setIndexSequence(mapToFieldIndexSequence(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXCREATETIME)) {
                                                                                        instance.setIndexCreateTime(mapToFieldIndexCreateTime(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
                                                                                            instance.setIndexPublishTime(mapToFieldIndexPublishTime(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSTATUS)) {
                                                                                                instance.setIndexStatus(mapToFieldIndexStatus(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
                                                                                                    instance.setIndexResourceUrl(mapToFieldIndexResourceUrl(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
                                                                                                        instance.setIndexDefaultTemplate(mapToFieldIndexDefaultTemplate(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBY)) {
                                                                                                            instance.setIndexSubmitBy(mapToFieldIndexSubmitBy(entry.getValue()));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
                                                                                                                instance.setIndexSubmitByGp(mapToFieldIndexSubmitByGp(entry.getValue()));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
                                                                                                                    instance.setIndexSubmitByIns(mapToFieldIndexSubmitByIns(entry.getValue()));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
                                                                                                                        instance.setIndexSubmitByFamily(mapToFieldIndexSubmitByFamily(entry.getValue()));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
                                                                                                                            instance.setIndexAuthLevel(mapToFieldIndexAuthLevel(entry.getValue()));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
                                                                                                                                instance.setIndexWrAuthLevel(mapToFieldIndexWrAuthLevel(entry.getValue()));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
                                                                                                                                    instance.setIndexExAuthLevel(mapToFieldIndexExAuthLevel(entry.getValue()));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
                                                                                                                                        instance.setIndexSubmitByTopIns(mapToFieldIndexSubmitByTopIns(entry.getValue()));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXASPECT)) {
                                                                                                                                            instance.setIndexAspect(mapToFieldIndexAspect(entry.getValue()));
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
                                                                                                                                                instance.setIndexRelatedObj(mapToFieldIndexRelatedObj(entry.getValue()));
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXTYPE)) {
                                                                                                                                                    instance.setIndexType(mapToFieldIndexType(entry.getValue()));
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return instance;
        }

        protected Integer mapToFieldIndexId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldIndexLevel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldIndexParent(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexNext(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexPrev(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Short mapToFieldIndexIndex(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Short.class);
        }

        protected Integer mapToFieldIndexRoot(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexLeftValue(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexRightValue(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldIndexTitle(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldIndexContent(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldIndexIcon(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldIndexBackground(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Short mapToFieldIndexRank(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Short.class);
        }

        protected Integer mapToFieldIndexPageId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Short mapToFieldIndexChildrenCount(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Short.class);
        }

        protected String mapToFieldIndexSequence(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldIndexCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Date mapToFieldIndexPublishTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected EnumIndexStatus mapToFieldIndexStatus(byte[] bytes) {
            return EnumIndexStatus.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected String mapToFieldIndexResourceUrl(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldIndexDefaultTemplate(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldIndexSubmitBy(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexSubmitByGp(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexSubmitByIns(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldIndexSubmitByFamily(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Short mapToFieldIndexAuthLevel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Short.class);
        }

        protected Short mapToFieldIndexWrAuthLevel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Short.class);
        }

        protected Short mapToFieldIndexExAuthLevel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Short.class);
        }

        protected Integer mapToFieldIndexSubmitByTopIns(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldIndexAspect(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldIndexRelatedObj(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldIndexType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelWikiIndex instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueIndexId = mapFromFieldIndexId(instance.getIndexId());
            ret.put(ModelWikiIndex.FI_INDEXID.getBytes(), valueIndexId);
            byte[] valueIndexLevel = mapFromFieldIndexLevel(instance.getIndexLevel());
            ret.put(ModelWikiIndex.FI_INDEXLEVEL.getBytes(), valueIndexLevel);
            byte[] valueIndexParent = mapFromFieldIndexParent(instance.getIndexParent());
            ret.put(ModelWikiIndex.FI_INDEXPARENT.getBytes(), valueIndexParent);
            byte[] valueIndexNext = mapFromFieldIndexNext(instance.getIndexNext());
            ret.put(ModelWikiIndex.FI_INDEXNEXT.getBytes(), valueIndexNext);
            byte[] valueIndexPrev = mapFromFieldIndexPrev(instance.getIndexPrev());
            ret.put(ModelWikiIndex.FI_INDEXPREV.getBytes(), valueIndexPrev);
            byte[] valueIndexIndex = mapFromFieldIndexIndex(instance.getIndexIndex());
            ret.put(ModelWikiIndex.FI_INDEXINDEX.getBytes(), valueIndexIndex);
            byte[] valueIndexRoot = mapFromFieldIndexRoot(instance.getIndexRoot());
            ret.put(ModelWikiIndex.FI_INDEXROOT.getBytes(), valueIndexRoot);
            byte[] valueIndexLeftValue = mapFromFieldIndexLeftValue(instance.getIndexLeftValue());
            ret.put(ModelWikiIndex.FI_INDEXLEFTVALUE.getBytes(), valueIndexLeftValue);
            byte[] valueIndexRightValue = mapFromFieldIndexRightValue(instance.getIndexRightValue());
            ret.put(ModelWikiIndex.FI_INDEXRIGHTVALUE.getBytes(), valueIndexRightValue);
            byte[] valueIndexTitle = mapFromFieldIndexTitle(instance.getIndexTitle());
            ret.put(ModelWikiIndex.FI_INDEXTITLE.getBytes(), valueIndexTitle);
            byte[] valueIndexContent = mapFromFieldIndexContent(instance.getIndexContent());
            ret.put(ModelWikiIndex.FI_INDEXCONTENT.getBytes(), valueIndexContent);
            byte[] valueIndexIcon = mapFromFieldIndexIcon(instance.getIndexIcon());
            ret.put(ModelWikiIndex.FI_INDEXICON.getBytes(), valueIndexIcon);
            byte[] valueIndexBackground = mapFromFieldIndexBackground(instance.getIndexBackground());
            ret.put(ModelWikiIndex.FI_INDEXBACKGROUND.getBytes(), valueIndexBackground);
            byte[] valueIndexRank = mapFromFieldIndexRank(instance.getIndexRank());
            ret.put(ModelWikiIndex.FI_INDEXRANK.getBytes(), valueIndexRank);
            byte[] valueIndexPageId = mapFromFieldIndexPageId(instance.getIndexPageId());
            ret.put(ModelWikiIndex.FI_INDEXPAGEID.getBytes(), valueIndexPageId);
            byte[] valueIndexChildrenCount = mapFromFieldIndexChildrenCount(instance.getIndexChildrenCount());
            ret.put(ModelWikiIndex.FI_INDEXCHILDRENCOUNT.getBytes(), valueIndexChildrenCount);
            byte[] valueIndexSequence = mapFromFieldIndexSequence(instance.getIndexSequence());
            ret.put(ModelWikiIndex.FI_INDEXSEQUENCE.getBytes(), valueIndexSequence);
            byte[] valueIndexCreateTime = mapFromFieldIndexCreateTime(instance.getIndexCreateTime());
            ret.put(ModelWikiIndex.FI_INDEXCREATETIME.getBytes(), valueIndexCreateTime);
            byte[] valueIndexPublishTime = mapFromFieldIndexPublishTime(instance.getIndexPublishTime());
            ret.put(ModelWikiIndex.FI_INDEXPUBLISHTIME.getBytes(), valueIndexPublishTime);
            byte[] valueIndexStatus = mapFromFieldIndexStatus(instance.getIndexStatus());
            ret.put(ModelWikiIndex.FI_INDEXSTATUS.getBytes(), valueIndexStatus);
            byte[] valueIndexResourceUrl = mapFromFieldIndexResourceUrl(instance.getIndexResourceUrl());
            ret.put(ModelWikiIndex.FI_INDEXRESOURCEURL.getBytes(), valueIndexResourceUrl);
            byte[] valueIndexDefaultTemplate = mapFromFieldIndexDefaultTemplate(instance.getIndexDefaultTemplate());
            ret.put(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE.getBytes(), valueIndexDefaultTemplate);
            byte[] valueIndexSubmitBy = mapFromFieldIndexSubmitBy(instance.getIndexSubmitBy());
            ret.put(ModelWikiIndex.FI_INDEXSUBMITBY.getBytes(), valueIndexSubmitBy);
            byte[] valueIndexSubmitByGp = mapFromFieldIndexSubmitByGp(instance.getIndexSubmitByGp());
            ret.put(ModelWikiIndex.FI_INDEXSUBMITBYGP.getBytes(), valueIndexSubmitByGp);
            byte[] valueIndexSubmitByIns = mapFromFieldIndexSubmitByIns(instance.getIndexSubmitByIns());
            ret.put(ModelWikiIndex.FI_INDEXSUBMITBYINS.getBytes(), valueIndexSubmitByIns);
            byte[] valueIndexSubmitByFamily = mapFromFieldIndexSubmitByFamily(instance.getIndexSubmitByFamily());
            ret.put(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY.getBytes(), valueIndexSubmitByFamily);
            byte[] valueIndexAuthLevel = mapFromFieldIndexAuthLevel(instance.getIndexAuthLevel());
            ret.put(ModelWikiIndex.FI_INDEXAUTHLEVEL.getBytes(), valueIndexAuthLevel);
            byte[] valueIndexWrAuthLevel = mapFromFieldIndexWrAuthLevel(instance.getIndexWrAuthLevel());
            ret.put(ModelWikiIndex.FI_INDEXWRAUTHLEVEL.getBytes(), valueIndexWrAuthLevel);
            byte[] valueIndexExAuthLevel = mapFromFieldIndexExAuthLevel(instance.getIndexExAuthLevel());
            ret.put(ModelWikiIndex.FI_INDEXEXAUTHLEVEL.getBytes(), valueIndexExAuthLevel);
            byte[] valueIndexSubmitByTopIns = mapFromFieldIndexSubmitByTopIns(instance.getIndexSubmitByTopIns());
            ret.put(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS.getBytes(), valueIndexSubmitByTopIns);
            byte[] valueIndexAspect = mapFromFieldIndexAspect(instance.getIndexAspect());
            ret.put(ModelWikiIndex.FI_INDEXASPECT.getBytes(), valueIndexAspect);
            byte[] valueIndexRelatedObj = mapFromFieldIndexRelatedObj(instance.getIndexRelatedObj());
            ret.put(ModelWikiIndex.FI_INDEXRELATEDOBJ.getBytes(), valueIndexRelatedObj);
            byte[] valueIndexType = mapFromFieldIndexType(instance.getIndexType());
            ret.put(ModelWikiIndex.FI_INDEXTYPE.getBytes(), valueIndexType);
            return ret;
        }

        protected byte[] mapFromFieldIndexId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexLevel(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexParent(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexNext(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexPrev(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexIndex(Short field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexRoot(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexLeftValue(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexRightValue(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexTitle(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexContent(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexIcon(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexBackground(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexRank(Short field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexPageId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexChildrenCount(Short field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexSequence(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexPublishTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexStatus(EnumIndexStatus field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldIndexResourceUrl(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexDefaultTemplate(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexSubmitBy(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexSubmitByGp(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexSubmitByIns(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexSubmitByFamily(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexAuthLevel(Short field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexWrAuthLevel(Short field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexExAuthLevel(Short field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexSubmitByTopIns(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexAspect(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexRelatedObj(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndexType(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelWikiIndex instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dIndexId = instance.getIndexId();
            if (dIndexId!= null) {
                ret.put(ModelWikiIndex.FI_INDEXID, dIndexId);
            }
            Byte dIndexLevel = instance.getIndexLevel();
            if (dIndexLevel!= null) {
                ret.put(ModelWikiIndex.FI_INDEXLEVEL, dIndexLevel);
            }
            Integer dIndexParent = instance.getIndexParent();
            if (dIndexParent!= null) {
                ret.put(ModelWikiIndex.FI_INDEXPARENT, dIndexParent);
            }
            Integer dIndexNext = instance.getIndexNext();
            if (dIndexNext!= null) {
                ret.put(ModelWikiIndex.FI_INDEXNEXT, dIndexNext);
            }
            Integer dIndexPrev = instance.getIndexPrev();
            if (dIndexPrev!= null) {
                ret.put(ModelWikiIndex.FI_INDEXPREV, dIndexPrev);
            }
            Short dIndexIndex = instance.getIndexIndex();
            if (dIndexIndex!= null) {
                ret.put(ModelWikiIndex.FI_INDEXINDEX, dIndexIndex);
            }
            Integer dIndexRoot = instance.getIndexRoot();
            if (dIndexRoot!= null) {
                ret.put(ModelWikiIndex.FI_INDEXROOT, dIndexRoot);
            }
            Integer dIndexLeftValue = instance.getIndexLeftValue();
            if (dIndexLeftValue!= null) {
                ret.put(ModelWikiIndex.FI_INDEXLEFTVALUE, dIndexLeftValue);
            }
            Integer dIndexRightValue = instance.getIndexRightValue();
            if (dIndexRightValue!= null) {
                ret.put(ModelWikiIndex.FI_INDEXRIGHTVALUE, dIndexRightValue);
            }
            String dIndexTitle = instance.getIndexTitle();
            if (dIndexTitle!= null) {
                ret.put(ModelWikiIndex.FI_INDEXTITLE, dIndexTitle);
            }
            String dIndexContent = instance.getIndexContent();
            if (dIndexContent!= null) {
                ret.put(ModelWikiIndex.FI_INDEXCONTENT, dIndexContent);
            }
            String dIndexIcon = instance.getIndexIcon();
            if (dIndexIcon!= null) {
                ret.put(ModelWikiIndex.FI_INDEXICON, dIndexIcon);
            }
            String dIndexBackground = instance.getIndexBackground();
            if (dIndexBackground!= null) {
                ret.put(ModelWikiIndex.FI_INDEXBACKGROUND, dIndexBackground);
            }
            Short dIndexRank = instance.getIndexRank();
            if (dIndexRank!= null) {
                ret.put(ModelWikiIndex.FI_INDEXRANK, dIndexRank);
            }
            Integer dIndexPageId = instance.getIndexPageId();
            if (dIndexPageId!= null) {
                ret.put(ModelWikiIndex.FI_INDEXPAGEID, dIndexPageId);
            }
            Short dIndexChildrenCount = instance.getIndexChildrenCount();
            if (dIndexChildrenCount!= null) {
                ret.put(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, dIndexChildrenCount);
            }
            String dIndexSequence = instance.getIndexSequence();
            if (dIndexSequence!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSEQUENCE, dIndexSequence);
            }
            Date dIndexCreateTime = instance.getIndexCreateTime();
            if (dIndexCreateTime!= null) {
                ret.put(ModelWikiIndex.FI_INDEXCREATETIME, dIndexCreateTime);
            }
            Date dIndexPublishTime = instance.getIndexPublishTime();
            if (dIndexPublishTime!= null) {
                ret.put(ModelWikiIndex.FI_INDEXPUBLISHTIME, dIndexPublishTime);
            }
            EnumIndexStatus dIndexStatus = instance.getIndexStatus();
            if (dIndexStatus!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSTATUS, dIndexStatus.val);
            }
            String dIndexResourceUrl = instance.getIndexResourceUrl();
            if (dIndexResourceUrl!= null) {
                ret.put(ModelWikiIndex.FI_INDEXRESOURCEURL, dIndexResourceUrl);
            }
            String dIndexDefaultTemplate = instance.getIndexDefaultTemplate();
            if (dIndexDefaultTemplate!= null) {
                ret.put(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, dIndexDefaultTemplate);
            }
            Integer dIndexSubmitBy = instance.getIndexSubmitBy();
            if (dIndexSubmitBy!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSUBMITBY, dIndexSubmitBy);
            }
            Integer dIndexSubmitByGp = instance.getIndexSubmitByGp();
            if (dIndexSubmitByGp!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSUBMITBYGP, dIndexSubmitByGp);
            }
            Integer dIndexSubmitByIns = instance.getIndexSubmitByIns();
            if (dIndexSubmitByIns!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSUBMITBYINS, dIndexSubmitByIns);
            }
            Integer dIndexSubmitByFamily = instance.getIndexSubmitByFamily();
            if (dIndexSubmitByFamily!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, dIndexSubmitByFamily);
            }
            Short dIndexAuthLevel = instance.getIndexAuthLevel();
            if (dIndexAuthLevel!= null) {
                ret.put(ModelWikiIndex.FI_INDEXAUTHLEVEL, dIndexAuthLevel);
            }
            Short dIndexWrAuthLevel = instance.getIndexWrAuthLevel();
            if (dIndexWrAuthLevel!= null) {
                ret.put(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, dIndexWrAuthLevel);
            }
            Short dIndexExAuthLevel = instance.getIndexExAuthLevel();
            if (dIndexExAuthLevel!= null) {
                ret.put(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, dIndexExAuthLevel);
            }
            Integer dIndexSubmitByTopIns = instance.getIndexSubmitByTopIns();
            if (dIndexSubmitByTopIns!= null) {
                ret.put(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, dIndexSubmitByTopIns);
            }
            Byte dIndexAspect = instance.getIndexAspect();
            if (dIndexAspect!= null) {
                ret.put(ModelWikiIndex.FI_INDEXASPECT, dIndexAspect);
            }
            Integer dIndexRelatedObj = instance.getIndexRelatedObj();
            if (dIndexRelatedObj!= null) {
                ret.put(ModelWikiIndex.FI_INDEXRELATEDOBJ, dIndexRelatedObj);
            }
            Byte dIndexType = instance.getIndexType();
            if (dIndexType!= null) {
                ret.put(ModelWikiIndex.FI_INDEXTYPE, dIndexType);
            }
            return ret;
        }

        @Override
        public ModelWikiIndex fromCommonMap(Map<String, Object> param) {
            ModelWikiIndex ret = new ModelWikiIndex();
            if (param == null) {
                return ret;
            }
            Object dIndexId = param.get(ModelWikiIndex.FI_INDEXID);
            if (dIndexId!= null) {
                this.setField(ModelWikiIndex.FI_INDEXID, ret, dIndexId);
            }
            Object dIndexLevel = param.get(ModelWikiIndex.FI_INDEXLEVEL);
            if (dIndexLevel!= null) {
                this.setField(ModelWikiIndex.FI_INDEXLEVEL, ret, dIndexLevel);
            }
            Object dIndexParent = param.get(ModelWikiIndex.FI_INDEXPARENT);
            if (dIndexParent!= null) {
                this.setField(ModelWikiIndex.FI_INDEXPARENT, ret, dIndexParent);
            }
            Object dIndexNext = param.get(ModelWikiIndex.FI_INDEXNEXT);
            if (dIndexNext!= null) {
                this.setField(ModelWikiIndex.FI_INDEXNEXT, ret, dIndexNext);
            }
            Object dIndexPrev = param.get(ModelWikiIndex.FI_INDEXPREV);
            if (dIndexPrev!= null) {
                this.setField(ModelWikiIndex.FI_INDEXPREV, ret, dIndexPrev);
            }
            Object dIndexIndex = param.get(ModelWikiIndex.FI_INDEXINDEX);
            if (dIndexIndex!= null) {
                this.setField(ModelWikiIndex.FI_INDEXINDEX, ret, dIndexIndex);
            }
            Object dIndexRoot = param.get(ModelWikiIndex.FI_INDEXROOT);
            if (dIndexRoot!= null) {
                this.setField(ModelWikiIndex.FI_INDEXROOT, ret, dIndexRoot);
            }
            Object dIndexLeftValue = param.get(ModelWikiIndex.FI_INDEXLEFTVALUE);
            if (dIndexLeftValue!= null) {
                this.setField(ModelWikiIndex.FI_INDEXLEFTVALUE, ret, dIndexLeftValue);
            }
            Object dIndexRightValue = param.get(ModelWikiIndex.FI_INDEXRIGHTVALUE);
            if (dIndexRightValue!= null) {
                this.setField(ModelWikiIndex.FI_INDEXRIGHTVALUE, ret, dIndexRightValue);
            }
            Object dIndexTitle = param.get(ModelWikiIndex.FI_INDEXTITLE);
            if (dIndexTitle!= null) {
                this.setField(ModelWikiIndex.FI_INDEXTITLE, ret, dIndexTitle);
            }
            Object dIndexContent = param.get(ModelWikiIndex.FI_INDEXCONTENT);
            if (dIndexContent!= null) {
                this.setField(ModelWikiIndex.FI_INDEXCONTENT, ret, dIndexContent);
            }
            Object dIndexIcon = param.get(ModelWikiIndex.FI_INDEXICON);
            if (dIndexIcon!= null) {
                this.setField(ModelWikiIndex.FI_INDEXICON, ret, dIndexIcon);
            }
            Object dIndexBackground = param.get(ModelWikiIndex.FI_INDEXBACKGROUND);
            if (dIndexBackground!= null) {
                this.setField(ModelWikiIndex.FI_INDEXBACKGROUND, ret, dIndexBackground);
            }
            Object dIndexRank = param.get(ModelWikiIndex.FI_INDEXRANK);
            if (dIndexRank!= null) {
                this.setField(ModelWikiIndex.FI_INDEXRANK, ret, dIndexRank);
            }
            Object dIndexPageId = param.get(ModelWikiIndex.FI_INDEXPAGEID);
            if (dIndexPageId!= null) {
                this.setField(ModelWikiIndex.FI_INDEXPAGEID, ret, dIndexPageId);
            }
            Object dIndexChildrenCount = param.get(ModelWikiIndex.FI_INDEXCHILDRENCOUNT);
            if (dIndexChildrenCount!= null) {
                this.setField(ModelWikiIndex.FI_INDEXCHILDRENCOUNT, ret, dIndexChildrenCount);
            }
            Object dIndexSequence = param.get(ModelWikiIndex.FI_INDEXSEQUENCE);
            if (dIndexSequence!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSEQUENCE, ret, dIndexSequence);
            }
            Object dIndexCreateTime = param.get(ModelWikiIndex.FI_INDEXCREATETIME);
            if (dIndexCreateTime!= null) {
                this.setField(ModelWikiIndex.FI_INDEXCREATETIME, ret, dIndexCreateTime);
            }
            Object dIndexPublishTime = param.get(ModelWikiIndex.FI_INDEXPUBLISHTIME);
            if (dIndexPublishTime!= null) {
                this.setField(ModelWikiIndex.FI_INDEXPUBLISHTIME, ret, dIndexPublishTime);
            }
            Object dIndexStatus = param.get(ModelWikiIndex.FI_INDEXSTATUS);
            if (dIndexStatus!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSTATUS, ret, dIndexStatus);
            }
            Object dIndexResourceUrl = param.get(ModelWikiIndex.FI_INDEXRESOURCEURL);
            if (dIndexResourceUrl!= null) {
                this.setField(ModelWikiIndex.FI_INDEXRESOURCEURL, ret, dIndexResourceUrl);
            }
            Object dIndexDefaultTemplate = param.get(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE);
            if (dIndexDefaultTemplate!= null) {
                this.setField(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE, ret, dIndexDefaultTemplate);
            }
            Object dIndexSubmitBy = param.get(ModelWikiIndex.FI_INDEXSUBMITBY);
            if (dIndexSubmitBy!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSUBMITBY, ret, dIndexSubmitBy);
            }
            Object dIndexSubmitByGp = param.get(ModelWikiIndex.FI_INDEXSUBMITBYGP);
            if (dIndexSubmitByGp!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSUBMITBYGP, ret, dIndexSubmitByGp);
            }
            Object dIndexSubmitByIns = param.get(ModelWikiIndex.FI_INDEXSUBMITBYINS);
            if (dIndexSubmitByIns!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSUBMITBYINS, ret, dIndexSubmitByIns);
            }
            Object dIndexSubmitByFamily = param.get(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY);
            if (dIndexSubmitByFamily!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY, ret, dIndexSubmitByFamily);
            }
            Object dIndexAuthLevel = param.get(ModelWikiIndex.FI_INDEXAUTHLEVEL);
            if (dIndexAuthLevel!= null) {
                this.setField(ModelWikiIndex.FI_INDEXAUTHLEVEL, ret, dIndexAuthLevel);
            }
            Object dIndexWrAuthLevel = param.get(ModelWikiIndex.FI_INDEXWRAUTHLEVEL);
            if (dIndexWrAuthLevel!= null) {
                this.setField(ModelWikiIndex.FI_INDEXWRAUTHLEVEL, ret, dIndexWrAuthLevel);
            }
            Object dIndexExAuthLevel = param.get(ModelWikiIndex.FI_INDEXEXAUTHLEVEL);
            if (dIndexExAuthLevel!= null) {
                this.setField(ModelWikiIndex.FI_INDEXEXAUTHLEVEL, ret, dIndexExAuthLevel);
            }
            Object dIndexSubmitByTopIns = param.get(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS);
            if (dIndexSubmitByTopIns!= null) {
                this.setField(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS, ret, dIndexSubmitByTopIns);
            }
            Object dIndexAspect = param.get(ModelWikiIndex.FI_INDEXASPECT);
            if (dIndexAspect!= null) {
                this.setField(ModelWikiIndex.FI_INDEXASPECT, ret, dIndexAspect);
            }
            Object dIndexRelatedObj = param.get(ModelWikiIndex.FI_INDEXRELATEDOBJ);
            if (dIndexRelatedObj!= null) {
                this.setField(ModelWikiIndex.FI_INDEXRELATEDOBJ, ret, dIndexRelatedObj);
            }
            Object dIndexType = param.get(ModelWikiIndex.FI_INDEXTYPE);
            if (dIndexType!= null) {
                this.setField(ModelWikiIndex.FI_INDEXTYPE, ret, dIndexType);
            }
            return ret;
        }

        protected Integer mapToFieldIndexId(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldIndexLevel(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldIndexParent(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexNext(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexPrev(Object obj) {
            return ((Integer) obj);
        }

        protected Short mapToFieldIndexIndex(Object obj) {
            return ((Short) obj);
        }

        protected Integer mapToFieldIndexRoot(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexLeftValue(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexRightValue(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldIndexTitle(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldIndexContent(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldIndexIcon(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldIndexBackground(Object obj) {
            return ((String) obj);
        }

        protected Short mapToFieldIndexRank(Object obj) {
            return ((Short) obj);
        }

        protected Integer mapToFieldIndexPageId(Object obj) {
            return ((Integer) obj);
        }

        protected Short mapToFieldIndexChildrenCount(Object obj) {
            return ((Short) obj);
        }

        protected String mapToFieldIndexSequence(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldIndexCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected Date mapToFieldIndexPublishTime(Object obj) {
            return ((Date) obj);
        }

        protected EnumIndexStatus mapToFieldIndexStatus(Object obj) {
            return EnumIndexStatus.fromValue(((Byte) obj));
        }

        protected String mapToFieldIndexResourceUrl(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldIndexDefaultTemplate(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldIndexSubmitBy(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexSubmitByGp(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexSubmitByIns(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldIndexSubmitByFamily(Object obj) {
            return ((Integer) obj);
        }

        protected Short mapToFieldIndexAuthLevel(Object obj) {
            return ((Short) obj);
        }

        protected Short mapToFieldIndexWrAuthLevel(Object obj) {
            return ((Short) obj);
        }

        protected Short mapToFieldIndexExAuthLevel(Object obj) {
            return ((Short) obj);
        }

        protected Integer mapToFieldIndexSubmitByTopIns(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldIndexAspect(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldIndexRelatedObj(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldIndexType(Object obj) {
            return ((Byte) obj);
        }

        public<TT> TT getField(String field, ModelWikiIndex instance) {
            try {
                if (field.equals(ModelWikiIndex.FI_INDEXID)) {
                    return ((TT) instance.getIndexId());
                } else {
                    if (field.equals(ModelWikiIndex.FI_INDEXLEVEL)) {
                        return ((TT) instance.getIndexLevel());
                    } else {
                        if (field.equals(ModelWikiIndex.FI_INDEXPARENT)) {
                            return ((TT) instance.getIndexParent());
                        } else {
                            if (field.equals(ModelWikiIndex.FI_INDEXNEXT)) {
                                return ((TT) instance.getIndexNext());
                            } else {
                                if (field.equals(ModelWikiIndex.FI_INDEXPREV)) {
                                    return ((TT) instance.getIndexPrev());
                                } else {
                                    if (field.equals(ModelWikiIndex.FI_INDEXINDEX)) {
                                        return ((TT) instance.getIndexIndex());
                                    } else {
                                        if (field.equals(ModelWikiIndex.FI_INDEXROOT)) {
                                            return ((TT) instance.getIndexRoot());
                                        } else {
                                            if (field.equals(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
                                                return ((TT) instance.getIndexLeftValue());
                                            } else {
                                                if (field.equals(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
                                                    return ((TT) instance.getIndexRightValue());
                                                } else {
                                                    if (field.equals(ModelWikiIndex.FI_INDEXTITLE)) {
                                                        return ((TT) instance.getIndexTitle());
                                                    } else {
                                                        if (field.equals(ModelWikiIndex.FI_INDEXCONTENT)) {
                                                            return ((TT) instance.getIndexContent());
                                                        } else {
                                                            if (field.equals(ModelWikiIndex.FI_INDEXICON)) {
                                                                return ((TT) instance.getIndexIcon());
                                                            } else {
                                                                if (field.equals(ModelWikiIndex.FI_INDEXBACKGROUND)) {
                                                                    return ((TT) instance.getIndexBackground());
                                                                } else {
                                                                    if (field.equals(ModelWikiIndex.FI_INDEXRANK)) {
                                                                        return ((TT) instance.getIndexRank());
                                                                    } else {
                                                                        if (field.equals(ModelWikiIndex.FI_INDEXPAGEID)) {
                                                                            return ((TT) instance.getIndexPageId());
                                                                        } else {
                                                                            if (field.equals(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
                                                                                return ((TT) instance.getIndexChildrenCount());
                                                                            } else {
                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSEQUENCE)) {
                                                                                    return ((TT) instance.getIndexSequence());
                                                                                } else {
                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXCREATETIME)) {
                                                                                        return ((TT) instance.getIndexCreateTime());
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
                                                                                            return ((TT) instance.getIndexPublishTime());
                                                                                        } else {
                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSTATUS)) {
                                                                                                return ((TT) instance.getIndexStatus());
                                                                                            } else {
                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
                                                                                                    return ((TT) instance.getIndexResourceUrl());
                                                                                                } else {
                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
                                                                                                        return ((TT) instance.getIndexDefaultTemplate());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBY)) {
                                                                                                            return ((TT) instance.getIndexSubmitBy());
                                                                                                        } else {
                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
                                                                                                                return ((TT) instance.getIndexSubmitByGp());
                                                                                                            } else {
                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
                                                                                                                    return ((TT) instance.getIndexSubmitByIns());
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
                                                                                                                        return ((TT) instance.getIndexSubmitByFamily());
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
                                                                                                                            return ((TT) instance.getIndexAuthLevel());
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
                                                                                                                                return ((TT) instance.getIndexWrAuthLevel());
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
                                                                                                                                    return ((TT) instance.getIndexExAuthLevel());
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
                                                                                                                                        return ((TT) instance.getIndexSubmitByTopIns());
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXASPECT)) {
                                                                                                                                            return ((TT) instance.getIndexAspect());
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
                                                                                                                                                return ((TT) instance.getIndexRelatedObj());
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXTYPE)) {
                                                                                                                                                    return ((TT) instance.getIndexType());
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        public<TT> void setField(String field, ModelWikiIndex instance, TT value) {
            if (field.equals(ModelWikiIndex.FI_INDEXID)) {
                try {
                    instance.setIndexId(mapToFieldIndexId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelWikiIndex.FI_INDEXLEVEL)) {
                    try {
                        instance.setIndexLevel(mapToFieldIndexLevel(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelWikiIndex.FI_INDEXPARENT)) {
                        try {
                            instance.setIndexParent(mapToFieldIndexParent(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelWikiIndex.FI_INDEXNEXT)) {
                            try {
                                instance.setIndexNext(mapToFieldIndexNext(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelWikiIndex.FI_INDEXPREV)) {
                                try {
                                    instance.setIndexPrev(mapToFieldIndexPrev(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelWikiIndex.FI_INDEXINDEX)) {
                                    try {
                                        instance.setIndexIndex(mapToFieldIndexIndex(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelWikiIndex.FI_INDEXROOT)) {
                                        try {
                                            instance.setIndexRoot(mapToFieldIndexRoot(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
                                            try {
                                                instance.setIndexLeftValue(mapToFieldIndexLeftValue(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
                                                try {
                                                    instance.setIndexRightValue(mapToFieldIndexRightValue(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelWikiIndex.FI_INDEXTITLE)) {
                                                    try {
                                                        instance.setIndexTitle(mapToFieldIndexTitle(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelWikiIndex.FI_INDEXCONTENT)) {
                                                        try {
                                                            instance.setIndexContent(mapToFieldIndexContent(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelWikiIndex.FI_INDEXICON)) {
                                                            try {
                                                                instance.setIndexIcon(mapToFieldIndexIcon(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelWikiIndex.FI_INDEXBACKGROUND)) {
                                                                try {
                                                                    instance.setIndexBackground(mapToFieldIndexBackground(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelWikiIndex.FI_INDEXRANK)) {
                                                                    try {
                                                                        instance.setIndexRank(mapToFieldIndexRank(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelWikiIndex.FI_INDEXPAGEID)) {
                                                                        try {
                                                                            instance.setIndexPageId(mapToFieldIndexPageId(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
                                                                            try {
                                                                                instance.setIndexChildrenCount(mapToFieldIndexChildrenCount(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSEQUENCE)) {
                                                                                try {
                                                                                    instance.setIndexSequence(mapToFieldIndexSequence(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelWikiIndex.FI_INDEXCREATETIME)) {
                                                                                    try {
                                                                                        instance.setIndexCreateTime(mapToFieldIndexCreateTime(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
                                                                                        try {
                                                                                            instance.setIndexPublishTime(mapToFieldIndexPublishTime(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXSTATUS)) {
                                                                                            try {
                                                                                                instance.setIndexStatus(mapToFieldIndexStatus(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
                                                                                                try {
                                                                                                    instance.setIndexResourceUrl(mapToFieldIndexResourceUrl(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
                                                                                                    try {
                                                                                                        instance.setIndexDefaultTemplate(mapToFieldIndexDefaultTemplate(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBY)) {
                                                                                                        try {
                                                                                                            instance.setIndexSubmitBy(mapToFieldIndexSubmitBy(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
                                                                                                            try {
                                                                                                                instance.setIndexSubmitByGp(mapToFieldIndexSubmitByGp(value));
                                                                                                            } catch (final Exception ex) {
                                                                                                                ex.printStackTrace();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
                                                                                                                try {
                                                                                                                    instance.setIndexSubmitByIns(mapToFieldIndexSubmitByIns(value));
                                                                                                                } catch (final Exception ex) {
                                                                                                                    ex.printStackTrace();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
                                                                                                                    try {
                                                                                                                        instance.setIndexSubmitByFamily(mapToFieldIndexSubmitByFamily(value));
                                                                                                                    } catch (final Exception ex) {
                                                                                                                        ex.printStackTrace();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
                                                                                                                        try {
                                                                                                                            instance.setIndexAuthLevel(mapToFieldIndexAuthLevel(value));
                                                                                                                        } catch (final Exception ex) {
                                                                                                                            ex.printStackTrace();
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
                                                                                                                            try {
                                                                                                                                instance.setIndexWrAuthLevel(mapToFieldIndexWrAuthLevel(value));
                                                                                                                            } catch (final Exception ex) {
                                                                                                                                ex.printStackTrace();
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
                                                                                                                                try {
                                                                                                                                    instance.setIndexExAuthLevel(mapToFieldIndexExAuthLevel(value));
                                                                                                                                } catch (final Exception ex) {
                                                                                                                                    ex.printStackTrace();
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
                                                                                                                                    try {
                                                                                                                                        instance.setIndexSubmitByTopIns(mapToFieldIndexSubmitByTopIns(value));
                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                        ex.printStackTrace();
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXASPECT)) {
                                                                                                                                        try {
                                                                                                                                            instance.setIndexAspect(mapToFieldIndexAspect(value));
                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                            ex.printStackTrace();
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
                                                                                                                                            try {
                                                                                                                                                instance.setIndexRelatedObj(mapToFieldIndexRelatedObj(value));
                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                ex.printStackTrace();
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXTYPE)) {
                                                                                                                                                try {
                                                                                                                                                    instance.setIndexType(mapToFieldIndexType(value));
                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void setField(String field, ModelWikiIndex instance, byte[] value) {
            if (field.equals(ModelWikiIndex.FI_INDEXID)) {
                instance.setIndexId(mapToFieldIndexId(value));
            } else {
                if (field.equals(ModelWikiIndex.FI_INDEXLEVEL)) {
                    instance.setIndexLevel(mapToFieldIndexLevel(value));
                } else {
                    if (field.equals(ModelWikiIndex.FI_INDEXPARENT)) {
                        instance.setIndexParent(mapToFieldIndexParent(value));
                    } else {
                        if (field.equals(ModelWikiIndex.FI_INDEXNEXT)) {
                            instance.setIndexNext(mapToFieldIndexNext(value));
                        } else {
                            if (field.equals(ModelWikiIndex.FI_INDEXPREV)) {
                                instance.setIndexPrev(mapToFieldIndexPrev(value));
                            } else {
                                if (field.equals(ModelWikiIndex.FI_INDEXINDEX)) {
                                    instance.setIndexIndex(mapToFieldIndexIndex(value));
                                } else {
                                    if (field.equals(ModelWikiIndex.FI_INDEXROOT)) {
                                        instance.setIndexRoot(mapToFieldIndexRoot(value));
                                    } else {
                                        if (field.equals(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
                                            instance.setIndexLeftValue(mapToFieldIndexLeftValue(value));
                                        } else {
                                            if (field.equals(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
                                                instance.setIndexRightValue(mapToFieldIndexRightValue(value));
                                            } else {
                                                if (field.equals(ModelWikiIndex.FI_INDEXTITLE)) {
                                                    instance.setIndexTitle(mapToFieldIndexTitle(value));
                                                } else {
                                                    if (field.equals(ModelWikiIndex.FI_INDEXCONTENT)) {
                                                        instance.setIndexContent(mapToFieldIndexContent(value));
                                                    } else {
                                                        if (field.equals(ModelWikiIndex.FI_INDEXICON)) {
                                                            instance.setIndexIcon(mapToFieldIndexIcon(value));
                                                        } else {
                                                            if (field.equals(ModelWikiIndex.FI_INDEXBACKGROUND)) {
                                                                instance.setIndexBackground(mapToFieldIndexBackground(value));
                                                            } else {
                                                                if (field.equals(ModelWikiIndex.FI_INDEXRANK)) {
                                                                    instance.setIndexRank(mapToFieldIndexRank(value));
                                                                } else {
                                                                    if (field.equals(ModelWikiIndex.FI_INDEXPAGEID)) {
                                                                        instance.setIndexPageId(mapToFieldIndexPageId(value));
                                                                    } else {
                                                                        if (field.equals(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
                                                                            instance.setIndexChildrenCount(mapToFieldIndexChildrenCount(value));
                                                                        } else {
                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSEQUENCE)) {
                                                                                instance.setIndexSequence(mapToFieldIndexSequence(value));
                                                                            } else {
                                                                                if (field.equals(ModelWikiIndex.FI_INDEXCREATETIME)) {
                                                                                    instance.setIndexCreateTime(mapToFieldIndexCreateTime(value));
                                                                                } else {
                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
                                                                                        instance.setIndexPublishTime(mapToFieldIndexPublishTime(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXSTATUS)) {
                                                                                            instance.setIndexStatus(mapToFieldIndexStatus(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
                                                                                                instance.setIndexResourceUrl(mapToFieldIndexResourceUrl(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
                                                                                                    instance.setIndexDefaultTemplate(mapToFieldIndexDefaultTemplate(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBY)) {
                                                                                                        instance.setIndexSubmitBy(mapToFieldIndexSubmitBy(value));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
                                                                                                            instance.setIndexSubmitByGp(mapToFieldIndexSubmitByGp(value));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
                                                                                                                instance.setIndexSubmitByIns(mapToFieldIndexSubmitByIns(value));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
                                                                                                                    instance.setIndexSubmitByFamily(mapToFieldIndexSubmitByFamily(value));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
                                                                                                                        instance.setIndexAuthLevel(mapToFieldIndexAuthLevel(value));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
                                                                                                                            instance.setIndexWrAuthLevel(mapToFieldIndexWrAuthLevel(value));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
                                                                                                                                instance.setIndexExAuthLevel(mapToFieldIndexExAuthLevel(value));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
                                                                                                                                    instance.setIndexSubmitByTopIns(mapToFieldIndexSubmitByTopIns(value));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelWikiIndex.FI_INDEXASPECT)) {
                                                                                                                                        instance.setIndexAspect(mapToFieldIndexAspect(value));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
                                                                                                                                            instance.setIndexRelatedObj(mapToFieldIndexRelatedObj(value));
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelWikiIndex.FI_INDEXTYPE)) {
                                                                                                                                                instance.setIndexType(mapToFieldIndexType(value));
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static class ResultSetMapperModelWikiIndex<T extends ModelWikiIndex>
        extends BaseDbMapper<T>
        implements DbResultSetMapper<T>
    {

        @Override
        public T mapRow(ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            T instance = buildInstance();
            return mapRow(instance, rs, rowNum, columnNames);
        }

        protected T buildInstance() {
            return ((T) new ModelWikiIndex());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldIndexId(rs, columnNames, instance);
            mapFieldIndexLevel(rs, columnNames, instance);
            mapFieldIndexParent(rs, columnNames, instance);
            mapFieldIndexNext(rs, columnNames, instance);
            mapFieldIndexPrev(rs, columnNames, instance);
            mapFieldIndexIndex(rs, columnNames, instance);
            mapFieldIndexRoot(rs, columnNames, instance);
            mapFieldIndexLeftValue(rs, columnNames, instance);
            mapFieldIndexRightValue(rs, columnNames, instance);
            mapFieldIndexTitle(rs, columnNames, instance);
            mapFieldIndexContent(rs, columnNames, instance);
            mapFieldIndexIcon(rs, columnNames, instance);
            mapFieldIndexBackground(rs, columnNames, instance);
            mapFieldIndexRank(rs, columnNames, instance);
            mapFieldIndexPageId(rs, columnNames, instance);
            mapFieldIndexChildrenCount(rs, columnNames, instance);
            mapFieldIndexSequence(rs, columnNames, instance);
            mapFieldIndexCreateTime(rs, columnNames, instance);
            mapFieldIndexPublishTime(rs, columnNames, instance);
            mapFieldIndexStatus(rs, columnNames, instance);
            mapFieldIndexResourceUrl(rs, columnNames, instance);
            mapFieldIndexDefaultTemplate(rs, columnNames, instance);
            mapFieldIndexSubmitBy(rs, columnNames, instance);
            mapFieldIndexSubmitByGp(rs, columnNames, instance);
            mapFieldIndexSubmitByIns(rs, columnNames, instance);
            mapFieldIndexSubmitByFamily(rs, columnNames, instance);
            mapFieldIndexAuthLevel(rs, columnNames, instance);
            mapFieldIndexWrAuthLevel(rs, columnNames, instance);
            mapFieldIndexExAuthLevel(rs, columnNames, instance);
            mapFieldIndexSubmitByTopIns(rs, columnNames, instance);
            mapFieldIndexAspect(rs, columnNames, instance);
            mapFieldIndexRelatedObj(rs, columnNames, instance);
            mapFieldIndexType(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldIndexId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXID)) {
                instance.setIndexId(rs.getInt(ModelWikiIndex.FI_INDEXID));
            }
        }

        protected void mapFieldIndexLevel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXLEVEL)) {
                instance.setIndexLevel(rs.getByte(ModelWikiIndex.FI_INDEXLEVEL));
            }
        }

        protected void mapFieldIndexParent(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXPARENT)) {
                instance.setIndexParent(rs.getInt(ModelWikiIndex.FI_INDEXPARENT));
            }
        }

        protected void mapFieldIndexNext(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXNEXT)) {
                instance.setIndexNext(rs.getInt(ModelWikiIndex.FI_INDEXNEXT));
            }
        }

        protected void mapFieldIndexPrev(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXPREV)) {
                instance.setIndexPrev(rs.getInt(ModelWikiIndex.FI_INDEXPREV));
            }
        }

        protected void mapFieldIndexIndex(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXINDEX)) {
                instance.setIndexIndex(rs.getShort(ModelWikiIndex.FI_INDEXINDEX));
            }
        }

        protected void mapFieldIndexRoot(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXROOT)) {
                instance.setIndexRoot(rs.getInt(ModelWikiIndex.FI_INDEXROOT));
            }
        }

        protected void mapFieldIndexLeftValue(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXLEFTVALUE)) {
                instance.setIndexLeftValue(rs.getInt(ModelWikiIndex.FI_INDEXLEFTVALUE));
            }
        }

        protected void mapFieldIndexRightValue(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXRIGHTVALUE)) {
                instance.setIndexRightValue(rs.getInt(ModelWikiIndex.FI_INDEXRIGHTVALUE));
            }
        }

        protected void mapFieldIndexTitle(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXTITLE)) {
                instance.setIndexTitle(rs.getString(ModelWikiIndex.FI_INDEXTITLE));
            }
        }

        protected void mapFieldIndexContent(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXCONTENT)) {
                instance.setIndexContent(rs.getString(ModelWikiIndex.FI_INDEXCONTENT));
            }
        }

        protected void mapFieldIndexIcon(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXICON)) {
                instance.setIndexIcon(rs.getString(ModelWikiIndex.FI_INDEXICON));
            }
        }

        protected void mapFieldIndexBackground(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXBACKGROUND)) {
                instance.setIndexBackground(rs.getString(ModelWikiIndex.FI_INDEXBACKGROUND));
            }
        }

        protected void mapFieldIndexRank(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXRANK)) {
                instance.setIndexRank(rs.getShort(ModelWikiIndex.FI_INDEXRANK));
            }
        }

        protected void mapFieldIndexPageId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXPAGEID)) {
                instance.setIndexPageId(rs.getInt(ModelWikiIndex.FI_INDEXPAGEID));
            }
        }

        protected void mapFieldIndexChildrenCount(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXCHILDRENCOUNT)) {
                instance.setIndexChildrenCount(rs.getShort(ModelWikiIndex.FI_INDEXCHILDRENCOUNT));
            }
        }

        protected void mapFieldIndexSequence(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSEQUENCE)) {
                instance.setIndexSequence(rs.getString(ModelWikiIndex.FI_INDEXSEQUENCE));
            }
        }

        protected void mapFieldIndexCreateTime(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXCREATETIME)) {
                instance.setIndexCreateTime(rs.getTimestamp(ModelWikiIndex.FI_INDEXCREATETIME));
            }
        }

        protected void mapFieldIndexPublishTime(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXPUBLISHTIME)) {
                instance.setIndexPublishTime(rs.getTimestamp(ModelWikiIndex.FI_INDEXPUBLISHTIME));
            }
        }

        protected void mapFieldIndexStatus(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSTATUS)) {
                instance.setIndexStatus(EnumIndexStatus.fromValue(rs.getByte(ModelWikiIndex.FI_INDEXSTATUS)));
            }
        }

        protected void mapFieldIndexResourceUrl(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXRESOURCEURL)) {
                instance.setIndexResourceUrl(rs.getString(ModelWikiIndex.FI_INDEXRESOURCEURL));
            }
        }

        protected void mapFieldIndexDefaultTemplate(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE)) {
                instance.setIndexDefaultTemplate(rs.getString(ModelWikiIndex.FI_INDEXDEFAULTTEMPLATE));
            }
        }

        protected void mapFieldIndexSubmitBy(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSUBMITBY)) {
                instance.setIndexSubmitBy(rs.getInt(ModelWikiIndex.FI_INDEXSUBMITBY));
            }
        }

        protected void mapFieldIndexSubmitByGp(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSUBMITBYGP)) {
                instance.setIndexSubmitByGp(rs.getInt(ModelWikiIndex.FI_INDEXSUBMITBYGP));
            }
        }

        protected void mapFieldIndexSubmitByIns(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSUBMITBYINS)) {
                instance.setIndexSubmitByIns(rs.getInt(ModelWikiIndex.FI_INDEXSUBMITBYINS));
            }
        }

        protected void mapFieldIndexSubmitByFamily(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY)) {
                instance.setIndexSubmitByFamily(rs.getInt(ModelWikiIndex.FI_INDEXSUBMITBYFAMILY));
            }
        }

        protected void mapFieldIndexAuthLevel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXAUTHLEVEL)) {
                instance.setIndexAuthLevel(rs.getShort(ModelWikiIndex.FI_INDEXAUTHLEVEL));
            }
        }

        protected void mapFieldIndexWrAuthLevel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXWRAUTHLEVEL)) {
                instance.setIndexWrAuthLevel(rs.getShort(ModelWikiIndex.FI_INDEXWRAUTHLEVEL));
            }
        }

        protected void mapFieldIndexExAuthLevel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXEXAUTHLEVEL)) {
                instance.setIndexExAuthLevel(rs.getShort(ModelWikiIndex.FI_INDEXEXAUTHLEVEL));
            }
        }

        protected void mapFieldIndexSubmitByTopIns(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS)) {
                instance.setIndexSubmitByTopIns(rs.getInt(ModelWikiIndex.FI_INDEXSUBMITBYTOPINS));
            }
        }

        protected void mapFieldIndexAspect(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXASPECT)) {
                instance.setIndexAspect(rs.getByte(ModelWikiIndex.FI_INDEXASPECT));
            }
        }

        protected void mapFieldIndexRelatedObj(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXRELATEDOBJ)) {
                instance.setIndexRelatedObj(rs.getInt(ModelWikiIndex.FI_INDEXRELATEDOBJ));
            }
        }

        protected void mapFieldIndexType(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndex.FI_INDEXTYPE)) {
                instance.setIndexType(rs.getByte(ModelWikiIndex.FI_INDEXTYPE));
            }
        }
    }
}
