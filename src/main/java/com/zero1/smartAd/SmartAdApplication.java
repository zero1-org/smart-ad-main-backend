package com.zero1.smartAd;

import com.zero1.smartAd.entity.PaymentEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SmartAdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartAdApplication.class, args);

        Optional<List<PaymentEntity>> paymentEntity = new ArrayList<>();

        paymentEntity.ifPresentOrElse();



    }

}
