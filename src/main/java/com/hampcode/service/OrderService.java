package com.hampcode.service;


import com.hampcode.dto.OrderRequest;
import com.hampcode.entities.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    public Order createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .accountId(orderRequest.getAccountId())
                .orderId("9999")
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();

        return order;
    }

    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList();

        Order order1 = Order.builder()
                .accountId("999819")
                .orderId("11123")
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();


        Order order2 = Order.builder()
                .accountId("999819")
                .orderId("11124")
                .status("PENDING")
                .totalAmount(120.00)
                .totalTax(12.00)
                .transactionDate(LocalDate.now())
                .build();

        orders.add(order1);
        orders.add(order2);

        return orders;
    }

    public Order findOrderById(String orderId) {
        Order order = Order.builder()
                .accountId("999819")
                .orderId(orderId)
                .status("PENDING")
                .totalAmount(100.00)
                .totalTax(10.00)
                .transactionDate(LocalDate.now())
                .build();

        return order;
    }
}