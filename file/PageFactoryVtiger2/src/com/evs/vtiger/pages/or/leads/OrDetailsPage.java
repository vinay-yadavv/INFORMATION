package com.evs.vtiger.pages.or.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrDetailsPage extends OrCommon {
	
	@FindBy(xpath ="//span[text()='WebView Solutions']")
	protected WebElement companyName;
	
	@FindBy(xpath = "//span[text()='Yadav']")
	public WebElement lastName ;
	
	@FindBy(xpath ="//td[@class='moduleName']")
	protected WebElement moduleNamer;
}
