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
import com.shangde.ent_portal.logical.dto.enums.EnumPageType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :wiki_page
 * 	内容表----用于存储展示界面

 * 表内的每条记录都是一条知识
 */
public class ModelWikiPage
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "pageId";
    public final static String DTO_TABLE_NAME = "wiki_page";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.wiki_page.pageId 字段
     * 
     */
    Integer pageId;
    public final static String FI_PAGEID = "pageId";
    /**
     * 对应数据库.wiki_page.pageVisitName 字段
     * 访问的名称，使用Id访问会造成安全问题，例如恶意遍历全部网站，此处使用随机生成的字符串来访问
     */
    String pageVisitName;
    public final static String FI_PAGEVISITNAME = "pageVisitName";
    /**
     * 对应数据库.wiki_page.pageContent 字段
     * 内容，html5为直接的富文本存储，其他类型为抽取出的文件内容
     */
    String pageContent;
    public final static String FI_PAGECONTENT = "pageContent";
    /**
     * 对应数据库.wiki_page.pageTitle 字段
     * 标题
     */
    String pageTitle;
    public final static String FI_PAGETITLE = "pageTitle";
    /**
     * 对应数据库.wiki_page.pageIndex 字段
     * 索引，对应索引表中的id
     */
    Integer pageIndex;
    public final static String FI_PAGEINDEX = "pageIndex";
    /**
     * 对应数据库.wiki_page.pageVersion 字段
     * 页面版本
     */
    Byte pageVersion;
    public final static String FI_PAGEVERSION = "pageVersion";
    /**
     * 对应数据库.wiki_page.pageSubmitBy 字段
     * 创建人
     */
    Integer pageSubmitBy;
    public final static String FI_PAGESUBMITBY = "pageSubmitBy";
    /**
     * 对应数据库.wiki_page.pageSubmitByGp 字段
     * 创建组
     */
    Integer pageSubmitByGp;
    public final static String FI_PAGESUBMITBYGP = "pageSubmitByGp";
    /**
     * 对应数据库.wiki_page.pageSubmitByIns 字段
     * 创建学院
     */
    Integer pageSubmitByIns;
    public final static String FI_PAGESUBMITBYINS = "pageSubmitByIns";
    /**
     * 对应数据库.wiki_page.pageSubmitByFamily 字段
     * 创建家族
     */
    Integer pageSubmitByFamily;
    public final static String FI_PAGESUBMITBYFAMILY = "pageSubmitByFamily";
    /**
     * 对应数据库.wiki_page.pageCreatedOn 字段
     * 创建时间
     */
    Date pageCreatedOn;
    public final static String FI_PAGECREATEDON = "pageCreatedOn";
    /**
     * 对应数据库.wiki_page.pageAddition 字段
     * 备注
     */
    String pageAddition;
    public final static String FI_PAGEADDITION = "pageAddition";
    /**
     * 对应数据库.wiki_page.pageState 字段
     * 逻辑删除位
     */
    Byte pageState;
    public final static String FI_PAGESTATE = "pageState";
    /**
     * 对应数据库.wiki_page.pageDisplayMethod 字段
     * 展示方式，预留
     */
    String pageDisplayMethod;
    public final static String FI_PAGEDISPLAYMETHOD = "pageDisplayMethod";
    /**
     * 对应数据库.wiki_page.pageAspect 字段
     * 页面类型：0 普通1 其他插件
     */
    Byte pageAspect;
    public final static String FI_PAGEASPECT = "pageAspect";
    /**
     * 对应数据库.wiki_page.pageType 字段
     * @@Enum--
     */
    EnumPageType pageType;
    public final static String FI_PAGETYPE = "pageType";
    /**
     * 对应数据库.wiki_page.pageResourceUrl 字段
     * 用于存储外链页面，或者资源性质页面，例如图集/视频的地址
     */
    String pageResourceUrl;
    public final static String FI_PAGERESOURCEURL = "pageResourceUrl";
    /**
     * 对应数据库.wiki_page.pageFileSize 字段
     * 
     */
    Long pageFileSize;
    public final static String FI_PAGEFILESIZE = "pageFileSize";
    /**
     * 对应数据库.wiki_page.pageRelatedObject 字段
     * 
     */
    Integer pageRelatedObject;
    public final static String FI_PAGERELATEDOBJECT = "pageRelatedObject";
    /**
     * 对应数据库.wiki_page.pageSubmitByTopIns 字段
     * 
     */
    Integer pageSubmitByTopIns;
    public final static String FI_PAGESUBMITBYTOPINS = "pageSubmitByTopIns";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelWikiPage.FI_PAGEID, Integer.class).put(ModelWikiPage.FI_PAGEVISITNAME, String.class).put(ModelWikiPage.FI_PAGECONTENT, String.class).put(ModelWikiPage.FI_PAGETITLE, String.class).put(ModelWikiPage.FI_PAGEINDEX, Integer.class).put(ModelWikiPage.FI_PAGEVERSION, Byte.class).put(ModelWikiPage.FI_PAGESUBMITBY, Integer.class).put(ModelWikiPage.FI_PAGESUBMITBYGP, Integer.class).put(ModelWikiPage.FI_PAGESUBMITBYINS, Integer.class).put(ModelWikiPage.FI_PAGESUBMITBYFAMILY, Integer.class).put(ModelWikiPage.FI_PAGECREATEDON, Date.class).put(ModelWikiPage.FI_PAGEADDITION, String.class).put(ModelWikiPage.FI_PAGESTATE, Byte.class).put(ModelWikiPage.FI_PAGEDISPLAYMETHOD, String.class).put(ModelWikiPage.FI_PAGEASPECT, Byte.class).put(ModelWikiPage.FI_PAGETYPE, EnumPageType.class).put(ModelWikiPage.FI_PAGERESOURCEURL, String.class).put(ModelWikiPage.FI_PAGEFILESIZE, Long.class).put(ModelWikiPage.FI_PAGERELATEDOBJECT, Integer.class).put(ModelWikiPage.FI_PAGESUBMITBYTOPINS, Integer.class).getMap();
    public final static Integer FIELD_COUNT = 20;
    public final static ResultSetMapperModelWikiPage<ModelWikiPage> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelWikiPage<com.shangde.ent_portal.logical.dto.basepo.ModelWikiPage>();
    public final static ByteMapMapperModelWikiPage MAP_OBJ_MAPPER = new ByteMapMapperModelWikiPage();

    public ModelWikiPage() {
    }

    public Integer getPageId() {
        return pageId;
    }

    public ModelWikiPage setPageId(Integer lPageId) {
        pageId = lPageId;
        return this;
    }

    public String getPageVisitName() {
        return pageVisitName;
    }

    public ModelWikiPage setPageVisitName(String lPageVisitName) {
        pageVisitName = lPageVisitName;
        return this;
    }

    public String getPageContent() {
        return pageContent;
    }

    public ModelWikiPage setPageContent(String lPageContent) {
        pageContent = lPageContent;
        return this;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public ModelWikiPage setPageTitle(String lPageTitle) {
        pageTitle = lPageTitle;
        return this;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public ModelWikiPage setPageIndex(Integer lPageIndex) {
        pageIndex = lPageIndex;
        return this;
    }

    public Byte getPageVersion() {
        return pageVersion;
    }

    public ModelWikiPage setPageVersion(Byte lPageVersion) {
        pageVersion = lPageVersion;
        return this;
    }

    public Integer getPageSubmitBy() {
        return pageSubmitBy;
    }

    public ModelWikiPage setPageSubmitBy(Integer lPageSubmitBy) {
        pageSubmitBy = lPageSubmitBy;
        return this;
    }

    public Integer getPageSubmitByGp() {
        return pageSubmitByGp;
    }

    public ModelWikiPage setPageSubmitByGp(Integer lPageSubmitByGp) {
        pageSubmitByGp = lPageSubmitByGp;
        return this;
    }

    public Integer getPageSubmitByIns() {
        return pageSubmitByIns;
    }

    public ModelWikiPage setPageSubmitByIns(Integer lPageSubmitByIns) {
        pageSubmitByIns = lPageSubmitByIns;
        return this;
    }

    public Integer getPageSubmitByFamily() {
        return pageSubmitByFamily;
    }

    public ModelWikiPage setPageSubmitByFamily(Integer lPageSubmitByFamily) {
        pageSubmitByFamily = lPageSubmitByFamily;
        return this;
    }

    public Date getPageCreatedOn() {
        return pageCreatedOn;
    }

    public ModelWikiPage setPageCreatedOn(Date lPageCreatedOn) {
        pageCreatedOn = lPageCreatedOn;
        return this;
    }

    public String getPageAddition() {
        return pageAddition;
    }

    public ModelWikiPage setPageAddition(String lPageAddition) {
        pageAddition = lPageAddition;
        return this;
    }

    public Byte getPageState() {
        return pageState;
    }

    public ModelWikiPage setPageState(Byte lPageState) {
        pageState = lPageState;
        return this;
    }

    public String getPageDisplayMethod() {
        return pageDisplayMethod;
    }

    public ModelWikiPage setPageDisplayMethod(String lPageDisplayMethod) {
        pageDisplayMethod = lPageDisplayMethod;
        return this;
    }

    public Byte getPageAspect() {
        return pageAspect;
    }

    public ModelWikiPage setPageAspect(Byte lPageAspect) {
        pageAspect = lPageAspect;
        return this;
    }

    public EnumPageType getPageType() {
        return pageType;
    }

    public ModelWikiPage setPageType(EnumPageType lPageType) {
        pageType = lPageType;
        return this;
    }

    public String getPageResourceUrl() {
        return pageResourceUrl;
    }

    public ModelWikiPage setPageResourceUrl(String lPageResourceUrl) {
        pageResourceUrl = lPageResourceUrl;
        return this;
    }

    public Long getPageFileSize() {
        return pageFileSize;
    }

    public ModelWikiPage setPageFileSize(Long lPageFileSize) {
        pageFileSize = lPageFileSize;
        return this;
    }

    public Integer getPageRelatedObject() {
        return pageRelatedObject;
    }

    public ModelWikiPage setPageRelatedObject(Integer lPageRelatedObject) {
        pageRelatedObject = lPageRelatedObject;
        return this;
    }

    public Integer getPageSubmitByTopIns() {
        return pageSubmitByTopIns;
    }

    public ModelWikiPage setPageSubmitByTopIns(Integer lPageSubmitByTopIns) {
        pageSubmitByTopIns = lPageSubmitByTopIns;
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
        if (getPageId()!= null) {
            return false;
        }
        if (getPageVisitName()!= null) {
            return false;
        }
        if (getPageContent()!= null) {
            return false;
        }
        if (getPageTitle()!= null) {
            return false;
        }
        if (getPageIndex()!= null) {
            return false;
        }
        if (getPageVersion()!= null) {
            return false;
        }
        if (getPageSubmitBy()!= null) {
            return false;
        }
        if (getPageSubmitByGp()!= null) {
            return false;
        }
        if (getPageSubmitByIns()!= null) {
            return false;
        }
        if (getPageSubmitByFamily()!= null) {
            return false;
        }
        if (getPageCreatedOn()!= null) {
            return false;
        }
        if (getPageAddition()!= null) {
            return false;
        }
        if (getPageState()!= null) {
            return false;
        }
        if (getPageDisplayMethod()!= null) {
            return false;
        }
        if (getPageAspect()!= null) {
            return false;
        }
        if (getPageType()!= null) {
            return false;
        }
        if (getPageResourceUrl()!= null) {
            return false;
        }
        if (getPageFileSize()!= null) {
            return false;
        }
        if (getPageRelatedObject()!= null) {
            return false;
        }
        if (getPageSubmitByTopIns()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _APIObj> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiPage.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiPage.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("pageId").append(":").append(pageId).append("}\n");
        ret.append("{").append("pageVisitName").append(":").append(pageVisitName).append("}\n");
        ret.append("{").append("pageContent").append(":").append(pageContent).append("}\n");
        ret.append("{").append("pageTitle").append(":").append(pageTitle).append("}\n");
        ret.append("{").append("pageIndex").append(":").append(pageIndex).append("}\n");
        ret.append("{").append("pageVersion").append(":").append(pageVersion).append("}\n");
        ret.append("{").append("pageSubmitBy").append(":").append(pageSubmitBy).append("}\n");
        ret.append("{").append("pageSubmitByGp").append(":").append(pageSubmitByGp).append("}\n");
        ret.append("{").append("pageSubmitByIns").append(":").append(pageSubmitByIns).append("}\n");
        ret.append("{").append("pageSubmitByFamily").append(":").append(pageSubmitByFamily).append("}\n");
        ret.append("{").append("pageCreatedOn").append(":").append(pageCreatedOn).append("}\n");
        ret.append("{").append("pageAddition").append(":").append(pageAddition).append("}\n");
        ret.append("{").append("pageState").append(":").append(pageState).append("}\n");
        ret.append("{").append("pageDisplayMethod").append(":").append(pageDisplayMethod).append("}\n");
        ret.append("{").append("pageAspect").append(":").append(pageAspect).append("}\n");
        ret.append("{").append("pageType").append(":").append(pageType).append("}\n");
        ret.append("{").append("pageResourceUrl").append(":").append(pageResourceUrl).append("}\n");
        ret.append("{").append("pageFileSize").append(":").append(pageFileSize).append("}\n");
        ret.append("{").append("pageRelatedObject").append(":").append(pageRelatedObject).append("}\n");
        ret.append("{").append("pageSubmitByTopIns").append(":").append(pageSubmitByTopIns).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelWikiPage
        implements RedisMapMapper<ModelWikiPage>
    {

        @Override
        public ModelWikiPage fromMap(Map<byte[], byte[]> map) {
            ModelWikiPage instance = new ModelWikiPage();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelWikiPage.FI_PAGEID)) {
                    instance.setPageId(mapToFieldPageId(entry.getValue()));
                } else {
                    if (field.equals(ModelWikiPage.FI_PAGEVISITNAME)) {
                        instance.setPageVisitName(mapToFieldPageVisitName(entry.getValue()));
                    } else {
                        if (field.equals(ModelWikiPage.FI_PAGECONTENT)) {
                            instance.setPageContent(mapToFieldPageContent(entry.getValue()));
                        } else {
                            if (field.equals(ModelWikiPage.FI_PAGETITLE)) {
                                instance.setPageTitle(mapToFieldPageTitle(entry.getValue()));
                            } else {
                                if (field.equals(ModelWikiPage.FI_PAGEINDEX)) {
                                    instance.setPageIndex(mapToFieldPageIndex(entry.getValue()));
                                } else {
                                    if (field.equals(ModelWikiPage.FI_PAGEVERSION)) {
                                        instance.setPageVersion(mapToFieldPageVersion(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelWikiPage.FI_PAGESUBMITBY)) {
                                            instance.setPageSubmitBy(mapToFieldPageSubmitBy(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelWikiPage.FI_PAGESUBMITBYGP)) {
                                                instance.setPageSubmitByGp(mapToFieldPageSubmitByGp(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelWikiPage.FI_PAGESUBMITBYINS)) {
                                                    instance.setPageSubmitByIns(mapToFieldPageSubmitByIns(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
                                                        instance.setPageSubmitByFamily(mapToFieldPageSubmitByFamily(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelWikiPage.FI_PAGECREATEDON)) {
                                                            instance.setPageCreatedOn(mapToFieldPageCreatedOn(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelWikiPage.FI_PAGEADDITION)) {
                                                                instance.setPageAddition(mapToFieldPageAddition(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelWikiPage.FI_PAGESTATE)) {
                                                                    instance.setPageState(mapToFieldPageState(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
                                                                        instance.setPageDisplayMethod(mapToFieldPageDisplayMethod(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelWikiPage.FI_PAGEASPECT)) {
                                                                            instance.setPageAspect(mapToFieldPageAspect(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelWikiPage.FI_PAGETYPE)) {
                                                                                instance.setPageType(mapToFieldPageType(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelWikiPage.FI_PAGERESOURCEURL)) {
                                                                                    instance.setPageResourceUrl(mapToFieldPageResourceUrl(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelWikiPage.FI_PAGEFILESIZE)) {
                                                                                        instance.setPageFileSize(mapToFieldPageFileSize(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
                                                                                            instance.setPageRelatedObject(mapToFieldPageRelatedObject(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
                                                                                                instance.setPageSubmitByTopIns(mapToFieldPageSubmitByTopIns(entry.getValue()));
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

        protected Integer mapToFieldPageId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldPageVisitName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPageContent(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPageTitle(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldPageIndex(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldPageVersion(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldPageSubmitBy(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldPageSubmitByGp(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldPageSubmitByIns(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldPageSubmitByFamily(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldPageCreatedOn(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldPageAddition(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldPageState(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected String mapToFieldPageDisplayMethod(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldPageAspect(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected EnumPageType mapToFieldPageType(byte[] bytes) {
            return EnumPageType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected String mapToFieldPageResourceUrl(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Long mapToFieldPageFileSize(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        protected Integer mapToFieldPageRelatedObject(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldPageSubmitByTopIns(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelWikiPage instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valuePageId = mapFromFieldPageId(instance.getPageId());
            ret.put(ModelWikiPage.FI_PAGEID.getBytes(), valuePageId);
            byte[] valuePageVisitName = mapFromFieldPageVisitName(instance.getPageVisitName());
            ret.put(ModelWikiPage.FI_PAGEVISITNAME.getBytes(), valuePageVisitName);
            byte[] valuePageContent = mapFromFieldPageContent(instance.getPageContent());
            ret.put(ModelWikiPage.FI_PAGECONTENT.getBytes(), valuePageContent);
            byte[] valuePageTitle = mapFromFieldPageTitle(instance.getPageTitle());
            ret.put(ModelWikiPage.FI_PAGETITLE.getBytes(), valuePageTitle);
            byte[] valuePageIndex = mapFromFieldPageIndex(instance.getPageIndex());
            ret.put(ModelWikiPage.FI_PAGEINDEX.getBytes(), valuePageIndex);
            byte[] valuePageVersion = mapFromFieldPageVersion(instance.getPageVersion());
            ret.put(ModelWikiPage.FI_PAGEVERSION.getBytes(), valuePageVersion);
            byte[] valuePageSubmitBy = mapFromFieldPageSubmitBy(instance.getPageSubmitBy());
            ret.put(ModelWikiPage.FI_PAGESUBMITBY.getBytes(), valuePageSubmitBy);
            byte[] valuePageSubmitByGp = mapFromFieldPageSubmitByGp(instance.getPageSubmitByGp());
            ret.put(ModelWikiPage.FI_PAGESUBMITBYGP.getBytes(), valuePageSubmitByGp);
            byte[] valuePageSubmitByIns = mapFromFieldPageSubmitByIns(instance.getPageSubmitByIns());
            ret.put(ModelWikiPage.FI_PAGESUBMITBYINS.getBytes(), valuePageSubmitByIns);
            byte[] valuePageSubmitByFamily = mapFromFieldPageSubmitByFamily(instance.getPageSubmitByFamily());
            ret.put(ModelWikiPage.FI_PAGESUBMITBYFAMILY.getBytes(), valuePageSubmitByFamily);
            byte[] valuePageCreatedOn = mapFromFieldPageCreatedOn(instance.getPageCreatedOn());
            ret.put(ModelWikiPage.FI_PAGECREATEDON.getBytes(), valuePageCreatedOn);
            byte[] valuePageAddition = mapFromFieldPageAddition(instance.getPageAddition());
            ret.put(ModelWikiPage.FI_PAGEADDITION.getBytes(), valuePageAddition);
            byte[] valuePageState = mapFromFieldPageState(instance.getPageState());
            ret.put(ModelWikiPage.FI_PAGESTATE.getBytes(), valuePageState);
            byte[] valuePageDisplayMethod = mapFromFieldPageDisplayMethod(instance.getPageDisplayMethod());
            ret.put(ModelWikiPage.FI_PAGEDISPLAYMETHOD.getBytes(), valuePageDisplayMethod);
            byte[] valuePageAspect = mapFromFieldPageAspect(instance.getPageAspect());
            ret.put(ModelWikiPage.FI_PAGEASPECT.getBytes(), valuePageAspect);
            byte[] valuePageType = mapFromFieldPageType(instance.getPageType());
            ret.put(ModelWikiPage.FI_PAGETYPE.getBytes(), valuePageType);
            byte[] valuePageResourceUrl = mapFromFieldPageResourceUrl(instance.getPageResourceUrl());
            ret.put(ModelWikiPage.FI_PAGERESOURCEURL.getBytes(), valuePageResourceUrl);
            byte[] valuePageFileSize = mapFromFieldPageFileSize(instance.getPageFileSize());
            ret.put(ModelWikiPage.FI_PAGEFILESIZE.getBytes(), valuePageFileSize);
            byte[] valuePageRelatedObject = mapFromFieldPageRelatedObject(instance.getPageRelatedObject());
            ret.put(ModelWikiPage.FI_PAGERELATEDOBJECT.getBytes(), valuePageRelatedObject);
            byte[] valuePageSubmitByTopIns = mapFromFieldPageSubmitByTopIns(instance.getPageSubmitByTopIns());
            ret.put(ModelWikiPage.FI_PAGESUBMITBYTOPINS.getBytes(), valuePageSubmitByTopIns);
            return ret;
        }

        protected byte[] mapFromFieldPageId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageVisitName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageContent(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageTitle(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageIndex(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageVersion(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageSubmitBy(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageSubmitByGp(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageSubmitByIns(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageSubmitByFamily(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageCreatedOn(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageAddition(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageState(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageDisplayMethod(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageAspect(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageType(EnumPageType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldPageResourceUrl(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageFileSize(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageRelatedObject(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPageSubmitByTopIns(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelWikiPage instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dPageId = instance.getPageId();
            if (dPageId!= null) {
                ret.put(ModelWikiPage.FI_PAGEID, dPageId);
            }
            String dPageVisitName = instance.getPageVisitName();
            if (dPageVisitName!= null) {
                ret.put(ModelWikiPage.FI_PAGEVISITNAME, dPageVisitName);
            }
            String dPageContent = instance.getPageContent();
            if (dPageContent!= null) {
                ret.put(ModelWikiPage.FI_PAGECONTENT, dPageContent);
            }
            String dPageTitle = instance.getPageTitle();
            if (dPageTitle!= null) {
                ret.put(ModelWikiPage.FI_PAGETITLE, dPageTitle);
            }
            Integer dPageIndex = instance.getPageIndex();
            if (dPageIndex!= null) {
                ret.put(ModelWikiPage.FI_PAGEINDEX, dPageIndex);
            }
            Byte dPageVersion = instance.getPageVersion();
            if (dPageVersion!= null) {
                ret.put(ModelWikiPage.FI_PAGEVERSION, dPageVersion);
            }
            Integer dPageSubmitBy = instance.getPageSubmitBy();
            if (dPageSubmitBy!= null) {
                ret.put(ModelWikiPage.FI_PAGESUBMITBY, dPageSubmitBy);
            }
            Integer dPageSubmitByGp = instance.getPageSubmitByGp();
            if (dPageSubmitByGp!= null) {
                ret.put(ModelWikiPage.FI_PAGESUBMITBYGP, dPageSubmitByGp);
            }
            Integer dPageSubmitByIns = instance.getPageSubmitByIns();
            if (dPageSubmitByIns!= null) {
                ret.put(ModelWikiPage.FI_PAGESUBMITBYINS, dPageSubmitByIns);
            }
            Integer dPageSubmitByFamily = instance.getPageSubmitByFamily();
            if (dPageSubmitByFamily!= null) {
                ret.put(ModelWikiPage.FI_PAGESUBMITBYFAMILY, dPageSubmitByFamily);
            }
            Date dPageCreatedOn = instance.getPageCreatedOn();
            if (dPageCreatedOn!= null) {
                ret.put(ModelWikiPage.FI_PAGECREATEDON, dPageCreatedOn);
            }
            String dPageAddition = instance.getPageAddition();
            if (dPageAddition!= null) {
                ret.put(ModelWikiPage.FI_PAGEADDITION, dPageAddition);
            }
            Byte dPageState = instance.getPageState();
            if (dPageState!= null) {
                ret.put(ModelWikiPage.FI_PAGESTATE, dPageState);
            }
            String dPageDisplayMethod = instance.getPageDisplayMethod();
            if (dPageDisplayMethod!= null) {
                ret.put(ModelWikiPage.FI_PAGEDISPLAYMETHOD, dPageDisplayMethod);
            }
            Byte dPageAspect = instance.getPageAspect();
            if (dPageAspect!= null) {
                ret.put(ModelWikiPage.FI_PAGEASPECT, dPageAspect);
            }
            EnumPageType dPageType = instance.getPageType();
            if (dPageType!= null) {
                ret.put(ModelWikiPage.FI_PAGETYPE, dPageType.val);
            }
            String dPageResourceUrl = instance.getPageResourceUrl();
            if (dPageResourceUrl!= null) {
                ret.put(ModelWikiPage.FI_PAGERESOURCEURL, dPageResourceUrl);
            }
            Long dPageFileSize = instance.getPageFileSize();
            if (dPageFileSize!= null) {
                ret.put(ModelWikiPage.FI_PAGEFILESIZE, dPageFileSize);
            }
            Integer dPageRelatedObject = instance.getPageRelatedObject();
            if (dPageRelatedObject!= null) {
                ret.put(ModelWikiPage.FI_PAGERELATEDOBJECT, dPageRelatedObject);
            }
            Integer dPageSubmitByTopIns = instance.getPageSubmitByTopIns();
            if (dPageSubmitByTopIns!= null) {
                ret.put(ModelWikiPage.FI_PAGESUBMITBYTOPINS, dPageSubmitByTopIns);
            }
            return ret;
        }

        @Override
        public ModelWikiPage fromCommonMap(Map<String, Object> param) {
            ModelWikiPage ret = new ModelWikiPage();
            if (param == null) {
                return ret;
            }
            Object dPageId = param.get(ModelWikiPage.FI_PAGEID);
            if (dPageId!= null) {
                this.setField(ModelWikiPage.FI_PAGEID, ret, dPageId);
            }
            Object dPageVisitName = param.get(ModelWikiPage.FI_PAGEVISITNAME);
            if (dPageVisitName!= null) {
                this.setField(ModelWikiPage.FI_PAGEVISITNAME, ret, dPageVisitName);
            }
            Object dPageContent = param.get(ModelWikiPage.FI_PAGECONTENT);
            if (dPageContent!= null) {
                this.setField(ModelWikiPage.FI_PAGECONTENT, ret, dPageContent);
            }
            Object dPageTitle = param.get(ModelWikiPage.FI_PAGETITLE);
            if (dPageTitle!= null) {
                this.setField(ModelWikiPage.FI_PAGETITLE, ret, dPageTitle);
            }
            Object dPageIndex = param.get(ModelWikiPage.FI_PAGEINDEX);
            if (dPageIndex!= null) {
                this.setField(ModelWikiPage.FI_PAGEINDEX, ret, dPageIndex);
            }
            Object dPageVersion = param.get(ModelWikiPage.FI_PAGEVERSION);
            if (dPageVersion!= null) {
                this.setField(ModelWikiPage.FI_PAGEVERSION, ret, dPageVersion);
            }
            Object dPageSubmitBy = param.get(ModelWikiPage.FI_PAGESUBMITBY);
            if (dPageSubmitBy!= null) {
                this.setField(ModelWikiPage.FI_PAGESUBMITBY, ret, dPageSubmitBy);
            }
            Object dPageSubmitByGp = param.get(ModelWikiPage.FI_PAGESUBMITBYGP);
            if (dPageSubmitByGp!= null) {
                this.setField(ModelWikiPage.FI_PAGESUBMITBYGP, ret, dPageSubmitByGp);
            }
            Object dPageSubmitByIns = param.get(ModelWikiPage.FI_PAGESUBMITBYINS);
            if (dPageSubmitByIns!= null) {
                this.setField(ModelWikiPage.FI_PAGESUBMITBYINS, ret, dPageSubmitByIns);
            }
            Object dPageSubmitByFamily = param.get(ModelWikiPage.FI_PAGESUBMITBYFAMILY);
            if (dPageSubmitByFamily!= null) {
                this.setField(ModelWikiPage.FI_PAGESUBMITBYFAMILY, ret, dPageSubmitByFamily);
            }
            Object dPageCreatedOn = param.get(ModelWikiPage.FI_PAGECREATEDON);
            if (dPageCreatedOn!= null) {
                this.setField(ModelWikiPage.FI_PAGECREATEDON, ret, dPageCreatedOn);
            }
            Object dPageAddition = param.get(ModelWikiPage.FI_PAGEADDITION);
            if (dPageAddition!= null) {
                this.setField(ModelWikiPage.FI_PAGEADDITION, ret, dPageAddition);
            }
            Object dPageState = param.get(ModelWikiPage.FI_PAGESTATE);
            if (dPageState!= null) {
                this.setField(ModelWikiPage.FI_PAGESTATE, ret, dPageState);
            }
            Object dPageDisplayMethod = param.get(ModelWikiPage.FI_PAGEDISPLAYMETHOD);
            if (dPageDisplayMethod!= null) {
                this.setField(ModelWikiPage.FI_PAGEDISPLAYMETHOD, ret, dPageDisplayMethod);
            }
            Object dPageAspect = param.get(ModelWikiPage.FI_PAGEASPECT);
            if (dPageAspect!= null) {
                this.setField(ModelWikiPage.FI_PAGEASPECT, ret, dPageAspect);
            }
            Object dPageType = param.get(ModelWikiPage.FI_PAGETYPE);
            if (dPageType!= null) {
                this.setField(ModelWikiPage.FI_PAGETYPE, ret, dPageType);
            }
            Object dPageResourceUrl = param.get(ModelWikiPage.FI_PAGERESOURCEURL);
            if (dPageResourceUrl!= null) {
                this.setField(ModelWikiPage.FI_PAGERESOURCEURL, ret, dPageResourceUrl);
            }
            Object dPageFileSize = param.get(ModelWikiPage.FI_PAGEFILESIZE);
            if (dPageFileSize!= null) {
                this.setField(ModelWikiPage.FI_PAGEFILESIZE, ret, dPageFileSize);
            }
            Object dPageRelatedObject = param.get(ModelWikiPage.FI_PAGERELATEDOBJECT);
            if (dPageRelatedObject!= null) {
                this.setField(ModelWikiPage.FI_PAGERELATEDOBJECT, ret, dPageRelatedObject);
            }
            Object dPageSubmitByTopIns = param.get(ModelWikiPage.FI_PAGESUBMITBYTOPINS);
            if (dPageSubmitByTopIns!= null) {
                this.setField(ModelWikiPage.FI_PAGESUBMITBYTOPINS, ret, dPageSubmitByTopIns);
            }
            return ret;
        }

        protected Integer mapToFieldPageId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldPageVisitName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPageContent(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPageTitle(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldPageIndex(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldPageVersion(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldPageSubmitBy(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldPageSubmitByGp(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldPageSubmitByIns(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldPageSubmitByFamily(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldPageCreatedOn(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldPageAddition(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldPageState(Object obj) {
            return ((Byte) obj);
        }

        protected String mapToFieldPageDisplayMethod(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldPageAspect(Object obj) {
            return ((Byte) obj);
        }

        protected EnumPageType mapToFieldPageType(Object obj) {
            return EnumPageType.fromValue(((Byte) obj));
        }

        protected String mapToFieldPageResourceUrl(Object obj) {
            return ((String) obj);
        }

        protected Long mapToFieldPageFileSize(Object obj) {
            return ((Long) obj);
        }

        protected Integer mapToFieldPageRelatedObject(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldPageSubmitByTopIns(Object obj) {
            return ((Integer) obj);
        }

        public<TT> TT getField(String field, ModelWikiPage instance) {
            try {
                if (field.equals(ModelWikiPage.FI_PAGEID)) {
                    return ((TT) instance.getPageId());
                } else {
                    if (field.equals(ModelWikiPage.FI_PAGEVISITNAME)) {
                        return ((TT) instance.getPageVisitName());
                    } else {
                        if (field.equals(ModelWikiPage.FI_PAGECONTENT)) {
                            return ((TT) instance.getPageContent());
                        } else {
                            if (field.equals(ModelWikiPage.FI_PAGETITLE)) {
                                return ((TT) instance.getPageTitle());
                            } else {
                                if (field.equals(ModelWikiPage.FI_PAGEINDEX)) {
                                    return ((TT) instance.getPageIndex());
                                } else {
                                    if (field.equals(ModelWikiPage.FI_PAGEVERSION)) {
                                        return ((TT) instance.getPageVersion());
                                    } else {
                                        if (field.equals(ModelWikiPage.FI_PAGESUBMITBY)) {
                                            return ((TT) instance.getPageSubmitBy());
                                        } else {
                                            if (field.equals(ModelWikiPage.FI_PAGESUBMITBYGP)) {
                                                return ((TT) instance.getPageSubmitByGp());
                                            } else {
                                                if (field.equals(ModelWikiPage.FI_PAGESUBMITBYINS)) {
                                                    return ((TT) instance.getPageSubmitByIns());
                                                } else {
                                                    if (field.equals(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
                                                        return ((TT) instance.getPageSubmitByFamily());
                                                    } else {
                                                        if (field.equals(ModelWikiPage.FI_PAGECREATEDON)) {
                                                            return ((TT) instance.getPageCreatedOn());
                                                        } else {
                                                            if (field.equals(ModelWikiPage.FI_PAGEADDITION)) {
                                                                return ((TT) instance.getPageAddition());
                                                            } else {
                                                                if (field.equals(ModelWikiPage.FI_PAGESTATE)) {
                                                                    return ((TT) instance.getPageState());
                                                                } else {
                                                                    if (field.equals(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
                                                                        return ((TT) instance.getPageDisplayMethod());
                                                                    } else {
                                                                        if (field.equals(ModelWikiPage.FI_PAGEASPECT)) {
                                                                            return ((TT) instance.getPageAspect());
                                                                        } else {
                                                                            if (field.equals(ModelWikiPage.FI_PAGETYPE)) {
                                                                                return ((TT) instance.getPageType());
                                                                            } else {
                                                                                if (field.equals(ModelWikiPage.FI_PAGERESOURCEURL)) {
                                                                                    return ((TT) instance.getPageResourceUrl());
                                                                                } else {
                                                                                    if (field.equals(ModelWikiPage.FI_PAGEFILESIZE)) {
                                                                                        return ((TT) instance.getPageFileSize());
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
                                                                                            return ((TT) instance.getPageRelatedObject());
                                                                                        } else {
                                                                                            if (field.equals(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
                                                                                                return ((TT) instance.getPageSubmitByTopIns());
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

        public<TT> void setField(String field, ModelWikiPage instance, TT value) {
            if (field.equals(ModelWikiPage.FI_PAGEID)) {
                try {
                    instance.setPageId(mapToFieldPageId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelWikiPage.FI_PAGEVISITNAME)) {
                    try {
                        instance.setPageVisitName(mapToFieldPageVisitName(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelWikiPage.FI_PAGECONTENT)) {
                        try {
                            instance.setPageContent(mapToFieldPageContent(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelWikiPage.FI_PAGETITLE)) {
                            try {
                                instance.setPageTitle(mapToFieldPageTitle(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelWikiPage.FI_PAGEINDEX)) {
                                try {
                                    instance.setPageIndex(mapToFieldPageIndex(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelWikiPage.FI_PAGEVERSION)) {
                                    try {
                                        instance.setPageVersion(mapToFieldPageVersion(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelWikiPage.FI_PAGESUBMITBY)) {
                                        try {
                                            instance.setPageSubmitBy(mapToFieldPageSubmitBy(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelWikiPage.FI_PAGESUBMITBYGP)) {
                                            try {
                                                instance.setPageSubmitByGp(mapToFieldPageSubmitByGp(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelWikiPage.FI_PAGESUBMITBYINS)) {
                                                try {
                                                    instance.setPageSubmitByIns(mapToFieldPageSubmitByIns(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
                                                    try {
                                                        instance.setPageSubmitByFamily(mapToFieldPageSubmitByFamily(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelWikiPage.FI_PAGECREATEDON)) {
                                                        try {
                                                            instance.setPageCreatedOn(mapToFieldPageCreatedOn(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelWikiPage.FI_PAGEADDITION)) {
                                                            try {
                                                                instance.setPageAddition(mapToFieldPageAddition(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelWikiPage.FI_PAGESTATE)) {
                                                                try {
                                                                    instance.setPageState(mapToFieldPageState(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
                                                                    try {
                                                                        instance.setPageDisplayMethod(mapToFieldPageDisplayMethod(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelWikiPage.FI_PAGEASPECT)) {
                                                                        try {
                                                                            instance.setPageAspect(mapToFieldPageAspect(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelWikiPage.FI_PAGETYPE)) {
                                                                            try {
                                                                                instance.setPageType(mapToFieldPageType(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelWikiPage.FI_PAGERESOURCEURL)) {
                                                                                try {
                                                                                    instance.setPageResourceUrl(mapToFieldPageResourceUrl(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelWikiPage.FI_PAGEFILESIZE)) {
                                                                                    try {
                                                                                        instance.setPageFileSize(mapToFieldPageFileSize(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
                                                                                        try {
                                                                                            instance.setPageRelatedObject(mapToFieldPageRelatedObject(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
                                                                                            try {
                                                                                                instance.setPageSubmitByTopIns(mapToFieldPageSubmitByTopIns(value));
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

        public void setField(String field, ModelWikiPage instance, byte[] value) {
            if (field.equals(ModelWikiPage.FI_PAGEID)) {
                instance.setPageId(mapToFieldPageId(value));
            } else {
                if (field.equals(ModelWikiPage.FI_PAGEVISITNAME)) {
                    instance.setPageVisitName(mapToFieldPageVisitName(value));
                } else {
                    if (field.equals(ModelWikiPage.FI_PAGECONTENT)) {
                        instance.setPageContent(mapToFieldPageContent(value));
                    } else {
                        if (field.equals(ModelWikiPage.FI_PAGETITLE)) {
                            instance.setPageTitle(mapToFieldPageTitle(value));
                        } else {
                            if (field.equals(ModelWikiPage.FI_PAGEINDEX)) {
                                instance.setPageIndex(mapToFieldPageIndex(value));
                            } else {
                                if (field.equals(ModelWikiPage.FI_PAGEVERSION)) {
                                    instance.setPageVersion(mapToFieldPageVersion(value));
                                } else {
                                    if (field.equals(ModelWikiPage.FI_PAGESUBMITBY)) {
                                        instance.setPageSubmitBy(mapToFieldPageSubmitBy(value));
                                    } else {
                                        if (field.equals(ModelWikiPage.FI_PAGESUBMITBYGP)) {
                                            instance.setPageSubmitByGp(mapToFieldPageSubmitByGp(value));
                                        } else {
                                            if (field.equals(ModelWikiPage.FI_PAGESUBMITBYINS)) {
                                                instance.setPageSubmitByIns(mapToFieldPageSubmitByIns(value));
                                            } else {
                                                if (field.equals(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
                                                    instance.setPageSubmitByFamily(mapToFieldPageSubmitByFamily(value));
                                                } else {
                                                    if (field.equals(ModelWikiPage.FI_PAGECREATEDON)) {
                                                        instance.setPageCreatedOn(mapToFieldPageCreatedOn(value));
                                                    } else {
                                                        if (field.equals(ModelWikiPage.FI_PAGEADDITION)) {
                                                            instance.setPageAddition(mapToFieldPageAddition(value));
                                                        } else {
                                                            if (field.equals(ModelWikiPage.FI_PAGESTATE)) {
                                                                instance.setPageState(mapToFieldPageState(value));
                                                            } else {
                                                                if (field.equals(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
                                                                    instance.setPageDisplayMethod(mapToFieldPageDisplayMethod(value));
                                                                } else {
                                                                    if (field.equals(ModelWikiPage.FI_PAGEASPECT)) {
                                                                        instance.setPageAspect(mapToFieldPageAspect(value));
                                                                    } else {
                                                                        if (field.equals(ModelWikiPage.FI_PAGETYPE)) {
                                                                            instance.setPageType(mapToFieldPageType(value));
                                                                        } else {
                                                                            if (field.equals(ModelWikiPage.FI_PAGERESOURCEURL)) {
                                                                                instance.setPageResourceUrl(mapToFieldPageResourceUrl(value));
                                                                            } else {
                                                                                if (field.equals(ModelWikiPage.FI_PAGEFILESIZE)) {
                                                                                    instance.setPageFileSize(mapToFieldPageFileSize(value));
                                                                                } else {
                                                                                    if (field.equals(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
                                                                                        instance.setPageRelatedObject(mapToFieldPageRelatedObject(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
                                                                                            instance.setPageSubmitByTopIns(mapToFieldPageSubmitByTopIns(value));
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

    public static class ResultSetMapperModelWikiPage<T extends ModelWikiPage>
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
            return ((T) new ModelWikiPage());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldPageId(rs, columnNames, instance);
            mapFieldPageVisitName(rs, columnNames, instance);
            mapFieldPageContent(rs, columnNames, instance);
            mapFieldPageTitle(rs, columnNames, instance);
            mapFieldPageIndex(rs, columnNames, instance);
            mapFieldPageVersion(rs, columnNames, instance);
            mapFieldPageSubmitBy(rs, columnNames, instance);
            mapFieldPageSubmitByGp(rs, columnNames, instance);
            mapFieldPageSubmitByIns(rs, columnNames, instance);
            mapFieldPageSubmitByFamily(rs, columnNames, instance);
            mapFieldPageCreatedOn(rs, columnNames, instance);
            mapFieldPageAddition(rs, columnNames, instance);
            mapFieldPageState(rs, columnNames, instance);
            mapFieldPageDisplayMethod(rs, columnNames, instance);
            mapFieldPageAspect(rs, columnNames, instance);
            mapFieldPageType(rs, columnNames, instance);
            mapFieldPageResourceUrl(rs, columnNames, instance);
            mapFieldPageFileSize(rs, columnNames, instance);
            mapFieldPageRelatedObject(rs, columnNames, instance);
            mapFieldPageSubmitByTopIns(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldPageId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEID)) {
                instance.setPageId(rs.getInt(ModelWikiPage.FI_PAGEID));
            }
        }

        protected void mapFieldPageVisitName(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEVISITNAME)) {
                instance.setPageVisitName(rs.getString(ModelWikiPage.FI_PAGEVISITNAME));
            }
        }

        protected void mapFieldPageContent(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGECONTENT)) {
                instance.setPageContent(rs.getString(ModelWikiPage.FI_PAGECONTENT));
            }
        }

        protected void mapFieldPageTitle(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGETITLE)) {
                instance.setPageTitle(rs.getString(ModelWikiPage.FI_PAGETITLE));
            }
        }

        protected void mapFieldPageIndex(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEINDEX)) {
                instance.setPageIndex(rs.getInt(ModelWikiPage.FI_PAGEINDEX));
            }
        }

        protected void mapFieldPageVersion(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEVERSION)) {
                instance.setPageVersion(rs.getByte(ModelWikiPage.FI_PAGEVERSION));
            }
        }

        protected void mapFieldPageSubmitBy(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGESUBMITBY)) {
                instance.setPageSubmitBy(rs.getInt(ModelWikiPage.FI_PAGESUBMITBY));
            }
        }

        protected void mapFieldPageSubmitByGp(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGESUBMITBYGP)) {
                instance.setPageSubmitByGp(rs.getInt(ModelWikiPage.FI_PAGESUBMITBYGP));
            }
        }

        protected void mapFieldPageSubmitByIns(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGESUBMITBYINS)) {
                instance.setPageSubmitByIns(rs.getInt(ModelWikiPage.FI_PAGESUBMITBYINS));
            }
        }

        protected void mapFieldPageSubmitByFamily(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGESUBMITBYFAMILY)) {
                instance.setPageSubmitByFamily(rs.getInt(ModelWikiPage.FI_PAGESUBMITBYFAMILY));
            }
        }

        protected void mapFieldPageCreatedOn(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGECREATEDON)) {
                instance.setPageCreatedOn(rs.getTimestamp(ModelWikiPage.FI_PAGECREATEDON));
            }
        }

        protected void mapFieldPageAddition(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEADDITION)) {
                instance.setPageAddition(rs.getString(ModelWikiPage.FI_PAGEADDITION));
            }
        }

        protected void mapFieldPageState(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGESTATE)) {
                instance.setPageState(rs.getByte(ModelWikiPage.FI_PAGESTATE));
            }
        }

        protected void mapFieldPageDisplayMethod(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEDISPLAYMETHOD)) {
                instance.setPageDisplayMethod(rs.getString(ModelWikiPage.FI_PAGEDISPLAYMETHOD));
            }
        }

        protected void mapFieldPageAspect(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEASPECT)) {
                instance.setPageAspect(rs.getByte(ModelWikiPage.FI_PAGEASPECT));
            }
        }

        protected void mapFieldPageType(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGETYPE)) {
                instance.setPageType(EnumPageType.fromValue(rs.getByte(ModelWikiPage.FI_PAGETYPE)));
            }
        }

        protected void mapFieldPageResourceUrl(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGERESOURCEURL)) {
                instance.setPageResourceUrl(rs.getString(ModelWikiPage.FI_PAGERESOURCEURL));
            }
        }

        protected void mapFieldPageFileSize(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGEFILESIZE)) {
                instance.setPageFileSize(rs.getLong(ModelWikiPage.FI_PAGEFILESIZE));
            }
        }

        protected void mapFieldPageRelatedObject(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGERELATEDOBJECT)) {
                instance.setPageRelatedObject(rs.getInt(ModelWikiPage.FI_PAGERELATEDOBJECT));
            }
        }

        protected void mapFieldPageSubmitByTopIns(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiPage.FI_PAGESUBMITBYTOPINS)) {
                instance.setPageSubmitByTopIns(rs.getInt(ModelWikiPage.FI_PAGESUBMITBYTOPINS));
            }
        }
    }
}
