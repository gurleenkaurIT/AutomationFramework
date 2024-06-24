package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

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
		passwordTextField.sendKeys(newPassword);
	}

	private void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTextField.sendKeys(confirmPassword);
	}

	public void changePassword(String newPassword, String confirmPassword) {
		enterPassword(newPassword);
		enterConfirmPassword(confirmPassword);
	}

	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}

}
