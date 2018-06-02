package com.javaProject;

import java.io.File;

public class TT implements Runnable {
    private File file;

    public TT(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        File[] fs = this.file.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].isFile()) {
                System.out.println(fs[i].getAbsolutePath());
            } else if (fs[i].isDirectory() && fs[i].length() != 0 && fs[i].listFiles() != null) {
                find(fs[i]);
            }
        }
    }

    public void find(File file) {
        File[] fs = this.file.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].isFile()) {
                System.out.println(fs[i].getAbsolutePath());
            } else if (fs[i].isDirectory() && fs[i].length() != 0 && fs[i].listFiles() != null) {
                find(fs[i]);
            }
        }
    }
}
