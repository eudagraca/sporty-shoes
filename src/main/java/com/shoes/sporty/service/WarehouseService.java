package com.shoes.sporty.service;

import com.shoes.sporty.models.Warehouse;
import com.shoes.sporty.reposotory.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository repository;

    public Warehouse save(Warehouse warehouse){
        return repository.save(warehouse);
    }

    public List<Warehouse> getAll(){
        return repository.findAll();
    }

    public Optional<Warehouse> getOne(String id){
        return repository.findById(id);
    }
}
