/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumItemType;
import com.shangde.ent_portal.logical.dto.enums.EnumItemValueType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;
import com.shawn.ss.lib.tools.db.impl.mapper.BaseDbMapper;


/**
 * base DTO,represent for table :wiki_structure_info_key_item
 * 	字段表
 */
public class ModelWikiStructureInfoKeyItem
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "itemId";
    public final static String DTO_TABLE_NAME = "wiki_structure_info_key_item";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.wiki_structure_info_key_item.itemId 字段
     * 主键
     */
    Integer itemId;
    public final static String FI_ITEMID = "itemId";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemName 字段
     * 字段名称（英文，查询用）
     */
    String itemName;
    public final static String FI_ITEMNAME = "itemName";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemType 字段
     * 
     */
    EnumItemType itemType;
    public final static String FI_ITEMTYPE = "itemType";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemValueType 字段
     * 
     */
    EnumItemValueType itemValueType;
    public final static String FI_ITEMVALUETYPE = "itemValueType";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemLabel 字段
     * 字段展示标签名（中文，展示用）
     */
    String itemLabel;
    public final static String FI_ITEMLABEL = "itemLabel";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemReadOnly 字段
     * 是否只读，0否，1是
     */
    Byte itemReadOnly;
    public final static String FI_ITEMREADONLY = "itemReadOnly";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemObtainMethod 字段
     * 元素获取方式（保留字段）
     */
    String itemObtainMethod;
    public final static String FI_ITEMOBTAINMETHOD = "itemObtainMethod";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemDeleteFlag 字段
     * 逻辑删除位
     */
    String itemDeleteFlag;
    public final static String FI_ITEMDELETEFLAG = "itemDeleteFlag";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemBelongCollection 字段
     * 所属主键集合
     */
    Integer itemBelongCollection;
    public final static String FI_ITEMBELONGCOLLECTION = "itemBelongCollection";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemDesp 字段
     * 字段描述
     */
    String itemDesp;
    public final static String FI_ITEMDESP = "itemDesp";
    /**
     * 对应数据库.wiki_structure_info_key_item.itemSequence 字段
     * 元素序号，关联`wiki_structure_info_primary_keys`表的keyxx字段，用于记录唯一值
     */
    Byte itemSequence;
    public final static String FI_ITEMSEQUENCE = "itemSequence";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelWikiStructureInfoKeyItem.FI_ITEMID, Integer.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, String.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, EnumItemType.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, EnumItemValueType.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, String.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, Byte.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, String.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, String.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, Integer.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, String.class).put(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, Byte.class).getMap();
    public final static Integer FIELD_COUNT = 11;
    public final static ResultSetMapperModelWikiStructureInfoKeyItem<ModelWikiStructureInfoKeyItem> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelWikiStructureInfoKeyItem<com.shangde.ent_portal.logical.dto.basepo.ModelWikiStructureInfoKeyItem>();
    public final static ByteMapMapperModelWikiStructureInfoKeyItem MAP_OBJ_MAPPER = new ByteMapMapperModelWikiStructureInfoKeyItem();

    public ModelWikiStructureInfoKeyItem() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public ModelWikiStructureInfoKeyItem setItemId(Integer lItemId) {
        itemId = lItemId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public ModelWikiStructureInfoKeyItem setItemName(String lItemName) {
        itemName = lItemName;
        return this;
    }

    public EnumItemType getItemType() {
        return itemType;
    }

    public ModelWikiStructureInfoKeyItem setItemType(EnumItemType lItemType) {
        itemType = lItemType;
        return this;
    }

    public EnumItemValueType getItemValueType() {
        return itemValueType;
    }

    public ModelWikiStructureInfoKeyItem setItemValueType(EnumItemValueType lItemValueType) {
        itemValueType = lItemValueType;
        return this;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public ModelWikiStructureInfoKeyItem setItemLabel(String lItemLabel) {
        itemLabel = lItemLabel;
        return this;
    }

    public Byte getItemReadOnly() {
        return itemReadOnly;
    }

    public ModelWikiStructureInfoKeyItem setItemReadOnly(Byte lItemReadOnly) {
        itemReadOnly = lItemReadOnly;
        return this;
    }

    public String getItemObtainMethod() {
        return itemObtainMethod;
    }

    public ModelWikiStructureInfoKeyItem setItemObtainMethod(String lItemObtainMethod) {
        itemObtainMethod = lItemObtainMethod;
        return this;
    }

    public String getItemDeleteFlag() {
        return itemDeleteFlag;
    }

    public ModelWikiStructureInfoKeyItem setItemDeleteFlag(String lItemDeleteFlag) {
        itemDeleteFlag = lItemDeleteFlag;
        return this;
    }

    public Integer getItemBelongCollection() {
        return itemBelongCollection;
    }

    public ModelWikiStructureInfoKeyItem setItemBelongCollection(Integer lItemBelongCollection) {
        itemBelongCollection = lItemBelongCollection;
        return this;
    }

    public String getItemDesp() {
        return itemDesp;
    }

    public ModelWikiStructureInfoKeyItem setItemDesp(String lItemDesp) {
        itemDesp = lItemDesp;
        return this;
    }

    public Byte getItemSequence() {
        return itemSequence;
    }

    public ModelWikiStructureInfoKeyItem setItemSequence(Byte lItemSequence) {
        itemSequence = lItemSequence;
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
        if (getItemId()!= null) {
            return false;
        }
        if (getItemName()!= null) {
            return false;
        }
        if (getItemType()!= null) {
            return false;
        }
        if (getItemValueType()!= null) {
            return false;
        }
        if (getItemLabel()!= null) {
            return false;
        }
        if (getItemReadOnly()!= null) {
            return false;
        }
        if (getItemObtainMethod()!= null) {
            return false;
        }
        if (getItemDeleteFlag()!= null) {
            return false;
        }
        if (getItemBelongCollection()!= null) {
            return false;
        }
        if (getItemDesp()!= null) {
            return false;
        }
        if (getItemSequence()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _APIObj> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiStructureInfoKeyItem.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelWikiStructureInfoKeyItem.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("itemId").append(":").append(itemId).append("}\n");
        ret.append("{").append("itemName").append(":").append(itemName).append("}\n");
        ret.append("{").append("itemType").append(":").append(itemType).append("}\n");
        ret.append("{").append("itemValueType").append(":").append(itemValueType).append("}\n");
        ret.append("{").append("itemLabel").append(":").append(itemLabel).append("}\n");
        ret.append("{").append("itemReadOnly").append(":").append(itemReadOnly).append("}\n");
        ret.append("{").append("itemObtainMethod").append(":").append(itemObtainMethod).append("}\n");
        ret.append("{").append("itemDeleteFlag").append(":").append(itemDeleteFlag).append("}\n");
        ret.append("{").append("itemBelongCollection").append(":").append(itemBelongCollection).append("}\n");
        ret.append("{").append("itemDesp").append(":").append(itemDesp).append("}\n");
        ret.append("{").append("itemSequence").append(":").append(itemSequence).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelWikiStructureInfoKeyItem
        implements RedisMapMapper<ModelWikiStructureInfoKeyItem>
    {

        @Override
        public ModelWikiStructureInfoKeyItem fromMap(Map<byte[], byte[]> map) {
            ModelWikiStructureInfoKeyItem instance = new ModelWikiStructureInfoKeyItem();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
                    instance.setItemId(mapToFieldItemId(entry.getValue()));
                } else {
                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
                        instance.setItemName(mapToFieldItemName(entry.getValue()));
                    } else {
                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
                            instance.setItemType(mapToFieldItemType(entry.getValue()));
                        } else {
                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
                                instance.setItemValueType(mapToFieldItemValueType(entry.getValue()));
                            } else {
                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
                                    instance.setItemLabel(mapToFieldItemLabel(entry.getValue()));
                                } else {
                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
                                        instance.setItemReadOnly(mapToFieldItemReadOnly(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
                                            instance.setItemObtainMethod(mapToFieldItemObtainMethod(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
                                                instance.setItemDeleteFlag(mapToFieldItemDeleteFlag(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
                                                    instance.setItemBelongCollection(mapToFieldItemBelongCollection(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
                                                        instance.setItemDesp(mapToFieldItemDesp(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
                                                            instance.setItemSequence(mapToFieldItemSequence(entry.getValue()));
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

        protected Integer mapToFieldItemId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldItemName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected EnumItemType mapToFieldItemType(byte[] bytes) {
            return EnumItemType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected EnumItemValueType mapToFieldItemValueType(byte[] bytes) {
            return EnumItemValueType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected String mapToFieldItemLabel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldItemReadOnly(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected String mapToFieldItemObtainMethod(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldItemDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldItemBelongCollection(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldItemDesp(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldItemSequence(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelWikiStructureInfoKeyItem instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueItemId = mapFromFieldItemId(instance.getItemId());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMID.getBytes(), valueItemId);
            byte[] valueItemName = mapFromFieldItemName(instance.getItemName());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMNAME.getBytes(), valueItemName);
            byte[] valueItemType = mapFromFieldItemType(instance.getItemType());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE.getBytes(), valueItemType);
            byte[] valueItemValueType = mapFromFieldItemValueType(instance.getItemValueType());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE.getBytes(), valueItemValueType);
            byte[] valueItemLabel = mapFromFieldItemLabel(instance.getItemLabel());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL.getBytes(), valueItemLabel);
            byte[] valueItemReadOnly = mapFromFieldItemReadOnly(instance.getItemReadOnly());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY.getBytes(), valueItemReadOnly);
            byte[] valueItemObtainMethod = mapFromFieldItemObtainMethod(instance.getItemObtainMethod());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD.getBytes(), valueItemObtainMethod);
            byte[] valueItemDeleteFlag = mapFromFieldItemDeleteFlag(instance.getItemDeleteFlag());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG.getBytes(), valueItemDeleteFlag);
            byte[] valueItemBelongCollection = mapFromFieldItemBelongCollection(instance.getItemBelongCollection());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION.getBytes(), valueItemBelongCollection);
            byte[] valueItemDesp = mapFromFieldItemDesp(instance.getItemDesp());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMDESP.getBytes(), valueItemDesp);
            byte[] valueItemSequence = mapFromFieldItemSequence(instance.getItemSequence());
            ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE.getBytes(), valueItemSequence);
            return ret;
        }

        protected byte[] mapFromFieldItemId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemType(EnumItemType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldItemValueType(EnumItemValueType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldItemLabel(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemReadOnly(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemObtainMethod(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemDeleteFlag(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemBelongCollection(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemDesp(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldItemSequence(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelWikiStructureInfoKeyItem instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dItemId = instance.getItemId();
            if (dItemId!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMID, dItemId);
            }
            String dItemName = instance.getItemName();
            if (dItemName!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, dItemName);
            }
            EnumItemType dItemType = instance.getItemType();
            if (dItemType!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, dItemType.val);
            }
            EnumItemValueType dItemValueType = instance.getItemValueType();
            if (dItemValueType!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, dItemValueType.val);
            }
            String dItemLabel = instance.getItemLabel();
            if (dItemLabel!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, dItemLabel);
            }
            Byte dItemReadOnly = instance.getItemReadOnly();
            if (dItemReadOnly!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, dItemReadOnly);
            }
            String dItemObtainMethod = instance.getItemObtainMethod();
            if (dItemObtainMethod!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, dItemObtainMethod);
            }
            String dItemDeleteFlag = instance.getItemDeleteFlag();
            if (dItemDeleteFlag!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, dItemDeleteFlag);
            }
            Integer dItemBelongCollection = instance.getItemBelongCollection();
            if (dItemBelongCollection!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, dItemBelongCollection);
            }
            String dItemDesp = instance.getItemDesp();
            if (dItemDesp!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, dItemDesp);
            }
            Byte dItemSequence = instance.getItemSequence();
            if (dItemSequence!= null) {
                ret.put(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, dItemSequence);
            }
            return ret;
        }

        @Override
        public ModelWikiStructureInfoKeyItem fromCommonMap(Map<String, Object> param) {
            ModelWikiStructureInfoKeyItem ret = new ModelWikiStructureInfoKeyItem();
            if (param == null) {
                return ret;
            }
            Object dItemId = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMID);
            if (dItemId!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMID, ret, dItemId);
            }
            Object dItemName = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMNAME);
            if (dItemName!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMNAME, ret, dItemName);
            }
            Object dItemType = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE);
            if (dItemType!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE, ret, dItemType);
            }
            Object dItemValueType = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE);
            if (dItemValueType!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE, ret, dItemValueType);
            }
            Object dItemLabel = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL);
            if (dItemLabel!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL, ret, dItemLabel);
            }
            Object dItemReadOnly = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY);
            if (dItemReadOnly!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY, ret, dItemReadOnly);
            }
            Object dItemObtainMethod = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD);
            if (dItemObtainMethod!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD, ret, dItemObtainMethod);
            }
            Object dItemDeleteFlag = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG);
            if (dItemDeleteFlag!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG, ret, dItemDeleteFlag);
            }
            Object dItemBelongCollection = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION);
            if (dItemBelongCollection!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION, ret, dItemBelongCollection);
            }
            Object dItemDesp = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMDESP);
            if (dItemDesp!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMDESP, ret, dItemDesp);
            }
            Object dItemSequence = param.get(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE);
            if (dItemSequence!= null) {
                this.setField(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE, ret, dItemSequence);
            }
            return ret;
        }

        protected Integer mapToFieldItemId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldItemName(Object obj) {
            return ((String) obj);
        }

        protected EnumItemType mapToFieldItemType(Object obj) {
            return EnumItemType.fromValue(((Byte) obj));
        }

        protected EnumItemValueType mapToFieldItemValueType(Object obj) {
            return EnumItemValueType.fromValue(((Byte) obj));
        }

        protected String mapToFieldItemLabel(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldItemReadOnly(Object obj) {
            return ((Byte) obj);
        }

        protected String mapToFieldItemObtainMethod(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldItemDeleteFlag(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldItemBelongCollection(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldItemDesp(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldItemSequence(Object obj) {
            return ((Byte) obj);
        }

        public<TT> TT getField(String field, ModelWikiStructureInfoKeyItem instance) {
            try {
                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
                    return ((TT) instance.getItemId());
                } else {
                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
                        return ((TT) instance.getItemName());
                    } else {
                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
                            return ((TT) instance.getItemType());
                        } else {
                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
                                return ((TT) instance.getItemValueType());
                            } else {
                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
                                    return ((TT) instance.getItemLabel());
                                } else {
                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
                                        return ((TT) instance.getItemReadOnly());
                                    } else {
                                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
                                            return ((TT) instance.getItemObtainMethod());
                                        } else {
                                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
                                                return ((TT) instance.getItemDeleteFlag());
                                            } else {
                                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
                                                    return ((TT) instance.getItemBelongCollection());
                                                } else {
                                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
                                                        return ((TT) instance.getItemDesp());
                                                    } else {
                                                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
                                                            return ((TT) instance.getItemSequence());
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

        public<TT> void setField(String field, ModelWikiStructureInfoKeyItem instance, TT value) {
            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
                try {
                    instance.setItemId(mapToFieldItemId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
                    try {
                        instance.setItemName(mapToFieldItemName(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
                        try {
                            instance.setItemType(mapToFieldItemType(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
                            try {
                                instance.setItemValueType(mapToFieldItemValueType(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
                                try {
                                    instance.setItemLabel(mapToFieldItemLabel(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
                                    try {
                                        instance.setItemReadOnly(mapToFieldItemReadOnly(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
                                        try {
                                            instance.setItemObtainMethod(mapToFieldItemObtainMethod(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
                                            try {
                                                instance.setItemDeleteFlag(mapToFieldItemDeleteFlag(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
                                                try {
                                                    instance.setItemBelongCollection(mapToFieldItemBelongCollection(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
                                                    try {
                                                        instance.setItemDesp(mapToFieldItemDesp(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
                                                        try {
                                                            instance.setItemSequence(mapToFieldItemSequence(value));
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

        public void setField(String field, ModelWikiStructureInfoKeyItem instance, byte[] value) {
            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
                instance.setItemId(mapToFieldItemId(value));
            } else {
                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
                    instance.setItemName(mapToFieldItemName(value));
                } else {
                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
                        instance.setItemType(mapToFieldItemType(value));
                    } else {
                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
                            instance.setItemValueType(mapToFieldItemValueType(value));
                        } else {
                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
                                instance.setItemLabel(mapToFieldItemLabel(value));
                            } else {
                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
                                    instance.setItemReadOnly(mapToFieldItemReadOnly(value));
                                } else {
                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
                                        instance.setItemObtainMethod(mapToFieldItemObtainMethod(value));
                                    } else {
                                        if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
                                            instance.setItemDeleteFlag(mapToFieldItemDeleteFlag(value));
                                        } else {
                                            if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
                                                instance.setItemBelongCollection(mapToFieldItemBelongCollection(value));
                                            } else {
                                                if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
                                                    instance.setItemDesp(mapToFieldItemDesp(value));
                                                } else {
                                                    if (field.equals(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
                                                        instance.setItemSequence(mapToFieldItemSequence(value));
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

    public static class ResultSetMapperModelWikiStructureInfoKeyItem<T extends ModelWikiStructureInfoKeyItem>
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
            return ((T) new ModelWikiStructureInfoKeyItem());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldItemId(rs, columnNames, instance);
            mapFieldItemName(rs, columnNames, instance);
            mapFieldItemType(rs, columnNames, instance);
            mapFieldItemValueType(rs, columnNames, instance);
            mapFieldItemLabel(rs, columnNames, instance);
            mapFieldItemReadOnly(rs, columnNames, instance);
            mapFieldItemObtainMethod(rs, columnNames, instance);
            mapFieldItemDeleteFlag(rs, columnNames, instance);
            mapFieldItemBelongCollection(rs, columnNames, instance);
            mapFieldItemDesp(rs, columnNames, instance);
            mapFieldItemSequence(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldItemId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMID)) {
                instance.setItemId(rs.getInt(ModelWikiStructureInfoKeyItem.FI_ITEMID));
            }
        }

        protected void mapFieldItemName(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMNAME)) {
                instance.setItemName(rs.getString(ModelWikiStructureInfoKeyItem.FI_ITEMNAME));
            }
        }

        protected void mapFieldItemType(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)) {
                instance.setItemType(EnumItemType.fromValue(rs.getByte(ModelWikiStructureInfoKeyItem.FI_ITEMTYPE)));
            }
        }

        protected void mapFieldItemValueType(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)) {
                instance.setItemValueType(EnumItemValueType.fromValue(rs.getByte(ModelWikiStructureInfoKeyItem.FI_ITEMVALUETYPE)));
            }
        }

        protected void mapFieldItemLabel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL)) {
                instance.setItemLabel(rs.getString(ModelWikiStructureInfoKeyItem.FI_ITEMLABEL));
            }
        }

        protected void mapFieldItemReadOnly(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY)) {
                instance.setItemReadOnly(rs.getByte(ModelWikiStructureInfoKeyItem.FI_ITEMREADONLY));
            }
        }

        protected void mapFieldItemObtainMethod(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD)) {
                instance.setItemObtainMethod(rs.getString(ModelWikiStructureInfoKeyItem.FI_ITEMOBTAINMETHOD));
            }
        }

        protected void mapFieldItemDeleteFlag(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG)) {
                instance.setItemDeleteFlag(rs.getString(ModelWikiStructureInfoKeyItem.FI_ITEMDELETEFLAG));
            }
        }

        protected void mapFieldItemBelongCollection(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION)) {
                instance.setItemBelongCollection(rs.getInt(ModelWikiStructureInfoKeyItem.FI_ITEMBELONGCOLLECTION));
            }
        }

        protected void mapFieldItemDesp(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMDESP)) {
                instance.setItemDesp(rs.getString(ModelWikiStructureInfoKeyItem.FI_ITEMDESP));
            }
        }

        protected void mapFieldItemSequence(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE)) {
                instance.setItemSequence(rs.getByte(ModelWikiStructureInfoKeyItem.FI_ITEMSEQUENCE));
            }
        }
    }
}
