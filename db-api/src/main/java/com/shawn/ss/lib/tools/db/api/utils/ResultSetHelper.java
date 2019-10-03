package com.shawn.ss.lib.tools.db.api.utils;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnInfo;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.ColumnDataType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.TableInfo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by ss on 2017/10/9.
 */
public class ResultSetHelper {

    public static Set<String> getAllColumns(ResultSet crs) {
        Set<String> ret = CollectionHelper.<String>newSortedSet();
        try {
            ResultSetMetaData meta = crs.getMetaData();
            int numCol = meta.getColumnCount();
            for (int i = 1; i <= numCol; i++) {
                ret.add(meta.getColumnLabel(i));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    public static int getColumnDef(ResultSet crs,TableInfoInterface tbi,String name) {

        TableInfo tb;//=new TableInfo();
        int ret=0;
        if(tbi instanceof TableInfo) {
            tb=(TableInfo)tbi;
            try {
                ResultSetMetaData meta = crs.getMetaData();
                int numCol = meta.getColumnCount();
                for (int i = 1; i <= numCol; i++) {
                    try {
                        ColumnInfo info = new ColumnInfo();
                        info.setFieldName(meta.getColumnLabel(i));
                        info.setExtra(meta.getColumnName(i));
                        info.setType(ColumnDataType.getType(meta.getColumnTypeName(i)));
                        info.setTable(meta.getTableName(i));
                        info.setPrecision(meta.getPrecision(i));
                        info.setDb(meta.getSchemaName(i));
                        info.setComment("from sql:"+name+",column {"+info.getFieldName()+"("+info.getExtra()+")}");
                        tb.addCol(info);
                        ret++;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    //meta.getColumnType()
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return ret;
//        return tb;
    }

}
