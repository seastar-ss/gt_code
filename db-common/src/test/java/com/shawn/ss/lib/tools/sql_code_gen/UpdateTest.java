package com.shawn.ss.lib.tools.sql_code_gen;

import com.shawn.ss.lib.tools.sql_code_gen.api.SQLBuilder;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLSelect;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQLUpdate;
import org.junit.Test;


public class UpdateTest {

//    public static void main(String[] args){
//        new SelectTest().testSelect();
//    }

    @Test
    public void testUpate(){
        SQLUpdate update = SQLBuilder.buildUpdateSql();
        update.table("testA").itemWhere("b").itemCol("c").itemCol("d");
        System.out.println(update.getSql(null));
    }
}
