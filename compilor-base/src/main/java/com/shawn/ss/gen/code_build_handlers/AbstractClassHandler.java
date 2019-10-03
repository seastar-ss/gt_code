package com.shawn.ss.gen.code_build_handlers;



import com.helger.jcodemodel.JCodeModel;
import com.shawn.ss.gen.ClassHandler;
import com.shawn.ss.gen.Constants;
import com.shawn.ss.gen.Helpers;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.structure.LoopStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.RoundEnvironment;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

/**
 * Created by ss on 2016/9/21.
 */
public abstract class AbstractClassHandler<T extends AbstractGenConf> implements ClassHandler {
    static Logger L= LoggerFactory.getLogger(AbstractClassHandler.class);
    protected final String name;
    protected boolean genCode;

    private List<T> contexts;

    public AbstractClassHandler(Class<? extends Annotation> clazz) {
        this.name = clazz.getName();
        this.genCode = true;
        contexts= Collections.synchronizedList(CollectionHelper.<T>newList());
    }

    public boolean isGenCode() {
        return genCode;
    }

    public AbstractClassHandler setGenCode(boolean genCode) {
        this.genCode = genCode;
        return this;
    }

    public List<T> getContexts() {
        return contexts;
    }

    public int sizeOfContext() {
        return contexts.size();
    }

    public boolean isContextEmpty() {
        return contexts.isEmpty();
    }

    public boolean addContext(T t) {
        return contexts.add(t);
    }

    //    public AbstractClassHandler setContexts(List<T> contexts) {
//        this.contexts = contexts;
//        return this;
//    }

    public String getName() {
        return name;
    }

    @Override
    public void finishHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {
        if (genCode) {
            String basePack = helpers.options.get(Constants.KEY_BASE_PACKAGE);
            if (basePack == null) {
                throw new IllegalArgumentException("未设置代码生成路径" + Constants.KEY_BASE_PACKAGE);
            }

            AbstractCodeGenerator generator = buildGenerator(basePack, helpers);
            generator.genCode();
            if(status.isLast()) {
                try {
                    generator.beforeWriteCode();
                    generator.writeCode();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected abstract AbstractCodeGenerator buildGenerator(String basePack, Helpers helpers);

    @Override
    public void beforeHandle(RoundEnvironment env, Helpers helpers, LoopStatus status) {
        if(!AbstractCodeGenerator.inited) {
            synchronized (AbstractCodeGenerator.class) {
                final JCodeModel cm = helpers.getCm();
                final String pos = helpers.options.getOrDefault(Constants.KEY_BASE_PACKAGE, "./src/main/java");
                AbstractCodeGenerator.setCm(cm);
                AbstractCodeGenerator.setBasePos(pos);
                L.debug("set gen code base :{},{}", pos, status.getIndex());
                AbstractCodeGenerator.inited=true;
            }
        }
    }
}
