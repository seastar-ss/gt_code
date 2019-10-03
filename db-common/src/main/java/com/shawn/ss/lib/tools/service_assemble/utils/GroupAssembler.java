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
public class GroupAssembler extends BaseDaoAssembler {

    final Set<String> groupField;
//    final Set<String> descFields;

    public GroupAssembler(String[] fields) {
        groupField = CollectionHelper.arrayToSet(fields);
//        descFields = CollectionHelper.arrayToSet(descSortFields);
    }

    public GroupAssembler() {
        groupField =CollectionHelper.newSet();
//        descFields=CollectionHelper.newSet();
    }

    public int fieldSize() {
        return groupField.size();
    }

    public GroupAssembler addField(String s) {
        groupField.add(s);
        return this;
    }

    public <T> T[] toArrayOfAscField(T[] a) {
        return groupField.toArray(a);
    }

    public void clearAscField() {
        groupField.clear();
    }

    @Override
    protected void assembleSelectSql(SQLSelect statement, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        if(groupField.size()>0) {
            for (String field : groupField) {
                statement.itemGroup(field);
            }
        }

    }
}
