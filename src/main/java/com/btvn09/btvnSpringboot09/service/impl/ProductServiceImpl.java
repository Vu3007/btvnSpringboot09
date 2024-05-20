package com.btvn09.btvnSpringboot09.service.impl;

import com.btvn09.btvnSpringboot09.dao.ProductDAO;
import com.btvn09.btvnSpringboot09.products.Product;
import com.btvn09.btvnSpringboot09.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> getAllProduct() {
        return productDAO.findAll();
    }
    public Product getProductById(int id){
        return productDAO.findId(id);
    }

}
