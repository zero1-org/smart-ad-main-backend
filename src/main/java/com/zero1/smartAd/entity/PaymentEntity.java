package com.zero1.smartAd.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class PaymentEntity {

    @Id
    @Column(name = "payment_id")
    private UUID id = UUID.randomUUID();
    @OneToOne(mappedBy = "payment")
    private BillingEntity billing;
    @Column(unique = true)
    private String code; // Comes from Payment service
    private ZonedDateTime processingDate; // Comes from Billing service
    private float value; // Comes from Payment service
}
