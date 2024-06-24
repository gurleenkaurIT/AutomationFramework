package com.navneenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.navneenAutomationLabs.Pages.AccountLoginPage;
import com.navneenAutomationLabs.Pages.LaptopsAndNotebooksPage;
import com.navneenAutomationLabs.Pages.MyAccountPage;
import com.navneenAutomationLabs.Pages.MyWishListPage;

public class MyWishListPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	LaptopsAndNotebooksPage laptopsAndNotebooksPage;
	MyWishListPage myWishListPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount("gurleen11296@gmail.com", "Password123");
	}

	@Test
	public void addLaptopToTheWishList() {
		laptopsAndNotebooksPage = myAccountPage.navigateToLaptopsAndNotebooksPage();
		laptopsAndNotebooksPage.clickHpLaptopWishListLink();
		String getSuccessBannerText = laptopsAndNotebooksPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: You have added HP LP3065 to your wish list!");
	}

	@Test
	public void addMacbookToTheWishList() {
		laptopsAndNotebooksPage = myAccountPage.navigateToLaptopsAndNotebooksPage();
		laptopsAndNotebooksPage.clickMacbookWishListLink();
		String getSuccessBannerText = laptopsAndNotebooksPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText, "Success: You have added MacBook to your wish list!");
	}

	@Test(dependsOnMethods = "addLaptopToTheWishList")
	public void removeLaptopFromTheWishList() {
		myWishListPage = myAccountPage.clickWishListLink();
			myWishListPage.clickRemoveHpLaptopLink();
			String getSuccessBannerText2 = myWishListPage.getTextFromSuccessBanner();
			Assert.assertEquals(getSuccessBannerText2, "Success: You have modified your wish list!");
	}

	@Test(dependsOnMethods = "addMacbookToTheWishList")
	public void removeMacbookFromTheWishList() {
		myWishListPage = myAccountPage.clickWishListLink();
			myWishListPage.clickRemoveMacbookLink();
			String getSuccessBannerText = myWishListPage.getTextFromSuccessBanner();
			Assert.assertEquals(getSuccessBannerText, "Success: You have modified your wish list!");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
