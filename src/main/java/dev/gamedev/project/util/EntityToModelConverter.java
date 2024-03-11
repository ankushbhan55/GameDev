package dev.gamedev.project.util;


import dev.gamedev.project.entity.GamesWithPlayer;
import dev.gamedev.project.model.PlayerMaxCredit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToModelConverter {

    public List<PlayerMaxCredit> convertGamesWithPlayerToPlayerMaxCredit(List<GamesWithPlayer> gamesWithPlayerList) {
     return  gamesWithPlayerList.stream().map(e -> new PlayerMaxCredit(e.getPlayer().getName(), e.getGame().getName(), ""+e.getCredits())).collect(Collectors.toList());
    }
}
