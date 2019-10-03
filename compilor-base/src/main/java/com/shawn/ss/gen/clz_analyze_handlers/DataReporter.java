package com.shawn.ss.gen.clz_analyze_handlers;

import com.google.gson.Gson;
import com.shawn.ss.gen.model.class_structure.ModelParamEntry;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.sunlands.uuid_war.base_service.api.ApiRequester;
import com.sunlands.uuid_war.base_service.dto.InputInfo;
import com.sunlands.uuid_war.base_service.dto.basepo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class DataReporter implements DataReporterInterface {
    static final Logger L = LoggerFactory.getLogger(DataReporter.class);

    Gson gson = new Gson();

    @Override
    public void reportData(String url,ModelPackageData dt){
        final String comment = dt.getComment();
        final String name = dt.getName();
        Integer pid = ApiRequester.addInfo(
                url,
                new InputInfo()
                        .setType("package")
                        .setPackageData(
                                new ModelTPackage()
                                        .setPackageName(name)
                                        .setCommont(comment)
                        )
        );
        if (!CollectionHelper.isCollectionEmpty(dt.getClz())) {
            final Collection<ModelClzData> values = dt.getClz().values();
            for (ModelClzData clzData : values) {
                final String key = clzData.getKey();
                final String clzDataComment = clzData.getComment();
                final String clzDataName = clzData.getName();
                Integer cid = ApiRequester.addInfo(
                        url,
                        new InputInfo()
                                .setType("class")
                                .setClzData(
                                        new ModelTClass()
                                                .setClassName(clzDataName)
                                                .setCommont(clzDataComment)
                                                .setPackageName(name)
                                                .setKeyStr(key)
                                                .setPackageId(pid)
                                )
                );
                if (!CollectionHelper.isCollectionEmpty(clzData.getFields())) {
                    final Collection<ModelFieldData> fValues = clzData.getFields().values();
                    for (ModelFieldData fieldData : fValues) {
                        final String fieldDataComment = fieldData.getComment();
                        final String fieldDataName = fieldData.getName();
                        final String fieldDataKey = fieldData.getKey();
                        final ModelParamEntry paramInfo = fieldData.getParamInfo();
                        Integer fid = ApiRequester.addInfo(
                                url,
                                new InputInfo()
                                        .setType("prop")
                                        .setPropertyData(
                                                new ModelTProperty()
//                                                            .setPropertyClassName(fieldDataName)
                                                        .setCommont(fieldDataComment)
                                                        .setPropertyName(fieldDataName)
                                                        .setKeyStr(fieldDataKey)
                                                        .setClassId(cid)
                                                        .setPropertyClassName(paramInfo.getClzName())
                                        )
                        );
                    }
                }
                if (!CollectionHelper.isCollectionEmpty(clzData.getMethods())) {
                    final Collection<ModelMethodData> mValues = clzData.getMethods().values();
                    for (ModelMethodData methodData : mValues) {
                        final ModelParamEntry ret = methodData.getRet();
                        final String dataComment = methodData.getComment();
                        final String dataName = methodData.getName();
                        final String methodDataKey = methodData.getKey();
                        Integer mid = ApiRequester.addInfo(
                                url,
                                new InputInfo()
                                        .setType("method")
                                        .setMethodData(
                                                new ModelTMethod()
//                                                            .setPropertyClassName(fieldDataName)
                                                        .setMethodComment(dataComment)
                                                        .setMethodShortName(dataName)
                                                        .setKeyStr(methodDataKey)
                                                        .setClassId(cid)
                                                        .setMethodRetClass(ret.getClzName())
                                        )
                        );
                        L.info("get method type:{}",gson.toJson(ret));
                        if (!CollectionHelper.isCollectionEmpty(methodData.getParams())) {
                            final Collection<ModelParamData> paValues = methodData.getParams().values();
                            for (ModelParamData modelParamData : paValues) {
                                final String paramDataKey = modelParamData.getKey();
                                final ModelParamEntry paramInfo = modelParamData.getParamInfo();
                                final String paramDataComment = modelParamData.getComment();
                                final String paramDataName = modelParamData.getName();
                                Integer paid = ApiRequester.addInfo(
                                        url,
                                        new InputInfo()
                                                .setType("param")
                                                .setParameterData(
                                                        new ModelTParameter()
//                                                            .setPropertyClassName(fieldDataName)
                                                                .setCommont(paramDataComment)
                                                                .setMethodId(mid)
                                                                .setKeyStr(paramDataKey)
                                                                .setClassId(String.valueOf(cid))
                                                                .setParameterClassName(paramInfo.getClzName())
                                                                .setParameterName(paramDataName)
                                                                .setClzType(
                                                                        (paramInfo.isChildrenEmpty() ? "no-field-" : "fields-") + paramInfo.getArrayType().size()
                                                                                + "," + paramInfo.getArrayType() + "," + paramInfo.getDataType().name()
                                                                )
                                                )
                                );
                                L.info("get method arg type:{}",gson.toJson(paramInfo));
                            }
                        }
                    }
                }
                L.info("add class :{}", cid);
            }
        }

    }
}
