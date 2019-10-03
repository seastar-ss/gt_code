package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.List;
import java.util.Map;

/**
 * Created by ss on 2017/10/11.
 */
public class TableInfo implements TableInfoInterface{
    public static final String EXTEND_BY_NUMBER = "extendedByNumber", EXTEND_BY_DATE = "extendedByDate";
    String tableName;
    String dbName;
    boolean isGenericTable;
    String prefix;
    String tablePattern;
    String extendType;
    String tableComment;
    int tableType=0;
    String charset;
    Integer prKeyIndex;
    List<ColumnInfoInterface> columns;
    Map<String,ColumnInfoInterface> columnMap;

    public TableInfo() {
        columns= CollectionHelper.newList();
        columnMap=CollectionHelper.newMap();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setGenericTable(boolean genericTable) {
        isGenericTable = genericTable;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setTablePattern(String tablePattern) {
        this.tablePattern = tablePattern;
    }

    public void setExtendType(String extendType) {
        this.extendType = extendType;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setColumns(List<ColumnInfoInterface> columns) {
        this.columns = columns;
        for(ColumnInfoInterface column:columns){
            columnMap.put(column.getFieldName(),column);
        }
    }

    public int sizeOfCol() {
        return columns.size();
    }

    public boolean isColEmpty() {
        return columns.isEmpty();
    }

    public boolean addCol(ColumnInfoInterface columnInfoInterface) {
        columnMap.put(columnInfoInterface.getFieldName(),columnInfoInterface);
        return columns.add(columnInfoInterface);
    }

    public void setPrKeyIndex(Integer prKeyIndex) {
        this.prKeyIndex = prKeyIndex;
    }

    @Override
    public String getTable() {
        return tableName;
    }

    @Override
    public String getDb() {
        return dbName;
    }

    @Override
    public String[] getTableColumnNames() {
        int size = columns.size();
        String[] ret=new String[size];
        for(int i = 0, n = size; i<n; ++i){
            ColumnInfoInterface col = columns.get(i);
            if(col!=null){
                ret[i]=col.getFieldName();
            }
        }
        return ret;
    }

    @Override
    public String getPriKey() {
        if(prKeyIndex!=null && prKeyIndex>=0 && prKeyIndex<columns.size()){
            return columns.get(prKeyIndex).getFieldName();
        }
        return null;
    }

    @Override
    public FieldDataTypeInterface getPriKeyType() {
        if(prKeyIndex!=null && prKeyIndex>=0 && prKeyIndex<columns.size()){
            return columns.get(prKeyIndex).getType();
        }
        return null;
    }

    @Override
    public List<ColumnInfoInterface> getColumns() {
        return columns;
    }

    @Override
    public TableInfo getTableInfo() {
        return this;
    }

    @Override
    public List<IndexInfo> getIndexes() {
        return null;
    }

    @Override
    public List<TableReferInfo> getReferFromTable() {
        return null;
    }

    @Override
    public List<TableReferInfo> getReferToTable() {
        return null;
    }

    @Override
    public FieldDataTypeInterface getColumnDataType(String colName) {
        ColumnInfoInterface columnInfoInterface = columnMap.get(colName);
        return columnInfoInterface==null?null:columnInfoInterface.getType();
    }

    @Override
    public ColumnInfoInterface getColumnData(String colName) {
        ColumnInfoInterface columnInfoInterface = columnMap.get(colName);
        return columnInfoInterface;
    }


    public Map<String,ColumnInfoInterface> getColMap(){
        return columnMap;
    }

    @Override
    public int getTableType() {
        return tableType;
    }

    @Override
    public String getTableComment() {
        return tableComment;
    }

    @Override
    public String getCharset() {
        return charset;
    }

    @Override
    public int getColumnCount() {
        return columns==null?-1:columns.size();
    }



    //    @Override
    public TableInfo setTableType(int tableType) {
        this.tableType = tableType;
        return this;
    }
}
