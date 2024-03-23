package com.example.springwebmvc.service;

import com.example.springwebmvc.dto.categorydto.CategoryRequest;
import com.example.springwebmvc.dto.categorydto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findCategories();
    CategoryResponse findCategoryById(Integer id);
    CategoryResponse findCategoryByName(String name);
    void createCategory (CategoryRequest request);
    CategoryResponse editCategoryByid(Integer id ,CategoryResponse request);
    void deletedById(Integer id);
}
