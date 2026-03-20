package com.enesincekara.walletservice.service;

import com.enesincekara.walletservice.domain.Wallet;
import com.enesincekara.walletservice.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    @Transactional
    public Wallet createWallet(UUID userId, BigDecimal initialBalance) {
        return walletRepository.save(new Wallet(userId, initialBalance));
    }
    @Transactional
    public Wallet depositMoney(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        wallet.deposit(amount);
        return walletRepository.save(wallet);
    }



}
