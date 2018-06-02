package com.itcast.day25;

import java.io.*;

public class ObjectInandOutDemo {
    public static void main(String[] args) {
        function_1();
        function_2();
    }

    public static void function_1(){
        //要序列化的话，被序列化的类要实现Serializable这一个接口
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=new FileOutputStream("E:\\person.txt");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(new Person("张三",19));
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("写入失败");
        }finally {
            try {
                if (oos!=null){
                    oos.close();
                }
            }catch (IOException e){
                System.out.println(e);
                throw new RuntimeException("释放资源失败");
            }
        }
    }

    public static void function_2(){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            fis=new FileInputStream("E:\\person.txt");
            ois=new ObjectInputStream(fis);
            Object obj=ois.readObject();
            System.out.println(obj);
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException("读取失败");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("wrong");
        }finally {
            try {
                if (ois!=null){
                    ois.close();
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
