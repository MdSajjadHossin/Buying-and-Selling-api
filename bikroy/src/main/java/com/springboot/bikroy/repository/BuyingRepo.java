package com.springboot.bikroy.repository;

import com.springboot.bikroy.entity.BuyingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyingRepo extends JpaRepository<BuyingRequest, Long> {
}
