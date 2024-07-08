package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class ContactUsPage extends TestBase {

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-name")
	WebElement nameTextField;

	@FindBy(css = "#input-email")
	WebElement emailTextFeild;

	@FindBy(css = "#input-enquiry")
	WebElement enquiryTextField;

	@FindBy(css = "input[value='Submit']")
	WebElement submitBtn;

	@FindBy(css = "#content p")
	WebElement successText;

	private void enterName(String name) {
		ActionUtils.clearAndSendKeys(nameTextField, name);
	}

	private void enterEmail(String email) {
		ActionUtils.clearAndSendKeys(emailTextFeild, email);
	}

	private void enterEnquiry(String enquiryText) {
		ActionUtils.clearAndSendKeys(enquiryTextField, enquiryText);
	}

	private void clickSubmitBtn() {
		ActionUtils.click(submitBtn);
	}

	public void fillEnquiryFormDetails(String name, String email, String enquiryText) {
		enterName(name);
		enterEmail(email);
		enterEnquiry(enquiryText);
		clickSubmitBtn();
	}

	public String getSuccessBannerText() {
		return ActionUtils.getText(successText);
	}
}
