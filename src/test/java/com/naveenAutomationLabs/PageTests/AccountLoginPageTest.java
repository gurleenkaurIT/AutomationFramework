package com.naveenAutomationLabs.PageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.ForgotYourPasswordPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ExcelUtils;
import com.naveenAutomationLabs.Utils.TestData;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
	}

	@Test(dataProvider = "ValidLoginData")
	public void validateLoginWithValidCredentials(String email, String pwd) {
		myAccountPage = loginPage.loginToMyAccount(email, pwd);
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText);
	}

	@Test
	public void validateLoginWithInValidCredentials() {
		loginPage.loginToMyAccount(TestData.incorrectEmail, TestData.incorrectPassword);
		String alertBannerText = loginPage.getTextFromAlertBanner();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBannerText);
	}

	@Test
	public void validateForgetPwdFunctionality() {
		pwdPage = loginPage.clickForgetPwdLink();
		loginPage = pwdPage.submitForgetPwdRequest(TestData.email);
		String succesBannerText = loginPage.getTextFromSuccessBanner();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.", succesBannerText);
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

	@DataProvider(name = "ValidLoginData")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "D:\\QA_Course\\Data.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
