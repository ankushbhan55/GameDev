package dev.gamedev.project.repository;


import dev.gamedev.project.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByIdIn(List<Long> collect);

    Player findPlayerByEmail(String email);

}
