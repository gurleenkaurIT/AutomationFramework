package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.ChangePasswordPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;

public class ChangePasswordPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	ChangePasswordPage changePasswordPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
	}

	@Test
	public void changeAccountPassword() {
		changePasswordPage = myAccountPage.clickPasswordLink();
		changePasswordPage.changePassword("Password123", "Password123");
		myAccountPage = changePasswordPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your password has been successfully updated.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
