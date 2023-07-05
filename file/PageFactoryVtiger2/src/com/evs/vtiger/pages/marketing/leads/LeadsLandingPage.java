package com.evs.vtiger.pages.marketing.leads;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utility.WebUtil;

public class LeadsLandingPage {
	
private WebUtil webUtil;

public LeadsLandingPage(WebUtil webUtil) {
	this.webUtil=webUtil;
	PageFactory.initElements(webUtil.getDriver(),this);
}
	@FindBy(xpath = "//img[contains(@title,'Create Lead')]")
	private WebElement weCreateLeads;

	
	public void clickCreateLeadBtn() throws IOException {
	webUtil.jsClick(weCreateLeads);
	 

		
	}
}
