package br.com.siaraapps.mtgdb.dtos;

import br.com.siaraapps.mtgdb.models.Card;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Set;

public record DeckoInsertDTO(
        @NotBlank
        String nome,
        String cores,
        String tipo,
        Integer quantidade,
        Set<Card> cards
) {
}
