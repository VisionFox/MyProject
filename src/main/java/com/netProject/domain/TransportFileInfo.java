package com.netProject.domain;

import java.io.File;

public class TransportFileInfo {
    private String fileName;
    private String fileSavePath;
    private String fileSaveName;
    private int fileSplitPartNum;
    private File acceptFile;

    public TransportFileInfo(){
        this("","","",5,null);
    }

    public TransportFileInfo(String fileName, String fileSavePath, String fileSaveName, int fileSplitPartNum, File acceptFile) {
        this.fileName = fileName;
        this.fileSavePath = fileSavePath;
        this.fileSaveName = fileSaveName;
        this.fileSplitPartNum = fileSplitPartNum;
        this.acceptFile = acceptFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSavePath() {
        return fileSavePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    public String getFileSaveName() {
        return fileSaveName;
    }

    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    public int getFileSplitPartNum() {
        return fileSplitPartNum;
    }

    public void setFileSplitPartNum(int fileSplitPartNum) {
        this.fileSplitPartNum = fileSplitPartNum;
    }

    public File getAcceptFile() {
        return acceptFile;
    }

    public void setAcceptFile(File acceptFile) {
        this.acceptFile = acceptFile;
    }
}
