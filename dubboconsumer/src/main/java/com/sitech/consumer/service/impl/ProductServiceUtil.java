package com.sitech.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sitech.consumer.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceUtil  implements ProductService {

    @Reference
    private com.sitech.api.Service service;


    @Override
    public String requestData(String str) {
        return service.requestData(str);
    }
}
