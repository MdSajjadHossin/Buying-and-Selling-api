package com.springboot.bikroy.service.seller;

import com.springboot.bikroy.dto.AdvertisementDto;

import java.io.IOException;

public interface SellerService {

    boolean postAd(Long userId, AdvertisementDto advertisementDto) throws IOException;
}
