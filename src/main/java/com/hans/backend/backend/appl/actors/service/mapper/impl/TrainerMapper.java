package com.hans.backend.backend.appl.actors.service.mapper.impl;

import com.hans.backend.backend.base.base.service.mapper.IMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
//import com.hans.backend.backend.appl.actors.service.mapper.IMapper;
import com.hans.backend.backend.appl.actors.business.TrainerEntity;
import com.hans.backend.backend.appl.actors.service.dto.Trainer;

@Mapper(componentModel = "spring")
public interface TrainerMapper extends IMapper<TrainerEntity, Trainer> {

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
//    @Mapping(source = "birthDate", target = "birthDate", dateFormat = "d/MM/yyyy")
    @Override
    TrainerEntity toEntity(Trainer dto);

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Override
    Trainer toDTO(TrainerEntity entity);

}