package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-password")
	WebElement pwdField;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(css = "#account-login div.alert-danger")
	WebElement alertBanner;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(xpath = "//a[text()='Forgotten Password']")
	WebElement forgettenPwdLink;

	@FindBy(css = "div.well a.btn-primary")
	WebElement continueBtn;

	private void enterEmail(String email) {
		ActionUtils.sendKeys(emailField, email);
	}

	private void enterPwd(String pwd) {
		ActionUtils.sendKeys(pwdField, pwd);
	}

	private void clickLoginBtn() {
		ActionUtils.click(loginBtn);
	}

	public ForgotYourPasswordPage clickForgetPwdLink() {
		ActionUtils.click(forgettenPwdLink);
		return new ForgotYourPasswordPage();
	}

	public String getTextFromAlertBanner() {
		return ActionUtils.getText(alertBanner);
	}

	public String getTextFromSuccessBanner() {
		return ActionUtils.getText(successBanner);
	}

	public MyAccountPage loginToMyAccount(String email, String pwd) {
		enterEmail(email);
		enterPwd(pwd);
		clickLoginBtn();
		return new MyAccountPage();
	}

	public RegisterAccountPage clickContinueLink() {
		ActionUtils.click(continueBtn);
		return new RegisterAccountPage();
	}

}
