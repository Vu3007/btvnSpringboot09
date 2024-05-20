package com.btvn09.btvnSpringboot09.products;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
     int id;
     String name;
     String description;
     String thumbnail;
     int price;
     Double rating;
     int priceDiscount;
}