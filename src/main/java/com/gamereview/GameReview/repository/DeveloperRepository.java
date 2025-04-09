package com.gamereview.GameReview.repository;

import com.gamereview.GameReview.model.DeveloperModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(exported = false)
public interface DeveloperRepository extends JpaRepository<DeveloperModel,Long> {
}
