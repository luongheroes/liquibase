package com.sample.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user", url = "localhost:8081/")
public interface FeignUserManagerExample {

    @GetMapping(value = "test")
    String getDataSample();

}
