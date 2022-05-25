package com.pagination;

import com.pagination.entity.Product;
import com.pagination.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Page<Product> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "30") int size,
            @RequestParam(value = "sortCriterion", defaultValue = "id") String sortCriterion,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") Sort.Direction sortDirection
    ) {
        return productService.findAll(getPageRequest(page, size, sortCriterion, sortDirection));
    }

    private PageRequest getPageRequest(int page, int size, String sortCriterion, Sort.Direction sortDirection) {
        return PageRequest.of(page, size, Sort.by(sortDirection, sortCriterion));
    }
}
