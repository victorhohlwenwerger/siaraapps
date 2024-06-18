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
        cardPrinting(cardSaved, "Salvo com sucesso");

        return cardSaved;

    }

    //Método responsável por consultar todos os cards
    public List<Card> findAll() {

        //Recupera lista de cards do repositório de dados
        List<Card> cardList = (List<Card>) cardRepository.findAll();

        //Imprime lista de cards em console
        listPrinting(cardList);

        return cardList;

    }

    //Método de consulta por ID
    public Card findByID(Integer id) {

        //Busca card por ID
        Optional<Card> card = cardRepository.findById(id);

        //Retorna card se ID encontrado, senão, lança exceção
        if (card.isPresent()) {
            cardPrinting(card.get(), "Recuperado com sucesso");
            return card.get();
        } else {
            throw new EntityNotFoundException("Card com id = " + id + " não encontrado");
        }

    }

    //Método de consulta por nome
    public List<Card> findByName(String name) {

        //Busca cards por nome
        List<Card> cards = cardRepository.findByNameLike("%" + name + "%");

        //Retorna lista de cards encontrados, senão, lança exceção
        if (!cards.isEmpty()) {
            listPrinting(cards);
            return cards;
        } else {
            throw new EntityNotFoundException("Nenhum card encontrado contendo nome = " + name);
        }

    }

    //Método de atualização de card por ID
    public Card updateByID(Card cardToUpdate) {

        //Busca card por ID
        Optional<Card> findedCard = cardRepository.findById(cardToUpdate.getId());

        //Retorna card atualizado se encontrado, senão, lança exceção
        if (findedCard.isPresent()) {
            Card cardUpdated = cardRepository.save(cardToUpdate);
            cardPrinting(cardUpdated, "Atualizado com sucesso");
            return cardUpdated;
        } else {
            throw new EntityNotFoundException("Nenhum card encontrado com id = " + cardToUpdate.getId());
        }

    }

    private void cardPrinting(Card card, String message) {

        System.out.println("========== Registro: ==========");
        System.out.println(card);
        System.out.println(message);
        System.out.println("===============================");

    }

    private void listPrinting(List<Card> cardList) {

        System.out.println("======== Lista de Cards ========");
        cardList.forEach(System.out::println);
        System.out.println("===============================");

    }

}
