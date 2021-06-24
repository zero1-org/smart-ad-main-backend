package com.zero1.smartAd.resource;

import com.zero1.smartAd.domain.Wallet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/wallets")
@RestController
public class WalletResource {

    public ResponseEntity<List<Wallet>> getWallets() {
        List<Wallet> wallets = new ArrayList<>();
        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }
}
