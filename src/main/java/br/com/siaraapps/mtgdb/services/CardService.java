package br.com.siaraapps.mtgdb.services;

import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.repositories.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //Método respnsável por consultar todos os cards
    public List<Card> findAll() {

        //Recupera lista de cards do repositório de dados
        List<Card> cardList = (List<Card>) cardRepository.findAll();

        //Imprime lista de cards em console
        cardList.forEach(System.out::println);

        return cardList;

    }

}
