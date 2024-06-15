package br.com.siaraapps.mtgdb.services;

import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.repositories.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepo cardRepository;

    public Card insert(Card card) {

        Card cardSaved = cardRepository.save(card);
        System.out.println("========== Registro: ==========");
        System.out.println(cardSaved);
        System.out.println("Salvo com sucesso");
        System.out.println("===============================");

        return cardSaved;

    }
}
