package com.shawn.ss.lib.code_gen.base.helper.db_analyzer;

import com.shawn.ss.lib.code_gen.base.helper.CodeHelper;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.SpecialModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.*;
import com.shawn.ss.lib.tools.db.impl.utils.HelperFactory;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;

/**
 * Created by ss on 2015/6/20.
 */
public class DbAnalyzer {


    public final static org.slf4j.Logger L = LoggerFactory.getLogger(DbAnalyzer.class);

    public static void main(String[] args) {
//        DBConnection c = new DBConnection("data_store.properties");
////        Map<String, TableDef> defss=CollectionBuilder.newHashMap();
//        DbAnalyzer anl = new DbAnalyzer();
//        anl.buildModel(c.conn,  new DbInfo("hackathon"));
    }

    CommentAnalyzer commentAnalyzer;

    public DbAnalyzer() {
        commentAnalyzer = new CommentAnalyzer();
    }

    //    static class ColumnUsage{
//        String TABLE_SCHEMA,TABLE_NAME,COLUMN_NAME,REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME,CONSTRAINT_NAME;
//    }

    public void buildModel(final DBConnectionHelper helper, final SpecialModelConf def) {
        NamedParameterJdbcTemplate template = helper.getJdbcTemplate();
        String sql = def.getSql();
        Map<String, Object> defualtParam = makeDefaultParam(def);
        TableInfoInterface info = def.getDef();
        final String defName = def.getMethodName();
        TableInfo tbInfo;
        if (info == null || !(info instanceof TableInfo)) {
            tbInfo = new TableInfo();
            tbInfo.setTableType(2);
            tbInfo.setTableName(defName);
            tbInfo.setTableComment(def.getComment());
        } else {
            tbInfo = (TableInfo) info;
        }
        Boolean succ = false;
        final TableInfoInterface tableInfo = tbInfo;
//        SpecialModelDef.DataAttrType type = modelDef.getDataType();
//        switch (type) {
//            case SQL:
        if (sql != null) {
            succ = template.query(sql, defualtParam, new DBInfoResultSetExtractor(tableInfo, defName));
        }
//                break;
//            case COUNT_WITH_SAME_CONDITION:
//                break;
//            case FIXED_VALUE:
//                break;
//        }
        if (!succ) {
            throw new IllegalArgumentException("sql :" + sql + " query for:" + defualtParam.toString() + " can't be executed");
        } else {
//            String baseModelTable = modelDef.getBaseModelTable();
//            def.setDef(tableInfo);
        }
    }

    private Map<String, Object> makeDefaultParam(SpecialModelConf def) {
        Map<String, Object> defualtParam = def.getDefualtParam();
        if (defualtParam == null) {
            defualtParam = CollectionHelper.newMap();
            def.setDefualtParam(defualtParam);
        }
        List<FieldInfoInterface> params = def.getParams();
//        L.warn("get params :"+params);
        for (FieldInfoInterface item : params) {
            FieldDataTypeInterface type = item.getType();
            String clzName = type.getTClassName();
            String paramName = item.getFieldName();
            if (!defualtParam.containsKey(paramName)) {
                if (TypeConstantHelper.BASIC_DATA_CLASS_NAMES.contains(clzName)) {
                    Object o = TypeConstantHelper.testAndUppackPrimitiveType(null, clzName);
                    if (!type.isArray() && !type.isCollection()) {
//                        Object o = TypeConstantHelper.testAndUppackPrimitiveType(null, clzName);
                        defualtParam.put(paramName, o);
                    } else {
                        defualtParam.put(paramName, Collections.singleton(o));
                    }
                } else {

                }
            }
        }
        L.warn("get map:" + defualtParam);
        return defualtParam;
    }

    public static class BuildModelParamHolder {
        Connection conn;
        DbInfo dbInfo;
        Set<String> ignoreTbPattern;
        Set<String> includingTable;
        String dbName;
        List<ColumnInfo> allCols;
        Map<String, TableInfo> tables;

        public BuildModelParamHolder(Connection conn, DbInfo dbInfo, Set<String> ignoreTbPattern, Set<String> includingTable) {
            this.conn = conn;
            this.dbInfo = dbInfo;
            this.ignoreTbPattern = ignoreTbPattern;
            this.includingTable = includingTable;
            this.dbName = dbInfo.getDbName();
            allCols = CollectionHelper.newList();
            tables = CollectionHelper.newMap();
        }

        public Connection getConn() {
            return conn;
        }

        public BuildModelParamHolder setConn(Connection conn) {
            this.conn = conn;
            return this;
        }

        public DbInfo getDbInfo() {
            return dbInfo;
        }

        public BuildModelParamHolder setDbInfo(DbInfo dbInfo) {
            this.dbInfo = dbInfo;
            return this;
        }

        public Set<String> getIgnoreTbPattern() {
            return ignoreTbPattern;
        }

        public BuildModelParamHolder setIgnoreTbPattern(Set<String> ignoreTbPattern) {
            this.ignoreTbPattern = ignoreTbPattern;
            return this;
        }

        public Set<String> getIncludingTable() {
            return includingTable;
        }

        public BuildModelParamHolder setIncludingTable(Set<String> includingTable) {
            this.includingTable = includingTable;
            return this;
        }

        public String getDbName() {
            return dbName;
        }

        public BuildModelParamHolder setDbName(String dbName) {
            this.dbName = dbName;
            return this;
        }
    }

    public void buildModel(BuildModelParamHolder input) {

//        }
//        String data_store=dbInfo.getDbName();
//        Map<String, List<TableRowExt>> tbCols = CollectionBuilder.newHashMap();
//        List<ColumnInfo> allCols = CollectionHelper.newList();
//        Map<String, TableInfo> tables = CollectionHelper.newMap();
//        try {
        anaylyzeTables(input);
        anaylyzeColumns(input);
        input.dbInfo.addAll(input.tables.values());
//        } catch (SQLException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
        L.warn("get table size:" + input.dbInfo.getTables().size());
    }

    private void anaylyzeTables(BuildModelParamHolder input) {
//        Map<String, TableInfo> tables, String dbName, Connection conn, Collection<String> allIgnorePattern, Collection<String> includingTable
        ResultSet rs = null;
        try {
            Statement st = input.conn.createStatement();
            rs = st.executeQuery(StringHelper.concat("select TABLE_NAME,TABLE_TYPE,TABLE_COMMENT,TABLE_COLLATION " +
                    "from information_schema.tables where TABLE_SCHEMA=\"", input.dbName, "\""));
            while (rs.next()) {
                TableInfo tb = new TableInfo();
                String tableName = rs.getString("TABLE_NAME");
                if (!CodeHelper.testIgnore(tableName, input.ignoreTbPattern, input.includingTable)) {
                    tb.setTableName(tableName);
                    tb.setCharset(rs.getString("TABLE_COLLATION"));
                    tb.setTableComment(rs.getString("TABLE_COMMENT"));
                    String tableType = rs.getString("TABLE_TYPE");
                    tb.setTableType(tableType.equals("BASE TABLE") ? 0 : 1);
                    input.tables.put(tableName, tb);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    private void anaylyzeColumns(
            BuildModelParamHolder input) {
        ResultSet rs = null;
        try {
            Statement st = input.conn.createStatement();
//            String data_store = dbInfo.getDbName();
            rs = st.executeQuery(StringHelper.concat("select * from information_schema.COLUMNS where TABLE_SCHEMA='", input.dbName, "'"));
            while (rs.next()) {
                String tb = rs.getString("TABLE_NAME");
                if (!CodeHelper.testIgnore(tb, input.ignoreTbPattern, input.includingTable)) {
                    String columnName = rs.getString("COLUMN_NAME");
                    if (CodeHelper.PATTERN_TB_NAME.matcher(columnName).matches()) {
                        final ColumnInfo row = new ColumnInfo();
                        row.setTable(tb);
                        row.setDb(input.dbName);
                        row.setFieldName(handleWord(columnName));
                        row.setType(ColumnDataType.getType(rs.getString("DATA_TYPE").toUpperCase()));
                        row.setExtra(rs.getString("EXTRA"));
                        row.setNullable(rs.getString("IS_NULLABLE").equals("YES"));
                        String key = rs.getString("COLUMN_KEY");
                        if (!StringHelper.isEmpty(key)) {
                            row.setPrime(key.equals("PRI"));
                            row.setUnique(key.equals("UNI"));
//                    row.set = key.equals("MUL");
                        }
                        row.setDefaultValue(rs.getString("COLUMN_DEFAULT"));
//                        row.setComment(rs.getString("COLUMN_COMMENT").trim());
                        String comment = rs.getString("COLUMN_COMMENT");
                        if (!StringHelper.isEmpty(comment)) {
                            commentAnalyzer.analyzeComment(comment.trim(), new CommentInfoHandlerImpl(row));
                        }
                        row.setCharLength(rs.getLong("CHARACTER_MAXIMUM_LENGTH"));

                        input.allCols.add(row);
                    }
//                    rs.getBlob(1).getBytes(0,)
                }
            }

            for (ColumnInfo col : input.allCols) {
                String table = col.getTable();
                TableInfo tableInfo = input.tables.get(table);
                if (tableInfo == null) {
                    tableInfo = new TableInfo();
                    tableInfo.setTableName(table);

                } else {

                }
                tableInfo.addCol(col);
                if (col.isPrime()) {
                    tableInfo.setPrKeyIndex(tableInfo.sizeOfCol() - 1);
                }
                input.tables.put(table, tableInfo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void anaylyzeColumnForEnum(ColumnInfo row) {
        String comment = row.getComment();
//        if (comment.trim().startsWith(ENUM_PREFIX)) {
        StringBuilder fieldComment = new StringBuilder(), itemComment = new StringBuilder();
        Scanner scanner = new Scanner(comment).useDelimiter("\r?\n");
//            scanner.skip(ENUM_PREFIX);
        String header = scanner.next();
        Matcher headerMatcher = CommentAnalyzer.EnumHandler.PATTERN_ENUM_HEADER.matcher(header);
        if (headerMatcher.matches()) {
            String clzName = headerMatcher.group(1);
            int fieldCommentIndex = 0;
            EnumTypeDef etf = new EnumTypeDef();
            etf.setClazzName(clzName);
            while (scanner.hasNext()) {
                String next = scanner.next();

                Matcher matcher = CommentAnalyzer.EnumHandler.PATTERN_ENUM_ITEM.matcher(next);
                if (matcher.matches()) {
                    String name = matcher.group(1);
                    String showName = matcher.group(2);
                    String index = matcher.group(3);
//                    int i = etf.sizeOfItems();
                    if (fieldCommentIndex > 0) {
                        EnumTypeDef.EnumDef item = etf.getItem(fieldCommentIndex - 1);
                        int length = itemComment.length();
                        if (length > 0) {
                            item.setComment(itemComment.toString());
                            itemComment.delete(0, length);
                        }
                    }
                    etf.addItem(index, name, showName, null);
                    ++fieldCommentIndex;
                } else {
                    if (fieldCommentIndex == 0) {
                        fieldComment.append(next).append("\n");
                    } else {
                        itemComment.append(next).append("\n");
                    }
                }
            }
            if (fieldComment.length() > 0) {
                etf.setRemark(fieldComment.toString());
            }
            if (fieldCommentIndex > 0) {
                EnumTypeDef.EnumDef item = etf.getItem(fieldCommentIndex - 1);
                int length = itemComment.length();
                if (length > 0) {
                    item.setComment(itemComment.toString());
                    itemComment.delete(0, length);
                }
            }
            etf.setCol(row);
            row.setEnumTypeDef(etf);
        }
//        }

    }

    private String handleWord(String columnName) {
        return columnName.replaceAll("[^\\w]", "_");
    }

    private static class DBInfoResultSetExtractor implements ResultSetExtractor<Boolean> {
        private final TableInfoInterface tableInfo;
        private final String defName;

        public DBInfoResultSetExtractor(TableInfoInterface tableInfo, String defName) {
            this.tableInfo = tableInfo;
            this.defName = defName;
        }

        @Override
        public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {
            int count = HelperFactory.getResultSetHeper().getColumnDef(rs, tableInfo, defName);
            return count > 0;
        }
    }

    private static class CommentInfoHandlerImpl implements CommentAnalyzer.CommentInfoHandler {
        private final ColumnInfo row;

        public CommentInfoHandlerImpl(ColumnInfo row) {
            this.row = row;
        }

        @Override
        public Object getInfo(String key, CommentAnalyzer.CommentHandler handler) {
            return null;
        }

        @Override
        public void handleResult(Object obj, CommentAnalyzer.CommentHandler handler) {
            if (handler instanceof CommentAnalyzer.DefaultHandler && obj != null && obj instanceof CharSequence) {
                String data = obj.toString();
                String originComment = row.getComment();
                if(originComment!=null) {
                    row.setComment(originComment.concat(data));
                }else {
                    row.setComment(data);
                }
            }else if(handler instanceof CommentAnalyzer.EnumHandler && obj!=null && obj instanceof CommentAnalyzer.EnumTypeDefInternal){
                CommentAnalyzer.EnumTypeDefInternal dt= (CommentAnalyzer.EnumTypeDefInternal) obj;
                dt.setCol(row);
                row.setEnumTypeDef(dt);
            }
        }
    }
}
