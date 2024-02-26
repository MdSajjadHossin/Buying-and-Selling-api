package com.springboot.bikroy.service.seller;

import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.dto.BuyingRequestDto;
import com.springboot.bikroy.entity.Advertisement;
import com.springboot.bikroy.entity.BuyingRequest;
import com.springboot.bikroy.entity.User;
import com.springboot.bikroy.enums.RequestStatus;
import com.springboot.bikroy.repository.AdvertisementRepo;
import com.springboot.bikroy.repository.BuyingRepo;
import com.springboot.bikroy.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{


    private final UserRepo userRepo;

    private final AdvertisementRepo advertisementRepo;

    private final BuyingRepo buyingRepo;

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

    public List<AdvertisementDto> getAllAds(Long userId){
        return advertisementRepo.findAllByUserId(userId).stream().map(Advertisement::getAdvertisementDto).collect(Collectors.toList());
    }

    public AdvertisementDto getAdById(Long adId){
        Optional<Advertisement> optionalAd = advertisementRepo.findById(adId);
        if(optionalAd.isPresent()){
            return optionalAd.get().getAdvertisementDto();
        }
        return null;
    }

    public boolean updateAd(Long adId, AdvertisementDto advertisementDto) throws IOException {
        Optional<Advertisement> optionalAd = advertisementRepo.findById(adId);
        if(optionalAd.isPresent()){
            Advertisement ad = optionalAd.get();

            ad.setProductName(advertisementDto.getProductName());
            ad.setDescription(advertisementDto.getDescription());
            ad.setPrice(advertisementDto.getPrice());

            if(advertisementDto.getImg() != null){
                ad.setImg(advertisementDto.getImg().getBytes());
            }
            advertisementRepo.save(ad);
            return true;
        }
        return false;
    }

    public boolean deleteAd(Long adId){
        Optional<Advertisement> optionalAd = advertisementRepo.findById(adId);
        if(optionalAd.isPresent()){
            advertisementRepo.delete(optionalAd.get());
            return true;
        }
        return false;
    }

    public List<BuyingRequestDto> getAllProduct(long sellerId){
        return buyingRepo.findAllBySellerId(sellerId).stream().map(BuyingRequest::getBuyingRequestDto).collect(Collectors.toList());
    }

    public boolean updateSellingStatus(Long sellingId, String status){
        Optional<BuyingRequest> optionalBuyingRequest = buyingRepo.findById(sellingId);
        if(optionalBuyingRequest.isPresent()){

            BuyingRequest buyingRequest = optionalBuyingRequest.get();

            if(Objects.equals(status, "Accepted")){
                buyingRequest.setRequestStatus(RequestStatus.ACCEPTED);
            }else{
               buyingRequest.setRequestStatus(RequestStatus.REJECTED);
            }
            buyingRepo.save(buyingRequest);
        }
        return false;
    }
}
