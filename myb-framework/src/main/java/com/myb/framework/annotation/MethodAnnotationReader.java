package com.myb.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MethodAnnotationReader {
    private static Map<Type, Map<Method, Map<Type,Annotation>>> typeMappingInfo =
            new HashMap<Type, Map<Method,  Map<Type,Annotation>>>();


	@SuppressWarnings("unchecked")
	public static <T,T2> T2 get(Class<T> classType, Method method,Class<T2> annotationType)
    {
        Map<Type,Annotation> annotationMap=get(classType, method);
        if(annotationMap!=null)
        {
            if(annotationMap.containsKey(annotationType))
            {
                return (T2)annotationMap.get(annotationType);
            }
        }
        return null;
    }
    public static <T> Map<Type,Annotation> get(Class<T> classType, Method method)
    {
        Map<Method, Map<Type,Annotation>> annotationInfoList =null;

        if(typeMappingInfo.containsKey(classType))
        {
            annotationInfoList=typeMappingInfo.get(classType);
        }
        else {
            annotationInfoList=getAnnotationInfoList(classType);
        }

        Map<Type,Annotation> annotationDataBindingInfo =null;

        if(annotationInfoList.containsKey(method))
        {
            annotationDataBindingInfo=annotationInfoList.get(method);
        }
        return annotationDataBindingInfo;
    }

    private static synchronized <T> Map<Method, Map<Type,Annotation>> getAnnotationInfoList(Class<T> classType)
    {
        Map<Method, Map<Type,Annotation>> annotationInfoList=null;
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

        Map<Type, Map<Method, Map<Type,Annotation>>>  newAnnotationList =
                new HashMap<Type, Map<Method, Map<Type,Annotation>>>();
        newAnnotationList.putAll(typeMappingInfo);

        Map<Method,Map<Type,Annotation>> mappingInfos;


        mappingInfos=getTypeInfo(classType);

        newAnnotationList.put(classType, mappingInfos);

        typeMappingInfo=newAnnotationList;


    }


    private static <T> Map<Method,  Map<Type,Annotation>> getTypeInfo(Class<T> classType)
    {
        Map<Method, Map<Type,Annotation>> mapInfo=new HashMap<Method,  Map<Type,Annotation>>();
        Method[] methods=classType.getMethods();
        for(int i=0;i<methods.length;i++)
        {
            Map<Type,Annotation> map=new HashMap<Type,Annotation>();
            Annotation[] annotations=methods[i].getAnnotations();
            if(annotations.length>0) {
                for (Annotation annotation:annotations)
                {
                    map.put(annotation.annotationType(),annotation);
                }

                mapInfo.put(methods[i], map);
            }

        }

        return mapInfo;
    }
}