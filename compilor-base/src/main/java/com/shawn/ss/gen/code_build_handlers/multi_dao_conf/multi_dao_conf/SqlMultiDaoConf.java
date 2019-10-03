package com.shawn.ss.gen.code_build_handlers.multi_dao_conf.multi_dao_conf;

import com.shawn.ss.gen.Helpers;
//import com.shawn.ss.gen.api.interfaces.SqlMultipleConf;
//import com.shawn.ss.gen.api.interfaces.SqlMultipleRelatedResp;
//import com.shawn.ss.gen.api.interfaces.SqlMultipleResp;
import com.shawn.ss.gen.api.interfaces.mutli_resp.SqlMultipleInterfaceConf;
import com.shawn.ss.gen.api.interfaces.mutli_resp.SqlMultipleRelatedConf;
import com.shawn.ss.gen.code_build_handlers.AbstractGenConf;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelRelatedTableDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.ParamHelper;
import com.shawn.ss.lib.tools.StringHelper;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlMultiDaoConf extends AbstractGenConf {


    protected String comment;

    static final Pattern conditionPattern=Pattern.compile("([0-9A-Za-z_$]+)=([0-9A-Za-z_$]+)(;|$)");

    protected Map<String, Object> defualtParam;
    protected final ModelBuilderContext context;

    List<ModelMulDaoConf> conf;

    public SqlMultiDaoConf(Element element, Helpers helpers) throws IllegalArgumentException {
        super(element);

        conf = CollectionHelper.newList();
        if (element.getKind() == ElementKind.INTERFACE &&
                element.getEnclosingElement() != null && element.getEnclosingElement().getKind() == ElementKind.PACKAGE) {
            final PackageElement el = (PackageElement) element.getEnclosingElement();

            context = findContext(el.getQualifiedName().toString(), helpers);
            if (context == null) {
                throw new IllegalArgumentException("@SqlMultiResp标注的类，应该在@DefaultResp标注的包之下");
            }
        } else {
            throw new IllegalArgumentException("不能再此处上增加@SqlMultiResp，请添加到public interface元素上");
        }

        String docComment = helpers.elementUtils.getDocComment(element);
        this.setComment(docComment);
        SqlMultipleInterfaceConf multipleResps = element.getAnnotation(SqlMultipleInterfaceConf.class);
        SqlMultipleRelatedConf[] related = multipleResps.related();
        TypeElement ele=(TypeElement)element;
        String clzInterfaceName = ele.getQualifiedName().toString();
        String clzSimpleName=ele.getSimpleName().toString();
        String packageName= ele.getQualifiedName().toString();
        ModelMulDaoConf conf = new ModelMulDaoConf();
        String daoClazzName = multipleResps.daoClazzName();
        String dtoClazzName = multipleResps.dtoClazzName();
        if(StringHelper.isEmpty(daoClazzName)){
            daoClazzName=clzInterfaceName+"Impl";
        }
        if(StringHelper.isEmpty(dtoClazzName)){
            dtoClazzName=packageName+".Model"+clzSimpleName;
        }
        conf.setMainDb(multipleResps.dbName());
        conf.setMainField(multipleResps.fieldName());
        conf.setMainTable(multipleResps.tableName());
        conf.setMainModelSelectMethod(Arrays.asList(multipleResps.methodType()));

        conf.setServiceClassName(daoClazzName);
        conf.setDtoClazzName(dtoClazzName);
        conf.setBuildNotAbstract(false);
        conf.setImplInterface(clzInterfaceName);

        List<ModelRelatedTableDef> relatedTbs = CollectionHelper.newList();
        for (SqlMultipleRelatedConf multipleResp : related) {
            String relationship = multipleResp.relationship();
            Map<String, String> map = ParamHelper.extractAllPattern(conditionPattern, relationship, 1, 2);
            if(map==null || map.size()==0){
                throw new IllegalArgumentException("multi dao condition illegal ,expected at least one condition,current is "+relationship);
            }
        }

//            SqlMultipleRelatedResp[] sqlMultipleRelatedResps = multipleResp.relatedResp();
//            List<ModelRelatedTableDef> relatedTbs = CollectionHelper.newList();
//            for (SqlMultipleRelatedResp item : sqlMultipleRelatedResps) {
//                relatedTbs.add(new ModelRelatedTableDef(item.dbName(),item.tableName(), item.condition(), item.relatedMainTableField(), item.isIdInThisTable(), !item.isList(), item.fieldName()));
//            }
        conf.setRelatedTables(relatedTbs);
        conf.setBuilderContext(context);
        this.conf.add(conf);
//        }
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
