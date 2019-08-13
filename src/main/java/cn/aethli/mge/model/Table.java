package cn.aethli.mge.model;

import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 16:17
 **/
@Data
public class Table {
    private Iterable<Column> primaryKeys;
    private Iterable<Column> columns;
}
