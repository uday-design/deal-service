package com.osttra.dealservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osttra.dealservice.dto.OrderMessage;
import com.osttra.dealservice.entity.Deal;
import com.osttra.dealservice.repository.DealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEventListener {

    @Autowired
    private DealRepository dealRepository;

    @KafkaListener(topics = "order-events", groupId = "deal-group")
    public void listenOrderEvents(String message) {
        log.info("Order Message received " + message);
        try {
            OrderMessage orderMessage = new ObjectMapper().readValue(message, OrderMessage.class);
            Deal deal = new Deal(orderMessage);
            dealRepository.save(deal);
        } catch (Exception e) {
            log.error("Unable to process message", e);
        }
    }
}
