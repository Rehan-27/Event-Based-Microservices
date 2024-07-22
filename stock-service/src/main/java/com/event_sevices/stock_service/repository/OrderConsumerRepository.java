package com.event_sevices.stock_service.repository;

import com.event_sevices.stock_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderConsumerRepository extends JpaRepository<OrderEntity,Long> {
}
