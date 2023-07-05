package com.evs.vtiger.pages.or.leads;

import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.or.common.OrCommon;

public class OrDeleteLeads extends OrCommon {

@FindBy(xpath = "Are You sure you want to delete?")
	protected String weDeletePopUp;
}
