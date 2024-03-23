//package com.example.springwebmvc.controller;
//
//import com.example.springwebmvc.dto.PatchProductRequest;
//import com.example.springwebmvc.dto.ProductCreateRequest;
//import com.example.springwebmvc.dto.ProductEditRequest;
//import com.example.springwebmvc.exception.ValidationException;
//import com.example.springwebmvc.service.ProductService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor  // that annotation 's lombok
//// url standard of RESTFul
//@RequestMapping("/api/v1/products")  // mean group of mapping http method
//public class  ProductController {
//    // that called controller injecrtion dependenc of service
//    private final ProductService productService;
//
//    // @RequestBody
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    void createNewProduct(@Valid @RequestBody ProductCreateRequest request){
//        System.out.println("REQUEST : "+request);
//        productService.createNewProduct(request);
//    }
//
//    @PutMapping("/{uuid}")
//    void editProductByUuid(@PathVariable String uuid,@RequestBody ProductEditRequest request){
//        System.out.println("REQUEST: "+ request);
//        productService.editProductByUuid(uuid,request);
//
//    }
//    @ResponseStatus(HttpStatus.NO_CONTENT)  // mean success with no respone back = status 204
//    @DeleteMapping("/{uuid}")
//    void deletedProductByUuid(@PathVariable String uuid){
//        productService.deleteByUuid(uuid);
//    }
//
//
////    @GetMapping("/product")
////    String findProducts(){
////        return " find all products";
////    }
//
//    @GetMapping("/name")
//    Map<String, Object> findProductsByName(@RequestParam(name ="") String name){
//        return Map.of(
//                "Message","Product has been found",
//                "data",productService.findproductsByName(name)
//        );
//
//    }
//
//    // Status code
//    @GetMapping
//    ResponseEntity<Map<String, Object> > findProducts(){
//        // by constructor
//        //        return new  ResponseEntity<>( Map.of(
////                "Message","Product has been found",
////                "data",productService.findproducts()
////        ),HttpStatus.OK);
//
//        /// builder partten
//        Map<String, Object>  data = Map.of(
//               "Message","Product has been found",
//                "data",productService.findproducts());
//        return ResponseEntity.accepted().body(data);
//    }
//    @GetMapping("/{id}")
//    Map<String ,Object> findProductById(@PathVariable Integer id){
//        return Map.of(
//                "Message","Product has been found",
//                "data",productService.findproductById(id)
//        );
//    }
//    @GetMapping("uuid/{uuid}")
//    Map<String ,Object> findProductById(@PathVariable String uuid){
//        return Map.of(
//                "Message","Product has been found",
//                "data",productService.findproductByUuid(uuid)
//        );
//    }
//
//
//}
