package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testbase.TestBase;

public class HomePage extends TestBase{
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Welcome Paul']")
	WebElement Username;
	
	@FindBy(xpath="//b[text()='Admin']")
	WebElement adminSec;
	
	public String validateHomepage(){
		return Username.getText();
	}
	
	public AdminPage adminsec(){
		adminSec.click();
		return new AdminPage();
	}
}
