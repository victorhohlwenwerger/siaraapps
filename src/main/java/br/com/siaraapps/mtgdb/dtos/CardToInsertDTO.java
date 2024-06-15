package br.com.siaraapps.mtgdb.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CardToInsertDTO(
        @NotBlank
        String name,
        String colors,
        Integer manaCost,
        String type,
        Character rarity,
        Integer power,
        Integer toughness,
        String printing,
        Boolean foil,
        Integer quantity,
        BigDecimal expectedValue
) {
}
