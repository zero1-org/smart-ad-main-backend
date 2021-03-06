package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Data
public class CustomerEntity {

    @Id
    private UUID id;
    private String name;
    private String document;
    private String email;
    private String phoneNumber;
    @OneToOne
    private SubscriptionEntity subscription;
}
