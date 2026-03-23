package com.enesincekara.walletservice.domain;

import com.enesincekara.walletservice.dto.WalletUpdateEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet extends AbstractAggregateRoot<Wallet> {
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
        registerEvent(new WalletUpdateEvent(this.id,this.userId,this.balance,"DEPOSIT"));
    }
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance = this.balance.subtract(amount);

        registerEvent(new WalletUpdateEvent(this.id,this.userId,this.balance,"WITHDRAW"));
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
