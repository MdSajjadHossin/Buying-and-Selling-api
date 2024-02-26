package com.springboot.bikroy.dto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdvertisementDto {
    private Long id;
    private String productName;
    private String description;
    private MultipartFile img;
    private byte[] returnedImg;
    private int price;
    private String sellerName;
    private Long userId;
}
