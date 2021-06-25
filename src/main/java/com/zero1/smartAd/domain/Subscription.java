package com.zero1.smartAd.domain;

import com.zero1.smartAd.domain.enums.SubscriptionTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Subscription {
    private UUID id;
    private String name;
    private float currentPrice;
    private SubscriptionTypeEnum subscriptionType;

    public float getDefaultValue() {
        return this.subscriptionType.getDefaultValue();
    }
}
