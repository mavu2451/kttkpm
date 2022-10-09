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
@Table(name = "maybay",schema = "mysql")
public class mayBay {
    @Id
    @Column(name="mamb")
    private String MaMB;
    @Column(name="loai")
    private String Loai;
    @Column(name="tambay")
    private Integer TamBay;
}
