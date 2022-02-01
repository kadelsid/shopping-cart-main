package com.Cart.controller;

import com.Cart.Utils.ApiResponse;
import com.Cart.dto.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/client")
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody ProductRequest productRequest) {


        ResponseEntity <ProductRequest> product = restTemplate.postForEntity("http://localhost:8080/api/products", productRequest, ProductRequest.class);

        if (product.getStatusCodeValue() == HttpStatus.OK.value()){

            ProductRequest statusName = product.getBody();
            log.info("{} Successful", statusName);
            return ApiResponse.generateResponse(product.getStatusCodeValue(), "Successful", statusName, null);

        }
return ApiResponse.generateResponse(HttpStatus.BAD_REQUEST.value(), "Failed", null, "Request Failed");
    }

 /*   @PutMapping("/products")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {

        HttpEntity<ProductRequest> requestEntity = new HttpEntity<ProductRequest>(productRequest, null);

        ResponseEntity <ProductRequest> product = restTemplate.exchange("http://localhost:8080/api/products/{id}" + id, HttpMethod.PUT, requestEntity, ProductRequest.class);

        if (product.getStatusCodeValue() == HttpStatus.OK.value()){

            ProductRequest body = responseEntity.getBody();
            //log.info("{} Successful", statusName);
            Map<String, Object> resMap = new HashMap<>();
            resMap.put("order", body.getData());
            return ApiResponse.generateResponse(product.getStatusCodeValue(), "Successful", body, null);

        }
        return ApiResponse.generateResponse(HttpStatus.BAD_REQUEST.value(), "Failed", null, "Request Failed");
    }*/


/*
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {

    }

    @GetMapping("/products")
    public ResponseEntity<Object> getProduct(@RequestParam(name = "category", required = false) String category) {


    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id){

    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){

    }*/




}
