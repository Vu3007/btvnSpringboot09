package com.btvn09.btvnSpringboot09.utils;


import com.btvn09.btvnSpringboot09.products.Product;

import java.util.List;

public interface IFileReader {
    List<Product> readFile(String filePath);
}
