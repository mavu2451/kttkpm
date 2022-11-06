package com.example.chuyenbay.controller;

import com.example.chuyenbay.entity.ChuyenBay;
import com.example.chuyenbay.repository.ChuyenBayRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;
    private static final String ChuyenBay_T = "chuyenbay";
    private static final String MayBayURL = "http://localhost:8081/";

    int count = 1;
    @GetMapping("mb")
    @Retry(name = ChuyenBay_T)
    public String mayBay(){
        String url = MayBayURL + "maybay";
        System.out.println("Retry " + count++ + "at" + new Date());
        return restTemplate.getForObject(url,String.class);
    }
    @PostMapping
    public ChuyenBay save(@RequestBody ChuyenBay chuyenBay) {
        return chuyenBayRepository.save(chuyenBay);
    }

    @GetMapping
    public List<ChuyenBay> getAllChuyenBay() {
        return chuyenBayRepository.findAll();
    }

    @GetMapping("/{id}")
    public ChuyenBay findChuyenBay(@PathVariable int id) {
        return chuyenBayRepository.findChuyenBayById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return chuyenBayRepository.deleteChuyenBay(id);
    }
}
