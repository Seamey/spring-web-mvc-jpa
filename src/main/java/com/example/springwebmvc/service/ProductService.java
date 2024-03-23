package com.example.springwebmvc.service;

import com.example.springwebmvc.dto.ProductCreateRequest;
import com.example.springwebmvc.dto.ProductEditRequest;
import com.example.springwebmvc.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductResponse> findproducts ();
    ProductResponse findproductsByName (String name);
    ProductResponse findproductById(Integer id);

    ProductResponse findproductByUuid(String uuid);
    void createNewProduct(ProductCreateRequest request);
    void editProductByUuid(String uuid, ProductEditRequest request);
   void deleteByUuid(String uuid);
}
