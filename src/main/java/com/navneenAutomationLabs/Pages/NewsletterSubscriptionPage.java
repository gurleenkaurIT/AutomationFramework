package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class NewsletterSubscriptionPage extends TestBase {

	public NewsletterSubscriptionPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name ='newsletter'][value='1']")
	WebElement yesRadioBtn;
	
	@FindBy(css = "input[name ='newsletter'][value='0']")
	WebElement noRadioBtn;

	@FindBy(css = "input.btn-primary")
	WebElement continueBtn;

	public void clickYesRadioBtn() {
		yesRadioBtn.click();
	}
	
	public void clickNoRadioBtn() {
		noRadioBtn.click();
	}

	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}
}
