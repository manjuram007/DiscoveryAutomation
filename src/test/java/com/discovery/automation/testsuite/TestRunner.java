package com.discovery.automation.testsuite;
 
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.discovery.automation.ConfigFileReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
  format = {"pretty", "json:target/json/output.json"}
 ,features = "resources/featurefile/End2EndTest.feature"
 ,glue={"com.discovery.automation.stepdefinitions"}
 ,dryRun = false
 ,tags= {"@videovalidation"}
 ,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
 ,monochrome = true
 )
 
public class TestRunner {
	
static ConfigFileReader ConfigfileReader = new ConfigFileReader();
	
	@AfterClass
	
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(ConfigfileReader.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.11.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_131");
	}
 
}