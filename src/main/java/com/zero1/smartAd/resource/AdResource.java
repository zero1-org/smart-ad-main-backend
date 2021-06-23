package com.zero1.smartAd.resource;

import com.zero1.smartAd.domain.Ad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdResource {

    @GetMapping("/ads")
    public ResponseEntity<List<Ad>> getAds() {
        // String email = jwt.claim("email");
        // User user = database.findByEmail(email);

        List<Ad> ads = new ArrayList<>();

        return new ResponseEntity<>(ads, HttpStatus.OK);
    }
}
