package br.com.siaraapps.mtgdb.controllers;

import br.com.siaraapps.mtgdb.dtos.CardToReturnDTO;
import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.dtos.CardToInsertDTO;
import br.com.siaraapps.mtgdb.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card")
public class CardController {

    // Injetando a dependência do service
    @Autowired
    private CardService cardService;

    //POST de um novo card via Body JSON
    @PostMapping
    public ResponseEntity<CardToReturnDTO> createNewCard(@RequestBody CardToInsertDTO inputCard) {

        //Convertendo DTO de cadastro em entidade
        Card cardToSave = new Card(inputCard);

        //Pedindo para salvar o card indicado
        Card cardSaved = cardService.insert(cardToSave);

        //Convertendo entidade em DTO de leitura
        CardToReturnDTO outputCard = new CardToReturnDTO(cardSaved);

        return ResponseEntity.ok(outputCard);

    }

}
