package com.naveenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class AddressBookPage extends TestBase {

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

	private void enterFirstName(String firstName) {
		ActionUtils.sendKeys(firstNamesTextField, firstName);
	}

	private void enterLastName(String lastName) {
		ActionUtils.sendKeys(lastNameTextField, lastName);
	}

	private void enterAddress(String address) {
		ActionUtils.sendKeys(addressTextField, address);
	}

	private void enterCity(String city) {
		ActionUtils.sendKeys(cityTextField, city);
	}

	private void enterPostalCode(String postalCode) {
		ActionUtils.sendKeys(postalcodeTextField, postalCode);
	}

	public void selectCountry(String country) {
		ActionUtils.selectByVisibleText(countryDropdown, country);
	}

	private void selectRegionOrState(String regionOrState) {
		ActionUtils.selectByVisibleText(regionOrStateDropdown, regionOrState);
	}

	private void clickNoDefaultAddressRadioBtn() {
		ActionUtils.click(noDefaultAddressRadioBtn);
	}

	public AddressBookEntriesPage clickContinueBtn() {
		ActionUtils.click(continueBtn);
		return new AddressBookEntriesPage();
	}

	public void enterNewAddress(String firstName, String lastName, String address, String city, String postalCode,
			String country, String regioOrState) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterAddress(address);
		enterCity(city);
		enterPostalCode(postalCode);
		selectCountry(country);
		selectRegionOrState(regioOrState);
		clickNoDefaultAddressRadioBtn();
	}

}
