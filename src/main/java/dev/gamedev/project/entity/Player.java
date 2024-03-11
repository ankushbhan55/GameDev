package dev.gamedev.project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;


    @Email
    @Column(unique=true)
    private String email;

    private String age;



    @JsonIgnore
    @OneToMany(mappedBy = "player",fetch = FetchType.LAZY)
    private List<GamesWithPlayer> gamesWithPlayers;



    private String gender;

    private String gamerTag;

    private String name;




}
