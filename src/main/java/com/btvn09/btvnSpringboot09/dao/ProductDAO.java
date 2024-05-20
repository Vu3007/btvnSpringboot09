package com.btvn09.btvnSpringboot09.dao;

import com.btvn09.btvnSpringboot09.products.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findId(int id);
}
