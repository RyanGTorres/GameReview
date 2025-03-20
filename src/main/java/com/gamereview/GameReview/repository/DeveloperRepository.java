package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<DeveloperModel,Long> {
}
