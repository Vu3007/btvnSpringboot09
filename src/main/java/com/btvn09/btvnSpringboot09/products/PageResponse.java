package com.btvn09.btvnSpringboot09.products;

import java.util.List;

public interface PageResponse<T> {
    List<T> getContent();

    int getPageSize();

    int getTotalPages();

    int getTotalElements();

    int getCurrentPage();
}