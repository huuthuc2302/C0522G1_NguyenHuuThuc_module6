package com.example.legomanagerbe.repository;

import com.example.legomanagerbe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
