package com.shawn.ss.gen.code_build_handlers.mul_dao_conf;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.gen.api.interfaces.*;
import com.shawn.ss.gen.code_build_handlers.AbstractGenConf;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelRelatedTableDef;
import com.shawn.ss.lib.tools.CollectionHelper;

import javax.lang.model.element.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlMultiDaoConf extends AbstractGenConf {


    protected String comment;

    protected Map<String, Object> defualtParam;
    protected final ModelBuilderContext context;
    static final Pattern conditionPattern=
            Pattern.compile("([A-Za-z][0-9A-Za-z_]+\\.[A-Za-z][0-9A-Za-z_$]+)=([A-Za-z][0-9A-Za-z_]+\\.[A-Za-z][0-9A-Za-z_$]+)(;|$)");

    List<ModelMulDaoConf> conf;

    public SqlMultiDaoConf(Element element, Helpers helpers) throws IllegalArgumentException {
        super(element);

        conf=CollectionHelper.newList();
        if (element.getKind() == ElementKind.PACKAGE) {
            final PackageElement el = (PackageElement) element;

            context = findContext(el.getQualifiedName().toString(), helpers);
            if (context == null) {
                throw new IllegalArgumentException("@SqlMultiResp标注的类，应该在@DefaultResp标注的包之下");
            }
        } else {
            throw new IllegalArgumentException("不能再此处上增加@SqlMultiResp，请添加到package元素上");
        }

        String docComment = helpers.elementUtils.getDocComment(element);
        this.setComment(docComment);
        SqlMultipleResp multipleResps = element.getAnnotation(SqlMultipleResp.class);
        SqlMultipleConf[] items = multipleResps.confs();
        for (SqlMultipleConf multipleResp : items) {
            ModelMulDaoConf conf = new ModelMulDaoConf();
            conf.setMainDb(multipleResp.dbName());
            conf.setMainField(multipleResp.fieldName());
            conf.setMainTable(multipleResp.tableName());
            final SelectMethodEnum[] selectMethodEnums = multipleResp.methodTypes();
            conf.setMainModelSelectMethod(Arrays.<SelectMethodEnum>asList(selectMethodEnums));
            conf.setServiceClassName(multipleResp.daoClazzName());
            conf.setDtoClazzName(multipleResp.dtoClazzName());
            SqlMultipleRelatedResp[] sqlMultipleRelatedResps = multipleResp.relatedResp();
            List<ModelRelatedTableDef> relatedTbs = CollectionHelper.newList();
            for (SqlMultipleRelatedResp item : sqlMultipleRelatedResps) {
                relatedTbs.add(new ModelRelatedTableDef(item.dbName(),item.tableName(), item.condition(), item.relatedMainTableField(), item.isIdInThisTable(), !item.isList(), item.fieldName()));
            }
            conf.setRelatedTables(relatedTbs);
            conf.setBuilderContext(context);
            this.conf.add(conf);
        }
//        dataSourceId=annotation.dataSourceId();

    }

    public ModelBuilderContext getContext() {
        return context;
    }

    public String getComment() {
        return comment;
    }

    public SqlMultiDaoConf setComment(String comment) {
        this.comment = comment;
        return this;
    }


    public List<ModelMulDaoConf> getConfModel() {

        return conf;
    }
}
