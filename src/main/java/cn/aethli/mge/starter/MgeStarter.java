package cn.aethli.mge.starter;

import java.io.File;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 15:51
 **/
public class MgeStarter {
    public void start(String path) throws Exception {
        File config = new File(path);
        //check config file exists
        if (!config.exists()) {
            throw new Exception("no config file found");
        }
        //check file format
        /*
         *todo support
         * properties
         * yml
         * xml
         */
        int dotIndex = path.lastIndexOf(".");
        String format;
        if ((dotIndex > -1) && (dotIndex < (path.length() - 1))) {
            format = path.substring(dotIndex + 1);
        } else {
            throw new Exception("bad file format");
        }
        format = format.toLowerCase();
        if ("properties".equals(format)) {

        } else if ("xml".equals(format)) {

        } else if ("yml".equals(format)) {

        } else {
            throw new Exception("not support format");
        }

    }
}
