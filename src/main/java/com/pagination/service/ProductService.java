package com.pagination.service;

import com.pagination.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {
    Page<Product> findAll(PageRequest pageRequest);
}
