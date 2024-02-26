package com.springboot.bikroy.repository;

import com.springboot.bikroy.dto.AdvertisementDto;
import com.springboot.bikroy.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAllByUserId(Long userId);

    List<Advertisement> findAllByProductNameContaining(String productName);
}
