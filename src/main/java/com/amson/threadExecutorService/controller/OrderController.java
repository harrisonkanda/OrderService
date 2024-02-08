package com.amson.threadExecutorService.controller;

import com.amson.threadExecutorService.dto.CrudResponse;
import com.amson.threadExecutorService.dto.OrderDto;
import com.amson.threadExecutorService.model.Order;
import com.amson.threadExecutorService.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("api/v1/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{order_id}")
    public CrudResponse get(@Positive @PathVariable Long order_id) {
        CrudResponse<Order> orderCrudResponse = orderService.get(order_id);
        orderCrudResponse.setStatus(HttpStatus.OK);
        return orderCrudResponse;
    }

    @DeleteMapping(value = "/{order_id}")
    public CrudResponse delete(@Positive @PathVariable Long order_id) {
        CrudResponse<Order> orderCrudResponse = orderService.delete(order_id);
        orderCrudResponse.setStatus(HttpStatus.NO_CONTENT);
        return orderCrudResponse;
    }

    @PutMapping(value = "/{order_id}")
    public CrudResponse update(@Valid @NotNull @RequestBody OrderDto orderDto, @Positive @PathVariable Long order_id) {
        CrudResponse<Order> orderCrudResponse = orderService.update(orderDto);
        orderCrudResponse.setStatus(HttpStatus.OK);
        return orderCrudResponse;
    }

    @PostMapping
    public CrudResponse create(@Valid @NotNull @RequestBody OrderDto orderDto) {
        CrudResponse<Order> orderCrudResponse = orderService.add(orderDto);
        orderCrudResponse.setStatus(HttpStatus.OK);
        return orderCrudResponse;
    }
}
