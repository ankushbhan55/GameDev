package dev.gamedev.project.util;

import dev.gamedev.project.entity.Country;
import dev.gamedev.project.entity.Game;
import dev.gamedev.project.entity.Player;
import dev.gamedev.project.model.GameModel;
import dev.gamedev.project.model.PlayerModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ModelToEntityConverter {

    private ModelMapper modelMapper;

    public ModelToEntityConverter() {
        modelMapper = new ModelMapper();
    }


    public Game convertGameModelToGameEntity(GameModel gm, Game gameDb) {
        gameDb.setCode(gm.getCode());
        gameDb.setName(gm.getName());
        gameDb.setType(gm.getType());
        gameDb.setReleaseYear(gm.getReleaseYear());

        return gameDb;
    }

    public Player convertPlayerModelToPlayer(PlayerModel playerMode, Country country) {
        Player playerDb = modelMapper.map(playerMode, Player.class);
        playerDb.setCountry(country);
        return playerDb;
    }
}
