package com.myb.codebuilder;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/1/28.
 */
public class Util
{
    public static void writeFile(String filePath,String content) throws IOException {
        File modelFile = new File(filePath);
        if (!modelFile.exists())
            modelFile.createNewFile();

        PrintWriter mappingfw = new PrintWriter(modelFile, "UTF-8");

        mappingfw.write(content);
        mappingfw.flush();
        mappingfw.close();
    }
    public static void creatFolder(String dir)
    {
        File folder = new File(dir);
        if (!folder.exists())
            folder.mkdirs();
    }
    public static String Join(String[] strings, String separator) {
        int len = strings.length;
        int i = 0;
        StringBuffer sbBuffer = new StringBuffer();
        for (String str : strings) {
            sbBuffer.append(str);
            if (i != len - 1) {
                sbBuffer.append(separator);
            }
            i++;
        }
        return sbBuffer.toString();
    }

    public static String Join(String[] strings, String separator,
                              String prefix, String suffix) {
        int len = strings.length;
        int i = 0;
        StringBuffer sbBuffer = new StringBuffer();
        for (String str : strings) {
            sbBuffer.append(prefix);
            sbBuffer.append(str);
            sbBuffer.append(suffix);
            if (i != len - 1) {
                sbBuffer.append(separator);
            }
            i++;
        }
        return sbBuffer.toString();
    }

//    protected static String getPrimaryKeyColumn(Fields[] fields) {
//        String pkName = null;
//        for (int i = 0; i < fields.length; i++)
//            if (fields[i].isPrimaryKey()) {
//                pkName = fields[i].getName();
//                break;
//            }
//        return pkName;
//    }
//
//    protected static String[] getColumns(Fields[] fields) {
//        List<String> columns = new ArrayList<String>();
//        for (int i = 0; i < fields.length; i++) {
//            if (!fields[i].isAutoIncrease()) {
//                columns.add(fields[i].getName());
//            }
//        }
//        return columns.toArray(new String[0]);
//    }

    public static String toAttributeString(String _p_attr) {
        if (_p_attr == null)
            return null;
        char[] _v_charArray = _p_attr.toCharArray();
        if (_v_charArray.length > 0) {
            _v_charArray[0] = Character.toLowerCase(_v_charArray[0]);
            if (_v_charArray.length > 1)
                _v_charArray[1] = Character.toLowerCase(_v_charArray[1]);
        }
        return new String(_v_charArray);
    }

    public static String firstToUpperCase(String _p_String) {
        if (_p_String == null)
            return null;
        char[] _v_charArray = _p_String.toCharArray();
        if (_v_charArray.length > 0)
            _v_charArray[0] = Character.toUpperCase(_v_charArray[0]);
        return new String(_v_charArray);
    }

    public static String firstToLowerCase(String _p_String) {
        if (_p_String == null)
            return null;
        char[] _v_charArray = _p_String.toCharArray();
        if (_v_charArray.length > 0)
            _v_charArray[0] = Character.toLowerCase(_v_charArray[0]);
        return new String(_v_charArray);
    }


    public static String  getFormatString(String tableName)
    {
        tableName=firstToUpperCase(tableName);
        String[] splitStrings=tableName.split("_");
        StringBuffer sb=new StringBuffer();
        for(String str:splitStrings)
        {
            sb.append(firstToUpperCase(str));
        }
        return sb.toString();
    }
}

