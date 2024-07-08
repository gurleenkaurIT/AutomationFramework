package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.ContactUsPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class ContactUsPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	ContactUsPage contactUsPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void submitContactUsForm() {
		contactUsPage = myAccountPage.clickContactUsLink();
		contactUsPage.fillEnquiryFormDetails(TestData.firstName, TestData.email, "This is an Enquiry");
		String getTextFromSuccessBanner = contactUsPage.getSuccessBannerText();
		Assert.assertEquals(getTextFromSuccessBanner, "Your enquiry has been successfully sent to the store owner!");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
