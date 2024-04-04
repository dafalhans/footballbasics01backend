package com.hans.backend.backend.appl.teams.service.dto;

import com.hans.backend.backend.appl.actors.service.dto.Player;
import com.hans.backend.backend.appl.actors.service.dto.Trainer;
import com.hans.backend.backend.base.base.service.dto.Base;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString(callSuper = true)
public class Team extends Base {

    private String teamName;
    private String location;
    private String stadiumName;
    private String teamLogoImageData;

    private Trainer trainer;

    private List<Player> players;
//    private List<PlayerForTeam> playerBasicList;

    private Map<Long, String> playerNames;
}