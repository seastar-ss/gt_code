package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ConfDataTable;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.List;

/**
 * Created by ss on 2018/3/3.
 */
public abstract class _BaseDaoConfImpl {
    protected final String name;
    protected transient ModelBuilderContext builderContext;
    List<SelectMethodEnum> mainModelSelectMethod;

    public _BaseDaoConfImpl(String name) {
        this.name = name;
        init();
    }

    private final void init() {
        ConfDataTable.put(this.name,this);
    }

    public _BaseDaoConfImpl(TableInfoInterface def) {
        String table = def.getTable();
        String db = def.getDb();
        if(db==null){
            db= DbDataTable.getCurrentDb();
        }
        this.name= CodeConstants.buildConfNameFromDbAndTable(db,table);
        init();
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

    public _BaseDaoConfImpl setBuilderContext(ModelBuilderContext builderContext) {
        this.builderContext = builderContext;
        return this;
    }

    public String getName() {
        return name;
    }

    public List<SelectMethodEnum> getMainModelSelectMethod() {
        return mainModelSelectMethod;
    }

    public _BaseDaoConfImpl setMainModelSelectMethod(List<SelectMethodEnum> mainModelSelectMethod) {
        this.mainModelSelectMethod = mainModelSelectMethod;
//        this.listResult= mainModelSelectMethod.isMultipleResult();
        return this;
    }

    public abstract String getTable();
    public abstract String getDb();

//    public _BaseConfImpl setName(String name) {
//        this.name = name;
//        return this;
//    }
}
