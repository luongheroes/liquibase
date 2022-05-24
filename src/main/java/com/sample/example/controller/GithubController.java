package com.sample.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.example.common.JsonUtils;
import com.sample.example.model.GitHubUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@AllArgsConstructor
@Slf4j
public class GithubController {


    @GetMapping("/github/user")
    public GitHubUser getUser(@Validated @RequestParam("name") String name) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.github.com/users/";
        uri = uri.concat(name);
        String data = restTemplate.getForObject(uri, String.class);
        log.info("Data response: " + data);
        if (Objects.isNull(data)) {
            return new GitHubUser();
        }
        GitHubUser gitHubUser = JsonUtils.toObject(data, GitHubUser.class);
        log.info("Data response: " + gitHubUser);
        return gitHubUser;
    }

}
