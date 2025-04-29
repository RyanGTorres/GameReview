package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.GameIdeaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameIdeaRepository extends JpaRepository<GameIdeaModel, Long> {
}
