package com.gamereview.GameReview.complements;


public enum PlataformaDigital {
    XBOX("XBOX"),
    PLAYSTATION("PLAYSTATION"),
    NINTENDO("NINTENDO"),
    PC("COMPUTADOR");

    private final String plataforma;

    PlataformaDigital(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }
}
