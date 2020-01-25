package com.shawn.ss.gen.code_build_handlers.multi_dao_conf.multi_dao_conf;

import com.shawn.ss.gen.Helpers;
import com.shawn.ss.gen.api.interfaces.mutli_resp.SqlMultipleInterfaceConf;
import com.shawn.ss.gen.api.interfaces.mutli_resp.SqlMultipleRelatedConf;
import com.shawn.ss.gen.code_build_handlers.AbstractGenConf;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelMulDaoDaoConf;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.ModelRelatedTableDef;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.shawn.ss.gen.api.interfaces.SqlMultipleConf;
//import com.shawn.ss.gen.api.interfaces.SqlMultipleRelatedResp;
//import com.shawn.ss.gen.api.interfaces.SqlMultipleResp;

/**
 * Created by ss on 2018/6/17.
 */
public class SqlMultiDaoConf extends AbstractGenConf {


    protected String comment;

    static final Pattern conditionPattern = Pattern.compile("([0-9A-Za-z_$\\.]+)=([0-9A-Za-z_$\\.]+)(;|$)");
    static final Pattern itemPattern = Pattern.compile("([0-9A-Za-z_$]+)");

    protected Map<String, Object> defualtParam;
    protected ModelBuilderContext context;

    List<ModelMulDaoDaoConf> conf;

    public SqlMultiDaoConf(Element element, Helpers helpers) throws IllegalArgumentException {
        super(element);

        this.conf = CollectionHelper.newList();
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
        TypeElement ele = (TypeElement) element;
        String clzInterfaceName = ele.getQualifiedName().toString();
        String clzSimpleName = ele.getSimpleName().toString();
        String packageName = ele.getQualifiedName().toString();

        String daoClazzName = multipleResps.daoClazzName();
        String dtoClazzName = multipleResps.dtoClazzName();
        if (StringHelper.isEmpty(daoClazzName)) {
            daoClazzName = clzInterfaceName + "Impl";
        }
        if (StringHelper.isEmpty(dtoClazzName)) {
            dtoClazzName = packageName + ".Model" + clzSimpleName;
        }
        ModelMulDaoDaoConf conf = new ModelMulDaoDaoConf(daoClazzName,context);
        String mainDb = multipleResps.dbName();
        String mainTable = multipleResps.tableName();
        conf.setMainTableDef(
                new ModelRelatedTableDef()
                        .setName(CodeConstants.buildConfNameFromDbAndTable(mainDb, mainTable))
                        .setFieldName(multipleResps.fieldName())
//                .set
        );
//        conf.setMainField(multipleResps.fieldName());
//        conf.setMainTable(multipleResps.tableName());
        conf.setMainModelSelectMethod(Arrays.asList(multipleResps.methodType()));

        conf.setServiceClassName(daoClazzName);
        conf.setPojoClzName(dtoClazzName);
        conf.setBuildNotAbstract(false);
        conf.setImplInterface(clzInterfaceName);

        List<ModelRelatedTableDef> relatedTbs = CollectionHelper.newList();
        for (SqlMultipleRelatedConf multipleResp : related) {
            String relationship = multipleResp.relationship();
            Map<String, String> map = CollectionHelper.newMap(); //= ParamHelper.extractAllPattern(conditionPattern, relationship, 1, 2);
            if (StringHelper.isEmpty(relationship)) {
                throw new IllegalArgumentException("multi dao condition illegal ,expected at least one condition,current is " + relationship);
            }
            String[] extraCondition = multipleResp.extraCondition();
            String dbName = multipleResp.dbName();
            String tableName = multipleResp.tableName();
            String[] result = calRelation(relationship, mainDb, mainTable, dbName, tableName);
            for (String re : extraCondition) {
                String[] calRelation = calRelation(re, mainDb, mainTable, dbName, tableName);
                map.put(calRelation[0], calRelation[1]);
            }
            relatedTbs.add(
                    new ModelRelatedTableDef(
                            CodeConstants.buildConfNameFromDbAndTable(dbName, tableName),
                            result[1], result[0], !multipleResp.isList()
                    )
                            .setAdditionalCondition(map)
                            .setAdditionalWhere(multipleResp.additionalWhere())
            );

        }

//            SqlMultipleRelatedResp[] sqlMultipleRelatedResps = multipleResp.relatedResp();
//            List<ModelRelatedTableDef> relatedTbs = CollectionHelper.newList();
//            for (SqlMultipleRelatedResp item : sqlMultipleRelatedResps) {
//                relatedTbs.add(new ModelRelatedTableDef(item.dbName(),item.tableName(), item.condition(), item.relatedMainTableField(), item.isIdInThisTable(), !item.isList(), item.fieldName()));
//            }
        conf.setRelatedTables(relatedTbs);
//        conf.setBuilderContext(context);
        this.conf.add(conf);
//        }
//        dataSourceId=annotation.dataSourceId();

    }

    private String[] calRelation(String relationship, String mainDb, String mainTable, String dbName, String tableName) {
        Matcher matcher = conditionPattern.matcher(relationship);

        if(matcher.matches()){
            String[] re=new String[2];
            String p1=matcher.group(1);
            String p2=matcher.group(2);
            String[] item1 = p1.split("\\.");
            String[] item2 = p2.split("\\.");
            getItem(item1,re,mainDb,mainTable,dbName,tableName);
            getItem(item2,re,mainDb,mainTable,dbName,tableName);
            if(re[0]!=null && re[1]!=null){
                return re;
            }else {
                throw new IllegalArgumentException("condition illegal, not match maintable and table ");
            }
        }
        throw new IllegalArgumentException("condition illegal, need to be as 'db1.table1.field1=db2.table2.field2' or 'table1.field1=table2.fields' ");
    }

    private void getItem(String[] item, String[] re, String mainDb, String mainTable, String dbName, String tableName) {
        if(item.length==2){
            if(item[0].equalsIgnoreCase(mainTable)){
                re[0]=item[1];
            }else if(item[0].equalsIgnoreCase(tableName)){
                re[1]=item[1];
            }
        }else if(item.length==3){
            if(item[0].equalsIgnoreCase(mainDb) && item[1].equalsIgnoreCase(mainTable)){
                re[0]=item[2];
            }else if(item[0].equalsIgnoreCase(dbName) && item[1].equalsIgnoreCase(tableName)){
                re[1]=item[2];
            }
        }
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

    public List<ModelMulDaoDaoConf> getConfModel() {

        return conf;
    }
}
