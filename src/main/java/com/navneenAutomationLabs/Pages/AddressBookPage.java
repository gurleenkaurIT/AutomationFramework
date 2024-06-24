package com.navneenAutomationLabs.Pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenAutomationLabs.TestBase.TestBase;

public class AddressBookPage extends TestBase {

	Select select;
	Random randomValue;

	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstNamesTextField;

	@FindBy(id = "input-lastname")
	WebElement lastNameTextField;

	@FindBy(id = "input-address-1")
	WebElement addressTextField;

	@FindBy(id = "input-city")
	WebElement cityTextField;

	@FindBy(id = "input-postcode")
	WebElement postalcodeTextField;

	@FindBy(css = "select#input-country")
	WebElement countryDropdown;

	@FindBy(css = "select#input-zone")
	WebElement regionOrStateDropdown;

	@FindBy(xpath = "//input[@type='radio'][@value='0']")
	WebElement noDefaultAddressRadioBtn;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;

	private void enterFirstName() {
		firstNamesTextField.sendKeys("Gurleen" + generateRandomNumber());
	}

	private void enterLastName() {
		lastNameTextField.sendKeys("Kaur" + generateRandomNumber());
	}

	private void enterAddress() {
		addressTextField.sendKeys("5 Main Street" + generateRandomNumber());
	}

	private void enterCity() {
		cityTextField.sendKeys("Brampton");
	}

	private void enterPostalCode() {
		postalcodeTextField.sendKeys("L6K 4Y4");
	}

	private int generateRandomNumber() {
		randomValue = new Random();
		int random = randomValue.nextInt(100);
		return random;
	}

	private void selectCountry() {
		select = new Select(countryDropdown);
		try {
			select.selectByVisibleText("Canada");
		} catch (Exception e) {
			select.selectByValue("38");
		}
	}

	private void selectRegionOrState() {
		select = new Select(regionOrStateDropdown);
		try {
			select.selectByVisibleText("Ontario");
		} catch (Exception e) {
			select.selectByValue("610");
		}
	}

	private void clickNoDefaultAddressRadioBtn() {
		noDefaultAddressRadioBtn.click();
	}

	public AddressBookEntriesPage clickContinueBtn() {
		continueBtn.click();
		return new AddressBookEntriesPage();
	}

	public void enterNewAddress() {
		enterFirstName();
		enterLastName();
		enterAddress();
		enterCity();
		enterPostalCode();
		selectCountry();
		selectRegionOrState();
		clickNoDefaultAddressRadioBtn();
	}

}
