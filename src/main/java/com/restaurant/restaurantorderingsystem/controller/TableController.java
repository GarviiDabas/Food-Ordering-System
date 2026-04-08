package com.restaurant.restaurantorderingsystem.controller;

import com.restaurant.restaurantorderingsystem.entity.RestaurantTable;
import com.restaurant.restaurantorderingsystem.repository.RestaurantTableRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TableController {

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @GetMapping("/admin/tables/free/{id}")
    public String freeTable(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("isAdmin") == null) {
            return "redirect:/login";
        }
        
        RestaurantTable table = restaurantTableRepository.findById(id).orElse(null);
        if (table != null) {
            table.setStatus("AVAILABLE");
            restaurantTableRepository.save(table);
        }
        
        return "redirect:/admin/dashboard";
    }
}
