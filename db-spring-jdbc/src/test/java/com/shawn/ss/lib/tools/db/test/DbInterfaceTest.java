package com.shawn.ss.lib.tools.db.test;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.db.impl.DbManager;
import com.shawn.ss.lib.tools.db.impl.utils.HelperFactory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class DbInterfaceTest {

    public static Logger L = LoggerFactory.getLogger(DbInterfaceTest.class);
    static ResourceBundle bundle=ResourceBundle.getBundle("db");
    static DbManager manager;
    static final String insertSql="INSERT INTO `t_user_lesson_attendtime_statistic_00`\n" +
            "(\n" +
            "`user_id`,\n" +
            "`teach_unit_id`,\n" +
            "`lesson_type`,\n" +
            "`round_id`,\n" +
            "`package_ids`,\n" +
            "`subject_ids`,\n" +
            "`attend_time`)\n" +
            "VALUES\n" +
            "(\n" +
            ":name,\n" +
            ":tid,\n" +
            ":type,\n" +
            ":rid,\n" +
            ":pid,\n" +
            ":sid,\n" +
            ":time);";
    @Before
    public void buildEnvirontment(){
        System.out.println(bundle.getString("db.url"));
        DBConnectionHelper helper=new DBConnectionHelper(
                bundle.getString("db.url"),
                bundle.getString("db.userName"),
                bundle.getString("db.password"),
                bundle.getString("db.driverClassName")
        );
        manager=new DbManager(helper.conn);
    }

    @Test
    public void testTableExist(){
        boolean info = HelperFactory.getTbHelper(manager).checkTableExist("t_user_info");
        L.info("result of table tb t_user_info:{}",info);
        info = HelperFactory.getTbHelper(manager).checkTableExist("ent_portal.t_user_info");
        L.info("result of table tb t_user_info:{}",info);
        info = HelperFactory.getTbHelper(manager).checkTableExist("t_not_exist_table");
        L.info("result of table tb t_user_info:{}",info);
    }

    @Test
    public void testTableCreate(){
        final String table = HelperFactory.getTbHelper(manager).createTable("t_user_info", "_19bak");
        L.info("create table :{}",table);
        boolean info = HelperFactory.getTbHelper(manager).checkTableExist("t_user_info_19bak");
        L.info("result of table tb t_user_info:{}",info);
    }

    @Test
    public void testExecute(){
        final List<Map<String, Object>> maps = manager.queryForList("select * from t_user_info where mobile in ('15901027363')", Collections.<String, Object>emptyMap());
        L.info("run result:{}",maps);
//        final boolean execute1 = manager.execute("DROP TABLE `test`;");
//        System.out.println("execute:"+ execute+ ","+execute1);
    }
    //UPDATE t_survey_record set opinion='课太少 没教材 没人牵着走 感觉一点知识都没学到;老师认真负责' where id=1309147;

//    @Test
    public void testUpdateNoExecute(){
        final int update = manager.update("UPDATE t_survey_record set opinion='课太少' 没教材 没人牵着走 感觉一点知识都没学到;老师认真负责' where id=1309147;", Collections.<String, Object>emptyMap());
        L.info("run result:{}",update);
//        final boolean execute1 = manager.execute("DROP TABLE `test`;");
//        System.out.println("execute:"+ execute+ ","+execute1);
    }

//    @Test
    public void testRunFlushData() throws Exception{
        File foler=new File("C:\\Users\\seast\\Desktop\\for-report\\new_user_issue");
        final File[] files = foler.listFiles();
        for(File af:files){
            if(af.getName().endsWith(".txt")) {
                L.info("handle file :{}", af.getAbsolutePath());
                File wrFile = new File(foler, "wr" + af.getName()+"ss");
                BufferedWriter wr = new BufferedWriter(new FileWriter(wrFile));
                BufferedReader rd = new BufferedReader(new FileReader(af));
                String line;
                String preline = null;
                int ii = 0;
                while ((line = rd.readLine()) != null) {
                    L.info("read line :{}",line);
                    if (line.trim().startsWith("1")) {
                        final String[] split = line.split(",");
                        if (split.length >= 2) {
                            String s1=split[0].trim();
                            String s2=split[1].trim();
                            final String s = manager.queryForObject(
                                    "SELECT group_concat(distinct mobile) mobile FROM ent_portal_prod.t_user_code where mobile like :str",
                                    Collections.singletonMap("str", s1.replace("****", "%")),
                                    String.class);
                            List<Map<String, Object>> maps = manager.queryForList(
                                    "select id,nickname,username,create_time_of_user,add_type,update_time from t_user_info where mobile=:mobile",
                                    Collections.<String, Object>singletonMap("mobile",s2));
                            wr.write(line);
                            wr.write(",");
                            wr.write(s==null?"":s);
                            L.info("get :{} ,{}",s,maps);
                            if(maps!=null && maps.size()>0) {
                                final Map<String, Object> map = maps.get(0);
                                wr.write(StringHelper.concat(
                                        ",", map.get("id"),
                                        ",",map.get("nickname"),
                                        ",",map.get("username"),
                                        ",",map.get("create_time_of_user"),
                                        ",",map.get("add_type"),
                                        ",",map.get("update_time")
                                ));
                            }
                            wr.newLine();
                        }
                    }
                }
                wr.flush();
                wr.close();
                rd.close();
            }
        }
    }

//    @Test
    public void testBatchInsert(){
        Random rnd=new Random(System.currentTimeMillis());
        int i = manager.batchInsert(insertSql, null);
        System.out.println(i);
        i = manager.batchInsert(insertSql, Collections.<Map<String,Object>>emptyList());
        System.out.println(i);
        i = manager.batchInsert(insertSql, CollectionHelper.<Map<String,Object>>listBuilder()
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .getList());
        System.out.println(i);

        i = manager.batchInsert(insertSql, CollectionHelper.<Map<String,Object>>listBuilder()
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .add(CollectionHelper.<String,Object>mapBuilder()
                        .put("name",rnd.nextInt(100))
                        .put("tid",rnd.nextInt(10000))
                        .put("type",rnd.nextInt(10))
                        .put("rid",rnd.nextInt(250000))
                        .put("pid",rnd.nextInt(1250000))
                        .put("sid",rnd.nextInt(1250000))
                        .put("time",rnd.nextInt(250000))
                        .getMap())
                .getList());
        System.out.println(i);
    }
}
