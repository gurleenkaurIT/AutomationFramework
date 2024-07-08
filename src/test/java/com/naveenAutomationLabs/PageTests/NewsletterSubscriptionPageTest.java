package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.Pages.NewsletterSubscriptionPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class NewsletterSubscriptionPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void subscribeNewsLetter() {
		newsletterSubscriptionPage = myAccountPage.clickNewsletterLink();
		newsletterSubscriptionPage.clickYesRadioBtn();
		myAccountPage = newsletterSubscriptionPage.clickContinueBtn();
		String subscriptionUpdatedText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(subscriptionUpdatedText,
				"Success: Your newsletter subscription has been successfully updated!");
	}

	@Test
	public void unSubscribeNewsLetter() {
		newsletterSubscriptionPage = myAccountPage.clickNewsletterLink();
		newsletterSubscriptionPage.clickNoRadioBtn();
		myAccountPage = newsletterSubscriptionPage.clickContinueBtn();
		String subscriptionUpdatedText = myAccountPage.getTextFromSuccessBanner();
		Assert.assertEquals(subscriptionUpdatedText,
				"Success: Your newsletter subscription has been successfully updated!");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
