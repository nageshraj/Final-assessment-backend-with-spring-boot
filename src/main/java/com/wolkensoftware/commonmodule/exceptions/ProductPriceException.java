package com.wolkensoftware.commonmodule.exceptions;

public class ProductPriceException extends Exception {

	@Override
	public String toString() {
		return "ProductPrice is out of range (0- 99,99,999)";

	}

}
