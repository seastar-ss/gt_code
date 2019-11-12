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
public interface ResultSetHelper {

    public Set<String> getAllColumns(ResultSet crs) ;

    public int getColumnDef(ResultSet crs,TableInfoInterface tbi,String name) ;

}
