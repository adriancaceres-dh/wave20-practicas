package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClothingRepository extends JpaRepository<Clothing, Long> {
    List<Clothing> getAllBySizeEqualsIgnoreCase(String size);
    List<Clothing> getAllByNameContains(String size);

    @Query("SELECT SUM(c.price) FROM Clothing c WHERE c.id in :clothingIdList")
    Double calculateTotalPrice(List<Long> clothingIdList);
}
