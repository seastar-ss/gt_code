package com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

/**
 * Created by ss on 2018/2/19.
 */
public class FakeModelBuilder {
    TableInfoInterface info;
//    private final ModelBuilderContext builderContext;
    private final String baseTable;
//    final Set<String> ignoreField;
    final String table;
    final String db;
//    final List<ColumnInfoInterface> columns;
//    final String modelClassName;
//    final JCodeModel cm;
//    final AbstractJClass extendedClazz;
//    JDefinedClass definedClass;
//    Map<String, JFieldVar> allModelFields;
//    Map<String, JMethod> allGetFields;
//    Map<String, JMethod> allSetFields;


    public FakeModelBuilder(String baseTable, String table, String db, TableInfoInterface info) {
        this.baseTable = baseTable;
        this.table = table;
        this.db = db;
        this.info = info;
    }

    public TableInfoInterface getInfo() {
        return info;
    }

    public FakeModelBuilder setInfo(TableInfoInterface info) {
        this.info = info;
        return this;
    }

    public String getBaseTable() {
        return baseTable;
    }

    public String getTable() {
        return table;
    }

    public String getDb() {
        return db;
    }
}
