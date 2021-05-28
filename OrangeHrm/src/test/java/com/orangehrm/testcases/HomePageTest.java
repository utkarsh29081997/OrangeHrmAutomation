package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.testbase.TestBase;
@Listeners(com.orangehrm.listners.CustomListner.class)	
public class HomePageTest extends TestBase{
	HomePage home;
	LoginPage login;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		intialization();
		home = new HomePage();
		login = new LoginPage();
		System.out.println("Browser Launched");
		login.loginTest(prop.getProperty("uname"),prop.getProperty("pass"));
		System.out.println("Logged In");
	}
	
	@Test
	public void checkDashBoardTitle() throws InterruptedException{
		String title = home.validateHomepage();
		Assert.assertEquals(title, "Welcome Paul");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
