package com.amson.threadExecutorService.service;

import com.amson.threadExecutorService.Constant;
import com.amson.threadExecutorService.dto.CrudResponse;
import com.amson.threadExecutorService.dto.OrderDto;
import com.amson.threadExecutorService.genericDto.ResponseData;
import com.amson.threadExecutorService.model.Order;
import com.amson.threadExecutorService.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    boolean status;
    private ResponseData<Order> responseData;
    private OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        status = Boolean.FALSE;
        this.orderRepository = orderRepository;
    }

    public CrudResponse<Order> add(OrderDto orderDto) {

        Order order = Order.builder()
                .order_id(orderDto.getOrder_id())
                .itemCategory(orderDto.getItemCategory())
                .quantity(orderDto.getQuantity())
                .unit_price(orderDto.getUnit_price())
                .build();

        orderRepository.save(order);

        return CrudResponse.<Order>builder()
                .message(status ? "": String.format("%s = [%s]", Constant.RECORD_CREATED, orderDto.getOrder_id()))
                .data(responseData)
                .build();
    }

    public CrudResponse<Order> get(final Long order_id) {
        if (orderRepository.findById(order_id).isPresent()) {
            status = Boolean.TRUE;
            responseData = new ResponseData<>(orderRepository.findById(order_id).get());
        }

        return CrudResponse.<Order>builder()
                .message(status ? "": String.format("%s = [%s]", Constant.RECORD_NOT_FOUND, order_id))
                .data(responseData)
                .build();

    }

    public CrudResponse<Order> delete(final Long order_id) {
        if (orderRepository.findById(order_id).isPresent()) {
            orderRepository.deleteById(order_id);
            status = Boolean.TRUE;
        }
        return CrudResponse.<Order>builder()
                .message(status ? "": String.format("%s = [%s]", Constant.RECORD_NOT_FOUND, order_id))
                .data(null)
                .build();
    }

    public CrudResponse<Order> update(final OrderDto orderDto) {
         Order order ;
        if (orderRepository.findById(orderDto.getOrder_id()).isPresent()) {
            order = orderRepository.findById(orderDto.getOrder_id()).get();
            order.setItemCategory(orderDto.getItemCategory());
            order.setQuantity(orderDto.getQuantity());
            order.setUnit_price(orderDto.getUnit_price());

            orderRepository.save(order);
            status = Boolean.TRUE;
            responseData = new ResponseData<>(order);
        }

        return CrudResponse.<Order>builder()
                .message(status ? "": String.format("%s = [%s]", Constant.RECORD_UPDATED, orderDto.getOrder_id()))
                .data(responseData)
                .build();
    }
}
