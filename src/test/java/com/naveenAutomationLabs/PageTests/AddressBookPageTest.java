package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.AddressBookEntriesPage;
import com.naveenAutomationLabs.Pages.AddressBookPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;
import com.naveenAutomationLabs.Utils.TestData;

public class AddressBookPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;
	AddressBookEntriesPage addressBookEntriesPage;
	ActionUtils actionClass;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void addNewAddressToAddressBookEntries() {
		addressBookEntriesPage = myAccountPage.clickAddressBookLink();
		addressBookPage = addressBookEntriesPage.clickNewAddressBtn();
		addressBookPage.enterNewAddress(TestData.newAddressFirstName, TestData.newAddressLastName,
				TestData.addressFirstLine, TestData.city, TestData.postalCode, TestData.country,
				TestData.regionOrState);
		addressBookEntriesPage = addressBookPage.clickContinueBtn();
		String getSuccessBannerText = addressBookEntriesPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Your address has been successfully added");
	}

	@Test(dependsOnMethods = "addNewAddressToAddressBookEntries")
	public void deleteAddressFromAddressBookEntries() {
		addressBookEntriesPage = myAccountPage.clickAddressBookLink();
		addressBookEntriesPage = new AddressBookEntriesPage();
		addressBookEntriesPage.deleteAddressFromAddressBookEntries(TestData.newAddressFirstName);
		driver.switchTo().alert().accept();
		String getSuccessBannerText = addressBookEntriesPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Your address has been successfully deleted");

	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}

}
