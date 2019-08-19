package com.selicuk.pageobjects;

import org.openqa.selenium.By;
import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.GenericLib;

public class Logout_Page extends BaseClass {

	private By btnUser;
	private By btnSignout;

	public Logout_Page() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		this.btnUser = By.className("gb_Ba gbii");
		this.btnSignout = By.xpath("//a[text()='Sign out']");
	}

	public boolean clickProfile() throws Exception {
		return genericLib.clickElement(this.btnUser);
	}

	public boolean clickSignout() throws Exception {
		return genericLib.clickElement(this.btnSignout);
	}
}
