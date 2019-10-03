package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.DbInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DbInfo implements DbInfoInterface {
    String dbName;
    List<TableInfo> tables;
    Map<String,TableInfo> tableInfoMap;

    public DbInfo(String dbName) {
        this.dbName = dbName;
        tables= CollectionHelper.newList();
        tableInfoMap=CollectionHelper.newMap();
    }

    @Override
    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public List<TableInfoInterface> getTables() {
        return Collections.<TableInfoInterface>unmodifiableList(tables);
    }

    @Override
    public TableInfoInterface getTable(String tableName) {
        return tableInfoMap.get(tableName);
    }

//    public void setTables(List<TableInfo> tables) {
//        this.tables = tables;
//    }

    public int size() {
        return tables.size();
    }

    public boolean isEmpty() {
        return tables.isEmpty();
    }

    public TableInfoInterface get(int index) {
        return tables.get(index);
    }

    public void add( TableInfo element) {
        tables.add(element);
        tableInfoMap.put(element.getTable(),element);
    }

    public boolean addAll(Collection<? extends TableInfo> c) {
        for(TableInfo element:c){
            tableInfoMap.put(element.getTable(),element);
        }
        return tables.addAll(c);

    }
}
