package com.example.chuyenbay.repository;

import com.example.chuyenbay.entity.ChuyenBay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class ChuyenBayRepository {
    public static final String HASH_KEY = "chuyenbay";

    @Autowired
    private RedisTemplate template;

    public ChuyenBay save(ChuyenBay chuyenBay){
        template.opsForHash().put(HASH_KEY,chuyenBay.getId(),chuyenBay);
        return chuyenBay;
    }

    public List<ChuyenBay> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public ChuyenBay findChuyenBayById(int id){
        return (ChuyenBay) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteChuyenBay(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "Xoá thành công !!";
    }
}
