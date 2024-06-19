package br.com.siaraapps.mtgdb.services;

import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.models.Deck;
import br.com.siaraapps.mtgdb.repositories.CardRepo;
import br.com.siaraapps.mtgdb.repositories.DeckRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeckService {

    @Autowired
    private DeckRepo deckRepository;

    @Autowired
    private CardRepo cardRepository;

    //insert
    public Deck insert(Deck deck){

        //Sincroniza set de cards com repositório de dados
        Set<Card> cards = deck.getCards().stream()
            .map(c -> {
                Optional<Card> foundCard = cardRepository.findById(c.getId());
                return foundCard.orElseThrow(() ->
                    new EntityNotFoundException("Card de id = " + c.getId() + " não encontrado"));
            })
            .collect(Collectors.toSet());
        deck.setCards(cards);

        Deck deckSaved = deckRepository.save(deck);
        deckPrinting(deckSaved, "Salvo com sucesso");
        return deckSaved;
    }
    //get all
    public List<Deck> findAll(){
        List<Deck> listOfDecks = (List<Deck>) deckRepository.findAll();
        listPrinting(listOfDecks);
        return listOfDecks;
    }

    //get by id
    public Deck findById(Integer id){

        //Busca deck por ID
        Optional<Deck> foundDeck = deckRepository.findById(id);

        //Retorna deck se encontrado, senão, lança exceção
        if(foundDeck.isPresent()){
            deckPrinting(foundDeck.get(),"Recuperado com sucesso");
            return foundDeck.get();
        }
        else {
            throw new EntityNotFoundException("Deck = " + id + " não encontrado");
        }
    }

    //edit
    public Deck updateByID(Deck deckToUpdate){

        //Busca deck por ID
        Optional<Deck> foundDeck = deckRepository.findById(deckToUpdate.getId());

        //Atualiza deck se encontrado, senão, lança exceção
        if(foundDeck.isPresent()){
            Deck updatedDeck = deckRepository.save(deckToUpdate);
            deckPrinting(updatedDeck, "Atualizado com sucesso");
            return updatedDeck;
        }
        else{
            throw new EntityNotFoundException("Nenhum deck encontrado com id = " + deckToUpdate.getId());
        }
    }

    //delete
    public void deleteByID(Integer id) {

        //Busca deck por ID
        Optional<Deck> foundDeck = deckRepository.findById(id);

        //Remove deck se encontrado, senão, lança exceção
        if (foundDeck.isPresent()) {
            deckRepository.deleteById(id);
            deckPrinting(foundDeck.get(), "Removido com sucesso");
        } else {
            throw new EntityNotFoundException("Nenhum deck encontrado com id = " + id);
        }

    }

    private void deckPrinting(Deck deck, String message) {

        System.out.println("========== Registro: ==========");
        System.out.println(deck);
        System.out.println(message);
        System.out.println("===============================");

    }

    private void listPrinting(List<Deck> deckList) {

        System.out.println("======== Lista de Decks ========");
        deckList.forEach(System.out::println);
        System.out.println("===============================");

    }


}
