package com.javaProject;

import java.io.File;
import java.util.Scanner;

public class Test {
    static int flag = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rootPath = sc.nextLine() + ":" + File.separator;
        File root = new File(rootPath);
        long sta=System.currentTimeMillis();
        find(root);
        long end=System.currentTimeMillis();
        System.out.println("时间"+(end-sta));
        System.out.println(rootPath+"文件数量"+flag);
    }

    public static void find(File f) {
        File[] fs = f.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].isFile()) {
                flag++;
                if(fs[i].getAbsolutePath().endsWith(".exe")){
                    System.out.println(fs[i].getAbsolutePath());
                }
                if(fs[i].getAbsolutePath().endsWith(".dll")){
                    System.out.println(fs[i].getAbsolutePath());
                }
            } else if (fs[i].isDirectory() && fs[i].length() != 0 && fs[i].listFiles() != null) {
                find(fs[i]);
            }
        }
    }

}
