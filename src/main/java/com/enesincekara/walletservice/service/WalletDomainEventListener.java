package com.enesincekara.walletservice.service;

import com.enesincekara.walletservice.dto.WalletUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class WalletDomainEventListener {
    private final KafkaProducerService kafkaProducerService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleWalletUpdateEvent(WalletUpdateEvent event) {
        kafkaProducerService.sendMessage(event);
    }
}
