package com.orangehrm.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream  ip = new FileInputStream(System.getProperty("user.dir")+"/orangehrm.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void intialization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "S:\\studyparts\\Drivers\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			System.setProperty("webdriver.gecko.driver", "S:\\studyparts\\Drivers\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS)
		int year = Calendar.getInstance().get(Calendar.YEAR);	
		driver.get(prop.getProperty("url"));
	}

	public void failed(){
		File files = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(files,new File("C:/Users/user/git/OrangeHrmAutomation/OrangeHrm/Screenshot/TestFailure.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
		
	
}
