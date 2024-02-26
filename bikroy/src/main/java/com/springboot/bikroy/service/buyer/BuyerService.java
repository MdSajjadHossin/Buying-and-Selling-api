package com.springboot.bikroy.service.buyer;

import com.springboot.bikroy.dto.AdvertisementDto;

import java.util.List;

public interface BuyerService {
    List<AdvertisementDto> getAllAds();
    List<AdvertisementDto> searchAllAds(String productName);
}
