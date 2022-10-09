package com.example.ChuyenBayHangKhong;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "chuyenbay",schema = "mysql")
public class chuyenBay {
    @Id
    @Column(name="macb")
    private String MaCB;
    @Column(name="gadi")
    private String GaDi;
    @Column(name="gaden")
    private String GaDen;
    @Column(name="dodai")
    private Integer DoDai;
    @Column(name="giodi")
    private Time GioDi;
    @Column(name="gioden")
    private Time GioDen;
    @Column(name="chiphi")
    private Integer ChiPhi;
}