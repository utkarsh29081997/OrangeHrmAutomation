package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testbase.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='txtUsername']")
	WebElement username;
	//By username = By.xpath("//input[@name='txtUsername']");
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	//By password = By.xpath("//input[@id='txtPassword']");
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement orangeImage;
	//By orangeImage = By.xpath("//div[@id='divLogo']//img");
	
	public String validatepageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatepageLogo(){
		return orangeImage.isDisplayed();
	}
	
	public HomePage loginTest(String un,String pass){
		
		username.sendKeys(un);
		password.sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		return new HomePage();
	}
	
	
}
