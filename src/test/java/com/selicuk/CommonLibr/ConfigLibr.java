package com.selicuk.CommonLibr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLibr {
	public static String ConfigValue = null;

	public String Readconfig(String Value) {
		File file = new File("CONFIG_FILE_PATH");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ConfigValue = prop.getProperty(Value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ConfigValue;
	}
}
