package com.btvn09.btvnSpringboot09.controller;

import com.btvn09.btvnSpringboot09.products.PageResponse;
import com.btvn09.btvnSpringboot09.products.PageResponseImpl;
import com.btvn09.btvnSpringboot09.products.Product;
import com.btvn09.btvnSpringboot09.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.btvn09.btvnSpringboot09.database.ProductDB.products;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String getAllProduct(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "allProduct";
    }
    @GetMapping("products/{id}")
    public String getProductById(Model model, @PathVariable int id){
        Product product=productService.getProductById(id);
        model.addAttribute("product",product);
        return "productId";
    }
    @GetMapping("/products")
    public String getProductList(Model model,
                              @RequestParam(required = false, defaultValue = "1") int page,
                              @RequestParam(required = false, defaultValue = "5") int pageSize) {
        PageResponse<Product> pageData = new PageResponseImpl<>(products, page, pageSize);
        model.addAttribute("pageData", pageData);
        return "product-list";
    }

}