package com.evs.vtiger.pages.marketing.leads;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.or.leads.OrDeleteLeads;
import com.evs.vtiger.utility.WebUtil;


public class VerifyDeleteNewLeads extends OrDeleteLeads{
	
	private WebUtil webUtil;
	
public	VerifyDeleteNewLeads(WebUtil webUtil){
		this.webUtil= webUtil;
		
	}
	public void verifyDeleteLeads() throws IOException {

		HomePage  homeModule=new HomePage(webUtil);
		homeModule.gotoMarketingLeads();
		webUtil.click(commonDeletBtn);
		webUtil.popUpAccept(weDeletePopUp);
		System.out.println("Leads Element is deleted : ");
		
	}
}
