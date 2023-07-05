package com.evs.vtiger.pages.home;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.or.home.OrHomePage;
import com.evs.vtiger.pages.login.LoginPage;
import com.evs.vtiger.pages.marketing.leads.LeadsLandingPage;
import com.evs.vtiger.utility.WebUtil;

public class HomePage extends OrHomePage {

	private WebUtil webUtil;

	public HomePage(WebUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[text()='Marketing']")
	private WebElement weActMouseOver;

	@FindBy(xpath = "(//a[text()='Leads'])[3]")
	private WebElement weClickOnLeads;

	@FindBy(xpath = "(//a[text()='Accounts'])[3]")
	private WebElement weAccounts;

	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement weCampaigns;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Contacts']")
	private WebElement weContacts;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Webmail']")
	private WebElement weWebMail;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Calendar']")
	private WebElement weCalender;

	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Documents']")
	private WebElement weDocuments;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement weLogout;

	public void mouseOverMarketing() throws IOException {
		webUtil.jsMouseOver(weActMouseOver);

	}

	public void gotoMarketingLeads() throws IOException {
		mouseOverMarketing();
		webUtil.jsClick(weClickOnLeads);

	}

	public void gotoMarketingAccounts() throws IOException {
		mouseOverMarketing();
		webUtil.click(weAccounts);
	}

	public void gotoCampaings() throws IOException {
		mouseOverMarketing();
		webUtil.click(weCampaigns);
	}

	public void gotoContacts() throws IOException {
		mouseOverMarketing();
		webUtil.click(weContacts);
	}

	public void gotoWebmail() throws IOException {
		mouseOverMarketing();
		webUtil.click(weWebMail);
	}

	public void gotoCalendar() throws IOException {
		mouseOverMarketing();
		webUtil.click(weCalender);
	}

	public void gotoDocuments() throws IOException {
		mouseOverMarketing();
		webUtil.click(weDocuments);

	}

	public void verifyHomePage() throws IOException {
		webUtil.verifyElementVisible(weAccounts);
		;

	}

	public void logout() throws IOException {
		// TODO Auto-generated method stub
		webUtil.click(weLogout);
	}

}
