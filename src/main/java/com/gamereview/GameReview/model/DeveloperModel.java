package com.gamereview.GameReview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "tb_developer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DeveloperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "country")
    private String country;

    @Column(name = "foundation_year") // Nome mais descritivo
    private int foundationYear; // Tipo alterado para int
}
