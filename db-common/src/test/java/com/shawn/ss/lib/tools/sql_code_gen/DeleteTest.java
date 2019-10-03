package com.shawn.ss.lib.tools.sql_code_gen;

import com.shawn.ss.lib.tools.sql_code_gen.api.SQLBuilder;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLDelete;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import org.junit.Test;


public class DeleteTest {

//    public static void main(String[] args){
//        new SelectTest().testSelect();
//    }

    @Test
    public void testSelect(){
        SQLDelete sqlSelect=SQLBuilder.buildDeleteSql();
        sqlSelect.table("testA").itemWhere("b").itemCol("c").itemCol("d");
        System.out.println(sqlSelect.getSql(null));
    }
}
