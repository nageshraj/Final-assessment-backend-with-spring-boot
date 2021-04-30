package com.wolkensoftware.commonmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products_details_table")
@Getter
@Setter
public class ProductsEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_type")
	private String productType;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_quantity")
	private int productQuantity;

	@Column(name = "product_availability")
	private String productAvailability;

	@Column(name = "product_rating")
	private int productRating;

}
