package com.naveenAutomationLabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLabs.Pages.AccountLoginPage;
import com.naveenAutomationLabs.Pages.LaptopsAndNotebooksPage;
import com.naveenAutomationLabs.Pages.MyAccountPage;
import com.naveenAutomationLabs.Pages.MyWishListPage;
import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.TestData;

public class LaptopsAndNotebooksPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	LaptopsAndNotebooksPage laptopsAndNotebooksPage;
	MyWishListPage myWishListPage;

	@BeforeMethod
	public void setup() {
		initialise();
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.loginToMyAccount(TestData.email, TestData.password);
	}

	@Test
	public void addLaptopToTheWishList() {
		laptopsAndNotebooksPage = myAccountPage.navigateToLaptopsAndNotebooksPage();
		laptopsAndNotebooksPage.addLaptopToWishList(TestData.HpLaptop);
		String getSuccessBannerText = laptopsAndNotebooksPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText,
				"Success: You have added " + TestData.HpLaptop + " to your wish list!");
	}

	@Test(dependsOnMethods = "addLaptopToTheWishList")
	public void removeLaptopFromTheWishList() {
		myWishListPage = myAccountPage.clickWishListLink();
		myWishListPage.removeProductFromWishList(TestData.HpLaptop);
		String getSuccessBannerText2 = myWishListPage.getTextFromSuccessBanner();
		Assert.assertEquals(getSuccessBannerText2, "Success: You have modified your wish list!");
	}

	@AfterMethod
	public void closeBrowser() {
		teardown();
	}
}
