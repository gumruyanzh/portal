package com.product.service;

import com.product.core.Product;
import com.product.db.ProductRepository;

import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/6/17.
 */
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }


    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public long create(Product product) {
        return productRepository.create(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
