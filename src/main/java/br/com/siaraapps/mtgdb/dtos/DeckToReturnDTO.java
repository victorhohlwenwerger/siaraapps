package br.com.siaraapps.mtgdb.dtos;

import br.com.siaraapps.mtgdb.models.Deck;

import java.util.Set;
import java.util.stream.Collectors;

public record DeckToReturnDTO(
        String nome,
        String cores,
        String tipo,
        Integer quantidade,
        Set<CardToReturnDTO> setOfCards
) {
    public DeckToReturnDTO(Deck deck) {

        this(
            deck.getNome(),
            deck.getCores(),
            deck.getTipo(),
            deck.getQuantidade(),
            deck.getCards().stream().map(CardToReturnDTO::new).collect(Collectors.toSet())
        );

    }
}
