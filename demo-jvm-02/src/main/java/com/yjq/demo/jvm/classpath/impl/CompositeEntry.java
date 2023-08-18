package com.yjq.demo.jvm.classpath.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yjq.demo.jvm.classpath.Entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @description:
 * @author: Created by yijq
 * @date: 2023/8/18 17:04
 */
public class CompositeEntry implements Entry {

    private final List<Entry> entryList = new ArrayList<>();
    public CompositeEntry(String pathList) {
        String[] paths = pathList.split(File.pathSeparator);
        for (String path : paths) {
            entryList.add(Entry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        for (Entry entry : entryList) {
            try {
                return entry.readClass(className);
            } catch (Exception ignored) {
                // ignored
            }
        }
        throw new IOException("class not found" + className);
    }

    @Override
    public String toString() {
        String[] strs = new String[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            strs[i] = entryList.get(i).toString();
        }
        return String.join(File.pathSeparator, strs);
    }
}
