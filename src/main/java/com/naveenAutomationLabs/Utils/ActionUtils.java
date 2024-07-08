package com.naveenAutomationLabs.Utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomationLabs.TestBase.TestBase;

public class ActionUtils extends TestBase {

	private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	static Select select;

	public static void selectByVisibleText(WebElement element, String text) {
		select = new Select(element);
		wait.until(ExpectedConditions.visibilityOf(element));
		select.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement element, String text) {
		select = new Select(element);
		wait.until(ExpectedConditions.visibilityOf(element));
		select.selectByValue(text);
	}

	public static void selectByIndex(WebElement element, Integer index) {
		select = new Select(element);
		wait.until(ExpectedConditions.visibilityOf(element));
		select.selectByIndex(index);
	}

	public static void submit(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void sendKeys(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	public static void clearAndSendKeys(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	public static void isElementPresent(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
	}

	public static String replaceAndGetText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText().replaceAll("[×]", "").trim();
	}

}
