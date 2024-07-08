package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.RegisterAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class RegisterAccountPageTest extends TestBase {

	AccountLoginPage loginPage;
	RegisterAccountPage registerAccountPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}

	@Test
	public void createNewAccountWithSubscribingNewsletter() {
		registerAccountPage = loginPage.clickContinueLink();
		registerAccountPage.fillDetailsToRegisterAccount(TestData.firstName, TestData.lastName, TestData.registerEmailOne,
				TestData.telephone, TestData.registerPassword, TestData.registerPassword);
		registerAccountPage.clickYesSubscribeRadioBtn();
		registerAccountPage.clickContinueBtn();
		String accountCreatedSuccessText = registerAccountPage.getSuccessBannerText();
		Assert.assertEquals(accountCreatedSuccessText,
				"Congratulations! Your new account has been successfully created!");
	}

	@Test
	public void createNewAccountWithNoSubscribingNewsletter() {
		registerAccountPage = loginPage.clickContinueLink();
		registerAccountPage.fillDetailsToRegisterAccount(TestData.firstName, TestData.lastName, TestData.registerEmailTwo,
				TestData.telephone, TestData.registerPassword, TestData.registerPassword);
		registerAccountPage.clickNoSubscribeRadioBtn();
		registerAccountPage.clickContinueBtn();
		String accountCreatedSuccessText = registerAccountPage.getSuccessBannerText();
		Assert.assertEquals(accountCreatedSuccessText,
				"Congratulations! Your new account has been successfully created!");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
