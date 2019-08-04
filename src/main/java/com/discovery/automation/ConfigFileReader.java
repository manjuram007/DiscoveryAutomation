package com.discovery.automation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.discovery.automation.Enum.DriverType;



public class ConfigFileReader {
	private Properties prop;
	private final String propertyFilePath= "ConfigFile.properties";

	//Loading
	public ConfigFileReader(){
		BufferedReader read;
		try {
			read = new BufferedReader(new FileReader(propertyFilePath));
			prop = new Properties();
			try {
				prop.load(read);
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid file " + propertyFilePath);
		}		
	}

	
	//DriverPath
	public String getDriverPath(){
		String driverPath = prop.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Invalid file path.");		
	}


	//Application url
	public String getApplicationUrl(String para) {
		String url = prop.getProperty(para);
		if(url != null) return url;
		else throw new RuntimeException("Undefined");
	}

	//Browser call 
	public DriverType getBrowser() {
		String browserName = prop.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("ieExplorer")) return DriverType.INTERNETEXPLORER;

		else throw new RuntimeException("Invalid path" + browserName);
	}


	//Window maximize
	public Boolean getBrowserWindowSize() {
		String windowSize = prop.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}

	//Report generation
	public String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}


}
