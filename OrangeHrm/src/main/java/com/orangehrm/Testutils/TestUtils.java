package com.orangehrm.Testutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestUtils {
	
	public static WebDriver driver;
	public static Properties prop;
//	public Actions action = new Actions(driver);
	public JavascriptExecutor js = (JavascriptExecutor)driver;
	public Select select;
	
	public void highlightElement(WebElement element){
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}
	public void unhighlightElement(WebElement element){
		js.executeScript("arguments[0].style.border = '1px solid white'", element);
	}
	
}
