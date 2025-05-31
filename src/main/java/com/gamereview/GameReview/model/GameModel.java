package com.gamereview.GameReview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_game_review")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "img_url")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "developer_id") // Nome da coluna que referencia a desenvolvedora
    private DeveloperModel developer; // Relacionamento com a desenvolvedora

    @Column (name = "gender")
    private String gender;

    @Column(name = "platform")
    private String platform;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "indicative_rating")
    private String indicativeRating;

    @OneToMany(mappedBy = "game") // Relacionamento com as avaliações
    private List<RatingModel> ratings;

}
