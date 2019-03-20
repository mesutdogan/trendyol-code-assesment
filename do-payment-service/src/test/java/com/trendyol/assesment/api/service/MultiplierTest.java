package com.trendyol.assesment.api.service;

import org.junit.Assert;
import org.junit.Test;

public class MultiplierTest {

	@Test
	public void times1() {
		Dollar five = new Dollar(5);
		five.times(2);
		Assert.assertEquals(10, five.getAmount());
		Dollar prod = five.times(3);
		Assert.assertEquals(15, prod.getAmount());
	}
}
