package com.example.nhanvien.controller;

import com.example.nhanvien.entity.nhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @RequestMapping
    public List<nhanVien> getAll(){
        return (List<nhanVien>) this.nhanVienRepository.getAll();
    }
}
