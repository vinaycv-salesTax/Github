package com.salestax.service.impl;

import com.salestax.service.IItemService;
import com.salestax.util.ItemUtil;

public abstract class TaxCalculator implements IItemService {

	protected IItemService item;

	protected double rate;

	abstract double getRate();

	public TaxCalculator(IItemService item) {
		this.item = item;
	}

	public double getItemPrice() {
		double salesTax = ItemUtil.nearest5Percent(this.item.getOriginalPrice() * this.getRate());
		return ItemUtil.roundPrice(this.item.getItemPrice() + salesTax);
	}

}