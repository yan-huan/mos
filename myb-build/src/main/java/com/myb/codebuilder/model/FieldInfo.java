package com.myb.codebuilder.model;

public class FieldInfo {
    private String name = "";
    private String type = "";
    private boolean primaryKey = false;
    private boolean autoIncrease = false;
    private String javaType = "";
    private String firstUpperName = "";
    private String firstLowerName = "";
    private ColumnLinkInfo columnLinkInfo;
    private String isListShow="false";
    private String isEditShow="false";
    private String comment;

    public FieldInfo(String name, String type, boolean primaryKey, String comment) {
        this.name = name;
        this.type = type;
        this.primaryKey = primaryKey;
        this.comment=comment;
    }



    public String getFirstUpperName() {
        return firstUpperName;
    }

    public void setFirstUpperName(String firstUpperName) {
        this.firstUpperName = firstUpperName;
    }

    public String getFirstLowerName() {
        return firstLowerName;
    }

    public void setFirstLowerName(String firstLowerName) {
        this.firstLowerName = firstLowerName;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAutoIncrease() {
        return autoIncrease;
    }

    public void setAutoIncrease(boolean autoIncrease) {
        this.autoIncrease = autoIncrease;
    }

    public String getJavaType() {
        if (javaType == "java.lang.Integer") {
            return "int";
        } else if (javaType == "java.lang.Long") {
            return "long";
        } else if (javaType == "java.lang.Byte") {
            return "byte";
        } else if (javaType == "java.lang.Char") {
            return "char";
        } else if (javaType == "java.lang.Short") {
            return "short";
        } else if (javaType == "java.lang.Float") {
            return "float";
        } else if (javaType == "java.lang.Double") {
            return "double";
        } else if (javaType == "java.lang.Boolean") {
            return "boolean";
        }
//        else if(javaType=="java.sql.Timestamp")
//        {
//            return "da";
//        }

        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }


    public String getIsListShow() {
        return isListShow;
    }

    public void setIsListShow(String isListShow) {
        this.isListShow = isListShow;
    }

    public String getIsEditShow() {
        return isEditShow;
    }

    public void setIsEditShow(String isEditShow) {
        this.isEditShow = isEditShow;
    }

    public ColumnLinkInfo getColumnLinkInfo() {
        return columnLinkInfo;
    }

    public void setColumnLinkInfo(ColumnLinkInfo columnLinkInfo) {
        this.columnLinkInfo = columnLinkInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}