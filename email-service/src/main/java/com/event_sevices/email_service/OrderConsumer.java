package com.event_sevices.email_service;

import com.event_sevices.base_domain.DTO.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {



    private static final Logger LOGGER= LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeMsg(OrderEvent orderEvent){
        LOGGER.info(String.format("Order event received in email service -> %s",orderEvent.toString()));

    }
}
