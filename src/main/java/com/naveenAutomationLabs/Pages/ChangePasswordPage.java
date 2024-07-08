package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class ChangePasswordPage extends TestBase {

	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#input-password")
	WebElement passwordTextField;

	@FindBy(css = "input#input-confirm")
	WebElement confirmPasswordTextField;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	private void enterPassword(String newPassword) {
		ActionUtils.sendKeys(passwordTextField, newPassword);
	}

	private void enterConfirmPassword(String confirmPassword) {
		ActionUtils.sendKeys(confirmPasswordTextField, confirmPassword);
	}

	public void changePassword(String newPassword, String confirmPassword) {
		enterPassword(newPassword);
		enterConfirmPassword(confirmPassword);
	}

	public MyAccountPage clickContinueBtn() {
		ActionUtils.click(continueBtn);
		return new MyAccountPage();
	}

}
