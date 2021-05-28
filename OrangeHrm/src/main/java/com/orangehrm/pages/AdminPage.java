package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testbase.TestBase;

public class AdminPage extends TestBase {
	
	public AdminPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='head']//h1")
	WebElement adminPage;
	
	public String verigyAdminpage(){
		String name = adminPage.getText();
		return name;
	}

	
}
