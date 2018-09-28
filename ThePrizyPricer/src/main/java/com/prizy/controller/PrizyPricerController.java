package com.prizy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.prizy.service;

@RestController
public class PrizyPricerController {

    @Autowire
    PrizyPriceService prizyPriceService;
    
    @RequestMapping("/productLoader")
    public String productLoader(@RequestBody ProductLoaderInDto productLoaderInDto) {

        return prizyPriceService.productLoader(productLoaderInDto);
    }
    
    @RequestMapping("/productLoader")
    public List<ProductLoaderModel> productList() {
        
        return prizyPriceService.productList();
    }
    
    @RequestMapping("/productLoader")
    public ProductLoaderOutDto productLoader(int id) {
        
        return prizyPriceService.productView(id);
    }
}
