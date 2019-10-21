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
 * base DTO,represent for table :t_user_info
 * 	用户信息表
 */
public class ModelTUserInfo
    extends AbstractBaseModel
{
    public final static String PRIMARY_KEY_NAME = "id";
    public final static String DTO_TABLE_NAME = "t_user_info";
    public final static String DTO_DB_NAME = null;
    public final static Integer DTO_MODEL_TYPE = 0;
    /**
     * 对应数据库.t_user_info.id 字段
     * PK
     */
    Integer id;
    public final static String FI_ID = "id";
    /**
     * 对应数据库.t_user_info.mobile 字段
     * 手机
     */
    String mobile;
    public final static String FI_MOBILE = "mobile";
    /**
     * 对应数据库.t_user_info.email 字段
     * 邮箱
     */
    String email;
    public final static String FI_EMAIL = "email";
    /**
     * 对应数据库.t_user_info.username 字段
     * 用户姓名
     */
    String username;
    public final static String FI_USERNAME = "username";
    /**
     * 对应数据库.t_user_info.nickname 字段
     * 用户昵称
     */
    String nickname;
    public final static String FI_NICKNAME = "nickname";
    /**
     * 对应数据库.t_user_info.sex 字段
     * 
     */
    String sex;
    public final static String FI_SEX = "sex";
    /**
     * 对应数据库.t_user_info.education 字段
     * 学历
     */
    String education;
    public final static String FI_EDUCATION = "education";
    /**
     * 对应数据库.t_user_info.cert_type 字段
     * 证件类型
     */
    String certType;
    public final static String FI_CERT_TYPE = "cert_type";
    /**
     * 对应数据库.t_user_info.cert_no 字段
     * 证件号码
     */
    String certNo;
    public final static String FI_CERT_NO = "cert_no";
    /**
     * 对应数据库.t_user_info.phone 字段
     * 联系电话
     */
    String phone;
    public final static String FI_PHONE = "phone";
    /**
     * 对应数据库.t_user_info.birthday 字段
     * 出生日期
     */
    Date birthday;
    public final static String FI_BIRTHDAY = "birthday";
    /**
     * 对应数据库.t_user_info.apply_date 字段
     * 报名日期
     */
    Date applyDate;
    public final static String FI_APPLY_DATE = "apply_date";
    /**
     * 对应数据库.t_user_info.urgent_linker 字段
     * 紧急联系人
     */
    String urgentLinker;
    public final static String FI_URGENT_LINKER = "urgent_linker";
    /**
     * 对应数据库.t_user_info.urgent_mobile 字段
     * 紧急联系人手机
     */
    String urgentMobile;
    public final static String FI_URGENT_MOBILE = "urgent_mobile";
    /**
     * 对应数据库.t_user_info.password 字段
     * 密码
     */
    String password;
    public final static String FI_PASSWORD = "password";
    /**
     * 对应数据库.t_user_info.state 字段
     *  1：有效；2：无效；
     */
    String state;
    public final static String FI_STATE = "state";
    /**
     * 对应数据库.t_user_info.province 字段
     * 所在省
     */
    String province;
    public final static String FI_PROVINCE = "province";
    /**
     * 对应数据库.t_user_info.city 字段
     * 所在市
     */
    String city;
    public final static String FI_CITY = "city";
    /**
     * 对应数据库.t_user_info.reg_time 字段
     * 创建时间
     */
    String regTime;
    public final static String FI_REG_TIME = "reg_time";
    /**
     * 对应数据库.t_user_info.creator 字段
     * 创建人
     */
    String creator;
    public final static String FI_CREATOR = "creator";
    /**
     * 对应数据库.t_user_info.school 字段
     * 所属分校
     */
    String school;
    public final static String FI_SCHOOL = "school";
    /**
     * 对应数据库.t_user_info.add_type 字段
     * 数据添加方式(1:个人中心后,2:商品订单,3:外部接口,4:个人中心前台注册)
     */
    Integer addType;
    public final static String FI_ADD_TYPE = "add_type";
    /**
     * 对应数据库.t_user_info.update_time 字段
     * 
     */
    Date updateTime;
    public final static String FI_UPDATE_TIME = "update_time";
    /**
     * 对应数据库.t_user_info.qq_code 字段
     * QQ号
     */
    String qqCode;
    public final static String FI_QQ_CODE = "qq_code";
    /**
     * 对应数据库.t_user_info.level_remark 字段
     * 
     */
    String levelRemark;
    public final static String FI_LEVEL_REMARK = "level_remark";
    /**
     * 对应数据库.t_user_info.reg_servicePage 字段
     * 注册页
     */
    String regServicePage;
    public final static String FI_REG_SERVICEPAGE = "reg_servicePage";
    /**
     * 对应数据库.t_user_info.reg_landingPage 字段
     * 着落页
     */
    String regLandingPage;
    public final static String FI_REG_LANDINGPAGE = "reg_landingPage";
    /**
     * 对应数据库.t_user_info.sync_bbs 字段
     * 是否与论坛用户同步,0:未同步 1:已同步
     */
    Byte syncBbs;
    public final static String FI_SYNC_BBS = "sync_bbs";
    /**
     * 对应数据库.t_user_info.nickname_bbs 字段
     * 论坛昵称
     */
    String nicknameBbs;
    public final static String FI_NICKNAME_BBS = "nickname_bbs";
    /**
     * 对应数据库.t_user_info.exam_province 字段
     * 
     */
    String examProvince;
    public final static String FI_EXAM_PROVINCE = "exam_province";
    /**
     * 对应数据库.t_user_info.hadiths_user_id 字段
     * 
     */
    Integer hadithsUserId;
    public final static String FI_HADITHS_USER_ID = "hadiths_user_id";
    /**
     * 对应数据库.t_user_info.material_province 字段
     * 下载资料省份
     */
    Integer materialProvince;
    public final static String FI_MATERIAL_PROVINCE = "material_province";
    /**
     * 对应数据库.t_user_info.huluo_user_id 字段
     * 狐逻用户ID
     */
    Integer huluoUserId;
    public final static String FI_HULUO_USER_ID = "huluo_user_id";
    /**
     * 对应数据库.t_user_info.referer 字段
     * 
     */
    String referer;
    public final static String FI_REFERER = "referer";
    /**
     * 对应数据库.t_user_info.image_url 字段
     * 头像url
     */
    String imageUrl;
    public final static String FI_IMAGE_URL = "image_url";
    /**
     * 对应数据库.t_user_info.home_phone 字段
     * 家庭电话
     */
    String homePhone;
    public final static String FI_HOME_PHONE = "home_phone";
    /**
     * 对应数据库.t_user_info.office_phone 字段
     * 办公电话
     */
    String officePhone;
    public final static String FI_OFFICE_PHONE = "office_phone";
    /**
     * 对应数据库.t_user_info.weixin_id 字段
     * 微信
     */
    String weixinId;
    public final static String FI_WEIXIN_ID = "weixin_id";
    /**
     * 对应数据库.t_user_info.emergency_rel 字段
     * 紧急联系人关系
     */
    String emergencyRel;
    public final static String FI_EMERGENCY_REL = "emergency_rel";
    /**
     * 对应数据库.t_user_info.address 字段
     * 学员现居住地
     */
    String address;
    public final static String FI_ADDRESS = "address";
    /**
     * 对应数据库.t_user_info.postcode 字段
     * 现居住地邮编
     */
    String postcode;
    public final static String FI_POSTCODE = "postcode";
    /**
     * 对应数据库.t_user_info.profession 字段
     * 职业
     */
    String profession;
    public final static String FI_PROFESSION = "profession";
    /**
     * 对应数据库.t_user_info.work_year 字段
     * 参加工作年份
     */
    Date workYear;
    public final static String FI_WORK_YEAR = "work_year";
    /**
     * 对应数据库.t_user_info.qt_cert 字段
     * 资格证书
     */
    String qtCert;
    public final static String FI_QT_CERT = "qt_cert";
    /**
     * 对应数据库.t_user_info.training_cert 字段
     * 培训证书
     */
    String trainingCert;
    public final static String FI_TRAINING_CERT = "training_cert";
    /**
     * 对应数据库.t_user_info.remark 字段
     * 备注
     */
    String remark;
    public final static String FI_REMARK = "remark";
    /**
     * 对应数据库.t_user_info.graduate_academy 字段
     * 毕业院校
     */
    String graduateAcademy;
    public final static String FI_GRADUATE_ACADEMY = "graduate_academy";
    /**
     * 对应数据库.t_user_info.industry 字段
     * 所处行业
     */
    String industry;
    public final static String FI_INDUSTRY = "industry";
    /**
     * 对应数据库.t_user_info.operator_id 字段
     * 操作人
     */
    String operatorId;
    public final static String FI_OPERATOR_ID = "operator_id";
    /**
     * 对应数据库.t_user_info.first_project_ids 字段
     * 一级项目ID,支持多个ID,多个ID用,分隔
     */
    String firstProjectIds;
    public final static String FI_FIRST_PROJECT_IDS = "first_project_ids";
    /**
     * 对应数据库.t_user_info.signature 字段
     * 个人签名
     */
    String signature;
    public final static String FI_SIGNATURE = "signature";
    /**
     * 对应数据库.t_user_info.im_user_id 字段
     * IM用户Id
     */
    Long imUserId;
    public final static String FI_IM_USER_ID = "im_user_id";
    public final static Map<String, Object> FIELD_CLASS = CollectionHelper.<String, Object> mapBuilder().put(ModelTUserInfo.FI_ID, Integer.class).put(ModelTUserInfo.FI_MOBILE, String.class).put(ModelTUserInfo.FI_EMAIL, String.class).put(ModelTUserInfo.FI_USERNAME, String.class).put(ModelTUserInfo.FI_NICKNAME, String.class).put(ModelTUserInfo.FI_SEX, String.class).put(ModelTUserInfo.FI_EDUCATION, String.class).put(ModelTUserInfo.FI_CERT_TYPE, String.class).put(ModelTUserInfo.FI_CERT_NO, String.class).put(ModelTUserInfo.FI_PHONE, String.class).put(ModelTUserInfo.FI_BIRTHDAY, Date.class).put(ModelTUserInfo.FI_APPLY_DATE, Date.class).put(ModelTUserInfo.FI_URGENT_LINKER, String.class).put(ModelTUserInfo.FI_URGENT_MOBILE, String.class).put(ModelTUserInfo.FI_PASSWORD, String.class).put(ModelTUserInfo.FI_STATE, String.class).put(ModelTUserInfo.FI_PROVINCE, String.class).put(ModelTUserInfo.FI_CITY, String.class).put(ModelTUserInfo.FI_REG_TIME, String.class).put(ModelTUserInfo.FI_CREATOR, String.class).put(ModelTUserInfo.FI_SCHOOL, String.class).put(ModelTUserInfo.FI_ADD_TYPE, Integer.class).put(ModelTUserInfo.FI_UPDATE_TIME, Date.class).put(ModelTUserInfo.FI_QQ_CODE, String.class).put(ModelTUserInfo.FI_LEVEL_REMARK, String.class).put(ModelTUserInfo.FI_REG_SERVICEPAGE, String.class).put(ModelTUserInfo.FI_REG_LANDINGPAGE, String.class).put(ModelTUserInfo.FI_SYNC_BBS, Byte.class).put(ModelTUserInfo.FI_NICKNAME_BBS, String.class).put(ModelTUserInfo.FI_EXAM_PROVINCE, String.class).put(ModelTUserInfo.FI_HADITHS_USER_ID, Integer.class).put(ModelTUserInfo.FI_MATERIAL_PROVINCE, Integer.class).put(ModelTUserInfo.FI_HULUO_USER_ID, Integer.class).put(ModelTUserInfo.FI_REFERER, String.class).put(ModelTUserInfo.FI_IMAGE_URL, String.class).put(ModelTUserInfo.FI_HOME_PHONE, String.class).put(ModelTUserInfo.FI_OFFICE_PHONE, String.class).put(ModelTUserInfo.FI_WEIXIN_ID, String.class).put(ModelTUserInfo.FI_EMERGENCY_REL, String.class).put(ModelTUserInfo.FI_ADDRESS, String.class).put(ModelTUserInfo.FI_POSTCODE, String.class).put(ModelTUserInfo.FI_PROFESSION, String.class).put(ModelTUserInfo.FI_WORK_YEAR, Date.class).put(ModelTUserInfo.FI_QT_CERT, String.class).put(ModelTUserInfo.FI_TRAINING_CERT, String.class).put(ModelTUserInfo.FI_REMARK, String.class).put(ModelTUserInfo.FI_GRADUATE_ACADEMY, String.class).put(ModelTUserInfo.FI_INDUSTRY, String.class).put(ModelTUserInfo.FI_OPERATOR_ID, String.class).put(ModelTUserInfo.FI_FIRST_PROJECT_IDS, String.class).put(ModelTUserInfo.FI_SIGNATURE, String.class).put(ModelTUserInfo.FI_IM_USER_ID, Long.class).getMap();
    public final static Integer FIELD_COUNT = 52;
    public final static ResultSetMapperModelTUserInfo<ModelTUserInfo> RESULT_SET_OBJ_MAPPER = new ResultSetMapperModelTUserInfo<com.shangde.ent_portal.logical.dto.basepo.ModelTUserInfo>();
    public final static ByteMapMapperModelTUserInfo MAP_OBJ_MAPPER = new ByteMapMapperModelTUserInfo();

    public ModelTUserInfo() {
    }

    public Integer getId() {
        return id;
    }

    public ModelTUserInfo setId(Integer lId) {
        id = lId;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ModelTUserInfo setMobile(String lMobile) {
        mobile = lMobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ModelTUserInfo setEmail(String lEmail) {
        email = lEmail;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ModelTUserInfo setUsername(String lUsername) {
        username = lUsername;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public ModelTUserInfo setNickname(String lNickname) {
        nickname = lNickname;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public ModelTUserInfo setSex(String lSex) {
        sex = lSex;
        return this;
    }

    public String getEducation() {
        return education;
    }

    public ModelTUserInfo setEducation(String lEducation) {
        education = lEducation;
        return this;
    }

    public String getCertType() {
        return certType;
    }

    public ModelTUserInfo setCertType(String lCertType) {
        certType = lCertType;
        return this;
    }

    public String getCertNo() {
        return certNo;
    }

    public ModelTUserInfo setCertNo(String lCertNo) {
        certNo = lCertNo;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ModelTUserInfo setPhone(String lPhone) {
        phone = lPhone;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ModelTUserInfo setBirthday(Date lBirthday) {
        birthday = lBirthday;
        return this;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public ModelTUserInfo setApplyDate(Date lApplyDate) {
        applyDate = lApplyDate;
        return this;
    }

    public String getUrgentLinker() {
        return urgentLinker;
    }

    public ModelTUserInfo setUrgentLinker(String lUrgentLinker) {
        urgentLinker = lUrgentLinker;
        return this;
    }

    public String getUrgentMobile() {
        return urgentMobile;
    }

    public ModelTUserInfo setUrgentMobile(String lUrgentMobile) {
        urgentMobile = lUrgentMobile;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ModelTUserInfo setPassword(String lPassword) {
        password = lPassword;
        return this;
    }

    public String getState() {
        return state;
    }

    public ModelTUserInfo setState(String lState) {
        state = lState;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public ModelTUserInfo setProvince(String lProvince) {
        province = lProvince;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ModelTUserInfo setCity(String lCity) {
        city = lCity;
        return this;
    }

    public String getRegTime() {
        return regTime;
    }

    public ModelTUserInfo setRegTime(String lRegTime) {
        regTime = lRegTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ModelTUserInfo setCreator(String lCreator) {
        creator = lCreator;
        return this;
    }

    public String getSchool() {
        return school;
    }

    public ModelTUserInfo setSchool(String lSchool) {
        school = lSchool;
        return this;
    }

    public Integer getAddType() {
        return addType;
    }

    public ModelTUserInfo setAddType(Integer lAddType) {
        addType = lAddType;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ModelTUserInfo setUpdateTime(Date lUpdateTime) {
        updateTime = lUpdateTime;
        return this;
    }

    public String getQqCode() {
        return qqCode;
    }

    public ModelTUserInfo setQqCode(String lQqCode) {
        qqCode = lQqCode;
        return this;
    }

    public String getLevelRemark() {
        return levelRemark;
    }

    public ModelTUserInfo setLevelRemark(String lLevelRemark) {
        levelRemark = lLevelRemark;
        return this;
    }

    public String getRegServicePage() {
        return regServicePage;
    }

    public ModelTUserInfo setRegServicePage(String lRegServicePage) {
        regServicePage = lRegServicePage;
        return this;
    }

    public String getRegLandingPage() {
        return regLandingPage;
    }

    public ModelTUserInfo setRegLandingPage(String lRegLandingPage) {
        regLandingPage = lRegLandingPage;
        return this;
    }

    public Byte getSyncBbs() {
        return syncBbs;
    }

    public ModelTUserInfo setSyncBbs(Byte lSyncBbs) {
        syncBbs = lSyncBbs;
        return this;
    }

    public String getNicknameBbs() {
        return nicknameBbs;
    }

    public ModelTUserInfo setNicknameBbs(String lNicknameBbs) {
        nicknameBbs = lNicknameBbs;
        return this;
    }

    public String getExamProvince() {
        return examProvince;
    }

    public ModelTUserInfo setExamProvince(String lExamProvince) {
        examProvince = lExamProvince;
        return this;
    }

    public Integer getHadithsUserId() {
        return hadithsUserId;
    }

    public ModelTUserInfo setHadithsUserId(Integer lHadithsUserId) {
        hadithsUserId = lHadithsUserId;
        return this;
    }

    public Integer getMaterialProvince() {
        return materialProvince;
    }

    public ModelTUserInfo setMaterialProvince(Integer lMaterialProvince) {
        materialProvince = lMaterialProvince;
        return this;
    }

    public Integer getHuluoUserId() {
        return huluoUserId;
    }

    public ModelTUserInfo setHuluoUserId(Integer lHuluoUserId) {
        huluoUserId = lHuluoUserId;
        return this;
    }

    public String getReferer() {
        return referer;
    }

    public ModelTUserInfo setReferer(String lReferer) {
        referer = lReferer;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelTUserInfo setImageUrl(String lImageUrl) {
        imageUrl = lImageUrl;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public ModelTUserInfo setHomePhone(String lHomePhone) {
        homePhone = lHomePhone;
        return this;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public ModelTUserInfo setOfficePhone(String lOfficePhone) {
        officePhone = lOfficePhone;
        return this;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public ModelTUserInfo setWeixinId(String lWeixinId) {
        weixinId = lWeixinId;
        return this;
    }

    public String getEmergencyRel() {
        return emergencyRel;
    }

    public ModelTUserInfo setEmergencyRel(String lEmergencyRel) {
        emergencyRel = lEmergencyRel;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ModelTUserInfo setAddress(String lAddress) {
        address = lAddress;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public ModelTUserInfo setPostcode(String lPostcode) {
        postcode = lPostcode;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public ModelTUserInfo setProfession(String lProfession) {
        profession = lProfession;
        return this;
    }

    public Date getWorkYear() {
        return workYear;
    }

    public ModelTUserInfo setWorkYear(Date lWorkYear) {
        workYear = lWorkYear;
        return this;
    }

    public String getQtCert() {
        return qtCert;
    }

    public ModelTUserInfo setQtCert(String lQtCert) {
        qtCert = lQtCert;
        return this;
    }

    public String getTrainingCert() {
        return trainingCert;
    }

    public ModelTUserInfo setTrainingCert(String lTrainingCert) {
        trainingCert = lTrainingCert;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ModelTUserInfo setRemark(String lRemark) {
        remark = lRemark;
        return this;
    }

    public String getGraduateAcademy() {
        return graduateAcademy;
    }

    public ModelTUserInfo setGraduateAcademy(String lGraduateAcademy) {
        graduateAcademy = lGraduateAcademy;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public ModelTUserInfo setIndustry(String lIndustry) {
        industry = lIndustry;
        return this;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public ModelTUserInfo setOperatorId(String lOperatorId) {
        operatorId = lOperatorId;
        return this;
    }

    public String getFirstProjectIds() {
        return firstProjectIds;
    }

    public ModelTUserInfo setFirstProjectIds(String lFirstProjectIds) {
        firstProjectIds = lFirstProjectIds;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public ModelTUserInfo setSignature(String lSignature) {
        signature = lSignature;
        return this;
    }

    public Long getImUserId() {
        return imUserId;
    }

    public ModelTUserInfo setImUserId(Long lImUserId) {
        imUserId = lImUserId;
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
        if (getMobile()!= null) {
            return false;
        }
        if (getEmail()!= null) {
            return false;
        }
        if (getUsername()!= null) {
            return false;
        }
        if (getNickname()!= null) {
            return false;
        }
        if (getSex()!= null) {
            return false;
        }
        if (getEducation()!= null) {
            return false;
        }
        if (getCertType()!= null) {
            return false;
        }
        if (getCertNo()!= null) {
            return false;
        }
        if (getPhone()!= null) {
            return false;
        }
        if (getBirthday()!= null) {
            return false;
        }
        if (getApplyDate()!= null) {
            return false;
        }
        if (getUrgentLinker()!= null) {
            return false;
        }
        if (getUrgentMobile()!= null) {
            return false;
        }
        if (getPassword()!= null) {
            return false;
        }
        if (getState()!= null) {
            return false;
        }
        if (getProvince()!= null) {
            return false;
        }
        if (getCity()!= null) {
            return false;
        }
        if (getRegTime()!= null) {
            return false;
        }
        if (getCreator()!= null) {
            return false;
        }
        if (getSchool()!= null) {
            return false;
        }
        if (getAddType()!= null) {
            return false;
        }
        if (getUpdateTime()!= null) {
            return false;
        }
        if (getQqCode()!= null) {
            return false;
        }
        if (getLevelRemark()!= null) {
            return false;
        }
        if (getRegServicePage()!= null) {
            return false;
        }
        if (getRegLandingPage()!= null) {
            return false;
        }
        if (getSyncBbs()!= null) {
            return false;
        }
        if (getNicknameBbs()!= null) {
            return false;
        }
        if (getExamProvince()!= null) {
            return false;
        }
        if (getHadithsUserId()!= null) {
            return false;
        }
        if (getMaterialProvince()!= null) {
            return false;
        }
        if (getHuluoUserId()!= null) {
            return false;
        }
        if (getReferer()!= null) {
            return false;
        }
        if (getImageUrl()!= null) {
            return false;
        }
        if (getHomePhone()!= null) {
            return false;
        }
        if (getOfficePhone()!= null) {
            return false;
        }
        if (getWeixinId()!= null) {
            return false;
        }
        if (getEmergencyRel()!= null) {
            return false;
        }
        if (getAddress()!= null) {
            return false;
        }
        if (getPostcode()!= null) {
            return false;
        }
        if (getProfession()!= null) {
            return false;
        }
        if (getWorkYear()!= null) {
            return false;
        }
        if (getQtCert()!= null) {
            return false;
        }
        if (getTrainingCert()!= null) {
            return false;
        }
        if (getRemark()!= null) {
            return false;
        }
        if (getGraduateAcademy()!= null) {
            return false;
        }
        if (getIndustry()!= null) {
            return false;
        }
        if (getOperatorId()!= null) {
            return false;
        }
        if (getFirstProjectIds()!= null) {
            return false;
        }
        if (getSignature()!= null) {
            return false;
        }
        if (getImUserId()!= null) {
            return false;
        }
        return true;
    }

    public<FT extends _ObjMapper> FT getFeature(Class<FT> clazz) {
        if (RedisMapMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUserInfo.MAP_OBJ_MAPPER);
        }
        if (DbResultSetMapper.class.isAssignableFrom(clazz)) {
            return ((FT) ModelTUserInfo.RESULT_SET_OBJ_MAPPER);
        }
        return null;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("{").append("id").append(":").append(id).append("}\n");
        ret.append("{").append("mobile").append(":").append(mobile).append("}\n");
        ret.append("{").append("email").append(":").append(email).append("}\n");
        ret.append("{").append("username").append(":").append(username).append("}\n");
        ret.append("{").append("nickname").append(":").append(nickname).append("}\n");
        ret.append("{").append("sex").append(":").append(sex).append("}\n");
        ret.append("{").append("education").append(":").append(education).append("}\n");
        ret.append("{").append("certType").append(":").append(certType).append("}\n");
        ret.append("{").append("certNo").append(":").append(certNo).append("}\n");
        ret.append("{").append("phone").append(":").append(phone).append("}\n");
        ret.append("{").append("birthday").append(":").append(birthday).append("}\n");
        ret.append("{").append("applyDate").append(":").append(applyDate).append("}\n");
        ret.append("{").append("urgentLinker").append(":").append(urgentLinker).append("}\n");
        ret.append("{").append("urgentMobile").append(":").append(urgentMobile).append("}\n");
        ret.append("{").append("password").append(":").append(password).append("}\n");
        ret.append("{").append("state").append(":").append(state).append("}\n");
        ret.append("{").append("province").append(":").append(province).append("}\n");
        ret.append("{").append("city").append(":").append(city).append("}\n");
        ret.append("{").append("regTime").append(":").append(regTime).append("}\n");
        ret.append("{").append("creator").append(":").append(creator).append("}\n");
        ret.append("{").append("school").append(":").append(school).append("}\n");
        ret.append("{").append("addType").append(":").append(addType).append("}\n");
        ret.append("{").append("updateTime").append(":").append(updateTime).append("}\n");
        ret.append("{").append("qqCode").append(":").append(qqCode).append("}\n");
        ret.append("{").append("levelRemark").append(":").append(levelRemark).append("}\n");
        ret.append("{").append("regServicePage").append(":").append(regServicePage).append("}\n");
        ret.append("{").append("regLandingPage").append(":").append(regLandingPage).append("}\n");
        ret.append("{").append("syncBbs").append(":").append(syncBbs).append("}\n");
        ret.append("{").append("nicknameBbs").append(":").append(nicknameBbs).append("}\n");
        ret.append("{").append("examProvince").append(":").append(examProvince).append("}\n");
        ret.append("{").append("hadithsUserId").append(":").append(hadithsUserId).append("}\n");
        ret.append("{").append("materialProvince").append(":").append(materialProvince).append("}\n");
        ret.append("{").append("huluoUserId").append(":").append(huluoUserId).append("}\n");
        ret.append("{").append("referer").append(":").append(referer).append("}\n");
        ret.append("{").append("imageUrl").append(":").append(imageUrl).append("}\n");
        ret.append("{").append("homePhone").append(":").append(homePhone).append("}\n");
        ret.append("{").append("officePhone").append(":").append(officePhone).append("}\n");
        ret.append("{").append("weixinId").append(":").append(weixinId).append("}\n");
        ret.append("{").append("emergencyRel").append(":").append(emergencyRel).append("}\n");
        ret.append("{").append("address").append(":").append(address).append("}\n");
        ret.append("{").append("postcode").append(":").append(postcode).append("}\n");
        ret.append("{").append("profession").append(":").append(profession).append("}\n");
        ret.append("{").append("workYear").append(":").append(workYear).append("}\n");
        ret.append("{").append("qtCert").append(":").append(qtCert).append("}\n");
        ret.append("{").append("trainingCert").append(":").append(trainingCert).append("}\n");
        ret.append("{").append("remark").append(":").append(remark).append("}\n");
        ret.append("{").append("graduateAcademy").append(":").append(graduateAcademy).append("}\n");
        ret.append("{").append("industry").append(":").append(industry).append("}\n");
        ret.append("{").append("operatorId").append(":").append(operatorId).append("}\n");
        ret.append("{").append("firstProjectIds").append(":").append(firstProjectIds).append("}\n");
        ret.append("{").append("signature").append(":").append(signature).append("}\n");
        ret.append("{").append("imUserId").append(":").append(imUserId).append("}\n");
        return ret.toString();
    }

    public static class ByteMapMapperModelTUserInfo
        implements RedisMapMapper<ModelTUserInfo>
    {

        @Override
        public ModelTUserInfo fromMap(Map<byte[], byte[]> map) {
            ModelTUserInfo instance = new ModelTUserInfo();
            Set<Map.Entry<byte[], byte[]>> entries = map.entrySet();
            for (Map.Entry<byte[], byte[]> entry: entries) {
                String field = new String(entry.getKey());
                if (field.equals(ModelTUserInfo.FI_ID)) {
                    instance.setId(mapToFieldId(entry.getValue()));
                } else {
                    if (field.equals(ModelTUserInfo.FI_MOBILE)) {
                        instance.setMobile(mapToFieldMobile(entry.getValue()));
                    } else {
                        if (field.equals(ModelTUserInfo.FI_EMAIL)) {
                            instance.setEmail(mapToFieldEmail(entry.getValue()));
                        } else {
                            if (field.equals(ModelTUserInfo.FI_USERNAME)) {
                                instance.setUsername(mapToFieldUsername(entry.getValue()));
                            } else {
                                if (field.equals(ModelTUserInfo.FI_NICKNAME)) {
                                    instance.setNickname(mapToFieldNickname(entry.getValue()));
                                } else {
                                    if (field.equals(ModelTUserInfo.FI_SEX)) {
                                        instance.setSex(mapToFieldSex(entry.getValue()));
                                    } else {
                                        if (field.equals(ModelTUserInfo.FI_EDUCATION)) {
                                            instance.setEducation(mapToFieldEducation(entry.getValue()));
                                        } else {
                                            if (field.equals(ModelTUserInfo.FI_CERT_TYPE)) {
                                                instance.setCertType(mapToFieldCertType(entry.getValue()));
                                            } else {
                                                if (field.equals(ModelTUserInfo.FI_CERT_NO)) {
                                                    instance.setCertNo(mapToFieldCertNo(entry.getValue()));
                                                } else {
                                                    if (field.equals(ModelTUserInfo.FI_PHONE)) {
                                                        instance.setPhone(mapToFieldPhone(entry.getValue()));
                                                    } else {
                                                        if (field.equals(ModelTUserInfo.FI_BIRTHDAY)) {
                                                            instance.setBirthday(mapToFieldBirthday(entry.getValue()));
                                                        } else {
                                                            if (field.equals(ModelTUserInfo.FI_APPLY_DATE)) {
                                                                instance.setApplyDate(mapToFieldApplyDate(entry.getValue()));
                                                            } else {
                                                                if (field.equals(ModelTUserInfo.FI_URGENT_LINKER)) {
                                                                    instance.setUrgentLinker(mapToFieldUrgentLinker(entry.getValue()));
                                                                } else {
                                                                    if (field.equals(ModelTUserInfo.FI_URGENT_MOBILE)) {
                                                                        instance.setUrgentMobile(mapToFieldUrgentMobile(entry.getValue()));
                                                                    } else {
                                                                        if (field.equals(ModelTUserInfo.FI_PASSWORD)) {
                                                                            instance.setPassword(mapToFieldPassword(entry.getValue()));
                                                                        } else {
                                                                            if (field.equals(ModelTUserInfo.FI_STATE)) {
                                                                                instance.setState(mapToFieldState(entry.getValue()));
                                                                            } else {
                                                                                if (field.equals(ModelTUserInfo.FI_PROVINCE)) {
                                                                                    instance.setProvince(mapToFieldProvince(entry.getValue()));
                                                                                } else {
                                                                                    if (field.equals(ModelTUserInfo.FI_CITY)) {
                                                                                        instance.setCity(mapToFieldCity(entry.getValue()));
                                                                                    } else {
                                                                                        if (field.equals(ModelTUserInfo.FI_REG_TIME)) {
                                                                                            instance.setRegTime(mapToFieldRegTime(entry.getValue()));
                                                                                        } else {
                                                                                            if (field.equals(ModelTUserInfo.FI_CREATOR)) {
                                                                                                instance.setCreator(mapToFieldCreator(entry.getValue()));
                                                                                            } else {
                                                                                                if (field.equals(ModelTUserInfo.FI_SCHOOL)) {
                                                                                                    instance.setSchool(mapToFieldSchool(entry.getValue()));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTUserInfo.FI_ADD_TYPE)) {
                                                                                                        instance.setAddType(mapToFieldAddType(entry.getValue()));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTUserInfo.FI_UPDATE_TIME)) {
                                                                                                            instance.setUpdateTime(mapToFieldUpdateTime(entry.getValue()));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTUserInfo.FI_QQ_CODE)) {
                                                                                                                instance.setQqCode(mapToFieldQqCode(entry.getValue()));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTUserInfo.FI_LEVEL_REMARK)) {
                                                                                                                    instance.setLevelRemark(mapToFieldLevelRemark(entry.getValue()));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
                                                                                                                        instance.setRegServicePage(mapToFieldRegServicePage(entry.getValue()));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
                                                                                                                            instance.setRegLandingPage(mapToFieldRegLandingPage(entry.getValue()));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTUserInfo.FI_SYNC_BBS)) {
                                                                                                                                instance.setSyncBbs(mapToFieldSyncBbs(entry.getValue()));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTUserInfo.FI_NICKNAME_BBS)) {
                                                                                                                                    instance.setNicknameBbs(mapToFieldNicknameBbs(entry.getValue()));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTUserInfo.FI_EXAM_PROVINCE)) {
                                                                                                                                        instance.setExamProvince(mapToFieldExamProvince(entry.getValue()));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTUserInfo.FI_HADITHS_USER_ID)) {
                                                                                                                                            instance.setHadithsUserId(mapToFieldHadithsUserId(entry.getValue()));
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
                                                                                                                                                instance.setMaterialProvince(mapToFieldMaterialProvince(entry.getValue()));
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTUserInfo.FI_HULUO_USER_ID)) {
                                                                                                                                                    instance.setHuluoUserId(mapToFieldHuluoUserId(entry.getValue()));
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_REFERER)) {
                                                                                                                                                        instance.setReferer(mapToFieldReferer(entry.getValue()));
                                                                                                                                                    } else {
                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_IMAGE_URL)) {
                                                                                                                                                            instance.setImageUrl(mapToFieldImageUrl(entry.getValue()));
                                                                                                                                                        } else {
                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_HOME_PHONE)) {
                                                                                                                                                                instance.setHomePhone(mapToFieldHomePhone(entry.getValue()));
                                                                                                                                                            } else {
                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_OFFICE_PHONE)) {
                                                                                                                                                                    instance.setOfficePhone(mapToFieldOfficePhone(entry.getValue()));
                                                                                                                                                                } else {
                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_WEIXIN_ID)) {
                                                                                                                                                                        instance.setWeixinId(mapToFieldWeixinId(entry.getValue()));
                                                                                                                                                                    } else {
                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_EMERGENCY_REL)) {
                                                                                                                                                                            instance.setEmergencyRel(mapToFieldEmergencyRel(entry.getValue()));
                                                                                                                                                                        } else {
                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_ADDRESS)) {
                                                                                                                                                                                instance.setAddress(mapToFieldAddress(entry.getValue()));
                                                                                                                                                                            } else {
                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_POSTCODE)) {
                                                                                                                                                                                    instance.setPostcode(mapToFieldPostcode(entry.getValue()));
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_PROFESSION)) {
                                                                                                                                                                                        instance.setProfession(mapToFieldProfession(entry.getValue()));
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_WORK_YEAR)) {
                                                                                                                                                                                            instance.setWorkYear(mapToFieldWorkYear(entry.getValue()));
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_QT_CERT)) {
                                                                                                                                                                                                instance.setQtCert(mapToFieldQtCert(entry.getValue()));
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_TRAINING_CERT)) {
                                                                                                                                                                                                    instance.setTrainingCert(mapToFieldTrainingCert(entry.getValue()));
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_REMARK)) {
                                                                                                                                                                                                        instance.setRemark(mapToFieldRemark(entry.getValue()));
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
                                                                                                                                                                                                            instance.setGraduateAcademy(mapToFieldGraduateAcademy(entry.getValue()));
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_INDUSTRY)) {
                                                                                                                                                                                                                instance.setIndustry(mapToFieldIndustry(entry.getValue()));
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_OPERATOR_ID)) {
                                                                                                                                                                                                                    instance.setOperatorId(mapToFieldOperatorId(entry.getValue()));
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
                                                                                                                                                                                                                        instance.setFirstProjectIds(mapToFieldFirstProjectIds(entry.getValue()));
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_SIGNATURE)) {
                                                                                                                                                                                                                            instance.setSignature(mapToFieldSignature(entry.getValue()));
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_IM_USER_ID)) {
                                                                                                                                                                                                                                instance.setImUserId(mapToFieldImUserId(entry.getValue()));
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

        protected String mapToFieldMobile(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldEmail(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUsername(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldNickname(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldSex(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldEducation(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCertType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCertNo(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPhone(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldBirthday(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected Date mapToFieldApplyDate(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldUrgentLinker(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldUrgentMobile(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPassword(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldState(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldProvince(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCity(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldRegTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldCreator(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldSchool(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldAddType(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Date mapToFieldUpdateTime(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldQqCode(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldLevelRemark(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldRegServicePage(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldRegLandingPage(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Byte mapToFieldSyncBbs(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Byte.class);
        }

        protected String mapToFieldNicknameBbs(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldExamProvince(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Integer mapToFieldHadithsUserId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldMaterialProvince(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected Integer mapToFieldHuluoUserId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Integer.class);
        }

        protected String mapToFieldReferer(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldImageUrl(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldHomePhone(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldOfficePhone(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldWeixinId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldEmergencyRel(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldAddress(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldPostcode(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldProfession(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Date mapToFieldWorkYear(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Date.class);
        }

        protected String mapToFieldQtCert(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldTrainingCert(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldRemark(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldGraduateAcademy(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldIndustry(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldOperatorId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldFirstProjectIds(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected String mapToFieldSignature(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, String.class);
        }

        protected Long mapToFieldImUserId(byte[] bytes) {
            return TypeConstantHelper.toObject(bytes, Long.class);
        }

        @Override
        public Map<byte[], byte[]> toMap(ModelTUserInfo instance) {
            Map<byte[], byte[]> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            byte[] valueId = mapFromFieldId(instance.getId());
            ret.put(ModelTUserInfo.FI_ID.getBytes(), valueId);
            byte[] valueMobile = mapFromFieldMobile(instance.getMobile());
            ret.put(ModelTUserInfo.FI_MOBILE.getBytes(), valueMobile);
            byte[] valueEmail = mapFromFieldEmail(instance.getEmail());
            ret.put(ModelTUserInfo.FI_EMAIL.getBytes(), valueEmail);
            byte[] valueUsername = mapFromFieldUsername(instance.getUsername());
            ret.put(ModelTUserInfo.FI_USERNAME.getBytes(), valueUsername);
            byte[] valueNickname = mapFromFieldNickname(instance.getNickname());
            ret.put(ModelTUserInfo.FI_NICKNAME.getBytes(), valueNickname);
            byte[] valueSex = mapFromFieldSex(instance.getSex());
            ret.put(ModelTUserInfo.FI_SEX.getBytes(), valueSex);
            byte[] valueEducation = mapFromFieldEducation(instance.getEducation());
            ret.put(ModelTUserInfo.FI_EDUCATION.getBytes(), valueEducation);
            byte[] valueCert_type = mapFromFieldCertType(instance.getCertType());
            ret.put(ModelTUserInfo.FI_CERT_TYPE.getBytes(), valueCert_type);
            byte[] valueCert_no = mapFromFieldCertNo(instance.getCertNo());
            ret.put(ModelTUserInfo.FI_CERT_NO.getBytes(), valueCert_no);
            byte[] valuePhone = mapFromFieldPhone(instance.getPhone());
            ret.put(ModelTUserInfo.FI_PHONE.getBytes(), valuePhone);
            byte[] valueBirthday = mapFromFieldBirthday(instance.getBirthday());
            ret.put(ModelTUserInfo.FI_BIRTHDAY.getBytes(), valueBirthday);
            byte[] valueApply_date = mapFromFieldApplyDate(instance.getApplyDate());
            ret.put(ModelTUserInfo.FI_APPLY_DATE.getBytes(), valueApply_date);
            byte[] valueUrgent_linker = mapFromFieldUrgentLinker(instance.getUrgentLinker());
            ret.put(ModelTUserInfo.FI_URGENT_LINKER.getBytes(), valueUrgent_linker);
            byte[] valueUrgent_mobile = mapFromFieldUrgentMobile(instance.getUrgentMobile());
            ret.put(ModelTUserInfo.FI_URGENT_MOBILE.getBytes(), valueUrgent_mobile);
            byte[] valuePassword = mapFromFieldPassword(instance.getPassword());
            ret.put(ModelTUserInfo.FI_PASSWORD.getBytes(), valuePassword);
            byte[] valueState = mapFromFieldState(instance.getState());
            ret.put(ModelTUserInfo.FI_STATE.getBytes(), valueState);
            byte[] valueProvince = mapFromFieldProvince(instance.getProvince());
            ret.put(ModelTUserInfo.FI_PROVINCE.getBytes(), valueProvince);
            byte[] valueCity = mapFromFieldCity(instance.getCity());
            ret.put(ModelTUserInfo.FI_CITY.getBytes(), valueCity);
            byte[] valueReg_time = mapFromFieldRegTime(instance.getRegTime());
            ret.put(ModelTUserInfo.FI_REG_TIME.getBytes(), valueReg_time);
            byte[] valueCreator = mapFromFieldCreator(instance.getCreator());
            ret.put(ModelTUserInfo.FI_CREATOR.getBytes(), valueCreator);
            byte[] valueSchool = mapFromFieldSchool(instance.getSchool());
            ret.put(ModelTUserInfo.FI_SCHOOL.getBytes(), valueSchool);
            byte[] valueAdd_type = mapFromFieldAddType(instance.getAddType());
            ret.put(ModelTUserInfo.FI_ADD_TYPE.getBytes(), valueAdd_type);
            byte[] valueUpdate_time = mapFromFieldUpdateTime(instance.getUpdateTime());
            ret.put(ModelTUserInfo.FI_UPDATE_TIME.getBytes(), valueUpdate_time);
            byte[] valueQq_code = mapFromFieldQqCode(instance.getQqCode());
            ret.put(ModelTUserInfo.FI_QQ_CODE.getBytes(), valueQq_code);
            byte[] valueLevel_remark = mapFromFieldLevelRemark(instance.getLevelRemark());
            ret.put(ModelTUserInfo.FI_LEVEL_REMARK.getBytes(), valueLevel_remark);
            byte[] valueReg_servicePage = mapFromFieldRegServicePage(instance.getRegServicePage());
            ret.put(ModelTUserInfo.FI_REG_SERVICEPAGE.getBytes(), valueReg_servicePage);
            byte[] valueReg_landingPage = mapFromFieldRegLandingPage(instance.getRegLandingPage());
            ret.put(ModelTUserInfo.FI_REG_LANDINGPAGE.getBytes(), valueReg_landingPage);
            byte[] valueSync_bbs = mapFromFieldSyncBbs(instance.getSyncBbs());
            ret.put(ModelTUserInfo.FI_SYNC_BBS.getBytes(), valueSync_bbs);
            byte[] valueNickname_bbs = mapFromFieldNicknameBbs(instance.getNicknameBbs());
            ret.put(ModelTUserInfo.FI_NICKNAME_BBS.getBytes(), valueNickname_bbs);
            byte[] valueExam_province = mapFromFieldExamProvince(instance.getExamProvince());
            ret.put(ModelTUserInfo.FI_EXAM_PROVINCE.getBytes(), valueExam_province);
            byte[] valueHadiths_user_id = mapFromFieldHadithsUserId(instance.getHadithsUserId());
            ret.put(ModelTUserInfo.FI_HADITHS_USER_ID.getBytes(), valueHadiths_user_id);
            byte[] valueMaterial_province = mapFromFieldMaterialProvince(instance.getMaterialProvince());
            ret.put(ModelTUserInfo.FI_MATERIAL_PROVINCE.getBytes(), valueMaterial_province);
            byte[] valueHuluo_user_id = mapFromFieldHuluoUserId(instance.getHuluoUserId());
            ret.put(ModelTUserInfo.FI_HULUO_USER_ID.getBytes(), valueHuluo_user_id);
            byte[] valueReferer = mapFromFieldReferer(instance.getReferer());
            ret.put(ModelTUserInfo.FI_REFERER.getBytes(), valueReferer);
            byte[] valueImage_url = mapFromFieldImageUrl(instance.getImageUrl());
            ret.put(ModelTUserInfo.FI_IMAGE_URL.getBytes(), valueImage_url);
            byte[] valueHome_phone = mapFromFieldHomePhone(instance.getHomePhone());
            ret.put(ModelTUserInfo.FI_HOME_PHONE.getBytes(), valueHome_phone);
            byte[] valueOffice_phone = mapFromFieldOfficePhone(instance.getOfficePhone());
            ret.put(ModelTUserInfo.FI_OFFICE_PHONE.getBytes(), valueOffice_phone);
            byte[] valueWeixin_id = mapFromFieldWeixinId(instance.getWeixinId());
            ret.put(ModelTUserInfo.FI_WEIXIN_ID.getBytes(), valueWeixin_id);
            byte[] valueEmergency_rel = mapFromFieldEmergencyRel(instance.getEmergencyRel());
            ret.put(ModelTUserInfo.FI_EMERGENCY_REL.getBytes(), valueEmergency_rel);
            byte[] valueAddress = mapFromFieldAddress(instance.getAddress());
            ret.put(ModelTUserInfo.FI_ADDRESS.getBytes(), valueAddress);
            byte[] valuePostcode = mapFromFieldPostcode(instance.getPostcode());
            ret.put(ModelTUserInfo.FI_POSTCODE.getBytes(), valuePostcode);
            byte[] valueProfession = mapFromFieldProfession(instance.getProfession());
            ret.put(ModelTUserInfo.FI_PROFESSION.getBytes(), valueProfession);
            byte[] valueWork_year = mapFromFieldWorkYear(instance.getWorkYear());
            ret.put(ModelTUserInfo.FI_WORK_YEAR.getBytes(), valueWork_year);
            byte[] valueQt_cert = mapFromFieldQtCert(instance.getQtCert());
            ret.put(ModelTUserInfo.FI_QT_CERT.getBytes(), valueQt_cert);
            byte[] valueTraining_cert = mapFromFieldTrainingCert(instance.getTrainingCert());
            ret.put(ModelTUserInfo.FI_TRAINING_CERT.getBytes(), valueTraining_cert);
            byte[] valueRemark = mapFromFieldRemark(instance.getRemark());
            ret.put(ModelTUserInfo.FI_REMARK.getBytes(), valueRemark);
            byte[] valueGraduate_academy = mapFromFieldGraduateAcademy(instance.getGraduateAcademy());
            ret.put(ModelTUserInfo.FI_GRADUATE_ACADEMY.getBytes(), valueGraduate_academy);
            byte[] valueIndustry = mapFromFieldIndustry(instance.getIndustry());
            ret.put(ModelTUserInfo.FI_INDUSTRY.getBytes(), valueIndustry);
            byte[] valueOperator_id = mapFromFieldOperatorId(instance.getOperatorId());
            ret.put(ModelTUserInfo.FI_OPERATOR_ID.getBytes(), valueOperator_id);
            byte[] valueFirst_project_ids = mapFromFieldFirstProjectIds(instance.getFirstProjectIds());
            ret.put(ModelTUserInfo.FI_FIRST_PROJECT_IDS.getBytes(), valueFirst_project_ids);
            byte[] valueSignature = mapFromFieldSignature(instance.getSignature());
            ret.put(ModelTUserInfo.FI_SIGNATURE.getBytes(), valueSignature);
            byte[] valueIm_user_id = mapFromFieldImUserId(instance.getImUserId());
            ret.put(ModelTUserInfo.FI_IM_USER_ID.getBytes(), valueIm_user_id);
            return ret;
        }

        protected byte[] mapFromFieldId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMobile(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEmail(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUsername(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldNickname(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSex(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEducation(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCertType(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCertNo(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPhone(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldBirthday(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldApplyDate(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUrgentLinker(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUrgentMobile(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPassword(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldState(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldProvince(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCity(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRegTime(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldCreator(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSchool(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAddType(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldUpdateTime(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldQqCode(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldLevelRemark(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRegServicePage(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRegLandingPage(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSyncBbs(Byte field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldNicknameBbs(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldExamProvince(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldHadithsUserId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldMaterialProvince(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldHuluoUserId(Integer field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldReferer(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldImageUrl(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldHomePhone(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldOfficePhone(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldWeixinId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldEmergencyRel(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldAddress(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldPostcode(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldProfession(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldWorkYear(Date field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldQtCert(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldTrainingCert(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldRemark(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldGraduateAcademy(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldIndustry(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldOperatorId(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldFirstProjectIds(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldSignature(String field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        protected byte[] mapFromFieldImUserId(Long field) {
            byte[] ret = TypeConstantHelper.fromObjectBin(field);
            return ret;
        }

        @Override
        public Map<String, Object> toCommonMap(ModelTUserInfo instance) {
            Map<String, Object> ret = CollectionHelper.newMap();
            if (instance == null) {
                return ret;
            }
            Integer dId = instance.getId();
            if (dId!= null) {
                ret.put(ModelTUserInfo.FI_ID, dId);
            }
            String dMobile = instance.getMobile();
            if (dMobile!= null) {
                ret.put(ModelTUserInfo.FI_MOBILE, dMobile);
            }
            String dEmail = instance.getEmail();
            if (dEmail!= null) {
                ret.put(ModelTUserInfo.FI_EMAIL, dEmail);
            }
            String dUsername = instance.getUsername();
            if (dUsername!= null) {
                ret.put(ModelTUserInfo.FI_USERNAME, dUsername);
            }
            String dNickname = instance.getNickname();
            if (dNickname!= null) {
                ret.put(ModelTUserInfo.FI_NICKNAME, dNickname);
            }
            String dSex = instance.getSex();
            if (dSex!= null) {
                ret.put(ModelTUserInfo.FI_SEX, dSex);
            }
            String dEducation = instance.getEducation();
            if (dEducation!= null) {
                ret.put(ModelTUserInfo.FI_EDUCATION, dEducation);
            }
            String dCert_type = instance.getCertType();
            if (dCert_type!= null) {
                ret.put(ModelTUserInfo.FI_CERT_TYPE, dCert_type);
            }
            String dCert_no = instance.getCertNo();
            if (dCert_no!= null) {
                ret.put(ModelTUserInfo.FI_CERT_NO, dCert_no);
            }
            String dPhone = instance.getPhone();
            if (dPhone!= null) {
                ret.put(ModelTUserInfo.FI_PHONE, dPhone);
            }
            Date dBirthday = instance.getBirthday();
            if (dBirthday!= null) {
                ret.put(ModelTUserInfo.FI_BIRTHDAY, dBirthday);
            }
            Date dApply_date = instance.getApplyDate();
            if (dApply_date!= null) {
                ret.put(ModelTUserInfo.FI_APPLY_DATE, dApply_date);
            }
            String dUrgent_linker = instance.getUrgentLinker();
            if (dUrgent_linker!= null) {
                ret.put(ModelTUserInfo.FI_URGENT_LINKER, dUrgent_linker);
            }
            String dUrgent_mobile = instance.getUrgentMobile();
            if (dUrgent_mobile!= null) {
                ret.put(ModelTUserInfo.FI_URGENT_MOBILE, dUrgent_mobile);
            }
            String dPassword = instance.getPassword();
            if (dPassword!= null) {
                ret.put(ModelTUserInfo.FI_PASSWORD, dPassword);
            }
            String dState = instance.getState();
            if (dState!= null) {
                ret.put(ModelTUserInfo.FI_STATE, dState);
            }
            String dProvince = instance.getProvince();
            if (dProvince!= null) {
                ret.put(ModelTUserInfo.FI_PROVINCE, dProvince);
            }
            String dCity = instance.getCity();
            if (dCity!= null) {
                ret.put(ModelTUserInfo.FI_CITY, dCity);
            }
            String dReg_time = instance.getRegTime();
            if (dReg_time!= null) {
                ret.put(ModelTUserInfo.FI_REG_TIME, dReg_time);
            }
            String dCreator = instance.getCreator();
            if (dCreator!= null) {
                ret.put(ModelTUserInfo.FI_CREATOR, dCreator);
            }
            String dSchool = instance.getSchool();
            if (dSchool!= null) {
                ret.put(ModelTUserInfo.FI_SCHOOL, dSchool);
            }
            Integer dAdd_type = instance.getAddType();
            if (dAdd_type!= null) {
                ret.put(ModelTUserInfo.FI_ADD_TYPE, dAdd_type);
            }
            Date dUpdate_time = instance.getUpdateTime();
            if (dUpdate_time!= null) {
                ret.put(ModelTUserInfo.FI_UPDATE_TIME, dUpdate_time);
            }
            String dQq_code = instance.getQqCode();
            if (dQq_code!= null) {
                ret.put(ModelTUserInfo.FI_QQ_CODE, dQq_code);
            }
            String dLevel_remark = instance.getLevelRemark();
            if (dLevel_remark!= null) {
                ret.put(ModelTUserInfo.FI_LEVEL_REMARK, dLevel_remark);
            }
            String dReg_servicePage = instance.getRegServicePage();
            if (dReg_servicePage!= null) {
                ret.put(ModelTUserInfo.FI_REG_SERVICEPAGE, dReg_servicePage);
            }
            String dReg_landingPage = instance.getRegLandingPage();
            if (dReg_landingPage!= null) {
                ret.put(ModelTUserInfo.FI_REG_LANDINGPAGE, dReg_landingPage);
            }
            Byte dSync_bbs = instance.getSyncBbs();
            if (dSync_bbs!= null) {
                ret.put(ModelTUserInfo.FI_SYNC_BBS, dSync_bbs);
            }
            String dNickname_bbs = instance.getNicknameBbs();
            if (dNickname_bbs!= null) {
                ret.put(ModelTUserInfo.FI_NICKNAME_BBS, dNickname_bbs);
            }
            String dExam_province = instance.getExamProvince();
            if (dExam_province!= null) {
                ret.put(ModelTUserInfo.FI_EXAM_PROVINCE, dExam_province);
            }
            Integer dHadiths_user_id = instance.getHadithsUserId();
            if (dHadiths_user_id!= null) {
                ret.put(ModelTUserInfo.FI_HADITHS_USER_ID, dHadiths_user_id);
            }
            Integer dMaterial_province = instance.getMaterialProvince();
            if (dMaterial_province!= null) {
                ret.put(ModelTUserInfo.FI_MATERIAL_PROVINCE, dMaterial_province);
            }
            Integer dHuluo_user_id = instance.getHuluoUserId();
            if (dHuluo_user_id!= null) {
                ret.put(ModelTUserInfo.FI_HULUO_USER_ID, dHuluo_user_id);
            }
            String dReferer = instance.getReferer();
            if (dReferer!= null) {
                ret.put(ModelTUserInfo.FI_REFERER, dReferer);
            }
            String dImage_url = instance.getImageUrl();
            if (dImage_url!= null) {
                ret.put(ModelTUserInfo.FI_IMAGE_URL, dImage_url);
            }
            String dHome_phone = instance.getHomePhone();
            if (dHome_phone!= null) {
                ret.put(ModelTUserInfo.FI_HOME_PHONE, dHome_phone);
            }
            String dOffice_phone = instance.getOfficePhone();
            if (dOffice_phone!= null) {
                ret.put(ModelTUserInfo.FI_OFFICE_PHONE, dOffice_phone);
            }
            String dWeixin_id = instance.getWeixinId();
            if (dWeixin_id!= null) {
                ret.put(ModelTUserInfo.FI_WEIXIN_ID, dWeixin_id);
            }
            String dEmergency_rel = instance.getEmergencyRel();
            if (dEmergency_rel!= null) {
                ret.put(ModelTUserInfo.FI_EMERGENCY_REL, dEmergency_rel);
            }
            String dAddress = instance.getAddress();
            if (dAddress!= null) {
                ret.put(ModelTUserInfo.FI_ADDRESS, dAddress);
            }
            String dPostcode = instance.getPostcode();
            if (dPostcode!= null) {
                ret.put(ModelTUserInfo.FI_POSTCODE, dPostcode);
            }
            String dProfession = instance.getProfession();
            if (dProfession!= null) {
                ret.put(ModelTUserInfo.FI_PROFESSION, dProfession);
            }
            Date dWork_year = instance.getWorkYear();
            if (dWork_year!= null) {
                ret.put(ModelTUserInfo.FI_WORK_YEAR, dWork_year);
            }
            String dQt_cert = instance.getQtCert();
            if (dQt_cert!= null) {
                ret.put(ModelTUserInfo.FI_QT_CERT, dQt_cert);
            }
            String dTraining_cert = instance.getTrainingCert();
            if (dTraining_cert!= null) {
                ret.put(ModelTUserInfo.FI_TRAINING_CERT, dTraining_cert);
            }
            String dRemark = instance.getRemark();
            if (dRemark!= null) {
                ret.put(ModelTUserInfo.FI_REMARK, dRemark);
            }
            String dGraduate_academy = instance.getGraduateAcademy();
            if (dGraduate_academy!= null) {
                ret.put(ModelTUserInfo.FI_GRADUATE_ACADEMY, dGraduate_academy);
            }
            String dIndustry = instance.getIndustry();
            if (dIndustry!= null) {
                ret.put(ModelTUserInfo.FI_INDUSTRY, dIndustry);
            }
            String dOperator_id = instance.getOperatorId();
            if (dOperator_id!= null) {
                ret.put(ModelTUserInfo.FI_OPERATOR_ID, dOperator_id);
            }
            String dFirst_project_ids = instance.getFirstProjectIds();
            if (dFirst_project_ids!= null) {
                ret.put(ModelTUserInfo.FI_FIRST_PROJECT_IDS, dFirst_project_ids);
            }
            String dSignature = instance.getSignature();
            if (dSignature!= null) {
                ret.put(ModelTUserInfo.FI_SIGNATURE, dSignature);
            }
            Long dIm_user_id = instance.getImUserId();
            if (dIm_user_id!= null) {
                ret.put(ModelTUserInfo.FI_IM_USER_ID, dIm_user_id);
            }
            return ret;
        }

        @Override
        public ModelTUserInfo fromCommonMap(Map<String, Object> param) {
            ModelTUserInfo ret = new ModelTUserInfo();
            if (param == null) {
                return ret;
            }
            Object dId = param.get(ModelTUserInfo.FI_ID);
            if (dId!= null) {
                this.setField(ModelTUserInfo.FI_ID, ret, dId);
            }
            Object dMobile = param.get(ModelTUserInfo.FI_MOBILE);
            if (dMobile!= null) {
                this.setField(ModelTUserInfo.FI_MOBILE, ret, dMobile);
            }
            Object dEmail = param.get(ModelTUserInfo.FI_EMAIL);
            if (dEmail!= null) {
                this.setField(ModelTUserInfo.FI_EMAIL, ret, dEmail);
            }
            Object dUsername = param.get(ModelTUserInfo.FI_USERNAME);
            if (dUsername!= null) {
                this.setField(ModelTUserInfo.FI_USERNAME, ret, dUsername);
            }
            Object dNickname = param.get(ModelTUserInfo.FI_NICKNAME);
            if (dNickname!= null) {
                this.setField(ModelTUserInfo.FI_NICKNAME, ret, dNickname);
            }
            Object dSex = param.get(ModelTUserInfo.FI_SEX);
            if (dSex!= null) {
                this.setField(ModelTUserInfo.FI_SEX, ret, dSex);
            }
            Object dEducation = param.get(ModelTUserInfo.FI_EDUCATION);
            if (dEducation!= null) {
                this.setField(ModelTUserInfo.FI_EDUCATION, ret, dEducation);
            }
            Object dCert_type = param.get(ModelTUserInfo.FI_CERT_TYPE);
            if (dCert_type!= null) {
                this.setField(ModelTUserInfo.FI_CERT_TYPE, ret, dCert_type);
            }
            Object dCert_no = param.get(ModelTUserInfo.FI_CERT_NO);
            if (dCert_no!= null) {
                this.setField(ModelTUserInfo.FI_CERT_NO, ret, dCert_no);
            }
            Object dPhone = param.get(ModelTUserInfo.FI_PHONE);
            if (dPhone!= null) {
                this.setField(ModelTUserInfo.FI_PHONE, ret, dPhone);
            }
            Object dBirthday = param.get(ModelTUserInfo.FI_BIRTHDAY);
            if (dBirthday!= null) {
                this.setField(ModelTUserInfo.FI_BIRTHDAY, ret, dBirthday);
            }
            Object dApply_date = param.get(ModelTUserInfo.FI_APPLY_DATE);
            if (dApply_date!= null) {
                this.setField(ModelTUserInfo.FI_APPLY_DATE, ret, dApply_date);
            }
            Object dUrgent_linker = param.get(ModelTUserInfo.FI_URGENT_LINKER);
            if (dUrgent_linker!= null) {
                this.setField(ModelTUserInfo.FI_URGENT_LINKER, ret, dUrgent_linker);
            }
            Object dUrgent_mobile = param.get(ModelTUserInfo.FI_URGENT_MOBILE);
            if (dUrgent_mobile!= null) {
                this.setField(ModelTUserInfo.FI_URGENT_MOBILE, ret, dUrgent_mobile);
            }
            Object dPassword = param.get(ModelTUserInfo.FI_PASSWORD);
            if (dPassword!= null) {
                this.setField(ModelTUserInfo.FI_PASSWORD, ret, dPassword);
            }
            Object dState = param.get(ModelTUserInfo.FI_STATE);
            if (dState!= null) {
                this.setField(ModelTUserInfo.FI_STATE, ret, dState);
            }
            Object dProvince = param.get(ModelTUserInfo.FI_PROVINCE);
            if (dProvince!= null) {
                this.setField(ModelTUserInfo.FI_PROVINCE, ret, dProvince);
            }
            Object dCity = param.get(ModelTUserInfo.FI_CITY);
            if (dCity!= null) {
                this.setField(ModelTUserInfo.FI_CITY, ret, dCity);
            }
            Object dReg_time = param.get(ModelTUserInfo.FI_REG_TIME);
            if (dReg_time!= null) {
                this.setField(ModelTUserInfo.FI_REG_TIME, ret, dReg_time);
            }
            Object dCreator = param.get(ModelTUserInfo.FI_CREATOR);
            if (dCreator!= null) {
                this.setField(ModelTUserInfo.FI_CREATOR, ret, dCreator);
            }
            Object dSchool = param.get(ModelTUserInfo.FI_SCHOOL);
            if (dSchool!= null) {
                this.setField(ModelTUserInfo.FI_SCHOOL, ret, dSchool);
            }
            Object dAdd_type = param.get(ModelTUserInfo.FI_ADD_TYPE);
            if (dAdd_type!= null) {
                this.setField(ModelTUserInfo.FI_ADD_TYPE, ret, dAdd_type);
            }
            Object dUpdate_time = param.get(ModelTUserInfo.FI_UPDATE_TIME);
            if (dUpdate_time!= null) {
                this.setField(ModelTUserInfo.FI_UPDATE_TIME, ret, dUpdate_time);
            }
            Object dQq_code = param.get(ModelTUserInfo.FI_QQ_CODE);
            if (dQq_code!= null) {
                this.setField(ModelTUserInfo.FI_QQ_CODE, ret, dQq_code);
            }
            Object dLevel_remark = param.get(ModelTUserInfo.FI_LEVEL_REMARK);
            if (dLevel_remark!= null) {
                this.setField(ModelTUserInfo.FI_LEVEL_REMARK, ret, dLevel_remark);
            }
            Object dReg_servicePage = param.get(ModelTUserInfo.FI_REG_SERVICEPAGE);
            if (dReg_servicePage!= null) {
                this.setField(ModelTUserInfo.FI_REG_SERVICEPAGE, ret, dReg_servicePage);
            }
            Object dReg_landingPage = param.get(ModelTUserInfo.FI_REG_LANDINGPAGE);
            if (dReg_landingPage!= null) {
                this.setField(ModelTUserInfo.FI_REG_LANDINGPAGE, ret, dReg_landingPage);
            }
            Object dSync_bbs = param.get(ModelTUserInfo.FI_SYNC_BBS);
            if (dSync_bbs!= null) {
                this.setField(ModelTUserInfo.FI_SYNC_BBS, ret, dSync_bbs);
            }
            Object dNickname_bbs = param.get(ModelTUserInfo.FI_NICKNAME_BBS);
            if (dNickname_bbs!= null) {
                this.setField(ModelTUserInfo.FI_NICKNAME_BBS, ret, dNickname_bbs);
            }
            Object dExam_province = param.get(ModelTUserInfo.FI_EXAM_PROVINCE);
            if (dExam_province!= null) {
                this.setField(ModelTUserInfo.FI_EXAM_PROVINCE, ret, dExam_province);
            }
            Object dHadiths_user_id = param.get(ModelTUserInfo.FI_HADITHS_USER_ID);
            if (dHadiths_user_id!= null) {
                this.setField(ModelTUserInfo.FI_HADITHS_USER_ID, ret, dHadiths_user_id);
            }
            Object dMaterial_province = param.get(ModelTUserInfo.FI_MATERIAL_PROVINCE);
            if (dMaterial_province!= null) {
                this.setField(ModelTUserInfo.FI_MATERIAL_PROVINCE, ret, dMaterial_province);
            }
            Object dHuluo_user_id = param.get(ModelTUserInfo.FI_HULUO_USER_ID);
            if (dHuluo_user_id!= null) {
                this.setField(ModelTUserInfo.FI_HULUO_USER_ID, ret, dHuluo_user_id);
            }
            Object dReferer = param.get(ModelTUserInfo.FI_REFERER);
            if (dReferer!= null) {
                this.setField(ModelTUserInfo.FI_REFERER, ret, dReferer);
            }
            Object dImage_url = param.get(ModelTUserInfo.FI_IMAGE_URL);
            if (dImage_url!= null) {
                this.setField(ModelTUserInfo.FI_IMAGE_URL, ret, dImage_url);
            }
            Object dHome_phone = param.get(ModelTUserInfo.FI_HOME_PHONE);
            if (dHome_phone!= null) {
                this.setField(ModelTUserInfo.FI_HOME_PHONE, ret, dHome_phone);
            }
            Object dOffice_phone = param.get(ModelTUserInfo.FI_OFFICE_PHONE);
            if (dOffice_phone!= null) {
                this.setField(ModelTUserInfo.FI_OFFICE_PHONE, ret, dOffice_phone);
            }
            Object dWeixin_id = param.get(ModelTUserInfo.FI_WEIXIN_ID);
            if (dWeixin_id!= null) {
                this.setField(ModelTUserInfo.FI_WEIXIN_ID, ret, dWeixin_id);
            }
            Object dEmergency_rel = param.get(ModelTUserInfo.FI_EMERGENCY_REL);
            if (dEmergency_rel!= null) {
                this.setField(ModelTUserInfo.FI_EMERGENCY_REL, ret, dEmergency_rel);
            }
            Object dAddress = param.get(ModelTUserInfo.FI_ADDRESS);
            if (dAddress!= null) {
                this.setField(ModelTUserInfo.FI_ADDRESS, ret, dAddress);
            }
            Object dPostcode = param.get(ModelTUserInfo.FI_POSTCODE);
            if (dPostcode!= null) {
                this.setField(ModelTUserInfo.FI_POSTCODE, ret, dPostcode);
            }
            Object dProfession = param.get(ModelTUserInfo.FI_PROFESSION);
            if (dProfession!= null) {
                this.setField(ModelTUserInfo.FI_PROFESSION, ret, dProfession);
            }
            Object dWork_year = param.get(ModelTUserInfo.FI_WORK_YEAR);
            if (dWork_year!= null) {
                this.setField(ModelTUserInfo.FI_WORK_YEAR, ret, dWork_year);
            }
            Object dQt_cert = param.get(ModelTUserInfo.FI_QT_CERT);
            if (dQt_cert!= null) {
                this.setField(ModelTUserInfo.FI_QT_CERT, ret, dQt_cert);
            }
            Object dTraining_cert = param.get(ModelTUserInfo.FI_TRAINING_CERT);
            if (dTraining_cert!= null) {
                this.setField(ModelTUserInfo.FI_TRAINING_CERT, ret, dTraining_cert);
            }
            Object dRemark = param.get(ModelTUserInfo.FI_REMARK);
            if (dRemark!= null) {
                this.setField(ModelTUserInfo.FI_REMARK, ret, dRemark);
            }
            Object dGraduate_academy = param.get(ModelTUserInfo.FI_GRADUATE_ACADEMY);
            if (dGraduate_academy!= null) {
                this.setField(ModelTUserInfo.FI_GRADUATE_ACADEMY, ret, dGraduate_academy);
            }
            Object dIndustry = param.get(ModelTUserInfo.FI_INDUSTRY);
            if (dIndustry!= null) {
                this.setField(ModelTUserInfo.FI_INDUSTRY, ret, dIndustry);
            }
            Object dOperator_id = param.get(ModelTUserInfo.FI_OPERATOR_ID);
            if (dOperator_id!= null) {
                this.setField(ModelTUserInfo.FI_OPERATOR_ID, ret, dOperator_id);
            }
            Object dFirst_project_ids = param.get(ModelTUserInfo.FI_FIRST_PROJECT_IDS);
            if (dFirst_project_ids!= null) {
                this.setField(ModelTUserInfo.FI_FIRST_PROJECT_IDS, ret, dFirst_project_ids);
            }
            Object dSignature = param.get(ModelTUserInfo.FI_SIGNATURE);
            if (dSignature!= null) {
                this.setField(ModelTUserInfo.FI_SIGNATURE, ret, dSignature);
            }
            Object dIm_user_id = param.get(ModelTUserInfo.FI_IM_USER_ID);
            if (dIm_user_id!= null) {
                this.setField(ModelTUserInfo.FI_IM_USER_ID, ret, dIm_user_id);
            }
            return ret;
        }

        protected Integer mapToFieldId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldMobile(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldEmail(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUsername(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldNickname(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldSex(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldEducation(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCertType(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCertNo(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPhone(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldBirthday(Object obj) {
            return ((Date) obj);
        }

        protected Date mapToFieldApplyDate(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldUrgentLinker(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldUrgentMobile(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPassword(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldState(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldProvince(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCity(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldRegTime(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldCreator(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldSchool(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldAddType(Object obj) {
            return ((Integer) obj);
        }

        protected Date mapToFieldUpdateTime(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldQqCode(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldLevelRemark(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldRegServicePage(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldRegLandingPage(Object obj) {
            return ((String) obj);
        }

        protected Byte mapToFieldSyncBbs(Object obj) {
            return ((Byte) obj);
        }

        protected String mapToFieldNicknameBbs(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldExamProvince(Object obj) {
            return ((String) obj);
        }

        protected Integer mapToFieldHadithsUserId(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldMaterialProvince(Object obj) {
            return ((Integer) obj);
        }

        protected Integer mapToFieldHuluoUserId(Object obj) {
            return ((Integer) obj);
        }

        protected String mapToFieldReferer(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldImageUrl(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldHomePhone(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldOfficePhone(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldWeixinId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldEmergencyRel(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldAddress(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldPostcode(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldProfession(Object obj) {
            return ((String) obj);
        }

        protected Date mapToFieldWorkYear(Object obj) {
            return ((Date) obj);
        }

        protected String mapToFieldQtCert(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldTrainingCert(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldRemark(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldGraduateAcademy(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldIndustry(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldOperatorId(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldFirstProjectIds(Object obj) {
            return ((String) obj);
        }

        protected String mapToFieldSignature(Object obj) {
            return ((String) obj);
        }

        protected Long mapToFieldImUserId(Object obj) {
            return ((Long) obj);
        }

        public<TT> TT getField(String field, ModelTUserInfo instance) {
            try {
                if (field.equals(ModelTUserInfo.FI_ID)) {
                    return ((TT) instance.getId());
                } else {
                    if (field.equals(ModelTUserInfo.FI_MOBILE)) {
                        return ((TT) instance.getMobile());
                    } else {
                        if (field.equals(ModelTUserInfo.FI_EMAIL)) {
                            return ((TT) instance.getEmail());
                        } else {
                            if (field.equals(ModelTUserInfo.FI_USERNAME)) {
                                return ((TT) instance.getUsername());
                            } else {
                                if (field.equals(ModelTUserInfo.FI_NICKNAME)) {
                                    return ((TT) instance.getNickname());
                                } else {
                                    if (field.equals(ModelTUserInfo.FI_SEX)) {
                                        return ((TT) instance.getSex());
                                    } else {
                                        if (field.equals(ModelTUserInfo.FI_EDUCATION)) {
                                            return ((TT) instance.getEducation());
                                        } else {
                                            if (field.equals(ModelTUserInfo.FI_CERT_TYPE)) {
                                                return ((TT) instance.getCertType());
                                            } else {
                                                if (field.equals(ModelTUserInfo.FI_CERT_NO)) {
                                                    return ((TT) instance.getCertNo());
                                                } else {
                                                    if (field.equals(ModelTUserInfo.FI_PHONE)) {
                                                        return ((TT) instance.getPhone());
                                                    } else {
                                                        if (field.equals(ModelTUserInfo.FI_BIRTHDAY)) {
                                                            return ((TT) instance.getBirthday());
                                                        } else {
                                                            if (field.equals(ModelTUserInfo.FI_APPLY_DATE)) {
                                                                return ((TT) instance.getApplyDate());
                                                            } else {
                                                                if (field.equals(ModelTUserInfo.FI_URGENT_LINKER)) {
                                                                    return ((TT) instance.getUrgentLinker());
                                                                } else {
                                                                    if (field.equals(ModelTUserInfo.FI_URGENT_MOBILE)) {
                                                                        return ((TT) instance.getUrgentMobile());
                                                                    } else {
                                                                        if (field.equals(ModelTUserInfo.FI_PASSWORD)) {
                                                                            return ((TT) instance.getPassword());
                                                                        } else {
                                                                            if (field.equals(ModelTUserInfo.FI_STATE)) {
                                                                                return ((TT) instance.getState());
                                                                            } else {
                                                                                if (field.equals(ModelTUserInfo.FI_PROVINCE)) {
                                                                                    return ((TT) instance.getProvince());
                                                                                } else {
                                                                                    if (field.equals(ModelTUserInfo.FI_CITY)) {
                                                                                        return ((TT) instance.getCity());
                                                                                    } else {
                                                                                        if (field.equals(ModelTUserInfo.FI_REG_TIME)) {
                                                                                            return ((TT) instance.getRegTime());
                                                                                        } else {
                                                                                            if (field.equals(ModelTUserInfo.FI_CREATOR)) {
                                                                                                return ((TT) instance.getCreator());
                                                                                            } else {
                                                                                                if (field.equals(ModelTUserInfo.FI_SCHOOL)) {
                                                                                                    return ((TT) instance.getSchool());
                                                                                                } else {
                                                                                                    if (field.equals(ModelTUserInfo.FI_ADD_TYPE)) {
                                                                                                        return ((TT) instance.getAddType());
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTUserInfo.FI_UPDATE_TIME)) {
                                                                                                            return ((TT) instance.getUpdateTime());
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTUserInfo.FI_QQ_CODE)) {
                                                                                                                return ((TT) instance.getQqCode());
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTUserInfo.FI_LEVEL_REMARK)) {
                                                                                                                    return ((TT) instance.getLevelRemark());
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
                                                                                                                        return ((TT) instance.getRegServicePage());
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
                                                                                                                            return ((TT) instance.getRegLandingPage());
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTUserInfo.FI_SYNC_BBS)) {
                                                                                                                                return ((TT) instance.getSyncBbs());
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTUserInfo.FI_NICKNAME_BBS)) {
                                                                                                                                    return ((TT) instance.getNicknameBbs());
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTUserInfo.FI_EXAM_PROVINCE)) {
                                                                                                                                        return ((TT) instance.getExamProvince());
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTUserInfo.FI_HADITHS_USER_ID)) {
                                                                                                                                            return ((TT) instance.getHadithsUserId());
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
                                                                                                                                                return ((TT) instance.getMaterialProvince());
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTUserInfo.FI_HULUO_USER_ID)) {
                                                                                                                                                    return ((TT) instance.getHuluoUserId());
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_REFERER)) {
                                                                                                                                                        return ((TT) instance.getReferer());
                                                                                                                                                    } else {
                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_IMAGE_URL)) {
                                                                                                                                                            return ((TT) instance.getImageUrl());
                                                                                                                                                        } else {
                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_HOME_PHONE)) {
                                                                                                                                                                return ((TT) instance.getHomePhone());
                                                                                                                                                            } else {
                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_OFFICE_PHONE)) {
                                                                                                                                                                    return ((TT) instance.getOfficePhone());
                                                                                                                                                                } else {
                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_WEIXIN_ID)) {
                                                                                                                                                                        return ((TT) instance.getWeixinId());
                                                                                                                                                                    } else {
                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_EMERGENCY_REL)) {
                                                                                                                                                                            return ((TT) instance.getEmergencyRel());
                                                                                                                                                                        } else {
                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_ADDRESS)) {
                                                                                                                                                                                return ((TT) instance.getAddress());
                                                                                                                                                                            } else {
                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_POSTCODE)) {
                                                                                                                                                                                    return ((TT) instance.getPostcode());
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_PROFESSION)) {
                                                                                                                                                                                        return ((TT) instance.getProfession());
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_WORK_YEAR)) {
                                                                                                                                                                                            return ((TT) instance.getWorkYear());
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_QT_CERT)) {
                                                                                                                                                                                                return ((TT) instance.getQtCert());
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_TRAINING_CERT)) {
                                                                                                                                                                                                    return ((TT) instance.getTrainingCert());
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_REMARK)) {
                                                                                                                                                                                                        return ((TT) instance.getRemark());
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
                                                                                                                                                                                                            return ((TT) instance.getGraduateAcademy());
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_INDUSTRY)) {
                                                                                                                                                                                                                return ((TT) instance.getIndustry());
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_OPERATOR_ID)) {
                                                                                                                                                                                                                    return ((TT) instance.getOperatorId());
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
                                                                                                                                                                                                                        return ((TT) instance.getFirstProjectIds());
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_SIGNATURE)) {
                                                                                                                                                                                                                            return ((TT) instance.getSignature());
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_IM_USER_ID)) {
                                                                                                                                                                                                                                return ((TT) instance.getImUserId());
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

        public<TT> void setField(String field, ModelTUserInfo instance, TT value) {
            if (field.equals(ModelTUserInfo.FI_ID)) {
                try {
                    instance.setId(mapToFieldId(value));
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if (field.equals(ModelTUserInfo.FI_MOBILE)) {
                    try {
                        instance.setMobile(mapToFieldMobile(value));
                    } catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (field.equals(ModelTUserInfo.FI_EMAIL)) {
                        try {
                            instance.setEmail(mapToFieldEmail(value));
                        } catch (final Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        if (field.equals(ModelTUserInfo.FI_USERNAME)) {
                            try {
                                instance.setUsername(mapToFieldUsername(value));
                            } catch (final Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            if (field.equals(ModelTUserInfo.FI_NICKNAME)) {
                                try {
                                    instance.setNickname(mapToFieldNickname(value));
                                } catch (final Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                if (field.equals(ModelTUserInfo.FI_SEX)) {
                                    try {
                                        instance.setSex(mapToFieldSex(value));
                                    } catch (final Exception ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    if (field.equals(ModelTUserInfo.FI_EDUCATION)) {
                                        try {
                                            instance.setEducation(mapToFieldEducation(value));
                                        } catch (final Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    } else {
                                        if (field.equals(ModelTUserInfo.FI_CERT_TYPE)) {
                                            try {
                                                instance.setCertType(mapToFieldCertType(value));
                                            } catch (final Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        } else {
                                            if (field.equals(ModelTUserInfo.FI_CERT_NO)) {
                                                try {
                                                    instance.setCertNo(mapToFieldCertNo(value));
                                                } catch (final Exception ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                if (field.equals(ModelTUserInfo.FI_PHONE)) {
                                                    try {
                                                        instance.setPhone(mapToFieldPhone(value));
                                                    } catch (final Exception ex) {
                                                        ex.printStackTrace();
                                                    }
                                                } else {
                                                    if (field.equals(ModelTUserInfo.FI_BIRTHDAY)) {
                                                        try {
                                                            instance.setBirthday(mapToFieldBirthday(value));
                                                        } catch (final Exception ex) {
                                                            ex.printStackTrace();
                                                        }
                                                    } else {
                                                        if (field.equals(ModelTUserInfo.FI_APPLY_DATE)) {
                                                            try {
                                                                instance.setApplyDate(mapToFieldApplyDate(value));
                                                            } catch (final Exception ex) {
                                                                ex.printStackTrace();
                                                            }
                                                        } else {
                                                            if (field.equals(ModelTUserInfo.FI_URGENT_LINKER)) {
                                                                try {
                                                                    instance.setUrgentLinker(mapToFieldUrgentLinker(value));
                                                                } catch (final Exception ex) {
                                                                    ex.printStackTrace();
                                                                }
                                                            } else {
                                                                if (field.equals(ModelTUserInfo.FI_URGENT_MOBILE)) {
                                                                    try {
                                                                        instance.setUrgentMobile(mapToFieldUrgentMobile(value));
                                                                    } catch (final Exception ex) {
                                                                        ex.printStackTrace();
                                                                    }
                                                                } else {
                                                                    if (field.equals(ModelTUserInfo.FI_PASSWORD)) {
                                                                        try {
                                                                            instance.setPassword(mapToFieldPassword(value));
                                                                        } catch (final Exception ex) {
                                                                            ex.printStackTrace();
                                                                        }
                                                                    } else {
                                                                        if (field.equals(ModelTUserInfo.FI_STATE)) {
                                                                            try {
                                                                                instance.setState(mapToFieldState(value));
                                                                            } catch (final Exception ex) {
                                                                                ex.printStackTrace();
                                                                            }
                                                                        } else {
                                                                            if (field.equals(ModelTUserInfo.FI_PROVINCE)) {
                                                                                try {
                                                                                    instance.setProvince(mapToFieldProvince(value));
                                                                                } catch (final Exception ex) {
                                                                                    ex.printStackTrace();
                                                                                }
                                                                            } else {
                                                                                if (field.equals(ModelTUserInfo.FI_CITY)) {
                                                                                    try {
                                                                                        instance.setCity(mapToFieldCity(value));
                                                                                    } catch (final Exception ex) {
                                                                                        ex.printStackTrace();
                                                                                    }
                                                                                } else {
                                                                                    if (field.equals(ModelTUserInfo.FI_REG_TIME)) {
                                                                                        try {
                                                                                            instance.setRegTime(mapToFieldRegTime(value));
                                                                                        } catch (final Exception ex) {
                                                                                            ex.printStackTrace();
                                                                                        }
                                                                                    } else {
                                                                                        if (field.equals(ModelTUserInfo.FI_CREATOR)) {
                                                                                            try {
                                                                                                instance.setCreator(mapToFieldCreator(value));
                                                                                            } catch (final Exception ex) {
                                                                                                ex.printStackTrace();
                                                                                            }
                                                                                        } else {
                                                                                            if (field.equals(ModelTUserInfo.FI_SCHOOL)) {
                                                                                                try {
                                                                                                    instance.setSchool(mapToFieldSchool(value));
                                                                                                } catch (final Exception ex) {
                                                                                                    ex.printStackTrace();
                                                                                                }
                                                                                            } else {
                                                                                                if (field.equals(ModelTUserInfo.FI_ADD_TYPE)) {
                                                                                                    try {
                                                                                                        instance.setAddType(mapToFieldAddType(value));
                                                                                                    } catch (final Exception ex) {
                                                                                                        ex.printStackTrace();
                                                                                                    }
                                                                                                } else {
                                                                                                    if (field.equals(ModelTUserInfo.FI_UPDATE_TIME)) {
                                                                                                        try {
                                                                                                            instance.setUpdateTime(mapToFieldUpdateTime(value));
                                                                                                        } catch (final Exception ex) {
                                                                                                            ex.printStackTrace();
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTUserInfo.FI_QQ_CODE)) {
                                                                                                            try {
                                                                                                                instance.setQqCode(mapToFieldQqCode(value));
                                                                                                            } catch (final Exception ex) {
                                                                                                                ex.printStackTrace();
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTUserInfo.FI_LEVEL_REMARK)) {
                                                                                                                try {
                                                                                                                    instance.setLevelRemark(mapToFieldLevelRemark(value));
                                                                                                                } catch (final Exception ex) {
                                                                                                                    ex.printStackTrace();
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
                                                                                                                    try {
                                                                                                                        instance.setRegServicePage(mapToFieldRegServicePage(value));
                                                                                                                    } catch (final Exception ex) {
                                                                                                                        ex.printStackTrace();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
                                                                                                                        try {
                                                                                                                            instance.setRegLandingPage(mapToFieldRegLandingPage(value));
                                                                                                                        } catch (final Exception ex) {
                                                                                                                            ex.printStackTrace();
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTUserInfo.FI_SYNC_BBS)) {
                                                                                                                            try {
                                                                                                                                instance.setSyncBbs(mapToFieldSyncBbs(value));
                                                                                                                            } catch (final Exception ex) {
                                                                                                                                ex.printStackTrace();
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTUserInfo.FI_NICKNAME_BBS)) {
                                                                                                                                try {
                                                                                                                                    instance.setNicknameBbs(mapToFieldNicknameBbs(value));
                                                                                                                                } catch (final Exception ex) {
                                                                                                                                    ex.printStackTrace();
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTUserInfo.FI_EXAM_PROVINCE)) {
                                                                                                                                    try {
                                                                                                                                        instance.setExamProvince(mapToFieldExamProvince(value));
                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                        ex.printStackTrace();
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTUserInfo.FI_HADITHS_USER_ID)) {
                                                                                                                                        try {
                                                                                                                                            instance.setHadithsUserId(mapToFieldHadithsUserId(value));
                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                            ex.printStackTrace();
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
                                                                                                                                            try {
                                                                                                                                                instance.setMaterialProvince(mapToFieldMaterialProvince(value));
                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                ex.printStackTrace();
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTUserInfo.FI_HULUO_USER_ID)) {
                                                                                                                                                try {
                                                                                                                                                    instance.setHuluoUserId(mapToFieldHuluoUserId(value));
                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTUserInfo.FI_REFERER)) {
                                                                                                                                                    try {
                                                                                                                                                        instance.setReferer(mapToFieldReferer(value));
                                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                                        ex.printStackTrace();
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_IMAGE_URL)) {
                                                                                                                                                        try {
                                                                                                                                                            instance.setImageUrl(mapToFieldImageUrl(value));
                                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                                            ex.printStackTrace();
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_HOME_PHONE)) {
                                                                                                                                                            try {
                                                                                                                                                                instance.setHomePhone(mapToFieldHomePhone(value));
                                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                                ex.printStackTrace();
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_OFFICE_PHONE)) {
                                                                                                                                                                try {
                                                                                                                                                                    instance.setOfficePhone(mapToFieldOfficePhone(value));
                                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_WEIXIN_ID)) {
                                                                                                                                                                    try {
                                                                                                                                                                        instance.setWeixinId(mapToFieldWeixinId(value));
                                                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                                                        ex.printStackTrace();
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_EMERGENCY_REL)) {
                                                                                                                                                                        try {
                                                                                                                                                                            instance.setEmergencyRel(mapToFieldEmergencyRel(value));
                                                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                                                            ex.printStackTrace();
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_ADDRESS)) {
                                                                                                                                                                            try {
                                                                                                                                                                                instance.setAddress(mapToFieldAddress(value));
                                                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                                                ex.printStackTrace();
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_POSTCODE)) {
                                                                                                                                                                                try {
                                                                                                                                                                                    instance.setPostcode(mapToFieldPostcode(value));
                                                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_PROFESSION)) {
                                                                                                                                                                                    try {
                                                                                                                                                                                        instance.setProfession(mapToFieldProfession(value));
                                                                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                                                                        ex.printStackTrace();
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_WORK_YEAR)) {
                                                                                                                                                                                        try {
                                                                                                                                                                                            instance.setWorkYear(mapToFieldWorkYear(value));
                                                                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                                                                            ex.printStackTrace();
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_QT_CERT)) {
                                                                                                                                                                                            try {
                                                                                                                                                                                                instance.setQtCert(mapToFieldQtCert(value));
                                                                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                                                                ex.printStackTrace();
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_TRAINING_CERT)) {
                                                                                                                                                                                                try {
                                                                                                                                                                                                    instance.setTrainingCert(mapToFieldTrainingCert(value));
                                                                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                                                                }
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_REMARK)) {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        instance.setRemark(mapToFieldRemark(value));
                                                                                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                                                                                        ex.printStackTrace();
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            instance.setGraduateAcademy(mapToFieldGraduateAcademy(value));
                                                                                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                                                                                            ex.printStackTrace();
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_INDUSTRY)) {
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                instance.setIndustry(mapToFieldIndustry(value));
                                                                                                                                                                                                            } catch (final Exception ex) {
                                                                                                                                                                                                                ex.printStackTrace();
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_OPERATOR_ID)) {
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    instance.setOperatorId(mapToFieldOperatorId(value));
                                                                                                                                                                                                                } catch (final Exception ex) {
                                                                                                                                                                                                                    ex.printStackTrace();
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        instance.setFirstProjectIds(mapToFieldFirstProjectIds(value));
                                                                                                                                                                                                                    } catch (final Exception ex) {
                                                                                                                                                                                                                        ex.printStackTrace();
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_SIGNATURE)) {
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            instance.setSignature(mapToFieldSignature(value));
                                                                                                                                                                                                                        } catch (final Exception ex) {
                                                                                                                                                                                                                            ex.printStackTrace();
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_IM_USER_ID)) {
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                instance.setImUserId(mapToFieldImUserId(value));
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

        public void setField(String field, ModelTUserInfo instance, byte[] value) {
            if (field.equals(ModelTUserInfo.FI_ID)) {
                instance.setId(mapToFieldId(value));
            } else {
                if (field.equals(ModelTUserInfo.FI_MOBILE)) {
                    instance.setMobile(mapToFieldMobile(value));
                } else {
                    if (field.equals(ModelTUserInfo.FI_EMAIL)) {
                        instance.setEmail(mapToFieldEmail(value));
                    } else {
                        if (field.equals(ModelTUserInfo.FI_USERNAME)) {
                            instance.setUsername(mapToFieldUsername(value));
                        } else {
                            if (field.equals(ModelTUserInfo.FI_NICKNAME)) {
                                instance.setNickname(mapToFieldNickname(value));
                            } else {
                                if (field.equals(ModelTUserInfo.FI_SEX)) {
                                    instance.setSex(mapToFieldSex(value));
                                } else {
                                    if (field.equals(ModelTUserInfo.FI_EDUCATION)) {
                                        instance.setEducation(mapToFieldEducation(value));
                                    } else {
                                        if (field.equals(ModelTUserInfo.FI_CERT_TYPE)) {
                                            instance.setCertType(mapToFieldCertType(value));
                                        } else {
                                            if (field.equals(ModelTUserInfo.FI_CERT_NO)) {
                                                instance.setCertNo(mapToFieldCertNo(value));
                                            } else {
                                                if (field.equals(ModelTUserInfo.FI_PHONE)) {
                                                    instance.setPhone(mapToFieldPhone(value));
                                                } else {
                                                    if (field.equals(ModelTUserInfo.FI_BIRTHDAY)) {
                                                        instance.setBirthday(mapToFieldBirthday(value));
                                                    } else {
                                                        if (field.equals(ModelTUserInfo.FI_APPLY_DATE)) {
                                                            instance.setApplyDate(mapToFieldApplyDate(value));
                                                        } else {
                                                            if (field.equals(ModelTUserInfo.FI_URGENT_LINKER)) {
                                                                instance.setUrgentLinker(mapToFieldUrgentLinker(value));
                                                            } else {
                                                                if (field.equals(ModelTUserInfo.FI_URGENT_MOBILE)) {
                                                                    instance.setUrgentMobile(mapToFieldUrgentMobile(value));
                                                                } else {
                                                                    if (field.equals(ModelTUserInfo.FI_PASSWORD)) {
                                                                        instance.setPassword(mapToFieldPassword(value));
                                                                    } else {
                                                                        if (field.equals(ModelTUserInfo.FI_STATE)) {
                                                                            instance.setState(mapToFieldState(value));
                                                                        } else {
                                                                            if (field.equals(ModelTUserInfo.FI_PROVINCE)) {
                                                                                instance.setProvince(mapToFieldProvince(value));
                                                                            } else {
                                                                                if (field.equals(ModelTUserInfo.FI_CITY)) {
                                                                                    instance.setCity(mapToFieldCity(value));
                                                                                } else {
                                                                                    if (field.equals(ModelTUserInfo.FI_REG_TIME)) {
                                                                                        instance.setRegTime(mapToFieldRegTime(value));
                                                                                    } else {
                                                                                        if (field.equals(ModelTUserInfo.FI_CREATOR)) {
                                                                                            instance.setCreator(mapToFieldCreator(value));
                                                                                        } else {
                                                                                            if (field.equals(ModelTUserInfo.FI_SCHOOL)) {
                                                                                                instance.setSchool(mapToFieldSchool(value));
                                                                                            } else {
                                                                                                if (field.equals(ModelTUserInfo.FI_ADD_TYPE)) {
                                                                                                    instance.setAddType(mapToFieldAddType(value));
                                                                                                } else {
                                                                                                    if (field.equals(ModelTUserInfo.FI_UPDATE_TIME)) {
                                                                                                        instance.setUpdateTime(mapToFieldUpdateTime(value));
                                                                                                    } else {
                                                                                                        if (field.equals(ModelTUserInfo.FI_QQ_CODE)) {
                                                                                                            instance.setQqCode(mapToFieldQqCode(value));
                                                                                                        } else {
                                                                                                            if (field.equals(ModelTUserInfo.FI_LEVEL_REMARK)) {
                                                                                                                instance.setLevelRemark(mapToFieldLevelRemark(value));
                                                                                                            } else {
                                                                                                                if (field.equals(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
                                                                                                                    instance.setRegServicePage(mapToFieldRegServicePage(value));
                                                                                                                } else {
                                                                                                                    if (field.equals(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
                                                                                                                        instance.setRegLandingPage(mapToFieldRegLandingPage(value));
                                                                                                                    } else {
                                                                                                                        if (field.equals(ModelTUserInfo.FI_SYNC_BBS)) {
                                                                                                                            instance.setSyncBbs(mapToFieldSyncBbs(value));
                                                                                                                        } else {
                                                                                                                            if (field.equals(ModelTUserInfo.FI_NICKNAME_BBS)) {
                                                                                                                                instance.setNicknameBbs(mapToFieldNicknameBbs(value));
                                                                                                                            } else {
                                                                                                                                if (field.equals(ModelTUserInfo.FI_EXAM_PROVINCE)) {
                                                                                                                                    instance.setExamProvince(mapToFieldExamProvince(value));
                                                                                                                                } else {
                                                                                                                                    if (field.equals(ModelTUserInfo.FI_HADITHS_USER_ID)) {
                                                                                                                                        instance.setHadithsUserId(mapToFieldHadithsUserId(value));
                                                                                                                                    } else {
                                                                                                                                        if (field.equals(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
                                                                                                                                            instance.setMaterialProvince(mapToFieldMaterialProvince(value));
                                                                                                                                        } else {
                                                                                                                                            if (field.equals(ModelTUserInfo.FI_HULUO_USER_ID)) {
                                                                                                                                                instance.setHuluoUserId(mapToFieldHuluoUserId(value));
                                                                                                                                            } else {
                                                                                                                                                if (field.equals(ModelTUserInfo.FI_REFERER)) {
                                                                                                                                                    instance.setReferer(mapToFieldReferer(value));
                                                                                                                                                } else {
                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_IMAGE_URL)) {
                                                                                                                                                        instance.setImageUrl(mapToFieldImageUrl(value));
                                                                                                                                                    } else {
                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_HOME_PHONE)) {
                                                                                                                                                            instance.setHomePhone(mapToFieldHomePhone(value));
                                                                                                                                                        } else {
                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_OFFICE_PHONE)) {
                                                                                                                                                                instance.setOfficePhone(mapToFieldOfficePhone(value));
                                                                                                                                                            } else {
                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_WEIXIN_ID)) {
                                                                                                                                                                    instance.setWeixinId(mapToFieldWeixinId(value));
                                                                                                                                                                } else {
                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_EMERGENCY_REL)) {
                                                                                                                                                                        instance.setEmergencyRel(mapToFieldEmergencyRel(value));
                                                                                                                                                                    } else {
                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_ADDRESS)) {
                                                                                                                                                                            instance.setAddress(mapToFieldAddress(value));
                                                                                                                                                                        } else {
                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_POSTCODE)) {
                                                                                                                                                                                instance.setPostcode(mapToFieldPostcode(value));
                                                                                                                                                                            } else {
                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_PROFESSION)) {
                                                                                                                                                                                    instance.setProfession(mapToFieldProfession(value));
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_WORK_YEAR)) {
                                                                                                                                                                                        instance.setWorkYear(mapToFieldWorkYear(value));
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_QT_CERT)) {
                                                                                                                                                                                            instance.setQtCert(mapToFieldQtCert(value));
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_TRAINING_CERT)) {
                                                                                                                                                                                                instance.setTrainingCert(mapToFieldTrainingCert(value));
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_REMARK)) {
                                                                                                                                                                                                    instance.setRemark(mapToFieldRemark(value));
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
                                                                                                                                                                                                        instance.setGraduateAcademy(mapToFieldGraduateAcademy(value));
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_INDUSTRY)) {
                                                                                                                                                                                                            instance.setIndustry(mapToFieldIndustry(value));
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (field.equals(ModelTUserInfo.FI_OPERATOR_ID)) {
                                                                                                                                                                                                                instance.setOperatorId(mapToFieldOperatorId(value));
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if (field.equals(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
                                                                                                                                                                                                                    instance.setFirstProjectIds(mapToFieldFirstProjectIds(value));
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (field.equals(ModelTUserInfo.FI_SIGNATURE)) {
                                                                                                                                                                                                                        instance.setSignature(mapToFieldSignature(value));
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (field.equals(ModelTUserInfo.FI_IM_USER_ID)) {
                                                                                                                                                                                                                            instance.setImUserId(mapToFieldImUserId(value));
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

    public static class ResultSetMapperModelTUserInfo<T extends ModelTUserInfo>
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
            return ((T) new ModelTUserInfo());
        }

        @Override
        public T mapRow(T instance, ResultSet rs, int rowNum, Set<String> columnNames)
            throws SQLException
        {
            mapFieldId(rs, columnNames, instance);
            mapFieldMobile(rs, columnNames, instance);
            mapFieldEmail(rs, columnNames, instance);
            mapFieldUsername(rs, columnNames, instance);
            mapFieldNickname(rs, columnNames, instance);
            mapFieldSex(rs, columnNames, instance);
            mapFieldEducation(rs, columnNames, instance);
            mapFieldCert_type(rs, columnNames, instance);
            mapFieldCert_no(rs, columnNames, instance);
            mapFieldPhone(rs, columnNames, instance);
            mapFieldBirthday(rs, columnNames, instance);
            mapFieldApply_date(rs, columnNames, instance);
            mapFieldUrgent_linker(rs, columnNames, instance);
            mapFieldUrgent_mobile(rs, columnNames, instance);
            mapFieldPassword(rs, columnNames, instance);
            mapFieldState(rs, columnNames, instance);
            mapFieldProvince(rs, columnNames, instance);
            mapFieldCity(rs, columnNames, instance);
            mapFieldReg_time(rs, columnNames, instance);
            mapFieldCreator(rs, columnNames, instance);
            mapFieldSchool(rs, columnNames, instance);
            mapFieldAdd_type(rs, columnNames, instance);
            mapFieldUpdate_time(rs, columnNames, instance);
            mapFieldQq_code(rs, columnNames, instance);
            mapFieldLevel_remark(rs, columnNames, instance);
            mapFieldReg_servicePage(rs, columnNames, instance);
            mapFieldReg_landingPage(rs, columnNames, instance);
            mapFieldSync_bbs(rs, columnNames, instance);
            mapFieldNickname_bbs(rs, columnNames, instance);
            mapFieldExam_province(rs, columnNames, instance);
            mapFieldHadiths_user_id(rs, columnNames, instance);
            mapFieldMaterial_province(rs, columnNames, instance);
            mapFieldHuluo_user_id(rs, columnNames, instance);
            mapFieldReferer(rs, columnNames, instance);
            mapFieldImage_url(rs, columnNames, instance);
            mapFieldHome_phone(rs, columnNames, instance);
            mapFieldOffice_phone(rs, columnNames, instance);
            mapFieldWeixin_id(rs, columnNames, instance);
            mapFieldEmergency_rel(rs, columnNames, instance);
            mapFieldAddress(rs, columnNames, instance);
            mapFieldPostcode(rs, columnNames, instance);
            mapFieldProfession(rs, columnNames, instance);
            mapFieldWork_year(rs, columnNames, instance);
            mapFieldQt_cert(rs, columnNames, instance);
            mapFieldTraining_cert(rs, columnNames, instance);
            mapFieldRemark(rs, columnNames, instance);
            mapFieldGraduate_academy(rs, columnNames, instance);
            mapFieldIndustry(rs, columnNames, instance);
            mapFieldOperator_id(rs, columnNames, instance);
            mapFieldFirst_project_ids(rs, columnNames, instance);
            mapFieldSignature(rs, columnNames, instance);
            mapFieldIm_user_id(rs, columnNames, instance);
            instance.setIndex(rowNum);
            return instance;
        }

        protected void mapFieldId(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_ID)) {
                instance.setId(rs.getInt(ModelTUserInfo.FI_ID));
            }
        }

        protected void mapFieldMobile(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_MOBILE)) {
                instance.setMobile(rs.getString(ModelTUserInfo.FI_MOBILE));
            }
        }

        protected void mapFieldEmail(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_EMAIL)) {
                instance.setEmail(rs.getString(ModelTUserInfo.FI_EMAIL));
            }
        }

        protected void mapFieldUsername(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_USERNAME)) {
                instance.setUsername(rs.getString(ModelTUserInfo.FI_USERNAME));
            }
        }

        protected void mapFieldNickname(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_NICKNAME)) {
                instance.setNickname(rs.getString(ModelTUserInfo.FI_NICKNAME));
            }
        }

        protected void mapFieldSex(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_SEX)) {
                instance.setSex(rs.getString(ModelTUserInfo.FI_SEX));
            }
        }

        protected void mapFieldEducation(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_EDUCATION)) {
                instance.setEducation(rs.getString(ModelTUserInfo.FI_EDUCATION));
            }
        }

        protected void mapFieldCert_type(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_CERT_TYPE)) {
                instance.setCertType(rs.getString(ModelTUserInfo.FI_CERT_TYPE));
            }
        }

        protected void mapFieldCert_no(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_CERT_NO)) {
                instance.setCertNo(rs.getString(ModelTUserInfo.FI_CERT_NO));
            }
        }

        protected void mapFieldPhone(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_PHONE)) {
                instance.setPhone(rs.getString(ModelTUserInfo.FI_PHONE));
            }
        }

        protected void mapFieldBirthday(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_BIRTHDAY)) {
                instance.setBirthday(rs.getDate(ModelTUserInfo.FI_BIRTHDAY));
            }
        }

        protected void mapFieldApply_date(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_APPLY_DATE)) {
                instance.setApplyDate(rs.getDate(ModelTUserInfo.FI_APPLY_DATE));
            }
        }

        protected void mapFieldUrgent_linker(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_URGENT_LINKER)) {
                instance.setUrgentLinker(rs.getString(ModelTUserInfo.FI_URGENT_LINKER));
            }
        }

        protected void mapFieldUrgent_mobile(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_URGENT_MOBILE)) {
                instance.setUrgentMobile(rs.getString(ModelTUserInfo.FI_URGENT_MOBILE));
            }
        }

        protected void mapFieldPassword(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_PASSWORD)) {
                instance.setPassword(rs.getString(ModelTUserInfo.FI_PASSWORD));
            }
        }

        protected void mapFieldState(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_STATE)) {
                instance.setState(rs.getString(ModelTUserInfo.FI_STATE));
            }
        }

        protected void mapFieldProvince(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_PROVINCE)) {
                instance.setProvince(rs.getString(ModelTUserInfo.FI_PROVINCE));
            }
        }

        protected void mapFieldCity(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_CITY)) {
                instance.setCity(rs.getString(ModelTUserInfo.FI_CITY));
            }
        }

        protected void mapFieldReg_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_REG_TIME)) {
                instance.setRegTime(rs.getString(ModelTUserInfo.FI_REG_TIME));
            }
        }

        protected void mapFieldCreator(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_CREATOR)) {
                instance.setCreator(rs.getString(ModelTUserInfo.FI_CREATOR));
            }
        }

        protected void mapFieldSchool(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_SCHOOL)) {
                instance.setSchool(rs.getString(ModelTUserInfo.FI_SCHOOL));
            }
        }

        protected void mapFieldAdd_type(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_ADD_TYPE)) {
                instance.setAddType(rs.getInt(ModelTUserInfo.FI_ADD_TYPE));
            }
        }

        protected void mapFieldUpdate_time(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_UPDATE_TIME)) {
                instance.setUpdateTime(rs.getTimestamp(ModelTUserInfo.FI_UPDATE_TIME));
            }
        }

        protected void mapFieldQq_code(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_QQ_CODE)) {
                instance.setQqCode(rs.getString(ModelTUserInfo.FI_QQ_CODE));
            }
        }

        protected void mapFieldLevel_remark(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_LEVEL_REMARK)) {
                instance.setLevelRemark(rs.getString(ModelTUserInfo.FI_LEVEL_REMARK));
            }
        }

        protected void mapFieldReg_servicePage(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_REG_SERVICEPAGE)) {
                instance.setRegServicePage(rs.getString(ModelTUserInfo.FI_REG_SERVICEPAGE));
            }
        }

        protected void mapFieldReg_landingPage(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_REG_LANDINGPAGE)) {
                instance.setRegLandingPage(rs.getString(ModelTUserInfo.FI_REG_LANDINGPAGE));
            }
        }

        protected void mapFieldSync_bbs(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_SYNC_BBS)) {
                instance.setSyncBbs(rs.getByte(ModelTUserInfo.FI_SYNC_BBS));
            }
        }

        protected void mapFieldNickname_bbs(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_NICKNAME_BBS)) {
                instance.setNicknameBbs(rs.getString(ModelTUserInfo.FI_NICKNAME_BBS));
            }
        }

        protected void mapFieldExam_province(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_EXAM_PROVINCE)) {
                instance.setExamProvince(rs.getString(ModelTUserInfo.FI_EXAM_PROVINCE));
            }
        }

        protected void mapFieldHadiths_user_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_HADITHS_USER_ID)) {
                instance.setHadithsUserId(rs.getInt(ModelTUserInfo.FI_HADITHS_USER_ID));
            }
        }

        protected void mapFieldMaterial_province(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_MATERIAL_PROVINCE)) {
                instance.setMaterialProvince(rs.getInt(ModelTUserInfo.FI_MATERIAL_PROVINCE));
            }
        }

        protected void mapFieldHuluo_user_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_HULUO_USER_ID)) {
                instance.setHuluoUserId(rs.getInt(ModelTUserInfo.FI_HULUO_USER_ID));
            }
        }

        protected void mapFieldReferer(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_REFERER)) {
                instance.setReferer(rs.getString(ModelTUserInfo.FI_REFERER));
            }
        }

        protected void mapFieldImage_url(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_IMAGE_URL)) {
                instance.setImageUrl(rs.getString(ModelTUserInfo.FI_IMAGE_URL));
            }
        }

        protected void mapFieldHome_phone(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_HOME_PHONE)) {
                instance.setHomePhone(rs.getString(ModelTUserInfo.FI_HOME_PHONE));
            }
        }

        protected void mapFieldOffice_phone(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_OFFICE_PHONE)) {
                instance.setOfficePhone(rs.getString(ModelTUserInfo.FI_OFFICE_PHONE));
            }
        }

        protected void mapFieldWeixin_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_WEIXIN_ID)) {
                instance.setWeixinId(rs.getString(ModelTUserInfo.FI_WEIXIN_ID));
            }
        }

        protected void mapFieldEmergency_rel(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_EMERGENCY_REL)) {
                instance.setEmergencyRel(rs.getString(ModelTUserInfo.FI_EMERGENCY_REL));
            }
        }

        protected void mapFieldAddress(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_ADDRESS)) {
                instance.setAddress(rs.getString(ModelTUserInfo.FI_ADDRESS));
            }
        }

        protected void mapFieldPostcode(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_POSTCODE)) {
                instance.setPostcode(rs.getString(ModelTUserInfo.FI_POSTCODE));
            }
        }

        protected void mapFieldProfession(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_PROFESSION)) {
                instance.setProfession(rs.getString(ModelTUserInfo.FI_PROFESSION));
            }
        }

        protected void mapFieldWork_year(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_WORK_YEAR)) {
                instance.setWorkYear(rs.getDate(ModelTUserInfo.FI_WORK_YEAR));
            }
        }

        protected void mapFieldQt_cert(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_QT_CERT)) {
                instance.setQtCert(rs.getString(ModelTUserInfo.FI_QT_CERT));
            }
        }

        protected void mapFieldTraining_cert(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_TRAINING_CERT)) {
                instance.setTrainingCert(rs.getString(ModelTUserInfo.FI_TRAINING_CERT));
            }
        }

        protected void mapFieldRemark(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_REMARK)) {
                instance.setRemark(rs.getString(ModelTUserInfo.FI_REMARK));
            }
        }

        protected void mapFieldGraduate_academy(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_GRADUATE_ACADEMY)) {
                instance.setGraduateAcademy(rs.getString(ModelTUserInfo.FI_GRADUATE_ACADEMY));
            }
        }

        protected void mapFieldIndustry(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_INDUSTRY)) {
                instance.setIndustry(rs.getString(ModelTUserInfo.FI_INDUSTRY));
            }
        }

        protected void mapFieldOperator_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_OPERATOR_ID)) {
                instance.setOperatorId(rs.getString(ModelTUserInfo.FI_OPERATOR_ID));
            }
        }

        protected void mapFieldFirst_project_ids(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_FIRST_PROJECT_IDS)) {
                instance.setFirstProjectIds(rs.getString(ModelTUserInfo.FI_FIRST_PROJECT_IDS));
            }
        }

        protected void mapFieldSignature(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_SIGNATURE)) {
                instance.setSignature(rs.getString(ModelTUserInfo.FI_SIGNATURE));
            }
        }

        protected void mapFieldIm_user_id(ResultSet rs, Set<String> columnNames, T instance)
            throws SQLException
        {
            if (columnNames.contains(ModelTUserInfo.FI_IM_USER_ID)) {
                instance.setImUserId(rs.getLong(ModelTUserInfo.FI_IM_USER_ID));
            }
        }
    }
}
