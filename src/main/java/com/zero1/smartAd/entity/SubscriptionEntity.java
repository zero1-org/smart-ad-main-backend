package com.zero1.smartAd.entity;

import com.zero1.smartAd.enumeration.SubscriptionStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class SubscriptionEntity {

    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String status;
    private ZonedDateTime creationDate = ZonedDateTime.now();
    private ZonedDateTime lastPaymentDate = creationDate;
    private ZonedDateTime expirationDate = creationDate.plusDays(30);
    private boolean operating = true;
    @ManyToOne
    private SubscriptionTypeEntity subscriptionType;
    @OneToOne
    private CustomerEntity customer;

    @OneToMany
    private Set<BillingEntity> billings = new HashSet<>();

    @OneToMany
    private Set<UserEntity> users = new HashSet<>();
    @OneToMany
    private Set<AdEntity> ads = new HashSet<>();

    public boolean isUptoDate(ZonedDateTime processingDate) {
        return processingDate.isBefore(this.getExpirationDate());
    }

    public void process() {
        var today = ZonedDateTime.now();
    }

    public void processPayment(ZonedDateTime paymentDate) {
        // Log -> subscriptionId, customerCNPJ, currentDate, nextExpirationDate
        ZonedDateTime nextExpirationDate = this.getExpirationDate().plusDays(30);
        this.setStatus(SubscriptionStatusEnum.OK.toString());
        this.setOperating(true);
        this.setLastPaymentDate(paymentDate);
        this.setExpirationDate(nextExpirationDate);
    }

    public void updateSubscriptionStatus(SubscriptionStatusEnum freshStatus, ZonedDateTime updateDate) {
        switch (freshStatus) {
            case OK:
                break;
            case WARN:
                this.warnSubscription(updateDate);
                break;
            case FREEZED:
                this.freezeSubscription(updateDate);
                break;
            default:
                this.cancelSubscription(updateDate);
        }
    }


    public SubscriptionStatusEnum getFreshStatus(ZonedDateTime processingDate) {
        if (this.isUptoDate(processingDate)) {
            return SubscriptionStatusEnum.OK;
        }

        int paymentDelayAllowed = this.getSubscriptionType().getDaysOfDelayAllowed();
        ZonedDateTime subscriptionDeadLine = this.getExpirationDate().plusDays(paymentDelayAllowed);

        if (processingDate.isBefore(subscriptionDeadLine)) {
            return SubscriptionStatusEnum.WARN;
        } else {
            return SubscriptionStatusEnum.FREEZED;
        }
    }

    public void warnSubscription(ZonedDateTime warningDate) {
        // Log -> subscriptionId, customerCNPJ, currentDate
        this.setStatus(SubscriptionStatusEnum.WARN.toString());
    }

    public void freezeSubscription(ZonedDateTime freezingDate) {
        // Log -> subscriptionId, customerCNPJ, currentDate
        this.setStatus(SubscriptionStatusEnum.FREEZED.toString());
        this.setOperating(false);
    }

    public void cancelSubscription(ZonedDateTime today) {
        // Log -> subscriptionId, customerCNPJ, currentDate
        this.setStatus(SubscriptionStatusEnum.CANCELLED.toString());
        this.setOperating(false);
    }
}
