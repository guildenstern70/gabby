package net.littlelite.gabby.utils;

public enum PhrasePart {
    NOUN,
    ADJECTIVE,
    VERB;

    public String getToken()
    {
        return switch (this) {
            case NOUN -> "=noun=";
            case ADJECTIVE -> "=adjective=";
            case VERB -> "=verb=";
            default -> throw new RuntimeException("Unknown word type");
        };
    }
}
