package br.com.siaraapps.mtgdb.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record DeckToInsertDTO(
        @NotBlank
        String nome,
        String cores,
        String tipo,
        Set<Integer> setOfCardIDs
) {
}
