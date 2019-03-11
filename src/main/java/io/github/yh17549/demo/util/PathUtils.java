package io.github.yh17549.demo.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author xyh
 * @date 2019-03-11
 */
public class PathUtils {

    private static final String ENCODE_UTF_8 = "UTF-8";

    public static String getJarRuntimePath(){
        String path = PathUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        try {
            path = URLDecoder.decode(path,ENCODE_UTF_8);
            File file = new File(path);
            if (file.isDirectory()){
                return file.getAbsolutePath();
            } else {
                return file.getParentFile().getAbsolutePath();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("parse runtime path error!");
    }

}
