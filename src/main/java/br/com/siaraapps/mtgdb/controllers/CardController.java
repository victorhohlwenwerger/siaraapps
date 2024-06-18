package br.com.siaraapps.mtgdb.controllers;

import br.com.siaraapps.mtgdb.dtos.CardToReturnDTO;
import br.com.siaraapps.mtgdb.models.Card;
import br.com.siaraapps.mtgdb.dtos.CardToInsertDTO;
import br.com.siaraapps.mtgdb.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //GET de todos os cards em JSON
    @GetMapping("/all")
    public ResponseEntity<List<CardToReturnDTO>> listAll() {

        //Recuperando lista de cards da base de dados
        List<Card> cardList = cardService.findAll();

        //Convertendo DE List<Card> PARA List<CardToReturnDTO>
        List<CardToReturnDTO> dtoList = cardList.stream().map(CardToReturnDTO::new).toList();

        return ResponseEntity.ok(dtoList);

    }

    //GET para consulta de card por ID
    @GetMapping("/{id}")
    public ResponseEntity<CardToReturnDTO> cardByID(@PathVariable Integer id) {

        //Recuperando card por ID
        Card card = cardService.findByID(id);

        //Covertendo entidade para DTO de retorno
        CardToReturnDTO cardToReturn = new CardToReturnDTO(card);

        return ResponseEntity.ok(cardToReturn);

    }



}
