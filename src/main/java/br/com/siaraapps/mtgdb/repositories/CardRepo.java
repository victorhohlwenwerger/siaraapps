package br.com.siaraapps.mtgdb.repositories;

import br.com.siaraapps.mtgdb.models.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepo extends CrudRepository<Card, Integer> {

    List<Card> findByNameLike(String name);

}
