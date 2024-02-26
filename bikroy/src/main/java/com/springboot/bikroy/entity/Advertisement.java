package com.springboot.bikroy.entity;

import com.springboot.bikroy.dto.AdvertisementDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public AdvertisementDto getAdvertisementDto(){
        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setId(id);
        advertisementDto.setProductName(productName);
        advertisementDto.setDescription(description);
        advertisementDto.setReturnedImg(img);
        advertisementDto.setPrice(price);
        advertisementDto.setSellerName(user.getFirstName() + user.getLastName());

        return advertisementDto;
    }

}
