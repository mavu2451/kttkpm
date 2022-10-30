package com.example.nhanvien.controller;

import com.example.nhanvien.entity.nhanVien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NhanVienRepository extends CrudRepository<nhanVien, Long> {
    @Query(value = "SELECT * FROM nhanvien ",nativeQuery = true)
    public List<nhanVien> getAll();
}
