package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

    public static String getProperty(String key) throws IOException 
    {
    	
    		File f=new File("src/test/resources/config.properties");
    		FileInputStream fis=new FileInputStream(f);
    		
            Properties prop = new Properties();
            prop.load(fis);
            
            
           // prop.load(new FileInputStream("src/test/resources/config.properties"));
            return prop.getProperty(key);
        
    	
    }
    
    
}
