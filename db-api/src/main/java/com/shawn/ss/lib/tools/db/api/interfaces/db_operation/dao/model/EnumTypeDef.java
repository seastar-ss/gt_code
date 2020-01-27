package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.List;

/**
 * Created by ss on 2016/4/20.
 */
public class EnumTypeDef {
//    {
//        "remark":"订单状态",
//            "enum":[{"type":"0","name":"created","showName":"未发布"},{"type":"1","name":"ordered","showName":"已发布"},{"type":"2","name":"dealMaked","showName":"已确认"},{"type":"3","name":"dispatched","showName":"已交付"},{"type":"1","name":"paid","showName":"已结算"},{"type":"1","name":"failed","showName":"已失败"}]
//    }
    String remark;
    String clazzName;
//    FieldDataTypeInterface originalType;
    FieldInfoInterface col;
    List<EnumDef> enumDef;

    public EnumTypeDef() {
        enumDef= CollectionHelper.newList();
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<EnumDef> getEnumDef() {
        return enumDef;
    }

    public void setEnumDef(List<EnumDef> enumDef) {
        this.enumDef = enumDef;
    }

    public int sizeOfItems() {
        return enumDef.size();
    }

    public boolean addItem(String type, String name, String showName, String comment) {
        return this.enumDef.add(new EnumDef(type,name,showName,comment));
    }

    public boolean addItem(EnumDef enumDef) {
        return this.enumDef.add(enumDef);
    }

    public EnumDef getItem(int index) {
        return enumDef.get(index);
    }

    public String getClazzName() {
        return clazzName;
    }

    public EnumTypeDef setClazzName(String clazzName) {
        this.clazzName = clazzName;
        return this;
    }

    //    public FieldDataTypeInterface getOriginalType() {
//        return originalType;
//    }
//
//    public EnumTypeDef setOriginalType(FieldDataTypeInterface originalType) {
//        this.originalType = originalType;
//        return this;
//    }


    public FieldInfoInterface getCol() {
        return col;
    }

    public EnumTypeDef setCol(FieldInfoInterface col) {
        this.col = col;
        return this;
    }

    public static class EnumDef{
        String type;
        String name;
        String showName;
        String comment;

        public EnumDef() {
        }

        public EnumDef(String type, String name, String showName, String comment) {
            this.type = type;
            this.name = name;
            this.showName = showName;
            this.comment = comment;
        }

        public String getType() {
            return type;
        }

        public EnumDef setType(String type) {
            this.type = type;
            return this;
        }

        public String getName() {
            return name;
        }

        public EnumDef setName(String name) {
            this.name = name;
            return this;
        }

        public String getShowName() {
            return showName;
        }

        public EnumDef setShowName(String showName) {
            this.showName = showName;
            return this;
        }

        public String getComment() {
            return comment;
        }

        public EnumDef setComment(String comment) {
            this.comment = comment;
            return this;
        }
    }
}
