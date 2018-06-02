package com.netProject.TCPFileTransportPlus;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class BreakPointSend implements Runnable{
    private Socket socket;
    private String propertiesPath="C:\\Users\\Administrator\\IdeaProjects\\MyProject\\src\\breakTransport.properties";
    private File file;
    private Properties properties=new Properties();

    BreakPointSend(Socket socket,String filePath){
        this.file=new File(filePath);
        this.socket=socket;
    }

    @Override
    public void run() {
        init();
        send();
    }


    public void init(){
        try {
            //更新接收方发送过来的断点配置文件
            InputStream in=this.socket.getInputStream();
            FileOutputStream proOut=new FileOutputStream(this.propertiesPath);

            byte[] dataBuff=new byte[1024];
            int len=0;

            while ((len=in.read(dataBuff))!=-1){
                proOut.write(dataBuff,0,len);
            }
            proOut.close();

            //in.close()不能用这个,会把socket也关闭？？？？？？？？？？？？？？？

            System.out.println("配置文件接收更新完毕");

            //加载断点配置信息进入properties
            FileInputStream proIn=new FileInputStream(this.propertiesPath);
            this.properties.load(proIn);
            proIn.close();
            System.out.println("配置信息加载完成------");
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("初始化失败");
        }
    }

    public void send(){
        try {
            //定位
            RandomAccessFile accessFile=new RandomAccessFile(this.file,"rw");
            accessFile.seek(Long.valueOf(this.properties.getProperty("breakPos")));

            //发送
            OutputStream out=socket.getOutputStream();
            byte[] dataBuff=new byte[1024];
            int len=0;

            while ((len=accessFile.read(dataBuff))!=-1){
                out.write(dataBuff,0,len);
            }
            socket.shutdownOutput();

            accessFile.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException("发送失败");
        }
    }
}
