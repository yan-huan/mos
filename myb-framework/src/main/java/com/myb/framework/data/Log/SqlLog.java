package com.myb.framework.data.Log;

import com.myb.framework.data.Log.type.DatabaseDialect;
import com.myb.framework.data.Log.type.TypeHandler;
import com.myb.framework.data.Log.type.TypeHandlerRegistry;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/7.
 */
public class SqlLog {
    private static Logger log = Logger.getLogger(SqlLog.class);

    private static TypeHandlerRegistry registry	= new TypeHandlerRegistry();


    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void log(String sql, Object[] values) {
        if (null == values || 0 == values.length) {
            log.info(sql);
        } else {
            List<Object> list = parse(sql, values);
            if (null == list) {
                log.info(sql);
            } else {
                StringBuilder builder = new StringBuilder();
                int index = 0;
                for (Object obj : list) {
                    if (null == obj) {
                        if (null != values[index]) {
                            TypeHandler typeHandler = registry.getTypeHandler(values[index].getClass());
                            if (null != typeHandler) {
                                typeHandler.appendLog(builder, values[index], DatabaseDialect.MYSQL);
                            } else {
                                log.info("不能解析的参数: " + values[index]);
                            }
                        } else {
                            builder.append(values[index]);
                        }
                        index++;
                    } else {
                        builder.append(obj);
                    }
                }
                //System.out.println(builder.toString());
                log.info(builder.toString());
            }
        }
    }

    private static List<Object> parse(String sql, Object[] values) {
        int count = 0;
        List<Object> list = new ArrayList<>();
        char[] src = sql.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean inString = false;
        for (int i = 0; i < src.length; i++) {
            char key = src[i];
            switch (key) {
                case '\'':
                    if (inString) {
                        inString = false;
                    } else {
                        inString = true;
                    }
                    builder.append(key);
                    break;
                case '?':
                    if (inString) {
                        builder.append(key);
                    } else {
                        list.add(builder.toString());
                        builder = new StringBuilder();
                        list.add(null);// replace
                        count++;
                    }
                    break;
                default:
                    builder.append(key);
            }
        }

        if (builder.length() > 0) {
            list.add(builder.toString());
        }

        if (count > 0) {
            if (count > values.length) {
                throw new RuntimeException("所需SQL变量数和入参数不符");
            }
            return list;
        }
        return null;
    }
}
