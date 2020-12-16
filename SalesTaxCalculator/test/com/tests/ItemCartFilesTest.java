package com.tests;

import org.junit.Test;

import com.salestax.util.ItemUtil;

public class ItemCartFilesTest {

	@Test
	public void testFileEntry1() {
		ItemUtil.getFromFile("source/data1.txt");
	}
	
	@Test
	public void testFileEntry2() {
		ItemUtil.getFromFile("source/data2.txt");
	}
	
	@Test
	public void testFileEntry3() {
		ItemUtil.getFromFile("source/data3.txt");
	}

	@Test
	public void testFileEntry4() {
		ItemUtil.getFromFile("source/data4.txt");
	}
}
