package com.yjq.demo.jvm.classpath.impl;

import com.yjq.demo.jvm.classpath.Entry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: 目录形式的类路径
 * @author: Created by yijq
 * @date: 2023/8/18 17:07
 */
public class DirEntry implements Entry {

    // 绝对路径
    private Path absolutePath;

    public DirEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        return Files.readAllBytes(absolutePath.resolve(className));
    }

    @Override
    public String toString() {
        return this.absolutePath.toString();
    }
}
