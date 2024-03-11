package dev.gamedev.project.controller;


import dev.gamedev.project.model.GameModel;
import dev.gamedev.project.service.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    GameService gameService;
   private ModelMapper  modelMapper;
    public GameController() {
        modelMapper  = new ModelMapper();
    }

    @GetMapping
    public List<GameModel> getAllGames() {
        return gameService.findAll().stream().map(e -> modelMapper.map(e, GameModel.class)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity createGame(@RequestBody GameModel game) {
        try {
            gameService.save(game);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an issue in the request");
        }
    }


}
