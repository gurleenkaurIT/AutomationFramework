package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.AccountLogoutPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class AccountLogoutPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AccountLogoutPage accountLogoutPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void logoutFromTheAccount() {
		accountLogoutPage = myAccountPage.clickLogoutLink();
		String logoutSuccessText = accountLogoutPage.getLogoutSuccessText();
		Assert.assertEquals(logoutSuccessText,
				"You have been logged off your account. It is now safe to leave the computer.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
