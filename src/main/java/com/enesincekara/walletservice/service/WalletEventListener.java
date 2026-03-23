package com.enesincekara.walletservice.service;

import com.enesincekara.walletservice.dto.WalletUpdateEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WalletEventListener {
    @KafkaListener(topics = "wallet-transactions",groupId = "wallet-group")
    public void handleWalletUpdate(WalletUpdateEvent event){
        System.out.println("Received Wallet Update Event");
        System.out.println("Cüzdan Id: " +event.walletId());
        System.out.println("Yeni Bakiye: " + event.newBalance());
        System.out.println("İşlem Tipi : " + event.transactionType());
    }
}
