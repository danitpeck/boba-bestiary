package dev.dani.bobabestiary.dto;

public record DrinkSummaryResponse(
    String drinkId,
    String name,
    String species,
    String baseFlavor,
    boolean summonAgain,
    int rating,
    int calorieEstimate
) {
}
