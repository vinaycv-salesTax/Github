package com.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.salestax.util.ItemUtil;

public class ItemUtilTest {

	@Test
	public void testNearest5Percent() {
		assertTrue(Math.abs((ItemUtil.nearest5Percent(1.03)) - 1.05) < 0.0001);
	}

	@Test
	public void testRoundPrice() {
		assertTrue(Math.abs((ItemUtil.roundPrice(10.125456) - 10.12)) > 0.008);
	}

	@Test
	public void testIsExempt() {
		assertTrue(ItemUtil.isExempt("chocolate bar"));
	}

}
