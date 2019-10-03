package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;
import com.shawn.ss.lib.tools.service_assemble.AbstractMultipleDaoAssembler;
import com.shawn.ss.lib.tools.service_assemble.DaoAssembler;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface _ComplexUpdateDaoInterface<Ty extends AbstractBaseModel> {

    @Transactional
    Ty updateOrInsert(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler);

    Ty updateOrInsert(Ty instance, Set<String> conditionField);

    @Transactional
    Ty insertIfNoExist(Ty instance, Set<String> conditionField, AbstractMultipleDaoAssembler assembler);

    Ty insertIfNoExist(Ty instance, Set<String> conditionField);
}
