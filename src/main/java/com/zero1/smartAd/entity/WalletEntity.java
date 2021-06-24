package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class WalletEntity {

    @Id
    private UUID id;
    private String name;
    private float balance;
    @ManyToOne
    private CustomerEntity customer;
    @ManyToMany
    private Set<UserEntity> users = new HashSet<>();
    @OneToOne
    private SubscriptionEntity subscription;
}
