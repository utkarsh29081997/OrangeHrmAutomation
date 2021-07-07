package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.testbase.TestBase;
//@Listeners(com.orangehrm.listners.CustomListner.class)	
public class AdminPageTest extends TestBase{
	
	LoginPage login;
	HomePage home;
	AdminPage admin;
	
	public AdminPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		intialization();
		home = new HomePage();
		login = new LoginPage();
		admin = new AdminPage();
		System.out.println("Browser Launched");
		login.loginTest(prop.getProperty("uname"),prop.getProperty("pass"));
		System.out.println("Logged In");
		home.adminsec();
	}
	@Ignore
	@Test(priority=0)
	public void verifyAdminPage(){
		String name1 = admin.verifyAdminpage();
		System.out.println(name1);
	}
	
	@Ignore
	@Test(priority=1)
	public void sendUsername(){
		String Result = admin.sendUsername();
		System.out.println(Result);
		Assert.assertEquals(Result, prop.getProperty("DefaultListResult"));
	}
	
	@Ignore
	@Test(priority=2)
	@Parameters("Username")
	public void restUsername(@Optional("Shanu") String Username){
		String Result = admin.resetUsername(Username);
		System.out.println(Result);
		Assert.assertEquals(Result, "");
	}

	@Ignore
	@Test(priority=3)
	public void srchUserByRole(){
		String Result = admin.srchUserbyRole(); 
		System.out.println(Result);
		Assert.assertEquals(Result, "Linda.Anderson");
	}

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
