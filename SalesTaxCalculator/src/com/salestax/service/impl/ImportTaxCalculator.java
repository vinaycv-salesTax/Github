package com.salestax.service.impl;

import com.salestax.service.IItemService;

public class ImportTaxCalculator extends TaxCalculator {

	private IItemService item;

	final double rate = 0.05;

	public ImportTaxCalculator(IItemService item) {
		super(item);
		this.item = item;
	}

	@Override
	double getRate() {
		return this.rate;
	}
	
	public boolean isImportedItem() {
		return item.isImportedItem();
	}

	public String getItemName() {
		return item.getItemName();
	}

	public double getOriginalPrice() {
		return item.getOriginalPrice();
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
		return item.isExemptItem();
	}
}