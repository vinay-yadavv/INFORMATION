package com.evs.vtiger.or.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.pages.marketing.leads.LeadsDetailsPage;

public class OrCommon {

	@FindBy(xpath = "//input[contains(@title,'Save')]")
	protected  WebElement 	commonSaveBtn;

	@FindBy(xpath = "//input[contains(@title,'Cancel')]")
	protected  WebElement  commonCanvelBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	protected WebElement   commonDetailsHeader;

	@FindBy(xpath = "//a[text()='del'])[1]")
	protected WebElement commonDeletBtn;


}
