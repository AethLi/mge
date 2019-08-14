package cn.aethli.mge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 16:17
 **/
@Data
public class Table {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "commentary")
    private String commentary;
    @JsonProperty(value = "primaryKey")
    private Iterable<Column> primaryKeys;
    @JsonProperty(value = "column")
    private Iterable<Column> columns;
}
