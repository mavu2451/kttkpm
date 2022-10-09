package com.example.ChuyenBayHangKhong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class chuyenBayDAO {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;
    @Autowired
    private MayBayRepository mayBayRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public void getGaDen(){
        List<chuyenBay> cb = chuyenBayRepository.getGaDen("DAD");
        System.out.println(cb);
    }
    public void getTamBay(){
        List<mayBay> mb = mayBayRepository.getTamBay("10000");
        System.out.println(mb);
    }
    public void getAllCB(){
        List<chuyenBay> cb = (List<chuyenBay>) chuyenBayRepository.findAll();
        System.out.println(cb);
    }
    public void getAllMB(){
        List<mayBay> mb = (List<mayBay>) mayBayRepository.findAll();
        System.out.println(mb);
    }
    public void getLuong(){
        List<nhanVien> nv = nhanVienRepository.getLuong(10000);
        System.out.println(nv);
    }
    public void getDoDaiChuyenBay(){
        List<chuyenBay> cb = chuyenBayRepository.getDoDai(10000,8000);
        System.out.println(cb);
    }
    public void getSGNBMV(){
        List<chuyenBay> cb = chuyenBayRepository.getSGNBMV("SGN","BMV");
        System.out.println(cb);
    }
    @Bean
    public CommandLineRunner run(){
        return (args -> {
            getSGNBMV();
        });
    }
}
