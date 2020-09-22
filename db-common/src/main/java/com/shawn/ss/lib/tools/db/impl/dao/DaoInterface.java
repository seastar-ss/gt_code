package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DaoInterface<Ty extends AbstractBaseModel, Tt>
//        extends
//        _AssembleDaoInterface<Ty>, _ConditionSelectDaoInterface<Ty>,
//        _IdSelectDaoInterface<Ty,Tt>, _InSelectDaoInterface<Ty>, _WhereSelectDaoInterface<Ty>,_BaseSelectDaoInterface<Ty>,
//        _UpdateDaoInterface<Ty>, _InsertDaoInterface<Ty>, _DeleteDaoInterface<Ty>, _ComplexUpdateDaoInterface<Ty>,
//        _ComplexSelectListDaoInterface<Ty>,_ComplexSelectItemDaoInterface<Ty>,_ComplexSelectOneDaoInterface<Ty>,
//        JoinableDao<Ty>
{
    public static final String KEY_WORD_TABLE_NAME_IN_PARAM="__table_name__";
    public static final String KEY_WORD_DB_NAME_IN_PARAM="__db_name__";
    public static final String KEY_WORD_DS_NAME_IN_PARAM="__ds_name__";
    String KEY_WORD_LIMIT_START = "start";
    String KEY_WORD_LIMIT_COUNT = "count";

    List<Ty> get(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count);

    List<Ty> get(Set<String> selectFields, Integer start, Integer count);

    List<Ty> get(Integer start, Integer count);

    List<Ty> get();

    List<Ty> getById(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, List<Tt> id);

    List<Ty> getById(Set<String> selectFields, Integer start, Integer count, List<Tt> id);

    List<Ty> getById(Integer start, Integer count, List<Tt> id);

    List<Ty> getById(List<Tt> id);

    List<Ty> getByIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes);

    List<Ty> getByIndex(Set<String> selectFields, Integer start, Integer count, String inField, List indexes);

    List<Ty> getByIndex(Integer start, Integer count, String inField, List indexes);

    List<Ty> getByIndex(String inField, List indexes);

    List<Ty> getByCond(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance);

    List<Ty> getByCond(Set<String> selectFields, Integer start, Integer count, Ty instance);

    List<Ty> getByCond(Integer start, Integer count, Ty instance);

    List<Ty> getByCond(Ty instance);

    List<Ty> getByWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByWhere(Set<String> selectFields, Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByWhere(Integer start, Integer count, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByWhere(Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndex(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes);

    List<Ty> getByCondAndIndex(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes);

    List<Ty> getByCondAndIndex(Integer start, Integer count, Ty instance, String inField, List indexes);

    List<Ty> getByCondAndIndex(Ty instance, String inField, List indexes);

    List<Ty> getByIdAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Tt id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndWhere(Set<String> selectFields, Integer start, Integer count, Tt id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndWhere(Integer start, Integer count, Tt id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndWhere(Tt id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndCondAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndCondAndWhere(Integer start, Integer count, Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIdAndCondAndWhere(Ty instance, List<Tt> id, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(Set<String> selectFields, Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByIndexAndWhere(String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Integer start, Integer count, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndWhere(Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Set<String> selectFields, Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Integer start, Integer count, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    List<Ty> getByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneById(Set<String> selectFields, DaoAssembler assembler, Tt id);

    Ty getOneById(Set<String> selectFields, Tt id);

    Ty getOneById(Tt id);

    Ty getOneByCond(Set<String> selectFields, DaoAssembler assembler, Ty instance);

    Ty getOneByCond(Set<String> selectFields, Ty instance);

    Ty getOneByCond(Ty instance);

    Ty getOneByWhere(Set<String> selectFields, DaoAssembler assembler, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByWhere(Set<String> selectFields, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByWhere(Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByCondAndWhere(Set<String> selectFields, Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByCondAndWhere(Ty instance, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByIdAndCondAndWhere(Set<String> selectFields, DaoAssembler assembler, Ty instance, Tt id, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByIdAndCondAndWhere(Set<String> selectFields, Ty instance, Tt id, Map<String, Object> extParam, Set<String> extCondition);

    Ty getOneByIdAndCondAndWhere(Ty instance, Tt id, Map<String, Object> extParam, Set<String> extCondition);

    Long getCountByCond(DaoAssembler assembler, Ty instance);

    Long getCountByCond(Ty instance);

    Long getCountByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes);

    Long getCountByCondAndIndex(Ty instance, String inField, List indexes);

    Long getCountByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    Long getCountByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Map<String, Object> extParam, Set<String> extCondition);

    <TT> TT getItemByIndex(DaoAssembler assembler, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> TT getItemByIndex(String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT> TT getItemByWhere(DaoAssembler assembler, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> TT getItemByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT> TT getItemByCond(DaoAssembler assembler, Ty instance, Class<TT> tClass, String rawItem);

    <TT extends Object> TT getItemByCond(Ty instance, Class<TT> tClass, String rawItem);

    <TT> TT getItemByCondAndIndex(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> TT getItemByCondAndIndex(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT> TT getItemByCondAndIndexAndWhere(DaoAssembler assembler, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> TT getItemByCondAndIndexAndWhere(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT> List<TT> getItemListByIndex(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListByIndex(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListByIndex(String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT> List<TT> getItemListByCond(DaoAssembler assembler, Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListByCond(Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListByCond(Ty instance, Class<TT> tClass, String rawItem);

    <TT> List<TT> getItemListById(DaoAssembler assembler, Integer start, Integer count, Tt id, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListById(Integer start, Integer count, Tt id, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListById(Tt id, Class<TT> tClass, String rawItem);

    <TT> List<TT> getItemListByWhere(DaoAssembler assembler, Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByWhere(Integer start, Integer count, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByWhere(Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT> List<TT> getItemListByIndexAndWhere(DaoAssembler assembler, Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByIndexAndWhere(Integer start, Integer count, String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByIndexAndWhere(String inField, List indexes, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT> List<TT> getItemListByCondAndWhere(DaoAssembler assembler, Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByCondAndWhere(Integer start, Integer count, Ty instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByCondAndWhere(Ty instance, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT> List<TT> getItemListByCondAndIndex(DaoAssembler assembler, Integer start, Integer count, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListByCondAndIndex(Integer start, Integer count, Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT extends Object> List<TT> getItemListByCondAndIndex(Ty instance, String inField, List indexes, Class<TT> tClass, String rawItem);

    <TT> List<TT> getItemListByIdAndCondAndWhere(DaoAssembler assembler, Integer start, Integer count, Ty instance, List<Tt> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Integer start, Integer count, Ty instance, List<Tt> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    <TT extends Object> List<TT> getItemListByIdAndCondAndWhere(Ty instance, List<Tt> id, Class<TT> tClass, String rawItem, Map<String, Object> extParam, Set<String> extCondition);

    AbstractBaseModel insert(Ty instance, DaoAssembler assembler);

    AbstractBaseModel insert(Ty instance);

    Integer insert(List<Ty> instances, Set<String> fields, DaoAssembler assembler);

    Integer insert(List<Ty> instances, Set<String> fields);

    Integer insert(List<Ty> instances);

    Integer update(Ty instance, Set<String> conditionField, DaoAssembler assembler);

    Integer update(Ty instance, Set<String> conditionField);

    Integer updateById(Ty instance, DaoAssembler assembler);

    Integer updateById(Tt id,Ty instance);

    Integer updateById(Ty instance);

    Integer updateByIds(Ty instance, Set<Integer> ids, DaoAssembler assembler);

    Integer updateByIds(Ty instance, Set<Integer> ids);

    Integer delete(Ty instance, Set<String> conditionField, DaoAssembler assembler);

    Integer delete(Ty instance, Set<String> conditionField);

    Integer deleteById(Tt id, DaoAssembler assembler);

    Integer deleteById(Tt id);

    Integer deleteByIds(Set<Integer> ids, DaoAssembler assembler);

    Integer deleteByIds(Set<Integer> ids);

    @Transactional
    AbstractBaseModel updateOrInsert(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler);

    AbstractBaseModel updateOrInsert(Ty instance, Set<String> conditionField);

    @Transactional
    AbstractBaseModel insertIfNoExist(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler);

    AbstractBaseModel insertIfNoExist(Ty instance, Set<String> conditionField);

    <TT> Map<TT, Ty> buildMap(List<Ty> list, String field);

    <TT> Map<TT, List<Ty>> buildListMap(List<Ty> list, String field);

    <TT> List<TT> extractItemAsList(List<Ty> list, String field);

    DaoInterface setCurrentQueryTable(String table);

    DaoInterface setCurrentQueryDB(String db);

    DaoInterface setCurrentQueryDataSource(String ds);

    AbstractDao<Ty, Tt> setDefaultResultSetMapping(DbResultSetMapper<Ty> defaultRSMapper);

    List<Ty> select(SelectParamHolder<Ty, Tt> holder);

    Ty selectOne(SelectParamHolder<Ty, Tt> holder);

    <TT extends Object, Tc> Tc selectItem(SelectParamHolder<Ty, Tt> holder, Class<Tc> tcClass);

    <TT extends Object, Tc> List<Tc> selectItemList(SelectParamHolder<Ty, Tt> holder, Class<Tc> tcClass);

    public static class SelectParamHolder<Ty, Tt> {
        List<Tt> ids;
        Tt id;
        Set<String> selectFields;
        Integer start;
        Integer count;
        Ty instance;
        String inField;
        List indexes;
        String rawItem;
        Map<String, Object> extParam;
        Set<String> extCondition;
        DaoAssembler assembler;

        public Set<String> getSelectFields() {
            return selectFields;
        }

        public SelectParamHolder setSelectFields(Set<String> selectFields) {
            this.selectFields = selectFields;
            return this;
        }

        public Integer getStart() {
            return start;
        }

        public SelectParamHolder setStart(Integer start) {
            this.start = start;
            return this;
        }

        public Integer getCount() {
            return count;
        }

        public SelectParamHolder setCount(Integer count) {
            this.count = count;
            return this;
        }

        public Ty getInstance() {
            return instance;
        }

        public SelectParamHolder setInstance(Ty instance) {
            this.instance = instance;
            return this;
        }

        public String getInField() {
            return inField;
        }

        public SelectParamHolder setInField(String inField) {
            this.inField = inField;
            return this;
        }

        public List getIndexes() {
            return indexes;
        }

        public SelectParamHolder setIndexes(List indexes) {
            this.indexes = indexes;
            return this;
        }

        public String getRawItem() {
            return rawItem;
        }

        public SelectParamHolder setRawItem(String rawItem) {
            this.rawItem = rawItem;
            return this;
        }

        public Map<String, Object> getExtParam() {
            return extParam;
        }

        public SelectParamHolder setExtParam(Map<String, Object> extParam) {
            this.extParam = extParam;
            return this;
        }

        public Set<String> getExtCondition() {
            return extCondition;
        }

        public SelectParamHolder setExtCondition(Set<String> extCondition) {
            this.extCondition = extCondition;
            return this;
        }

        public List<Tt> getIds() {
            return ids;
        }

        public SelectParamHolder setIds(List<Tt> ids) {
            this.ids = ids;
            return this;
        }

        public Object getId() {
            return id;
        }

        public SelectParamHolder setId(Tt id) {
            this.id = id;
            return this;
        }

        public DaoAssembler getAssembler() {
            return assembler;
        }

        public SelectParamHolder setAssembler(DaoAssembler assembler) {
            this.assembler = assembler;
            return this;
        }
    }
}
