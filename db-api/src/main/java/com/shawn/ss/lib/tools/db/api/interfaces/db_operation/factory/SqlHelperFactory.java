package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.SqlDbHelperInterface;

import javax.sql.DataSource;
import java.util.Properties;

public interface SqlHelperFactory {
    SqlDbHelperInterface getHelper();

    void setDebug(boolean debug);

    void setDataSource(DataSource dts);

    void setProperties(Properties p);
}
