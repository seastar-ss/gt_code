//package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao;
//
//import com.shawn.ss.lib.tools.data_store.api.interfaces.db_operation.dao.model.OrderType;
//import com.shawn.ss.lib.tools.data_store.dto_base.model.AbstractBaseModel;
//import com.shawn.ss.lib.tools.data_store.dto_base.model.AbstractOneToManyLinkModel;
//import com.shawn.ss.lib.tools.data_store.dto_base.model.AbstractOneToOneLinkModel;
//
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by ss on 2017/10/10.
// */
//public interface CascadeSingleDAOInterface<E extends AbstractBaseModel,T extends AbstractOneToOneLinkModel<E>> extends BaseDAOInterface<T> {
//    T selectJoinedDatasByEqCondition(T condition, E additionalCondition, Set<String> selectFields,
//                                     Map<String, OrderType> order, Set<String> joinedFields);
//    int insertCascade(T allParam);
//
//    int updateCascade(T allParam,Set<String> conditionFields);
//}
