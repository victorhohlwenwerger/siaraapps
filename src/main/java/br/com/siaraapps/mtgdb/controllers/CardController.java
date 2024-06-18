package br.com.siaraapps.mtgdb.controllers;

import br.com.siaraapps.mtgdb.dtos.CardToReturnDTO;
import br.com.siaraapps.mtgdb.dtos.CardToUpdateDTO;
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
    @GetMapping("/findByID")
    public ResponseEntity<CardToReturnDTO> cardByID(@RequestParam Integer id) {

        //Recuperando card por ID
        Card card = cardService.findByID(id);

        //Covertendo entidade para DTO de retorno
        CardToReturnDTO cardToReturn = new CardToReturnDTO(card);

        return ResponseEntity.ok(cardToReturn);

    }

    //GET para consulta de card por nome
    @GetMapping("/findByName")
    public ResponseEntity<List<CardToReturnDTO>> cardByID(@RequestParam String name) {

        //Recuperando card por ID
        List<Card> cards = cardService.findByName(name);

        //Covertendo entidade para DTO de retorno
        List<CardToReturnDTO> cardsToReturn = cards.stream().map(CardToReturnDTO::new).toList();

        return ResponseEntity.ok(cardsToReturn);

    }

    //PUT para update de card por ID
    @PutMapping("/updateByID")
    public ResponseEntity<CardToReturnDTO> updateByID(@RequestBody CardToUpdateDTO inputCard) {

        //Convertendo DTO de cadastro em entidade
        Card cardToUpdate = new Card(inputCard);

        //Atualiza card no repositório de dados
        Card cardUpdated = cardService.updateByID(cardToUpdate);

        //Covertendo entidade para DTO de retorno
        CardToReturnDTO cardToReturn = new CardToReturnDTO(cardUpdated);

        return ResponseEntity.ok(cardToReturn);

    }

}
