package ru.mts.media.platform.umc.dao.postgres.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.mts.media.platform.umc.domain.event.EventSave;
import ru.mts.media.platform.umc.domain.event.EventSot;

@Component
@RequiredArgsConstructor
public class EventPgDao implements EventSot {

    private final EventPgRepository repository;
    private final EventPgMapper mapper;


    @EventListener
    public void handleEventCreatedEvent(EventSave evt) {
        evt.unwrap()
                .map(mapper::toEntity)
                .ifPresent(repository::save);
    }
}
