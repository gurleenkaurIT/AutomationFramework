package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;
import com.naveenAutomationLabs.Utils.RandomDataGeneratorUtils;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement firstNameTextField;

	@FindBy(css = "#input-lastname")
	WebElement lastNameTextField;

	@FindBy(css = "#input-email")
	WebElement emailTextField;

	@FindBy(css = "#input-telephone")
	WebElement telephoneTextField;

	@FindBy(css = "#input-password")
	WebElement passwordTextField;

	@FindBy(css = "#input-confirm")
	WebElement confirmPasswordTextField;

	@FindBy(css = "input[type='radio'][value='0']")
	WebElement noSubscribeRadioBtn;
	
	@FindBy(css = "input[type='radio'][name='newsletter'][value='1']")
	WebElement yesSubscribeRadioBtn;

	@FindBy(css = "input[type='checkbox'][value='1']")
	WebElement privacyPolicyCheckBox;

	@FindBy(css = "input[type='submit'][value='Continue']")
	WebElement continueBtn;

	@FindBy(css = "div#content p:first-of-type")
	WebElement successBanner;

	private void enterFirstName(String firstName) {
		ActionUtils.sendKeys(firstNameTextField, firstName + RandomDataGeneratorUtils.generateRandomString());
	}

	private void enterLastName(String lastName) {
		ActionUtils.sendKeys(lastNameTextField, lastName + RandomDataGeneratorUtils.generateRandomString());
	}

	private void enterEmail(String email) {
		ActionUtils.sendKeys(emailTextField, email);
	}

	private void enterTelephone(String telephone) {
		ActionUtils.sendKeys(telephoneTextField, telephone);
	}

	private void enterPassword(String password) {
		ActionUtils.sendKeys(passwordTextField, password);
	}

	private void enterConfirmPassword(String confirmPassword) {
		ActionUtils.sendKeys(confirmPasswordTextField, confirmPassword);
	}

	public void clickNoSubscribeRadioBtn() {
		ActionUtils.click(noSubscribeRadioBtn);
	}
	
	public void clickYesSubscribeRadioBtn() {
		ActionUtils.click(yesSubscribeRadioBtn);
	}

	private void clickPrivacyPolicyCheckBox() {
		ActionUtils.click(privacyPolicyCheckBox);
	}

	public void clickContinueBtn() {
		ActionUtils.click(continueBtn);
	}

	public void fillDetailsToRegisterAccount(String firstName, String lastName, String email, String telephone,
			String password, String confirmPassword) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterTelephone(telephone);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		clickPrivacyPolicyCheckBox();
	}

	public String getSuccessBannerText() {
		return ActionUtils.getText(successBanner);
	}

}
