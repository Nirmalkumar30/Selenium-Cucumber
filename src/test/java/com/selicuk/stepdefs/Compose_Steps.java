package com.selicuk.stepdefs;

import static org.testng.Assert.assertEquals;

import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.ConfigLibr;
import com.selicuk.CommonLibr.GenericLib;
import com.selicuk.pageobjects.Compose_Page;

import cucumber.api.java8.En;

public class Compose_Steps extends BaseClass implements En {

	public Compose_Steps() throws Exception {

		configLib = new ConfigLibr();
		composePg = new Compose_Page();
		genericLib = new GenericLib();

		Given("User click on the compose button$", () -> {
			try {
				boolean result = composePg.clickCompose();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Given("User enters receiptent mail id as '(.*)' in the to field$", (String ReceiptentID) -> {
			try {
				boolean result = composePg.enterReceiverMail(ReceiptentID);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Given("User enters receiptent subject as '(.*)' in the to field$", (String Subject) -> {
			try {
				boolean result = composePg.enterSubject(Subject);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		When("User compose the message in the mail body as '(.*)' in the to field$", (String MailBody) -> {
			try {
				boolean result = composePg.enterMessage(MailBody);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("User click on the Send button$", () -> {
			try {
				boolean result = composePg.clickSend();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
}
