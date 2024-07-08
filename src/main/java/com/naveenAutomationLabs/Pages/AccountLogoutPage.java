package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class AccountLogoutPage extends TestBase {

	public AccountLogoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content p:first-of-type")
	WebElement getLogoutText;

	public String getLogoutSuccessText() {
		return ActionUtils.getText(getLogoutText);
	}
}
