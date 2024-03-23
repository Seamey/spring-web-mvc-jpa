package com.example.springwebmvc.controller;

import com.example.springwebmvc.dto.categorydto.CategoryRequest;
import com.example.springwebmvc.dto.categorydto.CategoryResponse;
import com.example.springwebmvc.model.Category;
import com.example.springwebmvc.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("/{id}")
    CategoryResponse findcategoryById(@PathVariable Integer id){
       return categoryService.findCategoryById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewCategory(@RequestBody CategoryRequest request){
        categoryService.createCategory(request);

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PutMapping("/{id}")
    CategoryResponse editCategoryById(@PathVariable Integer id ,@Valid @RequestBody CategoryResponse response){
        return  categoryService.editCategoryByid(id ,response);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable Integer id){
        categoryService.deletedById(id);
    }


    @Operation(summary = "Find all Categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the category",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found",
                    content = @Content) })
    @GetMapping
    Map<String,Object> findAllCategories(){
        Map<String,Object> data = new HashMap<>();
        data.put("Message",categoryService.findCategories());
        return data;
    }


}
