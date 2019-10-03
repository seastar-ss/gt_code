/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.create.table;

import net.sf.jsqlparser.util.SelectUtils;

import java.util.List;

public class Index {

    private String type;
    private String using;
    private List<String> columnsNames;
    private String name;
    private List<String> idxSpec;

    public List<String> getColumnsNames() {
        return columnsNames;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    /**
     * In postgresql, the index type (Btree, GIST, etc.) is indicated
     * with a USING clause.
     * Please note that:
     * Oracle - the type might be BITMAP, indicating a bitmap kind of index
     * MySQL - the type might be FULLTEXT or SPATIAL
     */
    public void setUsing(String string) {
        using = string;
    }

    public void setColumnsNames(List<String> list) {
        columnsNames = list;
    }

    public void setName(String string) {
        name = string;
    }

    public void setType(String string) {
        type = string;
    }

    public String getUsing() {
        return using;
    }

    public List<String> getIndexSpec() {
        return idxSpec;
    }

    public void setIndexSpec(List<String> idxSpec) {
        this.idxSpec = idxSpec;
    }

    @Override
    public String toString() {
        String idxSpecText = SelectUtils.getStringList(idxSpec, false, false);
        return new StringBuilder().append(type)
                .append(" ")
                .append(name != null ? name : "")
                .append(" ")
                .append(SelectUtils.getStringList(columnsNames, true, true))
                .append(" ")
                .append(!"".equals(idxSpecText) ? idxSpecText : "").toString();
    }
}
