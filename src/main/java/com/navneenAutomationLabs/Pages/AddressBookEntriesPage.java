package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class AddressBookEntriesPage extends TestBase {

	public AddressBookEntriesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='pull-right'] //a")
	WebElement newAddressBtn;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(css = "div.table-responsive tr:nth-of-type(2) td.text-right a:nth-of-type(2)")
	WebElement deleteBtn;

	public AddressBookPage clickNewAddressBtn() {
		newAddressBtn.click();
		return new AddressBookPage();
	}
	
	public String getTextFromSuccessBanner() {
		return successBanner.getText().trim();
	}

	public void clickDeleteBtn() {
		deleteBtn.click();
	}
}
