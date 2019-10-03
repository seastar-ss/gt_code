package com.shawn.ss.lib.tools.service_assemble.utils;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.BaseDaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;

import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/10/5.
 */
public class SortAssembler extends BaseDaoAssembler {

    final Set<String> ascFields;
    final Set<String> descFields;

    public SortAssembler(String[] ascSortFields, String[] descSortFields) {
        ascFields = CollectionHelper.arrayToSet(ascSortFields);
        descFields = CollectionHelper.arrayToSet(descSortFields);
    }

    public SortAssembler() {
        ascFields=CollectionHelper.newSet();
        descFields=CollectionHelper.newSet();
    }

    public int ascFieldSize() {
        return ascFields.size();
    }

    public SortAssembler addAscField(String s) {
        ascFields.add(s);
        return this;
    }

    public <T> T[] toArrayOfAscField(T[] a) {
        return ascFields.toArray(a);
    }

    public void clearAscField() {
        ascFields.clear();
    }

    public int descFieldSize() {
        return descFields.size();
    }

    public <T> T[] toArrayofDescField(T[] a) {
        return descFields.toArray(a);
    }

    public SortAssembler addDescField(String s) {
        descFields.add(s);
        return this;
    }

    public void clearDescField() {
        descFields.clear();
    }

    @Override
    protected void assembleSelectSql(SQLSelect statement, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        if(ascFields.size()>0) {
            for (String field : ascFields) {
                statement.order(true, field);
            }
        }
        if(descFields.size()>0) {
            for (String field : descFields) {
                statement.order(false, field);
            }
        }
    }
}
