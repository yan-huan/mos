
package com.myb.framework.config;

import java.io.IOException;

import com.myb.framework.caching.Cache;
import com.myb.framework.serialization.XmlSerializer;
import com.myb.framework.util.FileUtil;

public class ConfigManager {

    public static ConfigFiles getConfigFiles() throws IOException {
        String key = "configFiles";
        ConfigFiles configFiles = Cache.get(key, ConfigFiles.class);
        if (configFiles == null)
        {
            String fileName=java.net.URLDecoder.decode(ConfigManager.class.getResource("/").getPath(),"utf-8")+"config/config_files.xml";
            String xmlString= FileUtil.read(fileName);
            configFiles = XmlSerializer.deserialize(xmlString, ConfigFiles.class);
            Cache.set(key, configFiles, fileName);
        }
        return configFiles;
    }

    public static AppConfig getAppConfig() throws IOException
    {

        String key = "appConfig";
        AppConfig appConfig = getConfig(key, AppConfig.class);
        return appConfig;
    }

    public static RSConfig getRSConfig() throws IOException
    {

        String key = "resourceConfig";
        RSConfig rsConfig = getConfig(key, RSConfig.class);
        return rsConfig;
    }

    public static ParameterManager getParameterConfig() throws IOException
    {

        String key = "parameterConfig";
        ParameterManager parameterManager =getConfig(key,ParameterManager.class);
        return parameterManager;
    }

    public static <T> T getConfig(String key,Class<T> t) throws IOException {
        T config = Cache.get(key, t);
        if (config == null)
        {
        	System.out.println(ConfigManager.class.getResource("/").getPath());
            String pathString=java.net.URLDecoder.decode(ConfigManager.class.getResource("/").getPath(),"utf-8");
            String fileName=pathString+getConfigFiles().get(key).getPath();
            System.out.println(fileName);
            String xmlString=FileUtil.read(fileName);
            config = XmlSerializer.deserialize(xmlString, t);
            Cache.set(key, config, fileName);
        }
        return config;
    }


}