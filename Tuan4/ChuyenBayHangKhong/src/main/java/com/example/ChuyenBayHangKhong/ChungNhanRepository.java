package com.example.ChuyenBayHangKhong;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChungNhanRepository extends CrudRepository<chungNhan, Long> {
    @Query(value = "SELECT manv FROM chungnhan where mamb = ?1",nativeQuery = true)
    public List<chungNhan> getBoeing(String mamb);
}
