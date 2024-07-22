package com.event_sevices.order_service.kafka;


import com.event_sevices.base_domain.DTO.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private NewTopic newTopic;

    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(NewTopic newTopic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.newTopic = newTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderProducer.class);

    public void sendMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("Sending Order Event -> %s",orderEvent.toString()));

        //create message
        Message<OrderEvent> message= MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC,newTopic.name())
                .build();

        //sending message using kafkatemplate
        kafkaTemplate.send(message);
    }
}
