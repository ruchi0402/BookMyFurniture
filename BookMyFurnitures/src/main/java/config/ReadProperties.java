package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static Properties prop;
	
	public static void readFromPropertyFile()
	{
	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}

}

