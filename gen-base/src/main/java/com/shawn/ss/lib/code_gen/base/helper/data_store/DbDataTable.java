package com.shawn.ss.lib.code_gen.base.helper.data_store;

import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.base.helper.DbInfoHandler;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.DbInfoInterface;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DbDataTable {
    //    public static final Map<String,DataSourceInfoHolder> ALL_DATA_SOURCE= CollectionHelper.newMap(8);
    private static final Map<String, DBConnectionHelper> ALL_DATASOURCES = CollectionHelper.newMap(32);
    private static final Map<String, DbInfoInterface> ALL_DBS = CollectionHelper.newMap(32);
    private static final Map<Long, DbInfoHandler> ALL_HOLDERS = CollectionHelper.newMap(64);
    private static Map<String, List<DbInfoHandler>> DB_NAME_INDEXES = CollectionHelper.newMap(32);

    private static volatile String currentDb;

    public static boolean containsDbKey(Object key) {
        return ALL_DBS.containsKey(key);
    }

    public static int sizeOfHolder() {
        return ALL_HOLDERS.size();
    }

    public static boolean isHolderEmpty() {
        return ALL_HOLDERS.isEmpty();
    }

    public static boolean containsHolderKey(Long key) {
        return ALL_HOLDERS.containsKey(key);
    }

    public static DbInfoHandler getHolder(Long key) {
        return ALL_HOLDERS.get(key);
    }

    public static Collection<DbInfoHandler> holderValues() {
        return ALL_HOLDERS.values();
    }

    //    public static DbInfoHandler putDb(String key, DbInfoHandler value) {
//        return ALL_DBS.put(key, value);

//    }

    public static List<DbInfoHandler> getAllSlaveHandlerByName(String dbName) {
        List<DbInfoHandler> list = DB_NAME_INDEXES.get(dbName);
        if (list != null && list.size() > 1) {
            List<DbInfoHandler> ret = CollectionHelper.newList(list.size());
            for (DbInfoHandler dbInfoHandler : list) {
//                DbInfoHandler dbInfoHandler = ALL_HOLDERS.get(i);
                if (dbInfoHandler != null && dbInfoHandler.isSlave()) {
                    ret.add(dbInfoHandler);
                }
            }
            return ret;
        }
        return null;
    }

    public static List<String> getAllSlaveSourceNameByName(String dbName) {
        List<DbInfoHandler> list = getAllSlaveHandlerByName(dbName);
        if (list == null) {
            return null;
        }
        List<String> ret = CollectionHelper.newList(list.size());
        for (DbInfoHandler dbInfoHandler : list) {
//                DbInfoHandler dbInfoHandler = ALL_HOLDERS.get(i);
//                if(dbInfoHandler !=null && dbInfoHandler.isSlave()){
            ret.add(dbInfoHandler.getDataSourceId());
//                }
        }
        return ret;

    }

    public static DbInfoInterface getDb(Object key) {
        return ALL_DBS.get(key);
    }

    public static int sizeOfDataSource() {
        return ALL_DATASOURCES.size();
    }

    public static boolean isDataSourceEmpty() {
        return ALL_DATASOURCES.isEmpty();
    }

    public static boolean containsDataSourceKey(Object key) {
        return ALL_DATASOURCES.containsKey(key);
    }

    public static DBConnectionHelper getDataSource(Object key) {
        return ALL_DATASOURCES.get(key);
    }

//    public static DbInfoHandler putDataSource(String key, DbInfoHandler value) {
//        return ALL_DATASOURCES.put(key, value);
//    }

    public static Collection<DBConnectionHelper> dataSourceValues() {
        return ALL_DATASOURCES.values();
    }

    public synchronized static long putDbInfo(DbInfoHandler value) {
        final long uuid = value.getUuid();
        final String dbName = value.getDb();
        ALL_DATASOURCES.put(value.getDataSourceId(), value.getConnection());
        ALL_DBS.put(dbName, value.getDbInfo());
        ALL_HOLDERS.put(uuid, value);
        List<DbInfoHandler> list = DB_NAME_INDEXES.get(dbName);
        if (list == null) {
            list = CollectionHelper.newList();
        }
        list.add(value);
        DB_NAME_INDEXES.put(dbName, list);
        currentDb = dbName;
        return uuid;
    }

    public static boolean inited() {
        return ALL_DBS.size() > 0 && currentDb != null;
    }

    public static String getCurrentDb() {
        return currentDb;
    }
}
