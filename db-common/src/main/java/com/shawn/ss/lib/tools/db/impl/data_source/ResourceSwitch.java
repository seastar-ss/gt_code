package com.shawn.ss.lib.tools.db.impl.data_source;

import org.springframework.core.NamedInheritableThreadLocal;

import java.util.Set;

public class ResourceSwitch {
    public static final String READ = "r";
    public static final String WRITE = "w";

    static boolean hasTableStategy = false;

    private static final ThreadLocal<String> rwSwitcher = new NamedInheritableThreadLocal<>("ReadWriteSwitch");
    private static final ThreadLocal<Integer> rdResourceHint = new NamedInheritableThreadLocal<>("ThreadResourceHint");
    private static final ThreadLocal<Set<String>> relatedTables = new NamedInheritableThreadLocal<>("currentTablesRelatedWithTheOperation");

    public static boolean testIsRead() {
        String switcherStr = rwSwitcher.get();
        if (switcherStr == null) {
            rwSwitcher.set(WRITE);
            return false;
        }
        return switcherStr.equals(READ);
    }

    public static boolean isHasTableStategy() {
        return hasTableStategy;
    }

    public static void change(String type) {
        rwSwitcher.set(type);
    }

    public static boolean testIsTableBeChecked(String table) {
        Set<String> set = relatedTables.get();
        if (set != null) {
            return set.contains(table);
        }
        return false;
    }

    public static boolean testIsAllCheckTableInSet(Set<String> tables) {
        Set<String> set = relatedTables.get();
        if (set != null && set.size() > 0) {
            return tables.containsAll(set);
        }
        return false;
    }

    public static boolean testIsCheckedTableExistInSet(Set<String> tables) {
        Set<String> set = relatedTables.get();
        if (set != null && set.size() > 0) {
            for (String s : set) {
                if (tables.contains(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setTablesRelated(Set<String> set) {
        relatedTables.set(set);
    }

    public static void setRdResourceHint(int round) {
        rdResourceHint.set(round);
    }

    public static int getRdResourceHint() {
        return rdResourceHint.get() == null ? -1 : rdResourceHint.get();
    }
}
