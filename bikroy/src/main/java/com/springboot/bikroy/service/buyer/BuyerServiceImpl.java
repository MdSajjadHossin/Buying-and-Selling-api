package com.springboot.bikroy.service.buyer;

import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.entity.Advertisement;
import com.springboot.bikroy.repository.AdvertisementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService{

    private final AdvertisementRepo advertisementRepo;

    public List<AdvertisementDto> getAllAds(){
        return advertisementRepo.findAll().stream().map(Advertisement::getAdvertisementDto).collect(Collectors.toList());
    }

    public List<AdvertisementDto> searchAllAds(String productName){
        return advertisementRepo.findAllByProductNameContaining(productName).stream().map(Advertisement::getAdvertisementDto).collect(Collectors.toList());
    }
}
