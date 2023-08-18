package com.yjq.demo.jvm.classpath.impl;

import com.yjq.demo.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.*;

/**
 * @description: zip/zar文件形式类路径
 * @author: Created by yijq
 * @date: 2023/8/18 15:50
 */
public class ZipEntry implements Entry {

    private Path absolutePath;

    public ZipEntry(String path) {
        // 获取绝对路径
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        try (FileSystem zipFs = FileSystems.newFileSystem(absolutePath, null)){
            return Files.readAllBytes(zipFs.getPath(className));
        }
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}
