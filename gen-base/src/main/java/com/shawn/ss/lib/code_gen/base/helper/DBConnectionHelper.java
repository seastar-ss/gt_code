/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shawn.ss.lib.code_gen.base.helper;


import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.jdbc.Connection;
//

public class DBConnectionHelper {
    static final Pattern PARAM_PATTERN = Pattern.compile(":([0-9a-zA-Z_]+)");
    static final String PLACE_HOLDER_FOR_SQL = "?";
    final DataSource conn;
    final Properties p;
    final NamedParameterJdbcTemplate jdbcTemplate;
    public final static boolean debug = true;

    static {
        System.out.println("\nswitch sql debug "+debug+" \n");
//        DbHandler.setDebugable(debug);
    }

    private final String dataSourceId;

    public DBConnectionHelper(String dataSourceId, String url,String userName,String password,String driverName) {
        this.dataSourceId = dataSourceId;
        SimpleDataSource con = null;
        this.p = null;
        //helpers.p;
        if(StringHelper.isEmpty(dataSourceId)){
            dataSourceId= CodeHelper.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
        }
        String prefix= (dataSourceId.equals(CodeHelper.KEY_WORD_DEFAULT_DATA_SOURCE_ID)?"":dataSourceId+".");
        try {
            con = new SimpleDataSource();
            con.setUrl(url);
            con.setUser(userName);
            con.setPassword(password);
            con.setDriverName(driverName);
//            Class.forName(p.getProperty("jdbc.driverClassName")).newInstance();
//            con = DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("init data_store failed for "+userName+" @ " + url);
            throw new IllegalArgumentException("can't open data_store");
        } finally {
            conn = con;
            jdbcTemplate = new NamedParameterJdbcTemplate(conn);
        }
    }

    public DBConnectionHelper(String dataSourceId, Properties p) {
        this.dataSourceId = dataSourceId;
        SimpleDataSource con = null;
        this.p = p;
        //helpers.p;
        if(StringHelper.isEmpty(dataSourceId)){
            dataSourceId= CodeHelper.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
        }
        String prefix= (dataSourceId.equals(CodeHelper.KEY_WORD_DEFAULT_DATA_SOURCE_ID)?"":dataSourceId+".");
        try {
            con = new SimpleDataSource();
            con.setUrl(p.getProperty(prefix+"jdbc.url"));
            con.setUser(p.getProperty(prefix+"jdbc.username"));
            con.setPassword(p.getProperty(prefix+"jdbc.password"));
            con.setDriverName(p.getProperty("jdbc.driverClassName"));
//            Class.forName(p.getProperty("jdbc.driverClassName")).newInstance();
//            con = DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("init data_store failed for " + p.toString());
            throw new IllegalArgumentException("can't open data_store");
        } finally {
            conn = con;
            jdbcTemplate = new NamedParameterJdbcTemplate(conn);
        }
    }


    public static class SimpleDataSource implements DataSource {
        PrintWriter printWriter;
        int timeout;
        String url, user, password, driverName;

        @Override
        public Connection getConnection() throws SQLException {
            try {
                Class.forName(driverName).newInstance();
                Connection con = DriverManager.getConnection(url, user, password);
                return con;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            throw new SQLException("can't get connection");
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            this.setUser(username);
            this.setPassword(password);
            return getConnection();
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return printWriter;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {
            printWriter = out;
        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {
            timeout = seconds;
        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return timeout;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        public String getUrl() {
            return url;
        }

        public SimpleDataSource setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getUser() {
            return user;
        }

        public SimpleDataSource setUser(String user) {
            this.user = user;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public SimpleDataSource setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getDriverName() {
            return driverName;
        }

        public SimpleDataSource setDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }
    }

    public DBConnectionHelper(Properties p) {
        this(null,p);
    }

    public Connection getConnection() {
        try {
            return conn.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("not functional jdbc");
        }
    }

    public NamedParameterJdbcTemplate getJdbcTemplate() {

        return jdbcTemplate;
    }

    public String getDataSourceId() {
        return StringHelper.isEmpty(dataSourceId)? CodeHelper.KEY_WORD_DEFAULT_DATA_SOURCE_ID:dataSourceId;
    }

//    public DBConnectionHelper setDataSourceId(String dataSourceId) {
//        this.dataSourceId = dataSourceId;
//        return this;
//    }

    public class NamedPreparedStatement {

        final PreparedStatement st;
        final Map<String, Integer> params;
        final String originSql;

//        NamedPreparedStatement(PreparedStatement st, Map<String, Integer> params) {
//            this.st = st;
//            this.params = params;
//            originSql=
//        }

        NamedPreparedStatement(String sql) throws SQLException {
            this.params = CollectionHelper.newMap();
            this.originSql = sql;
            Matcher m = PARAM_PATTERN.matcher(sql);
            int start = 0;
            int index = 1;
            while (m.find(start)) {
                String k = m.group(1);
                sql = sql.replace(k, PLACE_HOLDER_FOR_SQL);
                params.put(k, index);
                start = m.end();
                ++index;
            }
            this.st = getConnection().prepareStatement(sql);
        }

        public Statement bindParam(Map<String, Object> param) throws SQLException {
            Set<String> keySet = params.keySet();
            for (String k : keySet) {
                if (param.containsKey(k)) {
                    Object obj = param.get(k);
                    int index = params.get(k);
                    Class<?> contentType = obj.getClass();
                    if (contentType.equals(Integer.class) || contentType.equals(int.class)) {
                        st.setObject(index, obj, Types.INTEGER);
                    } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
                        st.setObject(index, obj, Types.BIGINT);
                    } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
                        st.setObject(index, obj, Types.TINYINT);
                    } else if (contentType.equals(Character.class) || contentType.equals(char.class)) {
                        st.setObject(index, obj, Types.TINYINT);
                    } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
                        st.setObject(index, obj, Types.TINYINT);
                    } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
                        st.setObject(index, obj, Types.DOUBLE);
                    } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
                        st.setObject(index, obj, Types.FLOAT);
                    } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
                        st.setObject(index, obj, Types.SMALLINT);
                    } else if (contentType.equals(String.class)) {
                        st.setObject(index, obj, Types.VARCHAR);
                    } else if (contentType.equals(java.util.Date.class)) {
                        st.setObject(index, obj, Types.DATE);
                    } else if (contentType.isArray() && contentType.getComponentType().equals(byte.class)) {
                        st.setBytes(index, (byte[]) obj);
                    } else if (contentType.isArray()) {

                    }
                } else {
                    throw new IllegalArgumentException("statement key " + k + " not set in " + param);
                }
            }
            return st;
        }
    }

//    public NamedPreparedStatement prepare(String sql) throws SQLException {
//
//        return new NamedPreparedStatement(sql);
//    }

}
