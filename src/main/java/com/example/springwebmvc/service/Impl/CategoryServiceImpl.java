package com.example.springwebmvc.service.Impl;

import com.example.springwebmvc.dto.categorydto.CategoryRequest;
import com.example.springwebmvc.dto.categorydto.CategoryResponse;
import com.example.springwebmvc.model.Category;
import com.example.springwebmvc.respository.CategoryRepository;
import com.example.springwebmvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> new CategoryResponse(
                        category.getName(),
                        category.getDescription()
                )).toList();
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
                                            // findById is the method 's abstraction Rpository
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Category has not found!"
                )); /// it throw exception
        return new CategoryResponse(category.getName(),category.getDescription());
    }

    @Override
    public CategoryResponse findCategoryByName(String name) {
        return null;
    }

    @Override
    public void createCategory(CategoryRequest request) {
        // check exits cuz name can't duplicate
        if(categoryRepository.existsByName(request.name())){ // existsByName create method for check existsing
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"Category name already existed! ");
        }
        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());
                categoryRepository.save(category);  // method save mean insert everything into database

    }

    @Override
    public CategoryResponse editCategoryByid(Integer id,CategoryResponse request) {
        // load old category
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Category has not found!"
                ));
        category.setName(request.name());
        category.setDescription(request.description());
        // mean save object category into categoryRepository
        categoryRepository.save(category);
    return this.findCategoryById(id);  // mean get latest data
}
    @Override
    public void deletedById(Integer id) {
        // check
        if(! categoryRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category has not found");
        }
        categoryRepository.deleteById(id);
    }
}