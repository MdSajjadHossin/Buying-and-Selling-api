package com.springboot.bikroy.entity;

import com.springboot.bikroy.dto.BuyingRequestDto;
import com.springboot.bikroy.enums.RequestReview;
import com.springboot.bikroy.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class BuyingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RequestStatus requestStatus;

    private RequestReview requestReview;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User seller;

    @ManyToOne
    @JoinColumn(name = "ad_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Advertisement ad;

    public BuyingRequestDto getBuyingRequestDto(){
        BuyingRequestDto buyingRequestDto = new BuyingRequestDto();

        buyingRequestDto.setId(id);
        buyingRequestDto.setRequestStatus(requestStatus);
        buyingRequestDto.setReview(requestReview);
        buyingRequestDto.setAdId(ad.getId());
        buyingRequestDto.setUserId(seller.getId());
        buyingRequestDto.setProductName(ad.getProductName());
        buyingRequestDto.setUserName(user.getName());

        return buyingRequestDto;


    }
}
