package br.com.siaraapps.mtgdb.services;

import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.repositories.CardRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Método responsável por consultar todos os cards
    public List<Card> findAll() {

        //Recupera lista de cards do repositório de dados
        List<Card> cardList = (List<Card>) cardRepository.findAll();

        //Imprime lista de cards em console
        cardList.forEach(System.out::println);

        return cardList;

    }

    //Método de consulta por ID
    public Card findByID(Integer id) {

        //Busca card por ID
        Optional<Card> card = cardRepository.findById(id);

        //Retorna card se ID encontrado, senão, lança exceção
        if (card.isPresent()) {
            System.out.println("========== Registro: ==========");
            System.out.println(card);
            System.out.println("Recuperado com sucesso");
            System.out.println("===============================");
            return card.get();
        } else {
            throw new EntityNotFoundException("Card com id = " + id + " não encontrado");
        }

    }
}
