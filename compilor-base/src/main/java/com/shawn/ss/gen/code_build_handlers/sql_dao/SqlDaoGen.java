package com.shawn.ss.gen.code_build_handlers.sql_dao;

import com.shawn.ss.gen.code_build_handlers.AbstractCodeGenerator;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.base.helper.CommonModelFactory;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.base.helper.db_analyzer.DbAnalyzer;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.SpecialModelDaoConf;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.DbInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlDaoGen extends AbstractCodeGenerator {
    private List<SqlDaoConf> contexts;

    public SqlDaoGen(List<SqlDaoConf> contexts) {
        super();
        this.contexts = contexts;
    }

    @Override
    public void genCode() {
        for(SqlDaoConf ct:contexts) {
            ModelBuilderContext context = ct.getContext();

            List<FieldInfoInterface> params = ct.getParams();
            for (FieldInfoInterface defItem : params) {
                FieldDataTypeInterface type = defItem.getType();
                if (type.isMap()) {
                    throw new IllegalArgumentException("no map sql query parameter allowed , for " + defItem.getFieldName());
                }
                if (!TypeConstantHelper.BASIC_DATA_CLASS_NAMES.contains(type.getTClassName())) {
                    throw new IllegalArgumentException("no class sql query parameter allowed , for " + defItem.getFieldName());
                }
            }
            final String dataSourceName = ct.getDataSourceId();
            final DBConnectionHelper dbInfoHolder = DbDataTable.getDataSource(dataSourceName);
            final DbAnalyzer analyzer = CommonModelFactory.getAnalyzer();

            String baseModelTable = ct.getBaseModel();
//        String baseModel = null;
            Set<String> ignoreField = null;
            if (baseModelTable != null) {
//            baseModel=getModelClassName(baseModelTable, true);
                final DbInfoInterface db = DbDataTable.getDb(baseModelTable);
                TableInfoInterface baseTbInfo = db.getTable(baseModelTable);
                String[] columnNames = baseTbInfo.getTableColumnNames();
                ignoreField = CollectionHelper.newSortedSet();
                ignoreField.addAll(Arrays.asList(columnNames));
            }
            DbAnalyzer.BuildSQLModelParamHolder def=new DbAnalyzer.BuildSQLModelParamHolder()
                    .setDefName(ct.getClassName()+"#"+ct.getMethodName())
                    .setComment(ct.getComment())
                    .setHelper(dbInfoHolder)
                    .setParams(params)
                    .setSql(ct.getSql());
//                    .setInfo(ct.get)
            analyzer.buildModel(def);
//        if(params!=null && params.size()>1){
//            CommonPOJOConf commonPOJOConf=new CommonPOJOConf();
//            String queryModelClzName=getClassNameOfSpecialQueryDto(def.getClzName());
//            def.setQueryModelClzName(queryModelClzName);
//            commonPOJOConf.setPojoClzName(queryModelClzName).setBuilderContext(this);
//            for(CommonParamModelDef defItem:params){
//                commonPOJOConf.addField(defItem);
//            }
//            POJOModelBuilder builder=new POJOModelBuilder(commonPOJOConf);
//            builder.buildModel();
//        }
            SpecialModelDaoConf ret=new SpecialModelDaoConf(def.getDefName(),def.getInfo())
                    .setClzName(ct.getClassName())
                    .setMethodName(ct.getMethodName())
//                    .setDefualtParam(ct.getDefualtParam())
                    .setSql(ct.getSql())
                    .setComment(ct.getComment())
                    .setDataSourceName(ct.getDataSourceId())
                    .setInterfaceClzName(ct.getInterfaceClassName())
                    .setParams(ct.getParams())
                    .setIgnoreField(ignoreField)
                    .setBuildMapper(true);

            context.buildSpecialModalAndDao(
                    ret
//                    .setDataSourceName(context.get)
            );

        }
    }

    @Override
    public void beforeWriteCode() throws IOException {
//        for(SqlDaoConf ct:contexts) {
//            ModelBuilderContext context = ct.getContext();
//            context.writeModel();
//        }
    }
}
