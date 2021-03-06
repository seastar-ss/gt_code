package com.shawn.ss.lib.code_gen.model.gen_param_model.db_def;

import java.util.Map;
import java.util.Set;

public class DbModelConf {
    String db;
    private Set<String> ignoreTbPattern;
    private Set<String> includingPattern;
    boolean isSlave;
    String masterDbName;
    String defaultAssemblerClass;
    String defaultBaseDaoClass;
    private Map<String,String> baseDaoClass;
    private Map<String,String> baseAssembleClass;
    private String prefix;

    public DbModelConf() {
    }

    public String getDefaultBaseDaoClass() {
        return defaultBaseDaoClass;
    }

    public DbModelConf setDefaultBaseDaoClass(String defaultBaseDaoClass) {
        this.defaultBaseDaoClass = defaultBaseDaoClass;
        return this;
    }

    public Set<String> getIgnoreTbPattern() {
        return ignoreTbPattern;
    }

    public DbModelConf setIgnoreTbPattern(Set<String> ignoreTbPattern) {
        this.ignoreTbPattern = ignoreTbPattern;
        return this;
    }

    public Set<String> getIncludingPattern() {
        return includingPattern;
    }

    public DbModelConf setIncludingPattern(Set<String> includingPattern) {
        this.includingPattern = includingPattern;
        return this;
    }

    public boolean isSlave() {
        return isSlave;
    }

    public DbModelConf setSlave(boolean slave) {
        isSlave = slave;
        return this;
    }

    public String getMasterDbName() {
        return masterDbName;
    }

    public DbModelConf setMasterDbName(String masterDbName) {
        this.masterDbName = masterDbName;
        return this;
    }

    public String getDb() {
        return db;
    }

    public DbModelConf setDb(String db) {
        this.db = db;
        return this;
    }

    public String getDefaultAssemblerClass() {
        return defaultAssemblerClass;
    }

    public DbModelConf setDefaultAssemblerClass(String defaultAssemblerClass) {
        this.defaultAssemblerClass = defaultAssemblerClass;
        return this;
    }

    public Map<String, String> getBaseDaoClass() {
        return baseDaoClass;
    }

    public DbModelConf setBaseDaoClass(Map<String, String> baseDaoClass) {
        this.baseDaoClass = baseDaoClass;
        return this;
    }

    public Map<String, String> getBaseAssembleClass() {
        return baseAssembleClass;
    }

    public DbModelConf setBaseAssembleClass(Map<String, String> baseAssembleClass) {
        this.baseAssembleClass = baseAssembleClass;
        return this;
    }

    public int sizeOfAssembleClass() {
        return baseAssembleClass==null?0:baseAssembleClass.size();
    }

    public String getAssembleClass(Object key) {
        return baseAssembleClass==null?null:baseAssembleClass.get(key);
    }

    public int sizeOfBaseDaoClass() {
        return baseDaoClass==null?0:baseDaoClass.size();
    }

    public String getBaseDaoClass(Object key) {
        return baseDaoClass==null?null:baseDaoClass.get(key);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DbModelConf{");
        sb.append("db='").append(db).append('\'');
        sb.append(", ignoreTbPattern=").append(ignoreTbPattern);
        sb.append(", includingPattern=").append(includingPattern);
        sb.append(", isSlave=").append(isSlave);
        sb.append(", masterDbName='").append(masterDbName).append('\'');
        sb.append(", defaultAssemblerClass='").append(defaultAssemblerClass).append('\'');
        sb.append(", defaultBaseDaoClass='").append(defaultBaseDaoClass).append('\'');
        sb.append(", daoExtendClzName=").append(baseDaoClass);
        sb.append(", baseAssembleClass=").append(baseAssembleClass);
        sb.append('}');
        return sb.toString();
    }

    public DbModelConf setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }
}
