package com.gamereview.GameReview.model;

import com.gamereview.GameReview.complements.PlataformaDigital;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game_idea")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameIdeaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlataformaDigital plataformaDigital;

    public void addAttribute(String gameIdeaModel, GameIdeaModel gameIdeaModel1) {
    }
}
