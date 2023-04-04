package com.shoes.sporty.controllers;

import com.shoes.sporty.models.Category;
import com.shoes.sporty.models.Inventory;
import com.shoes.sporty.models.Product;
import com.shoes.sporty.models.Warehouse;
import com.shoes.sporty.service.CategoryService;
import com.shoes.sporty.service.ProductService;
import com.shoes.sporty.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private WarehouseService warehouseService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);


    @GetMapping()
    public ResponseEntity<List<Product>> index() {
        List<Product> products = service.allProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
//        return service.allProducts();
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Product product) {
        logger.info("Product | " + product.getCategories().toString());
        Set<Category> categoriesFromJson = product.getCategories();
        Set<Category> categories = new HashSet<>();
        Set<Inventory> inventoryForm = product.getInventories();
        Set<Inventory> inventories = new HashSet<>();

        for (Category category : categoriesFromJson) {
            Optional<Category> categoryOptional = categoryService.getOne(category.getId());
            if (categoryOptional.isEmpty()) {
                throw new IllegalArgumentException("Category with id " + category.getId() + " does not exist");
            }
            categories.add((categoryOptional.get()));
        }
        System.out.println("ProductController.create");
        System.out.println(product);

        for (Inventory inventory : inventoryForm) {
            Optional<Warehouse> warehouse = warehouseService.getOne(inventory.getWarehouse().getId());
            if (warehouse.isPresent()) {
                inventories.add(inventory);
            } else {
                throw new IllegalArgumentException("Warehouse with id " + inventory.getWarehouse().getId() + " not found");
            }
        }

        product.setCategories(categories);
        product.setInventories(inventories);
        System.out.println(product);
        System.out.println(categories);
        System.out.println(inventories);

        try {
            service.save(product);
            return new ResponseEntity<>("SuccessFully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatusCode.valueOf(400));
        }

    }


}
