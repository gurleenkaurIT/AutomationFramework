package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.MyAccountInformationPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class MyAccountInformationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAccountInformationPage myAccountInformationPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void editMyAccountInformation() {
		myAccountInformationPage = myAccountPage.clickEditAccountLink();
		myAccountInformationPage.modifyAccountInformation(TestData.firstName, TestData.lastName, TestData.email,
				TestData.telephone);
		myAccountPage = myAccountInformationPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your account has been successfully updated.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
