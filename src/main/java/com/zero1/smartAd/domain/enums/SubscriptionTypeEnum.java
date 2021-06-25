package com.zero1.smartAd.domain.enums;

import lombok.Getter;

public enum SubscriptionTypeEnum {
    FREE("Free", 0),
    STANDARD("Standard", 12.99f),
    PREMIUM("Premium", 36.45f);

    @Getter
    private final String name;
    @Getter
private final float defaultValue;

    SubscriptionTypeEnum(String name, float defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }
}
