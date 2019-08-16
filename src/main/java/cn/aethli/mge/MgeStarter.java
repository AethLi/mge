package cn.aethli.mge;

import cn.aethli.mge.model.Database;
import cn.aethli.mge.model.Table;
import cn.aethli.mge.run.SqlGenerate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 15:51
 **/
public class MgeStarter {
    public static void start(String path) throws Exception {
        File config = new File(path);
        //check config file exists
        if (!config.exists()) {
            throw new Exception("no config file found");
        }
        //check file format
        int dotIndex = path.lastIndexOf(".");
        String format;
        if ((dotIndex > -1) && (dotIndex < (path.length() - 1))) {
            format = path.substring(dotIndex + 1);
        } else {
            throw new Exception("bad file format");
        }
        format = format.toLowerCase();
        ObjectMapper objectMapper;
        if ("properties".equals(format)) {
            objectMapper = new ObjectMapper(new JavaPropsFactory());
        } else if ("xml".equals(format)) {
            objectMapper = new ObjectMapper(new XmlFactory());
        } else if ("yml".equals(format)) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else if ("json".equals(format)) {
            objectMapper = new ObjectMapper();
        } else {
            throw new Exception("not support format");
        }
        Database db = objectMapper.readValue(config, Database.class);
        StringBuilder sqlBuilder = new StringBuilder();
        for (Table t : db.getTables()) {
            ExecutorService executor = Executors.newCachedThreadPool();
            SqlGenerate sqlGenerate = new SqlGenerate(t);
            FutureTask<String> futureTask = new FutureTask<String>(sqlGenerate);
            executor.submit(futureTask);
            executor.shutdown();
        }
    }
}
