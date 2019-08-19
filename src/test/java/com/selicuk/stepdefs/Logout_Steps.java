package com.selicuk.stepdefs;

import static org.testng.Assert.assertEquals;

import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.ConfigLibr;
import com.selicuk.CommonLibr.GenericLib;
import com.selicuk.pageobjects.Logout_Page;

import cucumber.api.java8.En;

public class Logout_Steps extends BaseClass implements En {

	public Logout_Steps() throws Exception {

		configLib = new ConfigLibr();
		logoutPg = new Logout_Page();
		genericLib = new GenericLib();

		Given("User click on the profile button$", () -> {
			try {
				boolean result = logoutPg.clickProfile();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		When("User click on the signout button$", () -> {
			try {
				boolean result = logoutPg.clickSignout();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Then("User should able to navigate to the login page$", () -> {
			try {
				boolean result = genericLib.Verifyurl("ServiceLogin");
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});


	}
}
