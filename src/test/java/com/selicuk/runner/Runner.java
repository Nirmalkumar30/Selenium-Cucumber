package com.selicuk.runner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selicuk.CommonLibr.BaseClass;
import com.selicuk.CommonLibr.ConfigLibr;
import com.selicuk.CommonLibr.GenericLib;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.Utils;



@CucumberOptions(features = {
		 "src/test/resources/features/Sanity/",
	}, glue = { "com.selicuk.stepdefs",
				"com.selicuk.serviceHooks" },
		// tags = {"~@Ignore"},

		format = { "pretty", "html:REPORT_PATH/cucumber-reports/cucumber-pretty",
				"json:REPORT_PATH/cucumber-reports/CucumberTestReport.json",
				"rerun:REPORT_PATH/cucumber-reports/rerun.txt" }, monochrome = true)

public class Runner extends BaseClass {

	private static String browser;
	private TestNGCucumberRunner testNGCucumberRunner;
	private static ChromeOptions options;

	public Runner() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
	}

	@BeforeSuite(alwaysRun = true)
	public static void init() {
		configLib = new ConfigLibr();
		browser = System.getProperty("browser");
		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "CHROME_DRIVER_PATH");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
				capabilities.setCapability("nativeEvents", true);
				options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "IE_DRIVER_PATH");
				driver = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "GECO_DRIVER_PATH");
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void beforeScenario() {
		System.out.println("This will run before the Scenario");
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		driver = new ChromeDriver(options);
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		driver.quit();
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				System.out.println("Fails");
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
						"IMAGE_PATH.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			scenario.write(Utils.htmlEscape(driver.getPageSource()));
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

	@AfterSuite(alwaysRun = true)
	public void closeBroser() {

	}
}
