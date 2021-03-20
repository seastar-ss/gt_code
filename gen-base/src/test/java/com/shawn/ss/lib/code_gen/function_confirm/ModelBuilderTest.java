package com.shawn.ss.lib.code_gen.function_confirm;

//import com.shawn.ss.lib.code_gen.base.dao.common_dao.common_model_builder.ModelBuilder;

//import com.shawn.ss.lib.code_gen.base.dao.conf.SelectMethodEnum;

import com.shawn.ss.gen.api.conf.SelectMethod;
import com.shawn.ss.gen.api.conf.SelectMethodEnum;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.conf_factory.MultiModelConfFactory;
import com.shawn.ss.lib.code_gen.model.gen_param_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ModelBuilderTest {
    static final Logger L = LoggerFactory.getLogger(ModelBuilderTest.class.getSimpleName());

    static Collection<SelectMethod> list = CollectionHelper.<SelectMethod>listBuilder()
            .add(SelectMethodEnum.getAll)
            .add(SelectMethodEnum.getByCondition)
            .add(SelectMethodEnum.getByIndex)
            .add(SelectMethodEnum.getOneById)
            .add(SelectMethodEnum.getOneByCondtion)
            .add(SelectMethodEnum.getByIndexAndCondition)
            .getList();

    @Test
    public void testGenMigrationModel() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("db.properties"));
        final String TEST_POS_DEV = "/Users/shishengb18701shishengcorp.netease.com/Documents/project/server_for_work/omap_migration_tool/src/main/java";
        ModelBuilderContext modelBuilderContext = ModelBuilderContext.newInstance("com.netease.cowork.tools.ynote.omap_migration_tool", TEST_POS_DEV);
        DBConnectionHelper connectionMaster = modelBuilderContext.buildConnection("main_schema",
                p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb(connectionMaster, new DbModelConf().setSlave(false)
                .setDb("data_migration")
                .setIgnoreTbPattern(CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()));
        modelBuilderContext.executeInitBaseClazz();
        modelBuilderContext.executeBaseModelAndDaoBuild();
        modelBuilderContext.executeWriteModel();
    }

    @Test
    public void testGenColorQueryModel() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("db.properties"));
        final String TEST_POS_DEV = "/Users/shishengb18701shishengcorp.netease.com/Documents/project/otherProject/quick_image/es/java/FE_Base_v1/src/main/java";
        ModelBuilderContext modelBuilderContext = ModelBuilderContext.newInstance("com.kewei.main_data.color_query", TEST_POS_DEV);
        DBConnectionHelper connectionMaster = modelBuilderContext.buildConnection("main_schema",
                p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb(connectionMaster, new DbModelConf().setSlave(false)
                        .setDb("ai_designer").setPrefix("")
//                .setIgnoreTbPattern(CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet())
        );
        modelBuilderContext.executeInitBaseClazz();
        modelBuilderContext.executeBaseModelAndDaoBuild();
        modelBuilderContext.executeWriteModel();
    }

    @Test
    public void testGenSqlDbModel() throws IOException {
        Properties p = new Properties();
        p.load(new FileReader("db-ny.properties"));
        final String TEST_POS_DEV = "D:\\docs\\work_doc\\project\\own_project\\gt_code\\compilor-test\\src\\main\\gen_code\\java";
        ModelBuilderContext modelBuilderContext = ModelBuilderContext.newInstance("com.shawn.gen_lib.test", TEST_POS_DEV);
        DBConnectionHelper connectionMaster = modelBuilderContext.buildConnection("main_schema",
                p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );

        final Set<String> set = CollectionHelper.<String>setBuilder()
                .add("b_menu")
                .add("b_user")
                .add("b_user_info")
                .add("b_role")
                .add("b_material")
                .add("b_organization")
                .add("b_organization_user")
                .getSet();
        modelBuilderContext.addDb(connectionMaster, new DbModelConf().setSlave(false)
                .setIncludingPattern(
                        set
                )
                .setDb("main_data_schema")
                .setIgnoreTbPattern(CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()));
        DBConnectionHelper connection = modelBuilderContext.buildConnection("main_schema_slave",
                p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb(connection, new DbModelConf().setSlave(true)
                .setIncludingPattern(
                        set
                )
                .setDb("main_schema")
                .setIgnoreTbPattern(CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()));
        DBConnectionHelper wikiconnection = modelBuilderContext.buildConnection("wiki_master",
                p.getProperty("ent_activities.jdbc.url"), p.getProperty("ent_activities.jdbc.username"),
                p.getProperty("ent_activities.jdbc.password"),
                p.getProperty("jdbc.driverClassName")
        );
        modelBuilderContext.addDb(wikiconnection, new DbModelConf().setSlave(false)
                .setIncludingPattern(
                        CollectionHelper.<String>setBuilder()
                                .add("t_device")
                                .add("t_event")
                                .add("t_task")
                                .add("t_device_task")
                                .add("t_mall_area")
                                .getSet()
                ).setDb("robot_control_system")
                .setIgnoreTbPattern(
                        CollectionHelper.<String>setBuilder().add("ent_.*").add(".*\\d+$").getSet()
                )
        );
        modelBuilderContext.executeInitBaseClazz();
        modelBuilderContext.executeBaseModelAndDaoBuild();

        MultiModelConfFactory test = MultiModelConfFactory.newInstance("UserAndOrg", "test", list);
        test.addMainTable("orgUser", "main_data_schema", "b_organization_user");
        //        test.addRelatedTable("user", "main_data_schema.b_user.id=main_data_schema.b_organization_user.user_id", true, 1000);
        test.addRelatedTable(
                "org",
                "main_data_schema.b_organization.id=main_data_schema.b_organization_user.org_id",
                true,
                1000
        );

        MultiModelConfFactory testV2 = MultiModelConfFactory.newInstance("TaskAndEventOfDevice", "testV2", list);
        testV2.addMainTable("device", "robot_control_system", "t_device");
        testV2.addRelatedTable(
                "tasks",
                "robot_control_system.t_device.id=robot_control_system.t_device_task.device_id",
                false,
                10
        );
        testV2.addRelatedTable(
                "events",
                "robot_control_system.t_device.id=robot_control_system.t_event.event_device",
                false,
                10,
                CollectionHelper.<String, String>mapBuilder()
                        .put("device_type", "event_device_type")
                        .getMap(),
                " id>0 "
        );

        test.buildConf(modelBuilderContext);
        MultiModelConfFactory testV3 = MultiModelConfFactory.newInstance("userRoleAndOrg", "testV3", list);
        testV3.addMainTable("user", "main_data_schema", "b_user");
        testV3.addRelatedMultiDao(
                "userOrg",
                "main_data_schema.b_user.id=main_data_schema.b_organization_user.user_id",
                "UserAndOrg",
                false,
                -1
        );
        testV3.addRelatedTable(
                "info",
                "main_data_schema.b_user_info.user_id=main_data_schema.b_user.id",
                false,
                1000
        );

        modelBuilderContext.executeMultiModelAndDaoBuild();

        modelBuilderContext.executeWriteModel();
    }
}
