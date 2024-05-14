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
    public Product findById(int id) {
        return findAll().stream()
                .filter(product -> product.getId()==(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Product> findName(String prefix){
        return findAll().stream()
                .filter(product -> product.getName().toLowerCase().startsWith(prefix.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Product> findPrice( int min, int max){
        return findAll().stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findBrand(String brand){
        return findAll().stream()
                .filter(product -> product.getBrand().toLowerCase().equals(brand.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Product findMaxPrice(String brand){
      return findBrand(brand)
              .stream()
              .max((p1,p2)->p1.getPrice()- p2.getPrice())
              .orElse(null);
        }
}



