package com.naveenAutomationLabs.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLabs.TestBase.TestBase;
import com.naveenAutomationLabs.Utils.ActionUtils;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.btn-danger")
	WebElement removeBtn;

	@FindBy(css = "div.table-responsive tr td:nth-of-type(2)")
	List<WebElement> productsInWishLink;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	public String getTextFromSuccessBanner() {
		return ActionUtils.replaceAndGetText(successBanner);
	}

	public void removeProductFromWishList(String productName) {
		for (WebElement productList : productsInWishLink) {
			String productText = ActionUtils.getText(productList);
			if (productText.equalsIgnoreCase(productName)) {
				removeBtn.click();
				break;
			}
		}
	}

}
