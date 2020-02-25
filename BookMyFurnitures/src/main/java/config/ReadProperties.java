package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import util.TestUtil;

//Read Properties is reading data (browsertype and url) from config.properties file.
public class ReadProperties {
	public static Properties prop;
	Logger log = Logger.getLogger(ReadProperties.class);

	public ReadProperties() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}

	public String getApplicationURL() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

}
