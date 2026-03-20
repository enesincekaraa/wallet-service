package com.enesincekara.walletservice.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record WithdrawMoneyRequest(
        UUID walletId,
        BigDecimal amount
) {
}
