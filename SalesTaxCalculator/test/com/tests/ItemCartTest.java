package com.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.salestax.modal.ItemCart;
import com.salestax.util.ItemParser;

public class ItemCartTest {

	@Test
	public void testInput() {
		ItemCart sc = new ItemCart();
		sc.putItem(ItemParser.parser("1 book at 12.49"), ItemParser.count("1 book at 12.49"));
		sc.putItem(ItemParser.parser("1 music CD at 14.99"), ItemParser.count("1 music CD at 14.99"));
		sc.putItem(ItemParser.parser("1 chocolate bar at 0.85"), ItemParser.count("1 chocolate bar at 0.85"));
		sc.printOrder();
		sc.printResult();
		assertTrue (Math.abs((sc.getTotalTax() - 1.50)) < 0.001);
		assertTrue (Math.abs((sc.getTotal() - 29.83)) < 0.001);
	}

	@Test
	public void testInputMultipleItems() {
		ItemCart sc = new ItemCart();
		sc.putItem(ItemParser.parser("2 book at 12.49"), ItemParser.count("2 book at 12.49"));
		sc.putItem(ItemParser.parser("2 music CD at 14.99"), ItemParser.count("2 music CD at 14.99"));
		sc.putItem(ItemParser.parser("2 chocolate bar at 0.85"), ItemParser.count("2 chocolate bar at 0.85"));
		sc.printOrder();
		sc.printResult();
	}

	@Test
	public void testDoubleEntry() {
		ItemCart sc = new ItemCart();
		sc.putItem(ItemParser.parser("2 book at 10.00"), ItemParser.count("2 book at 10.00"));
		sc.putItem(ItemParser.parser("2 book at 100.00"), ItemParser.count("2 book at 100.00"));
		sc.printOrder();
		sc.printResult();
		assertTrue(sc.getItems().size() == 2);
	}

	@Test
	public void testDoubEntry() {
		ItemCart sc = new ItemCart();
		sc.putItem(ItemParser.parser("2 book at 10.00"), ItemParser.count("2 book at 10.00"));
		sc.putItem(ItemParser.parser("2 book at 10.00"), ItemParser.count("2 book at 10.00"));
		sc.printOrder();
		sc.printResult();
		assertTrue(sc.getItems().size() == 1);
	}
}
