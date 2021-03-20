package com.shawn.ss.lib.code_gen.base.helper.conf_factory;

import com.shawn.ss.lib.code_gen.base.helper.CodeConstants;
import com.shawn.ss.lib.code_gen.base.helper.DBConnectionHelper;
import com.shawn.ss.lib.code_gen.base.helper.ModelBuilderContext;
import com.shawn.ss.lib.code_gen.base.helper.db_analyzer.DbAnalyzer;
import com.shawn.ss.lib.code_gen.base.helper.data_store.DbDataTable;
import com.shawn.ss.lib.code_gen.model.def_model.dao_def.CommonModelDaoDef;
import com.shawn.ss.lib.code_gen.model.gen_param_model.db_def.DbModelConf;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.DbInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.TableInfoInterface;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.DbInfo;

import java.util.*;

public class CommonModelConfFactory {

    static final DbAnalyzer analyzer;

    static {
        analyzer = new DbAnalyzer();
    }

    private final ModelBuilderContext context;

    DbModelConf conf;

    public static DbAnalyzer getAnalyzer() {
        return analyzer;
    }

    final DBConnectionHelper connection;

    //    String dataSourceId;
    Map<String, TableInfoInterface> tbMaps;
    DbInfoInterface dbInfo;


    private final long uuid;

    {
        uuid = UUID.randomUUID().getMostSignificantBits();
    }

    public CommonModelConfFactory(DBConnectionHelper connection, boolean isSlave, ModelBuilderContext context) {
        this(connection, new DbModelConf().setSlave(isSlave), context);
        //        this.dataSourceId=connection.getDataSourceId();
    }

    public CommonModelConfFactory(DBConnectionHelper connection, DbModelConf conf, ModelBuilderContext context) {
        this.context = context;
        tbMaps = CollectionHelper.newMap();
        this.connection = connection;
        this.conf = conf;
        //        this.isSlave = isSlave;
        if (conf.getDb() != null) {
            setDb(conf.getDb(), conf.getIncludingPattern(), conf.getIgnoreTbPattern());
        }
        //        this.dataSourceId=connection.getDataSourceId();
    }

    public DBConnectionHelper getConnection() {
        return connection;
    }

    public String getDb() {
        return conf.getDb();
    }

    //    public DbInfoHandler setDb() {
    //        setDb(null, null, null);
    //        return this;
    //    }

    //    public DbInfoHandler setDb(String db) {
    //
    //        setDb(db, null, null);
    //        return this;
    //    }

    //    public DbInfoHandler setDb(String db, Set<String> excluding) {
    //        setDb(db, null, excluding);
    //        return this;
    //    }


    public CommonModelConfFactory setConf(DbModelConf conf) {
        this.conf = conf;
        if (conf.getDb() != null)
            setDb(conf.getDb(), conf.getIgnoreTbPattern(), conf.getIncludingPattern());
        return this;
    }

    protected CommonModelConfFactory setDb(String db, Set<String> including, Set<String> excluding) {
        if (inited()) {
            throw new IllegalStateException("已经初始化此实例：" + db);
        }
        String dataSourceId = connection.getDataSourceId();
        if (StringHelper.isEmpty(dataSourceId)) {
            dataSourceId = CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
        }
        this.conf.setDb(db);
        //        if (!dataSourceId.startsWith(data_store)) {
        //            if (StringHelper.isEmpty(dataSourceId)) {
        ////                dataSourceId=data_store;
        //                dataSourceId = CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID;
        //            } else if (!dataSourceId.equals(CodeConstants.KEY_WORD_DEFAULT_DATA_SOURCE_ID)) {
        //                throw new IllegalStateException("数据库和数据库库datasourceId不匹配，请检查是否配置有误，dataSourceId应以数据库名开头");
        //            }
        //        }
        //        this.db = db;
        if (this.conf.isSlave()) {

        } else {
            this.dbInfo = this.analyzeDb(excluding, including);
            this.tbMaps = this.buildTableMap(dbInfo);
        }
        return this;
    }

    public boolean inited() {
        return conf != null && conf.getDb() != null && dbInfo != null;
    }

    public Map<String, TableInfoInterface> getTbMaps() {
        return new HashMap<>(tbMaps);
    }

    //    public DbInfoHandler setTbMaps(Map<String, TableInfoInterface> tbMaps) {
    //        this.tbMaps = tbMaps;
    //        return this;
    //    }

    public DbInfoInterface getDbInfo() {
        return dbInfo;
    }

    public long getUuid() {
        return uuid;
    }

    //    public DbInfoHandler setDbInfo(DbInfoInterface dbInfo) {
    //        this.dbInfo = dbInfo;
    //        return this;
    //    }

    public int tbSize() {
        return tbMaps.size();
    }

    public boolean isTbEmpty() {
        return tbMaps.isEmpty();
    }

    public boolean containsTbKey(Object key) {
        return tbMaps.containsKey(key);
    }

    public TableInfoInterface getTb(String key) {
        return tbMaps.get(key);
    }

    public String getDataSourceId() {
        return connection.getDataSourceId();
    }

    //    public TableInfoInterface putTb(String key, TableInfoInterface value) {
    //        return tbMaps.put(key, value);
    //    }

    private DbInfo analyzeDb(Set<String> ignoreTbPattern, Set<String> includingPattern) {
        this.conf.setIgnoreTbPattern(ignoreTbPattern);
        this.conf.setIncludingPattern(includingPattern);
        DbInfo dbInfo;
        final String db = conf.getDb();
        dbInfo = (DbInfo) DbDataTable.getDb(db);
        if (dbInfo == null) {
            dbInfo = new DbInfo(db);
        }
        analyzer.buildModel(
                new DbAnalyzer.BuildModelParamHolder(
                        connection.getConnection(),
                        dbInfo,
                        ignoreTbPattern,
                        includingPattern
                )
        );
        return dbInfo;
    }

    private Map<String, TableInfoInterface> buildTableMap(DbInfoInterface db) {
        List<TableInfoInterface> tables = db.getTables();
        Map<String, TableInfoInterface> tbMap = CollectionHelper.newMap();
        for (TableInfoInterface tb : tables) {
            final Set<String> ignoreTbPattern = conf.getIgnoreTbPattern();
            final Set<String> includingPattern = conf.getIncludingPattern();
            if ((conf.getIgnoreTbPattern() == null && conf.getIncludingPattern() == null) ||
                    !CodeConstants.testIgnore(tb.getTable(), conf.getIgnoreTbPattern(), conf.getIncludingPattern())) {
                tbMap.put(tb.getTable(), tb);
            }
        }
        return tbMap;
    }

    /*
        public CommonModelDaoDef getDefs(String table) {
            CommonModelDaoDef ret = null;
            String dbName = getDb();
            List<String> dataSources = DbDataTable.getAllSlaveSourceNameByName(dbName);
            final String defaultAssemblerClass = conf.getDefaultAssemblerClass();
            final String defaultBaseDaoClass = conf.getDefaultBaseDaoClass();
            final TableInfoInterface tableInfo = getTbMaps().get(table);
            if (tableInfo != null) {
                String baseDaoClass = defaultBaseDaoClass;
                String assembleClass = defaultAssemblerClass;
                if (conf.getBaseDaoClass(table) != null) {
                    baseDaoClass = conf.getBaseDaoClass(table);
                }
                if (conf.getAssembleClass(table) != null) {
                    assembleClass = conf.getAssembleClass(table);
                }
    //            String table = tableInfo.getTable();
    //            String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
                final CommonModelDaoDef commonModelDaoDef = new CommonModelDaoDef(tableInfo, context)
    //                    .setDef(tableInfo)
                        .setBaseTable(null)
                        .setBuildMapper(true)
    //                    .setIgnoreField(null)
                        .setDataSourceName(getDataSourceId())
                        .setAssemblerExtendClzName(assembleClass)
                        .setDaoExtendClzName(baseDaoClass);
    //            if (dataSources != null) {
    //                commonModelDaoDef.setDataSourceNames(dataSources);
    //            }
            }
            return ret;
        }
    */
    public List<CommonModelDaoDef> buildDefs() {

        List<CommonModelDaoDef> defs = CollectionHelper.newList();
        String dbName = getDb();
        List<String> dataSources = DbDataTable.getAllSlaveSourceNameByName(dbName);
        Collection<TableInfoInterface> tables = getTbMaps().values();
        final String defaultAssemblerClass = conf.getDefaultAssemblerClass();
        final String defaultBaseDaoClass = conf.getDefaultBaseDaoClass();
        for (TableInfoInterface tableInfo : tables) {
            final String table = tableInfo.getTable();
            String baseDaoClass = defaultBaseDaoClass;
            String assembleClass = defaultAssemblerClass;
            if (conf.getBaseDaoClass(table) != null) {
                baseDaoClass = conf.getBaseDaoClass(table);
            }
            if (conf.getAssembleClass(table) != null) {
                assembleClass = conf.getAssembleClass(table);
            }
            //            String table = tableInfo.getTable();
            //            String modelSimpleName = CodeStyleTransformHelper.underlineSplittedStyleToHumpStyle(table);
            final CommonModelDaoDef commonModelDaoDef = new CommonModelDaoDef(tableInfo, context);
            //                    .setDef(tableInfo)
            commonModelDaoDef.setBaseTable(null);
            commonModelDaoDef.setBuildMapper(true);
            commonModelDaoDef.setDataSourceName(getDataSourceId());
            commonModelDaoDef.setAssemblerExtendClzName(assembleClass);
            commonModelDaoDef.setDaoExtendClzName(baseDaoClass);
            commonModelDaoDef.setMapperClzName(CodeConstants.getRSMapperClassName(context.getBasePackage(), table));
            commonModelDaoDef.setPojoMapperClzName(CodeConstants.getMapMapperClassName(context.getBasePackage(), table));
            commonModelDaoDef.setDaoClzName(CodeConstants.getDaoClassName(context.getBasePackage(), table, null, CodeConstants.TYPE_TABLE_COMMON_TYPE));
            commonModelDaoDef.setDbInstancePrefix(conf.getPrefix());

            if (dataSources != null) {
                commonModelDaoDef.setDataSourceNames(dataSources);
            }
            defs.add(commonModelDaoDef);
        }
        return defs;
    }

    public boolean isSlave() {
        return conf.isSlave();
    }

    public DbModelConf getConf() {
        return conf;
    }

    //    public DbInfoHandler setSlave(boolean slave) {
    //        isSlave = slave;
    //        return this;
    //    }
    //
    //    public String getMasterDbName() {
    //        return masterDbName;
    //    }
    //
    //    public DbInfoHandler setMasterDbName(String masterDbName) {
    //        this.masterDbName = masterDbName;
    //        return this;
    //    }

    @Override
    public String toString() {
        return "DbInfoHandler{" +
                "data_store='" + conf + '\'' +
                ", tbMaps=" + tbMaps.keySet() +
                ", uuid=" + uuid +
                '}';
    }
}
