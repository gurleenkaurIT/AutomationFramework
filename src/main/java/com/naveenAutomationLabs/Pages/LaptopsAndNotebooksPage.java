package com.naveenAutomationLabs.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class LaptopsAndNotebooksPage extends TestBase {

	public LaptopsAndNotebooksPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "list-view")
	WebElement listViewBtn;

	@FindBy(css = "#content div.row:nth-of-type(4) h4")
	List<WebElement> laptopsList;

	@FindBy(css = "button i.fa-heart")
	WebElement addToWishListLink;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	public String getTextFromSuccessBanner() {
		return ActionUtils.replaceAndGetText(successBanner);
	}

	public void clickListViewBtn() {
		ActionUtils.click(listViewBtn);
	}

	public void addLaptopToWishList(String productName) {
		for (WebElement elementList : laptopsList) {
			String elementText = ActionUtils.getText(elementList);
			if (elementText.equalsIgnoreCase(productName)) {
				addToWishListLink.click();
				break;
			}
		}
	}
}
