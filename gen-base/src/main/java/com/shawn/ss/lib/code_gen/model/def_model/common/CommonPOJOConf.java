package com.shawn.ss.lib.code_gen.model.def_model.common;

import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.JDefinedClass;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model._base.AbstractConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseConstantDef;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseModelClassNameConf;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/10/27.
 */
public class CommonPOJOConf extends AbstractConf implements _BaseModelConf, _BaseModelClassNameConf {


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

    protected final List<FieldInfoInterface> fields;
    Map<String, FieldInfoInterface> staticFields;
    protected final Map<String, Integer> fieldIndex;
    protected String pojoClzName;
    protected String pojoExtendsClzName;
    protected String comment;

    protected  final Set<String> ignoreField;
//    protected final String name;

//    protected transient final ModelBuilderContext builderContext;

    private JDefinedClass definedClz;

    public CommonPOJOConf(String name, ModelBuilderContext builderContext) {
        super(name,builderContext);
//        super(name);
        fields = CollectionHelper.newList();
        fieldIndex = CollectionHelper.newMap();
        staticFields = CollectionHelper.newMap();
        ignoreField=CollectionHelper.newSet();
    }

//    @Override
//    public String getDb() {
//        return null;
//    }

    @Override
    public List<FieldInfoInterface> getFields() {
        return fields;
    }

//    public void setFields(List<FieldInfoInterface> fields) {
////        this.fields = fields;
//        for (int i = 0, n = fields.size(); i < n; ++i) {
//            fieldIndex.put(fields.get(i).getFieldName(), i);
//        }
////        return this;
//    }

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
    public Set<String> getIgnoreField() {
        return ignoreField;
    }

    public boolean addIgnoreField(String field){
        if(fieldIndex.containsKey(field)){
            ignoreField.add(field);
            return true;
        }
        return false;
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
    public JDefinedClass getDeclaredModel() {
        return definedClz;
    }

    @Override
    public void setDeclaredModel(JDefinedClass tclazz) {
        this.definedClz = tclazz;

    }

    @Override
    public String getPojoClzName() {
        return pojoClzName;
    }

//    @Override
    public void setPojoClzName(String pojoClzName) {
        this.pojoClzName = pojoClzName;

    }

    @Override
    public String getPojoExtendsClzName() {
        return pojoExtendsClzName;
    }

//    @Override
    public void setPojoExtendsClzName(String pojoExtendsClzName) {
        this.pojoExtendsClzName = pojoExtendsClzName;

    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public Map<String, FieldInfoInterface> getStaticConstFields() {
        return Collections.<String, FieldInfoInterface>unmodifiableMap(staticFields);
    }

    @Override
    public boolean addStaticField(FieldInfoInterface fieldDef) {
        return staticFields.put(fieldDef.getFieldName(), fieldDef) != null;
    }

    @Override
    public FieldInfoInterface getStaticField(String key) {
        return staticFields.get(key);
    }

    @Override
    public FieldInfoInterface getPriField() {

        return null;
    }

    public void setComment(String comment) {
        this.comment = comment;

    }

    public String getName() {
        return name;
    }

//    @Override
//    public _BaseConstantConf getConstant() {
//        return null;
//    }

//    public CommonPOJOConf setBuilderContext(ModelBuilderContext builderContext) {
//        this.builderContext = builderContext;
//        return this;
//    }


}
