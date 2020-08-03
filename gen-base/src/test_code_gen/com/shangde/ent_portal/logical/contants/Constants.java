package com.shangde.ent_portal.logical.contants;

import com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial.PojoMapperModelBMaterial;
import com.shangde.ent_portal.logical.dto.basepo.ModelBMenu.PojoMapperModelBMenu;
import com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser.PojoMapperModelBOrgnizationUser;
import com.shangde.ent_portal.logical.dto.basepo.ModelBRole.PojoMapperModelBRole;
import com.shangde.ent_portal.logical.dto.basepo.ModelBUser.PojoMapperModelBUser;
import com.shangde.ent_portal.logical.dto.basepo.ModelTDevice.PojoMapperModelTDevice;
import com.shangde.ent_portal.logical.dto.basepo.ModelTEvent.PojoMapperModelTEvent;
import com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea.PojoMapperModelTMallArea;
import com.shangde.ent_portal.logical.dto.basepo.ModelTTask.PojoMapperModelTTask;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperBMaterial;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperBMenu;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperBOrgnizationUser;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperBRole;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperBUser;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperTDevice;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperTEvent;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperTMallArea;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperTTask;

public class Constants {
    public final static ResultSetMapperBOrgnizationUser<com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser> B_ORGNIZATION_USER_RESULT_SET_OBJ_MAPPER = new ResultSetMapperBOrgnizationUser<com.shangde.ent_portal.logical.dto.basepo.ModelBOrgnizationUser>();
    public final static PojoMapperModelBOrgnizationUser B_ORGNIZATION_USER_MAP_OBJ_MAPPER = new PojoMapperModelBOrgnizationUser();
    public final static ResultSetMapperBRole<com.shangde.ent_portal.logical.dto.basepo.ModelBRole> B_ROLE_RESULT_SET_OBJ_MAPPER = new ResultSetMapperBRole<com.shangde.ent_portal.logical.dto.basepo.ModelBRole>();
    public final static PojoMapperModelBRole B_ROLE_MAP_OBJ_MAPPER = new PojoMapperModelBRole();
    public final static ResultSetMapperBMaterial<com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial> B_MATERIAL_RESULT_SET_OBJ_MAPPER = new ResultSetMapperBMaterial<com.shangde.ent_portal.logical.dto.basepo.ModelBMaterial>();
    public final static PojoMapperModelBMaterial B_MATERIAL_MAP_OBJ_MAPPER = new PojoMapperModelBMaterial();
    public final static ResultSetMapperBMenu<com.shangde.ent_portal.logical.dto.basepo.ModelBMenu> B_MENU_RESULT_SET_OBJ_MAPPER = new ResultSetMapperBMenu<com.shangde.ent_portal.logical.dto.basepo.ModelBMenu>();
    public final static PojoMapperModelBMenu B_MENU_MAP_OBJ_MAPPER = new PojoMapperModelBMenu();
    public final static ResultSetMapperBUser<com.shangde.ent_portal.logical.dto.basepo.ModelBUser> B_USER_RESULT_SET_OBJ_MAPPER = new ResultSetMapperBUser<com.shangde.ent_portal.logical.dto.basepo.ModelBUser>();
    public final static PojoMapperModelBUser B_USER_MAP_OBJ_MAPPER = new PojoMapperModelBUser();
    public final static ResultSetMapperTMallArea<com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea> T_MALL_AREA_RESULT_SET_OBJ_MAPPER = new ResultSetMapperTMallArea<com.shangde.ent_portal.logical.dto.basepo.ModelTMallArea>();
    public final static PojoMapperModelTMallArea T_MALL_AREA_MAP_OBJ_MAPPER = new PojoMapperModelTMallArea();
    public final static ResultSetMapperTDevice<com.shangde.ent_portal.logical.dto.basepo.ModelTDevice> T_DEVICE_RESULT_SET_OBJ_MAPPER = new ResultSetMapperTDevice<com.shangde.ent_portal.logical.dto.basepo.ModelTDevice>();
    public final static PojoMapperModelTDevice T_DEVICE_MAP_OBJ_MAPPER = new PojoMapperModelTDevice();
    public final static ResultSetMapperTEvent<com.shangde.ent_portal.logical.dto.basepo.ModelTEvent> T_EVENT_RESULT_SET_OBJ_MAPPER = new ResultSetMapperTEvent<com.shangde.ent_portal.logical.dto.basepo.ModelTEvent>();
    public final static PojoMapperModelTEvent T_EVENT_MAP_OBJ_MAPPER = new PojoMapperModelTEvent();
    public final static ResultSetMapperTTask<com.shangde.ent_portal.logical.dto.basepo.ModelTTask> T_TASK_RESULT_SET_OBJ_MAPPER = new ResultSetMapperTTask<com.shangde.ent_portal.logical.dto.basepo.ModelTTask>();
    public final static PojoMapperModelTTask T_TASK_MAP_OBJ_MAPPER = new PojoMapperModelTTask();
}
