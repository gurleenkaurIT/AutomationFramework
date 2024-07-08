package com.naveenAutomationLabs.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class AddressBookEntriesPage extends TestBase {

	public AddressBookEntriesPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='pull-right'] //a")
	WebElement newAddressBtn;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(css = "div.table-responsive tbody tr td.text-left")
	List<WebElement> addressBookEntry;

	@FindBy(css = "div.table-responsive tr:nth-of-type(2) td.text-right a:nth-of-type(2)")
	WebElement deleteBtn;

	public AddressBookPage clickNewAddressBtn() {
		ActionUtils.click(newAddressBtn);
		return new AddressBookPage();
	}

	public String getTextFromSuccessBanner() {
		return ActionUtils.getText(successBanner);
	}

	public void deleteAddressFromAddressBookEntries(String addressName) {
		for (WebElement addressEnteriesList : addressBookEntry) {
			String addressText = ActionUtils.getText(addressEnteriesList);
			if (addressText.contains(addressName)) {
				deleteBtn.click();
				break;
			}
		}
	}

}
