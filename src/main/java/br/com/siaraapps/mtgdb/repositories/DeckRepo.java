package br.com.siaraapps.mtgdb.repositories;

import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.models.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepo extends CrudRepository<Deck, Integer> {

    List<Card> findByNameLike(String name);

}
