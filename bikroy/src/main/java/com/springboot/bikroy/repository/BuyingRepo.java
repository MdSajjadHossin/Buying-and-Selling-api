package com.springboot.bikroy.repository;

import com.springboot.bikroy.entity.BuyingRequest;
import org.hibernate.dialect.function.LocatePositionEmulation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyingRepo extends JpaRepository<BuyingRequest, Long> {

    List<BuyingRequest> findAllBySellerId(Long sellerId);

    List<BuyingRequest> findAllByUserId(Long userId);

}
