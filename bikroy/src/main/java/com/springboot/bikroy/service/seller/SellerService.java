package com.springboot.bikroy.service.seller;

import com.springboot.bikroy.dto.AdvertisementDto;

import java.io.IOException;
import java.util.List;

public interface SellerService {

    boolean postAd(Long userId, AdvertisementDto advertisementDto) throws IOException;
    List<AdvertisementDto> getAllAds(Long userId);
    public AdvertisementDto getAdById(Long adId);
    boolean updateAd(Long adId, AdvertisementDto advertisementDto) throws IOException;
    boolean deleteAd(Long adId);
}
