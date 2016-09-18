package com.myb.framework.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(value=java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface DataMapping {
	String value();
}
