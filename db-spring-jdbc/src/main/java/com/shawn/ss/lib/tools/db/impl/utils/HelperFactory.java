package com.shawn.ss.lib.tools.db.impl.utils;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.SimpleDbInterface;
import com.shawn.ss.lib.tools.db.api.utils.ResultSetHelper;
import com.shawn.ss.lib.tools.db.api.utils.TableCreateHelper;

public class HelperFactory {
    static ResultSetHelper rsHelper=new ResultSetHelperImpl();
//    static TableCreateHelper tbHelper=new TableCreateHelperImpl();

    public static ResultSetHelper getResultSetHeper(){
        return rsHelper;
    }

    public static TableCreateHelper getTbHelper(SimpleDbInterface dbInterface) {
        return new TableCreateHelperImpl(dbInterface);
    }
}
