package com.orangehrm.listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangehrm.testbase.TestBase;

public class CustomListner extends TestBase implements ITestListener{
	
	public void onTestFailure(ITestResult results) {					
		System.out.println("Failed Case "+results.getMethod().getMethodName());
        failed();
    }
}
