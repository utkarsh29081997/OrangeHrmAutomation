package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.testbase.TestBase;
@Listeners(com.orangehrm.listners.CustomListner.class)	
public class AdminPageTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	AdminPage admin;
	
	public AdminPageTest(){
		super();
	}
	
	@BeforeTest
	public void setup(){
		intialization();
		home = new HomePage();
		login = new LoginPage();
		System.out.println("Browser Launched");
		login.loginTest(prop.getProperty("uname"),prop.getProperty("pass"));
		System.out.println("Logged In");
		home = new HomePage();
		home.adminsec();
	}
	
	@Test
	public void verifyAdminPage(){
		String name1 = admin.verigyAdminpage();
		System.out.println(name1);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
