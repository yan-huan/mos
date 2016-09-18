package com.myb.codebuilder.model;


public class PackageInfo {
    private String packageName;
    private String template;
    private String fileName;
    private String path;

    public PackageInfo(String packageName, String template, String fileName, String path) {
        this.packageName = packageName;
        this.template = template;
        this.fileName = fileName;
        this.path = path;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}