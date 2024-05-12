package com.btvn09.btvnSpringboot09.database;

import com.btvn09.btvnSpringboot09.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB implements CommandLineRunner {
    @Autowired
    private IFileReader fileReader;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Khởi tạo dữ liệu ban đầu cho ứng dụng");
        ProductDB.products = fileReader.readFile("products.json");

        System.out.println("Số lượng Products = " + ProductDB.products.size());
    }
}
