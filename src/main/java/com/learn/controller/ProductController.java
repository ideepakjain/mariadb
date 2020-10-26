package com.learn.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.domain.Product;
import com.learn.services.ProductService;

/**
 * The Class ProductController.
 */
@RestController
public class ProductController {

	/** The product service. */
	private ProductService productService;

	/**
	 * Adds the.
	 *
	 * @param product the product
	 */
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		productService.saveOrUpdate(product);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Long id) {
		productService.delete(id);
	}

	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Long id) {
		try {
			Product product = productService.getById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * List.
	 *
	 * @return the list
	 */
	@GetMapping("/products")
	public List<Product> list() {
		return productService.listAll();
	}

	/**
	 * Sets the product service.
	 *
	 * @param productService the new product service
	 */
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Update.
	 *
	 * @param product the product
	 * @param id      the id
	 * @return the response entity
	 */
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id) {
		try {
			Product existProduct = productService.getById(id);
			productService.saveOrUpdate(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
