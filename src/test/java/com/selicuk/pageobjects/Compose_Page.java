package com.selicuk.pageobjects;

import org.openqa.selenium.By;
import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.GenericLib;

public class Compose_Page extends BaseClass {

	private By btnCompose;
	private By txtReceiverMail;
	private By txtSubject;
	private By txtMessage;
	private By btnsend;

	public Compose_Page() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		this.btnCompose = By.xpath("//div[@role='button' and text()='Compose']");
		this.txtReceiverMail = By.name("password");
		this.txtSubject = By.xpath("//font[text()='Next one']");
		this.txtMessage = By.name("password");
		this.btnsend = By.xpath("//font[text()='Next one']");
	}
	
	public boolean clickCompose() throws Exception {
		return genericLib.clickElement(this.btnCompose);
	}
	
	public boolean enterReceiverMail(String receiverMail) throws Exception {
		return genericLib.inputText(this.txtReceiverMail, receiverMail);
	}
	
	public boolean enterSubject(String subject) throws Exception {
		return genericLib.inputText(this.txtSubject, subject);
	}
	
	public boolean enterMessage(String message) throws Exception {
		return genericLib.inputText(this.txtMessage, message);
	}
	
	public boolean clickSend() throws Exception {
		return genericLib.clickElement(this.btnsend);
	}
}
