package com.wolkensoftware.commonmodule.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDTO {

	private String productName;

	private String productType;

	private double productPrice;

	private int productQuantity;

	private String productAvailability;

	private int productRating;

}
