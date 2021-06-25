package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Data
public class AdEntity {

    @Id
    private UUID id;
    private String name;
    private float value;
    @ManyToOne
    private SubscriptionEntity subscription;
}
