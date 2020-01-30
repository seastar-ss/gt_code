package com.shawn.ss.lib.tools.service_assemble.utils;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.DataSourceAndSchemaAndTable;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;


import java.util.List;
import java.util.Map;

public class ComposedDaoAssembler implements DaoAssembler {
    List<DaoAssembler> assemblerList;

    public ComposedDaoAssembler() {
        this.assemblerList = CollectionHelper.newList();
    }

    public ComposedDaoAssembler(List<DaoAssembler> assemblerList) {
        this.assemblerList = assemblerList;
    }

    public int sizeOfSubAssembler() {
        return assemblerList.size();
    }

    public boolean addSubAssembler(DaoAssembler assembler) {
        return assemblerList.add(assembler);
    }

    public void clearSubAssembler() {
        assemblerList.clear();
    }

    public DaoAssembler getSubAssembler(int index) {
        return assemblerList.get(index);
    }

    @Override
    public int assembleSql(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        if(assemblerList.size()>0){
            for(DaoAssembler assembler:assemblerList){
                int i = assembler.assembleSql(sql, params, tClazz);
                if(i !=0){
                    return  i;
                }
            }
        }
        return 0;
    }

    @Override
    public int assembleSql(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        if(assemblerList.size()>0){
            for(DaoAssembler assembler:assemblerList){
                int i = assembler.assembleSql(sql, params, tClazz);
                if(i !=0){
                    return  i;
                }
            }
        }
        return 0;
    }

    @Override
    public <T extends AbstractBaseModel> DbResultSetMapper<T> assembleResultSetMapper(Map<String, Object> params, Class<T> tClazz) {
        if(assemblerList.size()>0){
            return assemblerList.get(0).assembleResultSetMapper(params,tClazz);
        }
        return null;
    }

    @Override
    public boolean isMultiple() {
        if(assemblerList.size()>0){
            return assemblerList.get(0).isMultiple();
        }
        return false;
    }

    @Override
    public DataSourceAndSchemaAndTable selectDb(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        if(assemblerList.size()>0){
            return assemblerList.get(0).selectDb(sql,params,tClazz);
        }
        return null;
    }

    @Override
    public DataSourceAndSchemaAndTable selectDb(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        if(assemblerList.size()>0){
            return assemblerList.get(0).selectDb(sql,params,tClazz);
        }
        return null;
    }
}
