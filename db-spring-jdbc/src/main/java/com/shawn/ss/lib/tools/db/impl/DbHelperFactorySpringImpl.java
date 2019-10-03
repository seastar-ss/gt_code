//package com.shawn.ss.lib.tools.db.impl;
//
//import com.shawn.ss.lib.tools.data_store.api.interfaces.db_operation.SqlDbHelperInterface;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//public class DbHelperFactorySpringImpl extends AbstractDbHelperFactoryImpl {
//    boolean debug = true;
//    private DataSource dts;
//    private Properties props;
//
//    @Override
//    public SqlDbHelperInterface getHelper() {
//        return new SqlDbHelperSpringImpl(dts, props, debug);
//    }
//
//    @Override
//    public void setDebug(boolean debug) {
//        this.debug = debug;
//    }
//
//    @Override
//    public void setDataSource(DataSource dts) {
//        this.dts = dts;
//    }
//
//    @Override
//    public void setProperties(Properties p) {
//        props = p;
//    }
//
//}
