package com.orangehrm.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
	@Ignore
	@Test(priority=4)
	public void similarUsernameandEmpname(){
		List<String> list = new ArrayList<String>();
		list.addAll(admin.matchUsernameandEmpname());
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test(priority=5, dataProvider = "New User")
	public void addNewUser(String userRole, String empName, String userName, String password, String cnfrmpassword){
		String newUserSuccessmsg = admin.AddNewUser(userRole, empName, userName, password, cnfrmpassword);
		System.out.println(newUserSuccessmsg);
	}
	
	@DataProvider(name = "New User")
	public Object[][] newUserValues(){
		return new Object[][]{
			{"ESS", "Alice Duval","vick.mehtaaaa","Abcd12@12","Abcd12@12"},
			{"Admin", "Anthony Nolan","rahul.bharadwajjj","Abcd12@12","Abcd12@12"},
		};
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
