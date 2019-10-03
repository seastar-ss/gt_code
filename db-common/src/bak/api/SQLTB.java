package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import net.sf.jsqlparser.schema.Table;

/**
 * Created by ss on 2017/10/21.
 */
class SQLTB {
    String tnName;
    String tbAlis;
    String tbDb;
    SQLSelect tbSubQuery;
    Table tb;

    public SQLTB(String tnName, String tbAlis, String tbDb, Table tb) {
        this.tnName = tnName;
        this.tbAlis = tbAlis;
        this.tbDb = tbDb;
        this.tb = tb;
    }

    public SQLTB(String tbAlis, SQLSelect tbSubQuery) {
        this.tbAlis = tbAlis;
        this.tbSubQuery = tbSubQuery;
        this.tb = null;
    }
}
