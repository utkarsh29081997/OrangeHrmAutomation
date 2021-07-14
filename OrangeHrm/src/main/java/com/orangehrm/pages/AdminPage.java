package com.orangehrm.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.taskdefs.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

	@FindBy(id = "btnAdd")
	WebElement addNewUserbtn;
	
	@FindBy( id = "systemUser_employeeName_empName")
	WebElement inputEmpname;

	@FindBy( id = "systemUser_userName")
	WebElement inputnewUsername;
	
	@FindBy( id = "systemUser_password")
	WebElement inputUserpassword;

	@FindBy( id = "systemUser_confirmPassword")
	WebElement inputUsercnfrmpassword;

	@FindBy( id = "btnSave")
	WebElement saveButton;
	
	@FindBy(xpath = "//b[contains(text(),'PIM')]")
	WebElement pathforPIMpage;
	
//	@FindBy(xpath = "//div[@class='message success fadable']")
	String successMsg = "//div[@class='message success fadable']";
	
	// message success fadable
	
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
		select = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		select.selectByVisibleText("Admin");
		searchbtn.click();
		String result = driver.findElement(By.xpath(beforexpath)).getText();
		// String result = srchResult.getText();
		return result;
	}

	public List<String> matchUsernameandEmpname() {
		select = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		select.selectByVisibleText("Admin");
		searchbtn.click();

		List<WebElement> listofUsername = driver.findElements(By.xpath("//table[@class='table hover']//td[2]//a"));
		List<WebElement> listofEmpname = driver.findElements(By.xpath("//table[@class='table hover']//td[4]"));
		List<String> usernameregx = new ArrayList<String>();

		Iterator<WebElement> userit = listofUsername.iterator();
		Iterator<WebElement> empit = listofEmpname.iterator();

		while (userit.hasNext() && empit.hasNext()) {
			String userName = userit.next().getText();
			String empName = empit.next().getText();
			String replaceUsername = userName.replace(".", " ");
			if (empName.equals(replaceUsername)) {
				usernameregx.add(replaceUsername);
			}
		}
		return usernameregx;
	}

	public String AddNewUser(String userRole, String empName, String userName, String password, String cnfrmpassword) throws InterruptedException {
		addNewUserbtn.click();
		select = new Select(driver.findElement(By.id("systemUser_userType")));
		select.selectByVisibleText(userRole);
		
		// Capturing all the Elements from WebPage
		WebElement elements[] = {inputEmpname,inputnewUsername,inputUserpassword,inputUsercnfrmpassword}; 
		
		// Arguments to be passed to the elements
		String arguments[] = {empName,userName,password,cnfrmpassword};
		
		// Adding elements from WebElement array as Key and elements from arguments as Values
		//  Used Map because HashMap is not synchronized 
		Map<WebElement, String> hm = new HashMap<WebElement, String>();
		for(int i = 0;i<=elements.length-1;i++){
			for(int j=i;j<=i;j++){
				System.out.println(arguments[j]);
				hm.put(elements[i], arguments[j]);
			}
		}
		
		// Sending Key and Value from HashMap
		for(Map.Entry entry : hm.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
			WebElement element =  (WebElement) entry.getKey();
			highlightElement(element);
			String valuetoSend = (String) entry.getValue();
			element.sendKeys(valuetoSend);
			unhighlightElement(element);
		}
		
//		inputEmpname.sendKeys(empName);
//		inputnewUsername.sendKeys(userName);
//		inputUserpassword.sendKeys(password);
//		inputUsercnfrmpassword.sendKeys(cnfrmpassword);
		Thread.sleep(6000);
		saveButton.click();
	//	Thread.sleep(6000);
	//	System.out.println(verifyAdminpage());
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement sucsMsg;
//		sucsMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
		String Msg = driver.findElement(By.xpath(successMsg)).getText();
		
		return Msg;
	}
	
//	public PIMpage PIMsection(){	
//		Action mouseOverPIM = action.moveToElement(pathforPIMpage).build();
//		mouseOverPIM.perform();
//		return new PIMpage();
//	}
}
