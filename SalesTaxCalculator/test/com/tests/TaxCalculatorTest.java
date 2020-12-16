package com.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import com.salestax.modal.Item;
import com.salestax.service.IItemService;
import com.salestax.service.impl.ImportTaxCalculator;
import com.salestax.service.impl.SalesTaxDecorator;

public class TaxCalculatorTest {

	@Test
	public void testGetPrice() {
		IItemService item = new Item("Test", 100.00);
		assertEquals(item.getItemName(), "Test");
		System.out.println(item.getItemPrice());
		assertTrue(Math.abs((item.getItemPrice() - 100.00)) < 0.001);
		
		item = new ImportTaxCalculator(item);
		System.out.println(item.getItemPrice());
		assertTrue(Math.abs((item.getItemPrice() - 105.00)) < 0.001);


		item = new SalesTaxDecorator(item);
		System.out.println(item.getItemPrice());
		assertTrue(Math.abs((item.getItemPrice() - 115.00)) < 0.001);

		
		System.out.println(item.getOriginalPrice());
		assertTrue(Math.abs((item.getOriginalPrice() - 100.00)) < 0.001);
	}

}
