package com.naveenAutomationLabs.Utils;

import com.naveenAutomationLabs.TestBase.TestBase;

public class TestData extends TestBase {

	// Emails and Passwords
	public static final String email = "gurleen11296@gmail.com";
	public static final String password = "Password123";
	public static final String newPassword = "Password123";
	public static final String incorrectEmail = "gurleen96@gmail.com";
	public static final String incorrectPassword = "Password1";

	// Laptops and Notebooks Page product Name
	public static final String HpLaptop = "HP LP3065";
	public static final String MacBook = "MacBook";
	public static final String MacBookAir = "MacBook Air";
	public static final String MacBookPro = "MacBook Pro";
	public static final String SonyLaptop = "Sony VAIO";

	// Register New Account Details
	public static final String firstName = "Gurleen";
	public static final String lastName = "kaur";
	public static final String telephone = "5149876543";
	public static final String registerEmail = "Gurleen" + RandomDataGeneratorUtils.generateRandomInteger()
			+ "@gmail.com";

	// Enter New Address
	public static final String newAddressFirstName = "Gurleen1234";
	public static final String newAddressLastName = "kaur" + RandomDataGeneratorUtils.generateRandomString();
	public static final String addressFirstLine = "5 Main";
	public static final String city = "Brampton";
	public static final String postalCode = "L6Y 4K4";
	public static final String country = "Canada";
	public static final String regionOrState = "Ontario";
	
	// Affiliate Account Information
	public static final String companyName = "Navneen Automation";
	public static final String taxId = "123765489";
	
	// Bank Details
	public static final String accountName = "Gurleen Kaur";
	public static final String accountNumber = "1237654899";
	
}
