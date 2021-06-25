package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class SubscriptionTypeEntity {

    @Id
    private UUID id;
    private String name;
    private float price;
    @Column(name = "payment_delay_allowed_in_days")
    private int daysOfDelayAllowed;
    private int maximumAdsAllowed;
    private int maximumUsersAllowed;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<SubscriptionEntity> subscriptions = new HashSet<>();
}
