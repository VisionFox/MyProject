package com.xidian.project7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test7 {
    private static Set<String> javaKeyword = new HashSet<String>();

    static {
        javaKeyword.add("abstract");
        javaKeyword.add("assert");
        javaKeyword.add("boolean");
        javaKeyword.add("break");
        javaKeyword.add("byte");
        javaKeyword.add("case");
        javaKeyword.add("catch");
        javaKeyword.add("char");
        javaKeyword.add("class");
        javaKeyword.add("const");
        javaKeyword.add("continue");
        javaKeyword.add("default");
        javaKeyword.add("do");
        javaKeyword.add("double");
        javaKeyword.add("else");
        javaKeyword.add("enum");
        javaKeyword.add("extends");
        javaKeyword.add("final");
        javaKeyword.add("finally");
        javaKeyword.add("float");
        javaKeyword.add("for");
        javaKeyword.add("goto");
        javaKeyword.add("if");
        javaKeyword.add("implements");
        javaKeyword.add("import");
        javaKeyword.add("instanceof");
        javaKeyword.add("int");
        javaKeyword.add("interface");
        javaKeyword.add("long");
        javaKeyword.add("native");
        javaKeyword.add("new");
        javaKeyword.add("package");
        javaKeyword.add("private");
        javaKeyword.add("protected");
        javaKeyword.add("public");
        javaKeyword.add("return");
        javaKeyword.add("short");
        javaKeyword.add("static");
        javaKeyword.add("strictfp");
        javaKeyword.add("super");
        javaKeyword.add("switch");
        javaKeyword.add("synchronized");
        javaKeyword.add("this");
        javaKeyword.add("throw");
        javaKeyword.add("throws");
        javaKeyword.add("transient");
        javaKeyword.add("try");
        javaKeyword.add("void");
        javaKeyword.add("volatile");
        javaKeyword.add("while");
    }

    public static void main(String[] args) throws IOException {
        //用IO流的操作读取取TestMap.java的文本内容
        File testFile = new File("C:\\Users\\Administrator\\IdeaProjects\\MyProject\\src\\com\\xidian\\project7\\TestMap.java");
        FileReader fileReader = new FileReader(testFile);

        char[] buff = new char[1024];
        StringBuffer fileContent = new StringBuffer();
        int len = 0;

        while ((len = fileReader.read(buff)) != -1) {
            fileContent.append(new String(buff, 0, len));
        }

        fileReader.close();
        System.out.println("TestMap.java的文本内容为：\n" + fileContent);

        //进行词频统计
        Map<String, Integer> statistics = new HashMap<String, Integer>();
        StringTokenizer st1 = new StringTokenizer(fileContent.toString(), "(){}[]=+<>,.;:-“”\"\\ \r\n");
        while (st1.hasMoreTokens()) {
            String key = st1.nextToken();
            if (statistics.get(key) == null) {
                statistics.put(key, 1);
            } else {
                statistics.put(key, statistics.get(key) + 1);
            }
        }
        System.out.println("词频统计结果：\n" + statistics);


        //关键字统计

        //先把TestMap.java文本里的，第一个static块里面的
        //I have a dream的文本给切割过滤掉，以防影响后面的java关键词统计
        fileContent.delete(fileContent.indexOf("static {") + 7, fileContent.indexOf("public static void main"));

        //关键字统计情况
        Map<String, Integer> keyWordStatistics = new HashMap<String, Integer>();
        StringTokenizer st2 = new StringTokenizer(fileContent.toString(), "(){}[]=+<>,.;:-“”\"\\ \r\n");
        while (st2.hasMoreTokens()) {
            String word = st2.nextToken();
            if (javaKeyword.contains(word)) {
                if (keyWordStatistics.get(word) == null) {
                    keyWordStatistics.put(word, 1);
                } else {
                    keyWordStatistics.put(word, keyWordStatistics.get(word) + 1);
                }
            }
        }
        System.out.println("关键字统计情况：");
        System.out.println(keyWordStatistics);
    }
}
