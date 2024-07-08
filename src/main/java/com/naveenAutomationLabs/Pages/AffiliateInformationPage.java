package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class AffiliateInformationPage extends TestBase {

	public AffiliateInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#input-company")
	WebElement companyTextField;

	@FindBy(css = "input#input-tax")
	WebElement taxIdTextField;

	@FindBy(css = "input#input-cheque")
	WebElement chequePayeeNameTextField;

	@FindBy(css = "input#input-paypal")
	WebElement paypalEmailTextField;

	@FindBy(css = "input#input-bank-account-name")
	WebElement bankAccountNameTextField;

	@FindBy(css = "input#input-bank-account-number")
	WebElement bankAccountNumberTextField;

	@FindBy(css = "input[value='cheque']")
	WebElement chequePaymentMethodRadioBtn;

	@FindBy(css = "input[value='paypal']")
	WebElement paypalPaymentMethodRadioBtn;

	@FindBy(css = "input[value='bank']")
	WebElement bankTransferPaymentMethodRadioBtn;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	private void enterCompanyName(String companyName) {
		ActionUtils.clearAndSendKeys(companyTextField, companyName);
	}

	private void enterTaxId(String taxId) {
		ActionUtils.clearAndSendKeys(taxIdTextField, taxId);
	}

	private void clickChequeRadioBtn() {
		ActionUtils.click(chequePaymentMethodRadioBtn);
	}

	private void clickPaypalRadioBtn() {
		ActionUtils.click(paypalPaymentMethodRadioBtn);
	}

	private void clickBankTransferRadioBtn() {
		ActionUtils.click(bankTransferPaymentMethodRadioBtn);
	}

	private void enterChequePayeeName(String PayeeName) {
		ActionUtils.clearAndSendKeys(chequePayeeNameTextField, PayeeName);
	}

	private void enterpaypalEmail(String email) {
		ActionUtils.clearAndSendKeys(paypalEmailTextField, email);
	}

	private void enterAccountName(String accountName) {
		ActionUtils.clearAndSendKeys(bankAccountNameTextField, accountName);
	}

	private void enterAccountNumber(String accountNumber) {
		ActionUtils.clearAndSendKeys(bankAccountNumberTextField, accountNumber);
	}

	public MyAccountPage clickContinueBtn() {
		ActionUtils.click(continueBtn);
		return new MyAccountPage();
	}

	public void modifyChequePaymentMethod(String companyName, String taxId, String PayeeName) {
		enterCompanyName(companyName);
		enterTaxId(taxId);
		clickChequeRadioBtn();
		enterChequePayeeName(PayeeName);
	}

	public void modifyPaypalPaymentMethod(String companyName, String taxId, String email) {
		enterCompanyName(companyName);
		enterTaxId(taxId);
		clickPaypalRadioBtn();
		enterpaypalEmail(email);
	}
	
	public void modifyBankPaymentMethod(String companyName, String taxId, String accountName, String accountNumber) {
		enterCompanyName(companyName);
		enterTaxId(taxId);
		clickBankTransferRadioBtn();
		enterAccountName(accountName);
		enterAccountNumber(accountNumber);
	}
}
