package com.yjq.demo.jvm;
/**
 * @description:
 * @author: Created by yijq
 * @date: 2023/8/18 15:04
 */
public class Main {
    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage：<main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        System.out.printf("classpath:%s class:%s\n", cmd.classpath, cmd.getMainClass(), cmd.getAppArgs());
    }
}