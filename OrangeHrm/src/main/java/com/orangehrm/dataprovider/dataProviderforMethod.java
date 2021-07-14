package com.orangehrm.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class dataProviderforMethod {

	// Provide data to one single method
	@DataProvider(name = "New User")
	public Object[][] newUserValues(){
		return new Object[][]{
			{"ESS", "Alice Duval","vix.mehta","Abcd12@12","Abcd12@12"},
			{"Admin", "Anthony Nolan","rush.bharadwaj","Abcd12@12","Abcd12@12"},
		};
	}
	
	// Provide data to different methods 
	@DataProvider(name = "User Values wrt methods")
	public Object[][] valuesfordifferentMethods(Method m){
		if(m.getName().equalsIgnoreCase("addNewUser")){
		return new Object[][]{
			{"ESS", "Alice Duval","poona.mehta","Abcd12@12","Abcd12@12"},
			{"Admin", "Anthony Nolan","paya.bharadwaj","Abcd12@12","Abcd12@12"},
		};
		}
		else{
			return new Object[][]{
				{"No Data to be provided"}
			};
		}
	}
	
}
