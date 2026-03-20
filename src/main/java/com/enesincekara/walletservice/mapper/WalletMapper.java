package com.enesincekara.walletservice.mapper;

import com.enesincekara.walletservice.domain.Wallet;
import com.enesincekara.walletservice.dto.CreateWalletRequest;
import com.enesincekara.walletservice.dto.WalletResponse;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public Wallet toDomain(CreateWalletRequest req) {
        return new Wallet(req.userId(), req.initialBalance());
    }
    public WalletResponse  toResponse(Wallet wallet) {
        return new WalletResponse(wallet.getId(), wallet.getUserId(), wallet.getBalance());
    }
}
