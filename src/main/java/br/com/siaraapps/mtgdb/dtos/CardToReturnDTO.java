package br.com.siaraapps.mtgdb.dtos;

import br.com.siaraapps.mtgdb.models.Card;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CardToReturnDTO(
        @NotNull
        Integer id,
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

        public CardToReturnDTO(Card card) {
                this(
                        card.getId(),
                        card.getName(),
                        card.getColors(),
                        card.getManaCost(),
                        card.getType(),
                        card.getRarity(),
                        card.getPower(),
                        card.getToughness(),
                        card.getPrinting(),
                        card.isFoil(),
                        card.getQuantity(),
                        card.getExpectedValue()
                );
        }

}
