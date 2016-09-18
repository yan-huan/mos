package com.myb.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by gaitianyu on 2014/6/24.
 */
public class FieldAnnotation {
    private Field field;

    private Map<Type,Annotation> annotationMap;

    public Field getField() {
        return field;
    }

    public Map<Type, Annotation> getAnnotationMap() {
        return annotationMap;
    }

    public void setAnnotationMap(Map<Type, Annotation> annotationMap) {
        this.annotationMap = annotationMap;
    }

    public void setField(Field field) {
        this.field = field;
    }


}
