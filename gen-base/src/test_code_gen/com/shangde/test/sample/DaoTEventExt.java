package com.shangde.test.sample;

import com.shangde.ent_portal.logical.dao.basedao.DAOTEvent;
import com.shangde.ent_portal.logical.dto.basepo.ModelTEvent;
import com.shangde.ent_portal.logical.dto.basepo.ResultSetMapperTEvent;

import java.util.List;

public class DaoTEventExt extends DAOTEvent<ModelTEventExt> {

    static DaoTEventExt ext = new DaoTEventExt(ModelTEventExt.class, new ResultSetMapperTEvent<ModelTEventExt>());

    public DaoTEventExt(Class<ModelTEventExt> modelTEventExtClass, ResultSetMapperTEvent<ModelTEventExt> modelTEventExtResultSetMapperTEvent) {
        super(modelTEventExtClass, modelTEventExtResultSetMapperTEvent);
    }

    public static void main(String[] args) {
        List<ModelTEventExt> byCond = ext.getByCond(new ModelTEventExt().setDeviceArixX(0));
    }
}
