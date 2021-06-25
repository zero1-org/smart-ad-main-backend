package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class PermissionEntity {

    @Id
    private UUID id;
    private String name;
    private String displayableName;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<UserEntity> users;
}
