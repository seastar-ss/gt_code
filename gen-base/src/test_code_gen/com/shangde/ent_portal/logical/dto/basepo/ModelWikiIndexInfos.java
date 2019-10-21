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
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._ObjMapper;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :wiki_index_infos
 * 	索引扩展信息
 */
public class ModelWikiIndexInfos
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "cmsIndexInfoId";
    public final static String DTO_TABLE_NAME = "wiki_index_infos";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.wiki_index_infos.cmsIndexInfoId 字段
     * 
     */
    Integer cmsIndexInfoId;
    public final static String FI_CMSINDEXINFOID = "cmsIndexInfoId";
    /**
     * 对应数据库.wiki_index_infos.cmsIndexInfoState 字段
     * 逻辑删除位
     */
    Byte cmsIndexInfoState;
    public final static String FI_CMSINDEXINFOSTATE = "cmsIndexInfoState";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoCreateTime 字段
     * 
     */
    Date cmsInfoCreateTime;
    public final static String FI_CMSINFOCREATETIME = "cmsInfoCreateTime";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoKey 字段
     * 信息键
     */
    String cmsInfoKey;
    public final static String FI_CMSINFOKEY = "cmsInfoKey";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoValue 字段
     * 信息值
     */
    String cmsInfoValue;
    public final static String FI_CMSINFOVALUE = "cmsInfoValue";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoName 字段
     * 信息中文名
     */
    String cmsInfoName;
    public final static String FI_CMSINFONAME = "cmsInfoName";
    /**
     * 对应数据库.wiki_index_infos.cmdInfoAspect 字段
     * 信息分类，英文
     */
    String cmdInfoAspect;
    public final static String FI_CMDINFOASPECT = "cmdInfoAspect";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoDesc 字段
     * 信息描述
     */
    String cmsInfoDesc;
    public final static String FI_CMSINFODESC = "cmsInfoDesc";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoOfIndexId 字段
     * 信息所属index的id
     */
    Integer cmsInfoOfIndexId;
    public final static String FI_CMSINFOOFINDEXID = "cmsInfoOfIndexId";
    /**
     * 对应数据库.wiki_index_infos.cmsInfoOfIndexParent 字段
     * 
     */
    Integer cmsInfoOfIndexParent;
    public final static String FI_CMSINFOOFINDEXPARENT = "cmsInfoOfIndexParent";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, Integer.class).put(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, Byte.class).put(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, Date.class).put(ModelWikiIndexInfos.FI_CMSINFOKEY, String.class).put(ModelWikiIndexInfos.FI_CMSINFOVALUE, String.class).put(ModelWikiIndexInfos.FI_CMSINFONAME, String.class).put(ModelWikiIndexInfos.FI_CMDINFOASPECT, String.class).put(ModelWikiIndexInfos.FI_CMSINFODESC, String.class).put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, Integer.class).put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, Integer.class).getMap();
    public final static Integer FIELD_COUNT = 10;
    public final static ResultSetMapperModelWikiIndexInfos<ModelWikiIndexInfos> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelWikiIndexInfos<com.shangde.ent_portal.logical.dto.basepo.ModelWikiIndexInfos>();
    public final static ByteMapMapperModelWikiIndexInfos MAP_OBJ_MAPPER = new ByteMapMapperModelWikiIndexInfos();

    public ModelWikiIndexInfos() {
    }

    public Integer getCmsIndexInfoId() {
        return cmsIndexInfoId;
    }

    public ModelWikiIndexInfos setCmsIndexInfoId(Integer lCmsIndexInfoId) {
        cmsIndexInfoId = lCmsIndexInfoId;
        return this;
    }

    public Byte getCmsIndexInfoState() {
        return cmsIndexInfoState;
    }

    public ModelWikiIndexInfos setCmsIndexInfoState(Byte lCmsIndexInfoState) {
        cmsIndexInfoState = lCmsIndexInfoState;
        return this;
    }

    public Date getCmsInfoCreateTime() {
        return cmsInfoCreateTime;
    }

    public ModelWikiIndexInfos setCmsInfoCreateTime(Date lCmsInfoCreateTime) {
        cmsInfoCreateTime = lCmsInfoCreateTime;
        return this;
    }

    public String getCmsInfoKey() {
        return cmsInfoKey;
    }

    public ModelWikiIndexInfos setCmsInfoKey(String lCmsInfoKey) {
        cmsInfoKey = lCmsInfoKey;
        return this;
    }

    public String getCmsInfoValue() {
        return cmsInfoValue;
    }

    public ModelWikiIndexInfos setCmsInfoValue(String lCmsInfoValue) {
        cmsInfoValue = lCmsInfoValue;
        return this;
    }

    public String getCmsInfoName() {
        return cmsInfoName;
    }

    public ModelWikiIndexInfos setCmsInfoName(String lCmsInfoName) {
        cmsInfoName = lCmsInfoName;
        return this;
    }

    public String getCmdInfoAspect() {
        return cmdInfoAspect;
    }

    public ModelWikiIndexInfos setCmdInfoAspect(String lCmdInfoAspect) {
        cmdInfoAspect = lCmdInfoAspect;
        return this;
    }

    public String getCmsInfoDesc() {
        return cmsInfoDesc;
    }

    public ModelWikiIndexInfos setCmsInfoDesc(String lCmsInfoDesc) {
        cmsInfoDesc = lCmsInfoDesc;
        return this;
    }

    public Integer getCmsInfoOfIndexId() {
        return cmsInfoOfIndexId;
    }

    public ModelWikiIndexInfos setCmsInfoOfIndexId(Integer lCmsInfoOfIndexId) {
        cmsInfoOfIndexId = lCmsInfoOfIndexId;
        return this;
    }

    public Integer getCmsInfoOfIndexParent() {
        return cmsInfoOfIndexParent;
    }

    public ModelWikiIndexInfos setCmsInfoOfIndexParent(Integer lCmsInfoOfIndexParent) {
        cmsInfoOfIndexParent = lCmsInfoOfIndexParent;
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
        if (getCmsIndexInfoId()!= null) {
            return false;
        }
        if (getCmsIndexInfoState()!= null) {
            return false;
        }
        if (getCmsInfoCreateTime()!= null) {
            return false;
        }
        if (getCmsInfoKey()!= null) {
            return false;
        }
        if (getCmsInfoValue()!= null) {
            return false;
        }
        if (getCmsInfoName()!= null) {
            return false;
        }
        if (getCmdInfoAspect()!= null) {
            return false;
        }
        if (getCmsInfoDesc()!= null) {
            return false;
        }
        if (getCmsInfoOfIndexId()!= null) {
            return false;
        }
        if (getCmsInfoOfIndexParent()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiIndexInfos.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiIndexInfos.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("cmsIndexInfoId").append(":").append(cmsIndexInfoId).append("}\n");
        ret.append("{").append("cmsIndexInfoState").append(":").append(cmsIndexInfoState).append("}\n");
        ret.append("{").append("cmsInfoCreateTime").append(":").append(cmsInfoCreateTime).append("}\n");
        ret.append("{").append("cmsInfoKey").append(":").append(cmsInfoKey).append("}\n");
        ret.append("{").append("cmsInfoValue").append(":").append(cmsInfoValue).append("}\n");
        ret.append("{").append("cmsInfoName").append(":").append(cmsInfoName).append("}\n");
        ret.append("{").append("cmdInfoAspect").append(":").append(cmdInfoAspect).append("}\n");
        ret.append("{").append("cmsInfoDesc").append(":").append(cmsInfoDesc).append("}\n");
        ret.append("{").append("cmsInfoOfIndexId").append(":").append(cmsInfoOfIndexId).append("}\n");
        ret.append("{").append("cmsInfoOfIndexParent").append(":").append(cmsInfoOfIndexParent).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelWikiIndexInfos
        implements RedisMapMapper<ModelWikiIndexInfos>
    {

        @Override
        public ModelWikiIndexInfos fromMap(Map<byte[], byte[]> map) {
            ModelWikiIndexInfos instance = new ModelWikiIndexInfos();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
                    instance.setCmsIndexInfoId(mapToFieldCmsIndexInfoId(entry.getValue()));
                } else {
                    if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
                        instance.setCmsIndexInfoState(mapToFieldCmsIndexInfoState(entry.getValue()));
                    } else {
                        if (field.equals(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
                            instance.setCmsInfoCreateTime(mapToFieldCmsInfoCreateTime(entry.getValue()));
                        } else {
                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
                                instance.setCmsInfoKey(mapToFieldCmsInfoKey(entry.getValue()));
                            } else {
                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
                                    instance.setCmsInfoValue(mapToFieldCmsInfoValue(entry.getValue()));
                                } else {
                                    if (field.equals(ModelWikiIndexInfos.FI_CMSINFONAME)) {
                                        instance.setCmsInfoName(mapToFieldCmsInfoName(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
                                            instance.setCmdInfoAspect(mapToFieldCmdInfoAspect(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFODESC)) {
                                                instance.setCmsInfoDesc(mapToFieldCmsInfoDesc(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
                                                    instance.setCmsInfoOfIndexId(mapToFieldCmsInfoOfIndexId(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
                                                        instance.setCmsInfoOfIndexParent(mapToFieldCmsInfoOfIndexParent(entry.getValue()));
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

        protected Integer mapToFieldCmsIndexInfoId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldCmsIndexInfoState(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Date mapToFieldCmsInfoCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldCmsInfoKey(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCmsInfoValue(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCmsInfoName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCmdInfoAspect(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCmsInfoDesc(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldCmsInfoOfIndexId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldCmsInfoOfIndexParent(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelWikiIndexInfos instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueCmsIndexInfoId = mapFromFieldCmsIndexInfoId(instance.getCmsIndexInfoId());
            ret.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID.getBytes(), valueCmsIndexInfoId);
            byte[] valueCmsIndexInfoState = mapFromFieldCmsIndexInfoState(instance.getCmsIndexInfoState());
            ret.put(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE.getBytes(), valueCmsIndexInfoState);
            byte[] valueCmsInfoCreateTime = mapFromFieldCmsInfoCreateTime(instance.getCmsInfoCreateTime());
            ret.put(ModelWikiIndexInfos.FI_CMSINFOCREATETIME.getBytes(), valueCmsInfoCreateTime);
            byte[] valueCmsInfoKey = mapFromFieldCmsInfoKey(instance.getCmsInfoKey());
            ret.put(ModelWikiIndexInfos.FI_CMSINFOKEY.getBytes(), valueCmsInfoKey);
            byte[] valueCmsInfoValue = mapFromFieldCmsInfoValue(instance.getCmsInfoValue());
            ret.put(ModelWikiIndexInfos.FI_CMSINFOVALUE.getBytes(), valueCmsInfoValue);
            byte[] valueCmsInfoName = mapFromFieldCmsInfoName(instance.getCmsInfoName());
            ret.put(ModelWikiIndexInfos.FI_CMSINFONAME.getBytes(), valueCmsInfoName);
            byte[] valueCmdInfoAspect = mapFromFieldCmdInfoAspect(instance.getCmdInfoAspect());
            ret.put(ModelWikiIndexInfos.FI_CMDINFOASPECT.getBytes(), valueCmdInfoAspect);
            byte[] valueCmsInfoDesc = mapFromFieldCmsInfoDesc(instance.getCmsInfoDesc());
            ret.put(ModelWikiIndexInfos.FI_CMSINFODESC.getBytes(), valueCmsInfoDesc);
            byte[] valueCmsInfoOfIndexId = mapFromFieldCmsInfoOfIndexId(instance.getCmsInfoOfIndexId());
            ret.put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID.getBytes(), valueCmsInfoOfIndexId);
            byte[] valueCmsInfoOfIndexParent = mapFromFieldCmsInfoOfIndexParent(instance.getCmsInfoOfIndexParent());
            ret.put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT.getBytes(), valueCmsInfoOfIndexParent);
            return ret;
        }

        protected byte[] mapFromFieldCmsIndexInfoId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsIndexInfoState(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoKey(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoValue(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmdInfoAspect(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoDesc(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoOfIndexId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCmsInfoOfIndexParent(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelWikiIndexInfos instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dCmsIndexInfoId = instance.getCmsIndexInfoId();
            if (dCmsIndexInfoId!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINDEXINFOID, dCmsIndexInfoId);
            }
            Byte dCmsIndexInfoState = instance.getCmsIndexInfoState();
            if (dCmsIndexInfoState!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, dCmsIndexInfoState);
            }
            Date dCmsInfoCreateTime = instance.getCmsInfoCreateTime();
            if (dCmsInfoCreateTime!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, dCmsInfoCreateTime);
            }
            String dCmsInfoKey = instance.getCmsInfoKey();
            if (dCmsInfoKey!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFOKEY, dCmsInfoKey);
            }
            String dCmsInfoValue = instance.getCmsInfoValue();
            if (dCmsInfoValue!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFOVALUE, dCmsInfoValue);
            }
            String dCmsInfoName = instance.getCmsInfoName();
            if (dCmsInfoName!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFONAME, dCmsInfoName);
            }
            String dCmdInfoAspect = instance.getCmdInfoAspect();
            if (dCmdInfoAspect!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMDINFOASPECT, dCmdInfoAspect);
            }
            String dCmsInfoDesc = instance.getCmsInfoDesc();
            if (dCmsInfoDesc!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFODESC, dCmsInfoDesc);
            }
            Integer dCmsInfoOfIndexId = instance.getCmsInfoOfIndexId();
            if (dCmsInfoOfIndexId!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, dCmsInfoOfIndexId);
            }
            Integer dCmsInfoOfIndexParent = instance.getCmsInfoOfIndexParent();
            if (dCmsInfoOfIndexParent!= null) {
                ret.put(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, dCmsInfoOfIndexParent);
            }
            return ret;
        }

        @Override
        public ModelWikiIndexInfos fromCommonMap(Map<String, Object> param) {
            ModelWikiIndexInfos ret = new ModelWikiIndexInfos();
            if (param == null) {
                return ret;
            }
            Object dCmsIndexInfoId = param.get(ModelWikiIndexInfos.FI_CMSINDEXINFOID);
            if (dCmsIndexInfoId!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINDEXINFOID, ret, dCmsIndexInfoId);
            }
            Object dCmsIndexInfoState = param.get(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE);
            if (dCmsIndexInfoState!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE, ret, dCmsIndexInfoState);
            }
            Object dCmsInfoCreateTime = param.get(ModelWikiIndexInfos.FI_CMSINFOCREATETIME);
            if (dCmsInfoCreateTime!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFOCREATETIME, ret, dCmsInfoCreateTime);
            }
            Object dCmsInfoKey = param.get(ModelWikiIndexInfos.FI_CMSINFOKEY);
            if (dCmsInfoKey!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFOKEY, ret, dCmsInfoKey);
            }
            Object dCmsInfoValue = param.get(ModelWikiIndexInfos.FI_CMSINFOVALUE);
            if (dCmsInfoValue!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFOVALUE, ret, dCmsInfoValue);
            }
            Object dCmsInfoName = param.get(ModelWikiIndexInfos.FI_CMSINFONAME);
            if (dCmsInfoName!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFONAME, ret, dCmsInfoName);
            }
            Object dCmdInfoAspect = param.get(ModelWikiIndexInfos.FI_CMDINFOASPECT);
            if (dCmdInfoAspect!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMDINFOASPECT, ret, dCmdInfoAspect);
            }
            Object dCmsInfoDesc = param.get(ModelWikiIndexInfos.FI_CMSINFODESC);
            if (dCmsInfoDesc!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFODESC, ret, dCmsInfoDesc);
            }
            Object dCmsInfoOfIndexId = param.get(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID);
            if (dCmsInfoOfIndexId!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID, ret, dCmsInfoOfIndexId);
            }
            Object dCmsInfoOfIndexParent = param.get(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT);
            if (dCmsInfoOfIndexParent!= null) {
                this.setField(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT, ret, dCmsInfoOfIndexParent);
            }
            return ret;
        }

        protected Integer mapToFieldCmsIndexInfoId(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldCmsIndexInfoState(Object obj) {
            return ((Byte) obj);
        }

        protected Date mapToFieldCmsInfoCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldCmsInfoKey(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCmsInfoValue(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCmsInfoName(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCmdInfoAspect(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCmsInfoDesc(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldCmsInfoOfIndexId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldCmsInfoOfIndexParent(Object obj) {
            return ((Integer) obj);
        }

        public<TT> TT getField(String field, ModelWikiIndexInfos instance) {
            try {
                if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
                    return ((TT) instance.getCmsIndexInfoId());
                } else {
                    if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
                        return ((TT) instance.getCmsIndexInfoState());
                    } else {
                        if (field.equals(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
                            return ((TT) instance.getCmsInfoCreateTime());
                        } else {
                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
                                return ((TT) instance.getCmsInfoKey());
                            } else {
                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
                                    return ((TT) instance.getCmsInfoValue());
                                } else {
                                    if (field.equals(ModelWikiIndexInfos.FI_CMSINFONAME)) {
                                        return ((TT) instance.getCmsInfoName());
                                    } else {
                                        if (field.equals(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
                                            return ((TT) instance.getCmdInfoAspect());
                                        } else {
                                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFODESC)) {
                                                return ((TT) instance.getCmsInfoDesc());
                                            } else {
                                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
                                                    return ((TT) instance.getCmsInfoOfIndexId());
                                                } else {
                                                    if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
                                                        return ((TT) instance.getCmsInfoOfIndexParent());
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

        public<TT> void setField(String field, ModelWikiIndexInfos instance, TT value) {
            if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
                try {
                    instance.setCmsIndexInfoId(mapToFieldCmsIndexInfoId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
                    try {
                        instance.setCmsIndexInfoState(mapToFieldCmsIndexInfoState(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
                        try {
                            instance.setCmsInfoCreateTime(mapToFieldCmsInfoCreateTime(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
                            try {
                                instance.setCmsInfoKey(mapToFieldCmsInfoKey(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
                                try {
                                    instance.setCmsInfoValue(mapToFieldCmsInfoValue(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFONAME)) {
                                    try {
                                        instance.setCmsInfoName(mapToFieldCmsInfoName(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
                                        try {
                                            instance.setCmdInfoAspect(mapToFieldCmdInfoAspect(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelWikiIndexInfos.FI_CMSINFODESC)) {
                                            try {
                                                instance.setCmsInfoDesc(mapToFieldCmsInfoDesc(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
                                                try {
                                                    instance.setCmsInfoOfIndexId(mapToFieldCmsInfoOfIndexId(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
                                                    try {
                                                        instance.setCmsInfoOfIndexParent(mapToFieldCmsInfoOfIndexParent(value));
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

        public void setField(String field, ModelWikiIndexInfos instance, byte[] value) {
            if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
                instance.setCmsIndexInfoId(mapToFieldCmsIndexInfoId(value));
            } else {
                if (field.equals(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
                    instance.setCmsIndexInfoState(mapToFieldCmsIndexInfoState(value));
                } else {
                    if (field.equals(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
                        instance.setCmsInfoCreateTime(mapToFieldCmsInfoCreateTime(value));
                    } else {
                        if (field.equals(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
                            instance.setCmsInfoKey(mapToFieldCmsInfoKey(value));
                        } else {
                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
                                instance.setCmsInfoValue(mapToFieldCmsInfoValue(value));
                            } else {
                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFONAME)) {
                                    instance.setCmsInfoName(mapToFieldCmsInfoName(value));
                                } else {
                                    if (field.equals(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
                                        instance.setCmdInfoAspect(mapToFieldCmdInfoAspect(value));
                                    } else {
                                        if (field.equals(ModelWikiIndexInfos.FI_CMSINFODESC)) {
                                            instance.setCmsInfoDesc(mapToFieldCmsInfoDesc(value));
                                        } else {
                                            if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
                                                instance.setCmsInfoOfIndexId(mapToFieldCmsInfoOfIndexId(value));
                                            } else {
                                                if (field.equals(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
                                                    instance.setCmsInfoOfIndexParent(mapToFieldCmsInfoOfIndexParent(value));
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

    public static class ResultSetMapperModelWikiIndexInfos<T extends ModelWikiIndexInfos>
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
            return ((T) new ModelWikiIndexInfos());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldCmsIndexInfoId(rs, columnNames, instance);
            mapFieldCmsIndexInfoState(rs, columnNames, instance);
            mapFieldCmsInfoCreateTime(rs, columnNames, instance);
            mapFieldCmsInfoKey(rs, columnNames, instance);
            mapFieldCmsInfoValue(rs, columnNames, instance);
            mapFieldCmsInfoName(rs, columnNames, instance);
            mapFieldCmdInfoAspect(rs, columnNames, instance);
            mapFieldCmsInfoDesc(rs, columnNames, instance);
            mapFieldCmsInfoOfIndexId(rs, columnNames, instance);
            mapFieldCmsInfoOfIndexParent(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldCmsIndexInfoId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOID)) {
                instance.setCmsIndexInfoId(rs.getInt(ModelWikiIndexInfos.FI_CMSINDEXINFOID));
            }
        }

        protected void mapFieldCmsIndexInfoState(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE)) {
                instance.setCmsIndexInfoState(rs.getByte(ModelWikiIndexInfos.FI_CMSINDEXINFOSTATE));
            }
        }

        protected void mapFieldCmsInfoCreateTime(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFOCREATETIME)) {
                instance.setCmsInfoCreateTime(rs.getTimestamp(ModelWikiIndexInfos.FI_CMSINFOCREATETIME));
            }
        }

        protected void mapFieldCmsInfoKey(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFOKEY)) {
                instance.setCmsInfoKey(rs.getString(ModelWikiIndexInfos.FI_CMSINFOKEY));
            }
        }

        protected void mapFieldCmsInfoValue(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFOVALUE)) {
                instance.setCmsInfoValue(rs.getString(ModelWikiIndexInfos.FI_CMSINFOVALUE));
            }
        }

        protected void mapFieldCmsInfoName(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFONAME)) {
                instance.setCmsInfoName(rs.getString(ModelWikiIndexInfos.FI_CMSINFONAME));
            }
        }

        protected void mapFieldCmdInfoAspect(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMDINFOASPECT)) {
                instance.setCmdInfoAspect(rs.getString(ModelWikiIndexInfos.FI_CMDINFOASPECT));
            }
        }

        protected void mapFieldCmsInfoDesc(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFODESC)) {
                instance.setCmsInfoDesc(rs.getString(ModelWikiIndexInfos.FI_CMSINFODESC));
            }
        }

        protected void mapFieldCmsInfoOfIndexId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID)) {
                instance.setCmsInfoOfIndexId(rs.getInt(ModelWikiIndexInfos.FI_CMSINFOOFINDEXID));
            }
        }

        protected void mapFieldCmsInfoOfIndexParent(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT)) {
                instance.setCmsInfoOfIndexParent(rs.getInt(ModelWikiIndexInfos.FI_CMSINFOOFINDEXPARENT));
            }
        }
    }
}
