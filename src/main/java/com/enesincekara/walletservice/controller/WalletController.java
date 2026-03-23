package com.enesincekara.walletservice.controller;

import com.enesincekara.walletservice.dto.CreateWalletRequest;
import com.enesincekara.walletservice.dto.DepositMoneyRequest;
import com.enesincekara.walletservice.dto.WalletResponse;
import com.enesincekara.walletservice.dto.WithdrawMoneyRequest;
import com.enesincekara.walletservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {
    private final WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletResponse> save(@RequestBody CreateWalletRequest req) {
        return new ResponseEntity<>(walletService.createWallet(req), HttpStatus.CREATED);
    }
    @PatchMapping("/withdraw")
    public ResponseEntity<WalletResponse> withdrawMoney(@RequestBody WithdrawMoneyRequest req) {
        return new ResponseEntity<>(walletService.withdrawMoney(req), HttpStatus.OK);
    }
    @PatchMapping("/deposit")
    public ResponseEntity<WalletResponse> depositMoney(@RequestBody DepositMoneyRequest req) {
        return new ResponseEntity<>(walletService.depositMoney(req), HttpStatus.OK);
    }


}
