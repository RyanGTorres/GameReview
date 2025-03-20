package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel, Long> {
}
