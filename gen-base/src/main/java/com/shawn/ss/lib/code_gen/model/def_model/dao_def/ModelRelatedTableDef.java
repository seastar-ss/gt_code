package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.model.def_model._BaseDef;

import java.util.Map;

public class ModelRelatedTableDef implements _BaseDef {
    String db;
    String table;
    String fieldInThisTable;
    String fieldInMainTable;
    String fieldName;
    boolean fieldInThisTableIsId;
    String additionalWhere;
    Map<String,String> additionalCondition;
//    SpecialModelDef attr;
    boolean single;

    public String getTable() {
        return table;
    }

    public ModelRelatedTableDef setTable(String table) {
        this.table = table;
        return this;
    }

    public String getFieldInThisTable() {
        return fieldInThisTable;
    }

    public ModelRelatedTableDef setFieldInThisTable(String fieldInThisTable) {
        this.fieldInThisTable = fieldInThisTable;
        return this;
    }

    public String getFieldInMainTable() {
        return fieldInMainTable;
    }

    public ModelRelatedTableDef setFieldInMainTable(String fieldInMainTable) {
        this.fieldInMainTable = fieldInMainTable;
        return this;
    }

    public boolean isFieldInThisTableIsId() {
        return fieldInThisTableIsId;
    }

    public ModelRelatedTableDef setFieldInThisTableIsId(boolean fieldInThisTableIsId) {
        this.fieldInThisTableIsId = fieldInThisTableIsId;
        return this;
    }

    public boolean isSingle() {
        return single;
    }

    public ModelRelatedTableDef setSingle(boolean single) {
        this.single = single;
        return this;
    }

    public String getDb() {
        return db==null? DbDataTable.getCurrentDb():db;
    }

    public ModelRelatedTableDef setDb(String db) {
        this.db = db;
        return this;
    }

    //    public SpecialModelDef getAttr() {
//        return attr;
//    }
//
//    public ModelRelatedTableDef setAttr(SpecialModelDef attr) {
//        this.attr = attr;
////        String baseModelTable = attr.getBaseModelTable();
////        if(baseModelTable!=null && !baseModelTable.equals(table)){
////            throw new IllegalArgumentException("attr table "+baseModelTable+" not match "+table);
////        }
//        return this;
//    }


    public ModelRelatedTableDef() {
    }

    public ModelRelatedTableDef(String table, String fieldInThisTable, String fieldInMainTable, boolean single) {
        this.table = table;
        this.fieldInThisTable = fieldInThisTable;
        this.fieldInMainTable = fieldInMainTable;
        this.single = single;
        this.fieldInThisTableIsId=false;
    }

    public ModelRelatedTableDef(String table, String fieldInThisTable, String fieldInMainTable, boolean fieldInThisTableIsId,boolean single) {
        this.table = table;
        this.fieldInThisTable = fieldInThisTable;
        this.fieldInMainTable = fieldInMainTable;
        this.fieldInThisTableIsId = fieldInThisTableIsId;
        this.single = single;
    }

    public ModelRelatedTableDef(String db,String table, String fieldInThisTable, String fieldInMainTable, boolean fieldInThisTableIsId, boolean single, String fieldName) {
        this.table = table;
        this.db=db;
        this.fieldInThisTable = fieldInThisTable;
        this.fieldInMainTable = fieldInMainTable;
        this.fieldName = fieldName;
        this.fieldInThisTableIsId = fieldInThisTableIsId;
        this.single = single;
    }

    public String getFieldName() {
        return fieldName;
    }

    public ModelRelatedTableDef setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getAdditionalWhere() {
        return additionalWhere;
    }

    public ModelRelatedTableDef setAdditionalWhere(String additionalWhere) {
        this.additionalWhere = additionalWhere;
        return this;
    }

    public Map<String,String> getAdditionalCondition() {
        return additionalCondition;
    }

    public ModelRelatedTableDef setAdditionalCondition(Map<String,String> additionalCondition) {
        this.additionalCondition = additionalCondition;
        return this;
    }

    @Override
    public String toString() {
        return "ModelRelatedTableDef{" +
                "data_store='" + db + '\'' +
                ", table='" + table + '\'' +
                ", fieldInThisTable='" + fieldInThisTable + '\'' +
                ", fieldInMainTable='" + fieldInMainTable + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldInThisTableIsId=" + fieldInThisTableIsId +
                ", additionalWhere='" + additionalWhere + '\'' +
                ", single=" + single +
                '}';
    }
}
