package com.enesincekara.walletservice.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletUpdateEvent(
        UUID walletId,
        UUID userId,
        BigDecimal newBalance,
        String transactionType
) {
}
