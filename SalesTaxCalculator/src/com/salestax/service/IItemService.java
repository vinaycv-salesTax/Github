package com.salestax.service;

public interface IItemService {

	String getItemName();

	double getOriginalPrice();

	boolean isImportedItem();

	boolean isExemptItem();

	double getItemPrice();

}