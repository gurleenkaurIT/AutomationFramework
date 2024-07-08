package com.naveenAutomationLabs.Utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGeneratorUtils {

	public static int generateRandomInteger() {
		Random randomValue = new Random();
		int random = randomValue.nextInt(100);
		return random;
	}

	public static String generateRandomString() {
		String random = RandomStringUtils.randomAlphabetic(5);
		return random;
	}
}
