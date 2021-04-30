package com.wolkensoftware.commonmodule.exceptions;

public class ProductTypeException extends Exception {

	@Override
	public String toString() {
		return "ProductType is either not in the right format or violates length constraints";

	}

}
