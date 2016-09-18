package com.myb.framework.config;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Parameters")
public class ParameterManager {
	

	@XStreamImplicit(itemFieldName="Parameter")
	private List<Parameter> parameters;

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	
	public String get(String name)
	{
		String value="";
		if(parameters!=null)
		{
			for(Parameter parameter:parameters)
			{
				if(parameter.getName().equals(name))
				{
					value=parameter.getValue();
					break;
				}
			}
		}
		return value;
	}
	

}
