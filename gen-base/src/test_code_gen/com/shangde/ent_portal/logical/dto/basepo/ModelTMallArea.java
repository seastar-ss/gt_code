/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.enums.EnumAreaType;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;


/**
 * base DTO,represent for  :t_mall_area
 */
public class ModelTMallArea
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    EnumAreaType areaType;
    public final static String FI_AREA_TYPE = "area_type";
    /**
     * 区域名称
     */
    String areaName;
    public final static String FI_AREA_NAME = "area_name";
    /**
     * 区域逻辑长度按照单行可使用货位数定义仅仓位类型区域含此参数
     */
    Integer areaArixMaxX;
    public final static String FI_AREA_ARIX_MAX_X = "area_arix_max_x";
    /**
     * 区域逻辑宽度按照可使用货位行数定义仅仓位类型区域含此参数
     */
    Integer areaArixMaxY;
    public final static String FI_AREA_ARIX_MAX_Y = "area_arix_max_y";
    /**
     * 区域逻辑高度按照可使用货位层数定义仅仓位类型区域含此参数
     */
    Integer areaArixMaxZ;
    public final static String FI_AREA_ARIX_MAX_Z = "area_arix_max_z";
    /**
     * 区域是否可达
     */
    Byte areaReachable;
    public final static String FI_AREA_REACHABLE = "area_reachable";
    /**
     * 区域货位容量
     */
    Integer areaCapacity;
    public final static String FI_AREA_CAPACITY = "area_capacity";
    /**
     * 仓储区域x坐标基数
     */
    Integer areaArixXBase;
    public final static String FI_AREA_ARIX_X_BASE = "area_arix_x_base";
    /**
     * 仓储区域y坐标基数
     */
    Integer areaArixYBase;
    public final static String FI_AREA_ARIX_Y_BASE = "area_arix_y_base";
    /**
     * 仓储区域z坐标基数
     */
    Integer areaArixZBase;
    public final static String FI_AREA_ARIX_Z_BASE = "area_arix_z_base";
    /**
     * 区域索引，备用
     */
    Integer areaIndex;
    public final static String FI_AREA_INDEX = "area_index";
    /**
     * 区域地图对应t_map_logical_path.path_belong_to
     */
    Integer areaPath;
    public final static String FI_AREA_PATH = "area_path";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTMallArea.FI_ID, Integer.class).put(ModelTMallArea.FI_AREA_TYPE, EnumAreaType.class).put(ModelTMallArea.FI_AREA_NAME, String.class).put(ModelTMallArea.FI_AREA_ARIX_MAX_X, Integer.class).put(ModelTMallArea.FI_AREA_ARIX_MAX_Y, Integer.class).put(ModelTMallArea.FI_AREA_ARIX_MAX_Z, Integer.class).put(ModelTMallArea.FI_AREA_REACHABLE, Byte.class).put(ModelTMallArea.FI_AREA_CAPACITY, Integer.class).put(ModelTMallArea.FI_AREA_ARIX_X_BASE, Integer.class).put(ModelTMallArea.FI_AREA_ARIX_Y_BASE, Integer.class).put(ModelTMallArea.FI_AREA_ARIX_Z_BASE, Integer.class).put(ModelTMallArea.FI_AREA_INDEX, Integer.class).put(ModelTMallArea.FI_AREA_PATH, Integer.class).getMap();
    public final static Integer FIELD_COUNT = 13;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_mall_area";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelTMallArea() {
    }

    public Integer getId() {
        return id;
    }

    public ModelTMallArea setId(Integer lId) {
        id = lId;
        return this;
    }

    public EnumAreaType getAreaType() {
        return areaType;
    }

    public ModelTMallArea setAreaType(EnumAreaType lAreaType) {
        areaType = lAreaType;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public ModelTMallArea setAreaName(String lAreaName) {
        areaName = lAreaName;
        return this;
    }

    public Integer getAreaArixMaxX() {
        return areaArixMaxX;
    }

    public ModelTMallArea setAreaArixMaxX(Integer lAreaArixMaxX) {
        areaArixMaxX = lAreaArixMaxX;
        return this;
    }

    public Integer getAreaArixMaxY() {
        return areaArixMaxY;
    }

    public ModelTMallArea setAreaArixMaxY(Integer lAreaArixMaxY) {
        areaArixMaxY = lAreaArixMaxY;
        return this;
    }

    public Integer getAreaArixMaxZ() {
        return areaArixMaxZ;
    }

    public ModelTMallArea setAreaArixMaxZ(Integer lAreaArixMaxZ) {
        areaArixMaxZ = lAreaArixMaxZ;
        return this;
    }

    public Byte getAreaReachable() {
        return areaReachable;
    }

    public ModelTMallArea setAreaReachable(Byte lAreaReachable) {
        areaReachable = lAreaReachable;
        return this;
    }

    public Integer getAreaCapacity() {
        return areaCapacity;
    }

    public ModelTMallArea setAreaCapacity(Integer lAreaCapacity) {
        areaCapacity = lAreaCapacity;
        return this;
    }

    public Integer getAreaArixXBase() {
        return areaArixXBase;
    }

    public ModelTMallArea setAreaArixXBase(Integer lAreaArixXBase) {
        areaArixXBase = lAreaArixXBase;
        return this;
    }

    public Integer getAreaArixYBase() {
        return areaArixYBase;
    }

    public ModelTMallArea setAreaArixYBase(Integer lAreaArixYBase) {
        areaArixYBase = lAreaArixYBase;
        return this;
    }

    public Integer getAreaArixZBase() {
        return areaArixZBase;
    }

    public ModelTMallArea setAreaArixZBase(Integer lAreaArixZBase) {
        areaArixZBase = lAreaArixZBase;
        return this;
    }

    public Integer getAreaIndex() {
        return areaIndex;
    }

    public ModelTMallArea setAreaIndex(Integer lAreaIndex) {
        areaIndex = lAreaIndex;
        return this;
    }

    public Integer getAreaPath() {
        return areaPath;
    }

    public ModelTMallArea setAreaPath(Integer lAreaPath) {
        areaPath = lAreaPath;
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
        if (getId()!= null) {
            return false;
        }
        if (getAreaType()!= null) {
            return false;
        }
        if (getAreaName()!= null) {
            return false;
        }
        if (getAreaArixMaxX()!= null) {
            return false;
        }
        if (getAreaArixMaxY()!= null) {
            return false;
        }
        if (getAreaArixMaxZ()!= null) {
            return false;
        }
        if (getAreaReachable()!= null) {
            return false;
        }
        if (getAreaCapacity()!= null) {
            return false;
        }
        if (getAreaArixXBase()!= null) {
            return false;
        }
        if (getAreaArixYBase()!= null) {
            return false;
        }
        if (getAreaArixZBase()!= null) {
            return false;
        }
        if (getAreaIndex()!= null) {
            return false;
        }
        if (getAreaPath()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _APIObj> FT getFeature(Class<FT> clazz) {
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("areaType").append(":").append(areaType).append("}\n");
        ret.append("{").append("areaName").append(":").append(areaName).append("}\n");
        ret.append("{").append("areaArixMaxX").append(":").append(areaArixMaxX).append("}\n");
        ret.append("{").append("areaArixMaxY").append(":").append(areaArixMaxY).append("}\n");
        ret.append("{").append("areaArixMaxZ").append(":").append(areaArixMaxZ).append("}\n");
        ret.append("{").append("areaReachable").append(":").append(areaReachable).append("}\n");
        ret.append("{").append("areaCapacity").append(":").append(areaCapacity).append("}\n");
        ret.append("{").append("areaArixXBase").append(":").append(areaArixXBase).append("}\n");
        ret.append("{").append("areaArixYBase").append(":").append(areaArixYBase).append("}\n");
        ret.append("{").append("areaArixZBase").append(":").append(areaArixZBase).append("}\n");
        ret.append("{").append("areaIndex").append(":").append(areaIndex).append("}\n");
        ret.append("{").append("areaPath").append(":").append(areaPath).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelTMallArea
        implements RedisMapMapper<ModelTMallArea>
    {

        @Override
        public ModelTMallArea fromMap(Map<byte[], byte[]> map) {
            ModelTMallArea instance = new ModelTMallArea();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTMallArea.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTMallArea.FI_AREA_TYPE)) {
                        instance.setAreaType(mapToFieldAreaType(entry.getValue()));
                    } else {
                        if (field.equals(ModelTMallArea.FI_AREA_NAME)) {
                            instance.setAreaName(mapToFieldAreaName(entry.getValue()));
                        } else {
                            if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
                                instance.setAreaArixMaxX(mapToFieldAreaArixMaxX(entry.getValue()));
                            } else {
                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
                                    instance.setAreaArixMaxY(mapToFieldAreaArixMaxY(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
                                        instance.setAreaArixMaxZ(mapToFieldAreaArixMaxZ(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTMallArea.FI_AREA_REACHABLE)) {
                                            instance.setAreaReachable(mapToFieldAreaReachable(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTMallArea.FI_AREA_CAPACITY)) {
                                                instance.setAreaCapacity(mapToFieldAreaCapacity(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
                                                    instance.setAreaArixXBase(mapToFieldAreaArixXBase(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
                                                        instance.setAreaArixYBase(mapToFieldAreaArixYBase(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
                                                            instance.setAreaArixZBase(mapToFieldAreaArixZBase(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTMallArea.FI_AREA_INDEX)) {
                                                                instance.setAreaIndex(mapToFieldAreaIndex(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelTMallArea.FI_AREA_PATH)) {
                                                                    instance.setAreaPath(mapToFieldAreaPath(entry.getValue()));
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

        protected Integer mapToFieldId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected EnumAreaType mapToFieldAreaType(byte[] bytes) {
            return EnumAreaType.fromValue(TypeConstantHelper.toObject(bytes, Byte.class));
        }

        protected String mapToFieldAreaName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldAreaArixMaxX(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaArixMaxY(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaArixMaxZ(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Byte mapToFieldAreaReachable(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldAreaCapacity(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaArixXBase(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaArixYBase(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaArixZBase(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaIndex(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldAreaPath(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTMallArea instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTMallArea.FI_ID.getBytes(), valueId);
            byte[] valueArea_type = mapFromFieldAreaType(instance.getAreaType());
            ret.put(ModelTMallArea.FI_AREA_TYPE.getBytes(), valueArea_type);
            byte[] valueArea_name = mapFromFieldAreaName(instance.getAreaName());
            ret.put(ModelTMallArea.FI_AREA_NAME.getBytes(), valueArea_name);
            byte[] valueArea_arix_max_x = mapFromFieldAreaArixMaxX(instance.getAreaArixMaxX());
            ret.put(ModelTMallArea.FI_AREA_ARIX_MAX_X.getBytes(), valueArea_arix_max_x);
            byte[] valueArea_arix_max_y = mapFromFieldAreaArixMaxY(instance.getAreaArixMaxY());
            ret.put(ModelTMallArea.FI_AREA_ARIX_MAX_Y.getBytes(), valueArea_arix_max_y);
            byte[] valueArea_arix_max_z = mapFromFieldAreaArixMaxZ(instance.getAreaArixMaxZ());
            ret.put(ModelTMallArea.FI_AREA_ARIX_MAX_Z.getBytes(), valueArea_arix_max_z);
            byte[] valueArea_reachable = mapFromFieldAreaReachable(instance.getAreaReachable());
            ret.put(ModelTMallArea.FI_AREA_REACHABLE.getBytes(), valueArea_reachable);
            byte[] valueArea_capacity = mapFromFieldAreaCapacity(instance.getAreaCapacity());
            ret.put(ModelTMallArea.FI_AREA_CAPACITY.getBytes(), valueArea_capacity);
            byte[] valueArea_arix_x_base = mapFromFieldAreaArixXBase(instance.getAreaArixXBase());
            ret.put(ModelTMallArea.FI_AREA_ARIX_X_BASE.getBytes(), valueArea_arix_x_base);
            byte[] valueArea_arix_y_base = mapFromFieldAreaArixYBase(instance.getAreaArixYBase());
            ret.put(ModelTMallArea.FI_AREA_ARIX_Y_BASE.getBytes(), valueArea_arix_y_base);
            byte[] valueArea_arix_z_base = mapFromFieldAreaArixZBase(instance.getAreaArixZBase());
            ret.put(ModelTMallArea.FI_AREA_ARIX_Z_BASE.getBytes(), valueArea_arix_z_base);
            byte[] valueArea_index = mapFromFieldAreaIndex(instance.getAreaIndex());
            ret.put(ModelTMallArea.FI_AREA_INDEX.getBytes(), valueArea_index);
            byte[] valueArea_path = mapFromFieldAreaPath(instance.getAreaPath());
            ret.put(ModelTMallArea.FI_AREA_PATH.getBytes(), valueArea_path);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaType(EnumAreaType field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field.val);
            return ret;
        }

        protected byte[] mapFromFieldAreaName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaArixMaxX(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaArixMaxY(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaArixMaxZ(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaReachable(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaCapacity(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaArixXBase(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaArixYBase(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaArixZBase(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaIndex(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAreaPath(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTMallArea instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTMallArea.FI_ID, dId);
            }
            EnumAreaType dArea_type = instance.getAreaType();
            if (dArea_type!= null) {
                ret.put(ModelTMallArea.FI_AREA_TYPE, dArea_type.val);
            }
            String dArea_name = instance.getAreaName();
            if (dArea_name!= null) {
                ret.put(ModelTMallArea.FI_AREA_NAME, dArea_name);
            }
            Integer dArea_arix_max_x = instance.getAreaArixMaxX();
            if (dArea_arix_max_x!= null) {
                ret.put(ModelTMallArea.FI_AREA_ARIX_MAX_X, dArea_arix_max_x);
            }
            Integer dArea_arix_max_y = instance.getAreaArixMaxY();
            if (dArea_arix_max_y!= null) {
                ret.put(ModelTMallArea.FI_AREA_ARIX_MAX_Y, dArea_arix_max_y);
            }
            Integer dArea_arix_max_z = instance.getAreaArixMaxZ();
            if (dArea_arix_max_z!= null) {
                ret.put(ModelTMallArea.FI_AREA_ARIX_MAX_Z, dArea_arix_max_z);
            }
            Byte dArea_reachable = instance.getAreaReachable();
            if (dArea_reachable!= null) {
                ret.put(ModelTMallArea.FI_AREA_REACHABLE, dArea_reachable);
            }
            Integer dArea_capacity = instance.getAreaCapacity();
            if (dArea_capacity!= null) {
                ret.put(ModelTMallArea.FI_AREA_CAPACITY, dArea_capacity);
            }
            Integer dArea_arix_x_base = instance.getAreaArixXBase();
            if (dArea_arix_x_base!= null) {
                ret.put(ModelTMallArea.FI_AREA_ARIX_X_BASE, dArea_arix_x_base);
            }
            Integer dArea_arix_y_base = instance.getAreaArixYBase();
            if (dArea_arix_y_base!= null) {
                ret.put(ModelTMallArea.FI_AREA_ARIX_Y_BASE, dArea_arix_y_base);
            }
            Integer dArea_arix_z_base = instance.getAreaArixZBase();
            if (dArea_arix_z_base!= null) {
                ret.put(ModelTMallArea.FI_AREA_ARIX_Z_BASE, dArea_arix_z_base);
            }
            Integer dArea_index = instance.getAreaIndex();
            if (dArea_index!= null) {
                ret.put(ModelTMallArea.FI_AREA_INDEX, dArea_index);
            }
            Integer dArea_path = instance.getAreaPath();
            if (dArea_path!= null) {
                ret.put(ModelTMallArea.FI_AREA_PATH, dArea_path);
            }
            return ret;
        }

        @Override
        public ModelTMallArea fromCommonMap(Map<String, Object> param) {
            ModelTMallArea ret = new ModelTMallArea();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelTMallArea.FI_ID);
            if (dId!= null) {
                this.setField(ModelTMallArea.FI_ID, ret, dId);
            }
            Object dArea_type = param.get(ModelTMallArea.FI_AREA_TYPE);
            if (dArea_type!= null) {
                this.setField(ModelTMallArea.FI_AREA_TYPE, ret, dArea_type);
            }
            Object dArea_name = param.get(ModelTMallArea.FI_AREA_NAME);
            if (dArea_name!= null) {
                this.setField(ModelTMallArea.FI_AREA_NAME, ret, dArea_name);
            }
            Object dArea_arix_max_x = param.get(ModelTMallArea.FI_AREA_ARIX_MAX_X);
            if (dArea_arix_max_x!= null) {
                this.setField(ModelTMallArea.FI_AREA_ARIX_MAX_X, ret, dArea_arix_max_x);
            }
            Object dArea_arix_max_y = param.get(ModelTMallArea.FI_AREA_ARIX_MAX_Y);
            if (dArea_arix_max_y!= null) {
                this.setField(ModelTMallArea.FI_AREA_ARIX_MAX_Y, ret, dArea_arix_max_y);
            }
            Object dArea_arix_max_z = param.get(ModelTMallArea.FI_AREA_ARIX_MAX_Z);
            if (dArea_arix_max_z!= null) {
                this.setField(ModelTMallArea.FI_AREA_ARIX_MAX_Z, ret, dArea_arix_max_z);
            }
            Object dArea_reachable = param.get(ModelTMallArea.FI_AREA_REACHABLE);
            if (dArea_reachable!= null) {
                this.setField(ModelTMallArea.FI_AREA_REACHABLE, ret, dArea_reachable);
            }
            Object dArea_capacity = param.get(ModelTMallArea.FI_AREA_CAPACITY);
            if (dArea_capacity!= null) {
                this.setField(ModelTMallArea.FI_AREA_CAPACITY, ret, dArea_capacity);
            }
            Object dArea_arix_x_base = param.get(ModelTMallArea.FI_AREA_ARIX_X_BASE);
            if (dArea_arix_x_base!= null) {
                this.setField(ModelTMallArea.FI_AREA_ARIX_X_BASE, ret, dArea_arix_x_base);
            }
            Object dArea_arix_y_base = param.get(ModelTMallArea.FI_AREA_ARIX_Y_BASE);
            if (dArea_arix_y_base!= null) {
                this.setField(ModelTMallArea.FI_AREA_ARIX_Y_BASE, ret, dArea_arix_y_base);
            }
            Object dArea_arix_z_base = param.get(ModelTMallArea.FI_AREA_ARIX_Z_BASE);
            if (dArea_arix_z_base!= null) {
                this.setField(ModelTMallArea.FI_AREA_ARIX_Z_BASE, ret, dArea_arix_z_base);
            }
            Object dArea_index = param.get(ModelTMallArea.FI_AREA_INDEX);
            if (dArea_index!= null) {
                this.setField(ModelTMallArea.FI_AREA_INDEX, ret, dArea_index);
            }
            Object dArea_path = param.get(ModelTMallArea.FI_AREA_PATH);
            if (dArea_path!= null) {
                this.setField(ModelTMallArea.FI_AREA_PATH, ret, dArea_path);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected EnumAreaType mapToFieldAreaType(Object obj) {
            return EnumAreaType.fromValue(((Byte) obj));
        }

        protected String mapToFieldAreaName(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldAreaArixMaxX(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaArixMaxY(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaArixMaxZ(Object obj) {
            return ((Integer) obj);
        }

        protected Byte mapToFieldAreaReachable(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldAreaCapacity(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaArixXBase(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaArixYBase(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaArixZBase(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaIndex(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldAreaPath(Object obj) {
            return ((Integer) obj);
        }

        public<TT> TT getField(String field, ModelTMallArea instance) {
            try {
                if (field.equals(ModelTMallArea.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTMallArea.FI_AREA_TYPE)) {
                        return ((TT) instance.getAreaType());
                    } else {
                        if (field.equals(ModelTMallArea.FI_AREA_NAME)) {
                            return ((TT) instance.getAreaName());
                        } else {
                            if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
                                return ((TT) instance.getAreaArixMaxX());
                            } else {
                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
                                    return ((TT) instance.getAreaArixMaxY());
                                } else {
                                    if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
                                        return ((TT) instance.getAreaArixMaxZ());
                                    } else {
                                        if (field.equals(ModelTMallArea.FI_AREA_REACHABLE)) {
                                            return ((TT) instance.getAreaReachable());
                                        } else {
                                            if (field.equals(ModelTMallArea.FI_AREA_CAPACITY)) {
                                                return ((TT) instance.getAreaCapacity());
                                            } else {
                                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
                                                    return ((TT) instance.getAreaArixXBase());
                                                } else {
                                                    if (field.equals(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
                                                        return ((TT) instance.getAreaArixYBase());
                                                    } else {
                                                        if (field.equals(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
                                                            return ((TT) instance.getAreaArixZBase());
                                                        } else {
                                                            if (field.equals(ModelTMallArea.FI_AREA_INDEX)) {
                                                                return ((TT) instance.getAreaIndex());
                                                            } else {
                                                                if (field.equals(ModelTMallArea.FI_AREA_PATH)) {
                                                                    return ((TT) instance.getAreaPath());
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

        public<TT> void setField(String field, ModelTMallArea instance, TT value) {
            if (field.equals(ModelTMallArea.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTMallArea.FI_AREA_TYPE)) {
                    try {
                        instance.setAreaType(mapToFieldAreaType(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTMallArea.FI_AREA_NAME)) {
                        try {
                            instance.setAreaName(mapToFieldAreaName(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
                            try {
                                instance.setAreaArixMaxX(mapToFieldAreaArixMaxX(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
                                try {
                                    instance.setAreaArixMaxY(mapToFieldAreaArixMaxY(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
                                    try {
                                        instance.setAreaArixMaxZ(mapToFieldAreaArixMaxZ(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTMallArea.FI_AREA_REACHABLE)) {
                                        try {
                                            instance.setAreaReachable(mapToFieldAreaReachable(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTMallArea.FI_AREA_CAPACITY)) {
                                            try {
                                                instance.setAreaCapacity(mapToFieldAreaCapacity(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
                                                try {
                                                    instance.setAreaArixXBase(mapToFieldAreaArixXBase(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
                                                    try {
                                                        instance.setAreaArixYBase(mapToFieldAreaArixYBase(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
                                                        try {
                                                            instance.setAreaArixZBase(mapToFieldAreaArixZBase(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTMallArea.FI_AREA_INDEX)) {
                                                            try {
                                                                instance.setAreaIndex(mapToFieldAreaIndex(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelTMallArea.FI_AREA_PATH)) {
                                                                try {
                                                                    instance.setAreaPath(mapToFieldAreaPath(value));
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

        public void setField(String field, ModelTMallArea instance, byte[] value) {
            if (field.equals(ModelTMallArea.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTMallArea.FI_AREA_TYPE)) {
                    instance.setAreaType(mapToFieldAreaType(value));
                } else {
                    if (field.equals(ModelTMallArea.FI_AREA_NAME)) {
                        instance.setAreaName(mapToFieldAreaName(value));
                    } else {
                        if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_X)) {
                            instance.setAreaArixMaxX(mapToFieldAreaArixMaxX(value));
                        } else {
                            if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Y)) {
                                instance.setAreaArixMaxY(mapToFieldAreaArixMaxY(value));
                            } else {
                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_MAX_Z)) {
                                    instance.setAreaArixMaxZ(mapToFieldAreaArixMaxZ(value));
                                } else {
                                    if (field.equals(ModelTMallArea.FI_AREA_REACHABLE)) {
                                        instance.setAreaReachable(mapToFieldAreaReachable(value));
                                    } else {
                                        if (field.equals(ModelTMallArea.FI_AREA_CAPACITY)) {
                                            instance.setAreaCapacity(mapToFieldAreaCapacity(value));
                                        } else {
                                            if (field.equals(ModelTMallArea.FI_AREA_ARIX_X_BASE)) {
                                                instance.setAreaArixXBase(mapToFieldAreaArixXBase(value));
                                            } else {
                                                if (field.equals(ModelTMallArea.FI_AREA_ARIX_Y_BASE)) {
                                                    instance.setAreaArixYBase(mapToFieldAreaArixYBase(value));
                                                } else {
                                                    if (field.equals(ModelTMallArea.FI_AREA_ARIX_Z_BASE)) {
                                                        instance.setAreaArixZBase(mapToFieldAreaArixZBase(value));
                                                    } else {
                                                        if (field.equals(ModelTMallArea.FI_AREA_INDEX)) {
                                                            instance.setAreaIndex(mapToFieldAreaIndex(value));
                                                        } else {
                                                            if (field.equals(ModelTMallArea.FI_AREA_PATH)) {
                                                                instance.setAreaPath(mapToFieldAreaPath(value));
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
