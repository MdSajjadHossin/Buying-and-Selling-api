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
}
