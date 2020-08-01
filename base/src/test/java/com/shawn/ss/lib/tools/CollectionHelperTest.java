package com.shawn.ss.lib.tools;

//import org.apache.commons.net.imap.IMAPClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by ss on 2017/10/3.
 */
public class CollectionHelperTest {
    static final Logger L = LoggerFactory.getLogger(CollectionHelperTest.class.getSimpleName());

    @Test
    public void testGenMapSetList() {
        Map<Object, Object> tst = new HashMap<>();
        tst.put("a", "b");
        tst.put("what", "test");

        Collection c = new ArrayList<>();
        c.add("x");
        c.add("y");

        Map<Object, Object> map = CollectionHelper.mapBuilder().put("", "").put("haha", "test").put("what", "is").putAll(tst).getMap();
        String concat = StringHelper.concat("\n", map);
        L.info("map built is : {}", concat);
//        assertEquals(":\n" +
//                "haha:test\n" +
//                "what:test\n" +
//                "a:b",concat);

        Set set = CollectionHelper.setBuilder().add("1").add(1).add(1, 2, 3, "12bn").add(c).addAll(c).getSet();
        concat = StringHelper.concat("\n", set);
        L.info("set built is : {}", concat);
//        assertEquals("1\n" +
//                "1\n" +
//                "2\n" +
//                "[x\n" +
//                "y]\n" +
//                "3\n" +
//                "x\n" +
//                "y\n" +
//                "12bn",concat);

        List list = CollectionHelper.listBuilder().add("b").add("2018", "12345").add(c).addAll(c).getList();
        concat = StringHelper.concat("\n", list);
        L.info("list built is : {}", concat);
//        assertEquals("b\n" +
//                "2018\n" +
//                "12345\n" +
//                "[x\n" +
//                "y]\n" +
//                "x\n" +
//                "y",concat);
    }

}
