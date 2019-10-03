package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/10/5.
 */
public class BaseMultipleDaoAssembler extends AbstractMultipleDaoAssembler implements DaoAssembler,SQLLoopStatus {

//    final boolean isMultiple;

    public BaseMultipleDaoAssembler() {
        super();
    }


}
