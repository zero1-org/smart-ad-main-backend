package com.zero1.smartAd.entity;

import com.zero1.smartAd.enumeration.BillingStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class BillingEntity {

    @Id
    private UUID id = UUID.randomUUID();
    private ZonedDateTime creationDate = ZonedDateTime.now();
    private String status = BillingStatusEnum.OPEN.toString();
    @Column(unique = true)
    private String code; // Comes from Billing service
    private ZonedDateTime expirationDate; // Comes from Billing service
    private float value; // Comes from Billing service
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentEntity payment = new PaymentEntity();
    @ManyToOne
    private SubscriptionEntity subscriptionEntity;

    public String getStatus() {
        if (this.payment.getCode() != null) {
            return BillingStatusEnum.PAID.toString();
        }

        var today = ZonedDateTime.now();

        if (today.isBefore(this.expirationDate)) {
            return BillingStatusEnum.OPEN.toString();
        } else {
            return BillingStatusEnum.EXPIRED.toString();
        }
    }

    public void setStatus(BillingStatusEnum statusEnum) {
        this.status = statusEnum.toString();
    }

    public void setPayment(PaymentEntity payment) throws Exception {
        if (payment.getCode() != null) {
            float paidValue = payment.getValue();
            float expectedValue = this.getValue();

            if (paidValue == expectedValue) {
                this.payment = payment;
                this.setStatus(BillingStatusEnum.PAID);
                return;
            }
        }

        throw new Exception();
    }
}
