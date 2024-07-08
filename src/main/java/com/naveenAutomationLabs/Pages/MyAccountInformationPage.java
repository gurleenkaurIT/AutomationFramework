package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

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
		ActionUtils.clearAndSendKeys(firstNameTextField, firstName);
	}

	private void enterLastName(String lastName) {
		ActionUtils.clearAndSendKeys(lastNameTextField, lastName);
		lastNameTextField.clear();
		lastNameTextField.sendKeys(lastName);
	}

	private void enterEmail(String email) {
		ActionUtils.clearAndSendKeys(emailTextField, email);
	}

	private void enterTelephone(String telephone) {
		ActionUtils.clearAndSendKeys(telephoneTextField, telephone);
	}

	public void modifyAccountInformation(String firstName, String lastName, String email, String telephone) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterTelephone(telephone);
	}

	public MyAccountPage clickContinueBtn() {
		ActionUtils.click(continueBtn);
		return new MyAccountPage();
	}
}
