package com.evs.vtiger.pages.marketing.leads;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.or.leads.OrCreateLeads;
import com.evs.vtiger.utility.WebUtil;

public class LeadsCreatePage extends OrCreateLeads {

	private WebUtil webUtil;
	private Map<String, String> dataMap;

	public LeadsCreatePage(WebUtil webUtil, Map<String, String> dataMap) {
		this.webUtil = webUtil;
		this.dataMap = dataMap;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	@FindBy(xpath = "//select[contains(@name,'salutationtype')]")
	private WebElement weDropDown;

	@FindBy(name = "firstname")
	private WebElement weFirstName;

	@FindBy(name = "lastname")
	private WebElement weLastName;

	@FindBy(name = "company")
	private WebElement weCompanyName;

	@FindBy(id = "designation")
	private WebElement weDesignation;

	@FindBy(id = "phone")
	private WebElement wePhoneNo;

	@FindBy(id = "mobile")
	private WebElement weMobileNo;

	@FindBy(id = "fax")
	private WebElement weFax;

	@FindBy(id = "email")
	private WebElement weEmail;

	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement weleadsource;

	@FindBy(xpath = "//select[@name='leadstatus']")
	private WebElement weleadStatus;

	@FindBy(name = "lane")
	private WebElement welane;

	@FindBy(id = "code")
	private WebElement weCode;

	@FindBy(xpath = "//input[@id='country']")
	private WebElement weCountry;

	@FindBy(name = "pobox")
	private WebElement wePoBox;

	@FindBy(name = "city")
	private WebElement weCity;

	@FindBy(name = "state")
	private WebElement weState;

	@FindBy(name = "description")
	private WebElement weDescription;

	public void enterLeadsTotaleInfo() throws IOException {
		webUtil.staticWait(5);
		String salutaion = dataMap.get("salutaion_DD");
		webUtil.selectByVisibleTextByUsingSelect(weDropDown, salutaion);
		String firstName = dataMap.get("FirstName_ED");
		webUtil.sendKeys(weFirstName, firstName);
		String lastName = dataMap.get("LastName_ED");
		webUtil.sendKeys(weLastName, lastName);
		String companyName = dataMap.get("CompanyName_ED");
		webUtil.sendKeys(weCompanyName, companyName);
		String titleBox = dataMap.get("TitleBox_ED");
		webUtil.sendKeys(weDesignation, titleBox);
		String phoneNum = dataMap.get("PhoneNo_ED");
		webUtil.sendKeys(wePhoneNo, phoneNum);
		String mobileNum = dataMap.get("MobileNumber_ED");
		webUtil.sendKeys(weMobileNo, mobileNum);
		String fax = dataMap.get("Fax_ED");
		webUtil.sendKeys(weFax, fax);
		String email = dataMap.get("Email_ED");
		webUtil.sendKeys(weEmail, email);
		String lSource = dataMap.get("Lead_Source_DD");
		webUtil.selectByVisibleTextByUsingSelect(weleadsource, lSource);
		String lStatus = dataMap.get("Lead_Status_DD");
		webUtil.selectByVisibleTextByUsingSelect(weleadStatus, lStatus);
		String streetName = dataMap.get("Street_Name_ED");
		webUtil.sendKeys(welane, streetName);
		String postalCode = dataMap.get("Postal_Code_ED");
		webUtil.sendKeys(weCode, postalCode);
		String country = dataMap.get("Country_ED");
		webUtil.sendKeys(weCountry, country);
		String poBox = dataMap.get("PoBox_ED");
		webUtil.sendKeys(wePoBox, poBox);
		String city = dataMap.get("City_ED");
		webUtil.sendKeys(weCity, city);
		String state = dataMap.get("State_ED");
		webUtil.sendKeys(weState, state);
		String discription = dataMap.get("Discription_ED");
		webUtil.sendKeys(weDescription, discription);
	}

	public void saveLeads() throws IOException {

		webUtil.click(commonSaveBtn);

	}

	public void cancelLeads() throws IOException {

		webUtil.click(commonCanvelBtn);

	}

}
