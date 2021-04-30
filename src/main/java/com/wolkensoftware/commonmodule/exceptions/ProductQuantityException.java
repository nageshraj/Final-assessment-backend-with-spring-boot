package com.wolkensoftware.commonmodule.exceptions;

public class ProductQuantityException extends Exception {

	@Override
	public String toString() {
		return "ProductQuantity is out of range (0-999)";

	}

}
