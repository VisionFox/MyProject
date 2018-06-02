package com.javabigwork.app;

public class fileinfoBean {
    private int id;
    private String path;
    private String hash;
    private int count;

    public fileinfoBean(int id, String path, String hash, int count) {
        this.id = id;
        this.path = path;
        this.hash = hash;
        this.count = count;
    }

    public fileinfoBean() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "fileinfoBean{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", hash='" + hash + '\'' +
                ", count=" + count +
                '}';
    }
}
