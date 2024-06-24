package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.AffiliateInformationPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;

public class AffiliateInformationPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AffiliateInformationPage affiliateInformationPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
	}

	@Test
	public void editAffilaiteAccountInformation() {
		affiliateInformationPage = myAccountPage.clickEditAffiliateInformationLink();
		affiliateInformationPage.modifyAffiliateAccountInformation("Automation", "123765489", "Gurleen");
		myAccountPage = affiliateInformationPage.clickContinueBtn();
		String getSuccessBannerText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: Your account has been successfully updated.");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
