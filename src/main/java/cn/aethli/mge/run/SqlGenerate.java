package cn.aethli.mge.run;

import cn.aethli.mge.model.Column;
import cn.aethli.mge.model.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-14 16:23
 **/
@Data
@AllArgsConstructor
public class SqlGenerate implements Callable<String> {
    private Table table;

    @Override
    public String call() throws Exception {
        //check null
        if (table == null) {
            throw new Exception("no table");
        }
        //init sql
        StringBuilder sql = new StringBuilder();
        sql.append(String.format("CREATE TABLE '%s'(", table.getName()));
        //generate primary key sql
        for (Column column : table.getColumns()) {
            columnGenerate(sql, column);
        }
        StringBuilder primaryKeySql = new StringBuilder();
        for (Column primaryKey : table.getPrimaryKeys()) {
            columnGenerate(sql, primaryKey);
            primaryKeySql.append(String.format("'%s',", primaryKey.getName()));
        }
        if (primaryKeySql.length() > 2) {
            sql.append(String.format("PRIMARY KEY (%s)", primaryKeySql.toString()));
        }
        sql.append(String.format(")ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=%s", table.getComment()));
        return sql.toString();
    }

    private void columnGenerate(StringBuilder sql, Column primaryKey) {
        sql.append(String.format("'%s' ", primaryKey.getName()));
        String s = primaryKey.getType().toUpperCase();
        sql.append(primaryKey.getType());
        switch (s) {
            case "VARCHAR":
            case "INT":
                sql.append(String.format("(%d) ", primaryKey.getLength()));
                break;
            case "DOUBLE":
            case "DECIMAL":
                sql.append(String.format("(%d,%d)", primaryKey.getLength(), primaryKey.getDotIndex()));
                break;
            /*case "BLOB":
            case "DATETIME":
                break;*/
        }
        if (primaryKey.getAllowNull()) {
            sql.append("NULL");
        } else {
            sql.append("NOT NULL");
        }
        sql.append(",");
    }
}
