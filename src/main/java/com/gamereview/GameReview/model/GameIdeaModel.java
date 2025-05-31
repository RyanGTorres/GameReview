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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public PlataformaDigital getPlataformaDigital() {
        return plataformaDigital;
    }

    public void setPlataformaDigital(PlataformaDigital plataformaDigital) {
        this.plataformaDigital = plataformaDigital;
    }
}
