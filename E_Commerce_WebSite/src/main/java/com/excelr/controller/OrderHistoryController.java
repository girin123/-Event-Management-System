package com.excelr.controller;

import com.excelr.model.Order;
import com.excelr.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/orders")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping("/{userId}")
    public List<Order> getOrderHistory(@PathVariable Long userId) {
        return orderHistoryService.getOrdersByUser(userId);
    }
}
