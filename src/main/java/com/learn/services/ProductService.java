package com.learn.services;

import java.util.List;

import com.learn.domain.Product;

/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(Long id);

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	Product getById(Long id);

	/**
	 * List all.
	 *
	 * @return the list
	 */
	List<Product> listAll();

	/**
	 * Save or update.
	 *
	 * @param product the product
	 * @return the product
	 */
	Product saveOrUpdate(Product product);

}
