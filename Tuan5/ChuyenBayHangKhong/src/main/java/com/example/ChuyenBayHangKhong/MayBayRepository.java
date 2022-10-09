package com.example.ChuyenBayHangKhong;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MayBayRepository  extends CrudRepository<mayBay, Long> {
    @Query(value = "SELECT * FROM maybay where tambay > ?1",nativeQuery = true)
    public List<mayBay> getTamBay(String TamBay);

}
