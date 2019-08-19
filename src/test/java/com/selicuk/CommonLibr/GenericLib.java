package com.selicuk.CommonLibr;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class GenericLib extends BaseClass {

	public GenericLib() {
		// TODO Auto-generated constructor stub

	}

	public void navigateUrl(String app_url) {
		driver.get(app_url);
	}

	// Get Text
	public String getText(By by) throws Exception {
		String textVal = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			System.out.println(e1);
			if (e1.isDisplayed()) {
				textVal = e1.getText();
				System.out.println(textVal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return textVal;
	}

	// Enter Value in edit field
	public boolean inputText(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(by));
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().build().perform();
				e1.clear();
				e1.sendKeys(data);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean inputWithoutClick(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				e1.sendKeys(data);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean setText(By by, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				js.executeScript("arguments[0].setAttribute('style', 'background: LIME; border: 2px solid red;');", e1);
				js.executeScript("arguments[0].value='" + data + "';", e1);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean checkVisible(By by, int timeout) throws IOException {
		// Click Button
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// Random String
	public String generateString() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 6; i++)
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		strRandom = strRandomNumber.toString() + "7";
		return strRandom;
	}

	// Click Button
	public boolean clickifExist(By by) throws IOException {
		// Click Button
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Thread.sleep(1000);
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				js.executeScript("arguments[0].click();", e1);
			} 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickElement(By by) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(by));
			if ((e1.isDisplayed() && e1.isEnabled())) {
				e1.click();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Click Element
	public boolean doubleClick(By by) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(by));
			if ((e1.isDisplayed())) {
				Actions actions = new Actions(driver);
				actions.doubleClick(e1).perform();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void closeBrowser() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public void closeAllBrowser() throws Exception {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void confirmAlert() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dismissAlert() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.dismiss();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void doubleClick(By by, String elementname) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions builder = new Actions(driver);
				builder.doubleClick(e1).perform();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void reloadPage() throws Exception {
		// Refresh
		try {
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void selectCheckbox(By by, String elementname) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {

				} else {
					e1.click();
					Thread.sleep(2000);

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectCheckbox(By by, String elementname) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					e1.click();
					Thread.sleep(2000);
				} else {

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean selectByIndex(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				int val = Integer.parseInt(data);
				se.selectByIndex(val);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public void unselectByIndex(By by, String elementname, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				int val = Integer.parseInt(data);
				se.deselectByIndex(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean selectByText(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				se.selectByVisibleText(data);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectOptionByPartText(String by, String partialText) {
		try {
			driver.findElement(By.xpath(
					"//select[@id ='" + by.trim() + "']//option[contains(text(), '" + partialText.trim() + "')]"))
					.click();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public void unselectByText(By by, String elementname, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				se.deselectByVisibleText(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectAll(By by, String elementname, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				se.deselectAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void verifyTitle(String Text) throws Exception {
		try {
			// test.log(Status.INFO, "Verify title of page is" + Text);
			if (driver.getTitle().contains(Text)) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean VerifyText(String Expected, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		String Actual = driver.findElement(by).getText().trim();
		if (Actual.equalsIgnoreCase(Expected)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean compareText(String value1, String value2) {
		if ((value1.equals(value2))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Verifyurl(String Expected) throws IOException {
		try {
			String currenturl;
			for (int i = 1; i < 120; i++) {
				Thread.sleep(1000);
				currenturl = driver.getCurrentUrl();
				if (currenturl.contains(Expected)) {
					break;
				}
			}
			currenturl = driver.getCurrentUrl();
			if (currenturl.contains(Expected)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {		
			e.printStackTrace();
			return true;
		}
	}

	public boolean selectByValue(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				se.selectByValue(data);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public void unselectByValue(By by, String elementname, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				se.deselectByValue(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void selectWindow() throws Exception {
		try {
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String ChildWindow = i1.next();
				driver.switchTo().window(ChildWindow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchDefault() throws Exception {
		// Switch Default Window
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void frameByIndex(int Input) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Input));
			driver.switchTo().frame(Input);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void frameByelement(By by) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
			WebElement e1 = driver.findElement(by);
			driver.switchTo().frame(e1);
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void waitTillElementEnable(By by) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean waitTillElementDisable(By by) throws Exception {
		boolean result = false;
		try {
			for (int i = 0; i < 100; i++) {
				if (driver.findElement(by).isEnabled()) {
					Thread.sleep(500);
					result = false;
				} else {
					result = true;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	

	public void waitTillTextVisible(By by, String elementName) throws Exception {
		boolean val = false;
		try {
			for (int i = 0; i < 100; i++) {
				val = this.VerifyText(elementName, by);
				if (val == true) {
					break;
				} else
					Thread.sleep(1000);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean waitTillAdPopup(By by) throws Exception {

		boolean result = false;
		try {
			for (int i = 0; i < 3; i++) {
				if (driver.findElement(by).isDisplayed()) {
					Thread.sleep(1000);
					result = false;
				} else {
					result = true;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}




	public void scrollDown(int position) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + position + ")");
	}

	public File takeScreenShot(Scenario methodName) {
		String path = "ImageName.png";
		File screenshotFile = null;
		try {
			screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenshotFile;
	}
}
