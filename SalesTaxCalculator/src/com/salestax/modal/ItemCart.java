package com.salestax.modal;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.salestax.service.IItemService;
import com.salestax.service.impl.ImportTaxCalculator;
import com.salestax.service.impl.SalesTaxDecorator;
import com.salestax.util.ItemUtil;

public class ItemCart {

	private static final String DECIMAL_FORMAT = "###.00";
	private final Map<IItemService, Integer> itemMap = new HashMap<IItemService, Integer>();

	DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT);

	public void putItem(IItemService item, int count) {
		if (item.isImportedItem())
			item = new ImportTaxCalculator(item);
		if (!item.isExemptItem())
			item = new SalesTaxDecorator(item);
		Integer i = this.itemMap.get(item);
		if (i != null)
			count += i;
		this.itemMap.put(item, count);
	}

	public void removeItem(IItemService item) {
		this.itemMap.remove(item);
	}

	public void clearItems() {
		this.itemMap.clear();
	}

	public Set<IItemService> getItems() {
		return itemMap.keySet();
	}

	public int getItemQuantity(IItemService item) {
		return itemMap.get(item);
	}

	public double getTotalTax() {
		double totalTax = 0;
		for (IItemService item : itemMap.keySet()) {
			double subTotal = item.getItemPrice() * getItemQuantity(item);
			double subInitTotal = item.getOriginalPrice() * getItemQuantity(item);
			totalTax += subTotal - subInitTotal;
		}
		return totalTax;
	}

	public double getTotal() {
		double totalAmount = 0;
		for (IItemService item : itemMap.keySet()) {
			double subTotal = item.getItemPrice() * getItemQuantity(item);
			totalAmount += subTotal;
		}
		return ItemUtil.roundPrice(totalAmount);
	}

	public void printOrder() {
		for (IItemService item : itemMap.keySet()) {
			System.out.println(
					itemMap.get(item) + " " + item.getItemName() + " at " + df.format(item.getOriginalPrice()));
		}
		System.out.println();
	}

	public void printResult() {
		double taxtotal = 0;
		double total = 0;
		Set<IItemService> taxedItems = itemMap.keySet();
		for (IItemService item : taxedItems) {
			double subTotal = item.getItemPrice() * getItemQuantity(item);
			double subInitTotal = item.getOriginalPrice() * getItemQuantity(item);
			taxtotal += subTotal - subInitTotal;
			total += subTotal;
			System.out.println(getItemQuantity(item) + " " + item.getItemName() + ": " + df.format(subTotal));
		}
		total = ItemUtil.roundPrice(total);
		System.out.println("Sales Taxes: " + df.format(taxtotal));
		System.out.println("Total: " + df.format(total));
		System.out.println();
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide required arguments.");
			System.out.println("Run as command: java -jar jarname filename(s)");
			System.exit(0);
		}
		for (String fileName : args)
			ItemUtil.getFromFile(fileName);
	}

}
