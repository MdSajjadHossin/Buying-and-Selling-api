package com.springboot.bikroy.dto;

import com.springboot.bikroy.enums.RequestReview;
import com.springboot.bikroy.enums.RequestStatus;
import lombok.Data;

import java.util.Date;

@Data
public class BuyingRequestDto {

    private Long id;

    private String productName;

    private RequestStatus requestStatus;

    private RequestReview review;

    private Date Buyingdate;

    private Long userId;

    private String userName;

    private Long productId;

    private Long adId;

}
