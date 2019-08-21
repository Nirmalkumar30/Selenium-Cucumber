package com.selicuk.stepdefs;

import static org.testng.Assert.assertEquals;

import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.ConfigLibr;
import com.selicuk.CommonLibr.GenericLib;
import com.selicuk.pageobjects.Login_Page;

import cucumber.api.java8.En;

public class Login_Steps extends BaseClass implements En {
	
	
	public Login_Steps() throws Exception  {

		
		configLib = new ConfigLibr();
		loginPg = new Login_Page();
		genericLib = new GenericLib();
		
		Given("User enter the correct email id as '(.*)' in the email address field after launching the application$", (String emailID) -> {
			try {
				boolean result = loginPg.enterUsername(emailID);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		When("User click on the Next button$", () -> {
			try {
				boolean result = loginPg.clickNext();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Given("User enter the correct password as '(.*)' in the password field$", (String password) -> {
			try {
				boolean result = loginPg.enterPassword(password);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("User should able to navigate to the inbox page$", () -> {
			try {
				boolean result = genericLib.Verifyurl("#inbox");
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		

	}
}
