/**
 * don't modify , it is generate automatically, any modification will be lost after regeneration next time
 * 
 * @author shawn-ss's auto writer
 */
package com.shangde.ent_portal.logical.dto.basepo;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.RedisMapMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.dto_base.model._APIObj;


/**
 * base DTO,represent for  :b_menu
 */
public class ModelBMenu
    extends AbstractBaseModel
{
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 菜单编码
     */
    String menuCode;
    public final static String FI_MENU_CODE = "menu_code";
    /**
     * 菜单名称
     */
    String menuName;
    public final static String FI_MENU_NAME = "menu_name";
    /**
     * 菜单类型
     */
    Integer menuType;
    public final static String FI_MENU_TYPE = "menu_type";
    /**
     * 父级ID
     */
    Integer menuParentId;
    public final static String FI_MENU_PARENT_ID = "menu_parent_id";
    /**
     * 父级url
     */
    String menuParentUrl;
    public final static String FI_MENU_PARENT_URL = "menu_parent_url";
    /**
     * 菜单URL
     */
    String menuUrl;
    public final static String FI_MENU_URL = "menu_url";
    /**
     * 菜单样式
     */
    String menuIconClass;
    public final static String FI_MENU_ICON_CLASS = "menu_icon_class";
    /**
     * 排序
     */
    Integer menuSort;
    public final static String FI_MENU_SORT = "menu_sort";
    /**
     * 是否启用
     */
    Integer menuEnabled;
    public final static String FI_MENU_ENABLED = "menu_enabled";
    /**
     * 备注
     */
    String menuRemark;
    public final static String FI_MENU_REMARK = "menu_remark";
    /**
     * 创建人
     */
    Integer menuCreator;
    public final static String FI_MENU_CREATOR = "menu_creator";
    /**
     * 创建时间
     */
    Date menuCreateTime;
    public final static String FI_MENU_CREATE_TIME = "menu_create_time";
    /**
     * 修改人
     */
    Integer menuUpdator;
    public final static String FI_MENU_UPDATOR = "menu_updator";
    /**
     * 修改时间
     */
    Date menuUpdateTime;
    public final static String FI_MENU_UPDATE_TIME = "menu_update_time";
    /**
     * 删除标记
     */
    Byte menuDeleteFlag;
    public final static String FI_MENU_DELETE_FLAG = "menu_delete_flag";
    /**
     * 功能级别
     */
    Byte menuLevel;
    public final static String FI_MENU_LEVEL = "menu_level";
    /**
     * 菜单权限数值
     */
    Integer menuAuth;
    public final static String FI_MENU_AUTH = "menu_auth";
    /**
     * 功能基础参数--使用参数区分功能
     */
    String menuRequestParamMain;
    public final static String FI_MENU_REQUEST_PARAM_MAIN = "menu_request_param_main";
    /**
     * 功能副参数
     */
    String menuRequestParamSub;
    public final static String FI_MENU_REQUEST_PARAM_SUB = "menu_request_param_sub";
    /**
     * 关联api_id
     */
    Integer menuFunctionId;
    public final static String FI_MENU_FUNCTION_ID = "menu_function_id";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelBMenu.FI_ID, Integer.class).put(ModelBMenu.FI_MENU_CODE, String.class).put(ModelBMenu.FI_MENU_NAME, String.class).put(ModelBMenu.FI_MENU_TYPE, Integer.class).put(ModelBMenu.FI_MENU_PARENT_ID, Integer.class).put(ModelBMenu.FI_MENU_PARENT_URL, String.class).put(ModelBMenu.FI_MENU_URL, String.class).put(ModelBMenu.FI_MENU_ICON_CLASS, String.class).put(ModelBMenu.FI_MENU_SORT, Integer.class).put(ModelBMenu.FI_MENU_ENABLED, Integer.class).put(ModelBMenu.FI_MENU_REMARK, String.class).put(ModelBMenu.FI_MENU_CREATOR, Integer.class).put(ModelBMenu.FI_MENU_CREATE_TIME, Date.class).put(ModelBMenu.FI_MENU_UPDATOR, Integer.class).put(ModelBMenu.FI_MENU_UPDATE_TIME, Date.class).put(ModelBMenu.FI_MENU_DELETE_FLAG, Byte.class).put(ModelBMenu.FI_MENU_LEVEL, Byte.class).put(ModelBMenu.FI_MENU_AUTH, Integer.class).put(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN, String.class).put(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB, String.class).put(ModelBMenu.FI_MENU_FUNCTION_ID, Integer.class).getMap();
    public final static Integer FIELD_COUNT = 21;
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "b_menu";
    public final static String DTO_DB_NAME = "robot_control_system";

    public ModelBMenu() {
    }

    public Integer getId() {
        return id;
    }

    public ModelBMenu setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public ModelBMenu setMenuCode(String lMenuCode) {
        menuCode = lMenuCode;
        return this;
    }

    public String getMenuName() {
        return menuName;
    }

    public ModelBMenu setMenuName(String lMenuName) {
        menuName = lMenuName;
        return this;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public ModelBMenu setMenuType(Integer lMenuType) {
        menuType = lMenuType;
        return this;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public ModelBMenu setMenuParentId(Integer lMenuParentId) {
        menuParentId = lMenuParentId;
        return this;
    }

    public String getMenuParentUrl() {
        return menuParentUrl;
    }

    public ModelBMenu setMenuParentUrl(String lMenuParentUrl) {
        menuParentUrl = lMenuParentUrl;
        return this;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public ModelBMenu setMenuUrl(String lMenuUrl) {
        menuUrl = lMenuUrl;
        return this;
    }

    public String getMenuIconClass() {
        return menuIconClass;
    }

    public ModelBMenu setMenuIconClass(String lMenuIconClass) {
        menuIconClass = lMenuIconClass;
        return this;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public ModelBMenu setMenuSort(Integer lMenuSort) {
        menuSort = lMenuSort;
        return this;
    }

    public Integer getMenuEnabled() {
        return menuEnabled;
    }

    public ModelBMenu setMenuEnabled(Integer lMenuEnabled) {
        menuEnabled = lMenuEnabled;
        return this;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public ModelBMenu setMenuRemark(String lMenuRemark) {
        menuRemark = lMenuRemark;
        return this;
    }

    public Integer getMenuCreator() {
        return menuCreator;
    }

    public ModelBMenu setMenuCreator(Integer lMenuCreator) {
        menuCreator = lMenuCreator;
        return this;
    }

    public Date getMenuCreateTime() {
        return menuCreateTime;
    }

    public ModelBMenu setMenuCreateTime(Date lMenuCreateTime) {
        menuCreateTime = lMenuCreateTime;
        return this;
    }

    public Integer getMenuUpdator() {
        return menuUpdator;
    }

    public ModelBMenu setMenuUpdator(Integer lMenuUpdator) {
        menuUpdator = lMenuUpdator;
        return this;
    }

    public Date getMenuUpdateTime() {
        return menuUpdateTime;
    }

    public ModelBMenu setMenuUpdateTime(Date lMenuUpdateTime) {
        menuUpdateTime = lMenuUpdateTime;
        return this;
    }

    public Byte getMenuDeleteFlag() {
        return menuDeleteFlag;
    }

    public ModelBMenu setMenuDeleteFlag(Byte lMenuDeleteFlag) {
        menuDeleteFlag = lMenuDeleteFlag;
        return this;
    }

    public Byte getMenuLevel() {
        return menuLevel;
    }

    public ModelBMenu setMenuLevel(Byte lMenuLevel) {
        menuLevel = lMenuLevel;
        return this;
    }

    public Integer getMenuAuth() {
        return menuAuth;
    }

    public ModelBMenu setMenuAuth(Integer lMenuAuth) {
        menuAuth = lMenuAuth;
        return this;
    }

    public String getMenuRequestParamMain() {
        return menuRequestParamMain;
    }

    public ModelBMenu setMenuRequestParamMain(String lMenuRequestParamMain) {
        menuRequestParamMain = lMenuRequestParamMain;
        return this;
    }

    public String getMenuRequestParamSub() {
        return menuRequestParamSub;
    }

    public ModelBMenu setMenuRequestParamSub(String lMenuRequestParamSub) {
        menuRequestParamSub = lMenuRequestParamSub;
        return this;
    }

    public Integer getMenuFunctionId() {
        return menuFunctionId;
    }

    public ModelBMenu setMenuFunctionId(Integer lMenuFunctionId) {
        menuFunctionId = lMenuFunctionId;
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
        if (getMenuCode()!= null) {
            return false;
        }
        if (getMenuName()!= null) {
            return false;
        }
        if (getMenuType()!= null) {
            return false;
        }
        if (getMenuParentId()!= null) {
            return false;
        }
        if (getMenuParentUrl()!= null) {
            return false;
        }
        if (getMenuUrl()!= null) {
            return false;
        }
        if (getMenuIconClass()!= null) {
            return false;
        }
        if (getMenuSort()!= null) {
            return false;
        }
        if (getMenuEnabled()!= null) {
            return false;
        }
        if (getMenuRemark()!= null) {
            return false;
        }
        if (getMenuCreator()!= null) {
            return false;
        }
        if (getMenuCreateTime()!= null) {
            return false;
        }
        if (getMenuUpdator()!= null) {
            return false;
        }
        if (getMenuUpdateTime()!= null) {
            return false;
        }
        if (getMenuDeleteFlag()!= null) {
            return false;
        }
        if (getMenuLevel()!= null) {
            return false;
        }
        if (getMenuAuth()!= null) {
            return false;
        }
        if (getMenuRequestParamMain()!= null) {
            return false;
        }
        if (getMenuRequestParamSub()!= null) {
            return false;
        }
        if (getMenuFunctionId()!= null) {
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
        ret.append("{").append("menuCode").append(":").append(menuCode).append("}\n");
        ret.append("{").append("menuName").append(":").append(menuName).append("}\n");
        ret.append("{").append("menuType").append(":").append(menuType).append("}\n");
        ret.append("{").append("menuParentId").append(":").append(menuParentId).append("}\n");
        ret.append("{").append("menuParentUrl").append(":").append(menuParentUrl).append("}\n");
        ret.append("{").append("menuUrl").append(":").append(menuUrl).append("}\n");
        ret.append("{").append("menuIconClass").append(":").append(menuIconClass).append("}\n");
        ret.append("{").append("menuSort").append(":").append(menuSort).append("}\n");
        ret.append("{").append("menuEnabled").append(":").append(menuEnabled).append("}\n");
        ret.append("{").append("menuRemark").append(":").append(menuRemark).append("}\n");
        ret.append("{").append("menuCreator").append(":").append(menuCreator).append("}\n");
        ret.append("{").append("menuCreateTime").append(":").append(menuCreateTime).append("}\n");
        ret.append("{").append("menuUpdator").append(":").append(menuUpdator).append("}\n");
        ret.append("{").append("menuUpdateTime").append(":").append(menuUpdateTime).append("}\n");
        ret.append("{").append("menuDeleteFlag").append(":").append(menuDeleteFlag).append("}\n");
        ret.append("{").append("menuLevel").append(":").append(menuLevel).append("}\n");
        ret.append("{").append("menuAuth").append(":").append(menuAuth).append("}\n");
        ret.append("{").append("menuRequestParamMain").append(":").append(menuRequestParamMain).append("}\n");
        ret.append("{").append("menuRequestParamSub").append(":").append(menuRequestParamSub).append("}\n");
        ret.append("{").append("menuFunctionId").append(":").append(menuFunctionId).append("}\n");
        return ret.toString();
    }

    public static class PojoMapperModelBMenu
        implements RedisMapMapper<ModelBMenu>
    {

        @Override
        public ModelBMenu fromMap(Map<byte[], byte[]> map) {
            ModelBMenu instance = new ModelBMenu();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelBMenu.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelBMenu.FI_MENU_CODE)) {
                        instance.setMenuCode(mapToFieldMenuCode(entry.getValue()));
                    } else {
                        if (field.equals(ModelBMenu.FI_MENU_NAME)) {
                            instance.setMenuName(mapToFieldMenuName(entry.getValue()));
                        } else {
                            if (field.equals(ModelBMenu.FI_MENU_TYPE)) {
                                instance.setMenuType(mapToFieldMenuType(entry.getValue()));
                            } else {
                                if (field.equals(ModelBMenu.FI_MENU_PARENT_ID)) {
                                    instance.setMenuParentId(mapToFieldMenuParentId(entry.getValue()));
                                } else {
                                    if (field.equals(ModelBMenu.FI_MENU_PARENT_URL)) {
                                        instance.setMenuParentUrl(mapToFieldMenuParentUrl(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelBMenu.FI_MENU_URL)) {
                                            instance.setMenuUrl(mapToFieldMenuUrl(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelBMenu.FI_MENU_ICON_CLASS)) {
                                                instance.setMenuIconClass(mapToFieldMenuIconClass(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelBMenu.FI_MENU_SORT)) {
                                                    instance.setMenuSort(mapToFieldMenuSort(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelBMenu.FI_MENU_ENABLED)) {
                                                        instance.setMenuEnabled(mapToFieldMenuEnabled(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelBMenu.FI_MENU_REMARK)) {
                                                            instance.setMenuRemark(mapToFieldMenuRemark(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelBMenu.FI_MENU_CREATOR)) {
                                                                instance.setMenuCreator(mapToFieldMenuCreator(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelBMenu.FI_MENU_CREATE_TIME)) {
                                                                    instance.setMenuCreateTime(mapToFieldMenuCreateTime(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelBMenu.FI_MENU_UPDATOR)) {
                                                                        instance.setMenuUpdator(mapToFieldMenuUpdator(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelBMenu.FI_MENU_UPDATE_TIME)) {
                                                                            instance.setMenuUpdateTime(mapToFieldMenuUpdateTime(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelBMenu.FI_MENU_DELETE_FLAG)) {
                                                                                instance.setMenuDeleteFlag(mapToFieldMenuDeleteFlag(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelBMenu.FI_MENU_LEVEL)) {
                                                                                    instance.setMenuLevel(mapToFieldMenuLevel(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelBMenu.FI_MENU_AUTH)) {
                                                                                        instance.setMenuAuth(mapToFieldMenuAuth(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
                                                                                            instance.setMenuRequestParamMain(mapToFieldMenuRequestParamMain(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
                                                                                                instance.setMenuRequestParamSub(mapToFieldMenuRequestParamSub(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelBMenu.FI_MENU_FUNCTION_ID)) {
                                                                                                    instance.setMenuFunctionId(mapToFieldMenuFunctionId(entry.getValue()));
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

        protected Integer mapToFieldId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldMenuCode(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMenuName(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldMenuType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMenuParentId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldMenuParentUrl(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMenuUrl(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMenuIconClass(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldMenuSort(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMenuEnabled(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldMenuRemark(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldMenuCreator(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldMenuCreateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Integer mapToFieldMenuUpdator(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldMenuUpdateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Byte mapToFieldMenuDeleteFlag(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Byte mapToFieldMenuLevel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected Integer mapToFieldMenuAuth(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldMenuRequestParamMain(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldMenuRequestParamSub(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldMenuFunctionId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelBMenu instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelBMenu.FI_ID.getBytes(), valueId);
            byte[] valueMenu_code = mapFromFieldMenuCode(instance.getMenuCode());
            ret.put(ModelBMenu.FI_MENU_CODE.getBytes(), valueMenu_code);
            byte[] valueMenu_name = mapFromFieldMenuName(instance.getMenuName());
            ret.put(ModelBMenu.FI_MENU_NAME.getBytes(), valueMenu_name);
            byte[] valueMenu_type = mapFromFieldMenuType(instance.getMenuType());
            ret.put(ModelBMenu.FI_MENU_TYPE.getBytes(), valueMenu_type);
            byte[] valueMenu_parent_id = mapFromFieldMenuParentId(instance.getMenuParentId());
            ret.put(ModelBMenu.FI_MENU_PARENT_ID.getBytes(), valueMenu_parent_id);
            byte[] valueMenu_parent_url = mapFromFieldMenuParentUrl(instance.getMenuParentUrl());
            ret.put(ModelBMenu.FI_MENU_PARENT_URL.getBytes(), valueMenu_parent_url);
            byte[] valueMenu_url = mapFromFieldMenuUrl(instance.getMenuUrl());
            ret.put(ModelBMenu.FI_MENU_URL.getBytes(), valueMenu_url);
            byte[] valueMenu_icon_class = mapFromFieldMenuIconClass(instance.getMenuIconClass());
            ret.put(ModelBMenu.FI_MENU_ICON_CLASS.getBytes(), valueMenu_icon_class);
            byte[] valueMenu_sort = mapFromFieldMenuSort(instance.getMenuSort());
            ret.put(ModelBMenu.FI_MENU_SORT.getBytes(), valueMenu_sort);
            byte[] valueMenu_enabled = mapFromFieldMenuEnabled(instance.getMenuEnabled());
            ret.put(ModelBMenu.FI_MENU_ENABLED.getBytes(), valueMenu_enabled);
            byte[] valueMenu_remark = mapFromFieldMenuRemark(instance.getMenuRemark());
            ret.put(ModelBMenu.FI_MENU_REMARK.getBytes(), valueMenu_remark);
            byte[] valueMenu_creator = mapFromFieldMenuCreator(instance.getMenuCreator());
            ret.put(ModelBMenu.FI_MENU_CREATOR.getBytes(), valueMenu_creator);
            byte[] valueMenu_create_time = mapFromFieldMenuCreateTime(instance.getMenuCreateTime());
            ret.put(ModelBMenu.FI_MENU_CREATE_TIME.getBytes(), valueMenu_create_time);
            byte[] valueMenu_updator = mapFromFieldMenuUpdator(instance.getMenuUpdator());
            ret.put(ModelBMenu.FI_MENU_UPDATOR.getBytes(), valueMenu_updator);
            byte[] valueMenu_update_time = mapFromFieldMenuUpdateTime(instance.getMenuUpdateTime());
            ret.put(ModelBMenu.FI_MENU_UPDATE_TIME.getBytes(), valueMenu_update_time);
            byte[] valueMenu_delete_flag = mapFromFieldMenuDeleteFlag(instance.getMenuDeleteFlag());
            ret.put(ModelBMenu.FI_MENU_DELETE_FLAG.getBytes(), valueMenu_delete_flag);
            byte[] valueMenu_level = mapFromFieldMenuLevel(instance.getMenuLevel());
            ret.put(ModelBMenu.FI_MENU_LEVEL.getBytes(), valueMenu_level);
            byte[] valueMenu_auth = mapFromFieldMenuAuth(instance.getMenuAuth());
            ret.put(ModelBMenu.FI_MENU_AUTH.getBytes(), valueMenu_auth);
            byte[] valueMenu_request_param_main = mapFromFieldMenuRequestParamMain(instance.getMenuRequestParamMain());
            ret.put(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN.getBytes(), valueMenu_request_param_main);
            byte[] valueMenu_request_param_sub = mapFromFieldMenuRequestParamSub(instance.getMenuRequestParamSub());
            ret.put(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB.getBytes(), valueMenu_request_param_sub);
            byte[] valueMenu_function_id = mapFromFieldMenuFunctionId(instance.getMenuFunctionId());
            ret.put(ModelBMenu.FI_MENU_FUNCTION_ID.getBytes(), valueMenu_function_id);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuCode(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuName(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuType(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuParentId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuParentUrl(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuUrl(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuIconClass(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuSort(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuEnabled(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuRemark(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuCreator(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuCreateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuUpdator(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuUpdateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuDeleteFlag(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuLevel(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuAuth(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuRequestParamMain(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuRequestParamSub(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMenuFunctionId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelBMenu instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelBMenu.FI_ID, dId);
            }
            String dMenu_code = instance.getMenuCode();
            if (dMenu_code!= null) {
                ret.put(ModelBMenu.FI_MENU_CODE, dMenu_code);
            }
            String dMenu_name = instance.getMenuName();
            if (dMenu_name!= null) {
                ret.put(ModelBMenu.FI_MENU_NAME, dMenu_name);
            }
            Integer dMenu_type = instance.getMenuType();
            if (dMenu_type!= null) {
                ret.put(ModelBMenu.FI_MENU_TYPE, dMenu_type);
            }
            Integer dMenu_parent_id = instance.getMenuParentId();
            if (dMenu_parent_id!= null) {
                ret.put(ModelBMenu.FI_MENU_PARENT_ID, dMenu_parent_id);
            }
            String dMenu_parent_url = instance.getMenuParentUrl();
            if (dMenu_parent_url!= null) {
                ret.put(ModelBMenu.FI_MENU_PARENT_URL, dMenu_parent_url);
            }
            String dMenu_url = instance.getMenuUrl();
            if (dMenu_url!= null) {
                ret.put(ModelBMenu.FI_MENU_URL, dMenu_url);
            }
            String dMenu_icon_class = instance.getMenuIconClass();
            if (dMenu_icon_class!= null) {
                ret.put(ModelBMenu.FI_MENU_ICON_CLASS, dMenu_icon_class);
            }
            Integer dMenu_sort = instance.getMenuSort();
            if (dMenu_sort!= null) {
                ret.put(ModelBMenu.FI_MENU_SORT, dMenu_sort);
            }
            Integer dMenu_enabled = instance.getMenuEnabled();
            if (dMenu_enabled!= null) {
                ret.put(ModelBMenu.FI_MENU_ENABLED, dMenu_enabled);
            }
            String dMenu_remark = instance.getMenuRemark();
            if (dMenu_remark!= null) {
                ret.put(ModelBMenu.FI_MENU_REMARK, dMenu_remark);
            }
            Integer dMenu_creator = instance.getMenuCreator();
            if (dMenu_creator!= null) {
                ret.put(ModelBMenu.FI_MENU_CREATOR, dMenu_creator);
            }
            Date dMenu_create_time = instance.getMenuCreateTime();
            if (dMenu_create_time!= null) {
                ret.put(ModelBMenu.FI_MENU_CREATE_TIME, dMenu_create_time);
            }
            Integer dMenu_updator = instance.getMenuUpdator();
            if (dMenu_updator!= null) {
                ret.put(ModelBMenu.FI_MENU_UPDATOR, dMenu_updator);
            }
            Date dMenu_update_time = instance.getMenuUpdateTime();
            if (dMenu_update_time!= null) {
                ret.put(ModelBMenu.FI_MENU_UPDATE_TIME, dMenu_update_time);
            }
            Byte dMenu_delete_flag = instance.getMenuDeleteFlag();
            if (dMenu_delete_flag!= null) {
                ret.put(ModelBMenu.FI_MENU_DELETE_FLAG, dMenu_delete_flag);
            }
            Byte dMenu_level = instance.getMenuLevel();
            if (dMenu_level!= null) {
                ret.put(ModelBMenu.FI_MENU_LEVEL, dMenu_level);
            }
            Integer dMenu_auth = instance.getMenuAuth();
            if (dMenu_auth!= null) {
                ret.put(ModelBMenu.FI_MENU_AUTH, dMenu_auth);
            }
            String dMenu_request_param_main = instance.getMenuRequestParamMain();
            if (dMenu_request_param_main!= null) {
                ret.put(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN, dMenu_request_param_main);
            }
            String dMenu_request_param_sub = instance.getMenuRequestParamSub();
            if (dMenu_request_param_sub!= null) {
                ret.put(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB, dMenu_request_param_sub);
            }
            Integer dMenu_function_id = instance.getMenuFunctionId();
            if (dMenu_function_id!= null) {
                ret.put(ModelBMenu.FI_MENU_FUNCTION_ID, dMenu_function_id);
            }
            return ret;
        }

        @Override
        public ModelBMenu fromCommonMap(Map<String, Object> param) {
            ModelBMenu ret = new ModelBMenu();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelBMenu.FI_ID);
            if (dId!= null) {
                this.setField(ModelBMenu.FI_ID, ret, dId);
            }
            Object dMenu_code = param.get(ModelBMenu.FI_MENU_CODE);
            if (dMenu_code!= null) {
                this.setField(ModelBMenu.FI_MENU_CODE, ret, dMenu_code);
            }
            Object dMenu_name = param.get(ModelBMenu.FI_MENU_NAME);
            if (dMenu_name!= null) {
                this.setField(ModelBMenu.FI_MENU_NAME, ret, dMenu_name);
            }
            Object dMenu_type = param.get(ModelBMenu.FI_MENU_TYPE);
            if (dMenu_type!= null) {
                this.setField(ModelBMenu.FI_MENU_TYPE, ret, dMenu_type);
            }
            Object dMenu_parent_id = param.get(ModelBMenu.FI_MENU_PARENT_ID);
            if (dMenu_parent_id!= null) {
                this.setField(ModelBMenu.FI_MENU_PARENT_ID, ret, dMenu_parent_id);
            }
            Object dMenu_parent_url = param.get(ModelBMenu.FI_MENU_PARENT_URL);
            if (dMenu_parent_url!= null) {
                this.setField(ModelBMenu.FI_MENU_PARENT_URL, ret, dMenu_parent_url);
            }
            Object dMenu_url = param.get(ModelBMenu.FI_MENU_URL);
            if (dMenu_url!= null) {
                this.setField(ModelBMenu.FI_MENU_URL, ret, dMenu_url);
            }
            Object dMenu_icon_class = param.get(ModelBMenu.FI_MENU_ICON_CLASS);
            if (dMenu_icon_class!= null) {
                this.setField(ModelBMenu.FI_MENU_ICON_CLASS, ret, dMenu_icon_class);
            }
            Object dMenu_sort = param.get(ModelBMenu.FI_MENU_SORT);
            if (dMenu_sort!= null) {
                this.setField(ModelBMenu.FI_MENU_SORT, ret, dMenu_sort);
            }
            Object dMenu_enabled = param.get(ModelBMenu.FI_MENU_ENABLED);
            if (dMenu_enabled!= null) {
                this.setField(ModelBMenu.FI_MENU_ENABLED, ret, dMenu_enabled);
            }
            Object dMenu_remark = param.get(ModelBMenu.FI_MENU_REMARK);
            if (dMenu_remark!= null) {
                this.setField(ModelBMenu.FI_MENU_REMARK, ret, dMenu_remark);
            }
            Object dMenu_creator = param.get(ModelBMenu.FI_MENU_CREATOR);
            if (dMenu_creator!= null) {
                this.setField(ModelBMenu.FI_MENU_CREATOR, ret, dMenu_creator);
            }
            Object dMenu_create_time = param.get(ModelBMenu.FI_MENU_CREATE_TIME);
            if (dMenu_create_time!= null) {
                this.setField(ModelBMenu.FI_MENU_CREATE_TIME, ret, dMenu_create_time);
            }
            Object dMenu_updator = param.get(ModelBMenu.FI_MENU_UPDATOR);
            if (dMenu_updator!= null) {
                this.setField(ModelBMenu.FI_MENU_UPDATOR, ret, dMenu_updator);
            }
            Object dMenu_update_time = param.get(ModelBMenu.FI_MENU_UPDATE_TIME);
            if (dMenu_update_time!= null) {
                this.setField(ModelBMenu.FI_MENU_UPDATE_TIME, ret, dMenu_update_time);
            }
            Object dMenu_delete_flag = param.get(ModelBMenu.FI_MENU_DELETE_FLAG);
            if (dMenu_delete_flag!= null) {
                this.setField(ModelBMenu.FI_MENU_DELETE_FLAG, ret, dMenu_delete_flag);
            }
            Object dMenu_level = param.get(ModelBMenu.FI_MENU_LEVEL);
            if (dMenu_level!= null) {
                this.setField(ModelBMenu.FI_MENU_LEVEL, ret, dMenu_level);
            }
            Object dMenu_auth = param.get(ModelBMenu.FI_MENU_AUTH);
            if (dMenu_auth!= null) {
                this.setField(ModelBMenu.FI_MENU_AUTH, ret, dMenu_auth);
            }
            Object dMenu_request_param_main = param.get(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN);
            if (dMenu_request_param_main!= null) {
                this.setField(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN, ret, dMenu_request_param_main);
            }
            Object dMenu_request_param_sub = param.get(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB);
            if (dMenu_request_param_sub!= null) {
                this.setField(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB, ret, dMenu_request_param_sub);
            }
            Object dMenu_function_id = param.get(ModelBMenu.FI_MENU_FUNCTION_ID);
            if (dMenu_function_id!= null) {
                this.setField(ModelBMenu.FI_MENU_FUNCTION_ID, ret, dMenu_function_id);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMenuCode(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMenuName(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldMenuType(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMenuParentId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMenuParentUrl(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMenuUrl(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMenuIconClass(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldMenuSort(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMenuEnabled(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMenuRemark(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldMenuCreator(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldMenuCreateTime(Object obj) {
            return ((Date) obj);
        }

        protected Integer mapToFieldMenuUpdator(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldMenuUpdateTime(Object obj) {
            return ((Date) obj);
        }

        protected Byte mapToFieldMenuDeleteFlag(Object obj) {
            return ((Byte) obj);
        }

        protected Byte mapToFieldMenuLevel(Object obj) {
            return ((Byte) obj);
        }

        protected Integer mapToFieldMenuAuth(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMenuRequestParamMain(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldMenuRequestParamSub(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldMenuFunctionId(Object obj) {
            return ((Integer) obj);
        }

        public<TT> TT getField(String field, ModelBMenu instance) {
            try {
                if (field.equals(ModelBMenu.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelBMenu.FI_MENU_CODE)) {
                        return ((TT) instance.getMenuCode());
                    } else {
                        if (field.equals(ModelBMenu.FI_MENU_NAME)) {
                            return ((TT) instance.getMenuName());
                        } else {
                            if (field.equals(ModelBMenu.FI_MENU_TYPE)) {
                                return ((TT) instance.getMenuType());
                            } else {
                                if (field.equals(ModelBMenu.FI_MENU_PARENT_ID)) {
                                    return ((TT) instance.getMenuParentId());
                                } else {
                                    if (field.equals(ModelBMenu.FI_MENU_PARENT_URL)) {
                                        return ((TT) instance.getMenuParentUrl());
                                    } else {
                                        if (field.equals(ModelBMenu.FI_MENU_URL)) {
                                            return ((TT) instance.getMenuUrl());
                                        } else {
                                            if (field.equals(ModelBMenu.FI_MENU_ICON_CLASS)) {
                                                return ((TT) instance.getMenuIconClass());
                                            } else {
                                                if (field.equals(ModelBMenu.FI_MENU_SORT)) {
                                                    return ((TT) instance.getMenuSort());
                                                } else {
                                                    if (field.equals(ModelBMenu.FI_MENU_ENABLED)) {
                                                        return ((TT) instance.getMenuEnabled());
                                                    } else {
                                                        if (field.equals(ModelBMenu.FI_MENU_REMARK)) {
                                                            return ((TT) instance.getMenuRemark());
                                                        } else {
                                                            if (field.equals(ModelBMenu.FI_MENU_CREATOR)) {
                                                                return ((TT) instance.getMenuCreator());
                                                            } else {
                                                                if (field.equals(ModelBMenu.FI_MENU_CREATE_TIME)) {
                                                                    return ((TT) instance.getMenuCreateTime());
                                                                } else {
                                                                    if (field.equals(ModelBMenu.FI_MENU_UPDATOR)) {
                                                                        return ((TT) instance.getMenuUpdator());
                                                                    } else {
                                                                        if (field.equals(ModelBMenu.FI_MENU_UPDATE_TIME)) {
                                                                            return ((TT) instance.getMenuUpdateTime());
                                                                        } else {
                                                                            if (field.equals(ModelBMenu.FI_MENU_DELETE_FLAG)) {
                                                                                return ((TT) instance.getMenuDeleteFlag());
                                                                            } else {
                                                                                if (field.equals(ModelBMenu.FI_MENU_LEVEL)) {
                                                                                    return ((TT) instance.getMenuLevel());
                                                                                } else {
                                                                                    if (field.equals(ModelBMenu.FI_MENU_AUTH)) {
                                                                                        return ((TT) instance.getMenuAuth());
                                                                                    } else {
                                                                                        if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
                                                                                            return ((TT) instance.getMenuRequestParamMain());
                                                                                        } else {
                                                                                            if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
                                                                                                return ((TT) instance.getMenuRequestParamSub());
                                                                                            } else {
                                                                                                if (field.equals(ModelBMenu.FI_MENU_FUNCTION_ID)) {
                                                                                                    return ((TT) instance.getMenuFunctionId());
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

        public<TT> void setField(String field, ModelBMenu instance, TT value) {
            if (field.equals(ModelBMenu.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelBMenu.FI_MENU_CODE)) {
                    try {
                        instance.setMenuCode(mapToFieldMenuCode(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelBMenu.FI_MENU_NAME)) {
                        try {
                            instance.setMenuName(mapToFieldMenuName(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelBMenu.FI_MENU_TYPE)) {
                            try {
                                instance.setMenuType(mapToFieldMenuType(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelBMenu.FI_MENU_PARENT_ID)) {
                                try {
                                    instance.setMenuParentId(mapToFieldMenuParentId(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelBMenu.FI_MENU_PARENT_URL)) {
                                    try {
                                        instance.setMenuParentUrl(mapToFieldMenuParentUrl(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelBMenu.FI_MENU_URL)) {
                                        try {
                                            instance.setMenuUrl(mapToFieldMenuUrl(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelBMenu.FI_MENU_ICON_CLASS)) {
                                            try {
                                                instance.setMenuIconClass(mapToFieldMenuIconClass(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelBMenu.FI_MENU_SORT)) {
                                                try {
                                                    instance.setMenuSort(mapToFieldMenuSort(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelBMenu.FI_MENU_ENABLED)) {
                                                    try {
                                                        instance.setMenuEnabled(mapToFieldMenuEnabled(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelBMenu.FI_MENU_REMARK)) {
                                                        try {
                                                            instance.setMenuRemark(mapToFieldMenuRemark(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelBMenu.FI_MENU_CREATOR)) {
                                                            try {
                                                                instance.setMenuCreator(mapToFieldMenuCreator(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelBMenu.FI_MENU_CREATE_TIME)) {
                                                                try {
                                                                    instance.setMenuCreateTime(mapToFieldMenuCreateTime(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelBMenu.FI_MENU_UPDATOR)) {
                                                                    try {
                                                                        instance.setMenuUpdator(mapToFieldMenuUpdator(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelBMenu.FI_MENU_UPDATE_TIME)) {
                                                                        try {
                                                                            instance.setMenuUpdateTime(mapToFieldMenuUpdateTime(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelBMenu.FI_MENU_DELETE_FLAG)) {
                                                                            try {
                                                                                instance.setMenuDeleteFlag(mapToFieldMenuDeleteFlag(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelBMenu.FI_MENU_LEVEL)) {
                                                                                try {
                                                                                    instance.setMenuLevel(mapToFieldMenuLevel(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelBMenu.FI_MENU_AUTH)) {
                                                                                    try {
                                                                                        instance.setMenuAuth(mapToFieldMenuAuth(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
                                                                                        try {
                                                                                            instance.setMenuRequestParamMain(mapToFieldMenuRequestParamMain(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
                                                                                            try {
                                                                                                instance.setMenuRequestParamSub(mapToFieldMenuRequestParamSub(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelBMenu.FI_MENU_FUNCTION_ID)) {
                                                                                                try {
                                                                                                    instance.setMenuFunctionId(mapToFieldMenuFunctionId(value));
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

        public void setField(String field, ModelBMenu instance, byte[] value) {
            if (field.equals(ModelBMenu.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelBMenu.FI_MENU_CODE)) {
                    instance.setMenuCode(mapToFieldMenuCode(value));
                } else {
                    if (field.equals(ModelBMenu.FI_MENU_NAME)) {
                        instance.setMenuName(mapToFieldMenuName(value));
                    } else {
                        if (field.equals(ModelBMenu.FI_MENU_TYPE)) {
                            instance.setMenuType(mapToFieldMenuType(value));
                        } else {
                            if (field.equals(ModelBMenu.FI_MENU_PARENT_ID)) {
                                instance.setMenuParentId(mapToFieldMenuParentId(value));
                            } else {
                                if (field.equals(ModelBMenu.FI_MENU_PARENT_URL)) {
                                    instance.setMenuParentUrl(mapToFieldMenuParentUrl(value));
                                } else {
                                    if (field.equals(ModelBMenu.FI_MENU_URL)) {
                                        instance.setMenuUrl(mapToFieldMenuUrl(value));
                                    } else {
                                        if (field.equals(ModelBMenu.FI_MENU_ICON_CLASS)) {
                                            instance.setMenuIconClass(mapToFieldMenuIconClass(value));
                                        } else {
                                            if (field.equals(ModelBMenu.FI_MENU_SORT)) {
                                                instance.setMenuSort(mapToFieldMenuSort(value));
                                            } else {
                                                if (field.equals(ModelBMenu.FI_MENU_ENABLED)) {
                                                    instance.setMenuEnabled(mapToFieldMenuEnabled(value));
                                                } else {
                                                    if (field.equals(ModelBMenu.FI_MENU_REMARK)) {
                                                        instance.setMenuRemark(mapToFieldMenuRemark(value));
                                                    } else {
                                                        if (field.equals(ModelBMenu.FI_MENU_CREATOR)) {
                                                            instance.setMenuCreator(mapToFieldMenuCreator(value));
                                                        } else {
                                                            if (field.equals(ModelBMenu.FI_MENU_CREATE_TIME)) {
                                                                instance.setMenuCreateTime(mapToFieldMenuCreateTime(value));
                                                            } else {
                                                                if (field.equals(ModelBMenu.FI_MENU_UPDATOR)) {
                                                                    instance.setMenuUpdator(mapToFieldMenuUpdator(value));
                                                                } else {
                                                                    if (field.equals(ModelBMenu.FI_MENU_UPDATE_TIME)) {
                                                                        instance.setMenuUpdateTime(mapToFieldMenuUpdateTime(value));
                                                                    } else {
                                                                        if (field.equals(ModelBMenu.FI_MENU_DELETE_FLAG)) {
                                                                            instance.setMenuDeleteFlag(mapToFieldMenuDeleteFlag(value));
                                                                        } else {
                                                                            if (field.equals(ModelBMenu.FI_MENU_LEVEL)) {
                                                                                instance.setMenuLevel(mapToFieldMenuLevel(value));
                                                                            } else {
                                                                                if (field.equals(ModelBMenu.FI_MENU_AUTH)) {
                                                                                    instance.setMenuAuth(mapToFieldMenuAuth(value));
                                                                                } else {
                                                                                    if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_MAIN)) {
                                                                                        instance.setMenuRequestParamMain(mapToFieldMenuRequestParamMain(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelBMenu.FI_MENU_REQUEST_PARAM_SUB)) {
                                                                                            instance.setMenuRequestParamSub(mapToFieldMenuRequestParamSub(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelBMenu.FI_MENU_FUNCTION_ID)) {
                                                                                                instance.setMenuFunctionId(mapToFieldMenuFunctionId(value));
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
