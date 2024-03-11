package dev.gamedev.project.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gameswithplayer")
public class GamesWithPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="game_id")
    private Game  game;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;


    @ManyToOne
    @JoinColumn(name="level_id")
    private Level level;

    private int credits;

    public GamesWithPlayer(Game game, Player player, Level level) {
        this.game = game;
        this.player = player;
        this.level = level;
    }
}
