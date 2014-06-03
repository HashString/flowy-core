package com.flowy.core.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ssinghal
 * Created on 03-Jun-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public class ConfigHandler {

    private static final Properties prop;
    private static final String MONGO_CONFIG_PROPS = "mongo-config.properties";

    static {
        prop = new Properties();
        try {
            prop.load(ConfigHandler.class.getClassLoader().getResourceAsStream(MONGO_CONFIG_PROPS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
