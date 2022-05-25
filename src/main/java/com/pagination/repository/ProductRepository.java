package com.pagination.repository;

import com.pagination.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE LOWER(CONCAT(p.name, p.category, p.description)) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Product> search(@Param("search") String search);

}
