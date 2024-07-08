package com.naveenAutomationLabs.Listeners;

import java.time.Duration;
import java.util.Collection;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import com.naveenAutomationLabs.TestBase.TestBase;

public class WebDriverEvents extends TestBase implements WebDriverListener {

	public void beforeGet(WebDriver driver, String url) {
		logger.info("Navigating to URL: " + url);
	}

	public void afterGet(WebDriver driver, String url) {
		logger.info("Navigated to URL: " + url);
	}

	public void beforeGetCurrentUrl(WebDriver driver) {
		logger.info("Getting current URL");
	}

	public void afterGetCurrentUrl(WebDriver driver, String result) {
		logger.info("Got current URL: " + result);
	}

	public void beforeGetTitle(WebDriver driver) {
		logger.info("Getting current Title");
	}

	public void afterGetTitle(WebDriver driver, String result) {
		logger.info("Got current Title: " + result);
	}

	public void beforeFindElement(WebDriver driver, By locator) {
		logger.info("Finding an element:" + locator);
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		logger.info("Found an element:" + locator);
	}

	public void beforeClose(WebDriver driver) {
		logger.info("Closing driver Instance");
	}

	public void afterClose(WebDriver driver) {
		logger.info("Closed driver Instance");
	}

	public void beforeQuit(WebDriver driver) {
		logger.info("Quitting driver Instance");
	}

	public void afterQuit(WebDriver driver) {
		logger.info("Quit driver Instance");
	}

	public void beforeGetWindowHandles(WebDriver driver) {
		logger.info("Getting window Handles");
	}

	public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
		logger.info("Got window Handles: " + result);
	}

	public void beforeGetWindowHandle(WebDriver driver) {
		logger.info("Getting window Handle");
	}

	public void afterGetWindowHandle(WebDriver driver, String result) {
		logger.info("Got window Handle: " + result);
	}

	public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
		logger.info("Peforming Action: " + actions);
	}

	public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
		logger.info("Peformed Action: " + actions);
	}

	public void beforeClick(WebElement element) {
		logger.info("Clicking on element");
	}

	public void afterClick(WebElement element) {
		logger.info("Clicked on element");
	}

	public void beforeSubmit(WebElement element) {
		logger.info("Submitting");
	}

	public void afterSubmit(WebElement element) {
		logger.info("Submitted");
	}

	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		logger.info("Entering value to element" + keysToSend);
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		logger.info("Entered value to element" + keysToSend);
	}

	public void beforeClear(WebElement element) {
		logger.info("Clearing text from element");
	}

	public void afterClear(WebElement element) {
		logger.info("Cleared text from element");
	}

	public void beforeGetAttribute(WebElement element, String name) {
		logger.info("Getting attribute: " + name);
	}

	public void afterGetAttribute(WebElement element, String name, String result) {
		logger.info("Got attribute: " + name);
	}

	public void beforeIsSelected(WebElement element) {
		logger.info("Checking element is selected");
	}

	public void afterIsSelected(WebElement element, boolean result) {
		logger.info("Element is Selected: " + result);
	}

	public void beforeIsEnabled(WebElement element) {
		logger.info("Checking element is enabled");
	}

	public void afterIsEnabled(WebElement element, boolean result) {
		logger.info("Element is enabled: " + result);
	}

	public void beforeGetText(WebElement element) {
		logger.info("Getting text");
	}

	public void afterGetText(WebElement element, String result) {
		logger.info("Got text");
	}

	public void beforeFindElement(WebElement element, By locator) {
		logger.info("Finding an element: " + locator);
	}

	public void afterFindElement(WebElement element, By locator, WebElement result) {
		logger.info("Found and element: " + locator);
	}

	public void beforeIsDisplayed(WebElement element) {
		logger.info("Checking element is displayed");
	}

	public void afterIsDisplayed(WebElement element, boolean result) {
		logger.info("Element is diplayed: " + result);
	}

	public void beforeTo(WebDriver.Navigation navigation, String url) {
		logger.info("Navigating to " + url);
	}

	public void afterTo(WebDriver.Navigation navigation, String url) {
		logger.info("Navigated to " + url);
	}

	public void beforeRefresh(WebDriver.Navigation navigation) {
		logger.info("Refreshing a page");
	}

	public void afterRefresh(WebDriver.Navigation navigation) {
		logger.info("Refreshed a page");
	}

	public void beforeAccept(Alert alert) {
		logger.info("Accepting an alert");
	}

	public void afterAccept(Alert alert) {
		logger.info("Accepted an alert");
	}

	public void beforeDismiss(Alert alert) {
		logger.info("Dismissing an alert");
	}

	public void afterDismiss(Alert alert) {
		logger.info("Dismissed an alert");
	}

	public void beforeGetText(Alert alert) {
		logger.info("Getting alert text");
	}

	public void afterGetText(Alert alert, String result) {
		logger.info("Got alert text");
	}

	public void beforeSendKeys(Alert alert, String text) {
		logger.info("Performing send keys: " + text);
	}

	public void afterSendKeys(Alert alert, String text) {
		logger.info("Performed send keys: " + text);
	}

	public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
		logger.info("Implicitly waiting for " + duration);
	}

	public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
		logger.info("Implicitly waited for " + duration);
	}

	public void beforeMaximize(WebDriver.Window window) {
		logger.info("Maximizing Window");
	}

	public void afterMaximize(WebDriver.Window window) {
		logger.info("Maximized Window");
	}

	public void beforeDefaultContent(WebDriver.TargetLocator targetLocator) {
		logger.info("Navigating to default content");
	}

	public void afterDefaultContent(WebDriver.TargetLocator targetLocator, WebDriver driver) {
		logger.info("Navigated to default content");
	}
}
