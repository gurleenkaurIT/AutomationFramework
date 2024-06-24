package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class MyAccountInformationPage extends TestBase {

	public MyAccountInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#input-firstname")
	WebElement firstNameTextField;

	@FindBy(css = "input#input-lastname")
	WebElement lastNameTextField;

	@FindBy(css = "input#input-email")
	WebElement emailTextField;

	@FindBy(css = "input#input-telephone")
	WebElement telephoneTextField;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	private void enterFirstName(String firstName) {
		firstNameTextField.clear();
		firstNameTextField.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		lastNameTextField.clear();
		lastNameTextField.sendKeys(lastName);
	}

	private void enterEmail(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
	}

	private void enterTelephone(String telephone) {
		telephoneTextField.clear();
		telephoneTextField.sendKeys(telephone);
	}

	public void modifyAccountInformation(String firstName, String lastName, String email, String telephone) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterTelephone(telephone);
	}

	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}
}
