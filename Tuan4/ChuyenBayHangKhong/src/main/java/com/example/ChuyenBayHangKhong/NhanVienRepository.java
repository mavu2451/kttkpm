package com.example.ChuyenBayHangKhong;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NhanVienRepository extends CrudRepository<nhanVien, Long> {
    @Query(value = "SELECT * FROM nhanvien where luong < ?1 ",nativeQuery = true)
    public List<nhanVien> getLuong(Integer Luong);
}
