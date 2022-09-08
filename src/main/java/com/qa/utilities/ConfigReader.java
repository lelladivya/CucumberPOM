package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop;

	/**
	 * this method is used to load the properties from config.properties file
	 * 
	 * @return properties prop object.
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream fileIp = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fileIp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
