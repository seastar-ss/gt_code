package com.shawn.ss.gen.code_build_handlers.common_respository;

import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.gen.Constants;
import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultResp;
import com.shawn.ss.gen.api.interfaces.base_resp.DefaultRespConf;
import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.gen.code_build_handlers.AbstractGenConf;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.gen_param_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.ParamHelper;

import javax.lang.model.element.PackageElement;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ModelGenConf extends AbstractGenConf {

//    public static class ModelGenConfDetail {
//        final String database;
//        final String dataSourceId;
//        final Set<String> excludeTables;
//        final Set<String> includingTables;
//
//        public ModelGenConfDetail(String database, String dataSourceId, Set<String> excludeTables, Set<String> includingTables) {
//            this.database = database;
//            this.dataSourceId = dataSourceId;
//            this.excludeTables = excludeTables;
//            this.includingTables = includingTables;
//        }
//
//        public String getDatabase() {
//            return database;
//        }
//
//        public String getDataSourceId() {
//            return dataSourceId;
//        }
//
//        public Set<String> getExcludeTables() {
//            return excludeTables;
//        }
//
//        public Set<String> getIncludingTables() {
//            return includingTables;
//        }
//    }

    static final Pattern conf=
            Pattern.compile("([0-9A-Za-z_$]+)=([0-9A-Za-z_$\\.]+)(;|$)");
//    final Map<String, ModelGenConfDetail> allDt;
    final String packagePos;
    final ModelBuilderContext context;

    public ModelGenConf(PackageElement el, Helpers helpers) {
        super(el);
//        allDt = CollectionHelper.newMap();
        final JCodeModel cm = helpers.getCm();
        final String pos = helpers.options.getOrDefault(Constants.KEY_BASE_PACKAGE, "./src/main/java");
        final String basePack = helpers.options.getOrDefault(Constants.KEY_GEN_FILE_POSITION, "com.shawn.ss");
        helpers.println("build code in :" + basePack);
        String basePackPos = el.getQualifiedName().toString();
        if (!basePackPos.startsWith(basePack)) {
            throw new IllegalStateException("生成代码应该在" + Constants.KEY_GEN_FILE_POSITION + "属性配置的包内：" + basePack);
        }
//            ModelBuilderContext context = ModelBuilderContext.builderHelper(conn, cm, conf.getPackagePos(), pos);
        context = ModelBuilderContext.newInstance(cm, basePackPos, pos);
        AbstractCodeGenerator.setContext(context, basePackPos);
        helpers.println("put context in :" + basePackPos + "->" + context);
        packagePos = el.getQualifiedName().toString();
        final DefaultResp defaultResp = el.getAnnotation(DefaultResp.class);
        final DefaultRespConf[] confs = defaultResp.confs();
        for (DefaultRespConf annotation : confs) {
            final String database;
            final String dataSourceId;
            final Set<String> excludeTables;
            final Set<String> includingTables;
            database = annotation.db();
            dataSourceId = annotation.dataSourceId();
            String[] tables = annotation.exceptedTables();
            if (tables.length > 0)
                excludeTables = CollectionHelper.arrayToSet(tables);
            else
                excludeTables = null;
            tables = annotation.includeTables();
            if (tables.length > 0) {
                includingTables = CollectionHelper.arrayToSet(tables);
            } else {
                includingTables = null;
            }
            final String dfAC = annotation.defaultAssembleClass();
            final String dfDA = annotation.defaultDaoClass();
            final String assembleClsConf = annotation.assembleClass();
            final String daoClsConf = annotation.daoClass();
            final Map<String, String> assembleMap = ParamHelper.extractAllPattern(conf, assembleClsConf, 1, 2);
            final Map<String, String> daoMap = ParamHelper.extractAllPattern(conf, daoClsConf, 1, 2);
//            allDt.put(database, new ModelGenConfDetail(database, dataSourceId, excludeTables, includingTables));
            context.addDb(
                    helpers.getConn(dataSourceId),
                    new DbModelConf()
                            .setDb(database)
                            .setIgnoreTbPattern(excludeTables)
                            .setIncludingPattern(includingTables)
                            .setSlave(annotation.isSlave())
                            .setDefaultAssemblerClass(dfAC)
                            .setDefaultBaseDaoClass(dfDA)
                            .setBaseAssembleClass(assembleMap)
                            .setBaseDaoClass(daoMap)
            );
        }
    }

    public String getPackagePos() {
        return packagePos;
    }

//    public String getDatabase() {
//        return database;
//    }
//
//    public String getDataSourceId() {
//        return dataSourceId;
//    }
//
//    public Set<String> getExcludeTables() {
//        return excludeTables;
//    }
//
//    public Set<String> getIncludingTables() {
//        return includingTables;
//    }

    public ModelBuilderContext getContext() {
        return context;
    }
//
//    public ModelGenConf setContext(ModelBuilderContext context) {
//        this.context = context;
//        return this;
//    }
}
