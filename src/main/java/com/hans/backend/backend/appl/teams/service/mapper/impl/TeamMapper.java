package com.hans.backend.backend.appl.teams.service.mapper.impl;

import com.hans.backend.backend.base.base.service.mapper.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
//import com.hans.backend.backend.appl.teams.service.mapper.IMapper;
import com.hans.backend.backend.appl.teams.business.TeamEntity;
import com.hans.backend.backend.appl.teams.service.dto.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper extends IMapper<TeamEntity, Team> {

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Override
    TeamEntity toEntity(Team dto);

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Override
    Team toDTO(TeamEntity entity);

}