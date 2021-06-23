package com.zero1.smartAd.domain;

import com.zero1.smartAd.domain.enums.SubscriptionTypeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subscription {
    private String name;
    private SubscriptionTypeEnum subscriptionType;

    public float getValue() {
        return this.subscriptionType.getValue();
    }
}
