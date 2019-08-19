package com.selicuk.pageobjects;

import org.openqa.selenium.By;
import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.GenericLib;

public class Login_Page extends BaseClass {

	private By txtUsername;
	private By txtPassword;
	private By btnNext;

	public Login_Page() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		this.txtUsername = By.id("identifierId");
		this.txtPassword = By.name("password");
		this.btnNext = By.xpath("//font[text()='Next one']");
	}
	
	public boolean enterUsername(String userName) throws Exception {
		return genericLib.inputText(this.txtUsername, userName);
	}
	
	public boolean enterPassword(String passWord) throws Exception {
		return genericLib.inputText(this.txtPassword, passWord);
	}
	
	public boolean clickNext() throws Exception {
		return genericLib.clickElement(this.btnNext);
	}

}
