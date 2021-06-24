package com.zero1.smartAd.resource;

import com.zero1.smartAd.domain.Ad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/ads")
@RestController
public class AdResource {

    @GetMapping
    public ResponseEntity<List<Ad>> getAds() {
        List<Ad> ads = new ArrayList<>();

        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ad> getSingleAd(@PathVariable UUID id) {
        Ad ad = Ad.builder().build();
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }
}
