package com.learn.repositories;

import org.springframework.data.repository.CrudRepository;

import com.learn.domain.Product;

/**
 * The Interface ProductRepository.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
