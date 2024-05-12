package com.btvn09.btvnSpringboot09.dao.impl;


import com.btvn09.btvnSpringboot09.dao.ProductDAO;
import com.btvn09.btvnSpringboot09.database.ProductDB;
import com.btvn09.btvnSpringboot09.products.Product;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.btvn09.btvnSpringboot09.database.ProductDB.products;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        return ProductDB.products; // select * from books
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    @Override
    public List<Product> findName(String name){
        for (Product product:products){
            if (product.getName().toLowerCase()=="prefix"){
                return ProductDB.products;
            }
         }
        return null;
    }
    @Override
    public List<Product> findPrice( int min, int max){
        for (Product product:products){
            if (product.getPrice()>min&&product.getPrice()<max){
                    return products;
                }
            }
            return  null;
    }
}
