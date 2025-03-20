package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingModel,Long> {
}
