package com.myb.codebuilder;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/28.
 */
public class StringTemplate
{
    private static Configuration configuration = null;

    private static final String ENCODING = "UTF-8";

    public StringTemplate() throws IOException {
        String path=Thread.currentThread().getContextClassLoader().getResource("").getPath()+"template";
        configuration=new Configuration();
        configuration.setDirectoryForTemplateLoading(new File(path));
        configuration.setDefaultEncoding(ENCODING);
        configuration.setObjectWrapper(new DefaultObjectWrapper());
    }


    public String process(String templateName,Map<String, Object> parameters) throws IOException,
            TemplateException {
        Map<String, Object> root=new HashMap<String,Object>();
        if(parameters!=null)
        {
            for (String key : parameters.keySet()) {
                root.put(key, parameters.get(key));
            }
        }
        Template template = configuration.getTemplate(templateName);
        StringWriter stringWriter = new StringWriter();
        template.process(root, stringWriter);
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.toString();
    }

}

