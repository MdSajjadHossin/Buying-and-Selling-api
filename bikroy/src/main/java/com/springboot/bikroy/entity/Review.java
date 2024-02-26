package com.springboot.bikroy.entity;

import com.springboot.bikroy.dto.ReviewDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.PreparedStatement;
import java.util.Date;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String review;

    private Long rating;

    private Date reviewDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ad_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Advertisement ad;

    public ReviewDto getReviewDto(){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(id);
        reviewDto.setReview(review);
        reviewDto.setRating(rating);
        reviewDto.setReviewDate(reviewDate);
        reviewDto.setUserId(user.getId());
        reviewDto.setBuyerName(user.getName());
        reviewDto.setAdId(ad.getId());
        reviewDto.setProductName(ad.getProductName());

        return reviewDto;
    }


}
