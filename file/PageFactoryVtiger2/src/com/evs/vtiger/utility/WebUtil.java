package com.evs.vtiger.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebUtil {

	private WebDriver driver;
	private Properties props;

	public WebUtil() {
		try {
			props = new Properties();
			InputStream is = new FileInputStream("config.properties");

			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Properties getPropObj() {
		return props;
	}

	public WebDriver launchBrowser(String BrowserName) throws IOException {
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else
			getScreenShot();
		System.out.println(BrowserName + " Browser name is wrong . Please chacke it - ");
		return driver;
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public WebDriver getDriver() {

		return driver;

	}
	////////////////// WebElement ////////////////////////

	public void click(WebElement we) throws IOException {
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				we.click();
				System.out.println(" Element is clicked by WebElement ");
			} else
				getScreenShot();
			System.out.println(" Element is not Visible");
		} else
			getScreenShot();
		System.out.println(" Element is not clicked ");
	}

	public void sendKeys(WebElement we, String inputvalue) throws IOException {
		we.clear();
		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				we.sendKeys(inputvalue);
				System.out.println("value input successfully by WebElement ");
			} else
				getScreenShot();
			System.out.println("Element is not Displayed ");
		} else
			getScreenShot();
		System.out.println("Element is not input ");
	}

	public int getHight(WebElement we) throws IOException {
		int hig = 0;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				hig = we.getSize().getHeight();
				System.out.println(" Element hight is : " + hig);
			} else
				getScreenShot();
			System.out.println(" Element is not visible");
		} else
			getScreenShot();
		System.out.println(" Element is not displayed");

		return hig;
	}

	public int getWidth(WebElement we) throws IOException {
		int wid = 0;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				wid = we.getSize().getWidth();
				System.out.println(" Element Width is : " + wid);
			} else
				getScreenShot();
			System.out.println(" Element is  not visible");
		} else
			getScreenShot();
		System.out.println(" Element is not displayed");

		return wid;
	}

	public int getXlocation(WebElement we) throws IOException {
		int x = 0;
		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				x = we.getLocation().getX();
				System.out.println(" Element location of X : " + x);
			} else
				getScreenShot();
			System.out.println(" Element is not display");
		} else
			getScreenShot();
		System.out.println(" Element is not Enable");
		return x;
	}

	public int getYlocation(WebElement we) throws IOException {
		int y = 0;
		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				y = we.getLocation().getY();
				System.out.println("Element location of Y :  " + y);
			} else
				getScreenShot();
			System.out.println("Element is  not display");
		} else
			getScreenShot();
		System.out.println("Element is not showing on Enable");
		return y;
	}

	public String getInnerText(WebElement we) throws IOException {
		String text = null;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				text = we.getText();
				System.out.println("InerText of Element : " + text);
			} else
				getScreenShot();
			System.out.println("Element is not Enable");
		} else
			getScreenShot();
		System.out.println("Element is not displayed");
		return text;
	}

	public String getAttribute(WebElement we, String attributeName) throws IOException {
		String attributeValue = null;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				attributeValue = we.getAttribute(attributeName);
				System.out.println("InerText of Element: " + attributeValue);
			} else
				getScreenShot();
			System.out.println("Element is not Enabled");
		} else
			getScreenShot();
		System.out.println("Element is not displayed");
		return attributeValue;
	}

	public String getTagName(WebElement we) throws IOException {
		String tgn = null;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				tgn = we.getTagName();
				System.out.println("TagName of " + " : " + tgn);
			} else
				getScreenShot();
			System.out.println("Element is not Enable");
		} else
			getScreenShot();
		System.out.println("Element of tagname is not Displayed ");
		return tgn;
	}

	public void close() {
		driver.close();
		driver.quit();
	}

	///////////////////// DropDown ////////////////////

	public void selectByVisibleTextByUsingSelect(WebElement we, String Text) throws IOException {
		Select se = new Select(we);

		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.selectByVisibleText(Text);
				System.out.println(Text + " Element is selected by visibleText ");
			} else
				getScreenShot();
			System.out.println("DropDown Element is not enable : ");
		} else {
			getScreenShot();
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByIndexByUsingSelect(WebElement we, int index) throws IOException {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.selectByIndex(index);
				System.out.println(index + "Element is selected by index ");
			} else {
				getScreenShot();
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			getScreenShot();
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByvalueByUsingSelect(WebElement we, String value) throws IOException {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.selectByValue(value);
				System.out.println(value + "Element is selected by value ");
			} else {
				getScreenShot();
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			getScreenShot();
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void deselectByvalueByUsingSelect(WebElement we, String deselectbyvalue) throws IOException {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.deselectByValue(deselectbyvalue);
				System.out.println(deselectbyvalue + "Element is deselected by value ");
			} else {
				getScreenShot();
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			getScreenShot();
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void deselectByIndexByUsingSelect(WebElement we, int deselectbyindex) throws IOException {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.deselectByIndex(deselectbyindex);
				System.out.println(deselectbyindex + "Element is deselected by index ");
			} else
				getScreenShot();
			System.out.println("DropDown Element is not enable : ");
		} else
			getScreenShot();
		System.out.println("DropDown Element is not Displayed : ");
	}

	public void deselectAll(WebElement we) throws IOException {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.deselectAll();
				System.out.println(" All Element is deselected  ");
			} else
				getScreenShot();
			System.out.println("DropDown Element is not enable : ");
		} else
			getScreenShot();
		System.out.println("DropDown Element is not Displayed : ");
	}

	public boolean isSelected(WebElement we) {
		boolean slc = we.isSelected();
		System.out.println(we + "Element is selected ");
		return slc;
	}

	public boolean displayed(WebElement we) {
		boolean displ = we.isDisplayed();
		System.out.println(we + "Element is displayed ");
		return displ;
	}

	public boolean enabled(WebElement we) {
		boolean enalb = we.isEnabled();
		System.out.println(we + "Element is Enabled ");
		return enalb;
	}

	//////////////////// Actions /////////////////

	public void mouseOverByUsingAction(WebElement we) throws IOException {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					System.out.println("Element is clicked by Actions : ");
				}

			} else
				getScreenShot();
			System.out.println("Element is not Enable :");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");
	}

	public void ClickAndHoldByUSingAction(WebElement we) throws IOException {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			act.clickAndHold(we).build().perform();
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					System.out.println("Element is clicked and hold by actions");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not Display ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");

	}

	public void sendkeysByUsingAction(WebElement we, String input) throws IOException {
		Actions act = new Actions(driver);
		we.clear();
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.sendKeys(we, input).build().perform();
					System.out.println("Value input successfully by action");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not display : ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");
	}

	public void clickByUsingAction(WebElement we) throws IOException {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.click().build().perform();
					System.out.println("Element is clicked by Actions ");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not displayed : ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");
	}

	public void doudleClickByUsingAction(WebElement we) throws IOException {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.doubleClick(we).build().perform();
					System.out.println("Double click on element is successfully ");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not displayed : ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");
	}

	public void rightClickByUsingAction(WebElement we) throws IOException {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.contextClick(we).build().perform();
					System.out.println("Right click on element is successfully");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not displayed : ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");

	}

	public void dragAndDropByUsingAction(WebElement we1, WebElement ww2) throws IOException {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.dragAndDrop(we1, ww2).build().perform();
					System.out.println("Element is drag and drop successfully by drag and drop ");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not displayed : ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");
	}

	public void clickAndHoldByUsingAction(WebElement we1, WebElement ww2) throws IOException {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.clickAndHold(we1).moveToElement(ww2).release().build().perform();
					System.out.println("Element drag and drop and drop by move to element");
				} else
					getScreenShot();
				System.out.println("Element is not Enable :");
			} else
				getScreenShot();
			System.out.println("Element is not displayed : ");
		} else
			getScreenShot();
		System.out.println("Element is not find on HTML Page");
	}

	//////////////////////// Javascript /////////////////////////

	public void jsClick(WebElement we) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", we);
		System.out.println("Element is clicked by javascript ");
	}

	public void jsSendkeys(WebElement we, String inputvalue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=" + "'" + inputvalue + "'", we);
		System.out.println("Value is inputed by javascript ");
	}

	public void jsMouseOver(WebElement we) throws IOException {

		String strJs = "var element = argument[0];" + "var mouseEventObj=document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
		try {
			String mouseOverScript = "if(document.createEvent){var evObj =document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseOver' ,true, false);arguments[0].dispatchEvent(evObj);}"
					+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(strJs, we);
		} catch (Exception e) {
			getScreenShot();
			System.out.println("javaScript MouseOver is not click ");
		}
	}

	//////////////////////////// Wait /////////////////////////

	public void implicitWait(int timeInSecound) {

		driver.manage().timeouts().implicitlyWait(timeInSecound, TimeUnit.SECONDS);

	}

	public void staticWait(int timeInSecound) throws IOException {
		int secound = timeInSecound * 1000;
		try {
			Thread.sleep(secound);
			System.out.println("Static wait is puted ");
		} catch (InterruptedException e) {
			getScreenShot();
			e.printStackTrace();
		}

	}

	public void enabledElementwait(WebElement we, int timeInSecound) throws IOException {
		if (we.equals(we.isEnabled())) {
			WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
			expli.until(ExpectedConditions.elementToBeClickable(we));
		} else
			getScreenShot();
		System.out.println("Element is not Enabled");
	}

	public void selectedElementWait(WebElement we, int timeInSecound) throws IOException {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		if (we.equals(we.isSelected())) {
			expli.until(ExpectedConditions.elementToBeSelected(we));
		} else {
			getScreenShot();
			System.out.println("Element is not selected");
		}
	}

	public void visibleElementWait(WebElement we, int timeInSecound) throws IOException {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		if (we.equals(we.isDisplayed())) {
			expli.until(ExpectedConditions.visibilityOfAllElements(we));
		} else {
			getScreenShot();
			System.out.println("Element is not visible");
		}
	}

	/////////////////////// Alert //////////////////////

	public void popUpAccept(String popInnerText) {
		String text = driver.switchTo().alert().getText();
		if (text.equalsIgnoreCase(popInnerText)) {
			System.out.println(text);
			driver.switchTo().alert().accept();
		}

	}

	public void popUpdismiss(String popInnerText) {
		String text = driver.switchTo().alert().getText();
		if (text.equalsIgnoreCase(popInnerText)) {
			System.out.println(text);
			driver.switchTo().alert().dismiss();
		}
	}

	public String popUpGetText() {

		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void popUpSendKeys(String inputvalue) {

		driver.switchTo().alert().sendKeys(inputvalue);
	}

	/////////////////////// iFrame /////////////////////////

	public WebDriver switchToFrameByIdOrName(String IdValueOrNameValue) {
		WebDriver as = driver.switchTo().frame(IdValueOrNameValue);
		return as;
	}

	public WebDriver switchToFrameByWebElement(WebElement we) {
		WebDriver ss = driver.switchTo().frame(we);
		return ss;
	}

	public WebDriver switchToFrameByIndex(int frameNumber) {
		WebDriver cd = driver.switchTo().frame(frameNumber);
		return cd;
	}

	public WebDriver switchToParentFrame() {
		WebDriver we = driver.switchTo().parentFrame();
		return we;
	}

	public WebDriver switchToMainFrame() {
		WebDriver we = driver.switchTo().defaultContent();
		return we;
	}

	///////////////////// Window Handle ////////////////

	public void switchToWindowsByTitle(String title) {
		Set<String> window = driver.getWindowHandles();
		for (String multipleWindow : window) {
			driver.switchTo().window(multipleWindow);
			String tit = driver.getTitle();
			System.out.println(tit);
			if (tit.equalsIgnoreCase(title)) {

			}
		}

	}

	public void switchToWindowsByURL() {
		Set<String> window = driver.getWindowHandles();
		System.out.println(window);
		for (String multipleWindow : window) {
			driver.switchTo().window(multipleWindow);
			String url = driver.getCurrentUrl();
			System.out.println(url);

		}
	}

	public String switchToWindowByTitle() {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		String title = driver.getTitle();
		System.out.println(title);
		return window;

	}

	public String switchToWindowByURL() {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		return window;

	}

	public WebElement keys(WebElement we, String keysname) {
		if (keysname.equalsIgnoreCase("F5")) {
			we.sendKeys(Keys.F5);
		} else if (keysname.equalsIgnoreCase("Enter")) {
			we.sendKeys(Keys.ENTER);
		} else if (keysname.equalsIgnoreCase("Arrow Down")) {
			we.sendKeys(Keys.ARROW_DOWN);
		} else if (keysname.equalsIgnoreCase("Arrow Up")) {
			we.sendKeys(Keys.ARROW_UP);
		} else if (keysname.equalsIgnoreCase("Arrow Left")) {
			we.sendKeys(Keys.ARROW_LEFT);
		} else if (keysname.equalsIgnoreCase("Arrow Right")) {
			we.sendKeys(Keys.ARROW_RIGHT);
		}

		return we;

	}

	public void verifyInnerText(WebElement we, String expInnerText) throws IOException {
		String actualInnerText = getInnerText(we);
		if (actualInnerText.equalsIgnoreCase(expInnerText)) {
			System.out.println("Validation Passed. Where actual- " + actualInnerText + " & expected - " + expInnerText);
		    Reporter.log("Validation Passed- ");
		
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Where actual- " + actualInnerText + " & expected - " + expInnerText);
			Assert.assertEquals(actualInnerText, expInnerText);
		}
		

		
	}

	public void verifyInnerTextContains(WebElement we, String expInnerText) throws IOException {
		String actualInnerText = getInnerText(we);
		if (actualInnerText.contains(expInnerText)) {
			System.out.println("Validation Passed. Where actual- " + actualInnerText + " & expected - " + expInnerText);
		    Reporter.log("Validation Passed- ");

		} else {
			getScreenShot();
			System.out.println("Validation Failed. Where actual- " + actualInnerText + " & expected - " + expInnerText);
			Assert.assertEquals(actualInnerText, expInnerText);

		}

	}

	public void verifyAttribute(WebElement we, String expAttributeValue, String attributeName) throws IOException {
		String actualAttributeValue = getAttribute(we, attributeName);
		if (actualAttributeValue.contains(expAttributeValue)) {
			System.out.println(
					"Validation Passed. Where actual- " + actualAttributeValue + " & expected - " + expAttributeValue);
		} else {
			getScreenShot();
			System.out.println(
					"Validation Failed. Where actual- " + actualAttributeValue + " & expected - " + expAttributeValue);

		}

	}

	public void verifyEnabled(WebElement we) throws IOException {
		boolean actualEnableValue = we.isEnabled();
		if (actualEnableValue) {
			System.out.println("Validation Passed. Element is Enabled");
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Element is Disabled");

		}

	}

	public void verifyDisabled(WebElement we) throws IOException {
		boolean actualEnableValue = we.isEnabled();
		if (actualEnableValue == false) {
			System.out.println("Validation Passed. Element is Disabled");
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Element is Enabled");

		}

	}

	public void verifyChecked(WebElement we) throws IOException {
		boolean actualChecked = we.isSelected();
		if (actualChecked == true) {
			System.out.println("Validation Passed. Check box is checked");
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Check box is unchecked");

		}
	}

	public void verifyUnChecked(WebElement we) throws IOException {
		boolean actualChecked = we.isSelected();
		if (actualChecked == false) {
			System.out.println("Validation Passed. Check box is unchecked");
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Check box is checked");

		}
	}

	public void verifyTitle(String expTitle) throws IOException {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expTitle)) {
			System.out.println(
					"Validation Passed. Where Actual Title : " + actualTitle + " & Expected Title : " + expTitle);
		} else {
			getScreenShot();
			System.out.println(
					"Validation Failed. Where Actual Title : " + actualTitle + " & Expected Title : " + expTitle);

		}
	}

	public void verifyElementVisible(WebElement we) throws IOException {

		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			System.out.println("Validation Passed. Element is visible");
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Element is invisible");

		}
	}

	public void verifyElementInvisible(WebElement we) throws IOException {

		if (!we.isDisplayed() & we.getSize().getHeight() == 0 & we.getSize().getWidth() == 0) {
			System.out.println("Validation Passed. Element is invisible");
		} else {
			getScreenShot();
			System.out.println("Validation Failed. Element is visible");

		}
	}

	public void getScreenShot() {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File tempObj = tss.getScreenshotAs(OutputType.FILE);
		File flsPath = new File("ScreenShot/" + "Rishu" + ".png");
		try {
			Files.copy(tempObj, flsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getRandomNumber(int minNumber, int maxNumber) {
		int num = (int) (Math.random() * (maxNumber - minNumber + 1) + minNumber);
		System.out.println(num);
	}

}
