package com.test.pkg2;

import com.test.pkg1.A;

public class PublicVsPackage {
    public static void main(String[] args){
        A obj=new A();
//B obj2=new B(); //在pkg1之外不能创建B的对象
//obj.mtd(); //在pkg1之外不能访问mtd()方法
    }


}
