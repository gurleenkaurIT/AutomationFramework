package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.AddressBookEntriesPage;
import com.navneenAutomationLabs.Pages.AddressBookPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;

public class AddressBookPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;
	AddressBookEntriesPage addressBookEntriesPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
	}

	@Test
	public void addNewAddressToAddressBookEntries() {
		addressBookEntriesPage = myAccountPage.clickAddressBookLink();
		addressBookPage = addressBookEntriesPage.clickNewAddressBtn();
		addressBookPage.enterNewAddress();
		addressBookEntriesPage = addressBookPage.clickContinueBtn();
		String getSuccessBannerText = addressBookEntriesPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Your address has been successfully added");
	}

	@Test(dependsOnMethods = "addNewAddressToAddressBookEntries")
	public void deleteAddressFromAddressBookEntries() {
		addressBookEntriesPage = myAccountPage.clickAddressBookLink();
		addressBookEntriesPage = new AddressBookEntriesPage();
		addressBookEntriesPage.clickDeleteBtn();
		driver.switchTo().alert().accept();
		String getSuccessBannerText = addressBookEntriesPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Your address has been successfully deleted");

	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
