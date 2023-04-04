package com.shoes.sporty.models;


import com.shoes.sporty.ApplicationContextProvider;
import com.shoes.sporty.reposotory.WarehouseRepository;
import jakarta.persistence.*;
import java.util.List;

@Table(name = "warehouses")
@Entity
public class Warehouse {
    @Id
    private String id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
    private List<Inventory> inventories;

    @Override
    public String toString() {
        return "Warehouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @PrePersist
    private void generateId() {
        if (id == null) {
            WarehouseRepository warehouseRepo = ApplicationContextProvider.getBean(WarehouseRepository.class);
            id = warehouseRepo.getNextWarehouseId();
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
