package com.shawn.ss.lib.tools.db.impl.dao;

import com.shawn.ss.lib.tools.db.dto_base.model.AbstractBaseModel;

public interface JoinableDao <Ty extends AbstractBaseModel>  extends _AssembleDaoInterface<Ty>,_InSelectDaoInterface<Ty> {

}
