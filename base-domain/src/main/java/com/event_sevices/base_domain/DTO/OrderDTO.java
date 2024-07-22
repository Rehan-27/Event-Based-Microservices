package com.event_sevices.base_domain.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private String orderId;
    private String name;
    private  int qty;
    private double price;

}
