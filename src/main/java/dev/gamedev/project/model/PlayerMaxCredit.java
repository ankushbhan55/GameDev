package dev.gamedev.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PlayerMaxCredit {

    private String playerName;

    private String gameName;

    private String maxCredits;
}
