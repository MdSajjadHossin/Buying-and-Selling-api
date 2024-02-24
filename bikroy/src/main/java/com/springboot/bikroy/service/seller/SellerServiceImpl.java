package com.springboot.bikroy.service.seller;

import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.entity.Advertisement;
import com.springboot.bikroy.entity.User;
import com.springboot.bikroy.repository.AdvertisementRepo;
import com.springboot.bikroy.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{


    private final UserRepo userRepo;

    private final AdvertisementRepo advertisementRepo;

    public boolean postAd(Long userId, AdvertisementDto advertisementDto) throws IOException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()){
            Advertisement ad = new Advertisement();
            ad.setProductName(advertisementDto.getProductName());
            ad.setDescription(advertisementDto.getDescription());
            ad.setImg(advertisementDto.getImg().getBytes());
            ad.setPrice(advertisementDto.getPrice());
            ad.setUser(optionalUser.get());

            advertisementRepo.save(ad);
            return true;
        }
        return false;
    }


}
