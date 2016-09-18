package com.myb.framework.serialization;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlSerializer {
	public static <T> String serialize(Object object,Class<T> c) {    
		XStream xStream=new XStream();
		xStream.processAnnotations(c);  
		String xmlString=xStream.toXML(object);
		return xmlString;
    }  
	
	
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String xmlString,Class<T> c){ 
    	
    	XStream xStream=new XStream(new DomDriver());
		xStream.processAnnotations(c);
		T obj = (T)xStream.fromXML(xmlString);
		return obj;
    }  
	
	
}
