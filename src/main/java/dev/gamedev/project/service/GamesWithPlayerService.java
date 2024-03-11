package dev.gamedev.project.service;


import dev.gamedev.project.entity.Game;
import dev.gamedev.project.entity.GamesWithPlayer;
import dev.gamedev.project.entity.Level;
import dev.gamedev.project.entity.Player;
import dev.gamedev.project.model.GamePlayerLevelLink;
import dev.gamedev.project.repository.GamesWithPlayerRepository;
import dev.gamedev.project.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesWithPlayerService {


    @Autowired
    GamesWithPlayerRepository gameswithplayerRepo;

    @Autowired
    ValidationUtil validationUtil;


    public List<GamesWithPlayer> findMaxCredit() {
       return gameswithplayerRepo.findMaxCredit();
    }

    public GamesWithPlayer findByPlayerAndGame(long playerId, String gameName) {
        return gameswithplayerRepo.findByPlayer_IdAndGame_Name(playerId, gameName).orElse(null);
    }

    public void save(GamesWithPlayer playerwithGame) {
         gameswithplayerRepo.save(playerwithGame);

    }

    public List<GamesWithPlayer> findMatchMaking(String level, String game, String country) {
     return   gameswithplayerRepo.findByLevel_NameAndGame_NameAndPlayer_Country_CountryName(level, game, country);

    }

    public void linkGamesWithPlayers(GamePlayerLevelLink gll) {
        Game game = validationUtil.validateGame(gll.getGameName());
        Player player = validationUtil.validatePlayer(gll.getPlayerEmail());
        Level level = validationUtil.validateLevel(gll.getLevel());

        gameswithplayerRepo.save(new GamesWithPlayer(game, player, level));

    }
}
