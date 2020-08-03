package com.shawn.ss.lib.code_gen;

//import com.sample.UserDTO;
//import com.shawn.ss.lib.code_gen.base.dao.conf.SelectMethodEnum;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.tools.CollectionHelper;
import org.junit.Test;

import java.util.Set;

public class CodeTest {
    @Test
    public void testSqlGen(){
//        SQLSelect select = SQL.buildSelectSql("table").items(UserDTO.).setLimit();
//        System.out.println(select.getSql(null));
        String chars="ccccccccc";
        encrypt(chars);
    }

    @Test
    public void testMethods(){
        Set<Object> set = CollectionHelper.setBuilder(true).addAll(SelectMethodEnum.getAllSelectMethod().keySet()).getSet();
        System.out.println(set.size());
        System.out.println(set);
    }

    private void encrypt(String chars) {
        StringBuilder ret=new StringBuilder("");
        int[] secret=new int[]{1,4,7};
        char[] res=new char[3];
        for(int i=0;i<chars.length();++i){
            int n=i%3;
            res[n]=(char)((chars.charAt(i)+secret[n])%128);
            if(n==2){
                ret.append(res[1]).append(res[2]).append(res[0]);
            }
        }
//        ret.append(res);
        System.out.println(ret);
    }

    @Test
    public void testSqlGen0(){
//        SQLSelect select = SQL.buildSelectSql("table").items(UserDTO.).setLimit();
//        System.out.println(select.getSql(null));
        String chars="it is a secret";
        StringBuilder ret=new StringBuilder("");

        char[] res=new char[3];
        for(int i=0;i<chars.length();++i){
            int n=i%3;
            res[n]=(char)((chars.charAt(i)+1)%128);
            if(n==2){
                ret.append(res[1]).append(res[2]).append(res[0]);
            }
        }
        ret.append(res);
        System.out.println(ret);
    }


    @Test
    public void testg(){
//        SQLSelect select = SQL.buildSelectSql("table").items(UserDTO.).setLimit();
//        System.out.println(select.getSql(null));
        String chars="it is a secret";
        StringBuilder ret=new StringBuilder("");

        for(int i=0;i<chars.length();++i){
           ret.append((char)(chars.charAt(i)+1));

        }

        System.out.println(ret);
//        print(new Integer(1));
    }

//    void print (Integer ... a){
//
//    }
//    void print(Number a){
//
//    }
//    void print(Object a){
//
//    }
}
