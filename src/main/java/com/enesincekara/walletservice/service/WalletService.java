package com.enesincekara.walletservice.service;

import com.enesincekara.walletservice.domain.Wallet;
import com.enesincekara.walletservice.dto.*;
import com.enesincekara.walletservice.mapper.WalletMapper;
import com.enesincekara.walletservice.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public WalletResponse depositMoney(DepositMoneyRequest req) {
        Wallet wallet = walletRepository.findByIdWithLock(req.walletId()).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        wallet.deposit(req.amount());
        Wallet savedWallet = walletRepository.save(wallet);

        return walletMapper.toResponse(savedWallet);
    }

    @Transactional
    public WalletResponse withdrawMoney(WithdrawMoneyRequest req) {
        Wallet wallet = walletRepository.findByIdWithLock(req.walletId()).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        wallet.withdraw(req.amount());
        return walletMapper.toResponse(walletRepository.save(wallet));
    }



}
