package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;
import com.navneenAutomationLabs.Pages.NewsletterSubscriptionPage;

public class NewsletterSubscriptionPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
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
