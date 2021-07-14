package com.orangehrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMpage;
import com.orangehrm.testbase.TestBase;

public class PIMpageTest extends TestBase{
	AdminPage admin;
	LoginPage login;
	PIMpage pim;
	public PIMpageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		intialization();
		admin = new AdminPage();
		login = new LoginPage();
		pim = new PIMpage();
		System.out.println("Browser Launched");
		login.loginTest(prop.getProperty("uname"),prop.getProperty("pass"));
		System.out.println("Logged In");
		admin.PIMsection();
	}
	
	@Test
	public void check(){
		System.out.println("Reached 2");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
