package com.orangehrm.pages;

import org.openqa.selenium.support.PageFactory;

import com.orangehrm.testbase.TestBase;

public class PIMpage extends TestBase {
	public PIMpage(){
		PageFactory.initElements(driver, this);
	}

}
