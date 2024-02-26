package com.springboot.bikroy.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdDetailsForBuyerDto {

    private AdvertisementDto advertisementDto;

    private List<ReviewDto> reviewDtoList;
}
