package com.gamereview.GameReview.dto;

import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.model.RatingModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String name;
    private String imgUrl;
    private DeveloperModel developer;
    private String gender;
    private String platform;
    private Date realeseDate;
    private String indicativeRating;
    private List<RatingModel> ratings;
}
