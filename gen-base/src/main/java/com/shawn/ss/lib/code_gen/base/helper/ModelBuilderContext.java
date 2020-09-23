package com.shawn.ss.lib.code_gen.base.helper;

import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JMethod;
import com.shawn.ss.lib.code_gen.base.common.ConstantsBuilder;
import com.shawn.ss.lib.code_gen.base.common.MapperOfPojoBuilder;
import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_dao_builder.CommonDaoBuilder;
import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.MapperOfResultSetBuilder;

import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.PoModelBuilder;
import com.shawn.ss.lib.code_gen.base.dao.multi_dao.composed_model_builder.ComposedPoModelBuilder;
import com.shawn.ss.lib.code_gen.base.dao.multi_dao.multi_assemble_builder.ComposedAssemblerBuilder;
import com.shawn.ss.lib.code_gen.base.dao.multi_dao.multi_dao_builder.MultiDaoBuilder;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;

import com.shawn.ss.lib.code_gen.model.MethodTypeEnum;
import com.shawn.ss.lib.code_gen.model.def_model._base.AbstractConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDaoDef;

import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.code_gen.model.gen_param_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

//import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.MapperOfMapBuilder;

public class ModelBuilderContext {
    final Logger L = LoggerFactory.getLogger(ModelBuilderContext.class.getSimpleName());

    volatile String basePackage;
    JCodeModel cm;
    private String filePath;
    private Map<Long, CommonModelFactory> relatedDbs;

    private ModelBuilderContext() {
        relatedDbs = CollectionHelper.newMap(32);
        //        dbNameToIndex=CollectionHelper.newMap(32);
    }

    public static ModelBuilderContext newInstance(JCodeModel cm, String basePackage, String filePath) {
        ModelBuilderContext mbh = new ModelBuilderContext();
        mbh.init(cm, basePackage, filePath);
        return mbh;
    }

    public static ModelBuilderContext newInstance(String basePackage, String filePath) {
        ModelBuilderContext mbh = new ModelBuilderContext();
        mbh.init(basePackage, filePath);
        return mbh;
    }


    public DBConnectionHelper buildConnection(String dataSourceId, String dbUrl, String dbUserName, String dbPassword, String dbDriver) {
        return new DBConnectionHelper(dataSourceId, dbUrl, dbUserName, dbPassword, dbDriver);
    }

    public long addDb(DBConnectionHelper conn, DbModelConf conf) {
        final CommonModelFactory infoHolder = new CommonModelFactory(conn, conf, this);
        final long uuid = DbDataTable.putDbInfo(infoHolder);
        relatedDbs.put(uuid, infoHolder);
        return uuid;
    }


    protected void init(JCodeModel cm, String basePackage, String filePath) {
        this.filePath = filePath;
        this.basePackage = basePackage;
        this.cm = cm;
        assert (cm != null);
    }

    protected void init(String basePackage, String filePath) {
        this.filePath = filePath;
        this.basePackage = basePackage;
        cm = new JCodeModel();

    }


    /* private String getModelClassName(String table) {
        return getModelClassName(table, true);
    }*/

    /* public String getMapperClass(String modelClassName) {
        return basePackage + ".dto.mapper." + CodeConstants.CLASS_NAME_RESULT_SET_MAPPER_PREFIX + CodeConstants.getClassNameFromFullName(modelClassName);
    }*/

    public void executeBaseModelAndDaoBuild() {

        final Collection<CommonModelFactory> commonModelFactories = relatedDbs.values();
        for (CommonModelFactory commonModelFactory : commonModelFactories) {
            executeBaseModelAndDaoBuild(commonModelFactory);
        }
    }

    public void executeBaseModelAndDaoBuild(long uuid) {
        if (!relatedDbs.containsKey(uuid)) {
            throw new IllegalStateException("错误的uuid，此context不包含此uuid：" + uuid + " context:" + relatedDbs.toString());
        }
        final CommonModelFactory commonModelFactory = DbDataTable.getHolder(uuid);
        executeBaseModelAndDaoBuild(commonModelFactory);
    }


    public void executeBaseModelAndDaoBuild(CommonModelFactory db) {
        List<CommonModelDaoDef> defs = db.buildDefs();
        for (CommonModelDaoDef def : defs) {

            buildBaseModel(def);
            try {
                CommonDaoBuilder daoBuilder = new CommonDaoBuilder(def);
                daoBuilder.buildModel();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void buildBaseModel(_BaseDaoConf def) {
        try {

            PoModelBuilder builder = new PoModelBuilder(def);
            builder.buildModel();

            MapperOfPojoBuilder redisMapperBuilder = new MapperOfPojoBuilder(def);
            redisMapperBuilder.buildModel();
            MapperOfResultSetBuilder rsMapperBuilder = new MapperOfResultSetBuilder(def);
            rsMapperBuilder.buildModel();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void buildMultiSelectDao(_BaseDaoConf conf) {
        //        serviceName = getServiceClassName(serviceName);
        if (conf == null) {
            return;
        }
        try {
            ComposedPoModelBuilder modelBuilder = new ComposedPoModelBuilder(conf);
            modelBuilder.buildModel();

            ComposedAssemblerBuilder assemblerBuilder = new ComposedAssemblerBuilder(conf);
            assemblerBuilder.buildModel();

            MultiDaoBuilder builder = new MultiDaoBuilder(conf);
            builder.buildModel();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void executeWriteModel() {
        try {
            File file = new File(filePath);
            if (file.exists() || file.mkdirs()) {
                L.info("code will in folder:{}", file.getAbsolutePath());
                cm.build(file);
            } else {
                L.info("can't buildBaseModelAndDao folder:{}", file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerMethod(JMethod method) {
        String name = method.name();
        JDefinedClass jDefinedClass = method.owningClass();
        String clzName = jDefinedClass.name();
        ClassDataTable.putDaoClz(clzName, jDefinedClass);
        MethodTypeEnum mType = null;
        if (clzName.startsWith(CodeConstants.CLASS_NAME_DAO_PREFIX)) {
            mType = MethodTypeEnum.DAO_METHOD;
        } else if (clzName.startsWith(CodeConstants.CLASS_NAME_MODEL_PREFIX)) {
            mType = MethodTypeEnum.MODEL_METHOD;
        } else if (clzName.startsWith(CodeConstants.CLASS_NAME_RESULT_SET_MAPPER_PREFIX)) {
            mType = MethodTypeEnum.MODEL_MAPPER_METHOD;
        } else if (clzName.startsWith(CodeConstants.CLASS_NAME_MULTI_DAO_PREFIX)) {
            mType = MethodTypeEnum.MUL_DAO_METHOD;
        } else {
            mType = MethodTypeEnum.SQL_DEFINED_METHOD;
        }
        boolean constructor = method.isConstructor();

        if (!constructor) {
            //            AbstractJType varParamType = method.listVarParamType();
            ClassDataTable.putMethod(mType, clzName, name, method);
        }
    }

    public JCodeModel getCm() {
        return cm;
    }

    public String getClzName(String clzName) {
        return basePackage + clzName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public ModelBuilderContext setBasePackage(String basePackage) {
        this.basePackage = basePackage;
        return this;
    }

    @Override
    public String toString() {
        return "ModelBuilderContext{" +
                "basePackage='" + basePackage + '\'' +
                ", relatedDbs=" + relatedDbs +
                '}';
    }


    public void initBaseClazz() {
        ConstantsBuilder builder = new ConstantsBuilder(new DefaultConf("init", this));
        builder.buildModel();
    }

    private class DefaultConf extends AbstractConf {
        protected DefaultConf(String name, ModelBuilderContext builderContext) {
            super(name, builderContext);
            initConstantClz();
        }

        private void initConstantClz() {
            constantConf.setClzName(CodeConstants.getConstantClzName(builderContext.getBasePackage()));
        }


    }

}