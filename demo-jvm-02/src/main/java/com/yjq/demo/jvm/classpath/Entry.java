package com.yjq.demo.jvm.classpath;

import com.yjq.demo.jvm.classpath.impl.CompositeEntry;
import com.yjq.demo.jvm.classpath.impl.DirEntry;
import com.yjq.demo.jvm.classpath.impl.WildcardEntry;
import com.yjq.demo.jvm.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

/**
 * @description: 类路径接口
 * @author: Created by yijq
 * @date: 2023/8/18 15:50
 */
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {

        // File.pathSeparator; 路径分隔符(win\linux)
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }
}
