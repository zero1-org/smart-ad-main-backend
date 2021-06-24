package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class SubscriptionEntity {

    @Id
    private UUID id;
    private String name;
    private float currentPrice;
    @OneToOne
    private WalletEntity wallet;
    @ManyToOne
    @JoinColumn(name = "subscription_type")
    private SubscriptionTypeEntity type;
}
