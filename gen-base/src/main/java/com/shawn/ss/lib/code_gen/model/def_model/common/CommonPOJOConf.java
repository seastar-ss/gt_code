package com.shawn.ss.lib.code_gen.model.def_model.common;

import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._BaseModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.List;

/**
 * Created by ss on 2018/10/27.
 */
public class CommonPOJOConf implements _BaseModelConf {
//    public static class FieldDef{
//        String name;
//        String tClass;
//
//        public String getName() {
//            return name;
//        }
//
//        public FieldDef setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public String gettClass() {
//            return tClass;
//        }
//
//        public FieldDef settClass(String tClass) {
//            this.tClass = tClass;
//            return this;
//        }
//    }

    List<FieldInfoInterface> fields;
    String pojoClzName;
    String pojoExtendsClzName;
    protected transient ModelBuilderContext builderContext;

    public CommonPOJOConf() {
//        super(name);
        fields= CollectionHelper.newList();
    }

//    @Override
//    public String getDb() {
//        return null;
//    }

    @Override
    public List<FieldInfoInterface> getFields() {
        return fields;
    }

    public CommonPOJOConf setFields(List<FieldInfoInterface> fields) {
        this.fields = fields;
        return this;
    }

    @Override
    public int sizeOfField() {
        return fields.size();
    }

    @Override
    public boolean addField(FieldInfoInterface fieldDef) {
        return fields.add(fieldDef);
    }

    @Override
    public FieldInfoInterface getField(int index) {
        return fields.get(index);
    }

    @Override
    public String getPojoClzName() {
        return pojoClzName;
    }

    @Override
    public CommonPOJOConf setPojoClzName(String pojoClzName) {
        this.pojoClzName = pojoClzName;
        return this;
    }

    @Override
    public String getPojoExtendsClzName() {
        return pojoExtendsClzName;
    }

    @Override
    public CommonPOJOConf setPojoExtendsClzName(String pojoExtendsClzName) {
        this.pojoExtendsClzName = pojoExtendsClzName;
        return this;
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public CommonPOJOConf setBuilderContext(ModelBuilderContext builderContext) {
        this.builderContext = builderContext;
        return this;
    }
}
