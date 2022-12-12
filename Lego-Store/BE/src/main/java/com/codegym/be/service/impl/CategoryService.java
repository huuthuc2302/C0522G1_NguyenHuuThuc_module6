package com.codegym.be.service.impl;

import com.codegym.be.model.Category;
import com.codegym.be.repository.ICategoryRepository;
import com.codegym.be.service.ICategoryService;
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
