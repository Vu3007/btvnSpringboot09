package com.btvn09.btvnSpringboot09.service;

import com.btvn09.btvnSpringboot09.products.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(int id);
}
