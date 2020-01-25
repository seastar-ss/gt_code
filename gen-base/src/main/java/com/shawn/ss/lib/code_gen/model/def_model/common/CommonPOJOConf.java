package com.shawn.ss.lib.code_gen.model.def_model.common;

import com.helger.jcodemodel.AbstractJType;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._BaseModelClassNameConf;
import com.shawn.ss.lib.code_gen.model.def_model._BaseModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/10/27.
 */
public class CommonPOJOConf<T extends CommonPOJOConf> implements _BaseModelConf<T>, _BaseModelClassNameConf<T> {


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
    Map<String, Integer> fieldIndex;
    String pojoClzName;
    String pojoExtendsClzName;
    protected String comment;
    protected final String name;

    protected transient final ModelBuilderContext builderContext;

    private AbstractJType definedClz;

    public CommonPOJOConf(String name, ModelBuilderContext builderContext) {
        this.builderContext = builderContext;
        this.name = name;
//        super(name);
        fields = CollectionHelper.newList();
        fieldIndex = CollectionHelper.newMap();
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
        for (int i = 0, n = fields.size(); i < n; ++i) {
            fieldIndex.put(fields.get(i).getFieldName(), i);
        }
        return this;
    }

    @Override
    public int sizeOfField() {
        return fields.size();
    }

    @Override
    public boolean addField(FieldInfoInterface fieldDef) {
        boolean add = fields.add(fieldDef);
        if (add) {
            fieldIndex.put(fieldDef.getFieldName(), fields.size() - 1);
        }
        return add;
    }

    @Override
    public FieldInfoInterface getField(int index) {
        return fields.get(index);
    }

    @Override
    public Set<String> ignoreField() {
        return Collections.emptySet();
    }


    @Override
    public FieldInfoInterface getField(String key) {
        if (fieldIndex.containsKey(key)) {
            Integer index = fieldIndex.get(key);
            if (index > 0 && index < fields.size())
                return fields.get(index);
        }
        return null;
    }

    @Override
    public AbstractJType getDeclaredModel() {
        return definedClz;
    }

    @Override
    public T setDeclaredModel(AbstractJType tclazz) {
        this.definedClz = tclazz;
        return (T) this;
    }

    @Override
    public String getPojoClzName() {
        return pojoClzName;
    }

    @Override
    public T setPojoClzName(String pojoClzName) {
        this.pojoClzName = pojoClzName;
        return (T) this;
    }

    @Override
    public String getPojoExtendsClzName() {
        return pojoExtendsClzName;
    }

    @Override
    public T setPojoExtendsClzName(String pojoExtendsClzName) {
        this.pojoExtendsClzName = pojoExtendsClzName;
        return (T) this;
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public String getComment() {
        return comment;
    }

    public T setComment(String comment) {
        this.comment = comment;
        return (T) this;
    }

    public String getName() {
        return name;
    }

//    public CommonPOJOConf setBuilderContext(ModelBuilderContext builderContext) {
//        this.builderContext = builderContext;
//        return this;
//    }


}
