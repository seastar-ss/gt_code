package com.shawn.ss.lib.tools.sql_code_gen;

import com.shawn.ss.lib.tools.sql_code_gen.api.SQLBuilder;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import org.junit.Test;


public class SelectTest {

//    public static void main(String[] args){
//        new SelectTest().testSelect();
//    }

    @Test
    public void testSelect(){
        SQLSelect sqlSelect=SQLBuilder.buildSelectSql();
        sqlSelect.table("testA").itemWhere("b").itemCol("c").itemCol("d");
        System.out.println(sqlSelect.getSql(null));
    }
}
