package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import util.TestUtil;

//Read Properties is reading data (browsertype and url) from config.properties file.
public class ReadProperties {
	public static Properties prop;
	static Logger log = Logger.getLogger(ReadProperties.class);

	public static void readFromPropertyFile() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
			prop.load(ip);

		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}

}
