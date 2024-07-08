package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.ChangePasswordPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class ChangePasswordPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	ChangePasswordPage changePasswordPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void changeAccountPassword() {
		changePasswordPage = myAccountPage.clickPasswordLink();
		changePasswordPage.changePassword(TestData.newPassword, TestData.newPassword);
		myAccountPage = changePasswordPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your password has been successfully updated.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
