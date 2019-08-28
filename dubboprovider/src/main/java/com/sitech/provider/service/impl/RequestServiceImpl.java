package com.sitech.provider.service.impl;

import com.sitech.api.Service;
import com.sitech.api.utils.MethodUtils;

@com.alibaba.dubbo.config.annotation.Service
public class RequestServiceImpl implements Service {



    @Override
    public String requestData(String str) {

        String prefix = "{provider:";
        return prefix + str + ",ip:" + MethodUtils.getIp() + "}";
    }
}
