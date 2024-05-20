package com.btvn09.btvnSpringboot09.dao.impl;


import com.btvn09.btvnSpringboot09.dao.ProductDAO;
import com.btvn09.btvnSpringboot09.database.ProductDB;
import com.btvn09.btvnSpringboot09.products.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.btvn09.btvnSpringboot09.database.ProductDB.products;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        return ProductDB.products; // select * from books
    }

    @Override
    public Product findId(int id) {
        return findAll().stream()
                .filter(product -> product.getId()==(id))
                .findFirst()
                .orElse(null);
    }


}



