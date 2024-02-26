package com.springboot.bikroy.service.buyer;

import com.springboot.bikroy.dto.AdDetailsForBuyerDto;
import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.dto.BuyingRequestDto;
import com.springboot.bikroy.dto.ReviewDto;

import java.util.List;

public interface BuyerService {
    List<AdvertisementDto> getAllAds();
    List<AdvertisementDto> searchAllAds(String productName);
    boolean buyingProduct(BuyingRequestDto buyingRequestDto);
    AdDetailsForBuyerDto adDetailsForBuyerDto(Long adId);
    List<BuyingRequestDto> getAllSellingProductByUserId(Long userId);
    Boolean review(ReviewDto reviewDto);
}
