package com.hampcode.api;

import com.hampcode.dto.OrderRequest;
import com.hampcode.dto.OrderResponse;
import com.hampcode.entities.Order;
import com.hampcode.mapper.OrderMapper;
import com.hampcode.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orderMapper.convertEntityToDto(orders), HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(orderMapper.convertEntityToDto(order), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(orderMapper.convertEntityToDto(order), HttpStatus.CREATED);
    }
}
