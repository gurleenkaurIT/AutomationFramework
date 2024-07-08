package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

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

	@FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
	WebElement logoutLink;

	@FindBy(css = " i.fa-phone")
	WebElement contactUsLink;

	public String getMyAccountText() {
		return ActionUtils.getText(myAccountText);
	}

	public String getTextFromSuccessBanner() {
		return ActionUtils.getText(successBanner);
	}

	public NewsletterSubscriptionPage clickNewsletterLink() {
		ActionUtils.click(newsletterLink);
		return new NewsletterSubscriptionPage();
	}

	public AddressBookEntriesPage clickAddressBookLink() {
		ActionUtils.click(addressBookLink);
		return new AddressBookEntriesPage();
	}

	public ChangePasswordPage clickPasswordLink() {
		ActionUtils.click(passwordLink);
		return new ChangePasswordPage();
	}

	public MyAccountInformationPage clickEditAccountLink() {
		ActionUtils.click(editAccountLink);
		return new MyAccountInformationPage();
	}

	public AffiliateInformationPage clickEditAffiliateInformationLink() {
		ActionUtils.click(editAffiliateInformationLink);
		return new AffiliateInformationPage();
	}

	public LaptopsAndNotebooksPage navigateToLaptopsAndNotebooksPage() {
		ActionUtils.click(laptopsAndNotebooksLink);
		ActionUtils.click(showAllLaptopsAndNotebooksLink);
		return new LaptopsAndNotebooksPage();
	}

	public MyWishListPage clickWishListLink() {
		ActionUtils.click(wishlistLink);
		return new MyWishListPage();
	}

	public AccountLogoutPage clickLogoutLink() {
		ActionUtils.click(logoutLink);
		return new AccountLogoutPage();
	}

	public ContactUsPage clickContactUsLink() {
		ActionUtils.click(contactUsLink);
		return new ContactUsPage();
	}
}