package com.minimarket.cashiers;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by sw84437 on 3/9/2016.
 */
public class Config {

    public static final String propFileName = "config.properties";
    private Properties properties = new Properties();
    private Logger logger = Logger.getLogger(Config.class);

    public Config() {
        init();
    }

    public void init() {
        InputStream inputStream = Config.class.getResourceAsStream(propFileName);
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            logger.error("can't open config", e);
        }
    }



    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
