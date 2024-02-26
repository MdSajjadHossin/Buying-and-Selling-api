package com.springboot.bikroy.repository;

import com.springboot.bikroy.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findAllById(Long adId);
}
