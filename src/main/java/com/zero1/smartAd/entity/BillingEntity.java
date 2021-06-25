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
    private String status = BillingStatusEnum.WAITING.toString();
    private ZonedDateTime paidAt;
    @Column(unique = true)
    private String code; // Comes from Billing service
    private ZonedDateTime expirationDate; // Comes from Billing service
    private float value; // Comes from Billing service
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentEntity payment = new PaymentEntity();
    @ManyToOne
    private SubscriptionEntity subscriptionEntity;


    public boolean wasSuccessfullyOpened() {
        return this.getCode() != null;
    }

    public boolean hasValidPayment() {
        return this.getPayment().getCode() != null
                && this.getPayment().getValue() == this.getValue();
    }

    public boolean hasValidStatus(BillingStatusEnum target) {
        final boolean billIsOpen = this.wasSuccessfullyOpened();
        final boolean billIsPaid = this.hasValidPayment();
        final boolean billIsExpired = ZonedDateTime.now().isAfter(this.getExpirationDate());

        if (billIsOpen) {
            switch (target) {
                case PAID:
                    return billIsPaid;
                case OPEN:
                    return !billIsPaid && !billIsExpired;
                case EXPIRED:
                    return !billIsPaid && billIsExpired;
                default:
                    return false;
            }
        } else {
            BillingStatusEnum expectedStatus = BillingStatusEnum.WAITING;
            return target.equals(expectedStatus);
        }
    }

    public void setStatus(BillingStatusEnum statusEnum) throws Exception {
        if (this.hasValidStatus(statusEnum))
            this.status = statusEnum.toString();
        else throw new Exception();
    }

    public void setPayment(PaymentEntity payment) throws Exception {
        if (this.hasValidPayment()) {
            this.payment = payment;
            this.setStatus(BillingStatusEnum.PAID);
            this.setPaidAt(ZonedDateTime.now());
        } else throw new Exception();
    }
}
