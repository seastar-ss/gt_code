package com.shawn.ss.gen.clz_analyze_handlers;

import com.shawn.ss.gen.model.class_structure.ModelParamEntry;

public class ModelParamData extends ElementData{

//    String comment;
    ModelParamEntry paramInfo;

    transient ModelMethodData belongTo;


//     ModelParamData(ElRet el,boolean isField) {
//        super(el);
//        this.isField=isField;
//    }

    ModelParamData(ElRet el, ModelParamEntry paramInfo, ModelMethodData belongTo) {
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

    public ModelParamData setParamInfo(ModelParamEntry paramInfo) {
        this.paramInfo = paramInfo;
        return this;
    }

    public ModelMethodData getBelongTo() {
        return belongTo;
    }

    public ModelParamData setBelongTo(ModelMethodData belongTo) {
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
