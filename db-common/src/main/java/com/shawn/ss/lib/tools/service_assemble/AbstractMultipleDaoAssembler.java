package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.mappers.db.DbResultSetMapper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.sql_code_gen.api.SQL;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2018/10/5.
 */
public abstract class AbstractMultipleDaoAssembler extends AbstractDaoAssembler implements DaoAssembler, SQLLoopStatus {

    //    final boolean isMultiple;

    protected final BaseSQLLoopStatus status;

    protected volatile Map<Integer, AbstractDaoAssembler> assemblers;

    protected AbstractMultipleDaoAssembler() {
        super(true);
        status = new BaseSQLLoopStatus();
    }

    private void testAndBuildParams() {
        if (assemblers == null) {
            synchronized (this) {
                assemblers = CollectionHelper.newMap();
            }
        }
    }

    protected void registerAssembler(Integer key, AbstractDaoAssembler assembler) {
        testAndBuildParams();
        assemblers.put(key, assembler);
    }

    protected AbstractDaoAssembler obtainAssembler(Integer key) {
        if (assemblers == null) return null;
        AbstractDaoAssembler abstractDaoAssembler = assemblers.get(key);
        if (abstractDaoAssembler instanceof AbstractMultipleDaoAssembler) {
            AbstractMultipleDaoAssembler ma = (AbstractMultipleDaoAssembler) abstractDaoAssembler;
            ma.putAllParam(this.getAdditionalParams());
        }
        return abstractDaoAssembler;
    }

    @Override
    public int assembleSql(SQL sql, Map<String, Object> params, Class<? extends AbstractBaseModel> tClazz) {
        return 0;
    }

    @Override
    public int assembleSql(SQL sql, List<Map<String, Object>> params, Class<? extends AbstractBaseModel> tClazz) {
        return 0;
    }

    @Override
    public <T extends AbstractBaseModel> DbResultSetMapper<T> assembleResultSetMapper(Map<String, Object> params, Class<T> tClazz) {
        return null;
    }

    @Override
    public int getIndex() {
        return status.getIndex();
    }

    public boolean isParamEmpty() {
        return status.isParamEmpty();
    }

    public Set<String> paramKeySet() {
        return status.paramKeySet();
    }

    public int paramSize() {
        return status.paramSize();
    }

    public Object getParam(Object key) {
        return status.getParam(key);
    }

    public Object putParam(String key, Object value) {
        return status.putParam(key, value);
    }

    public void putAllParam(Map<? extends String, ?> m) {
        status.putAllParam(m);
    }

    @Override
    public Map<String, Object> getAdditionalParams() {
        return status.getAdditionalParams();
    }

    public void increaseIndex() {
        status.increaseIndex();
    }

    public BaseSQLLoopStatus setIndex(int index) {
        return status.setIndex(index);
    }

    public void clearParam() {
        status.clearParam();
    }

    @Override
    public boolean isMultiple() {
        return isMultiple;
    }

    protected void clearData() {
        if (!CollectionHelper.isCollectionEmpty(assemblers)) {
            assemblers.forEach((k, v) -> {
                if (v instanceof AbstractMultipleDaoAssembler) {
                    ((AbstractMultipleDaoAssembler) v).clearParam();
                }
            });
        }
        clearParam();
    }
}
