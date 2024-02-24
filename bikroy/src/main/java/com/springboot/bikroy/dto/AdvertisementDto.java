package com.springboot.bikroy.dto;

import com.springboot.bikroy.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
