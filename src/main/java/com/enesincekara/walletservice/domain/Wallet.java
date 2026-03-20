package com.enesincekara.walletservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    private UUID id;
    private UUID userId;
    private BigDecimal balance;

    protected Wallet() {
    }
    public Wallet(UUID userId, BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.balance = initialBalance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance = this.balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance = this.balance.subtract(amount);
    }
    public UUID getId() {
        return id;
    }
    public UUID getUserId() {
        return userId;
    }
    public BigDecimal getBalance() {
        return balance;
    }

}
