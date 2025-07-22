package ru.mts.media.platform.umc.domain.event;

import org.mapstruct.Mapper;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.EventInput;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EventDomainServiceMapper {

    Event toDto(EventInput input);
}
