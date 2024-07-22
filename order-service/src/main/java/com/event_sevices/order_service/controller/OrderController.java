package com.event_sevices.order_service.controller;


import com.event_sevices.base_domain.DTO.OrderDTO;
import com.event_sevices.base_domain.DTO.OrderEvent;
import com.event_sevices.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/createOrder")
    public String placeOrder(@RequestBody OrderDTO orderDto){
        orderDto.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent= new OrderEvent();

        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending...");
        orderEvent.setOrderDto(orderDto);

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully...";
    }
}
