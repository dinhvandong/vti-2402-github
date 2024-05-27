package com.vti.loship.controllers;

import com.vti.loship.models.Order;
import com.vti.loship.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    // localhost:8080/api/order/0?page=0&size=100
    @GetMapping("/{status}")
    public Page<Order> getOrdersByStatusAndSortByCreatedDateDesc(@PathVariable int status,
                                                                 @RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "100") int size) {
        return orderService.getOrdersByStatusAndSortByCreatedDateDesc(status, page, size);
    }
}