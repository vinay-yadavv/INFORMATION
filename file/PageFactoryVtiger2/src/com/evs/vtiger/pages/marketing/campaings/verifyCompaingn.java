package com.evs.vtiger.pages.marketing.campaings;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utility.WebUtil;




public class verifyCompaingn {
	
	private WebUtil webUtil;
	
	@FindBy(xpath = "//td[@class='searchAlph']")
	private WebElement weSearchAlph;
	
	public verifyCompaingn() {
		this.webUtil=webUtil;
		
	}
	public void verifyCompaingAlphaBet() throws IOException {
	webUtil.click(weSearchAlph);
	
	}

	
	
}
