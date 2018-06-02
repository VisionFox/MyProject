package com.offer;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class bean extends HttpServer implements Runnable{
    int id;
    String name;
    Integer oo;
    double pp;

    public bean(int id) {
        this.id = id;
    }

    public bean(int id, String name, Integer oo, double pp) {
        this.id = id;
        this.name = name;
        this.oo = oo;
        this.pp = pp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOo() {
        return oo;
    }

    public void setOo(Integer oo) {
        this.oo = oo;
    }

    public double getPp() {
        return pp;
    }

    public void setPp(double pp) {
        this.pp = pp;
    }

    @Override
    public String toString() {
        return "bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", oo=" + oo +
                ", pp=" + pp +
                '}';
    }



    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {

    }

    @Override
    public void start() {

    }

    @Override
    public void setExecutor(Executor executor) {

    }

    @Override
    public Executor getExecutor() {
        return null;
    }

    @Override
    public void stop(int i) {

    }

    @Override
    public HttpContext createContext(String s, HttpHandler httpHandler) {
        return null;
    }

    @Override
    public HttpContext createContext(String s) {
        return null;
    }

    @Override
    public void removeContext(String s) throws IllegalArgumentException {

    }

    @Override
    public void removeContext(HttpContext httpContext) {

    }

    @Override
    public InetSocketAddress getAddress() {
        return null;
    }

    @Override
    public void run() {

    }
}
