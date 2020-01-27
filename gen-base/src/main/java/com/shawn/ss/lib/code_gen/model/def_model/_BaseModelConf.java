package com.shawn.ss.lib.code_gen.model.def_model;

import com.helger.jcodemodel.AbstractJType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/2/13.
 */
public interface _BaseModelConf<T extends _BaseModelConf> extends _BaseModelClassNameConf<T>, _BaseContextConf {
    List<FieldInfoInterface> getFields();

    int sizeOfField();

    boolean addField(FieldInfoInterface fieldDef);

    FieldInfoInterface getField(int index);

    FieldInfoInterface getField(String key);

    Set<String> ignoreField();

    String getComment();

    Map<String,FieldInfoInterface> getStaticConstFields();

    boolean addStaticField(FieldInfoInterface fieldDef);

    FieldInfoInterface getStaticField(String key);

    /*
     * data access interface
     *
     */
    AbstractJType getDeclaredModel();

    T setDeclaredModel(AbstractJType tclazz);
}
