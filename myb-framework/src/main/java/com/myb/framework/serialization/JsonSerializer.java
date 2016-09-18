package com.myb.framework.serialization;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonSerializer {
	
	private static ObjectMapper mapper=new ObjectMapper();
	
	public static String serializeObject(Object obj) throws JsonProcessingException {
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		return mapper.writeValueAsString(obj);
	}
	
	public static <T> T deserializeObject(String json, Class<T> c) throws JsonParseException, JsonMappingException, IOException{
	    T o = null;

	    o = mapper.readValue(json, c);
	    return o; 
	}

}
