package com.btvn09.btvnSpringboot09.utils.file;

import com.btvn09.btvnSpringboot09.products.Product;
import com.btvn09.btvnSpringboot09.utils.IFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Component
public class JsonFileReader implements IFileReader {
    @Override
    public List<Product> readFile(String filePath) {
        System.out.println("Read data from JSON file");
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Product> products = mapper.readValue(new File(filePath), new TypeReference<List<Product>>() {});
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();  // Trả về danh sách rỗng nếu có lỗi xảy ra
        }
    }
}