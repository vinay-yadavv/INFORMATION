package com.evs.vtiger.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evs.vtiger.exceldata.ExcelUtil;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.login.LoginPage;
import com.evs.vtiger.pages.marketing.leads.LeadsLandingPage;
import com.evs.vtiger.utility.WebUtil;
import com.evs.vtiger.pages.marketing.campaings.CampaingsCreatePage;
import com.evs.vtiger.pages.marketing.leads.LeadsCreatePage;
import com.evs.vtiger.pages.marketing.leads.LeadsDetailsPage;

public class ValidateLeadsFunctionality {
	private static Map<String, String> dataMap;

	private WebUtil webUtil;

	/// JUnit - NUnit ,
	// cedric buest = TestNG - testng.org
	/// beforeSuite /// afterSuite

	@Test
	public void abcd() {
		int a=100;
		int b=200;
		int c=200;
		Assert.assertEquals(b, c);   ////    Hard Assert
		
		Assert.assertEquals(a, b);
		
		Assert.assertEquals(a, c);
		
       
       
       
		
	}
	
	
	@BeforeTest
	public void connectDB() {
		System.out.println("connect to db");
	    
		
		
	}

	@AfterTest
	public void disconnectDB() {
		System.out.println("disconnect to db");

	}

	@BeforeClass
	public void beforeTestCaseClass() throws IOException {
		webUtil = new WebUtil();
		String brName = webUtil.getPropObj().getProperty("browser_name");
		webUtil.launchBrowser(brName);
	}

	@AfterClass
	public void afterTestCaseClass() throws IOException {
		webUtil.close();
	}

	@BeforeMethod
	public void beforeTestCase() throws IOException {
		LoginPage loginPage = new LoginPage(webUtil);
		loginPage.validLogin();
	}

	@AfterMethod
	public void afterTestCase() throws IOException {
		new HomePage(webUtil).logout();
	}

	
	@Parameters({"Browser", "username", "password"})
	@Test(groups = {"smoke"})
	public void validateValidLogin(String br) throws IOException {
       System.out.println(br);
         webUtil.launchBrowser(br);
		new HomePage(webUtil).verifyHomePage();

	}

	@Test(groups = {"smoke", "regression"}, enabled= true, priority = 1, dependsOnMethods = { "validateValidLogin"})
	public void validateCreateLeads() throws IOException {

		dataMap = ExcelUtil.getTestCaseData("testdata\\TestCase.xlsx", "VT001");

		HomePage homePage = new HomePage(webUtil);
		homePage.gotoMarketingLeads();
		LeadsLandingPage leadsLandingPg = new LeadsLandingPage(webUtil);
		leadsLandingPg.clickCreateLeadBtn();
		LeadsCreatePage leadsCreatePage = new LeadsCreatePage(webUtil, dataMap);
		leadsCreatePage.enterLeadsTotaleInfo();
		leadsCreatePage.saveLeads();

		LeadsDetailsPage weVerifyDetail = new LeadsDetailsPage(webUtil);
		String expLdHedDe = dataMap.get("expLeadHederDetail");
		weVerifyDetail.verifyLeadsDetailHeader(expLdHedDe);
		String expLastName = dataMap.get("LastName_ED");
		weVerifyDetail.verifyLastName(expLastName);
		String expCompanyName = dataMap.get("CompanyName_ED");
		weVerifyDetail.verifyCompanyName(expCompanyName);
	}

	@Test(groups = {"5", "6"})
	public void validateCreateCampaings() throws IOException {

		HomePage homePage = new HomePage(webUtil);
		homePage.gotoCampaings();
		CampaingsCreatePage camCrePg = new CampaingsCreatePage(webUtil);
		camCrePg.enterMandetaryInfo();
		camCrePg.saveCampaigns();

	}

}
