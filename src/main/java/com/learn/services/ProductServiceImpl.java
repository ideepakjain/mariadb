package com.learn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.domain.Product;
import com.learn.repositories.ProductRepository;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {

	/** The product repository. */
	private ProductRepository productRepository;

	/**
	 * Instantiates a new product service impl.
	 *
	 * @param productRepository the product repository
	 */
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);

	}

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@Override
	public Product getById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	/**
	 * List all.
	 *
	 * @return the list
	 */
	@Override
	public List<Product> listAll() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add); // fun with Java 8
		return products;
	}

	/**
	 * Save or update.
	 *
	 * @param product the product
	 * @return the product
	 */
	@Override
	public Product saveOrUpdate(Product product) {
		productRepository.save(product);
		return product;
	}

}
