package com.shawn.ss.lib.tools.sql_code_gen;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ss on 2017/10/12.
 */
public class SqlGenApiTest {

    static final Logger L = LoggerFactory.getLogger(SqlGenApiTest.class.getSimpleName());

    @Test
    public void testSqlSelectGen() {

//        final SQLSelect where = SQL.("dba", "tablea", "ta")
//                .items("id").funcItems("a", "count")
////                .where(LogicalOpType.notIn,"testNotIn","testNotIn",FieldDataTypeInterface.stringData)
//                .where(LogicalOpType.notLike, "testNotNotLike", "testNotLike", ColumnDataType.stringData);
//        where.setTable("tableTest");
//        //.getSql(null);
//        String sql =where.getSql(null);
//                L.info(sql);
//        sql = SQL.buildSelectSql("dba", "tablea", "ta").items("id").funcItems("total","sum")
//                .items(new ColumnValueWithAlisColumnItem("ta", "totalScore", "aScore"), new ColumnValueWithAlisColumnItem("tb", "totalScore", "bScore"))
//                .items("gs", "tc").joinTableWithCondition(false, "dbb", "tableb", "tb", new ColumnValueParamItem("ta", "sid", "tb", "id", null))
//                .joinTableWithCondition(true, "adb", "tablec", "tc",
//                        new ColumnValueParamItem("ta", "cid", "tc", "id", null),
//                        new ColumnValueConstantItem("tc", "gs", "type", null),
//                        new ColumnValueParamItem("tc", "gs", null,"'type'", null)
//                )
//                .where("gs", FieldDataTypeInterface.stringData).where("tb", "totalScore", "tbTScore", FieldDataTypeInterface.intData)
//                .where(LogicalRelationshipType.or, LogicalOpType.in, new JDBCParamParamItem("tc", "gs", "gsValue", FieldDataTypeInterface.stringData), new JDBCParamParamItem("tc", "gs2", "gsValue", FieldDataTypeInterface.stringData))
//                .group("tb", "bScore").where()
//                .group("api").havingCondition(LogicalRelationshipType.and, LogicalOpType.eq, "sum(api)", "ta", "s150", FieldDataTypeInterface.constValue)
//                .getSql(Config.LibType.springJdbcTemplate);
//        L.info(sql);
//        SQLSelect sqlSelect = SQL.parseSql("select id, rule_code, rule_name, rule_type, is_operation, experience_operation_formula, sunland_amount_operation_formula," +
//                " experience,  sunland_amount, max_experience, max_sunland_amount, series_days, experience_remark, sunland_amount_remark, create_time,  update_time," +
//                " creator, operator, delete_flag, is_only_first from t_score_system_rule where delete_flag = 0 and rule_code = ? ",
//                Config.LibType.springJdbcTemplate);
//        L.info(String.valueOf(sqlSelect.getAllTable()));
//        sql = SQL.buildDeleteSql("test").where("gs", FieldDataTypeInterface.floatData)
//                .where(LogicalRelationshipType.or, LogicalOpType.like, null, "item", "item", FieldDataTypeInterface.stringData)
//                .order(false, "a", "b").setLimit(5).getSql(Config.LibType.springJdbcTemplate);
//        L.info(sql);
//
//        sql = SQL.buildInsertSql("whatUp").items("what", FieldDataTypeInterface.floatData).constantItems("hell", 18)
//                .funcItems("time", "now")
//                .getSql(Config.LibType.springJdbcTemplate);
//        L.info(sql);
//
//        sql = SQL.buildUpdateSql("hh").items("sb", "wd", "tt").where("name", FieldDataTypeInterface.floatData).where("ok", "what", FieldDataTypeInterface.stringData)
//                .order(true, "a", "b").setLimit(2, 5).getSql(Config.LibType.springJdbcTemplate);
//        L.info(sql);

//        sql=SQL.buildComplexSelectSql(
//                CollectionHelper.<SQLSelect>newList(SQL.buildSelectSql("dba", "tablea", "ta")
//                                .setCalFoundRows().items("id").funcItems("total","sum")
//                .items(new ColumnValueWithAlisColumnItem("ta", "totalScore", "aScore"),
//                        new ColumnValueWithAlisColumnItem("tb", "totalScore", "bScore"))
//                .items("gs", "tc")
//                                .joinTableWithCondition(false, null, "tableb", "tb",
//                                        new ColumnValueParamItem("ta", "sid", "tb", "id", null))
//                .joinTableWithCondition(true, null, "tablec", "tc",
//                        new ColumnValueParamItem("ta", "cid", "tc", "id", null),
//                        new ColumnValueParamItem("tc", "gs", null, "'0'", null))
//                .where("gs", FieldDataTypeInterface.stringData).where("tb", "totalScore", "tbTScore", FieldDataTypeInterface.intData)
//                .where(LogicalRelationshipType.or, LogicalOpType.in, new JDBCParamParamItem("tc", "gs", "gsValue", FieldDataTypeInterface.stringData))
//                .group("tb", "bScore")
//                .group("api")
//                                .havingCondition(LogicalRelationshipType.and, LogicalOpType.eq, "sum(api)", "ta", "s150", FieldDataTypeInterface.constValue),
//                SQL.buildComplexSelectSql("table1","table2").chooseSelect(1).items("a","b","c").chooseSelect(0).items("b","c","d").where("a","f",FieldDataTypeInterface.stringData)
//        ), UnionRelationshipType.unionAll).getSql(Config.LibType.springJdbcTemplate);
//        L.info(sql);
        //SQL.buildInsertSql().parseSql("",null);
    }


//    @Test
//    public void testFunc() throws JSQLParserException {
//        String sql = SQL.buildSelectSql("dba", "tablea", "ta")
//                .items("id").funcItems("a","sum")
//                .rawItem("if(a=:b,1,0)*2000 as score")
//                .rawWhere("test>239+tes")
//                .rawWhere("test>235+if(tes,3,4)")
//                .rawWhere("t>239+tes")
//                .rawWhere("te>239+tes")
//                .rawWhere("test>239-wdi")
//                .getSql(null);
//        L.info(sql);
//    }

//    @Test
//    public void getParse() throws JSQLParserException {
//        String sql = SQL.buildSelectSql("dba", "tablea", "ta")
//                .items("id").funcItems("a","count")
//                .rawItem("if(a=:b,1,0)*2000 as score")
//                .rawWhere("test>239+tes")
//                .rawWhere("test>235+if(tes,3,4)")
//                .rawWhere("t>239+tes")
//                .rawWhere("te>239+tes")
//                .rawWhere("test>239-wdi")
//                .rawHavingCondition("test.tt>11920-test.qq")
//                .getSql(null);
//        L.info(sql);
//    }
//
//    @Test
//    public void simpleTest() throws JSQLParserException {
//        String sql = SQL.buildSelectSql("dba", "tablea", "ta")
//                .items(new ColumnItem() {
//                    @Override
//                    public Expression asExpression(HasMainTable sql) {
//                        return new Column("1=1");
//                    }
//                })
//                .getSql(null);
//        L.info(sql);
//    }
//
//    @Test
//    public void simpleTestUpdate() throws JSQLParserException {
//        String sql = SQL.buildUpdateSql("dba", "tablea", null)
//                .rawItem("b=count(a)-b")
//                .getSql(null);
//        L.info(sql);
//    }

//    @Test
//    public void getEnumByName(){
//        L.info(CommonOpType.getEnumByName("plus").toString());
//        try {
//            L.info(CommonOpType.getEnumByName("now")==null?"null":"ok?");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//    }

}
