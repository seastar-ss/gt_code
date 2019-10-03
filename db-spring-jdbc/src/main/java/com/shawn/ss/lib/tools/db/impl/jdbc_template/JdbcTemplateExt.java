package com.shawn.ss.lib.tools.db.impl.jdbc_template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.ParsedSql;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Set;

/**
 * Created by ss on 2017/10/9.
 */
public class JdbcTemplateExt extends NamedParameterJdbcTemplate {

    static final Logger L = LoggerFactory.getLogger(JdbcTemplateExt.class.getSimpleName());

    public JdbcTemplateExt(DataSource dataSource) {
        super(dataSource);
    }

    Map<String, String> replacement;

    public Map<String, String> getReplacement() {
        return replacement;
    }

    public void setReplacement(Map<String, String> replacement) {
        this.replacement = replacement;
    }

    @Override
    protected ParsedSql getParsedSql(String sql) {
        if (replacement != null && replacement.size() > 0) {
            Set<Map.Entry<String, String>> entries = replacement.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                sql = sql.replace(entry.getKey(), entry.getValue());
            }
        }
        ParsedSql parsedSql = super.getParsedSql(sql);
        if (sql.toLowerCase().startsWith("update") || sql.toLowerCase().startsWith("insert")) {
            L.info("run sql {} ", parsedSql.toString());
        }
        return parsedSql;
    }
}
