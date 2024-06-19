package br.com.siaraapps.mtgdb.controllers;

import br.com.siaraapps.mtgdb.dtos.DeckToReturnDTO;
import br.com.siaraapps.mtgdb.dtos.DeckToInsertDTO;
import br.com.siaraapps.mtgdb.models.Deck;
import br.com.siaraapps.mtgdb.services.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("deck")
public class DeckController {

    // Injetando a dependência do service
    @Autowired
    private DeckService deckService;

    //POST de um novo deck via Body JSON
    @PostMapping
    public ResponseEntity<DeckToReturnDTO> createNewDeck(@RequestBody DeckToInsertDTO inputDeck) {

        //Convertendo DTO de cadastro em entidade
        Deck deckToSave = new Deck(inputDeck);

        //Pedindo para salvar o deck indicado
        Deck deckSaved = deckService.insert(deckToSave);

        //Convertendo entidade em DTO de leitura
        DeckToReturnDTO outputDeck = new DeckToReturnDTO(deckSaved);

        return ResponseEntity.ok(outputDeck);

    }

    //GET de todos os cards em JSON


    //GET para consulta de card por ID



    //GET para consulta de card por nome


    //PUT para update de card por ID


}
