package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class ForgotYourPasswordPage extends TestBase {

	public ForgotYourPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(css = "div.pull-right input")
	WebElement continueBtn;

	@FindBy(css = "div.alert-danger")
	WebElement alertBanner;

	private void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	private void clickContinueBtn() {
		continueBtn.click();
	}

	public AccountLoginPage submitForgetPwdRequest(String email) {
		enterEmail(email);
		clickContinueBtn();
		return new AccountLoginPage();

	}

	public String getAlertBannerText() {
		return alertBanner.getText();
	}

}
