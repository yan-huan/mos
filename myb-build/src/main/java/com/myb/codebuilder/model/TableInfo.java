package com.myb.codebuilder.model;

/**
 * Created by Administrator on 2015/5/25.
 */
public class TableInfo {
    private String tableName;
    private String[] listShow;
    private String[] editShow;
    private ColumnLinkInfo[] columnLinkInfos;
    private String firstUpperClassName;
    public TableInfo()
    {

    }

    public TableInfo(String tableName, String[] listShow, String[] editShow, ColumnLinkInfo[] columnLinkInfos) {
        this.tableName = tableName;
        this.listShow = listShow;
        this.editShow = editShow;
        this.columnLinkInfos = columnLinkInfos;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getListShow() {
        return listShow;
    }

    public void setListShow(String[] listShow) {
        this.listShow = listShow;
    }

    public String[] getEditShow() {
        return editShow;
    }

    public void setEditShow(String[] editShow) {
        this.editShow = editShow;
    }

    public ColumnLinkInfo[] getColumnLinkInfos() {
        return columnLinkInfos;
    }

    public void setColumnLinkInfos(ColumnLinkInfo[] fields) {
        this.columnLinkInfos = fields;
    }

    public void setFirstUpperClassName(String firstUpperClassName) {
        this.firstUpperClassName = firstUpperClassName;
    }

    public String getFirstUpperClassName() {
        return firstUpperClassName;
    }
}
