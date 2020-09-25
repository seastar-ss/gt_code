package com.shawn.ss.lib.code_gen.base.helper;

import com.helger.jcodemodel.*;
import com.shawn.ss.gen.api.conf.SelectMethod;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.model.def_model.interfaces._BaseModelConf;
import com.shawn.ss.lib.tools.CodeStyleTransformHelper;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.TypeConstantHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.DbInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.FieldInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.FieldDataTypeInterface;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

import java.util.*;
import java.util.regex.Pattern;

public class CodeConstants {


    final static Pattern PATTERN_NUMBER_START = Pattern.compile("^\\d+.*");

    public static final int MODE_PUBLIC_STATIC_FINAL = JMod.PUBLIC + JMod.STATIC + JMod.FINAL;
    public static final int MODE_PUBLIC_STATIC = JMod.PUBLIC + JMod.STATIC;
    public static final int MODE_PRIVATE_STATIC = JMod.PRIVATE + JMod.STATIC;
    public static final int MODE_PRIVATE_STATIC_VOLATILE = JMod.PRIVATE + JMod.STATIC + JMod.VOLATILE;

    public static final String FIELD_CONST_NAME_PREFIX = "FI_";
    public static final String FIELD_TABLE_NAME = "DTO_TABLE_NAME";
    public static final String FIELD_DB_NAME = "DTO_DB_NAME";
    public static final String FIELD_MODEL_TYPE = "DTO_MODEL_TYPE";
    public static final String FIELD_MODEL_FIELD_PREFIX = "dtf";
    public static final String FIELD_MODEL_RELATED_SQL = "DTO_MODEL_SQL";
    public static final String FIELD_DAO_RELATED_SQL_PREFIX = "DAO_SQL_";
    public static final String FIELD_PRIMARY_KEY_NAME = "PRIMARY_KEY_NAME";
    public static final String FIELD_RESULT_SET_MAPPER = "RESULT_SET_MAPPER";
    public static final String FIELD_RESULT_SET_MAPPER_INSTANCE_APPENDIX = "_RESULT_SET_OBJ_MAPPER";
    public static final String FIELD_MODEL_FIELD_COUNT = "FIELD_COUNT";
    public static final String FIELD_REDIS_MAP_MAPPER = "MAP_MAPPER";
    public static final String FIELD_REDIS_MAP_MAPPER_INSTANCE_APPENDIX = "_MAP_OBJ_MAPPER";
    public static final String FIELD_COMMON_CONF_CLAZZ = "ALL_DTO_CLAZZ_CONF";

    public static final String FIELD_FIELDS_CLASS_CONSTANT_MAP = "FIELD_CLASS";
    public static final String FIELD_DAO_DB_FIELD = "data_store";
    public static final String FIELD_DAO_DB_FIELD_MAP = "dbMap";
    public static final String FIELD_DAO_LOGGER = "logger";
    public static final String FIELD_DAO_DS_FIELD_PREFIX = "dbOf";

    public static final String FIELD_ENUM_DESC_FIELD = "desc";
    public static final String FIELD_ENUM_VAL_FIELD = "val";
    public static final String FIELD_MULTIDAO_RND_PREFIX = "RND_OF_";


    public static final String FIELD_DEFAULT_START = "DEFAULT_START", FIELD_DEFAULT_COUNT = "DEFUALT_COUNT";
    public static final String KEY_WORD_FOR_DATA_SOURCE = "DATA_SOURCE_OF_";

    /*
     * method start
     */
    public static final String METHOD_MAPPER_MAP_ROW = "mapRow";
    public static final String METHOD_MAPPER_MAP_SINGLE_COLUMN_ROW_PREFIX = "mapField";

    public static final String METHOD_JEDIS_MAPPER_FROM_MAP = "fromMap";
    public static final String METHOD_JEDIS_MAPPER_TO_MAP = "toMap";
    public static final String METHOD_JEDIS_MAPPER_TO_COMMON_MAP = "toCommonMap";
    public static final String METHOD_JEDIS_MAPPER_FROM_COMMON_MAP = "fromCommonMap";
    public static final String METHOD_JEDIS_MAPPER_TO_MAP_FIELD_PREFIX = "mapToField";
    public static final String METHOD_JEDIS_MAPPER_FROM_MAP_FIELD_PREFIX = "mapFromField";
    public static final String METHOD_JEDIS_MAPPER_GET_FIELD = "getField";
    public static final String METHOD_JEDIS_MAPPER_SET_FIELD = "setField";

    public static final String METHOD_MODEL_GET_FIELD_CONFIG = "getFieldConfig";
    public static final String METHOD_MODEL_IS_EMPTY = "isEmpty";

    public static final String METHOD_DAO_GET_BY_ID = "getOneById";
    public static final String METHOD_DAO_GET_BY_IDS = "getById";
    public static final String METHOD_DAO_GET_ALL = "get";
    public static final String METHOD_DAO_GET_BY_INDEXES = "getByIndex";
    public static final String METHOD_DAO_GET_BY_CONDITION = "getByCond";
    public static final String METHOD_DAO_GET_ONE_BY_CONDITION = "getOneByCond";
    public static final String METHOD_DAO_GET_BY_INDEXES_AND_CONDITION = "getByIndexAndCond";

    public static final String METHOD_DAO_COMMON_SELECT_LIST = "select";
    public static final String METHOD_DAO_COMMON_SELECT_ONE = "selectOne";

    public static final String METHOD_DAO_GET_COUNT_BY_CONDITION = "getCountByCondition";

    public static final String METHOD_DAO_GET_COUNT_BY_INDEX_AND_CONDITION = "getCountByIndexesAndCondition";
    public static final String METHOD_DAO_CUSTOMER_GET_ITEM_BY_CONDITION = "getRawItemByCondition";
    public static final String METHOD_DAO_CUSTOMER_GET_ITEM_BY_INDEXES = "getRawItemByIndexes";
    public static final String METHOD_DAO_CUSTOMER_GET_BY_INDEXES_AND_CONDITION_AND_CUSTOMER_CONDITION = "getByIndexesAndCustomerCondition";
    public static final String METHOD_DAO_CUSTOMER_GET_ITEM_BY_INDEX_AND_CONDITION = "getRawItemByIndexesAndCondition";
    public static final String METHOD_DAO_CUSTOMER_GET_ITEM_BY_CUSTOMER_CONDITION = "getRawItemByCustomerCondition";
    public static final String METHOD_DAO_CUSTOMER_GET_ONE_BY_CUSTOMER_CONDITION = "getOneByCustomerCondition";
    public static final String METHOD_DAO_CUSTOMER_GET_LIST_BY_CUSTOMER_CONDITION = "getByRawCondition";
    public static final String METHOD_DAO_INSERT = "insert";
    public static final String METHOD_DAO_UPDATE = "update";
    public static final String METHOD_DAO_UPDATE_BY_ID = "updateById";
    public static final String METHOD_DAO_UPDATE_BY_IDS = "updateByIds";
    public static final String METHOD_DAO_DELETE = "delete";
    public static final String METHOD_DAO_DELETE_BY_ID = "deleteById";
    public static final String METHOD_DAO_DELETE_BY_IDS = "deleteByIds";
    public static final String METHOD_DAO_UPDATE_OR_INSERT = "updateOrInsert";
    public static final String METHOD_DAO_INSERT_IF_NO_EXIST = "insertIfNoExist";
    public static final String METHOD_DAO_BUILD_MAP = "buildMap";
    public static final String METHOD_DAO_BUILD_LIST_MAP = "buildListMap";
    public static final String METHOD_DAO_BUILD_LIST = "extractItemAsList";

    public static final String METHOD_DAO_GET_RESULT = "getResult";
    public static final String METHOD_DAO_GET_RESULT_LIST = "getResults";
    public static final String METHOD_DAO_GET_RESULT_ITEM_LIST = "getSingleResults";
    public static final String METHOD_DAO_GET_RESULT_SCALAR = "getSingleResult";
    public static final String METHOD_DAO_GET_RESULT_SINGLE_LIST = "getSingleResults";
    public static final String METHOD_DAO_BUILD_IN_CLUASE = "buildInClause";
    public static final String METHOD_DAO_BUILD_RAW_WHERE = "buildRawWhere";
    public static final String METHOD_DAO_BUILD_SELECT_FIELD_CLUASE = "buildSelectFieldCluase";
    public static final String METHOD_DAO_BUILD_CONDITION_CLUASE = "buildConditionCluase";
    public static final String METHOD_DAO_BUILD_RAW_IN_CLUASE = "buildRawInCluase";

    public static final String METHOD_DAO_PARENT_UPDATE = "update";
    public static final String METHOD_DAO_PARENT_INSERT = "insert";
    public static final String METHOD_DAO_PARENT_BATCH_INSERT = "batchInsert";

    public static final String METHOD_ASSEMBLER_INCREASE_INDEX = "increaseIndex";
    public static final String METHOD_ASSEMBLER_SET_INDEX = "setIndex";
    public static final String METHOD_ASSEMBLER_GET_INDEX = "getIndex";

    public static final String METHOD_SERVICE_GET_DATA = "getData";
    public static final String METHOD_SERVICE_GET_MAIN_DATA_PREFIX = "getMainDataVia";
    public static final String METHOD_SERVICE_ASSEMBLE_MAIN_DATA = "assembleMainData";
    public static final String METHOD_SERVICE_ASSEMBLE_MAIN_DATA_LIST = "assembleMainDataList";
    public static final String METHOD_SERVICE_GET_SUB_DATA_PREFIX = "getSubData";
    public static final String METHOD_SERVICE_ASSEMBLE_SUB_DATA_PREFIX = "assembleSubData";

    public static final String METHOD_METHOD_GET_FEATURE = "getFeature";

    public static final String METHOD_ENUM_FROM_VALUE = "fromValue";

    public static final String METHOD_SPRING_BEAN_AFTER_PROPERTIES_SET = "afterPropertiesSet";


    /*
     * method end
     */
    public static final String LIB_METHOD_SET_CONTAINS = "contains";
    public static final String LIB_SQL_BUILD_SELECT = "buildSelectSql";
    public static final String LIB_SQL_BUILD_INSERT = "buildInsertSql";
    public static final String LIB_SQL_BUILD_UPDATE = "buildUpdateSql";
    public static final String LIB_SQL_BUILD_DELETE = "buildDeleteSql";
    public static final String LIB_SQL_BUILD_SET_TABLE = "table";

    public static final String LIB_SQL_ADD_ITEM = "itemCol";
    public static final String LIB_SQL_ADD_FUNC_ITEM = "rawSelectItem";
    public static final String LIB_SQL_ADD_RAW_ITEM = "rawSelectItem";
    public static final String LIB_SQL_SET_LIMIT = "limit";
    public static final String LIB_SQL_SET_WHERE = "itemWhere";
    public static final String LIB_SQL_SET_RAW_WHERE = "rawWhere";
    public static final String LIB_SQL_GET_SQL = "getSql";
    public static final String LIB_DB_QUERY = "query";
    public static final String LIB_DB_QUERY_ONE = "queryForObject";
    public static final String LIB_DB_QUERY_LIST = "queryForList";
    public static final String LIB_DB_INSERT = "insert";
    public static final String LIB_DB_BATCH_INSERT = "batchInsert";
    public static final String LIB_DB_UPDATE = "update";
    public static final String LIB_COLUMN_TYPE_GET_TYPE = "getType";
    public static final String LIB_SQL_ASSEMBLE_SQL = "assembleSql";
    public static final String LIB_SQL_ASSEMBLE_RESULT_SET = "assembleResultSetMapper";
    public static final String LIB_SQL_ASSEMBLE_PARAM = "assembleSqlParam";
    public static final String LIB_SQL_ASSEMBLE_SELECT_DB = "selectDb";

    public static final String CLASS_NAME_DAO_PREFIX = "DAO";
    public static final String CLASS_NAME_MULTI_DAO_PREFIX = "MulDao";
    public static final String CLASS_NAME_MULTI_DAO_ASSEMBLER_APPENDIX = "Assembler";
    public static final String CLASS_NAME_MODEL_PREFIX = "Model";
    public static final String CLASS_NAME_ENUM_PREFIX = "Enum";
    public static final String CLASS_NAME_DB_SOURCE_CONFIG_PREFIX = "DSConfig";
    //    public static final String CLASS_NAME_ENUM_PREFIX = "Enum";
    public static final String CLASS_NAME_RESULT_SET_MAPPER_PREFIX = "ResultSetMapper";
    public static final String CLASS_NAME_REDIS_BYTE_MAPPER_PREFIX = "PojoMapMapper";
    public static final String CLASS_NAME_POJO_MAPPER_PREFIX = "PojoRsMapper";
    public static final String CLASS_NAME_ALL_SPECIAL_DAO_TABLE_NAME = "SqlSpecialDao";
    public static final String CLASS_NAME_ALL_SQL_CONTANT_CLASS = ".constants.SqlConstants";
    public static final String CLASS_NAME_CONSTANTS = "Constants";
    //    public static final String CLASS_NAME_COMMON_DB_DAO_PREFIX="DAO";

    public static final String KEY_WORD_GET = "get";
    public static final String KEY_WORD_SET = "set";

    public static final String KEY_WORD_DEFAULT_DATA_SOURCE_ID = "defaultDbManager";


    public static final Pattern PATTERN_TB_NAME = Pattern.compile("^\\w+$");
    public static final String PARAM_DAO_ASSEMBLER = "assembler";
    public static final String PARAM_DAO_FIELDS = "fields";
    public static final String PARAM_DAO_SELECTED_FIELDS = "selectFields";
    public static final String PARAM_DAO_START = "start";
    public static final String PARAM_DAO_COUNT = "count";
    public static final String PARAM_DAO_EXT_PARAME = "extParam";
    public static final String PARAM_DAO_EXT_CONDITION = "extCondition";
    public static final String PARAM_DAO_INDEX_IN_FIELD = "inField";
    public static final String PARAM_DAO_INDEXES = "indexes";
    public static final String PARAM_DAO_INSTANCE = "instance";
    public static final String PARAM_DAO_RAW_ITEM = "rawItem";
    public static final String PARAM_DAO_T_CLASS = "tClass";
    public static final String LIB_ASSERT_METHOD = "throwExceptionIf";

    public static final int TYPE_TABLE_SQL_TYPE = 2;
    public static final int TYPE_TABLE_MUL_TYPE = 1;
    public static final int TYPE_TABLE_COMMON_TYPE = 0;

    public static Set<SelectMethod> allSelectMethod = CollectionHelper.<SelectMethod>setBuilder(true)
            .addAll(SelectMethodEnum.getAllSelectMethod().values())
            .getSet();

    public static IJExpression litObject(Class contentType, Object obj) {
        if (obj != null && contentType != null) {
            if (TypeConstantHelper.PRIMITIVE_CLASS.contains(contentType) ||
                    TypeConstantHelper.PRIMITIVE_BOX_CLASS.contains(contentType) ||
                    contentType.equals(String.class)) {
                if (contentType.equals(int.class) || contentType.equals(Integer.class)) {
                    return JExpr.lit(Integer.parseInt(obj.toString()));
                } else if (contentType.equals(Long.class) || contentType.equals(long.class)) {
                    return JExpr.lit(Long.parseLong(obj.toString()));
                } else if (contentType.equals(Byte.class) || contentType.equals(byte.class)) {
                    return JExpr.lit(Byte.parseByte(obj.toString()));
                } else if (contentType.equals(Character.class) || contentType.equals(char.class)) {
                    return JExpr.lit(obj.toString().charAt(0));
                } else if (contentType.equals(Boolean.class) || contentType.equals(boolean.class)) {
                    return JExpr.lit(Boolean.parseBoolean(obj.toString()));
                } else if (contentType.equals(Double.class) || contentType.equals(double.class)) {
                    return JExpr.lit(Double.parseDouble(obj.toString()));
                } else if (contentType.equals(Float.class) || contentType.equals(float.class)) {
                    return JExpr.lit(Float.parseFloat(obj.toString()));
                } else if (contentType.equals(Short.class) || contentType.equals(short.class)) {
                    return JExpr.lit(Short.parseShort(obj.toString()));
                } else if (contentType.equals(String.class) || CharSequence.class.isAssignableFrom(contentType)) {
                    return JExpr.lit(obj.toString());
                } else if (Number.class.isAssignableFrom(contentType)) {
                    return JExpr.lit(((Number) obj).doubleValue());
                }
            }
        }
        throw new IllegalArgumentException("class only can be primitive and not null");
    }


    //    public static AbstractJClass buildNarrowedClass(JCodeModel cm,Class base,Object[] narrowedClass){
    //
    //    }

    public static IJExpression litObject(Object obj) {
        if (obj != null) {
            Class<?> contentType = obj.getClass();
            return litObject(contentType, obj);

        }
        throw new IllegalArgumentException("class only can be primitive and not null");

    }

    public static AbstractJClass buildNarrowedClass(JCodeModel cm, Object base, Object... narrowedClass) {

        AbstractJClass ret;
        if (base instanceof Class) {
            ret = cm.ref((Class<?>) base);
        } else if (base instanceof AbstractJClass) {
            ret = (AbstractJClass) base;
        } else {
            throw new IllegalStateException("wrong argument");
        }
        if (narrowedClass != null && narrowedClass.length > 0) {
            for (Object clz : narrowedClass) {
                if (clz instanceof Class) {
                    ret = ret.narrow((Class) clz);
                } else if (clz instanceof AbstractJClass) {
                    ret = ret.narrow((AbstractJClass) clz);
                }
            }
        }
        return ret;
    }

    //    public  static  AbstractJClass buildType(JCodeModel cm, FieldDataTypeInterface tp) {
    //        if (tp==FieldDataTypeInterface.intData || tp==FieldDataTypeInterface.shortData || tp==FieldDataTypeInterface. || tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(Integer.class);
    //        } else if (tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(Long.class);
    //        } else if (tp==FieldDataTypeInterface.intData || tp==FieldDataTypeInterface.intData || tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(Double.class);
    //        } else if (tp==FieldDataTypeInterface.intData || tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(Date.class);
    //        } else if (tp==FieldDataTypeInterface.intData || tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(String.class);
    //        } else if (tp==FieldDataTypeInterface.intData || tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(byte[].class);
    //        } else if (tp==FieldDataTypeInterface.intData) {
    //            return cm.ref(Boolean.class);
    //        }
    //        return null;
    //    }
    public static AbstractJClass buildType(JCodeModel cm, String tp) {

        tp = tp.toUpperCase();
        if (tp.startsWith("TINYINT") || tp.startsWith("SMALLINT") || tp.startsWith("INT") || tp.startsWith("MEDIUMINT")) {
            return cm.ref(Integer.class);
        } else if (tp.startsWith("BIGINT")) {
            return cm.ref(Long.class);
        } else if (tp.startsWith("DECIMAL") || tp.startsWith("FLOAT") || tp.startsWith("DOUBLE")) {
            return cm.ref(Double.class);
        } else if (tp.startsWith("DATE") || tp.startsWith("TIME")) {
            return cm.ref(Date.class);
        } else if (tp.contains("CHAR") || tp.contains("TEXT")) {
            return cm.ref(String.class);
        } else if (tp.contains("BLOB") || tp.contains("BINARY")) {
            return cm.ref(byte[].class);
        } else if (tp.contains("BOOL")) {
            return cm.ref(Boolean.class);
        }
        return null;
    }

    public static String getConfigTypeByType(String tp) {
        tp = tp.toUpperCase();
        if (tp.startsWith("TINYINT") || tp.startsWith("SMALLINT") || tp.startsWith("INT") || tp.startsWith("MEDIUMINT")) {
            return "num";
        } else if (tp.startsWith("BIGINT")) {
            return "num";
        } else if (tp.startsWith("DECIMAL") || tp.startsWith("FLOAT") || tp.startsWith("DOUBLE")) {
            return "num";
        } else if (tp.startsWith("DATE") || tp.startsWith("TIME")) {
            return "date";
        } else if (tp.contains("CHAR") || tp.contains("TEXT")) {
            return "html";
        } else if (tp.contains("BLOB") || tp.contains("BINARY")) {
            return "html";
        } else if (tp.contains("BOOL")) {
            return "string";
        }
        return "toString";
    }

    public static String getMethodByType(String tp) {
        tp = tp.toUpperCase();
        if (tp.startsWith("SMALLINT") || tp.startsWith("INT") || tp.startsWith("MEDIUMINT")) {
            return "getInt";
        } else if (tp.startsWith("TINYINT")) {
            return "getByte";
        } else if (tp.startsWith("BIGINT")) {
            return "getLong";
        } else if (tp.startsWith("DECIMAL") || tp.startsWith("FLOAT") || tp.startsWith("DOUBLE")) {
            return "getDouble";
        } else if (tp.startsWith("DATE") || tp.startsWith("TIME")) {
            return "getTimestamp";
        } else if (tp.contains("CHAR") || tp.contains("TEXT")) {
            return "getString";
        } else if (tp.contains("BLOB") || tp.contains("BINARY")) {
            return "getByte";
        } else if (tp.contains("BOOL")) {
            return "getBoolean";
        }
        return "toString";
    }

    public static JMethod[] buildGetterAndSetter(JDefinedClass _class, String fd, AbstractJClass type, JFieldVar field) {
        JMethod getter = CodeConstants.buildGetter(_class, fd, type, field);
        JMethod setter = CodeConstants.buildSetter(_class, fd, type, field);
        return new JMethod[]{getter, setter};
    }

    private static int getMod(JMods mode, boolean write) {
        int syncFlag = write ? ((mode.getValue() & JMod.VOLATILE) == 0 ? 0 : JMod.SYNCHRONIZED) : 0;
        int staticFlag = mode.isStatic() ? JMod.STATIC : 0;
        return staticFlag
                + JMod.PUBLIC
                + syncFlag;
    }

    public static JMethod buildGetter(JDefinedClass _class, String fd, AbstractJClass type, JFieldVar field) {
        JMods mods1 = field.mods();
        int mods = getMod(mods1, false);
        JMethod method = _class.method(mods, type, getModelGetMethodName(fd));
        method.body()._return(field);
        return method;
    }


    public static String getModelGetMethodName(String fd) {
        return KEY_WORD_GET + CodeStyleTransformHelper.upperFirstCase(fd);
    }

    public static JMethod buildSetter(JDefinedClass _class, String fd, AbstractJClass type, JFieldVar field) {
        JMods mods1 = field.mods();
        int mods = getMod(mods1, true);
        //        JCodeModel cm=_class.owner();

        String modelSetMethodName = getModelSetMethodName(fd);
        JMethod method = mods1.isStatic() ?
                _class.method(mods, void.class, modelSetMethodName) :
                _class.method(mods, _class, modelSetMethodName);
        JVar varParam = method.param(type, "l" + CodeStyleTransformHelper.upperFirstCase(fd));
        JBlock body = method.body();
        body.assign(field, varParam);
        if (!mods1.isStatic())
            body._return(JExpr._this());
        return method;
    }

    public static String getModelSetMethodName(String fd) {
        return KEY_WORD_SET + CodeStyleTransformHelper.upperFirstCase(fd);
    }

    public static IJExpressionStatement castToType(JCodeModel cm, IJExpressionStatement expr, String tp) {
        tp = tp.toUpperCase();
        //        cm.ref("").staticInvoke()
        if (tp.startsWith("TINYINT") || tp.startsWith("SMALLINT") || tp.startsWith("INT") || tp.startsWith("MEDIUMINT")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getInt").arg(expr);
        } else if (tp.startsWith("BIGINT")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getLong").arg(expr);
        } else if (tp.startsWith("DECIMAL") || tp.startsWith("FLOAT") || tp.startsWith("DOUBLE")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getDouble").arg(expr);
        } else if (tp.startsWith("DATE") || tp.startsWith("TIME")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getDate").arg(expr);
        } else if (tp.contains("CHAR") || tp.contains("TEXT")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getString").arg(expr);
        } else if (tp.contains("BLOB") || tp.contains("BINARY")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getString").arg(expr);
        } else if (tp.contains("BOOL")) {
            //            return cm.ref(CollectionBuilder.class).staticInvoke("getInt").arg(expr);
        }
        return null;
    }

    public static void buildPutMapExpression(JBlock body, JFieldRef constField, IJExpressionStatement param, IJExpressionStatement paramContainer, int i) {
        //        JExpression constField = JExpr.ref(limitCount);
        JConditional countIf = body._if(param.invoke("containsKey").arg(constField).not());
        JBlock blockCount = countIf._then();
        blockCount.add(paramContainer.invoke("put").arg(constField).arg(JExpr.lit(i)));
        JBlock blockCountNot = countIf._else();
        blockCountNot.add(paramContainer.invoke("put").arg(constField).arg(param.invoke("KEY_WORD_GET").arg(constField)));
    }

    public static String getClassNameFromFullName(String fullName) {
        if (fullName == null) {
            return null;
        }
        String[] split = fullName.split("\\.");
        if (split.length == 0) {
            return null;
        }
        return split[split.length - 1];
    }

    public static void buildCatchPrintStatement(JCodeModel cm, JTryBlock jTryBlock, Class<Exception> exceptionClass) {
        JCatchBlock catchBlock = jTryBlock._catch(cm.ref(exceptionClass == null ? Exception.class : exceptionClass));
        JVar param = catchBlock.param("ex");
        catchBlock.body().invoke(param, "printStackTrace");
    }

    public static void setDefaultLimit(JCodeModel cm, JBlock body, JVar start, JVar count) {
        body._if(start.eq(JExpr._null()))._then().assign(start, cm.ref(AbstractBaseModel.class).staticRef(CodeConstants.FIELD_DEFAULT_START));
        body._if(count.eq(JExpr._null()))._then().assign(count, cm.ref(AbstractBaseModel.class).staticRef(CodeConstants.FIELD_DEFAULT_COUNT));
    }

    public static JVar buildStringObjectMapParam(JCodeModel cm, JBlock body, Map<String, JVar> map) {
        JVar param = body.decl(buildNarrowedClass(cm, Map.class, String.class, Object.class), "param", cm.ref(CollectionHelper.class).staticInvoke("newMap"));
        Set<Map.Entry<String, JVar>> entries = map.entrySet();
        for (Map.Entry<String, JVar> var : entries) {
            String key = var.getKey();
            JVar value = var.getValue();
            body.invoke(param, "put").arg(JExpr.lit(key)).arg(value);
        }
        return param;
    }

    public static void copyMethodParam(JMethod fromMethod, JMethod toMethod) {
        copyMethodParam(fromMethod, toMethod, null, null);
    }

    public static void copyMethodParam(JMethod fromMethod, JMethod toMethod, List<JVar> allVar) {
        copyMethodParam(fromMethod, toMethod, allVar, null);
    }

    public static void copyMethodParam(JMethod fromMethod, JMethod toMethod, List<JVar> allVar, StringParamFilter filter) {
        boolean constructor = fromMethod.isConstructor();
        if (constructor) {
            return;
        }
        //        AbstractJType returnType = fromMethod.type();
        Collection<AbstractJClass> aThrows = fromMethod.getThrows();
        List<JVar> jVars = fromMethod.params();
        for (int i = 0, n = jVars.size(); i < n; ++i) {
            JVar param = jVars.get(i);
            String varName = param.name();
            if (filter == null || filter.accept(param, i)) {
                AbstractJType type = param.type();
                JVar var = toMethod.param(type, varName);
                if (allVar != null)
                    allVar.add(var);
            }
        }
    }

    public static JMethod buildReloadMethodWithoutCertainName(JMethod method, JDefinedClass definedClass, String... certainName) {
        List<JVar> params = method.params();
        Set<String> exclude = CollectionHelper.newSet();
        for (String n : certainName) {
            exclude.add(n);
        }
        boolean hasExcludeParam = false;
        for (JVar var : params) {
            String name = var.name();
            if (exclude.contains(name)) {
                hasExcludeParam = true;
            }
        }
        if (hasExcludeParam) {
            JMethod reloadMethod = definedClass.method(JMod.PUBLIC, method.type(), method.name());
            JTypeVar[] jTypeVars = method.typeParams();
            for (JTypeVar var : jTypeVars) {
                reloadMethod.generify(var.name(), var._extends());
            }
            //        List<JVar> allVars=CollectionHelper.newLinkedList();
            //        final int assemblerIndex;
            JBlock body = reloadMethod.body();
            JInvocation invoke = JExpr.invoke(method);

            for (JVar var : params) {
                String name = var.name();
                AbstractJType type = var.type();
                if (exclude.contains(name)) {
                    invoke.arg(JExpr._null());
                } else {
                    JVar param = reloadMethod.param(type, name);
                    invoke.arg(param);
                }
            }
            body._return(invoke);
            return reloadMethod;
        } else {
            return method;
        }
    }

    public static String getMethodNameOfModelGet(String colName) {
        return CodeConstants.KEY_WORD_GET + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(colName));
    }

    public static String getMethodNameOfModelSet(String colName) {
        return CodeConstants.KEY_WORD_SET + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(colName));
    }

    public static String getMethodNameOfRedisMapperMapToField(String colName) {
        return CodeConstants.METHOD_JEDIS_MAPPER_TO_MAP_FIELD_PREFIX + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(colName));
    }

    public static String getMethodNameOfRedisMapperMapFromField(String colName) {
        return CodeConstants.METHOD_JEDIS_MAPPER_FROM_MAP_FIELD_PREFIX + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(colName));
    }

    public static String getMethodNameOfResultSetMapField(String colName) {
        return CodeConstants.METHOD_MAPPER_MAP_SINGLE_COLUMN_ROW_PREFIX + CodeStyleTransformHelper.upperFirstCase(colName);
    }

    public static String getClazzNameFromTableName(String tableName) {
        String humpStyle = tableName;
        if (tableName.contains("_")) {
            humpStyle = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(tableName);
        }
        return CodeStyleTransformHelper.upperFirstCase(humpStyle);
    }

    public static JFieldRef getBaseModelColumnStaticRef(AbstractJClass modelClass, String colName) {
        return modelClass.staticRef(CodeConstants.FIELD_CONST_NAME_PREFIX + colName.toUpperCase());
    }

    public static void genToStringMethod(JCodeModel cm, JDefinedClass definedClass, boolean includeStatic) {
        JMethod toStringMethod = definedClass.method(JMod.PUBLIC, cm.ref(String.class), "toString");
        JBlock body = toStringMethod.body();
        AbstractJClass jClassRet = cm.ref(StringBuilder.class);
        JVar ret = body.decl(jClassRet, "ret", JExpr._new(jClassRet));

        Map<String, JFieldVar> fields = definedClass.fields();
        Set<Map.Entry<String, JFieldVar>> entries = fields.entrySet();
        for (Map.Entry<String, JFieldVar> entry : entries) {
            JFieldVar value = entry.getValue();
            JMods mods = value.mods();
            if ((mods.getValue() & JMod.FINAL) == 0) {
                if ((!includeStatic && !mods.isStatic()) || includeStatic) {
                    String key = entry.getKey();
                    JInvocation arg = JExpr.invoke(ret, "append").arg(JExpr.lit("{"))
                            .invoke("append").arg(JExpr.lit(key))
                            .invoke("append").arg(JExpr.lit(":"))
                            .invoke("append").arg(value)
                            .invoke("append").arg(JExpr.lit("}\n"));
                    body.add(arg);
                }
            }
        }
        body._return(JExpr.invoke(ret, "toString"));
    }

    public static String getFieldNameOfMulDaoRNDName(String mainField) {
        String sMain = CodeStyleTransformHelper.humpStyleToUnderlineSplittedStyle(mainField).toUpperCase();
        return FIELD_MULTIDAO_RND_PREFIX + sMain;
    }

    public static String getMethodNameOfMultiDaoAssemble(String mainField) {
        return LIB_SQL_ASSEMBLE_SQL + CodeStyleTransformHelper.upperFirstCase(mainField);
    }

    public static JInvocation invokeMethodWithParam(JMethod assembleMain, List<JVar> jVars) {
        JInvocation invoke = JExpr.invoke(assembleMain);
        for (JVar var : jVars) {
            invoke.arg(var);
        }
        return invoke;
    }

    public static AbstractJClass getClassFromDef(JCodeModel cm, FieldInfoInterface fieldDef) {
        AbstractJClass abstractJClass = null;
        FieldDataTypeInterface type = fieldDef.getType();
        String clzName = type.getTClassName();
        if (!type.isArray() && !type.isCollection() && !type.isMap()) {
            abstractJClass = cm.ref(clzName);
        } else if (type.isArray()) {
            abstractJClass = cm.ref(clzName).array();
        } else if (type.isCollection()) {
            abstractJClass = CodeConstants.buildNarrowedClass(cm, Collection.class, clzName);
        } else if (type.isMap()) {
            String keyClzName = type.getKeyClassName();
            abstractJClass = CodeConstants.buildNarrowedClass(cm, Map.class, keyClzName, clzName);
        }
        return abstractJClass;
    }

    public static String getFieldNameOfDBFieldBySourceName(String dsName) {
        return CodeConstants.FIELD_DAO_DB_FIELD
                + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(dsName))
                ;
    }

    public static String getFieldNameOfDBSourceName(String dsName) {
        return CodeConstants.FIELD_DAO_DS_FIELD_PREFIX
                + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(dsName))
                ;
    }

    public static boolean hasMethod(String methodName) {
        return allSelectMethod.contains(methodName);
    }

    public static final String buildConfNameFromDbAndTable(String db, String table) {
        String name = null;

        if (db == null) {
            name = table;
        } else {
            name = db + "_" + table;
        }
        return name;
    }

    public static String getFieldNameFromTbColumn(String colName) {
        String fname = null;
        String humpStyleColName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(colName);

        if (PATTERN_NUMBER_START.matcher(humpStyleColName).matches()) {
            fname = CodeConstants.FIELD_MODEL_FIELD_PREFIX + CodeStyleTransformHelper.upperFirstCase(humpStyleColName);
        } else {
            fname = humpStyleColName;
        }
        return fname;
    }

    public static void buildStaticFieldFromMap(JCodeModel cm, JDefinedClass definedClass, Map<String, FieldInfoInterface> staticConstFields) {
        Collection<FieldInfoInterface> collection = staticConstFields.values();
        for (FieldInfoInterface fd : collection) {
            String fieldName = fd.getFieldName();
            Object defaultValue = fd.getDefaultValue();
            FieldDataTypeInterface type = fd.getType();
            definedClass.field(CodeConstants.MODE_PUBLIC_STATIC_FINAL, cm.ref(type.getTClassName()), fieldName, CodeConstants.litObject(defaultValue));
        }

    }

    public static String getFieldNameOfDbRsMapperForModel(String name) {

        return name.toUpperCase() + CodeConstants.FIELD_RESULT_SET_MAPPER_INSTANCE_APPENDIX;
    }

    public static String getFieldNameOfCommonMapperForModel(String name) {

        return name.toUpperCase() + CodeConstants.FIELD_REDIS_MAP_MAPPER_INSTANCE_APPENDIX;
    }

    public static String getConfNameOfEnum(EnumTypeDef def) {
        return def.getCol().getFieldName() + "Enum";
    }

    public static String getDsConfigClzName(String name) {

        return CLASS_NAME_DB_SOURCE_CONFIG_PREFIX + CodeStyleTransformHelper.upperFirstCase(name);
    }

    public static JInvocation getCommonFieldMapper(String name1, JDefinedClass constantClz1) {
        String fieldGetterNameOfCommonMapper = getModelGetMethodName(getFieldNameOfCommonMapperForModel(name1));
        JInvocation fieldCommonMapper = constantClz1.staticInvoke(fieldGetterNameOfCommonMapper);
        return fieldCommonMapper;
    }

    public static JInvocation getDbRsFieldMapper(String name1, JDefinedClass constantClz1) {
        String fieldGetterNameOfCommonMapper = getModelGetMethodName(getFieldNameOfDbRsMapperForModel(name1));
        JInvocation fieldCommonMapper = constantClz1.staticInvoke(fieldGetterNameOfCommonMapper);
        return fieldCommonMapper;
    }

    public static FieldDataTypeInterface getFieldType(String db, String table, String colName) {
        final DbInfoInterface holder = DbDataTable.getDb(db);
        TableInfoInterface tableInfoInterface = holder.getTable(table);
        if (tableInfoInterface == null) {
            return null;
        } else {
            return tableInfoInterface.getColumnDataType(colName);
        }
    }

    public static FieldDataTypeInterface getIdFieldType(String db, String table) {
        final DbInfoInterface holder = DbDataTable.getDb(db);
        TableInfoInterface tableInfoInterface = holder.getTable(table);
        if (tableInfoInterface == null) {
            return null;
        } else {
            return tableInfoInterface.getPriKeyType();
        }
    }

    public static String getIdFieldName(String db, String table) {
        final DbInfoInterface holder = DbDataTable.getDb(db);
        TableInfoInterface tableInfoInterface = holder.getTable(table);
        if (tableInfoInterface == null) {
            return null;
        } else {
            return tableInfoInterface.getPriKey();
        }
    }

    public static String getEnumClzName(String basePackage, String clazzName) {
        return basePackage + ".dto.enums." + CLASS_NAME_ENUM_PREFIX + CodeStyleTransformHelper.upperFirstCase(clazzName);
    }

    public static String getModelVoClassName(String basePackage, String tb) {
        return basePackage + ".vo." + CLASS_NAME_MODEL_PREFIX + CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(tb));
    }

    public static String getConstantClzName(String basePackage) {
        return basePackage + ".contants." + CLASS_NAME_CONSTANTS;
    }

    public static String getRSMapperClassName(String basePackage, String table) {
        String modelSimpleName = CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table));
        return basePackage + ".dto." + "mappers." + CLASS_NAME_RESULT_SET_MAPPER_PREFIX + modelSimpleName;
    }

    public static String getMapMapperClassName(String basePackage, String table) {
        String modelSimpleName = CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table));
        return basePackage + ".dto." + "mappers." + CLASS_NAME_REDIS_BYTE_MAPPER_PREFIX + modelSimpleName;
    }

    public static String getDaoClassName(String basePackage, String table, String baseTable, int type) {
        String tb = (baseTable == null ? table : baseTable);
        String modelSimpleName = CodeStyleTransformHelper.upperFirstCase(CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(tb));
        if (type == TYPE_TABLE_SQL_TYPE && baseTable == null) {
            return basePackage + ".dao.spdao." + CLASS_NAME_DAO_PREFIX + modelSimpleName;
        } else {
            return basePackage + ".dao.basedao." + CLASS_NAME_DAO_PREFIX + modelSimpleName;
        }
    }

    public static String getDaoClassName(String basePackage, String table) {
        //        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
        return getDaoClassName(basePackage, table, null, 0);
        //                basePackage + ".dao." + CodeConstants.CLASS_NAME_DAO_PREFIX + CodeStyleTransformHelper.upperFirstCase(modelSimpleName);
    }

    public static String getMulSelectDaoClassName(String basePackage, String table) {
        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
        return basePackage + ".dao.multi_dao." + CLASS_NAME_MULTI_DAO_PREFIX + CodeStyleTransformHelper.upperFirstCase(modelSimpleName);
    }

    public static String getMulDaoAssemblerClassName(String basePackage, String serviceClassName) {
        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(serviceClassName);
        return basePackage + ".dao.multi_dao." + CLASS_NAME_MULTI_DAO_PREFIX + CodeStyleTransformHelper.upperFirstCase(modelSimpleName) + CLASS_NAME_MULTI_DAO_ASSEMBLER_APPENDIX;
    }

    public static String getClassNameOfSpecialQueryDto(String basePackage, String clzName) {
        return basePackage + ".dto.input." + CLASS_NAME_MODEL_PREFIX + CodeStyleTransformHelper.upperFirstCase(clzName);
    }

    public static String getModelClassName(String basePackage, String table, String baseTable) {
        return getModelClassName(basePackage, table, baseTable, true);
    }

    public static String getModelClassName(String basePackage, String table, boolean base) {
        return getModelClassName(basePackage, table, null, base);
    }

    public static String getModelClassName(String basePackage, String table, String baseTable, boolean isBase) {
        String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
        String prefix = basePackage + ".dto." + (isBase ? "basepo." : "composedpo.") + CLASS_NAME_MODEL_PREFIX;
        return (prefix + CodeStyleTransformHelper.upperFirstCase(modelSimpleName)) + (baseTable == null ? "" : "Ext");
    }


    public static interface StringParamFilter {
        boolean accept(JVar var, int i);
    }

    public static AbstractJType getTypeOfField(JCodeModel cm, ModelBuilderContext bc, String db, String table, String field) {
        final DbInfoInterface dbInfo = DbDataTable.getDb(db);
        if (dbInfo == null)
            return null;
        final TableInfoInterface tableInfo = dbInfo.getTable(table);
        if (tableInfo == null)
            return null;
        final ColumnInfoInterface item = (ColumnInfoInterface) tableInfo.getColumnData(field);
        if (item == null)
            return null;
        AbstractJClass jClass;
        EnumTypeDef typeDef = item.getEnumTypeDef();
        if (typeDef == null) {
            jClass = cm.ref(item.getType().gettClass());
        } else {
            //                if(type==null && enumTypeDef !=null) {
            jClass = cm.ref(typeDef.getClazzName());
            //                }
        }
        return jClass;
    }

    public static AbstractJClass getFieldDefType(JCodeModel cm, FieldInfoInterface item) {
        return getFieldDefType(cm, null, item, null);
    }

    public static AbstractJClass getFieldDefType(JCodeModel cm, _BaseModelConf odef, FieldInfoInterface item, ModelBuilderContext bc) {
        AbstractJClass jClass = null;
        //        if (odef instanceof CommonModelDaoDef) {
        //            CommonModelDaoDef def = (CommonModelDaoDef) odef;
        FieldDataTypeInterface type = item.getType();
        EnumTypeDef typeDef = item.getEnumTypeDef();
        if (typeDef == null) {
            if (type.gettClass() != null)
                jClass = cm.ref(type.gettClass());
            else if (type.getTClassName() != null)
                jClass = cm.ref(type.getTClassName());
        } else {
            //                FieldInfoInterface field = def.getField(item.getFieldName());
            //                EnumTypeDef enumTypeDef = field.getEnumTypeDef();
            //                if(enumTypeDef!=null) {
            //                    jClass = cm.ref(enumTypeDef.getClazzName());//def.getEnumClz(item.getFieldName());
            //                    if (jClass == null) {
            //                if(type==null && enumTypeDef !=null) {

            //                }
            //                    }
            //                }else{
            jClass = cm.ref(getEnumClzName(bc.getBasePackage(), typeDef.getClazzName()));
            //                }
        }
        if (type.isArray()) {
            jClass = jClass.array();
        } else if (type.isCollection()) {
            jClass = CodeConstants.buildNarrowedClass(cm, Collection.class, jClass);
        } else if (type.isMap()) {
            jClass = CodeConstants.buildNarrowedClass(cm, Map.class, cm.ref(type.getKeyClass()), jClass);
        }
        //        } else {
        //            jClass = cm.ref(item.getType().gettClass());
        //        }
        return jClass;
    }

    public static boolean testIgnore(String tableName, Collection<String> ignoreTbPattern, Collection<String> includingTable) {
        List<Pattern> excluding = CollectionHelper.newList();
        List<Pattern> including = CollectionHelper.newList();
        if (includingTable != null && includingTable.size() > 0) {
            for (String p : includingTable) {
                Pattern pattern = Pattern.compile(p);
                including.add(pattern);
            }
        }
        //        else {
        if (ignoreTbPattern != null && ignoreTbPattern.size() > 0) {
            for (String p : ignoreTbPattern) {
                Pattern pattern = Pattern.compile(p);
                excluding.add(pattern);
            }
        }
        if (!PATTERN_TB_NAME.matcher(tableName).matches()) {
            return true;
        }
        if (including.size() > 0) {
            if (!matchingOne(tableName, including))
                return true;
        }
        if (excluding.size() > 0) {
            return matchingOne(tableName, excluding);
        }
        return false;
    }

    public static boolean matchingOne(String target, Collection<Pattern> allPatterns) {
        if (allPatterns != null && allPatterns.size() != 0) {
            for (Pattern p : allPatterns) {
                if (p.matcher(target).matches()) {
                    return true;
                }
            }
        }
        return false;
    }
}
