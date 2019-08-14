package cn.aethli.mge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-14 10:52
 **/
@Data
public class Database {
    @JsonProperty(value = "table")
    private Iterable<Table> tables;
}
