package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperModel,Long> {
}
