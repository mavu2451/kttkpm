package com.example.RestAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerExample {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get-for-object")
    public Username getForObject() {
        int id = 1;
        return restTemplate.getForObject("/" + id, Username.class);
    }

    @GetMapping("/get-for-entity")
    public Username getForEntity() {
        int id = 2;
        ResponseEntity<Username> entity = restTemplate.getForEntity("/" + id, Username.class);
        return entity.getBody();
    }
}