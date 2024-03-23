//package com.example.springwebmvc.service.Impl;
//
//import com.example.springwebmvc.dto.PatchProductRequest;
//import com.example.springwebmvc.dto.ProductCreateRequest;
//import com.example.springwebmvc.dto.ProductEditRequest;
//import com.example.springwebmvc.dto.ProductResponse;
//import com.example.springwebmvc.model.Product;
//import com.example.springwebmvc.service.ProductService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Service
//@Slf4j  // annotation for log message
//public class ProductServiceImpl implements ProductService {
//
//    private List<Product> products;
//
//    public ProductServiceImpl() {
//        products = new ArrayList<>();
//        Product p1 = new Product();
//        p1.setId(1);
//        p1.setUuid(UUID.randomUUID().toString());
//        p1.setName("iPhone 14 Pro Max");
//        p1.setPrice(1300.0);
//        p1.setQty(1);
//        p1.setImportedDate(LocalDate.now());
//        p1.setStatus(true);
//        Product p2 = new Product();
//        p2.setId(2);
//        p2.setUuid(UUID.randomUUID().toString());
//        p2.setName("macBook M3 RAM 30GB");
//        p2.setPrice(2600.0);
//        p2.setQty(2);
//        p2.setImportedDate(LocalDate.now());
//        p2.setStatus(true);
//        products.add(p1);
//        products.add(p2);
//    }
//
//    @Override
//    public List<ProductResponse> findproducts() {
//        return products.stream()
//                .filter(pro->pro.getStatus().equals(true))
//                .map(product -> new ProductResponse(
//                        product.getUuid(),
//                        product.getName(),
//                        product.getPrice(),
//                        product.getQty()
//                )).toList();
//    }
//    @Override
//    public ProductResponse findproductsByName(String name) {
//        return products.stream()
//                .filter(pro-> pro.getName().toLowerCase().contains(name.toLowerCase()) && pro.getStatus().equals(true))
//                .map(product -> new ProductResponse(
//                        product.getUuid(),
//                        product.getName(),
//                        product.getPrice(),
//                        product.getQty()
//                )).findFirst().orElseThrow();
//    }
//
//
//    @Override
//    public ProductResponse findproductById(Integer id) {
//        return products.stream()
//                .filter(product ->
//                        product.getId().equals(id)&&
//                                product.getStatus().equals(true))
//                .map(product -> new ProductResponse(
//                        product.getUuid(),
//                        product.getName(),
//                        product.getPrice(),
//                        product.getQty()
//                )).findFirst().orElseThrow();
//    }
//
//    @Override
//    public ProductResponse findproductByUuid(String uuid) {
//        return products.stream()
//                .filter(pro->pro.getUuid().equals(uuid) && pro.getStatus().equals(true))
//                .map(product -> new ProductResponse(
//                        product.getUuid(),
//                        product.getName(),
//                        product.getPrice(),
//                        product.getQty()
//                )).findFirst().orElseThrow();
//    }
//
//    @Override
//    public void createNewProduct(ProductCreateRequest request) {
//        Product newProduct = new Product();
//        newProduct.setName(request.name());
//        newProduct.setPrice(request.price());
//        newProduct.setQty(request.qty());
//        newProduct.setId(products.size() + 1);
//        newProduct.setUuid(UUID.randomUUID().toString());
//        newProduct.setStatus(true);
//        products.add(newProduct);
//    }
//
//    @Override
//    public void editProductByUuid(String uuid, ProductEditRequest request) {
//        // check uuid if exits
//         products.stream().filter(pro->pro.getUuid().equals(uuid))
//                .peek(oldProduct->{
//                    oldProduct.setName(request.name());
//                    oldProduct.setPrice(request.price());
//
//                }).count();
//              // .peek mean map but not return
//
//    }
////    @Override
////    public void deleteByUuid(String uuid) {
////       products = products.stream().filter(pro->!pro.getUuid().equals(uuid)
//    //              .collection(Collection.tolist();
//    //                  log.into("Affected row: {} ",1);
////    }
//
//
//    @Override
//    public void deleteByUuid(String uuid) {
//        products.removeIf(product ->
//            product.getUuid().equals(uuid)
//        );
//        log.info("Affected row: {}",1);
//
//    }
//
//    @Override
//    public List<PatchProductRequest> patchingProduct(String name, PatchProductRequest request) {
//        if (!products.isEmpty()) {
//            products.stream().filter(pro -> pro.getName().toLowerCase().equals(name.toLowerCase()))
//                    .map(patchproduct -> {
//                        patchproduct.setQty(request.qty());
//                        patchproduct.setPrice(request.price());
//                        return patchproduct;
//                    }).toList();
//        }else {
//
//        }
//        return null;
//    }
//}
