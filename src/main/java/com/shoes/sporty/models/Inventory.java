package com.shoes.sporty.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Table(name = "inventories")
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference(value="product-inventory")
    private Product product;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_id")
    @JsonBackReference(value="warehouse-inventory")
    private Warehouse warehouse;

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", warehouse=" + warehouse +

                '}';
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
