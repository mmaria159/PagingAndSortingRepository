package com.pagination.service;

import com.pagination.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(PageRequest pageRequest);
    List<Product> search(String search);
}
