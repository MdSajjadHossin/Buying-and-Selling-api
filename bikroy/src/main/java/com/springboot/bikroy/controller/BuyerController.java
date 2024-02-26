package com.springboot.bikroy.controller;

import com.springboot.bikroy.service.buyer.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seller")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping("/ads")
    public ResponseEntity<?> getAllAds(){
        return ResponseEntity.ok(buyerService.getAllAds());
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<?> searchAdByName(@PathVariable String productName){
        return ResponseEntity.ok(buyerService.searchAllAds(productName));
    }
}
