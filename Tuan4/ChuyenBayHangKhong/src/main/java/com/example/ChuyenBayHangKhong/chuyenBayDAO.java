package com.example.ChuyenBayHangKhong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController
@RequestMapping("/api")
public class chuyenBayDAO {
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;
    @Autowired
    private MayBayRepository mayBayRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private  ChungNhanRepository chungNhanRepository;

    @GetMapping
    public List<chuyenBay> getAll(){
        return (List<chuyenBay>) this.chuyenBayRepository.findAll();
    }
    @GetMapping(value = "gaden/{gaDen}")
    public List<chuyenBay> gaDen(@PathVariable("gaDen") String gaDen){
//        List<chuyenBay> cb = chuyenBayRepository.getGaDen("DAD");
//        System.out.println(cb);
        return chuyenBayRepository.getGaDen(gaDen);
    }
    @GetMapping(value = "tambay/{tamBay}")
    public List<mayBay> tamBay(@PathVariable("tamBay") String tamBay){
//        List<mayBay> mb = mayBayRepository.getTamBay("10000");
//        System.out.println(mb);
        return mayBayRepository.getTamBay(tamBay);
    }
    @GetMapping(value = "allchuyenbay")
    public List<chuyenBay> getAllCB(){
//        List<chuyenBay> cb = (List<chuyenBay>) chuyenBayRepository.findAll();
//        System.out.println(cb);
        return (List<chuyenBay>) chuyenBayRepository.findAll();
    }
    @GetMapping(value = "allmaybay")
    public List<mayBay> getAllMB(){
//        List<mayBay> mb = (List<mayBay>) mayBayRepository.findAll();
//        System.out.println(mb);
        return (List<mayBay>) mayBayRepository.findAll();
    }
    @GetMapping(value = "luong/{luong}")
    public List<nhanVien> getLuong(@PathVariable("luong") Integer luong){
//        List<nhanVien> nv = nhanVienRepository.getLuong(10000);
//        System.out.println(nv);
        return nhanVienRepository.getLuong(luong);
    }
    @GetMapping(value = "dodaichuyenbay/{dodai1}/{dodai2}")
    public List<chuyenBay> getDoDaiChuyenBay(@PathVariable("dodai1") Integer dodai1, @PathVariable("dodai2") Integer dodai2){
//        List<chuyenBay> cb = chuyenBayRepository.getDoDai(10000,8000);
//        System.out.println(cb);
        return chuyenBayRepository.getDoDai(dodai1,dodai2);
    }
    @GetMapping(value = "timsgbmt/{sg}/{bmt}")
    public List<chuyenBay> getSGNBMV(@PathVariable("sg") String sg, @PathVariable("bmt") String bmt){
//        List<chuyenBay> cb = chuyenBayRepository.getSGNBMV("SGN","BMV");
//        System.out.println(cb);
        return chuyenBayRepository.getSGNBMV(sg,bmt);
    }
//    public void getSGN(){
//        List<chuyenBay> cb = chuyenBayRepository.getSGN("sgn");
//        System.out.println(cb);
//    }
//    public void boeing(){
//        List<chungNhan> cn = chungNhanRepository.getBoeing("737");
//        System.out.println(cn);
//    }
//    public void getVN(){
//        List<mayBay> mb = mayBayRepository.getVN280(11979);
//        System.out.println(mb);
//    }
    @Bean
    public CommandLineRunner run(){
        return (args -> {
        });
    }
}
