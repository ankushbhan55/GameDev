package dev.gamedev.project.repository;


import dev.gamedev.project.entity.GamesWithPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GamesWithPlayerRepository extends JpaRepository<GamesWithPlayer, Long> {

    @Query(value = "SELECT t1.* " +
            "FROM gameswithplayer  t1 " +
            "INNER JOIN ( " +
            "    SELECT game_id, level_id, MAX(credits) AS max_credits " +
            "    FROM gameswithplayer " +
            "    GROUP BY game_id, level_id " +
            ") t2 ON t1.game_id = t2.game_id AND t1.level_id = t2.level_id AND t1.credits = t2.max_credits",
            nativeQuery = true)
    List<GamesWithPlayer> findMaxCredit();

    List<GamesWithPlayer> findByLevel_NameAndGame_NameAndPlayer_Country_CountryName(String level, String game, String country);
    Optional<GamesWithPlayer> findByPlayer_EmailAndGame_Name(String playerEmail, String gameName);

}
