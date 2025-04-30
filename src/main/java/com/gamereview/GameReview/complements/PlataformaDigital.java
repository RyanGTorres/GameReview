package com.gamereview.GameReview.complements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PlataformaDigital {
    XBOX("XBOX"),
    PLAYSTATION("PLAYSTATION"),
    NINTENDO("NINTENDO"),
    PC("COMPUTADOR");

    private final String plataforma;

}
