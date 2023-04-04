package com.shoes.sporty.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "comfort", nullable = false)
    private String comfort;
    @Column(name = "size", nullable = false)
    private int size;
    @Column(name = "durability", nullable = false)
    private String durability;
    @Column(name = "createdAt")
    private final LocalDateTime createdAt = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
    @Column(name = "updatedAt")
    private final LocalDateTime updatedAt =  Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime();

    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "image_url")
    private String imageUrl;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @JsonManagedReference(value="product-inventory")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inventory> inventories = new HashSet<>();


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", comfort='" + comfort + '\'' +
                ", size=" + size +
                ", durability='" + durability + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", categories=" + categories +
                ", inventories=" + inventories +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

}
