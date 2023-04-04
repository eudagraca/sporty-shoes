package com.shoes.sporty.controllers;

import com.shoes.sporty.models.Warehouse;
import com.shoes.sporty.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    @Autowired
    private WarehouseService service;

    Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Warehouse warehouse){
        service.save(warehouse);

        return new ResponseEntity<>("Successfully saved", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Warehouse>> getAll(){
        var warehouses = service.getAll();
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }


}
