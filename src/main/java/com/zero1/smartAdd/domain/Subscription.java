package com.zero1.smartAdd.domain;

import com.zero1.smartAdd.domain.enums.SubscriptionTypeEnum;
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
