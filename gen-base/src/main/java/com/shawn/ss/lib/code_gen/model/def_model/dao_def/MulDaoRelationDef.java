package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseRelationDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Map;

public class MulDaoRelationDef implements _BaseRelationDef {

    final Map<String, String> additionalCondition;
    FieldInfoInterface relatedField;
    String additionalWhere;
    String fieldName;
    boolean isSingle;
    String fieldInThisTable;
    String fieldInRelatedTable;
    Integer batchSize;
    boolean isMain;

    public MulDaoRelationDef() {
        additionalCondition = CollectionHelper.newMap();
    }

    public String getAdditionalCondition(Object key) {
        return additionalCondition.get(key);
    }

    public String putAdditionalCondition(String key, String value) {
        return additionalCondition.put(key, value);
    }

    @Override
    public Map<String, String> getAdditionalCondition() {
        return additionalCondition;
    }

    @Override
    public FieldInfoInterface getRelatedField() {
        return relatedField;
    }

    @Override
    public Integer getBatchSize() {
        return batchSize;
    }

    public MulDaoRelationDef setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    public MulDaoRelationDef setRelatedField(FieldInfoInterface relatedField) {
        this.relatedField = relatedField;
        return this;
    }

    @Override
    public String getAdditionalWhere() {
        return additionalWhere;
    }

    public MulDaoRelationDef setAdditionalWhere(String additionalWhere) {
        this.additionalWhere = additionalWhere;
        return this;
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    public MulDaoRelationDef setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    @Override
    public boolean isSingle() {
        return isSingle;
    }

    public MulDaoRelationDef setSingle(boolean single) {
        isSingle = single;
        return this;
    }

    @Override
    public String getFieldInThisTable() {
        return fieldInThisTable;
    }

    public MulDaoRelationDef setFieldInThisTable(String fieldInThisTable) {
        this.fieldInThisTable = fieldInThisTable;
        return this;
    }

    @Override
    public String getFieldInRelatedTable() {
        return fieldInRelatedTable;
    }

    public MulDaoRelationDef setFieldInRelatedTable(String fieldInRelatedTable) {
        this.fieldInRelatedTable = fieldInRelatedTable;
        return this;
    }

    @Override
    public boolean isMain() {
        return isMain;
    }

    public MulDaoRelationDef setMain(boolean main) {
        isMain = main;
        return this;
    }
}
