package com.gamereview.GameReview.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDTO {

    private Long id;
    private String name;
    private String country;
    private int foundationYear;

}
