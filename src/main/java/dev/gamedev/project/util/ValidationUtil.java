package dev.gamedev.project.util;


import dev.gamedev.project.entity.Country;
import dev.gamedev.project.entity.Game;
import dev.gamedev.project.entity.Level;
import dev.gamedev.project.entity.Player;
import dev.gamedev.project.exceptions.CountryNotFoundException;
import dev.gamedev.project.exceptions.GameNotFoundException;
import dev.gamedev.project.exceptions.LevelNotFoundException;
import dev.gamedev.project.exceptions.PlayerNotFoundException;
import dev.gamedev.project.repository.CountryRepository;
import dev.gamedev.project.repository.GameRepository;
import dev.gamedev.project.repository.LevelRepository;
import dev.gamedev.project.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    @Autowired
    GameRepository gameRepo;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    LevelRepository levelRepository;


    public Game validateGame(String gameName) {
        Game gameDb =  gameRepo.findGameByName(gameName);
        if (gameDb == null) {
            throw new GameNotFoundException(gameName +" does not exist in database");

        } else return gameDb;
    }


    public Country validateCountry(String country) {
       Country countryDb =  countryRepository.findCountryByCountryName(country);
       if (countryDb == null) {
           throw new CountryNotFoundException(country +" does not exist in database");

       } else return countryDb;
    }

    public Player validatePlayer(String email) {
        Player playerDb =  playerRepository.findPlayerByEmail(email);
        if (playerDb == null) {
            throw new PlayerNotFoundException(email +" does not exist in database");

        } else return playerDb;
    }

    public Level validateLevel(String levelName) {
        Level levelDb =  levelRepository.findLevelByName(levelName);
        if (levelDb == null) {
            throw new LevelNotFoundException(levelName +" does not exist in database");

        } else return levelDb;
    }
}
