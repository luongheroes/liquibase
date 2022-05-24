package com.sample.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "gitHub", url = "https://api.github.com/")
public interface FeignClientExample {
    @GetMapping(value = "users/{name}")
    String getUser(@PathVariable("name") String name);
}
