package cn.aethli.mge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "length")
    private int length;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "allowNull")
    private Boolean allowNull;
    @JsonProperty(value = "dotIndex")
    private int dotIndex;
}
