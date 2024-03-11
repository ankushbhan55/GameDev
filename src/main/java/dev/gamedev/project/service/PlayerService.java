package dev.gamedev.project.service;

import dev.gamedev.project.entity.Country;
import dev.gamedev.project.entity.GamesWithPlayer;
import dev.gamedev.project.model.PlayerMaxCredit;
import dev.gamedev.project.model.PlayerModel;
import dev.gamedev.project.repository.PlayerRepository;
import dev.gamedev.project.util.EntityToModelConverter;
import dev.gamedev.project.util.ModelToEntityConverter;
import dev.gamedev.project.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    GamesWithPlayerService gameswithplayerService;

    @Autowired
    EntityToModelConverter etmConverter;

    @Autowired
    ModelToEntityConverter modelToEntityConverter;

    @Autowired
    ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    public PlayerService() {
        modelMapper = new ModelMapper();
    }

    public List<PlayerModel> getAllPlayers() {
      return  playerRepo.findAll().stream().map(e-> modelMapper.map(e, PlayerModel.class)).collect(Collectors.toList());
    }

    public List<PlayerModel> findMatchMaking(String levelId, String gameId, String countryId) {
        List<GamesWithPlayer> gamesWithPlayers = gameswithplayerService.findMatchMaking(levelId, gameId, countryId);
        return  playerRepo.findByIdIn(gamesWithPlayers.stream().map(e-> e.getPlayer().getId()).collect(Collectors.toList())).stream().map(
                  e-> modelMapper.map(e, PlayerModel.class)).collect(Collectors.toList());

    }


    public void save(PlayerModel playerModel) {
       Country country = validationUtil.validateCountry(playerModel.getCountryName());
        playerRepo.save(modelToEntityConverter.convertPlayerModelToPlayer(playerModel, country));
    }

    public List<PlayerMaxCredit> getMaxCredit() {
        List<GamesWithPlayer> gamesWithPlayers = gameswithplayerService.findMaxCredit();
       return etmConverter.convertGamesWithPlayerToPlayerMaxCredit(gamesWithPlayers);
    }
}
