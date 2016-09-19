package com.myb.mos.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanglun on 2016/9/19.
 */
public enum ShopExceptionEnum {

        TRADE_OVER(1, "交易完成"),
        /**
         * 交易失败
         **/
        TRADE_FAIL(2, "交易失败"),

        /**
         *
         **/
        REFUND_ING(3, "退款中");



        private int code;
        private String name;

        private static final Map<Integer, String> lookup = new HashMap<>();

        static {
            for (ShopExceptionEnum shopExceptionEnum : EnumSet.allOf(ShopExceptionEnum.class)) {
                lookup.put(shopExceptionEnum.getCode(), shopExceptionEnum.getName());
            }
        }

        private ShopExceptionEnum(int code, String name) {
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

