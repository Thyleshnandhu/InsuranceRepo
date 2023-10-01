package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleRetryTest {
	@Test(retryAnalyzer = com.insu.Genericutils.RetryImpl.class)
	public void retrytest() {
		Assert.assertEquals("A", "B");
	}

}
