package cn.aethli.mge.utils;


import cn.aethli.mge.model.Table;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 16:29
 **/
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public List<Table> configRead(File file) throws IOException {
        objectMapper.readTree(file);
        return null;
    }
}
