package com.event_sevices.base_domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {

    private String message;
    private String status;
    private OrderDTO orderDto;
}
