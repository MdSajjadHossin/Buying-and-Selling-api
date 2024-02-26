package com.springboot.bikroy.controller;

import com.springboot.bikroy.dto.BuyingRequestDto;
import com.springboot.bikroy.dto.ReviewDto;
import com.springboot.bikroy.service.buyer.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buyer")
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
    @PostMapping("/buyingProduct")
    public ResponseEntity<?> buyProduct(@RequestBody BuyingRequestDto buyingRequestDto){
        boolean success = buyerService.buyingProduct(buyingRequestDto);
        if(success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ad/{adId}")
    public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long adId){
        return ResponseEntity.ok(buyerService.adDetailsForBuyerDto(adId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getSellingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(buyerService.getAllSellingProductByUserId(userId));
    }

    @PostMapping("/review")
    public ResponseEntity<?> giveReview(@RequestBody ReviewDto reviewDto){
        boolean success = buyerService.review(reviewDto);
        if(success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
