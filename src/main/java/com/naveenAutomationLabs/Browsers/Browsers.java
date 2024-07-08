package com.naveenAutomationLabs.Browsers;

public enum Browsers {

	CHROME("GoogleChrome"), 
	FIREFOX("MozillaFirefox"), 
	EDGE("Microsoft Edge"), 
	SAFARI("Mac Safari");

	private String browserNameWithCompanies;

	Browsers(String browserName) {
		this.browserNameWithCompanies = browserName;
	}

	public String getBrowserNameWithCompanies() {
		return browserNameWithCompanies;
	}
}
