package com.gamereview.GameReview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_rating")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RatingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "game_id")
    private GameModel game;

    @Column(name = "note")
    private double note;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date_realese")
    private Date realeseDate;
}
