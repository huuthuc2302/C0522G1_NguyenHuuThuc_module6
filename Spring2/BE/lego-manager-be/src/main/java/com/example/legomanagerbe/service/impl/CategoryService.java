package com.example.legomanagerbe.service.impl;

import com.example.legomanagerbe.model.Category;
import com.example.legomanagerbe.repository.ICategoryRepository;
import com.example.legomanagerbe.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRepository.findAll();
    }
}
