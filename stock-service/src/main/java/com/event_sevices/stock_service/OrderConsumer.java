package com.event_sevices.stock_service;

import com.event_sevices.base_domain.DTO.OrderEvent;
import com.event_sevices.stock_service.entity.OrderEntity;
import com.event_sevices.stock_service.repository.OrderConsumerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private OrderConsumerRepository orderConsumerRepository;

    public OrderConsumer(OrderConsumerRepository orderConsumerRepository) {
        this.orderConsumerRepository = orderConsumerRepository;
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMsg(OrderEvent orderEvent){
        LOGGER.info(String.format("Order event received in stock service -> %s",orderEvent.toString()));

        OrderEntity orderEntity= new OrderEntity();
        orderEntity.setEvent(orderEvent.toString());

        orderConsumerRepository.save(orderEntity);
    }
}
