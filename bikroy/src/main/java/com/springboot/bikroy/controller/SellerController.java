package com.springboot.bikroy.controller;

import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/ad/{userId}")
    public ResponseEntity<?> postAd(@PathVariable Long userId, @ModelAttribute AdvertisementDto advertisementDto) throws IOException {
        boolean sellerExist = sellerService.postAd(userId, advertisementDto);
        if(sellerExist){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ads/{userId}")
    public ResponseEntity<?> getAllAdsByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(sellerService.getAllAds(userId));
    }

    @GetMapping("/ads/{adId}")
    public ResponseEntity<?> getAdByAdId(@PathVariable Long adId){
        return ResponseEntity.ok(sellerService.getAdById(adId));
    }

    @PutMapping("/ad/{adId}")
    public ResponseEntity<?> updateAd(@PathVariable Long adId, @ModelAttribute AdvertisementDto advertisementDto) throws IOException {
        boolean adExist = sellerService.updateAd(adId, advertisementDto);
        if(adExist) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {

        }return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/ad/{adId}")
    public ResponseEntity<?> deleteAd(@PathVariable Long adId){
        boolean adExist = sellerService.deleteAd(adId);
        if(adExist){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
