package com.btvn09.btvnSpringboot09.controller;

import com.btvn09.btvnSpringboot09.products.Product;
import com.btvn09.btvnSpringboot09.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.CREATED);
    }
    //1
   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product=productService.getProductById(id);
       if(product != null) {
           return ResponseEntity.ok(product); // 200
       }

       return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
   }
    //2
    @GetMapping("/name-starts/{prefix}")
    public  ResponseEntity<List<Product>> getName(@PathVariable String name){
        List<Product> products= productService.getName(name);
        if(products != null) {
            return ResponseEntity.ok(products); // 200
        }

        return ResponseEntity.ok( products);
    }
    //3
    @GetMapping("/price/{min}/{max}")
    public ResponseEntity<List<Product>> getPrice(@PathVariable int min,@PathVariable int max){
        List<Product> product1 = productService.getPrice(min,max);
        return ResponseEntity.ok(product1);
    }
    //4
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getBrand(@PathVariable String brand){
        List<Product> product2=productService.getBrand(brand);
        return  ResponseEntity.ok( product2);
    }
    //5
    @GetMapping("/brand/{brand}/max-price")
    public ResponseEntity<Product> getMaxPrice(@PathVariable String brand){
        Product product3=productService.getMaxPrice(brand);
        return ResponseEntity.ok(product3);


    }


//        private final List<Product> products;
//        public ProductController() {
//            products = new ArrayList<>();
//            products.add(new Product(1, "iPhone 12", "The latest iPhone", 999,"Apple"));
//            products.add(new Product(2, "iPhone 13", "The latest iPhone", 9998,"Apple"));
//            products.add(new Product(3, "iPhone 14", "The latest iPhone", 9979,"Apple"));
//            products.add(new Product(4, "iPhone 15", "The latest iPhone", 8999,"Apple"));
//            products.add(new Product(5, "iPhone 8", "The latest iPhone", 9919,"Apple"));
//            products.add(new Product(6, "iPhone 7", "The latest iPhone", 990,"Apple"));
//            products.add(new Product(7, "iPhone 6", "The latest iPhone", 77,"Apple"));
//            products.add(new Product(8, "iPhone 5", "The latest iPhone", 33,"Apple"));
//            products.add(new Product(9, "iPhone 4", "The latest iPhone", 11,"Apple"));
//            products.add(new Product(10, "iPhone 3", "The latest iPhone", 6,"Apple"));
//
//        }
//
//    @GetMapping
//    public  ResponseEntity<List<Product>> getAllProducts(){
//        return new ResponseEntity<>(products, HttpStatus.CREATED);
//    }
//    //1
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getBookById(@PathVariable int id) {
//        for (Product product : products) {
//            if (product.getId() == id) {
//                return new ResponseEntity<>(product, HttpStatus.OK); // 200
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
//    }
//
//    //2
//    @GetMapping("/name-starts/{prefix}")
//    public  ResponseEntity<List<Product>> getName(@PathVariable String prefix){
//            List<Product> result= new ArrayList<>();
//            for (Product product:products){
//                if (product.getName().toLowerCase()=="prefix"){
//                    result.add(product);
//            }
//         }
//        return ResponseEntity.ok( result);
//    }
//    //3
//    @GetMapping("/price/{min}/{max}")
//    public ResponseEntity<List<Product>> getPrice(@PathVariable int min,@PathVariable int max){
//            List<Product> result =new ArrayList<>() ;
//            for (Product product:products){
//                if (product.getPrice()>min&&product.getPrice()<max){
//                    result.add(product);
//                }
//            }
//            return  ResponseEntity.ok( result);
//    }
//    //4
//    @GetMapping("/brand/{brand}")
//    public ResponseEntity<List<Product>> getBrand(@PathVariable String brand){
//        List<Product> result =new ArrayList<>() ;
//        for (Product product:products){
//            if (product.getBrand()==brand){
//                result.add(product);
//            }
//        }
//        return  ResponseEntity.ok( result);
//    }
//    //5
//    @GetMapping("/brand/{brand}/max-price")
//    public ResponseEntity<List<Product>> getMaxPrice(@PathVariable String brand){
//        List<Product> result =new ArrayList<>() ;
//        int maxPrice=0;
//        for (Product product:products){
//            if (product.getPrice()>maxPrice){
//                maxPrice=product.getPrice();
//            }
//            result.add(product);
//
//        }
//        return  ResponseEntity.ok( result);
//
//}


}

