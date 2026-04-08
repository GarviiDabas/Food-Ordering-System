package com.restaurant.restaurantorderingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_number", unique = true, nullable = false)
    private int tableNumber;

    @Column(name = "status", nullable = false)
    private String status = "AVAILABLE"; // AVAILABLE, RESERVED

    public RestaurantTable() {}

    public RestaurantTable(int tableNumber) {
        this.tableNumber = tableNumber;
        this.status = "AVAILABLE";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
