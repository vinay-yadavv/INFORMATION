package com.evs.vtiger.pages.marketing.leads;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.evs.vtiger.pages.or.leads.OrDetailsPage;
import com.evs.vtiger.utility.WebUtil;


public class LeadsDetailsPage extends OrDetailsPage{
	
	private WebUtil webUtil;
	
	public LeadsDetailsPage(WebUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}
	
public void verifyLeadsDetailHeader(String expectedHeaderText) throws IOException {
	
	String actualHeaderText =webUtil.getInnerText(commonDetailsHeader);
	if(actualHeaderText.contains(expectedHeaderText)) {
		System.out.println("Leads Detail Header Passed. Actual - "+actualHeaderText+" Expected "+expectedHeaderText);
	}else {
		System.out.println("Leads Detail Header Failed. Actual - "+actualHeaderText+" Expected "+expectedHeaderText);
     Assert.assertEquals(actualHeaderText, expectedHeaderText);
	
	}
   
}

public void verifyLeadsHeader(String expectedHeaderText) throws IOException {
	String actualHeaderText =webUtil.getInnerText(moduleNamer);
	if(actualHeaderText.equalsIgnoreCase(expectedHeaderText)) {
		System.out.println("Leads Detail Header Passed. Actual - "+actualHeaderText+" Expected "+expectedHeaderText);
	}else {
		System.out.println("Leads Detail Header Failed. Actual - "+actualHeaderText+" Expected "+expectedHeaderText);	
	}
}

public void verifyLastName(String expectedName) throws IOException {
	
	String actualLastName = webUtil.getInnerText(lastName);
	if(actualLastName.contains(expectedName)) {
		System.out.println("Last Name Fassed Passed. Actual - "+actualLastName+" Expected "+expectedName);
	}else {
		System.out.println("Last Name Fassed Failed. Actual - "+actualLastName+" Expected "+expectedName);
	}
}

public void verifyCompanyName(String expectedName) throws IOException {
	
	webUtil.verifyInnerText(companyName, expectedName);

	
}




 }
