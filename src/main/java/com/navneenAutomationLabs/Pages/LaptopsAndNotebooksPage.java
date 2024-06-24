package com.navneenAutomationLabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;

public class LaptopsAndNotebooksPage extends TestBase {

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "list-view")
	WebElement clickListViewBtn;

	@FindBy(css = "#content div.row:nth-of-type(4) div.product-list:first-of-type button:nth-of-type(2)")
	WebElement addLaptopToWishListLink;

	@FindBy(css = "#content div.row:nth-of-type(4) div.product-list:nth-of-type(2) button:nth-of-type(2)")
	WebElement addMacbookToWishListLink;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	public void clickHpLaptopWishListLink() {
		clickListViewBtn.click();
		addLaptopToWishListLink.click();
	}

	public void clickMacbookWishListLink() {
		clickListViewBtn.click();
		addMacbookToWishListLink.click();
	}

	public String getTextFromSuccessBanner() {
		return successBanner.getText().replaceAll("[×]", "").trim();

	}

}
