package ru.mts.media.platform.umc.dao.postgres.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mts.media.platform.umc.dao.postgres.venue.VenuePgMapper;
import ru.mts.media.platform.umc.domain.gql.types.Event;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {VenuePgMapper.class})
public interface EventPgMapper {

    EventPgEntity toEntity(Event event);

    @Mapping(target = "venues", source = "venues")
    Event toModel(EventPgEntity entity);
}
