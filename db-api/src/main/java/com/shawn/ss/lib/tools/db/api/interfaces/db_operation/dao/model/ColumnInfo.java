package com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model;

import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.ColumnInfoInterface;

import java.util.Properties;

/**
 * Created by ss on 2017/10/11.
 */
public class ColumnInfo extends FieldInfo implements ColumnInfoInterface {
    String extra;
    boolean nullable, prime, unique, referer, indexed, autoIncreament;
    String charSet;
    long charLength;
    int precision;
    Properties extraInfo;
    String table;
    String db;
    TableInfo info;

    public ColumnInfo() {
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Override
    public String getExtra() {
        return extra;
    }

    public ColumnInfo setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    public ColumnInfo setNullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    @Override
    public boolean isPrime() {
        return prime;
    }

    public ColumnInfo setPrime(boolean prime) {
        this.prime = prime;
        return this;
    }

    @Override
    public boolean isUnique() {
        return unique;
    }

    public ColumnInfo setUnique(boolean unique) {
        this.unique = unique;
        return this;
    }

    @Override
    public boolean isReferer() {
        return referer;
    }

    public ColumnInfo setReferer(boolean referer) {
        this.referer = referer;
        return this;
    }

    @Override
    public boolean isIndexed() {
        return indexed;
    }

    public ColumnInfo setIndexed(boolean indexed) {
        this.indexed = indexed;
        return this;
    }

    @Override
    public boolean isAutoIncreament() {
        return autoIncreament;
    }

    public ColumnInfo setAutoIncreament(boolean autoIncreament) {
        this.autoIncreament = autoIncreament;
        return this;
    }

    @Override
    public String getCharSet() {
        return charSet;
    }

    public ColumnInfo setCharSet(String charSet) {
        this.charSet = charSet;
        return this;
    }

    @Override
    public long getCharLength() {
        return charLength;
    }

    public ColumnInfo setCharLength(long charLength) {
        this.charLength = charLength;
        return this;
    }

    @Override
    public int getPrecision() {
        return precision;
    }

    public ColumnInfo setPrecision(int precision) {
        this.precision = precision;
        return this;
    }

    @Override
    public Properties getExtraInfo() {
        return extraInfo;
    }

    public ColumnInfo setExtraInfo(Properties extraInfo) {
        this.extraInfo = extraInfo;
        return this;
    }

    @Override
    public TableInfo getInfo() {
        return info;
    }

    public ColumnInfo setInfo(TableInfo info) {
        this.info = info;
        return this;
    }

}
