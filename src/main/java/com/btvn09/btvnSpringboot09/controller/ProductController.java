package com.btvn09.btvnSpringboot09.controller;

import com.btvn09.btvnSpringboot09.products.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

        private final List<Product> products;
        public ProductController() {
            products = new ArrayList<>();
            products.add(new Product("1", "iPhone 12", "The latest iPhone", 999,"Apple"));
            products.add(new Product("2", "iPhone 13", "The latest iPhone", 9998,"Apple"));
            products.add(new Product("3", "iPhone 14", "The latest iPhone", 9979,"Apple"));
            products.add(new Product("4", "iPhone 15", "The latest iPhone", 8999,"Apple"));
            products.add(new Product("5", "iPhone 8", "The latest iPhone", 9919,"Apple"));
            products.add(new Product("6", "iPhone 7", "The latest iPhone", 990,"Apple"));
            products.add(new Product("7", "iPhone 6", "The latest iPhone", 77,"Apple"));
            products.add(new Product("8", "iPhone 5", "The latest iPhone", 33,"Apple"));
            products.add(new Product("9", "iPhone 4", "The latest iPhone", 11,"Apple"));
            products.add(new Product("10", "iPhone 3", "The latest iPhone", 6,"Apple"));

        }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
            return products;
    }


    }

