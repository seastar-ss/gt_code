package com.shawn.ss.lib.tools.sql_code_gen.api;

import com.shawn.ss.lib.tools.sql_code_gen.api.impl.*;

public class SQLBuilder {

    public static SQLSelect buildSelectSql(){
        return new SQLSelectImpl();
    }

    public static SQLInsert buildInsertSql(){
        return new SQLInsertImpl();
    }

    public static SQLUpdate buildUpdateSql(){
        return new SQLUpdateImpl();
    }

    public static SQLDelete buildDeleteSql(){
        return new SQLDeleteImpl();
    }



    public static <TT extends SQL> SQL<TT> parseSql(String sql){
        return SQLImpl.<TT>parse(sql);
    }
}
