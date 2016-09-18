package com.myb.framework.data;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class EntityBuilder {
	
    private static Map<Type, Map<String, AnnotationDataBindingInfo>> typeMappingInfo =
    new HashMap<Type, Map<String, AnnotationDataBindingInfo>>();
    
    public static <T> AnnotationDataBindingInfo getPropertyInfo(Class<T> c, String columnName)
    {
    	Map<String, AnnotationDataBindingInfo> annotationInfoList =null;

    	if(typeMappingInfo.containsKey(c))
    	{
    		annotationInfoList=typeMappingInfo.get(c);
    	}
    	else {
    		annotationInfoList=getAnnotationInfoList(c);
		}

    	AnnotationDataBindingInfo annotationDataBindingInfo =null;
    	columnName=columnName.toLowerCase();
    	if(annotationInfoList.containsKey(columnName))
    	{
    		annotationDataBindingInfo=annotationInfoList.get(columnName);
    	}
        return annotationDataBindingInfo;
    }
    
    private static synchronized <T> Map<String, AnnotationDataBindingInfo> getAnnotationInfoList(Class<T> c)
    {
    	Map<String, AnnotationDataBindingInfo> annotationInfoList=null;
    	if(typeMappingInfo.containsKey(c))
    	{
    		annotationInfoList=typeMappingInfo.get(c);
    		
    	}
    	else {
  
			addTypeInfo(c);
			annotationInfoList=typeMappingInfo.get(c);
    		
		}
    	return annotationInfoList;
    }
    
    private static <T> void addTypeInfo(Class<T> c)
    {

    	Map<Type, Map<String, AnnotationDataBindingInfo>>  newMappingList =
            new HashMap<Type, Map<String, AnnotationDataBindingInfo>>();
    	newMappingList.putAll(typeMappingInfo);
    	



        Map<String, AnnotationDataBindingInfo> mappingInfos;


        mappingInfos=getTypeInfo(c);

        newMappingList.put(c, mappingInfos);
        
        typeMappingInfo=newMappingList;


    }
    
    
    private static <T> Map<String, AnnotationDataBindingInfo> getTypeInfo(Class<T> c)
    {
    	Map<String, AnnotationDataBindingInfo> mapInfo=new HashMap<String, AnnotationDataBindingInfo>();

    	Field[] fields=c.getDeclaredFields();
        
        for(int i=0;i<fields.length;i++)
        {
        	DataMapping dataMapping= fields[i].getAnnotation(DataMapping.class);
        	if(dataMapping!=null)
        	{
            	String columnString=dataMapping.value().toLowerCase();
            	fields[i].setAccessible(true);
            	AnnotationDataBindingInfo bindingInfo=new AnnotationDataBindingInfo();
            	bindingInfo.setColumn(columnString);
            	bindingInfo.setFieldInfo(fields[i]);
            	mapInfo.put(columnString, bindingInfo);	
        	}

        }
    	
       return mapInfo;
    }
}
    
    


