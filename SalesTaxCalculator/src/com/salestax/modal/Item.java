package com.salestax.modal;

import com.salestax.service.IItemService;

public class Item implements IItemService {

	private String itemName;
	private boolean isImportedItem = false;
	private boolean isExemptItem = false;
	private double originalPrice;

	public Item(String itemName, double originalPrice) {
		this.itemName = itemName;
		this.originalPrice = originalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isImportedItem() {
		return isImportedItem;
	}

	public void setImportedItem(boolean isImportedItem) {
		this.isImportedItem = isImportedItem;
	}

	public boolean isExemptItem() {
		return isExemptItem;
	}

	public void setExemptItem(boolean isExemptItem) {
		this.isExemptItem = isExemptItem;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int hashCode() {
		return itemName.hashCode() + new Integer((int) (originalPrice * 100));
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
	public double getItemPrice() {
		return this.originalPrice;
	}
}