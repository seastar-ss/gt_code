package com.shawn.ss.lib.code_gen.base.common;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;

import java.util.Map;

//import com.shawn.ss.lib.code_gen.model.def_model.dao_def.EnumTypeConf;

/**
 * Created by ss on 2018/3/4.
 */
public class EnumBuilder implements CodeBuilderInterface {

    private EnumTypeConf def;
    private final ModelBuilderContext builderContext;
    private final JCodeModel cm;
    private EnumTypeDef typeDef;
    private final String tb;
    private final FieldInfoInterface col;
    private JDefinedClass definedClass;
    private final FieldDataTypeInterface colType;

    public EnumBuilder(EnumTypeConf def) {
        this.def = def;
        builderContext = def.getBuilderContext();
        cm = builderContext.getCm();
        typeDef = def.getDef();
        tb = def.getName();
        col = typeDef.getCol();
        colType = col.getType();
    }

    @Override
    public void buildModel() {

        String cname = def.getClazzName();//builderContext.getEnumClzName(typeDef.getClazzName());
        definedClass = null;
        try {
            definedClass = cm._class(cname, EClassType.ENUM);

            definedClass.javadoc().append("表").append(tb).append(".").append(col.getAliasField()).append("相关枚举");
            //构造函数
            JFieldVar val = definedClass.field(JMod.PUBLIC + JMod.FINAL, colType.gettClass(), CodeConstants.FIELD_ENUM_VAL_FIELD);
            JFieldVar desc = definedClass.field(JMod.PUBLIC + JMod.FINAL, String.class, CodeConstants.FIELD_ENUM_DESC_FIELD);
            JMethod constructor = definedClass.constructor(JMod.NONE);
            JVar v = constructor.param(colType.gettClass(), "v");
            JVar s = constructor.param(String.class, "s");
            constructor.body().assign(val, v).assign(desc, s);
            //mapping函数
            AbstractJClass jType = CodeConstants.buildNarrowedClass(cm, Map.class, colType.gettClass(), definedClass);
//                                jType.narrow(aClass,intCls);
            JFieldVar valuesMap = definedClass.field(CodeConstants.MODE_PRIVATE_STATIC, jType, "valuesMap");
            JMethod method = definedClass.method(CodeConstants.MODE_PUBLIC_STATIC, definedClass, CodeConstants.METHOD_ENUM_FROM_VALUE);
            JVar vs = method.param(colType.gettClass(), "v");
            JBlock body = method.body();
            JBlock then = body._if(valuesMap.eq(JExpr._null()))._then();

            then.directStatement("synchronized(" + cname + ".class" + ")");
            JBlock syncBlock = new JBlock().bracesRequired(true);
            JBlock thenBlock = syncBlock._if(valuesMap.eq(JExpr._null()).cor(valuesMap.invoke("size").eq(JExpr.lit(0))))._then();
            thenBlock.assign(valuesMap, cm.ref(CollectionHelper.class).staticInvoke("newMap"));
            JVar values = thenBlock.decl(JMod.NONE, definedClass.array(), "values", definedClass.staticInvoke("values"));
            JForEach venum = thenBlock.forEach(definedClass, "venum", values);
            venum.body().add(valuesMap.invoke("put").arg(venum.var().ref("val")).arg(venum.var()));
            then.add(syncBlock);
            body._return(valuesMap.invoke("get").arg(vs));
            //枚举常量
//            Map<Integer, String> datas = CollectionHelper.newMap();

            for (EnumTypeDef.EnumDef def : typeDef.getEnumDef()) {
                if (def != null) {
                    String name = def.getName();
//                                        L.w("constant name:", name);
                    JEnumConstant anEnum = definedClass.enumConstant(name);
                    anEnum.javadoc().append(def.getShowName());
                    anEnum.arg(CodeConstants.litObject(colType.gettClass(), def.getType())).arg(JExpr.lit(def.getShowName()));
//                    datas.put(def.getType(), def.getShowName());
                }
            }
//            definedClass.method(JMod.PUBLIC,cm.ref(String.class),"toString").body()
//                    ._return(cm.ref(String.class).staticInvoke("valueOf").arg(val));

        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public EnumTypeConf getDef() {
        return def;
    }

    public JDefinedClass getDefinedClass() {
        return definedClass;
    }
}
