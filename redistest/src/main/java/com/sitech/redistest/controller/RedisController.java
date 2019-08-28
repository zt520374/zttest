package com.sitech.redistest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/redistest")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


        @RequestMapping("/setV")
        public String setV() {
            redisTemplate.opsForValue().set("ZHANGT", "huqian");
            log.info(redisTemplate.opsForValue().get("ZHANGT").toString());
            return "ok";
        }


         @RequestMapping("/getV")
          public String getV() {
             log.info(redisTemplate.opsForValue().get("ZHANGT").toString());
             return "ok";
         }

}
