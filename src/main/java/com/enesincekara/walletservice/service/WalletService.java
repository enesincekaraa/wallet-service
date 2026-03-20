package com.enesincekara.walletservice.service;

import com.enesincekara.walletservice.domain.Wallet;
import com.enesincekara.walletservice.dto.CreateWalletRequest;
import com.enesincekara.walletservice.dto.WalletResponse;
import com.enesincekara.walletservice.mapper.WalletMapper;
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
    private final WalletMapper walletMapper;

    @Transactional
    public WalletResponse createWallet(CreateWalletRequest req) {
        return walletMapper.toResponse
                (walletRepository.save
                        (new Wallet(req.userId(), req.initialBalance())));
    }
    @Transactional
    public WalletResponse depositMoney(UUID walletId, BigDecimal amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        wallet.deposit(amount);
        return walletMapper.toResponse(walletRepository.save(wallet));
    }



}
