package cn.aethli.mge.model;

import lombok.Data;

/**
 * support:VARCHAR,BLOB,DATETIME,INT,DECIMAL,DOUBLE
 *
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 16:02
 **/
@Data
public class Column {
    private String name;
    private int length;
    private String type;
    private Boolean allowNull;
    private int dotIndex;
}
