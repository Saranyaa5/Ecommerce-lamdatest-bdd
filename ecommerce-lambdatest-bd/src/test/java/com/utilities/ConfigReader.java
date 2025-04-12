//package com.utilities;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class ConfigReader {
//    private static Properties prop = new Properties();
//
//    public static void loadProperties(String filePath) {
//        try {
//            FileInputStream fis = new FileInputStream(filePath);
//            prop.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String getProperty(String key) {
//        return prop.getProperty(key);
//    }
//    
//}

package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    public static void loadProperties(String filePath) {
      
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (input != null) {
                prop.load(input);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (InputStream input = new FileInputStream(Paths.get(filePath).toFile())) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file from both classpath and filesystem: " + filePath, e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}