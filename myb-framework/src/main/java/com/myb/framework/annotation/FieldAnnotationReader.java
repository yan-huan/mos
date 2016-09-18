package com.myb.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaitianyu on 2014/6/24.
 */
public class FieldAnnotationReader {

    private static Map<Type, Map<String, FieldAnnotation>> typeMappingInfo =
            new HashMap<Type, Map<String,  FieldAnnotation>>();


    public static <T> FieldAnnotation get(Class<T> classType, String field)
    {
        Map<String,FieldAnnotation> annotationInfoList =null;

        if(typeMappingInfo.containsKey(classType))
        {
            annotationInfoList=typeMappingInfo.get(classType);
        }
        else {
            annotationInfoList=getAnnotationInfoList(classType);
        }

        FieldAnnotation annotationDataBindingInfo =null;

        if(annotationInfoList.containsKey(field))
        {
            annotationDataBindingInfo=annotationInfoList.get(field);
        }
        return annotationDataBindingInfo;
    }

    @SuppressWarnings("unchecked")
	public static <T,T2> T2 get(Class<T> classType, String field,Class<T2> annotationType)
    {
        FieldAnnotation fieldAnnotation=get(classType,field);
        if(fieldAnnotation!=null)
        {
            if(fieldAnnotation.getAnnotationMap()!=null)
            {
                if(fieldAnnotation.getAnnotationMap().containsKey(annotationType))
                {
                    return (T2)fieldAnnotation.getAnnotationMap().get(annotationType);
                }
            }
        }
        return null;
    }

    private static synchronized <T> Map<String, FieldAnnotation> getAnnotationInfoList(Class<T> classType)
    {
        Map<String, FieldAnnotation> annotationInfoList=null;
        if(typeMappingInfo.containsKey(classType))
        {
            annotationInfoList=typeMappingInfo.get(classType);

        }
        else {

            addTypeInfo(classType);
            annotationInfoList=typeMappingInfo.get(classType);

        }
        return annotationInfoList;
    }

    private static <T> void addTypeInfo(Class<T> classType)
    {

        Map<Type, Map<String,FieldAnnotation>>  newAnnotationList =
                new HashMap<Type, Map<String, FieldAnnotation>>();
        newAnnotationList.putAll(typeMappingInfo);

        Map<String,FieldAnnotation> mappingInfos;


        mappingInfos=getTypeInfo(classType);

        newAnnotationList.put(classType, mappingInfos);

        typeMappingInfo=newAnnotationList;


    }


    private static <T> Map<String,  FieldAnnotation> getTypeInfo(Class<T> classType)
    {
        Map<String, FieldAnnotation> mapInfo=new HashMap<String, FieldAnnotation>();
        Field[] fields=classType.getDeclaredFields();
        for(int i=0;i<fields.length;i++)
        {
            Annotation[] annotations=fields[i].getAnnotations();
            if(annotations.length>0) {
                FieldAnnotation fieldAnnotation=new FieldAnnotation();
                Map<Type,Annotation> map=new HashMap<Type,Annotation>();

                for (Annotation annotation:annotations)
                {
                    map.put(annotation.annotationType(),annotation);
                }
                fieldAnnotation.setField(fields[i]);
                fieldAnnotation.setAnnotationMap(map);
                mapInfo.put(fields[i].getName(), fieldAnnotation);
            }

        }

        return mapInfo;
    }
}
