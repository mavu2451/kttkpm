package com.example.ChuyenBayHangKhong;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "nhanvien")
public class nhanVien {
    @Id
    @Column(name = "manv")
    private String MaNV;
    @Column(name = "ten")
    private String Ten;
    @Column(name = "luong")
    private Integer Luong;
}
