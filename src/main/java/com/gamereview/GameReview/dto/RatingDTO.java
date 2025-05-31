package com.gamereview.GameReview.dto;


import com.gamereview.GameReview.model.GameModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {

    private Long id;
    private GameModel game;
    private double note;
    private String comment;
    private Date releaseDate;
}
