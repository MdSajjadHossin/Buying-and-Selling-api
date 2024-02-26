package com.springboot.bikroy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewDto {
    private Long id;

    private String review;

    private Long rating;

    private Date reviewDate;

    private Long userId;

    private Long adId;

    private String buyerName;

    private String productName;

    private Long productId;
}
