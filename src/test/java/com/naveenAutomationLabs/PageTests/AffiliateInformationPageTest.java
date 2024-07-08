package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.AffiliateInformationPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class AffiliateInformationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AffiliateInformationPage affiliateInformationPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void modifyChequePaymentMethod() {
		affiliateInformationPage = myAccountPage.clickEditAffiliateInformationLink();
		affiliateInformationPage.modifyChequePaymentMethod(TestData.companyName, TestData.taxId, TestData.firstName);
		myAccountPage = affiliateInformationPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your account has been successfully updated.");
	}

	@Test
	public void modifyPayPalPaymentMethod() {
		affiliateInformationPage = myAccountPage.clickEditAffiliateInformationLink();
		affiliateInformationPage.modifyPaypalPaymentMethod(TestData.companyName, TestData.taxId, TestData.email);
		myAccountPage = affiliateInformationPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your account has been successfully updated.");
	}

	@Test
	public void modifyBankPaymentMethod() {
		affiliateInformationPage = myAccountPage.clickEditAffiliateInformationLink();
		affiliateInformationPage.modifyBankPaymentMethod(TestData.companyName, TestData.taxId, TestData.accountName,
				TestData.accountNumber);
		myAccountPage = affiliateInformationPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your account has been successfully updated.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
