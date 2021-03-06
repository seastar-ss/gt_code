//package com.shawn.ss.lib.code_gen.model.def_model.dao_def;
//
//import com.shawn.ss.lib.code_gen.base.helper.data_store.ConfDataTable;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseDef;
//import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseSubDaoConf;
//
//import java.util.Map;
//
//public class ModelRelatedTableDef implements _BaseDef {
//
//    _BaseSubDaoConf.EnumFieldDataSrcType type;
//
//    /* for common dao */
////    String db;
////    String table;
//
//    /* for special dao */
//    String name;
//
//    /* for mul dao */
//
//    String fieldInThisTable;
//    String fieldInMainTable;
//
//    String fieldName;
//    boolean single;
//
////    boolean fieldInThisTableIsId;
//    String additionalWhere;
//    Map<String,String> additionalCondition;
////    SpecialModelConf attr;
//
//
//
//
//    public String getTable() {
//        _BaseDaoConfImpl conf = ConfDataTable.get(name);
////        if(conf instanceof CommonModelDef){
////            CommonModelDef def = (CommonModelDef) conf;
////            return def.getDef().getTable();
////        }
//        return conf.getTable();
//    }
//
////    public ModelRelatedTableDef setTable(String table) {
////        this.table = table;
////        return this;
////    }
//
//    public String getFieldInThisTable() {
//        return fieldInThisTable;
//    }
//
//    public ModelRelatedTableDef setFieldInThisTable(String fieldInThisTable) {
//        this.fieldInThisTable = fieldInThisTable;
//        return this;
//    }
//
//    public String getFieldInMainTable() {
//        return fieldInMainTable;
//    }
//
//    public ModelRelatedTableDef setFieldInMainTable(String fieldInMainTable) {
//        this.fieldInMainTable = fieldInMainTable;
//        return this;
//    }
//
////    public boolean isFieldInThisTableIsId() {
////        return fieldInThisTableIsId;
////    }
//
////    public ModelRelatedTableDef setFieldInThisTableIsId(boolean fieldInThisTableIsId) {
////        this.fieldInThisTableIsId = fieldInThisTableIsId;
////        return this;
////    }
//
//    public boolean isSingle() {
//        return single;
//    }
//
//    public ModelRelatedTableDef setSingle(boolean single) {
//        this.single = single;
//        return this;
//    }
//
//    public String getDb() {
//        _BaseDaoConfImpl conf = ConfDataTable.get(name);
////        if(conf instanceof CommonModelDef){
////            CommonModelDef def = (CommonModelDef) conf;
////            return def.getTable();
////        }
//        return conf.getDb();
//    }
//
////    public ModelRelatedTableDef setDb(String db) {
////        this.db = db;
////        return this;
////    }
//
//    //    public SpecialModelConf getAttr() {
////        return attr;
////    }
////
////    public ModelRelatedTableDef setAttr(SpecialModelConf attr) {
////        this.attr = attr;
//////        String baseModelTable = attr.getBaseModelTable();
//////        if(baseModelTable!=null && !baseModelTable.equals(table)){
//////            throw new IllegalArgumentException("attr table "+baseModelTable+" not match "+table);
//////        }
////        return this;
////    }
//
//
//    public ModelRelatedTableDef() {
//        type= _BaseSubDaoConf.EnumFieldDataSrcType.commonDao;
//    }
//
//    public ModelRelatedTableDef(String name, String fieldInThisTable, String fieldInMainTable, boolean single) {
//        this(name, _BaseSubDaoConf.EnumFieldDataSrcType.commonDao,fieldInThisTable,fieldInMainTable,single);
//    }
//
//    public ModelRelatedTableDef(String name, _BaseSubDaoConf.EnumFieldDataSrcType type, String fieldInThisTable, String fieldInMainTable, boolean single) {
//        this.name = name;
//        this.type=type;
//        this.fieldInThisTable = fieldInThisTable;
//        this.fieldInMainTable = fieldInMainTable;
//        this.single = single;
////        this.fieldInThisTableIsId=false;
//    }
//
////    public ModelRelatedTableDef(String table, String fieldInThisTable, String fieldInMainTable, boolean fieldInThisTableIsId,boolean single) {
////        this.table = table;
////        this.fieldInThisTable = fieldInThisTable;
////        this.fieldInMainTable = fieldInMainTable;
//////        this.fieldInThisTableIsId = fieldInThisTableIsId;
////        this.single = single;
////    }
////
////    public ModelRelatedTableDef(String db,String table, String fieldInThisTable, String fieldInMainTable,  boolean single, String fieldName) {
////        this.table = table;
////        this.db=db;
////        this.fieldInThisTable = fieldInThisTable;
////        this.fieldInMainTable = fieldInMainTable;
////        this.fieldName = fieldName;
//////        this.fieldInThisTableIsId = fieldInThisTableIsId;
////        this.single = single;
////    }
//
//    public String getFieldName() {
//        return fieldName;
//    }
//
//    public ModelRelatedTableDef setFieldName(String fieldName) {
//        this.fieldName = fieldName;
//        return this;
//    }
//
//    public String getAdditionalWhere() {
//        return additionalWhere;
//    }
//
//    public ModelRelatedTableDef setAdditionalWhere(String additionalWhere) {
//        this.additionalWhere = additionalWhere;
//        return this;
//    }
//
//    public Map<String,String> getAdditionalCondition() {
//        return additionalCondition;
//    }
//
//    public ModelRelatedTableDef setAdditionalCondition(Map<String,String> additionalCondition) {
//        this.additionalCondition = additionalCondition;
//        return this;
//    }
//
//    public _BaseSubDaoConf.EnumFieldDataSrcType getType() {
//        return type;
//    }
//
//    public ModelRelatedTableDef setType(_BaseSubDaoConf.EnumFieldDataSrcType type) {
//        this.type = type;
//        return this;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public ModelRelatedTableDef setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//
//
//    @Override
//    public String toString() {
//        return "ModelRelatedTableDef{" +
//                "type=" + type +
//                ", name='" + name + '\'' +
//                ", fieldInThisTable='" + fieldInThisTable + '\'' +
//                ", fieldInMainTable='" + fieldInMainTable + '\'' +
//                ", fieldName='" + fieldName + '\'' +
//                ", single=" + single +
//                ", additionalWhere='" + additionalWhere + '\'' +
//                ", additionalCondition=" + additionalCondition +
//                '}';
//    }
//}
