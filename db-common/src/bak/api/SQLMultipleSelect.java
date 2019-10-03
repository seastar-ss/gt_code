package com.shawn.ss.lib.tools.service_assemble.api.bak.api;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.UnionRelationshipType;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.factory.Config;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

public class SQLMultipleSelect extends SQLSelect<SQLMultipleSelect> {

    protected SetOperationList root;
    private List<SQLSelect> selects;

    //    protected SetOperationList current;
//    int index;
    protected SQLMultipleSelect parent;


    protected SQLMultipleSelect(Select select) {
        super(select);
//        this.select = select;
        buildInstance(select);
    }


    protected SQLMultipleSelect(List<SQLSelect> selects, List<UnionRelationshipType> relationship) {
        this();
        buildInstance(selects, relationship);
//        else {
//            this.selects=CollectionHelper.newList();
//            root=new SetOperationList();
//            parent=null;
//        }
    }

    protected SQLMultipleSelect() {
        super();
    }

    protected SQLMultipleSelect(SetOperationList body) {
        super(body);
        select = new Select();
        select.setSelectBody(body);
        buildInstance(select);
    }

    @Override
    protected void init() {
        select = new Select();
        selects = CollectionHelper.newList();
        root = new SetOperationList();
        select.setSelectBody(root);
        parent = null;
    }

    private void buildInstance(Select select) {
        SelectBody selectBody = this.select.getSelectBody();
        if (selectBody instanceof SetOperationList) {
            SetOperationList body = (SetOperationList) selectBody;
            List<SelectBody> selects = body.getSelects();
            List<SetOperation> operations = body.getOperations();
            List<SQLSelect> ss = SQLUtils.getSelectListFromBody(selects);
//            List<UnionRelationshipType> relationship=SQLUtils.getUnionTypeFromOp(operations);
            buildInstanceN(ss, operations);
        } else {
            throw SQLBuilderException.newNotImplementException();
        }
    }

    private void buildInstanceN(List<SQLSelect> selects, List<SetOperation> relationship) {
        if (selects != null && relationship != null) {
            int size = selects.size();
            int rsize = relationship.size();
            if (size > 0 && rsize == size - 1) {
//                this.selects = selects;
                for (int i = 0; i < size; ++i) {
                    SetOperation type = null;
                    if (i > 0) {
                        type = relationship.get(i - 1);
                    }
                    addSelect(selects.get(i), type);
                }
            } else {
                throw SQLBuilderException.newIllegalBuildParamException();
            }
        }
    }

    private void buildInstance(List<SQLSelect> selects, List<UnionRelationshipType> relationship) {
        if (selects != null && relationship != null) {
            int size = selects.size();
            int rsize = relationship.size();
            if (size > 0 && rsize == size - 1) {
                List<SetOperation> ress = CollectionHelper.newList(relationship.size());
                if (rsize > 0) {
                    for (UnionRelationshipType ops : relationship) {
                        ress.add(SQLUtils.getUnionExpression(ops));
                    }
                }
                buildInstanceN(selects, ress);
            }
        }
    }

    //    protected SQLMultipleSelect() {
//        super();
////        selects=CollectionHelper.newList();
////        unionRelations =CollectionHelper.newList();
//        this.select =new Select();
//        root = new SetOperationList();
////        current=root;
////        Select s = new Select();
//        SelectBody body = new PlainSelect();
////        s.setSelectBody(body);
//        addSelect(body,UnionRelationshipType.unionDistinct);
//        body=new PlainSelect();
//        addSelect(body,UnionRelationshipType.unionDistinct);
//        this.select.setSelectBody(root);
////        whereHelper = new SqlHelper(this);
//    }

    private SQLMultipleSelect addSelect(SelectBody select, SetOperation unionDistinct) {
        List<SelectBody> selects = root.getSelects();
        List<SetOperation> operations = root.getOperations();
        if (selects == null) {
            selects = CollectionHelper.newList();
        }
        if (operations == null) {
            operations = CollectionHelper.newList();
        }
        int index = selects.size();
        selects.add(select);

        this.body = select;
        if (selects.size() > 1) {
            operations.add(unionDistinct);
        }
        root.setOpsAndSelects(selects, operations);
        root.setIndex(index);
        return this;
    }

    public <T extends SQLSelect> SQLMultipleSelect addSelect(T select, SetOperation unionDistinct) {
        if (select instanceof SQLMultipleSelect) {
            SQLMultipleSelect multipleSelect = (SQLMultipleSelect) select;
            multipleSelect.parent = this;
            this.addSelect(multipleSelect.root, unionDistinct);
        } else {
            this.addSelect(select.body, unionDistinct);
        }
        this.selects.add(select);
        return this;
    }

    public final SQLMultipleSelect chooseSelect(int index) {
        root.setIndex(index);
        body = root.getCurrent();
        return this;
    }

    public <T extends SQLSelect> T getSelect(int index) {
        return (T) selects.get(index);
    }

    public int getIndex() {
        return root.getIndex();
    }

    public SQLMultipleSelect getParent() {
        return parent == null ? this : parent;
    }

    public int getSizeOfSelect() {
        List<SelectBody> selects = root.getSelects();
        return selects == null ? 0 : selects.size();
    }

    @Override
    protected HasWhereClause getWhereBase() {
//        Expression where = body.getWhere();
//        if(where==null){
//            where=new NoodExpression();
//        }
        return root.getCurrent();
    }

    @Override
    public HasOrderClause getOrderBase() {
        return root;
    }

    @Override
    public HasLimitClause getLimitBase() {
        return root;
    }

    @Override
    public HasMainTable getMainTableHandler() {
        return root.getCurrent();
    }

    @Override
    public String getSql(Config.LibType type) {
        return select.toString();
    }

    @Override
    public boolean removeItems(String item) {

        boolean ret=false;
//        List<Column> columns = select.getColumns();
//        List<Column> newColumns=CollectionHelper.newList();
//        if(columns!=null && columns.size()>0) {
//            for (Column c : columns) {
//                if(c!=null && c.getColumnName()!=null){
//                    if(c.getColumnName().equals(item)){
//                        ret=true;
//                    }else{
//                        newColumns.add(c);
//                    }
//                }
//            }
//            insert.setColumns(newColumns);
//        }

        return ret;
    }

}

