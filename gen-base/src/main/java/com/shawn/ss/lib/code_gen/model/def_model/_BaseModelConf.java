package com.shawn.ss.lib.code_gen.model.def_model;

import com.shawn.ss.lib.code_gen.model.def_model.common.CommonPOJOConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.List;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseModelConf<T extends _BaseModelConf> {
    List<FieldInfoInterface> getFields();

    int sizeOfField();

    boolean addField(FieldInfoInterface fieldDef);

    FieldInfoInterface getField(int index);

    String getPojoClzName();

    T setPojoClzName(String pojoClzName);

    String getPojoExtendsClzName();

    T setPojoExtendsClzName(String pojoExtendsClzName);
}
