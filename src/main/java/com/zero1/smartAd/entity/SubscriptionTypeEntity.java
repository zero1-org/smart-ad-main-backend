package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class SubscriptionTypeEntity {

    @Id
    private UUID id;
    private String name;
    private float defaultPrice;
}
