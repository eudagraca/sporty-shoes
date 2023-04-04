package com.shoes.sporty.reposotory;

import com.shoes.sporty.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {

    @Query("SELECT MAX(SUBSTRING(w.id, 3)) FROM Warehouse w")
    String findMaxWarehouseId();

    default String getNextWarehouseId() {
        String maxId = findMaxWarehouseId();
        if (maxId != null) {
            int nextNum = Integer.parseInt(maxId.substring(2)) + 1;
            return String.format("WH%03d", nextNum);
        } else {
            return "WH001";
        }
    }
}
