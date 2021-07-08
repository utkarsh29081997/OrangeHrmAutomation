package com.orangehrm.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.testbase.TestBase;

public class AdminPage extends TestBase {

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement adminPage;

	@FindBy(id = "searchSystemUser_userName")
	WebElement inputName;

	@FindBy(name = "_search")
	WebElement searchbtn;

	@FindBy(name = "_reset")
	WebElement resetbtn;

	@FindBy(id = "searchSystemUser_userType")
	WebElement userRoledrpdwn;

	@FindBy(xpath = "//div[@Id='customerList']//tbody//descendant::a[contains(text(),'Admin')]")
	WebElement srchResult;

	String beforexpath = "//div[@Id='customerList']//tbody//descendant::a[contains(text(),'" + prop.getProperty("name")
			+ "')]";

	public String verifyAdminpage() {
		String name = adminPage.getText();
		return name;
	}

	public String sendUsername() {
		inputName.sendKeys(prop.getProperty("name"));
		searchbtn.click();
		String result = driver.findElement(By.xpath(beforexpath)).getText();
		System.out.println("Send Username :::" + result);
		return result;
	}

	public String resetUsername(String uname) {
		inputName.sendKeys(uname);
		resetbtn.click();
		String username = inputName.getAttribute("value");
		return username;
	}

	public String srchUserbyRole() {
		Select select = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		select.selectByVisibleText("Admin");
		searchbtn.click();
		String result = driver.findElement(By.xpath(beforexpath)).getText();
		// String result = srchResult.getText();
		return result;
	}

	public List<String> matchUsernameandEmpname() {
		Select select = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		select.selectByVisibleText("Admin");
		searchbtn.click();

		List<WebElement> listofUsername = driver.findElements(By.xpath("//table[@class='table hover']//td[2]//a"));
		List<WebElement> listofEmpname = driver.findElements(By.xpath("//table[@class='table hover']//td[4]"));
		List<String> usernameregx = new ArrayList<String>();

		Iterator<WebElement> userit = listofUsername.iterator();
		Iterator<WebElement> empit = listofUsername.iterator();

		while (userit.hasNext() && empit.hasNext()) {
			String userName = userit.next().getText();
			String empName = empit.next().getText();
			String replaceUsername = userName.replace(".", " ");
			if (empName.equals(replaceUsername)) {
				usernameregx.add(replaceUsername);
			}
			else{
				usernameregx.add("No Same Values Found");
			}
		}
		return usernameregx;
	}

}
