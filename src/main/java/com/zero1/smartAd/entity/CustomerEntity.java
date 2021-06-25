package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
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
    @OneToMany
    private Set<SubscriptionEntity> subscriptions = new HashSet<>();
    @OneToMany
    private Set<UserEntity> users = new HashSet<>();
}
