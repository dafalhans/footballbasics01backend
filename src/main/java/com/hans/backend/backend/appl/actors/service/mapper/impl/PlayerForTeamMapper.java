package com.hans.backend.backend.appl.actors.service.mapper.impl;

import com.hans.backend.backend.appl.actors.business.PlayerEntity;
import com.hans.backend.backend.appl.actors.service.dto.Player;
import com.hans.backend.backend.appl.utils.mappers.ImageMapper;
import com.hans.backend.backend.base.base.service.mapper.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerForTeamMapper extends IMapper<PlayerEntity, Player> {

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
//    @Mapping(source = "birthDate", target = "birthDate", dateFormat = "yyyy-MM-dd")
//    @Mapping(target = "id", ignore = true)
    @Mapping(source = "playerImageData", target = "playerImageData", ignore = true)
    @Override
    PlayerEntity toEntity(Player dto);

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
//    @Mapping(source = "birthDate", target = "birthDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "playerImageData", target = "playerImageData", ignore = true)
    @Override
    Player toDTO(PlayerEntity entity);

}