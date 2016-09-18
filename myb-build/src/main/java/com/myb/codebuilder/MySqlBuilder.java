package com.myb.codebuilder;


import com.myb.codebuilder.model.ColumnLinkInfo;
import com.myb.codebuilder.model.FieldInfo;
import com.myb.codebuilder.model.PackageInfo;
import com.myb.codebuilder.model.TableInfo;

import freemarker.template.TemplateException;



import java.io.*;
import java.sql.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class MySqlBuilder {

    private static StringTemplate stringTemplate=null;
    private static Map<String,Object> commonMaps=new HashMap<String, Object>();


    public static void main(String[] args) throws Exception {
        stringTemplate= new StringTemplate();
        MySqlBuilder mySqlBuilder = new MySqlBuilder();
        mySqlBuilder.load_common();
        mySqlBuilder.load_table();
        mySqlBuilder.load_other();
    }

    private void load_common() throws Exception {
        commonMaps.put("project_path","C:/Users/yanhuan/Desktop/aa");
        commonMaps.put("db_driver","com.mysql.jdbc.Driver");

        //commonMaps.put("db_url","jdbc:mysql://127.0.0.1/test?useUnicode=true&characterEncoding=UTF-8");
        commonMaps.put("db_url","jdbc:mysql://182.92.172.193:3306/meiyebang-mos-001?useUnicode=true&characterEncoding=UTF-8");
        commonMaps.put("db_user","root");
        commonMaps.put("db_password","ucV*-0qRFy");
        commonMaps.put("groupId","com.myb.service");
        commonMaps.put("artifactId","mybile");


        commonMaps.put("project_name",String.format("%s.%s",commonMaps.get("groupId"),commonMaps.get("artifactId")));
        List<TableInfo> tableInfos =new ArrayList<TableInfo>();

//        tableInfos.add(new TableInfo("permission_user_system",
//                null,
//                null,
//                new ColumnLinkInfo[]{new ColumnLinkInfo("system_id","permission_system","system_id","system_name")}));


        loadDBTable(tableInfos);


        commonMaps.put("tables", tableInfos);

    }

	private void load_table() throws Exception {




        Map<String,PackageInfo> packageInfos=new HashMap<String, PackageInfo>();
        packageInfos.put("mapping",new PackageInfo(commonMaps.get("project_name")+".pojo","mapping.ftl","Mapping.java","/src/main/java/"));
        packageInfos.put("pojo",new PackageInfo(commonMaps.get("project_name")+".pojo","pojo.ftl",".java","/src/main/java/"));
        packageInfos.put("dao",new PackageInfo(commonMaps.get("project_name")+".dao","dao.ftl","Dao.java","/src/main/java/"));
        packageInfos.put("services",new PackageInfo(commonMaps.get("project_name")+".services","services.ftl","Service.java","/src/main/java/"));
        packageInfos.put("servicesimpl",new PackageInfo(commonMaps.get("project_name")+".servicesImpl","servicesimpl.ftl","ServiceImpl.java","/src/main/java/"));
        packageInfos.put("controllers",new PackageInfo(commonMaps.get("project_name")+".controllers","controllers.ftl","Controller.java","/src/main/java/"));
        packageInfos.put("Search",new PackageInfo("views","search.ftl","Search.jsp","/src/main/webapp/WEB-INF/"));
        packageInfos.put("Edit",new PackageInfo("views","edit.ftl","EditView.jsp","/src/main/webapp/WEB-INF/"));

        List<TableInfo> tableInfos =(List<TableInfo>)commonMaps.get("tables");



        for(PackageInfo packageInfo:packageInfos.values())
        {
            String dir=commonMaps.get("project_path") + packageInfo.getPath()
                    + packageInfo.getPackageName().replace(".", File.separator);
            Util.creatFolder(dir);
        }


        for (TableInfo tableInfo : tableInfos) {
            System.out.println("table name:" + tableInfo.getTableName());
            for(PackageInfo packageInfo:packageInfos.values()) {
                buldFile(tableInfo,packageInfo,packageInfos);
            }
        }


    }


    public void load_other() throws IOException, TemplateException {
        Map<String,String> shareFiles=new HashMap<String, String>();
        shareFiles.put("app_config.xml","/src/main/resources/config/app/");
        shareFiles.put("parameter_config.xml","/src/main/resources/config/app/");
        shareFiles.put("resource_config.xml","/src/main/resources/config/app/");
        shareFiles.put("jdbc.properties","/src/main/resources/config/properties/");
        shareFiles.put("application_context.xml","/src/main/resources/config/sp/");
        shareFiles.put("spring_mvc.xml","/src/main/resources/config/sp/");
        shareFiles.put("db_context.xml","/src/main/resources/config/sp/");
        shareFiles.put("config_files.xml","/src/main/resources/config/");
        shareFiles.put("log4j.properties","/src/main/java/");
        shareFiles.put("web.xml","/src/main/webapp/WEB-INF/");
        shareFiles.put("pom.xml","/");
        shareFiles.put("header.jsp","/src/main/webapp/WEB-INF/views/shared/");
        shareFiles.put("Home.jsp","/src/main/webapp/WEB-INF/views/");
        shareFiles.put("HomeController.java", "/src/main/java/" + commonMaps.get("project_name").toString().replace(".", File.separator) + File.separator+"controllers" + File.separator);
        shareFiles.put("Converter.java","/src/main/java/"+commonMaps.get("project_name").toString().replace(".", File.separator)+"/common/");

        for(String file:shareFiles.keySet()) {
            System.out.println(file);
            String dir=commonMaps.get("project_path") + shareFiles.get(file).replace(".", File.separator);
            Util.creatFolder(dir);
            String template_path= File.separator + "config" + File.separator +file;
            String content=stringTemplate.process(template_path,commonMaps);
            String filePath=commonMaps.get("project_path") + shareFiles.get(file) + file;
            Util.writeFile(filePath, content);
        }
    }




    protected void buldFile(TableInfo tableInfo,PackageInfo packageInfo,Map<String,PackageInfo> packageInfoMap) throws Exception {
        FieldInfo[] fieldInfos = getFields(tableInfo);
        loadComment(fieldInfos, tableInfo);
        String content="";
        String firstUpperClassName=Util.getFormatString(tableInfo.getTableName());
        String firstLowerClassName=Util.firstToLowerCase(Util.getFormatString(tableInfo.getTableName())) ;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("tableName", tableInfo.getTableName());
        map.put("packageName",packageInfo.getPackageName());
        map.put("firstUpperClassName",firstUpperClassName );
        map.put("firstLowerClassName",firstLowerClassName );
        map.put("project_name",commonMaps.get("project_name"));
        for(String key:packageInfoMap.keySet())
        {
            map.put(key,packageInfoMap.get(key));
        }
        List<FieldInfo> fieldInfoList =new ArrayList<FieldInfo>();
        for(FieldInfo fieldInfo : fieldInfos)
        {
            fieldInfoList.add(fieldInfo);
        }
        map.put("fields", fieldInfoList);

        String filePath=commonMaps.get("project_path") + packageInfo.getPath()
                + packageInfo.getPackageName().replace(".", File.separator) + File.separator +firstUpperClassName
                + packageInfo.getFileName();

        content=stringTemplate.process(packageInfo.getTemplate(),map);
        System.out.println(filePath);
        Util.writeFile(filePath,content);
    }


    protected Map<String,String> getFieldComment(TableInfo tableInfo) throws Exception {
        HashMap<String,String> map=new HashMap<String,String>();
        Connection conn = getConnection();
        PreparedStatement psFieldComment=conn.prepareStatement("show full columns from " + tableInfo.getTableName());
        ResultSet rsFieldComment = psFieldComment.executeQuery();

        while (rsFieldComment.next())
        {
            map.put(rsFieldComment.getString("Field"),rsFieldComment.getString("Comment"));
        }
        if (psFieldComment != null)
            psFieldComment.close();
        if (conn != null)
            conn.close();
        return map;
    }

    protected void loadComment(FieldInfo[] fieldInfos,TableInfo tableInfo) throws Exception {
        Map<String,String> map=getFieldComment(tableInfo);
        for (int i=0;i< fieldInfos.length;i++)
        {
            fieldInfos[i].setComment(map.get(fieldInfos[i].getName()));
        }
    }



    protected  FieldInfo[] getFields(TableInfo tableInfo) throws Exception {
        Connection conn = null;
        PreparedStatement psField = null;

        FieldInfo[] fieldInfos = null;
        conn = getConnection();
        ResultSet rs1 = conn.getMetaData()
                .getPrimaryKeys(null, null, tableInfo.getTableName());
        String primaryKey = null;
        while (rs1.next()) {
            primaryKey = rs1.getString(4);
        }
        psField = conn.prepareStatement("select * from " + tableInfo.getTableName()+" LIMIT 1");
        ResultSet rsField = psField.executeQuery();
        ResultSetMetaData rsmField = rsField.getMetaData();
        int colCount = rsmField.getColumnCount();



        fieldInfos = new FieldInfo[colCount];
//        if(tableConfig.getEditShow()==null)
//        {
//            if()
//            tableConfig.setEditShow(new String[colCount]);
//            tableConfig.setListShow(new String[colCount]);
//        }
        for (int i = 0; i < fieldInfos.length; i++) {
            String colName = rsmField.getColumnName(i + 1);

            String colType = rsmField.getColumnTypeName(i + 1);

            boolean isPK = colName.equals(primaryKey);
            fieldInfos[i] = new FieldInfo(colName, colType, isPK,"");
            fieldInfos[i].setAutoIncrease(rsmField.isAutoIncrement(i + 1));
            fieldInfos[i].setJavaType(rsmField.getColumnClassName(i + 1));
            fieldInfos[i].setFirstLowerName(Util.firstToLowerCase(Util.getFormatString(colName)));
            fieldInfos[i].setFirstUpperName(Util.firstToUpperCase(Util.getFormatString(colName)));


            if(tableInfo.getEditShow()!=null)
            {
                for(String editShow: tableInfo.getEditShow())
                {
                    if(editShow.toLowerCase().equals(fieldInfos[i].getName().toLowerCase()))
                    {
                        fieldInfos[i].setIsEditShow("true");
                        break;
                    }
                }
            }
            else
            {
                fieldInfos[i].setIsEditShow("true");
            }

            if(tableInfo.getListShow()!=null)
            {
                for(String listShow: tableInfo.getListShow())
                {
                    if(listShow.toLowerCase().equals(fieldInfos[i].getName().toLowerCase()))
                    {
                        fieldInfos[i].setIsListShow("true");
                        break;
                    }
                }
            }
            else
            {
                fieldInfos[i].setIsListShow("true");
            }

            if(tableInfo.getColumnLinkInfos()!=null) {
                for (ColumnLinkInfo columnLinkInfo : tableInfo.getColumnLinkInfos()) {
                    if (columnLinkInfo.getField().toLowerCase().equals(colName.toLowerCase())) {
                        columnLinkInfo.setLinkTable(Util.getFormatString( columnLinkInfo.getLinkTable()));
                        columnLinkInfo.setLinkTextField(Util.firstToLowerCase( Util.getFormatString( columnLinkInfo.getLinkTextField())));
                        columnLinkInfo.setLinkValueField(Util.firstToLowerCase( Util.getFormatString( columnLinkInfo.getLinkValueField())));
                        fieldInfos[i].setColumnLinkInfo(columnLinkInfo);
                        System.out.println(fieldInfos[i].getColumnLinkInfo().getField());
                        break;
                    }
                }
            }
        }
        if (psField != null)
            psField.close();
        if (conn != null)
            conn.close();
        return fieldInfos;
    }

    protected  void loadDBTable(List<TableInfo> tableInfos) throws Exception {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("show tables");
        ResultSet rs = stmt.executeQuery();

        if(tableInfos.size()==0) {
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(rs.getString(1));
                tableInfo.setFirstUpperClassName(Util.firstToUpperCase(Util.getFormatString(tableInfo.getTableName())));
                tableInfos.add(tableInfo);
            }
        }
        else
        {
            for(int i=0;i<tableInfos.size();i++){

                tableInfos.get(i).setFirstUpperClassName(Util.firstToUpperCase(Util.getFormatString(tableInfos.get(i).getTableName())));

            }
        }
        if (stmt != null)
            stmt.close();
        if (conn != null)
            conn.close();
        if (rs != null)
            rs.close();
    }

    protected  Connection getConnection() throws Exception {
        Class.forName(commonMaps.get("db_driver").toString());
        Connection conn = DriverManager.getConnection(commonMaps.get("db_url").toString(), commonMaps.get("db_user").toString(), commonMaps.get("db_password").toString());
        return conn;
    }



}



