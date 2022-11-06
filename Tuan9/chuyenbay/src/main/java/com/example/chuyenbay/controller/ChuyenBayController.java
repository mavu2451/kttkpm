package com.example.chuyenbay.controller;

import com.example.chuyenbay.entity.ChuyenBay;
import com.example.chuyenbay.repository.ChuyenBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

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
