package com.gamereview.GameReview.complements;

public enum PlataformaDigital {
    XBOX("Xbox"),
    PLAYSTATION("Playstation"),
    PC("Computador"),
    NITENDO("Nitendo");

    private final String displayName;

    PlataformaDigital(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
