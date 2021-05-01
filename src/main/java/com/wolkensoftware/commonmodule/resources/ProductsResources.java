package com.wolkensoftware.commonmodule.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolkensoftware.commonmodule.DTO.ProductsDTO;
import com.wolkensoftware.commonmodule.entity.ProductsEntity;
import com.wolkensoftware.commonmodule.service.ProductsService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class ProductsResources {

	Logger logger = LoggerFactory.getLogger(ProductsResources.class);

	@Autowired
	ProductsService productsService;

	@PutMapping("/addProduct")
	public ResponseEntity<ProductsEntity> registerUser(@RequestBody ProductsDTO productsDTO) {

		logger.info("INSIDE /addProduct");

		ProductsEntity productsEntity = null;

		try {
			productsEntity = productsService.validateAndAddProduct(productsDTO);
		} catch (NullPointerException e) {
			logger.error(e.toString());
		}

		if (productsEntity != null)
			return new ResponseEntity<ProductsEntity>(productsEntity, HttpStatus.OK);
		else
			return new ResponseEntity<ProductsEntity>(productsEntity, HttpStatus.FAILED_DEPENDENCY);

	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductsEntity>> getAllProducts() {

		logger.info("INSIDE /getAllProducts");

		List<ProductsEntity> allProducts = null;

		try {
			allProducts = productsService.validateAndGetAllProducts();
		} catch (NullPointerException e) {
			e.toString();
		}
		if (allProducts != null)
			return new ResponseEntity<List<ProductsEntity>>(allProducts, HttpStatus.OK);
		else
			return new ResponseEntity<List<ProductsEntity>>(allProducts, HttpStatus.FAILED_DEPENDENCY);

	}

	@GetMapping("/getAllProductsByType/{type}")
	public ResponseEntity<List<ProductsEntity>> getAllProductsByType(@PathVariable String type) {

		logger.info("INSIDE /getAllProductsByType");

		List<ProductsEntity> allProductsByType = null;

		try {
			allProductsByType = productsService.validateAndGetProductsByType(type);
		} catch (NullPointerException e) {
			e.toString();
		}
		if (allProductsByType != null)
			return new ResponseEntity<List<ProductsEntity>>(allProductsByType, HttpStatus.OK);
		else
			return new ResponseEntity<List<ProductsEntity>>(allProductsByType, HttpStatus.FAILED_DEPENDENCY);

	}

	@GetMapping("/getProductByName/{name}")
	public ResponseEntity<ProductsEntity> getProductByName(@PathVariable String name) {

		logger.info("INSIDE /getProductByName");

		ProductsEntity productByName = null;

		try {
			productByName = productsService.validateAndGetProductByName(name);
		} catch (NullPointerException e) {
			e.toString();
		}
		if (productByName != null)
			return new ResponseEntity<ProductsEntity>(productByName, HttpStatus.OK);
		else
			return new ResponseEntity<ProductsEntity>(productByName, HttpStatus.FAILED_DEPENDENCY);

	}

	@DeleteMapping("/deleteByName/{name}")
	public ResponseEntity<Integer> deleteByName(@PathVariable String name) {

		logger.info("INSIDE /deleteByName");

		Integer deleteByName = null;

		try {
			deleteByName = productsService.validateAndDeleteByName(name);
		} catch (NullPointerException e) {
			e.toString();
		}
		if (deleteByName != null)
			return new ResponseEntity<Integer>(deleteByName, HttpStatus.OK);
		else
			return new ResponseEntity<Integer>(deleteByName, HttpStatus.FAILED_DEPENDENCY);

	}
}
