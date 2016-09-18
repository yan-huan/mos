<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.myb.framework.web.resource.MetaDataCollection"%>
<%@page import="org.springframework.web.context.request.RequestContextHolder"%>
<%@page import="org.springframework.web.context.request.ServletRequestAttributes"%>
<%
    String path = request.getContextPath();
    String port= request.getServerPort()==80?"":String.valueOf(request.getServerPort());
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+port+path+"/";
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    MetaDataCollection metaDataCollection=new MetaDataCollection(attributes.getRequest());
%>
<link rel="shortcut icon" href="<%=basePath %>favicon.ico" type="image/x-icon" />
<%=metaDataCollection.getMetaDataCss().toString() %>
<%=metaDataCollection.getMetaDataJs().toString() %>