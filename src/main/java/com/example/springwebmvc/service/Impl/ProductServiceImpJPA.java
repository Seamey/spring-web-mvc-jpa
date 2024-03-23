package com.example.springwebmvc.service.Impl;

import com.example.springwebmvc.dto.ProductCreateRequest;
import com.example.springwebmvc.dto.ProductEditRequest;
import com.example.springwebmvc.dto.ProductResponse;
import com.example.springwebmvc.model.Product;
import com.example.springwebmvc.respository.ProductRepository;
import com.example.springwebmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpJPA implements ProductService {
    private  final ProductRepository productRepository;
    @Override
    public List<ProductResponse> findproducts() {
       List<Product> products= productRepository.findAll();
        return products.stream().map(
                product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty())
        ).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findproductsByName(String name) {
        return null;
    }

    @Override
    public ProductResponse findproductById(Integer id) {
       Product product=  productRepository.findById(id).orElseThrow(
               ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
       ); /// it throw exception
        return new ProductResponse(product.getUuid(),
                product.getName(),
                product.getPrice(),
                product.getQty());
    }


    @Override
    public ProductResponse findproductByUuid(String uuid) {
        Product products= productRepository.findByUuid(uuid).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return new ProductResponse(products.getUuid(),
                products.getName(),
                products.getPrice(),
                products.getQty());
    }

    @Override
    public void createNewProduct(ProductCreateRequest request) {
        Product product = new Product();
        product.setUuid(UUID.randomUUID().toString());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQty(request.qty());
        product.setImportedDate(LocalDate.now());
        productRepository.save(product);
    }

    @Override
    public void editProductByUuid(String uuid, ProductEditRequest request) {
        Product product=productRepository.findByUuid(uuid).orElseThrow(()->
               new ResponseStatusException(HttpStatus.NOT_FOUND,"Product has not found")
        );
        product.setName(request.name());
        product.setPrice(request.price());
        productRepository.save(product);
    }

    @Override
    public void deleteByUuid(String uuid) {
        if(!productRepository.existsByUuid(uuid)){
          throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"product has not found");
        }
        productRepository.deleteByUuid(uuid);
    }


}
