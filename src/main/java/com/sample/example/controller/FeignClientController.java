package com.sample.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.example.common.JsonUtils;
import com.sample.example.model.DataSample;
import com.sample.example.model.GitHubUser;
import com.sample.example.service.FeignClientExample;
import com.sample.example.service.FeignUserManagerExample;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class FeignClientController {

    FeignClientExample feignClientExample;
    FeignUserManagerExample feignUserManagerExample;

    @GetMapping("/feign/user")
    public GitHubUser getUser(@Validated @RequestParam("name") String name) throws JsonProcessingException {
        String data = feignClientExample.getUser(name);
        log.info("data: " + data);
        GitHubUser gitHubUser = JsonUtils.toObject(data, GitHubUser.class);
        log.info("gitHubUser: " + gitHubUser);
        return gitHubUser;
    }
    @GetMapping("/feign/dataSample")
    public DataSample getDataSample() throws JsonProcessingException {
        String data = feignUserManagerExample.getDataSample();
        log.info("data: " + data);
        DataSample dataSample = JsonUtils.toObject(data, DataSample.class);
        log.info("dataSample: " + dataSample);
        return dataSample;
    }

}
