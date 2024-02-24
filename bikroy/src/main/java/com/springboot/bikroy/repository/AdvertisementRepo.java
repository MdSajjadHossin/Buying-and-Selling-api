package com.springboot.bikroy.repository;

import com.springboot.bikroy.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {

}
