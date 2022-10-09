package com.example.ChuyenBayHangKhong;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChuyenBayRepository extends CrudRepository<chuyenBay, Long> {
    @Query(value = "SElECT * FROM chuyenbay where gaden = ?1", nativeQuery = true)
    public List<chuyenBay> getGaDen(String GaDen);
    @Query(value = "SELECT * FROM chuyenbay where dodai < ?1 and dodai > ?2",nativeQuery = true)
    public List<chuyenBay> getDoDai(Integer dodai1, Integer dodai2);
    @Query(value = "SELECT * FROM chuyenbay where gadi = ?1 and gaden = ?2",nativeQuery = true)
    public List<chuyenBay> getSGNBMV(String sg, String bmt);
//    @Query(countQuery = "SELECT COUNT(gadi) FROM chuyenbay where gadi = ?1",nativeQuery = true)
//    public List<chuyenBay> getSGN(String sgn);
}