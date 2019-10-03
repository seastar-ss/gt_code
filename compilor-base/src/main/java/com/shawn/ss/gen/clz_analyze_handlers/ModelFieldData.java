package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.gen.model.class_structure.ModelParamEntry;

public class ModelFieldData extends ElementData{

//    String comment;
    ModelParamEntry paramInfo;

    transient ModelClzData belongTo;


//     ModelParamData(ElRet el,boolean isField) {
//        super(el);
//        this.isField=isField;
//    }

    ModelFieldData(ElRet el, ModelParamEntry paramInfo, ModelClzData belongTo) {
        super(el);
//        this.comment = comment;
        this.paramInfo = paramInfo;
        this.belongTo = belongTo;
//        this.isField = isField;
    }

//    public String getComment() {
//        return comment;
//    }
//
//    public ModelParamData setComment(String comment) {
//        this.comment = comment;
//        return this;
//    }

    public ModelParamEntry getParamInfo() {
        return paramInfo;
    }

    public ModelFieldData setParamInfo(ModelParamEntry paramInfo) {
        this.paramInfo = paramInfo;
        return this;
    }

    public ModelClzData getBelongTo() {
        return belongTo;
    }

    public ModelFieldData setBelongTo(ModelClzData belongTo) {
        this.belongTo = belongTo;
        return this;
    }

//    public boolean isField() {
//        return isField;
//    }
//
//    public ModelParamData setField(boolean field) {
//        isField = field;
//        return this;
//    }
}
