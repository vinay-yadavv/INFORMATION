package com.evs.vtiger.pages.marketing.campaings;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.or.campaings.pages.OrCampaings;
import com.evs.vtiger.utility.WebUtil;

public class CampaingsCreatePage extends OrCampaings {

	private WebUtil webUtil;
	public CampaingsCreatePage(WebUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement weCampaignname;

	public void enterMandetaryInfo() throws IOException {
		webUtil.click(weCampaignname);
	}

	public void saveCampaigns() throws IOException {
		webUtil.click(commonSaveBtn);
	}

	public void cancleCampaings() throws IOException {
		webUtil.click(commonCanvelBtn);
	}








}
