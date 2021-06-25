package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class UserEntity {

    @Id
    private UUID id;
    private String fullName;
    private String login;
    @ManyToOne
    private CustomerEntity customer;
    @ManyToMany
    private Set<WalletEntity> wallets;
    @ManyToMany
    private Set<PermissionEntity> permissions;
}
