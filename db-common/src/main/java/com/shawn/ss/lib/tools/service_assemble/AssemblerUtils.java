package com.shawn.ss.lib.tools.service_assemble;

import com.shawn.ss.lib.tools.service_assemble.utils.SortAssembler;

/**
 * Created by ss on 2018/10/5.
 */
public class AssemblerUtils {
    public static final BaseDaoAssembler defaultAssembler=new BaseDaoAssembler();

    public static DaoAssembler baseDaoAssembler(){
        return defaultAssembler;
    }

    public static SortAssembler sortAssembler(String[] ascSortFields,String[] descSortFields){
        return new SortAssembler(ascSortFields,descSortFields);
    }

    public static SortAssembler sortAssembler(){
        return new SortAssembler();
    }
}
