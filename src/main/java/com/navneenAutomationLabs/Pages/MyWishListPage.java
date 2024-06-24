package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='MacBook'] //parent::td //parent::tr //td[@class='text-right'] //a")
	WebElement removeMacbookLink;

	@FindBy(xpath = "//a[contains(text(),'HP')] //parent::td //parent::tr //td[@class='text-right'] //a")
	WebElement removeHpLaptopLink;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	public void clickRemoveMacbookLink() {
		removeMacbookLink.click();
	}

	public void clickRemoveHpLaptopLink() {
		removeHpLaptopLink.click();
	}

	public String getTextFromSuccessBanner() {
		return successBanner.getText().replaceAll("[×]", "").trim();
	}

}
