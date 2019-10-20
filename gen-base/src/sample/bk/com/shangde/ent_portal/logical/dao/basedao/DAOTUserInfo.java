package com.shangde.ent_portal.logical.dao.basedao;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;
import com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo.ResultSetMapperModelTUserInfo;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalOpType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.LogicalRelationshipType;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.db.impl.dao.AbstractDao;
import com.shawn.ss.lib.tools.db.impl.dao.DaoInterface;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.BaseMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLInsert;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo;

@Repository("DAOTUserInfo")
@SuppressWarnings("unchecked")
public class DAOTUserInfo
    extends AbstractDao<com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo, Integer>
    implements DaoInterface<com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo, Integer> , InitializingBean
{
    public final static Logger logger = LoggerFactory.getLogger(DAOTUserInfo.class);
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_store;
    protected final static Map<String, SimpleDbInterface> dbMap = CollectionHelper.newMap();
    public final static String dbOfEntPortalSlave = "ent_portal_slave";
    @Autowired(required = true)
    @Qualifier("ent_portal_slave")
    protected SimpleDbInterface data_storeEntPortalSlave;

    public DAOTUserInfo() {
        super(com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo.class);
    }

    @Override
    public void afterPropertiesSet()
        throws Exception
    {
        if (data_storeEntPortalSlave!= null) {
            dbMap.put(dbOfEntPortalSlave, data_storeEntPortalSlave);
        }
    }

    protected<TT> TT getSingleResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.getSingleResult(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected<TT> List<TT> getSingleResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param, Class<TT> tClass) {
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.getSingleResults(dbInstance, assembler, sqlBuilder, param, tClass);
    }

    protected List<ModelTUserInfo> getResults(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTUserInfo.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelTUserInfo<ModelTUserInfo> rsMapper = ModelTUserInfo.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTUserInfo<ModelTUserInfo> rsMapperTmp = ((ResultSetMapperModelTUserInfo<ModelTUserInfo> ) assembler.<ModelTUserInfo> assembleResultSetMapper(param, ModelTUserInfo.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResults(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected ModelTUserInfo getResult(DaoAssembler assembler, SQL<SQLSelect> sqlBuilder, Map<String, Object> param) {
        int status = 0;
        if (assembler!= null) {
            status = assembler.assembleSql(sqlBuilder, param, ModelTUserInfo.class);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        if (status == 0) {
            ResultSetMapperModelTUserInfo<ModelTUserInfo> rsMapper = ModelTUserInfo.RESULT_SET_OBJ_MAPPER;
            if (assembler!= null) {
                ResultSetMapperModelTUserInfo<ModelTUserInfo> rsMapperTmp = ((ResultSetMapperModelTUserInfo<ModelTUserInfo> ) assembler.<ModelTUserInfo> assembleResultSetMapper(param, ModelTUserInfo.class));
                if (rsMapperTmp!= null) {
                    rsMapper = rsMapperTmp;
                }
            }
            try {
                return super.getResult(dbInstance, assembler, sqlBuilder, param, rsMapper);
            } catch (final Exception ex) {
                logger.error("sql execption", ex);
                return null;
            }
        } else {
            return null;
        }
    }

    protected void buildInClause(SQLSelect sqlBuilder, String inField, Map<String, Object> param, List indexes) {
        if (ModelTUserInfo.FIELD_CLASS.containsKey(inField)) {
            Object fieldClassObj = ModelTUserInfo.FIELD_CLASS.get(inField);
            super.buildRawInCluase(sqlBuilder, param, inField, fieldClassObj, indexes);
        } else {
            logger.error("field parameter error");
            throw new IllegalArgumentException(((("there is mistake with infield parameter, column "+ inField)+" not found in table ")+ com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo.DTO_TABLE_NAME));
        }
    }

    protected void buildConditionCluase(SQLSelect<SQLSelect> sqlBuilder, ModelTUserInfo instance, Map<String, Object> param) {
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_ID, ColumnDataType.intData);
            param.put(ModelTUserInfo.FI_ID, dId);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_MOBILE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_MOBILE, dMobile);
        }
        String dEmail = instance.getEmail();
        if (dEmail!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_EMAIL, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_EMAIL, dEmail);
        }
        String dUsername = instance.getUsername();
        if (dUsername!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_USERNAME, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_USERNAME, dUsername);
        }
        String dNickname = instance.getNickname();
        if (dNickname!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_NICKNAME, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_NICKNAME, dNickname);
        }
        String dSex = instance.getSex();
        if (dSex!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_SEX, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_SEX, dSex);
        }
        String dEducation = instance.getEducation();
        if (dEducation!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_EDUCATION, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_EDUCATION, dEducation);
        }
        String dCert_type = instance.getCertType();
        if (dCert_type!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_CERT_TYPE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_CERT_TYPE, dCert_type);
        }
        String dCert_no = instance.getCertNo();
        if (dCert_no!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_CERT_NO, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_CERT_NO, dCert_no);
        }
        String dPhone = instance.getPhone();
        if (dPhone!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_PHONE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_PHONE, dPhone);
        }
        Date dBirthday = instance.getBirthday();
        if (dBirthday!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_BIRTHDAY, ColumnDataType.dateData);
            param.put(ModelTUserInfo.FI_BIRTHDAY, dBirthday);
        }
        Date dApply_date = instance.getApplyDate();
        if (dApply_date!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_APPLY_DATE, ColumnDataType.dateData);
            param.put(ModelTUserInfo.FI_APPLY_DATE, dApply_date);
        }
        String dUrgent_linker = instance.getUrgentLinker();
        if (dUrgent_linker!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_URGENT_LINKER, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_URGENT_LINKER, dUrgent_linker);
        }
        String dUrgent_mobile = instance.getUrgentMobile();
        if (dUrgent_mobile!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_URGENT_MOBILE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_URGENT_MOBILE, dUrgent_mobile);
        }
        String dPassword = instance.getPassword();
        if (dPassword!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_PASSWORD, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_PASSWORD, dPassword);
        }
        String dState = instance.getState();
        if (dState!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_STATE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_STATE, dState);
        }
        String dProvince = instance.getProvince();
        if (dProvince!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_PROVINCE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_PROVINCE, dProvince);
        }
        String dCity = instance.getCity();
        if (dCity!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_CITY, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_CITY, dCity);
        }
        String dReg_time = instance.getRegTime();
        if (dReg_time!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_REG_TIME, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_REG_TIME, dReg_time);
        }
        String dCreator = instance.getCreator();
        if (dCreator!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_CREATOR, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_CREATOR, dCreator);
        }
        String dSchool = instance.getSchool();
        if (dSchool!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_SCHOOL, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_SCHOOL, dSchool);
        }
        Integer dAdd_type = instance.getAddType();
        if (dAdd_type!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_ADD_TYPE, ColumnDataType.intData);
            param.put(ModelTUserInfo.FI_ADD_TYPE, dAdd_type);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
            param.put(ModelTUserInfo.FI_UPDATE_TIME, dUpdate_time);
        }
        String dQq_code = instance.getQqCode();
        if (dQq_code!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_QQ_CODE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_QQ_CODE, dQq_code);
        }
        String dLevel_remark = instance.getLevelRemark();
        if (dLevel_remark!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_LEVEL_REMARK, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_LEVEL_REMARK, dLevel_remark);
        }
        String dReg_servicePage = instance.getRegServicePage();
        if (dReg_servicePage!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_REG_SERVICEPAGE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_REG_SERVICEPAGE, dReg_servicePage);
        }
        String dReg_landingPage = instance.getRegLandingPage();
        if (dReg_landingPage!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_REG_LANDINGPAGE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_REG_LANDINGPAGE, dReg_landingPage);
        }
        Byte dSync_bbs = instance.getSyncBbs();
        if (dSync_bbs!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_SYNC_BBS, ColumnDataType.byteData);
            param.put(ModelTUserInfo.FI_SYNC_BBS, dSync_bbs);
        }
        String dNickname_bbs = instance.getNicknameBbs();
        if (dNickname_bbs!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_NICKNAME_BBS, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_NICKNAME_BBS, dNickname_bbs);
        }
        String dExam_province = instance.getExamProvince();
        if (dExam_province!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_EXAM_PROVINCE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_EXAM_PROVINCE, dExam_province);
        }
        Integer dHadiths_user_id = instance.getHadithsUserId();
        if (dHadiths_user_id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_HADITHS_USER_ID, ColumnDataType.intData);
            param.put(ModelTUserInfo.FI_HADITHS_USER_ID, dHadiths_user_id);
        }
        Integer dMaterial_province = instance.getMaterialProvince();
        if (dMaterial_province!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_MATERIAL_PROVINCE, ColumnDataType.intData);
            param.put(ModelTUserInfo.FI_MATERIAL_PROVINCE, dMaterial_province);
        }
        Integer dHuluo_user_id = instance.getHuluoUserId();
        if (dHuluo_user_id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_HULUO_USER_ID, ColumnDataType.intData);
            param.put(ModelTUserInfo.FI_HULUO_USER_ID, dHuluo_user_id);
        }
        String dReferer = instance.getReferer();
        if (dReferer!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_REFERER, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_REFERER, dReferer);
        }
        String dImage_url = instance.getImageUrl();
        if (dImage_url!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_IMAGE_URL, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_IMAGE_URL, dImage_url);
        }
        String dHome_phone = instance.getHomePhone();
        if (dHome_phone!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_HOME_PHONE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_HOME_PHONE, dHome_phone);
        }
        String dOffice_phone = instance.getOfficePhone();
        if (dOffice_phone!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_OFFICE_PHONE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_OFFICE_PHONE, dOffice_phone);
        }
        String dWeixin_id = instance.getWeixinId();
        if (dWeixin_id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_WEIXIN_ID, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_WEIXIN_ID, dWeixin_id);
        }
        String dEmergency_rel = instance.getEmergencyRel();
        if (dEmergency_rel!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_EMERGENCY_REL, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_EMERGENCY_REL, dEmergency_rel);
        }
        String dAddress = instance.getAddress();
        if (dAddress!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_ADDRESS, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_ADDRESS, dAddress);
        }
        String dPostcode = instance.getPostcode();
        if (dPostcode!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_POSTCODE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_POSTCODE, dPostcode);
        }
        String dProfession = instance.getProfession();
        if (dProfession!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_PROFESSION, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_PROFESSION, dProfession);
        }
        Date dWork_year = instance.getWorkYear();
        if (dWork_year!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_WORK_YEAR, ColumnDataType.dateData);
            param.put(ModelTUserInfo.FI_WORK_YEAR, dWork_year);
        }
        String dQt_cert = instance.getQtCert();
        if (dQt_cert!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_QT_CERT, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_QT_CERT, dQt_cert);
        }
        String dTraining_cert = instance.getTrainingCert();
        if (dTraining_cert!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_TRAINING_CERT, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_TRAINING_CERT, dTraining_cert);
        }
        String dRemark = instance.getRemark();
        if (dRemark!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_REMARK, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_REMARK, dRemark);
        }
        String dGraduate_academy = instance.getGraduateAcademy();
        if (dGraduate_academy!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_GRADUATE_ACADEMY, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_GRADUATE_ACADEMY, dGraduate_academy);
        }
        String dIndustry = instance.getIndustry();
        if (dIndustry!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_INDUSTRY, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_INDUSTRY, dIndustry);
        }
        String dOperator_id = instance.getOperatorId();
        if (dOperator_id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_OPERATOR_ID, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_OPERATOR_ID, dOperator_id);
        }
        String dFirst_project_ids = instance.getFirstProjectIds();
        if (dFirst_project_ids!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_FIRST_PROJECT_IDS, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_FIRST_PROJECT_IDS, dFirst_project_ids);
        }
        String dSignature = instance.getSignature();
        if (dSignature!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_SIGNATURE, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_SIGNATURE, dSignature);
        }
        Long dIm_user_id = instance.getImUserId();
        if (dIm_user_id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_IM_USER_ID, ColumnDataType.longData);
            param.put(ModelTUserInfo.FI_IM_USER_ID, dIm_user_id);
        }
        String dConstellation = instance.getConstellation();
        if (dConstellation!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_CONSTELLATION, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_CONSTELLATION, dConstellation);
        }
        String dHobby = instance.getHobby();
        if (dHobby!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_HOBBY, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_HOBBY, dHobby);
        }
        Byte dShow_academy = instance.getShowAcademy();
        if (dShow_academy!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_SHOW_ACADEMY, ColumnDataType.byteData);
            param.put(ModelTUserInfo.FI_SHOW_ACADEMY, dShow_academy);
        }
        String dEmail_263 = instance.getEmail263();
        if (dEmail_263 != null) {
            sqlBuilder.where(ModelTUserInfo.FI_EMAIL_263, ColumnDataType.stringData);
            param.put(ModelTUserInfo.FI_EMAIL_263, dEmail_263);
        }
        Date dCreate_time_of_user = instance.getCreateTimeOfUser();
        if (dCreate_time_of_user!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_CREATE_TIME_OF_USER, ColumnDataType.timeStampData);
            param.put(ModelTUserInfo.FI_CREATE_TIME_OF_USER, dCreate_time_of_user);
        }
    }

    protected void buildSelectFieldCluase(SQLSelect<SQLSelect> sqlBuilder, Set<String> selectFields) {
        if (selectFields.contains(ModelTUserInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_ID);
        }
        if (selectFields.contains(ModelTUserInfo.FI_MOBILE)) {
            sqlBuilder.items(ModelTUserInfo.FI_MOBILE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_EMAIL)) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL);
        }
        if (selectFields.contains(ModelTUserInfo.FI_USERNAME)) {
            sqlBuilder.items(ModelTUserInfo.FI_USERNAME);
        }
        if (selectFields.contains(ModelTUserInfo.FI_NICKNAME)) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME);
        }
        if (selectFields.contains(ModelTUserInfo.FI_SEX)) {
            sqlBuilder.items(ModelTUserInfo.FI_SEX);
        }
        if (selectFields.contains(ModelTUserInfo.FI_EDUCATION)) {
            sqlBuilder.items(ModelTUserInfo.FI_EDUCATION);
        }
        if (selectFields.contains(ModelTUserInfo.FI_CERT_TYPE)) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_TYPE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_CERT_NO)) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_NO);
        }
        if (selectFields.contains(ModelTUserInfo.FI_PHONE)) {
            sqlBuilder.items(ModelTUserInfo.FI_PHONE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_BIRTHDAY)) {
            sqlBuilder.items(ModelTUserInfo.FI_BIRTHDAY);
        }
        if (selectFields.contains(ModelTUserInfo.FI_APPLY_DATE)) {
            sqlBuilder.items(ModelTUserInfo.FI_APPLY_DATE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_LINKER);
        }
        if (selectFields.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_MOBILE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_PASSWORD)) {
            sqlBuilder.items(ModelTUserInfo.FI_PASSWORD);
        }
        if (selectFields.contains(ModelTUserInfo.FI_STATE)) {
            sqlBuilder.items(ModelTUserInfo.FI_STATE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_PROVINCE)) {
            sqlBuilder.items(ModelTUserInfo.FI_PROVINCE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_CITY)) {
            sqlBuilder.items(ModelTUserInfo.FI_CITY);
        }
        if (selectFields.contains(ModelTUserInfo.FI_REG_TIME)) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_TIME);
        }
        if (selectFields.contains(ModelTUserInfo.FI_CREATOR)) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATOR);
        }
        if (selectFields.contains(ModelTUserInfo.FI_SCHOOL)) {
            sqlBuilder.items(ModelTUserInfo.FI_SCHOOL);
        }
        if (selectFields.contains(ModelTUserInfo.FI_ADD_TYPE)) {
            sqlBuilder.items(ModelTUserInfo.FI_ADD_TYPE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
            sqlBuilder.items(ModelTUserInfo.FI_UPDATE_TIME);
        }
        if (selectFields.contains(ModelTUserInfo.FI_QQ_CODE)) {
            sqlBuilder.items(ModelTUserInfo.FI_QQ_CODE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
            sqlBuilder.items(ModelTUserInfo.FI_LEVEL_REMARK);
        }
        if (selectFields.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_SERVICEPAGE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_LANDINGPAGE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_SYNC_BBS)) {
            sqlBuilder.items(ModelTUserInfo.FI_SYNC_BBS);
        }
        if (selectFields.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME_BBS);
        }
        if (selectFields.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
            sqlBuilder.items(ModelTUserInfo.FI_EXAM_PROVINCE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_HADITHS_USER_ID);
        }
        if (selectFields.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
            sqlBuilder.items(ModelTUserInfo.FI_MATERIAL_PROVINCE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_HULUO_USER_ID);
        }
        if (selectFields.contains(ModelTUserInfo.FI_REFERER)) {
            sqlBuilder.items(ModelTUserInfo.FI_REFERER);
        }
        if (selectFields.contains(ModelTUserInfo.FI_IMAGE_URL)) {
            sqlBuilder.items(ModelTUserInfo.FI_IMAGE_URL);
        }
        if (selectFields.contains(ModelTUserInfo.FI_HOME_PHONE)) {
            sqlBuilder.items(ModelTUserInfo.FI_HOME_PHONE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
            sqlBuilder.items(ModelTUserInfo.FI_OFFICE_PHONE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_WEIXIN_ID);
        }
        if (selectFields.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
            sqlBuilder.items(ModelTUserInfo.FI_EMERGENCY_REL);
        }
        if (selectFields.contains(ModelTUserInfo.FI_ADDRESS)) {
            sqlBuilder.items(ModelTUserInfo.FI_ADDRESS);
        }
        if (selectFields.contains(ModelTUserInfo.FI_POSTCODE)) {
            sqlBuilder.items(ModelTUserInfo.FI_POSTCODE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_PROFESSION)) {
            sqlBuilder.items(ModelTUserInfo.FI_PROFESSION);
        }
        if (selectFields.contains(ModelTUserInfo.FI_WORK_YEAR)) {
            sqlBuilder.items(ModelTUserInfo.FI_WORK_YEAR);
        }
        if (selectFields.contains(ModelTUserInfo.FI_QT_CERT)) {
            sqlBuilder.items(ModelTUserInfo.FI_QT_CERT);
        }
        if (selectFields.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
            sqlBuilder.items(ModelTUserInfo.FI_TRAINING_CERT);
        }
        if (selectFields.contains(ModelTUserInfo.FI_REMARK)) {
            sqlBuilder.items(ModelTUserInfo.FI_REMARK);
        }
        if (selectFields.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
            sqlBuilder.items(ModelTUserInfo.FI_GRADUATE_ACADEMY);
        }
        if (selectFields.contains(ModelTUserInfo.FI_INDUSTRY)) {
            sqlBuilder.items(ModelTUserInfo.FI_INDUSTRY);
        }
        if (selectFields.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_OPERATOR_ID);
        }
        if (selectFields.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
            sqlBuilder.items(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
        }
        if (selectFields.contains(ModelTUserInfo.FI_SIGNATURE)) {
            sqlBuilder.items(ModelTUserInfo.FI_SIGNATURE);
        }
        if (selectFields.contains(ModelTUserInfo.FI_IM_USER_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_IM_USER_ID);
        }
        if (selectFields.contains(ModelTUserInfo.FI_CONSTELLATION)) {
            sqlBuilder.items(ModelTUserInfo.FI_CONSTELLATION);
        }
        if (selectFields.contains(ModelTUserInfo.FI_HOBBY)) {
            sqlBuilder.items(ModelTUserInfo.FI_HOBBY);
        }
        if (selectFields.contains(ModelTUserInfo.FI_SHOW_ACADEMY)) {
            sqlBuilder.items(ModelTUserInfo.FI_SHOW_ACADEMY);
        }
        if (selectFields.contains(ModelTUserInfo.FI_EMAIL_263)) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL_263);
        }
        if (selectFields.contains(ModelTUserInfo.FI_CREATE_TIME_OF_USER)) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATE_TIME_OF_USER);
        }
    }

    public List<ModelTUserInfo> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> get(Set<String> selectFields, Integer start, Integer count) {
        return get(selectFields, null, start, count);
    }

    public List<ModelTUserInfo> get(Integer start, Integer count) {
        return get(null, start, count);
    }

    public List<ModelTUserInfo> get() {
        return get(null, null);
    }

    public List<ModelTUserInfo> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Integer> id) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserInfo.FI_ID, ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getById(Set<String> selectFields, Integer start, Integer count, List<Integer> id) {
        return getById(selectFields, null, start, count, id);
    }

    public List<ModelTUserInfo> getById(Integer start, Integer count, List<Integer> id) {
        return getById(null, start, count, id);
    }

    public List<ModelTUserInfo> getById(List<Integer> id) {
        return getById(null, null, id);
    }

    public List<ModelTUserInfo> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes) {
        return getByIndex(selectFields, null, start, count, inField, indexes);
    }

    public List<ModelTUserInfo> getByIndex(Integer start, Integer count, String inField, List indexes) {
        return getByIndex(null, start, count, inField, indexes);
    }

    public List<ModelTUserInfo> getByIndex(String inField, List indexes) {
        return getByIndex(null, null, inField, indexes);
    }

    public List<ModelTUserInfo> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByCond(Set<String> selectFields, Integer start, Integer count, ModelTUserInfo instance) {
        return getByCond(selectFields, null, start, count, instance);
    }

    public List<ModelTUserInfo> getByCond(Integer start, Integer count, ModelTUserInfo instance) {
        return getByCond(null, start, count, instance);
    }

    public List<ModelTUserInfo> getByCond(ModelTUserInfo instance) {
        return getByCond(null, null, instance);
    }

    public List<ModelTUserInfo> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(selectFields, null, start, count, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, start, count, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getByWhere(null, null, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes) {
        return getByCondAndIndex(selectFields, null, start, count, instance, inField, indexes);
    }

    public List<ModelTUserInfo> getByCondAndIndex(Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes) {
        return getByCondAndIndex(null, start, count, instance, inField, indexes);
    }

    public List<ModelTUserInfo> getByCondAndIndex(ModelTUserInfo instance, String inField, List indexes) {
        return getByCondAndIndex(null, null, instance, inField, indexes);
    }

    public List<ModelTUserInfo> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserInfo.FI_ID, ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(selectFields, null, start, count, id, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIdAndWhere(Integer start, Integer count, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, start, count, id, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIdAndWhere(Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndWhere(null, null, id, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserInfo.FI_ID, ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTUserInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(selectFields, null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIdAndCondAndWhere(Integer start, Integer count, ModelTUserInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, start, count, instance, id, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIdAndCondAndWhere(ModelTUserInfo instance, List<Integer> id, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIdAndCondAndWhere(null, null, instance, id, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(selectFields, null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, start, count, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByIndexAndWhere(null, null, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(selectFields, null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndWhere(Integer start, Integer count, ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, start, count, instance, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndWhere(ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndWhere(null, null, instance, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getResults(assembler, sqlBuilder, param);
    }

    public List<ModelTUserInfo> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(selectFields, null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndIndexAndWhere(Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, start, count, instance, inField, indexes, extParam, extCondition);
    }

    public List<ModelTUserInfo> getByCondAndIndexAndWhere(ModelTUserInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getByCondAndIndexAndWhere(null, null, instance, inField, indexes, extParam, extCondition);
    }

    public ModelTUserInfo getOneById(Set<String> selectFields, DaoAssembler assembler, Integer id) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUserInfo getOneById(Set<String> selectFields, Integer id) {
        return getOneById(selectFields, null, id);
    }

    public ModelTUserInfo getOneById(Integer id) {
        return getOneById(null, id);
    }

    public ModelTUserInfo getOneByCond(Set<String> selectFields, DaoAssembler assembler, ModelTUserInfo instance) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUserInfo getOneByCond(Set<String> selectFields, ModelTUserInfo instance) {
        return getOneByCond(selectFields, null, instance);
    }

    public ModelTUserInfo getOneByCond(ModelTUserInfo instance) {
        return getOneByCond(null, instance);
    }

    public ModelTUserInfo getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUserInfo getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(selectFields, null, extParam, extCondition);
    }

    public ModelTUserInfo getOneByWhere(Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByWhere(null, extParam, extCondition);
    }

    public ModelTUserInfo getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUserInfo getOneByCondAndWhere(Set<String> selectFields, ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(selectFields, null, instance, extParam, extCondition);
    }

    public ModelTUserInfo getOneByCondAndWhere(ModelTUserInfo instance, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByCondAndWhere(null, instance, extParam, extCondition);
    }

    public ModelTUserInfo getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, ModelTUserInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        if (selectFields == null) {
            selectFields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        buildConditionCluase(sqlBuilder, instance, param);
        buildSelectFieldCluase(sqlBuilder, selectFields);
        if (id!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return getResult(assembler, sqlBuilder, param);
    }

    public ModelTUserInfo getOneByIdAndCondAndWhere(Set<String> selectFields, ModelTUserInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(selectFields, null, instance, id, extParam, extCondition);
    }

    public ModelTUserInfo getOneByIdAndCondAndWhere(ModelTUserInfo instance, Integer id, Map<String, Object> extParam, Set<String> extCondition) {
        return getOneByIdAndCondAndWhere(null, instance, id, extParam, extCondition);
    }

    public Long getCountByCond(DaoAssembler assembler, ModelTUserInfo instance) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCond(ModelTUserInfo instance) {
        return getCountByCond(null, instance);
    }

    public Long getCountByCondAndIndex(DaoAssembler assembler, ModelTUserInfo instance, String inField, List indexes) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndex(ModelTUserInfo instance, String inField, List indexes) {
        return getCountByCondAndIndex(null, instance, inField, indexes);
    }

    public Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, ModelTUserInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        sqlBuilder.funcItems("count", "count");
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return getSingleResult(assembler, sqlBuilder, param, Long.class);
    }

    public Long getCountByCondAndIndexAndWhere(ModelTUserInfo instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition) {
        return getCountByCondAndIndexAndWhere(null, instance, inField, indexes, extParam, extCondition);
    }

    public<TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByIndex(null, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByWhere(null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> TT getItemByCond(DaoAssembler assembler, ModelTUserInfo instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCond(ModelTUserInfo instance, Class<TT> tClass, String rawItem) {
        return getItemByCond(null, instance, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndex(DaoAssembler assembler, ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndex(ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemByCondAndIndex(null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer start = 0;
        Integer count = 1;
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((TT) getSingleResult(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> TT getItemByCondAndIndexAndWhere(ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemByCondAndIndexAndWhere(null, instance, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, start, count, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByIndex(null, null, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, ModelTUserInfo instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, start, count, instance, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCond(ModelTUserInfo instance, Class<TT> tClass, String rawItem) {
        return getItemListByCond(null, null, instance, tClass, rawItem);
    }

    public<TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserInfo.FI_ID, ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListById(Integer start, Integer count, Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, start, count, id, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListById(Integer id, Class<TT> tClass, String rawItem) {
        return getItemListById(null, null, id, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, start, count, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByWhere(null, null, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, start, count, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIndexAndWhere(null, null, inField, indexes, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, ModelTUserInfo instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, start, count, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByCondAndWhere(ModelTUserInfo instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByCondAndWhere(null, null, instance, tClass, rawItem, extParam, extCondition);
    }

    public<TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        buildInClause(sqlBuilder, inField, param, indexes);
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, start, count, instance, inField, indexes, tClass, rawItem);
    }

    public<TT extends Object> List<TT> getItemListByCondAndIndex(ModelTUserInfo instance, String inField, List indexes, Class<TT> tClass, String rawItem) {
        return getItemListByCondAndIndex(null, null, instance, inField, indexes, tClass, rawItem);
    }

    public<TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, ModelTUserInfo instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        SQLSelect<SQLSelect> sqlBuilder = SQL.buildSelectSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (start == null) {
            start = AbstractBaseModel.DEFAULT_START;
        }
        if (count == null) {
            count = AbstractBaseModel.DEFUALT_COUNT;
        }
        Map<String, Object> param = CollectionHelper.newMap();
        param.put(DaoInterface.KEY_WORD_LIMIT_START, start);
        param.put(DaoInterface.KEY_WORD_LIMIT_COUNT, count);
        super.buildRawWhere(sqlBuilder, param, extParam, extCondition);
        assert((tClass!= null));
        assert(((rawItem!= null)&&(rawItem.length()> 0)));
        sqlBuilder.rawItem(rawItem);
        buildConditionCluase(sqlBuilder, instance, param);
        if (id!= null) {
            sqlBuilder.where(LogicalRelationshipType.and, LogicalOpType.in, null, ModelTUserInfo.FI_ID, ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        sqlBuilder.setLimit();
        return ((List<TT> ) getSingleResults(assembler, sqlBuilder, param, tClass));
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, ModelTUserInfo instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, start, count, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public<TT extends Object> List<TT> getItemListByIdAndCondAndWhere(ModelTUserInfo instance, List<Integer> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition) {
        return getItemListByIdAndCondAndWhere(null, null, instance, id, tClass, rawItem, extParam, extCondition);
    }

    public ModelTUserInfo insert(ModelTUserInfo instance, DaoAssembler assembler) {
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ID);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_MOBILE);
        }
        String dEmail = instance.getEmail();
        if (dEmail!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL);
        }
        String dUsername = instance.getUsername();
        if (dUsername!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_USERNAME);
        }
        String dNickname = instance.getNickname();
        if (dNickname!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME);
        }
        String dSex = instance.getSex();
        if (dSex!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SEX);
        }
        String dEducation = instance.getEducation();
        if (dEducation!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EDUCATION);
        }
        String dCert_type = instance.getCertType();
        if (dCert_type!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_TYPE);
        }
        String dCert_no = instance.getCertNo();
        if (dCert_no!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_NO);
        }
        String dPhone = instance.getPhone();
        if (dPhone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PHONE);
        }
        Date dBirthday = instance.getBirthday();
        if (dBirthday!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_BIRTHDAY);
        }
        Date dApply_date = instance.getApplyDate();
        if (dApply_date!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_APPLY_DATE);
        }
        String dUrgent_linker = instance.getUrgentLinker();
        if (dUrgent_linker!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_LINKER);
        }
        String dUrgent_mobile = instance.getUrgentMobile();
        if (dUrgent_mobile!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_MOBILE);
        }
        String dPassword = instance.getPassword();
        if (dPassword!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PASSWORD);
        }
        String dState = instance.getState();
        if (dState!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_STATE);
        }
        String dProvince = instance.getProvince();
        if (dProvince!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PROVINCE);
        }
        String dCity = instance.getCity();
        if (dCity!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CITY);
        }
        String dReg_time = instance.getRegTime();
        if (dReg_time!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_TIME);
        }
        String dCreator = instance.getCreator();
        if (dCreator!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATOR);
        }
        String dSchool = instance.getSchool();
        if (dSchool!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SCHOOL);
        }
        Integer dAdd_type = instance.getAddType();
        if (dAdd_type!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ADD_TYPE);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_UPDATE_TIME);
        }
        String dQq_code = instance.getQqCode();
        if (dQq_code!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_QQ_CODE);
        }
        String dLevel_remark = instance.getLevelRemark();
        if (dLevel_remark!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_LEVEL_REMARK);
        }
        String dReg_servicePage = instance.getRegServicePage();
        if (dReg_servicePage!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_SERVICEPAGE);
        }
        String dReg_landingPage = instance.getRegLandingPage();
        if (dReg_landingPage!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_LANDINGPAGE);
        }
        Byte dSync_bbs = instance.getSyncBbs();
        if (dSync_bbs!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SYNC_BBS);
        }
        String dNickname_bbs = instance.getNicknameBbs();
        if (dNickname_bbs!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME_BBS);
        }
        String dExam_province = instance.getExamProvince();
        if (dExam_province!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EXAM_PROVINCE);
        }
        Integer dHadiths_user_id = instance.getHadithsUserId();
        if (dHadiths_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HADITHS_USER_ID);
        }
        Integer dMaterial_province = instance.getMaterialProvince();
        if (dMaterial_province!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_MATERIAL_PROVINCE);
        }
        Integer dHuluo_user_id = instance.getHuluoUserId();
        if (dHuluo_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HULUO_USER_ID);
        }
        String dReferer = instance.getReferer();
        if (dReferer!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REFERER);
        }
        String dImage_url = instance.getImageUrl();
        if (dImage_url!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_IMAGE_URL);
        }
        String dHome_phone = instance.getHomePhone();
        if (dHome_phone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HOME_PHONE);
        }
        String dOffice_phone = instance.getOfficePhone();
        if (dOffice_phone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_OFFICE_PHONE);
        }
        String dWeixin_id = instance.getWeixinId();
        if (dWeixin_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_WEIXIN_ID);
        }
        String dEmergency_rel = instance.getEmergencyRel();
        if (dEmergency_rel!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMERGENCY_REL);
        }
        String dAddress = instance.getAddress();
        if (dAddress!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ADDRESS);
        }
        String dPostcode = instance.getPostcode();
        if (dPostcode!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_POSTCODE);
        }
        String dProfession = instance.getProfession();
        if (dProfession!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PROFESSION);
        }
        Date dWork_year = instance.getWorkYear();
        if (dWork_year!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_WORK_YEAR);
        }
        String dQt_cert = instance.getQtCert();
        if (dQt_cert!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_QT_CERT);
        }
        String dTraining_cert = instance.getTrainingCert();
        if (dTraining_cert!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_TRAINING_CERT);
        }
        String dRemark = instance.getRemark();
        if (dRemark!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REMARK);
        }
        String dGraduate_academy = instance.getGraduateAcademy();
        if (dGraduate_academy!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_GRADUATE_ACADEMY);
        }
        String dIndustry = instance.getIndustry();
        if (dIndustry!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_INDUSTRY);
        }
        String dOperator_id = instance.getOperatorId();
        if (dOperator_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_OPERATOR_ID);
        }
        String dFirst_project_ids = instance.getFirstProjectIds();
        if (dFirst_project_ids!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
        }
        String dSignature = instance.getSignature();
        if (dSignature!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SIGNATURE);
        }
        Long dIm_user_id = instance.getImUserId();
        if (dIm_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_IM_USER_ID);
        }
        String dConstellation = instance.getConstellation();
        if (dConstellation!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CONSTELLATION);
        }
        String dHobby = instance.getHobby();
        if (dHobby!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HOBBY);
        }
        Byte dShow_academy = instance.getShowAcademy();
        if (dShow_academy!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SHOW_ACADEMY);
        }
        String dEmail_263 = instance.getEmail263();
        if (dEmail_263 != null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL_263);
        }
        Date dCreate_time_of_user = instance.getCreateTimeOfUser();
        if (dCreate_time_of_user!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATE_TIME_OF_USER);
        }
        Map<String, Object> param = ModelTUserInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        Long ret = super.insert(dbInstance, assembler, sqlBuilder, param);
        if (ret!= null) {
            if (ret >Long.MIN_VALUE) {
                instance.setId(((Integer) TypeConstantHelper.testPackPrType(ret, Integer.class)));
                return instance;
            } else {
                return instance;
            }
        } else {
            return null;
        }
    }

    public ModelTUserInfo insert(ModelTUserInfo instance) {
        return insert(instance, null);
    }

    public Integer insert(List<ModelTUserInfo> instances, Set<String> fields, DaoAssembler assembler) {
        if (fields == null) {
            fields = ModelTUserInfo.FIELD_CLASS.keySet();
        }
        SQLInsert sqlBuilder = SQL.buildInsertSql(ModelTUserInfo.DTO_TABLE_NAME);
        if (fields.contains(ModelTUserInfo.FI_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_ID);
        }
        if (fields.contains(ModelTUserInfo.FI_MOBILE)) {
            sqlBuilder.items(ModelTUserInfo.FI_MOBILE);
        }
        if (fields.contains(ModelTUserInfo.FI_EMAIL)) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL);
        }
        if (fields.contains(ModelTUserInfo.FI_USERNAME)) {
            sqlBuilder.items(ModelTUserInfo.FI_USERNAME);
        }
        if (fields.contains(ModelTUserInfo.FI_NICKNAME)) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME);
        }
        if (fields.contains(ModelTUserInfo.FI_SEX)) {
            sqlBuilder.items(ModelTUserInfo.FI_SEX);
        }
        if (fields.contains(ModelTUserInfo.FI_EDUCATION)) {
            sqlBuilder.items(ModelTUserInfo.FI_EDUCATION);
        }
        if (fields.contains(ModelTUserInfo.FI_CERT_TYPE)) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_TYPE);
        }
        if (fields.contains(ModelTUserInfo.FI_CERT_NO)) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_NO);
        }
        if (fields.contains(ModelTUserInfo.FI_PHONE)) {
            sqlBuilder.items(ModelTUserInfo.FI_PHONE);
        }
        if (fields.contains(ModelTUserInfo.FI_BIRTHDAY)) {
            sqlBuilder.items(ModelTUserInfo.FI_BIRTHDAY);
        }
        if (fields.contains(ModelTUserInfo.FI_APPLY_DATE)) {
            sqlBuilder.items(ModelTUserInfo.FI_APPLY_DATE);
        }
        if (fields.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_LINKER);
        }
        if (fields.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_MOBILE);
        }
        if (fields.contains(ModelTUserInfo.FI_PASSWORD)) {
            sqlBuilder.items(ModelTUserInfo.FI_PASSWORD);
        }
        if (fields.contains(ModelTUserInfo.FI_STATE)) {
            sqlBuilder.items(ModelTUserInfo.FI_STATE);
        }
        if (fields.contains(ModelTUserInfo.FI_PROVINCE)) {
            sqlBuilder.items(ModelTUserInfo.FI_PROVINCE);
        }
        if (fields.contains(ModelTUserInfo.FI_CITY)) {
            sqlBuilder.items(ModelTUserInfo.FI_CITY);
        }
        if (fields.contains(ModelTUserInfo.FI_REG_TIME)) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_TIME);
        }
        if (fields.contains(ModelTUserInfo.FI_CREATOR)) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATOR);
        }
        if (fields.contains(ModelTUserInfo.FI_SCHOOL)) {
            sqlBuilder.items(ModelTUserInfo.FI_SCHOOL);
        }
        if (fields.contains(ModelTUserInfo.FI_ADD_TYPE)) {
            sqlBuilder.items(ModelTUserInfo.FI_ADD_TYPE);
        }
        if (fields.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
            sqlBuilder.items(ModelTUserInfo.FI_UPDATE_TIME);
        }
        if (fields.contains(ModelTUserInfo.FI_QQ_CODE)) {
            sqlBuilder.items(ModelTUserInfo.FI_QQ_CODE);
        }
        if (fields.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
            sqlBuilder.items(ModelTUserInfo.FI_LEVEL_REMARK);
        }
        if (fields.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_SERVICEPAGE);
        }
        if (fields.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_LANDINGPAGE);
        }
        if (fields.contains(ModelTUserInfo.FI_SYNC_BBS)) {
            sqlBuilder.items(ModelTUserInfo.FI_SYNC_BBS);
        }
        if (fields.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME_BBS);
        }
        if (fields.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
            sqlBuilder.items(ModelTUserInfo.FI_EXAM_PROVINCE);
        }
        if (fields.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_HADITHS_USER_ID);
        }
        if (fields.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
            sqlBuilder.items(ModelTUserInfo.FI_MATERIAL_PROVINCE);
        }
        if (fields.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_HULUO_USER_ID);
        }
        if (fields.contains(ModelTUserInfo.FI_REFERER)) {
            sqlBuilder.items(ModelTUserInfo.FI_REFERER);
        }
        if (fields.contains(ModelTUserInfo.FI_IMAGE_URL)) {
            sqlBuilder.items(ModelTUserInfo.FI_IMAGE_URL);
        }
        if (fields.contains(ModelTUserInfo.FI_HOME_PHONE)) {
            sqlBuilder.items(ModelTUserInfo.FI_HOME_PHONE);
        }
        if (fields.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
            sqlBuilder.items(ModelTUserInfo.FI_OFFICE_PHONE);
        }
        if (fields.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_WEIXIN_ID);
        }
        if (fields.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
            sqlBuilder.items(ModelTUserInfo.FI_EMERGENCY_REL);
        }
        if (fields.contains(ModelTUserInfo.FI_ADDRESS)) {
            sqlBuilder.items(ModelTUserInfo.FI_ADDRESS);
        }
        if (fields.contains(ModelTUserInfo.FI_POSTCODE)) {
            sqlBuilder.items(ModelTUserInfo.FI_POSTCODE);
        }
        if (fields.contains(ModelTUserInfo.FI_PROFESSION)) {
            sqlBuilder.items(ModelTUserInfo.FI_PROFESSION);
        }
        if (fields.contains(ModelTUserInfo.FI_WORK_YEAR)) {
            sqlBuilder.items(ModelTUserInfo.FI_WORK_YEAR);
        }
        if (fields.contains(ModelTUserInfo.FI_QT_CERT)) {
            sqlBuilder.items(ModelTUserInfo.FI_QT_CERT);
        }
        if (fields.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
            sqlBuilder.items(ModelTUserInfo.FI_TRAINING_CERT);
        }
        if (fields.contains(ModelTUserInfo.FI_REMARK)) {
            sqlBuilder.items(ModelTUserInfo.FI_REMARK);
        }
        if (fields.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
            sqlBuilder.items(ModelTUserInfo.FI_GRADUATE_ACADEMY);
        }
        if (fields.contains(ModelTUserInfo.FI_INDUSTRY)) {
            sqlBuilder.items(ModelTUserInfo.FI_INDUSTRY);
        }
        if (fields.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_OPERATOR_ID);
        }
        if (fields.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
            sqlBuilder.items(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
        }
        if (fields.contains(ModelTUserInfo.FI_SIGNATURE)) {
            sqlBuilder.items(ModelTUserInfo.FI_SIGNATURE);
        }
        if (fields.contains(ModelTUserInfo.FI_IM_USER_ID)) {
            sqlBuilder.items(ModelTUserInfo.FI_IM_USER_ID);
        }
        if (fields.contains(ModelTUserInfo.FI_CONSTELLATION)) {
            sqlBuilder.items(ModelTUserInfo.FI_CONSTELLATION);
        }
        if (fields.contains(ModelTUserInfo.FI_HOBBY)) {
            sqlBuilder.items(ModelTUserInfo.FI_HOBBY);
        }
        if (fields.contains(ModelTUserInfo.FI_SHOW_ACADEMY)) {
            sqlBuilder.items(ModelTUserInfo.FI_SHOW_ACADEMY);
        }
        if (fields.contains(ModelTUserInfo.FI_EMAIL_263)) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL_263);
        }
        if (fields.contains(ModelTUserInfo.FI_CREATE_TIME_OF_USER)) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATE_TIME_OF_USER);
        }
        List<Map<String, Object>> param = CollectionHelper.<Map<String,Object>> newList();
        for (ModelTUserInfo instance: instances) {
            Map<String, Object> paramMap = ModelTUserInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
            param.add(paramMap);
        }
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.batchInsert(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer insert(List<ModelTUserInfo> instances, Set<String> fields) {
        return insert(instances, fields, null);
    }

    public Integer insert(List<ModelTUserInfo> instances) {
        return insert(instances, null, null);
    }

    public Integer update(ModelTUserInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTUserInfo.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelTUserInfo.FI_ID, ColumnDataType.intData);
        } else {
            if (dId!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_ID);
            }
        }
        String dMobile = instance.getMobile();
        if (conditionField.contains(ModelTUserInfo.FI_MOBILE)) {
            assert((dMobile!= null));
            sqlBuilder.where(ModelTUserInfo.FI_MOBILE, ColumnDataType.stringData);
        } else {
            if (dMobile!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_MOBILE);
            }
        }
        String dEmail = instance.getEmail();
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL)) {
            assert((dEmail!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EMAIL, ColumnDataType.stringData);
        } else {
            if (dEmail!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_EMAIL);
            }
        }
        String dUsername = instance.getUsername();
        if (conditionField.contains(ModelTUserInfo.FI_USERNAME)) {
            assert((dUsername!= null));
            sqlBuilder.where(ModelTUserInfo.FI_USERNAME, ColumnDataType.stringData);
        } else {
            if (dUsername!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_USERNAME);
            }
        }
        String dNickname = instance.getNickname();
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME)) {
            assert((dNickname!= null));
            sqlBuilder.where(ModelTUserInfo.FI_NICKNAME, ColumnDataType.stringData);
        } else {
            if (dNickname!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_NICKNAME);
            }
        }
        String dSex = instance.getSex();
        if (conditionField.contains(ModelTUserInfo.FI_SEX)) {
            assert((dSex!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SEX, ColumnDataType.stringData);
        } else {
            if (dSex!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_SEX);
            }
        }
        String dEducation = instance.getEducation();
        if (conditionField.contains(ModelTUserInfo.FI_EDUCATION)) {
            assert((dEducation!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EDUCATION, ColumnDataType.stringData);
        } else {
            if (dEducation!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_EDUCATION);
            }
        }
        String dCert_type = instance.getCertType();
        if (conditionField.contains(ModelTUserInfo.FI_CERT_TYPE)) {
            assert((dCert_type!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CERT_TYPE, ColumnDataType.stringData);
        } else {
            if (dCert_type!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_CERT_TYPE);
            }
        }
        String dCert_no = instance.getCertNo();
        if (conditionField.contains(ModelTUserInfo.FI_CERT_NO)) {
            assert((dCert_no!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CERT_NO, ColumnDataType.stringData);
        } else {
            if (dCert_no!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_CERT_NO);
            }
        }
        String dPhone = instance.getPhone();
        if (conditionField.contains(ModelTUserInfo.FI_PHONE)) {
            assert((dPhone!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PHONE, ColumnDataType.stringData);
        } else {
            if (dPhone!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_PHONE);
            }
        }
        Date dBirthday = instance.getBirthday();
        if (conditionField.contains(ModelTUserInfo.FI_BIRTHDAY)) {
            assert((dBirthday!= null));
            sqlBuilder.where(ModelTUserInfo.FI_BIRTHDAY, ColumnDataType.dateData);
        } else {
            if (dBirthday!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_BIRTHDAY);
            }
        }
        Date dApply_date = instance.getApplyDate();
        if (conditionField.contains(ModelTUserInfo.FI_APPLY_DATE)) {
            assert((dApply_date!= null));
            sqlBuilder.where(ModelTUserInfo.FI_APPLY_DATE, ColumnDataType.dateData);
        } else {
            if (dApply_date!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_APPLY_DATE);
            }
        }
        String dUrgent_linker = instance.getUrgentLinker();
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
            assert((dUrgent_linker!= null));
            sqlBuilder.where(ModelTUserInfo.FI_URGENT_LINKER, ColumnDataType.stringData);
        } else {
            if (dUrgent_linker!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_URGENT_LINKER);
            }
        }
        String dUrgent_mobile = instance.getUrgentMobile();
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
            assert((dUrgent_mobile!= null));
            sqlBuilder.where(ModelTUserInfo.FI_URGENT_MOBILE, ColumnDataType.stringData);
        } else {
            if (dUrgent_mobile!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_URGENT_MOBILE);
            }
        }
        String dPassword = instance.getPassword();
        if (conditionField.contains(ModelTUserInfo.FI_PASSWORD)) {
            assert((dPassword!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PASSWORD, ColumnDataType.stringData);
        } else {
            if (dPassword!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_PASSWORD);
            }
        }
        String dState = instance.getState();
        if (conditionField.contains(ModelTUserInfo.FI_STATE)) {
            assert((dState!= null));
            sqlBuilder.where(ModelTUserInfo.FI_STATE, ColumnDataType.stringData);
        } else {
            if (dState!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_STATE);
            }
        }
        String dProvince = instance.getProvince();
        if (conditionField.contains(ModelTUserInfo.FI_PROVINCE)) {
            assert((dProvince!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PROVINCE, ColumnDataType.stringData);
        } else {
            if (dProvince!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_PROVINCE);
            }
        }
        String dCity = instance.getCity();
        if (conditionField.contains(ModelTUserInfo.FI_CITY)) {
            assert((dCity!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CITY, ColumnDataType.stringData);
        } else {
            if (dCity!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_CITY);
            }
        }
        String dReg_time = instance.getRegTime();
        if (conditionField.contains(ModelTUserInfo.FI_REG_TIME)) {
            assert((dReg_time!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REG_TIME, ColumnDataType.stringData);
        } else {
            if (dReg_time!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_REG_TIME);
            }
        }
        String dCreator = instance.getCreator();
        if (conditionField.contains(ModelTUserInfo.FI_CREATOR)) {
            assert((dCreator!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CREATOR, ColumnDataType.stringData);
        } else {
            if (dCreator!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_CREATOR);
            }
        }
        String dSchool = instance.getSchool();
        if (conditionField.contains(ModelTUserInfo.FI_SCHOOL)) {
            assert((dSchool!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SCHOOL, ColumnDataType.stringData);
        } else {
            if (dSchool!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_SCHOOL);
            }
        }
        Integer dAdd_type = instance.getAddType();
        if (conditionField.contains(ModelTUserInfo.FI_ADD_TYPE)) {
            assert((dAdd_type!= null));
            sqlBuilder.where(ModelTUserInfo.FI_ADD_TYPE, ColumnDataType.intData);
        } else {
            if (dAdd_type!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_ADD_TYPE);
            }
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.where(ModelTUserInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        } else {
            if (dUpdate_time!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_UPDATE_TIME);
            }
        }
        String dQq_code = instance.getQqCode();
        if (conditionField.contains(ModelTUserInfo.FI_QQ_CODE)) {
            assert((dQq_code!= null));
            sqlBuilder.where(ModelTUserInfo.FI_QQ_CODE, ColumnDataType.stringData);
        } else {
            if (dQq_code!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_QQ_CODE);
            }
        }
        String dLevel_remark = instance.getLevelRemark();
        if (conditionField.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
            assert((dLevel_remark!= null));
            sqlBuilder.where(ModelTUserInfo.FI_LEVEL_REMARK, ColumnDataType.stringData);
        } else {
            if (dLevel_remark!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_LEVEL_REMARK);
            }
        }
        String dReg_servicePage = instance.getRegServicePage();
        if (conditionField.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
            assert((dReg_servicePage!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REG_SERVICEPAGE, ColumnDataType.stringData);
        } else {
            if (dReg_servicePage!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_REG_SERVICEPAGE);
            }
        }
        String dReg_landingPage = instance.getRegLandingPage();
        if (conditionField.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
            assert((dReg_landingPage!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REG_LANDINGPAGE, ColumnDataType.stringData);
        } else {
            if (dReg_landingPage!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_REG_LANDINGPAGE);
            }
        }
        Byte dSync_bbs = instance.getSyncBbs();
        if (conditionField.contains(ModelTUserInfo.FI_SYNC_BBS)) {
            assert((dSync_bbs!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SYNC_BBS, ColumnDataType.byteData);
        } else {
            if (dSync_bbs!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_SYNC_BBS);
            }
        }
        String dNickname_bbs = instance.getNicknameBbs();
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
            assert((dNickname_bbs!= null));
            sqlBuilder.where(ModelTUserInfo.FI_NICKNAME_BBS, ColumnDataType.stringData);
        } else {
            if (dNickname_bbs!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_NICKNAME_BBS);
            }
        }
        String dExam_province = instance.getExamProvince();
        if (conditionField.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
            assert((dExam_province!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EXAM_PROVINCE, ColumnDataType.stringData);
        } else {
            if (dExam_province!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_EXAM_PROVINCE);
            }
        }
        Integer dHadiths_user_id = instance.getHadithsUserId();
        if (conditionField.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
            assert((dHadiths_user_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HADITHS_USER_ID, ColumnDataType.intData);
        } else {
            if (dHadiths_user_id!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_HADITHS_USER_ID);
            }
        }
        Integer dMaterial_province = instance.getMaterialProvince();
        if (conditionField.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
            assert((dMaterial_province!= null));
            sqlBuilder.where(ModelTUserInfo.FI_MATERIAL_PROVINCE, ColumnDataType.intData);
        } else {
            if (dMaterial_province!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_MATERIAL_PROVINCE);
            }
        }
        Integer dHuluo_user_id = instance.getHuluoUserId();
        if (conditionField.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
            assert((dHuluo_user_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HULUO_USER_ID, ColumnDataType.intData);
        } else {
            if (dHuluo_user_id!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_HULUO_USER_ID);
            }
        }
        String dReferer = instance.getReferer();
        if (conditionField.contains(ModelTUserInfo.FI_REFERER)) {
            assert((dReferer!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REFERER, ColumnDataType.stringData);
        } else {
            if (dReferer!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_REFERER);
            }
        }
        String dImage_url = instance.getImageUrl();
        if (conditionField.contains(ModelTUserInfo.FI_IMAGE_URL)) {
            assert((dImage_url!= null));
            sqlBuilder.where(ModelTUserInfo.FI_IMAGE_URL, ColumnDataType.stringData);
        } else {
            if (dImage_url!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_IMAGE_URL);
            }
        }
        String dHome_phone = instance.getHomePhone();
        if (conditionField.contains(ModelTUserInfo.FI_HOME_PHONE)) {
            assert((dHome_phone!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HOME_PHONE, ColumnDataType.stringData);
        } else {
            if (dHome_phone!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_HOME_PHONE);
            }
        }
        String dOffice_phone = instance.getOfficePhone();
        if (conditionField.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
            assert((dOffice_phone!= null));
            sqlBuilder.where(ModelTUserInfo.FI_OFFICE_PHONE, ColumnDataType.stringData);
        } else {
            if (dOffice_phone!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_OFFICE_PHONE);
            }
        }
        String dWeixin_id = instance.getWeixinId();
        if (conditionField.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
            assert((dWeixin_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_WEIXIN_ID, ColumnDataType.stringData);
        } else {
            if (dWeixin_id!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_WEIXIN_ID);
            }
        }
        String dEmergency_rel = instance.getEmergencyRel();
        if (conditionField.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
            assert((dEmergency_rel!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EMERGENCY_REL, ColumnDataType.stringData);
        } else {
            if (dEmergency_rel!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_EMERGENCY_REL);
            }
        }
        String dAddress = instance.getAddress();
        if (conditionField.contains(ModelTUserInfo.FI_ADDRESS)) {
            assert((dAddress!= null));
            sqlBuilder.where(ModelTUserInfo.FI_ADDRESS, ColumnDataType.stringData);
        } else {
            if (dAddress!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_ADDRESS);
            }
        }
        String dPostcode = instance.getPostcode();
        if (conditionField.contains(ModelTUserInfo.FI_POSTCODE)) {
            assert((dPostcode!= null));
            sqlBuilder.where(ModelTUserInfo.FI_POSTCODE, ColumnDataType.stringData);
        } else {
            if (dPostcode!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_POSTCODE);
            }
        }
        String dProfession = instance.getProfession();
        if (conditionField.contains(ModelTUserInfo.FI_PROFESSION)) {
            assert((dProfession!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PROFESSION, ColumnDataType.stringData);
        } else {
            if (dProfession!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_PROFESSION);
            }
        }
        Date dWork_year = instance.getWorkYear();
        if (conditionField.contains(ModelTUserInfo.FI_WORK_YEAR)) {
            assert((dWork_year!= null));
            sqlBuilder.where(ModelTUserInfo.FI_WORK_YEAR, ColumnDataType.dateData);
        } else {
            if (dWork_year!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_WORK_YEAR);
            }
        }
        String dQt_cert = instance.getQtCert();
        if (conditionField.contains(ModelTUserInfo.FI_QT_CERT)) {
            assert((dQt_cert!= null));
            sqlBuilder.where(ModelTUserInfo.FI_QT_CERT, ColumnDataType.stringData);
        } else {
            if (dQt_cert!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_QT_CERT);
            }
        }
        String dTraining_cert = instance.getTrainingCert();
        if (conditionField.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
            assert((dTraining_cert!= null));
            sqlBuilder.where(ModelTUserInfo.FI_TRAINING_CERT, ColumnDataType.stringData);
        } else {
            if (dTraining_cert!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_TRAINING_CERT);
            }
        }
        String dRemark = instance.getRemark();
        if (conditionField.contains(ModelTUserInfo.FI_REMARK)) {
            assert((dRemark!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REMARK, ColumnDataType.stringData);
        } else {
            if (dRemark!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_REMARK);
            }
        }
        String dGraduate_academy = instance.getGraduateAcademy();
        if (conditionField.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
            assert((dGraduate_academy!= null));
            sqlBuilder.where(ModelTUserInfo.FI_GRADUATE_ACADEMY, ColumnDataType.stringData);
        } else {
            if (dGraduate_academy!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_GRADUATE_ACADEMY);
            }
        }
        String dIndustry = instance.getIndustry();
        if (conditionField.contains(ModelTUserInfo.FI_INDUSTRY)) {
            assert((dIndustry!= null));
            sqlBuilder.where(ModelTUserInfo.FI_INDUSTRY, ColumnDataType.stringData);
        } else {
            if (dIndustry!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_INDUSTRY);
            }
        }
        String dOperator_id = instance.getOperatorId();
        if (conditionField.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
            assert((dOperator_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_OPERATOR_ID, ColumnDataType.stringData);
        } else {
            if (dOperator_id!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_OPERATOR_ID);
            }
        }
        String dFirst_project_ids = instance.getFirstProjectIds();
        if (conditionField.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
            assert((dFirst_project_ids!= null));
            sqlBuilder.where(ModelTUserInfo.FI_FIRST_PROJECT_IDS, ColumnDataType.stringData);
        } else {
            if (dFirst_project_ids!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
            }
        }
        String dSignature = instance.getSignature();
        if (conditionField.contains(ModelTUserInfo.FI_SIGNATURE)) {
            assert((dSignature!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SIGNATURE, ColumnDataType.stringData);
        } else {
            if (dSignature!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_SIGNATURE);
            }
        }
        Long dIm_user_id = instance.getImUserId();
        if (conditionField.contains(ModelTUserInfo.FI_IM_USER_ID)) {
            assert((dIm_user_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_IM_USER_ID, ColumnDataType.longData);
        } else {
            if (dIm_user_id!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_IM_USER_ID);
            }
        }
        String dConstellation = instance.getConstellation();
        if (conditionField.contains(ModelTUserInfo.FI_CONSTELLATION)) {
            assert((dConstellation!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CONSTELLATION, ColumnDataType.stringData);
        } else {
            if (dConstellation!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_CONSTELLATION);
            }
        }
        String dHobby = instance.getHobby();
        if (conditionField.contains(ModelTUserInfo.FI_HOBBY)) {
            assert((dHobby!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HOBBY, ColumnDataType.stringData);
        } else {
            if (dHobby!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_HOBBY);
            }
        }
        Byte dShow_academy = instance.getShowAcademy();
        if (conditionField.contains(ModelTUserInfo.FI_SHOW_ACADEMY)) {
            assert((dShow_academy!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SHOW_ACADEMY, ColumnDataType.byteData);
        } else {
            if (dShow_academy!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_SHOW_ACADEMY);
            }
        }
        String dEmail_263 = instance.getEmail263();
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL_263)) {
            assert((dEmail_263 != null));
            sqlBuilder.where(ModelTUserInfo.FI_EMAIL_263, ColumnDataType.stringData);
        } else {
            if (dEmail_263 != null) {
                sqlBuilder.items(ModelTUserInfo.FI_EMAIL_263);
            }
        }
        Date dCreate_time_of_user = instance.getCreateTimeOfUser();
        if (conditionField.contains(ModelTUserInfo.FI_CREATE_TIME_OF_USER)) {
            assert((dCreate_time_of_user!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CREATE_TIME_OF_USER, ColumnDataType.timeStampData);
        } else {
            if (dCreate_time_of_user!= null) {
                sqlBuilder.items(ModelTUserInfo.FI_CREATE_TIME_OF_USER);
            }
        }
        Map<String, Object> param = ModelTUserInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer update(ModelTUserInfo instance, Set<String> conditionField) {
        return update(instance, conditionField, null);
    }

    public Integer updateById(ModelTUserInfo instance, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserInfo.DTO_TABLE_NAME);
        assert((instance.getId()!= null));
        Integer dId = instance.getId();
        if (dId!= null) {
            sqlBuilder.where(ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_MOBILE);
        }
        String dEmail = instance.getEmail();
        if (dEmail!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL);
        }
        String dUsername = instance.getUsername();
        if (dUsername!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_USERNAME);
        }
        String dNickname = instance.getNickname();
        if (dNickname!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME);
        }
        String dSex = instance.getSex();
        if (dSex!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SEX);
        }
        String dEducation = instance.getEducation();
        if (dEducation!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EDUCATION);
        }
        String dCert_type = instance.getCertType();
        if (dCert_type!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_TYPE);
        }
        String dCert_no = instance.getCertNo();
        if (dCert_no!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_NO);
        }
        String dPhone = instance.getPhone();
        if (dPhone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PHONE);
        }
        Date dBirthday = instance.getBirthday();
        if (dBirthday!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_BIRTHDAY);
        }
        Date dApply_date = instance.getApplyDate();
        if (dApply_date!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_APPLY_DATE);
        }
        String dUrgent_linker = instance.getUrgentLinker();
        if (dUrgent_linker!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_LINKER);
        }
        String dUrgent_mobile = instance.getUrgentMobile();
        if (dUrgent_mobile!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_MOBILE);
        }
        String dPassword = instance.getPassword();
        if (dPassword!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PASSWORD);
        }
        String dState = instance.getState();
        if (dState!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_STATE);
        }
        String dProvince = instance.getProvince();
        if (dProvince!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PROVINCE);
        }
        String dCity = instance.getCity();
        if (dCity!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CITY);
        }
        String dReg_time = instance.getRegTime();
        if (dReg_time!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_TIME);
        }
        String dCreator = instance.getCreator();
        if (dCreator!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATOR);
        }
        String dSchool = instance.getSchool();
        if (dSchool!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SCHOOL);
        }
        Integer dAdd_type = instance.getAddType();
        if (dAdd_type!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ADD_TYPE);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_UPDATE_TIME);
        }
        String dQq_code = instance.getQqCode();
        if (dQq_code!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_QQ_CODE);
        }
        String dLevel_remark = instance.getLevelRemark();
        if (dLevel_remark!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_LEVEL_REMARK);
        }
        String dReg_servicePage = instance.getRegServicePage();
        if (dReg_servicePage!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_SERVICEPAGE);
        }
        String dReg_landingPage = instance.getRegLandingPage();
        if (dReg_landingPage!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_LANDINGPAGE);
        }
        Byte dSync_bbs = instance.getSyncBbs();
        if (dSync_bbs!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SYNC_BBS);
        }
        String dNickname_bbs = instance.getNicknameBbs();
        if (dNickname_bbs!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME_BBS);
        }
        String dExam_province = instance.getExamProvince();
        if (dExam_province!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EXAM_PROVINCE);
        }
        Integer dHadiths_user_id = instance.getHadithsUserId();
        if (dHadiths_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HADITHS_USER_ID);
        }
        Integer dMaterial_province = instance.getMaterialProvince();
        if (dMaterial_province!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_MATERIAL_PROVINCE);
        }
        Integer dHuluo_user_id = instance.getHuluoUserId();
        if (dHuluo_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HULUO_USER_ID);
        }
        String dReferer = instance.getReferer();
        if (dReferer!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REFERER);
        }
        String dImage_url = instance.getImageUrl();
        if (dImage_url!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_IMAGE_URL);
        }
        String dHome_phone = instance.getHomePhone();
        if (dHome_phone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HOME_PHONE);
        }
        String dOffice_phone = instance.getOfficePhone();
        if (dOffice_phone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_OFFICE_PHONE);
        }
        String dWeixin_id = instance.getWeixinId();
        if (dWeixin_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_WEIXIN_ID);
        }
        String dEmergency_rel = instance.getEmergencyRel();
        if (dEmergency_rel!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMERGENCY_REL);
        }
        String dAddress = instance.getAddress();
        if (dAddress!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ADDRESS);
        }
        String dPostcode = instance.getPostcode();
        if (dPostcode!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_POSTCODE);
        }
        String dProfession = instance.getProfession();
        if (dProfession!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PROFESSION);
        }
        Date dWork_year = instance.getWorkYear();
        if (dWork_year!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_WORK_YEAR);
        }
        String dQt_cert = instance.getQtCert();
        if (dQt_cert!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_QT_CERT);
        }
        String dTraining_cert = instance.getTrainingCert();
        if (dTraining_cert!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_TRAINING_CERT);
        }
        String dRemark = instance.getRemark();
        if (dRemark!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REMARK);
        }
        String dGraduate_academy = instance.getGraduateAcademy();
        if (dGraduate_academy!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_GRADUATE_ACADEMY);
        }
        String dIndustry = instance.getIndustry();
        if (dIndustry!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_INDUSTRY);
        }
        String dOperator_id = instance.getOperatorId();
        if (dOperator_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_OPERATOR_ID);
        }
        String dFirst_project_ids = instance.getFirstProjectIds();
        if (dFirst_project_ids!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
        }
        String dSignature = instance.getSignature();
        if (dSignature!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SIGNATURE);
        }
        Long dIm_user_id = instance.getImUserId();
        if (dIm_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_IM_USER_ID);
        }
        String dConstellation = instance.getConstellation();
        if (dConstellation!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CONSTELLATION);
        }
        String dHobby = instance.getHobby();
        if (dHobby!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HOBBY);
        }
        Byte dShow_academy = instance.getShowAcademy();
        if (dShow_academy!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SHOW_ACADEMY);
        }
        String dEmail_263 = instance.getEmail263();
        if (dEmail_263 != null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL_263);
        }
        Date dCreate_time_of_user = instance.getCreateTimeOfUser();
        if (dCreate_time_of_user!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATE_TIME_OF_USER);
        }
        Map<String, Object> param = ModelTUserInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateById(ModelTUserInfo instance) {
        return updateById(instance, null);
    }

    public Integer updateByIds(ModelTUserInfo instance, Set<Integer> ids, DaoAssembler assembler) {
        SQLUpdate sqlBuilder = SQL.buildUpdateSql(ModelTUserInfo.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        sqlBuilder.where(LogicalOpType.in, ModelTUserInfo.FI_ID, "ids", ColumnDataType.intData);
        instance.setId(null);
        String dMobile = instance.getMobile();
        if (dMobile!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_MOBILE);
        }
        String dEmail = instance.getEmail();
        if (dEmail!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL);
        }
        String dUsername = instance.getUsername();
        if (dUsername!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_USERNAME);
        }
        String dNickname = instance.getNickname();
        if (dNickname!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME);
        }
        String dSex = instance.getSex();
        if (dSex!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SEX);
        }
        String dEducation = instance.getEducation();
        if (dEducation!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EDUCATION);
        }
        String dCert_type = instance.getCertType();
        if (dCert_type!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_TYPE);
        }
        String dCert_no = instance.getCertNo();
        if (dCert_no!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CERT_NO);
        }
        String dPhone = instance.getPhone();
        if (dPhone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PHONE);
        }
        Date dBirthday = instance.getBirthday();
        if (dBirthday!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_BIRTHDAY);
        }
        Date dApply_date = instance.getApplyDate();
        if (dApply_date!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_APPLY_DATE);
        }
        String dUrgent_linker = instance.getUrgentLinker();
        if (dUrgent_linker!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_LINKER);
        }
        String dUrgent_mobile = instance.getUrgentMobile();
        if (dUrgent_mobile!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_URGENT_MOBILE);
        }
        String dPassword = instance.getPassword();
        if (dPassword!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PASSWORD);
        }
        String dState = instance.getState();
        if (dState!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_STATE);
        }
        String dProvince = instance.getProvince();
        if (dProvince!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PROVINCE);
        }
        String dCity = instance.getCity();
        if (dCity!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CITY);
        }
        String dReg_time = instance.getRegTime();
        if (dReg_time!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_TIME);
        }
        String dCreator = instance.getCreator();
        if (dCreator!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATOR);
        }
        String dSchool = instance.getSchool();
        if (dSchool!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SCHOOL);
        }
        Integer dAdd_type = instance.getAddType();
        if (dAdd_type!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ADD_TYPE);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (dUpdate_time!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_UPDATE_TIME);
        }
        String dQq_code = instance.getQqCode();
        if (dQq_code!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_QQ_CODE);
        }
        String dLevel_remark = instance.getLevelRemark();
        if (dLevel_remark!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_LEVEL_REMARK);
        }
        String dReg_servicePage = instance.getRegServicePage();
        if (dReg_servicePage!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_SERVICEPAGE);
        }
        String dReg_landingPage = instance.getRegLandingPage();
        if (dReg_landingPage!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REG_LANDINGPAGE);
        }
        Byte dSync_bbs = instance.getSyncBbs();
        if (dSync_bbs!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SYNC_BBS);
        }
        String dNickname_bbs = instance.getNicknameBbs();
        if (dNickname_bbs!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_NICKNAME_BBS);
        }
        String dExam_province = instance.getExamProvince();
        if (dExam_province!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EXAM_PROVINCE);
        }
        Integer dHadiths_user_id = instance.getHadithsUserId();
        if (dHadiths_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HADITHS_USER_ID);
        }
        Integer dMaterial_province = instance.getMaterialProvince();
        if (dMaterial_province!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_MATERIAL_PROVINCE);
        }
        Integer dHuluo_user_id = instance.getHuluoUserId();
        if (dHuluo_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HULUO_USER_ID);
        }
        String dReferer = instance.getReferer();
        if (dReferer!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REFERER);
        }
        String dImage_url = instance.getImageUrl();
        if (dImage_url!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_IMAGE_URL);
        }
        String dHome_phone = instance.getHomePhone();
        if (dHome_phone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HOME_PHONE);
        }
        String dOffice_phone = instance.getOfficePhone();
        if (dOffice_phone!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_OFFICE_PHONE);
        }
        String dWeixin_id = instance.getWeixinId();
        if (dWeixin_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_WEIXIN_ID);
        }
        String dEmergency_rel = instance.getEmergencyRel();
        if (dEmergency_rel!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMERGENCY_REL);
        }
        String dAddress = instance.getAddress();
        if (dAddress!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_ADDRESS);
        }
        String dPostcode = instance.getPostcode();
        if (dPostcode!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_POSTCODE);
        }
        String dProfession = instance.getProfession();
        if (dProfession!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_PROFESSION);
        }
        Date dWork_year = instance.getWorkYear();
        if (dWork_year!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_WORK_YEAR);
        }
        String dQt_cert = instance.getQtCert();
        if (dQt_cert!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_QT_CERT);
        }
        String dTraining_cert = instance.getTrainingCert();
        if (dTraining_cert!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_TRAINING_CERT);
        }
        String dRemark = instance.getRemark();
        if (dRemark!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_REMARK);
        }
        String dGraduate_academy = instance.getGraduateAcademy();
        if (dGraduate_academy!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_GRADUATE_ACADEMY);
        }
        String dIndustry = instance.getIndustry();
        if (dIndustry!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_INDUSTRY);
        }
        String dOperator_id = instance.getOperatorId();
        if (dOperator_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_OPERATOR_ID);
        }
        String dFirst_project_ids = instance.getFirstProjectIds();
        if (dFirst_project_ids!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
        }
        String dSignature = instance.getSignature();
        if (dSignature!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SIGNATURE);
        }
        Long dIm_user_id = instance.getImUserId();
        if (dIm_user_id!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_IM_USER_ID);
        }
        String dConstellation = instance.getConstellation();
        if (dConstellation!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CONSTELLATION);
        }
        String dHobby = instance.getHobby();
        if (dHobby!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_HOBBY);
        }
        Byte dShow_academy = instance.getShowAcademy();
        if (dShow_academy!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_SHOW_ACADEMY);
        }
        String dEmail_263 = instance.getEmail263();
        if (dEmail_263 != null) {
            sqlBuilder.items(ModelTUserInfo.FI_EMAIL_263);
        }
        Date dCreate_time_of_user = instance.getCreateTimeOfUser();
        if (dCreate_time_of_user!= null) {
            sqlBuilder.items(ModelTUserInfo.FI_CREATE_TIME_OF_USER);
        }
        Map<String, Object> param = ModelTUserInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        param.put("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer updateByIds(ModelTUserInfo instance, Set<Integer> ids) {
        return updateByIds(instance, ids, null);
    }

    public Integer delete(ModelTUserInfo instance, Set<String> conditionField, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTUserInfo.DTO_TABLE_NAME);
        Integer dId = instance.getId();
        if (conditionField.contains(ModelTUserInfo.FI_ID)) {
            assert((dId!= null));
            sqlBuilder.where(ModelTUserInfo.FI_ID, ColumnDataType.intData);
        }
        String dMobile = instance.getMobile();
        if (conditionField.contains(ModelTUserInfo.FI_MOBILE)) {
            assert((dMobile!= null));
            sqlBuilder.where(ModelTUserInfo.FI_MOBILE, ColumnDataType.stringData);
        }
        String dEmail = instance.getEmail();
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL)) {
            assert((dEmail!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EMAIL, ColumnDataType.stringData);
        }
        String dUsername = instance.getUsername();
        if (conditionField.contains(ModelTUserInfo.FI_USERNAME)) {
            assert((dUsername!= null));
            sqlBuilder.where(ModelTUserInfo.FI_USERNAME, ColumnDataType.stringData);
        }
        String dNickname = instance.getNickname();
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME)) {
            assert((dNickname!= null));
            sqlBuilder.where(ModelTUserInfo.FI_NICKNAME, ColumnDataType.stringData);
        }
        String dSex = instance.getSex();
        if (conditionField.contains(ModelTUserInfo.FI_SEX)) {
            assert((dSex!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SEX, ColumnDataType.stringData);
        }
        String dEducation = instance.getEducation();
        if (conditionField.contains(ModelTUserInfo.FI_EDUCATION)) {
            assert((dEducation!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EDUCATION, ColumnDataType.stringData);
        }
        String dCert_type = instance.getCertType();
        if (conditionField.contains(ModelTUserInfo.FI_CERT_TYPE)) {
            assert((dCert_type!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CERT_TYPE, ColumnDataType.stringData);
        }
        String dCert_no = instance.getCertNo();
        if (conditionField.contains(ModelTUserInfo.FI_CERT_NO)) {
            assert((dCert_no!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CERT_NO, ColumnDataType.stringData);
        }
        String dPhone = instance.getPhone();
        if (conditionField.contains(ModelTUserInfo.FI_PHONE)) {
            assert((dPhone!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PHONE, ColumnDataType.stringData);
        }
        Date dBirthday = instance.getBirthday();
        if (conditionField.contains(ModelTUserInfo.FI_BIRTHDAY)) {
            assert((dBirthday!= null));
            sqlBuilder.where(ModelTUserInfo.FI_BIRTHDAY, ColumnDataType.dateData);
        }
        Date dApply_date = instance.getApplyDate();
        if (conditionField.contains(ModelTUserInfo.FI_APPLY_DATE)) {
            assert((dApply_date!= null));
            sqlBuilder.where(ModelTUserInfo.FI_APPLY_DATE, ColumnDataType.dateData);
        }
        String dUrgent_linker = instance.getUrgentLinker();
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
            assert((dUrgent_linker!= null));
            sqlBuilder.where(ModelTUserInfo.FI_URGENT_LINKER, ColumnDataType.stringData);
        }
        String dUrgent_mobile = instance.getUrgentMobile();
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
            assert((dUrgent_mobile!= null));
            sqlBuilder.where(ModelTUserInfo.FI_URGENT_MOBILE, ColumnDataType.stringData);
        }
        String dPassword = instance.getPassword();
        if (conditionField.contains(ModelTUserInfo.FI_PASSWORD)) {
            assert((dPassword!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PASSWORD, ColumnDataType.stringData);
        }
        String dState = instance.getState();
        if (conditionField.contains(ModelTUserInfo.FI_STATE)) {
            assert((dState!= null));
            sqlBuilder.where(ModelTUserInfo.FI_STATE, ColumnDataType.stringData);
        }
        String dProvince = instance.getProvince();
        if (conditionField.contains(ModelTUserInfo.FI_PROVINCE)) {
            assert((dProvince!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PROVINCE, ColumnDataType.stringData);
        }
        String dCity = instance.getCity();
        if (conditionField.contains(ModelTUserInfo.FI_CITY)) {
            assert((dCity!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CITY, ColumnDataType.stringData);
        }
        String dReg_time = instance.getRegTime();
        if (conditionField.contains(ModelTUserInfo.FI_REG_TIME)) {
            assert((dReg_time!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REG_TIME, ColumnDataType.stringData);
        }
        String dCreator = instance.getCreator();
        if (conditionField.contains(ModelTUserInfo.FI_CREATOR)) {
            assert((dCreator!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CREATOR, ColumnDataType.stringData);
        }
        String dSchool = instance.getSchool();
        if (conditionField.contains(ModelTUserInfo.FI_SCHOOL)) {
            assert((dSchool!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SCHOOL, ColumnDataType.stringData);
        }
        Integer dAdd_type = instance.getAddType();
        if (conditionField.contains(ModelTUserInfo.FI_ADD_TYPE)) {
            assert((dAdd_type!= null));
            sqlBuilder.where(ModelTUserInfo.FI_ADD_TYPE, ColumnDataType.intData);
        }
        Date dUpdate_time = instance.getUpdateTime();
        if (conditionField.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
            assert((dUpdate_time!= null));
            sqlBuilder.where(ModelTUserInfo.FI_UPDATE_TIME, ColumnDataType.timeStampData);
        }
        String dQq_code = instance.getQqCode();
        if (conditionField.contains(ModelTUserInfo.FI_QQ_CODE)) {
            assert((dQq_code!= null));
            sqlBuilder.where(ModelTUserInfo.FI_QQ_CODE, ColumnDataType.stringData);
        }
        String dLevel_remark = instance.getLevelRemark();
        if (conditionField.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
            assert((dLevel_remark!= null));
            sqlBuilder.where(ModelTUserInfo.FI_LEVEL_REMARK, ColumnDataType.stringData);
        }
        String dReg_servicePage = instance.getRegServicePage();
        if (conditionField.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
            assert((dReg_servicePage!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REG_SERVICEPAGE, ColumnDataType.stringData);
        }
        String dReg_landingPage = instance.getRegLandingPage();
        if (conditionField.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
            assert((dReg_landingPage!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REG_LANDINGPAGE, ColumnDataType.stringData);
        }
        Byte dSync_bbs = instance.getSyncBbs();
        if (conditionField.contains(ModelTUserInfo.FI_SYNC_BBS)) {
            assert((dSync_bbs!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SYNC_BBS, ColumnDataType.byteData);
        }
        String dNickname_bbs = instance.getNicknameBbs();
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
            assert((dNickname_bbs!= null));
            sqlBuilder.where(ModelTUserInfo.FI_NICKNAME_BBS, ColumnDataType.stringData);
        }
        String dExam_province = instance.getExamProvince();
        if (conditionField.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
            assert((dExam_province!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EXAM_PROVINCE, ColumnDataType.stringData);
        }
        Integer dHadiths_user_id = instance.getHadithsUserId();
        if (conditionField.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
            assert((dHadiths_user_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HADITHS_USER_ID, ColumnDataType.intData);
        }
        Integer dMaterial_province = instance.getMaterialProvince();
        if (conditionField.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
            assert((dMaterial_province!= null));
            sqlBuilder.where(ModelTUserInfo.FI_MATERIAL_PROVINCE, ColumnDataType.intData);
        }
        Integer dHuluo_user_id = instance.getHuluoUserId();
        if (conditionField.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
            assert((dHuluo_user_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HULUO_USER_ID, ColumnDataType.intData);
        }
        String dReferer = instance.getReferer();
        if (conditionField.contains(ModelTUserInfo.FI_REFERER)) {
            assert((dReferer!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REFERER, ColumnDataType.stringData);
        }
        String dImage_url = instance.getImageUrl();
        if (conditionField.contains(ModelTUserInfo.FI_IMAGE_URL)) {
            assert((dImage_url!= null));
            sqlBuilder.where(ModelTUserInfo.FI_IMAGE_URL, ColumnDataType.stringData);
        }
        String dHome_phone = instance.getHomePhone();
        if (conditionField.contains(ModelTUserInfo.FI_HOME_PHONE)) {
            assert((dHome_phone!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HOME_PHONE, ColumnDataType.stringData);
        }
        String dOffice_phone = instance.getOfficePhone();
        if (conditionField.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
            assert((dOffice_phone!= null));
            sqlBuilder.where(ModelTUserInfo.FI_OFFICE_PHONE, ColumnDataType.stringData);
        }
        String dWeixin_id = instance.getWeixinId();
        if (conditionField.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
            assert((dWeixin_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_WEIXIN_ID, ColumnDataType.stringData);
        }
        String dEmergency_rel = instance.getEmergencyRel();
        if (conditionField.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
            assert((dEmergency_rel!= null));
            sqlBuilder.where(ModelTUserInfo.FI_EMERGENCY_REL, ColumnDataType.stringData);
        }
        String dAddress = instance.getAddress();
        if (conditionField.contains(ModelTUserInfo.FI_ADDRESS)) {
            assert((dAddress!= null));
            sqlBuilder.where(ModelTUserInfo.FI_ADDRESS, ColumnDataType.stringData);
        }
        String dPostcode = instance.getPostcode();
        if (conditionField.contains(ModelTUserInfo.FI_POSTCODE)) {
            assert((dPostcode!= null));
            sqlBuilder.where(ModelTUserInfo.FI_POSTCODE, ColumnDataType.stringData);
        }
        String dProfession = instance.getProfession();
        if (conditionField.contains(ModelTUserInfo.FI_PROFESSION)) {
            assert((dProfession!= null));
            sqlBuilder.where(ModelTUserInfo.FI_PROFESSION, ColumnDataType.stringData);
        }
        Date dWork_year = instance.getWorkYear();
        if (conditionField.contains(ModelTUserInfo.FI_WORK_YEAR)) {
            assert((dWork_year!= null));
            sqlBuilder.where(ModelTUserInfo.FI_WORK_YEAR, ColumnDataType.dateData);
        }
        String dQt_cert = instance.getQtCert();
        if (conditionField.contains(ModelTUserInfo.FI_QT_CERT)) {
            assert((dQt_cert!= null));
            sqlBuilder.where(ModelTUserInfo.FI_QT_CERT, ColumnDataType.stringData);
        }
        String dTraining_cert = instance.getTrainingCert();
        if (conditionField.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
            assert((dTraining_cert!= null));
            sqlBuilder.where(ModelTUserInfo.FI_TRAINING_CERT, ColumnDataType.stringData);
        }
        String dRemark = instance.getRemark();
        if (conditionField.contains(ModelTUserInfo.FI_REMARK)) {
            assert((dRemark!= null));
            sqlBuilder.where(ModelTUserInfo.FI_REMARK, ColumnDataType.stringData);
        }
        String dGraduate_academy = instance.getGraduateAcademy();
        if (conditionField.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
            assert((dGraduate_academy!= null));
            sqlBuilder.where(ModelTUserInfo.FI_GRADUATE_ACADEMY, ColumnDataType.stringData);
        }
        String dIndustry = instance.getIndustry();
        if (conditionField.contains(ModelTUserInfo.FI_INDUSTRY)) {
            assert((dIndustry!= null));
            sqlBuilder.where(ModelTUserInfo.FI_INDUSTRY, ColumnDataType.stringData);
        }
        String dOperator_id = instance.getOperatorId();
        if (conditionField.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
            assert((dOperator_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_OPERATOR_ID, ColumnDataType.stringData);
        }
        String dFirst_project_ids = instance.getFirstProjectIds();
        if (conditionField.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
            assert((dFirst_project_ids!= null));
            sqlBuilder.where(ModelTUserInfo.FI_FIRST_PROJECT_IDS, ColumnDataType.stringData);
        }
        String dSignature = instance.getSignature();
        if (conditionField.contains(ModelTUserInfo.FI_SIGNATURE)) {
            assert((dSignature!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SIGNATURE, ColumnDataType.stringData);
        }
        Long dIm_user_id = instance.getImUserId();
        if (conditionField.contains(ModelTUserInfo.FI_IM_USER_ID)) {
            assert((dIm_user_id!= null));
            sqlBuilder.where(ModelTUserInfo.FI_IM_USER_ID, ColumnDataType.longData);
        }
        String dConstellation = instance.getConstellation();
        if (conditionField.contains(ModelTUserInfo.FI_CONSTELLATION)) {
            assert((dConstellation!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CONSTELLATION, ColumnDataType.stringData);
        }
        String dHobby = instance.getHobby();
        if (conditionField.contains(ModelTUserInfo.FI_HOBBY)) {
            assert((dHobby!= null));
            sqlBuilder.where(ModelTUserInfo.FI_HOBBY, ColumnDataType.stringData);
        }
        Byte dShow_academy = instance.getShowAcademy();
        if (conditionField.contains(ModelTUserInfo.FI_SHOW_ACADEMY)) {
            assert((dShow_academy!= null));
            sqlBuilder.where(ModelTUserInfo.FI_SHOW_ACADEMY, ColumnDataType.byteData);
        }
        String dEmail_263 = instance.getEmail263();
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL_263)) {
            assert((dEmail_263 != null));
            sqlBuilder.where(ModelTUserInfo.FI_EMAIL_263, ColumnDataType.stringData);
        }
        Date dCreate_time_of_user = instance.getCreateTimeOfUser();
        if (conditionField.contains(ModelTUserInfo.FI_CREATE_TIME_OF_USER)) {
            assert((dCreate_time_of_user!= null));
            sqlBuilder.where(ModelTUserInfo.FI_CREATE_TIME_OF_USER, ColumnDataType.timeStampData);
        }
        Map<String, Object> param = ModelTUserInfo.MAP_OBJ_MAPPER.toCommonMap(instance);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer delete(ModelTUserInfo instance, Set<String> conditionField) {
        return delete(instance, conditionField, null);
    }

    public Integer deleteById(Integer id, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTUserInfo.DTO_TABLE_NAME);
        assert((id!= null));
        Map<String, Object> param = Collections.singletonMap("id", id);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteById(Integer id) {
        return deleteById(id, null);
    }

    public Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler) {
        SQLDelete sqlBuilder = SQL.buildDeleteSql(ModelTUserInfo.DTO_TABLE_NAME);
        assert(((ids!= null)&&(ids.size()> 0)));
        Map<String, Object> param = Collections.singletonMap("ids", ids);
        SimpleDbInterface dbInstance = data_store;
        String dbToUse = super.selectDb(assembler, sqlBuilder, param);
        if ((dbToUse!= null)&&dbMap.containsKey(dbToUse)) {
            dbInstance = dbMap.get(dbToUse);
        }
        return super.update(dbInstance, assembler, sqlBuilder, param);
    }

    public Integer deleteByIds(Set<Integer> ids) {
        return deleteByIds(ids, null);
    }

    @Transactional
    public ModelTUserInfo updateOrInsert(ModelTUserInfo instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTUserInfo checkInstance = new ModelTUserInfo();
        if (conditionField.contains(ModelTUserInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_MOBILE)) {
            checkInstance.setMobile(instance.getMobile());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL)) {
            checkInstance.setEmail(instance.getEmail());
        }
        if (conditionField.contains(ModelTUserInfo.FI_USERNAME)) {
            checkInstance.setUsername(instance.getUsername());
        }
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME)) {
            checkInstance.setNickname(instance.getNickname());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SEX)) {
            checkInstance.setSex(instance.getSex());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EDUCATION)) {
            checkInstance.setEducation(instance.getEducation());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CERT_TYPE)) {
            checkInstance.setCertType(instance.getCertType());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CERT_NO)) {
            checkInstance.setCertNo(instance.getCertNo());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PHONE)) {
            checkInstance.setPhone(instance.getPhone());
        }
        if (conditionField.contains(ModelTUserInfo.FI_BIRTHDAY)) {
            checkInstance.setBirthday(instance.getBirthday());
        }
        if (conditionField.contains(ModelTUserInfo.FI_APPLY_DATE)) {
            checkInstance.setApplyDate(instance.getApplyDate());
        }
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
            checkInstance.setUrgentLinker(instance.getUrgentLinker());
        }
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
            checkInstance.setUrgentMobile(instance.getUrgentMobile());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PASSWORD)) {
            checkInstance.setPassword(instance.getPassword());
        }
        if (conditionField.contains(ModelTUserInfo.FI_STATE)) {
            checkInstance.setState(instance.getState());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PROVINCE)) {
            checkInstance.setProvince(instance.getProvince());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CITY)) {
            checkInstance.setCity(instance.getCity());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REG_TIME)) {
            checkInstance.setRegTime(instance.getRegTime());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CREATOR)) {
            checkInstance.setCreator(instance.getCreator());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SCHOOL)) {
            checkInstance.setSchool(instance.getSchool());
        }
        if (conditionField.contains(ModelTUserInfo.FI_ADD_TYPE)) {
            checkInstance.setAddType(instance.getAddType());
        }
        if (conditionField.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        if (conditionField.contains(ModelTUserInfo.FI_QQ_CODE)) {
            checkInstance.setQqCode(instance.getQqCode());
        }
        if (conditionField.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
            checkInstance.setLevelRemark(instance.getLevelRemark());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
            checkInstance.setRegServicePage(instance.getRegServicePage());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
            checkInstance.setRegLandingPage(instance.getRegLandingPage());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SYNC_BBS)) {
            checkInstance.setSyncBbs(instance.getSyncBbs());
        }
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
            checkInstance.setNicknameBbs(instance.getNicknameBbs());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
            checkInstance.setExamProvince(instance.getExamProvince());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
            checkInstance.setHadithsUserId(instance.getHadithsUserId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
            checkInstance.setMaterialProvince(instance.getMaterialProvince());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
            checkInstance.setHuluoUserId(instance.getHuluoUserId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REFERER)) {
            checkInstance.setReferer(instance.getReferer());
        }
        if (conditionField.contains(ModelTUserInfo.FI_IMAGE_URL)) {
            checkInstance.setImageUrl(instance.getImageUrl());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HOME_PHONE)) {
            checkInstance.setHomePhone(instance.getHomePhone());
        }
        if (conditionField.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
            checkInstance.setOfficePhone(instance.getOfficePhone());
        }
        if (conditionField.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
            checkInstance.setWeixinId(instance.getWeixinId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
            checkInstance.setEmergencyRel(instance.getEmergencyRel());
        }
        if (conditionField.contains(ModelTUserInfo.FI_ADDRESS)) {
            checkInstance.setAddress(instance.getAddress());
        }
        if (conditionField.contains(ModelTUserInfo.FI_POSTCODE)) {
            checkInstance.setPostcode(instance.getPostcode());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PROFESSION)) {
            checkInstance.setProfession(instance.getProfession());
        }
        if (conditionField.contains(ModelTUserInfo.FI_WORK_YEAR)) {
            checkInstance.setWorkYear(instance.getWorkYear());
        }
        if (conditionField.contains(ModelTUserInfo.FI_QT_CERT)) {
            checkInstance.setQtCert(instance.getQtCert());
        }
        if (conditionField.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
            checkInstance.setTrainingCert(instance.getTrainingCert());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REMARK)) {
            checkInstance.setRemark(instance.getRemark());
        }
        if (conditionField.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
            checkInstance.setGraduateAcademy(instance.getGraduateAcademy());
        }
        if (conditionField.contains(ModelTUserInfo.FI_INDUSTRY)) {
            checkInstance.setIndustry(instance.getIndustry());
        }
        if (conditionField.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
            checkInstance.setOperatorId(instance.getOperatorId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
            checkInstance.setFirstProjectIds(instance.getFirstProjectIds());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SIGNATURE)) {
            checkInstance.setSignature(instance.getSignature());
        }
        if (conditionField.contains(ModelTUserInfo.FI_IM_USER_ID)) {
            checkInstance.setImUserId(instance.getImUserId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CONSTELLATION)) {
            checkInstance.setConstellation(instance.getConstellation());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HOBBY)) {
            checkInstance.setHobby(instance.getHobby());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SHOW_ACADEMY)) {
            checkInstance.setShowAcademy(instance.getShowAcademy());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL_263)) {
            checkInstance.setEmail263(instance.getEmail263());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CREATE_TIME_OF_USER)) {
            checkInstance.setCreateTimeOfUser(instance.getCreateTimeOfUser());
        }
        ModelTUserInfo selected = getOneByCond(Collections.singleton(ModelTUserInfo.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            update(instance, Collections.singleton(ModelTUserInfo.FI_ID), assembler);
            return instance;
        }
    }

    public ModelTUserInfo updateOrInsert(ModelTUserInfo instance, Set<String> conditionField) {
        return updateOrInsert(instance, conditionField, null);
    }

    @Transactional
    public ModelTUserInfo insertIfNoExist(ModelTUserInfo instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler) {
        if (assembler == null) {
            assembler = new BaseMultipleDaoAssembler();
        }
        ModelTUserInfo checkInstance = new ModelTUserInfo();
        if (conditionField.contains(ModelTUserInfo.FI_ID)) {
            checkInstance.setId(instance.getId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_MOBILE)) {
            checkInstance.setMobile(instance.getMobile());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL)) {
            checkInstance.setEmail(instance.getEmail());
        }
        if (conditionField.contains(ModelTUserInfo.FI_USERNAME)) {
            checkInstance.setUsername(instance.getUsername());
        }
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME)) {
            checkInstance.setNickname(instance.getNickname());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SEX)) {
            checkInstance.setSex(instance.getSex());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EDUCATION)) {
            checkInstance.setEducation(instance.getEducation());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CERT_TYPE)) {
            checkInstance.setCertType(instance.getCertType());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CERT_NO)) {
            checkInstance.setCertNo(instance.getCertNo());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PHONE)) {
            checkInstance.setPhone(instance.getPhone());
        }
        if (conditionField.contains(ModelTUserInfo.FI_BIRTHDAY)) {
            checkInstance.setBirthday(instance.getBirthday());
        }
        if (conditionField.contains(ModelTUserInfo.FI_APPLY_DATE)) {
            checkInstance.setApplyDate(instance.getApplyDate());
        }
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
            checkInstance.setUrgentLinker(instance.getUrgentLinker());
        }
        if (conditionField.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
            checkInstance.setUrgentMobile(instance.getUrgentMobile());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PASSWORD)) {
            checkInstance.setPassword(instance.getPassword());
        }
        if (conditionField.contains(ModelTUserInfo.FI_STATE)) {
            checkInstance.setState(instance.getState());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PROVINCE)) {
            checkInstance.setProvince(instance.getProvince());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CITY)) {
            checkInstance.setCity(instance.getCity());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REG_TIME)) {
            checkInstance.setRegTime(instance.getRegTime());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CREATOR)) {
            checkInstance.setCreator(instance.getCreator());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SCHOOL)) {
            checkInstance.setSchool(instance.getSchool());
        }
        if (conditionField.contains(ModelTUserInfo.FI_ADD_TYPE)) {
            checkInstance.setAddType(instance.getAddType());
        }
        if (conditionField.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
            checkInstance.setUpdateTime(instance.getUpdateTime());
        }
        if (conditionField.contains(ModelTUserInfo.FI_QQ_CODE)) {
            checkInstance.setQqCode(instance.getQqCode());
        }
        if (conditionField.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
            checkInstance.setLevelRemark(instance.getLevelRemark());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
            checkInstance.setRegServicePage(instance.getRegServicePage());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
            checkInstance.setRegLandingPage(instance.getRegLandingPage());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SYNC_BBS)) {
            checkInstance.setSyncBbs(instance.getSyncBbs());
        }
        if (conditionField.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
            checkInstance.setNicknameBbs(instance.getNicknameBbs());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
            checkInstance.setExamProvince(instance.getExamProvince());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
            checkInstance.setHadithsUserId(instance.getHadithsUserId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
            checkInstance.setMaterialProvince(instance.getMaterialProvince());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
            checkInstance.setHuluoUserId(instance.getHuluoUserId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REFERER)) {
            checkInstance.setReferer(instance.getReferer());
        }
        if (conditionField.contains(ModelTUserInfo.FI_IMAGE_URL)) {
            checkInstance.setImageUrl(instance.getImageUrl());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HOME_PHONE)) {
            checkInstance.setHomePhone(instance.getHomePhone());
        }
        if (conditionField.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
            checkInstance.setOfficePhone(instance.getOfficePhone());
        }
        if (conditionField.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
            checkInstance.setWeixinId(instance.getWeixinId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
            checkInstance.setEmergencyRel(instance.getEmergencyRel());
        }
        if (conditionField.contains(ModelTUserInfo.FI_ADDRESS)) {
            checkInstance.setAddress(instance.getAddress());
        }
        if (conditionField.contains(ModelTUserInfo.FI_POSTCODE)) {
            checkInstance.setPostcode(instance.getPostcode());
        }
        if (conditionField.contains(ModelTUserInfo.FI_PROFESSION)) {
            checkInstance.setProfession(instance.getProfession());
        }
        if (conditionField.contains(ModelTUserInfo.FI_WORK_YEAR)) {
            checkInstance.setWorkYear(instance.getWorkYear());
        }
        if (conditionField.contains(ModelTUserInfo.FI_QT_CERT)) {
            checkInstance.setQtCert(instance.getQtCert());
        }
        if (conditionField.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
            checkInstance.setTrainingCert(instance.getTrainingCert());
        }
        if (conditionField.contains(ModelTUserInfo.FI_REMARK)) {
            checkInstance.setRemark(instance.getRemark());
        }
        if (conditionField.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
            checkInstance.setGraduateAcademy(instance.getGraduateAcademy());
        }
        if (conditionField.contains(ModelTUserInfo.FI_INDUSTRY)) {
            checkInstance.setIndustry(instance.getIndustry());
        }
        if (conditionField.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
            checkInstance.setOperatorId(instance.getOperatorId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
            checkInstance.setFirstProjectIds(instance.getFirstProjectIds());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SIGNATURE)) {
            checkInstance.setSignature(instance.getSignature());
        }
        if (conditionField.contains(ModelTUserInfo.FI_IM_USER_ID)) {
            checkInstance.setImUserId(instance.getImUserId());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CONSTELLATION)) {
            checkInstance.setConstellation(instance.getConstellation());
        }
        if (conditionField.contains(ModelTUserInfo.FI_HOBBY)) {
            checkInstance.setHobby(instance.getHobby());
        }
        if (conditionField.contains(ModelTUserInfo.FI_SHOW_ACADEMY)) {
            checkInstance.setShowAcademy(instance.getShowAcademy());
        }
        if (conditionField.contains(ModelTUserInfo.FI_EMAIL_263)) {
            checkInstance.setEmail263(instance.getEmail263());
        }
        if (conditionField.contains(ModelTUserInfo.FI_CREATE_TIME_OF_USER)) {
            checkInstance.setCreateTimeOfUser(instance.getCreateTimeOfUser());
        }
        ModelTUserInfo selected = getOneByCond(Collections.singleton(ModelTUserInfo.FI_ID), assembler, checkInstance);
        assembler.increaseIndex();
        if (selected == null) {
            return insert(instance, assembler);
        } else {
            instance.setId(selected.getId());
            return instance;
        }
    }

    public ModelTUserInfo insertIfNoExist(ModelTUserInfo instance, Set<String> conditionField) {
        return insertIfNoExist(instance, conditionField, null);
    }

    public<TT> Map<TT, ModelTUserInfo> buildMap(List<ModelTUserInfo> list, String field) {
        Map<TT, ModelTUserInfo> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUserInfo item: list) {
            ret.put(ModelTUserInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), item);
        }
        return ret;
    }

    public<TT> Map<TT, List<ModelTUserInfo>> buildListMap(List<ModelTUserInfo> list, String field) {
        Map<TT, List<ModelTUserInfo>> ret = CollectionHelper.newMap();
        if (list == null) {
            return ret;
        }
        for (ModelTUserInfo item: list) {
            List<ModelTUserInfo> itemList = ret.get(ModelTUserInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            if (itemList == null) {
                itemList = CollectionHelper.newList();
            }
            itemList.add(item);
            ret.put(ModelTUserInfo.MAP_OBJ_MAPPER.<TT> getField(field, item), itemList);
        }
        return ret;
    }

    public<TT> List<TT> extractItemAsList(List<ModelTUserInfo> list, String field) {
        List<TT> ret = CollectionHelper.newList();
        if ((list == null)||(list.size() == 0)) {
            return ret;
        }
        if (ModelTUserInfo.FIELD_CLASS.containsKey(field)) {
            for (ModelTUserInfo item: list) {
                ret.add(ModelTUserInfo.MAP_OBJ_MAPPER.<TT> getField(field, item));
            }
        }
        return ret;
    }
}
