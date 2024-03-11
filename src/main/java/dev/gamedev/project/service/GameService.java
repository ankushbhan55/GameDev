package dev.gamedev.project.service;


import dev.gamedev.project.entity.Game;
import dev.gamedev.project.exceptions.GameNotFoundException;
import dev.gamedev.project.model.GameModel;
import dev.gamedev.project.repository.GameRepository;
import dev.gamedev.project.util.ModelToEntityConverter;
import dev.gamedev.project.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private ModelMapper modelMapper;

    @Autowired
    GameRepository gameRepo;

    @Autowired
    ValidationUtil validationUtil;

    @Autowired
    ModelToEntityConverter modelToEntityConverter;

    public GameService() {
        modelMapper = new ModelMapper();
    }


    public List<Game> findAll() {
        return gameRepo.findAll();
    }

    public void save(GameModel game) {
        try {
            Game gameDb = validationUtil.validateGame(game.getName());
            modelToEntityConverter.convertGameModelToGameEntity(game, gameDb);
        } catch (GameNotFoundException gx) {
            gameRepo.save(modelMapper.map(game, Game.class));
        }
    }
}
