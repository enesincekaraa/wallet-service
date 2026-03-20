package com.enesincekara.walletservice.service;

import com.enesincekara.walletservice.dto.WalletUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "wallet-transactions";

    public void sendMessage(WalletUpdateEvent event) {
        kafkaTemplate.send(TOPIC, event.walletId().toString(), event);
    }
}
