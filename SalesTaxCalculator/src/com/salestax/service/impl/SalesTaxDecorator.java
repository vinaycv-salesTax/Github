package com.salestax.service.impl;

import com.salestax.service.IItemService;

public class SalesTaxDecorator extends TaxCalculator {

	private IItemService itemToDecorate;

	final double rate = 0.1;

	public SalesTaxDecorator(IItemService item) {
		super(item);
		this.itemToDecorate = item;
	}

	@Override
	double getRate() {
		return this.rate;
	}

	public boolean isImportedItem() {
		return itemToDecorate.isImportedItem();
	}

	public String getItemName() {
		return itemToDecorate.getItemName();
	}

	public double getOriginalPrice() {
		return itemToDecorate.getOriginalPrice();
	}

	@Override
	public int hashCode() {
		return this.getItemName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj instanceof IItemService) {
			return (((IItemService) obj).hashCode() == this.hashCode());

		} else
			return false;
	}

	@Override
	public boolean isExemptItem() {
		return itemToDecorate.isExemptItem();
	}

}