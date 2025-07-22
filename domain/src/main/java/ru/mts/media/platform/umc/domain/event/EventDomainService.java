package ru.mts.media.platform.umc.domain.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.EventInput;

@Service
@RequiredArgsConstructor
public class EventDomainService {

    private final ApplicationEventPublisher eventPublisher;
    private final EventDomainServiceMapper mapper;

    public Event save(EventInput input) {
        eventPublisher.publishEvent(mapper.toDto(input));
        return mapper.toDto(input);
    }
}
