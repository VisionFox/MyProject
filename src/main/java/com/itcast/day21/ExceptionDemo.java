package com.itcast.day21;

public class ExceptionDemo {
    public static void main(String[] args)throws Exception{
            getavg(12,34,56,-6,6,78);


    }

    public static void getavg(int...a)throws FuShuException{
        int sum=0;
        for (int s:a){
            if (s  <  0){
                throw new FuShuException();
            }
            sum+=s;
        }
        System.out.println(sum/a.length);
    }
}
