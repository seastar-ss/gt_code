//package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;
//
////import com.shawn.ss.lib.tools.data_store.api.interfaces.db_operation.dao.model.OpType;
//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.OrderType;
//import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.TableReferInfo;
//import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
//import com.shawn.ss.lib.tools.structure.NamedCommonEntry;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by ss on 2017/10/10.
// */
//public interface BaseDAOInterface<T extends AbstractBaseModel> {
//
//    List<T> selectByEqCondition(T condition, Set<String> selectFields,Map<String, OrderType> order);
//
//    List<T> selectByEqCondition(T condition, Set<String> selectFields,Map<String, OrderType> order,int start,int count);
//
////    List<T> selectByCondition(Map<OpType, String> conditions, Set<String> fields, Map<String, OrderType> order);
//
//    List<T> selectByIds(String... id);
//
//    T selectOneByEqCondition(T eqConditions, Set<String> fields);
//
//    T selectOneById(String id);
//
//    int getCountByEqCondition(T eqConditions);
//
//    boolean isExistByEqCondition(T eqConditions);
//
//    int insert(T item);
//
//    int insertAll(List<T> items);
//
//    int updateByEqCondition(T allParam, Set<String> conditionFields);
//
//    int updateByEqCondition(T allParam, Set<String> conditionFields,int start,int count);
//
//    int updateById(T allParam, String id);
//
//    int updateByIds(T allParam, String ... id);
//
//    int updateOrInsertByEqCondition(T allParam, Set<String> conditionFields);
//
//    int deleteById(String id);
//
//    int deleteByIds(String ... id);
//
//    int deleteByEqCondition(T param);
//
//    int deleteByEqCondition(T param,int start,int count);
//
//    TableReferInfo getTableInfo();
//
//}
