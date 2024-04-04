package com.hans.backend.backend.appl.teams.service.mapper.impl;

import com.hans.backend.backend.appl.actors.business.PlayerEntity;
import com.hans.backend.backend.appl.actors.service.mapper.impl.PlayerForTeamMapper;
import com.hans.backend.backend.appl.actors.service.mapper.impl.PlayerMapper;
import com.hans.backend.backend.appl.actors.service.mapper.impl.TrainerMapper;
import com.hans.backend.backend.appl.utils.mappers.ImageMapper;
import com.hans.backend.backend.base.base.service.mapper.IMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
//import com.hans.backend.backend.appl.teams.service.mapper.IMapper;
import com.hans.backend.backend.appl.teams.business.TeamEntity;
import com.hans.backend.backend.appl.teams.service.dto.Team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", uses = {ImageMapper.class, PlayerForTeamMapper.class, TrainerMapper.class})
public interface TeamMapper extends IMapper<TeamEntity, Team> {

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Mapping(source = "teamLogoImageData", target = "teamLogoImageData", qualifiedByName = "mapStringToImageBytes")
    @Override
    TeamEntity toEntity(Team dto);

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Mapping(source = "teamLogoImageData", target = "teamLogoImageData", qualifiedByName = "mapImageBytesToString")
    @Mapping(source = "players", target = "playerNames")
    @Override
    Team toDTO(TeamEntity entity);


    default Map<Long, String> mapPlayersToPlayerNames(List<PlayerEntity> players) {
        Map<Long, String> playerNames = new HashMap<>();
        if (players != null){
            for (PlayerEntity player : players) {
                String fullName = player.getFirstName() + " " + player.getLastName();
                playerNames.put(player.getId(), fullName);
            }
        }

        return playerNames;
    }


}