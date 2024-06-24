package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(xpath = "//li[@class = 'dropdown open'] //a[text()='Logout']")
	WebElement logoutBtn;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Newsletter']")
	WebElement newsletterLink;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Address Book']")
	WebElement addressBookLink;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Password']")
	WebElement passwordLink;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Edit Account']")
	WebElement editAccountLink;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(xpath = "//a[text()='Edit your affiliate information']")
	WebElement editAffiliateInformationLink;

	@FindBy(xpath = "//a[text()='Laptops & Notebooks']")
	WebElement laptopsAndNotebooksLink;

	@FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
	WebElement showAllLaptopsAndNotebooksLink;

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Wish List']")
	WebElement wishlistLink;

	public String getMyAccountText() {
		return myAccountText.getText().trim();
	}

	public String getTextFromSuccessBanner() {
		return successBanner.getText().trim();
	}

	public NewsletterSubscriptionPage clickNewsletterLink() {
		newsletterLink.click();
		return new NewsletterSubscriptionPage();
	}

	public AddressBookEntriesPage clickAddressBookLink() {
		addressBookLink.click();
		return new AddressBookEntriesPage();
	}

	public ChangePasswordPage clickPasswordLink() {
		passwordLink.click();
		return new ChangePasswordPage();
	}

	public MyAccountInformationPage clickEditAccountLink() {
		editAccountLink.click();
		return new MyAccountInformationPage();
	}

	public AffiliateInformationPage clickEditAffiliateInformationLink() {
		editAffiliateInformationLink.click();
		return new AffiliateInformationPage();
	}

	public LaptopsAndNotebooksPage navigateToLaptopsAndNotebooksPage() {
		laptopsAndNotebooksLink.click();
		showAllLaptopsAndNotebooksLink.click();
		return new LaptopsAndNotebooksPage();
	}

	public MyWishListPage clickWishListLink() {
		wishlistLink.click();
		return new MyWishListPage();

	}
}