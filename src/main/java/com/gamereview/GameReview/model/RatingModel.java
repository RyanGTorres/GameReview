package com.gamereview.GameReview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getRealeseDate() {
        return realeseDate;
    }

    public void setRealeseDate(Date realeseDate) {
        this.realeseDate = realeseDate;
    }
}
