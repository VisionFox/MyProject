package com.netProject.caogao;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        File file=new File("F:\\TCPtest.jpg");
        System.out.println(file.getUsableSpace());
    }
}
