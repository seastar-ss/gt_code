package com.shawn.ss.lib.tools.db.impl.data_source;

import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class TableStategy implements InitializingBean {
    Pattern NUM_PATTERN = Pattern.compile("\\d+");

    Set<String> volatileTable;
    Set<String> volatileTablePattern;

    Set<String> changeLessTable;
    Set<String> changelessTablePattern;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (volatileTable == null) {
            volatileTable = new HashSet<>();
        }
        if (changeLessTable == null) {
            changeLessTable = new HashSet<>();
        }
        if (changelessTablePattern != null) {
            for (String s : changelessTablePattern) {
                Set<String> tables = buildTableWithPattern(s);
                changeLessTable.addAll(tables);
            }
        }
        if (volatileTablePattern != null) {
            for (String s : volatileTablePattern) {
                Set<String> tables = buildTableWithPattern(s);
                volatileTable.addAll(tables);
            }
        }
    }

    private Set<String> buildTableWithPattern(String s) {
        Set<String> ret = new HashSet<>();
        String[] split = s.split(",");
        addTbGenByNumberToSet(split, ret);
        return ret;
    }

    private void addTbGenByNumberToSet(String[] split, Set<String> ret) {
        if (split.length == 3 && NUM_PATTERN.matcher(split[1]).matches() && NUM_PATTERN.matcher(split[2]).matches()) {
            int start = Integer.parseInt(split[1]);
            int end = Integer.parseInt(split[2]);
            for (int i = start; i < end; ++i) {
                ret.add(split[0] + i);
            }
        }
    }

    public Set<String> getChangeLessTable() {
        return changeLessTable;
    }

    public void setChangeLessTable(Set<String> changeLessTable) {
        this.changeLessTable = changeLessTable;
    }

    public Set<String> getChangelessTablePattern() {
        return changelessTablePattern;
    }

    public void setChangelessTablePattern(Set<String> changelessTablePattern) {
        this.changelessTablePattern = changelessTablePattern;
    }

    public Set<String> getVolatileTable() {
        return volatileTable;
    }

    public void setVolatileTable(Set<String> volatileTable) {
        this.volatileTable = volatileTable;
    }

    public Set<String> getVolatileTablePattern() {
        return volatileTablePattern;
    }

    public void setVolatileTablePattern(Set<String> volatileTablePattern) {
        this.volatileTablePattern = volatileTablePattern;
    }
}
