package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.lib.code_gen.model.def_model._BaseConf;
import com.shawn.ss.lib.code_gen.model.def_model._BaseDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

public class SpecificSelectModelConf extends CommonModelDef<SpecialModelConf> implements _BaseConf, _BaseDef {

    public SpecificSelectModelConf(String name, TableInfoInterface def) {
        super(name, def);
    }
}
