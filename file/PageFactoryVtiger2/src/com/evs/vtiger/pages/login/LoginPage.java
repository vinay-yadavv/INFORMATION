package com.evs.vtiger.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.or.login.OrLogin;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.utility.WebUtil;

public class LoginPage extends OrLogin {

	@FindBy(name = "user_name")
	private WebElement weUserName;

	@FindBy(name = "user_password")
	private WebElement wePassword;

	@FindBy(xpath = "//select[@name='login_theme']")
	private WebElement weLoginThame;

	@FindBy(name = "Login")
	public WebElement loginBtn;

	private WebUtil webUtil;

	public LoginPage(WebUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void validLogin() {

		String url = webUtil.getPropObj().getProperty("url");
		webUtil.getDriver().get(url);
		String uname = webUtil.getPropObj().getProperty("username");
		String pwd = webUtil.getPropObj().getProperty("password");
		String logTheme = webUtil.getPropObj().getProperty("weLoginThame");
		webUtil.jsSendkeys(weUserName, uname);
		webUtil.jsSendkeys(wePassword, pwd);
		webUtil.jsSendkeys(weLoginThame, logTheme);
		webUtil.jsClick(loginBtn);

	}

	public void invalidLogin(String invalicUserName, String invalidUserPassword, String invalidLogTheme) {

		webUtil.jsSendkeys(weUserName, invalicUserName);
		webUtil.jsSendkeys(wePassword, invalidUserPassword);
		webUtil.jsSendkeys(weLoginThame, invalidLogTheme);
		webUtil.jsClick(loginBtn);

	}
	

}
