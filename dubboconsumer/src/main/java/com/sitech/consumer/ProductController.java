package com.sitech.consumer;

import com.sitech.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/request")
    public String request(String str){
        String prefix = "consumer:";
        return prefix + productService.requestData(str);
    }
}
