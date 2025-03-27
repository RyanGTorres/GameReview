package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
}
