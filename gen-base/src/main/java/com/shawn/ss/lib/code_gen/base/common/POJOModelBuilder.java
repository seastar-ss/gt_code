package com.shawn.ss.lib.code_gen.base.common;

import com.helger.jcodemodel.*;
import com.shawn.ss.lib.code_gen.CodeBuilderInterface;
import com.shawn.ss.lib.code_gen.base.helper.CodeHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.model.def_model.common.CommonPOJOConf;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;

import java.util.List;

/**
 * Created by ss on 2018/10/27.
 */
public class POJOModelBuilder  implements CodeBuilderInterface {

    private final CommonPOJOConf def;
    private final ModelBuilderContext builderContext;
    private final JCodeModel cm;
    private JDefinedClass definedClass;


    public POJOModelBuilder(CommonPOJOConf def) {

        this.def = def;
        builderContext = def.getBuilderContext();
        cm = builderContext.getCm();
    }

    @Override
    public void buildModel() {
//        definedClass = null;
        try {
            definedClass = cm._class(def.getPojoClzName());
            String pojoExtendsClzName = def.getPojoExtendsClzName();
            if(pojoExtendsClzName!=null) {
                definedClass._extends(cm.ref(pojoExtendsClzName));
            }

            definedClass.constructor(JMod.PUBLIC);
            List<FieldInfoInterface> fields = def.getFields();
            for(FieldInfoInterface field:fields) {
                buildField(field);
            }
        } catch (JClassAlreadyExistsException e) {
            e.printStackTrace();
        }

    }

    private void buildField(FieldInfoInterface fieldDef) {

        AbstractJClass abstractJClass= CodeHelper.getClassFromDef(cm,fieldDef);
        String name = fieldDef.getFieldName();
        JFieldVar fieldVar = definedClass.field(JMod.PROTECTED, abstractJClass, name);
        JMethod[] methods = CodeHelper.buildGetterAndSetter(definedClass, name, abstractJClass, fieldVar);
    }
}
