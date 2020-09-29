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
import com.shawn.ss.lib.code_gen.base.helper.conf_factory.CommonModelConfFactory;
import com.shawn.ss.lib.code_gen.base.helper.conf_factory.MultiModelConfFactory;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ClassDataTable;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;

import com.shawn.ss.lib.code_gen.model.MethodTypeEnum;
import com.shawn.ss.lib.code_gen.model.def_model._base.AbstractConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDaoDef;

import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDaoConf;
import com.shawn.ss.lib.code_gen.model.gen_param_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ModelBuilderContext {
    final Logger L = LoggerFactory.getLogger(ModelBuilderContext.class.getSimpleName());

    volatile String basePackage;
    JCodeModel cm;
    private String filePath;
    private Map<Long, CommonModelConfFactory> relatedDbs;

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
        final CommonModelConfFactory infoHolder = new CommonModelConfFactory(conn, conf, this);
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

    public void executeBaseModelAndDaoBuild() {

        final Collection<CommonModelConfFactory> commonModelFactories = relatedDbs.values();
        for (CommonModelConfFactory commonModelConfFactory : commonModelFactories) {
            executeBaseModelAndDaoBuild(commonModelConfFactory);
        }
    }

    public void executeBaseModelAndDaoBuild(long uuid) {
        if (!relatedDbs.containsKey(uuid)) {
            throw new IllegalStateException("错误的uuid，此context不包含此uuid：" + uuid + " context:" + relatedDbs.toString());
        }
        final CommonModelConfFactory commonModelConfFactory = DbDataTable.getHolder(uuid);
        executeBaseModelAndDaoBuild(commonModelConfFactory);
    }


    public void executeBaseModelAndDaoBuild(CommonModelConfFactory db) {
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

    public void executeMultiModelAndDaoBuild() {
        Map<String, _BaseDaoConf> confs = MultiModelConfFactory.buildConfs(this);
        confs.forEach((k, v) -> buildMultiSelectDao(v));
    }

    public void executeMultiModelAndDaoBuild(String config) {
        MultiModelConfFactory factory = MultiModelConfFactory.getFactory(config);
        buildMultiSelectDao(factory.buildConf(this));
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

    public void buildBaseModel(_BaseDaoConf def) {
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

    public void buildSpecialSelectDao(_BaseDaoConf conf) {

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


    public void executeInitBaseClazz() {
        ConstantsBuilder builder = new ConstantsBuilder(new DefaultConf(basePackage, this));
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