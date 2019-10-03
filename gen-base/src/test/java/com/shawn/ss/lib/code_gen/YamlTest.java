package com.shawn.ss.lib.code_gen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class YamlTest {
    Pattern p= Pattern.compile("[0-9]");
//    @Test


    @Test
    public void testIter(){
        List<Integer> ii=new ArrayList<>();
        ii.add(1);
        ii.add(2);
        for(Integer i : ii){
            System.out.println(i);
        }
    }
}
