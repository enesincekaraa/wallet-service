package com.enesincekara.walletservice.wallet;

import com.enesincekara.walletservice.domain.Wallet;
import com.enesincekara.walletservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    @PostMapping
    public void save(@RequestParam("userId") UUID userId, @RequestParam("initialBalance") BigDecimal initialBalance) {
        walletService.createWallet(userId, initialBalance);
    }
}
