package com.event_sevices.stock_service.entity;

import com.event_sevices.base_domain.DTO.OrderEvent;
import jakarta.persistence.*;

@Entity
@Table(name = "order_data")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String eventData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEvent() {
        return eventData;
    }

    public void setEvent(String event) {
        this.eventData = event;
    }

}
