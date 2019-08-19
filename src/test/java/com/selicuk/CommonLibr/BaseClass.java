package com.selicuk.CommonLibr;

import org.openqa.selenium.WebDriver;

import com.selicuk.pageobjects.Compose_Page;
import com.selicuk.pageobjects.Login_Page;
import com.selicuk.pageobjects.Logout_Page;




public class BaseClass {

	public static WebDriver driver = null;
	public static GenericLib genericLib;
	public static ConfigLibr configLib;
	public static Login_Page loginPg;
	public static Compose_Page composePg;
	public static Logout_Page logoutPg;

}
