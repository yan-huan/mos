package com.myb.codebuilder.model;

/**
 * Created by Administrator on 2015/5/25.
 */

public class ColumnLinkInfo
{
    private String field;
    private String linkTable;
    private String linkValueField;
    private String linkTextField;
    private String insertTable;

    public ColumnLinkInfo(String field, String linkTable, String linkValueField, String linkTextField) {
        this.field = field;
        this.linkTable = linkTable;
        this.linkValueField = linkValueField;
        this.linkTextField = linkTextField;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLinkTable() {
        return linkTable;
    }

    public void setLinkTable(String linkTable) {
        this.linkTable = linkTable;
    }

    public String getLinkValueField() {
        return linkValueField;
    }

    public void setLinkValueField(String linkValueField) {
        this.linkValueField = linkValueField;
    }

    public String getLinkTextField() {
        return linkTextField;
    }

    public void setLinkTextField(String linkTextField) {
        this.linkTextField = linkTextField;
    }

    public String getInsertTable() {
        return insertTable;
    }

    public void setInsertTable(String insertTable) {
        this.insertTable = insertTable;
    }
}
