package com.evs.vtiger.pages.marketing.campaings;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utility.WebUtil;


public class CampaingsLandingPage {
	private WebUtil webUtil;
public CampaingsLandingPage(WebUtil webUtil) {
	this.webUtil=webUtil;
	PageFactory.initElements(webUtil.getDriver(),this);
	
}
@FindBy(xpath = "//img[@title='Create Campaign...']")	
private WebElement weClickBtnCampaings;



public void clickCmpCreateBtn() throws IOException {
	webUtil.click(weClickBtnCampaings);
	
}
	
}
