package com.example.ChuyenBayHangKhong;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NhanVienRepository extends CrudRepository<nhanVien, Long> {
    @Query(value = "SELECT * FROM nhanvien where luong < ?1 ",nativeQuery = true)
    public List<nhanVien> getLuong(Integer Luong);
}
