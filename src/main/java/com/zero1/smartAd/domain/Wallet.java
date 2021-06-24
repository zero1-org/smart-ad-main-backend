package com.zero1.smartAd.domain;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class Wallet {
    private UUID id = UUID.randomUUID();
    private String name;
    private float funds;
    private ZonedDateTime createdAt;
    private ZonedDateTime expirationDate;
    private Customer customer;
    private Subscription subscription;
    private Set<Ad> ads = new HashSet<>();
    private Set<User> users = new HashSet<>();

    public boolean hasSufficientFunds() {
        return funds > subscription.getDefaultValue();
    }

    public boolean isUpToDate() {
        return expirationDate.getDayOfMonth() >= ZonedDateTime.now().getDayOfMonth();
    }
}
