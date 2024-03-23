package com.example.springwebmvc.controller;

import com.example.springwebmvc.dto.ProductCreateRequest;
import com.example.springwebmvc.dto.ProductEditRequest;
import com.example.springwebmvc.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/products")

public class ProductControllerV2 {
    private final ProductService productService;

    @GetMapping
    Map<String, Object> findAllproduct() {
        Map<String, Object> product = new HashMap<>();
        product.put("Message", productService.findproducts());
        return product;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct(@Valid @RequestBody ProductCreateRequest
                                  request) {
        System.out.println("Message: " + request);
        productService.createNewProduct(request);
    }
    @Operation(summary = "Find all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id product",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content) })
    @GetMapping("/uuid/{uuid}")
    public Map<String,Object> findProductByUUid(@PathVariable String uuid){
        return Map.of(
                "Message","Product has been found",
                "data",productService.findproductByUuid(uuid)
        );
    }
    @GetMapping("/{id}")
    public Map<String,Object> findProductById(@PathVariable Integer id){
        return Map.of(
                "Message","Product has been found",
                "data",productService.findproductById(id)
        );
    }
    @PutMapping("/{uuid}")
    void editProduct(@PathVariable String uuid,@RequestBody ProductEditRequest response){
        productService.editProductByUuid(uuid,response);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @DeleteMapping("/{uuid}")
    void deletedProduct(@PathVariable String uuid){
        productService.deleteByUuid(uuid);
    }


}
