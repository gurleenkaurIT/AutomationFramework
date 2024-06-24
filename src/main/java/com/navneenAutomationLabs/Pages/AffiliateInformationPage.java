package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class AffiliateInformationPage extends TestBase {

	public AffiliateInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#input-company")
	WebElement companyTextField;

	@FindBy(css = "input#input-tax")
	WebElement taxIdTextField;

	@FindBy(css = "input[name='payment'][value='cheque']")
	WebElement chequePaymentMethodRadioBtn;

	@FindBy(css = "input#input-cheque")
	WebElement chequePayeeNameTextField;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	private void enterCompanyName(String companyName) {
		companyTextField.clear();
		companyTextField.sendKeys(companyName);
	}

	private void enterTaxId(String taxId) {
		taxIdTextField.clear();
		taxIdTextField.sendKeys(taxId);
	}

	private void clickChequeRadioBtn() {
		chequePaymentMethodRadioBtn.click();
	}

	private void enterChequePayeeName(String PayeeName) {
		chequePayeeNameTextField.clear();
		chequePayeeNameTextField.sendKeys(PayeeName);
	}

	public MyAccountPage clickContinueBtn() {
		continueBtn.click();
		return new MyAccountPage();
	}

	public void modifyAffiliateAccountInformation(String companyName, String taxId, String PayeeName) {
		enterCompanyName(companyName);
		enterTaxId(taxId);
		clickChequeRadioBtn();
		enterChequePayeeName(PayeeName);
	}
}
