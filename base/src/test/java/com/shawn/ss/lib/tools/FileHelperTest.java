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
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ss on 2017/10/3.
 */
public class FileHelperTest {

    static final Logger L = LoggerFactory.getLogger(FileHelperTest.class.getSimpleName());

    final String[] texts = {"1234567890我是测试abc!@#", "~!@##$%^&*()_+|=-{}[]';l<>?,./`1234567890qwertyuiopasdfghjklzxcvbnm中文字符、！~·@#￥%……%……&*（）——+【】{}《》，。？、：；‘“”’",
            "这是一段长文本文本\n" +
                    "1234567890我是测试abc!@#1234567890我是测试abc!@#1234567890我是测试abc!@#1234567890" +
                    "我是测试abc!@#1234567890我是测试abc!@#1234567890我是测试abc!@#1234567890" +
                    "我是测试abc!@#1234567890我是测试abc!@#1234567890我是测试abc!@#"};

    @Test
    public void testWriteFile() {
        try {
//            File af = new File("test.txt");
//            Path path = Paths.get(af.getAbsolutePath());
//
//            FileHelper.writeStrToFile(texts[0], af);
//            List<String> strings1 = Files.readAllLines(path);
//            L.info("file content after write: \n {}", StringHelper.concat(strings1));
//            assertEquals(strings1.get(0), texts[0]);
//
//            FileHelper.writeStrToFile(texts[1], "test.txt", false);
//            List<String> strings2 = Files.readAllLines(path);
//            L.info("file content after write: \n {}", StringHelper.concat(strings2));
//            assertEquals(strings2.get(0), texts[1]);
//
//            FileHelper.writeStrToFile(texts[2], "test.txt", true);
//            List<String> strings3 = FileHelper.readTextFile(path.toFile(),Integer.MAX_VALUE);
//            String concat = StringHelper.concat("\n",strings3);
//            L.info("file content after write: \n {}",concat );
//            assertEquals(concat, texts[1] + texts[2]);
//
//            Files.delete(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadFile(){
        File af = new File("test.txt");
        Path path = Paths.get(af.getAbsolutePath());

        String repeat = StringHelper.repeat(texts[2], 50);
        byte[] bytes1 = repeat.getBytes();
        try {
            FileHelper.writeStrToFile(repeat,af);

            byte[] bytes = FileHelper.readFile(af, 0);
            L.info("file content read : \n {}",new String(bytes) );
            assertArrayEquals(bytes1,bytes);

            bytes = FileHelper.readFile(af, 20);
            L.info("file content read : \n {}",new String(bytes) );
            byte[] res=new byte[20];
            System.arraycopy(bytes1,0,res,0,20);
            assertArrayEquals(bytes,res);

            bytes = FileHelper.readFile(af,-20);
            res=new byte[20];
            System.arraycopy(bytes1,bytes1.length-20,res,0,20);
            L.info("file content read : \n {}",new String(bytes));
            assertArrayEquals(bytes,res);
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
