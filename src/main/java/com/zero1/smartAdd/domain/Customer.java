package com.zero1.smartAdd.domain;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Data
@Builder
public class Customer {
    private UUID id = UUID.randomUUID();
    private String name;
    private String document;
    private String email;
    private String phoneNumber;
    private Set<User> users = new HashSet<>();
    private Set<Wallet> wallets = new HashSet<>();

    public Set<Wallet> getExpiredWallets() {
        return this.getWallets().stream()
                .filter(not(Wallet::isUpToDate))
                .collect(Collectors.toSet());
    }
}
