package com.zero1.smartAd.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class User {
    private UUID id = UUID.randomUUID();
    private String fullName;
    private String email;
    private Set<Wallet> wallets;
}
