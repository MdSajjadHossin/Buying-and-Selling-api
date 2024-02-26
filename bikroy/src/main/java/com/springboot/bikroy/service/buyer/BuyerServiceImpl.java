package com.springboot.bikroy.service.buyer;

import com.springboot.bikroy.dto.AdDetailsForBuyerDto;
import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.dto.BuyingRequestDto;
import com.springboot.bikroy.entity.Advertisement;
import com.springboot.bikroy.entity.BuyingRequest;
import com.springboot.bikroy.entity.User;
import com.springboot.bikroy.enums.RequestReview;
import com.springboot.bikroy.enums.RequestStatus;
import com.springboot.bikroy.repository.AdvertisementRepo;
import com.springboot.bikroy.repository.BuyingRepo;
import com.springboot.bikroy.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService{

    private final AdvertisementRepo advertisementRepo;
    private final UserRepo userRepo;
    private final BuyingRepo buyingRepo;

    public List<AdvertisementDto> getAllAds(){
        return advertisementRepo.findAll().stream().map(Advertisement::getAdvertisementDto).collect(Collectors.toList());
    }

    public List<AdvertisementDto> searchAllAds(String productName){
        return advertisementRepo.findAllByProductNameContaining(productName).stream().map(Advertisement::getAdvertisementDto).collect(Collectors.toList());
    }

    public boolean buyingProduct(BuyingRequestDto buyingRequestDto){
        Optional<Advertisement> optionalAd = advertisementRepo.findById(buyingRequestDto.getId());
        Optional<User> optionalUser = userRepo.findById(buyingRequestDto.getUserId());

        if(optionalAd.isPresent() && optionalUser.isPresent()){
            BuyingRequest buyingRequest = new BuyingRequest();
            buyingRequest.setRequestStatus(RequestStatus.PENDING);
            buyingRequest.setUser(optionalUser.get());

            buyingRequest.setAd(optionalAd.get());
            buyingRequest.setSeller(optionalAd.get().getUser());
            buyingRequest.setRequestReview(RequestReview.FALSE);

            buyingRepo.save(buyingRequest);
            return true;

        }
        return false;
    }

    public AdDetailsForBuyerDto adDetailsForBuyerDto(Long adId){
        Optional<Advertisement> optionalAd = advertisementRepo.findById(adId);
        AdDetailsForBuyerDto adDetailsForBuyerDto = new AdDetailsForBuyerDto();

        if(optionalAd.isPresent()) {
            adDetailsForBuyerDto.setAdvertisementDto(optionalAd.get().getAdvertisementDto());
        }
        return adDetailsForBuyerDto;
    }

    public List<BuyingRequestDto> getAllSellingProductByUserId(Long userId){
        return buyingRepo.findAllByUserId(userId).stream().map(BuyingRequest::getBuyingRequestDto).collect(Collectors.toList());
    }
}
