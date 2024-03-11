package dev.gamedev.project.controller;


import dev.gamedev.project.entity.GamesWithPlayer;
import dev.gamedev.project.exceptions.CountryNotFoundException;
import dev.gamedev.project.model.AddCredit;
import dev.gamedev.project.model.GamePlayerLevelLink;
import dev.gamedev.project.model.PlayerMaxCredit;
import dev.gamedev.project.model.PlayerModel;
import dev.gamedev.project.service.GamesWithPlayerService;
import dev.gamedev.project.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {


    @Autowired
    PlayerService playerService;

    @Autowired
    GamesWithPlayerService gameswithplayerService;
    @GetMapping
    public List<PlayerModel> getAllPlayers() {
        return playerService.getAllPlayers();
    }


    @GetMapping(path = "/matchmaking/{level}/{game}/{country}")
    public List<PlayerModel> getPlayersForMatchMaking(@PathVariable String level, @PathVariable String game, @PathVariable String country) {

        List<PlayerModel> playerList = playerService.findMatchMaking(level, game, country);
        return playerList;

    }

    @GetMapping(path = "/maxcredit")
    public List<PlayerMaxCredit> getPlayersWithMaxCredit() {
        List<PlayerMaxCredit> playerMaxCreditList = new ArrayList<>();
        playerMaxCreditList =  playerService.getMaxCredit();
        return playerMaxCreditList;
    }

    @PostMapping
    public ResponseEntity createPlayer(@RequestBody PlayerModel playerModel) {
        try {
            playerService.save(playerModel);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
        catch (CountryNotFoundException ex) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Country not found");
        }
    }

    @PostMapping(path="/addcredit")
    public ResponseEntity addCredits(@RequestBody AddCredit addCredit) {

        GamesWithPlayer playerwithGame = gameswithplayerService.findByPlayerAndGame(Long.parseLong(addCredit.getPlayerId()),
               addCredit.getGameName());
        if(playerwithGame == null) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player does not play the game");
        }
        else {
            playerwithGame.setCredits(Integer.parseInt(addCredit.getCredit()));
            gameswithplayerService.save(playerwithGame);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
    }

    @PostMapping(path="/linkgameswithplayers")
    public ResponseEntity linkGamesWithPlayers(@RequestBody GamePlayerLevelLink gll) {

        try {
            gameswithplayerService.linkGamesWithPlayers(gll);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
}
