package com.enesincekara.walletservice.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record DepositMoneyRequest (
        UUID walletId,
        BigDecimal amount
){
}
