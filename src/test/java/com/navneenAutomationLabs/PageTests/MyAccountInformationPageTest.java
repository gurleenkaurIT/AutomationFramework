package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.MyAccountInformationPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;

public class MyAccountInformationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAccountInformationPage myAccountInformationPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
	}

	@Test
	public void editMyAccountInformation() {
		myAccountInformationPage = myAccountPage.clickEditAccountLink();
		myAccountInformationPage.modifyAccountInformation("Gurleen", "Kaur", "gurleen11296@gmail.com", "5149879876");
		myAccountPage = myAccountInformationPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your account has been successfully updated.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
