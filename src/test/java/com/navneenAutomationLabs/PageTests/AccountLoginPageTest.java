package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.ForgotYourPasswordPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}

	@Test
	public void validateLoginWithValidCredentials() {
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText);
	}

	@Test
	public void validateLoginWithInValidCredentials() {
		loginPage.loginToMyAccount("gurleen0102@gmail.com", "Password1");
		String alertBannerText = loginPage.getTextFromAlertBanner().trim();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBannerText);
	}

	@Test
	public void validateForgetPwdFunctionality() {
		pwdPage = loginPage.clickForgetPwdLink();
		loginPage = pwdPage.submitForgetPwdRequest("abc1@xyz.com");
		String succesBannerText = loginPage.getTextFromSuccessBanner().trim();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.", succesBannerText);
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
