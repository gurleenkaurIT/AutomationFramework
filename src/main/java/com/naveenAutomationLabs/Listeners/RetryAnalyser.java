package com.naveenAutomationLabs.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenAutomationLabs.TestBase.TestBase;

public class RetryAnalyser extends TestBase implements IRetryAnalyzer {
	int cnt = 0;
	int maxCnt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (cnt < maxCnt) {
			logger.info("Running the failed test : " + result.getMethod().getMethodName());
			cnt++;
			return true;
		}
		return false;
	}
}
