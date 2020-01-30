package com.shawn.ss.lib.code_gen.model.def_model.dao_def;

import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.data_store.ConfDataTable;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.model.def_model.common.CommonPOJOConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;

import java.util.List;

/**
 * Created by ss on 2018/3/3.
 */
public abstract class _BaseDaoConfImpl<T extends _BaseDaoConfImpl> extends CommonPOJOConf {
    //    protected transient final ModelBuilderContext builderContext;
    List<SelectMethodEnum> mainModelSelectMethod;

    public _BaseDaoConfImpl(String name, ModelBuilderContext builderContext) {
        super(name,builderContext);

//        this.builderContext = builderContext;

    }



    public _BaseDaoConfImpl(TableInfoInterface def, ModelBuilderContext builderContext) {
        super(CodeConstants.buildConfNameFromDbAndTable(def.getDb(),def.getTable()),builderContext);
//        this.builderContext = builderContext;
        String table = def.getTable();
        String db = def.getDb();
        if(db==null){
            db= DbDataTable.getCurrentDb();
        }

        init();
    }

    public ModelBuilderContext getBuilderContext() {
        return builderContext;
    }

//    public _BaseDaoConfImpl setBuilderContext(ModelBuilderContext builderContext) {
//        this.builderContext = builderContext;
//        return this;
//    }

    public List<SelectMethodEnum> getMainModelSelectMethod() {
        return mainModelSelectMethod;
    }

    public T setMainModelSelectMethod(List<SelectMethodEnum> mainModelSelectMethod) {
        this.mainModelSelectMethod = mainModelSelectMethod;
//        this.listResult= mainModelSelectMethod.isMultipleResult();
        return (T)this;
    }

    public abstract String getTable();
    public abstract String getDb();

//    public _BaseConfImpl setName(String name) {
//        this.name = name;
//        return this;
//    }
}
