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
@Table(name = "chungnhan")
public class chungNhan {
    @Id
    @Column(name = "MaNV")
    private int MaNV;
    @Column(name = "MaMB")
    private int MaMB;
}
