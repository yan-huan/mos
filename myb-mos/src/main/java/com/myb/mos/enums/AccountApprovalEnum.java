package com.myb.mos.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangLun on 2016/9/19.
 */
public enum AccountApprovalEnum {


    /**
     *未审批
     */
    APPROVAL_NONE(1, "未审批"),

    /**
     * 审批通过
     **/
    APPROVAL_SUCCESS(2, "审批通过"),

    /**
     *审批未通过,
     **/
    APPROVAL_FAIL(3, "审批驳回"),

    /**
     *
     */
    RE_APPROVAL(4,"退回再审批"),


    APPROVAL_CLOSE(-1,"账号已关闭");


    private int code;
    private String name;

    private static final Map<Integer, String> lookup = new HashMap<>();

    static {
        for (AccountApprovalEnum accountApprovalEnum : EnumSet.allOf(AccountApprovalEnum.class)) {
            lookup.put(accountApprovalEnum.getCode(), accountApprovalEnum.getName());
        }
    }

    private AccountApprovalEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static String getNameValue(Integer code) {
        return lookup.get(code);
    }

    public static Map<Integer, String> getLookup() {
        return lookup;
    }
}

