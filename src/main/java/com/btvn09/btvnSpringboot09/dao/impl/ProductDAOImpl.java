package com.btvn09.btvnSpringboot09.dao.impl;


import com.btvn09.btvnSpringboot09.dao.ProductDAO;
import com.btvn09.btvnSpringboot09.database.ProductDB;
import com.btvn09.btvnSpringboot09.products.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<Product> findName(String prefix){
        List<Product>result=new ArrayList<>();
        for (Product product : ProductDB.products) {
            if(product.getName().toLowerCase().startsWith(prefix.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
    @Override
    public List<Product> findPrice( int min, int max){
        List<Product>result=new ArrayList<>();
        for (Product product : ProductDB.products) {
            if(product.getPrice()<=max&&product.getPrice()>=min){
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> findBrand(String brand){
        List<Product>result=new ArrayList<>();
        for(Product product:ProductDB.products){
            if(product.getBrand().toLowerCase().equals(brand.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product findMaxPrice(String brand){
        ProductDB.products.sort(new Comparator<Product>(){
            @Override
            public int compare(Product o1,Product o2){
                return o2.getPrice()-o1.getPrice();
            }
        });
        for(Product product:ProductDB.products){
            if(product.getBrand().toLowerCase().equals(brand.toLowerCase())){
                return product;
            }
        }
        return null;
}


}
