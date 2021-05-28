package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.testbase.TestBase;


public class LoginPageTest extends TestBase {
	LoginPage login;

	public 	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		intialization();
		login = new LoginPage();
		System.out.println("Browser Launched");
	}
	@Test(priority=0)
	public void titleCheck(){
		String title = login.validatepageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		login.loginTest(prop.getProperty("uname"),prop.getProperty("pass"));
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
